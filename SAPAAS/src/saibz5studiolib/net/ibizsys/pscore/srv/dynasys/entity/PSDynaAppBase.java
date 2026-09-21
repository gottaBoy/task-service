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
package net.ibizsys.pscore.srv.dynasys.entity;

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
import net.ibizsys.pscore.srv.config.service.PSAppTypeService;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppView;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaSys;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaSysService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaAppBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDynaAppBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSAPPTYPEID = "PSAPPTYPEID";
    public static final String FIELD_PSAPPTYPENAME = "PSAPPTYPENAME";
    public static final String FIELD_PSDYNAAPPID = "PSDYNAAPPID";
    public static final String FIELD_PSDYNAAPPNAME = "PSDYNAAPPNAME";
    public static final String FIELD_PSDYNASYSID = "PSDYNASYSID";
    public static final String FIELD_PSDYNASYSNAME = "PSDYNASYSNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_LOGICNAME = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSAPPTYPEID = 4;
    private static final int INDEX_PSAPPTYPENAME = 5;
    private static final int INDEX_PSDYNAAPPID = 6;
    private static final int INDEX_PSDYNAAPPNAME = 7;
    private static final int INDEX_PSDYNASYSID = 8;
    private static final int INDEX_PSDYNASYSNAME = 9;
    private static final int INDEX_PSSYSAPPID = 10;
    private static final int INDEX_PSSYSAPPNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_VALIDFLAG = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDynaAppBase proxyPSDynaAppBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psapptypeidDirtyFlag = false;
    private boolean psapptypenameDirtyFlag = false;
    private boolean psdynaappidDirtyFlag = false;
    private boolean psdynaappnameDirtyFlag = false;
    private boolean psdynasysidDirtyFlag = false;
    private boolean psdynasysnameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="psapptypeid")
    private String psapptypeid;
    @Column(name="psapptypename")
    private String psapptypename;
    @Column(name="psdynaappid")
    private String psdynaappid;
    @Column(name="psdynaappname")
    private String psdynaappname;
    @Column(name="psdynasysid")
    private String psdynasysid;
    @Column(name="psdynasysname")
    private String psdynasysname;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSAppTypeLock = new Integer(1);
    private PSAppType psapptype = null;
    private Integer objPSDynaSysLock = new Integer(1);
    private PSDynaSys psdynasys = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSDynaAppViewsLock = new Integer(1);
    private ArrayList<PSDynaAppView> psdynaappviews = null;

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

    public void setPSDynaAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynaappid = string;
        this.psdynaappidDirtyFlag = true;
    }

    public String getPSDynaAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppId();
        }
        return this.psdynaappid;
    }

    public boolean isPSDynaAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaAppIdDirty();
        }
        return this.psdynaappidDirtyFlag;
    }

    public void resetPSDynaAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaAppId();
            return;
        }
        this.psdynaappidDirtyFlag = false;
        this.psdynaappid = null;
    }

    public void setPSDynaAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynaappname = string;
        this.psdynaappnameDirtyFlag = true;
    }

    public String getPSDynaAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppName();
        }
        return this.psdynaappname;
    }

    public boolean isPSDynaAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaAppNameDirty();
        }
        return this.psdynaappnameDirtyFlag;
    }

    public void resetPSDynaAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaAppName();
            return;
        }
        this.psdynaappnameDirtyFlag = false;
        this.psdynaappname = null;
    }

    public void setPSDynaSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynasysid = string;
        this.psdynasysidDirtyFlag = true;
    }

    public String getPSDynaSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaSysId();
        }
        return this.psdynasysid;
    }

    public boolean isPSDynaSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaSysIdDirty();
        }
        return this.psdynasysidDirtyFlag;
    }

    public void resetPSDynaSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaSysId();
            return;
        }
        this.psdynasysidDirtyFlag = false;
        this.psdynasysid = null;
    }

    public void setPSDynaSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynasysname = string;
        this.psdynasysnameDirtyFlag = true;
    }

    public String getPSDynaSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaSysName();
        }
        return this.psdynasysname;
    }

    public boolean isPSDynaSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaSysNameDirty();
        }
        return this.psdynasysnameDirtyFlag;
    }

    public void resetPSDynaSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaSysName();
            return;
        }
        this.psdynasysnameDirtyFlag = false;
        this.psdynasysname = null;
    }

    public void setPSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappid = string;
        this.pssysappidDirtyFlag = true;
    }

    public String getPSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppId();
        }
        return this.pssysappid;
    }

    public boolean isPSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppIdDirty();
        }
        return this.pssysappidDirtyFlag;
    }

    public void resetPSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppId();
            return;
        }
        this.pssysappidDirtyFlag = false;
        this.pssysappid = null;
    }

    public void setPSSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappname = string;
        this.pssysappnameDirtyFlag = true;
    }

    public String getPSSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppName();
        }
        return this.pssysappname;
    }

    public boolean isPSSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppNameDirty();
        }
        return this.pssysappnameDirtyFlag;
    }

    public void resetPSSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppName();
            return;
        }
        this.pssysappnameDirtyFlag = false;
        this.pssysappname = null;
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
        PSDynaAppBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDynaAppBase pSDynaAppBase) {
        pSDynaAppBase.resetCreateDate();
        pSDynaAppBase.resetCreateMan();
        pSDynaAppBase.resetLogicName();
        pSDynaAppBase.resetMemo();
        pSDynaAppBase.resetPSAppTypeId();
        pSDynaAppBase.resetPSAppTypeName();
        pSDynaAppBase.resetPSDynaAppId();
        pSDynaAppBase.resetPSDynaAppName();
        pSDynaAppBase.resetPSDynaSysId();
        pSDynaAppBase.resetPSDynaSysName();
        pSDynaAppBase.resetPSSysAppId();
        pSDynaAppBase.resetPSSysAppName();
        pSDynaAppBase.resetUpdateDate();
        pSDynaAppBase.resetUpdateMan();
        pSDynaAppBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
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
        if (!bl || this.isPSDynaAppIdDirty()) {
            hashMap.put(FIELD_PSDYNAAPPID, this.getPSDynaAppId());
        }
        if (!bl || this.isPSDynaAppNameDirty()) {
            hashMap.put(FIELD_PSDYNAAPPNAME, this.getPSDynaAppName());
        }
        if (!bl || this.isPSDynaSysIdDirty()) {
            hashMap.put(FIELD_PSDYNASYSID, this.getPSDynaSysId());
        }
        if (!bl || this.isPSDynaSysNameDirty()) {
            hashMap.put(FIELD_PSDYNASYSNAME, this.getPSDynaSysName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
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
        return PSDynaAppBase.get(this, n);
    }

    private static Object get(PSDynaAppBase pSDynaAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaAppBase.getCreateDate();
            }
            case 1: {
                return pSDynaAppBase.getCreateMan();
            }
            case 2: {
                return pSDynaAppBase.getLogicName();
            }
            case 3: {
                return pSDynaAppBase.getMemo();
            }
            case 4: {
                return pSDynaAppBase.getPSAppTypeId();
            }
            case 5: {
                return pSDynaAppBase.getPSAppTypeName();
            }
            case 6: {
                return pSDynaAppBase.getPSDynaAppId();
            }
            case 7: {
                return pSDynaAppBase.getPSDynaAppName();
            }
            case 8: {
                return pSDynaAppBase.getPSDynaSysId();
            }
            case 9: {
                return pSDynaAppBase.getPSDynaSysName();
            }
            case 10: {
                return pSDynaAppBase.getPSSysAppId();
            }
            case 11: {
                return pSDynaAppBase.getPSSysAppName();
            }
            case 12: {
                return pSDynaAppBase.getUpdateDate();
            }
            case 13: {
                return pSDynaAppBase.getUpdateMan();
            }
            case 14: {
                return pSDynaAppBase.getValidFlag();
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
        PSDynaAppBase.set(this, n, object);
    }

    private static void set(PSDynaAppBase pSDynaAppBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDynaAppBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDynaAppBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDynaAppBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDynaAppBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDynaAppBase.setPSAppTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDynaAppBase.setPSAppTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDynaAppBase.setPSDynaAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDynaAppBase.setPSDynaAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDynaAppBase.setPSDynaSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDynaAppBase.setPSDynaSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDynaAppBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDynaAppBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDynaAppBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSDynaAppBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDynaAppBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDynaAppBase.isNull(this, n);
    }

    private static boolean isNull(PSDynaAppBase pSDynaAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaAppBase.getCreateDate() == null;
            }
            case 1: {
                return pSDynaAppBase.getCreateMan() == null;
            }
            case 2: {
                return pSDynaAppBase.getLogicName() == null;
            }
            case 3: {
                return pSDynaAppBase.getMemo() == null;
            }
            case 4: {
                return pSDynaAppBase.getPSAppTypeId() == null;
            }
            case 5: {
                return pSDynaAppBase.getPSAppTypeName() == null;
            }
            case 6: {
                return pSDynaAppBase.getPSDynaAppId() == null;
            }
            case 7: {
                return pSDynaAppBase.getPSDynaAppName() == null;
            }
            case 8: {
                return pSDynaAppBase.getPSDynaSysId() == null;
            }
            case 9: {
                return pSDynaAppBase.getPSDynaSysName() == null;
            }
            case 10: {
                return pSDynaAppBase.getPSSysAppId() == null;
            }
            case 11: {
                return pSDynaAppBase.getPSSysAppName() == null;
            }
            case 12: {
                return pSDynaAppBase.getUpdateDate() == null;
            }
            case 13: {
                return pSDynaAppBase.getUpdateMan() == null;
            }
            case 14: {
                return pSDynaAppBase.getValidFlag() == null;
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
        return PSDynaAppBase.contains(this, n);
    }

    private static boolean contains(PSDynaAppBase pSDynaAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaAppBase.isCreateDateDirty();
            }
            case 1: {
                return pSDynaAppBase.isCreateManDirty();
            }
            case 2: {
                return pSDynaAppBase.isLogicNameDirty();
            }
            case 3: {
                return pSDynaAppBase.isMemoDirty();
            }
            case 4: {
                return pSDynaAppBase.isPSAppTypeIdDirty();
            }
            case 5: {
                return pSDynaAppBase.isPSAppTypeNameDirty();
            }
            case 6: {
                return pSDynaAppBase.isPSDynaAppIdDirty();
            }
            case 7: {
                return pSDynaAppBase.isPSDynaAppNameDirty();
            }
            case 8: {
                return pSDynaAppBase.isPSDynaSysIdDirty();
            }
            case 9: {
                return pSDynaAppBase.isPSDynaSysNameDirty();
            }
            case 10: {
                return pSDynaAppBase.isPSSysAppIdDirty();
            }
            case 11: {
                return pSDynaAppBase.isPSSysAppNameDirty();
            }
            case 12: {
                return pSDynaAppBase.isUpdateDateDirty();
            }
            case 13: {
                return pSDynaAppBase.isUpdateManDirty();
            }
            case 14: {
                return pSDynaAppBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDynaAppBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDynaAppBase pSDynaAppBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDynaAppBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDynaAppBase.getJSONValue((Object)pSDynaAppBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDynaAppBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDynaAppBase.getJSONValue((Object)pSDynaAppBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDynaAppBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDynaAppBase.getJSONValue((Object)pSDynaAppBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDynaAppBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDynaAppBase.getJSONValue((Object)pSDynaAppBase.getMemo()), (boolean)false);
        }
        if (bl || pSDynaAppBase.getPSAppTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapptypeid", (Object)PSDynaAppBase.getJSONValue((Object)pSDynaAppBase.getPSAppTypeId()), (boolean)false);
        }
        if (bl || pSDynaAppBase.getPSAppTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapptypename", (Object)PSDynaAppBase.getJSONValue((Object)pSDynaAppBase.getPSAppTypeName()), (boolean)false);
        }
        if (bl || pSDynaAppBase.getPSDynaAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynaappid", (Object)PSDynaAppBase.getJSONValue((Object)pSDynaAppBase.getPSDynaAppId()), (boolean)false);
        }
        if (bl || pSDynaAppBase.getPSDynaAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynaappname", (Object)PSDynaAppBase.getJSONValue((Object)pSDynaAppBase.getPSDynaAppName()), (boolean)false);
        }
        if (bl || pSDynaAppBase.getPSDynaSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynasysid", (Object)PSDynaAppBase.getJSONValue((Object)pSDynaAppBase.getPSDynaSysId()), (boolean)false);
        }
        if (bl || pSDynaAppBase.getPSDynaSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynasysname", (Object)PSDynaAppBase.getJSONValue((Object)pSDynaAppBase.getPSDynaSysName()), (boolean)false);
        }
        if (bl || pSDynaAppBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSDynaAppBase.getJSONValue((Object)pSDynaAppBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSDynaAppBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSDynaAppBase.getJSONValue((Object)pSDynaAppBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSDynaAppBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDynaAppBase.getJSONValue((Object)pSDynaAppBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDynaAppBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDynaAppBase.getJSONValue((Object)pSDynaAppBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDynaAppBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDynaAppBase.getJSONValue((Object)pSDynaAppBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDynaAppBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDynaAppBase pSDynaAppBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDynaAppBase.getCreateDate() != null) {
            object = pSDynaAppBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaAppBase.getCreateMan() != null) {
            object = pSDynaAppBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppBase.getLogicName() != null) {
            object = pSDynaAppBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppBase.getMemo() != null) {
            object = pSDynaAppBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppBase.getPSAppTypeId() != null) {
            object = pSDynaAppBase.getPSAppTypeId();
            xmlNode.setAttribute(FIELD_PSAPPTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppBase.getPSAppTypeName() != null) {
            object = pSDynaAppBase.getPSAppTypeName();
            xmlNode.setAttribute(FIELD_PSAPPTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppBase.getPSDynaAppId() != null) {
            object = pSDynaAppBase.getPSDynaAppId();
            xmlNode.setAttribute(FIELD_PSDYNAAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppBase.getPSDynaAppName() != null) {
            object = pSDynaAppBase.getPSDynaAppName();
            xmlNode.setAttribute(FIELD_PSDYNAAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppBase.getPSDynaSysId() != null) {
            object = pSDynaAppBase.getPSDynaSysId();
            xmlNode.setAttribute(FIELD_PSDYNASYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppBase.getPSDynaSysName() != null) {
            object = pSDynaAppBase.getPSDynaSysName();
            xmlNode.setAttribute(FIELD_PSDYNASYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppBase.getPSSysAppId() != null) {
            object = pSDynaAppBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppBase.getPSSysAppName() != null) {
            object = pSDynaAppBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppBase.getUpdateDate() != null) {
            object = pSDynaAppBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaAppBase.getUpdateMan() != null) {
            object = pSDynaAppBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDynaAppBase.getValidFlag() != null) {
            object = pSDynaAppBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDynaAppBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDynaAppBase pSDynaAppBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDynaAppBase.isCreateDateDirty() && (bl || pSDynaAppBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDynaAppBase.getCreateDate());
        }
        if (pSDynaAppBase.isCreateManDirty() && (bl || pSDynaAppBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDynaAppBase.getCreateMan());
        }
        if (pSDynaAppBase.isLogicNameDirty() && (bl || pSDynaAppBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDynaAppBase.getLogicName());
        }
        if (pSDynaAppBase.isMemoDirty() && (bl || pSDynaAppBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDynaAppBase.getMemo());
        }
        if (pSDynaAppBase.isPSAppTypeIdDirty() && (bl || pSDynaAppBase.getPSAppTypeId() != null)) {
            iDataObject.set(FIELD_PSAPPTYPEID, (Object)pSDynaAppBase.getPSAppTypeId());
        }
        if (pSDynaAppBase.isPSAppTypeNameDirty() && (bl || pSDynaAppBase.getPSAppTypeName() != null)) {
            iDataObject.set(FIELD_PSAPPTYPENAME, (Object)pSDynaAppBase.getPSAppTypeName());
        }
        if (pSDynaAppBase.isPSDynaAppIdDirty() && (bl || pSDynaAppBase.getPSDynaAppId() != null)) {
            iDataObject.set(FIELD_PSDYNAAPPID, (Object)pSDynaAppBase.getPSDynaAppId());
        }
        if (pSDynaAppBase.isPSDynaAppNameDirty() && (bl || pSDynaAppBase.getPSDynaAppName() != null)) {
            iDataObject.set(FIELD_PSDYNAAPPNAME, (Object)pSDynaAppBase.getPSDynaAppName());
        }
        if (pSDynaAppBase.isPSDynaSysIdDirty() && (bl || pSDynaAppBase.getPSDynaSysId() != null)) {
            iDataObject.set(FIELD_PSDYNASYSID, (Object)pSDynaAppBase.getPSDynaSysId());
        }
        if (pSDynaAppBase.isPSDynaSysNameDirty() && (bl || pSDynaAppBase.getPSDynaSysName() != null)) {
            iDataObject.set(FIELD_PSDYNASYSNAME, (Object)pSDynaAppBase.getPSDynaSysName());
        }
        if (pSDynaAppBase.isPSSysAppIdDirty() && (bl || pSDynaAppBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSDynaAppBase.getPSSysAppId());
        }
        if (pSDynaAppBase.isPSSysAppNameDirty() && (bl || pSDynaAppBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSDynaAppBase.getPSSysAppName());
        }
        if (pSDynaAppBase.isUpdateDateDirty() && (bl || pSDynaAppBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDynaAppBase.getUpdateDate());
        }
        if (pSDynaAppBase.isUpdateManDirty() && (bl || pSDynaAppBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDynaAppBase.getUpdateMan());
        }
        if (pSDynaAppBase.isValidFlagDirty() && (bl || pSDynaAppBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDynaAppBase.getValidFlag());
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
        return PSDynaAppBase.remove(this, n);
    }

    private static boolean remove(PSDynaAppBase pSDynaAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDynaAppBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDynaAppBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDynaAppBase.resetLogicName();
                return true;
            }
            case 3: {
                pSDynaAppBase.resetMemo();
                return true;
            }
            case 4: {
                pSDynaAppBase.resetPSAppTypeId();
                return true;
            }
            case 5: {
                pSDynaAppBase.resetPSAppTypeName();
                return true;
            }
            case 6: {
                pSDynaAppBase.resetPSDynaAppId();
                return true;
            }
            case 7: {
                pSDynaAppBase.resetPSDynaAppName();
                return true;
            }
            case 8: {
                pSDynaAppBase.resetPSDynaSysId();
                return true;
            }
            case 9: {
                pSDynaAppBase.resetPSDynaSysName();
                return true;
            }
            case 10: {
                pSDynaAppBase.resetPSSysAppId();
                return true;
            }
            case 11: {
                pSDynaAppBase.resetPSSysAppName();
                return true;
            }
            case 12: {
                pSDynaAppBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSDynaAppBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSDynaAppBase.resetValidFlag();
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
    public PSDynaSys getPSDynaSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaSys();
        }
        if (this.getPSDynaSysId() == null) {
            return null;
        }
        Integer n = this.objPSDynaSysLock;
        synchronized (n) {
            if (this.psdynasys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaSysId(), (Object)this.psdynasys.getPSDynaSysId()) != 0L) {
                this.psdynasys = null;
            }
            if (this.psdynasys == null) {
                PSDynaSys pSDynaSys = new PSDynaSys();
                pSDynaSys.setPSDynaSysId(this.getPSDynaSysId());
                PSDynaSysService pSDynaSysService = (PSDynaSysService)ServiceGlobal.getService(PSDynaSysService.class, (SessionFactory)this.getSessionFactory());
                pSDynaSysService.autoGet((IEntity)pSDynaSys);
                this.psdynasys = pSDynaSys;
            }
            return this.psdynasys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysApp getPSSysApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysApp();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        Integer n = this.objPSSysAppLock;
        synchronized (n) {
            if (this.pssysapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAppId(), (Object)this.pssysapp.getPSSysAppId()) != 0L) {
                this.pssysapp = null;
            }
            if (this.pssysapp == null) {
                PSSysApp pSSysApp = new PSSysApp();
                pSSysApp.setPSSysAppId(this.getPSSysAppId());
                PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSSysAppService.autoGet((IEntity)pSSysApp);
                this.pssysapp = pSSysApp;
            }
            return this.pssysapp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDynaAppView> getPSDynaAppViews() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppViews();
        }
        if (this.getPSDynaAppId() == null) {
            return null;
        }
        PSDynaAppViewService pSDynaAppViewService = (PSDynaAppViewService)ServiceGlobal.getService(PSDynaAppViewService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDynaAppViewsLock;
        synchronized (n) {
            if (this.psdynaappviews == null) {
                this.psdynaappviews = pSDynaAppViewService.selectByPSDynaApp(this);
            }
            return this.psdynaappviews;
        }
    }

    private PSDynaAppBase getProxyEntity() {
        return this.proxyPSDynaAppBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDynaAppBase = null;
        if (iDataObject != null && iDataObject instanceof PSDynaAppBase) {
            this.proxyPSDynaAppBase = (PSDynaAppBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaAppService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_LOGICNAME, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSAPPTYPEID, 4);
        fieldIndexMap.put(FIELD_PSAPPTYPENAME, 5);
        fieldIndexMap.put(FIELD_PSDYNAAPPID, 6);
        fieldIndexMap.put(FIELD_PSDYNAAPPNAME, 7);
        fieldIndexMap.put(FIELD_PSDYNASYSID, 8);
        fieldIndexMap.put(FIELD_PSDYNASYSNAME, 9);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 10);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_VALIDFLAG, 14);
    }
}

