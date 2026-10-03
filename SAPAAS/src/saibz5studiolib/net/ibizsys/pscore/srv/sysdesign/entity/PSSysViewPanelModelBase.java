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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelItem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysViewPanelModelBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysViewPanelModelBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CTRLMODELNAME = "CTRLMODELNAME";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_DATATYPE = "DATATYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELTAG = "MODELTAG";
    public static final String FIELD_MODELTAG2 = "MODELTAG2";
    public static final String FIELD_MODELTYPE = "MODELTYPE";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String FIELD_PSSYSVIEWPANELITEMID = "PSSYSVIEWPANELITEMID";
    public static final String FIELD_PSSYSVIEWPANELITEMNAME = "PSSYSVIEWPANELITEMNAME";
    public static final String FIELD_PSSYSVIEWPANELMODELID = "PSSYSVIEWPANELMODELID";
    public static final String FIELD_PSSYSVIEWPANELMODELNAME = "PSSYSVIEWPANELMODELNAME";
    public static final String FIELD_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String FIELD_REFFIELDNAME = "REFFIELDNAME";
    public static final String FIELD_REFMODELNAME = "REFMODELNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VIEWMODELNAME = "VIEWMODELNAME";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_CTRLMODELNAME = 3;
    private static final int INDEX_CUSTOMCODE = 4;
    private static final int INDEX_CUSTOMMODE = 5;
    private static final int INDEX_DATATYPE = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_MODELTAG = 8;
    private static final int INDEX_MODELTAG2 = 9;
    private static final int INDEX_MODELTYPE = 10;
    private static final int INDEX_PSSYSDYNAMODELID = 11;
    private static final int INDEX_PSSYSDYNAMODELNAME = 12;
    private static final int INDEX_PSSYSVIEWPANELID = 13;
    private static final int INDEX_PSSYSVIEWPANELITEMID = 14;
    private static final int INDEX_PSSYSVIEWPANELITEMNAME = 15;
    private static final int INDEX_PSSYSVIEWPANELMODELID = 16;
    private static final int INDEX_PSSYSVIEWPANELMODELNAME = 17;
    private static final int INDEX_PSSYSVIEWPANELNAME = 18;
    private static final int INDEX_REFFIELDNAME = 19;
    private static final int INDEX_REFMODELNAME = 20;
    private static final int INDEX_UPDATEDATE = 21;
    private static final int INDEX_UPDATEMAN = 22;
    private static final int INDEX_USERCAT = 23;
    private static final int INDEX_USERTAG = 24;
    private static final int INDEX_USERTAG2 = 25;
    private static final int INDEX_USERTAG3 = 26;
    private static final int INDEX_USERTAG4 = 27;
    private static final int INDEX_VIEWMODELNAME = 28;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysViewPanelModelBase proxyPSSysViewPanelModelBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ctrlmodelnameDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean datatypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modeltagDirtyFlag = false;
    private boolean modeltag2DirtyFlag = false;
    private boolean modeltypeDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssysviewpanelidDirtyFlag = false;
    private boolean pssysviewpanelitemidDirtyFlag = false;
    private boolean pssysviewpanelitemnameDirtyFlag = false;
    private boolean pssysviewpanelmodelidDirtyFlag = false;
    private boolean pssysviewpanelmodelnameDirtyFlag = false;
    private boolean pssysviewpanelnameDirtyFlag = false;
    private boolean reffieldnameDirtyFlag = false;
    private boolean refmodelnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean viewmodelnameDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="ctrlmodelname")
    private String ctrlmodelname;
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="datatype")
    private String datatype;
    @Column(name="memo")
    private String memo;
    @Column(name="modeltag")
    private String modeltag;
    @Column(name="modeltag2")
    private String modeltag2;
    @Column(name="modeltype")
    private String modeltype;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssysviewpanelid")
    private String pssysviewpanelid;
    @Column(name="pssysviewpanelitemid")
    private String pssysviewpanelitemid;
    @Column(name="pssysviewpanelitemname")
    private String pssysviewpanelitemname;
    @Column(name="pssysviewpanelmodelid")
    private String pssysviewpanelmodelid;
    @Column(name="pssysviewpanelmodelname")
    private String pssysviewpanelmodelname;
    @Column(name="pssysviewpanelname")
    private String pssysviewpanelname;
    @Column(name="reffieldname")
    private String reffieldname;
    @Column(name="refmodelname")
    private String refmodelname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="viewmodelname")
    private String viewmodelname;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysViewPanelItemLock = new Integer(1);
    private PSSysViewPanelItem pssysviewpanelitem = null;
    private Integer objPSSysViewPanelLock = new Integer(1);
    private PSSysViewPanel pssysviewpanel = null;

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

    public void setCtrlModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlmodelname = string;
        this.ctrlmodelnameDirtyFlag = true;
    }

    public String getCtrlModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlModelName();
        }
        return this.ctrlmodelname;
    }

    public boolean isCtrlModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlModelNameDirty();
        }
        return this.ctrlmodelnameDirtyFlag;
    }

    public void resetCtrlModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlModelName();
            return;
        }
        this.ctrlmodelnameDirtyFlag = false;
        this.ctrlmodelname = null;
    }

    public void setCustomCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcode = string;
        this.customcodeDirtyFlag = true;
    }

    public String getCustomCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCode();
        }
        return this.customcode;
    }

    public boolean isCustomCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCodeDirty();
        }
        return this.customcodeDirtyFlag;
    }

    public void resetCustomCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCode();
            return;
        }
        this.customcodeDirtyFlag = false;
        this.customcode = null;
    }

    public void setCustomMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomMode(n);
            return;
        }
        this.custommode = n;
        this.custommodeDirtyFlag = true;
    }

    public Integer getCustomMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomMode();
        }
        return this.custommode;
    }

    public boolean isCustomModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomModeDirty();
        }
        return this.custommodeDirtyFlag;
    }

    public void resetCustomMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomMode();
            return;
        }
        this.custommodeDirtyFlag = false;
        this.custommode = null;
    }

    public void setDataType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.datatype = string;
        this.datatypeDirtyFlag = true;
    }

    public String getDataType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataType();
        }
        return this.datatype;
    }

    public boolean isDataTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataTypeDirty();
        }
        return this.datatypeDirtyFlag;
    }

    public void resetDataType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataType();
            return;
        }
        this.datatypeDirtyFlag = false;
        this.datatype = null;
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

    public void setModelType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modeltype = string;
        this.modeltypeDirtyFlag = true;
    }

    public String getModelType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelType();
        }
        return this.modeltype;
    }

    public boolean isModelTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelTypeDirty();
        }
        return this.modeltypeDirtyFlag;
    }

    public void resetModelType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelType();
            return;
        }
        this.modeltypeDirtyFlag = false;
        this.modeltype = null;
    }

    public void setPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelid = string;
        this.pssysdynamodelidDirtyFlag = true;
    }

    public String getPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelId();
        }
        return this.pssysdynamodelid;
    }

    public boolean isPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelIdDirty();
        }
        return this.pssysdynamodelidDirtyFlag;
    }

    public void resetPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelId();
            return;
        }
        this.pssysdynamodelidDirtyFlag = false;
        this.pssysdynamodelid = null;
    }

    public void setPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelname = string;
        this.pssysdynamodelnameDirtyFlag = true;
    }

    public String getPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelName();
        }
        return this.pssysdynamodelname;
    }

    public boolean isPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelNameDirty();
        }
        return this.pssysdynamodelnameDirtyFlag;
    }

    public void resetPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelName();
            return;
        }
        this.pssysdynamodelnameDirtyFlag = false;
        this.pssysdynamodelname = null;
    }

    public void setPSSysViewPanelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelid = string;
        this.pssysviewpanelidDirtyFlag = true;
    }

    public String getPSSysViewPanelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelId();
        }
        return this.pssysviewpanelid;
    }

    public boolean isPSSysViewPanelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelIdDirty();
        }
        return this.pssysviewpanelidDirtyFlag;
    }

    public void resetPSSysViewPanelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelId();
            return;
        }
        this.pssysviewpanelidDirtyFlag = false;
        this.pssysviewpanelid = null;
    }

    public void setPSSysViewPanelItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelitemid = string;
        this.pssysviewpanelitemidDirtyFlag = true;
    }

    public String getPSSysViewPanelItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelItemId();
        }
        return this.pssysviewpanelitemid;
    }

    public boolean isPSSysViewPanelItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelItemIdDirty();
        }
        return this.pssysviewpanelitemidDirtyFlag;
    }

    public void resetPSSysViewPanelItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelItemId();
            return;
        }
        this.pssysviewpanelitemidDirtyFlag = false;
        this.pssysviewpanelitemid = null;
    }

    public void setPSSysViewPanelItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelitemname = string;
        this.pssysviewpanelitemnameDirtyFlag = true;
    }

    public String getPSSysViewPanelItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelItemName();
        }
        return this.pssysviewpanelitemname;
    }

    public boolean isPSSysViewPanelItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelItemNameDirty();
        }
        return this.pssysviewpanelitemnameDirtyFlag;
    }

    public void resetPSSysViewPanelItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelItemName();
            return;
        }
        this.pssysviewpanelitemnameDirtyFlag = false;
        this.pssysviewpanelitemname = null;
    }

    public void setPSSysViewPanelModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelmodelid = string;
        this.pssysviewpanelmodelidDirtyFlag = true;
    }

    public String getPSSysViewPanelModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelModelId();
        }
        return this.pssysviewpanelmodelid;
    }

    public boolean isPSSysViewPanelModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelModelIdDirty();
        }
        return this.pssysviewpanelmodelidDirtyFlag;
    }

    public void resetPSSysViewPanelModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelModelId();
            return;
        }
        this.pssysviewpanelmodelidDirtyFlag = false;
        this.pssysviewpanelmodelid = null;
    }

    public void setPSSysViewPanelModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelmodelname = string;
        this.pssysviewpanelmodelnameDirtyFlag = true;
    }

    public String getPSSysViewPanelModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelModelName();
        }
        return this.pssysviewpanelmodelname;
    }

    public boolean isPSSysViewPanelModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelModelNameDirty();
        }
        return this.pssysviewpanelmodelnameDirtyFlag;
    }

    public void resetPSSysViewPanelModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelModelName();
            return;
        }
        this.pssysviewpanelmodelnameDirtyFlag = false;
        this.pssysviewpanelmodelname = null;
    }

    public void setPSSysViewPanelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelname = string;
        this.pssysviewpanelnameDirtyFlag = true;
    }

    public String getPSSysViewPanelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelName();
        }
        return this.pssysviewpanelname;
    }

    public boolean isPSSysViewPanelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelNameDirty();
        }
        return this.pssysviewpanelnameDirtyFlag;
    }

    public void resetPSSysViewPanelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelName();
            return;
        }
        this.pssysviewpanelnameDirtyFlag = false;
        this.pssysviewpanelname = null;
    }

    public void setRefFieldName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefFieldName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reffieldname = string;
        this.reffieldnameDirtyFlag = true;
    }

    public String getRefFieldName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefFieldName();
        }
        return this.reffieldname;
    }

    public boolean isRefFieldNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefFieldNameDirty();
        }
        return this.reffieldnameDirtyFlag;
    }

    public void resetRefFieldName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefFieldName();
            return;
        }
        this.reffieldnameDirtyFlag = false;
        this.reffieldname = null;
    }

    public void setRefModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refmodelname = string;
        this.refmodelnameDirtyFlag = true;
    }

    public String getRefModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefModelName();
        }
        return this.refmodelname;
    }

    public boolean isRefModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefModelNameDirty();
        }
        return this.refmodelnameDirtyFlag;
    }

    public void resetRefModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefModelName();
            return;
        }
        this.refmodelnameDirtyFlag = false;
        this.refmodelname = null;
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

    public void setUserCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usercat = string;
        this.usercatDirtyFlag = true;
    }

    public String getUserCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCat();
        }
        return this.usercat;
    }

    public boolean isUserCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCatDirty();
        }
        return this.usercatDirtyFlag;
    }

    public void resetUserCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCat();
            return;
        }
        this.usercatDirtyFlag = false;
        this.usercat = null;
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

    public void setUserTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag3 = string;
        this.usertag3DirtyFlag = true;
    }

    public String getUserTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag3();
        }
        return this.usertag3;
    }

    public boolean isUserTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag3Dirty();
        }
        return this.usertag3DirtyFlag;
    }

    public void resetUserTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag3();
            return;
        }
        this.usertag3DirtyFlag = false;
        this.usertag3 = null;
    }

    public void setUserTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag4 = string;
        this.usertag4DirtyFlag = true;
    }

    public String getUserTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag4();
        }
        return this.usertag4;
    }

    public boolean isUserTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag4Dirty();
        }
        return this.usertag4DirtyFlag;
    }

    public void resetUserTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag4();
            return;
        }
        this.usertag4DirtyFlag = false;
        this.usertag4 = null;
    }

    public void setViewModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewmodelname = string;
        this.viewmodelnameDirtyFlag = true;
    }

    public String getViewModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewModelName();
        }
        return this.viewmodelname;
    }

    public boolean isViewModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewModelNameDirty();
        }
        return this.viewmodelnameDirtyFlag;
    }

    public void resetViewModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewModelName();
            return;
        }
        this.viewmodelnameDirtyFlag = false;
        this.viewmodelname = null;
    }

    protected void onReset() {
        PSSysViewPanelModelBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysViewPanelModelBase pSSysViewPanelModelBase) {
        pSSysViewPanelModelBase.resetCodeName();
        pSSysViewPanelModelBase.resetCreateDate();
        pSSysViewPanelModelBase.resetCreateMan();
        pSSysViewPanelModelBase.resetCtrlModelName();
        pSSysViewPanelModelBase.resetCustomCode();
        pSSysViewPanelModelBase.resetCustomMode();
        pSSysViewPanelModelBase.resetDataType();
        pSSysViewPanelModelBase.resetMemo();
        pSSysViewPanelModelBase.resetModelTag();
        pSSysViewPanelModelBase.resetModelTag2();
        pSSysViewPanelModelBase.resetModelType();
        pSSysViewPanelModelBase.resetPSSysDynaModelId();
        pSSysViewPanelModelBase.resetPSSysDynaModelName();
        pSSysViewPanelModelBase.resetPSSysViewPanelId();
        pSSysViewPanelModelBase.resetPSSysViewPanelItemId();
        pSSysViewPanelModelBase.resetPSSysViewPanelItemName();
        pSSysViewPanelModelBase.resetPSSysViewPanelModelId();
        pSSysViewPanelModelBase.resetPSSysViewPanelModelName();
        pSSysViewPanelModelBase.resetPSSysViewPanelName();
        pSSysViewPanelModelBase.resetRefFieldName();
        pSSysViewPanelModelBase.resetRefModelName();
        pSSysViewPanelModelBase.resetUpdateDate();
        pSSysViewPanelModelBase.resetUpdateMan();
        pSSysViewPanelModelBase.resetUserCat();
        pSSysViewPanelModelBase.resetUserTag();
        pSSysViewPanelModelBase.resetUserTag2();
        pSSysViewPanelModelBase.resetUserTag3();
        pSSysViewPanelModelBase.resetUserTag4();
        pSSysViewPanelModelBase.resetViewModelName();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCtrlModelNameDirty()) {
            hashMap.put(FIELD_CTRLMODELNAME, this.getCtrlModelName());
        }
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isCustomModeDirty()) {
            hashMap.put(FIELD_CUSTOMMODE, this.getCustomMode());
        }
        if (!bl || this.isDataTypeDirty()) {
            hashMap.put(FIELD_DATATYPE, this.getDataType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModelTagDirty()) {
            hashMap.put(FIELD_MODELTAG, this.getModelTag());
        }
        if (!bl || this.isModelTag2Dirty()) {
            hashMap.put(FIELD_MODELTAG2, this.getModelTag2());
        }
        if (!bl || this.isModelTypeDirty()) {
            hashMap.put(FIELD_MODELTYPE, this.getModelType());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysViewPanelIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELID, this.getPSSysViewPanelId());
        }
        if (!bl || this.isPSSysViewPanelItemIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELITEMID, this.getPSSysViewPanelItemId());
        }
        if (!bl || this.isPSSysViewPanelItemNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELITEMNAME, this.getPSSysViewPanelItemName());
        }
        if (!bl || this.isPSSysViewPanelModelIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELMODELID, this.getPSSysViewPanelModelId());
        }
        if (!bl || this.isPSSysViewPanelModelNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELMODELNAME, this.getPSSysViewPanelModelName());
        }
        if (!bl || this.isPSSysViewPanelNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELNAME, this.getPSSysViewPanelName());
        }
        if (!bl || this.isRefFieldNameDirty()) {
            hashMap.put(FIELD_REFFIELDNAME, this.getRefFieldName());
        }
        if (!bl || this.isRefModelNameDirty()) {
            hashMap.put(FIELD_REFMODELNAME, this.getRefModelName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isUserTag3Dirty()) {
            hashMap.put(FIELD_USERTAG3, this.getUserTag3());
        }
        if (!bl || this.isUserTag4Dirty()) {
            hashMap.put(FIELD_USERTAG4, this.getUserTag4());
        }
        if (!bl || this.isViewModelNameDirty()) {
            hashMap.put(FIELD_VIEWMODELNAME, this.getViewModelName());
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
        return PSSysViewPanelModelBase.get(this, n);
    }

    private static Object get(PSSysViewPanelModelBase pSSysViewPanelModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysViewPanelModelBase.getCodeName();
            }
            case 1: {
                return pSSysViewPanelModelBase.getCreateDate();
            }
            case 2: {
                return pSSysViewPanelModelBase.getCreateMan();
            }
            case 3: {
                return pSSysViewPanelModelBase.getCtrlModelName();
            }
            case 4: {
                return pSSysViewPanelModelBase.getCustomCode();
            }
            case 5: {
                return pSSysViewPanelModelBase.getCustomMode();
            }
            case 6: {
                return pSSysViewPanelModelBase.getDataType();
            }
            case 7: {
                return pSSysViewPanelModelBase.getMemo();
            }
            case 8: {
                return pSSysViewPanelModelBase.getModelTag();
            }
            case 9: {
                return pSSysViewPanelModelBase.getModelTag2();
            }
            case 10: {
                return pSSysViewPanelModelBase.getModelType();
            }
            case 11: {
                return pSSysViewPanelModelBase.getPSSysDynaModelId();
            }
            case 12: {
                return pSSysViewPanelModelBase.getPSSysDynaModelName();
            }
            case 13: {
                return pSSysViewPanelModelBase.getPSSysViewPanelId();
            }
            case 14: {
                return pSSysViewPanelModelBase.getPSSysViewPanelItemId();
            }
            case 15: {
                return pSSysViewPanelModelBase.getPSSysViewPanelItemName();
            }
            case 16: {
                return pSSysViewPanelModelBase.getPSSysViewPanelModelId();
            }
            case 17: {
                return pSSysViewPanelModelBase.getPSSysViewPanelModelName();
            }
            case 18: {
                return pSSysViewPanelModelBase.getPSSysViewPanelName();
            }
            case 19: {
                return pSSysViewPanelModelBase.getRefFieldName();
            }
            case 20: {
                return pSSysViewPanelModelBase.getRefModelName();
            }
            case 21: {
                return pSSysViewPanelModelBase.getUpdateDate();
            }
            case 22: {
                return pSSysViewPanelModelBase.getUpdateMan();
            }
            case 23: {
                return pSSysViewPanelModelBase.getUserCat();
            }
            case 24: {
                return pSSysViewPanelModelBase.getUserTag();
            }
            case 25: {
                return pSSysViewPanelModelBase.getUserTag2();
            }
            case 26: {
                return pSSysViewPanelModelBase.getUserTag3();
            }
            case 27: {
                return pSSysViewPanelModelBase.getUserTag4();
            }
            case 28: {
                return pSSysViewPanelModelBase.getViewModelName();
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
        PSSysViewPanelModelBase.set(this, n, object);
    }

    private static void set(PSSysViewPanelModelBase pSSysViewPanelModelBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysViewPanelModelBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysViewPanelModelBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysViewPanelModelBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysViewPanelModelBase.setCtrlModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysViewPanelModelBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysViewPanelModelBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSysViewPanelModelBase.setDataType(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysViewPanelModelBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysViewPanelModelBase.setModelTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysViewPanelModelBase.setModelTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysViewPanelModelBase.setModelType(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysViewPanelModelBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysViewPanelModelBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysViewPanelModelBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysViewPanelModelBase.setPSSysViewPanelItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysViewPanelModelBase.setPSSysViewPanelItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysViewPanelModelBase.setPSSysViewPanelModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysViewPanelModelBase.setPSSysViewPanelModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysViewPanelModelBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysViewPanelModelBase.setRefFieldName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysViewPanelModelBase.setRefModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysViewPanelModelBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 22: {
                pSSysViewPanelModelBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysViewPanelModelBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysViewPanelModelBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysViewPanelModelBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysViewPanelModelBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysViewPanelModelBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysViewPanelModelBase.setViewModelName(DataObject.getStringValue((Object)object));
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
        return PSSysViewPanelModelBase.isNull(this, n);
    }

    private static boolean isNull(PSSysViewPanelModelBase pSSysViewPanelModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysViewPanelModelBase.getCodeName() == null;
            }
            case 1: {
                return pSSysViewPanelModelBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysViewPanelModelBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysViewPanelModelBase.getCtrlModelName() == null;
            }
            case 4: {
                return pSSysViewPanelModelBase.getCustomCode() == null;
            }
            case 5: {
                return pSSysViewPanelModelBase.getCustomMode() == null;
            }
            case 6: {
                return pSSysViewPanelModelBase.getDataType() == null;
            }
            case 7: {
                return pSSysViewPanelModelBase.getMemo() == null;
            }
            case 8: {
                return pSSysViewPanelModelBase.getModelTag() == null;
            }
            case 9: {
                return pSSysViewPanelModelBase.getModelTag2() == null;
            }
            case 10: {
                return pSSysViewPanelModelBase.getModelType() == null;
            }
            case 11: {
                return pSSysViewPanelModelBase.getPSSysDynaModelId() == null;
            }
            case 12: {
                return pSSysViewPanelModelBase.getPSSysDynaModelName() == null;
            }
            case 13: {
                return pSSysViewPanelModelBase.getPSSysViewPanelId() == null;
            }
            case 14: {
                return pSSysViewPanelModelBase.getPSSysViewPanelItemId() == null;
            }
            case 15: {
                return pSSysViewPanelModelBase.getPSSysViewPanelItemName() == null;
            }
            case 16: {
                return pSSysViewPanelModelBase.getPSSysViewPanelModelId() == null;
            }
            case 17: {
                return pSSysViewPanelModelBase.getPSSysViewPanelModelName() == null;
            }
            case 18: {
                return pSSysViewPanelModelBase.getPSSysViewPanelName() == null;
            }
            case 19: {
                return pSSysViewPanelModelBase.getRefFieldName() == null;
            }
            case 20: {
                return pSSysViewPanelModelBase.getRefModelName() == null;
            }
            case 21: {
                return pSSysViewPanelModelBase.getUpdateDate() == null;
            }
            case 22: {
                return pSSysViewPanelModelBase.getUpdateMan() == null;
            }
            case 23: {
                return pSSysViewPanelModelBase.getUserCat() == null;
            }
            case 24: {
                return pSSysViewPanelModelBase.getUserTag() == null;
            }
            case 25: {
                return pSSysViewPanelModelBase.getUserTag2() == null;
            }
            case 26: {
                return pSSysViewPanelModelBase.getUserTag3() == null;
            }
            case 27: {
                return pSSysViewPanelModelBase.getUserTag4() == null;
            }
            case 28: {
                return pSSysViewPanelModelBase.getViewModelName() == null;
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
        return PSSysViewPanelModelBase.contains(this, n);
    }

    private static boolean contains(PSSysViewPanelModelBase pSSysViewPanelModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysViewPanelModelBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysViewPanelModelBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysViewPanelModelBase.isCreateManDirty();
            }
            case 3: {
                return pSSysViewPanelModelBase.isCtrlModelNameDirty();
            }
            case 4: {
                return pSSysViewPanelModelBase.isCustomCodeDirty();
            }
            case 5: {
                return pSSysViewPanelModelBase.isCustomModeDirty();
            }
            case 6: {
                return pSSysViewPanelModelBase.isDataTypeDirty();
            }
            case 7: {
                return pSSysViewPanelModelBase.isMemoDirty();
            }
            case 8: {
                return pSSysViewPanelModelBase.isModelTagDirty();
            }
            case 9: {
                return pSSysViewPanelModelBase.isModelTag2Dirty();
            }
            case 10: {
                return pSSysViewPanelModelBase.isModelTypeDirty();
            }
            case 11: {
                return pSSysViewPanelModelBase.isPSSysDynaModelIdDirty();
            }
            case 12: {
                return pSSysViewPanelModelBase.isPSSysDynaModelNameDirty();
            }
            case 13: {
                return pSSysViewPanelModelBase.isPSSysViewPanelIdDirty();
            }
            case 14: {
                return pSSysViewPanelModelBase.isPSSysViewPanelItemIdDirty();
            }
            case 15: {
                return pSSysViewPanelModelBase.isPSSysViewPanelItemNameDirty();
            }
            case 16: {
                return pSSysViewPanelModelBase.isPSSysViewPanelModelIdDirty();
            }
            case 17: {
                return pSSysViewPanelModelBase.isPSSysViewPanelModelNameDirty();
            }
            case 18: {
                return pSSysViewPanelModelBase.isPSSysViewPanelNameDirty();
            }
            case 19: {
                return pSSysViewPanelModelBase.isRefFieldNameDirty();
            }
            case 20: {
                return pSSysViewPanelModelBase.isRefModelNameDirty();
            }
            case 21: {
                return pSSysViewPanelModelBase.isUpdateDateDirty();
            }
            case 22: {
                return pSSysViewPanelModelBase.isUpdateManDirty();
            }
            case 23: {
                return pSSysViewPanelModelBase.isUserCatDirty();
            }
            case 24: {
                return pSSysViewPanelModelBase.isUserTagDirty();
            }
            case 25: {
                return pSSysViewPanelModelBase.isUserTag2Dirty();
            }
            case 26: {
                return pSSysViewPanelModelBase.isUserTag3Dirty();
            }
            case 27: {
                return pSSysViewPanelModelBase.isUserTag4Dirty();
            }
            case 28: {
                return pSSysViewPanelModelBase.isViewModelNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysViewPanelModelBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysViewPanelModelBase pSSysViewPanelModelBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysViewPanelModelBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysViewPanelModelBase.getJSONValue((Object)pSSysViewPanelModelBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysViewPanelModelBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysViewPanelModelBase.getJSONValue((Object)pSSysViewPanelModelBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysViewPanelModelBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysViewPanelModelBase.getJSONValue((Object)pSSysViewPanelModelBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysViewPanelModelBase.getCtrlModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlmodelname", (Object)PSSysViewPanelModelBase.getJSONValue((Object)pSSysViewPanelModelBase.getCtrlModelName()), (boolean)false);
        }
        if (bl || pSSysViewPanelModelBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSSysViewPanelModelBase.getJSONValue((Object)pSSysViewPanelModelBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSSysViewPanelModelBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSSysViewPanelModelBase.getJSONValue((Object)pSSysViewPanelModelBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSSysViewPanelModelBase.getDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datatype", (Object)PSSysViewPanelModelBase.getJSONValue((Object)pSSysViewPanelModelBase.getDataType()), (boolean)false);
        }
        if (bl || pSSysViewPanelModelBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysViewPanelModelBase.getJSONValue((Object)pSSysViewPanelModelBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysViewPanelModelBase.getModelTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modeltag", (Object)PSSysViewPanelModelBase.getJSONValue((Object)pSSysViewPanelModelBase.getModelTag()), (boolean)false);
        }
        if (bl || pSSysViewPanelModelBase.getModelTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modeltag2", (Object)PSSysViewPanelModelBase.getJSONValue((Object)pSSysViewPanelModelBase.getModelTag2()), (boolean)false);
        }
        if (bl || pSSysViewPanelModelBase.getModelType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modeltype", (Object)PSSysViewPanelModelBase.getJSONValue((Object)pSSysViewPanelModelBase.getModelType()), (boolean)false);
        }
        if (bl || pSSysViewPanelModelBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysViewPanelModelBase.getJSONValue((Object)pSSysViewPanelModelBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysViewPanelModelBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysViewPanelModelBase.getJSONValue((Object)pSSysViewPanelModelBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysViewPanelModelBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSSysViewPanelModelBase.getJSONValue((Object)pSSysViewPanelModelBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSSysViewPanelModelBase.getPSSysViewPanelItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelitemid", (Object)PSSysViewPanelModelBase.getJSONValue((Object)pSSysViewPanelModelBase.getPSSysViewPanelItemId()), (boolean)false);
        }
        if (bl || pSSysViewPanelModelBase.getPSSysViewPanelItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelitemname", (Object)PSSysViewPanelModelBase.getJSONValue((Object)pSSysViewPanelModelBase.getPSSysViewPanelItemName()), (boolean)false);
        }
        if (bl || pSSysViewPanelModelBase.getPSSysViewPanelModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelmodelid", (Object)PSSysViewPanelModelBase.getJSONValue((Object)pSSysViewPanelModelBase.getPSSysViewPanelModelId()), (boolean)false);
        }
        if (bl || pSSysViewPanelModelBase.getPSSysViewPanelModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelmodelname", (Object)PSSysViewPanelModelBase.getJSONValue((Object)pSSysViewPanelModelBase.getPSSysViewPanelModelName()), (boolean)false);
        }
        if (bl || pSSysViewPanelModelBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSSysViewPanelModelBase.getJSONValue((Object)pSSysViewPanelModelBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSSysViewPanelModelBase.getRefFieldName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reffieldname", (Object)PSSysViewPanelModelBase.getJSONValue((Object)pSSysViewPanelModelBase.getRefFieldName()), (boolean)false);
        }
        if (bl || pSSysViewPanelModelBase.getRefModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refmodelname", (Object)PSSysViewPanelModelBase.getJSONValue((Object)pSSysViewPanelModelBase.getRefModelName()), (boolean)false);
        }
        if (bl || pSSysViewPanelModelBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysViewPanelModelBase.getJSONValue((Object)pSSysViewPanelModelBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysViewPanelModelBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysViewPanelModelBase.getJSONValue((Object)pSSysViewPanelModelBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysViewPanelModelBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysViewPanelModelBase.getJSONValue((Object)pSSysViewPanelModelBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysViewPanelModelBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysViewPanelModelBase.getJSONValue((Object)pSSysViewPanelModelBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysViewPanelModelBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysViewPanelModelBase.getJSONValue((Object)pSSysViewPanelModelBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysViewPanelModelBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysViewPanelModelBase.getJSONValue((Object)pSSysViewPanelModelBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysViewPanelModelBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysViewPanelModelBase.getJSONValue((Object)pSSysViewPanelModelBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysViewPanelModelBase.getViewModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewmodelname", (Object)PSSysViewPanelModelBase.getJSONValue((Object)pSSysViewPanelModelBase.getViewModelName()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysViewPanelModelBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysViewPanelModelBase pSSysViewPanelModelBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysViewPanelModelBase.getCodeName() != null) {
            object = pSSysViewPanelModelBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelModelBase.getCreateDate() != null) {
            object = pSSysViewPanelModelBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysViewPanelModelBase.getCreateMan() != null) {
            object = pSSysViewPanelModelBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelModelBase.getCtrlModelName() != null) {
            object = pSSysViewPanelModelBase.getCtrlModelName();
            xmlNode.setAttribute(FIELD_CTRLMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelModelBase.getCustomCode() != null) {
            object = pSSysViewPanelModelBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelModelBase.getCustomMode() != null) {
            object = pSSysViewPanelModelBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysViewPanelModelBase.getDataType() != null) {
            object = pSSysViewPanelModelBase.getDataType();
            xmlNode.setAttribute(FIELD_DATATYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelModelBase.getMemo() != null) {
            object = pSSysViewPanelModelBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelModelBase.getModelTag() != null) {
            object = pSSysViewPanelModelBase.getModelTag();
            xmlNode.setAttribute(FIELD_MODELTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelModelBase.getModelTag2() != null) {
            object = pSSysViewPanelModelBase.getModelTag2();
            xmlNode.setAttribute(FIELD_MODELTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelModelBase.getModelType() != null) {
            object = pSSysViewPanelModelBase.getModelType();
            xmlNode.setAttribute(FIELD_MODELTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelModelBase.getPSSysDynaModelId() != null) {
            object = pSSysViewPanelModelBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelModelBase.getPSSysDynaModelName() != null) {
            object = pSSysViewPanelModelBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelModelBase.getPSSysViewPanelId() != null) {
            object = pSSysViewPanelModelBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelModelBase.getPSSysViewPanelItemId() != null) {
            object = pSSysViewPanelModelBase.getPSSysViewPanelItemId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelModelBase.getPSSysViewPanelItemName() != null) {
            object = pSSysViewPanelModelBase.getPSSysViewPanelItemName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelModelBase.getPSSysViewPanelModelId() != null) {
            object = pSSysViewPanelModelBase.getPSSysViewPanelModelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelModelBase.getPSSysViewPanelModelName() != null) {
            object = pSSysViewPanelModelBase.getPSSysViewPanelModelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelModelBase.getPSSysViewPanelName() != null) {
            object = pSSysViewPanelModelBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelModelBase.getRefFieldName() != null) {
            object = pSSysViewPanelModelBase.getRefFieldName();
            xmlNode.setAttribute(FIELD_REFFIELDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelModelBase.getRefModelName() != null) {
            object = pSSysViewPanelModelBase.getRefModelName();
            xmlNode.setAttribute(FIELD_REFMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelModelBase.getUpdateDate() != null) {
            object = pSSysViewPanelModelBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysViewPanelModelBase.getUpdateMan() != null) {
            object = pSSysViewPanelModelBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelModelBase.getUserCat() != null) {
            object = pSSysViewPanelModelBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelModelBase.getUserTag() != null) {
            object = pSSysViewPanelModelBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelModelBase.getUserTag2() != null) {
            object = pSSysViewPanelModelBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelModelBase.getUserTag3() != null) {
            object = pSSysViewPanelModelBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelModelBase.getUserTag4() != null) {
            object = pSSysViewPanelModelBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysViewPanelModelBase.getViewModelName() != null) {
            object = pSSysViewPanelModelBase.getViewModelName();
            xmlNode.setAttribute(FIELD_VIEWMODELNAME, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysViewPanelModelBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysViewPanelModelBase pSSysViewPanelModelBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysViewPanelModelBase.isCodeNameDirty() && (bl || pSSysViewPanelModelBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysViewPanelModelBase.getCodeName());
        }
        if (pSSysViewPanelModelBase.isCreateDateDirty() && (bl || pSSysViewPanelModelBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysViewPanelModelBase.getCreateDate());
        }
        if (pSSysViewPanelModelBase.isCreateManDirty() && (bl || pSSysViewPanelModelBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysViewPanelModelBase.getCreateMan());
        }
        if (pSSysViewPanelModelBase.isCtrlModelNameDirty() && (bl || pSSysViewPanelModelBase.getCtrlModelName() != null)) {
            iDataObject.set(FIELD_CTRLMODELNAME, (Object)pSSysViewPanelModelBase.getCtrlModelName());
        }
        if (pSSysViewPanelModelBase.isCustomCodeDirty() && (bl || pSSysViewPanelModelBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSSysViewPanelModelBase.getCustomCode());
        }
        if (pSSysViewPanelModelBase.isCustomModeDirty() && (bl || pSSysViewPanelModelBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSSysViewPanelModelBase.getCustomMode());
        }
        if (pSSysViewPanelModelBase.isDataTypeDirty() && (bl || pSSysViewPanelModelBase.getDataType() != null)) {
            iDataObject.set(FIELD_DATATYPE, (Object)pSSysViewPanelModelBase.getDataType());
        }
        if (pSSysViewPanelModelBase.isMemoDirty() && (bl || pSSysViewPanelModelBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysViewPanelModelBase.getMemo());
        }
        if (pSSysViewPanelModelBase.isModelTagDirty() && (bl || pSSysViewPanelModelBase.getModelTag() != null)) {
            iDataObject.set(FIELD_MODELTAG, (Object)pSSysViewPanelModelBase.getModelTag());
        }
        if (pSSysViewPanelModelBase.isModelTag2Dirty() && (bl || pSSysViewPanelModelBase.getModelTag2() != null)) {
            iDataObject.set(FIELD_MODELTAG2, (Object)pSSysViewPanelModelBase.getModelTag2());
        }
        if (pSSysViewPanelModelBase.isModelTypeDirty() && (bl || pSSysViewPanelModelBase.getModelType() != null)) {
            iDataObject.set(FIELD_MODELTYPE, (Object)pSSysViewPanelModelBase.getModelType());
        }
        if (pSSysViewPanelModelBase.isPSSysDynaModelIdDirty() && (bl || pSSysViewPanelModelBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysViewPanelModelBase.getPSSysDynaModelId());
        }
        if (pSSysViewPanelModelBase.isPSSysDynaModelNameDirty() && (bl || pSSysViewPanelModelBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysViewPanelModelBase.getPSSysDynaModelName());
        }
        if (pSSysViewPanelModelBase.isPSSysViewPanelIdDirty() && (bl || pSSysViewPanelModelBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSSysViewPanelModelBase.getPSSysViewPanelId());
        }
        if (pSSysViewPanelModelBase.isPSSysViewPanelItemIdDirty() && (bl || pSSysViewPanelModelBase.getPSSysViewPanelItemId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELITEMID, (Object)pSSysViewPanelModelBase.getPSSysViewPanelItemId());
        }
        if (pSSysViewPanelModelBase.isPSSysViewPanelItemNameDirty() && (bl || pSSysViewPanelModelBase.getPSSysViewPanelItemName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELITEMNAME, (Object)pSSysViewPanelModelBase.getPSSysViewPanelItemName());
        }
        if (pSSysViewPanelModelBase.isPSSysViewPanelModelIdDirty() && (bl || pSSysViewPanelModelBase.getPSSysViewPanelModelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELMODELID, (Object)pSSysViewPanelModelBase.getPSSysViewPanelModelId());
        }
        if (pSSysViewPanelModelBase.isPSSysViewPanelModelNameDirty() && (bl || pSSysViewPanelModelBase.getPSSysViewPanelModelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELMODELNAME, (Object)pSSysViewPanelModelBase.getPSSysViewPanelModelName());
        }
        if (pSSysViewPanelModelBase.isPSSysViewPanelNameDirty() && (bl || pSSysViewPanelModelBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSSysViewPanelModelBase.getPSSysViewPanelName());
        }
        if (pSSysViewPanelModelBase.isRefFieldNameDirty() && (bl || pSSysViewPanelModelBase.getRefFieldName() != null)) {
            iDataObject.set(FIELD_REFFIELDNAME, (Object)pSSysViewPanelModelBase.getRefFieldName());
        }
        if (pSSysViewPanelModelBase.isRefModelNameDirty() && (bl || pSSysViewPanelModelBase.getRefModelName() != null)) {
            iDataObject.set(FIELD_REFMODELNAME, (Object)pSSysViewPanelModelBase.getRefModelName());
        }
        if (pSSysViewPanelModelBase.isUpdateDateDirty() && (bl || pSSysViewPanelModelBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysViewPanelModelBase.getUpdateDate());
        }
        if (pSSysViewPanelModelBase.isUpdateManDirty() && (bl || pSSysViewPanelModelBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysViewPanelModelBase.getUpdateMan());
        }
        if (pSSysViewPanelModelBase.isUserCatDirty() && (bl || pSSysViewPanelModelBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysViewPanelModelBase.getUserCat());
        }
        if (pSSysViewPanelModelBase.isUserTagDirty() && (bl || pSSysViewPanelModelBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysViewPanelModelBase.getUserTag());
        }
        if (pSSysViewPanelModelBase.isUserTag2Dirty() && (bl || pSSysViewPanelModelBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysViewPanelModelBase.getUserTag2());
        }
        if (pSSysViewPanelModelBase.isUserTag3Dirty() && (bl || pSSysViewPanelModelBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysViewPanelModelBase.getUserTag3());
        }
        if (pSSysViewPanelModelBase.isUserTag4Dirty() && (bl || pSSysViewPanelModelBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysViewPanelModelBase.getUserTag4());
        }
        if (pSSysViewPanelModelBase.isViewModelNameDirty() && (bl || pSSysViewPanelModelBase.getViewModelName() != null)) {
            iDataObject.set(FIELD_VIEWMODELNAME, (Object)pSSysViewPanelModelBase.getViewModelName());
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
        return PSSysViewPanelModelBase.remove(this, n);
    }

    private static boolean remove(PSSysViewPanelModelBase pSSysViewPanelModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysViewPanelModelBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysViewPanelModelBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysViewPanelModelBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysViewPanelModelBase.resetCtrlModelName();
                return true;
            }
            case 4: {
                pSSysViewPanelModelBase.resetCustomCode();
                return true;
            }
            case 5: {
                pSSysViewPanelModelBase.resetCustomMode();
                return true;
            }
            case 6: {
                pSSysViewPanelModelBase.resetDataType();
                return true;
            }
            case 7: {
                pSSysViewPanelModelBase.resetMemo();
                return true;
            }
            case 8: {
                pSSysViewPanelModelBase.resetModelTag();
                return true;
            }
            case 9: {
                pSSysViewPanelModelBase.resetModelTag2();
                return true;
            }
            case 10: {
                pSSysViewPanelModelBase.resetModelType();
                return true;
            }
            case 11: {
                pSSysViewPanelModelBase.resetPSSysDynaModelId();
                return true;
            }
            case 12: {
                pSSysViewPanelModelBase.resetPSSysDynaModelName();
                return true;
            }
            case 13: {
                pSSysViewPanelModelBase.resetPSSysViewPanelId();
                return true;
            }
            case 14: {
                pSSysViewPanelModelBase.resetPSSysViewPanelItemId();
                return true;
            }
            case 15: {
                pSSysViewPanelModelBase.resetPSSysViewPanelItemName();
                return true;
            }
            case 16: {
                pSSysViewPanelModelBase.resetPSSysViewPanelModelId();
                return true;
            }
            case 17: {
                pSSysViewPanelModelBase.resetPSSysViewPanelModelName();
                return true;
            }
            case 18: {
                pSSysViewPanelModelBase.resetPSSysViewPanelName();
                return true;
            }
            case 19: {
                pSSysViewPanelModelBase.resetRefFieldName();
                return true;
            }
            case 20: {
                pSSysViewPanelModelBase.resetRefModelName();
                return true;
            }
            case 21: {
                pSSysViewPanelModelBase.resetUpdateDate();
                return true;
            }
            case 22: {
                pSSysViewPanelModelBase.resetUpdateMan();
                return true;
            }
            case 23: {
                pSSysViewPanelModelBase.resetUserCat();
                return true;
            }
            case 24: {
                pSSysViewPanelModelBase.resetUserTag();
                return true;
            }
            case 25: {
                pSSysViewPanelModelBase.resetUserTag2();
                return true;
            }
            case 26: {
                pSSysViewPanelModelBase.resetUserTag3();
                return true;
            }
            case 27: {
                pSSysViewPanelModelBase.resetUserTag4();
                return true;
            }
            case 28: {
                pSSysViewPanelModelBase.resetViewModelName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDynaModel getPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModel();
        }
        if (this.getPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objPSSysDynaModelLock;
        synchronized (n) {
            if (this.pssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDynaModelId(), (Object)this.pssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.pssysdynamodel = null;
            }
            if (this.pssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet(pSSysDynaModel);
                this.pssysdynamodel = pSSysDynaModel;
            }
            return this.pssysdynamodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysViewPanelItem getPSSysViewPanelItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelItem();
        }
        if (this.getPSSysViewPanelItemId() == null) {
            return null;
        }
        Integer n = this.objPSSysViewPanelItemLock;
        synchronized (n) {
            if (this.pssysviewpanelitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysViewPanelItemId(), (Object)this.pssysviewpanelitem.getPSSysViewPanelItemId()) != 0L) {
                this.pssysviewpanelitem = null;
            }
            if (this.pssysviewpanelitem == null) {
                PSSysViewPanelItem pSSysViewPanelItem = new PSSysViewPanelItem();
                pSSysViewPanelItem.setPSSysViewPanelItemId(this.getPSSysViewPanelItemId());
                PSSysViewPanelItemService pSSysViewPanelItemService = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelItemService.autoGet(pSSysViewPanelItem);
                this.pssysviewpanelitem = pSSysViewPanelItem;
            }
            return this.pssysviewpanelitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysViewPanel getPSSysViewPanel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanel();
        }
        if (this.getPSSysViewPanelId() == null) {
            return null;
        }
        Integer n = this.objPSSysViewPanelLock;
        synchronized (n) {
            if (this.pssysviewpanel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysViewPanelId(), (Object)this.pssysviewpanel.getPSSysViewPanelId()) != 0L) {
                this.pssysviewpanel = null;
            }
            if (this.pssysviewpanel == null) {
                PSSysViewPanel pSSysViewPanel = new PSSysViewPanel();
                pSSysViewPanel.setPSSysViewPanelId(this.getPSSysViewPanelId());
                PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelService.autoGet(pSSysViewPanel);
                this.pssysviewpanel = pSSysViewPanel;
            }
            return this.pssysviewpanel;
        }
    }

    private PSSysViewPanelModelBase getProxyEntity() {
        return this.proxyPSSysViewPanelModelBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysViewPanelModelBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysViewPanelModelBase) {
            this.proxyPSSysViewPanelModelBase = (PSSysViewPanelModelBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelModelService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CTRLMODELNAME, 3);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 4);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 5);
        fieldIndexMap.put(FIELD_DATATYPE, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_MODELTAG, 8);
        fieldIndexMap.put(FIELD_MODELTAG2, 9);
        fieldIndexMap.put(FIELD_MODELTYPE, 10);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 11);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 12);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELID, 13);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELITEMID, 14);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELITEMNAME, 15);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELMODELID, 16);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELMODELNAME, 17);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELNAME, 18);
        fieldIndexMap.put(FIELD_REFFIELDNAME, 19);
        fieldIndexMap.put(FIELD_REFMODELNAME, 20);
        fieldIndexMap.put(FIELD_UPDATEDATE, 21);
        fieldIndexMap.put(FIELD_UPDATEMAN, 22);
        fieldIndexMap.put(FIELD_USERCAT, 23);
        fieldIndexMap.put(FIELD_USERTAG, 24);
        fieldIndexMap.put(FIELD_USERTAG2, 25);
        fieldIndexMap.put(FIELD_USERTAG3, 26);
        fieldIndexMap.put(FIELD_USERTAG4, 27);
        fieldIndexMap.put(FIELD_VIEWMODELNAME, 28);
    }
}

