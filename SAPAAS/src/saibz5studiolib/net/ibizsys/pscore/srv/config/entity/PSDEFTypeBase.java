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
import net.ibizsys.pscore.srv.config.entity.PSCodeListTempl;
import net.ibizsys.pscore.srv.config.entity.PSUnit;
import net.ibizsys.pscore.srv.config.entity.PSValueRule;
import net.ibizsys.pscore.srv.config.service.PSCodeListTemplService;
import net.ibizsys.pscore.srv.config.service.PSUnitService;
import net.ibizsys.pscore.srv.config.service.PSValueRuleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEFTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DATATYPES = "DATATYPES";
    public static final String FIELD_DOTNETFORMAT = "DOTNETFORMAT";
    public static final String FIELD_EDITORHEIGHT = "EDITORHEIGHT";
    public static final String FIELD_EDITORTYPE = "EDITORTYPE";
    public static final String FIELD_EDITORWIDTH = "EDITORWIDTH";
    public static final String FIELD_FIELDS = "FIELDS";
    public static final String FIELD_FORMITEMOBJ = "FORMITEMOBJ";
    public static final String FIELD_GRIDCOLALIGN = "GRIDCOLALIGN";
    public static final String FIELD_GRIDCOLCLMODE = "GRIDCOLCLMODE";
    public static final String FIELD_GRIDCOLOBJ = "GRIDCOLOBJ";
    public static final String FIELD_GRIDCOLWIDTH = "GRIDCOLWIDTH";
    public static final String FIELD_ICONPATH = "ICONPATH";
    public static final String FIELD_INCREMENTFLAG = "INCREMENTFLAG";
    public static final String FIELD_JAVAFORMAT = "JAVAFORMAT";
    public static final String FIELD_JSFORMAT = "JSFORMAT";
    public static final String FIELD_MAXVALUESTR = "MAXVALUESTR";
    public static final String FIELD_MBEDITORHEIGHT = "MBEDITORHEIGHT";
    public static final String FIELD_MBEDITORTYPE = "MBEDITORTYPE";
    public static final String FIELD_MBEDITORWIDTH = "MBEDITORWIDTH";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINSTRLENGTH = "MINSTRLENGTH";
    public static final String FIELD_MINVALUESTR = "MINVALUESTR";
    public static final String FIELD_OBJHELPER = "OBJHELPER";
    public static final String FIELD_OBJHELPER2 = "OBJHELPER2";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PRECISION2 = "PRECISION2";
    public static final String FIELD_PSCODELISTTEMPLID = "PSCODELISTTEMPLID";
    public static final String FIELD_PSCODELISTTEMPLNAME = "PSCODELISTTEMPLNAME";
    public static final String FIELD_PSDEFTYPEID = "PSDEFTYPEID";
    public static final String FIELD_PSDEFTYPENAME = "PSDEFTYPENAME";
    public static final String FIELD_PSUNITID = "PSUNITID";
    public static final String FIELD_PSUNITNAME = "PSUNITNAME";
    public static final String FIELD_PSVALUERULEID = "PSVALUERULEID";
    public static final String FIELD_PSVALUERULENAME = "PSVALUERULENAME";
    public static final String FIELD_PYFORMAT = "PYFORMAT";
    public static final String FIELD_SEARCHEDITORHEIGHT = "SEARCHEDITORHEIGHT";
    public static final String FIELD_SEARCHEDITORTYPE = "SEARCHEDITORTYPE";
    public static final String FIELD_SEARCHEDITORWIDTH = "SEARCHEDITORWIDTH";
    public static final String FIELD_SEARCHMBEDITORHEIGHT = "SEARCHMBEDITORHEIGHT";
    public static final String FIELD_SEARCHMBEDITORTYPE = "SEARCHMBEDITORTYPE";
    public static final String FIELD_SEARCHMBEDITORWIDTH = "SEARCHMBEDITORWIDTH";
    public static final String FIELD_SEARCHMODEOBJ = "SEARCHMODEOBJ";
    public static final String FIELD_SFITEMOBJ = "SFITEMOBJ";
    public static final String FIELD_STDDATATYPE = "STDDATATYPE";
    public static final String FIELD_STRLENGTH = "STRLENGTH";
    public static final String FIELD_TESTDATA = "TESTDATA";
    public static final String FIELD_TSFORMAT = "TSFORMAT";
    public static final String FIELD_UIMODEOBJ = "UIMODEOBJ";
    public static final String FIELD_UNSIGNEDFLAG = "UNSIGNEDFLAG";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DATATYPES = 2;
    private static final int INDEX_DOTNETFORMAT = 3;
    private static final int INDEX_EDITORHEIGHT = 4;
    private static final int INDEX_EDITORTYPE = 5;
    private static final int INDEX_EDITORWIDTH = 6;
    private static final int INDEX_FIELDS = 7;
    private static final int INDEX_FORMITEMOBJ = 8;
    private static final int INDEX_GRIDCOLALIGN = 9;
    private static final int INDEX_GRIDCOLCLMODE = 10;
    private static final int INDEX_GRIDCOLOBJ = 11;
    private static final int INDEX_GRIDCOLWIDTH = 12;
    private static final int INDEX_ICONPATH = 13;
    private static final int INDEX_INCREMENTFLAG = 14;
    private static final int INDEX_JAVAFORMAT = 15;
    private static final int INDEX_JSFORMAT = 16;
    private static final int INDEX_MAXVALUESTR = 17;
    private static final int INDEX_MBEDITORHEIGHT = 18;
    private static final int INDEX_MBEDITORTYPE = 19;
    private static final int INDEX_MBEDITORWIDTH = 20;
    private static final int INDEX_MEMO = 21;
    private static final int INDEX_MINSTRLENGTH = 22;
    private static final int INDEX_MINVALUESTR = 23;
    private static final int INDEX_OBJHELPER = 24;
    private static final int INDEX_OBJHELPER2 = 25;
    private static final int INDEX_ORDERVALUE = 26;
    private static final int INDEX_PRECISION2 = 27;
    private static final int INDEX_PSCODELISTTEMPLID = 28;
    private static final int INDEX_PSCODELISTTEMPLNAME = 29;
    private static final int INDEX_PSDEFTYPEID = 30;
    private static final int INDEX_PSDEFTYPENAME = 31;
    private static final int INDEX_PSUNITID = 32;
    private static final int INDEX_PSUNITNAME = 33;
    private static final int INDEX_PSVALUERULEID = 34;
    private static final int INDEX_PSVALUERULENAME = 35;
    private static final int INDEX_PYFORMAT = 36;
    private static final int INDEX_SEARCHEDITORHEIGHT = 37;
    private static final int INDEX_SEARCHEDITORTYPE = 38;
    private static final int INDEX_SEARCHEDITORWIDTH = 39;
    private static final int INDEX_SEARCHMBEDITORHEIGHT = 40;
    private static final int INDEX_SEARCHMBEDITORTYPE = 41;
    private static final int INDEX_SEARCHMBEDITORWIDTH = 42;
    private static final int INDEX_SEARCHMODEOBJ = 43;
    private static final int INDEX_SFITEMOBJ = 44;
    private static final int INDEX_STDDATATYPE = 45;
    private static final int INDEX_STRLENGTH = 46;
    private static final int INDEX_TESTDATA = 47;
    private static final int INDEX_TSFORMAT = 48;
    private static final int INDEX_UIMODEOBJ = 49;
    private static final int INDEX_UNSIGNEDFLAG = 50;
    private static final int INDEX_UPDATEDATE = 51;
    private static final int INDEX_UPDATEMAN = 52;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEFTypeBase proxyPSDEFTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean datatypesDirtyFlag = false;
    private boolean dotnetformatDirtyFlag = false;
    private boolean editorheightDirtyFlag = false;
    private boolean editortypeDirtyFlag = false;
    private boolean editorwidthDirtyFlag = false;
    private boolean fieldsDirtyFlag = false;
    private boolean formitemobjDirtyFlag = false;
    private boolean gridcolalignDirtyFlag = false;
    private boolean gridcolclmodeDirtyFlag = false;
    private boolean gridcolobjDirtyFlag = false;
    private boolean gridcolwidthDirtyFlag = false;
    private boolean iconpathDirtyFlag = false;
    private boolean incrementflagDirtyFlag = false;
    private boolean javaformatDirtyFlag = false;
    private boolean jsformatDirtyFlag = false;
    private boolean maxvaluestrDirtyFlag = false;
    private boolean mbeditorheightDirtyFlag = false;
    private boolean mbeditortypeDirtyFlag = false;
    private boolean mbeditorwidthDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minstrlengthDirtyFlag = false;
    private boolean minvaluestrDirtyFlag = false;
    private boolean objhelperDirtyFlag = false;
    private boolean objhelper2DirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean precision2DirtyFlag = false;
    private boolean pscodelisttemplidDirtyFlag = false;
    private boolean pscodelisttemplnameDirtyFlag = false;
    private boolean psdeftypeidDirtyFlag = false;
    private boolean psdeftypenameDirtyFlag = false;
    private boolean psunitidDirtyFlag = false;
    private boolean psunitnameDirtyFlag = false;
    private boolean psvalueruleidDirtyFlag = false;
    private boolean psvaluerulenameDirtyFlag = false;
    private boolean pyformatDirtyFlag = false;
    private boolean searcheditorheightDirtyFlag = false;
    private boolean searcheditortypeDirtyFlag = false;
    private boolean searcheditorwidthDirtyFlag = false;
    private boolean searchmbeditorheightDirtyFlag = false;
    private boolean searchmbeditortypeDirtyFlag = false;
    private boolean searchmbeditorwidthDirtyFlag = false;
    private boolean searchmodeobjDirtyFlag = false;
    private boolean sfitemobjDirtyFlag = false;
    private boolean stddatatypeDirtyFlag = false;
    private boolean strlengthDirtyFlag = false;
    private boolean testdataDirtyFlag = false;
    private boolean tsformatDirtyFlag = false;
    private boolean uimodeobjDirtyFlag = false;
    private boolean unsignedflagDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="datatypes")
    private String datatypes;
    @Column(name="dotnetformat")
    private String dotnetformat;
    @Column(name="editorheight")
    private Integer editorheight;
    @Column(name="editortype")
    private String editortype;
    @Column(name="editorwidth")
    private Integer editorwidth;
    @Column(name="fields")
    private String fields;
    @Column(name="formitemobj")
    private String formitemobj;
    @Column(name="gridcolalign")
    private String gridcolalign;
    @Column(name="gridcolclmode")
    private String gridcolclmode;
    @Column(name="gridcolobj")
    private String gridcolobj;
    @Column(name="gridcolwidth")
    private Integer gridcolwidth;
    @Column(name="iconpath")
    private String iconpath;
    @Column(name="incrementflag")
    private Integer incrementflag;
    @Column(name="javaformat")
    private String javaformat;
    @Column(name="jsformat")
    private String jsformat;
    @Column(name="maxvaluestr")
    private String maxvaluestr;
    @Column(name="mbeditorheight")
    private Integer mbeditorheight;
    @Column(name="mbeditortype")
    private String mbeditortype;
    @Column(name="mbeditorwidth")
    private Integer mbeditorwidth;
    @Column(name="memo")
    private String memo;
    @Column(name="minstrlength")
    private Integer minstrlength;
    @Column(name="minvaluestr")
    private String minvaluestr;
    @Column(name="objhelper")
    private String objhelper;
    @Column(name="objhelper2")
    private String objhelper2;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="precision2")
    private Integer precision2;
    @Column(name="pscodelisttemplid")
    private String pscodelisttemplid;
    @Column(name="pscodelisttemplname")
    private String pscodelisttemplname;
    @Column(name="psdeftypeid")
    private String psdeftypeid;
    @Column(name="psdeftypename")
    private String psdeftypename;
    @Column(name="psunitid")
    private String psunitid;
    @Column(name="psunitname")
    private String psunitname;
    @Column(name="psvalueruleid")
    private String psvalueruleid;
    @Column(name="psvaluerulename")
    private String psvaluerulename;
    @Column(name="pyformat")
    private String pyformat;
    @Column(name="searcheditorheight")
    private Integer searcheditorheight;
    @Column(name="searcheditortype")
    private String searcheditortype;
    @Column(name="searcheditorwidth")
    private Integer searcheditorwidth;
    @Column(name="searchmbeditorheight")
    private Integer searchmbeditorheight;
    @Column(name="searchmbeditortype")
    private String searchmbeditortype;
    @Column(name="searchmbeditorwidth")
    private Integer searchmbeditorwidth;
    @Column(name="searchmodeobj")
    private String searchmodeobj;
    @Column(name="sfitemobj")
    private String sfitemobj;
    @Column(name="stddatatype")
    private Integer stddatatype;
    @Column(name="strlength")
    private Integer strlength;
    @Column(name="testdata")
    private String testdata;
    @Column(name="tsformat")
    private String tsformat;
    @Column(name="uimodeobj")
    private String uimodeobj;
    @Column(name="unsignedflag")
    private Integer unsignedflag;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSCodeListTemplLock = new Integer(1);
    private PSCodeListTempl pscodelisttempl = null;
    private Integer objPSUnitLock = new Integer(1);
    private PSUnit psunit = null;
    private Integer objPSValueRuleLock = new Integer(1);
    private PSValueRule psvaluerule = null;

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

    public void setDataTypes(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataTypes(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.datatypes = string;
        this.datatypesDirtyFlag = true;
    }

    public String getDataTypes() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataTypes();
        }
        return this.datatypes;
    }

    public boolean isDataTypesDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataTypesDirty();
        }
        return this.datatypesDirtyFlag;
    }

    public void resetDataTypes() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataTypes();
            return;
        }
        this.datatypesDirtyFlag = false;
        this.datatypes = null;
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

    public void setEditorHeight(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEditorHeight(n);
            return;
        }
        this.editorheight = n;
        this.editorheightDirtyFlag = true;
    }

    public Integer getEditorHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEditorHeight();
        }
        return this.editorheight;
    }

    public boolean isEditorHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEditorHeightDirty();
        }
        return this.editorheightDirtyFlag;
    }

    public void resetEditorHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEditorHeight();
            return;
        }
        this.editorheightDirtyFlag = false;
        this.editorheight = null;
    }

    public void setEditorType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEditorType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.editortype = string;
        this.editortypeDirtyFlag = true;
    }

    public String getEditorType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEditorType();
        }
        return this.editortype;
    }

    public boolean isEditorTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEditorTypeDirty();
        }
        return this.editortypeDirtyFlag;
    }

    public void resetEditorType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEditorType();
            return;
        }
        this.editortypeDirtyFlag = false;
        this.editortype = null;
    }

    public void setEditorWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEditorWidth(n);
            return;
        }
        this.editorwidth = n;
        this.editorwidthDirtyFlag = true;
    }

    public Integer getEditorWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEditorWidth();
        }
        return this.editorwidth;
    }

    public boolean isEditorWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEditorWidthDirty();
        }
        return this.editorwidthDirtyFlag;
    }

    public void resetEditorWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEditorWidth();
            return;
        }
        this.editorwidthDirtyFlag = false;
        this.editorwidth = null;
    }

    public void setFields(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFields(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fields = string;
        this.fieldsDirtyFlag = true;
    }

    public String getFields() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFields();
        }
        return this.fields;
    }

    public boolean isFieldsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFieldsDirty();
        }
        return this.fieldsDirtyFlag;
    }

    public void resetFields() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFields();
            return;
        }
        this.fieldsDirtyFlag = false;
        this.fields = null;
    }

    public void setFormItemObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFormItemObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.formitemobj = string;
        this.formitemobjDirtyFlag = true;
    }

    public String getFormItemObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormItemObj();
        }
        return this.formitemobj;
    }

    public boolean isFormItemObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFormItemObjDirty();
        }
        return this.formitemobjDirtyFlag;
    }

    public void resetFormItemObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFormItemObj();
            return;
        }
        this.formitemobjDirtyFlag = false;
        this.formitemobj = null;
    }

    public void setGridColAlign(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGridColAlign(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gridcolalign = string;
        this.gridcolalignDirtyFlag = true;
    }

    public String getGridColAlign() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGridColAlign();
        }
        return this.gridcolalign;
    }

    public boolean isGridColAlignDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGridColAlignDirty();
        }
        return this.gridcolalignDirtyFlag;
    }

    public void resetGridColAlign() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGridColAlign();
            return;
        }
        this.gridcolalignDirtyFlag = false;
        this.gridcolalign = null;
    }

    public void setGridColCLMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGridColCLMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gridcolclmode = string;
        this.gridcolclmodeDirtyFlag = true;
    }

    public String getGridColCLMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGridColCLMode();
        }
        return this.gridcolclmode;
    }

    public boolean isGridColCLModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGridColCLModeDirty();
        }
        return this.gridcolclmodeDirtyFlag;
    }

    public void resetGridColCLMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGridColCLMode();
            return;
        }
        this.gridcolclmodeDirtyFlag = false;
        this.gridcolclmode = null;
    }

    public void setGridColObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGridColObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gridcolobj = string;
        this.gridcolobjDirtyFlag = true;
    }

    public String getGridColObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGridColObj();
        }
        return this.gridcolobj;
    }

    public boolean isGridColObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGridColObjDirty();
        }
        return this.gridcolobjDirtyFlag;
    }

    public void resetGridColObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGridColObj();
            return;
        }
        this.gridcolobjDirtyFlag = false;
        this.gridcolobj = null;
    }

    public void setGridColWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGridColWidth(n);
            return;
        }
        this.gridcolwidth = n;
        this.gridcolwidthDirtyFlag = true;
    }

    public Integer getGridColWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGridColWidth();
        }
        return this.gridcolwidth;
    }

    public boolean isGridColWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGridColWidthDirty();
        }
        return this.gridcolwidthDirtyFlag;
    }

    public void resetGridColWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGridColWidth();
            return;
        }
        this.gridcolwidthDirtyFlag = false;
        this.gridcolwidth = null;
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

    public void setIncrementFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIncrementFlag(n);
            return;
        }
        this.incrementflag = n;
        this.incrementflagDirtyFlag = true;
    }

    public Integer getIncrementFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIncrementFlag();
        }
        return this.incrementflag;
    }

    public boolean isIncrementFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIncrementFlagDirty();
        }
        return this.incrementflagDirtyFlag;
    }

    public void resetIncrementFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIncrementFlag();
            return;
        }
        this.incrementflagDirtyFlag = false;
        this.incrementflag = null;
    }

    public void setJAVAFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJAVAFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.javaformat = string;
        this.javaformatDirtyFlag = true;
    }

    public String getJAVAFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJAVAFormat();
        }
        return this.javaformat;
    }

    public boolean isJAVAFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJAVAFormatDirty();
        }
        return this.javaformatDirtyFlag;
    }

    public void resetJAVAFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJAVAFormat();
            return;
        }
        this.javaformatDirtyFlag = false;
        this.javaformat = null;
    }

    public void setJSFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJSFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jsformat = string;
        this.jsformatDirtyFlag = true;
    }

    public String getJSFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJSFormat();
        }
        return this.jsformat;
    }

    public boolean isJSFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJSFormatDirty();
        }
        return this.jsformatDirtyFlag;
    }

    public void resetJSFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJSFormat();
            return;
        }
        this.jsformatDirtyFlag = false;
        this.jsformat = null;
    }

    public void setMaxValueStr(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxValueStr(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.maxvaluestr = string;
        this.maxvaluestrDirtyFlag = true;
    }

    public String getMaxValueStr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxValueStr();
        }
        return this.maxvaluestr;
    }

    public boolean isMaxValueStrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxValueStrDirty();
        }
        return this.maxvaluestrDirtyFlag;
    }

    public void resetMaxValueStr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxValueStr();
            return;
        }
        this.maxvaluestrDirtyFlag = false;
        this.maxvaluestr = null;
    }

    public void setMBEditorHeight(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMBEditorHeight(n);
            return;
        }
        this.mbeditorheight = n;
        this.mbeditorheightDirtyFlag = true;
    }

    public Integer getMBEditorHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMBEditorHeight();
        }
        return this.mbeditorheight;
    }

    public boolean isMBEditorHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMBEditorHeightDirty();
        }
        return this.mbeditorheightDirtyFlag;
    }

    public void resetMBEditorHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMBEditorHeight();
            return;
        }
        this.mbeditorheightDirtyFlag = false;
        this.mbeditorheight = null;
    }

    public void setMBEditorType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMBEditorType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mbeditortype = string;
        this.mbeditortypeDirtyFlag = true;
    }

    public String getMBEditorType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMBEditorType();
        }
        return this.mbeditortype;
    }

    public boolean isMBEditorTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMBEditorTypeDirty();
        }
        return this.mbeditortypeDirtyFlag;
    }

    public void resetMBEditorType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMBEditorType();
            return;
        }
        this.mbeditortypeDirtyFlag = false;
        this.mbeditortype = null;
    }

    public void setMBEditorWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMBEditorWidth(n);
            return;
        }
        this.mbeditorwidth = n;
        this.mbeditorwidthDirtyFlag = true;
    }

    public Integer getMBEditorWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMBEditorWidth();
        }
        return this.mbeditorwidth;
    }

    public boolean isMBEditorWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMBEditorWidthDirty();
        }
        return this.mbeditorwidthDirtyFlag;
    }

    public void resetMBEditorWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMBEditorWidth();
            return;
        }
        this.mbeditorwidthDirtyFlag = false;
        this.mbeditorwidth = null;
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

    public void setMinStrLength(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinStrLength(n);
            return;
        }
        this.minstrlength = n;
        this.minstrlengthDirtyFlag = true;
    }

    public Integer getMinStrLength() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinStrLength();
        }
        return this.minstrlength;
    }

    public boolean isMinStrLengthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinStrLengthDirty();
        }
        return this.minstrlengthDirtyFlag;
    }

    public void resetMinStrLength() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinStrLength();
            return;
        }
        this.minstrlengthDirtyFlag = false;
        this.minstrlength = null;
    }

    public void setMinValueStr(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinValueStr(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minvaluestr = string;
        this.minvaluestrDirtyFlag = true;
    }

    public String getMinValueStr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinValueStr();
        }
        return this.minvaluestr;
    }

    public boolean isMinValueStrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinValueStrDirty();
        }
        return this.minvaluestrDirtyFlag;
    }

    public void resetMinValueStr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinValueStr();
            return;
        }
        this.minvaluestrDirtyFlag = false;
        this.minvaluestr = null;
    }

    public void setObjHelper(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setObjHelper(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.objhelper = string;
        this.objhelperDirtyFlag = true;
    }

    public String getObjHelper() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getObjHelper();
        }
        return this.objhelper;
    }

    public boolean isObjHelperDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isObjHelperDirty();
        }
        return this.objhelperDirtyFlag;
    }

    public void resetObjHelper() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetObjHelper();
            return;
        }
        this.objhelperDirtyFlag = false;
        this.objhelper = null;
    }

    public void setObjHelper2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setObjHelper2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.objhelper2 = string;
        this.objhelper2DirtyFlag = true;
    }

    public String getObjHelper2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getObjHelper2();
        }
        return this.objhelper2;
    }

    public boolean isObjHelper2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isObjHelper2Dirty();
        }
        return this.objhelper2DirtyFlag;
    }

    public void resetObjHelper2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetObjHelper2();
            return;
        }
        this.objhelper2DirtyFlag = false;
        this.objhelper2 = null;
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

    public void setPrecision2(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrecision2(n);
            return;
        }
        this.precision2 = n;
        this.precision2DirtyFlag = true;
    }

    public Integer getPrecision2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrecision2();
        }
        return this.precision2;
    }

    public boolean isPrecision2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrecision2Dirty();
        }
        return this.precision2DirtyFlag;
    }

    public void resetPrecision2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrecision2();
            return;
        }
        this.precision2DirtyFlag = false;
        this.precision2 = null;
    }

    public void setPSCodeListTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodelisttemplid = string;
        this.pscodelisttemplidDirtyFlag = true;
    }

    public String getPSCodeListTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListTemplId();
        }
        return this.pscodelisttemplid;
    }

    public boolean isPSCodeListTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListTemplIdDirty();
        }
        return this.pscodelisttemplidDirtyFlag;
    }

    public void resetPSCodeListTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListTemplId();
            return;
        }
        this.pscodelisttemplidDirtyFlag = false;
        this.pscodelisttemplid = null;
    }

    public void setPSCodeListTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodelisttemplname = string;
        this.pscodelisttemplnameDirtyFlag = true;
    }

    public String getPSCodeListTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListTemplName();
        }
        return this.pscodelisttemplname;
    }

    public boolean isPSCodeListTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListTemplNameDirty();
        }
        return this.pscodelisttemplnameDirtyFlag;
    }

    public void resetPSCodeListTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListTemplName();
            return;
        }
        this.pscodelisttemplnameDirtyFlag = false;
        this.pscodelisttemplname = null;
    }

    public void setPSDEFTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeftypeid = string;
        this.psdeftypeidDirtyFlag = true;
    }

    public String getPSDEFTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFTypeId();
        }
        return this.psdeftypeid;
    }

    public boolean isPSDEFTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFTypeIdDirty();
        }
        return this.psdeftypeidDirtyFlag;
    }

    public void resetPSDEFTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFTypeId();
            return;
        }
        this.psdeftypeidDirtyFlag = false;
        this.psdeftypeid = null;
    }

    public void setPSDEFTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeftypename = string;
        this.psdeftypenameDirtyFlag = true;
    }

    public String getPSDEFTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFTypeName();
        }
        return this.psdeftypename;
    }

    public boolean isPSDEFTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFTypeNameDirty();
        }
        return this.psdeftypenameDirtyFlag;
    }

    public void resetPSDEFTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFTypeName();
            return;
        }
        this.psdeftypenameDirtyFlag = false;
        this.psdeftypename = null;
    }

    public void setPSUnitId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUnitId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psunitid = string;
        this.psunitidDirtyFlag = true;
    }

    public String getPSUnitId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUnitId();
        }
        return this.psunitid;
    }

    public boolean isPSUnitIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUnitIdDirty();
        }
        return this.psunitidDirtyFlag;
    }

    public void resetPSUnitId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUnitId();
            return;
        }
        this.psunitidDirtyFlag = false;
        this.psunitid = null;
    }

    public void setPSUnitName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUnitName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psunitname = string;
        this.psunitnameDirtyFlag = true;
    }

    public String getPSUnitName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUnitName();
        }
        return this.psunitname;
    }

    public boolean isPSUnitNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUnitNameDirty();
        }
        return this.psunitnameDirtyFlag;
    }

    public void resetPSUnitName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUnitName();
            return;
        }
        this.psunitnameDirtyFlag = false;
        this.psunitname = null;
    }

    public void setPSValueRuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSValueRuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psvalueruleid = string;
        this.psvalueruleidDirtyFlag = true;
    }

    public String getPSValueRuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSValueRuleId();
        }
        return this.psvalueruleid;
    }

    public boolean isPSValueRuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSValueRuleIdDirty();
        }
        return this.psvalueruleidDirtyFlag;
    }

    public void resetPSValueRuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSValueRuleId();
            return;
        }
        this.psvalueruleidDirtyFlag = false;
        this.psvalueruleid = null;
    }

    public void setPSValueRuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSValueRuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psvaluerulename = string;
        this.psvaluerulenameDirtyFlag = true;
    }

    public String getPSValueRuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSValueRuleName();
        }
        return this.psvaluerulename;
    }

    public boolean isPSValueRuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSValueRuleNameDirty();
        }
        return this.psvaluerulenameDirtyFlag;
    }

    public void resetPSValueRuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSValueRuleName();
            return;
        }
        this.psvaluerulenameDirtyFlag = false;
        this.psvaluerulename = null;
    }

    public void setPYFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPYFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pyformat = string;
        this.pyformatDirtyFlag = true;
    }

    public String getPYFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPYFormat();
        }
        return this.pyformat;
    }

    public boolean isPYFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPYFormatDirty();
        }
        return this.pyformatDirtyFlag;
    }

    public void resetPYFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPYFormat();
            return;
        }
        this.pyformatDirtyFlag = false;
        this.pyformat = null;
    }

    public void setSearchEditorHeight(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSearchEditorHeight(n);
            return;
        }
        this.searcheditorheight = n;
        this.searcheditorheightDirtyFlag = true;
    }

    public Integer getSearchEditorHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSearchEditorHeight();
        }
        return this.searcheditorheight;
    }

    public boolean isSearchEditorHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSearchEditorHeightDirty();
        }
        return this.searcheditorheightDirtyFlag;
    }

    public void resetSearchEditorHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSearchEditorHeight();
            return;
        }
        this.searcheditorheightDirtyFlag = false;
        this.searcheditorheight = null;
    }

    public void setSearchEditorType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSearchEditorType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.searcheditortype = string;
        this.searcheditortypeDirtyFlag = true;
    }

    public String getSearchEditorType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSearchEditorType();
        }
        return this.searcheditortype;
    }

    public boolean isSearchEditorTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSearchEditorTypeDirty();
        }
        return this.searcheditortypeDirtyFlag;
    }

    public void resetSearchEditorType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSearchEditorType();
            return;
        }
        this.searcheditortypeDirtyFlag = false;
        this.searcheditortype = null;
    }

    public void setSearchEditorWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSearchEditorWidth(n);
            return;
        }
        this.searcheditorwidth = n;
        this.searcheditorwidthDirtyFlag = true;
    }

    public Integer getSearchEditorWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSearchEditorWidth();
        }
        return this.searcheditorwidth;
    }

    public boolean isSearchEditorWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSearchEditorWidthDirty();
        }
        return this.searcheditorwidthDirtyFlag;
    }

    public void resetSearchEditorWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSearchEditorWidth();
            return;
        }
        this.searcheditorwidthDirtyFlag = false;
        this.searcheditorwidth = null;
    }

    public void setSearchMBEditorHeight(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSearchMBEditorHeight(n);
            return;
        }
        this.searchmbeditorheight = n;
        this.searchmbeditorheightDirtyFlag = true;
    }

    public Integer getSearchMBEditorHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSearchMBEditorHeight();
        }
        return this.searchmbeditorheight;
    }

    public boolean isSearchMBEditorHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSearchMBEditorHeightDirty();
        }
        return this.searchmbeditorheightDirtyFlag;
    }

    public void resetSearchMBEditorHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSearchMBEditorHeight();
            return;
        }
        this.searchmbeditorheightDirtyFlag = false;
        this.searchmbeditorheight = null;
    }

    public void setSearchMBEditorType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSearchMBEditorType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.searchmbeditortype = string;
        this.searchmbeditortypeDirtyFlag = true;
    }

    public String getSearchMBEditorType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSearchMBEditorType();
        }
        return this.searchmbeditortype;
    }

    public boolean isSearchMBEditorTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSearchMBEditorTypeDirty();
        }
        return this.searchmbeditortypeDirtyFlag;
    }

    public void resetSearchMBEditorType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSearchMBEditorType();
            return;
        }
        this.searchmbeditortypeDirtyFlag = false;
        this.searchmbeditortype = null;
    }

    public void setSearchMBEditorWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSearchMBEditorWidth(n);
            return;
        }
        this.searchmbeditorwidth = n;
        this.searchmbeditorwidthDirtyFlag = true;
    }

    public Integer getSearchMBEditorWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSearchMBEditorWidth();
        }
        return this.searchmbeditorwidth;
    }

    public boolean isSearchMBEditorWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSearchMBEditorWidthDirty();
        }
        return this.searchmbeditorwidthDirtyFlag;
    }

    public void resetSearchMBEditorWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSearchMBEditorWidth();
            return;
        }
        this.searchmbeditorwidthDirtyFlag = false;
        this.searchmbeditorwidth = null;
    }

    public void setSearchModeObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSearchModeObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.searchmodeobj = string;
        this.searchmodeobjDirtyFlag = true;
    }

    public String getSearchModeObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSearchModeObj();
        }
        return this.searchmodeobj;
    }

    public boolean isSearchModeObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSearchModeObjDirty();
        }
        return this.searchmodeobjDirtyFlag;
    }

    public void resetSearchModeObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSearchModeObj();
            return;
        }
        this.searchmodeobjDirtyFlag = false;
        this.searchmodeobj = null;
    }

    public void setSFItemObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSFItemObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sfitemobj = string;
        this.sfitemobjDirtyFlag = true;
    }

    public String getSFItemObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSFItemObj();
        }
        return this.sfitemobj;
    }

    public boolean isSFItemObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSFItemObjDirty();
        }
        return this.sfitemobjDirtyFlag;
    }

    public void resetSFItemObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSFItemObj();
            return;
        }
        this.sfitemobjDirtyFlag = false;
        this.sfitemobj = null;
    }

    public void setStdDataType(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStdDataType(n);
            return;
        }
        this.stddatatype = n;
        this.stddatatypeDirtyFlag = true;
    }

    public Integer getStdDataType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStdDataType();
        }
        return this.stddatatype;
    }

    public boolean isStdDataTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStdDataTypeDirty();
        }
        return this.stddatatypeDirtyFlag;
    }

    public void resetStdDataType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStdDataType();
            return;
        }
        this.stddatatypeDirtyFlag = false;
        this.stddatatype = null;
    }

    public void setStrLength(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStrLength(n);
            return;
        }
        this.strlength = n;
        this.strlengthDirtyFlag = true;
    }

    public Integer getStrLength() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStrLength();
        }
        return this.strlength;
    }

    public boolean isStrLengthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStrLengthDirty();
        }
        return this.strlengthDirtyFlag;
    }

    public void resetStrLength() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStrLength();
            return;
        }
        this.strlengthDirtyFlag = false;
        this.strlength = null;
    }

    public void setTestData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTestData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.testdata = string;
        this.testdataDirtyFlag = true;
    }

    public String getTestData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTestData();
        }
        return this.testdata;
    }

    public boolean isTestDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTestDataDirty();
        }
        return this.testdataDirtyFlag;
    }

    public void resetTestData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTestData();
            return;
        }
        this.testdataDirtyFlag = false;
        this.testdata = null;
    }

    public void setTSFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tsformat = string;
        this.tsformatDirtyFlag = true;
    }

    public String getTSFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSFormat();
        }
        return this.tsformat;
    }

    public boolean isTSFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSFormatDirty();
        }
        return this.tsformatDirtyFlag;
    }

    public void resetTSFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSFormat();
            return;
        }
        this.tsformatDirtyFlag = false;
        this.tsformat = null;
    }

    public void setUIModeObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUIModeObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uimodeobj = string;
        this.uimodeobjDirtyFlag = true;
    }

    public String getUIModeObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUIModeObj();
        }
        return this.uimodeobj;
    }

    public boolean isUIModeObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUIModeObjDirty();
        }
        return this.uimodeobjDirtyFlag;
    }

    public void resetUIModeObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUIModeObj();
            return;
        }
        this.uimodeobjDirtyFlag = false;
        this.uimodeobj = null;
    }

    public void setUnsignedFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUnsignedFlag(n);
            return;
        }
        this.unsignedflag = n;
        this.unsignedflagDirtyFlag = true;
    }

    public Integer getUnsignedFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUnsignedFlag();
        }
        return this.unsignedflag;
    }

    public boolean isUnsignedFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUnsignedFlagDirty();
        }
        return this.unsignedflagDirtyFlag;
    }

    public void resetUnsignedFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUnsignedFlag();
            return;
        }
        this.unsignedflagDirtyFlag = false;
        this.unsignedflag = null;
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

    protected void onReset() {
        PSDEFTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEFTypeBase pSDEFTypeBase) {
        pSDEFTypeBase.resetCreateDate();
        pSDEFTypeBase.resetCreateMan();
        pSDEFTypeBase.resetDataTypes();
        pSDEFTypeBase.resetDotNETFormat();
        pSDEFTypeBase.resetEditorHeight();
        pSDEFTypeBase.resetEditorType();
        pSDEFTypeBase.resetEditorWidth();
        pSDEFTypeBase.resetFields();
        pSDEFTypeBase.resetFormItemObj();
        pSDEFTypeBase.resetGridColAlign();
        pSDEFTypeBase.resetGridColCLMode();
        pSDEFTypeBase.resetGridColObj();
        pSDEFTypeBase.resetGridColWidth();
        pSDEFTypeBase.resetIconPath();
        pSDEFTypeBase.resetIncrementFlag();
        pSDEFTypeBase.resetJAVAFormat();
        pSDEFTypeBase.resetJSFormat();
        pSDEFTypeBase.resetMaxValueStr();
        pSDEFTypeBase.resetMBEditorHeight();
        pSDEFTypeBase.resetMBEditorType();
        pSDEFTypeBase.resetMBEditorWidth();
        pSDEFTypeBase.resetMemo();
        pSDEFTypeBase.resetMinStrLength();
        pSDEFTypeBase.resetMinValueStr();
        pSDEFTypeBase.resetObjHelper();
        pSDEFTypeBase.resetObjHelper2();
        pSDEFTypeBase.resetOrderValue();
        pSDEFTypeBase.resetPrecision2();
        pSDEFTypeBase.resetPSCodeListTemplId();
        pSDEFTypeBase.resetPSCodeListTemplName();
        pSDEFTypeBase.resetPSDEFTypeId();
        pSDEFTypeBase.resetPSDEFTypeName();
        pSDEFTypeBase.resetPSUnitId();
        pSDEFTypeBase.resetPSUnitName();
        pSDEFTypeBase.resetPSValueRuleId();
        pSDEFTypeBase.resetPSValueRuleName();
        pSDEFTypeBase.resetPYFormat();
        pSDEFTypeBase.resetSearchEditorHeight();
        pSDEFTypeBase.resetSearchEditorType();
        pSDEFTypeBase.resetSearchEditorWidth();
        pSDEFTypeBase.resetSearchMBEditorHeight();
        pSDEFTypeBase.resetSearchMBEditorType();
        pSDEFTypeBase.resetSearchMBEditorWidth();
        pSDEFTypeBase.resetSearchModeObj();
        pSDEFTypeBase.resetSFItemObj();
        pSDEFTypeBase.resetStdDataType();
        pSDEFTypeBase.resetStrLength();
        pSDEFTypeBase.resetTestData();
        pSDEFTypeBase.resetTSFormat();
        pSDEFTypeBase.resetUIModeObj();
        pSDEFTypeBase.resetUnsignedFlag();
        pSDEFTypeBase.resetUpdateDate();
        pSDEFTypeBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDataTypesDirty()) {
            hashMap.put(FIELD_DATATYPES, this.getDataTypes());
        }
        if (!bl || this.isDotNETFormatDirty()) {
            hashMap.put(FIELD_DOTNETFORMAT, this.getDotNETFormat());
        }
        if (!bl || this.isEditorHeightDirty()) {
            hashMap.put(FIELD_EDITORHEIGHT, this.getEditorHeight());
        }
        if (!bl || this.isEditorTypeDirty()) {
            hashMap.put(FIELD_EDITORTYPE, this.getEditorType());
        }
        if (!bl || this.isEditorWidthDirty()) {
            hashMap.put(FIELD_EDITORWIDTH, this.getEditorWidth());
        }
        if (!bl || this.isFieldsDirty()) {
            hashMap.put(FIELD_FIELDS, this.getFields());
        }
        if (!bl || this.isFormItemObjDirty()) {
            hashMap.put(FIELD_FORMITEMOBJ, this.getFormItemObj());
        }
        if (!bl || this.isGridColAlignDirty()) {
            hashMap.put(FIELD_GRIDCOLALIGN, this.getGridColAlign());
        }
        if (!bl || this.isGridColCLModeDirty()) {
            hashMap.put(FIELD_GRIDCOLCLMODE, this.getGridColCLMode());
        }
        if (!bl || this.isGridColObjDirty()) {
            hashMap.put(FIELD_GRIDCOLOBJ, this.getGridColObj());
        }
        if (!bl || this.isGridColWidthDirty()) {
            hashMap.put(FIELD_GRIDCOLWIDTH, this.getGridColWidth());
        }
        if (!bl || this.isIconPathDirty()) {
            hashMap.put(FIELD_ICONPATH, this.getIconPath());
        }
        if (!bl || this.isIncrementFlagDirty()) {
            hashMap.put(FIELD_INCREMENTFLAG, this.getIncrementFlag());
        }
        if (!bl || this.isJAVAFormatDirty()) {
            hashMap.put(FIELD_JAVAFORMAT, this.getJAVAFormat());
        }
        if (!bl || this.isJSFormatDirty()) {
            hashMap.put(FIELD_JSFORMAT, this.getJSFormat());
        }
        if (!bl || this.isMaxValueStrDirty()) {
            hashMap.put(FIELD_MAXVALUESTR, this.getMaxValueStr());
        }
        if (!bl || this.isMBEditorHeightDirty()) {
            hashMap.put(FIELD_MBEDITORHEIGHT, this.getMBEditorHeight());
        }
        if (!bl || this.isMBEditorTypeDirty()) {
            hashMap.put(FIELD_MBEDITORTYPE, this.getMBEditorType());
        }
        if (!bl || this.isMBEditorWidthDirty()) {
            hashMap.put(FIELD_MBEDITORWIDTH, this.getMBEditorWidth());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMinStrLengthDirty()) {
            hashMap.put(FIELD_MINSTRLENGTH, this.getMinStrLength());
        }
        if (!bl || this.isMinValueStrDirty()) {
            hashMap.put(FIELD_MINVALUESTR, this.getMinValueStr());
        }
        if (!bl || this.isObjHelperDirty()) {
            hashMap.put(FIELD_OBJHELPER, this.getObjHelper());
        }
        if (!bl || this.isObjHelper2Dirty()) {
            hashMap.put(FIELD_OBJHELPER2, this.getObjHelper2());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPrecision2Dirty()) {
            hashMap.put(FIELD_PRECISION2, this.getPrecision2());
        }
        if (!bl || this.isPSCodeListTemplIdDirty()) {
            hashMap.put(FIELD_PSCODELISTTEMPLID, this.getPSCodeListTemplId());
        }
        if (!bl || this.isPSCodeListTemplNameDirty()) {
            hashMap.put(FIELD_PSCODELISTTEMPLNAME, this.getPSCodeListTemplName());
        }
        if (!bl || this.isPSDEFTypeIdDirty()) {
            hashMap.put(FIELD_PSDEFTYPEID, this.getPSDEFTypeId());
        }
        if (!bl || this.isPSDEFTypeNameDirty()) {
            hashMap.put(FIELD_PSDEFTYPENAME, this.getPSDEFTypeName());
        }
        if (!bl || this.isPSUnitIdDirty()) {
            hashMap.put(FIELD_PSUNITID, this.getPSUnitId());
        }
        if (!bl || this.isPSUnitNameDirty()) {
            hashMap.put(FIELD_PSUNITNAME, this.getPSUnitName());
        }
        if (!bl || this.isPSValueRuleIdDirty()) {
            hashMap.put(FIELD_PSVALUERULEID, this.getPSValueRuleId());
        }
        if (!bl || this.isPSValueRuleNameDirty()) {
            hashMap.put(FIELD_PSVALUERULENAME, this.getPSValueRuleName());
        }
        if (!bl || this.isPYFormatDirty()) {
            hashMap.put(FIELD_PYFORMAT, this.getPYFormat());
        }
        if (!bl || this.isSearchEditorHeightDirty()) {
            hashMap.put(FIELD_SEARCHEDITORHEIGHT, this.getSearchEditorHeight());
        }
        if (!bl || this.isSearchEditorTypeDirty()) {
            hashMap.put(FIELD_SEARCHEDITORTYPE, this.getSearchEditorType());
        }
        if (!bl || this.isSearchEditorWidthDirty()) {
            hashMap.put(FIELD_SEARCHEDITORWIDTH, this.getSearchEditorWidth());
        }
        if (!bl || this.isSearchMBEditorHeightDirty()) {
            hashMap.put(FIELD_SEARCHMBEDITORHEIGHT, this.getSearchMBEditorHeight());
        }
        if (!bl || this.isSearchMBEditorTypeDirty()) {
            hashMap.put(FIELD_SEARCHMBEDITORTYPE, this.getSearchMBEditorType());
        }
        if (!bl || this.isSearchMBEditorWidthDirty()) {
            hashMap.put(FIELD_SEARCHMBEDITORWIDTH, this.getSearchMBEditorWidth());
        }
        if (!bl || this.isSearchModeObjDirty()) {
            hashMap.put(FIELD_SEARCHMODEOBJ, this.getSearchModeObj());
        }
        if (!bl || this.isSFItemObjDirty()) {
            hashMap.put(FIELD_SFITEMOBJ, this.getSFItemObj());
        }
        if (!bl || this.isStdDataTypeDirty()) {
            hashMap.put(FIELD_STDDATATYPE, this.getStdDataType());
        }
        if (!bl || this.isStrLengthDirty()) {
            hashMap.put(FIELD_STRLENGTH, this.getStrLength());
        }
        if (!bl || this.isTestDataDirty()) {
            hashMap.put(FIELD_TESTDATA, this.getTestData());
        }
        if (!bl || this.isTSFormatDirty()) {
            hashMap.put(FIELD_TSFORMAT, this.getTSFormat());
        }
        if (!bl || this.isUIModeObjDirty()) {
            hashMap.put(FIELD_UIMODEOBJ, this.getUIModeObj());
        }
        if (!bl || this.isUnsignedFlagDirty()) {
            hashMap.put(FIELD_UNSIGNEDFLAG, this.getUnsignedFlag());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSDEFTypeBase.get(this, n);
    }

    private static Object get(PSDEFTypeBase pSDEFTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFTypeBase.getCreateDate();
            }
            case 1: {
                return pSDEFTypeBase.getCreateMan();
            }
            case 2: {
                return pSDEFTypeBase.getDataTypes();
            }
            case 3: {
                return pSDEFTypeBase.getDotNETFormat();
            }
            case 4: {
                return pSDEFTypeBase.getEditorHeight();
            }
            case 5: {
                return pSDEFTypeBase.getEditorType();
            }
            case 6: {
                return pSDEFTypeBase.getEditorWidth();
            }
            case 7: {
                return pSDEFTypeBase.getFields();
            }
            case 8: {
                return pSDEFTypeBase.getFormItemObj();
            }
            case 9: {
                return pSDEFTypeBase.getGridColAlign();
            }
            case 10: {
                return pSDEFTypeBase.getGridColCLMode();
            }
            case 11: {
                return pSDEFTypeBase.getGridColObj();
            }
            case 12: {
                return pSDEFTypeBase.getGridColWidth();
            }
            case 13: {
                return pSDEFTypeBase.getIconPath();
            }
            case 14: {
                return pSDEFTypeBase.getIncrementFlag();
            }
            case 15: {
                return pSDEFTypeBase.getJAVAFormat();
            }
            case 16: {
                return pSDEFTypeBase.getJSFormat();
            }
            case 17: {
                return pSDEFTypeBase.getMaxValueStr();
            }
            case 18: {
                return pSDEFTypeBase.getMBEditorHeight();
            }
            case 19: {
                return pSDEFTypeBase.getMBEditorType();
            }
            case 20: {
                return pSDEFTypeBase.getMBEditorWidth();
            }
            case 21: {
                return pSDEFTypeBase.getMemo();
            }
            case 22: {
                return pSDEFTypeBase.getMinStrLength();
            }
            case 23: {
                return pSDEFTypeBase.getMinValueStr();
            }
            case 24: {
                return pSDEFTypeBase.getObjHelper();
            }
            case 25: {
                return pSDEFTypeBase.getObjHelper2();
            }
            case 26: {
                return pSDEFTypeBase.getOrderValue();
            }
            case 27: {
                return pSDEFTypeBase.getPrecision2();
            }
            case 28: {
                return pSDEFTypeBase.getPSCodeListTemplId();
            }
            case 29: {
                return pSDEFTypeBase.getPSCodeListTemplName();
            }
            case 30: {
                return pSDEFTypeBase.getPSDEFTypeId();
            }
            case 31: {
                return pSDEFTypeBase.getPSDEFTypeName();
            }
            case 32: {
                return pSDEFTypeBase.getPSUnitId();
            }
            case 33: {
                return pSDEFTypeBase.getPSUnitName();
            }
            case 34: {
                return pSDEFTypeBase.getPSValueRuleId();
            }
            case 35: {
                return pSDEFTypeBase.getPSValueRuleName();
            }
            case 36: {
                return pSDEFTypeBase.getPYFormat();
            }
            case 37: {
                return pSDEFTypeBase.getSearchEditorHeight();
            }
            case 38: {
                return pSDEFTypeBase.getSearchEditorType();
            }
            case 39: {
                return pSDEFTypeBase.getSearchEditorWidth();
            }
            case 40: {
                return pSDEFTypeBase.getSearchMBEditorHeight();
            }
            case 41: {
                return pSDEFTypeBase.getSearchMBEditorType();
            }
            case 42: {
                return pSDEFTypeBase.getSearchMBEditorWidth();
            }
            case 43: {
                return pSDEFTypeBase.getSearchModeObj();
            }
            case 44: {
                return pSDEFTypeBase.getSFItemObj();
            }
            case 45: {
                return pSDEFTypeBase.getStdDataType();
            }
            case 46: {
                return pSDEFTypeBase.getStrLength();
            }
            case 47: {
                return pSDEFTypeBase.getTestData();
            }
            case 48: {
                return pSDEFTypeBase.getTSFormat();
            }
            case 49: {
                return pSDEFTypeBase.getUIModeObj();
            }
            case 50: {
                return pSDEFTypeBase.getUnsignedFlag();
            }
            case 51: {
                return pSDEFTypeBase.getUpdateDate();
            }
            case 52: {
                return pSDEFTypeBase.getUpdateMan();
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
        PSDEFTypeBase.set(this, n, object);
    }

    private static void set(PSDEFTypeBase pSDEFTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEFTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEFTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEFTypeBase.setDataTypes(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEFTypeBase.setDotNETFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEFTypeBase.setEditorHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDEFTypeBase.setEditorType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEFTypeBase.setEditorWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDEFTypeBase.setFields(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEFTypeBase.setFormItemObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEFTypeBase.setGridColAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEFTypeBase.setGridColCLMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEFTypeBase.setGridColObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEFTypeBase.setGridColWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDEFTypeBase.setIconPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEFTypeBase.setIncrementFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDEFTypeBase.setJAVAFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEFTypeBase.setJSFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEFTypeBase.setMaxValueStr(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEFTypeBase.setMBEditorHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSDEFTypeBase.setMBEditorType(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEFTypeBase.setMBEditorWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSDEFTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEFTypeBase.setMinStrLength(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSDEFTypeBase.setMinValueStr(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEFTypeBase.setObjHelper(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEFTypeBase.setObjHelper2(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEFTypeBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSDEFTypeBase.setPrecision2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSDEFTypeBase.setPSCodeListTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEFTypeBase.setPSCodeListTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEFTypeBase.setPSDEFTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEFTypeBase.setPSDEFTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEFTypeBase.setPSUnitId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEFTypeBase.setPSUnitName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEFTypeBase.setPSValueRuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEFTypeBase.setPSValueRuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEFTypeBase.setPYFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEFTypeBase.setSearchEditorHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 38: {
                pSDEFTypeBase.setSearchEditorType(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEFTypeBase.setSearchEditorWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 40: {
                pSDEFTypeBase.setSearchMBEditorHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 41: {
                pSDEFTypeBase.setSearchMBEditorType(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEFTypeBase.setSearchMBEditorWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 43: {
                pSDEFTypeBase.setSearchModeObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDEFTypeBase.setSFItemObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDEFTypeBase.setStdDataType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 46: {
                pSDEFTypeBase.setStrLength(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 47: {
                pSDEFTypeBase.setTestData(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDEFTypeBase.setTSFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDEFTypeBase.setUIModeObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDEFTypeBase.setUnsignedFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 51: {
                pSDEFTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 52: {
                pSDEFTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDEFTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSDEFTypeBase pSDEFTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEFTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEFTypeBase.getDataTypes() == null;
            }
            case 3: {
                return pSDEFTypeBase.getDotNETFormat() == null;
            }
            case 4: {
                return pSDEFTypeBase.getEditorHeight() == null;
            }
            case 5: {
                return pSDEFTypeBase.getEditorType() == null;
            }
            case 6: {
                return pSDEFTypeBase.getEditorWidth() == null;
            }
            case 7: {
                return pSDEFTypeBase.getFields() == null;
            }
            case 8: {
                return pSDEFTypeBase.getFormItemObj() == null;
            }
            case 9: {
                return pSDEFTypeBase.getGridColAlign() == null;
            }
            case 10: {
                return pSDEFTypeBase.getGridColCLMode() == null;
            }
            case 11: {
                return pSDEFTypeBase.getGridColObj() == null;
            }
            case 12: {
                return pSDEFTypeBase.getGridColWidth() == null;
            }
            case 13: {
                return pSDEFTypeBase.getIconPath() == null;
            }
            case 14: {
                return pSDEFTypeBase.getIncrementFlag() == null;
            }
            case 15: {
                return pSDEFTypeBase.getJAVAFormat() == null;
            }
            case 16: {
                return pSDEFTypeBase.getJSFormat() == null;
            }
            case 17: {
                return pSDEFTypeBase.getMaxValueStr() == null;
            }
            case 18: {
                return pSDEFTypeBase.getMBEditorHeight() == null;
            }
            case 19: {
                return pSDEFTypeBase.getMBEditorType() == null;
            }
            case 20: {
                return pSDEFTypeBase.getMBEditorWidth() == null;
            }
            case 21: {
                return pSDEFTypeBase.getMemo() == null;
            }
            case 22: {
                return pSDEFTypeBase.getMinStrLength() == null;
            }
            case 23: {
                return pSDEFTypeBase.getMinValueStr() == null;
            }
            case 24: {
                return pSDEFTypeBase.getObjHelper() == null;
            }
            case 25: {
                return pSDEFTypeBase.getObjHelper2() == null;
            }
            case 26: {
                return pSDEFTypeBase.getOrderValue() == null;
            }
            case 27: {
                return pSDEFTypeBase.getPrecision2() == null;
            }
            case 28: {
                return pSDEFTypeBase.getPSCodeListTemplId() == null;
            }
            case 29: {
                return pSDEFTypeBase.getPSCodeListTemplName() == null;
            }
            case 30: {
                return pSDEFTypeBase.getPSDEFTypeId() == null;
            }
            case 31: {
                return pSDEFTypeBase.getPSDEFTypeName() == null;
            }
            case 32: {
                return pSDEFTypeBase.getPSUnitId() == null;
            }
            case 33: {
                return pSDEFTypeBase.getPSUnitName() == null;
            }
            case 34: {
                return pSDEFTypeBase.getPSValueRuleId() == null;
            }
            case 35: {
                return pSDEFTypeBase.getPSValueRuleName() == null;
            }
            case 36: {
                return pSDEFTypeBase.getPYFormat() == null;
            }
            case 37: {
                return pSDEFTypeBase.getSearchEditorHeight() == null;
            }
            case 38: {
                return pSDEFTypeBase.getSearchEditorType() == null;
            }
            case 39: {
                return pSDEFTypeBase.getSearchEditorWidth() == null;
            }
            case 40: {
                return pSDEFTypeBase.getSearchMBEditorHeight() == null;
            }
            case 41: {
                return pSDEFTypeBase.getSearchMBEditorType() == null;
            }
            case 42: {
                return pSDEFTypeBase.getSearchMBEditorWidth() == null;
            }
            case 43: {
                return pSDEFTypeBase.getSearchModeObj() == null;
            }
            case 44: {
                return pSDEFTypeBase.getSFItemObj() == null;
            }
            case 45: {
                return pSDEFTypeBase.getStdDataType() == null;
            }
            case 46: {
                return pSDEFTypeBase.getStrLength() == null;
            }
            case 47: {
                return pSDEFTypeBase.getTestData() == null;
            }
            case 48: {
                return pSDEFTypeBase.getTSFormat() == null;
            }
            case 49: {
                return pSDEFTypeBase.getUIModeObj() == null;
            }
            case 50: {
                return pSDEFTypeBase.getUnsignedFlag() == null;
            }
            case 51: {
                return pSDEFTypeBase.getUpdateDate() == null;
            }
            case 52: {
                return pSDEFTypeBase.getUpdateMan() == null;
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
        return PSDEFTypeBase.contains(this, n);
    }

    private static boolean contains(PSDEFTypeBase pSDEFTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEFTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSDEFTypeBase.isDataTypesDirty();
            }
            case 3: {
                return pSDEFTypeBase.isDotNETFormatDirty();
            }
            case 4: {
                return pSDEFTypeBase.isEditorHeightDirty();
            }
            case 5: {
                return pSDEFTypeBase.isEditorTypeDirty();
            }
            case 6: {
                return pSDEFTypeBase.isEditorWidthDirty();
            }
            case 7: {
                return pSDEFTypeBase.isFieldsDirty();
            }
            case 8: {
                return pSDEFTypeBase.isFormItemObjDirty();
            }
            case 9: {
                return pSDEFTypeBase.isGridColAlignDirty();
            }
            case 10: {
                return pSDEFTypeBase.isGridColCLModeDirty();
            }
            case 11: {
                return pSDEFTypeBase.isGridColObjDirty();
            }
            case 12: {
                return pSDEFTypeBase.isGridColWidthDirty();
            }
            case 13: {
                return pSDEFTypeBase.isIconPathDirty();
            }
            case 14: {
                return pSDEFTypeBase.isIncrementFlagDirty();
            }
            case 15: {
                return pSDEFTypeBase.isJAVAFormatDirty();
            }
            case 16: {
                return pSDEFTypeBase.isJSFormatDirty();
            }
            case 17: {
                return pSDEFTypeBase.isMaxValueStrDirty();
            }
            case 18: {
                return pSDEFTypeBase.isMBEditorHeightDirty();
            }
            case 19: {
                return pSDEFTypeBase.isMBEditorTypeDirty();
            }
            case 20: {
                return pSDEFTypeBase.isMBEditorWidthDirty();
            }
            case 21: {
                return pSDEFTypeBase.isMemoDirty();
            }
            case 22: {
                return pSDEFTypeBase.isMinStrLengthDirty();
            }
            case 23: {
                return pSDEFTypeBase.isMinValueStrDirty();
            }
            case 24: {
                return pSDEFTypeBase.isObjHelperDirty();
            }
            case 25: {
                return pSDEFTypeBase.isObjHelper2Dirty();
            }
            case 26: {
                return pSDEFTypeBase.isOrderValueDirty();
            }
            case 27: {
                return pSDEFTypeBase.isPrecision2Dirty();
            }
            case 28: {
                return pSDEFTypeBase.isPSCodeListTemplIdDirty();
            }
            case 29: {
                return pSDEFTypeBase.isPSCodeListTemplNameDirty();
            }
            case 30: {
                return pSDEFTypeBase.isPSDEFTypeIdDirty();
            }
            case 31: {
                return pSDEFTypeBase.isPSDEFTypeNameDirty();
            }
            case 32: {
                return pSDEFTypeBase.isPSUnitIdDirty();
            }
            case 33: {
                return pSDEFTypeBase.isPSUnitNameDirty();
            }
            case 34: {
                return pSDEFTypeBase.isPSValueRuleIdDirty();
            }
            case 35: {
                return pSDEFTypeBase.isPSValueRuleNameDirty();
            }
            case 36: {
                return pSDEFTypeBase.isPYFormatDirty();
            }
            case 37: {
                return pSDEFTypeBase.isSearchEditorHeightDirty();
            }
            case 38: {
                return pSDEFTypeBase.isSearchEditorTypeDirty();
            }
            case 39: {
                return pSDEFTypeBase.isSearchEditorWidthDirty();
            }
            case 40: {
                return pSDEFTypeBase.isSearchMBEditorHeightDirty();
            }
            case 41: {
                return pSDEFTypeBase.isSearchMBEditorTypeDirty();
            }
            case 42: {
                return pSDEFTypeBase.isSearchMBEditorWidthDirty();
            }
            case 43: {
                return pSDEFTypeBase.isSearchModeObjDirty();
            }
            case 44: {
                return pSDEFTypeBase.isSFItemObjDirty();
            }
            case 45: {
                return pSDEFTypeBase.isStdDataTypeDirty();
            }
            case 46: {
                return pSDEFTypeBase.isStrLengthDirty();
            }
            case 47: {
                return pSDEFTypeBase.isTestDataDirty();
            }
            case 48: {
                return pSDEFTypeBase.isTSFormatDirty();
            }
            case 49: {
                return pSDEFTypeBase.isUIModeObjDirty();
            }
            case 50: {
                return pSDEFTypeBase.isUnsignedFlagDirty();
            }
            case 51: {
                return pSDEFTypeBase.isUpdateDateDirty();
            }
            case 52: {
                return pSDEFTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEFTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEFTypeBase pSDEFTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEFTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getDataTypes() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datatypes", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getDataTypes()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getDotNETFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dotnetformat", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getDotNETFormat()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getEditorHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editorheight", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getEditorHeight()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getEditorType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editortype", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getEditorType()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getEditorWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editorwidth", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getEditorWidth()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getFields() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fields", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getFields()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getFormItemObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"formitemobj", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getFormItemObj()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getGridColAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gridcolalign", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getGridColAlign()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getGridColCLMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gridcolclmode", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getGridColCLMode()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getGridColObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gridcolobj", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getGridColObj()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getGridColWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gridcolwidth", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getGridColWidth()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getIconPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpath", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getIconPath()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getIncrementFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"incrementflag", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getIncrementFlag()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getJAVAFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"javaformat", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getJAVAFormat()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getJSFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jsformat", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getJSFormat()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getMaxValueStr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxvaluestr", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getMaxValueStr()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getMBEditorHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mbeditorheight", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getMBEditorHeight()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getMBEditorType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mbeditortype", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getMBEditorType()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getMBEditorWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mbeditorwidth", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getMBEditorWidth()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getMinStrLength() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minstrlength", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getMinStrLength()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getMinValueStr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minvaluestr", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getMinValueStr()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getObjHelper() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"objhelper", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getObjHelper()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getObjHelper2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"objhelper2", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getObjHelper2()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getPrecision2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"precision2", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getPrecision2()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getPSCodeListTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelisttemplid", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getPSCodeListTemplId()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getPSCodeListTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelisttemplname", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getPSCodeListTemplName()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getPSDEFTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeftypeid", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getPSDEFTypeId()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getPSDEFTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeftypename", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getPSDEFTypeName()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getPSUnitId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psunitid", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getPSUnitId()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getPSUnitName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psunitname", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getPSUnitName()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getPSValueRuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psvalueruleid", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getPSValueRuleId()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getPSValueRuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psvaluerulename", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getPSValueRuleName()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getPYFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pyformat", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getPYFormat()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getSearchEditorHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"searcheditorheight", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getSearchEditorHeight()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getSearchEditorType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"searcheditortype", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getSearchEditorType()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getSearchEditorWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"searcheditorwidth", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getSearchEditorWidth()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getSearchMBEditorHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"searchmbeditorheight", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getSearchMBEditorHeight()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getSearchMBEditorType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"searchmbeditortype", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getSearchMBEditorType()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getSearchMBEditorWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"searchmbeditorwidth", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getSearchMBEditorWidth()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getSearchModeObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"searchmodeobj", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getSearchModeObj()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getSFItemObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sfitemobj", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getSFItemObj()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getStdDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stddatatype", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getStdDataType()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getStrLength() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"strlength", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getStrLength()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getTestData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"testdata", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getTestData()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getTSFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tsformat", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getTSFormat()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getUIModeObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uimodeobj", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getUIModeObj()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getUnsignedFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"unsignedflag", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getUnsignedFlag()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEFTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEFTypeBase.getJSONValue((Object)pSDEFTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEFTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEFTypeBase pSDEFTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEFTypeBase.getCreateDate() != null) {
            object = pSDEFTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFTypeBase.getCreateMan() != null) {
            object = pSDEFTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getDataTypes() != null) {
            object = pSDEFTypeBase.getDataTypes();
            xmlNode.setAttribute(FIELD_DATATYPES, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getDotNETFormat() != null) {
            object = pSDEFTypeBase.getDotNETFormat();
            xmlNode.setAttribute(FIELD_DOTNETFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getEditorHeight() != null) {
            object = pSDEFTypeBase.getEditorHeight();
            xmlNode.setAttribute(FIELD_EDITORHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFTypeBase.getEditorType() != null) {
            object = pSDEFTypeBase.getEditorType();
            xmlNode.setAttribute(FIELD_EDITORTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getEditorWidth() != null) {
            object = pSDEFTypeBase.getEditorWidth();
            xmlNode.setAttribute(FIELD_EDITORWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFTypeBase.getFields() != null) {
            object = pSDEFTypeBase.getFields();
            xmlNode.setAttribute(FIELD_FIELDS, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getFormItemObj() != null) {
            object = pSDEFTypeBase.getFormItemObj();
            xmlNode.setAttribute(FIELD_FORMITEMOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getGridColAlign() != null) {
            object = pSDEFTypeBase.getGridColAlign();
            xmlNode.setAttribute(FIELD_GRIDCOLALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getGridColCLMode() != null) {
            object = pSDEFTypeBase.getGridColCLMode();
            xmlNode.setAttribute(FIELD_GRIDCOLCLMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getGridColObj() != null) {
            object = pSDEFTypeBase.getGridColObj();
            xmlNode.setAttribute(FIELD_GRIDCOLOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getGridColWidth() != null) {
            object = pSDEFTypeBase.getGridColWidth();
            xmlNode.setAttribute(FIELD_GRIDCOLWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFTypeBase.getIconPath() != null) {
            object = pSDEFTypeBase.getIconPath();
            xmlNode.setAttribute(FIELD_ICONPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getIncrementFlag() != null) {
            object = pSDEFTypeBase.getIncrementFlag();
            xmlNode.setAttribute(FIELD_INCREMENTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFTypeBase.getJAVAFormat() != null) {
            object = pSDEFTypeBase.getJAVAFormat();
            xmlNode.setAttribute(FIELD_JAVAFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getJSFormat() != null) {
            object = pSDEFTypeBase.getJSFormat();
            xmlNode.setAttribute(FIELD_JSFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getMaxValueStr() != null) {
            object = pSDEFTypeBase.getMaxValueStr();
            xmlNode.setAttribute(FIELD_MAXVALUESTR, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getMBEditorHeight() != null) {
            object = pSDEFTypeBase.getMBEditorHeight();
            xmlNode.setAttribute(FIELD_MBEDITORHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFTypeBase.getMBEditorType() != null) {
            object = pSDEFTypeBase.getMBEditorType();
            xmlNode.setAttribute(FIELD_MBEDITORTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getMBEditorWidth() != null) {
            object = pSDEFTypeBase.getMBEditorWidth();
            xmlNode.setAttribute(FIELD_MBEDITORWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFTypeBase.getMemo() != null) {
            object = pSDEFTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getMinStrLength() != null) {
            object = pSDEFTypeBase.getMinStrLength();
            xmlNode.setAttribute(FIELD_MINSTRLENGTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFTypeBase.getMinValueStr() != null) {
            object = pSDEFTypeBase.getMinValueStr();
            xmlNode.setAttribute(FIELD_MINVALUESTR, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getObjHelper() != null) {
            object = pSDEFTypeBase.getObjHelper();
            xmlNode.setAttribute(FIELD_OBJHELPER, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getObjHelper2() != null) {
            object = pSDEFTypeBase.getObjHelper2();
            xmlNode.setAttribute(FIELD_OBJHELPER2, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getOrderValue() != null) {
            object = pSDEFTypeBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFTypeBase.getPrecision2() != null) {
            object = pSDEFTypeBase.getPrecision2();
            xmlNode.setAttribute(FIELD_PRECISION2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFTypeBase.getPSCodeListTemplId() != null) {
            object = pSDEFTypeBase.getPSCodeListTemplId();
            xmlNode.setAttribute(FIELD_PSCODELISTTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getPSCodeListTemplName() != null) {
            object = pSDEFTypeBase.getPSCodeListTemplName();
            xmlNode.setAttribute(FIELD_PSCODELISTTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getPSDEFTypeId() != null) {
            object = pSDEFTypeBase.getPSDEFTypeId();
            xmlNode.setAttribute(FIELD_PSDEFTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getPSDEFTypeName() != null) {
            object = pSDEFTypeBase.getPSDEFTypeName();
            xmlNode.setAttribute(FIELD_PSDEFTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getPSUnitId() != null) {
            object = pSDEFTypeBase.getPSUnitId();
            xmlNode.setAttribute(FIELD_PSUNITID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getPSUnitName() != null) {
            object = pSDEFTypeBase.getPSUnitName();
            xmlNode.setAttribute(FIELD_PSUNITNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getPSValueRuleId() != null) {
            object = pSDEFTypeBase.getPSValueRuleId();
            xmlNode.setAttribute(FIELD_PSVALUERULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getPSValueRuleName() != null) {
            object = pSDEFTypeBase.getPSValueRuleName();
            xmlNode.setAttribute(FIELD_PSVALUERULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getPYFormat() != null) {
            object = pSDEFTypeBase.getPYFormat();
            xmlNode.setAttribute(FIELD_PYFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getSearchEditorHeight() != null) {
            object = pSDEFTypeBase.getSearchEditorHeight();
            xmlNode.setAttribute(FIELD_SEARCHEDITORHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFTypeBase.getSearchEditorType() != null) {
            object = pSDEFTypeBase.getSearchEditorType();
            xmlNode.setAttribute(FIELD_SEARCHEDITORTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getSearchEditorWidth() != null) {
            object = pSDEFTypeBase.getSearchEditorWidth();
            xmlNode.setAttribute(FIELD_SEARCHEDITORWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFTypeBase.getSearchMBEditorHeight() != null) {
            object = pSDEFTypeBase.getSearchMBEditorHeight();
            xmlNode.setAttribute(FIELD_SEARCHMBEDITORHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFTypeBase.getSearchMBEditorType() != null) {
            object = pSDEFTypeBase.getSearchMBEditorType();
            xmlNode.setAttribute(FIELD_SEARCHMBEDITORTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getSearchMBEditorWidth() != null) {
            object = pSDEFTypeBase.getSearchMBEditorWidth();
            xmlNode.setAttribute(FIELD_SEARCHMBEDITORWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFTypeBase.getSearchModeObj() != null) {
            object = pSDEFTypeBase.getSearchModeObj();
            xmlNode.setAttribute(FIELD_SEARCHMODEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getSFItemObj() != null) {
            object = pSDEFTypeBase.getSFItemObj();
            xmlNode.setAttribute(FIELD_SFITEMOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getStdDataType() != null) {
            object = pSDEFTypeBase.getStdDataType();
            xmlNode.setAttribute(FIELD_STDDATATYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFTypeBase.getStrLength() != null) {
            object = pSDEFTypeBase.getStrLength();
            xmlNode.setAttribute(FIELD_STRLENGTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFTypeBase.getTestData() != null) {
            object = pSDEFTypeBase.getTestData();
            xmlNode.setAttribute(FIELD_TESTDATA, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getTSFormat() != null) {
            object = pSDEFTypeBase.getTSFormat();
            xmlNode.setAttribute(FIELD_TSFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getUIModeObj() != null) {
            object = pSDEFTypeBase.getUIModeObj();
            xmlNode.setAttribute(FIELD_UIMODEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDEFTypeBase.getUnsignedFlag() != null) {
            object = pSDEFTypeBase.getUnsignedFlag();
            xmlNode.setAttribute(FIELD_UNSIGNEDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFTypeBase.getUpdateDate() != null) {
            object = pSDEFTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFTypeBase.getUpdateMan() != null) {
            object = pSDEFTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEFTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEFTypeBase pSDEFTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEFTypeBase.isCreateDateDirty() && (bl || pSDEFTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEFTypeBase.getCreateDate());
        }
        if (pSDEFTypeBase.isCreateManDirty() && (bl || pSDEFTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEFTypeBase.getCreateMan());
        }
        if (pSDEFTypeBase.isDataTypesDirty() && (bl || pSDEFTypeBase.getDataTypes() != null)) {
            iDataObject.set(FIELD_DATATYPES, (Object)pSDEFTypeBase.getDataTypes());
        }
        if (pSDEFTypeBase.isDotNETFormatDirty() && (bl || pSDEFTypeBase.getDotNETFormat() != null)) {
            iDataObject.set(FIELD_DOTNETFORMAT, (Object)pSDEFTypeBase.getDotNETFormat());
        }
        if (pSDEFTypeBase.isEditorHeightDirty() && (bl || pSDEFTypeBase.getEditorHeight() != null)) {
            iDataObject.set(FIELD_EDITORHEIGHT, (Object)pSDEFTypeBase.getEditorHeight());
        }
        if (pSDEFTypeBase.isEditorTypeDirty() && (bl || pSDEFTypeBase.getEditorType() != null)) {
            iDataObject.set(FIELD_EDITORTYPE, (Object)pSDEFTypeBase.getEditorType());
        }
        if (pSDEFTypeBase.isEditorWidthDirty() && (bl || pSDEFTypeBase.getEditorWidth() != null)) {
            iDataObject.set(FIELD_EDITORWIDTH, (Object)pSDEFTypeBase.getEditorWidth());
        }
        if (pSDEFTypeBase.isFieldsDirty() && (bl || pSDEFTypeBase.getFields() != null)) {
            iDataObject.set(FIELD_FIELDS, (Object)pSDEFTypeBase.getFields());
        }
        if (pSDEFTypeBase.isFormItemObjDirty() && (bl || pSDEFTypeBase.getFormItemObj() != null)) {
            iDataObject.set(FIELD_FORMITEMOBJ, (Object)pSDEFTypeBase.getFormItemObj());
        }
        if (pSDEFTypeBase.isGridColAlignDirty() && (bl || pSDEFTypeBase.getGridColAlign() != null)) {
            iDataObject.set(FIELD_GRIDCOLALIGN, (Object)pSDEFTypeBase.getGridColAlign());
        }
        if (pSDEFTypeBase.isGridColCLModeDirty() && (bl || pSDEFTypeBase.getGridColCLMode() != null)) {
            iDataObject.set(FIELD_GRIDCOLCLMODE, (Object)pSDEFTypeBase.getGridColCLMode());
        }
        if (pSDEFTypeBase.isGridColObjDirty() && (bl || pSDEFTypeBase.getGridColObj() != null)) {
            iDataObject.set(FIELD_GRIDCOLOBJ, (Object)pSDEFTypeBase.getGridColObj());
        }
        if (pSDEFTypeBase.isGridColWidthDirty() && (bl || pSDEFTypeBase.getGridColWidth() != null)) {
            iDataObject.set(FIELD_GRIDCOLWIDTH, (Object)pSDEFTypeBase.getGridColWidth());
        }
        if (pSDEFTypeBase.isIconPathDirty() && (bl || pSDEFTypeBase.getIconPath() != null)) {
            iDataObject.set(FIELD_ICONPATH, (Object)pSDEFTypeBase.getIconPath());
        }
        if (pSDEFTypeBase.isIncrementFlagDirty() && (bl || pSDEFTypeBase.getIncrementFlag() != null)) {
            iDataObject.set(FIELD_INCREMENTFLAG, (Object)pSDEFTypeBase.getIncrementFlag());
        }
        if (pSDEFTypeBase.isJAVAFormatDirty() && (bl || pSDEFTypeBase.getJAVAFormat() != null)) {
            iDataObject.set(FIELD_JAVAFORMAT, (Object)pSDEFTypeBase.getJAVAFormat());
        }
        if (pSDEFTypeBase.isJSFormatDirty() && (bl || pSDEFTypeBase.getJSFormat() != null)) {
            iDataObject.set(FIELD_JSFORMAT, (Object)pSDEFTypeBase.getJSFormat());
        }
        if (pSDEFTypeBase.isMaxValueStrDirty() && (bl || pSDEFTypeBase.getMaxValueStr() != null)) {
            iDataObject.set(FIELD_MAXVALUESTR, (Object)pSDEFTypeBase.getMaxValueStr());
        }
        if (pSDEFTypeBase.isMBEditorHeightDirty() && (bl || pSDEFTypeBase.getMBEditorHeight() != null)) {
            iDataObject.set(FIELD_MBEDITORHEIGHT, (Object)pSDEFTypeBase.getMBEditorHeight());
        }
        if (pSDEFTypeBase.isMBEditorTypeDirty() && (bl || pSDEFTypeBase.getMBEditorType() != null)) {
            iDataObject.set(FIELD_MBEDITORTYPE, (Object)pSDEFTypeBase.getMBEditorType());
        }
        if (pSDEFTypeBase.isMBEditorWidthDirty() && (bl || pSDEFTypeBase.getMBEditorWidth() != null)) {
            iDataObject.set(FIELD_MBEDITORWIDTH, (Object)pSDEFTypeBase.getMBEditorWidth());
        }
        if (pSDEFTypeBase.isMemoDirty() && (bl || pSDEFTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEFTypeBase.getMemo());
        }
        if (pSDEFTypeBase.isMinStrLengthDirty() && (bl || pSDEFTypeBase.getMinStrLength() != null)) {
            iDataObject.set(FIELD_MINSTRLENGTH, (Object)pSDEFTypeBase.getMinStrLength());
        }
        if (pSDEFTypeBase.isMinValueStrDirty() && (bl || pSDEFTypeBase.getMinValueStr() != null)) {
            iDataObject.set(FIELD_MINVALUESTR, (Object)pSDEFTypeBase.getMinValueStr());
        }
        if (pSDEFTypeBase.isObjHelperDirty() && (bl || pSDEFTypeBase.getObjHelper() != null)) {
            iDataObject.set(FIELD_OBJHELPER, (Object)pSDEFTypeBase.getObjHelper());
        }
        if (pSDEFTypeBase.isObjHelper2Dirty() && (bl || pSDEFTypeBase.getObjHelper2() != null)) {
            iDataObject.set(FIELD_OBJHELPER2, (Object)pSDEFTypeBase.getObjHelper2());
        }
        if (pSDEFTypeBase.isOrderValueDirty() && (bl || pSDEFTypeBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEFTypeBase.getOrderValue());
        }
        if (pSDEFTypeBase.isPrecision2Dirty() && (bl || pSDEFTypeBase.getPrecision2() != null)) {
            iDataObject.set(FIELD_PRECISION2, (Object)pSDEFTypeBase.getPrecision2());
        }
        if (pSDEFTypeBase.isPSCodeListTemplIdDirty() && (bl || pSDEFTypeBase.getPSCodeListTemplId() != null)) {
            iDataObject.set(FIELD_PSCODELISTTEMPLID, (Object)pSDEFTypeBase.getPSCodeListTemplId());
        }
        if (pSDEFTypeBase.isPSCodeListTemplNameDirty() && (bl || pSDEFTypeBase.getPSCodeListTemplName() != null)) {
            iDataObject.set(FIELD_PSCODELISTTEMPLNAME, (Object)pSDEFTypeBase.getPSCodeListTemplName());
        }
        if (pSDEFTypeBase.isPSDEFTypeIdDirty() && (bl || pSDEFTypeBase.getPSDEFTypeId() != null)) {
            iDataObject.set(FIELD_PSDEFTYPEID, (Object)pSDEFTypeBase.getPSDEFTypeId());
        }
        if (pSDEFTypeBase.isPSDEFTypeNameDirty() && (bl || pSDEFTypeBase.getPSDEFTypeName() != null)) {
            iDataObject.set(FIELD_PSDEFTYPENAME, (Object)pSDEFTypeBase.getPSDEFTypeName());
        }
        if (pSDEFTypeBase.isPSUnitIdDirty() && (bl || pSDEFTypeBase.getPSUnitId() != null)) {
            iDataObject.set(FIELD_PSUNITID, (Object)pSDEFTypeBase.getPSUnitId());
        }
        if (pSDEFTypeBase.isPSUnitNameDirty() && (bl || pSDEFTypeBase.getPSUnitName() != null)) {
            iDataObject.set(FIELD_PSUNITNAME, (Object)pSDEFTypeBase.getPSUnitName());
        }
        if (pSDEFTypeBase.isPSValueRuleIdDirty() && (bl || pSDEFTypeBase.getPSValueRuleId() != null)) {
            iDataObject.set(FIELD_PSVALUERULEID, (Object)pSDEFTypeBase.getPSValueRuleId());
        }
        if (pSDEFTypeBase.isPSValueRuleNameDirty() && (bl || pSDEFTypeBase.getPSValueRuleName() != null)) {
            iDataObject.set(FIELD_PSVALUERULENAME, (Object)pSDEFTypeBase.getPSValueRuleName());
        }
        if (pSDEFTypeBase.isPYFormatDirty() && (bl || pSDEFTypeBase.getPYFormat() != null)) {
            iDataObject.set(FIELD_PYFORMAT, (Object)pSDEFTypeBase.getPYFormat());
        }
        if (pSDEFTypeBase.isSearchEditorHeightDirty() && (bl || pSDEFTypeBase.getSearchEditorHeight() != null)) {
            iDataObject.set(FIELD_SEARCHEDITORHEIGHT, (Object)pSDEFTypeBase.getSearchEditorHeight());
        }
        if (pSDEFTypeBase.isSearchEditorTypeDirty() && (bl || pSDEFTypeBase.getSearchEditorType() != null)) {
            iDataObject.set(FIELD_SEARCHEDITORTYPE, (Object)pSDEFTypeBase.getSearchEditorType());
        }
        if (pSDEFTypeBase.isSearchEditorWidthDirty() && (bl || pSDEFTypeBase.getSearchEditorWidth() != null)) {
            iDataObject.set(FIELD_SEARCHEDITORWIDTH, (Object)pSDEFTypeBase.getSearchEditorWidth());
        }
        if (pSDEFTypeBase.isSearchMBEditorHeightDirty() && (bl || pSDEFTypeBase.getSearchMBEditorHeight() != null)) {
            iDataObject.set(FIELD_SEARCHMBEDITORHEIGHT, (Object)pSDEFTypeBase.getSearchMBEditorHeight());
        }
        if (pSDEFTypeBase.isSearchMBEditorTypeDirty() && (bl || pSDEFTypeBase.getSearchMBEditorType() != null)) {
            iDataObject.set(FIELD_SEARCHMBEDITORTYPE, (Object)pSDEFTypeBase.getSearchMBEditorType());
        }
        if (pSDEFTypeBase.isSearchMBEditorWidthDirty() && (bl || pSDEFTypeBase.getSearchMBEditorWidth() != null)) {
            iDataObject.set(FIELD_SEARCHMBEDITORWIDTH, (Object)pSDEFTypeBase.getSearchMBEditorWidth());
        }
        if (pSDEFTypeBase.isSearchModeObjDirty() && (bl || pSDEFTypeBase.getSearchModeObj() != null)) {
            iDataObject.set(FIELD_SEARCHMODEOBJ, (Object)pSDEFTypeBase.getSearchModeObj());
        }
        if (pSDEFTypeBase.isSFItemObjDirty() && (bl || pSDEFTypeBase.getSFItemObj() != null)) {
            iDataObject.set(FIELD_SFITEMOBJ, (Object)pSDEFTypeBase.getSFItemObj());
        }
        if (pSDEFTypeBase.isStdDataTypeDirty() && (bl || pSDEFTypeBase.getStdDataType() != null)) {
            iDataObject.set(FIELD_STDDATATYPE, (Object)pSDEFTypeBase.getStdDataType());
        }
        if (pSDEFTypeBase.isStrLengthDirty() && (bl || pSDEFTypeBase.getStrLength() != null)) {
            iDataObject.set(FIELD_STRLENGTH, (Object)pSDEFTypeBase.getStrLength());
        }
        if (pSDEFTypeBase.isTestDataDirty() && (bl || pSDEFTypeBase.getTestData() != null)) {
            iDataObject.set(FIELD_TESTDATA, (Object)pSDEFTypeBase.getTestData());
        }
        if (pSDEFTypeBase.isTSFormatDirty() && (bl || pSDEFTypeBase.getTSFormat() != null)) {
            iDataObject.set(FIELD_TSFORMAT, (Object)pSDEFTypeBase.getTSFormat());
        }
        if (pSDEFTypeBase.isUIModeObjDirty() && (bl || pSDEFTypeBase.getUIModeObj() != null)) {
            iDataObject.set(FIELD_UIMODEOBJ, (Object)pSDEFTypeBase.getUIModeObj());
        }
        if (pSDEFTypeBase.isUnsignedFlagDirty() && (bl || pSDEFTypeBase.getUnsignedFlag() != null)) {
            iDataObject.set(FIELD_UNSIGNEDFLAG, (Object)pSDEFTypeBase.getUnsignedFlag());
        }
        if (pSDEFTypeBase.isUpdateDateDirty() && (bl || pSDEFTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEFTypeBase.getUpdateDate());
        }
        if (pSDEFTypeBase.isUpdateManDirty() && (bl || pSDEFTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEFTypeBase.getUpdateMan());
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
        return PSDEFTypeBase.remove(this, n);
    }

    private static boolean remove(PSDEFTypeBase pSDEFTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEFTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEFTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEFTypeBase.resetDataTypes();
                return true;
            }
            case 3: {
                pSDEFTypeBase.resetDotNETFormat();
                return true;
            }
            case 4: {
                pSDEFTypeBase.resetEditorHeight();
                return true;
            }
            case 5: {
                pSDEFTypeBase.resetEditorType();
                return true;
            }
            case 6: {
                pSDEFTypeBase.resetEditorWidth();
                return true;
            }
            case 7: {
                pSDEFTypeBase.resetFields();
                return true;
            }
            case 8: {
                pSDEFTypeBase.resetFormItemObj();
                return true;
            }
            case 9: {
                pSDEFTypeBase.resetGridColAlign();
                return true;
            }
            case 10: {
                pSDEFTypeBase.resetGridColCLMode();
                return true;
            }
            case 11: {
                pSDEFTypeBase.resetGridColObj();
                return true;
            }
            case 12: {
                pSDEFTypeBase.resetGridColWidth();
                return true;
            }
            case 13: {
                pSDEFTypeBase.resetIconPath();
                return true;
            }
            case 14: {
                pSDEFTypeBase.resetIncrementFlag();
                return true;
            }
            case 15: {
                pSDEFTypeBase.resetJAVAFormat();
                return true;
            }
            case 16: {
                pSDEFTypeBase.resetJSFormat();
                return true;
            }
            case 17: {
                pSDEFTypeBase.resetMaxValueStr();
                return true;
            }
            case 18: {
                pSDEFTypeBase.resetMBEditorHeight();
                return true;
            }
            case 19: {
                pSDEFTypeBase.resetMBEditorType();
                return true;
            }
            case 20: {
                pSDEFTypeBase.resetMBEditorWidth();
                return true;
            }
            case 21: {
                pSDEFTypeBase.resetMemo();
                return true;
            }
            case 22: {
                pSDEFTypeBase.resetMinStrLength();
                return true;
            }
            case 23: {
                pSDEFTypeBase.resetMinValueStr();
                return true;
            }
            case 24: {
                pSDEFTypeBase.resetObjHelper();
                return true;
            }
            case 25: {
                pSDEFTypeBase.resetObjHelper2();
                return true;
            }
            case 26: {
                pSDEFTypeBase.resetOrderValue();
                return true;
            }
            case 27: {
                pSDEFTypeBase.resetPrecision2();
                return true;
            }
            case 28: {
                pSDEFTypeBase.resetPSCodeListTemplId();
                return true;
            }
            case 29: {
                pSDEFTypeBase.resetPSCodeListTemplName();
                return true;
            }
            case 30: {
                pSDEFTypeBase.resetPSDEFTypeId();
                return true;
            }
            case 31: {
                pSDEFTypeBase.resetPSDEFTypeName();
                return true;
            }
            case 32: {
                pSDEFTypeBase.resetPSUnitId();
                return true;
            }
            case 33: {
                pSDEFTypeBase.resetPSUnitName();
                return true;
            }
            case 34: {
                pSDEFTypeBase.resetPSValueRuleId();
                return true;
            }
            case 35: {
                pSDEFTypeBase.resetPSValueRuleName();
                return true;
            }
            case 36: {
                pSDEFTypeBase.resetPYFormat();
                return true;
            }
            case 37: {
                pSDEFTypeBase.resetSearchEditorHeight();
                return true;
            }
            case 38: {
                pSDEFTypeBase.resetSearchEditorType();
                return true;
            }
            case 39: {
                pSDEFTypeBase.resetSearchEditorWidth();
                return true;
            }
            case 40: {
                pSDEFTypeBase.resetSearchMBEditorHeight();
                return true;
            }
            case 41: {
                pSDEFTypeBase.resetSearchMBEditorType();
                return true;
            }
            case 42: {
                pSDEFTypeBase.resetSearchMBEditorWidth();
                return true;
            }
            case 43: {
                pSDEFTypeBase.resetSearchModeObj();
                return true;
            }
            case 44: {
                pSDEFTypeBase.resetSFItemObj();
                return true;
            }
            case 45: {
                pSDEFTypeBase.resetStdDataType();
                return true;
            }
            case 46: {
                pSDEFTypeBase.resetStrLength();
                return true;
            }
            case 47: {
                pSDEFTypeBase.resetTestData();
                return true;
            }
            case 48: {
                pSDEFTypeBase.resetTSFormat();
                return true;
            }
            case 49: {
                pSDEFTypeBase.resetUIModeObj();
                return true;
            }
            case 50: {
                pSDEFTypeBase.resetUnsignedFlag();
                return true;
            }
            case 51: {
                pSDEFTypeBase.resetUpdateDate();
                return true;
            }
            case 52: {
                pSDEFTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCodeListTempl getPSCodeListTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListTempl();
        }
        if (this.getPSCodeListTemplId() == null) {
            return null;
        }
        Integer n = this.objPSCodeListTemplLock;
        synchronized (n) {
            if (this.pscodelisttempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSCodeListTemplId(), (Object)this.pscodelisttempl.getPSCodeListTemplId()) != 0L) {
                this.pscodelisttempl = null;
            }
            if (this.pscodelisttempl == null) {
                PSCodeListTempl pSCodeListTempl = new PSCodeListTempl();
                pSCodeListTempl.setPSCodeListTemplId(this.getPSCodeListTemplId());
                PSCodeListTemplService pSCodeListTemplService = (PSCodeListTemplService)ServiceGlobal.getService(PSCodeListTemplService.class, (SessionFactory)this.getSessionFactory());
                pSCodeListTemplService.autoGet((IEntity)pSCodeListTempl);
                this.pscodelisttempl = pSCodeListTempl;
            }
            return this.pscodelisttempl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSUnit getPSUnit() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUnit();
        }
        if (this.getPSUnitId() == null) {
            return null;
        }
        Integer n = this.objPSUnitLock;
        synchronized (n) {
            if (this.psunit != null && DataTypeHelper.compare((int)25, (Object)this.getPSUnitId(), (Object)this.psunit.getPSUnitId()) != 0L) {
                this.psunit = null;
            }
            if (this.psunit == null) {
                PSUnit pSUnit = new PSUnit();
                pSUnit.setPSUnitId(this.getPSUnitId());
                PSUnitService pSUnitService = (PSUnitService)ServiceGlobal.getService(PSUnitService.class, (SessionFactory)this.getSessionFactory());
                pSUnitService.autoGet((IEntity)pSUnit);
                this.psunit = pSUnit;
            }
            return this.psunit;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSValueRule getPSValueRule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSValueRule();
        }
        if (this.getPSValueRuleId() == null) {
            return null;
        }
        Integer n = this.objPSValueRuleLock;
        synchronized (n) {
            if (this.psvaluerule != null && DataTypeHelper.compare((int)25, (Object)this.getPSValueRuleId(), (Object)this.psvaluerule.getPSValueRuleId()) != 0L) {
                this.psvaluerule = null;
            }
            if (this.psvaluerule == null) {
                PSValueRule pSValueRule = new PSValueRule();
                pSValueRule.setPSValueRuleId(this.getPSValueRuleId());
                PSValueRuleService pSValueRuleService = (PSValueRuleService)ServiceGlobal.getService(PSValueRuleService.class, (SessionFactory)this.getSessionFactory());
                pSValueRuleService.autoGet((IEntity)pSValueRule);
                this.psvaluerule = pSValueRule;
            }
            return this.psvaluerule;
        }
    }

    private PSDEFTypeBase getProxyEntity() {
        return this.proxyPSDEFTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEFTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEFTypeBase) {
            this.proxyPSDEFTypeBase = (PSDEFTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDEFTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DATATYPES, 2);
        fieldIndexMap.put(FIELD_DOTNETFORMAT, 3);
        fieldIndexMap.put(FIELD_EDITORHEIGHT, 4);
        fieldIndexMap.put(FIELD_EDITORTYPE, 5);
        fieldIndexMap.put(FIELD_EDITORWIDTH, 6);
        fieldIndexMap.put(FIELD_FIELDS, 7);
        fieldIndexMap.put(FIELD_FORMITEMOBJ, 8);
        fieldIndexMap.put(FIELD_GRIDCOLALIGN, 9);
        fieldIndexMap.put(FIELD_GRIDCOLCLMODE, 10);
        fieldIndexMap.put(FIELD_GRIDCOLOBJ, 11);
        fieldIndexMap.put(FIELD_GRIDCOLWIDTH, 12);
        fieldIndexMap.put(FIELD_ICONPATH, 13);
        fieldIndexMap.put(FIELD_INCREMENTFLAG, 14);
        fieldIndexMap.put(FIELD_JAVAFORMAT, 15);
        fieldIndexMap.put(FIELD_JSFORMAT, 16);
        fieldIndexMap.put(FIELD_MAXVALUESTR, 17);
        fieldIndexMap.put(FIELD_MBEDITORHEIGHT, 18);
        fieldIndexMap.put(FIELD_MBEDITORTYPE, 19);
        fieldIndexMap.put(FIELD_MBEDITORWIDTH, 20);
        fieldIndexMap.put(FIELD_MEMO, 21);
        fieldIndexMap.put(FIELD_MINSTRLENGTH, 22);
        fieldIndexMap.put(FIELD_MINVALUESTR, 23);
        fieldIndexMap.put(FIELD_OBJHELPER, 24);
        fieldIndexMap.put(FIELD_OBJHELPER2, 25);
        fieldIndexMap.put(FIELD_ORDERVALUE, 26);
        fieldIndexMap.put(FIELD_PRECISION2, 27);
        fieldIndexMap.put(FIELD_PSCODELISTTEMPLID, 28);
        fieldIndexMap.put(FIELD_PSCODELISTTEMPLNAME, 29);
        fieldIndexMap.put(FIELD_PSDEFTYPEID, 30);
        fieldIndexMap.put(FIELD_PSDEFTYPENAME, 31);
        fieldIndexMap.put(FIELD_PSUNITID, 32);
        fieldIndexMap.put(FIELD_PSUNITNAME, 33);
        fieldIndexMap.put(FIELD_PSVALUERULEID, 34);
        fieldIndexMap.put(FIELD_PSVALUERULENAME, 35);
        fieldIndexMap.put(FIELD_PYFORMAT, 36);
        fieldIndexMap.put(FIELD_SEARCHEDITORHEIGHT, 37);
        fieldIndexMap.put(FIELD_SEARCHEDITORTYPE, 38);
        fieldIndexMap.put(FIELD_SEARCHEDITORWIDTH, 39);
        fieldIndexMap.put(FIELD_SEARCHMBEDITORHEIGHT, 40);
        fieldIndexMap.put(FIELD_SEARCHMBEDITORTYPE, 41);
        fieldIndexMap.put(FIELD_SEARCHMBEDITORWIDTH, 42);
        fieldIndexMap.put(FIELD_SEARCHMODEOBJ, 43);
        fieldIndexMap.put(FIELD_SFITEMOBJ, 44);
        fieldIndexMap.put(FIELD_STDDATATYPE, 45);
        fieldIndexMap.put(FIELD_STRLENGTH, 46);
        fieldIndexMap.put(FIELD_TESTDATA, 47);
        fieldIndexMap.put(FIELD_TSFORMAT, 48);
        fieldIndexMap.put(FIELD_UIMODEOBJ, 49);
        fieldIndexMap.put(FIELD_UNSIGNEDFLAG, 50);
        fieldIndexMap.put(FIELD_UPDATEDATE, 51);
        fieldIndexMap.put(FIELD_UPDATEMAN, 52);
    }
}

