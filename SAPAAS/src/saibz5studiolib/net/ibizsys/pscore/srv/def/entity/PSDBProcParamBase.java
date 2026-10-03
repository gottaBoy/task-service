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
package net.ibizsys.pscore.srv.def.entity;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDESPCode;
import net.ibizsys.pscore.srv.dedesign.service.PSDESPCodeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDBProcParamBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDBProcParamBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_JDBCTYPE = "JDBCTYPE";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PARAMDIR = "PARAMDIR";
    public static final String FIELD_PSDBPROCPARAMID = "PSDBPROCPARAMID";
    public static final String FIELD_PSDBPROCPARAMNAME = "PSDBPROCPARAMNAME";
    public static final String FIELD_PSDESPCODEID = "PSDESPCODEID";
    public static final String FIELD_PSDESPCODENAME = "PSDESPCODENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_JDBCTYPE = 2;
    private static final int INDEX_ORDERVALUE = 3;
    private static final int INDEX_PARAMDIR = 4;
    private static final int INDEX_PSDBPROCPARAMID = 5;
    private static final int INDEX_PSDBPROCPARAMNAME = 6;
    private static final int INDEX_PSDESPCODEID = 7;
    private static final int INDEX_PSDESPCODENAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDBProcParamBase proxyPSDBProcParamBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean jdbctypeDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean paramdirDirtyFlag = false;
    private boolean psdbprocparamidDirtyFlag = false;
    private boolean psdbprocparamnameDirtyFlag = false;
    private boolean psdespcodeidDirtyFlag = false;
    private boolean psdespcodenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="jdbctype")
    private Integer jdbctype;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="paramdir")
    private Integer paramdir;
    @Column(name="psdbprocparamid")
    private String psdbprocparamid;
    @Column(name="psdbprocparamname")
    private String psdbprocparamname;
    @Column(name="psdespcodeid")
    private String psdespcodeid;
    @Column(name="psdespcodename")
    private String psdespcodename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDESPCodeLock = new Integer(1);
    private PSDESPCode psdespcode = null;

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

    public void setJdbcType(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJdbcType(n);
            return;
        }
        this.jdbctype = n;
        this.jdbctypeDirtyFlag = true;
    }

    public Integer getJdbcType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJdbcType();
        }
        return this.jdbctype;
    }

    public boolean isJdbcTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJdbcTypeDirty();
        }
        return this.jdbctypeDirtyFlag;
    }

    public void resetJdbcType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJdbcType();
            return;
        }
        this.jdbctypeDirtyFlag = false;
        this.jdbctype = null;
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

    public void setParamDIR(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamDIR(n);
            return;
        }
        this.paramdir = n;
        this.paramdirDirtyFlag = true;
    }

    public Integer getParamDIR() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamDIR();
        }
        return this.paramdir;
    }

    public boolean isParamDIRDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamDIRDirty();
        }
        return this.paramdirDirtyFlag;
    }

    public void resetParamDIR() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamDIR();
            return;
        }
        this.paramdirDirtyFlag = false;
        this.paramdir = null;
    }

    public void setPSDBProcParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBProcParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbprocparamid = string;
        this.psdbprocparamidDirtyFlag = true;
    }

    public String getPSDBProcParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBProcParamId();
        }
        return this.psdbprocparamid;
    }

    public boolean isPSDBProcParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBProcParamIdDirty();
        }
        return this.psdbprocparamidDirtyFlag;
    }

    public void resetPSDBProcParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBProcParamId();
            return;
        }
        this.psdbprocparamidDirtyFlag = false;
        this.psdbprocparamid = null;
    }

    public void setPSDBProcParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBProcParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbprocparamname = string;
        this.psdbprocparamnameDirtyFlag = true;
    }

    public String getPSDBProcParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBProcParamName();
        }
        return this.psdbprocparamname;
    }

    public boolean isPSDBProcParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBProcParamNameDirty();
        }
        return this.psdbprocparamnameDirtyFlag;
    }

    public void resetPSDBProcParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBProcParamName();
            return;
        }
        this.psdbprocparamnameDirtyFlag = false;
        this.psdbprocparamname = null;
    }

    public void setPSDESPCodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESPCodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdespcodeid = string;
        this.psdespcodeidDirtyFlag = true;
    }

    public String getPSDESPCodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESPCodeId();
        }
        return this.psdespcodeid;
    }

    public boolean isPSDESPCodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESPCodeIdDirty();
        }
        return this.psdespcodeidDirtyFlag;
    }

    public void resetPSDESPCodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESPCodeId();
            return;
        }
        this.psdespcodeidDirtyFlag = false;
        this.psdespcodeid = null;
    }

    public void setPSDESPCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDESPCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdespcodename = string;
        this.psdespcodenameDirtyFlag = true;
    }

    public String getPSDESPCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESPCodeName();
        }
        return this.psdespcodename;
    }

    public boolean isPSDESPCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDESPCodeNameDirty();
        }
        return this.psdespcodenameDirtyFlag;
    }

    public void resetPSDESPCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDESPCodeName();
            return;
        }
        this.psdespcodenameDirtyFlag = false;
        this.psdespcodename = null;
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
        PSDBProcParamBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDBProcParamBase pSDBProcParamBase) {
        pSDBProcParamBase.resetCreateDate();
        pSDBProcParamBase.resetCreateMan();
        pSDBProcParamBase.resetJdbcType();
        pSDBProcParamBase.resetOrderValue();
        pSDBProcParamBase.resetParamDIR();
        pSDBProcParamBase.resetPSDBProcParamId();
        pSDBProcParamBase.resetPSDBProcParamName();
        pSDBProcParamBase.resetPSDESPCodeId();
        pSDBProcParamBase.resetPSDESPCodeName();
        pSDBProcParamBase.resetUpdateDate();
        pSDBProcParamBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isJdbcTypeDirty()) {
            hashMap.put(FIELD_JDBCTYPE, this.getJdbcType());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isParamDIRDirty()) {
            hashMap.put(FIELD_PARAMDIR, this.getParamDIR());
        }
        if (!bl || this.isPSDBProcParamIdDirty()) {
            hashMap.put(FIELD_PSDBPROCPARAMID, this.getPSDBProcParamId());
        }
        if (!bl || this.isPSDBProcParamNameDirty()) {
            hashMap.put(FIELD_PSDBPROCPARAMNAME, this.getPSDBProcParamName());
        }
        if (!bl || this.isPSDESPCodeIdDirty()) {
            hashMap.put(FIELD_PSDESPCODEID, this.getPSDESPCodeId());
        }
        if (!bl || this.isPSDESPCodeNameDirty()) {
            hashMap.put(FIELD_PSDESPCODENAME, this.getPSDESPCodeName());
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
        return PSDBProcParamBase.get(this, n);
    }

    private static Object get(PSDBProcParamBase pSDBProcParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBProcParamBase.getCreateDate();
            }
            case 1: {
                return pSDBProcParamBase.getCreateMan();
            }
            case 2: {
                return pSDBProcParamBase.getJdbcType();
            }
            case 3: {
                return pSDBProcParamBase.getOrderValue();
            }
            case 4: {
                return pSDBProcParamBase.getParamDIR();
            }
            case 5: {
                return pSDBProcParamBase.getPSDBProcParamId();
            }
            case 6: {
                return pSDBProcParamBase.getPSDBProcParamName();
            }
            case 7: {
                return pSDBProcParamBase.getPSDESPCodeId();
            }
            case 8: {
                return pSDBProcParamBase.getPSDESPCodeName();
            }
            case 9: {
                return pSDBProcParamBase.getUpdateDate();
            }
            case 10: {
                return pSDBProcParamBase.getUpdateMan();
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
        PSDBProcParamBase.set(this, n, object);
    }

    private static void set(PSDBProcParamBase pSDBProcParamBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDBProcParamBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDBProcParamBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDBProcParamBase.setJdbcType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDBProcParamBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDBProcParamBase.setParamDIR(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDBProcParamBase.setPSDBProcParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDBProcParamBase.setPSDBProcParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDBProcParamBase.setPSDESPCodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDBProcParamBase.setPSDESPCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDBProcParamBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSDBProcParamBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDBProcParamBase.isNull(this, n);
    }

    private static boolean isNull(PSDBProcParamBase pSDBProcParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBProcParamBase.getCreateDate() == null;
            }
            case 1: {
                return pSDBProcParamBase.getCreateMan() == null;
            }
            case 2: {
                return pSDBProcParamBase.getJdbcType() == null;
            }
            case 3: {
                return pSDBProcParamBase.getOrderValue() == null;
            }
            case 4: {
                return pSDBProcParamBase.getParamDIR() == null;
            }
            case 5: {
                return pSDBProcParamBase.getPSDBProcParamId() == null;
            }
            case 6: {
                return pSDBProcParamBase.getPSDBProcParamName() == null;
            }
            case 7: {
                return pSDBProcParamBase.getPSDESPCodeId() == null;
            }
            case 8: {
                return pSDBProcParamBase.getPSDESPCodeName() == null;
            }
            case 9: {
                return pSDBProcParamBase.getUpdateDate() == null;
            }
            case 10: {
                return pSDBProcParamBase.getUpdateMan() == null;
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
        return PSDBProcParamBase.contains(this, n);
    }

    private static boolean contains(PSDBProcParamBase pSDBProcParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBProcParamBase.isCreateDateDirty();
            }
            case 1: {
                return pSDBProcParamBase.isCreateManDirty();
            }
            case 2: {
                return pSDBProcParamBase.isJdbcTypeDirty();
            }
            case 3: {
                return pSDBProcParamBase.isOrderValueDirty();
            }
            case 4: {
                return pSDBProcParamBase.isParamDIRDirty();
            }
            case 5: {
                return pSDBProcParamBase.isPSDBProcParamIdDirty();
            }
            case 6: {
                return pSDBProcParamBase.isPSDBProcParamNameDirty();
            }
            case 7: {
                return pSDBProcParamBase.isPSDESPCodeIdDirty();
            }
            case 8: {
                return pSDBProcParamBase.isPSDESPCodeNameDirty();
            }
            case 9: {
                return pSDBProcParamBase.isUpdateDateDirty();
            }
            case 10: {
                return pSDBProcParamBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDBProcParamBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDBProcParamBase pSDBProcParamBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDBProcParamBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDBProcParamBase.getJSONValue((Object)pSDBProcParamBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDBProcParamBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDBProcParamBase.getJSONValue((Object)pSDBProcParamBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDBProcParamBase.getJdbcType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jdbctype", (Object)PSDBProcParamBase.getJSONValue((Object)pSDBProcParamBase.getJdbcType()), (boolean)false);
        }
        if (bl || pSDBProcParamBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDBProcParamBase.getJSONValue((Object)pSDBProcParamBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDBProcParamBase.getParamDIR() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramdir", (Object)PSDBProcParamBase.getJSONValue((Object)pSDBProcParamBase.getParamDIR()), (boolean)false);
        }
        if (bl || pSDBProcParamBase.getPSDBProcParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbprocparamid", (Object)PSDBProcParamBase.getJSONValue((Object)pSDBProcParamBase.getPSDBProcParamId()), (boolean)false);
        }
        if (bl || pSDBProcParamBase.getPSDBProcParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbprocparamname", (Object)PSDBProcParamBase.getJSONValue((Object)pSDBProcParamBase.getPSDBProcParamName()), (boolean)false);
        }
        if (bl || pSDBProcParamBase.getPSDESPCodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdespcodeid", (Object)PSDBProcParamBase.getJSONValue((Object)pSDBProcParamBase.getPSDESPCodeId()), (boolean)false);
        }
        if (bl || pSDBProcParamBase.getPSDESPCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdespcodename", (Object)PSDBProcParamBase.getJSONValue((Object)pSDBProcParamBase.getPSDESPCodeName()), (boolean)false);
        }
        if (bl || pSDBProcParamBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDBProcParamBase.getJSONValue((Object)pSDBProcParamBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDBProcParamBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDBProcParamBase.getJSONValue((Object)pSDBProcParamBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDBProcParamBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDBProcParamBase pSDBProcParamBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDBProcParamBase.getCreateDate() != null) {
            object = pSDBProcParamBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDBProcParamBase.getCreateMan() != null) {
            object = pSDBProcParamBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDBProcParamBase.getJdbcType() != null) {
            object = pSDBProcParamBase.getJdbcType();
            xmlNode.setAttribute(FIELD_JDBCTYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDBProcParamBase.getOrderValue() != null) {
            object = pSDBProcParamBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDBProcParamBase.getParamDIR() != null) {
            object = pSDBProcParamBase.getParamDIR();
            xmlNode.setAttribute(FIELD_PARAMDIR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDBProcParamBase.getPSDBProcParamId() != null) {
            object = pSDBProcParamBase.getPSDBProcParamId();
            xmlNode.setAttribute(FIELD_PSDBPROCPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSDBProcParamBase.getPSDBProcParamName() != null) {
            object = pSDBProcParamBase.getPSDBProcParamName();
            xmlNode.setAttribute(FIELD_PSDBPROCPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBProcParamBase.getPSDESPCodeId() != null) {
            object = pSDBProcParamBase.getPSDESPCodeId();
            xmlNode.setAttribute(FIELD_PSDESPCODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDBProcParamBase.getPSDESPCodeName() != null) {
            object = pSDBProcParamBase.getPSDESPCodeName();
            xmlNode.setAttribute(FIELD_PSDESPCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBProcParamBase.getUpdateDate() != null) {
            object = pSDBProcParamBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDBProcParamBase.getUpdateMan() != null) {
            object = pSDBProcParamBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDBProcParamBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDBProcParamBase pSDBProcParamBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDBProcParamBase.isCreateDateDirty() && (bl || pSDBProcParamBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDBProcParamBase.getCreateDate());
        }
        if (pSDBProcParamBase.isCreateManDirty() && (bl || pSDBProcParamBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDBProcParamBase.getCreateMan());
        }
        if (pSDBProcParamBase.isJdbcTypeDirty() && (bl || pSDBProcParamBase.getJdbcType() != null)) {
            iDataObject.set(FIELD_JDBCTYPE, (Object)pSDBProcParamBase.getJdbcType());
        }
        if (pSDBProcParamBase.isOrderValueDirty() && (bl || pSDBProcParamBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDBProcParamBase.getOrderValue());
        }
        if (pSDBProcParamBase.isParamDIRDirty() && (bl || pSDBProcParamBase.getParamDIR() != null)) {
            iDataObject.set(FIELD_PARAMDIR, (Object)pSDBProcParamBase.getParamDIR());
        }
        if (pSDBProcParamBase.isPSDBProcParamIdDirty() && (bl || pSDBProcParamBase.getPSDBProcParamId() != null)) {
            iDataObject.set(FIELD_PSDBPROCPARAMID, (Object)pSDBProcParamBase.getPSDBProcParamId());
        }
        if (pSDBProcParamBase.isPSDBProcParamNameDirty() && (bl || pSDBProcParamBase.getPSDBProcParamName() != null)) {
            iDataObject.set(FIELD_PSDBPROCPARAMNAME, (Object)pSDBProcParamBase.getPSDBProcParamName());
        }
        if (pSDBProcParamBase.isPSDESPCodeIdDirty() && (bl || pSDBProcParamBase.getPSDESPCodeId() != null)) {
            iDataObject.set(FIELD_PSDESPCODEID, (Object)pSDBProcParamBase.getPSDESPCodeId());
        }
        if (pSDBProcParamBase.isPSDESPCodeNameDirty() && (bl || pSDBProcParamBase.getPSDESPCodeName() != null)) {
            iDataObject.set(FIELD_PSDESPCODENAME, (Object)pSDBProcParamBase.getPSDESPCodeName());
        }
        if (pSDBProcParamBase.isUpdateDateDirty() && (bl || pSDBProcParamBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDBProcParamBase.getUpdateDate());
        }
        if (pSDBProcParamBase.isUpdateManDirty() && (bl || pSDBProcParamBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDBProcParamBase.getUpdateMan());
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
        return PSDBProcParamBase.remove(this, n);
    }

    private static boolean remove(PSDBProcParamBase pSDBProcParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDBProcParamBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDBProcParamBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDBProcParamBase.resetJdbcType();
                return true;
            }
            case 3: {
                pSDBProcParamBase.resetOrderValue();
                return true;
            }
            case 4: {
                pSDBProcParamBase.resetParamDIR();
                return true;
            }
            case 5: {
                pSDBProcParamBase.resetPSDBProcParamId();
                return true;
            }
            case 6: {
                pSDBProcParamBase.resetPSDBProcParamName();
                return true;
            }
            case 7: {
                pSDBProcParamBase.resetPSDESPCodeId();
                return true;
            }
            case 8: {
                pSDBProcParamBase.resetPSDESPCodeName();
                return true;
            }
            case 9: {
                pSDBProcParamBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSDBProcParamBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDESPCode getPSDESPCode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDESPCode();
        }
        if (this.getPSDESPCodeId() == null) {
            return null;
        }
        Integer n = this.objPSDESPCodeLock;
        synchronized (n) {
            if (this.psdespcode != null && DataTypeHelper.compare((int)25, (Object)this.getPSDESPCodeId(), (Object)this.psdespcode.getPSDESPCodeId()) != 0L) {
                this.psdespcode = null;
            }
            if (this.psdespcode == null) {
                PSDESPCode pSDESPCode = new PSDESPCode();
                pSDESPCode.setPSDESPCodeId(this.getPSDESPCodeId());
                PSDESPCodeService pSDESPCodeService = (PSDESPCodeService)ServiceGlobal.getService(PSDESPCodeService.class, (SessionFactory)this.getSessionFactory());
                pSDESPCodeService.autoGet(pSDESPCode);
                this.psdespcode = pSDESPCode;
            }
            return this.psdespcode;
        }
    }

    private PSDBProcParamBase getProxyEntity() {
        return this.proxyPSDBProcParamBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDBProcParamBase = null;
        if (iDataObject != null && iDataObject instanceof PSDBProcParamBase) {
            this.proxyPSDBProcParamBase = (PSDBProcParamBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.def.service.PSDBProcParamService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_JDBCTYPE, 2);
        fieldIndexMap.put(FIELD_ORDERVALUE, 3);
        fieldIndexMap.put(FIELD_PARAMDIR, 4);
        fieldIndexMap.put(FIELD_PSDBPROCPARAMID, 5);
        fieldIndexMap.put(FIELD_PSDBPROCPARAMNAME, 6);
        fieldIndexMap.put(FIELD_PSDESPCODEID, 7);
        fieldIndexMap.put(FIELD_PSDESPCODENAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
    }
}

