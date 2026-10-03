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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelModel;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPanelLogicParamBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPanelLogicParamBase.class);
    public static final String FIELD_ARRAYFLAG = "ARRAYFLAG";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DATATYPE = "DATATYPE";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PARAMTYPE = "PARAMTYPE";
    public static final String FIELD_PSPANELLOGICPARAMID = "PSPANELLOGICPARAMID";
    public static final String FIELD_PSPANELLOGICPARAMNAME = "PSPANELLOGICPARAMNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String FIELD_PSSYSVIEWPANELLOGICID = "PSSYSVIEWPANELLOGICID";
    public static final String FIELD_PSSYSVIEWPANELLOGICNAME = "PSSYSVIEWPANELLOGICNAME";
    public static final String FIELD_PSSYSVIEWPANELMODELID = "PSSYSVIEWPANELMODELID";
    public static final String FIELD_PSSYSVIEWPANELMODELNAME = "PSSYSVIEWPANELMODELNAME";
    public static final String FIELD_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_ARRAYFLAG = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_DATATYPE = 4;
    private static final int INDEX_LOGICNAME = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_PARAMTYPE = 7;
    private static final int INDEX_PSPANELLOGICPARAMID = 8;
    private static final int INDEX_PSPANELLOGICPARAMNAME = 9;
    private static final int INDEX_PSSYSTEMID = 10;
    private static final int INDEX_PSSYSVIEWPANELID = 11;
    private static final int INDEX_PSSYSVIEWPANELLOGICID = 12;
    private static final int INDEX_PSSYSVIEWPANELLOGICNAME = 13;
    private static final int INDEX_PSSYSVIEWPANELMODELID = 14;
    private static final int INDEX_PSSYSVIEWPANELMODELNAME = 15;
    private static final int INDEX_PSSYSVIEWPANELNAME = 16;
    private static final int INDEX_UPDATEDATE = 17;
    private static final int INDEX_UPDATEMAN = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPanelLogicParamBase proxyPSPanelLogicParamBase = null;
    private boolean arrayflagDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean datatypeDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean paramtypeDirtyFlag = false;
    private boolean pspanellogicparamidDirtyFlag = false;
    private boolean pspanellogicparamnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssysviewpanelidDirtyFlag = false;
    private boolean pssysviewpanellogicidDirtyFlag = false;
    private boolean pssysviewpanellogicnameDirtyFlag = false;
    private boolean pssysviewpanelmodelidDirtyFlag = false;
    private boolean pssysviewpanelmodelnameDirtyFlag = false;
    private boolean pssysviewpanelnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="arrayflag")
    private Integer arrayflag;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="datatype")
    private String datatype;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="paramtype")
    private String paramtype;
    @Column(name="pspanellogicparamid")
    private String pspanellogicparamid;
    @Column(name="pspanellogicparamname")
    private String pspanellogicparamname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssysviewpanelid")
    private String pssysviewpanelid;
    @Column(name="pssysviewpanellogicid")
    private String pssysviewpanellogicid;
    @Column(name="pssysviewpanellogicname")
    private String pssysviewpanellogicname;
    @Column(name="pssysviewpanelmodelid")
    private String pssysviewpanelmodelid;
    @Column(name="pssysviewpanelmodelname")
    private String pssysviewpanelmodelname;
    @Column(name="pssysviewpanelname")
    private String pssysviewpanelname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSysViewPanelLogicLock = new Integer(1);
    private PSSysViewPanelLogic pssysviewpanellogic = null;
    private Integer objPSSysViewPanelModelLock = new Integer(1);
    private PSSysViewPanelModel pssysviewpanelmodel = null;
    private Integer objPSSysViewPanelLock = new Integer(1);
    private PSSysViewPanel pssysviewpanel = null;

    public void setArrayFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setArrayFlag(n);
            return;
        }
        this.arrayflag = n;
        this.arrayflagDirtyFlag = true;
    }

    public Integer getArrayFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getArrayFlag();
        }
        return this.arrayflag;
    }

    public boolean isArrayFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isArrayFlagDirty();
        }
        return this.arrayflagDirtyFlag;
    }

    public void resetArrayFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetArrayFlag();
            return;
        }
        this.arrayflagDirtyFlag = false;
        this.arrayflag = null;
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

    public void setParamType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.paramtype = string;
        this.paramtypeDirtyFlag = true;
    }

    public String getParamType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamType();
        }
        return this.paramtype;
    }

    public boolean isParamTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamTypeDirty();
        }
        return this.paramtypeDirtyFlag;
    }

    public void resetParamType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamType();
            return;
        }
        this.paramtypeDirtyFlag = false;
        this.paramtype = null;
    }

    public void setPSPanelLogicParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPanelLogicParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspanellogicparamid = string;
        this.pspanellogicparamidDirtyFlag = true;
    }

    public String getPSPanelLogicParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLogicParamId();
        }
        return this.pspanellogicparamid;
    }

    public boolean isPSPanelLogicParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPanelLogicParamIdDirty();
        }
        return this.pspanellogicparamidDirtyFlag;
    }

    public void resetPSPanelLogicParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPanelLogicParamId();
            return;
        }
        this.pspanellogicparamidDirtyFlag = false;
        this.pspanellogicparamid = null;
    }

    public void setPSPanelLogicParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPanelLogicParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspanellogicparamname = string;
        this.pspanellogicparamnameDirtyFlag = true;
    }

    public String getPSPanelLogicParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLogicParamName();
        }
        return this.pspanellogicparamname;
    }

    public boolean isPSPanelLogicParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPanelLogicParamNameDirty();
        }
        return this.pspanellogicparamnameDirtyFlag;
    }

    public void resetPSPanelLogicParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPanelLogicParamName();
            return;
        }
        this.pspanellogicparamnameDirtyFlag = false;
        this.pspanellogicparamname = null;
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

    public void setPSSysViewPanelLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanellogicid = string;
        this.pssysviewpanellogicidDirtyFlag = true;
    }

    public String getPSSysViewPanelLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelLogicId();
        }
        return this.pssysviewpanellogicid;
    }

    public boolean isPSSysViewPanelLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelLogicIdDirty();
        }
        return this.pssysviewpanellogicidDirtyFlag;
    }

    public void resetPSSysViewPanelLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelLogicId();
            return;
        }
        this.pssysviewpanellogicidDirtyFlag = false;
        this.pssysviewpanellogicid = null;
    }

    public void setPSSysViewPanelLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanellogicname = string;
        this.pssysviewpanellogicnameDirtyFlag = true;
    }

    public String getPSSysViewPanelLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelLogicName();
        }
        return this.pssysviewpanellogicname;
    }

    public boolean isPSSysViewPanelLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelLogicNameDirty();
        }
        return this.pssysviewpanellogicnameDirtyFlag;
    }

    public void resetPSSysViewPanelLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelLogicName();
            return;
        }
        this.pssysviewpanellogicnameDirtyFlag = false;
        this.pssysviewpanellogicname = null;
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
        PSPanelLogicParamBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPanelLogicParamBase pSPanelLogicParamBase) {
        pSPanelLogicParamBase.resetArrayFlag();
        pSPanelLogicParamBase.resetCodeName();
        pSPanelLogicParamBase.resetCreateDate();
        pSPanelLogicParamBase.resetCreateMan();
        pSPanelLogicParamBase.resetDataType();
        pSPanelLogicParamBase.resetLogicName();
        pSPanelLogicParamBase.resetMemo();
        pSPanelLogicParamBase.resetParamType();
        pSPanelLogicParamBase.resetPSPanelLogicParamId();
        pSPanelLogicParamBase.resetPSPanelLogicParamName();
        pSPanelLogicParamBase.resetPSSystemId();
        pSPanelLogicParamBase.resetPSSysViewPanelId();
        pSPanelLogicParamBase.resetPSSysViewPanelLogicId();
        pSPanelLogicParamBase.resetPSSysViewPanelLogicName();
        pSPanelLogicParamBase.resetPSSysViewPanelModelId();
        pSPanelLogicParamBase.resetPSSysViewPanelModelName();
        pSPanelLogicParamBase.resetPSSysViewPanelName();
        pSPanelLogicParamBase.resetUpdateDate();
        pSPanelLogicParamBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isArrayFlagDirty()) {
            hashMap.put(FIELD_ARRAYFLAG, this.getArrayFlag());
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
        if (!bl || this.isDataTypeDirty()) {
            hashMap.put(FIELD_DATATYPE, this.getDataType());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isParamTypeDirty()) {
            hashMap.put(FIELD_PARAMTYPE, this.getParamType());
        }
        if (!bl || this.isPSPanelLogicParamIdDirty()) {
            hashMap.put(FIELD_PSPANELLOGICPARAMID, this.getPSPanelLogicParamId());
        }
        if (!bl || this.isPSPanelLogicParamNameDirty()) {
            hashMap.put(FIELD_PSPANELLOGICPARAMNAME, this.getPSPanelLogicParamName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSysViewPanelIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELID, this.getPSSysViewPanelId());
        }
        if (!bl || this.isPSSysViewPanelLogicIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELLOGICID, this.getPSSysViewPanelLogicId());
        }
        if (!bl || this.isPSSysViewPanelLogicNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELLOGICNAME, this.getPSSysViewPanelLogicName());
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
        return PSPanelLogicParamBase.get(this, n);
    }

    private static Object get(PSPanelLogicParamBase pSPanelLogicParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelLogicParamBase.getArrayFlag();
            }
            case 1: {
                return pSPanelLogicParamBase.getCodeName();
            }
            case 2: {
                return pSPanelLogicParamBase.getCreateDate();
            }
            case 3: {
                return pSPanelLogicParamBase.getCreateMan();
            }
            case 4: {
                return pSPanelLogicParamBase.getDataType();
            }
            case 5: {
                return pSPanelLogicParamBase.getLogicName();
            }
            case 6: {
                return pSPanelLogicParamBase.getMemo();
            }
            case 7: {
                return pSPanelLogicParamBase.getParamType();
            }
            case 8: {
                return pSPanelLogicParamBase.getPSPanelLogicParamId();
            }
            case 9: {
                return pSPanelLogicParamBase.getPSPanelLogicParamName();
            }
            case 10: {
                return pSPanelLogicParamBase.getPSSystemId();
            }
            case 11: {
                return pSPanelLogicParamBase.getPSSysViewPanelId();
            }
            case 12: {
                return pSPanelLogicParamBase.getPSSysViewPanelLogicId();
            }
            case 13: {
                return pSPanelLogicParamBase.getPSSysViewPanelLogicName();
            }
            case 14: {
                return pSPanelLogicParamBase.getPSSysViewPanelModelId();
            }
            case 15: {
                return pSPanelLogicParamBase.getPSSysViewPanelModelName();
            }
            case 16: {
                return pSPanelLogicParamBase.getPSSysViewPanelName();
            }
            case 17: {
                return pSPanelLogicParamBase.getUpdateDate();
            }
            case 18: {
                return pSPanelLogicParamBase.getUpdateMan();
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
        PSPanelLogicParamBase.set(this, n, object);
    }

    private static void set(PSPanelLogicParamBase pSPanelLogicParamBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPanelLogicParamBase.setArrayFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSPanelLogicParamBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPanelLogicParamBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSPanelLogicParamBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPanelLogicParamBase.setDataType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPanelLogicParamBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPanelLogicParamBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPanelLogicParamBase.setParamType(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPanelLogicParamBase.setPSPanelLogicParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPanelLogicParamBase.setPSPanelLogicParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPanelLogicParamBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPanelLogicParamBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSPanelLogicParamBase.setPSSysViewPanelLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSPanelLogicParamBase.setPSSysViewPanelLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSPanelLogicParamBase.setPSSysViewPanelModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSPanelLogicParamBase.setPSSysViewPanelModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSPanelLogicParamBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSPanelLogicParamBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSPanelLogicParamBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSPanelLogicParamBase.isNull(this, n);
    }

    private static boolean isNull(PSPanelLogicParamBase pSPanelLogicParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelLogicParamBase.getArrayFlag() == null;
            }
            case 1: {
                return pSPanelLogicParamBase.getCodeName() == null;
            }
            case 2: {
                return pSPanelLogicParamBase.getCreateDate() == null;
            }
            case 3: {
                return pSPanelLogicParamBase.getCreateMan() == null;
            }
            case 4: {
                return pSPanelLogicParamBase.getDataType() == null;
            }
            case 5: {
                return pSPanelLogicParamBase.getLogicName() == null;
            }
            case 6: {
                return pSPanelLogicParamBase.getMemo() == null;
            }
            case 7: {
                return pSPanelLogicParamBase.getParamType() == null;
            }
            case 8: {
                return pSPanelLogicParamBase.getPSPanelLogicParamId() == null;
            }
            case 9: {
                return pSPanelLogicParamBase.getPSPanelLogicParamName() == null;
            }
            case 10: {
                return pSPanelLogicParamBase.getPSSystemId() == null;
            }
            case 11: {
                return pSPanelLogicParamBase.getPSSysViewPanelId() == null;
            }
            case 12: {
                return pSPanelLogicParamBase.getPSSysViewPanelLogicId() == null;
            }
            case 13: {
                return pSPanelLogicParamBase.getPSSysViewPanelLogicName() == null;
            }
            case 14: {
                return pSPanelLogicParamBase.getPSSysViewPanelModelId() == null;
            }
            case 15: {
                return pSPanelLogicParamBase.getPSSysViewPanelModelName() == null;
            }
            case 16: {
                return pSPanelLogicParamBase.getPSSysViewPanelName() == null;
            }
            case 17: {
                return pSPanelLogicParamBase.getUpdateDate() == null;
            }
            case 18: {
                return pSPanelLogicParamBase.getUpdateMan() == null;
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
        return PSPanelLogicParamBase.contains(this, n);
    }

    private static boolean contains(PSPanelLogicParamBase pSPanelLogicParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelLogicParamBase.isArrayFlagDirty();
            }
            case 1: {
                return pSPanelLogicParamBase.isCodeNameDirty();
            }
            case 2: {
                return pSPanelLogicParamBase.isCreateDateDirty();
            }
            case 3: {
                return pSPanelLogicParamBase.isCreateManDirty();
            }
            case 4: {
                return pSPanelLogicParamBase.isDataTypeDirty();
            }
            case 5: {
                return pSPanelLogicParamBase.isLogicNameDirty();
            }
            case 6: {
                return pSPanelLogicParamBase.isMemoDirty();
            }
            case 7: {
                return pSPanelLogicParamBase.isParamTypeDirty();
            }
            case 8: {
                return pSPanelLogicParamBase.isPSPanelLogicParamIdDirty();
            }
            case 9: {
                return pSPanelLogicParamBase.isPSPanelLogicParamNameDirty();
            }
            case 10: {
                return pSPanelLogicParamBase.isPSSystemIdDirty();
            }
            case 11: {
                return pSPanelLogicParamBase.isPSSysViewPanelIdDirty();
            }
            case 12: {
                return pSPanelLogicParamBase.isPSSysViewPanelLogicIdDirty();
            }
            case 13: {
                return pSPanelLogicParamBase.isPSSysViewPanelLogicNameDirty();
            }
            case 14: {
                return pSPanelLogicParamBase.isPSSysViewPanelModelIdDirty();
            }
            case 15: {
                return pSPanelLogicParamBase.isPSSysViewPanelModelNameDirty();
            }
            case 16: {
                return pSPanelLogicParamBase.isPSSysViewPanelNameDirty();
            }
            case 17: {
                return pSPanelLogicParamBase.isUpdateDateDirty();
            }
            case 18: {
                return pSPanelLogicParamBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPanelLogicParamBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPanelLogicParamBase pSPanelLogicParamBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPanelLogicParamBase.getArrayFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"arrayflag", (Object)PSPanelLogicParamBase.getJSONValue((Object)pSPanelLogicParamBase.getArrayFlag()), (boolean)false);
        }
        if (bl || pSPanelLogicParamBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSPanelLogicParamBase.getJSONValue((Object)pSPanelLogicParamBase.getCodeName()), (boolean)false);
        }
        if (bl || pSPanelLogicParamBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPanelLogicParamBase.getJSONValue((Object)pSPanelLogicParamBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPanelLogicParamBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPanelLogicParamBase.getJSONValue((Object)pSPanelLogicParamBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPanelLogicParamBase.getDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datatype", (Object)PSPanelLogicParamBase.getJSONValue((Object)pSPanelLogicParamBase.getDataType()), (boolean)false);
        }
        if (bl || pSPanelLogicParamBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSPanelLogicParamBase.getJSONValue((Object)pSPanelLogicParamBase.getLogicName()), (boolean)false);
        }
        if (bl || pSPanelLogicParamBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPanelLogicParamBase.getJSONValue((Object)pSPanelLogicParamBase.getMemo()), (boolean)false);
        }
        if (bl || pSPanelLogicParamBase.getParamType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramtype", (Object)PSPanelLogicParamBase.getJSONValue((Object)pSPanelLogicParamBase.getParamType()), (boolean)false);
        }
        if (bl || pSPanelLogicParamBase.getPSPanelLogicParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspanellogicparamid", (Object)PSPanelLogicParamBase.getJSONValue((Object)pSPanelLogicParamBase.getPSPanelLogicParamId()), (boolean)false);
        }
        if (bl || pSPanelLogicParamBase.getPSPanelLogicParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspanellogicparamname", (Object)PSPanelLogicParamBase.getJSONValue((Object)pSPanelLogicParamBase.getPSPanelLogicParamName()), (boolean)false);
        }
        if (bl || pSPanelLogicParamBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSPanelLogicParamBase.getJSONValue((Object)pSPanelLogicParamBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSPanelLogicParamBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSPanelLogicParamBase.getJSONValue((Object)pSPanelLogicParamBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSPanelLogicParamBase.getPSSysViewPanelLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanellogicid", (Object)PSPanelLogicParamBase.getJSONValue((Object)pSPanelLogicParamBase.getPSSysViewPanelLogicId()), (boolean)false);
        }
        if (bl || pSPanelLogicParamBase.getPSSysViewPanelLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanellogicname", (Object)PSPanelLogicParamBase.getJSONValue((Object)pSPanelLogicParamBase.getPSSysViewPanelLogicName()), (boolean)false);
        }
        if (bl || pSPanelLogicParamBase.getPSSysViewPanelModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelmodelid", (Object)PSPanelLogicParamBase.getJSONValue((Object)pSPanelLogicParamBase.getPSSysViewPanelModelId()), (boolean)false);
        }
        if (bl || pSPanelLogicParamBase.getPSSysViewPanelModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelmodelname", (Object)PSPanelLogicParamBase.getJSONValue((Object)pSPanelLogicParamBase.getPSSysViewPanelModelName()), (boolean)false);
        }
        if (bl || pSPanelLogicParamBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSPanelLogicParamBase.getJSONValue((Object)pSPanelLogicParamBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSPanelLogicParamBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPanelLogicParamBase.getJSONValue((Object)pSPanelLogicParamBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPanelLogicParamBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPanelLogicParamBase.getJSONValue((Object)pSPanelLogicParamBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPanelLogicParamBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPanelLogicParamBase pSPanelLogicParamBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPanelLogicParamBase.getArrayFlag() != null) {
            object = pSPanelLogicParamBase.getArrayFlag();
            xmlNode.setAttribute(FIELD_ARRAYFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelLogicParamBase.getCodeName() != null) {
            object = pSPanelLogicParamBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicParamBase.getCreateDate() != null) {
            object = pSPanelLogicParamBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPanelLogicParamBase.getCreateMan() != null) {
            object = pSPanelLogicParamBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicParamBase.getDataType() != null) {
            object = pSPanelLogicParamBase.getDataType();
            xmlNode.setAttribute(FIELD_DATATYPE, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicParamBase.getLogicName() != null) {
            object = pSPanelLogicParamBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicParamBase.getMemo() != null) {
            object = pSPanelLogicParamBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicParamBase.getParamType() != null) {
            object = pSPanelLogicParamBase.getParamType();
            xmlNode.setAttribute(FIELD_PARAMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicParamBase.getPSPanelLogicParamId() != null) {
            object = pSPanelLogicParamBase.getPSPanelLogicParamId();
            xmlNode.setAttribute(FIELD_PSPANELLOGICPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicParamBase.getPSPanelLogicParamName() != null) {
            object = pSPanelLogicParamBase.getPSPanelLogicParamName();
            xmlNode.setAttribute(FIELD_PSPANELLOGICPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicParamBase.getPSSystemId() != null) {
            object = pSPanelLogicParamBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicParamBase.getPSSysViewPanelId() != null) {
            object = pSPanelLogicParamBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicParamBase.getPSSysViewPanelLogicId() != null) {
            object = pSPanelLogicParamBase.getPSSysViewPanelLogicId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicParamBase.getPSSysViewPanelLogicName() != null) {
            object = pSPanelLogicParamBase.getPSSysViewPanelLogicName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicParamBase.getPSSysViewPanelModelId() != null) {
            object = pSPanelLogicParamBase.getPSSysViewPanelModelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicParamBase.getPSSysViewPanelModelName() != null) {
            object = pSPanelLogicParamBase.getPSSysViewPanelModelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicParamBase.getPSSysViewPanelName() != null) {
            object = pSPanelLogicParamBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicParamBase.getUpdateDate() != null) {
            object = pSPanelLogicParamBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPanelLogicParamBase.getUpdateMan() != null) {
            object = pSPanelLogicParamBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPanelLogicParamBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPanelLogicParamBase pSPanelLogicParamBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPanelLogicParamBase.isArrayFlagDirty() && (bl || pSPanelLogicParamBase.getArrayFlag() != null)) {
            iDataObject.set(FIELD_ARRAYFLAG, (Object)pSPanelLogicParamBase.getArrayFlag());
        }
        if (pSPanelLogicParamBase.isCodeNameDirty() && (bl || pSPanelLogicParamBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSPanelLogicParamBase.getCodeName());
        }
        if (pSPanelLogicParamBase.isCreateDateDirty() && (bl || pSPanelLogicParamBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPanelLogicParamBase.getCreateDate());
        }
        if (pSPanelLogicParamBase.isCreateManDirty() && (bl || pSPanelLogicParamBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPanelLogicParamBase.getCreateMan());
        }
        if (pSPanelLogicParamBase.isDataTypeDirty() && (bl || pSPanelLogicParamBase.getDataType() != null)) {
            iDataObject.set(FIELD_DATATYPE, (Object)pSPanelLogicParamBase.getDataType());
        }
        if (pSPanelLogicParamBase.isLogicNameDirty() && (bl || pSPanelLogicParamBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSPanelLogicParamBase.getLogicName());
        }
        if (pSPanelLogicParamBase.isMemoDirty() && (bl || pSPanelLogicParamBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPanelLogicParamBase.getMemo());
        }
        if (pSPanelLogicParamBase.isParamTypeDirty() && (bl || pSPanelLogicParamBase.getParamType() != null)) {
            iDataObject.set(FIELD_PARAMTYPE, (Object)pSPanelLogicParamBase.getParamType());
        }
        if (pSPanelLogicParamBase.isPSPanelLogicParamIdDirty() && (bl || pSPanelLogicParamBase.getPSPanelLogicParamId() != null)) {
            iDataObject.set(FIELD_PSPANELLOGICPARAMID, (Object)pSPanelLogicParamBase.getPSPanelLogicParamId());
        }
        if (pSPanelLogicParamBase.isPSPanelLogicParamNameDirty() && (bl || pSPanelLogicParamBase.getPSPanelLogicParamName() != null)) {
            iDataObject.set(FIELD_PSPANELLOGICPARAMNAME, (Object)pSPanelLogicParamBase.getPSPanelLogicParamName());
        }
        if (pSPanelLogicParamBase.isPSSystemIdDirty() && (bl || pSPanelLogicParamBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSPanelLogicParamBase.getPSSystemId());
        }
        if (pSPanelLogicParamBase.isPSSysViewPanelIdDirty() && (bl || pSPanelLogicParamBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSPanelLogicParamBase.getPSSysViewPanelId());
        }
        if (pSPanelLogicParamBase.isPSSysViewPanelLogicIdDirty() && (bl || pSPanelLogicParamBase.getPSSysViewPanelLogicId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELLOGICID, (Object)pSPanelLogicParamBase.getPSSysViewPanelLogicId());
        }
        if (pSPanelLogicParamBase.isPSSysViewPanelLogicNameDirty() && (bl || pSPanelLogicParamBase.getPSSysViewPanelLogicName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELLOGICNAME, (Object)pSPanelLogicParamBase.getPSSysViewPanelLogicName());
        }
        if (pSPanelLogicParamBase.isPSSysViewPanelModelIdDirty() && (bl || pSPanelLogicParamBase.getPSSysViewPanelModelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELMODELID, (Object)pSPanelLogicParamBase.getPSSysViewPanelModelId());
        }
        if (pSPanelLogicParamBase.isPSSysViewPanelModelNameDirty() && (bl || pSPanelLogicParamBase.getPSSysViewPanelModelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELMODELNAME, (Object)pSPanelLogicParamBase.getPSSysViewPanelModelName());
        }
        if (pSPanelLogicParamBase.isPSSysViewPanelNameDirty() && (bl || pSPanelLogicParamBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSPanelLogicParamBase.getPSSysViewPanelName());
        }
        if (pSPanelLogicParamBase.isUpdateDateDirty() && (bl || pSPanelLogicParamBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPanelLogicParamBase.getUpdateDate());
        }
        if (pSPanelLogicParamBase.isUpdateManDirty() && (bl || pSPanelLogicParamBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPanelLogicParamBase.getUpdateMan());
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
        return PSPanelLogicParamBase.remove(this, n);
    }

    private static boolean remove(PSPanelLogicParamBase pSPanelLogicParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPanelLogicParamBase.resetArrayFlag();
                return true;
            }
            case 1: {
                pSPanelLogicParamBase.resetCodeName();
                return true;
            }
            case 2: {
                pSPanelLogicParamBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSPanelLogicParamBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSPanelLogicParamBase.resetDataType();
                return true;
            }
            case 5: {
                pSPanelLogicParamBase.resetLogicName();
                return true;
            }
            case 6: {
                pSPanelLogicParamBase.resetMemo();
                return true;
            }
            case 7: {
                pSPanelLogicParamBase.resetParamType();
                return true;
            }
            case 8: {
                pSPanelLogicParamBase.resetPSPanelLogicParamId();
                return true;
            }
            case 9: {
                pSPanelLogicParamBase.resetPSPanelLogicParamName();
                return true;
            }
            case 10: {
                pSPanelLogicParamBase.resetPSSystemId();
                return true;
            }
            case 11: {
                pSPanelLogicParamBase.resetPSSysViewPanelId();
                return true;
            }
            case 12: {
                pSPanelLogicParamBase.resetPSSysViewPanelLogicId();
                return true;
            }
            case 13: {
                pSPanelLogicParamBase.resetPSSysViewPanelLogicName();
                return true;
            }
            case 14: {
                pSPanelLogicParamBase.resetPSSysViewPanelModelId();
                return true;
            }
            case 15: {
                pSPanelLogicParamBase.resetPSSysViewPanelModelName();
                return true;
            }
            case 16: {
                pSPanelLogicParamBase.resetPSSysViewPanelName();
                return true;
            }
            case 17: {
                pSPanelLogicParamBase.resetUpdateDate();
                return true;
            }
            case 18: {
                pSPanelLogicParamBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysViewPanelLogic getPSSysViewPanelLogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelLogic();
        }
        if (this.getPSSysViewPanelLogicId() == null) {
            return null;
        }
        Integer n = this.objPSSysViewPanelLogicLock;
        synchronized (n) {
            if (this.pssysviewpanellogic != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysViewPanelLogicId(), (Object)this.pssysviewpanellogic.getPSSysViewPanelLogicId()) != 0L) {
                this.pssysviewpanellogic = null;
            }
            if (this.pssysviewpanellogic == null) {
                PSSysViewPanelLogic pSSysViewPanelLogic = new PSSysViewPanelLogic();
                pSSysViewPanelLogic.setPSSysViewPanelLogicId(this.getPSSysViewPanelLogicId());
                PSSysViewPanelLogicService pSSysViewPanelLogicService = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelLogicService.autoGet(pSSysViewPanelLogic);
                this.pssysviewpanellogic = pSSysViewPanelLogic;
            }
            return this.pssysviewpanellogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysViewPanelModel getPSSysViewPanelModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelModel();
        }
        if (this.getPSSysViewPanelModelId() == null) {
            return null;
        }
        Integer n = this.objPSSysViewPanelModelLock;
        synchronized (n) {
            if (this.pssysviewpanelmodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysViewPanelModelId(), (Object)this.pssysviewpanelmodel.getPSSysViewPanelModelId()) != 0L) {
                this.pssysviewpanelmodel = null;
            }
            if (this.pssysviewpanelmodel == null) {
                PSSysViewPanelModel pSSysViewPanelModel = new PSSysViewPanelModel();
                pSSysViewPanelModel.setPSSysViewPanelModelId(this.getPSSysViewPanelModelId());
                PSSysViewPanelModelService pSSysViewPanelModelService = (PSSysViewPanelModelService)ServiceGlobal.getService(PSSysViewPanelModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelModelService.autoGet(pSSysViewPanelModel);
                this.pssysviewpanelmodel = pSSysViewPanelModel;
            }
            return this.pssysviewpanelmodel;
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

    private PSPanelLogicParamBase getProxyEntity() {
        return this.proxyPSPanelLogicParamBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPanelLogicParamBase = null;
        if (iDataObject != null && iDataObject instanceof PSPanelLogicParamBase) {
            this.proxyPSPanelLogicParamBase = (PSPanelLogicParamBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicParamService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ARRAYFLAG, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_DATATYPE, 4);
        fieldIndexMap.put(FIELD_LOGICNAME, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_PARAMTYPE, 7);
        fieldIndexMap.put(FIELD_PSPANELLOGICPARAMID, 8);
        fieldIndexMap.put(FIELD_PSPANELLOGICPARAMNAME, 9);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 10);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELID, 11);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELLOGICID, 12);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELLOGICNAME, 13);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELMODELID, 14);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELMODELNAME, 15);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELNAME, 16);
        fieldIndexMap.put(FIELD_UPDATEDATE, 17);
        fieldIndexMap.put(FIELD_UPDATEMAN, 18);
    }
}

