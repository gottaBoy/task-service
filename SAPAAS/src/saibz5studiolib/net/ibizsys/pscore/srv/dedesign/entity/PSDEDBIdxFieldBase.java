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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDBIndex;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDBIndexService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDBIdxFieldBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEDBIdxFieldBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_INCMODE = "INCMODE";
    public static final String FIELD_INDEXLENGTH = "INDEXLENGTH";
    public static final String FIELD_PSDEDBIDXFIELDID = "PSDEDBIDXFIELDID";
    public static final String FIELD_PSDEDBIDXFIELDNAME = "PSDEDBIDXFIELDNAME";
    public static final String FIELD_PSDEDBINDEXID = "PSDEDBINDEXID";
    public static final String FIELD_PSDEDBINDEXNAME = "PSDEDBINDEXNAME";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_SORTDIR = "SORTDIR";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_INCMODE = 2;
    private static final int INDEX_INDEXLENGTH = 3;
    private static final int INDEX_PSDEDBIDXFIELDID = 4;
    private static final int INDEX_PSDEDBIDXFIELDNAME = 5;
    private static final int INDEX_PSDEDBINDEXID = 6;
    private static final int INDEX_PSDEDBINDEXNAME = 7;
    private static final int INDEX_PSDEFID = 8;
    private static final int INDEX_PSDEFNAME = 9;
    private static final int INDEX_PSDEID = 10;
    private static final int INDEX_SORTDIR = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEDBIdxFieldBase proxyPSDEDBIdxFieldBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean incmodeDirtyFlag = false;
    private boolean indexlengthDirtyFlag = false;
    private boolean psdedbidxfieldidDirtyFlag = false;
    private boolean psdedbidxfieldnameDirtyFlag = false;
    private boolean psdedbindexidDirtyFlag = false;
    private boolean psdedbindexnameDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean sortdirDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="incmode")
    private Integer incmode;
    @Column(name="indexlength")
    private Integer indexlength;
    @Column(name="psdedbidxfieldid")
    private String psdedbidxfieldid;
    @Column(name="psdedbidxfieldname")
    private String psdedbidxfieldname;
    @Column(name="psdedbindexid")
    private String psdedbindexid;
    @Column(name="psdedbindexname")
    private String psdedbindexname;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="sortdir")
    private String sortdir;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDEDBIndexLock = new Integer(1);
    private PSDEDBIndex psdedbindex = null;
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

    public void setIncMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIncMode(n);
            return;
        }
        this.incmode = n;
        this.incmodeDirtyFlag = true;
    }

    public Integer getIncMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIncMode();
        }
        return this.incmode;
    }

    public boolean isIncModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIncModeDirty();
        }
        return this.incmodeDirtyFlag;
    }

    public void resetIncMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIncMode();
            return;
        }
        this.incmodeDirtyFlag = false;
        this.incmode = null;
    }

    public void setIndexLength(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIndexLength(n);
            return;
        }
        this.indexlength = n;
        this.indexlengthDirtyFlag = true;
    }

    public Integer getIndexLength() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIndexLength();
        }
        return this.indexlength;
    }

    public boolean isIndexLengthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIndexLengthDirty();
        }
        return this.indexlengthDirtyFlag;
    }

    public void resetIndexLength() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIndexLength();
            return;
        }
        this.indexlengthDirtyFlag = false;
        this.indexlength = null;
    }

    public void setPSDEDBIdxFieldId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDBIdxFieldId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedbidxfieldid = string;
        this.psdedbidxfieldidDirtyFlag = true;
    }

    public String getPSDEDBIdxFieldId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDBIdxFieldId();
        }
        return this.psdedbidxfieldid;
    }

    public boolean isPSDEDBIdxFieldIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDBIdxFieldIdDirty();
        }
        return this.psdedbidxfieldidDirtyFlag;
    }

    public void resetPSDEDBIdxFieldId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDBIdxFieldId();
            return;
        }
        this.psdedbidxfieldidDirtyFlag = false;
        this.psdedbidxfieldid = null;
    }

    public void setPSDEDBIdxFieldName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDBIdxFieldName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedbidxfieldname = string;
        this.psdedbidxfieldnameDirtyFlag = true;
    }

    public String getPSDEDBIdxFieldName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDBIdxFieldName();
        }
        return this.psdedbidxfieldname;
    }

    public boolean isPSDEDBIdxFieldNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDBIdxFieldNameDirty();
        }
        return this.psdedbidxfieldnameDirtyFlag;
    }

    public void resetPSDEDBIdxFieldName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDBIdxFieldName();
            return;
        }
        this.psdedbidxfieldnameDirtyFlag = false;
        this.psdedbidxfieldname = null;
    }

    public void setPSDEDBIndexId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDBIndexId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedbindexid = string;
        this.psdedbindexidDirtyFlag = true;
    }

    public String getPSDEDBIndexId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDBIndexId();
        }
        return this.psdedbindexid;
    }

    public boolean isPSDEDBIndexIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDBIndexIdDirty();
        }
        return this.psdedbindexidDirtyFlag;
    }

    public void resetPSDEDBIndexId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDBIndexId();
            return;
        }
        this.psdedbindexidDirtyFlag = false;
        this.psdedbindexid = null;
    }

    public void setPSDEDBIndexName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDBIndexName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedbindexname = string;
        this.psdedbindexnameDirtyFlag = true;
    }

    public String getPSDEDBIndexName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDBIndexName();
        }
        return this.psdedbindexname;
    }

    public boolean isPSDEDBIndexNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDBIndexNameDirty();
        }
        return this.psdedbindexnameDirtyFlag;
    }

    public void resetPSDEDBIndexName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDBIndexName();
            return;
        }
        this.psdedbindexnameDirtyFlag = false;
        this.psdedbindexname = null;
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

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
    }

    public void setSortDir(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSortDir(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sortdir = string;
        this.sortdirDirtyFlag = true;
    }

    public String getSortDir() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSortDir();
        }
        return this.sortdir;
    }

    public boolean isSortDirDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSortDirDirty();
        }
        return this.sortdirDirtyFlag;
    }

    public void resetSortDir() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSortDir();
            return;
        }
        this.sortdirDirtyFlag = false;
        this.sortdir = null;
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
        PSDEDBIdxFieldBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEDBIdxFieldBase pSDEDBIdxFieldBase) {
        pSDEDBIdxFieldBase.resetCreateDate();
        pSDEDBIdxFieldBase.resetCreateMan();
        pSDEDBIdxFieldBase.resetIncMode();
        pSDEDBIdxFieldBase.resetIndexLength();
        pSDEDBIdxFieldBase.resetPSDEDBIdxFieldId();
        pSDEDBIdxFieldBase.resetPSDEDBIdxFieldName();
        pSDEDBIdxFieldBase.resetPSDEDBIndexId();
        pSDEDBIdxFieldBase.resetPSDEDBIndexName();
        pSDEDBIdxFieldBase.resetPSDEFId();
        pSDEDBIdxFieldBase.resetPSDEFName();
        pSDEDBIdxFieldBase.resetPSDEId();
        pSDEDBIdxFieldBase.resetSortDir();
        pSDEDBIdxFieldBase.resetUpdateDate();
        pSDEDBIdxFieldBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isIncModeDirty()) {
            hashMap.put(FIELD_INCMODE, this.getIncMode());
        }
        if (!bl || this.isIndexLengthDirty()) {
            hashMap.put(FIELD_INDEXLENGTH, this.getIndexLength());
        }
        if (!bl || this.isPSDEDBIdxFieldIdDirty()) {
            hashMap.put(FIELD_PSDEDBIDXFIELDID, this.getPSDEDBIdxFieldId());
        }
        if (!bl || this.isPSDEDBIdxFieldNameDirty()) {
            hashMap.put(FIELD_PSDEDBIDXFIELDNAME, this.getPSDEDBIdxFieldName());
        }
        if (!bl || this.isPSDEDBIndexIdDirty()) {
            hashMap.put(FIELD_PSDEDBINDEXID, this.getPSDEDBIndexId());
        }
        if (!bl || this.isPSDEDBIndexNameDirty()) {
            hashMap.put(FIELD_PSDEDBINDEXNAME, this.getPSDEDBIndexName());
        }
        if (!bl || this.isPSDEFIdDirty()) {
            hashMap.put(FIELD_PSDEFID, this.getPSDEFId());
        }
        if (!bl || this.isPSDEFNameDirty()) {
            hashMap.put(FIELD_PSDEFNAME, this.getPSDEFName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isSortDirDirty()) {
            hashMap.put(FIELD_SORTDIR, this.getSortDir());
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
        return PSDEDBIdxFieldBase.get(this, n);
    }

    private static Object get(PSDEDBIdxFieldBase pSDEDBIdxFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDBIdxFieldBase.getCreateDate();
            }
            case 1: {
                return pSDEDBIdxFieldBase.getCreateMan();
            }
            case 2: {
                return pSDEDBIdxFieldBase.getIncMode();
            }
            case 3: {
                return pSDEDBIdxFieldBase.getIndexLength();
            }
            case 4: {
                return pSDEDBIdxFieldBase.getPSDEDBIdxFieldId();
            }
            case 5: {
                return pSDEDBIdxFieldBase.getPSDEDBIdxFieldName();
            }
            case 6: {
                return pSDEDBIdxFieldBase.getPSDEDBIndexId();
            }
            case 7: {
                return pSDEDBIdxFieldBase.getPSDEDBIndexName();
            }
            case 8: {
                return pSDEDBIdxFieldBase.getPSDEFId();
            }
            case 9: {
                return pSDEDBIdxFieldBase.getPSDEFName();
            }
            case 10: {
                return pSDEDBIdxFieldBase.getPSDEId();
            }
            case 11: {
                return pSDEDBIdxFieldBase.getSortDir();
            }
            case 12: {
                return pSDEDBIdxFieldBase.getUpdateDate();
            }
            case 13: {
                return pSDEDBIdxFieldBase.getUpdateMan();
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
        PSDEDBIdxFieldBase.set(this, n, object);
    }

    private static void set(PSDEDBIdxFieldBase pSDEDBIdxFieldBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEDBIdxFieldBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEDBIdxFieldBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEDBIdxFieldBase.setIncMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDEDBIdxFieldBase.setIndexLength(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDEDBIdxFieldBase.setPSDEDBIdxFieldId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEDBIdxFieldBase.setPSDEDBIdxFieldName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEDBIdxFieldBase.setPSDEDBIndexId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEDBIdxFieldBase.setPSDEDBIndexName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEDBIdxFieldBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEDBIdxFieldBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEDBIdxFieldBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEDBIdxFieldBase.setSortDir(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEDBIdxFieldBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSDEDBIdxFieldBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDEDBIdxFieldBase.isNull(this, n);
    }

    private static boolean isNull(PSDEDBIdxFieldBase pSDEDBIdxFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDBIdxFieldBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEDBIdxFieldBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEDBIdxFieldBase.getIncMode() == null;
            }
            case 3: {
                return pSDEDBIdxFieldBase.getIndexLength() == null;
            }
            case 4: {
                return pSDEDBIdxFieldBase.getPSDEDBIdxFieldId() == null;
            }
            case 5: {
                return pSDEDBIdxFieldBase.getPSDEDBIdxFieldName() == null;
            }
            case 6: {
                return pSDEDBIdxFieldBase.getPSDEDBIndexId() == null;
            }
            case 7: {
                return pSDEDBIdxFieldBase.getPSDEDBIndexName() == null;
            }
            case 8: {
                return pSDEDBIdxFieldBase.getPSDEFId() == null;
            }
            case 9: {
                return pSDEDBIdxFieldBase.getPSDEFName() == null;
            }
            case 10: {
                return pSDEDBIdxFieldBase.getPSDEId() == null;
            }
            case 11: {
                return pSDEDBIdxFieldBase.getSortDir() == null;
            }
            case 12: {
                return pSDEDBIdxFieldBase.getUpdateDate() == null;
            }
            case 13: {
                return pSDEDBIdxFieldBase.getUpdateMan() == null;
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
        return PSDEDBIdxFieldBase.contains(this, n);
    }

    private static boolean contains(PSDEDBIdxFieldBase pSDEDBIdxFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDBIdxFieldBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEDBIdxFieldBase.isCreateManDirty();
            }
            case 2: {
                return pSDEDBIdxFieldBase.isIncModeDirty();
            }
            case 3: {
                return pSDEDBIdxFieldBase.isIndexLengthDirty();
            }
            case 4: {
                return pSDEDBIdxFieldBase.isPSDEDBIdxFieldIdDirty();
            }
            case 5: {
                return pSDEDBIdxFieldBase.isPSDEDBIdxFieldNameDirty();
            }
            case 6: {
                return pSDEDBIdxFieldBase.isPSDEDBIndexIdDirty();
            }
            case 7: {
                return pSDEDBIdxFieldBase.isPSDEDBIndexNameDirty();
            }
            case 8: {
                return pSDEDBIdxFieldBase.isPSDEFIdDirty();
            }
            case 9: {
                return pSDEDBIdxFieldBase.isPSDEFNameDirty();
            }
            case 10: {
                return pSDEDBIdxFieldBase.isPSDEIdDirty();
            }
            case 11: {
                return pSDEDBIdxFieldBase.isSortDirDirty();
            }
            case 12: {
                return pSDEDBIdxFieldBase.isUpdateDateDirty();
            }
            case 13: {
                return pSDEDBIdxFieldBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEDBIdxFieldBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEDBIdxFieldBase pSDEDBIdxFieldBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEDBIdxFieldBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEDBIdxFieldBase.getJSONValue((Object)pSDEDBIdxFieldBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEDBIdxFieldBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEDBIdxFieldBase.getJSONValue((Object)pSDEDBIdxFieldBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEDBIdxFieldBase.getIncMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"incmode", (Object)PSDEDBIdxFieldBase.getJSONValue((Object)pSDEDBIdxFieldBase.getIncMode()), (boolean)false);
        }
        if (bl || pSDEDBIdxFieldBase.getIndexLength() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"indexlength", (Object)PSDEDBIdxFieldBase.getJSONValue((Object)pSDEDBIdxFieldBase.getIndexLength()), (boolean)false);
        }
        if (bl || pSDEDBIdxFieldBase.getPSDEDBIdxFieldId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedbidxfieldid", (Object)PSDEDBIdxFieldBase.getJSONValue((Object)pSDEDBIdxFieldBase.getPSDEDBIdxFieldId()), (boolean)false);
        }
        if (bl || pSDEDBIdxFieldBase.getPSDEDBIdxFieldName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedbidxfieldname", (Object)PSDEDBIdxFieldBase.getJSONValue((Object)pSDEDBIdxFieldBase.getPSDEDBIdxFieldName()), (boolean)false);
        }
        if (bl || pSDEDBIdxFieldBase.getPSDEDBIndexId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedbindexid", (Object)PSDEDBIdxFieldBase.getJSONValue((Object)pSDEDBIdxFieldBase.getPSDEDBIndexId()), (boolean)false);
        }
        if (bl || pSDEDBIdxFieldBase.getPSDEDBIndexName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedbindexname", (Object)PSDEDBIdxFieldBase.getJSONValue((Object)pSDEDBIdxFieldBase.getPSDEDBIndexName()), (boolean)false);
        }
        if (bl || pSDEDBIdxFieldBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSDEDBIdxFieldBase.getJSONValue((Object)pSDEDBIdxFieldBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSDEDBIdxFieldBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSDEDBIdxFieldBase.getJSONValue((Object)pSDEDBIdxFieldBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSDEDBIdxFieldBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEDBIdxFieldBase.getJSONValue((Object)pSDEDBIdxFieldBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEDBIdxFieldBase.getSortDir() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sortdir", (Object)PSDEDBIdxFieldBase.getJSONValue((Object)pSDEDBIdxFieldBase.getSortDir()), (boolean)false);
        }
        if (bl || pSDEDBIdxFieldBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEDBIdxFieldBase.getJSONValue((Object)pSDEDBIdxFieldBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEDBIdxFieldBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEDBIdxFieldBase.getJSONValue((Object)pSDEDBIdxFieldBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEDBIdxFieldBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEDBIdxFieldBase pSDEDBIdxFieldBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEDBIdxFieldBase.getCreateDate() != null) {
            object = pSDEDBIdxFieldBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDBIdxFieldBase.getCreateMan() != null) {
            object = pSDEDBIdxFieldBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBIdxFieldBase.getIncMode() != null) {
            object = pSDEDBIdxFieldBase.getIncMode();
            xmlNode.setAttribute(FIELD_INCMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDBIdxFieldBase.getIndexLength() != null) {
            object = pSDEDBIdxFieldBase.getIndexLength();
            xmlNode.setAttribute(FIELD_INDEXLENGTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEDBIdxFieldBase.getPSDEDBIdxFieldId() != null) {
            object = pSDEDBIdxFieldBase.getPSDEDBIdxFieldId();
            xmlNode.setAttribute(FIELD_PSDEDBIDXFIELDID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBIdxFieldBase.getPSDEDBIdxFieldName() != null) {
            object = pSDEDBIdxFieldBase.getPSDEDBIdxFieldName();
            xmlNode.setAttribute(FIELD_PSDEDBIDXFIELDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBIdxFieldBase.getPSDEDBIndexId() != null) {
            object = pSDEDBIdxFieldBase.getPSDEDBIndexId();
            xmlNode.setAttribute(FIELD_PSDEDBINDEXID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBIdxFieldBase.getPSDEDBIndexName() != null) {
            object = pSDEDBIdxFieldBase.getPSDEDBIndexName();
            xmlNode.setAttribute(FIELD_PSDEDBINDEXNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBIdxFieldBase.getPSDEFId() != null) {
            object = pSDEDBIdxFieldBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBIdxFieldBase.getPSDEFName() != null) {
            object = pSDEDBIdxFieldBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBIdxFieldBase.getPSDEId() != null) {
            object = pSDEDBIdxFieldBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBIdxFieldBase.getSortDir() != null) {
            object = pSDEDBIdxFieldBase.getSortDir();
            xmlNode.setAttribute(FIELD_SORTDIR, object == null ? "" : (String)object);
        }
        if (bl || pSDEDBIdxFieldBase.getUpdateDate() != null) {
            object = pSDEDBIdxFieldBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDBIdxFieldBase.getUpdateMan() != null) {
            object = pSDEDBIdxFieldBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEDBIdxFieldBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEDBIdxFieldBase pSDEDBIdxFieldBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEDBIdxFieldBase.isCreateDateDirty() && (bl || pSDEDBIdxFieldBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEDBIdxFieldBase.getCreateDate());
        }
        if (pSDEDBIdxFieldBase.isCreateManDirty() && (bl || pSDEDBIdxFieldBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEDBIdxFieldBase.getCreateMan());
        }
        if (pSDEDBIdxFieldBase.isIncModeDirty() && (bl || pSDEDBIdxFieldBase.getIncMode() != null)) {
            iDataObject.set(FIELD_INCMODE, (Object)pSDEDBIdxFieldBase.getIncMode());
        }
        if (pSDEDBIdxFieldBase.isIndexLengthDirty() && (bl || pSDEDBIdxFieldBase.getIndexLength() != null)) {
            iDataObject.set(FIELD_INDEXLENGTH, (Object)pSDEDBIdxFieldBase.getIndexLength());
        }
        if (pSDEDBIdxFieldBase.isPSDEDBIdxFieldIdDirty() && (bl || pSDEDBIdxFieldBase.getPSDEDBIdxFieldId() != null)) {
            iDataObject.set(FIELD_PSDEDBIDXFIELDID, (Object)pSDEDBIdxFieldBase.getPSDEDBIdxFieldId());
        }
        if (pSDEDBIdxFieldBase.isPSDEDBIdxFieldNameDirty() && (bl || pSDEDBIdxFieldBase.getPSDEDBIdxFieldName() != null)) {
            iDataObject.set(FIELD_PSDEDBIDXFIELDNAME, (Object)pSDEDBIdxFieldBase.getPSDEDBIdxFieldName());
        }
        if (pSDEDBIdxFieldBase.isPSDEDBIndexIdDirty() && (bl || pSDEDBIdxFieldBase.getPSDEDBIndexId() != null)) {
            iDataObject.set(FIELD_PSDEDBINDEXID, (Object)pSDEDBIdxFieldBase.getPSDEDBIndexId());
        }
        if (pSDEDBIdxFieldBase.isPSDEDBIndexNameDirty() && (bl || pSDEDBIdxFieldBase.getPSDEDBIndexName() != null)) {
            iDataObject.set(FIELD_PSDEDBINDEXNAME, (Object)pSDEDBIdxFieldBase.getPSDEDBIndexName());
        }
        if (pSDEDBIdxFieldBase.isPSDEFIdDirty() && (bl || pSDEDBIdxFieldBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSDEDBIdxFieldBase.getPSDEFId());
        }
        if (pSDEDBIdxFieldBase.isPSDEFNameDirty() && (bl || pSDEDBIdxFieldBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSDEDBIdxFieldBase.getPSDEFName());
        }
        if (pSDEDBIdxFieldBase.isPSDEIdDirty() && (bl || pSDEDBIdxFieldBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEDBIdxFieldBase.getPSDEId());
        }
        if (pSDEDBIdxFieldBase.isSortDirDirty() && (bl || pSDEDBIdxFieldBase.getSortDir() != null)) {
            iDataObject.set(FIELD_SORTDIR, (Object)pSDEDBIdxFieldBase.getSortDir());
        }
        if (pSDEDBIdxFieldBase.isUpdateDateDirty() && (bl || pSDEDBIdxFieldBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEDBIdxFieldBase.getUpdateDate());
        }
        if (pSDEDBIdxFieldBase.isUpdateManDirty() && (bl || pSDEDBIdxFieldBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEDBIdxFieldBase.getUpdateMan());
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
        return PSDEDBIdxFieldBase.remove(this, n);
    }

    private static boolean remove(PSDEDBIdxFieldBase pSDEDBIdxFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEDBIdxFieldBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEDBIdxFieldBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEDBIdxFieldBase.resetIncMode();
                return true;
            }
            case 3: {
                pSDEDBIdxFieldBase.resetIndexLength();
                return true;
            }
            case 4: {
                pSDEDBIdxFieldBase.resetPSDEDBIdxFieldId();
                return true;
            }
            case 5: {
                pSDEDBIdxFieldBase.resetPSDEDBIdxFieldName();
                return true;
            }
            case 6: {
                pSDEDBIdxFieldBase.resetPSDEDBIndexId();
                return true;
            }
            case 7: {
                pSDEDBIdxFieldBase.resetPSDEDBIndexName();
                return true;
            }
            case 8: {
                pSDEDBIdxFieldBase.resetPSDEFId();
                return true;
            }
            case 9: {
                pSDEDBIdxFieldBase.resetPSDEFName();
                return true;
            }
            case 10: {
                pSDEDBIdxFieldBase.resetPSDEId();
                return true;
            }
            case 11: {
                pSDEDBIdxFieldBase.resetSortDir();
                return true;
            }
            case 12: {
                pSDEDBIdxFieldBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSDEDBIdxFieldBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDBIndex getPSDEDBIndex() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDBIndex();
        }
        if (this.getPSDEDBIndexId() == null) {
            return null;
        }
        Integer n = this.objPSDEDBIndexLock;
        synchronized (n) {
            if (this.psdedbindex != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDBIndexId(), (Object)this.psdedbindex.getPSDEDBIndexId()) != 0L) {
                this.psdedbindex = null;
            }
            if (this.psdedbindex == null) {
                PSDEDBIndex pSDEDBIndex = new PSDEDBIndex();
                pSDEDBIndex.setPSDEDBIndexId(this.getPSDEDBIndexId());
                PSDEDBIndexService pSDEDBIndexService = (PSDEDBIndexService)ServiceGlobal.getService(PSDEDBIndexService.class, (SessionFactory)this.getSessionFactory());
                pSDEDBIndexService.autoGet(pSDEDBIndex);
                this.psdedbindex = pSDEDBIndex;
            }
            return this.psdedbindex;
        }
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

    private PSDEDBIdxFieldBase getProxyEntity() {
        return this.proxyPSDEDBIdxFieldBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEDBIdxFieldBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEDBIdxFieldBase) {
            this.proxyPSDEDBIdxFieldBase = (PSDEDBIdxFieldBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDBIdxFieldService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_INCMODE, 2);
        fieldIndexMap.put(FIELD_INDEXLENGTH, 3);
        fieldIndexMap.put(FIELD_PSDEDBIDXFIELDID, 4);
        fieldIndexMap.put(FIELD_PSDEDBIDXFIELDNAME, 5);
        fieldIndexMap.put(FIELD_PSDEDBINDEXID, 6);
        fieldIndexMap.put(FIELD_PSDEDBINDEXNAME, 7);
        fieldIndexMap.put(FIELD_PSDEFID, 8);
        fieldIndexMap.put(FIELD_PSDEFNAME, 9);
        fieldIndexMap.put(FIELD_PSDEID, 10);
        fieldIndexMap.put(FIELD_SORTDIR, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
    }
}

