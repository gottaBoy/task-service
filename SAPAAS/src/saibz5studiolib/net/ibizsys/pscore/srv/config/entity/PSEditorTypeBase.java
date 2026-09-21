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
package net.ibizsys.pscore.srv.config.entity;

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

public abstract class PSEditorTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSEditorTypeBase.class);
    public static final String FIELD_AJAXHANDLER = "AJAXHANDLER";
    public static final String FIELD_CONVERTCITEXT = "CONVERTCITEXT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CTRLOBJ = "CTRLOBJ";
    public static final String FIELD_DOTNETFORMAT = "DOTNETFORMAT";
    public static final String FIELD_EDITABLE = "EDITABLE";
    public static final String FIELD_EDITORCODE = "EDITORCODE";
    public static final String FIELD_EDITORPARAM = "EDITORPARAM";
    public static final String FIELD_FIEDITOR = "FIEDITOR";
    public static final String FIELD_GCEDITOR = "GCEDITOR";
    public static final String FIELD_HEIGHT = "HEIGHT";
    public static final String FIELD_ICONPATH = "ICONPATH";
    public static final String FIELD_JAVAFORMAT = "JAVAFORMAT";
    public static final String FIELD_LINKVIEWSHOWMODE = "LINKVIEWSHOWMODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MOBFIEDITOR = "MOBFIEDITOR";
    public static final String FIELD_NEEDCODELISTCONFIG = "NEEDCODELISTCONFIG";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSEDITORTYPEID = "PSEDITORTYPEID";
    public static final String FIELD_PSEDITORTYPENAME = "PSEDITORTYPENAME";
    public static final String FIELD_REFVIEWSHOWMODE = "REFVIEWSHOWMODE";
    public static final String FIELD_SBEDITOR = "SBEDITOR";
    public static final String FIELD_STANDARDEDITOR = "STANDARDEDITOR";
    public static final String FIELD_STANDARDTYPE = "STANDARDTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VALUEPROCESSOR = "VALUEPROCESSOR";
    public static final String FIELD_WIDTH = "WIDTH";
    private static final int INDEX_AJAXHANDLER = 0;
    private static final int INDEX_CONVERTCITEXT = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_CTRLOBJ = 4;
    private static final int INDEX_DOTNETFORMAT = 5;
    private static final int INDEX_EDITABLE = 6;
    private static final int INDEX_EDITORCODE = 7;
    private static final int INDEX_EDITORPARAM = 8;
    private static final int INDEX_FIEDITOR = 9;
    private static final int INDEX_GCEDITOR = 10;
    private static final int INDEX_HEIGHT = 11;
    private static final int INDEX_ICONPATH = 12;
    private static final int INDEX_JAVAFORMAT = 13;
    private static final int INDEX_LINKVIEWSHOWMODE = 14;
    private static final int INDEX_MEMO = 15;
    private static final int INDEX_MOBFIEDITOR = 16;
    private static final int INDEX_NEEDCODELISTCONFIG = 17;
    private static final int INDEX_ORDERVALUE = 18;
    private static final int INDEX_PSEDITORTYPEID = 19;
    private static final int INDEX_PSEDITORTYPENAME = 20;
    private static final int INDEX_REFVIEWSHOWMODE = 21;
    private static final int INDEX_SBEDITOR = 22;
    private static final int INDEX_STANDARDEDITOR = 23;
    private static final int INDEX_STANDARDTYPE = 24;
    private static final int INDEX_UPDATEDATE = 25;
    private static final int INDEX_UPDATEMAN = 26;
    private static final int INDEX_VALIDFLAG = 27;
    private static final int INDEX_VALUEPROCESSOR = 28;
    private static final int INDEX_WIDTH = 29;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSEditorTypeBase proxyPSEditorTypeBase = null;
    private boolean ajaxhandlerDirtyFlag = false;
    private boolean convertcitextDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ctrlobjDirtyFlag = false;
    private boolean dotnetformatDirtyFlag = false;
    private boolean editableDirtyFlag = false;
    private boolean editorcodeDirtyFlag = false;
    private boolean editorparamDirtyFlag = false;
    private boolean fieditorDirtyFlag = false;
    private boolean gceditorDirtyFlag = false;
    private boolean heightDirtyFlag = false;
    private boolean iconpathDirtyFlag = false;
    private boolean javaformatDirtyFlag = false;
    private boolean linkviewshowmodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mobfieditorDirtyFlag = false;
    private boolean needcodelistconfigDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pseditortypeidDirtyFlag = false;
    private boolean pseditortypenameDirtyFlag = false;
    private boolean refviewshowmodeDirtyFlag = false;
    private boolean sbeditorDirtyFlag = false;
    private boolean standardeditorDirtyFlag = false;
    private boolean standardtypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean valueprocessorDirtyFlag = false;
    private boolean widthDirtyFlag = false;
    @Column(name="ajaxhandler")
    private String ajaxhandler;
    @Column(name="convertcitext")
    private Integer convertcitext;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="ctrlobj")
    private String ctrlobj;
    @Column(name="dotnetformat")
    private String dotnetformat;
    @Column(name="editable")
    private Integer editable;
    @Column(name="editorcode")
    private String editorcode;
    @Column(name="editorparam")
    private String editorparam;
    @Column(name="fieditor")
    private Integer fieditor;
    @Column(name="gceditor")
    private Integer gceditor;
    @Column(name="height")
    private Integer height;
    @Column(name="iconpath")
    private String iconpath;
    @Column(name="javaformat")
    private String javaformat;
    @Column(name="linkviewshowmode")
    private String linkviewshowmode;
    @Column(name="memo")
    private String memo;
    @Column(name="mobfieditor")
    private Integer mobfieditor;
    @Column(name="needcodelistconfig")
    private Integer needcodelistconfig;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pseditortypeid")
    private String pseditortypeid;
    @Column(name="pseditortypename")
    private String pseditortypename;
    @Column(name="refviewshowmode")
    private String refviewshowmode;
    @Column(name="sbeditor")
    private Integer sbeditor;
    @Column(name="standardeditor")
    private String standardeditor;
    @Column(name="standardtype")
    private Integer standardtype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="valueprocessor")
    private String valueprocessor;
    @Column(name="width")
    private Integer width;

    public void setAjaxHandler(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAjaxHandler(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ajaxhandler = string;
        this.ajaxhandlerDirtyFlag = true;
    }

    public String getAjaxHandler() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAjaxHandler();
        }
        return this.ajaxhandler;
    }

    public boolean isAjaxHandlerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAjaxHandlerDirty();
        }
        return this.ajaxhandlerDirtyFlag;
    }

    public void resetAjaxHandler() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAjaxHandler();
            return;
        }
        this.ajaxhandlerDirtyFlag = false;
        this.ajaxhandler = null;
    }

    public void setConvertCIText(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setConvertCIText(n);
            return;
        }
        this.convertcitext = n;
        this.convertcitextDirtyFlag = true;
    }

    public Integer getConvertCIText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getConvertCIText();
        }
        return this.convertcitext;
    }

    public boolean isConvertCITextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isConvertCITextDirty();
        }
        return this.convertcitextDirtyFlag;
    }

    public void resetConvertCIText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetConvertCIText();
            return;
        }
        this.convertcitextDirtyFlag = false;
        this.convertcitext = null;
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

    public void setCtrlObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlobj = string;
        this.ctrlobjDirtyFlag = true;
    }

    public String getCtrlObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlObj();
        }
        return this.ctrlobj;
    }

    public boolean isCtrlObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlObjDirty();
        }
        return this.ctrlobjDirtyFlag;
    }

    public void resetCtrlObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlObj();
            return;
        }
        this.ctrlobjDirtyFlag = false;
        this.ctrlobj = null;
    }

    public void setDotNETFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDotNETFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dotnetformat = string;
        this.dotnetformatDirtyFlag = true;
    }

    public String getDotNETFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDotNETFormat();
        }
        return this.dotnetformat;
    }

    public boolean isDotNETFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDotNETFormatDirty();
        }
        return this.dotnetformatDirtyFlag;
    }

    public void resetDotNETFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDotNETFormat();
            return;
        }
        this.dotnetformatDirtyFlag = false;
        this.dotnetformat = null;
    }

    public void setEditable(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEditable(n);
            return;
        }
        this.editable = n;
        this.editableDirtyFlag = true;
    }

    public Integer getEditable() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEditable();
        }
        return this.editable;
    }

    public boolean isEditableDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEditableDirty();
        }
        return this.editableDirtyFlag;
    }

    public void resetEditable() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEditable();
            return;
        }
        this.editableDirtyFlag = false;
        this.editable = null;
    }

    public void setEditorCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEditorCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.editorcode = string;
        this.editorcodeDirtyFlag = true;
    }

    public String getEditorCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEditorCode();
        }
        return this.editorcode;
    }

    public boolean isEditorCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEditorCodeDirty();
        }
        return this.editorcodeDirtyFlag;
    }

    public void resetEditorCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEditorCode();
            return;
        }
        this.editorcodeDirtyFlag = false;
        this.editorcode = null;
    }

    public void setEditorParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEditorParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.editorparam = string;
        this.editorparamDirtyFlag = true;
    }

    public String getEditorParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEditorParam();
        }
        return this.editorparam;
    }

    public boolean isEditorParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEditorParamDirty();
        }
        return this.editorparamDirtyFlag;
    }

    public void resetEditorParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEditorParam();
            return;
        }
        this.editorparamDirtyFlag = false;
        this.editorparam = null;
    }

    public void setFIEditor(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFIEditor(n);
            return;
        }
        this.fieditor = n;
        this.fieditorDirtyFlag = true;
    }

    public Integer getFIEditor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFIEditor();
        }
        return this.fieditor;
    }

    public boolean isFIEditorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFIEditorDirty();
        }
        return this.fieditorDirtyFlag;
    }

    public void resetFIEditor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFIEditor();
            return;
        }
        this.fieditorDirtyFlag = false;
        this.fieditor = null;
    }

    public void setGCEditor(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGCEditor(n);
            return;
        }
        this.gceditor = n;
        this.gceditorDirtyFlag = true;
    }

    public Integer getGCEditor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGCEditor();
        }
        return this.gceditor;
    }

    public boolean isGCEditorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGCEditorDirty();
        }
        return this.gceditorDirtyFlag;
    }

    public void resetGCEditor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGCEditor();
            return;
        }
        this.gceditorDirtyFlag = false;
        this.gceditor = null;
    }

    public void setHeight(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHeight(n);
            return;
        }
        this.height = n;
        this.heightDirtyFlag = true;
    }

    public Integer getHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHeight();
        }
        return this.height;
    }

    public boolean isHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHeightDirty();
        }
        return this.heightDirtyFlag;
    }

    public void resetHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHeight();
            return;
        }
        this.heightDirtyFlag = false;
        this.height = null;
    }

    public void setIconPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIconPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iconpath = string;
        this.iconpathDirtyFlag = true;
    }

    public String getIconPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconPath();
        }
        return this.iconpath;
    }

    public boolean isIconPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIconPathDirty();
        }
        return this.iconpathDirtyFlag;
    }

    public void resetIconPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIconPath();
            return;
        }
        this.iconpathDirtyFlag = false;
        this.iconpath = null;
    }

    public void setJavaFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJavaFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.javaformat = string;
        this.javaformatDirtyFlag = true;
    }

    public String getJavaFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJavaFormat();
        }
        return this.javaformat;
    }

    public boolean isJavaFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJavaFormatDirty();
        }
        return this.javaformatDirtyFlag;
    }

    public void resetJavaFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJavaFormat();
            return;
        }
        this.javaformatDirtyFlag = false;
        this.javaformat = null;
    }

    public void setLinkViewShowMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkViewShowMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linkviewshowmode = string;
        this.linkviewshowmodeDirtyFlag = true;
    }

    public String getLinkViewShowMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkViewShowMode();
        }
        return this.linkviewshowmode;
    }

    public boolean isLinkViewShowModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkViewShowModeDirty();
        }
        return this.linkviewshowmodeDirtyFlag;
    }

    public void resetLinkViewShowMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkViewShowMode();
            return;
        }
        this.linkviewshowmodeDirtyFlag = false;
        this.linkviewshowmode = null;
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

    public void setMobFIEditor(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobFIEditor(n);
            return;
        }
        this.mobfieditor = n;
        this.mobfieditorDirtyFlag = true;
    }

    public Integer getMobFIEditor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobFIEditor();
        }
        return this.mobfieditor;
    }

    public boolean isMobFIEditorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobFIEditorDirty();
        }
        return this.mobfieditorDirtyFlag;
    }

    public void resetMobFIEditor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobFIEditor();
            return;
        }
        this.mobfieditorDirtyFlag = false;
        this.mobfieditor = null;
    }

    public void setNeedCodeListConfig(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNeedCodeListConfig(n);
            return;
        }
        this.needcodelistconfig = n;
        this.needcodelistconfigDirtyFlag = true;
    }

    public Integer getNeedCodeListConfig() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNeedCodeListConfig();
        }
        return this.needcodelistconfig;
    }

    public boolean isNeedCodeListConfigDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNeedCodeListConfigDirty();
        }
        return this.needcodelistconfigDirtyFlag;
    }

    public void resetNeedCodeListConfig() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNeedCodeListConfig();
            return;
        }
        this.needcodelistconfigDirtyFlag = false;
        this.needcodelistconfig = null;
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

    public void setPSEditorTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSEditorTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pseditortypeid = string;
        this.pseditortypeidDirtyFlag = true;
    }

    public String getPSEditorTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSEditorTypeId();
        }
        return this.pseditortypeid;
    }

    public boolean isPSEditorTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSEditorTypeIdDirty();
        }
        return this.pseditortypeidDirtyFlag;
    }

    public void resetPSEditorTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSEditorTypeId();
            return;
        }
        this.pseditortypeidDirtyFlag = false;
        this.pseditortypeid = null;
    }

    public void setPSEditorTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSEditorTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pseditortypename = string;
        this.pseditortypenameDirtyFlag = true;
    }

    public String getPSEditorTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSEditorTypeName();
        }
        return this.pseditortypename;
    }

    public boolean isPSEditorTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSEditorTypeNameDirty();
        }
        return this.pseditortypenameDirtyFlag;
    }

    public void resetPSEditorTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSEditorTypeName();
            return;
        }
        this.pseditortypenameDirtyFlag = false;
        this.pseditortypename = null;
    }

    public void setRefViewShowMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefViewShowMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refviewshowmode = string;
        this.refviewshowmodeDirtyFlag = true;
    }

    public String getRefViewShowMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefViewShowMode();
        }
        return this.refviewshowmode;
    }

    public boolean isRefViewShowModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefViewShowModeDirty();
        }
        return this.refviewshowmodeDirtyFlag;
    }

    public void resetRefViewShowMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefViewShowMode();
            return;
        }
        this.refviewshowmodeDirtyFlag = false;
        this.refviewshowmode = null;
    }

    public void setSBEditor(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSBEditor(n);
            return;
        }
        this.sbeditor = n;
        this.sbeditorDirtyFlag = true;
    }

    public Integer getSBEditor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSBEditor();
        }
        return this.sbeditor;
    }

    public boolean isSBEditorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSBEditorDirty();
        }
        return this.sbeditorDirtyFlag;
    }

    public void resetSBEditor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSBEditor();
            return;
        }
        this.sbeditorDirtyFlag = false;
        this.sbeditor = null;
    }

    public void setStandardEditor(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStandardEditor(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.standardeditor = string;
        this.standardeditorDirtyFlag = true;
    }

    public String getStandardEditor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStandardEditor();
        }
        return this.standardeditor;
    }

    public boolean isStandardEditorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStandardEditorDirty();
        }
        return this.standardeditorDirtyFlag;
    }

    public void resetStandardEditor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStandardEditor();
            return;
        }
        this.standardeditorDirtyFlag = false;
        this.standardeditor = null;
    }

    public void setStandardType(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStandardType(n);
            return;
        }
        this.standardtype = n;
        this.standardtypeDirtyFlag = true;
    }

    public Integer getStandardType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStandardType();
        }
        return this.standardtype;
    }

    public boolean isStandardTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStandardTypeDirty();
        }
        return this.standardtypeDirtyFlag;
    }

    public void resetStandardType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStandardType();
            return;
        }
        this.standardtypeDirtyFlag = false;
        this.standardtype = null;
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

    public void setValueProcessor(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValueProcessor(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valueprocessor = string;
        this.valueprocessorDirtyFlag = true;
    }

    public String getValueProcessor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValueProcessor();
        }
        return this.valueprocessor;
    }

    public boolean isValueProcessorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueProcessorDirty();
        }
        return this.valueprocessorDirtyFlag;
    }

    public void resetValueProcessor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValueProcessor();
            return;
        }
        this.valueprocessorDirtyFlag = false;
        this.valueprocessor = null;
    }

    public void setWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWidth(n);
            return;
        }
        this.width = n;
        this.widthDirtyFlag = true;
    }

    public Integer getWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWidth();
        }
        return this.width;
    }

    public boolean isWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWidthDirty();
        }
        return this.widthDirtyFlag;
    }

    public void resetWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWidth();
            return;
        }
        this.widthDirtyFlag = false;
        this.width = null;
    }

    protected void onReset() {
        PSEditorTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSEditorTypeBase pSEditorTypeBase) {
        pSEditorTypeBase.resetAjaxHandler();
        pSEditorTypeBase.resetConvertCIText();
        pSEditorTypeBase.resetCreateDate();
        pSEditorTypeBase.resetCreateMan();
        pSEditorTypeBase.resetCtrlObj();
        pSEditorTypeBase.resetDotNETFormat();
        pSEditorTypeBase.resetEditable();
        pSEditorTypeBase.resetEditorCode();
        pSEditorTypeBase.resetEditorParam();
        pSEditorTypeBase.resetFIEditor();
        pSEditorTypeBase.resetGCEditor();
        pSEditorTypeBase.resetHeight();
        pSEditorTypeBase.resetIconPath();
        pSEditorTypeBase.resetJavaFormat();
        pSEditorTypeBase.resetLinkViewShowMode();
        pSEditorTypeBase.resetMemo();
        pSEditorTypeBase.resetMobFIEditor();
        pSEditorTypeBase.resetNeedCodeListConfig();
        pSEditorTypeBase.resetOrderValue();
        pSEditorTypeBase.resetPSEditorTypeId();
        pSEditorTypeBase.resetPSEditorTypeName();
        pSEditorTypeBase.resetRefViewShowMode();
        pSEditorTypeBase.resetSBEditor();
        pSEditorTypeBase.resetStandardEditor();
        pSEditorTypeBase.resetStandardType();
        pSEditorTypeBase.resetUpdateDate();
        pSEditorTypeBase.resetUpdateMan();
        pSEditorTypeBase.resetValidFlag();
        pSEditorTypeBase.resetValueProcessor();
        pSEditorTypeBase.resetWidth();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAjaxHandlerDirty()) {
            hashMap.put(FIELD_AJAXHANDLER, this.getAjaxHandler());
        }
        if (!bl || this.isConvertCITextDirty()) {
            hashMap.put(FIELD_CONVERTCITEXT, this.getConvertCIText());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCtrlObjDirty()) {
            hashMap.put(FIELD_CTRLOBJ, this.getCtrlObj());
        }
        if (!bl || this.isDotNETFormatDirty()) {
            hashMap.put(FIELD_DOTNETFORMAT, this.getDotNETFormat());
        }
        if (!bl || this.isEditableDirty()) {
            hashMap.put(FIELD_EDITABLE, this.getEditable());
        }
        if (!bl || this.isEditorCodeDirty()) {
            hashMap.put(FIELD_EDITORCODE, this.getEditorCode());
        }
        if (!bl || this.isEditorParamDirty()) {
            hashMap.put(FIELD_EDITORPARAM, this.getEditorParam());
        }
        if (!bl || this.isFIEditorDirty()) {
            hashMap.put(FIELD_FIEDITOR, this.getFIEditor());
        }
        if (!bl || this.isGCEditorDirty()) {
            hashMap.put(FIELD_GCEDITOR, this.getGCEditor());
        }
        if (!bl || this.isHeightDirty()) {
            hashMap.put(FIELD_HEIGHT, this.getHeight());
        }
        if (!bl || this.isIconPathDirty()) {
            hashMap.put(FIELD_ICONPATH, this.getIconPath());
        }
        if (!bl || this.isJavaFormatDirty()) {
            hashMap.put(FIELD_JAVAFORMAT, this.getJavaFormat());
        }
        if (!bl || this.isLinkViewShowModeDirty()) {
            hashMap.put(FIELD_LINKVIEWSHOWMODE, this.getLinkViewShowMode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMobFIEditorDirty()) {
            hashMap.put(FIELD_MOBFIEDITOR, this.getMobFIEditor());
        }
        if (!bl || this.isNeedCodeListConfigDirty()) {
            hashMap.put(FIELD_NEEDCODELISTCONFIG, this.getNeedCodeListConfig());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSEditorTypeIdDirty()) {
            hashMap.put(FIELD_PSEDITORTYPEID, this.getPSEditorTypeId());
        }
        if (!bl || this.isPSEditorTypeNameDirty()) {
            hashMap.put(FIELD_PSEDITORTYPENAME, this.getPSEditorTypeName());
        }
        if (!bl || this.isRefViewShowModeDirty()) {
            hashMap.put(FIELD_REFVIEWSHOWMODE, this.getRefViewShowMode());
        }
        if (!bl || this.isSBEditorDirty()) {
            hashMap.put(FIELD_SBEDITOR, this.getSBEditor());
        }
        if (!bl || this.isStandardEditorDirty()) {
            hashMap.put(FIELD_STANDARDEDITOR, this.getStandardEditor());
        }
        if (!bl || this.isStandardTypeDirty()) {
            hashMap.put(FIELD_STANDARDTYPE, this.getStandardType());
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
        if (!bl || this.isValueProcessorDirty()) {
            hashMap.put(FIELD_VALUEPROCESSOR, this.getValueProcessor());
        }
        if (!bl || this.isWidthDirty()) {
            hashMap.put(FIELD_WIDTH, this.getWidth());
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
        return PSEditorTypeBase.get(this, n);
    }

    private static Object get(PSEditorTypeBase pSEditorTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSEditorTypeBase.getAjaxHandler();
            }
            case 1: {
                return pSEditorTypeBase.getConvertCIText();
            }
            case 2: {
                return pSEditorTypeBase.getCreateDate();
            }
            case 3: {
                return pSEditorTypeBase.getCreateMan();
            }
            case 4: {
                return pSEditorTypeBase.getCtrlObj();
            }
            case 5: {
                return pSEditorTypeBase.getDotNETFormat();
            }
            case 6: {
                return pSEditorTypeBase.getEditable();
            }
            case 7: {
                return pSEditorTypeBase.getEditorCode();
            }
            case 8: {
                return pSEditorTypeBase.getEditorParam();
            }
            case 9: {
                return pSEditorTypeBase.getFIEditor();
            }
            case 10: {
                return pSEditorTypeBase.getGCEditor();
            }
            case 11: {
                return pSEditorTypeBase.getHeight();
            }
            case 12: {
                return pSEditorTypeBase.getIconPath();
            }
            case 13: {
                return pSEditorTypeBase.getJavaFormat();
            }
            case 14: {
                return pSEditorTypeBase.getLinkViewShowMode();
            }
            case 15: {
                return pSEditorTypeBase.getMemo();
            }
            case 16: {
                return pSEditorTypeBase.getMobFIEditor();
            }
            case 17: {
                return pSEditorTypeBase.getNeedCodeListConfig();
            }
            case 18: {
                return pSEditorTypeBase.getOrderValue();
            }
            case 19: {
                return pSEditorTypeBase.getPSEditorTypeId();
            }
            case 20: {
                return pSEditorTypeBase.getPSEditorTypeName();
            }
            case 21: {
                return pSEditorTypeBase.getRefViewShowMode();
            }
            case 22: {
                return pSEditorTypeBase.getSBEditor();
            }
            case 23: {
                return pSEditorTypeBase.getStandardEditor();
            }
            case 24: {
                return pSEditorTypeBase.getStandardType();
            }
            case 25: {
                return pSEditorTypeBase.getUpdateDate();
            }
            case 26: {
                return pSEditorTypeBase.getUpdateMan();
            }
            case 27: {
                return pSEditorTypeBase.getValidFlag();
            }
            case 28: {
                return pSEditorTypeBase.getValueProcessor();
            }
            case 29: {
                return pSEditorTypeBase.getWidth();
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
        PSEditorTypeBase.set(this, n, object);
    }

    private static void set(PSEditorTypeBase pSEditorTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSEditorTypeBase.setAjaxHandler(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSEditorTypeBase.setConvertCIText(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSEditorTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSEditorTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSEditorTypeBase.setCtrlObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSEditorTypeBase.setDotNETFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSEditorTypeBase.setEditable(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSEditorTypeBase.setEditorCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSEditorTypeBase.setEditorParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSEditorTypeBase.setFIEditor(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSEditorTypeBase.setGCEditor(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSEditorTypeBase.setHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSEditorTypeBase.setIconPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSEditorTypeBase.setJavaFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSEditorTypeBase.setLinkViewShowMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSEditorTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSEditorTypeBase.setMobFIEditor(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSEditorTypeBase.setNeedCodeListConfig(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSEditorTypeBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSEditorTypeBase.setPSEditorTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSEditorTypeBase.setPSEditorTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSEditorTypeBase.setRefViewShowMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSEditorTypeBase.setSBEditor(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSEditorTypeBase.setStandardEditor(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSEditorTypeBase.setStandardType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSEditorTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 26: {
                pSEditorTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSEditorTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSEditorTypeBase.setValueProcessor(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSEditorTypeBase.setWidth(DataObject.getIntegerValue((Object)object));
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
        return PSEditorTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSEditorTypeBase pSEditorTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSEditorTypeBase.getAjaxHandler() == null;
            }
            case 1: {
                return pSEditorTypeBase.getConvertCIText() == null;
            }
            case 2: {
                return pSEditorTypeBase.getCreateDate() == null;
            }
            case 3: {
                return pSEditorTypeBase.getCreateMan() == null;
            }
            case 4: {
                return pSEditorTypeBase.getCtrlObj() == null;
            }
            case 5: {
                return pSEditorTypeBase.getDotNETFormat() == null;
            }
            case 6: {
                return pSEditorTypeBase.getEditable() == null;
            }
            case 7: {
                return pSEditorTypeBase.getEditorCode() == null;
            }
            case 8: {
                return pSEditorTypeBase.getEditorParam() == null;
            }
            case 9: {
                return pSEditorTypeBase.getFIEditor() == null;
            }
            case 10: {
                return pSEditorTypeBase.getGCEditor() == null;
            }
            case 11: {
                return pSEditorTypeBase.getHeight() == null;
            }
            case 12: {
                return pSEditorTypeBase.getIconPath() == null;
            }
            case 13: {
                return pSEditorTypeBase.getJavaFormat() == null;
            }
            case 14: {
                return pSEditorTypeBase.getLinkViewShowMode() == null;
            }
            case 15: {
                return pSEditorTypeBase.getMemo() == null;
            }
            case 16: {
                return pSEditorTypeBase.getMobFIEditor() == null;
            }
            case 17: {
                return pSEditorTypeBase.getNeedCodeListConfig() == null;
            }
            case 18: {
                return pSEditorTypeBase.getOrderValue() == null;
            }
            case 19: {
                return pSEditorTypeBase.getPSEditorTypeId() == null;
            }
            case 20: {
                return pSEditorTypeBase.getPSEditorTypeName() == null;
            }
            case 21: {
                return pSEditorTypeBase.getRefViewShowMode() == null;
            }
            case 22: {
                return pSEditorTypeBase.getSBEditor() == null;
            }
            case 23: {
                return pSEditorTypeBase.getStandardEditor() == null;
            }
            case 24: {
                return pSEditorTypeBase.getStandardType() == null;
            }
            case 25: {
                return pSEditorTypeBase.getUpdateDate() == null;
            }
            case 26: {
                return pSEditorTypeBase.getUpdateMan() == null;
            }
            case 27: {
                return pSEditorTypeBase.getValidFlag() == null;
            }
            case 28: {
                return pSEditorTypeBase.getValueProcessor() == null;
            }
            case 29: {
                return pSEditorTypeBase.getWidth() == null;
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
        return PSEditorTypeBase.contains(this, n);
    }

    private static boolean contains(PSEditorTypeBase pSEditorTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSEditorTypeBase.isAjaxHandlerDirty();
            }
            case 1: {
                return pSEditorTypeBase.isConvertCITextDirty();
            }
            case 2: {
                return pSEditorTypeBase.isCreateDateDirty();
            }
            case 3: {
                return pSEditorTypeBase.isCreateManDirty();
            }
            case 4: {
                return pSEditorTypeBase.isCtrlObjDirty();
            }
            case 5: {
                return pSEditorTypeBase.isDotNETFormatDirty();
            }
            case 6: {
                return pSEditorTypeBase.isEditableDirty();
            }
            case 7: {
                return pSEditorTypeBase.isEditorCodeDirty();
            }
            case 8: {
                return pSEditorTypeBase.isEditorParamDirty();
            }
            case 9: {
                return pSEditorTypeBase.isFIEditorDirty();
            }
            case 10: {
                return pSEditorTypeBase.isGCEditorDirty();
            }
            case 11: {
                return pSEditorTypeBase.isHeightDirty();
            }
            case 12: {
                return pSEditorTypeBase.isIconPathDirty();
            }
            case 13: {
                return pSEditorTypeBase.isJavaFormatDirty();
            }
            case 14: {
                return pSEditorTypeBase.isLinkViewShowModeDirty();
            }
            case 15: {
                return pSEditorTypeBase.isMemoDirty();
            }
            case 16: {
                return pSEditorTypeBase.isMobFIEditorDirty();
            }
            case 17: {
                return pSEditorTypeBase.isNeedCodeListConfigDirty();
            }
            case 18: {
                return pSEditorTypeBase.isOrderValueDirty();
            }
            case 19: {
                return pSEditorTypeBase.isPSEditorTypeIdDirty();
            }
            case 20: {
                return pSEditorTypeBase.isPSEditorTypeNameDirty();
            }
            case 21: {
                return pSEditorTypeBase.isRefViewShowModeDirty();
            }
            case 22: {
                return pSEditorTypeBase.isSBEditorDirty();
            }
            case 23: {
                return pSEditorTypeBase.isStandardEditorDirty();
            }
            case 24: {
                return pSEditorTypeBase.isStandardTypeDirty();
            }
            case 25: {
                return pSEditorTypeBase.isUpdateDateDirty();
            }
            case 26: {
                return pSEditorTypeBase.isUpdateManDirty();
            }
            case 27: {
                return pSEditorTypeBase.isValidFlagDirty();
            }
            case 28: {
                return pSEditorTypeBase.isValueProcessorDirty();
            }
            case 29: {
                return pSEditorTypeBase.isWidthDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSEditorTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSEditorTypeBase pSEditorTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSEditorTypeBase.getAjaxHandler() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ajaxhandler", (Object)PSEditorTypeBase.getJSONValue((Object)pSEditorTypeBase.getAjaxHandler()), (boolean)false);
        }
        if (bl || pSEditorTypeBase.getConvertCIText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"convertcitext", (Object)PSEditorTypeBase.getJSONValue((Object)pSEditorTypeBase.getConvertCIText()), (boolean)false);
        }
        if (bl || pSEditorTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSEditorTypeBase.getJSONValue((Object)pSEditorTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSEditorTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSEditorTypeBase.getJSONValue((Object)pSEditorTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSEditorTypeBase.getCtrlObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlobj", (Object)PSEditorTypeBase.getJSONValue((Object)pSEditorTypeBase.getCtrlObj()), (boolean)false);
        }
        if (bl || pSEditorTypeBase.getDotNETFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dotnetformat", (Object)PSEditorTypeBase.getJSONValue((Object)pSEditorTypeBase.getDotNETFormat()), (boolean)false);
        }
        if (bl || pSEditorTypeBase.getEditable() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editable", (Object)PSEditorTypeBase.getJSONValue((Object)pSEditorTypeBase.getEditable()), (boolean)false);
        }
        if (bl || pSEditorTypeBase.getEditorCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editorcode", (Object)PSEditorTypeBase.getJSONValue((Object)pSEditorTypeBase.getEditorCode()), (boolean)false);
        }
        if (bl || pSEditorTypeBase.getEditorParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editorparam", (Object)PSEditorTypeBase.getJSONValue((Object)pSEditorTypeBase.getEditorParam()), (boolean)false);
        }
        if (bl || pSEditorTypeBase.getFIEditor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fieditor", (Object)PSEditorTypeBase.getJSONValue((Object)pSEditorTypeBase.getFIEditor()), (boolean)false);
        }
        if (bl || pSEditorTypeBase.getGCEditor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gceditor", (Object)PSEditorTypeBase.getJSONValue((Object)pSEditorTypeBase.getGCEditor()), (boolean)false);
        }
        if (bl || pSEditorTypeBase.getHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"height", (Object)PSEditorTypeBase.getJSONValue((Object)pSEditorTypeBase.getHeight()), (boolean)false);
        }
        if (bl || pSEditorTypeBase.getIconPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpath", (Object)PSEditorTypeBase.getJSONValue((Object)pSEditorTypeBase.getIconPath()), (boolean)false);
        }
        if (bl || pSEditorTypeBase.getJavaFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"javaformat", (Object)PSEditorTypeBase.getJSONValue((Object)pSEditorTypeBase.getJavaFormat()), (boolean)false);
        }
        if (bl || pSEditorTypeBase.getLinkViewShowMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkviewshowmode", (Object)PSEditorTypeBase.getJSONValue((Object)pSEditorTypeBase.getLinkViewShowMode()), (boolean)false);
        }
        if (bl || pSEditorTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSEditorTypeBase.getJSONValue((Object)pSEditorTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSEditorTypeBase.getMobFIEditor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobfieditor", (Object)PSEditorTypeBase.getJSONValue((Object)pSEditorTypeBase.getMobFIEditor()), (boolean)false);
        }
        if (bl || pSEditorTypeBase.getNeedCodeListConfig() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"needcodelistconfig", (Object)PSEditorTypeBase.getJSONValue((Object)pSEditorTypeBase.getNeedCodeListConfig()), (boolean)false);
        }
        if (bl || pSEditorTypeBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSEditorTypeBase.getJSONValue((Object)pSEditorTypeBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSEditorTypeBase.getPSEditorTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pseditortypeid", (Object)PSEditorTypeBase.getJSONValue((Object)pSEditorTypeBase.getPSEditorTypeId()), (boolean)false);
        }
        if (bl || pSEditorTypeBase.getPSEditorTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pseditortypename", (Object)PSEditorTypeBase.getJSONValue((Object)pSEditorTypeBase.getPSEditorTypeName()), (boolean)false);
        }
        if (bl || pSEditorTypeBase.getRefViewShowMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refviewshowmode", (Object)PSEditorTypeBase.getJSONValue((Object)pSEditorTypeBase.getRefViewShowMode()), (boolean)false);
        }
        if (bl || pSEditorTypeBase.getSBEditor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sbeditor", (Object)PSEditorTypeBase.getJSONValue((Object)pSEditorTypeBase.getSBEditor()), (boolean)false);
        }
        if (bl || pSEditorTypeBase.getStandardEditor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"standardeditor", (Object)PSEditorTypeBase.getJSONValue((Object)pSEditorTypeBase.getStandardEditor()), (boolean)false);
        }
        if (bl || pSEditorTypeBase.getStandardType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"standardtype", (Object)PSEditorTypeBase.getJSONValue((Object)pSEditorTypeBase.getStandardType()), (boolean)false);
        }
        if (bl || pSEditorTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSEditorTypeBase.getJSONValue((Object)pSEditorTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSEditorTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSEditorTypeBase.getJSONValue((Object)pSEditorTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSEditorTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSEditorTypeBase.getJSONValue((Object)pSEditorTypeBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSEditorTypeBase.getValueProcessor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valueprocessor", (Object)PSEditorTypeBase.getJSONValue((Object)pSEditorTypeBase.getValueProcessor()), (boolean)false);
        }
        if (bl || pSEditorTypeBase.getWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"width", (Object)PSEditorTypeBase.getJSONValue((Object)pSEditorTypeBase.getWidth()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSEditorTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSEditorTypeBase pSEditorTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSEditorTypeBase.getAjaxHandler() != null) {
            object = pSEditorTypeBase.getAjaxHandler();
            xmlNode.setAttribute(FIELD_AJAXHANDLER, object == null ? "" : (String)object);
        }
        if (bl || pSEditorTypeBase.getConvertCIText() != null) {
            object = pSEditorTypeBase.getConvertCIText();
            xmlNode.setAttribute(FIELD_CONVERTCITEXT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSEditorTypeBase.getCreateDate() != null) {
            object = pSEditorTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSEditorTypeBase.getCreateMan() != null) {
            object = pSEditorTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSEditorTypeBase.getCtrlObj() != null) {
            object = pSEditorTypeBase.getCtrlObj();
            xmlNode.setAttribute(FIELD_CTRLOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSEditorTypeBase.getDotNETFormat() != null) {
            object = pSEditorTypeBase.getDotNETFormat();
            xmlNode.setAttribute(FIELD_DOTNETFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSEditorTypeBase.getEditable() != null) {
            object = pSEditorTypeBase.getEditable();
            xmlNode.setAttribute(FIELD_EDITABLE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSEditorTypeBase.getEditorCode() != null) {
            object = pSEditorTypeBase.getEditorCode();
            xmlNode.setAttribute(FIELD_EDITORCODE, object == null ? "" : (String)object);
        }
        if (bl || pSEditorTypeBase.getEditorParam() != null) {
            object = pSEditorTypeBase.getEditorParam();
            xmlNode.setAttribute(FIELD_EDITORPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSEditorTypeBase.getFIEditor() != null) {
            object = pSEditorTypeBase.getFIEditor();
            xmlNode.setAttribute(FIELD_FIEDITOR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSEditorTypeBase.getGCEditor() != null) {
            object = pSEditorTypeBase.getGCEditor();
            xmlNode.setAttribute(FIELD_GCEDITOR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSEditorTypeBase.getHeight() != null) {
            object = pSEditorTypeBase.getHeight();
            xmlNode.setAttribute(FIELD_HEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSEditorTypeBase.getIconPath() != null) {
            object = pSEditorTypeBase.getIconPath();
            xmlNode.setAttribute(FIELD_ICONPATH, object == null ? "" : (String)object);
        }
        if (bl || pSEditorTypeBase.getJavaFormat() != null) {
            object = pSEditorTypeBase.getJavaFormat();
            xmlNode.setAttribute(FIELD_JAVAFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSEditorTypeBase.getLinkViewShowMode() != null) {
            object = pSEditorTypeBase.getLinkViewShowMode();
            xmlNode.setAttribute(FIELD_LINKVIEWSHOWMODE, object == null ? "" : (String)object);
        }
        if (bl || pSEditorTypeBase.getMemo() != null) {
            object = pSEditorTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSEditorTypeBase.getMobFIEditor() != null) {
            object = pSEditorTypeBase.getMobFIEditor();
            xmlNode.setAttribute(FIELD_MOBFIEDITOR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSEditorTypeBase.getNeedCodeListConfig() != null) {
            object = pSEditorTypeBase.getNeedCodeListConfig();
            xmlNode.setAttribute(FIELD_NEEDCODELISTCONFIG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSEditorTypeBase.getOrderValue() != null) {
            object = pSEditorTypeBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSEditorTypeBase.getPSEditorTypeId() != null) {
            object = pSEditorTypeBase.getPSEditorTypeId();
            xmlNode.setAttribute(FIELD_PSEDITORTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSEditorTypeBase.getPSEditorTypeName() != null) {
            object = pSEditorTypeBase.getPSEditorTypeName();
            xmlNode.setAttribute(FIELD_PSEDITORTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSEditorTypeBase.getRefViewShowMode() != null) {
            object = pSEditorTypeBase.getRefViewShowMode();
            xmlNode.setAttribute(FIELD_REFVIEWSHOWMODE, object == null ? "" : (String)object);
        }
        if (bl || pSEditorTypeBase.getSBEditor() != null) {
            object = pSEditorTypeBase.getSBEditor();
            xmlNode.setAttribute(FIELD_SBEDITOR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSEditorTypeBase.getStandardEditor() != null) {
            object = pSEditorTypeBase.getStandardEditor();
            xmlNode.setAttribute(FIELD_STANDARDEDITOR, object == null ? "" : (String)object);
        }
        if (bl || pSEditorTypeBase.getStandardType() != null) {
            object = pSEditorTypeBase.getStandardType();
            xmlNode.setAttribute(FIELD_STANDARDTYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSEditorTypeBase.getUpdateDate() != null) {
            object = pSEditorTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSEditorTypeBase.getUpdateMan() != null) {
            object = pSEditorTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSEditorTypeBase.getValidFlag() != null) {
            object = pSEditorTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSEditorTypeBase.getValueProcessor() != null) {
            object = pSEditorTypeBase.getValueProcessor();
            xmlNode.setAttribute(FIELD_VALUEPROCESSOR, object == null ? "" : (String)object);
        }
        if (bl || pSEditorTypeBase.getWidth() != null) {
            object = pSEditorTypeBase.getWidth();
            xmlNode.setAttribute(FIELD_WIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSEditorTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSEditorTypeBase pSEditorTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSEditorTypeBase.isAjaxHandlerDirty() && (bl || pSEditorTypeBase.getAjaxHandler() != null)) {
            iDataObject.set(FIELD_AJAXHANDLER, (Object)pSEditorTypeBase.getAjaxHandler());
        }
        if (pSEditorTypeBase.isConvertCITextDirty() && (bl || pSEditorTypeBase.getConvertCIText() != null)) {
            iDataObject.set(FIELD_CONVERTCITEXT, (Object)pSEditorTypeBase.getConvertCIText());
        }
        if (pSEditorTypeBase.isCreateDateDirty() && (bl || pSEditorTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSEditorTypeBase.getCreateDate());
        }
        if (pSEditorTypeBase.isCreateManDirty() && (bl || pSEditorTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSEditorTypeBase.getCreateMan());
        }
        if (pSEditorTypeBase.isCtrlObjDirty() && (bl || pSEditorTypeBase.getCtrlObj() != null)) {
            iDataObject.set(FIELD_CTRLOBJ, (Object)pSEditorTypeBase.getCtrlObj());
        }
        if (pSEditorTypeBase.isDotNETFormatDirty() && (bl || pSEditorTypeBase.getDotNETFormat() != null)) {
            iDataObject.set(FIELD_DOTNETFORMAT, (Object)pSEditorTypeBase.getDotNETFormat());
        }
        if (pSEditorTypeBase.isEditableDirty() && (bl || pSEditorTypeBase.getEditable() != null)) {
            iDataObject.set(FIELD_EDITABLE, (Object)pSEditorTypeBase.getEditable());
        }
        if (pSEditorTypeBase.isEditorCodeDirty() && (bl || pSEditorTypeBase.getEditorCode() != null)) {
            iDataObject.set(FIELD_EDITORCODE, (Object)pSEditorTypeBase.getEditorCode());
        }
        if (pSEditorTypeBase.isEditorParamDirty() && (bl || pSEditorTypeBase.getEditorParam() != null)) {
            iDataObject.set(FIELD_EDITORPARAM, (Object)pSEditorTypeBase.getEditorParam());
        }
        if (pSEditorTypeBase.isFIEditorDirty() && (bl || pSEditorTypeBase.getFIEditor() != null)) {
            iDataObject.set(FIELD_FIEDITOR, (Object)pSEditorTypeBase.getFIEditor());
        }
        if (pSEditorTypeBase.isGCEditorDirty() && (bl || pSEditorTypeBase.getGCEditor() != null)) {
            iDataObject.set(FIELD_GCEDITOR, (Object)pSEditorTypeBase.getGCEditor());
        }
        if (pSEditorTypeBase.isHeightDirty() && (bl || pSEditorTypeBase.getHeight() != null)) {
            iDataObject.set(FIELD_HEIGHT, (Object)pSEditorTypeBase.getHeight());
        }
        if (pSEditorTypeBase.isIconPathDirty() && (bl || pSEditorTypeBase.getIconPath() != null)) {
            iDataObject.set(FIELD_ICONPATH, (Object)pSEditorTypeBase.getIconPath());
        }
        if (pSEditorTypeBase.isJavaFormatDirty() && (bl || pSEditorTypeBase.getJavaFormat() != null)) {
            iDataObject.set(FIELD_JAVAFORMAT, (Object)pSEditorTypeBase.getJavaFormat());
        }
        if (pSEditorTypeBase.isLinkViewShowModeDirty() && (bl || pSEditorTypeBase.getLinkViewShowMode() != null)) {
            iDataObject.set(FIELD_LINKVIEWSHOWMODE, (Object)pSEditorTypeBase.getLinkViewShowMode());
        }
        if (pSEditorTypeBase.isMemoDirty() && (bl || pSEditorTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSEditorTypeBase.getMemo());
        }
        if (pSEditorTypeBase.isMobFIEditorDirty() && (bl || pSEditorTypeBase.getMobFIEditor() != null)) {
            iDataObject.set(FIELD_MOBFIEDITOR, (Object)pSEditorTypeBase.getMobFIEditor());
        }
        if (pSEditorTypeBase.isNeedCodeListConfigDirty() && (bl || pSEditorTypeBase.getNeedCodeListConfig() != null)) {
            iDataObject.set(FIELD_NEEDCODELISTCONFIG, (Object)pSEditorTypeBase.getNeedCodeListConfig());
        }
        if (pSEditorTypeBase.isOrderValueDirty() && (bl || pSEditorTypeBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSEditorTypeBase.getOrderValue());
        }
        if (pSEditorTypeBase.isPSEditorTypeIdDirty() && (bl || pSEditorTypeBase.getPSEditorTypeId() != null)) {
            iDataObject.set(FIELD_PSEDITORTYPEID, (Object)pSEditorTypeBase.getPSEditorTypeId());
        }
        if (pSEditorTypeBase.isPSEditorTypeNameDirty() && (bl || pSEditorTypeBase.getPSEditorTypeName() != null)) {
            iDataObject.set(FIELD_PSEDITORTYPENAME, (Object)pSEditorTypeBase.getPSEditorTypeName());
        }
        if (pSEditorTypeBase.isRefViewShowModeDirty() && (bl || pSEditorTypeBase.getRefViewShowMode() != null)) {
            iDataObject.set(FIELD_REFVIEWSHOWMODE, (Object)pSEditorTypeBase.getRefViewShowMode());
        }
        if (pSEditorTypeBase.isSBEditorDirty() && (bl || pSEditorTypeBase.getSBEditor() != null)) {
            iDataObject.set(FIELD_SBEDITOR, (Object)pSEditorTypeBase.getSBEditor());
        }
        if (pSEditorTypeBase.isStandardEditorDirty() && (bl || pSEditorTypeBase.getStandardEditor() != null)) {
            iDataObject.set(FIELD_STANDARDEDITOR, (Object)pSEditorTypeBase.getStandardEditor());
        }
        if (pSEditorTypeBase.isStandardTypeDirty() && (bl || pSEditorTypeBase.getStandardType() != null)) {
            iDataObject.set(FIELD_STANDARDTYPE, (Object)pSEditorTypeBase.getStandardType());
        }
        if (pSEditorTypeBase.isUpdateDateDirty() && (bl || pSEditorTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSEditorTypeBase.getUpdateDate());
        }
        if (pSEditorTypeBase.isUpdateManDirty() && (bl || pSEditorTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSEditorTypeBase.getUpdateMan());
        }
        if (pSEditorTypeBase.isValidFlagDirty() && (bl || pSEditorTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSEditorTypeBase.getValidFlag());
        }
        if (pSEditorTypeBase.isValueProcessorDirty() && (bl || pSEditorTypeBase.getValueProcessor() != null)) {
            iDataObject.set(FIELD_VALUEPROCESSOR, (Object)pSEditorTypeBase.getValueProcessor());
        }
        if (pSEditorTypeBase.isWidthDirty() && (bl || pSEditorTypeBase.getWidth() != null)) {
            iDataObject.set(FIELD_WIDTH, (Object)pSEditorTypeBase.getWidth());
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
        return PSEditorTypeBase.remove(this, n);
    }

    private static boolean remove(PSEditorTypeBase pSEditorTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSEditorTypeBase.resetAjaxHandler();
                return true;
            }
            case 1: {
                pSEditorTypeBase.resetConvertCIText();
                return true;
            }
            case 2: {
                pSEditorTypeBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSEditorTypeBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSEditorTypeBase.resetCtrlObj();
                return true;
            }
            case 5: {
                pSEditorTypeBase.resetDotNETFormat();
                return true;
            }
            case 6: {
                pSEditorTypeBase.resetEditable();
                return true;
            }
            case 7: {
                pSEditorTypeBase.resetEditorCode();
                return true;
            }
            case 8: {
                pSEditorTypeBase.resetEditorParam();
                return true;
            }
            case 9: {
                pSEditorTypeBase.resetFIEditor();
                return true;
            }
            case 10: {
                pSEditorTypeBase.resetGCEditor();
                return true;
            }
            case 11: {
                pSEditorTypeBase.resetHeight();
                return true;
            }
            case 12: {
                pSEditorTypeBase.resetIconPath();
                return true;
            }
            case 13: {
                pSEditorTypeBase.resetJavaFormat();
                return true;
            }
            case 14: {
                pSEditorTypeBase.resetLinkViewShowMode();
                return true;
            }
            case 15: {
                pSEditorTypeBase.resetMemo();
                return true;
            }
            case 16: {
                pSEditorTypeBase.resetMobFIEditor();
                return true;
            }
            case 17: {
                pSEditorTypeBase.resetNeedCodeListConfig();
                return true;
            }
            case 18: {
                pSEditorTypeBase.resetOrderValue();
                return true;
            }
            case 19: {
                pSEditorTypeBase.resetPSEditorTypeId();
                return true;
            }
            case 20: {
                pSEditorTypeBase.resetPSEditorTypeName();
                return true;
            }
            case 21: {
                pSEditorTypeBase.resetRefViewShowMode();
                return true;
            }
            case 22: {
                pSEditorTypeBase.resetSBEditor();
                return true;
            }
            case 23: {
                pSEditorTypeBase.resetStandardEditor();
                return true;
            }
            case 24: {
                pSEditorTypeBase.resetStandardType();
                return true;
            }
            case 25: {
                pSEditorTypeBase.resetUpdateDate();
                return true;
            }
            case 26: {
                pSEditorTypeBase.resetUpdateMan();
                return true;
            }
            case 27: {
                pSEditorTypeBase.resetValidFlag();
                return true;
            }
            case 28: {
                pSEditorTypeBase.resetValueProcessor();
                return true;
            }
            case 29: {
                pSEditorTypeBase.resetWidth();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSEditorTypeBase getProxyEntity() {
        return this.proxyPSEditorTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSEditorTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSEditorTypeBase) {
            this.proxyPSEditorTypeBase = (PSEditorTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSEditorTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AJAXHANDLER, 0);
        fieldIndexMap.put(FIELD_CONVERTCITEXT, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_CTRLOBJ, 4);
        fieldIndexMap.put(FIELD_DOTNETFORMAT, 5);
        fieldIndexMap.put(FIELD_EDITABLE, 6);
        fieldIndexMap.put(FIELD_EDITORCODE, 7);
        fieldIndexMap.put(FIELD_EDITORPARAM, 8);
        fieldIndexMap.put(FIELD_FIEDITOR, 9);
        fieldIndexMap.put(FIELD_GCEDITOR, 10);
        fieldIndexMap.put(FIELD_HEIGHT, 11);
        fieldIndexMap.put(FIELD_ICONPATH, 12);
        fieldIndexMap.put(FIELD_JAVAFORMAT, 13);
        fieldIndexMap.put(FIELD_LINKVIEWSHOWMODE, 14);
        fieldIndexMap.put(FIELD_MEMO, 15);
        fieldIndexMap.put(FIELD_MOBFIEDITOR, 16);
        fieldIndexMap.put(FIELD_NEEDCODELISTCONFIG, 17);
        fieldIndexMap.put(FIELD_ORDERVALUE, 18);
        fieldIndexMap.put(FIELD_PSEDITORTYPEID, 19);
        fieldIndexMap.put(FIELD_PSEDITORTYPENAME, 20);
        fieldIndexMap.put(FIELD_REFVIEWSHOWMODE, 21);
        fieldIndexMap.put(FIELD_SBEDITOR, 22);
        fieldIndexMap.put(FIELD_STANDARDEDITOR, 23);
        fieldIndexMap.put(FIELD_STANDARDTYPE, 24);
        fieldIndexMap.put(FIELD_UPDATEDATE, 25);
        fieldIndexMap.put(FIELD_UPDATEMAN, 26);
        fieldIndexMap.put(FIELD_VALIDFLAG, 27);
        fieldIndexMap.put(FIELD_VALUEPROCESSOR, 28);
        fieldIndexMap.put(FIELD_WIDTH, 29);
    }
}

