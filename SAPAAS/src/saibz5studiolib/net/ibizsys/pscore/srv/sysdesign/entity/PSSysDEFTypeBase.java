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
import net.ibizsys.pscore.srv.config.entity.PSDEFType;
import net.ibizsys.pscore.srv.config.service.PSDEFTypeService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUnit;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUnitService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDEFTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDEFTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EDITORHEIGHT = "EDITORHEIGHT";
    public static final String FIELD_EDITORTYPE = "EDITORTYPE";
    public static final String FIELD_EDITORWIDTH = "EDITORWIDTH";
    public static final String FIELD_FIELDS = "FIELDS";
    public static final String FIELD_GRIDCOLALIGN = "GRIDCOLALIGN";
    public static final String FIELD_GRIDCOLCLMODE = "GRIDCOLCLMODE";
    public static final String FIELD_GRIDCOLWIDTH = "GRIDCOLWIDTH";
    public static final String FIELD_JSFORMAT = "JSFORMAT";
    public static final String FIELD_MAXVALUE = "MAXVALUE";
    public static final String FIELD_MBEDITORHEIGHT = "MBEDITORHEIGHT";
    public static final String FIELD_MBEDITORTYPE = "MBEDITORTYPE";
    public static final String FIELD_MBEDITORWIDTH = "MBEDITORWIDTH";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINSTRLENGTH = "MINSTRLENGTH";
    public static final String FIELD_MINVALUE = "MINVALUE";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PRECISION2 = "PRECISION2";
    public static final String FIELD_PSCODELISTID = "PSCODELISTID";
    public static final String FIELD_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String FIELD_PSDEFTYPEID = "PSDEFTYPEID";
    public static final String FIELD_PSDEFTYPENAME = "PSDEFTYPENAME";
    public static final String FIELD_PSSYSDEFTYPEID = "PSSYSDEFTYPEID";
    public static final String FIELD_PSSYSDEFTYPENAME = "PSSYSDEFTYPENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSUNITID = "PSSYSUNITID";
    public static final String FIELD_PSSYSUNITNAME = "PSSYSUNITNAME";
    public static final String FIELD_PSSYSVALUERULEID = "PSSYSVALUERULEID";
    public static final String FIELD_PSSYSVALUERULENAME = "PSSYSVALUERULENAME";
    public static final String FIELD_PYFORMAT = "PYFORMAT";
    public static final String FIELD_SEARCHEDITORHEIGHT = "SEARCHEDITORHEIGHT";
    public static final String FIELD_SEARCHEDITORTYPE = "SEARCHEDITORTYPE";
    public static final String FIELD_SEARCHEDITORWIDTH = "SEARCHEDITORWIDTH";
    public static final String FIELD_SEARCHMBEDITORHEIGHT = "SEARCHMBEDITORHEIGHT";
    public static final String FIELD_SEARCHMBEDITORTYPE = "SEARCHMBEDITORTYPE";
    public static final String FIELD_SEARCHMBEDITORWIDTH = "SEARCHMBEDITORWIDTH";
    public static final String FIELD_STDDATATYPE = "STDDATATYPE";
    public static final String FIELD_STRLENGTH = "STRLENGTH";
    public static final String FIELD_TSFORMAT = "TSFORMAT";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VALUEFORMAT = "VALUEFORMAT";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_EDITORHEIGHT = 2;
    private static final int INDEX_EDITORTYPE = 3;
    private static final int INDEX_EDITORWIDTH = 4;
    private static final int INDEX_FIELDS = 5;
    private static final int INDEX_GRIDCOLALIGN = 6;
    private static final int INDEX_GRIDCOLCLMODE = 7;
    private static final int INDEX_GRIDCOLWIDTH = 8;
    private static final int INDEX_JSFORMAT = 9;
    private static final int INDEX_MAXVALUE = 10;
    private static final int INDEX_MBEDITORHEIGHT = 11;
    private static final int INDEX_MBEDITORTYPE = 12;
    private static final int INDEX_MBEDITORWIDTH = 13;
    private static final int INDEX_MEMO = 14;
    private static final int INDEX_MINSTRLENGTH = 15;
    private static final int INDEX_MINVALUE = 16;
    private static final int INDEX_ORDERVALUE = 17;
    private static final int INDEX_PRECISION2 = 18;
    private static final int INDEX_PSCODELISTID = 19;
    private static final int INDEX_PSCODELISTNAME = 20;
    private static final int INDEX_PSDEFTYPEID = 21;
    private static final int INDEX_PSDEFTYPENAME = 22;
    private static final int INDEX_PSSYSDEFTYPEID = 23;
    private static final int INDEX_PSSYSDEFTYPENAME = 24;
    private static final int INDEX_PSSYSTEMID = 25;
    private static final int INDEX_PSSYSTEMNAME = 26;
    private static final int INDEX_PSSYSUNITID = 27;
    private static final int INDEX_PSSYSUNITNAME = 28;
    private static final int INDEX_PSSYSVALUERULEID = 29;
    private static final int INDEX_PSSYSVALUERULENAME = 30;
    private static final int INDEX_PYFORMAT = 31;
    private static final int INDEX_SEARCHEDITORHEIGHT = 32;
    private static final int INDEX_SEARCHEDITORTYPE = 33;
    private static final int INDEX_SEARCHEDITORWIDTH = 34;
    private static final int INDEX_SEARCHMBEDITORHEIGHT = 35;
    private static final int INDEX_SEARCHMBEDITORTYPE = 36;
    private static final int INDEX_SEARCHMBEDITORWIDTH = 37;
    private static final int INDEX_STDDATATYPE = 38;
    private static final int INDEX_STRLENGTH = 39;
    private static final int INDEX_TSFORMAT = 40;
    private static final int INDEX_UPDATEDATE = 41;
    private static final int INDEX_UPDATEMAN = 42;
    private static final int INDEX_VALIDFLAG = 43;
    private static final int INDEX_VALUEFORMAT = 44;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysDEFTypeBase proxyPSSysDEFTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean editorheightDirtyFlag = false;
    private boolean editortypeDirtyFlag = false;
    private boolean editorwidthDirtyFlag = false;
    private boolean fieldsDirtyFlag = false;
    private boolean gridcolalignDirtyFlag = false;
    private boolean gridcolclmodeDirtyFlag = false;
    private boolean gridcolwidthDirtyFlag = false;
    private boolean jsformatDirtyFlag = false;
    private boolean maxvalueDirtyFlag = false;
    private boolean mbeditorheightDirtyFlag = false;
    private boolean mbeditortypeDirtyFlag = false;
    private boolean mbeditorwidthDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minstrlengthDirtyFlag = false;
    private boolean minvalueDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean precision2DirtyFlag = false;
    private boolean pscodelistidDirtyFlag = false;
    private boolean pscodelistnameDirtyFlag = false;
    private boolean psdeftypeidDirtyFlag = false;
    private boolean psdeftypenameDirtyFlag = false;
    private boolean pssysdeftypeidDirtyFlag = false;
    private boolean pssysdeftypenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssysunitidDirtyFlag = false;
    private boolean pssysunitnameDirtyFlag = false;
    private boolean pssysvalueruleidDirtyFlag = false;
    private boolean pssysvaluerulenameDirtyFlag = false;
    private boolean pyformatDirtyFlag = false;
    private boolean searcheditorheightDirtyFlag = false;
    private boolean searcheditortypeDirtyFlag = false;
    private boolean searcheditorwidthDirtyFlag = false;
    private boolean searchmbeditorheightDirtyFlag = false;
    private boolean searchmbeditortypeDirtyFlag = false;
    private boolean searchmbeditorwidthDirtyFlag = false;
    private boolean stddatatypeDirtyFlag = false;
    private boolean strlengthDirtyFlag = false;
    private boolean tsformatDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean valueformatDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="editorheight")
    private Integer editorheight;
    @Column(name="editortype")
    private String editortype;
    @Column(name="editorwidth")
    private Integer editorwidth;
    @Column(name="fields")
    private String fields;
    @Column(name="gridcolalign")
    private String gridcolalign;
    @Column(name="gridcolclmode")
    private String gridcolclmode;
    @Column(name="gridcolwidth")
    private Integer gridcolwidth;
    @Column(name="jsformat")
    private String jsformat;
    @Column(name="maxvalue")
    private String maxvalue;
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
    @Column(name="minvalue")
    private String minvalue;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="precision2")
    private Integer precision2;
    @Column(name="pscodelistid")
    private String pscodelistid;
    @Column(name="pscodelistname")
    private String pscodelistname;
    @Column(name="psdeftypeid")
    private String psdeftypeid;
    @Column(name="psdeftypename")
    private String psdeftypename;
    @Column(name="pssysdeftypeid")
    private String pssysdeftypeid;
    @Column(name="pssysdeftypename")
    private String pssysdeftypename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssysunitid")
    private String pssysunitid;
    @Column(name="pssysunitname")
    private String pssysunitname;
    @Column(name="pssysvalueruleid")
    private String pssysvalueruleid;
    @Column(name="pssysvaluerulename")
    private String pssysvaluerulename;
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
    @Column(name="stddatatype")
    private Integer stddatatype;
    @Column(name="strlength")
    private Integer strlength;
    @Column(name="tsformat")
    private String tsformat;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="valueformat")
    private String valueformat;
    private Integer objPSCodeListLock = new Integer(1);
    private PSCodeList pscodelist = null;
    private Integer objPSDEFTypeLock = new Integer(1);
    private PSDEFType psdeftype = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysUnitLock = new Integer(1);
    private PSSysUnit pssysunit = null;
    private Integer objPSSysValueRuleLock = new Integer(1);
    private PSSysValueRule pssysvaluerule = null;

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

    public void setMaxValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.maxvalue = string;
        this.maxvalueDirtyFlag = true;
    }

    public String getMaxValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxValue();
        }
        return this.maxvalue;
    }

    public boolean isMaxValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxValueDirty();
        }
        return this.maxvalueDirtyFlag;
    }

    public void resetMaxValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxValue();
            return;
        }
        this.maxvalueDirtyFlag = false;
        this.maxvalue = null;
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

    public void setMinValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minvalue = string;
        this.minvalueDirtyFlag = true;
    }

    public String getMinValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinValue();
        }
        return this.minvalue;
    }

    public boolean isMinValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinValueDirty();
        }
        return this.minvalueDirtyFlag;
    }

    public void resetMinValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinValue();
            return;
        }
        this.minvalueDirtyFlag = false;
        this.minvalue = null;
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

    public void setPSCodeListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodelistid = string;
        this.pscodelistidDirtyFlag = true;
    }

    public String getPSCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListId();
        }
        return this.pscodelistid;
    }

    public boolean isPSCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListIdDirty();
        }
        return this.pscodelistidDirtyFlag;
    }

    public void resetPSCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListId();
            return;
        }
        this.pscodelistidDirtyFlag = false;
        this.pscodelistid = null;
    }

    public void setPSCodeListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodelistname = string;
        this.pscodelistnameDirtyFlag = true;
    }

    public String getPSCodeListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListName();
        }
        return this.pscodelistname;
    }

    public boolean isPSCodeListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListNameDirty();
        }
        return this.pscodelistnameDirtyFlag;
    }

    public void resetPSCodeListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListName();
            return;
        }
        this.pscodelistnameDirtyFlag = false;
        this.pscodelistname = null;
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

    public void setPSSysDEFTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDEFTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdeftypeid = string;
        this.pssysdeftypeidDirtyFlag = true;
    }

    public String getPSSysDEFTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDEFTypeId();
        }
        return this.pssysdeftypeid;
    }

    public boolean isPSSysDEFTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDEFTypeIdDirty();
        }
        return this.pssysdeftypeidDirtyFlag;
    }

    public void resetPSSysDEFTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDEFTypeId();
            return;
        }
        this.pssysdeftypeidDirtyFlag = false;
        this.pssysdeftypeid = null;
    }

    public void setPSSysDEFTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDEFTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdeftypename = string;
        this.pssysdeftypenameDirtyFlag = true;
    }

    public String getPSSysDEFTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDEFTypeName();
        }
        return this.pssysdeftypename;
    }

    public boolean isPSSysDEFTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDEFTypeNameDirty();
        }
        return this.pssysdeftypenameDirtyFlag;
    }

    public void resetPSSysDEFTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDEFTypeName();
            return;
        }
        this.pssysdeftypenameDirtyFlag = false;
        this.pssysdeftypename = null;
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

    public void setPSSysUnitId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUnitId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysunitid = string;
        this.pssysunitidDirtyFlag = true;
    }

    public String getPSSysUnitId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUnitId();
        }
        return this.pssysunitid;
    }

    public boolean isPSSysUnitIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUnitIdDirty();
        }
        return this.pssysunitidDirtyFlag;
    }

    public void resetPSSysUnitId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUnitId();
            return;
        }
        this.pssysunitidDirtyFlag = false;
        this.pssysunitid = null;
    }

    public void setPSSysUnitName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUnitName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysunitname = string;
        this.pssysunitnameDirtyFlag = true;
    }

    public String getPSSysUnitName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUnitName();
        }
        return this.pssysunitname;
    }

    public boolean isPSSysUnitNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUnitNameDirty();
        }
        return this.pssysunitnameDirtyFlag;
    }

    public void resetPSSysUnitName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUnitName();
            return;
        }
        this.pssysunitnameDirtyFlag = false;
        this.pssysunitname = null;
    }

    public void setPSSysValueRuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysValueRuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysvalueruleid = string;
        this.pssysvalueruleidDirtyFlag = true;
    }

    public String getPSSysValueRuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysValueRuleId();
        }
        return this.pssysvalueruleid;
    }

    public boolean isPSSysValueRuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysValueRuleIdDirty();
        }
        return this.pssysvalueruleidDirtyFlag;
    }

    public void resetPSSysValueRuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysValueRuleId();
            return;
        }
        this.pssysvalueruleidDirtyFlag = false;
        this.pssysvalueruleid = null;
    }

    public void setPSSysValueRuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysValueRuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysvaluerulename = string;
        this.pssysvaluerulenameDirtyFlag = true;
    }

    public String getPSSysValueRuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysValueRuleName();
        }
        return this.pssysvaluerulename;
    }

    public boolean isPSSysValueRuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysValueRuleNameDirty();
        }
        return this.pssysvaluerulenameDirtyFlag;
    }

    public void resetPSSysValueRuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysValueRuleName();
            return;
        }
        this.pssysvaluerulenameDirtyFlag = false;
        this.pssysvaluerulename = null;
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

    public void setValueFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValueFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valueformat = string;
        this.valueformatDirtyFlag = true;
    }

    public String getValueFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValueFormat();
        }
        return this.valueformat;
    }

    public boolean isValueFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueFormatDirty();
        }
        return this.valueformatDirtyFlag;
    }

    public void resetValueFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValueFormat();
            return;
        }
        this.valueformatDirtyFlag = false;
        this.valueformat = null;
    }

    protected void onReset() {
        PSSysDEFTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDEFTypeBase pSSysDEFTypeBase) {
        pSSysDEFTypeBase.resetCreateDate();
        pSSysDEFTypeBase.resetCreateMan();
        pSSysDEFTypeBase.resetEditorHeight();
        pSSysDEFTypeBase.resetEditorType();
        pSSysDEFTypeBase.resetEditorWidth();
        pSSysDEFTypeBase.resetFields();
        pSSysDEFTypeBase.resetGridColAlign();
        pSSysDEFTypeBase.resetGridColCLMode();
        pSSysDEFTypeBase.resetGridColWidth();
        pSSysDEFTypeBase.resetJSFormat();
        pSSysDEFTypeBase.resetMaxValue();
        pSSysDEFTypeBase.resetMBEditorHeight();
        pSSysDEFTypeBase.resetMBEditorType();
        pSSysDEFTypeBase.resetMBEditorWidth();
        pSSysDEFTypeBase.resetMemo();
        pSSysDEFTypeBase.resetMinStrLength();
        pSSysDEFTypeBase.resetMinValue();
        pSSysDEFTypeBase.resetOrderValue();
        pSSysDEFTypeBase.resetPrecision2();
        pSSysDEFTypeBase.resetPSCodeListId();
        pSSysDEFTypeBase.resetPSCodeListName();
        pSSysDEFTypeBase.resetPSDEFTypeId();
        pSSysDEFTypeBase.resetPSDEFTypeName();
        pSSysDEFTypeBase.resetPSSysDEFTypeId();
        pSSysDEFTypeBase.resetPSSysDEFTypeName();
        pSSysDEFTypeBase.resetPSSystemId();
        pSSysDEFTypeBase.resetPSSystemName();
        pSSysDEFTypeBase.resetPSSysUnitId();
        pSSysDEFTypeBase.resetPSSysUnitName();
        pSSysDEFTypeBase.resetPSSysValueRuleId();
        pSSysDEFTypeBase.resetPSSysValueRuleName();
        pSSysDEFTypeBase.resetPYFormat();
        pSSysDEFTypeBase.resetSearchEditorHeight();
        pSSysDEFTypeBase.resetSearchEditorType();
        pSSysDEFTypeBase.resetSearchEditorWidth();
        pSSysDEFTypeBase.resetSearchMBEditorHeight();
        pSSysDEFTypeBase.resetSearchMBEditorType();
        pSSysDEFTypeBase.resetSearchMBEditorWidth();
        pSSysDEFTypeBase.resetStdDataType();
        pSSysDEFTypeBase.resetStrLength();
        pSSysDEFTypeBase.resetTSFormat();
        pSSysDEFTypeBase.resetUpdateDate();
        pSSysDEFTypeBase.resetUpdateMan();
        pSSysDEFTypeBase.resetValidFlag();
        pSSysDEFTypeBase.resetValueFormat();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
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
        if (!bl || this.isGridColAlignDirty()) {
            hashMap.put(FIELD_GRIDCOLALIGN, this.getGridColAlign());
        }
        if (!bl || this.isGridColCLModeDirty()) {
            hashMap.put(FIELD_GRIDCOLCLMODE, this.getGridColCLMode());
        }
        if (!bl || this.isGridColWidthDirty()) {
            hashMap.put(FIELD_GRIDCOLWIDTH, this.getGridColWidth());
        }
        if (!bl || this.isJSFormatDirty()) {
            hashMap.put(FIELD_JSFORMAT, this.getJSFormat());
        }
        if (!bl || this.isMaxValueDirty()) {
            hashMap.put(FIELD_MAXVALUE, this.getMaxValue());
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
        if (!bl || this.isMinValueDirty()) {
            hashMap.put(FIELD_MINVALUE, this.getMinValue());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPrecision2Dirty()) {
            hashMap.put(FIELD_PRECISION2, this.getPrecision2());
        }
        if (!bl || this.isPSCodeListIdDirty()) {
            hashMap.put(FIELD_PSCODELISTID, this.getPSCodeListId());
        }
        if (!bl || this.isPSCodeListNameDirty()) {
            hashMap.put(FIELD_PSCODELISTNAME, this.getPSCodeListName());
        }
        if (!bl || this.isPSDEFTypeIdDirty()) {
            hashMap.put(FIELD_PSDEFTYPEID, this.getPSDEFTypeId());
        }
        if (!bl || this.isPSDEFTypeNameDirty()) {
            hashMap.put(FIELD_PSDEFTYPENAME, this.getPSDEFTypeName());
        }
        if (!bl || this.isPSSysDEFTypeIdDirty()) {
            hashMap.put(FIELD_PSSYSDEFTYPEID, this.getPSSysDEFTypeId());
        }
        if (!bl || this.isPSSysDEFTypeNameDirty()) {
            hashMap.put(FIELD_PSSYSDEFTYPENAME, this.getPSSysDEFTypeName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSSysUnitIdDirty()) {
            hashMap.put(FIELD_PSSYSUNITID, this.getPSSysUnitId());
        }
        if (!bl || this.isPSSysUnitNameDirty()) {
            hashMap.put(FIELD_PSSYSUNITNAME, this.getPSSysUnitName());
        }
        if (!bl || this.isPSSysValueRuleIdDirty()) {
            hashMap.put(FIELD_PSSYSVALUERULEID, this.getPSSysValueRuleId());
        }
        if (!bl || this.isPSSysValueRuleNameDirty()) {
            hashMap.put(FIELD_PSSYSVALUERULENAME, this.getPSSysValueRuleName());
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
        if (!bl || this.isStdDataTypeDirty()) {
            hashMap.put(FIELD_STDDATATYPE, this.getStdDataType());
        }
        if (!bl || this.isStrLengthDirty()) {
            hashMap.put(FIELD_STRLENGTH, this.getStrLength());
        }
        if (!bl || this.isTSFormatDirty()) {
            hashMap.put(FIELD_TSFORMAT, this.getTSFormat());
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
        if (!bl || this.isValueFormatDirty()) {
            hashMap.put(FIELD_VALUEFORMAT, this.getValueFormat());
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
        return PSSysDEFTypeBase.get(this, n);
    }

    private static Object get(PSSysDEFTypeBase pSSysDEFTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDEFTypeBase.getCreateDate();
            }
            case 1: {
                return pSSysDEFTypeBase.getCreateMan();
            }
            case 2: {
                return pSSysDEFTypeBase.getEditorHeight();
            }
            case 3: {
                return pSSysDEFTypeBase.getEditorType();
            }
            case 4: {
                return pSSysDEFTypeBase.getEditorWidth();
            }
            case 5: {
                return pSSysDEFTypeBase.getFields();
            }
            case 6: {
                return pSSysDEFTypeBase.getGridColAlign();
            }
            case 7: {
                return pSSysDEFTypeBase.getGridColCLMode();
            }
            case 8: {
                return pSSysDEFTypeBase.getGridColWidth();
            }
            case 9: {
                return pSSysDEFTypeBase.getJSFormat();
            }
            case 10: {
                return pSSysDEFTypeBase.getMaxValue();
            }
            case 11: {
                return pSSysDEFTypeBase.getMBEditorHeight();
            }
            case 12: {
                return pSSysDEFTypeBase.getMBEditorType();
            }
            case 13: {
                return pSSysDEFTypeBase.getMBEditorWidth();
            }
            case 14: {
                return pSSysDEFTypeBase.getMemo();
            }
            case 15: {
                return pSSysDEFTypeBase.getMinStrLength();
            }
            case 16: {
                return pSSysDEFTypeBase.getMinValue();
            }
            case 17: {
                return pSSysDEFTypeBase.getOrderValue();
            }
            case 18: {
                return pSSysDEFTypeBase.getPrecision2();
            }
            case 19: {
                return pSSysDEFTypeBase.getPSCodeListId();
            }
            case 20: {
                return pSSysDEFTypeBase.getPSCodeListName();
            }
            case 21: {
                return pSSysDEFTypeBase.getPSDEFTypeId();
            }
            case 22: {
                return pSSysDEFTypeBase.getPSDEFTypeName();
            }
            case 23: {
                return pSSysDEFTypeBase.getPSSysDEFTypeId();
            }
            case 24: {
                return pSSysDEFTypeBase.getPSSysDEFTypeName();
            }
            case 25: {
                return pSSysDEFTypeBase.getPSSystemId();
            }
            case 26: {
                return pSSysDEFTypeBase.getPSSystemName();
            }
            case 27: {
                return pSSysDEFTypeBase.getPSSysUnitId();
            }
            case 28: {
                return pSSysDEFTypeBase.getPSSysUnitName();
            }
            case 29: {
                return pSSysDEFTypeBase.getPSSysValueRuleId();
            }
            case 30: {
                return pSSysDEFTypeBase.getPSSysValueRuleName();
            }
            case 31: {
                return pSSysDEFTypeBase.getPYFormat();
            }
            case 32: {
                return pSSysDEFTypeBase.getSearchEditorHeight();
            }
            case 33: {
                return pSSysDEFTypeBase.getSearchEditorType();
            }
            case 34: {
                return pSSysDEFTypeBase.getSearchEditorWidth();
            }
            case 35: {
                return pSSysDEFTypeBase.getSearchMBEditorHeight();
            }
            case 36: {
                return pSSysDEFTypeBase.getSearchMBEditorType();
            }
            case 37: {
                return pSSysDEFTypeBase.getSearchMBEditorWidth();
            }
            case 38: {
                return pSSysDEFTypeBase.getStdDataType();
            }
            case 39: {
                return pSSysDEFTypeBase.getStrLength();
            }
            case 40: {
                return pSSysDEFTypeBase.getTSFormat();
            }
            case 41: {
                return pSSysDEFTypeBase.getUpdateDate();
            }
            case 42: {
                return pSSysDEFTypeBase.getUpdateMan();
            }
            case 43: {
                return pSSysDEFTypeBase.getValidFlag();
            }
            case 44: {
                return pSSysDEFTypeBase.getValueFormat();
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
        PSSysDEFTypeBase.set(this, n, object);
    }

    private static void set(PSSysDEFTypeBase pSSysDEFTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDEFTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysDEFTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysDEFTypeBase.setEditorHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSSysDEFTypeBase.setEditorType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysDEFTypeBase.setEditorWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSSysDEFTypeBase.setFields(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysDEFTypeBase.setGridColAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysDEFTypeBase.setGridColCLMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysDEFTypeBase.setGridColWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSSysDEFTypeBase.setJSFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysDEFTypeBase.setMaxValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysDEFTypeBase.setMBEditorHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSSysDEFTypeBase.setMBEditorType(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysDEFTypeBase.setMBEditorWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSSysDEFTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysDEFTypeBase.setMinStrLength(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSSysDEFTypeBase.setMinValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysDEFTypeBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSSysDEFTypeBase.setPrecision2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSSysDEFTypeBase.setPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysDEFTypeBase.setPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysDEFTypeBase.setPSDEFTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysDEFTypeBase.setPSDEFTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysDEFTypeBase.setPSSysDEFTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysDEFTypeBase.setPSSysDEFTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysDEFTypeBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysDEFTypeBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysDEFTypeBase.setPSSysUnitId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysDEFTypeBase.setPSSysUnitName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysDEFTypeBase.setPSSysValueRuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysDEFTypeBase.setPSSysValueRuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysDEFTypeBase.setPYFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysDEFTypeBase.setSearchEditorHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSSysDEFTypeBase.setSearchEditorType(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysDEFTypeBase.setSearchEditorWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSSysDEFTypeBase.setSearchMBEditorHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 36: {
                pSSysDEFTypeBase.setSearchMBEditorType(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysDEFTypeBase.setSearchMBEditorWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 38: {
                pSSysDEFTypeBase.setStdDataType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 39: {
                pSSysDEFTypeBase.setStrLength(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 40: {
                pSSysDEFTypeBase.setTSFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysDEFTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 42: {
                pSSysDEFTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSysDEFTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 44: {
                pSSysDEFTypeBase.setValueFormat(DataObject.getStringValue((Object)object));
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
        return PSSysDEFTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDEFTypeBase pSSysDEFTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDEFTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysDEFTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysDEFTypeBase.getEditorHeight() == null;
            }
            case 3: {
                return pSSysDEFTypeBase.getEditorType() == null;
            }
            case 4: {
                return pSSysDEFTypeBase.getEditorWidth() == null;
            }
            case 5: {
                return pSSysDEFTypeBase.getFields() == null;
            }
            case 6: {
                return pSSysDEFTypeBase.getGridColAlign() == null;
            }
            case 7: {
                return pSSysDEFTypeBase.getGridColCLMode() == null;
            }
            case 8: {
                return pSSysDEFTypeBase.getGridColWidth() == null;
            }
            case 9: {
                return pSSysDEFTypeBase.getJSFormat() == null;
            }
            case 10: {
                return pSSysDEFTypeBase.getMaxValue() == null;
            }
            case 11: {
                return pSSysDEFTypeBase.getMBEditorHeight() == null;
            }
            case 12: {
                return pSSysDEFTypeBase.getMBEditorType() == null;
            }
            case 13: {
                return pSSysDEFTypeBase.getMBEditorWidth() == null;
            }
            case 14: {
                return pSSysDEFTypeBase.getMemo() == null;
            }
            case 15: {
                return pSSysDEFTypeBase.getMinStrLength() == null;
            }
            case 16: {
                return pSSysDEFTypeBase.getMinValue() == null;
            }
            case 17: {
                return pSSysDEFTypeBase.getOrderValue() == null;
            }
            case 18: {
                return pSSysDEFTypeBase.getPrecision2() == null;
            }
            case 19: {
                return pSSysDEFTypeBase.getPSCodeListId() == null;
            }
            case 20: {
                return pSSysDEFTypeBase.getPSCodeListName() == null;
            }
            case 21: {
                return pSSysDEFTypeBase.getPSDEFTypeId() == null;
            }
            case 22: {
                return pSSysDEFTypeBase.getPSDEFTypeName() == null;
            }
            case 23: {
                return pSSysDEFTypeBase.getPSSysDEFTypeId() == null;
            }
            case 24: {
                return pSSysDEFTypeBase.getPSSysDEFTypeName() == null;
            }
            case 25: {
                return pSSysDEFTypeBase.getPSSystemId() == null;
            }
            case 26: {
                return pSSysDEFTypeBase.getPSSystemName() == null;
            }
            case 27: {
                return pSSysDEFTypeBase.getPSSysUnitId() == null;
            }
            case 28: {
                return pSSysDEFTypeBase.getPSSysUnitName() == null;
            }
            case 29: {
                return pSSysDEFTypeBase.getPSSysValueRuleId() == null;
            }
            case 30: {
                return pSSysDEFTypeBase.getPSSysValueRuleName() == null;
            }
            case 31: {
                return pSSysDEFTypeBase.getPYFormat() == null;
            }
            case 32: {
                return pSSysDEFTypeBase.getSearchEditorHeight() == null;
            }
            case 33: {
                return pSSysDEFTypeBase.getSearchEditorType() == null;
            }
            case 34: {
                return pSSysDEFTypeBase.getSearchEditorWidth() == null;
            }
            case 35: {
                return pSSysDEFTypeBase.getSearchMBEditorHeight() == null;
            }
            case 36: {
                return pSSysDEFTypeBase.getSearchMBEditorType() == null;
            }
            case 37: {
                return pSSysDEFTypeBase.getSearchMBEditorWidth() == null;
            }
            case 38: {
                return pSSysDEFTypeBase.getStdDataType() == null;
            }
            case 39: {
                return pSSysDEFTypeBase.getStrLength() == null;
            }
            case 40: {
                return pSSysDEFTypeBase.getTSFormat() == null;
            }
            case 41: {
                return pSSysDEFTypeBase.getUpdateDate() == null;
            }
            case 42: {
                return pSSysDEFTypeBase.getUpdateMan() == null;
            }
            case 43: {
                return pSSysDEFTypeBase.getValidFlag() == null;
            }
            case 44: {
                return pSSysDEFTypeBase.getValueFormat() == null;
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
        return PSSysDEFTypeBase.contains(this, n);
    }

    private static boolean contains(PSSysDEFTypeBase pSSysDEFTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDEFTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysDEFTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSSysDEFTypeBase.isEditorHeightDirty();
            }
            case 3: {
                return pSSysDEFTypeBase.isEditorTypeDirty();
            }
            case 4: {
                return pSSysDEFTypeBase.isEditorWidthDirty();
            }
            case 5: {
                return pSSysDEFTypeBase.isFieldsDirty();
            }
            case 6: {
                return pSSysDEFTypeBase.isGridColAlignDirty();
            }
            case 7: {
                return pSSysDEFTypeBase.isGridColCLModeDirty();
            }
            case 8: {
                return pSSysDEFTypeBase.isGridColWidthDirty();
            }
            case 9: {
                return pSSysDEFTypeBase.isJSFormatDirty();
            }
            case 10: {
                return pSSysDEFTypeBase.isMaxValueDirty();
            }
            case 11: {
                return pSSysDEFTypeBase.isMBEditorHeightDirty();
            }
            case 12: {
                return pSSysDEFTypeBase.isMBEditorTypeDirty();
            }
            case 13: {
                return pSSysDEFTypeBase.isMBEditorWidthDirty();
            }
            case 14: {
                return pSSysDEFTypeBase.isMemoDirty();
            }
            case 15: {
                return pSSysDEFTypeBase.isMinStrLengthDirty();
            }
            case 16: {
                return pSSysDEFTypeBase.isMinValueDirty();
            }
            case 17: {
                return pSSysDEFTypeBase.isOrderValueDirty();
            }
            case 18: {
                return pSSysDEFTypeBase.isPrecision2Dirty();
            }
            case 19: {
                return pSSysDEFTypeBase.isPSCodeListIdDirty();
            }
            case 20: {
                return pSSysDEFTypeBase.isPSCodeListNameDirty();
            }
            case 21: {
                return pSSysDEFTypeBase.isPSDEFTypeIdDirty();
            }
            case 22: {
                return pSSysDEFTypeBase.isPSDEFTypeNameDirty();
            }
            case 23: {
                return pSSysDEFTypeBase.isPSSysDEFTypeIdDirty();
            }
            case 24: {
                return pSSysDEFTypeBase.isPSSysDEFTypeNameDirty();
            }
            case 25: {
                return pSSysDEFTypeBase.isPSSystemIdDirty();
            }
            case 26: {
                return pSSysDEFTypeBase.isPSSystemNameDirty();
            }
            case 27: {
                return pSSysDEFTypeBase.isPSSysUnitIdDirty();
            }
            case 28: {
                return pSSysDEFTypeBase.isPSSysUnitNameDirty();
            }
            case 29: {
                return pSSysDEFTypeBase.isPSSysValueRuleIdDirty();
            }
            case 30: {
                return pSSysDEFTypeBase.isPSSysValueRuleNameDirty();
            }
            case 31: {
                return pSSysDEFTypeBase.isPYFormatDirty();
            }
            case 32: {
                return pSSysDEFTypeBase.isSearchEditorHeightDirty();
            }
            case 33: {
                return pSSysDEFTypeBase.isSearchEditorTypeDirty();
            }
            case 34: {
                return pSSysDEFTypeBase.isSearchEditorWidthDirty();
            }
            case 35: {
                return pSSysDEFTypeBase.isSearchMBEditorHeightDirty();
            }
            case 36: {
                return pSSysDEFTypeBase.isSearchMBEditorTypeDirty();
            }
            case 37: {
                return pSSysDEFTypeBase.isSearchMBEditorWidthDirty();
            }
            case 38: {
                return pSSysDEFTypeBase.isStdDataTypeDirty();
            }
            case 39: {
                return pSSysDEFTypeBase.isStrLengthDirty();
            }
            case 40: {
                return pSSysDEFTypeBase.isTSFormatDirty();
            }
            case 41: {
                return pSSysDEFTypeBase.isUpdateDateDirty();
            }
            case 42: {
                return pSSysDEFTypeBase.isUpdateManDirty();
            }
            case 43: {
                return pSSysDEFTypeBase.isValidFlagDirty();
            }
            case 44: {
                return pSSysDEFTypeBase.isValueFormatDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDEFTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDEFTypeBase pSSysDEFTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDEFTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getEditorHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editorheight", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getEditorHeight()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getEditorType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editortype", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getEditorType()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getEditorWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editorwidth", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getEditorWidth()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getFields() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fields", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getFields()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getGridColAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gridcolalign", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getGridColAlign()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getGridColCLMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gridcolclmode", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getGridColCLMode()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getGridColWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gridcolwidth", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getGridColWidth()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getJSFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jsformat", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getJSFormat()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getMaxValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxvalue", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getMaxValue()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getMBEditorHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mbeditorheight", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getMBEditorHeight()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getMBEditorType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mbeditortype", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getMBEditorType()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getMBEditorWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mbeditorwidth", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getMBEditorWidth()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getMinStrLength() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minstrlength", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getMinStrLength()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getMinValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minvalue", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getMinValue()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getPrecision2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"precision2", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getPrecision2()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistid", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getPSCodeListId()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistname", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getPSCodeListName()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getPSDEFTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeftypeid", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getPSDEFTypeId()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getPSDEFTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeftypename", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getPSDEFTypeName()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getPSSysDEFTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdeftypeid", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getPSSysDEFTypeId()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getPSSysDEFTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdeftypename", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getPSSysDEFTypeName()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getPSSysUnitId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysunitid", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getPSSysUnitId()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getPSSysUnitName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysunitname", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getPSSysUnitName()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getPSSysValueRuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysvalueruleid", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getPSSysValueRuleId()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getPSSysValueRuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysvaluerulename", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getPSSysValueRuleName()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getPYFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pyformat", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getPYFormat()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getSearchEditorHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"searcheditorheight", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getSearchEditorHeight()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getSearchEditorType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"searcheditortype", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getSearchEditorType()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getSearchEditorWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"searcheditorwidth", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getSearchEditorWidth()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getSearchMBEditorHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"searchmbeditorheight", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getSearchMBEditorHeight()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getSearchMBEditorType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"searchmbeditortype", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getSearchMBEditorType()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getSearchMBEditorWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"searchmbeditorwidth", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getSearchMBEditorWidth()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getStdDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stddatatype", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getStdDataType()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getStrLength() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"strlength", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getStrLength()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getTSFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tsformat", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getTSFormat()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSSysDEFTypeBase.getValueFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valueformat", (Object)PSSysDEFTypeBase.getJSONValue((Object)pSSysDEFTypeBase.getValueFormat()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDEFTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDEFTypeBase pSSysDEFTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDEFTypeBase.getCreateDate() != null) {
            object = pSSysDEFTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDEFTypeBase.getCreateMan() != null) {
            object = pSSysDEFTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDEFTypeBase.getEditorHeight() != null) {
            object = pSSysDEFTypeBase.getEditorHeight();
            xmlNode.setAttribute(FIELD_EDITORHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDEFTypeBase.getEditorType() != null) {
            object = pSSysDEFTypeBase.getEditorType();
            xmlNode.setAttribute(FIELD_EDITORTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDEFTypeBase.getEditorWidth() != null) {
            object = pSSysDEFTypeBase.getEditorWidth();
            xmlNode.setAttribute(FIELD_EDITORWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDEFTypeBase.getFields() != null) {
            object = pSSysDEFTypeBase.getFields();
            xmlNode.setAttribute(FIELD_FIELDS, object == null ? "" : (String)object);
        }
        if (bl || pSSysDEFTypeBase.getGridColAlign() != null) {
            object = pSSysDEFTypeBase.getGridColAlign();
            xmlNode.setAttribute(FIELD_GRIDCOLALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDEFTypeBase.getGridColCLMode() != null) {
            object = pSSysDEFTypeBase.getGridColCLMode();
            xmlNode.setAttribute(FIELD_GRIDCOLCLMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDEFTypeBase.getGridColWidth() != null) {
            object = pSSysDEFTypeBase.getGridColWidth();
            xmlNode.setAttribute(FIELD_GRIDCOLWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDEFTypeBase.getJSFormat() != null) {
            object = pSSysDEFTypeBase.getJSFormat();
            xmlNode.setAttribute(FIELD_JSFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysDEFTypeBase.getMaxValue() != null) {
            object = pSSysDEFTypeBase.getMaxValue();
            xmlNode.setAttribute(FIELD_MAXVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDEFTypeBase.getMBEditorHeight() != null) {
            object = pSSysDEFTypeBase.getMBEditorHeight();
            xmlNode.setAttribute(FIELD_MBEDITORHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDEFTypeBase.getMBEditorType() != null) {
            object = pSSysDEFTypeBase.getMBEditorType();
            xmlNode.setAttribute(FIELD_MBEDITORTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDEFTypeBase.getMBEditorWidth() != null) {
            object = pSSysDEFTypeBase.getMBEditorWidth();
            xmlNode.setAttribute(FIELD_MBEDITORWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDEFTypeBase.getMemo() != null) {
            object = pSSysDEFTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDEFTypeBase.getMinStrLength() != null) {
            object = pSSysDEFTypeBase.getMinStrLength();
            xmlNode.setAttribute(FIELD_MINSTRLENGTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDEFTypeBase.getMinValue() != null) {
            object = pSSysDEFTypeBase.getMinValue();
            xmlNode.setAttribute(FIELD_MINVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDEFTypeBase.getOrderValue() != null) {
            object = pSSysDEFTypeBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDEFTypeBase.getPrecision2() != null) {
            object = pSSysDEFTypeBase.getPrecision2();
            xmlNode.setAttribute(FIELD_PRECISION2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDEFTypeBase.getPSCodeListId() != null) {
            object = pSSysDEFTypeBase.getPSCodeListId();
            xmlNode.setAttribute(FIELD_PSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDEFTypeBase.getPSCodeListName() != null) {
            object = pSSysDEFTypeBase.getPSCodeListName();
            xmlNode.setAttribute(FIELD_PSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDEFTypeBase.getPSDEFTypeId() != null) {
            object = pSSysDEFTypeBase.getPSDEFTypeId();
            xmlNode.setAttribute(FIELD_PSDEFTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDEFTypeBase.getPSDEFTypeName() != null) {
            object = pSSysDEFTypeBase.getPSDEFTypeName();
            xmlNode.setAttribute(FIELD_PSDEFTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDEFTypeBase.getPSSysDEFTypeId() != null) {
            object = pSSysDEFTypeBase.getPSSysDEFTypeId();
            xmlNode.setAttribute(FIELD_PSSYSDEFTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDEFTypeBase.getPSSysDEFTypeName() != null) {
            object = pSSysDEFTypeBase.getPSSysDEFTypeName();
            xmlNode.setAttribute(FIELD_PSSYSDEFTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDEFTypeBase.getPSSystemId() != null) {
            object = pSSysDEFTypeBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDEFTypeBase.getPSSystemName() != null) {
            object = pSSysDEFTypeBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDEFTypeBase.getPSSysUnitId() != null) {
            object = pSSysDEFTypeBase.getPSSysUnitId();
            xmlNode.setAttribute(FIELD_PSSYSUNITID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDEFTypeBase.getPSSysUnitName() != null) {
            object = pSSysDEFTypeBase.getPSSysUnitName();
            xmlNode.setAttribute(FIELD_PSSYSUNITNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDEFTypeBase.getPSSysValueRuleId() != null) {
            object = pSSysDEFTypeBase.getPSSysValueRuleId();
            xmlNode.setAttribute(FIELD_PSSYSVALUERULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDEFTypeBase.getPSSysValueRuleName() != null) {
            object = pSSysDEFTypeBase.getPSSysValueRuleName();
            xmlNode.setAttribute(FIELD_PSSYSVALUERULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDEFTypeBase.getPYFormat() != null) {
            object = pSSysDEFTypeBase.getPYFormat();
            xmlNode.setAttribute(FIELD_PYFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysDEFTypeBase.getSearchEditorHeight() != null) {
            object = pSSysDEFTypeBase.getSearchEditorHeight();
            xmlNode.setAttribute(FIELD_SEARCHEDITORHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDEFTypeBase.getSearchEditorType() != null) {
            object = pSSysDEFTypeBase.getSearchEditorType();
            xmlNode.setAttribute(FIELD_SEARCHEDITORTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDEFTypeBase.getSearchEditorWidth() != null) {
            object = pSSysDEFTypeBase.getSearchEditorWidth();
            xmlNode.setAttribute(FIELD_SEARCHEDITORWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDEFTypeBase.getSearchMBEditorHeight() != null) {
            object = pSSysDEFTypeBase.getSearchMBEditorHeight();
            xmlNode.setAttribute(FIELD_SEARCHMBEDITORHEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDEFTypeBase.getSearchMBEditorType() != null) {
            object = pSSysDEFTypeBase.getSearchMBEditorType();
            xmlNode.setAttribute(FIELD_SEARCHMBEDITORTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDEFTypeBase.getSearchMBEditorWidth() != null) {
            object = pSSysDEFTypeBase.getSearchMBEditorWidth();
            xmlNode.setAttribute(FIELD_SEARCHMBEDITORWIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDEFTypeBase.getStdDataType() != null) {
            object = pSSysDEFTypeBase.getStdDataType();
            xmlNode.setAttribute(FIELD_STDDATATYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDEFTypeBase.getStrLength() != null) {
            object = pSSysDEFTypeBase.getStrLength();
            xmlNode.setAttribute(FIELD_STRLENGTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDEFTypeBase.getTSFormat() != null) {
            object = pSSysDEFTypeBase.getTSFormat();
            xmlNode.setAttribute(FIELD_TSFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysDEFTypeBase.getUpdateDate() != null) {
            object = pSSysDEFTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDEFTypeBase.getUpdateMan() != null) {
            object = pSSysDEFTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDEFTypeBase.getValidFlag() != null) {
            object = pSSysDEFTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDEFTypeBase.getValueFormat() != null) {
            object = pSSysDEFTypeBase.getValueFormat();
            xmlNode.setAttribute(FIELD_VALUEFORMAT, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDEFTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDEFTypeBase pSSysDEFTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDEFTypeBase.isCreateDateDirty() && (bl || pSSysDEFTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDEFTypeBase.getCreateDate());
        }
        if (pSSysDEFTypeBase.isCreateManDirty() && (bl || pSSysDEFTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDEFTypeBase.getCreateMan());
        }
        if (pSSysDEFTypeBase.isEditorHeightDirty() && (bl || pSSysDEFTypeBase.getEditorHeight() != null)) {
            iDataObject.set(FIELD_EDITORHEIGHT, (Object)pSSysDEFTypeBase.getEditorHeight());
        }
        if (pSSysDEFTypeBase.isEditorTypeDirty() && (bl || pSSysDEFTypeBase.getEditorType() != null)) {
            iDataObject.set(FIELD_EDITORTYPE, (Object)pSSysDEFTypeBase.getEditorType());
        }
        if (pSSysDEFTypeBase.isEditorWidthDirty() && (bl || pSSysDEFTypeBase.getEditorWidth() != null)) {
            iDataObject.set(FIELD_EDITORWIDTH, (Object)pSSysDEFTypeBase.getEditorWidth());
        }
        if (pSSysDEFTypeBase.isFieldsDirty() && (bl || pSSysDEFTypeBase.getFields() != null)) {
            iDataObject.set(FIELD_FIELDS, (Object)pSSysDEFTypeBase.getFields());
        }
        if (pSSysDEFTypeBase.isGridColAlignDirty() && (bl || pSSysDEFTypeBase.getGridColAlign() != null)) {
            iDataObject.set(FIELD_GRIDCOLALIGN, (Object)pSSysDEFTypeBase.getGridColAlign());
        }
        if (pSSysDEFTypeBase.isGridColCLModeDirty() && (bl || pSSysDEFTypeBase.getGridColCLMode() != null)) {
            iDataObject.set(FIELD_GRIDCOLCLMODE, (Object)pSSysDEFTypeBase.getGridColCLMode());
        }
        if (pSSysDEFTypeBase.isGridColWidthDirty() && (bl || pSSysDEFTypeBase.getGridColWidth() != null)) {
            iDataObject.set(FIELD_GRIDCOLWIDTH, (Object)pSSysDEFTypeBase.getGridColWidth());
        }
        if (pSSysDEFTypeBase.isJSFormatDirty() && (bl || pSSysDEFTypeBase.getJSFormat() != null)) {
            iDataObject.set(FIELD_JSFORMAT, (Object)pSSysDEFTypeBase.getJSFormat());
        }
        if (pSSysDEFTypeBase.isMaxValueDirty() && (bl || pSSysDEFTypeBase.getMaxValue() != null)) {
            iDataObject.set(FIELD_MAXVALUE, (Object)pSSysDEFTypeBase.getMaxValue());
        }
        if (pSSysDEFTypeBase.isMBEditorHeightDirty() && (bl || pSSysDEFTypeBase.getMBEditorHeight() != null)) {
            iDataObject.set(FIELD_MBEDITORHEIGHT, (Object)pSSysDEFTypeBase.getMBEditorHeight());
        }
        if (pSSysDEFTypeBase.isMBEditorTypeDirty() && (bl || pSSysDEFTypeBase.getMBEditorType() != null)) {
            iDataObject.set(FIELD_MBEDITORTYPE, (Object)pSSysDEFTypeBase.getMBEditorType());
        }
        if (pSSysDEFTypeBase.isMBEditorWidthDirty() && (bl || pSSysDEFTypeBase.getMBEditorWidth() != null)) {
            iDataObject.set(FIELD_MBEDITORWIDTH, (Object)pSSysDEFTypeBase.getMBEditorWidth());
        }
        if (pSSysDEFTypeBase.isMemoDirty() && (bl || pSSysDEFTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysDEFTypeBase.getMemo());
        }
        if (pSSysDEFTypeBase.isMinStrLengthDirty() && (bl || pSSysDEFTypeBase.getMinStrLength() != null)) {
            iDataObject.set(FIELD_MINSTRLENGTH, (Object)pSSysDEFTypeBase.getMinStrLength());
        }
        if (pSSysDEFTypeBase.isMinValueDirty() && (bl || pSSysDEFTypeBase.getMinValue() != null)) {
            iDataObject.set(FIELD_MINVALUE, (Object)pSSysDEFTypeBase.getMinValue());
        }
        if (pSSysDEFTypeBase.isOrderValueDirty() && (bl || pSSysDEFTypeBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysDEFTypeBase.getOrderValue());
        }
        if (pSSysDEFTypeBase.isPrecision2Dirty() && (bl || pSSysDEFTypeBase.getPrecision2() != null)) {
            iDataObject.set(FIELD_PRECISION2, (Object)pSSysDEFTypeBase.getPrecision2());
        }
        if (pSSysDEFTypeBase.isPSCodeListIdDirty() && (bl || pSSysDEFTypeBase.getPSCodeListId() != null)) {
            iDataObject.set(FIELD_PSCODELISTID, (Object)pSSysDEFTypeBase.getPSCodeListId());
        }
        if (pSSysDEFTypeBase.isPSCodeListNameDirty() && (bl || pSSysDEFTypeBase.getPSCodeListName() != null)) {
            iDataObject.set(FIELD_PSCODELISTNAME, (Object)pSSysDEFTypeBase.getPSCodeListName());
        }
        if (pSSysDEFTypeBase.isPSDEFTypeIdDirty() && (bl || pSSysDEFTypeBase.getPSDEFTypeId() != null)) {
            iDataObject.set(FIELD_PSDEFTYPEID, (Object)pSSysDEFTypeBase.getPSDEFTypeId());
        }
        if (pSSysDEFTypeBase.isPSDEFTypeNameDirty() && (bl || pSSysDEFTypeBase.getPSDEFTypeName() != null)) {
            iDataObject.set(FIELD_PSDEFTYPENAME, (Object)pSSysDEFTypeBase.getPSDEFTypeName());
        }
        if (pSSysDEFTypeBase.isPSSysDEFTypeIdDirty() && (bl || pSSysDEFTypeBase.getPSSysDEFTypeId() != null)) {
            iDataObject.set(FIELD_PSSYSDEFTYPEID, (Object)pSSysDEFTypeBase.getPSSysDEFTypeId());
        }
        if (pSSysDEFTypeBase.isPSSysDEFTypeNameDirty() && (bl || pSSysDEFTypeBase.getPSSysDEFTypeName() != null)) {
            iDataObject.set(FIELD_PSSYSDEFTYPENAME, (Object)pSSysDEFTypeBase.getPSSysDEFTypeName());
        }
        if (pSSysDEFTypeBase.isPSSystemIdDirty() && (bl || pSSysDEFTypeBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysDEFTypeBase.getPSSystemId());
        }
        if (pSSysDEFTypeBase.isPSSystemNameDirty() && (bl || pSSysDEFTypeBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysDEFTypeBase.getPSSystemName());
        }
        if (pSSysDEFTypeBase.isPSSysUnitIdDirty() && (bl || pSSysDEFTypeBase.getPSSysUnitId() != null)) {
            iDataObject.set(FIELD_PSSYSUNITID, (Object)pSSysDEFTypeBase.getPSSysUnitId());
        }
        if (pSSysDEFTypeBase.isPSSysUnitNameDirty() && (bl || pSSysDEFTypeBase.getPSSysUnitName() != null)) {
            iDataObject.set(FIELD_PSSYSUNITNAME, (Object)pSSysDEFTypeBase.getPSSysUnitName());
        }
        if (pSSysDEFTypeBase.isPSSysValueRuleIdDirty() && (bl || pSSysDEFTypeBase.getPSSysValueRuleId() != null)) {
            iDataObject.set(FIELD_PSSYSVALUERULEID, (Object)pSSysDEFTypeBase.getPSSysValueRuleId());
        }
        if (pSSysDEFTypeBase.isPSSysValueRuleNameDirty() && (bl || pSSysDEFTypeBase.getPSSysValueRuleName() != null)) {
            iDataObject.set(FIELD_PSSYSVALUERULENAME, (Object)pSSysDEFTypeBase.getPSSysValueRuleName());
        }
        if (pSSysDEFTypeBase.isPYFormatDirty() && (bl || pSSysDEFTypeBase.getPYFormat() != null)) {
            iDataObject.set(FIELD_PYFORMAT, (Object)pSSysDEFTypeBase.getPYFormat());
        }
        if (pSSysDEFTypeBase.isSearchEditorHeightDirty() && (bl || pSSysDEFTypeBase.getSearchEditorHeight() != null)) {
            iDataObject.set(FIELD_SEARCHEDITORHEIGHT, (Object)pSSysDEFTypeBase.getSearchEditorHeight());
        }
        if (pSSysDEFTypeBase.isSearchEditorTypeDirty() && (bl || pSSysDEFTypeBase.getSearchEditorType() != null)) {
            iDataObject.set(FIELD_SEARCHEDITORTYPE, (Object)pSSysDEFTypeBase.getSearchEditorType());
        }
        if (pSSysDEFTypeBase.isSearchEditorWidthDirty() && (bl || pSSysDEFTypeBase.getSearchEditorWidth() != null)) {
            iDataObject.set(FIELD_SEARCHEDITORWIDTH, (Object)pSSysDEFTypeBase.getSearchEditorWidth());
        }
        if (pSSysDEFTypeBase.isSearchMBEditorHeightDirty() && (bl || pSSysDEFTypeBase.getSearchMBEditorHeight() != null)) {
            iDataObject.set(FIELD_SEARCHMBEDITORHEIGHT, (Object)pSSysDEFTypeBase.getSearchMBEditorHeight());
        }
        if (pSSysDEFTypeBase.isSearchMBEditorTypeDirty() && (bl || pSSysDEFTypeBase.getSearchMBEditorType() != null)) {
            iDataObject.set(FIELD_SEARCHMBEDITORTYPE, (Object)pSSysDEFTypeBase.getSearchMBEditorType());
        }
        if (pSSysDEFTypeBase.isSearchMBEditorWidthDirty() && (bl || pSSysDEFTypeBase.getSearchMBEditorWidth() != null)) {
            iDataObject.set(FIELD_SEARCHMBEDITORWIDTH, (Object)pSSysDEFTypeBase.getSearchMBEditorWidth());
        }
        if (pSSysDEFTypeBase.isStdDataTypeDirty() && (bl || pSSysDEFTypeBase.getStdDataType() != null)) {
            iDataObject.set(FIELD_STDDATATYPE, (Object)pSSysDEFTypeBase.getStdDataType());
        }
        if (pSSysDEFTypeBase.isStrLengthDirty() && (bl || pSSysDEFTypeBase.getStrLength() != null)) {
            iDataObject.set(FIELD_STRLENGTH, (Object)pSSysDEFTypeBase.getStrLength());
        }
        if (pSSysDEFTypeBase.isTSFormatDirty() && (bl || pSSysDEFTypeBase.getTSFormat() != null)) {
            iDataObject.set(FIELD_TSFORMAT, (Object)pSSysDEFTypeBase.getTSFormat());
        }
        if (pSSysDEFTypeBase.isUpdateDateDirty() && (bl || pSSysDEFTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDEFTypeBase.getUpdateDate());
        }
        if (pSSysDEFTypeBase.isUpdateManDirty() && (bl || pSSysDEFTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDEFTypeBase.getUpdateMan());
        }
        if (pSSysDEFTypeBase.isValidFlagDirty() && (bl || pSSysDEFTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysDEFTypeBase.getValidFlag());
        }
        if (pSSysDEFTypeBase.isValueFormatDirty() && (bl || pSSysDEFTypeBase.getValueFormat() != null)) {
            iDataObject.set(FIELD_VALUEFORMAT, (Object)pSSysDEFTypeBase.getValueFormat());
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
        return PSSysDEFTypeBase.remove(this, n);
    }

    private static boolean remove(PSSysDEFTypeBase pSSysDEFTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDEFTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysDEFTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysDEFTypeBase.resetEditorHeight();
                return true;
            }
            case 3: {
                pSSysDEFTypeBase.resetEditorType();
                return true;
            }
            case 4: {
                pSSysDEFTypeBase.resetEditorWidth();
                return true;
            }
            case 5: {
                pSSysDEFTypeBase.resetFields();
                return true;
            }
            case 6: {
                pSSysDEFTypeBase.resetGridColAlign();
                return true;
            }
            case 7: {
                pSSysDEFTypeBase.resetGridColCLMode();
                return true;
            }
            case 8: {
                pSSysDEFTypeBase.resetGridColWidth();
                return true;
            }
            case 9: {
                pSSysDEFTypeBase.resetJSFormat();
                return true;
            }
            case 10: {
                pSSysDEFTypeBase.resetMaxValue();
                return true;
            }
            case 11: {
                pSSysDEFTypeBase.resetMBEditorHeight();
                return true;
            }
            case 12: {
                pSSysDEFTypeBase.resetMBEditorType();
                return true;
            }
            case 13: {
                pSSysDEFTypeBase.resetMBEditorWidth();
                return true;
            }
            case 14: {
                pSSysDEFTypeBase.resetMemo();
                return true;
            }
            case 15: {
                pSSysDEFTypeBase.resetMinStrLength();
                return true;
            }
            case 16: {
                pSSysDEFTypeBase.resetMinValue();
                return true;
            }
            case 17: {
                pSSysDEFTypeBase.resetOrderValue();
                return true;
            }
            case 18: {
                pSSysDEFTypeBase.resetPrecision2();
                return true;
            }
            case 19: {
                pSSysDEFTypeBase.resetPSCodeListId();
                return true;
            }
            case 20: {
                pSSysDEFTypeBase.resetPSCodeListName();
                return true;
            }
            case 21: {
                pSSysDEFTypeBase.resetPSDEFTypeId();
                return true;
            }
            case 22: {
                pSSysDEFTypeBase.resetPSDEFTypeName();
                return true;
            }
            case 23: {
                pSSysDEFTypeBase.resetPSSysDEFTypeId();
                return true;
            }
            case 24: {
                pSSysDEFTypeBase.resetPSSysDEFTypeName();
                return true;
            }
            case 25: {
                pSSysDEFTypeBase.resetPSSystemId();
                return true;
            }
            case 26: {
                pSSysDEFTypeBase.resetPSSystemName();
                return true;
            }
            case 27: {
                pSSysDEFTypeBase.resetPSSysUnitId();
                return true;
            }
            case 28: {
                pSSysDEFTypeBase.resetPSSysUnitName();
                return true;
            }
            case 29: {
                pSSysDEFTypeBase.resetPSSysValueRuleId();
                return true;
            }
            case 30: {
                pSSysDEFTypeBase.resetPSSysValueRuleName();
                return true;
            }
            case 31: {
                pSSysDEFTypeBase.resetPYFormat();
                return true;
            }
            case 32: {
                pSSysDEFTypeBase.resetSearchEditorHeight();
                return true;
            }
            case 33: {
                pSSysDEFTypeBase.resetSearchEditorType();
                return true;
            }
            case 34: {
                pSSysDEFTypeBase.resetSearchEditorWidth();
                return true;
            }
            case 35: {
                pSSysDEFTypeBase.resetSearchMBEditorHeight();
                return true;
            }
            case 36: {
                pSSysDEFTypeBase.resetSearchMBEditorType();
                return true;
            }
            case 37: {
                pSSysDEFTypeBase.resetSearchMBEditorWidth();
                return true;
            }
            case 38: {
                pSSysDEFTypeBase.resetStdDataType();
                return true;
            }
            case 39: {
                pSSysDEFTypeBase.resetStrLength();
                return true;
            }
            case 40: {
                pSSysDEFTypeBase.resetTSFormat();
                return true;
            }
            case 41: {
                pSSysDEFTypeBase.resetUpdateDate();
                return true;
            }
            case 42: {
                pSSysDEFTypeBase.resetUpdateMan();
                return true;
            }
            case 43: {
                pSSysDEFTypeBase.resetValidFlag();
                return true;
            }
            case 44: {
                pSSysDEFTypeBase.resetValueFormat();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCodeList getPSCodeList() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeList();
        }
        if (this.getPSCodeListId() == null) {
            return null;
        }
        Integer n = this.objPSCodeListLock;
        synchronized (n) {
            if (this.pscodelist != null && DataTypeHelper.compare((int)25, (Object)this.getPSCodeListId(), (Object)this.pscodelist.getPSCodeListId()) != 0L) {
                this.pscodelist = null;
            }
            if (this.pscodelist == null) {
                PSCodeList pSCodeList = new PSCodeList();
                pSCodeList.setPSCodeListId(this.getPSCodeListId());
                PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
                pSCodeListService.autoGet((IEntity)pSCodeList);
                this.pscodelist = pSCodeList;
            }
            return this.pscodelist;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFType getPSDEFType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFType();
        }
        if (this.getPSDEFTypeId() == null) {
            return null;
        }
        Integer n = this.objPSDEFTypeLock;
        synchronized (n) {
            if (this.psdeftype != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFTypeId(), (Object)this.psdeftype.getPSDEFTypeId()) != 0L) {
                this.psdeftype = null;
            }
            if (this.psdeftype == null) {
                PSDEFType pSDEFType = new PSDEFType();
                pSDEFType.setPSDEFTypeId(this.getPSDEFTypeId());
                PSDEFTypeService pSDEFTypeService = (PSDEFTypeService)ServiceGlobal.getService(PSDEFTypeService.class, (SessionFactory)this.getSessionFactory());
                pSDEFTypeService.autoGet((IEntity)pSDEFType);
                this.psdeftype = pSDEFType;
            }
            return this.psdeftype;
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
                pSSystemService.autoGet((IEntity)pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysUnit getPSSysUnit() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUnit();
        }
        if (this.getPSSysUnitId() == null) {
            return null;
        }
        Integer n = this.objPSSysUnitLock;
        synchronized (n) {
            if (this.pssysunit != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUnitId(), (Object)this.pssysunit.getPSSysUnitId()) != 0L) {
                this.pssysunit = null;
            }
            if (this.pssysunit == null) {
                PSSysUnit pSSysUnit = new PSSysUnit();
                pSSysUnit.setPSSysUnitId(this.getPSSysUnitId());
                PSSysUnitService pSSysUnitService = (PSSysUnitService)ServiceGlobal.getService(PSSysUnitService.class, (SessionFactory)this.getSessionFactory());
                pSSysUnitService.autoGet((IEntity)pSSysUnit);
                this.pssysunit = pSSysUnit;
            }
            return this.pssysunit;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysValueRule getPSSysValueRule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysValueRule();
        }
        if (this.getPSSysValueRuleId() == null) {
            return null;
        }
        Integer n = this.objPSSysValueRuleLock;
        synchronized (n) {
            if (this.pssysvaluerule != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysValueRuleId(), (Object)this.pssysvaluerule.getPSSysValueRuleId()) != 0L) {
                this.pssysvaluerule = null;
            }
            if (this.pssysvaluerule == null) {
                PSSysValueRule pSSysValueRule = new PSSysValueRule();
                pSSysValueRule.setPSSysValueRuleId(this.getPSSysValueRuleId());
                PSSysValueRuleService pSSysValueRuleService = (PSSysValueRuleService)ServiceGlobal.getService(PSSysValueRuleService.class, (SessionFactory)this.getSessionFactory());
                pSSysValueRuleService.autoGet((IEntity)pSSysValueRule);
                this.pssysvaluerule = pSSysValueRule;
            }
            return this.pssysvaluerule;
        }
    }

    private PSSysDEFTypeBase getProxyEntity() {
        return this.proxyPSSysDEFTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDEFTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDEFTypeBase) {
            this.proxyPSSysDEFTypeBase = (PSSysDEFTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDEFTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_EDITORHEIGHT, 2);
        fieldIndexMap.put(FIELD_EDITORTYPE, 3);
        fieldIndexMap.put(FIELD_EDITORWIDTH, 4);
        fieldIndexMap.put(FIELD_FIELDS, 5);
        fieldIndexMap.put(FIELD_GRIDCOLALIGN, 6);
        fieldIndexMap.put(FIELD_GRIDCOLCLMODE, 7);
        fieldIndexMap.put(FIELD_GRIDCOLWIDTH, 8);
        fieldIndexMap.put(FIELD_JSFORMAT, 9);
        fieldIndexMap.put(FIELD_MAXVALUE, 10);
        fieldIndexMap.put(FIELD_MBEDITORHEIGHT, 11);
        fieldIndexMap.put(FIELD_MBEDITORTYPE, 12);
        fieldIndexMap.put(FIELD_MBEDITORWIDTH, 13);
        fieldIndexMap.put(FIELD_MEMO, 14);
        fieldIndexMap.put(FIELD_MINSTRLENGTH, 15);
        fieldIndexMap.put(FIELD_MINVALUE, 16);
        fieldIndexMap.put(FIELD_ORDERVALUE, 17);
        fieldIndexMap.put(FIELD_PRECISION2, 18);
        fieldIndexMap.put(FIELD_PSCODELISTID, 19);
        fieldIndexMap.put(FIELD_PSCODELISTNAME, 20);
        fieldIndexMap.put(FIELD_PSDEFTYPEID, 21);
        fieldIndexMap.put(FIELD_PSDEFTYPENAME, 22);
        fieldIndexMap.put(FIELD_PSSYSDEFTYPEID, 23);
        fieldIndexMap.put(FIELD_PSSYSDEFTYPENAME, 24);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 25);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 26);
        fieldIndexMap.put(FIELD_PSSYSUNITID, 27);
        fieldIndexMap.put(FIELD_PSSYSUNITNAME, 28);
        fieldIndexMap.put(FIELD_PSSYSVALUERULEID, 29);
        fieldIndexMap.put(FIELD_PSSYSVALUERULENAME, 30);
        fieldIndexMap.put(FIELD_PYFORMAT, 31);
        fieldIndexMap.put(FIELD_SEARCHEDITORHEIGHT, 32);
        fieldIndexMap.put(FIELD_SEARCHEDITORTYPE, 33);
        fieldIndexMap.put(FIELD_SEARCHEDITORWIDTH, 34);
        fieldIndexMap.put(FIELD_SEARCHMBEDITORHEIGHT, 35);
        fieldIndexMap.put(FIELD_SEARCHMBEDITORTYPE, 36);
        fieldIndexMap.put(FIELD_SEARCHMBEDITORWIDTH, 37);
        fieldIndexMap.put(FIELD_STDDATATYPE, 38);
        fieldIndexMap.put(FIELD_STRLENGTH, 39);
        fieldIndexMap.put(FIELD_TSFORMAT, 40);
        fieldIndexMap.put(FIELD_UPDATEDATE, 41);
        fieldIndexMap.put(FIELD_UPDATEMAN, 42);
        fieldIndexMap.put(FIELD_VALIDFLAG, 43);
        fieldIndexMap.put(FIELD_VALUEFORMAT, 44);
    }
}

