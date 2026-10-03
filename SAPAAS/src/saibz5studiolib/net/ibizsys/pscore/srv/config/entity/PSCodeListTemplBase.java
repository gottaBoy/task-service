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
import net.ibizsys.pscore.srv.config.entity.PSSysLanRes;
import net.ibizsys.pscore.srv.config.service.PSSysLanResService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCodeListTemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCodeListTemplBase.class);
    public static final String FIELD_CLMODEL = "CLMODEL";
    public static final String FIELD_CLPARAM = "CLPARAM";
    public static final String FIELD_CLPATH = "CLPATH";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EMPTYTEXT = "EMPTYTEXT";
    public static final String FIELD_EMPTYTEXTPSSYSLANRESID = "EMPTYTEXTPSSYSLANRESID";
    public static final String FIELD_EMPTYTEXTPSSYSLANRESNAME = "EMPTYTEXTPSSYSLANRESNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NOVALUEEMPTY = "NOVALUEEMPTY";
    public static final String FIELD_NUMBERITEM = "NUMBERITEM";
    public static final String FIELD_ORMODE = "ORMODE";
    public static final String FIELD_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String FIELD_PSCODELISTTEMPLID = "PSCODELISTTEMPLID";
    public static final String FIELD_PSCODELISTTEMPLNAME = "PSCODELISTTEMPLNAME";
    public static final String FIELD_SEPERATOR = "SEPERATOR";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALUESEPERATOR = "VALUESEPERATOR";
    private static final int INDEX_CLMODEL = 0;
    private static final int INDEX_CLPARAM = 1;
    private static final int INDEX_CLPATH = 2;
    private static final int INDEX_CODENAME = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_EMPTYTEXT = 6;
    private static final int INDEX_EMPTYTEXTPSSYSLANRESID = 7;
    private static final int INDEX_EMPTYTEXTPSSYSLANRESNAME = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_NOVALUEEMPTY = 10;
    private static final int INDEX_NUMBERITEM = 11;
    private static final int INDEX_ORMODE = 12;
    private static final int INDEX_PREDEFINEDTYPE = 13;
    private static final int INDEX_PSCODELISTTEMPLID = 14;
    private static final int INDEX_PSCODELISTTEMPLNAME = 15;
    private static final int INDEX_SEPERATOR = 16;
    private static final int INDEX_UPDATEDATE = 17;
    private static final int INDEX_UPDATEMAN = 18;
    private static final int INDEX_VALUESEPERATOR = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCodeListTemplBase proxyPSCodeListTemplBase = null;
    private boolean clmodelDirtyFlag = false;
    private boolean clparamDirtyFlag = false;
    private boolean clpathDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean emptytextDirtyFlag = false;
    private boolean emptytextpssyslanresidDirtyFlag = false;
    private boolean emptytextpssyslanresnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean novalueemptyDirtyFlag = false;
    private boolean numberitemDirtyFlag = false;
    private boolean ormodeDirtyFlag = false;
    private boolean predefinedtypeDirtyFlag = false;
    private boolean pscodelisttemplidDirtyFlag = false;
    private boolean pscodelisttemplnameDirtyFlag = false;
    private boolean seperatorDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean valueseperatorDirtyFlag = false;
    @Column(name="clmodel")
    private String clmodel;
    @Column(name="clparam")
    private String clparam;
    @Column(name="clpath")
    private String clpath;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="emptytext")
    private String emptytext;
    @Column(name="emptytextpssyslanresid")
    private String emptytextpssyslanresid;
    @Column(name="emptytextpssyslanresname")
    private String emptytextpssyslanresname;
    @Column(name="memo")
    private String memo;
    @Column(name="novalueempty")
    private Integer novalueempty;
    @Column(name="numberitem")
    private Integer numberitem;
    @Column(name="ormode")
    private String ormode;
    @Column(name="predefinedtype")
    private String predefinedtype;
    @Column(name="pscodelisttemplid")
    private String pscodelisttemplid;
    @Column(name="pscodelisttemplname")
    private String pscodelisttemplname;
    @Column(name="seperator")
    private String seperator;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="valueseperator")
    private String valueseperator;
    private Integer objEmptyTextPSSysLanResLock = new Integer(1);
    private PSSysLanRes emptytextpssyslanres = null;

    public void setCLModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCLModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clmodel = string;
        this.clmodelDirtyFlag = true;
    }

    public String getCLModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCLModel();
        }
        return this.clmodel;
    }

    public boolean isCLModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCLModelDirty();
        }
        return this.clmodelDirtyFlag;
    }

    public void resetCLModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCLModel();
            return;
        }
        this.clmodelDirtyFlag = false;
        this.clmodel = null;
    }

    public void setCLParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCLParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clparam = string;
        this.clparamDirtyFlag = true;
    }

    public String getCLParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCLParam();
        }
        return this.clparam;
    }

    public boolean isCLParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCLParamDirty();
        }
        return this.clparamDirtyFlag;
    }

    public void resetCLParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCLParam();
            return;
        }
        this.clparamDirtyFlag = false;
        this.clparam = null;
    }

    public void setCLPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCLPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clpath = string;
        this.clpathDirtyFlag = true;
    }

    public String getCLPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCLPath();
        }
        return this.clpath;
    }

    public boolean isCLPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCLPathDirty();
        }
        return this.clpathDirtyFlag;
    }

    public void resetCLPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCLPath();
            return;
        }
        this.clpathDirtyFlag = false;
        this.clpath = null;
    }

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

    public void setEmptyText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmptyText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.emptytext = string;
        this.emptytextDirtyFlag = true;
    }

    public String getEmptyText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmptyText();
        }
        return this.emptytext;
    }

    public boolean isEmptyTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmptyTextDirty();
        }
        return this.emptytextDirtyFlag;
    }

    public void resetEmptyText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmptyText();
            return;
        }
        this.emptytextDirtyFlag = false;
        this.emptytext = null;
    }

    public void setEmptyTextPSSyslanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmptyTextPSSyslanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.emptytextpssyslanresid = string;
        this.emptytextpssyslanresidDirtyFlag = true;
    }

    public String getEmptyTextPSSyslanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmptyTextPSSyslanResId();
        }
        return this.emptytextpssyslanresid;
    }

    public boolean isEmptyTextPSSyslanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmptyTextPSSyslanResIdDirty();
        }
        return this.emptytextpssyslanresidDirtyFlag;
    }

    public void resetEmptyTextPSSyslanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmptyTextPSSyslanResId();
            return;
        }
        this.emptytextpssyslanresidDirtyFlag = false;
        this.emptytextpssyslanresid = null;
    }

    public void setEmptyTextPSSyslanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmptyTextPSSyslanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.emptytextpssyslanresname = string;
        this.emptytextpssyslanresnameDirtyFlag = true;
    }

    public String getEmptyTextPSSyslanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmptyTextPSSyslanResName();
        }
        return this.emptytextpssyslanresname;
    }

    public boolean isEmptyTextPSSyslanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmptyTextPSSyslanResNameDirty();
        }
        return this.emptytextpssyslanresnameDirtyFlag;
    }

    public void resetEmptyTextPSSyslanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmptyTextPSSyslanResName();
            return;
        }
        this.emptytextpssyslanresnameDirtyFlag = false;
        this.emptytextpssyslanresname = null;
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

    public void setNoValueEmpty(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNoValueEmpty(n);
            return;
        }
        this.novalueempty = n;
        this.novalueemptyDirtyFlag = true;
    }

    public Integer getNoValueEmpty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNoValueEmpty();
        }
        return this.novalueempty;
    }

    public boolean isNoValueEmptyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNoValueEmptyDirty();
        }
        return this.novalueemptyDirtyFlag;
    }

    public void resetNoValueEmpty() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNoValueEmpty();
            return;
        }
        this.novalueemptyDirtyFlag = false;
        this.novalueempty = null;
    }

    public void setNumberItem(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNumberItem(n);
            return;
        }
        this.numberitem = n;
        this.numberitemDirtyFlag = true;
    }

    public Integer getNumberItem() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNumberItem();
        }
        return this.numberitem;
    }

    public boolean isNumberItemDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNumberItemDirty();
        }
        return this.numberitemDirtyFlag;
    }

    public void resetNumberItem() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNumberItem();
            return;
        }
        this.numberitemDirtyFlag = false;
        this.numberitem = null;
    }

    public void setOrMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ormode = string;
        this.ormodeDirtyFlag = true;
    }

    public String getOrMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrMode();
        }
        return this.ormode;
    }

    public boolean isOrModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrModeDirty();
        }
        return this.ormodeDirtyFlag;
    }

    public void resetOrMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrMode();
            return;
        }
        this.ormodeDirtyFlag = false;
        this.ormode = null;
    }

    public void setPredefinedType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPredefinedType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.predefinedtype = string;
        this.predefinedtypeDirtyFlag = true;
    }

    public String getPredefinedType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPredefinedType();
        }
        return this.predefinedtype;
    }

    public boolean isPredefinedTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPredefinedTypeDirty();
        }
        return this.predefinedtypeDirtyFlag;
    }

    public void resetPredefinedType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPredefinedType();
            return;
        }
        this.predefinedtypeDirtyFlag = false;
        this.predefinedtype = null;
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

    public void setSeperator(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSeperator(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.seperator = string;
        this.seperatorDirtyFlag = true;
    }

    public String getSeperator() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSeperator();
        }
        return this.seperator;
    }

    public boolean isSeperatorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSeperatorDirty();
        }
        return this.seperatorDirtyFlag;
    }

    public void resetSeperator() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSeperator();
            return;
        }
        this.seperatorDirtyFlag = false;
        this.seperator = null;
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

    public void setValueSeperator(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValueSeperator(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valueseperator = string;
        this.valueseperatorDirtyFlag = true;
    }

    public String getValueSeperator() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValueSeperator();
        }
        return this.valueseperator;
    }

    public boolean isValueSeperatorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueSeperatorDirty();
        }
        return this.valueseperatorDirtyFlag;
    }

    public void resetValueSeperator() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValueSeperator();
            return;
        }
        this.valueseperatorDirtyFlag = false;
        this.valueseperator = null;
    }

    protected void onReset() {
        PSCodeListTemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCodeListTemplBase pSCodeListTemplBase) {
        pSCodeListTemplBase.resetCLModel();
        pSCodeListTemplBase.resetCLParam();
        pSCodeListTemplBase.resetCLPath();
        pSCodeListTemplBase.resetCodeName();
        pSCodeListTemplBase.resetCreateDate();
        pSCodeListTemplBase.resetCreateMan();
        pSCodeListTemplBase.resetEmptyText();
        pSCodeListTemplBase.resetEmptyTextPSSyslanResId();
        pSCodeListTemplBase.resetEmptyTextPSSyslanResName();
        pSCodeListTemplBase.resetMemo();
        pSCodeListTemplBase.resetNoValueEmpty();
        pSCodeListTemplBase.resetNumberItem();
        pSCodeListTemplBase.resetOrMode();
        pSCodeListTemplBase.resetPredefinedType();
        pSCodeListTemplBase.resetPSCodeListTemplId();
        pSCodeListTemplBase.resetPSCodeListTemplName();
        pSCodeListTemplBase.resetSeperator();
        pSCodeListTemplBase.resetUpdateDate();
        pSCodeListTemplBase.resetUpdateMan();
        pSCodeListTemplBase.resetValueSeperator();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCLModelDirty()) {
            hashMap.put(FIELD_CLMODEL, this.getCLModel());
        }
        if (!bl || this.isCLParamDirty()) {
            hashMap.put(FIELD_CLPARAM, this.getCLParam());
        }
        if (!bl || this.isCLPathDirty()) {
            hashMap.put(FIELD_CLPATH, this.getCLPath());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEmptyTextDirty()) {
            hashMap.put(FIELD_EMPTYTEXT, this.getEmptyText());
        }
        if (!bl || this.isEmptyTextPSSyslanResIdDirty()) {
            hashMap.put(FIELD_EMPTYTEXTPSSYSLANRESID, this.getEmptyTextPSSyslanResId());
        }
        if (!bl || this.isEmptyTextPSSyslanResNameDirty()) {
            hashMap.put(FIELD_EMPTYTEXTPSSYSLANRESNAME, this.getEmptyTextPSSyslanResName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isNoValueEmptyDirty()) {
            hashMap.put(FIELD_NOVALUEEMPTY, this.getNoValueEmpty());
        }
        if (!bl || this.isNumberItemDirty()) {
            hashMap.put(FIELD_NUMBERITEM, this.getNumberItem());
        }
        if (!bl || this.isOrModeDirty()) {
            hashMap.put(FIELD_ORMODE, this.getOrMode());
        }
        if (!bl || this.isPredefinedTypeDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPE, this.getPredefinedType());
        }
        if (!bl || this.isPSCodeListTemplIdDirty()) {
            hashMap.put(FIELD_PSCODELISTTEMPLID, this.getPSCodeListTemplId());
        }
        if (!bl || this.isPSCodeListTemplNameDirty()) {
            hashMap.put(FIELD_PSCODELISTTEMPLNAME, this.getPSCodeListTemplName());
        }
        if (!bl || this.isSeperatorDirty()) {
            hashMap.put(FIELD_SEPERATOR, this.getSeperator());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isValueSeperatorDirty()) {
            hashMap.put(FIELD_VALUESEPERATOR, this.getValueSeperator());
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
        return PSCodeListTemplBase.get(this, n);
    }

    private static Object get(PSCodeListTemplBase pSCodeListTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCodeListTemplBase.getCLModel();
            }
            case 1: {
                return pSCodeListTemplBase.getCLParam();
            }
            case 2: {
                return pSCodeListTemplBase.getCLPath();
            }
            case 3: {
                return pSCodeListTemplBase.getCodeName();
            }
            case 4: {
                return pSCodeListTemplBase.getCreateDate();
            }
            case 5: {
                return pSCodeListTemplBase.getCreateMan();
            }
            case 6: {
                return pSCodeListTemplBase.getEmptyText();
            }
            case 7: {
                return pSCodeListTemplBase.getEmptyTextPSSyslanResId();
            }
            case 8: {
                return pSCodeListTemplBase.getEmptyTextPSSyslanResName();
            }
            case 9: {
                return pSCodeListTemplBase.getMemo();
            }
            case 10: {
                return pSCodeListTemplBase.getNoValueEmpty();
            }
            case 11: {
                return pSCodeListTemplBase.getNumberItem();
            }
            case 12: {
                return pSCodeListTemplBase.getOrMode();
            }
            case 13: {
                return pSCodeListTemplBase.getPredefinedType();
            }
            case 14: {
                return pSCodeListTemplBase.getPSCodeListTemplId();
            }
            case 15: {
                return pSCodeListTemplBase.getPSCodeListTemplName();
            }
            case 16: {
                return pSCodeListTemplBase.getSeperator();
            }
            case 17: {
                return pSCodeListTemplBase.getUpdateDate();
            }
            case 18: {
                return pSCodeListTemplBase.getUpdateMan();
            }
            case 19: {
                return pSCodeListTemplBase.getValueSeperator();
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
        PSCodeListTemplBase.set(this, n, object);
    }

    private static void set(PSCodeListTemplBase pSCodeListTemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCodeListTemplBase.setCLModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSCodeListTemplBase.setCLParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSCodeListTemplBase.setCLPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSCodeListTemplBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSCodeListTemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSCodeListTemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSCodeListTemplBase.setEmptyText(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSCodeListTemplBase.setEmptyTextPSSyslanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSCodeListTemplBase.setEmptyTextPSSyslanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSCodeListTemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSCodeListTemplBase.setNoValueEmpty(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSCodeListTemplBase.setNumberItem(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSCodeListTemplBase.setOrMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSCodeListTemplBase.setPredefinedType(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSCodeListTemplBase.setPSCodeListTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSCodeListTemplBase.setPSCodeListTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSCodeListTemplBase.setSeperator(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSCodeListTemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSCodeListTemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSCodeListTemplBase.setValueSeperator(DataObject.getStringValue((Object)object));
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
        return PSCodeListTemplBase.isNull(this, n);
    }

    private static boolean isNull(PSCodeListTemplBase pSCodeListTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCodeListTemplBase.getCLModel() == null;
            }
            case 1: {
                return pSCodeListTemplBase.getCLParam() == null;
            }
            case 2: {
                return pSCodeListTemplBase.getCLPath() == null;
            }
            case 3: {
                return pSCodeListTemplBase.getCodeName() == null;
            }
            case 4: {
                return pSCodeListTemplBase.getCreateDate() == null;
            }
            case 5: {
                return pSCodeListTemplBase.getCreateMan() == null;
            }
            case 6: {
                return pSCodeListTemplBase.getEmptyText() == null;
            }
            case 7: {
                return pSCodeListTemplBase.getEmptyTextPSSyslanResId() == null;
            }
            case 8: {
                return pSCodeListTemplBase.getEmptyTextPSSyslanResName() == null;
            }
            case 9: {
                return pSCodeListTemplBase.getMemo() == null;
            }
            case 10: {
                return pSCodeListTemplBase.getNoValueEmpty() == null;
            }
            case 11: {
                return pSCodeListTemplBase.getNumberItem() == null;
            }
            case 12: {
                return pSCodeListTemplBase.getOrMode() == null;
            }
            case 13: {
                return pSCodeListTemplBase.getPredefinedType() == null;
            }
            case 14: {
                return pSCodeListTemplBase.getPSCodeListTemplId() == null;
            }
            case 15: {
                return pSCodeListTemplBase.getPSCodeListTemplName() == null;
            }
            case 16: {
                return pSCodeListTemplBase.getSeperator() == null;
            }
            case 17: {
                return pSCodeListTemplBase.getUpdateDate() == null;
            }
            case 18: {
                return pSCodeListTemplBase.getUpdateMan() == null;
            }
            case 19: {
                return pSCodeListTemplBase.getValueSeperator() == null;
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
        return PSCodeListTemplBase.contains(this, n);
    }

    private static boolean contains(PSCodeListTemplBase pSCodeListTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCodeListTemplBase.isCLModelDirty();
            }
            case 1: {
                return pSCodeListTemplBase.isCLParamDirty();
            }
            case 2: {
                return pSCodeListTemplBase.isCLPathDirty();
            }
            case 3: {
                return pSCodeListTemplBase.isCodeNameDirty();
            }
            case 4: {
                return pSCodeListTemplBase.isCreateDateDirty();
            }
            case 5: {
                return pSCodeListTemplBase.isCreateManDirty();
            }
            case 6: {
                return pSCodeListTemplBase.isEmptyTextDirty();
            }
            case 7: {
                return pSCodeListTemplBase.isEmptyTextPSSyslanResIdDirty();
            }
            case 8: {
                return pSCodeListTemplBase.isEmptyTextPSSyslanResNameDirty();
            }
            case 9: {
                return pSCodeListTemplBase.isMemoDirty();
            }
            case 10: {
                return pSCodeListTemplBase.isNoValueEmptyDirty();
            }
            case 11: {
                return pSCodeListTemplBase.isNumberItemDirty();
            }
            case 12: {
                return pSCodeListTemplBase.isOrModeDirty();
            }
            case 13: {
                return pSCodeListTemplBase.isPredefinedTypeDirty();
            }
            case 14: {
                return pSCodeListTemplBase.isPSCodeListTemplIdDirty();
            }
            case 15: {
                return pSCodeListTemplBase.isPSCodeListTemplNameDirty();
            }
            case 16: {
                return pSCodeListTemplBase.isSeperatorDirty();
            }
            case 17: {
                return pSCodeListTemplBase.isUpdateDateDirty();
            }
            case 18: {
                return pSCodeListTemplBase.isUpdateManDirty();
            }
            case 19: {
                return pSCodeListTemplBase.isValueSeperatorDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCodeListTemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCodeListTemplBase pSCodeListTemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCodeListTemplBase.getCLModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clmodel", (Object)PSCodeListTemplBase.getJSONValue((Object)pSCodeListTemplBase.getCLModel()), (boolean)false);
        }
        if (bl || pSCodeListTemplBase.getCLParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clparam", (Object)PSCodeListTemplBase.getJSONValue((Object)pSCodeListTemplBase.getCLParam()), (boolean)false);
        }
        if (bl || pSCodeListTemplBase.getCLPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clpath", (Object)PSCodeListTemplBase.getJSONValue((Object)pSCodeListTemplBase.getCLPath()), (boolean)false);
        }
        if (bl || pSCodeListTemplBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSCodeListTemplBase.getJSONValue((Object)pSCodeListTemplBase.getCodeName()), (boolean)false);
        }
        if (bl || pSCodeListTemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCodeListTemplBase.getJSONValue((Object)pSCodeListTemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCodeListTemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCodeListTemplBase.getJSONValue((Object)pSCodeListTemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCodeListTemplBase.getEmptyText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytext", (Object)PSCodeListTemplBase.getJSONValue((Object)pSCodeListTemplBase.getEmptyText()), (boolean)false);
        }
        if (bl || pSCodeListTemplBase.getEmptyTextPSSyslanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytextpssyslanresid", (Object)PSCodeListTemplBase.getJSONValue((Object)pSCodeListTemplBase.getEmptyTextPSSyslanResId()), (boolean)false);
        }
        if (bl || pSCodeListTemplBase.getEmptyTextPSSyslanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"emptytextpssyslanresname", (Object)PSCodeListTemplBase.getJSONValue((Object)pSCodeListTemplBase.getEmptyTextPSSyslanResName()), (boolean)false);
        }
        if (bl || pSCodeListTemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSCodeListTemplBase.getJSONValue((Object)pSCodeListTemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSCodeListTemplBase.getNoValueEmpty() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"novalueempty", (Object)PSCodeListTemplBase.getJSONValue((Object)pSCodeListTemplBase.getNoValueEmpty()), (boolean)false);
        }
        if (bl || pSCodeListTemplBase.getNumberItem() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"numberitem", (Object)PSCodeListTemplBase.getJSONValue((Object)pSCodeListTemplBase.getNumberItem()), (boolean)false);
        }
        if (bl || pSCodeListTemplBase.getOrMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ormode", (Object)PSCodeListTemplBase.getJSONValue((Object)pSCodeListTemplBase.getOrMode()), (boolean)false);
        }
        if (bl || pSCodeListTemplBase.getPredefinedType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtype", (Object)PSCodeListTemplBase.getJSONValue((Object)pSCodeListTemplBase.getPredefinedType()), (boolean)false);
        }
        if (bl || pSCodeListTemplBase.getPSCodeListTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelisttemplid", (Object)PSCodeListTemplBase.getJSONValue((Object)pSCodeListTemplBase.getPSCodeListTemplId()), (boolean)false);
        }
        if (bl || pSCodeListTemplBase.getPSCodeListTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelisttemplname", (Object)PSCodeListTemplBase.getJSONValue((Object)pSCodeListTemplBase.getPSCodeListTemplName()), (boolean)false);
        }
        if (bl || pSCodeListTemplBase.getSeperator() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"seperator", (Object)PSCodeListTemplBase.getJSONValue((Object)pSCodeListTemplBase.getSeperator()), (boolean)false);
        }
        if (bl || pSCodeListTemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCodeListTemplBase.getJSONValue((Object)pSCodeListTemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCodeListTemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCodeListTemplBase.getJSONValue((Object)pSCodeListTemplBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSCodeListTemplBase.getValueSeperator() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valueseperator", (Object)PSCodeListTemplBase.getJSONValue((Object)pSCodeListTemplBase.getValueSeperator()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCodeListTemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCodeListTemplBase pSCodeListTemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCodeListTemplBase.getCLModel() != null) {
            object = pSCodeListTemplBase.getCLModel();
            xmlNode.setAttribute(FIELD_CLMODEL, (String)(object == null ? "" : object));
        }
        if (bl || pSCodeListTemplBase.getCLParam() != null) {
            object = pSCodeListTemplBase.getCLParam();
            xmlNode.setAttribute(FIELD_CLPARAM, (String)(object == null ? "" : object));
        }
        if (bl || pSCodeListTemplBase.getCLPath() != null) {
            object = pSCodeListTemplBase.getCLPath();
            xmlNode.setAttribute(FIELD_CLPATH, (String)(object == null ? "" : object));
        }
        if (bl || pSCodeListTemplBase.getCodeName() != null) {
            object = pSCodeListTemplBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListTemplBase.getCreateDate() != null) {
            object = pSCodeListTemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCodeListTemplBase.getCreateMan() != null) {
            object = pSCodeListTemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListTemplBase.getEmptyText() != null) {
            object = pSCodeListTemplBase.getEmptyText();
            xmlNode.setAttribute(FIELD_EMPTYTEXT, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListTemplBase.getEmptyTextPSSyslanResId() != null) {
            object = pSCodeListTemplBase.getEmptyTextPSSyslanResId();
            xmlNode.setAttribute(FIELD_EMPTYTEXTPSSYSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListTemplBase.getEmptyTextPSSyslanResName() != null) {
            object = pSCodeListTemplBase.getEmptyTextPSSyslanResName();
            xmlNode.setAttribute(FIELD_EMPTYTEXTPSSYSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListTemplBase.getMemo() != null) {
            object = pSCodeListTemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListTemplBase.getNoValueEmpty() != null) {
            object = pSCodeListTemplBase.getNoValueEmpty();
            xmlNode.setAttribute(FIELD_NOVALUEEMPTY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeListTemplBase.getNumberItem() != null) {
            object = pSCodeListTemplBase.getNumberItem();
            xmlNode.setAttribute(FIELD_NUMBERITEM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeListTemplBase.getOrMode() != null) {
            object = pSCodeListTemplBase.getOrMode();
            xmlNode.setAttribute(FIELD_ORMODE, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListTemplBase.getPredefinedType() != null) {
            object = pSCodeListTemplBase.getPredefinedType();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListTemplBase.getPSCodeListTemplId() != null) {
            object = pSCodeListTemplBase.getPSCodeListTemplId();
            xmlNode.setAttribute(FIELD_PSCODELISTTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListTemplBase.getPSCodeListTemplName() != null) {
            object = pSCodeListTemplBase.getPSCodeListTemplName();
            xmlNode.setAttribute(FIELD_PSCODELISTTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListTemplBase.getSeperator() != null) {
            object = pSCodeListTemplBase.getSeperator();
            xmlNode.setAttribute(FIELD_SEPERATOR, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListTemplBase.getUpdateDate() != null) {
            object = pSCodeListTemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCodeListTemplBase.getUpdateMan() != null) {
            object = pSCodeListTemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCodeListTemplBase.getValueSeperator() != null) {
            object = pSCodeListTemplBase.getValueSeperator();
            xmlNode.setAttribute(FIELD_VALUESEPERATOR, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCodeListTemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCodeListTemplBase pSCodeListTemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCodeListTemplBase.isCLModelDirty() && (bl || pSCodeListTemplBase.getCLModel() != null)) {
            iDataObject.set(FIELD_CLMODEL, (Object)pSCodeListTemplBase.getCLModel());
        }
        if (pSCodeListTemplBase.isCLParamDirty() && (bl || pSCodeListTemplBase.getCLParam() != null)) {
            iDataObject.set(FIELD_CLPARAM, (Object)pSCodeListTemplBase.getCLParam());
        }
        if (pSCodeListTemplBase.isCLPathDirty() && (bl || pSCodeListTemplBase.getCLPath() != null)) {
            iDataObject.set(FIELD_CLPATH, (Object)pSCodeListTemplBase.getCLPath());
        }
        if (pSCodeListTemplBase.isCodeNameDirty() && (bl || pSCodeListTemplBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSCodeListTemplBase.getCodeName());
        }
        if (pSCodeListTemplBase.isCreateDateDirty() && (bl || pSCodeListTemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCodeListTemplBase.getCreateDate());
        }
        if (pSCodeListTemplBase.isCreateManDirty() && (bl || pSCodeListTemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCodeListTemplBase.getCreateMan());
        }
        if (pSCodeListTemplBase.isEmptyTextDirty() && (bl || pSCodeListTemplBase.getEmptyText() != null)) {
            iDataObject.set(FIELD_EMPTYTEXT, (Object)pSCodeListTemplBase.getEmptyText());
        }
        if (pSCodeListTemplBase.isEmptyTextPSSyslanResIdDirty() && (bl || pSCodeListTemplBase.getEmptyTextPSSyslanResId() != null)) {
            iDataObject.set(FIELD_EMPTYTEXTPSSYSLANRESID, (Object)pSCodeListTemplBase.getEmptyTextPSSyslanResId());
        }
        if (pSCodeListTemplBase.isEmptyTextPSSyslanResNameDirty() && (bl || pSCodeListTemplBase.getEmptyTextPSSyslanResName() != null)) {
            iDataObject.set(FIELD_EMPTYTEXTPSSYSLANRESNAME, (Object)pSCodeListTemplBase.getEmptyTextPSSyslanResName());
        }
        if (pSCodeListTemplBase.isMemoDirty() && (bl || pSCodeListTemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSCodeListTemplBase.getMemo());
        }
        if (pSCodeListTemplBase.isNoValueEmptyDirty() && (bl || pSCodeListTemplBase.getNoValueEmpty() != null)) {
            iDataObject.set(FIELD_NOVALUEEMPTY, (Object)pSCodeListTemplBase.getNoValueEmpty());
        }
        if (pSCodeListTemplBase.isNumberItemDirty() && (bl || pSCodeListTemplBase.getNumberItem() != null)) {
            iDataObject.set(FIELD_NUMBERITEM, (Object)pSCodeListTemplBase.getNumberItem());
        }
        if (pSCodeListTemplBase.isOrModeDirty() && (bl || pSCodeListTemplBase.getOrMode() != null)) {
            iDataObject.set(FIELD_ORMODE, (Object)pSCodeListTemplBase.getOrMode());
        }
        if (pSCodeListTemplBase.isPredefinedTypeDirty() && (bl || pSCodeListTemplBase.getPredefinedType() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPE, (Object)pSCodeListTemplBase.getPredefinedType());
        }
        if (pSCodeListTemplBase.isPSCodeListTemplIdDirty() && (bl || pSCodeListTemplBase.getPSCodeListTemplId() != null)) {
            iDataObject.set(FIELD_PSCODELISTTEMPLID, (Object)pSCodeListTemplBase.getPSCodeListTemplId());
        }
        if (pSCodeListTemplBase.isPSCodeListTemplNameDirty() && (bl || pSCodeListTemplBase.getPSCodeListTemplName() != null)) {
            iDataObject.set(FIELD_PSCODELISTTEMPLNAME, (Object)pSCodeListTemplBase.getPSCodeListTemplName());
        }
        if (pSCodeListTemplBase.isSeperatorDirty() && (bl || pSCodeListTemplBase.getSeperator() != null)) {
            iDataObject.set(FIELD_SEPERATOR, (Object)pSCodeListTemplBase.getSeperator());
        }
        if (pSCodeListTemplBase.isUpdateDateDirty() && (bl || pSCodeListTemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCodeListTemplBase.getUpdateDate());
        }
        if (pSCodeListTemplBase.isUpdateManDirty() && (bl || pSCodeListTemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCodeListTemplBase.getUpdateMan());
        }
        if (pSCodeListTemplBase.isValueSeperatorDirty() && (bl || pSCodeListTemplBase.getValueSeperator() != null)) {
            iDataObject.set(FIELD_VALUESEPERATOR, (Object)pSCodeListTemplBase.getValueSeperator());
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
        return PSCodeListTemplBase.remove(this, n);
    }

    private static boolean remove(PSCodeListTemplBase pSCodeListTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCodeListTemplBase.resetCLModel();
                return true;
            }
            case 1: {
                pSCodeListTemplBase.resetCLParam();
                return true;
            }
            case 2: {
                pSCodeListTemplBase.resetCLPath();
                return true;
            }
            case 3: {
                pSCodeListTemplBase.resetCodeName();
                return true;
            }
            case 4: {
                pSCodeListTemplBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSCodeListTemplBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSCodeListTemplBase.resetEmptyText();
                return true;
            }
            case 7: {
                pSCodeListTemplBase.resetEmptyTextPSSyslanResId();
                return true;
            }
            case 8: {
                pSCodeListTemplBase.resetEmptyTextPSSyslanResName();
                return true;
            }
            case 9: {
                pSCodeListTemplBase.resetMemo();
                return true;
            }
            case 10: {
                pSCodeListTemplBase.resetNoValueEmpty();
                return true;
            }
            case 11: {
                pSCodeListTemplBase.resetNumberItem();
                return true;
            }
            case 12: {
                pSCodeListTemplBase.resetOrMode();
                return true;
            }
            case 13: {
                pSCodeListTemplBase.resetPredefinedType();
                return true;
            }
            case 14: {
                pSCodeListTemplBase.resetPSCodeListTemplId();
                return true;
            }
            case 15: {
                pSCodeListTemplBase.resetPSCodeListTemplName();
                return true;
            }
            case 16: {
                pSCodeListTemplBase.resetSeperator();
                return true;
            }
            case 17: {
                pSCodeListTemplBase.resetUpdateDate();
                return true;
            }
            case 18: {
                pSCodeListTemplBase.resetUpdateMan();
                return true;
            }
            case 19: {
                pSCodeListTemplBase.resetValueSeperator();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysLanRes getEmptyTextPSSysLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmptyTextPSSysLanRes();
        }
        if (this.getEmptyTextPSSyslanResId() == null) {
            return null;
        }
        Integer n = this.objEmptyTextPSSysLanResLock;
        synchronized (n) {
            if (this.emptytextpssyslanres != null && DataTypeHelper.compare((int)25, (Object)this.getEmptyTextPSSyslanResId(), (Object)this.emptytextpssyslanres.getPSSysLanResId()) != 0L) {
                this.emptytextpssyslanres = null;
            }
            if (this.emptytextpssyslanres == null) {
                PSSysLanRes pSSysLanRes = new PSSysLanRes();
                pSSysLanRes.setPSSysLanResId(this.getEmptyTextPSSyslanResId());
                PSSysLanResService pSSysLanResService = (PSSysLanResService)ServiceGlobal.getService(PSSysLanResService.class, (SessionFactory)this.getSessionFactory());
                pSSysLanResService.autoGet(pSSysLanRes);
                this.emptytextpssyslanres = pSSysLanRes;
            }
            return this.emptytextpssyslanres;
        }
    }

    private PSCodeListTemplBase getProxyEntity() {
        return this.proxyPSCodeListTemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCodeListTemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSCodeListTemplBase) {
            this.proxyPSCodeListTemplBase = (PSCodeListTemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCodeListTemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CLMODEL, 0);
        fieldIndexMap.put(FIELD_CLPARAM, 1);
        fieldIndexMap.put(FIELD_CLPATH, 2);
        fieldIndexMap.put(FIELD_CODENAME, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_EMPTYTEXT, 6);
        fieldIndexMap.put(FIELD_EMPTYTEXTPSSYSLANRESID, 7);
        fieldIndexMap.put(FIELD_EMPTYTEXTPSSYSLANRESNAME, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_NOVALUEEMPTY, 10);
        fieldIndexMap.put(FIELD_NUMBERITEM, 11);
        fieldIndexMap.put(FIELD_ORMODE, 12);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPE, 13);
        fieldIndexMap.put(FIELD_PSCODELISTTEMPLID, 14);
        fieldIndexMap.put(FIELD_PSCODELISTTEMPLNAME, 15);
        fieldIndexMap.put(FIELD_SEPERATOR, 16);
        fieldIndexMap.put(FIELD_UPDATEDATE, 17);
        fieldIndexMap.put(FIELD_UPDATEMAN, 18);
        fieldIndexMap.put(FIELD_VALUESEPERATOR, 19);
    }
}

