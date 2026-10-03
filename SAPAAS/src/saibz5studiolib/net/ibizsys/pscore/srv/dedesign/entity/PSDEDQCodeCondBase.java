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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCode;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDQCodeCondBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEDQCodeCondBase.class);
    public static final String FIELD_CONDCODE = "CONDCODE";
    public static final String FIELD_CONDTAG = "CONDTAG";
    public static final String FIELD_CONDTAG2 = "CONDTAG2";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FIELDNAME = "FIELDNAME";
    public static final String FIELD_IGNOREEMPTY = "IGNOREEMPTY";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEDQCODECONDID = "PSDEDQCODECONDID";
    public static final String FIELD_PSDEDQCODECONDNAME = "PSDEDQCODECONDNAME";
    public static final String FIELD_PSDEDQCODEID = "PSDEDQCODEID";
    public static final String FIELD_PSDEDQCODENAME = "PSDEDQCODENAME";
    public static final String FIELD_PSVARTYPEID = "PSVARTYPEID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CONDCODE = 0;
    private static final int INDEX_CONDTAG = 1;
    private static final int INDEX_CONDTAG2 = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_FIELDNAME = 5;
    private static final int INDEX_IGNOREEMPTY = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_ORDERVALUE = 8;
    private static final int INDEX_PSDEDQCODECONDID = 9;
    private static final int INDEX_PSDEDQCODECONDNAME = 10;
    private static final int INDEX_PSDEDQCODEID = 11;
    private static final int INDEX_PSDEDQCODENAME = 12;
    private static final int INDEX_PSVARTYPEID = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEDQCodeCondBase proxyPSDEDQCodeCondBase = null;
    private boolean condcodeDirtyFlag = false;
    private boolean condtagDirtyFlag = false;
    private boolean condtag2DirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean fieldnameDirtyFlag = false;
    private boolean ignoreemptyDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdedqcodecondidDirtyFlag = false;
    private boolean psdedqcodecondnameDirtyFlag = false;
    private boolean psdedqcodeidDirtyFlag = false;
    private boolean psdedqcodenameDirtyFlag = false;
    private boolean psvartypeidDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="condcode")
    private String condcode;
    @Column(name="condtag")
    private String condtag;
    @Column(name="condtag2")
    private String condtag2;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="fieldname")
    private String fieldname;
    @Column(name="ignoreempty")
    private Integer ignoreempty;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdedqcodecondid")
    private String psdedqcodecondid;
    @Column(name="psdedqcodecondname")
    private String psdedqcodecondname;
    @Column(name="psdedqcodeid")
    private String psdedqcodeid;
    @Column(name="psdedqcodename")
    private String psdedqcodename;
    @Column(name="psvartypeid")
    private String psvartypeid;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDEDQCodeLock = new Integer(1);
    private PSDEDQCode psdedqcode = null;

    public void setCondCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCondCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.condcode = string;
        this.condcodeDirtyFlag = true;
    }

    public String getCondCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCondCode();
        }
        return this.condcode;
    }

    public boolean isCondCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCondCodeDirty();
        }
        return this.condcodeDirtyFlag;
    }

    public void resetCondCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCondCode();
            return;
        }
        this.condcodeDirtyFlag = false;
        this.condcode = null;
    }

    public void setCondTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCondTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.condtag = string;
        this.condtagDirtyFlag = true;
    }

    public String getCondTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCondTag();
        }
        return this.condtag;
    }

    public boolean isCondTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCondTagDirty();
        }
        return this.condtagDirtyFlag;
    }

    public void resetCondTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCondTag();
            return;
        }
        this.condtagDirtyFlag = false;
        this.condtag = null;
    }

    public void setCondTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCondTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.condtag2 = string;
        this.condtag2DirtyFlag = true;
    }

    public String getCondTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCondTag2();
        }
        return this.condtag2;
    }

    public boolean isCondTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCondTag2Dirty();
        }
        return this.condtag2DirtyFlag;
    }

    public void resetCondTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCondTag2();
            return;
        }
        this.condtag2DirtyFlag = false;
        this.condtag2 = null;
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

    public void setFieldName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFieldName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fieldname = string;
        this.fieldnameDirtyFlag = true;
    }

    public String getFieldName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFieldName();
        }
        return this.fieldname;
    }

    public boolean isFieldNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFieldNameDirty();
        }
        return this.fieldnameDirtyFlag;
    }

    public void resetFieldName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFieldName();
            return;
        }
        this.fieldnameDirtyFlag = false;
        this.fieldname = null;
    }

    public void setIgnoreEmpty(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIgnoreEmpty(n);
            return;
        }
        this.ignoreempty = n;
        this.ignoreemptyDirtyFlag = true;
    }

    public Integer getIgnoreEmpty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIgnoreEmpty();
        }
        return this.ignoreempty;
    }

    public boolean isIgnoreEmptyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIgnoreEmptyDirty();
        }
        return this.ignoreemptyDirtyFlag;
    }

    public void resetIgnoreEmpty() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIgnoreEmpty();
            return;
        }
        this.ignoreemptyDirtyFlag = false;
        this.ignoreempty = null;
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

    public void setPSDEDQCodeCondId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDQCodeCondId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedqcodecondid = string;
        this.psdedqcodecondidDirtyFlag = true;
    }

    public String getPSDEDQCodeCondId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQCodeCondId();
        }
        return this.psdedqcodecondid;
    }

    public boolean isPSDEDQCodeCondIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDQCodeCondIdDirty();
        }
        return this.psdedqcodecondidDirtyFlag;
    }

    public void resetPSDEDQCodeCondId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDQCodeCondId();
            return;
        }
        this.psdedqcodecondidDirtyFlag = false;
        this.psdedqcodecondid = null;
    }

    public void setPSDEDQCodeCondName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDQCodeCondName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedqcodecondname = string;
        this.psdedqcodecondnameDirtyFlag = true;
    }

    public String getPSDEDQCodeCondName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQCodeCondName();
        }
        return this.psdedqcodecondname;
    }

    public boolean isPSDEDQCodeCondNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDQCodeCondNameDirty();
        }
        return this.psdedqcodecondnameDirtyFlag;
    }

    public void resetPSDEDQCodeCondName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDQCodeCondName();
            return;
        }
        this.psdedqcodecondnameDirtyFlag = false;
        this.psdedqcodecondname = null;
    }

    public void setPSDEDQCodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDQCodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedqcodeid = string;
        this.psdedqcodeidDirtyFlag = true;
    }

    public String getPSDEDQCodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQCodeId();
        }
        return this.psdedqcodeid;
    }

    public boolean isPSDEDQCodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDQCodeIdDirty();
        }
        return this.psdedqcodeidDirtyFlag;
    }

    public void resetPSDEDQCodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDQCodeId();
            return;
        }
        this.psdedqcodeidDirtyFlag = false;
        this.psdedqcodeid = null;
    }

    public void setPSDEDQCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDQCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedqcodename = string;
        this.psdedqcodenameDirtyFlag = true;
    }

    public String getPSDEDQCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQCodeName();
        }
        return this.psdedqcodename;
    }

    public boolean isPSDEDQCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDQCodeNameDirty();
        }
        return this.psdedqcodenameDirtyFlag;
    }

    public void resetPSDEDQCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDQCodeName();
            return;
        }
        this.psdedqcodenameDirtyFlag = false;
        this.psdedqcodename = null;
    }

    public void setPSVarTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSVarTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psvartypeid = string;
        this.psvartypeidDirtyFlag = true;
    }

    public String getPSVarTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSVarTypeId();
        }
        return this.psvartypeid;
    }

    public boolean isPSVarTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSVarTypeIdDirty();
        }
        return this.psvartypeidDirtyFlag;
    }

    public void resetPSVarTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSVarTypeId();
            return;
        }
        this.psvartypeidDirtyFlag = false;
        this.psvartypeid = null;
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
        PSDEDQCodeCondBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEDQCodeCondBase pSDEDQCodeCondBase) {
        pSDEDQCodeCondBase.resetCondCode();
        pSDEDQCodeCondBase.resetCondTag();
        pSDEDQCodeCondBase.resetCondTag2();
        pSDEDQCodeCondBase.resetCreateDate();
        pSDEDQCodeCondBase.resetCreateMan();
        pSDEDQCodeCondBase.resetFieldName();
        pSDEDQCodeCondBase.resetIgnoreEmpty();
        pSDEDQCodeCondBase.resetMemo();
        pSDEDQCodeCondBase.resetOrderValue();
        pSDEDQCodeCondBase.resetPSDEDQCodeCondId();
        pSDEDQCodeCondBase.resetPSDEDQCodeCondName();
        pSDEDQCodeCondBase.resetPSDEDQCodeId();
        pSDEDQCodeCondBase.resetPSDEDQCodeName();
        pSDEDQCodeCondBase.resetPSVarTypeId();
        pSDEDQCodeCondBase.resetUpdateDate();
        pSDEDQCodeCondBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCondCodeDirty()) {
            hashMap.put(FIELD_CONDCODE, this.getCondCode());
        }
        if (!bl || this.isCondTagDirty()) {
            hashMap.put(FIELD_CONDTAG, this.getCondTag());
        }
        if (!bl || this.isCondTag2Dirty()) {
            hashMap.put(FIELD_CONDTAG2, this.getCondTag2());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isFieldNameDirty()) {
            hashMap.put(FIELD_FIELDNAME, this.getFieldName());
        }
        if (!bl || this.isIgnoreEmptyDirty()) {
            hashMap.put(FIELD_IGNOREEMPTY, this.getIgnoreEmpty());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDEDQCodeCondIdDirty()) {
            hashMap.put(FIELD_PSDEDQCODECONDID, this.getPSDEDQCodeCondId());
        }
        if (!bl || this.isPSDEDQCodeCondNameDirty()) {
            hashMap.put(FIELD_PSDEDQCODECONDNAME, this.getPSDEDQCodeCondName());
        }
        if (!bl || this.isPSDEDQCodeIdDirty()) {
            hashMap.put(FIELD_PSDEDQCODEID, this.getPSDEDQCodeId());
        }
        if (!bl || this.isPSDEDQCodeNameDirty()) {
            hashMap.put(FIELD_PSDEDQCODENAME, this.getPSDEDQCodeName());
        }
        if (!bl || this.isPSVarTypeIdDirty()) {
            hashMap.put(FIELD_PSVARTYPEID, this.getPSVarTypeId());
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
        return PSDEDQCodeCondBase.get(this, n);
    }

    private static Object get(PSDEDQCodeCondBase pSDEDQCodeCondBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDQCodeCondBase.getCondCode();
            }
            case 1: {
                return pSDEDQCodeCondBase.getCondTag();
            }
            case 2: {
                return pSDEDQCodeCondBase.getCondTag2();
            }
            case 3: {
                return pSDEDQCodeCondBase.getCreateDate();
            }
            case 4: {
                return pSDEDQCodeCondBase.getCreateMan();
            }
            case 5: {
                return pSDEDQCodeCondBase.getFieldName();
            }
            case 6: {
                return pSDEDQCodeCondBase.getIgnoreEmpty();
            }
            case 7: {
                return pSDEDQCodeCondBase.getMemo();
            }
            case 8: {
                return pSDEDQCodeCondBase.getOrderValue();
            }
            case 9: {
                return pSDEDQCodeCondBase.getPSDEDQCodeCondId();
            }
            case 10: {
                return pSDEDQCodeCondBase.getPSDEDQCodeCondName();
            }
            case 11: {
                return pSDEDQCodeCondBase.getPSDEDQCodeId();
            }
            case 12: {
                return pSDEDQCodeCondBase.getPSDEDQCodeName();
            }
            case 13: {
                return pSDEDQCodeCondBase.getPSVarTypeId();
            }
            case 14: {
                return pSDEDQCodeCondBase.getUpdateDate();
            }
            case 15: {
                return pSDEDQCodeCondBase.getUpdateMan();
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
        PSDEDQCodeCondBase.set(this, n, object);
    }

    private static void set(PSDEDQCodeCondBase pSDEDQCodeCondBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEDQCodeCondBase.setCondCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEDQCodeCondBase.setCondTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEDQCodeCondBase.setCondTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEDQCodeCondBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDEDQCodeCondBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEDQCodeCondBase.setFieldName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEDQCodeCondBase.setIgnoreEmpty(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDEDQCodeCondBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEDQCodeCondBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDEDQCodeCondBase.setPSDEDQCodeCondId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEDQCodeCondBase.setPSDEDQCodeCondName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEDQCodeCondBase.setPSDEDQCodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEDQCodeCondBase.setPSDEDQCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEDQCodeCondBase.setPSVarTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEDQCodeCondBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSDEDQCodeCondBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDEDQCodeCondBase.isNull(this, n);
    }

    private static boolean isNull(PSDEDQCodeCondBase pSDEDQCodeCondBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDQCodeCondBase.getCondCode() == null;
            }
            case 1: {
                return pSDEDQCodeCondBase.getCondTag() == null;
            }
            case 2: {
                return pSDEDQCodeCondBase.getCondTag2() == null;
            }
            case 3: {
                return pSDEDQCodeCondBase.getCreateDate() == null;
            }
            case 4: {
                return pSDEDQCodeCondBase.getCreateMan() == null;
            }
            case 5: {
                return pSDEDQCodeCondBase.getFieldName() == null;
            }
            case 6: {
                return pSDEDQCodeCondBase.getIgnoreEmpty() == null;
            }
            case 7: {
                return pSDEDQCodeCondBase.getMemo() == null;
            }
            case 8: {
                return pSDEDQCodeCondBase.getOrderValue() == null;
            }
            case 9: {
                return pSDEDQCodeCondBase.getPSDEDQCodeCondId() == null;
            }
            case 10: {
                return pSDEDQCodeCondBase.getPSDEDQCodeCondName() == null;
            }
            case 11: {
                return pSDEDQCodeCondBase.getPSDEDQCodeId() == null;
            }
            case 12: {
                return pSDEDQCodeCondBase.getPSDEDQCodeName() == null;
            }
            case 13: {
                return pSDEDQCodeCondBase.getPSVarTypeId() == null;
            }
            case 14: {
                return pSDEDQCodeCondBase.getUpdateDate() == null;
            }
            case 15: {
                return pSDEDQCodeCondBase.getUpdateMan() == null;
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
        return PSDEDQCodeCondBase.contains(this, n);
    }

    private static boolean contains(PSDEDQCodeCondBase pSDEDQCodeCondBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDQCodeCondBase.isCondCodeDirty();
            }
            case 1: {
                return pSDEDQCodeCondBase.isCondTagDirty();
            }
            case 2: {
                return pSDEDQCodeCondBase.isCondTag2Dirty();
            }
            case 3: {
                return pSDEDQCodeCondBase.isCreateDateDirty();
            }
            case 4: {
                return pSDEDQCodeCondBase.isCreateManDirty();
            }
            case 5: {
                return pSDEDQCodeCondBase.isFieldNameDirty();
            }
            case 6: {
                return pSDEDQCodeCondBase.isIgnoreEmptyDirty();
            }
            case 7: {
                return pSDEDQCodeCondBase.isMemoDirty();
            }
            case 8: {
                return pSDEDQCodeCondBase.isOrderValueDirty();
            }
            case 9: {
                return pSDEDQCodeCondBase.isPSDEDQCodeCondIdDirty();
            }
            case 10: {
                return pSDEDQCodeCondBase.isPSDEDQCodeCondNameDirty();
            }
            case 11: {
                return pSDEDQCodeCondBase.isPSDEDQCodeIdDirty();
            }
            case 12: {
                return pSDEDQCodeCondBase.isPSDEDQCodeNameDirty();
            }
            case 13: {
                return pSDEDQCodeCondBase.isPSVarTypeIdDirty();
            }
            case 14: {
                return pSDEDQCodeCondBase.isUpdateDateDirty();
            }
            case 15: {
                return pSDEDQCodeCondBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEDQCodeCondBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEDQCodeCondBase pSDEDQCodeCondBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEDQCodeCondBase.getCondCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condcode", (Object)PSDEDQCodeCondBase.getJSONValue((Object)pSDEDQCodeCondBase.getCondCode()), (boolean)false);
        }
        if (bl || pSDEDQCodeCondBase.getCondTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condtag", (Object)PSDEDQCodeCondBase.getJSONValue((Object)pSDEDQCodeCondBase.getCondTag()), (boolean)false);
        }
        if (bl || pSDEDQCodeCondBase.getCondTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condtag2", (Object)PSDEDQCodeCondBase.getJSONValue((Object)pSDEDQCodeCondBase.getCondTag2()), (boolean)false);
        }
        if (bl || pSDEDQCodeCondBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEDQCodeCondBase.getJSONValue((Object)pSDEDQCodeCondBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEDQCodeCondBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEDQCodeCondBase.getJSONValue((Object)pSDEDQCodeCondBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEDQCodeCondBase.getFieldName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fieldname", (Object)PSDEDQCodeCondBase.getJSONValue((Object)pSDEDQCodeCondBase.getFieldName()), (boolean)false);
        }
        if (bl || pSDEDQCodeCondBase.getIgnoreEmpty() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ignoreempty", (Object)PSDEDQCodeCondBase.getJSONValue((Object)pSDEDQCodeCondBase.getIgnoreEmpty()), (boolean)false);
        }
        if (bl || pSDEDQCodeCondBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEDQCodeCondBase.getJSONValue((Object)pSDEDQCodeCondBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEDQCodeCondBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEDQCodeCondBase.getJSONValue((Object)pSDEDQCodeCondBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEDQCodeCondBase.getPSDEDQCodeCondId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqcodecondid", (Object)PSDEDQCodeCondBase.getJSONValue((Object)pSDEDQCodeCondBase.getPSDEDQCodeCondId()), (boolean)false);
        }
        if (bl || pSDEDQCodeCondBase.getPSDEDQCodeCondName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqcodecondname", (Object)PSDEDQCodeCondBase.getJSONValue((Object)pSDEDQCodeCondBase.getPSDEDQCodeCondName()), (boolean)false);
        }
        if (bl || pSDEDQCodeCondBase.getPSDEDQCodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqcodeid", (Object)PSDEDQCodeCondBase.getJSONValue((Object)pSDEDQCodeCondBase.getPSDEDQCodeId()), (boolean)false);
        }
        if (bl || pSDEDQCodeCondBase.getPSDEDQCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqcodename", (Object)PSDEDQCodeCondBase.getJSONValue((Object)pSDEDQCodeCondBase.getPSDEDQCodeName()), (boolean)false);
        }
        if (bl || pSDEDQCodeCondBase.getPSVarTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psvartypeid", (Object)PSDEDQCodeCondBase.getJSONValue((Object)pSDEDQCodeCondBase.getPSVarTypeId()), (boolean)false);
        }
        if (bl || pSDEDQCodeCondBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEDQCodeCondBase.getJSONValue((Object)pSDEDQCodeCondBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEDQCodeCondBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEDQCodeCondBase.getJSONValue((Object)pSDEDQCodeCondBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEDQCodeCondBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEDQCodeCondBase pSDEDQCodeCondBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEDQCodeCondBase.getCondCode() != null) {
            object = pSDEDQCodeCondBase.getCondCode();
            xmlNode.setAttribute(FIELD_CONDCODE, (String)(object == null ? "" : object));
        }
        if (bl || pSDEDQCodeCondBase.getCondTag() != null) {
            object = pSDEDQCodeCondBase.getCondTag();
            xmlNode.setAttribute(FIELD_CONDTAG, (String)(object == null ? "" : object));
        }
        if (bl || pSDEDQCodeCondBase.getCondTag2() != null) {
            object = pSDEDQCodeCondBase.getCondTag2();
            xmlNode.setAttribute(FIELD_CONDTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCodeCondBase.getCreateDate() != null) {
            object = pSDEDQCodeCondBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDQCodeCondBase.getCreateMan() != null) {
            object = pSDEDQCodeCondBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCodeCondBase.getFieldName() != null) {
            object = pSDEDQCodeCondBase.getFieldName();
            xmlNode.setAttribute(FIELD_FIELDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCodeCondBase.getIgnoreEmpty() != null) {
            object = pSDEDQCodeCondBase.getIgnoreEmpty();
            xmlNode.setAttribute(FIELD_IGNOREEMPTY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDQCodeCondBase.getMemo() != null) {
            object = pSDEDQCodeCondBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCodeCondBase.getOrderValue() != null) {
            object = pSDEDQCodeCondBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDQCodeCondBase.getPSDEDQCodeCondId() != null) {
            object = pSDEDQCodeCondBase.getPSDEDQCodeCondId();
            xmlNode.setAttribute(FIELD_PSDEDQCODECONDID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCodeCondBase.getPSDEDQCodeCondName() != null) {
            object = pSDEDQCodeCondBase.getPSDEDQCodeCondName();
            xmlNode.setAttribute(FIELD_PSDEDQCODECONDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCodeCondBase.getPSDEDQCodeId() != null) {
            object = pSDEDQCodeCondBase.getPSDEDQCodeId();
            xmlNode.setAttribute(FIELD_PSDEDQCODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCodeCondBase.getPSDEDQCodeName() != null) {
            object = pSDEDQCodeCondBase.getPSDEDQCodeName();
            xmlNode.setAttribute(FIELD_PSDEDQCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCodeCondBase.getPSVarTypeId() != null) {
            object = pSDEDQCodeCondBase.getPSVarTypeId();
            xmlNode.setAttribute(FIELD_PSVARTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCodeCondBase.getUpdateDate() != null) {
            object = pSDEDQCodeCondBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDQCodeCondBase.getUpdateMan() != null) {
            object = pSDEDQCodeCondBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEDQCodeCondBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEDQCodeCondBase pSDEDQCodeCondBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEDQCodeCondBase.isCondCodeDirty() && (bl || pSDEDQCodeCondBase.getCondCode() != null)) {
            iDataObject.set(FIELD_CONDCODE, (Object)pSDEDQCodeCondBase.getCondCode());
        }
        if (pSDEDQCodeCondBase.isCondTagDirty() && (bl || pSDEDQCodeCondBase.getCondTag() != null)) {
            iDataObject.set(FIELD_CONDTAG, (Object)pSDEDQCodeCondBase.getCondTag());
        }
        if (pSDEDQCodeCondBase.isCondTag2Dirty() && (bl || pSDEDQCodeCondBase.getCondTag2() != null)) {
            iDataObject.set(FIELD_CONDTAG2, (Object)pSDEDQCodeCondBase.getCondTag2());
        }
        if (pSDEDQCodeCondBase.isCreateDateDirty() && (bl || pSDEDQCodeCondBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEDQCodeCondBase.getCreateDate());
        }
        if (pSDEDQCodeCondBase.isCreateManDirty() && (bl || pSDEDQCodeCondBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEDQCodeCondBase.getCreateMan());
        }
        if (pSDEDQCodeCondBase.isFieldNameDirty() && (bl || pSDEDQCodeCondBase.getFieldName() != null)) {
            iDataObject.set(FIELD_FIELDNAME, (Object)pSDEDQCodeCondBase.getFieldName());
        }
        if (pSDEDQCodeCondBase.isIgnoreEmptyDirty() && (bl || pSDEDQCodeCondBase.getIgnoreEmpty() != null)) {
            iDataObject.set(FIELD_IGNOREEMPTY, (Object)pSDEDQCodeCondBase.getIgnoreEmpty());
        }
        if (pSDEDQCodeCondBase.isMemoDirty() && (bl || pSDEDQCodeCondBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEDQCodeCondBase.getMemo());
        }
        if (pSDEDQCodeCondBase.isOrderValueDirty() && (bl || pSDEDQCodeCondBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEDQCodeCondBase.getOrderValue());
        }
        if (pSDEDQCodeCondBase.isPSDEDQCodeCondIdDirty() && (bl || pSDEDQCodeCondBase.getPSDEDQCodeCondId() != null)) {
            iDataObject.set(FIELD_PSDEDQCODECONDID, (Object)pSDEDQCodeCondBase.getPSDEDQCodeCondId());
        }
        if (pSDEDQCodeCondBase.isPSDEDQCodeCondNameDirty() && (bl || pSDEDQCodeCondBase.getPSDEDQCodeCondName() != null)) {
            iDataObject.set(FIELD_PSDEDQCODECONDNAME, (Object)pSDEDQCodeCondBase.getPSDEDQCodeCondName());
        }
        if (pSDEDQCodeCondBase.isPSDEDQCodeIdDirty() && (bl || pSDEDQCodeCondBase.getPSDEDQCodeId() != null)) {
            iDataObject.set(FIELD_PSDEDQCODEID, (Object)pSDEDQCodeCondBase.getPSDEDQCodeId());
        }
        if (pSDEDQCodeCondBase.isPSDEDQCodeNameDirty() && (bl || pSDEDQCodeCondBase.getPSDEDQCodeName() != null)) {
            iDataObject.set(FIELD_PSDEDQCODENAME, (Object)pSDEDQCodeCondBase.getPSDEDQCodeName());
        }
        if (pSDEDQCodeCondBase.isPSVarTypeIdDirty() && (bl || pSDEDQCodeCondBase.getPSVarTypeId() != null)) {
            iDataObject.set(FIELD_PSVARTYPEID, (Object)pSDEDQCodeCondBase.getPSVarTypeId());
        }
        if (pSDEDQCodeCondBase.isUpdateDateDirty() && (bl || pSDEDQCodeCondBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEDQCodeCondBase.getUpdateDate());
        }
        if (pSDEDQCodeCondBase.isUpdateManDirty() && (bl || pSDEDQCodeCondBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEDQCodeCondBase.getUpdateMan());
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
        return PSDEDQCodeCondBase.remove(this, n);
    }

    private static boolean remove(PSDEDQCodeCondBase pSDEDQCodeCondBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEDQCodeCondBase.resetCondCode();
                return true;
            }
            case 1: {
                pSDEDQCodeCondBase.resetCondTag();
                return true;
            }
            case 2: {
                pSDEDQCodeCondBase.resetCondTag2();
                return true;
            }
            case 3: {
                pSDEDQCodeCondBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSDEDQCodeCondBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSDEDQCodeCondBase.resetFieldName();
                return true;
            }
            case 6: {
                pSDEDQCodeCondBase.resetIgnoreEmpty();
                return true;
            }
            case 7: {
                pSDEDQCodeCondBase.resetMemo();
                return true;
            }
            case 8: {
                pSDEDQCodeCondBase.resetOrderValue();
                return true;
            }
            case 9: {
                pSDEDQCodeCondBase.resetPSDEDQCodeCondId();
                return true;
            }
            case 10: {
                pSDEDQCodeCondBase.resetPSDEDQCodeCondName();
                return true;
            }
            case 11: {
                pSDEDQCodeCondBase.resetPSDEDQCodeId();
                return true;
            }
            case 12: {
                pSDEDQCodeCondBase.resetPSDEDQCodeName();
                return true;
            }
            case 13: {
                pSDEDQCodeCondBase.resetPSVarTypeId();
                return true;
            }
            case 14: {
                pSDEDQCodeCondBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSDEDQCodeCondBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDQCode getPSDEDQCode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQCode();
        }
        if (this.getPSDEDQCodeId() == null) {
            return null;
        }
        Integer n = this.objPSDEDQCodeLock;
        synchronized (n) {
            if (this.psdedqcode != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDQCodeId(), (Object)this.psdedqcode.getPSDEDQCodeId()) != 0L) {
                this.psdedqcode = null;
            }
            if (this.psdedqcode == null) {
                PSDEDQCode pSDEDQCode = new PSDEDQCode();
                pSDEDQCode.setPSDEDQCodeId(this.getPSDEDQCodeId());
                PSDEDQCodeService pSDEDQCodeService = (PSDEDQCodeService)ServiceGlobal.getService(PSDEDQCodeService.class, (SessionFactory)this.getSessionFactory());
                pSDEDQCodeService.autoGet(pSDEDQCode);
                this.psdedqcode = pSDEDQCode;
            }
            return this.psdedqcode;
        }
    }

    private PSDEDQCodeCondBase getProxyEntity() {
        return this.proxyPSDEDQCodeCondBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEDQCodeCondBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEDQCodeCondBase) {
            this.proxyPSDEDQCodeCondBase = (PSDEDQCodeCondBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeCondService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONDCODE, 0);
        fieldIndexMap.put(FIELD_CONDTAG, 1);
        fieldIndexMap.put(FIELD_CONDTAG2, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_FIELDNAME, 5);
        fieldIndexMap.put(FIELD_IGNOREEMPTY, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_ORDERVALUE, 8);
        fieldIndexMap.put(FIELD_PSDEDQCODECONDID, 9);
        fieldIndexMap.put(FIELD_PSDEDQCODECONDNAME, 10);
        fieldIndexMap.put(FIELD_PSDEDQCODEID, 11);
        fieldIndexMap.put(FIELD_PSDEDQCODENAME, 12);
        fieldIndexMap.put(FIELD_PSVARTYPEID, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
    }
}

