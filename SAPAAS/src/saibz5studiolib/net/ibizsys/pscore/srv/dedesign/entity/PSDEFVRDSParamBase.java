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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDSParam;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFValueRule;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDSParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFValueRuleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFVRDSParamBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEFVRDSParamBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDEDSPARAMID = "PSDEDSPARAMID";
    public static final String FIELD_PSDEDSPARAMNAME = "PSDEDSPARAMNAME";
    public static final String FIELD_PSDEFVRDSPARAMID = "PSDEFVRDSPARAMID";
    public static final String FIELD_PSDEFVRDSPARAMNAME = "PSDEFVRDSPARAMNAME";
    public static final String FIELD_PSDEFVRID = "PSDEFVRID";
    public static final String FIELD_PSDEFVRNAME = "PSDEFVRNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDEDSPARAMID = 2;
    private static final int INDEX_PSDEDSPARAMNAME = 3;
    private static final int INDEX_PSDEFVRDSPARAMID = 4;
    private static final int INDEX_PSDEFVRDSPARAMNAME = 5;
    private static final int INDEX_PSDEFVRID = 6;
    private static final int INDEX_PSDEFVRNAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEFVRDSParamBase proxyPSDEFVRDSParamBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdedsparamidDirtyFlag = false;
    private boolean psdedsparamnameDirtyFlag = false;
    private boolean psdefvrdsparamidDirtyFlag = false;
    private boolean psdefvrdsparamnameDirtyFlag = false;
    private boolean psdefvridDirtyFlag = false;
    private boolean psdefvrnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psdedsparamid")
    private String psdedsparamid;
    @Column(name="psdedsparamname")
    private String psdedsparamname;
    @Column(name="psdefvrdsparamid")
    private String psdefvrdsparamid;
    @Column(name="psdefvrdsparamname")
    private String psdefvrdsparamname;
    @Column(name="psdefvrid")
    private String psdefvrid;
    @Column(name="psdefvrname")
    private String psdefvrname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPsdedsparamLock = new Integer(1);
    private PSDEDSParam psdedsparam = null;
    private Integer objPSDEFVRLock = new Integer(1);
    private PSDEFValueRule psdefvr = null;

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

    public void setPSDEDSParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsparamid = string;
        this.psdedsparamidDirtyFlag = true;
    }

    public String getPSDEDSParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSParamId();
        }
        return this.psdedsparamid;
    }

    public boolean isPSDEDSParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSParamIdDirty();
        }
        return this.psdedsparamidDirtyFlag;
    }

    public void resetPSDEDSParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSParamId();
            return;
        }
        this.psdedsparamidDirtyFlag = false;
        this.psdedsparamid = null;
    }

    public void setPSDEDSParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedsparamname = string;
        this.psdedsparamnameDirtyFlag = true;
    }

    public String getPSDEDSParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSParamName();
        }
        return this.psdedsparamname;
    }

    public boolean isPSDEDSParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSParamNameDirty();
        }
        return this.psdedsparamnameDirtyFlag;
    }

    public void resetPSDEDSParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSParamName();
            return;
        }
        this.psdedsparamnameDirtyFlag = false;
        this.psdedsparamname = null;
    }

    public void setPSDEFVRDSParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFVRDSParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefvrdsparamid = string;
        this.psdefvrdsparamidDirtyFlag = true;
    }

    public String getPSDEFVRDSParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFVRDSParamId();
        }
        return this.psdefvrdsparamid;
    }

    public boolean isPSDEFVRDSParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFVRDSParamIdDirty();
        }
        return this.psdefvrdsparamidDirtyFlag;
    }

    public void resetPSDEFVRDSParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFVRDSParamId();
            return;
        }
        this.psdefvrdsparamidDirtyFlag = false;
        this.psdefvrdsparamid = null;
    }

    public void setPSDEFVRDSParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFVRDSParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefvrdsparamname = string;
        this.psdefvrdsparamnameDirtyFlag = true;
    }

    public String getPSDEFVRDSParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFVRDSParamName();
        }
        return this.psdefvrdsparamname;
    }

    public boolean isPSDEFVRDSParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFVRDSParamNameDirty();
        }
        return this.psdefvrdsparamnameDirtyFlag;
    }

    public void resetPSDEFVRDSParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFVRDSParamName();
            return;
        }
        this.psdefvrdsparamnameDirtyFlag = false;
        this.psdefvrdsparamname = null;
    }

    public void setPSDEFVRID(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFVRID(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefvrid = string;
        this.psdefvridDirtyFlag = true;
    }

    public String getPSDEFVRID() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFVRID();
        }
        return this.psdefvrid;
    }

    public boolean isPSDEFVRIDDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFVRIDDirty();
        }
        return this.psdefvridDirtyFlag;
    }

    public void resetPSDEFVRID() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFVRID();
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
        PSDEFVRDSParamBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEFVRDSParamBase pSDEFVRDSParamBase) {
        pSDEFVRDSParamBase.resetCreateDate();
        pSDEFVRDSParamBase.resetCreateMan();
        pSDEFVRDSParamBase.resetPSDEDSParamId();
        pSDEFVRDSParamBase.resetPSDEDSParamName();
        pSDEFVRDSParamBase.resetPSDEFVRDSParamId();
        pSDEFVRDSParamBase.resetPSDEFVRDSParamName();
        pSDEFVRDSParamBase.resetPSDEFVRID();
        pSDEFVRDSParamBase.resetPSDEFVRName();
        pSDEFVRDSParamBase.resetUpdateDate();
        pSDEFVRDSParamBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSDEDSParamIdDirty()) {
            hashMap.put(FIELD_PSDEDSPARAMID, this.getPSDEDSParamId());
        }
        if (!bl || this.isPSDEDSParamNameDirty()) {
            hashMap.put(FIELD_PSDEDSPARAMNAME, this.getPSDEDSParamName());
        }
        if (!bl || this.isPSDEFVRDSParamIdDirty()) {
            hashMap.put(FIELD_PSDEFVRDSPARAMID, this.getPSDEFVRDSParamId());
        }
        if (!bl || this.isPSDEFVRDSParamNameDirty()) {
            hashMap.put(FIELD_PSDEFVRDSPARAMNAME, this.getPSDEFVRDSParamName());
        }
        if (!bl || this.isPSDEFVRIDDirty()) {
            hashMap.put(FIELD_PSDEFVRID, this.getPSDEFVRID());
        }
        if (!bl || this.isPSDEFVRNameDirty()) {
            hashMap.put(FIELD_PSDEFVRNAME, this.getPSDEFVRName());
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
        return PSDEFVRDSParamBase.get(this, n);
    }

    private static Object get(PSDEFVRDSParamBase pSDEFVRDSParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFVRDSParamBase.getCreateDate();
            }
            case 1: {
                return pSDEFVRDSParamBase.getCreateMan();
            }
            case 2: {
                return pSDEFVRDSParamBase.getPSDEDSParamId();
            }
            case 3: {
                return pSDEFVRDSParamBase.getPSDEDSParamName();
            }
            case 4: {
                return pSDEFVRDSParamBase.getPSDEFVRDSParamId();
            }
            case 5: {
                return pSDEFVRDSParamBase.getPSDEFVRDSParamName();
            }
            case 6: {
                return pSDEFVRDSParamBase.getPSDEFVRID();
            }
            case 7: {
                return pSDEFVRDSParamBase.getPSDEFVRName();
            }
            case 8: {
                return pSDEFVRDSParamBase.getUpdateDate();
            }
            case 9: {
                return pSDEFVRDSParamBase.getUpdateMan();
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
        PSDEFVRDSParamBase.set(this, n, object);
    }

    private static void set(PSDEFVRDSParamBase pSDEFVRDSParamBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEFVRDSParamBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEFVRDSParamBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEFVRDSParamBase.setPSDEDSParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEFVRDSParamBase.setPSDEDSParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEFVRDSParamBase.setPSDEFVRDSParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEFVRDSParamBase.setPSDEFVRDSParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEFVRDSParamBase.setPSDEFVRID(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEFVRDSParamBase.setPSDEFVRName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEFVRDSParamBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDEFVRDSParamBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDEFVRDSParamBase.isNull(this, n);
    }

    private static boolean isNull(PSDEFVRDSParamBase pSDEFVRDSParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFVRDSParamBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEFVRDSParamBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEFVRDSParamBase.getPSDEDSParamId() == null;
            }
            case 3: {
                return pSDEFVRDSParamBase.getPSDEDSParamName() == null;
            }
            case 4: {
                return pSDEFVRDSParamBase.getPSDEFVRDSParamId() == null;
            }
            case 5: {
                return pSDEFVRDSParamBase.getPSDEFVRDSParamName() == null;
            }
            case 6: {
                return pSDEFVRDSParamBase.getPSDEFVRID() == null;
            }
            case 7: {
                return pSDEFVRDSParamBase.getPSDEFVRName() == null;
            }
            case 8: {
                return pSDEFVRDSParamBase.getUpdateDate() == null;
            }
            case 9: {
                return pSDEFVRDSParamBase.getUpdateMan() == null;
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
        return PSDEFVRDSParamBase.contains(this, n);
    }

    private static boolean contains(PSDEFVRDSParamBase pSDEFVRDSParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFVRDSParamBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEFVRDSParamBase.isCreateManDirty();
            }
            case 2: {
                return pSDEFVRDSParamBase.isPSDEDSParamIdDirty();
            }
            case 3: {
                return pSDEFVRDSParamBase.isPSDEDSParamNameDirty();
            }
            case 4: {
                return pSDEFVRDSParamBase.isPSDEFVRDSParamIdDirty();
            }
            case 5: {
                return pSDEFVRDSParamBase.isPSDEFVRDSParamNameDirty();
            }
            case 6: {
                return pSDEFVRDSParamBase.isPSDEFVRIDDirty();
            }
            case 7: {
                return pSDEFVRDSParamBase.isPSDEFVRNameDirty();
            }
            case 8: {
                return pSDEFVRDSParamBase.isUpdateDateDirty();
            }
            case 9: {
                return pSDEFVRDSParamBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEFVRDSParamBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEFVRDSParamBase pSDEFVRDSParamBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEFVRDSParamBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEFVRDSParamBase.getJSONValue((Object)pSDEFVRDSParamBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEFVRDSParamBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEFVRDSParamBase.getJSONValue((Object)pSDEFVRDSParamBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEFVRDSParamBase.getPSDEDSParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsparamid", (Object)PSDEFVRDSParamBase.getJSONValue((Object)pSDEFVRDSParamBase.getPSDEDSParamId()), (boolean)false);
        }
        if (bl || pSDEFVRDSParamBase.getPSDEDSParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedsparamname", (Object)PSDEFVRDSParamBase.getJSONValue((Object)pSDEFVRDSParamBase.getPSDEDSParamName()), (boolean)false);
        }
        if (bl || pSDEFVRDSParamBase.getPSDEFVRDSParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvrdsparamid", (Object)PSDEFVRDSParamBase.getJSONValue((Object)pSDEFVRDSParamBase.getPSDEFVRDSParamId()), (boolean)false);
        }
        if (bl || pSDEFVRDSParamBase.getPSDEFVRDSParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvrdsparamname", (Object)PSDEFVRDSParamBase.getJSONValue((Object)pSDEFVRDSParamBase.getPSDEFVRDSParamName()), (boolean)false);
        }
        if (bl || pSDEFVRDSParamBase.getPSDEFVRID() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvrid", (Object)PSDEFVRDSParamBase.getJSONValue((Object)pSDEFVRDSParamBase.getPSDEFVRID()), (boolean)false);
        }
        if (bl || pSDEFVRDSParamBase.getPSDEFVRName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefvrname", (Object)PSDEFVRDSParamBase.getJSONValue((Object)pSDEFVRDSParamBase.getPSDEFVRName()), (boolean)false);
        }
        if (bl || pSDEFVRDSParamBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEFVRDSParamBase.getJSONValue((Object)pSDEFVRDSParamBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEFVRDSParamBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEFVRDSParamBase.getJSONValue((Object)pSDEFVRDSParamBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEFVRDSParamBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEFVRDSParamBase pSDEFVRDSParamBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEFVRDSParamBase.getCreateDate() != null) {
            object = pSDEFVRDSParamBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFVRDSParamBase.getCreateMan() != null) {
            object = pSDEFVRDSParamBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRDSParamBase.getPSDEDSParamId() != null) {
            object = pSDEFVRDSParamBase.getPSDEDSParamId();
            xmlNode.setAttribute(FIELD_PSDEDSPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRDSParamBase.getPSDEDSParamName() != null) {
            object = pSDEFVRDSParamBase.getPSDEDSParamName();
            xmlNode.setAttribute(FIELD_PSDEDSPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRDSParamBase.getPSDEFVRDSParamId() != null) {
            object = pSDEFVRDSParamBase.getPSDEFVRDSParamId();
            xmlNode.setAttribute(FIELD_PSDEFVRDSPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRDSParamBase.getPSDEFVRDSParamName() != null) {
            object = pSDEFVRDSParamBase.getPSDEFVRDSParamName();
            xmlNode.setAttribute(FIELD_PSDEFVRDSPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRDSParamBase.getPSDEFVRID() != null) {
            object = pSDEFVRDSParamBase.getPSDEFVRID();
            xmlNode.setAttribute(FIELD_PSDEFVRID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRDSParamBase.getPSDEFVRName() != null) {
            object = pSDEFVRDSParamBase.getPSDEFVRName();
            xmlNode.setAttribute(FIELD_PSDEFVRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFVRDSParamBase.getUpdateDate() != null) {
            object = pSDEFVRDSParamBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFVRDSParamBase.getUpdateMan() != null) {
            object = pSDEFVRDSParamBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEFVRDSParamBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEFVRDSParamBase pSDEFVRDSParamBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEFVRDSParamBase.isCreateDateDirty() && (bl || pSDEFVRDSParamBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEFVRDSParamBase.getCreateDate());
        }
        if (pSDEFVRDSParamBase.isCreateManDirty() && (bl || pSDEFVRDSParamBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEFVRDSParamBase.getCreateMan());
        }
        if (pSDEFVRDSParamBase.isPSDEDSParamIdDirty() && (bl || pSDEFVRDSParamBase.getPSDEDSParamId() != null)) {
            iDataObject.set(FIELD_PSDEDSPARAMID, (Object)pSDEFVRDSParamBase.getPSDEDSParamId());
        }
        if (pSDEFVRDSParamBase.isPSDEDSParamNameDirty() && (bl || pSDEFVRDSParamBase.getPSDEDSParamName() != null)) {
            iDataObject.set(FIELD_PSDEDSPARAMNAME, (Object)pSDEFVRDSParamBase.getPSDEDSParamName());
        }
        if (pSDEFVRDSParamBase.isPSDEFVRDSParamIdDirty() && (bl || pSDEFVRDSParamBase.getPSDEFVRDSParamId() != null)) {
            iDataObject.set(FIELD_PSDEFVRDSPARAMID, (Object)pSDEFVRDSParamBase.getPSDEFVRDSParamId());
        }
        if (pSDEFVRDSParamBase.isPSDEFVRDSParamNameDirty() && (bl || pSDEFVRDSParamBase.getPSDEFVRDSParamName() != null)) {
            iDataObject.set(FIELD_PSDEFVRDSPARAMNAME, (Object)pSDEFVRDSParamBase.getPSDEFVRDSParamName());
        }
        if (pSDEFVRDSParamBase.isPSDEFVRIDDirty() && (bl || pSDEFVRDSParamBase.getPSDEFVRID() != null)) {
            iDataObject.set(FIELD_PSDEFVRID, (Object)pSDEFVRDSParamBase.getPSDEFVRID());
        }
        if (pSDEFVRDSParamBase.isPSDEFVRNameDirty() && (bl || pSDEFVRDSParamBase.getPSDEFVRName() != null)) {
            iDataObject.set(FIELD_PSDEFVRNAME, (Object)pSDEFVRDSParamBase.getPSDEFVRName());
        }
        if (pSDEFVRDSParamBase.isUpdateDateDirty() && (bl || pSDEFVRDSParamBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEFVRDSParamBase.getUpdateDate());
        }
        if (pSDEFVRDSParamBase.isUpdateManDirty() && (bl || pSDEFVRDSParamBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEFVRDSParamBase.getUpdateMan());
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
        return PSDEFVRDSParamBase.remove(this, n);
    }

    private static boolean remove(PSDEFVRDSParamBase pSDEFVRDSParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEFVRDSParamBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEFVRDSParamBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEFVRDSParamBase.resetPSDEDSParamId();
                return true;
            }
            case 3: {
                pSDEFVRDSParamBase.resetPSDEDSParamName();
                return true;
            }
            case 4: {
                pSDEFVRDSParamBase.resetPSDEFVRDSParamId();
                return true;
            }
            case 5: {
                pSDEFVRDSParamBase.resetPSDEFVRDSParamName();
                return true;
            }
            case 6: {
                pSDEFVRDSParamBase.resetPSDEFVRID();
                return true;
            }
            case 7: {
                pSDEFVRDSParamBase.resetPSDEFVRName();
                return true;
            }
            case 8: {
                pSDEFVRDSParamBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSDEFVRDSParamBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDSParam getPsdedsparam() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPsdedsparam();
        }
        if (this.getPSDEDSParamId() == null) {
            return null;
        }
        Integer n = this.objPsdedsparamLock;
        synchronized (n) {
            if (this.psdedsparam != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDSParamId(), (Object)this.psdedsparam.getPSDEDSParamId()) != 0L) {
                this.psdedsparam = null;
            }
            if (this.psdedsparam == null) {
                PSDEDSParam pSDEDSParam = new PSDEDSParam();
                pSDEDSParam.setPSDEDSParamId(this.getPSDEDSParamId());
                PSDEDSParamService pSDEDSParamService = (PSDEDSParamService)ServiceGlobal.getService(PSDEDSParamService.class, (SessionFactory)this.getSessionFactory());
                pSDEDSParamService.autoGet(pSDEDSParam);
                this.psdedsparam = pSDEDSParam;
            }
            return this.psdedsparam;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFValueRule getPSDEFVR() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFVR();
        }
        if (this.getPSDEFVRID() == null) {
            return null;
        }
        Integer n = this.objPSDEFVRLock;
        synchronized (n) {
            if (this.psdefvr != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFVRID(), (Object)this.psdefvr.getPSDEFValueRuleId()) != 0L) {
                this.psdefvr = null;
            }
            if (this.psdefvr == null) {
                PSDEFValueRule pSDEFValueRule = new PSDEFValueRule();
                pSDEFValueRule.setPSDEFValueRuleId(this.getPSDEFVRID());
                PSDEFValueRuleService pSDEFValueRuleService = (PSDEFValueRuleService)ServiceGlobal.getService(PSDEFValueRuleService.class, (SessionFactory)this.getSessionFactory());
                pSDEFValueRuleService.autoGet(pSDEFValueRule);
                this.psdefvr = pSDEFValueRule;
            }
            return this.psdefvr;
        }
    }

    private PSDEFVRDSParamBase getProxyEntity() {
        return this.proxyPSDEFVRDSParamBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEFVRDSParamBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEFVRDSParamBase) {
            this.proxyPSDEFVRDSParamBase = (PSDEFVRDSParamBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFVRDSParamService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDEDSPARAMID, 2);
        fieldIndexMap.put(FIELD_PSDEDSPARAMNAME, 3);
        fieldIndexMap.put(FIELD_PSDEFVRDSPARAMID, 4);
        fieldIndexMap.put(FIELD_PSDEFVRDSPARAMNAME, 5);
        fieldIndexMap.put(FIELD_PSDEFVRID, 6);
        fieldIndexMap.put(FIELD_PSDEFVRNAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
    }
}

