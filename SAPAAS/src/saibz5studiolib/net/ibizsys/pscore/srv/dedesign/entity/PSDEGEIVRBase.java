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
package net.ibizsys.pscore.srv.dedesign.entity;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRule;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridCol;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRule;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEGEIVRBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEGEIVRBase.class);
    public static final String FIELD_CHECKMODE = "CHECKMODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELSTATE = "MODELSTATE";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEFVRID = "PSDEFVRID";
    public static final String FIELD_PSDEFVRNAME = "PSDEFVRNAME";
    public static final String FIELD_PSDEGEIVRID = "PSDEGEIVRID";
    public static final String FIELD_PSDEGEIVRNAME = "PSDEGEIVRNAME";
    public static final String FIELD_PSDEGRIDCOLID = "PSDEGRIDCOLID";
    public static final String FIELD_PSDEGRIDCOLNAME = "PSDEGRIDCOLNAME";
    public static final String FIELD_PSDEGRIDID = "PSDEGRIDID";
    public static final String FIELD_PSDEGRIDNAME = "PSDEGRIDNAME";
    public static final String FIELD_PSSYSVALUERULEID = "PSSYSVALUERULEID";
    public static final String FIELD_PSSYSVALUERULENAME = "PSSYSVALUERULENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VRTYPE = "VRTYPE";
    private static final int INDEX_CHECKMODE = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_MODELSTATE = 4;
    private static final int INDEX_ORDERVALUE = 5;
    private static final int INDEX_PSDEFVRID = 6;
    private static final int INDEX_PSDEFVRNAME = 7;
    private static final int INDEX_PSDEGEIVRID = 8;
    private static final int INDEX_PSDEGEIVRNAME = 9;
    private static final int INDEX_PSDEGRIDCOLID = 10;
    private static final int INDEX_PSDEGRIDCOLNAME = 11;
    private static final int INDEX_PSDEGRIDID = 12;
    private static final int INDEX_PSDEGRIDNAME = 13;
    private static final int INDEX_PSSYSVALUERULEID = 14;
    private static final int INDEX_PSSYSVALUERULENAME = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_USERCAT = 18;
    private static final int INDEX_USERTAG = 19;
    private static final int INDEX_USERTAG2 = 20;
    private static final int INDEX_USERTAG3 = 21;
    private static final int INDEX_USERTAG4 = 22;
    private static final int INDEX_VRTYPE = 23;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEGEIVRBase proxyPSDEGEIVRBase = null;
    private boolean checkmodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modelstateDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdefvridDirtyFlag = false;
    private boolean psdefvrnameDirtyFlag = false;
    private boolean psdegeivridDirtyFlag = false;
    private boolean psdegeivrnameDirtyFlag = false;
    private boolean psdegridcolidDirtyFlag = false;
    private boolean psdegridcolnameDirtyFlag = false;
    private boolean psdegrididDirtyFlag = false;
    private boolean psdegridnameDirtyFlag = false;
    private boolean pssysvalueruleidDirtyFlag = false;
    private boolean pssysvaluerulenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean vrtypeDirtyFlag = false;
    @Column(name="checkmode")
    private Integer checkmode;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="modelstate")
    private Integer modelstate;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdefvrid")
    private String psdefvrid;
    @Column(name="psdefvrname")
    private String psdefvrname;
    @Column(name="psdegeivrid")
    private String psdegeivrid;
    @Column(name="psdegeivrname")
    private String psdegeivrname;
    @Column(name="psdegridcolid")
    private String psdegridcolid;
    @Column(name="psdegridcolname")
    private String psdegridcolname;
    @Column(name="psdegridid")
    private String psdegridid;
    @Column(name="psdegridname")
    private String psdegridname;
    @Column(name="pssysvalueruleid")
    private String pssysvalueruleid;
    @Column(name="pssysvaluerulename")
    private String pssysvaluerulename;
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
    @Column(name="vrtype")
    private String vrtype;
    private Integer objPSDEFVRLock = new Integer(1);
    private PSDEFValueRule psdefvr = null;
    private Integer objPSDEGridColLock = new Integer(1);
    private PSDEGridCol psdegridcol = null;
    private Integer objPSDEGridLock = new Integer(1);
    private PSDEGrid psdegrid = null;
    private Integer objPSSysValueRuleLock = new Integer(1);
    private PSSysValueRule pssysvaluerule = null;

    public void setCheckMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCheckMode(n);
            return;
        }
        this.checkmode = n;
        this.checkmodeDirtyFlag = true;
    }

    public Integer getCheckMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCheckMode();
        }
        return this.checkmode;
    }

    public boolean isCheckModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCheckModeDirty();
        }
        return this.checkmodeDirtyFlag;
    }

    public void resetCheckMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCheckMode();
            return;
        }
        this.checkmodeDirtyFlag = false;
        this.checkmode = null;
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

    public void setModelState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelState(n);
            return;
        }
        this.modelstate = n;
        this.modelstateDirtyFlag = true;
    }

    public Integer getModelState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelState();
        }
        return this.modelstate;
    }

    public boolean isModelStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelStateDirty();
        }
        return this.modelstateDirtyFlag;
    }

    public void resetModelState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelState();
            return;
        }
        this.modelstateDirtyFlag = false;
        this.modelstate = null;
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

    public void setPSDEFVRId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFVRId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefvrid = string;
        this.psdefvridDirtyFlag = true;
    }

    public String getPSDEFVRId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFVRId();
        }
        return this.psdefvrid;
    }

    public boolean isPSDEFVRIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFVRIdDirty();
        }
        return this.psdefvridDirtyFlag;
    }

    public void resetPSDEFVRId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFVRId();
            return;
        }
        this.psdefvridDirtyFlag = false;
        this.psdefvrid = null;
    }

    public void setPSDEFVRName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFVRName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefvrname = string;
        this.psdefvrnameDirtyFlag = true;
    }

    public String getPSDEFVRName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFVRName();
        }
        return this.psdefvrname;
    }

    public boolean isPSDEFVRNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFVRNameDirty();
        }
        return this.psdefvrnameDirtyFlag;
    }

    public void resetPSDEFVRName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFVRName();
            return;
        }
        this.psdefvrnameDirtyFlag = false;
        this.psdefvrname = null;
    }

    public void setPSDEGEIVRId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGEIVRId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegeivrid = string;
        this.psdegeivridDirtyFlag = true;
    }

    public String getPSDEGEIVRId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGEIVRId();
        }
        return this.psdegeivrid;
    }

    public boolean isPSDEGEIVRIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGEIVRIdDirty();
        }
        return this.psdegeivridDirtyFlag;
    }

    public void resetPSDEGEIVRId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGEIVRId();
            return;
        }
        this.psdegeivridDirtyFlag = false;
        this.psdegeivrid = null;
    }

    public void setPSDEGEIVRName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGEIVRName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegeivrname = string;
        this.psdegeivrnameDirtyFlag = true;
    }

    public String getPSDEGEIVRName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGEIVRName();
        }
        return this.psdegeivrname;
    }

    public boolean isPSDEGEIVRNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGEIVRNameDirty();
        }
        return this.psdegeivrnameDirtyFlag;
    }

    public void resetPSDEGEIVRName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGEIVRName();
            return;
        }
        this.psdegeivrnameDirtyFlag = false;
        this.psdegeivrname = null;
    }

    public void setPSDEGridColId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridColId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegridcolid = string;
        this.psdegridcolidDirtyFlag = true;
    }

    public String getPSDEGridColId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridColId();
        }
        return this.psdegridcolid;
    }

    public boolean isPSDEGridColIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridColIdDirty();
        }
        return this.psdegridcolidDirtyFlag;
    }

    public void resetPSDEGridColId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridColId();
            return;
        }
        this.psdegridcolidDirtyFlag = false;
        this.psdegridcolid = null;
    }

    public void setPSDEGridColName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridColName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegridcolname = string;
        this.psdegridcolnameDirtyFlag = true;
    }

    public String getPSDEGridColName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridColName();
        }
        return this.psdegridcolname;
    }

    public boolean isPSDEGridColNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridColNameDirty();
        }
        return this.psdegridcolnameDirtyFlag;
    }

    public void resetPSDEGridColName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridColName();
            return;
        }
        this.psdegridcolnameDirtyFlag = false;
        this.psdegridcolname = null;
    }

    public void setPSDEGridId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegridid = string;
        this.psdegrididDirtyFlag = true;
    }

    public String getPSDEGridId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridId();
        }
        return this.psdegridid;
    }

    public boolean isPSDEGridIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridIdDirty();
        }
        return this.psdegrididDirtyFlag;
    }

    public void resetPSDEGridId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridId();
            return;
        }
        this.psdegrididDirtyFlag = false;
        this.psdegridid = null;
    }

    public void setPSDEGridName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegridname = string;
        this.psdegridnameDirtyFlag = true;
    }

    public String getPSDEGridName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridName();
        }
        return this.psdegridname;
    }

    public boolean isPSDEGridNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridNameDirty();
        }
        return this.psdegridnameDirtyFlag;
    }

    public void resetPSDEGridName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridName();
            return;
        }
        this.psdegridnameDirtyFlag = false;
        this.psdegridname = null;
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

    public void setVRType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVRType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vrtype = string;
        this.vrtypeDirtyFlag = true;
    }

    public String getVRType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVRType();
        }
        return this.vrtype;
    }

    public boolean isVRTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVRTypeDirty();
        }
        return this.vrtypeDirtyFlag;
    }

    public void resetVRType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVRType();
            return;
        }
        this.vrtypeDirtyFlag = false;
        this.vrtype = null;
    }

    protected void onReset() {
        PSDEGEIVRBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEGEIVRBase pSDEGEIVRBase) {
        pSDEGEIVRBase.resetCheckMode();
        pSDEGEIVRBase.resetCreateDate();
        pSDEGEIVRBase.resetCreateMan();
        pSDEGEIVRBase.resetMemo();
        pSDEGEIVRBase.resetModelState();
        pSDEGEIVRBase.resetOrderValue();
        pSDEGEIVRBase.resetPSDEFVRId();
        pSDEGEIVRBase.resetPSDEFVRName();
        pSDEGEIVRBase.resetPSDEGEIVRId();
        pSDEGEIVRBase.resetPSDEGEIVRName();
        pSDEGEIVRBase.resetPSDEGridColId();
        pSDEGEIVRBase.resetPSDEGridColName();
        pSDEGEIVRBase.resetPSDEGridId();
        pSDEGEIVRBase.resetPSDEGridName();
        pSDEGEIVRBase.resetPSSysValueRuleId();
        pSDEGEIVRBase.resetPSSysValueRuleName();
        pSDEGEIVRBase.resetUpdateDate();
        pSDEGEIVRBase.resetUpdateMan();
        pSDEGEIVRBase.resetUserCat();
        pSDEGEIVRBase.resetUserTag();
        pSDEGEIVRBase.resetUserTag2();
        pSDEGEIVRBase.resetUserTag3();
        pSDEGEIVRBase.resetUserTag4();
        pSDEGEIVRBase.resetVRType();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCheckModeDirty()) {
            hashMap.put(FIELD_CHECKMODE, this.getCheckMode());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModelStateDirty()) {
            hashMap.put(FIELD_MODELSTATE, this.getModelState());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDEFVRIdDirty()) {
            hashMap.put(FIELD_PSDEFVRID, this.getPSDEFVRId());
        }
        if (!bl || this.isPSDEFVRNameDirty()) {
            hashMap.put(FIELD_PSDEFVRNAME, this.getPSDEFVRName());
        }
        if (!bl || this.isPSDEGEIVRIdDirty()) {
            hashMap.put(FIELD_PSDEGEIVRID, this.getPSDEGEIVRId());
        }
        if (!bl || this.isPSDEGEIVRNameDirty()) {
            hashMap.put(FIELD_PSDEGEIVRNAME, this.getPSDEGEIVRName());
        }
        if (!bl || this.isPSDEGridColIdDirty()) {
            hashMap.put(FIELD_PSDEGRIDCOLID, this.getPSDEGridColId());
        }
        if (!bl || this.isPSDEGridColNameDirty()) {
            hashMap.put(FIELD_PSDEGRIDCOLNAME, this.getPSDEGridColName());
        }
        if (!bl || this.isPSDEGridIdDirty()) {
            hashMap.put(FIELD_PSDEGRIDID, this.getPSDEGridId());
        }
        if (!bl || this.isPSDEGridNameDirty()) {
            hashMap.put(FIELD_PSDEGRIDNAME, this.getPSDEGridName());
        }
        if (!bl || this.isPSSysValueRuleIdDirty()) {
            hashMap.put(FIELD_PSSYSVALUERULEID, this.getPSSysValueRuleId());
        }
        if (!bl || this.isPSSysValueRuleNameDirty()) {
            hashMap.put(FIELD_PSSYSVALUERULENAME, this.getPSSysValueRuleName());
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
        if (!bl || this.isVRTypeDirty()) {
            hashMap.put(FIELD_VRTYPE, this.getVRType());
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
        return PSDEGEIVRBase.get(this, n);
    }

    private static Object get(PSDEGEIVRBase pSDEGEIVRBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEGEIVRBase.getCheckMode();
            }
            case 1: {
                return pSDEGEIVRBase.getCreateDate();
            }
            case 2: {
                return pSDEGEIVRBase.getCreateMan();
            }
            case 3: {
                return pSDEGEIVRBase.getMemo();
            }
            case 4: {
                return pSDEGEIVRBase.getModelState();
            }
            case 5: {
                return pSDEGEIVRBase.getOrderValue();
            }
            case 6: {
                return pSDEGEIVRBase.getPSDEFVRId();
            }
            case 7: {
                return pSDEGEIVRBase.getPSDEFVRName();
            }
            case 8: {
                return pSDEGEIVRBase.getPSDEGEIVRId();
            }
            case 9: {
                return pSDEGEIVRBase.getPSDEGEIVRName();
            }
            case 10: {
                return pSDEGEIVRBase.getPSDEGridColId();
            }
            case 11: {
                return pSDEGEIVRBase.getPSDEGridColName();
            }
            case 12: {
                return pSDEGEIVRBase.getPSDEGridId();
            }
            case 13: {
                return pSDEGEIVRBase.getPSDEGridName();
            }
            case 14: {
                return pSDEGEIVRBase.getPSSysValueRuleId();
            }
            case 15: {
                return pSDEGEIVRBase.getPSSysValueRuleName();
            }
            case 16: {
                return pSDEGEIVRBase.getUpdateDate();
            }
            case 17: {
                return pSDEGEIVRBase.getUpdateMan();
            }
            case 18: {
                return pSDEGEIVRBase.getUserCat();
            }
            case 19: {
                return pSDEGEIVRBase.getUserTag();
            }
            case 20: {
                return pSDEGEIVRBase.getUserTag2();
            }
            case 21: {
                return pSDEGEIVRBase.getUserTag3();
            }
            case 22: {
                return pSDEGEIVRBase.getUserTag4();
            }
            case 23: {
                return pSDEGEIVRBase.getVRType();
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
        PSDEGEIVRBase.set(this, n, object);
    }

    private static void set(PSDEGEIVRBase pSDEGEIVRBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEGEIVRBase.setCheckMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDEGEIVRBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDEGEIVRBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEGEIVRBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEGEIVRBase.setModelState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDEGEIVRBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDEGEIVRBase.setPSDEFVRId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEGEIVRBase.setPSDEFVRName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEGEIVRBase.setPSDEGEIVRId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEGEIVRBase.setPSDEGEIVRName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEGEIVRBase.setPSDEGridColId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEGEIVRBase.setPSDEGridColName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEGEIVRBase.setPSDEGridId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEGEIVRBase.setPSDEGridName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEGEIVRBase.setPSSysValueRuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEGEIVRBase.setPSSysValueRuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEGEIVRBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSDEGEIVRBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEGEIVRBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEGEIVRBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEGEIVRBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEGEIVRBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEGEIVRBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEGEIVRBase.setVRType(DataObject.getStringValue((Object)object));
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
        return PSDEGEIVRBase.isNull(this, n);
    }

    private static boolean isNull(PSDEGEIVRBase pSDEGEIVRBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEGEIVRBase.getCheckMode() == null;
            }
            case 1: {
                return pSDEGEIVRBase.getCreateDate() == null;
            }
            case 2: {
                return pSDEGEIVRBase.getCreateMan() == null;
            }
            case 3: {
                return pSDEGEIVRBase.getMemo() == null;
            }
            case 4: {
                return pSDEGEIVRBase.getModelState() == null;
            }
            case 5: {
                return pSDEGEIVRBase.getOrderValue() == null;
            }
            case 6: {
                return pSDEGEIVRBase.getPSDEFVRId() == null;
            }
            case 7: {
                return pSDEGEIVRBase.getPSDEFVRName() == null;
            }
            case 8: {
                return pSDEGEIVRBase.getPSDEGEIVRId() == null;
            }
            case 9: {
                return pSDEGEIVRBase.getPSDEGEIVRName() == null;
            }
            case 10: {
                return pSDEGEIVRBase.getPSDEGridColId() == null;
            }
            case 11: {
                return pSDEGEIVRBase.getPSDEGridColName() == null;
            }
            case 12: {
                return pSDEGEIVRBase.getPSDEGridId() == null;
            }
            case 13: {
                return pSDEGEIVRBase.getPSDEGridName() == null;
            }
            case 14: {
                return pSDEGEIVRBase.getPSSysValueRuleId() == null;
            }
            case 15: {
                return pSDEGEIVRBase.getPSSysValueRuleName() == null;
            }
            case 16: {
                return pSDEGEIVRBase.getUpdateDate() == null;
            }
            case 17: {
                return pSDEGEIVRBase.getUpdateMan() == null;
            }
            case 18: {
                return pSDEGEIVRBase.getUserCat() == null;
            }
            case 19: {
                return pSDEGEIVRBase.getUserTag() == null;
            }
            case 20: {
                return pSDEGEIVRBase.getUserTag2() == null;
            }
            case 21: {
                return pSDEGEIVRBase.getUserTag3() == null;
            }
            case 22: {
                return pSDEGEIVRBase.getUserTag4() == null;
            }
            case 23: {
                return pSDEGEIVRBase.getVRType() == null;
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
        return PSDEGEIVRBase.contains(this, n);
    }

    private static boolean contains(PSDEGEIVRBase pSDEGEIVRBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEGEIVRBase.isCheckModeDirty();
            }
            case 1: {
                return pSDEGEIVRBase.isCreateDateDirty();
            }
            case 2: {
                return pSDEGEIVRBase.isCreateManDirty();
            }
            case 3: {
                return pSDEGEIVRBase.isMemoDirty();
            }
            case 4: {
                return pSDEGEIVRBase.isModelStateDirty();
            }
            case 5: {
                return pSDEGEIVRBase.isOrderValueDirty();
            }
            case 6: {
                return pSDEGEIVRBase.isPSDEFVRIdDirty();
            }
            case 7: {
                return pSDEGEIVRBase.isPSDEFVRNameDirty();
            }
            case 8: {
                return pSDEGEIVRBase.isPSDEGEIVRIdDirty();
            }
            case 9: {
                return pSDEGEIVRBase.isPSDEGEIVRNameDirty();
            }
            case 10: {
                return pSDEGEIVRBase.isPSDEGridColIdDirty();
            }
            case 11: {
                return pSDEGEIVRBase.isPSDEGridColNameDirty();
            }
            case 12: {
                return pSDEGEIVRBase.isPSDEGridIdDirty();
            }
            case 13: {
                return pSDEGEIVRBase.isPSDEGridNameDirty();
            }
            case 14: {
                return pSDEGEIVRBase.isPSSysValueRuleIdDirty();
            }
            case 15: {
                return pSDEGEIVRBase.isPSSysValueRuleNameDirty();
            }
            case 16: {
                return pSDEGEIVRBase.isUpdateDateDirty();
            }
            case 17: {
                return pSDEGEIVRBase.isUpdateManDirty();
            }
            case 18: {
                return pSDEGEIVRBase.isUserCatDirty();
            }
            case 19: {
                return pSDEGEIVRBase.isUserTagDirty();
            }
            case 20: {
                return pSDEGEIVRBase.isUserTag2Dirty();
            }
            case 21: {
                return pSDEGEIVRBase.isUserTag3Dirty();
            }
            case 22: {
                return pSDEGEIVRBase.isUserTag4Dirty();
            }
            case 23: {
                return pSDEGEIVRBase.isVRTypeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEGEIVRBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEGEIVRBase pSDEGEIVRBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEGEIVRBase.getCheckMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"checkmode", (Object)PSDEGEIVRBase.getJSONValue((Object)pSDEGEIVRBase.getCheckMode()), (boolean)false);
        }
        if (bl || pSDEGEIVRBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEGEIVRBase.getJSONValue((Object)pSDEGEIVRBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEGEIVRBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEGEIVRBase.getJSONValue((Object)pSDEGEIVRBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEGEIVRBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEGEIVRBase.getJSONValue((Object)pSDEGEIVRBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEGEIVRBase.getModelState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelstate", (Object)PSDEGEIVRBase.getJSONValue((Object)pSDEGEIVRBase.getModelState()), (boolean)false);
        }
        if (bl || pSDEGEIVRBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEGEIVRBase.getJSONValue((Object)pSDEGEIVRBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEGEIVRBase.getPSDEFVRId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvrid", (Object)PSDEGEIVRBase.getJSONValue((Object)pSDEGEIVRBase.getPSDEFVRId()), (boolean)false);
        }
        if (bl || pSDEGEIVRBase.getPSDEFVRName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvrname", (Object)PSDEGEIVRBase.getJSONValue((Object)pSDEGEIVRBase.getPSDEFVRName()), (boolean)false);
        }
        if (bl || pSDEGEIVRBase.getPSDEGEIVRId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegeivrid", (Object)PSDEGEIVRBase.getJSONValue((Object)pSDEGEIVRBase.getPSDEGEIVRId()), (boolean)false);
        }
        if (bl || pSDEGEIVRBase.getPSDEGEIVRName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegeivrname", (Object)PSDEGEIVRBase.getJSONValue((Object)pSDEGEIVRBase.getPSDEGEIVRName()), (boolean)false);
        }
        if (bl || pSDEGEIVRBase.getPSDEGridColId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridcolid", (Object)PSDEGEIVRBase.getJSONValue((Object)pSDEGEIVRBase.getPSDEGridColId()), (boolean)false);
        }
        if (bl || pSDEGEIVRBase.getPSDEGridColName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridcolname", (Object)PSDEGEIVRBase.getJSONValue((Object)pSDEGEIVRBase.getPSDEGridColName()), (boolean)false);
        }
        if (bl || pSDEGEIVRBase.getPSDEGridId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridid", (Object)PSDEGEIVRBase.getJSONValue((Object)pSDEGEIVRBase.getPSDEGridId()), (boolean)false);
        }
        if (bl || pSDEGEIVRBase.getPSDEGridName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridname", (Object)PSDEGEIVRBase.getJSONValue((Object)pSDEGEIVRBase.getPSDEGridName()), (boolean)false);
        }
        if (bl || pSDEGEIVRBase.getPSSysValueRuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysvalueruleid", (Object)PSDEGEIVRBase.getJSONValue((Object)pSDEGEIVRBase.getPSSysValueRuleId()), (boolean)false);
        }
        if (bl || pSDEGEIVRBase.getPSSysValueRuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysvaluerulename", (Object)PSDEGEIVRBase.getJSONValue((Object)pSDEGEIVRBase.getPSSysValueRuleName()), (boolean)false);
        }
        if (bl || pSDEGEIVRBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEGEIVRBase.getJSONValue((Object)pSDEGEIVRBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEGEIVRBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEGEIVRBase.getJSONValue((Object)pSDEGEIVRBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEGEIVRBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEGEIVRBase.getJSONValue((Object)pSDEGEIVRBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEGEIVRBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEGEIVRBase.getJSONValue((Object)pSDEGEIVRBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEGEIVRBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEGEIVRBase.getJSONValue((Object)pSDEGEIVRBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEGEIVRBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEGEIVRBase.getJSONValue((Object)pSDEGEIVRBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEGEIVRBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEGEIVRBase.getJSONValue((Object)pSDEGEIVRBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEGEIVRBase.getVRType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vrtype", (Object)PSDEGEIVRBase.getJSONValue((Object)pSDEGEIVRBase.getVRType()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEGEIVRBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEGEIVRBase pSDEGEIVRBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEGEIVRBase.getCheckMode() != null) {
            object = pSDEGEIVRBase.getCheckMode();
            xmlNode.setAttribute(FIELD_CHECKMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGEIVRBase.getCreateDate() != null) {
            object = pSDEGEIVRBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEGEIVRBase.getCreateMan() != null) {
            object = pSDEGEIVRBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIVRBase.getMemo() != null) {
            object = pSDEGEIVRBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIVRBase.getModelState() != null) {
            object = pSDEGEIVRBase.getModelState();
            xmlNode.setAttribute(FIELD_MODELSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGEIVRBase.getOrderValue() != null) {
            object = pSDEGEIVRBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEGEIVRBase.getPSDEFVRId() != null) {
            object = pSDEGEIVRBase.getPSDEFVRId();
            xmlNode.setAttribute(FIELD_PSDEFVRID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIVRBase.getPSDEFVRName() != null) {
            object = pSDEGEIVRBase.getPSDEFVRName();
            xmlNode.setAttribute(FIELD_PSDEFVRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIVRBase.getPSDEGEIVRId() != null) {
            object = pSDEGEIVRBase.getPSDEGEIVRId();
            xmlNode.setAttribute(FIELD_PSDEGEIVRID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIVRBase.getPSDEGEIVRName() != null) {
            object = pSDEGEIVRBase.getPSDEGEIVRName();
            xmlNode.setAttribute(FIELD_PSDEGEIVRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIVRBase.getPSDEGridColId() != null) {
            object = pSDEGEIVRBase.getPSDEGridColId();
            xmlNode.setAttribute(FIELD_PSDEGRIDCOLID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIVRBase.getPSDEGridColName() != null) {
            object = pSDEGEIVRBase.getPSDEGridColName();
            xmlNode.setAttribute(FIELD_PSDEGRIDCOLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIVRBase.getPSDEGridId() != null) {
            object = pSDEGEIVRBase.getPSDEGridId();
            xmlNode.setAttribute(FIELD_PSDEGRIDID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIVRBase.getPSDEGridName() != null) {
            object = pSDEGEIVRBase.getPSDEGridName();
            xmlNode.setAttribute(FIELD_PSDEGRIDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIVRBase.getPSSysValueRuleId() != null) {
            object = pSDEGEIVRBase.getPSSysValueRuleId();
            xmlNode.setAttribute(FIELD_PSSYSVALUERULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIVRBase.getPSSysValueRuleName() != null) {
            object = pSDEGEIVRBase.getPSSysValueRuleName();
            xmlNode.setAttribute(FIELD_PSSYSVALUERULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIVRBase.getUpdateDate() != null) {
            object = pSDEGEIVRBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEGEIVRBase.getUpdateMan() != null) {
            object = pSDEGEIVRBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIVRBase.getUserCat() != null) {
            object = pSDEGEIVRBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIVRBase.getUserTag() != null) {
            object = pSDEGEIVRBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIVRBase.getUserTag2() != null) {
            object = pSDEGEIVRBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIVRBase.getUserTag3() != null) {
            object = pSDEGEIVRBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIVRBase.getUserTag4() != null) {
            object = pSDEGEIVRBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIVRBase.getVRType() != null) {
            object = pSDEGEIVRBase.getVRType();
            xmlNode.setAttribute(FIELD_VRTYPE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEGEIVRBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEGEIVRBase pSDEGEIVRBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEGEIVRBase.isCheckModeDirty() && (bl || pSDEGEIVRBase.getCheckMode() != null)) {
            iDataObject.set(FIELD_CHECKMODE, (Object)pSDEGEIVRBase.getCheckMode());
        }
        if (pSDEGEIVRBase.isCreateDateDirty() && (bl || pSDEGEIVRBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEGEIVRBase.getCreateDate());
        }
        if (pSDEGEIVRBase.isCreateManDirty() && (bl || pSDEGEIVRBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEGEIVRBase.getCreateMan());
        }
        if (pSDEGEIVRBase.isMemoDirty() && (bl || pSDEGEIVRBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEGEIVRBase.getMemo());
        }
        if (pSDEGEIVRBase.isModelStateDirty() && (bl || pSDEGEIVRBase.getModelState() != null)) {
            iDataObject.set(FIELD_MODELSTATE, (Object)pSDEGEIVRBase.getModelState());
        }
        if (pSDEGEIVRBase.isOrderValueDirty() && (bl || pSDEGEIVRBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEGEIVRBase.getOrderValue());
        }
        if (pSDEGEIVRBase.isPSDEFVRIdDirty() && (bl || pSDEGEIVRBase.getPSDEFVRId() != null)) {
            iDataObject.set(FIELD_PSDEFVRID, (Object)pSDEGEIVRBase.getPSDEFVRId());
        }
        if (pSDEGEIVRBase.isPSDEFVRNameDirty() && (bl || pSDEGEIVRBase.getPSDEFVRName() != null)) {
            iDataObject.set(FIELD_PSDEFVRNAME, (Object)pSDEGEIVRBase.getPSDEFVRName());
        }
        if (pSDEGEIVRBase.isPSDEGEIVRIdDirty() && (bl || pSDEGEIVRBase.getPSDEGEIVRId() != null)) {
            iDataObject.set(FIELD_PSDEGEIVRID, (Object)pSDEGEIVRBase.getPSDEGEIVRId());
        }
        if (pSDEGEIVRBase.isPSDEGEIVRNameDirty() && (bl || pSDEGEIVRBase.getPSDEGEIVRName() != null)) {
            iDataObject.set(FIELD_PSDEGEIVRNAME, (Object)pSDEGEIVRBase.getPSDEGEIVRName());
        }
        if (pSDEGEIVRBase.isPSDEGridColIdDirty() && (bl || pSDEGEIVRBase.getPSDEGridColId() != null)) {
            iDataObject.set(FIELD_PSDEGRIDCOLID, (Object)pSDEGEIVRBase.getPSDEGridColId());
        }
        if (pSDEGEIVRBase.isPSDEGridColNameDirty() && (bl || pSDEGEIVRBase.getPSDEGridColName() != null)) {
            iDataObject.set(FIELD_PSDEGRIDCOLNAME, (Object)pSDEGEIVRBase.getPSDEGridColName());
        }
        if (pSDEGEIVRBase.isPSDEGridIdDirty() && (bl || pSDEGEIVRBase.getPSDEGridId() != null)) {
            iDataObject.set(FIELD_PSDEGRIDID, (Object)pSDEGEIVRBase.getPSDEGridId());
        }
        if (pSDEGEIVRBase.isPSDEGridNameDirty() && (bl || pSDEGEIVRBase.getPSDEGridName() != null)) {
            iDataObject.set(FIELD_PSDEGRIDNAME, (Object)pSDEGEIVRBase.getPSDEGridName());
        }
        if (pSDEGEIVRBase.isPSSysValueRuleIdDirty() && (bl || pSDEGEIVRBase.getPSSysValueRuleId() != null)) {
            iDataObject.set(FIELD_PSSYSVALUERULEID, (Object)pSDEGEIVRBase.getPSSysValueRuleId());
        }
        if (pSDEGEIVRBase.isPSSysValueRuleNameDirty() && (bl || pSDEGEIVRBase.getPSSysValueRuleName() != null)) {
            iDataObject.set(FIELD_PSSYSVALUERULENAME, (Object)pSDEGEIVRBase.getPSSysValueRuleName());
        }
        if (pSDEGEIVRBase.isUpdateDateDirty() && (bl || pSDEGEIVRBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEGEIVRBase.getUpdateDate());
        }
        if (pSDEGEIVRBase.isUpdateManDirty() && (bl || pSDEGEIVRBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEGEIVRBase.getUpdateMan());
        }
        if (pSDEGEIVRBase.isUserCatDirty() && (bl || pSDEGEIVRBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEGEIVRBase.getUserCat());
        }
        if (pSDEGEIVRBase.isUserTagDirty() && (bl || pSDEGEIVRBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEGEIVRBase.getUserTag());
        }
        if (pSDEGEIVRBase.isUserTag2Dirty() && (bl || pSDEGEIVRBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEGEIVRBase.getUserTag2());
        }
        if (pSDEGEIVRBase.isUserTag3Dirty() && (bl || pSDEGEIVRBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEGEIVRBase.getUserTag3());
        }
        if (pSDEGEIVRBase.isUserTag4Dirty() && (bl || pSDEGEIVRBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEGEIVRBase.getUserTag4());
        }
        if (pSDEGEIVRBase.isVRTypeDirty() && (bl || pSDEGEIVRBase.getVRType() != null)) {
            iDataObject.set(FIELD_VRTYPE, (Object)pSDEGEIVRBase.getVRType());
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
        return PSDEGEIVRBase.remove(this, n);
    }

    private static boolean remove(PSDEGEIVRBase pSDEGEIVRBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEGEIVRBase.resetCheckMode();
                return true;
            }
            case 1: {
                pSDEGEIVRBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDEGEIVRBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDEGEIVRBase.resetMemo();
                return true;
            }
            case 4: {
                pSDEGEIVRBase.resetModelState();
                return true;
            }
            case 5: {
                pSDEGEIVRBase.resetOrderValue();
                return true;
            }
            case 6: {
                pSDEGEIVRBase.resetPSDEFVRId();
                return true;
            }
            case 7: {
                pSDEGEIVRBase.resetPSDEFVRName();
                return true;
            }
            case 8: {
                pSDEGEIVRBase.resetPSDEGEIVRId();
                return true;
            }
            case 9: {
                pSDEGEIVRBase.resetPSDEGEIVRName();
                return true;
            }
            case 10: {
                pSDEGEIVRBase.resetPSDEGridColId();
                return true;
            }
            case 11: {
                pSDEGEIVRBase.resetPSDEGridColName();
                return true;
            }
            case 12: {
                pSDEGEIVRBase.resetPSDEGridId();
                return true;
            }
            case 13: {
                pSDEGEIVRBase.resetPSDEGridName();
                return true;
            }
            case 14: {
                pSDEGEIVRBase.resetPSSysValueRuleId();
                return true;
            }
            case 15: {
                pSDEGEIVRBase.resetPSSysValueRuleName();
                return true;
            }
            case 16: {
                pSDEGEIVRBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSDEGEIVRBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSDEGEIVRBase.resetUserCat();
                return true;
            }
            case 19: {
                pSDEGEIVRBase.resetUserTag();
                return true;
            }
            case 20: {
                pSDEGEIVRBase.resetUserTag2();
                return true;
            }
            case 21: {
                pSDEGEIVRBase.resetUserTag3();
                return true;
            }
            case 22: {
                pSDEGEIVRBase.resetUserTag4();
                return true;
            }
            case 23: {
                pSDEGEIVRBase.resetVRType();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFValueRule getPSDEFVR() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFVR();
        }
        if (this.getPSDEFVRId() == null) {
            return null;
        }
        Integer n = this.objPSDEFVRLock;
        synchronized (n) {
            if (this.psdefvr != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFVRId(), (Object)this.psdefvr.getPSDEFValueRuleId()) != 0L) {
                this.psdefvr = null;
            }
            if (this.psdefvr == null) {
                PSDEFValueRule pSDEFValueRule = new PSDEFValueRule();
                pSDEFValueRule.setPSDEFValueRuleId(this.getPSDEFVRId());
                PSDEFValueRuleService pSDEFValueRuleService = (PSDEFValueRuleService)ServiceGlobal.getService(PSDEFValueRuleService.class, (SessionFactory)this.getSessionFactory());
                pSDEFValueRuleService.autoGet(pSDEFValueRule);
                this.psdefvr = pSDEFValueRule;
            }
            return this.psdefvr;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEGridCol getPSDEGridCol() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridCol();
        }
        if (this.getPSDEGridColId() == null) {
            return null;
        }
        Integer n = this.objPSDEGridColLock;
        synchronized (n) {
            if (this.psdegridcol != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEGridColId(), (Object)this.psdegridcol.getPSDEGridColId()) != 0L) {
                this.psdegridcol = null;
            }
            if (this.psdegridcol == null) {
                PSDEGridCol pSDEGridCol = new PSDEGridCol();
                pSDEGridCol.setPSDEGridColId(this.getPSDEGridColId());
                PSDEGridColService pSDEGridColService = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
                pSDEGridColService.autoGet(pSDEGridCol);
                this.psdegridcol = pSDEGridCol;
            }
            return this.psdegridcol;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEGrid getPSDEGrid() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGrid();
        }
        if (this.getPSDEGridId() == null) {
            return null;
        }
        Integer n = this.objPSDEGridLock;
        synchronized (n) {
            if (this.psdegrid != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEGridId(), (Object)this.psdegrid.getPSDEGridId()) != 0L) {
                this.psdegrid = null;
            }
            if (this.psdegrid == null) {
                PSDEGrid pSDEGrid = new PSDEGrid();
                pSDEGrid.setPSDEGridId(this.getPSDEGridId());
                PSDEGridService pSDEGridService = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
                pSDEGridService.autoGet(pSDEGrid);
                this.psdegrid = pSDEGrid;
            }
            return this.psdegrid;
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
                pSSysValueRuleService.autoGet(pSSysValueRule);
                this.pssysvaluerule = pSSysValueRule;
            }
            return this.pssysvaluerule;
        }
    }

    private PSDEGEIVRBase getProxyEntity() {
        return this.proxyPSDEGEIVRBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEGEIVRBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEGEIVRBase) {
            this.proxyPSDEGEIVRBase = (PSDEGEIVRBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEGEIVRService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CHECKMODE, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_MODELSTATE, 4);
        fieldIndexMap.put(FIELD_ORDERVALUE, 5);
        fieldIndexMap.put(FIELD_PSDEFVRID, 6);
        fieldIndexMap.put(FIELD_PSDEFVRNAME, 7);
        fieldIndexMap.put(FIELD_PSDEGEIVRID, 8);
        fieldIndexMap.put(FIELD_PSDEGEIVRNAME, 9);
        fieldIndexMap.put(FIELD_PSDEGRIDCOLID, 10);
        fieldIndexMap.put(FIELD_PSDEGRIDCOLNAME, 11);
        fieldIndexMap.put(FIELD_PSDEGRIDID, 12);
        fieldIndexMap.put(FIELD_PSDEGRIDNAME, 13);
        fieldIndexMap.put(FIELD_PSSYSVALUERULEID, 14);
        fieldIndexMap.put(FIELD_PSSYSVALUERULENAME, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_USERCAT, 18);
        fieldIndexMap.put(FIELD_USERTAG, 19);
        fieldIndexMap.put(FIELD_USERTAG2, 20);
        fieldIndexMap.put(FIELD_USERTAG3, 21);
        fieldIndexMap.put(FIELD_USERTAG4, 22);
        fieldIndexMap.put(FIELD_VRTYPE, 23);
    }
}

