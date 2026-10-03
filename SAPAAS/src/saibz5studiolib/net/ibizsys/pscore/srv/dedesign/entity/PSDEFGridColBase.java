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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFGridColBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEFGridColBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_GCMODE = "GCMODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEFGRIDCOLID = "PSDEFGRIDCOLID";
    public static final String FIELD_PSDEFGRIDCOLNAME = "PSDEFGRIDCOLNAME";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_WIDTH = "WIDTH";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_GCMODE = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDEFGRIDCOLID = 4;
    private static final int INDEX_PSDEFGRIDCOLNAME = 5;
    private static final int INDEX_PSDEFID = 6;
    private static final int INDEX_PSDEFNAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final int INDEX_USERPARAMS = 10;
    private static final int INDEX_WIDTH = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEFGridColBase proxyPSDEFGridColBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean gcmodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdefgridcolidDirtyFlag = false;
    private boolean psdefgridcolnameDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean widthDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="gcmode")
    private String gcmode;
    @Column(name="memo")
    private String memo;
    @Column(name="psdefgridcolid")
    private String psdefgridcolid;
    @Column(name="psdefgridcolname")
    private String psdefgridcolname;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userparams")
    private String userparams;
    @Column(name="width")
    private Integer width;
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;

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

    public void setGCMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGCMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gcmode = string;
        this.gcmodeDirtyFlag = true;
    }

    public String getGCMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGCMode();
        }
        return this.gcmode;
    }

    public boolean isGCModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGCModeDirty();
        }
        return this.gcmodeDirtyFlag;
    }

    public void resetGCMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGCMode();
            return;
        }
        this.gcmodeDirtyFlag = false;
        this.gcmode = null;
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

    public void setPSDEFGridColId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFGridColId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefgridcolid = string;
        this.psdefgridcolidDirtyFlag = true;
    }

    public String getPSDEFGridColId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFGridColId();
        }
        return this.psdefgridcolid;
    }

    public boolean isPSDEFGridColIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFGridColIdDirty();
        }
        return this.psdefgridcolidDirtyFlag;
    }

    public void resetPSDEFGridColId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFGridColId();
            return;
        }
        this.psdefgridcolidDirtyFlag = false;
        this.psdefgridcolid = null;
    }

    public void setPSDEFGridColName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFGridColName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefgridcolname = string;
        this.psdefgridcolnameDirtyFlag = true;
    }

    public String getPSDEFGridColName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFGridColName();
        }
        return this.psdefgridcolname;
    }

    public boolean isPSDEFGridColNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFGridColNameDirty();
        }
        return this.psdefgridcolnameDirtyFlag;
    }

    public void resetPSDEFGridColName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFGridColName();
            return;
        }
        this.psdefgridcolnameDirtyFlag = false;
        this.psdefgridcolname = null;
    }

    public void setPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefid = string;
        this.psdefidDirtyFlag = true;
    }

    public String getPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFId();
        }
        return this.psdefid;
    }

    public boolean isPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIdDirty();
        }
        return this.psdefidDirtyFlag;
    }

    public void resetPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFId();
            return;
        }
        this.psdefidDirtyFlag = false;
        this.psdefid = null;
    }

    public void setPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefname = string;
        this.psdefnameDirtyFlag = true;
    }

    public String getPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFName();
        }
        return this.psdefname;
    }

    public boolean isPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFNameDirty();
        }
        return this.psdefnameDirtyFlag;
    }

    public void resetPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFName();
            return;
        }
        this.psdefnameDirtyFlag = false;
        this.psdefname = null;
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

    public void setUserParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userparams = string;
        this.userparamsDirtyFlag = true;
    }

    public String getUserParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserParams();
        }
        return this.userparams;
    }

    public boolean isUserParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserParamsDirty();
        }
        return this.userparamsDirtyFlag;
    }

    public void resetUserParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserParams();
            return;
        }
        this.userparamsDirtyFlag = false;
        this.userparams = null;
    }

    public void setWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWidth(n);
            return;
        }
        this.width = n;
        this.widthDirtyFlag = true;
    }

    public Integer getWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWidth();
        }
        return this.width;
    }

    public boolean isWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWidthDirty();
        }
        return this.widthDirtyFlag;
    }

    public void resetWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWidth();
            return;
        }
        this.widthDirtyFlag = false;
        this.width = null;
    }

    protected void onReset() {
        PSDEFGridColBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEFGridColBase pSDEFGridColBase) {
        pSDEFGridColBase.resetCreateDate();
        pSDEFGridColBase.resetCreateMan();
        pSDEFGridColBase.resetGCMode();
        pSDEFGridColBase.resetMemo();
        pSDEFGridColBase.resetPSDEFGridColId();
        pSDEFGridColBase.resetPSDEFGridColName();
        pSDEFGridColBase.resetPSDEFId();
        pSDEFGridColBase.resetPSDEFName();
        pSDEFGridColBase.resetUpdateDate();
        pSDEFGridColBase.resetUpdateMan();
        pSDEFGridColBase.resetUserParams();
        pSDEFGridColBase.resetWidth();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isGCModeDirty()) {
            hashMap.put(FIELD_GCMODE, this.getGCMode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEFGridColIdDirty()) {
            hashMap.put(FIELD_PSDEFGRIDCOLID, this.getPSDEFGridColId());
        }
        if (!bl || this.isPSDEFGridColNameDirty()) {
            hashMap.put(FIELD_PSDEFGRIDCOLNAME, this.getPSDEFGridColName());
        }
        if (!bl || this.isPSDEFIdDirty()) {
            hashMap.put(FIELD_PSDEFID, this.getPSDEFId());
        }
        if (!bl || this.isPSDEFNameDirty()) {
            hashMap.put(FIELD_PSDEFNAME, this.getPSDEFName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
        }
        if (!bl || this.isWidthDirty()) {
            hashMap.put(FIELD_WIDTH, this.getWidth());
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
        return PSDEFGridColBase.get(this, n);
    }

    private static Object get(PSDEFGridColBase pSDEFGridColBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFGridColBase.getCreateDate();
            }
            case 1: {
                return pSDEFGridColBase.getCreateMan();
            }
            case 2: {
                return pSDEFGridColBase.getGCMode();
            }
            case 3: {
                return pSDEFGridColBase.getMemo();
            }
            case 4: {
                return pSDEFGridColBase.getPSDEFGridColId();
            }
            case 5: {
                return pSDEFGridColBase.getPSDEFGridColName();
            }
            case 6: {
                return pSDEFGridColBase.getPSDEFId();
            }
            case 7: {
                return pSDEFGridColBase.getPSDEFName();
            }
            case 8: {
                return pSDEFGridColBase.getUpdateDate();
            }
            case 9: {
                return pSDEFGridColBase.getUpdateMan();
            }
            case 10: {
                return pSDEFGridColBase.getUserParams();
            }
            case 11: {
                return pSDEFGridColBase.getWidth();
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
        PSDEFGridColBase.set(this, n, object);
    }

    private static void set(PSDEFGridColBase pSDEFGridColBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEFGridColBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEFGridColBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEFGridColBase.setGCMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEFGridColBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEFGridColBase.setPSDEFGridColId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEFGridColBase.setPSDEFGridColName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEFGridColBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEFGridColBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEFGridColBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDEFGridColBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEFGridColBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEFGridColBase.setWidth(DataObject.getIntegerValue((Object)object));
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
        return PSDEFGridColBase.isNull(this, n);
    }

    private static boolean isNull(PSDEFGridColBase pSDEFGridColBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFGridColBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEFGridColBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEFGridColBase.getGCMode() == null;
            }
            case 3: {
                return pSDEFGridColBase.getMemo() == null;
            }
            case 4: {
                return pSDEFGridColBase.getPSDEFGridColId() == null;
            }
            case 5: {
                return pSDEFGridColBase.getPSDEFGridColName() == null;
            }
            case 6: {
                return pSDEFGridColBase.getPSDEFId() == null;
            }
            case 7: {
                return pSDEFGridColBase.getPSDEFName() == null;
            }
            case 8: {
                return pSDEFGridColBase.getUpdateDate() == null;
            }
            case 9: {
                return pSDEFGridColBase.getUpdateMan() == null;
            }
            case 10: {
                return pSDEFGridColBase.getUserParams() == null;
            }
            case 11: {
                return pSDEFGridColBase.getWidth() == null;
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
        return PSDEFGridColBase.contains(this, n);
    }

    private static boolean contains(PSDEFGridColBase pSDEFGridColBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFGridColBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEFGridColBase.isCreateManDirty();
            }
            case 2: {
                return pSDEFGridColBase.isGCModeDirty();
            }
            case 3: {
                return pSDEFGridColBase.isMemoDirty();
            }
            case 4: {
                return pSDEFGridColBase.isPSDEFGridColIdDirty();
            }
            case 5: {
                return pSDEFGridColBase.isPSDEFGridColNameDirty();
            }
            case 6: {
                return pSDEFGridColBase.isPSDEFIdDirty();
            }
            case 7: {
                return pSDEFGridColBase.isPSDEFNameDirty();
            }
            case 8: {
                return pSDEFGridColBase.isUpdateDateDirty();
            }
            case 9: {
                return pSDEFGridColBase.isUpdateManDirty();
            }
            case 10: {
                return pSDEFGridColBase.isUserParamsDirty();
            }
            case 11: {
                return pSDEFGridColBase.isWidthDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEFGridColBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEFGridColBase pSDEFGridColBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEFGridColBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEFGridColBase.getJSONValue((Object)pSDEFGridColBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEFGridColBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEFGridColBase.getJSONValue((Object)pSDEFGridColBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEFGridColBase.getGCMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gcmode", (Object)PSDEFGridColBase.getJSONValue((Object)pSDEFGridColBase.getGCMode()), (boolean)false);
        }
        if (bl || pSDEFGridColBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEFGridColBase.getJSONValue((Object)pSDEFGridColBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEFGridColBase.getPSDEFGridColId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefgridcolid", (Object)PSDEFGridColBase.getJSONValue((Object)pSDEFGridColBase.getPSDEFGridColId()), (boolean)false);
        }
        if (bl || pSDEFGridColBase.getPSDEFGridColName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefgridcolname", (Object)PSDEFGridColBase.getJSONValue((Object)pSDEFGridColBase.getPSDEFGridColName()), (boolean)false);
        }
        if (bl || pSDEFGridColBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSDEFGridColBase.getJSONValue((Object)pSDEFGridColBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSDEFGridColBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSDEFGridColBase.getJSONValue((Object)pSDEFGridColBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSDEFGridColBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEFGridColBase.getJSONValue((Object)pSDEFGridColBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEFGridColBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEFGridColBase.getJSONValue((Object)pSDEFGridColBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEFGridColBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDEFGridColBase.getJSONValue((Object)pSDEFGridColBase.getUserParams()), (boolean)false);
        }
        if (bl || pSDEFGridColBase.getWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"width", (Object)PSDEFGridColBase.getJSONValue((Object)pSDEFGridColBase.getWidth()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEFGridColBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEFGridColBase pSDEFGridColBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEFGridColBase.getCreateDate() != null) {
            object = pSDEFGridColBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFGridColBase.getCreateMan() != null) {
            object = pSDEFGridColBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGridColBase.getGCMode() != null) {
            object = pSDEFGridColBase.getGCMode();
            xmlNode.setAttribute(FIELD_GCMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGridColBase.getMemo() != null) {
            object = pSDEFGridColBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGridColBase.getPSDEFGridColId() != null) {
            object = pSDEFGridColBase.getPSDEFGridColId();
            xmlNode.setAttribute(FIELD_PSDEFGRIDCOLID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGridColBase.getPSDEFGridColName() != null) {
            object = pSDEFGridColBase.getPSDEFGridColName();
            xmlNode.setAttribute(FIELD_PSDEFGRIDCOLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGridColBase.getPSDEFId() != null) {
            object = pSDEFGridColBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGridColBase.getPSDEFName() != null) {
            object = pSDEFGridColBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGridColBase.getUpdateDate() != null) {
            object = pSDEFGridColBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFGridColBase.getUpdateMan() != null) {
            object = pSDEFGridColBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGridColBase.getUserParams() != null) {
            object = pSDEFGridColBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEFGridColBase.getWidth() != null) {
            object = pSDEFGridColBase.getWidth();
            xmlNode.setAttribute(FIELD_WIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEFGridColBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEFGridColBase pSDEFGridColBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEFGridColBase.isCreateDateDirty() && (bl || pSDEFGridColBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEFGridColBase.getCreateDate());
        }
        if (pSDEFGridColBase.isCreateManDirty() && (bl || pSDEFGridColBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEFGridColBase.getCreateMan());
        }
        if (pSDEFGridColBase.isGCModeDirty() && (bl || pSDEFGridColBase.getGCMode() != null)) {
            iDataObject.set(FIELD_GCMODE, (Object)pSDEFGridColBase.getGCMode());
        }
        if (pSDEFGridColBase.isMemoDirty() && (bl || pSDEFGridColBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEFGridColBase.getMemo());
        }
        if (pSDEFGridColBase.isPSDEFGridColIdDirty() && (bl || pSDEFGridColBase.getPSDEFGridColId() != null)) {
            iDataObject.set(FIELD_PSDEFGRIDCOLID, (Object)pSDEFGridColBase.getPSDEFGridColId());
        }
        if (pSDEFGridColBase.isPSDEFGridColNameDirty() && (bl || pSDEFGridColBase.getPSDEFGridColName() != null)) {
            iDataObject.set(FIELD_PSDEFGRIDCOLNAME, (Object)pSDEFGridColBase.getPSDEFGridColName());
        }
        if (pSDEFGridColBase.isPSDEFIdDirty() && (bl || pSDEFGridColBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSDEFGridColBase.getPSDEFId());
        }
        if (pSDEFGridColBase.isPSDEFNameDirty() && (bl || pSDEFGridColBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSDEFGridColBase.getPSDEFName());
        }
        if (pSDEFGridColBase.isUpdateDateDirty() && (bl || pSDEFGridColBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEFGridColBase.getUpdateDate());
        }
        if (pSDEFGridColBase.isUpdateManDirty() && (bl || pSDEFGridColBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEFGridColBase.getUpdateMan());
        }
        if (pSDEFGridColBase.isUserParamsDirty() && (bl || pSDEFGridColBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDEFGridColBase.getUserParams());
        }
        if (pSDEFGridColBase.isWidthDirty() && (bl || pSDEFGridColBase.getWidth() != null)) {
            iDataObject.set(FIELD_WIDTH, (Object)pSDEFGridColBase.getWidth());
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
        return PSDEFGridColBase.remove(this, n);
    }

    private static boolean remove(PSDEFGridColBase pSDEFGridColBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEFGridColBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEFGridColBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEFGridColBase.resetGCMode();
                return true;
            }
            case 3: {
                pSDEFGridColBase.resetMemo();
                return true;
            }
            case 4: {
                pSDEFGridColBase.resetPSDEFGridColId();
                return true;
            }
            case 5: {
                pSDEFGridColBase.resetPSDEFGridColName();
                return true;
            }
            case 6: {
                pSDEFGridColBase.resetPSDEFId();
                return true;
            }
            case 7: {
                pSDEFGridColBase.resetPSDEFName();
                return true;
            }
            case 8: {
                pSDEFGridColBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSDEFGridColBase.resetUpdateMan();
                return true;
            }
            case 10: {
                pSDEFGridColBase.resetUserParams();
                return true;
            }
            case 11: {
                pSDEFGridColBase.resetWidth();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEF();
        }
        if (this.getPSDEFId() == null) {
            return null;
        }
        Integer n = this.objPSDEFLock;
        synchronized (n) {
            if (this.psdef != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFId(), (Object)this.psdef.getPSDEFieldId()) != 0L) {
                this.psdef = null;
            }
            if (this.psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.psdef = pSDEField;
            }
            return this.psdef;
        }
    }

    private PSDEFGridColBase getProxyEntity() {
        return this.proxyPSDEFGridColBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEFGridColBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEFGridColBase) {
            this.proxyPSDEFGridColBase = (PSDEFGridColBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFGridColService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_GCMODE, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDEFGRIDCOLID, 4);
        fieldIndexMap.put(FIELD_PSDEFGRIDCOLNAME, 5);
        fieldIndexMap.put(FIELD_PSDEFID, 6);
        fieldIndexMap.put(FIELD_PSDEFNAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
        fieldIndexMap.put(FIELD_USERPARAMS, 10);
        fieldIndexMap.put(FIELD_WIDTH, 11);
    }
}

