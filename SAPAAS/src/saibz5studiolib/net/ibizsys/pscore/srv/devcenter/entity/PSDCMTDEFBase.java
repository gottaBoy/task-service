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
package net.ibizsys.pscore.srv.devcenter.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCModelTempl;
import net.ibizsys.pscore.srv.devcenter.service.PSDCModelTemplService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCMTDEFBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCMTDEFBase.class);
    public static final String FIELD_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFDATATYPE = "DEFDATATYPE";
    public static final String FIELD_LENGTH = "LENGTH";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MAJORFIELD = "MAJORFIELD";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PKEY = "PKEY";
    public static final String FIELD_PRECISION2 = "PRECISION2";
    public static final String FIELD_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String FIELD_PSDCMODELTEMPLID = "PSDCMODELTEMPLID";
    public static final String FIELD_PSDCMODELTEMPLNAME = "PSDCMODELTEMPLNAME";
    public static final String FIELD_PSDCMTDEFID = "PSDCMTDEFID";
    public static final String FIELD_PSDCMTDEFNAME = "PSDCMTDEFNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_ALLOWEMPTY = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_DEFDATATYPE = 4;
    private static final int INDEX_LENGTH = 5;
    private static final int INDEX_LOGICNAME = 6;
    private static final int INDEX_MAJORFIELD = 7;
    private static final int INDEX_MEMO = 8;
    private static final int INDEX_ORDERVALUE = 9;
    private static final int INDEX_PKEY = 10;
    private static final int INDEX_PRECISION2 = 11;
    private static final int INDEX_PREDEFINEDTYPE = 12;
    private static final int INDEX_PSDCMODELTEMPLID = 13;
    private static final int INDEX_PSDCMODELTEMPLNAME = 14;
    private static final int INDEX_PSDCMTDEFID = 15;
    private static final int INDEX_PSDCMTDEFNAME = 16;
    private static final int INDEX_UPDATEDATE = 17;
    private static final int INDEX_UPDATEMAN = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCMTDEFBase proxyPSDCMTDEFBase = null;
    private boolean allowemptyDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defdatatypeDirtyFlag = false;
    private boolean lengthDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean majorfieldDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pkeyDirtyFlag = false;
    private boolean precision2DirtyFlag = false;
    private boolean predefinedtypeDirtyFlag = false;
    private boolean psdcmodeltemplidDirtyFlag = false;
    private boolean psdcmodeltemplnameDirtyFlag = false;
    private boolean psdcmtdefidDirtyFlag = false;
    private boolean psdcmtdefnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="allowempty")
    private Integer allowempty;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defdatatype")
    private String defdatatype;
    @Column(name="length")
    private Integer length;
    @Column(name="logicname")
    private String logicname;
    @Column(name="majorfield")
    private Integer majorfield;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pkey")
    private Integer pkey;
    @Column(name="precision2")
    private Integer precision2;
    @Column(name="predefinedtype")
    private String predefinedtype;
    @Column(name="psdcmodeltemplid")
    private String psdcmodeltemplid;
    @Column(name="psdcmodeltemplname")
    private String psdcmodeltemplname;
    @Column(name="psdcmtdefid")
    private String psdcmtdefid;
    @Column(name="psdcmtdefname")
    private String psdcmtdefname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDCModelTemplLock = new Integer(1);
    private PSDCModelTempl psdcmodeltempl = null;

    public void setAllowEmpty(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllowEmpty(n);
            return;
        }
        this.allowempty = n;
        this.allowemptyDirtyFlag = true;
    }

    public Integer getAllowEmpty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllowEmpty();
        }
        return this.allowempty;
    }

    public boolean isAllowEmptyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllowEmptyDirty();
        }
        return this.allowemptyDirtyFlag;
    }

    public void resetAllowEmpty() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllowEmpty();
            return;
        }
        this.allowemptyDirtyFlag = false;
        this.allowempty = null;
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

    public void setDEFDataType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEFDataType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defdatatype = string;
        this.defdatatypeDirtyFlag = true;
    }

    public String getDEFDataType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEFDataType();
        }
        return this.defdatatype;
    }

    public boolean isDEFDataTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEFDataTypeDirty();
        }
        return this.defdatatypeDirtyFlag;
    }

    public void resetDEFDataType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEFDataType();
            return;
        }
        this.defdatatypeDirtyFlag = false;
        this.defdatatype = null;
    }

    public void setLength(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLength(n);
            return;
        }
        this.length = n;
        this.lengthDirtyFlag = true;
    }

    public Integer getLength() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLength();
        }
        return this.length;
    }

    public boolean isLengthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLengthDirty();
        }
        return this.lengthDirtyFlag;
    }

    public void resetLength() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLength();
            return;
        }
        this.lengthDirtyFlag = false;
        this.length = null;
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

    public void setMajorField(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorField(n);
            return;
        }
        this.majorfield = n;
        this.majorfieldDirtyFlag = true;
    }

    public Integer getMajorField() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorField();
        }
        return this.majorfield;
    }

    public boolean isMajorFieldDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorFieldDirty();
        }
        return this.majorfieldDirtyFlag;
    }

    public void resetMajorField() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorField();
            return;
        }
        this.majorfieldDirtyFlag = false;
        this.majorfield = null;
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

    public void setPKey(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPKey(n);
            return;
        }
        this.pkey = n;
        this.pkeyDirtyFlag = true;
    }

    public Integer getPKey() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPKey();
        }
        return this.pkey;
    }

    public boolean isPKeyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPKeyDirty();
        }
        return this.pkeyDirtyFlag;
    }

    public void resetPKey() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPKey();
            return;
        }
        this.pkeyDirtyFlag = false;
        this.pkey = null;
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

    public void setPreDefinedType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPreDefinedType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.predefinedtype = string;
        this.predefinedtypeDirtyFlag = true;
    }

    public String getPreDefinedType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPreDefinedType();
        }
        return this.predefinedtype;
    }

    public boolean isPreDefinedTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPreDefinedTypeDirty();
        }
        return this.predefinedtypeDirtyFlag;
    }

    public void resetPreDefinedType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPreDefinedType();
            return;
        }
        this.predefinedtypeDirtyFlag = false;
        this.predefinedtype = null;
    }

    public void setPSDCModelTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCModelTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmodeltemplid = string;
        this.psdcmodeltemplidDirtyFlag = true;
    }

    public String getPSDCModelTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCModelTemplId();
        }
        return this.psdcmodeltemplid;
    }

    public boolean isPSDCModelTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCModelTemplIdDirty();
        }
        return this.psdcmodeltemplidDirtyFlag;
    }

    public void resetPSDCModelTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCModelTemplId();
            return;
        }
        this.psdcmodeltemplidDirtyFlag = false;
        this.psdcmodeltemplid = null;
    }

    public void setPSDCModelTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCModelTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmodeltemplname = string;
        this.psdcmodeltemplnameDirtyFlag = true;
    }

    public String getPSDCModelTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCModelTemplName();
        }
        return this.psdcmodeltemplname;
    }

    public boolean isPSDCModelTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCModelTemplNameDirty();
        }
        return this.psdcmodeltemplnameDirtyFlag;
    }

    public void resetPSDCModelTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCModelTemplName();
            return;
        }
        this.psdcmodeltemplnameDirtyFlag = false;
        this.psdcmodeltemplname = null;
    }

    public void setPSDCMTDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMTDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmtdefid = string;
        this.psdcmtdefidDirtyFlag = true;
    }

    public String getPSDCMTDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMTDEFId();
        }
        return this.psdcmtdefid;
    }

    public boolean isPSDCMTDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMTDEFIdDirty();
        }
        return this.psdcmtdefidDirtyFlag;
    }

    public void resetPSDCMTDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMTDEFId();
            return;
        }
        this.psdcmtdefidDirtyFlag = false;
        this.psdcmtdefid = null;
    }

    public void setPSDCMTDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMTDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmtdefname = string;
        this.psdcmtdefnameDirtyFlag = true;
    }

    public String getPSDCMTDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMTDEFName();
        }
        return this.psdcmtdefname;
    }

    public boolean isPSDCMTDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMTDEFNameDirty();
        }
        return this.psdcmtdefnameDirtyFlag;
    }

    public void resetPSDCMTDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMTDEFName();
            return;
        }
        this.psdcmtdefnameDirtyFlag = false;
        this.psdcmtdefname = null;
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
        PSDCMTDEFBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCMTDEFBase pSDCMTDEFBase) {
        pSDCMTDEFBase.resetAllowEmpty();
        pSDCMTDEFBase.resetCodeName();
        pSDCMTDEFBase.resetCreateDate();
        pSDCMTDEFBase.resetCreateMan();
        pSDCMTDEFBase.resetDEFDataType();
        pSDCMTDEFBase.resetLength();
        pSDCMTDEFBase.resetLogicName();
        pSDCMTDEFBase.resetMajorField();
        pSDCMTDEFBase.resetMemo();
        pSDCMTDEFBase.resetOrderValue();
        pSDCMTDEFBase.resetPKey();
        pSDCMTDEFBase.resetPrecision2();
        pSDCMTDEFBase.resetPreDefinedType();
        pSDCMTDEFBase.resetPSDCModelTemplId();
        pSDCMTDEFBase.resetPSDCModelTemplName();
        pSDCMTDEFBase.resetPSDCMTDEFId();
        pSDCMTDEFBase.resetPSDCMTDEFName();
        pSDCMTDEFBase.resetUpdateDate();
        pSDCMTDEFBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllowEmptyDirty()) {
            hashMap.put(FIELD_ALLOWEMPTY, this.getAllowEmpty());
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
        if (!bl || this.isDEFDataTypeDirty()) {
            hashMap.put(FIELD_DEFDATATYPE, this.getDEFDataType());
        }
        if (!bl || this.isLengthDirty()) {
            hashMap.put(FIELD_LENGTH, this.getLength());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMajorFieldDirty()) {
            hashMap.put(FIELD_MAJORFIELD, this.getMajorField());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPKeyDirty()) {
            hashMap.put(FIELD_PKEY, this.getPKey());
        }
        if (!bl || this.isPrecision2Dirty()) {
            hashMap.put(FIELD_PRECISION2, this.getPrecision2());
        }
        if (!bl || this.isPreDefinedTypeDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPE, this.getPreDefinedType());
        }
        if (!bl || this.isPSDCModelTemplIdDirty()) {
            hashMap.put(FIELD_PSDCMODELTEMPLID, this.getPSDCModelTemplId());
        }
        if (!bl || this.isPSDCModelTemplNameDirty()) {
            hashMap.put(FIELD_PSDCMODELTEMPLNAME, this.getPSDCModelTemplName());
        }
        if (!bl || this.isPSDCMTDEFIdDirty()) {
            hashMap.put(FIELD_PSDCMTDEFID, this.getPSDCMTDEFId());
        }
        if (!bl || this.isPSDCMTDEFNameDirty()) {
            hashMap.put(FIELD_PSDCMTDEFNAME, this.getPSDCMTDEFName());
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
        return PSDCMTDEFBase.get(this, n);
    }

    private static Object get(PSDCMTDEFBase pSDCMTDEFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCMTDEFBase.getAllowEmpty();
            }
            case 1: {
                return pSDCMTDEFBase.getCodeName();
            }
            case 2: {
                return pSDCMTDEFBase.getCreateDate();
            }
            case 3: {
                return pSDCMTDEFBase.getCreateMan();
            }
            case 4: {
                return pSDCMTDEFBase.getDEFDataType();
            }
            case 5: {
                return pSDCMTDEFBase.getLength();
            }
            case 6: {
                return pSDCMTDEFBase.getLogicName();
            }
            case 7: {
                return pSDCMTDEFBase.getMajorField();
            }
            case 8: {
                return pSDCMTDEFBase.getMemo();
            }
            case 9: {
                return pSDCMTDEFBase.getOrderValue();
            }
            case 10: {
                return pSDCMTDEFBase.getPKey();
            }
            case 11: {
                return pSDCMTDEFBase.getPrecision2();
            }
            case 12: {
                return pSDCMTDEFBase.getPreDefinedType();
            }
            case 13: {
                return pSDCMTDEFBase.getPSDCModelTemplId();
            }
            case 14: {
                return pSDCMTDEFBase.getPSDCModelTemplName();
            }
            case 15: {
                return pSDCMTDEFBase.getPSDCMTDEFId();
            }
            case 16: {
                return pSDCMTDEFBase.getPSDCMTDEFName();
            }
            case 17: {
                return pSDCMTDEFBase.getUpdateDate();
            }
            case 18: {
                return pSDCMTDEFBase.getUpdateMan();
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
        PSDCMTDEFBase.set(this, n, object);
    }

    private static void set(PSDCMTDEFBase pSDCMTDEFBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCMTDEFBase.setAllowEmpty(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDCMTDEFBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCMTDEFBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDCMTDEFBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCMTDEFBase.setDEFDataType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCMTDEFBase.setLength(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDCMTDEFBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCMTDEFBase.setMajorField(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDCMTDEFBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCMTDEFBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDCMTDEFBase.setPKey(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDCMTDEFBase.setPrecision2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDCMTDEFBase.setPreDefinedType(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCMTDEFBase.setPSDCModelTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCMTDEFBase.setPSDCModelTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCMTDEFBase.setPSDCMTDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCMTDEFBase.setPSDCMTDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDCMTDEFBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSDCMTDEFBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCMTDEFBase.isNull(this, n);
    }

    private static boolean isNull(PSDCMTDEFBase pSDCMTDEFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCMTDEFBase.getAllowEmpty() == null;
            }
            case 1: {
                return pSDCMTDEFBase.getCodeName() == null;
            }
            case 2: {
                return pSDCMTDEFBase.getCreateDate() == null;
            }
            case 3: {
                return pSDCMTDEFBase.getCreateMan() == null;
            }
            case 4: {
                return pSDCMTDEFBase.getDEFDataType() == null;
            }
            case 5: {
                return pSDCMTDEFBase.getLength() == null;
            }
            case 6: {
                return pSDCMTDEFBase.getLogicName() == null;
            }
            case 7: {
                return pSDCMTDEFBase.getMajorField() == null;
            }
            case 8: {
                return pSDCMTDEFBase.getMemo() == null;
            }
            case 9: {
                return pSDCMTDEFBase.getOrderValue() == null;
            }
            case 10: {
                return pSDCMTDEFBase.getPKey() == null;
            }
            case 11: {
                return pSDCMTDEFBase.getPrecision2() == null;
            }
            case 12: {
                return pSDCMTDEFBase.getPreDefinedType() == null;
            }
            case 13: {
                return pSDCMTDEFBase.getPSDCModelTemplId() == null;
            }
            case 14: {
                return pSDCMTDEFBase.getPSDCModelTemplName() == null;
            }
            case 15: {
                return pSDCMTDEFBase.getPSDCMTDEFId() == null;
            }
            case 16: {
                return pSDCMTDEFBase.getPSDCMTDEFName() == null;
            }
            case 17: {
                return pSDCMTDEFBase.getUpdateDate() == null;
            }
            case 18: {
                return pSDCMTDEFBase.getUpdateMan() == null;
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
        return PSDCMTDEFBase.contains(this, n);
    }

    private static boolean contains(PSDCMTDEFBase pSDCMTDEFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCMTDEFBase.isAllowEmptyDirty();
            }
            case 1: {
                return pSDCMTDEFBase.isCodeNameDirty();
            }
            case 2: {
                return pSDCMTDEFBase.isCreateDateDirty();
            }
            case 3: {
                return pSDCMTDEFBase.isCreateManDirty();
            }
            case 4: {
                return pSDCMTDEFBase.isDEFDataTypeDirty();
            }
            case 5: {
                return pSDCMTDEFBase.isLengthDirty();
            }
            case 6: {
                return pSDCMTDEFBase.isLogicNameDirty();
            }
            case 7: {
                return pSDCMTDEFBase.isMajorFieldDirty();
            }
            case 8: {
                return pSDCMTDEFBase.isMemoDirty();
            }
            case 9: {
                return pSDCMTDEFBase.isOrderValueDirty();
            }
            case 10: {
                return pSDCMTDEFBase.isPKeyDirty();
            }
            case 11: {
                return pSDCMTDEFBase.isPrecision2Dirty();
            }
            case 12: {
                return pSDCMTDEFBase.isPreDefinedTypeDirty();
            }
            case 13: {
                return pSDCMTDEFBase.isPSDCModelTemplIdDirty();
            }
            case 14: {
                return pSDCMTDEFBase.isPSDCModelTemplNameDirty();
            }
            case 15: {
                return pSDCMTDEFBase.isPSDCMTDEFIdDirty();
            }
            case 16: {
                return pSDCMTDEFBase.isPSDCMTDEFNameDirty();
            }
            case 17: {
                return pSDCMTDEFBase.isUpdateDateDirty();
            }
            case 18: {
                return pSDCMTDEFBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCMTDEFBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCMTDEFBase pSDCMTDEFBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCMTDEFBase.getAllowEmpty() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"allowempty", (Object)PSDCMTDEFBase.getJSONValue((Object)pSDCMTDEFBase.getAllowEmpty()), (boolean)false);
        }
        if (bl || pSDCMTDEFBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDCMTDEFBase.getJSONValue((Object)pSDCMTDEFBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDCMTDEFBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCMTDEFBase.getJSONValue((Object)pSDCMTDEFBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCMTDEFBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCMTDEFBase.getJSONValue((Object)pSDCMTDEFBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCMTDEFBase.getDEFDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defdatatype", (Object)PSDCMTDEFBase.getJSONValue((Object)pSDCMTDEFBase.getDEFDataType()), (boolean)false);
        }
        if (bl || pSDCMTDEFBase.getLength() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"length", (Object)PSDCMTDEFBase.getJSONValue((Object)pSDCMTDEFBase.getLength()), (boolean)false);
        }
        if (bl || pSDCMTDEFBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDCMTDEFBase.getJSONValue((Object)pSDCMTDEFBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDCMTDEFBase.getMajorField() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"majorfield", (Object)PSDCMTDEFBase.getJSONValue((Object)pSDCMTDEFBase.getMajorField()), (boolean)false);
        }
        if (bl || pSDCMTDEFBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCMTDEFBase.getJSONValue((Object)pSDCMTDEFBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCMTDEFBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDCMTDEFBase.getJSONValue((Object)pSDCMTDEFBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDCMTDEFBase.getPKey() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pkey", (Object)PSDCMTDEFBase.getJSONValue((Object)pSDCMTDEFBase.getPKey()), (boolean)false);
        }
        if (bl || pSDCMTDEFBase.getPrecision2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"precision2", (Object)PSDCMTDEFBase.getJSONValue((Object)pSDCMTDEFBase.getPrecision2()), (boolean)false);
        }
        if (bl || pSDCMTDEFBase.getPreDefinedType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtype", (Object)PSDCMTDEFBase.getJSONValue((Object)pSDCMTDEFBase.getPreDefinedType()), (boolean)false);
        }
        if (bl || pSDCMTDEFBase.getPSDCModelTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmodeltemplid", (Object)PSDCMTDEFBase.getJSONValue((Object)pSDCMTDEFBase.getPSDCModelTemplId()), (boolean)false);
        }
        if (bl || pSDCMTDEFBase.getPSDCModelTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmodeltemplname", (Object)PSDCMTDEFBase.getJSONValue((Object)pSDCMTDEFBase.getPSDCModelTemplName()), (boolean)false);
        }
        if (bl || pSDCMTDEFBase.getPSDCMTDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmtdefid", (Object)PSDCMTDEFBase.getJSONValue((Object)pSDCMTDEFBase.getPSDCMTDEFId()), (boolean)false);
        }
        if (bl || pSDCMTDEFBase.getPSDCMTDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmtdefname", (Object)PSDCMTDEFBase.getJSONValue((Object)pSDCMTDEFBase.getPSDCMTDEFName()), (boolean)false);
        }
        if (bl || pSDCMTDEFBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCMTDEFBase.getJSONValue((Object)pSDCMTDEFBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCMTDEFBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCMTDEFBase.getJSONValue((Object)pSDCMTDEFBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCMTDEFBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCMTDEFBase pSDCMTDEFBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCMTDEFBase.getAllowEmpty() != null) {
            object = pSDCMTDEFBase.getAllowEmpty();
            xmlNode.setAttribute(FIELD_ALLOWEMPTY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMTDEFBase.getCodeName() != null) {
            object = pSDCMTDEFBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMTDEFBase.getCreateDate() != null) {
            object = pSDCMTDEFBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCMTDEFBase.getCreateMan() != null) {
            object = pSDCMTDEFBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCMTDEFBase.getDEFDataType() != null) {
            object = pSDCMTDEFBase.getDEFDataType();
            xmlNode.setAttribute(FIELD_DEFDATATYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCMTDEFBase.getLength() != null) {
            object = pSDCMTDEFBase.getLength();
            xmlNode.setAttribute(FIELD_LENGTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMTDEFBase.getLogicName() != null) {
            object = pSDCMTDEFBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMTDEFBase.getMajorField() != null) {
            object = pSDCMTDEFBase.getMajorField();
            xmlNode.setAttribute(FIELD_MAJORFIELD, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMTDEFBase.getMemo() != null) {
            object = pSDCMTDEFBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCMTDEFBase.getOrderValue() != null) {
            object = pSDCMTDEFBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMTDEFBase.getPKey() != null) {
            object = pSDCMTDEFBase.getPKey();
            xmlNode.setAttribute(FIELD_PKEY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMTDEFBase.getPrecision2() != null) {
            object = pSDCMTDEFBase.getPrecision2();
            xmlNode.setAttribute(FIELD_PRECISION2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMTDEFBase.getPreDefinedType() != null) {
            object = pSDCMTDEFBase.getPreDefinedType();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCMTDEFBase.getPSDCModelTemplId() != null) {
            object = pSDCMTDEFBase.getPSDCModelTemplId();
            xmlNode.setAttribute(FIELD_PSDCMODELTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMTDEFBase.getPSDCModelTemplName() != null) {
            object = pSDCMTDEFBase.getPSDCModelTemplName();
            xmlNode.setAttribute(FIELD_PSDCMODELTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMTDEFBase.getPSDCMTDEFId() != null) {
            object = pSDCMTDEFBase.getPSDCMTDEFId();
            xmlNode.setAttribute(FIELD_PSDCMTDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMTDEFBase.getPSDCMTDEFName() != null) {
            object = pSDCMTDEFBase.getPSDCMTDEFName();
            xmlNode.setAttribute(FIELD_PSDCMTDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMTDEFBase.getUpdateDate() != null) {
            object = pSDCMTDEFBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCMTDEFBase.getUpdateMan() != null) {
            object = pSDCMTDEFBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCMTDEFBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCMTDEFBase pSDCMTDEFBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCMTDEFBase.isAllowEmptyDirty() && (bl || pSDCMTDEFBase.getAllowEmpty() != null)) {
            iDataObject.set(FIELD_ALLOWEMPTY, (Object)pSDCMTDEFBase.getAllowEmpty());
        }
        if (pSDCMTDEFBase.isCodeNameDirty() && (bl || pSDCMTDEFBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDCMTDEFBase.getCodeName());
        }
        if (pSDCMTDEFBase.isCreateDateDirty() && (bl || pSDCMTDEFBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCMTDEFBase.getCreateDate());
        }
        if (pSDCMTDEFBase.isCreateManDirty() && (bl || pSDCMTDEFBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCMTDEFBase.getCreateMan());
        }
        if (pSDCMTDEFBase.isDEFDataTypeDirty() && (bl || pSDCMTDEFBase.getDEFDataType() != null)) {
            iDataObject.set(FIELD_DEFDATATYPE, (Object)pSDCMTDEFBase.getDEFDataType());
        }
        if (pSDCMTDEFBase.isLengthDirty() && (bl || pSDCMTDEFBase.getLength() != null)) {
            iDataObject.set(FIELD_LENGTH, (Object)pSDCMTDEFBase.getLength());
        }
        if (pSDCMTDEFBase.isLogicNameDirty() && (bl || pSDCMTDEFBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDCMTDEFBase.getLogicName());
        }
        if (pSDCMTDEFBase.isMajorFieldDirty() && (bl || pSDCMTDEFBase.getMajorField() != null)) {
            iDataObject.set(FIELD_MAJORFIELD, (Object)pSDCMTDEFBase.getMajorField());
        }
        if (pSDCMTDEFBase.isMemoDirty() && (bl || pSDCMTDEFBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCMTDEFBase.getMemo());
        }
        if (pSDCMTDEFBase.isOrderValueDirty() && (bl || pSDCMTDEFBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDCMTDEFBase.getOrderValue());
        }
        if (pSDCMTDEFBase.isPKeyDirty() && (bl || pSDCMTDEFBase.getPKey() != null)) {
            iDataObject.set(FIELD_PKEY, (Object)pSDCMTDEFBase.getPKey());
        }
        if (pSDCMTDEFBase.isPrecision2Dirty() && (bl || pSDCMTDEFBase.getPrecision2() != null)) {
            iDataObject.set(FIELD_PRECISION2, (Object)pSDCMTDEFBase.getPrecision2());
        }
        if (pSDCMTDEFBase.isPreDefinedTypeDirty() && (bl || pSDCMTDEFBase.getPreDefinedType() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPE, (Object)pSDCMTDEFBase.getPreDefinedType());
        }
        if (pSDCMTDEFBase.isPSDCModelTemplIdDirty() && (bl || pSDCMTDEFBase.getPSDCModelTemplId() != null)) {
            iDataObject.set(FIELD_PSDCMODELTEMPLID, (Object)pSDCMTDEFBase.getPSDCModelTemplId());
        }
        if (pSDCMTDEFBase.isPSDCModelTemplNameDirty() && (bl || pSDCMTDEFBase.getPSDCModelTemplName() != null)) {
            iDataObject.set(FIELD_PSDCMODELTEMPLNAME, (Object)pSDCMTDEFBase.getPSDCModelTemplName());
        }
        if (pSDCMTDEFBase.isPSDCMTDEFIdDirty() && (bl || pSDCMTDEFBase.getPSDCMTDEFId() != null)) {
            iDataObject.set(FIELD_PSDCMTDEFID, (Object)pSDCMTDEFBase.getPSDCMTDEFId());
        }
        if (pSDCMTDEFBase.isPSDCMTDEFNameDirty() && (bl || pSDCMTDEFBase.getPSDCMTDEFName() != null)) {
            iDataObject.set(FIELD_PSDCMTDEFNAME, (Object)pSDCMTDEFBase.getPSDCMTDEFName());
        }
        if (pSDCMTDEFBase.isUpdateDateDirty() && (bl || pSDCMTDEFBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCMTDEFBase.getUpdateDate());
        }
        if (pSDCMTDEFBase.isUpdateManDirty() && (bl || pSDCMTDEFBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCMTDEFBase.getUpdateMan());
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
        return PSDCMTDEFBase.remove(this, n);
    }

    private static boolean remove(PSDCMTDEFBase pSDCMTDEFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCMTDEFBase.resetAllowEmpty();
                return true;
            }
            case 1: {
                pSDCMTDEFBase.resetCodeName();
                return true;
            }
            case 2: {
                pSDCMTDEFBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDCMTDEFBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDCMTDEFBase.resetDEFDataType();
                return true;
            }
            case 5: {
                pSDCMTDEFBase.resetLength();
                return true;
            }
            case 6: {
                pSDCMTDEFBase.resetLogicName();
                return true;
            }
            case 7: {
                pSDCMTDEFBase.resetMajorField();
                return true;
            }
            case 8: {
                pSDCMTDEFBase.resetMemo();
                return true;
            }
            case 9: {
                pSDCMTDEFBase.resetOrderValue();
                return true;
            }
            case 10: {
                pSDCMTDEFBase.resetPKey();
                return true;
            }
            case 11: {
                pSDCMTDEFBase.resetPrecision2();
                return true;
            }
            case 12: {
                pSDCMTDEFBase.resetPreDefinedType();
                return true;
            }
            case 13: {
                pSDCMTDEFBase.resetPSDCModelTemplId();
                return true;
            }
            case 14: {
                pSDCMTDEFBase.resetPSDCModelTemplName();
                return true;
            }
            case 15: {
                pSDCMTDEFBase.resetPSDCMTDEFId();
                return true;
            }
            case 16: {
                pSDCMTDEFBase.resetPSDCMTDEFName();
                return true;
            }
            case 17: {
                pSDCMTDEFBase.resetUpdateDate();
                return true;
            }
            case 18: {
                pSDCMTDEFBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCModelTempl getPSDCModelTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCModelTempl();
        }
        if (this.getPSDCModelTemplId() == null) {
            return null;
        }
        Integer n = this.objPSDCModelTemplLock;
        synchronized (n) {
            if (this.psdcmodeltempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCModelTemplId(), (Object)this.psdcmodeltempl.getPSDCModelTemplId()) != 0L) {
                this.psdcmodeltempl = null;
            }
            if (this.psdcmodeltempl == null) {
                PSDCModelTempl pSDCModelTempl = new PSDCModelTempl();
                pSDCModelTempl.setPSDCModelTemplId(this.getPSDCModelTemplId());
                PSDCModelTemplService pSDCModelTemplService = (PSDCModelTemplService)ServiceGlobal.getService(PSDCModelTemplService.class, (SessionFactory)this.getSessionFactory());
                pSDCModelTemplService.autoGet((IEntity)pSDCModelTempl);
                this.psdcmodeltempl = pSDCModelTempl;
            }
            return this.psdcmodeltempl;
        }
    }

    private PSDCMTDEFBase getProxyEntity() {
        return this.proxyPSDCMTDEFBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCMTDEFBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCMTDEFBase) {
            this.proxyPSDCMTDEFBase = (PSDCMTDEFBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCMTDEFService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLOWEMPTY, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_DEFDATATYPE, 4);
        fieldIndexMap.put(FIELD_LENGTH, 5);
        fieldIndexMap.put(FIELD_LOGICNAME, 6);
        fieldIndexMap.put(FIELD_MAJORFIELD, 7);
        fieldIndexMap.put(FIELD_MEMO, 8);
        fieldIndexMap.put(FIELD_ORDERVALUE, 9);
        fieldIndexMap.put(FIELD_PKEY, 10);
        fieldIndexMap.put(FIELD_PRECISION2, 11);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPE, 12);
        fieldIndexMap.put(FIELD_PSDCMODELTEMPLID, 13);
        fieldIndexMap.put(FIELD_PSDCMODELTEMPLNAME, 14);
        fieldIndexMap.put(FIELD_PSDCMTDEFID, 15);
        fieldIndexMap.put(FIELD_PSDCMTDEFNAME, 16);
        fieldIndexMap.put(FIELD_UPDATEDATE, 17);
        fieldIndexMap.put(FIELD_UPDATEMAN, 18);
    }
}

