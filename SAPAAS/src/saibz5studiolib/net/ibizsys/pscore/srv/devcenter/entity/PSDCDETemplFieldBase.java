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
import net.ibizsys.pscore.srv.config.entity.PSDEFDataType;
import net.ibizsys.pscore.srv.config.service.PSDEFDataTypeService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDETempl;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDETemplService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCDETemplFieldBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCDETemplFieldBase.class);
    public static final String FIELD_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFTYPE = "DEFTYPE";
    public static final String FIELD_LENGTH = "LENGTH";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PRECISION2 = "PRECISION2";
    public static final String FIELD_PREDEFINETYPE = "PREDEFINETYPE";
    public static final String FIELD_PSDATATYPEID = "PSDATATYPEID";
    public static final String FIELD_PSDATATYPENAME = "PSDATATYPENAME";
    public static final String FIELD_PSDCDETEMPLFIELDID = "PSDCDETEMPLFIELDID";
    public static final String FIELD_PSDCDETEMPLFIELDNAME = "PSDCDETEMPLFIELDNAME";
    public static final String FIELD_PSDCDETEMPLID = "PSDCDETEMPLID";
    public static final String FIELD_PSDCDETEMPLNAME = "PSDCDETEMPLNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ALLOWEMPTY = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_DEFTYPE = 4;
    private static final int INDEX_LENGTH = 5;
    private static final int INDEX_LOGICNAME = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_PRECISION2 = 8;
    private static final int INDEX_PREDEFINETYPE = 9;
    private static final int INDEX_PSDATATYPEID = 10;
    private static final int INDEX_PSDATATYPENAME = 11;
    private static final int INDEX_PSDCDETEMPLFIELDID = 12;
    private static final int INDEX_PSDCDETEMPLFIELDNAME = 13;
    private static final int INDEX_PSDCDETEMPLID = 14;
    private static final int INDEX_PSDCDETEMPLNAME = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_VALIDFLAG = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCDETemplFieldBase proxyPSDCDETemplFieldBase = null;
    private boolean allowemptyDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean deftypeDirtyFlag = false;
    private boolean lengthDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean precision2DirtyFlag = false;
    private boolean predefinetypeDirtyFlag = false;
    private boolean psdatatypeidDirtyFlag = false;
    private boolean psdatatypenameDirtyFlag = false;
    private boolean psdcdetemplfieldidDirtyFlag = false;
    private boolean psdcdetemplfieldnameDirtyFlag = false;
    private boolean psdcdetemplidDirtyFlag = false;
    private boolean psdcdetemplnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="allowempty")
    private Integer allowempty;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="deftype")
    private Integer deftype;
    @Column(name="length")
    private Integer length;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="precision2")
    private Integer precision2;
    @Column(name="predefinetype")
    private String predefinetype;
    @Column(name="psdatatypeid")
    private String psdatatypeid;
    @Column(name="psdatatypename")
    private String psdatatypename;
    @Column(name="psdcdetemplfieldid")
    private String psdcdetemplfieldid;
    @Column(name="psdcdetemplfieldname")
    private String psdcdetemplfieldname;
    @Column(name="psdcdetemplid")
    private String psdcdetemplid;
    @Column(name="psdcdetemplname")
    private String psdcdetemplname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDCDETemplLock = new Integer(1);
    private PSDCDETempl psdcdetempl = null;
    private Integer objPSDataTypeLock = new Integer(1);
    private PSDEFDataType psdatatype = null;

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

    public void setDEFType(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEFType(n);
            return;
        }
        this.deftype = n;
        this.deftypeDirtyFlag = true;
    }

    public Integer getDEFType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEFType();
        }
        return this.deftype;
    }

    public boolean isDEFTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEFTypeDirty();
        }
        return this.deftypeDirtyFlag;
    }

    public void resetDEFType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEFType();
            return;
        }
        this.deftypeDirtyFlag = false;
        this.deftype = null;
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

    public void setPreDefineType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPreDefineType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.predefinetype = string;
        this.predefinetypeDirtyFlag = true;
    }

    public String getPreDefineType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPreDefineType();
        }
        return this.predefinetype;
    }

    public boolean isPreDefineTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPreDefineTypeDirty();
        }
        return this.predefinetypeDirtyFlag;
    }

    public void resetPreDefineType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPreDefineType();
            return;
        }
        this.predefinetypeDirtyFlag = false;
        this.predefinetype = null;
    }

    public void setPSDataTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDataTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdatatypeid = string;
        this.psdatatypeidDirtyFlag = true;
    }

    public String getPSDataTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDataTypeId();
        }
        return this.psdatatypeid;
    }

    public boolean isPSDataTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDataTypeIdDirty();
        }
        return this.psdatatypeidDirtyFlag;
    }

    public void resetPSDataTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDataTypeId();
            return;
        }
        this.psdatatypeidDirtyFlag = false;
        this.psdatatypeid = null;
    }

    public void setPSDataTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDataTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdatatypename = string;
        this.psdatatypenameDirtyFlag = true;
    }

    public String getPSDataTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDataTypeName();
        }
        return this.psdatatypename;
    }

    public boolean isPSDataTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDataTypeNameDirty();
        }
        return this.psdatatypenameDirtyFlag;
    }

    public void resetPSDataTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDataTypeName();
            return;
        }
        this.psdatatypenameDirtyFlag = false;
        this.psdatatypename = null;
    }

    public void setPSDCDETemplFieldId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDETemplFieldId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdetemplfieldid = string;
        this.psdcdetemplfieldidDirtyFlag = true;
    }

    public String getPSDCDETemplFieldId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDETemplFieldId();
        }
        return this.psdcdetemplfieldid;
    }

    public boolean isPSDCDETemplFieldIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDETemplFieldIdDirty();
        }
        return this.psdcdetemplfieldidDirtyFlag;
    }

    public void resetPSDCDETemplFieldId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDETemplFieldId();
            return;
        }
        this.psdcdetemplfieldidDirtyFlag = false;
        this.psdcdetemplfieldid = null;
    }

    public void setPSDCDETemplFieldName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDETemplFieldName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdetemplfieldname = string;
        this.psdcdetemplfieldnameDirtyFlag = true;
    }

    public String getPSDCDETemplFieldName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDETemplFieldName();
        }
        return this.psdcdetemplfieldname;
    }

    public boolean isPSDCDETemplFieldNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDETemplFieldNameDirty();
        }
        return this.psdcdetemplfieldnameDirtyFlag;
    }

    public void resetPSDCDETemplFieldName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDETemplFieldName();
            return;
        }
        this.psdcdetemplfieldnameDirtyFlag = false;
        this.psdcdetemplfieldname = null;
    }

    public void setPSDCDETemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDETemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdetemplid = string;
        this.psdcdetemplidDirtyFlag = true;
    }

    public String getPSDCDETemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDETemplId();
        }
        return this.psdcdetemplid;
    }

    public boolean isPSDCDETemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDETemplIdDirty();
        }
        return this.psdcdetemplidDirtyFlag;
    }

    public void resetPSDCDETemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDETemplId();
            return;
        }
        this.psdcdetemplidDirtyFlag = false;
        this.psdcdetemplid = null;
    }

    public void setPSDCDETemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDETemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdetemplname = string;
        this.psdcdetemplnameDirtyFlag = true;
    }

    public String getPSDCDETemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDETemplName();
        }
        return this.psdcdetemplname;
    }

    public boolean isPSDCDETemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDETemplNameDirty();
        }
        return this.psdcdetemplnameDirtyFlag;
    }

    public void resetPSDCDETemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDETemplName();
            return;
        }
        this.psdcdetemplnameDirtyFlag = false;
        this.psdcdetemplname = null;
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
        PSDCDETemplFieldBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCDETemplFieldBase pSDCDETemplFieldBase) {
        pSDCDETemplFieldBase.resetAllowEmpty();
        pSDCDETemplFieldBase.resetCodeName();
        pSDCDETemplFieldBase.resetCreateDate();
        pSDCDETemplFieldBase.resetCreateMan();
        pSDCDETemplFieldBase.resetDEFType();
        pSDCDETemplFieldBase.resetLength();
        pSDCDETemplFieldBase.resetLogicName();
        pSDCDETemplFieldBase.resetMemo();
        pSDCDETemplFieldBase.resetPrecision2();
        pSDCDETemplFieldBase.resetPreDefineType();
        pSDCDETemplFieldBase.resetPSDataTypeId();
        pSDCDETemplFieldBase.resetPSDataTypeName();
        pSDCDETemplFieldBase.resetPSDCDETemplFieldId();
        pSDCDETemplFieldBase.resetPSDCDETemplFieldName();
        pSDCDETemplFieldBase.resetPSDCDETemplId();
        pSDCDETemplFieldBase.resetPSDCDETemplName();
        pSDCDETemplFieldBase.resetUpdateDate();
        pSDCDETemplFieldBase.resetUpdateMan();
        pSDCDETemplFieldBase.resetValidFlag();
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
        if (!bl || this.isDEFTypeDirty()) {
            hashMap.put(FIELD_DEFTYPE, this.getDEFType());
        }
        if (!bl || this.isLengthDirty()) {
            hashMap.put(FIELD_LENGTH, this.getLength());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPrecision2Dirty()) {
            hashMap.put(FIELD_PRECISION2, this.getPrecision2());
        }
        if (!bl || this.isPreDefineTypeDirty()) {
            hashMap.put(FIELD_PREDEFINETYPE, this.getPreDefineType());
        }
        if (!bl || this.isPSDataTypeIdDirty()) {
            hashMap.put(FIELD_PSDATATYPEID, this.getPSDataTypeId());
        }
        if (!bl || this.isPSDataTypeNameDirty()) {
            hashMap.put(FIELD_PSDATATYPENAME, this.getPSDataTypeName());
        }
        if (!bl || this.isPSDCDETemplFieldIdDirty()) {
            hashMap.put(FIELD_PSDCDETEMPLFIELDID, this.getPSDCDETemplFieldId());
        }
        if (!bl || this.isPSDCDETemplFieldNameDirty()) {
            hashMap.put(FIELD_PSDCDETEMPLFIELDNAME, this.getPSDCDETemplFieldName());
        }
        if (!bl || this.isPSDCDETemplIdDirty()) {
            hashMap.put(FIELD_PSDCDETEMPLID, this.getPSDCDETemplId());
        }
        if (!bl || this.isPSDCDETemplNameDirty()) {
            hashMap.put(FIELD_PSDCDETEMPLNAME, this.getPSDCDETemplName());
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
        return PSDCDETemplFieldBase.get(this, n);
    }

    private static Object get(PSDCDETemplFieldBase pSDCDETemplFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDETemplFieldBase.getAllowEmpty();
            }
            case 1: {
                return pSDCDETemplFieldBase.getCodeName();
            }
            case 2: {
                return pSDCDETemplFieldBase.getCreateDate();
            }
            case 3: {
                return pSDCDETemplFieldBase.getCreateMan();
            }
            case 4: {
                return pSDCDETemplFieldBase.getDEFType();
            }
            case 5: {
                return pSDCDETemplFieldBase.getLength();
            }
            case 6: {
                return pSDCDETemplFieldBase.getLogicName();
            }
            case 7: {
                return pSDCDETemplFieldBase.getMemo();
            }
            case 8: {
                return pSDCDETemplFieldBase.getPrecision2();
            }
            case 9: {
                return pSDCDETemplFieldBase.getPreDefineType();
            }
            case 10: {
                return pSDCDETemplFieldBase.getPSDataTypeId();
            }
            case 11: {
                return pSDCDETemplFieldBase.getPSDataTypeName();
            }
            case 12: {
                return pSDCDETemplFieldBase.getPSDCDETemplFieldId();
            }
            case 13: {
                return pSDCDETemplFieldBase.getPSDCDETemplFieldName();
            }
            case 14: {
                return pSDCDETemplFieldBase.getPSDCDETemplId();
            }
            case 15: {
                return pSDCDETemplFieldBase.getPSDCDETemplName();
            }
            case 16: {
                return pSDCDETemplFieldBase.getUpdateDate();
            }
            case 17: {
                return pSDCDETemplFieldBase.getUpdateMan();
            }
            case 18: {
                return pSDCDETemplFieldBase.getValidFlag();
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
        PSDCDETemplFieldBase.set(this, n, object);
    }

    private static void set(PSDCDETemplFieldBase pSDCDETemplFieldBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCDETemplFieldBase.setAllowEmpty(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDCDETemplFieldBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCDETemplFieldBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDCDETemplFieldBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCDETemplFieldBase.setDEFType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDCDETemplFieldBase.setLength(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDCDETemplFieldBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCDETemplFieldBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCDETemplFieldBase.setPrecision2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDCDETemplFieldBase.setPreDefineType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCDETemplFieldBase.setPSDataTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCDETemplFieldBase.setPSDataTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCDETemplFieldBase.setPSDCDETemplFieldId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCDETemplFieldBase.setPSDCDETemplFieldName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCDETemplFieldBase.setPSDCDETemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCDETemplFieldBase.setPSDCDETemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCDETemplFieldBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSDCDETemplFieldBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDCDETemplFieldBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDCDETemplFieldBase.isNull(this, n);
    }

    private static boolean isNull(PSDCDETemplFieldBase pSDCDETemplFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDETemplFieldBase.getAllowEmpty() == null;
            }
            case 1: {
                return pSDCDETemplFieldBase.getCodeName() == null;
            }
            case 2: {
                return pSDCDETemplFieldBase.getCreateDate() == null;
            }
            case 3: {
                return pSDCDETemplFieldBase.getCreateMan() == null;
            }
            case 4: {
                return pSDCDETemplFieldBase.getDEFType() == null;
            }
            case 5: {
                return pSDCDETemplFieldBase.getLength() == null;
            }
            case 6: {
                return pSDCDETemplFieldBase.getLogicName() == null;
            }
            case 7: {
                return pSDCDETemplFieldBase.getMemo() == null;
            }
            case 8: {
                return pSDCDETemplFieldBase.getPrecision2() == null;
            }
            case 9: {
                return pSDCDETemplFieldBase.getPreDefineType() == null;
            }
            case 10: {
                return pSDCDETemplFieldBase.getPSDataTypeId() == null;
            }
            case 11: {
                return pSDCDETemplFieldBase.getPSDataTypeName() == null;
            }
            case 12: {
                return pSDCDETemplFieldBase.getPSDCDETemplFieldId() == null;
            }
            case 13: {
                return pSDCDETemplFieldBase.getPSDCDETemplFieldName() == null;
            }
            case 14: {
                return pSDCDETemplFieldBase.getPSDCDETemplId() == null;
            }
            case 15: {
                return pSDCDETemplFieldBase.getPSDCDETemplName() == null;
            }
            case 16: {
                return pSDCDETemplFieldBase.getUpdateDate() == null;
            }
            case 17: {
                return pSDCDETemplFieldBase.getUpdateMan() == null;
            }
            case 18: {
                return pSDCDETemplFieldBase.getValidFlag() == null;
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
        return PSDCDETemplFieldBase.contains(this, n);
    }

    private static boolean contains(PSDCDETemplFieldBase pSDCDETemplFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDETemplFieldBase.isAllowEmptyDirty();
            }
            case 1: {
                return pSDCDETemplFieldBase.isCodeNameDirty();
            }
            case 2: {
                return pSDCDETemplFieldBase.isCreateDateDirty();
            }
            case 3: {
                return pSDCDETemplFieldBase.isCreateManDirty();
            }
            case 4: {
                return pSDCDETemplFieldBase.isDEFTypeDirty();
            }
            case 5: {
                return pSDCDETemplFieldBase.isLengthDirty();
            }
            case 6: {
                return pSDCDETemplFieldBase.isLogicNameDirty();
            }
            case 7: {
                return pSDCDETemplFieldBase.isMemoDirty();
            }
            case 8: {
                return pSDCDETemplFieldBase.isPrecision2Dirty();
            }
            case 9: {
                return pSDCDETemplFieldBase.isPreDefineTypeDirty();
            }
            case 10: {
                return pSDCDETemplFieldBase.isPSDataTypeIdDirty();
            }
            case 11: {
                return pSDCDETemplFieldBase.isPSDataTypeNameDirty();
            }
            case 12: {
                return pSDCDETemplFieldBase.isPSDCDETemplFieldIdDirty();
            }
            case 13: {
                return pSDCDETemplFieldBase.isPSDCDETemplFieldNameDirty();
            }
            case 14: {
                return pSDCDETemplFieldBase.isPSDCDETemplIdDirty();
            }
            case 15: {
                return pSDCDETemplFieldBase.isPSDCDETemplNameDirty();
            }
            case 16: {
                return pSDCDETemplFieldBase.isUpdateDateDirty();
            }
            case 17: {
                return pSDCDETemplFieldBase.isUpdateManDirty();
            }
            case 18: {
                return pSDCDETemplFieldBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCDETemplFieldBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCDETemplFieldBase pSDCDETemplFieldBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCDETemplFieldBase.getAllowEmpty() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"allowempty", (Object)PSDCDETemplFieldBase.getJSONValue((Object)pSDCDETemplFieldBase.getAllowEmpty()), (boolean)false);
        }
        if (bl || pSDCDETemplFieldBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDCDETemplFieldBase.getJSONValue((Object)pSDCDETemplFieldBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDCDETemplFieldBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCDETemplFieldBase.getJSONValue((Object)pSDCDETemplFieldBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCDETemplFieldBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCDETemplFieldBase.getJSONValue((Object)pSDCDETemplFieldBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCDETemplFieldBase.getDEFType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deftype", (Object)PSDCDETemplFieldBase.getJSONValue((Object)pSDCDETemplFieldBase.getDEFType()), (boolean)false);
        }
        if (bl || pSDCDETemplFieldBase.getLength() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"length", (Object)PSDCDETemplFieldBase.getJSONValue((Object)pSDCDETemplFieldBase.getLength()), (boolean)false);
        }
        if (bl || pSDCDETemplFieldBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDCDETemplFieldBase.getJSONValue((Object)pSDCDETemplFieldBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDCDETemplFieldBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCDETemplFieldBase.getJSONValue((Object)pSDCDETemplFieldBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCDETemplFieldBase.getPrecision2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"precision2", (Object)PSDCDETemplFieldBase.getJSONValue((Object)pSDCDETemplFieldBase.getPrecision2()), (boolean)false);
        }
        if (bl || pSDCDETemplFieldBase.getPreDefineType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinetype", (Object)PSDCDETemplFieldBase.getJSONValue((Object)pSDCDETemplFieldBase.getPreDefineType()), (boolean)false);
        }
        if (bl || pSDCDETemplFieldBase.getPSDataTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdatatypeid", (Object)PSDCDETemplFieldBase.getJSONValue((Object)pSDCDETemplFieldBase.getPSDataTypeId()), (boolean)false);
        }
        if (bl || pSDCDETemplFieldBase.getPSDataTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdatatypename", (Object)PSDCDETemplFieldBase.getJSONValue((Object)pSDCDETemplFieldBase.getPSDataTypeName()), (boolean)false);
        }
        if (bl || pSDCDETemplFieldBase.getPSDCDETemplFieldId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdetemplfieldid", (Object)PSDCDETemplFieldBase.getJSONValue((Object)pSDCDETemplFieldBase.getPSDCDETemplFieldId()), (boolean)false);
        }
        if (bl || pSDCDETemplFieldBase.getPSDCDETemplFieldName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdetemplfieldname", (Object)PSDCDETemplFieldBase.getJSONValue((Object)pSDCDETemplFieldBase.getPSDCDETemplFieldName()), (boolean)false);
        }
        if (bl || pSDCDETemplFieldBase.getPSDCDETemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdetemplid", (Object)PSDCDETemplFieldBase.getJSONValue((Object)pSDCDETemplFieldBase.getPSDCDETemplId()), (boolean)false);
        }
        if (bl || pSDCDETemplFieldBase.getPSDCDETemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdetemplname", (Object)PSDCDETemplFieldBase.getJSONValue((Object)pSDCDETemplFieldBase.getPSDCDETemplName()), (boolean)false);
        }
        if (bl || pSDCDETemplFieldBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCDETemplFieldBase.getJSONValue((Object)pSDCDETemplFieldBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCDETemplFieldBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCDETemplFieldBase.getJSONValue((Object)pSDCDETemplFieldBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCDETemplFieldBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDCDETemplFieldBase.getJSONValue((Object)pSDCDETemplFieldBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCDETemplFieldBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCDETemplFieldBase pSDCDETemplFieldBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCDETemplFieldBase.getAllowEmpty() != null) {
            object = pSDCDETemplFieldBase.getAllowEmpty();
            xmlNode.setAttribute(FIELD_ALLOWEMPTY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCDETemplFieldBase.getCodeName() != null) {
            object = pSDCDETemplFieldBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDETemplFieldBase.getCreateDate() != null) {
            object = pSDCDETemplFieldBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCDETemplFieldBase.getCreateMan() != null) {
            object = pSDCDETemplFieldBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCDETemplFieldBase.getDEFType() != null) {
            object = pSDCDETemplFieldBase.getDEFType();
            xmlNode.setAttribute(FIELD_DEFTYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCDETemplFieldBase.getLength() != null) {
            object = pSDCDETemplFieldBase.getLength();
            xmlNode.setAttribute(FIELD_LENGTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCDETemplFieldBase.getLogicName() != null) {
            object = pSDCDETemplFieldBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDETemplFieldBase.getMemo() != null) {
            object = pSDCDETemplFieldBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCDETemplFieldBase.getPrecision2() != null) {
            object = pSDCDETemplFieldBase.getPrecision2();
            xmlNode.setAttribute(FIELD_PRECISION2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCDETemplFieldBase.getPreDefineType() != null) {
            object = pSDCDETemplFieldBase.getPreDefineType();
            xmlNode.setAttribute(FIELD_PREDEFINETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCDETemplFieldBase.getPSDataTypeId() != null) {
            object = pSDCDETemplFieldBase.getPSDataTypeId();
            xmlNode.setAttribute(FIELD_PSDATATYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDETemplFieldBase.getPSDataTypeName() != null) {
            object = pSDCDETemplFieldBase.getPSDataTypeName();
            xmlNode.setAttribute(FIELD_PSDATATYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDETemplFieldBase.getPSDCDETemplFieldId() != null) {
            object = pSDCDETemplFieldBase.getPSDCDETemplFieldId();
            xmlNode.setAttribute(FIELD_PSDCDETEMPLFIELDID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDETemplFieldBase.getPSDCDETemplFieldName() != null) {
            object = pSDCDETemplFieldBase.getPSDCDETemplFieldName();
            xmlNode.setAttribute(FIELD_PSDCDETEMPLFIELDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDETemplFieldBase.getPSDCDETemplId() != null) {
            object = pSDCDETemplFieldBase.getPSDCDETemplId();
            xmlNode.setAttribute(FIELD_PSDCDETEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDETemplFieldBase.getPSDCDETemplName() != null) {
            object = pSDCDETemplFieldBase.getPSDCDETemplName();
            xmlNode.setAttribute(FIELD_PSDCDETEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDETemplFieldBase.getUpdateDate() != null) {
            object = pSDCDETemplFieldBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCDETemplFieldBase.getUpdateMan() != null) {
            object = pSDCDETemplFieldBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCDETemplFieldBase.getValidFlag() != null) {
            object = pSDCDETemplFieldBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCDETemplFieldBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCDETemplFieldBase pSDCDETemplFieldBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCDETemplFieldBase.isAllowEmptyDirty() && (bl || pSDCDETemplFieldBase.getAllowEmpty() != null)) {
            iDataObject.set(FIELD_ALLOWEMPTY, (Object)pSDCDETemplFieldBase.getAllowEmpty());
        }
        if (pSDCDETemplFieldBase.isCodeNameDirty() && (bl || pSDCDETemplFieldBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDCDETemplFieldBase.getCodeName());
        }
        if (pSDCDETemplFieldBase.isCreateDateDirty() && (bl || pSDCDETemplFieldBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCDETemplFieldBase.getCreateDate());
        }
        if (pSDCDETemplFieldBase.isCreateManDirty() && (bl || pSDCDETemplFieldBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCDETemplFieldBase.getCreateMan());
        }
        if (pSDCDETemplFieldBase.isDEFTypeDirty() && (bl || pSDCDETemplFieldBase.getDEFType() != null)) {
            iDataObject.set(FIELD_DEFTYPE, (Object)pSDCDETemplFieldBase.getDEFType());
        }
        if (pSDCDETemplFieldBase.isLengthDirty() && (bl || pSDCDETemplFieldBase.getLength() != null)) {
            iDataObject.set(FIELD_LENGTH, (Object)pSDCDETemplFieldBase.getLength());
        }
        if (pSDCDETemplFieldBase.isLogicNameDirty() && (bl || pSDCDETemplFieldBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDCDETemplFieldBase.getLogicName());
        }
        if (pSDCDETemplFieldBase.isMemoDirty() && (bl || pSDCDETemplFieldBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCDETemplFieldBase.getMemo());
        }
        if (pSDCDETemplFieldBase.isPrecision2Dirty() && (bl || pSDCDETemplFieldBase.getPrecision2() != null)) {
            iDataObject.set(FIELD_PRECISION2, (Object)pSDCDETemplFieldBase.getPrecision2());
        }
        if (pSDCDETemplFieldBase.isPreDefineTypeDirty() && (bl || pSDCDETemplFieldBase.getPreDefineType() != null)) {
            iDataObject.set(FIELD_PREDEFINETYPE, (Object)pSDCDETemplFieldBase.getPreDefineType());
        }
        if (pSDCDETemplFieldBase.isPSDataTypeIdDirty() && (bl || pSDCDETemplFieldBase.getPSDataTypeId() != null)) {
            iDataObject.set(FIELD_PSDATATYPEID, (Object)pSDCDETemplFieldBase.getPSDataTypeId());
        }
        if (pSDCDETemplFieldBase.isPSDataTypeNameDirty() && (bl || pSDCDETemplFieldBase.getPSDataTypeName() != null)) {
            iDataObject.set(FIELD_PSDATATYPENAME, (Object)pSDCDETemplFieldBase.getPSDataTypeName());
        }
        if (pSDCDETemplFieldBase.isPSDCDETemplFieldIdDirty() && (bl || pSDCDETemplFieldBase.getPSDCDETemplFieldId() != null)) {
            iDataObject.set(FIELD_PSDCDETEMPLFIELDID, (Object)pSDCDETemplFieldBase.getPSDCDETemplFieldId());
        }
        if (pSDCDETemplFieldBase.isPSDCDETemplFieldNameDirty() && (bl || pSDCDETemplFieldBase.getPSDCDETemplFieldName() != null)) {
            iDataObject.set(FIELD_PSDCDETEMPLFIELDNAME, (Object)pSDCDETemplFieldBase.getPSDCDETemplFieldName());
        }
        if (pSDCDETemplFieldBase.isPSDCDETemplIdDirty() && (bl || pSDCDETemplFieldBase.getPSDCDETemplId() != null)) {
            iDataObject.set(FIELD_PSDCDETEMPLID, (Object)pSDCDETemplFieldBase.getPSDCDETemplId());
        }
        if (pSDCDETemplFieldBase.isPSDCDETemplNameDirty() && (bl || pSDCDETemplFieldBase.getPSDCDETemplName() != null)) {
            iDataObject.set(FIELD_PSDCDETEMPLNAME, (Object)pSDCDETemplFieldBase.getPSDCDETemplName());
        }
        if (pSDCDETemplFieldBase.isUpdateDateDirty() && (bl || pSDCDETemplFieldBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCDETemplFieldBase.getUpdateDate());
        }
        if (pSDCDETemplFieldBase.isUpdateManDirty() && (bl || pSDCDETemplFieldBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCDETemplFieldBase.getUpdateMan());
        }
        if (pSDCDETemplFieldBase.isValidFlagDirty() && (bl || pSDCDETemplFieldBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDCDETemplFieldBase.getValidFlag());
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
        return PSDCDETemplFieldBase.remove(this, n);
    }

    private static boolean remove(PSDCDETemplFieldBase pSDCDETemplFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCDETemplFieldBase.resetAllowEmpty();
                return true;
            }
            case 1: {
                pSDCDETemplFieldBase.resetCodeName();
                return true;
            }
            case 2: {
                pSDCDETemplFieldBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDCDETemplFieldBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDCDETemplFieldBase.resetDEFType();
                return true;
            }
            case 5: {
                pSDCDETemplFieldBase.resetLength();
                return true;
            }
            case 6: {
                pSDCDETemplFieldBase.resetLogicName();
                return true;
            }
            case 7: {
                pSDCDETemplFieldBase.resetMemo();
                return true;
            }
            case 8: {
                pSDCDETemplFieldBase.resetPrecision2();
                return true;
            }
            case 9: {
                pSDCDETemplFieldBase.resetPreDefineType();
                return true;
            }
            case 10: {
                pSDCDETemplFieldBase.resetPSDataTypeId();
                return true;
            }
            case 11: {
                pSDCDETemplFieldBase.resetPSDataTypeName();
                return true;
            }
            case 12: {
                pSDCDETemplFieldBase.resetPSDCDETemplFieldId();
                return true;
            }
            case 13: {
                pSDCDETemplFieldBase.resetPSDCDETemplFieldName();
                return true;
            }
            case 14: {
                pSDCDETemplFieldBase.resetPSDCDETemplId();
                return true;
            }
            case 15: {
                pSDCDETemplFieldBase.resetPSDCDETemplName();
                return true;
            }
            case 16: {
                pSDCDETemplFieldBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSDCDETemplFieldBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSDCDETemplFieldBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCDETempl getPSDCDETempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDETempl();
        }
        if (this.getPSDCDETemplId() == null) {
            return null;
        }
        Integer n = this.objPSDCDETemplLock;
        synchronized (n) {
            if (this.psdcdetempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCDETemplId(), (Object)this.psdcdetempl.getPSDCDETemplId()) != 0L) {
                this.psdcdetempl = null;
            }
            if (this.psdcdetempl == null) {
                PSDCDETempl pSDCDETempl = new PSDCDETempl();
                pSDCDETempl.setPSDCDETemplId(this.getPSDCDETemplId());
                PSDCDETemplService pSDCDETemplService = (PSDCDETemplService)ServiceGlobal.getService(PSDCDETemplService.class, (SessionFactory)this.getSessionFactory());
                pSDCDETemplService.autoGet(pSDCDETempl);
                this.psdcdetempl = pSDCDETempl;
            }
            return this.psdcdetempl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFDataType getPSDataType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDataType();
        }
        if (this.getPSDataTypeId() == null) {
            return null;
        }
        Integer n = this.objPSDataTypeLock;
        synchronized (n) {
            if (this.psdatatype != null && DataTypeHelper.compare((int)25, (Object)this.getPSDataTypeId(), (Object)this.psdatatype.getPSDEFDataTypeId()) != 0L) {
                this.psdatatype = null;
            }
            if (this.psdatatype == null) {
                PSDEFDataType pSDEFDataType = new PSDEFDataType();
                pSDEFDataType.setPSDEFDataTypeId(this.getPSDataTypeId());
                PSDEFDataTypeService pSDEFDataTypeService = (PSDEFDataTypeService)ServiceGlobal.getService(PSDEFDataTypeService.class, (SessionFactory)this.getSessionFactory());
                pSDEFDataTypeService.autoGet(pSDEFDataType);
                this.psdatatype = pSDEFDataType;
            }
            return this.psdatatype;
        }
    }

    private PSDCDETemplFieldBase getProxyEntity() {
        return this.proxyPSDCDETemplFieldBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCDETemplFieldBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCDETemplFieldBase) {
            this.proxyPSDCDETemplFieldBase = (PSDCDETemplFieldBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCDETemplFieldService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLOWEMPTY, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_DEFTYPE, 4);
        fieldIndexMap.put(FIELD_LENGTH, 5);
        fieldIndexMap.put(FIELD_LOGICNAME, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_PRECISION2, 8);
        fieldIndexMap.put(FIELD_PREDEFINETYPE, 9);
        fieldIndexMap.put(FIELD_PSDATATYPEID, 10);
        fieldIndexMap.put(FIELD_PSDATATYPENAME, 11);
        fieldIndexMap.put(FIELD_PSDCDETEMPLFIELDID, 12);
        fieldIndexMap.put(FIELD_PSDCDETEMPLFIELDNAME, 13);
        fieldIndexMap.put(FIELD_PSDCDETEMPLID, 14);
        fieldIndexMap.put(FIELD_PSDCDETEMPLNAME, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_VALIDFLAG, 18);
    }
}

