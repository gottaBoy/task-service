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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetail;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysValueRule;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysValueRuleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFIVRBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEFIVRBase.class);
    public static final String FIELD_CHECKMODE = "CHECKMODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELSTATE = "MODELSTATE";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEFIID = "PSDEFIID";
    public static final String FIELD_PSDEFINAME = "PSDEFINAME";
    public static final String FIELD_PSDEFIVRID = "PSDEFIVRID";
    public static final String FIELD_PSDEFIVRNAME = "PSDEFIVRNAME";
    public static final String FIELD_PSDEFORMID = "PSDEFORMID";
    public static final String FIELD_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String FIELD_PSDEFVRID = "PSDEFVRID";
    public static final String FIELD_PSDEFVRNAME = "PSDEFVRNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
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
    private static final int INDEX_DYNAMODELFLAG = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_MODELSTATE = 5;
    private static final int INDEX_ORDERVALUE = 6;
    private static final int INDEX_PSDEFIID = 7;
    private static final int INDEX_PSDEFINAME = 8;
    private static final int INDEX_PSDEFIVRID = 9;
    private static final int INDEX_PSDEFIVRNAME = 10;
    private static final int INDEX_PSDEFORMID = 11;
    private static final int INDEX_PSDEFORMNAME = 12;
    private static final int INDEX_PSDEFVRID = 13;
    private static final int INDEX_PSDEFVRNAME = 14;
    private static final int INDEX_PSDYNAINSTID = 15;
    private static final int INDEX_PSSYSVALUERULEID = 16;
    private static final int INDEX_PSSYSVALUERULENAME = 17;
    private static final int INDEX_UPDATEDATE = 18;
    private static final int INDEX_UPDATEMAN = 19;
    private static final int INDEX_USERCAT = 20;
    private static final int INDEX_USERTAG = 21;
    private static final int INDEX_USERTAG2 = 22;
    private static final int INDEX_USERTAG3 = 23;
    private static final int INDEX_USERTAG4 = 24;
    private static final int INDEX_VRTYPE = 25;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEFIVRBase proxyPSDEFIVRBase = null;
    private boolean checkmodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modelstateDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdefiidDirtyFlag = false;
    private boolean psdefinameDirtyFlag = false;
    private boolean psdefivridDirtyFlag = false;
    private boolean psdefivrnameDirtyFlag = false;
    private boolean psdeformidDirtyFlag = false;
    private boolean psdeformnameDirtyFlag = false;
    private boolean psdefvridDirtyFlag = false;
    private boolean psdefvrnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
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
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="memo")
    private String memo;
    @Column(name="modelstate")
    private Integer modelstate;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdefiid")
    private String psdefiid;
    @Column(name="psdefiname")
    private String psdefiname;
    @Column(name="psdefivrid")
    private String psdefivrid;
    @Column(name="psdefivrname")
    private String psdefivrname;
    @Column(name="psdeformid")
    private String psdeformid;
    @Column(name="psdeformname")
    private String psdeformname;
    @Column(name="psdefvrid")
    private String psdefvrid;
    @Column(name="psdefvrname")
    private String psdefvrname;
    @Column(name="psdynainstid")
    private String psdynainstid;
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
    private Integer objPSDEFILock = new Integer(1);
    private PSDEFormDetail psdefi = null;
    private Integer objPSDEFormLock = new Integer(1);
    private PSDEForm psdeform = null;
    private Integer objPSDEFVRLock = new Integer(1);
    private PSDEFValueRule psdefvr = null;
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

    public void setDynaModelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModelFlag(n);
            return;
        }
        this.dynamodelflag = n;
        this.dynamodelflagDirtyFlag = true;
    }

    public Integer getDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModelFlag();
        }
        return this.dynamodelflag;
    }

    public boolean isDynaModelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelFlagDirty();
        }
        return this.dynamodelflagDirtyFlag;
    }

    public void resetDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModelFlag();
            return;
        }
        this.dynamodelflagDirtyFlag = false;
        this.dynamodelflag = null;
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

    public void setPSDEFIId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFIId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefiid = string;
        this.psdefiidDirtyFlag = true;
    }

    public String getPSDEFIId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFIId();
        }
        return this.psdefiid;
    }

    public boolean isPSDEFIIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIIdDirty();
        }
        return this.psdefiidDirtyFlag;
    }

    public void resetPSDEFIId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFIId();
            return;
        }
        this.psdefiidDirtyFlag = false;
        this.psdefiid = null;
    }

    public void setPSDEFIName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFIName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefiname = string;
        this.psdefinameDirtyFlag = true;
    }

    public String getPSDEFIName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFIName();
        }
        return this.psdefiname;
    }

    public boolean isPSDEFINameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFINameDirty();
        }
        return this.psdefinameDirtyFlag;
    }

    public void resetPSDEFIName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFIName();
            return;
        }
        this.psdefinameDirtyFlag = false;
        this.psdefiname = null;
    }

    public void setPSDEFIVRId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFIVRId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefivrid = string;
        this.psdefivridDirtyFlag = true;
    }

    public String getPSDEFIVRId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFIVRId();
        }
        return this.psdefivrid;
    }

    public boolean isPSDEFIVRIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIVRIdDirty();
        }
        return this.psdefivridDirtyFlag;
    }

    public void resetPSDEFIVRId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFIVRId();
            return;
        }
        this.psdefivridDirtyFlag = false;
        this.psdefivrid = null;
    }

    public void setPSDEFIVRName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFIVRName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefivrname = string;
        this.psdefivrnameDirtyFlag = true;
    }

    public String getPSDEFIVRName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFIVRName();
        }
        return this.psdefivrname;
    }

    public boolean isPSDEFIVRNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIVRNameDirty();
        }
        return this.psdefivrnameDirtyFlag;
    }

    public void resetPSDEFIVRName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFIVRName();
            return;
        }
        this.psdefivrnameDirtyFlag = false;
        this.psdefivrname = null;
    }

    public void setPSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformid = string;
        this.psdeformidDirtyFlag = true;
    }

    public String getPSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormId();
        }
        return this.psdeformid;
    }

    public boolean isPSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormIdDirty();
        }
        return this.psdeformidDirtyFlag;
    }

    public void resetPSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormId();
            return;
        }
        this.psdeformidDirtyFlag = false;
        this.psdeformid = null;
    }

    public void setPSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformname = string;
        this.psdeformnameDirtyFlag = true;
    }

    public String getPSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormName();
        }
        return this.psdeformname;
    }

    public boolean isPSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormNameDirty();
        }
        return this.psdeformnameDirtyFlag;
    }

    public void resetPSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormName();
            return;
        }
        this.psdeformnameDirtyFlag = false;
        this.psdeformname = null;
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

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
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
        PSDEFIVRBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEFIVRBase pSDEFIVRBase) {
        pSDEFIVRBase.resetCheckMode();
        pSDEFIVRBase.resetCreateDate();
        pSDEFIVRBase.resetCreateMan();
        pSDEFIVRBase.resetDynaModelFlag();
        pSDEFIVRBase.resetMemo();
        pSDEFIVRBase.resetModelState();
        pSDEFIVRBase.resetOrderValue();
        pSDEFIVRBase.resetPSDEFIId();
        pSDEFIVRBase.resetPSDEFIName();
        pSDEFIVRBase.resetPSDEFIVRId();
        pSDEFIVRBase.resetPSDEFIVRName();
        pSDEFIVRBase.resetPSDEFormId();
        pSDEFIVRBase.resetPSDEFormName();
        pSDEFIVRBase.resetPSDEFVRId();
        pSDEFIVRBase.resetPSDEFVRName();
        pSDEFIVRBase.resetPSDynaInstId();
        pSDEFIVRBase.resetPSSysValueRuleId();
        pSDEFIVRBase.resetPSSysValueRuleName();
        pSDEFIVRBase.resetUpdateDate();
        pSDEFIVRBase.resetUpdateMan();
        pSDEFIVRBase.resetUserCat();
        pSDEFIVRBase.resetUserTag();
        pSDEFIVRBase.resetUserTag2();
        pSDEFIVRBase.resetUserTag3();
        pSDEFIVRBase.resetUserTag4();
        pSDEFIVRBase.resetVRType();
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
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
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
        if (!bl || this.isPSDEFIIdDirty()) {
            hashMap.put(FIELD_PSDEFIID, this.getPSDEFIId());
        }
        if (!bl || this.isPSDEFINameDirty()) {
            hashMap.put(FIELD_PSDEFINAME, this.getPSDEFIName());
        }
        if (!bl || this.isPSDEFIVRIdDirty()) {
            hashMap.put(FIELD_PSDEFIVRID, this.getPSDEFIVRId());
        }
        if (!bl || this.isPSDEFIVRNameDirty()) {
            hashMap.put(FIELD_PSDEFIVRNAME, this.getPSDEFIVRName());
        }
        if (!bl || this.isPSDEFormIdDirty()) {
            hashMap.put(FIELD_PSDEFORMID, this.getPSDEFormId());
        }
        if (!bl || this.isPSDEFormNameDirty()) {
            hashMap.put(FIELD_PSDEFORMNAME, this.getPSDEFormName());
        }
        if (!bl || this.isPSDEFVRIdDirty()) {
            hashMap.put(FIELD_PSDEFVRID, this.getPSDEFVRId());
        }
        if (!bl || this.isPSDEFVRNameDirty()) {
            hashMap.put(FIELD_PSDEFVRNAME, this.getPSDEFVRName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
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
        return PSDEFIVRBase.get(this, n);
    }

    private static Object get(PSDEFIVRBase pSDEFIVRBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFIVRBase.getCheckMode();
            }
            case 1: {
                return pSDEFIVRBase.getCreateDate();
            }
            case 2: {
                return pSDEFIVRBase.getCreateMan();
            }
            case 3: {
                return pSDEFIVRBase.getDynaModelFlag();
            }
            case 4: {
                return pSDEFIVRBase.getMemo();
            }
            case 5: {
                return pSDEFIVRBase.getModelState();
            }
            case 6: {
                return pSDEFIVRBase.getOrderValue();
            }
            case 7: {
                return pSDEFIVRBase.getPSDEFIId();
            }
            case 8: {
                return pSDEFIVRBase.getPSDEFIName();
            }
            case 9: {
                return pSDEFIVRBase.getPSDEFIVRId();
            }
            case 10: {
                return pSDEFIVRBase.getPSDEFIVRName();
            }
            case 11: {
                return pSDEFIVRBase.getPSDEFormId();
            }
            case 12: {
                return pSDEFIVRBase.getPSDEFormName();
            }
            case 13: {
                return pSDEFIVRBase.getPSDEFVRId();
            }
            case 14: {
                return pSDEFIVRBase.getPSDEFVRName();
            }
            case 15: {
                return pSDEFIVRBase.getPSDynaInstId();
            }
            case 16: {
                return pSDEFIVRBase.getPSSysValueRuleId();
            }
            case 17: {
                return pSDEFIVRBase.getPSSysValueRuleName();
            }
            case 18: {
                return pSDEFIVRBase.getUpdateDate();
            }
            case 19: {
                return pSDEFIVRBase.getUpdateMan();
            }
            case 20: {
                return pSDEFIVRBase.getUserCat();
            }
            case 21: {
                return pSDEFIVRBase.getUserTag();
            }
            case 22: {
                return pSDEFIVRBase.getUserTag2();
            }
            case 23: {
                return pSDEFIVRBase.getUserTag3();
            }
            case 24: {
                return pSDEFIVRBase.getUserTag4();
            }
            case 25: {
                return pSDEFIVRBase.getVRType();
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
        PSDEFIVRBase.set(this, n, object);
    }

    private static void set(PSDEFIVRBase pSDEFIVRBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEFIVRBase.setCheckMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDEFIVRBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDEFIVRBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEFIVRBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDEFIVRBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEFIVRBase.setModelState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDEFIVRBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDEFIVRBase.setPSDEFIId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEFIVRBase.setPSDEFIName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEFIVRBase.setPSDEFIVRId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEFIVRBase.setPSDEFIVRName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEFIVRBase.setPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEFIVRBase.setPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEFIVRBase.setPSDEFVRId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEFIVRBase.setPSDEFVRName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEFIVRBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEFIVRBase.setPSSysValueRuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEFIVRBase.setPSSysValueRuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEFIVRBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 19: {
                pSDEFIVRBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEFIVRBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEFIVRBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEFIVRBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEFIVRBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEFIVRBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEFIVRBase.setVRType(DataObject.getStringValue((Object)object));
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
        return PSDEFIVRBase.isNull(this, n);
    }

    private static boolean isNull(PSDEFIVRBase pSDEFIVRBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFIVRBase.getCheckMode() == null;
            }
            case 1: {
                return pSDEFIVRBase.getCreateDate() == null;
            }
            case 2: {
                return pSDEFIVRBase.getCreateMan() == null;
            }
            case 3: {
                return pSDEFIVRBase.getDynaModelFlag() == null;
            }
            case 4: {
                return pSDEFIVRBase.getMemo() == null;
            }
            case 5: {
                return pSDEFIVRBase.getModelState() == null;
            }
            case 6: {
                return pSDEFIVRBase.getOrderValue() == null;
            }
            case 7: {
                return pSDEFIVRBase.getPSDEFIId() == null;
            }
            case 8: {
                return pSDEFIVRBase.getPSDEFIName() == null;
            }
            case 9: {
                return pSDEFIVRBase.getPSDEFIVRId() == null;
            }
            case 10: {
                return pSDEFIVRBase.getPSDEFIVRName() == null;
            }
            case 11: {
                return pSDEFIVRBase.getPSDEFormId() == null;
            }
            case 12: {
                return pSDEFIVRBase.getPSDEFormName() == null;
            }
            case 13: {
                return pSDEFIVRBase.getPSDEFVRId() == null;
            }
            case 14: {
                return pSDEFIVRBase.getPSDEFVRName() == null;
            }
            case 15: {
                return pSDEFIVRBase.getPSDynaInstId() == null;
            }
            case 16: {
                return pSDEFIVRBase.getPSSysValueRuleId() == null;
            }
            case 17: {
                return pSDEFIVRBase.getPSSysValueRuleName() == null;
            }
            case 18: {
                return pSDEFIVRBase.getUpdateDate() == null;
            }
            case 19: {
                return pSDEFIVRBase.getUpdateMan() == null;
            }
            case 20: {
                return pSDEFIVRBase.getUserCat() == null;
            }
            case 21: {
                return pSDEFIVRBase.getUserTag() == null;
            }
            case 22: {
                return pSDEFIVRBase.getUserTag2() == null;
            }
            case 23: {
                return pSDEFIVRBase.getUserTag3() == null;
            }
            case 24: {
                return pSDEFIVRBase.getUserTag4() == null;
            }
            case 25: {
                return pSDEFIVRBase.getVRType() == null;
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
        return PSDEFIVRBase.contains(this, n);
    }

    private static boolean contains(PSDEFIVRBase pSDEFIVRBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFIVRBase.isCheckModeDirty();
            }
            case 1: {
                return pSDEFIVRBase.isCreateDateDirty();
            }
            case 2: {
                return pSDEFIVRBase.isCreateManDirty();
            }
            case 3: {
                return pSDEFIVRBase.isDynaModelFlagDirty();
            }
            case 4: {
                return pSDEFIVRBase.isMemoDirty();
            }
            case 5: {
                return pSDEFIVRBase.isModelStateDirty();
            }
            case 6: {
                return pSDEFIVRBase.isOrderValueDirty();
            }
            case 7: {
                return pSDEFIVRBase.isPSDEFIIdDirty();
            }
            case 8: {
                return pSDEFIVRBase.isPSDEFINameDirty();
            }
            case 9: {
                return pSDEFIVRBase.isPSDEFIVRIdDirty();
            }
            case 10: {
                return pSDEFIVRBase.isPSDEFIVRNameDirty();
            }
            case 11: {
                return pSDEFIVRBase.isPSDEFormIdDirty();
            }
            case 12: {
                return pSDEFIVRBase.isPSDEFormNameDirty();
            }
            case 13: {
                return pSDEFIVRBase.isPSDEFVRIdDirty();
            }
            case 14: {
                return pSDEFIVRBase.isPSDEFVRNameDirty();
            }
            case 15: {
                return pSDEFIVRBase.isPSDynaInstIdDirty();
            }
            case 16: {
                return pSDEFIVRBase.isPSSysValueRuleIdDirty();
            }
            case 17: {
                return pSDEFIVRBase.isPSSysValueRuleNameDirty();
            }
            case 18: {
                return pSDEFIVRBase.isUpdateDateDirty();
            }
            case 19: {
                return pSDEFIVRBase.isUpdateManDirty();
            }
            case 20: {
                return pSDEFIVRBase.isUserCatDirty();
            }
            case 21: {
                return pSDEFIVRBase.isUserTagDirty();
            }
            case 22: {
                return pSDEFIVRBase.isUserTag2Dirty();
            }
            case 23: {
                return pSDEFIVRBase.isUserTag3Dirty();
            }
            case 24: {
                return pSDEFIVRBase.isUserTag4Dirty();
            }
            case 25: {
                return pSDEFIVRBase.isVRTypeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEFIVRBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEFIVRBase pSDEFIVRBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEFIVRBase.getCheckMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"checkmode", (Object)PSDEFIVRBase.getJSONValue((Object)pSDEFIVRBase.getCheckMode()), (boolean)false);
        }
        if (bl || pSDEFIVRBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEFIVRBase.getJSONValue((Object)pSDEFIVRBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEFIVRBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEFIVRBase.getJSONValue((Object)pSDEFIVRBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEFIVRBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEFIVRBase.getJSONValue((Object)pSDEFIVRBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEFIVRBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEFIVRBase.getJSONValue((Object)pSDEFIVRBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEFIVRBase.getModelState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelstate", (Object)PSDEFIVRBase.getJSONValue((Object)pSDEFIVRBase.getModelState()), (boolean)false);
        }
        if (bl || pSDEFIVRBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEFIVRBase.getJSONValue((Object)pSDEFIVRBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEFIVRBase.getPSDEFIId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefiid", (Object)PSDEFIVRBase.getJSONValue((Object)pSDEFIVRBase.getPSDEFIId()), (boolean)false);
        }
        if (bl || pSDEFIVRBase.getPSDEFIName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefiname", (Object)PSDEFIVRBase.getJSONValue((Object)pSDEFIVRBase.getPSDEFIName()), (boolean)false);
        }
        if (bl || pSDEFIVRBase.getPSDEFIVRId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefivrid", (Object)PSDEFIVRBase.getJSONValue((Object)pSDEFIVRBase.getPSDEFIVRId()), (boolean)false);
        }
        if (bl || pSDEFIVRBase.getPSDEFIVRName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefivrname", (Object)PSDEFIVRBase.getJSONValue((Object)pSDEFIVRBase.getPSDEFIVRName()), (boolean)false);
        }
        if (bl || pSDEFIVRBase.getPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformid", (Object)PSDEFIVRBase.getJSONValue((Object)pSDEFIVRBase.getPSDEFormId()), (boolean)false);
        }
        if (bl || pSDEFIVRBase.getPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformname", (Object)PSDEFIVRBase.getJSONValue((Object)pSDEFIVRBase.getPSDEFormName()), (boolean)false);
        }
        if (bl || pSDEFIVRBase.getPSDEFVRId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvrid", (Object)PSDEFIVRBase.getJSONValue((Object)pSDEFIVRBase.getPSDEFVRId()), (boolean)false);
        }
        if (bl || pSDEFIVRBase.getPSDEFVRName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvrname", (Object)PSDEFIVRBase.getJSONValue((Object)pSDEFIVRBase.getPSDEFVRName()), (boolean)false);
        }
        if (bl || pSDEFIVRBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEFIVRBase.getJSONValue((Object)pSDEFIVRBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEFIVRBase.getPSSysValueRuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysvalueruleid", (Object)PSDEFIVRBase.getJSONValue((Object)pSDEFIVRBase.getPSSysValueRuleId()), (boolean)false);
        }
        if (bl || pSDEFIVRBase.getPSSysValueRuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysvaluerulename", (Object)PSDEFIVRBase.getJSONValue((Object)pSDEFIVRBase.getPSSysValueRuleName()), (boolean)false);
        }
        if (bl || pSDEFIVRBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEFIVRBase.getJSONValue((Object)pSDEFIVRBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEFIVRBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEFIVRBase.getJSONValue((Object)pSDEFIVRBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEFIVRBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEFIVRBase.getJSONValue((Object)pSDEFIVRBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEFIVRBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEFIVRBase.getJSONValue((Object)pSDEFIVRBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEFIVRBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEFIVRBase.getJSONValue((Object)pSDEFIVRBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEFIVRBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEFIVRBase.getJSONValue((Object)pSDEFIVRBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEFIVRBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEFIVRBase.getJSONValue((Object)pSDEFIVRBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEFIVRBase.getVRType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vrtype", (Object)PSDEFIVRBase.getJSONValue((Object)pSDEFIVRBase.getVRType()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEFIVRBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEFIVRBase pSDEFIVRBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEFIVRBase.getCheckMode() != null) {
            object = pSDEFIVRBase.getCheckMode();
            xmlNode.setAttribute(FIELD_CHECKMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFIVRBase.getCreateDate() != null) {
            object = pSDEFIVRBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFIVRBase.getCreateMan() != null) {
            object = pSDEFIVRBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIVRBase.getDynaModelFlag() != null) {
            object = pSDEFIVRBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFIVRBase.getMemo() != null) {
            object = pSDEFIVRBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIVRBase.getModelState() != null) {
            object = pSDEFIVRBase.getModelState();
            xmlNode.setAttribute(FIELD_MODELSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFIVRBase.getOrderValue() != null) {
            object = pSDEFIVRBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFIVRBase.getPSDEFIId() != null) {
            object = pSDEFIVRBase.getPSDEFIId();
            xmlNode.setAttribute(FIELD_PSDEFIID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIVRBase.getPSDEFIName() != null) {
            object = pSDEFIVRBase.getPSDEFIName();
            xmlNode.setAttribute(FIELD_PSDEFINAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIVRBase.getPSDEFIVRId() != null) {
            object = pSDEFIVRBase.getPSDEFIVRId();
            xmlNode.setAttribute(FIELD_PSDEFIVRID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIVRBase.getPSDEFIVRName() != null) {
            object = pSDEFIVRBase.getPSDEFIVRName();
            xmlNode.setAttribute(FIELD_PSDEFIVRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIVRBase.getPSDEFormId() != null) {
            object = pSDEFIVRBase.getPSDEFormId();
            xmlNode.setAttribute(FIELD_PSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIVRBase.getPSDEFormName() != null) {
            object = pSDEFIVRBase.getPSDEFormName();
            xmlNode.setAttribute(FIELD_PSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIVRBase.getPSDEFVRId() != null) {
            object = pSDEFIVRBase.getPSDEFVRId();
            xmlNode.setAttribute(FIELD_PSDEFVRID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIVRBase.getPSDEFVRName() != null) {
            object = pSDEFIVRBase.getPSDEFVRName();
            xmlNode.setAttribute(FIELD_PSDEFVRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIVRBase.getPSDynaInstId() != null) {
            object = pSDEFIVRBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIVRBase.getPSSysValueRuleId() != null) {
            object = pSDEFIVRBase.getPSSysValueRuleId();
            xmlNode.setAttribute(FIELD_PSSYSVALUERULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIVRBase.getPSSysValueRuleName() != null) {
            object = pSDEFIVRBase.getPSSysValueRuleName();
            xmlNode.setAttribute(FIELD_PSSYSVALUERULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIVRBase.getUpdateDate() != null) {
            object = pSDEFIVRBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFIVRBase.getUpdateMan() != null) {
            object = pSDEFIVRBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIVRBase.getUserCat() != null) {
            object = pSDEFIVRBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIVRBase.getUserTag() != null) {
            object = pSDEFIVRBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIVRBase.getUserTag2() != null) {
            object = pSDEFIVRBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIVRBase.getUserTag3() != null) {
            object = pSDEFIVRBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIVRBase.getUserTag4() != null) {
            object = pSDEFIVRBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEFIVRBase.getVRType() != null) {
            object = pSDEFIVRBase.getVRType();
            xmlNode.setAttribute(FIELD_VRTYPE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEFIVRBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEFIVRBase pSDEFIVRBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEFIVRBase.isCheckModeDirty() && (bl || pSDEFIVRBase.getCheckMode() != null)) {
            iDataObject.set(FIELD_CHECKMODE, (Object)pSDEFIVRBase.getCheckMode());
        }
        if (pSDEFIVRBase.isCreateDateDirty() && (bl || pSDEFIVRBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEFIVRBase.getCreateDate());
        }
        if (pSDEFIVRBase.isCreateManDirty() && (bl || pSDEFIVRBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEFIVRBase.getCreateMan());
        }
        if (pSDEFIVRBase.isDynaModelFlagDirty() && (bl || pSDEFIVRBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEFIVRBase.getDynaModelFlag());
        }
        if (pSDEFIVRBase.isMemoDirty() && (bl || pSDEFIVRBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEFIVRBase.getMemo());
        }
        if (pSDEFIVRBase.isModelStateDirty() && (bl || pSDEFIVRBase.getModelState() != null)) {
            iDataObject.set(FIELD_MODELSTATE, (Object)pSDEFIVRBase.getModelState());
        }
        if (pSDEFIVRBase.isOrderValueDirty() && (bl || pSDEFIVRBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEFIVRBase.getOrderValue());
        }
        if (pSDEFIVRBase.isPSDEFIIdDirty() && (bl || pSDEFIVRBase.getPSDEFIId() != null)) {
            iDataObject.set(FIELD_PSDEFIID, (Object)pSDEFIVRBase.getPSDEFIId());
        }
        if (pSDEFIVRBase.isPSDEFINameDirty() && (bl || pSDEFIVRBase.getPSDEFIName() != null)) {
            iDataObject.set(FIELD_PSDEFINAME, (Object)pSDEFIVRBase.getPSDEFIName());
        }
        if (pSDEFIVRBase.isPSDEFIVRIdDirty() && (bl || pSDEFIVRBase.getPSDEFIVRId() != null)) {
            iDataObject.set(FIELD_PSDEFIVRID, (Object)pSDEFIVRBase.getPSDEFIVRId());
        }
        if (pSDEFIVRBase.isPSDEFIVRNameDirty() && (bl || pSDEFIVRBase.getPSDEFIVRName() != null)) {
            iDataObject.set(FIELD_PSDEFIVRNAME, (Object)pSDEFIVRBase.getPSDEFIVRName());
        }
        if (pSDEFIVRBase.isPSDEFormIdDirty() && (bl || pSDEFIVRBase.getPSDEFormId() != null)) {
            iDataObject.set(FIELD_PSDEFORMID, (Object)pSDEFIVRBase.getPSDEFormId());
        }
        if (pSDEFIVRBase.isPSDEFormNameDirty() && (bl || pSDEFIVRBase.getPSDEFormName() != null)) {
            iDataObject.set(FIELD_PSDEFORMNAME, (Object)pSDEFIVRBase.getPSDEFormName());
        }
        if (pSDEFIVRBase.isPSDEFVRIdDirty() && (bl || pSDEFIVRBase.getPSDEFVRId() != null)) {
            iDataObject.set(FIELD_PSDEFVRID, (Object)pSDEFIVRBase.getPSDEFVRId());
        }
        if (pSDEFIVRBase.isPSDEFVRNameDirty() && (bl || pSDEFIVRBase.getPSDEFVRName() != null)) {
            iDataObject.set(FIELD_PSDEFVRNAME, (Object)pSDEFIVRBase.getPSDEFVRName());
        }
        if (pSDEFIVRBase.isPSDynaInstIdDirty() && (bl || pSDEFIVRBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEFIVRBase.getPSDynaInstId());
        }
        if (pSDEFIVRBase.isPSSysValueRuleIdDirty() && (bl || pSDEFIVRBase.getPSSysValueRuleId() != null)) {
            iDataObject.set(FIELD_PSSYSVALUERULEID, (Object)pSDEFIVRBase.getPSSysValueRuleId());
        }
        if (pSDEFIVRBase.isPSSysValueRuleNameDirty() && (bl || pSDEFIVRBase.getPSSysValueRuleName() != null)) {
            iDataObject.set(FIELD_PSSYSVALUERULENAME, (Object)pSDEFIVRBase.getPSSysValueRuleName());
        }
        if (pSDEFIVRBase.isUpdateDateDirty() && (bl || pSDEFIVRBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEFIVRBase.getUpdateDate());
        }
        if (pSDEFIVRBase.isUpdateManDirty() && (bl || pSDEFIVRBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEFIVRBase.getUpdateMan());
        }
        if (pSDEFIVRBase.isUserCatDirty() && (bl || pSDEFIVRBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEFIVRBase.getUserCat());
        }
        if (pSDEFIVRBase.isUserTagDirty() && (bl || pSDEFIVRBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEFIVRBase.getUserTag());
        }
        if (pSDEFIVRBase.isUserTag2Dirty() && (bl || pSDEFIVRBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEFIVRBase.getUserTag2());
        }
        if (pSDEFIVRBase.isUserTag3Dirty() && (bl || pSDEFIVRBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEFIVRBase.getUserTag3());
        }
        if (pSDEFIVRBase.isUserTag4Dirty() && (bl || pSDEFIVRBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEFIVRBase.getUserTag4());
        }
        if (pSDEFIVRBase.isVRTypeDirty() && (bl || pSDEFIVRBase.getVRType() != null)) {
            iDataObject.set(FIELD_VRTYPE, (Object)pSDEFIVRBase.getVRType());
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
        return PSDEFIVRBase.remove(this, n);
    }

    private static boolean remove(PSDEFIVRBase pSDEFIVRBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEFIVRBase.resetCheckMode();
                return true;
            }
            case 1: {
                pSDEFIVRBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDEFIVRBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDEFIVRBase.resetDynaModelFlag();
                return true;
            }
            case 4: {
                pSDEFIVRBase.resetMemo();
                return true;
            }
            case 5: {
                pSDEFIVRBase.resetModelState();
                return true;
            }
            case 6: {
                pSDEFIVRBase.resetOrderValue();
                return true;
            }
            case 7: {
                pSDEFIVRBase.resetPSDEFIId();
                return true;
            }
            case 8: {
                pSDEFIVRBase.resetPSDEFIName();
                return true;
            }
            case 9: {
                pSDEFIVRBase.resetPSDEFIVRId();
                return true;
            }
            case 10: {
                pSDEFIVRBase.resetPSDEFIVRName();
                return true;
            }
            case 11: {
                pSDEFIVRBase.resetPSDEFormId();
                return true;
            }
            case 12: {
                pSDEFIVRBase.resetPSDEFormName();
                return true;
            }
            case 13: {
                pSDEFIVRBase.resetPSDEFVRId();
                return true;
            }
            case 14: {
                pSDEFIVRBase.resetPSDEFVRName();
                return true;
            }
            case 15: {
                pSDEFIVRBase.resetPSDynaInstId();
                return true;
            }
            case 16: {
                pSDEFIVRBase.resetPSSysValueRuleId();
                return true;
            }
            case 17: {
                pSDEFIVRBase.resetPSSysValueRuleName();
                return true;
            }
            case 18: {
                pSDEFIVRBase.resetUpdateDate();
                return true;
            }
            case 19: {
                pSDEFIVRBase.resetUpdateMan();
                return true;
            }
            case 20: {
                pSDEFIVRBase.resetUserCat();
                return true;
            }
            case 21: {
                pSDEFIVRBase.resetUserTag();
                return true;
            }
            case 22: {
                pSDEFIVRBase.resetUserTag2();
                return true;
            }
            case 23: {
                pSDEFIVRBase.resetUserTag3();
                return true;
            }
            case 24: {
                pSDEFIVRBase.resetUserTag4();
                return true;
            }
            case 25: {
                pSDEFIVRBase.resetVRType();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFormDetail getPSDEFI() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFI();
        }
        if (this.getPSDEFIId() == null) {
            return null;
        }
        Integer n = this.objPSDEFILock;
        synchronized (n) {
            if (this.psdefi != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFIId(), (Object)this.psdefi.getPSDEFormDetailId()) != 0L) {
                this.psdefi = null;
            }
            if (this.psdefi == null) {
                PSDEFormDetail pSDEFormDetail = new PSDEFormDetail();
                pSDEFormDetail.setPSDEFormDetailId(this.getPSDEFIId());
                PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormDetailService.autoGet((IEntity)pSDEFormDetail);
                this.psdefi = pSDEFormDetail;
            }
            return this.psdefi;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEForm getPSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEForm();
        }
        if (this.getPSDEFormId() == null) {
            return null;
        }
        Integer n = this.objPSDEFormLock;
        synchronized (n) {
            if (this.psdeform != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFormId(), (Object)this.psdeform.getPSDEFormId()) != 0L) {
                this.psdeform = null;
            }
            if (this.psdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getPSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet((IEntity)pSDEForm);
                this.psdeform = pSDEForm;
            }
            return this.psdeform;
        }
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
                pSDEFValueRuleService.autoGet((IEntity)pSDEFValueRule);
                this.psdefvr = pSDEFValueRule;
            }
            return this.psdefvr;
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

    private PSDEFIVRBase getProxyEntity() {
        return this.proxyPSDEFIVRBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEFIVRBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEFIVRBase) {
            this.proxyPSDEFIVRBase = (PSDEFIVRBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFIVRService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CHECKMODE, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_MODELSTATE, 5);
        fieldIndexMap.put(FIELD_ORDERVALUE, 6);
        fieldIndexMap.put(FIELD_PSDEFIID, 7);
        fieldIndexMap.put(FIELD_PSDEFINAME, 8);
        fieldIndexMap.put(FIELD_PSDEFIVRID, 9);
        fieldIndexMap.put(FIELD_PSDEFIVRNAME, 10);
        fieldIndexMap.put(FIELD_PSDEFORMID, 11);
        fieldIndexMap.put(FIELD_PSDEFORMNAME, 12);
        fieldIndexMap.put(FIELD_PSDEFVRID, 13);
        fieldIndexMap.put(FIELD_PSDEFVRNAME, 14);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 15);
        fieldIndexMap.put(FIELD_PSSYSVALUERULEID, 16);
        fieldIndexMap.put(FIELD_PSSYSVALUERULENAME, 17);
        fieldIndexMap.put(FIELD_UPDATEDATE, 18);
        fieldIndexMap.put(FIELD_UPDATEMAN, 19);
        fieldIndexMap.put(FIELD_USERCAT, 20);
        fieldIndexMap.put(FIELD_USERTAG, 21);
        fieldIndexMap.put(FIELD_USERTAG2, 22);
        fieldIndexMap.put(FIELD_USERTAG3, 23);
        fieldIndexMap.put(FIELD_USERTAG4, 24);
        fieldIndexMap.put(FIELD_VRTYPE, 25);
    }
}

