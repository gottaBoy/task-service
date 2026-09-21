/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.dynasys.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaWF;
import net.ibizsys.psrt.srv.dynasys.service.DSDynaWFService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class DSDynaWFVerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(DSDynaWFVerBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DSDYNAWFID = "DSDYNAWFID";
    public static final String FIELD_DSDYNAWFNAME = "DSDYNAWFNAME";
    public static final String FIELD_DSDYNAWFVERID = "DSDYNAWFVERID";
    public static final String FIELD_DSDYNAWFVERNAME = "DSDYNAWFVERNAME";
    public static final String FIELD_DYNAMODEL = "DYNAMODEL";
    public static final String FIELD_DYNASYSINSTID = "DYNASYSINSTID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WFVERSION = "WFVERSION";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DSDYNAWFID = 2;
    private static final int INDEX_DSDYNAWFNAME = 3;
    private static final int INDEX_DSDYNAWFVERID = 4;
    private static final int INDEX_DSDYNAWFVERNAME = 5;
    private static final int INDEX_DYNAMODEL = 6;
    private static final int INDEX_DYNASYSINSTID = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final int INDEX_WFVERSION = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private DSDynaWFVerBase proxyDSDynaWFVerBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dsdynawfidDirtyFlag = false;
    private boolean dsdynawfnameDirtyFlag = false;
    private boolean dsdynawfveridDirtyFlag = false;
    private boolean dsdynawfvernameDirtyFlag = false;
    private boolean dynamodelDirtyFlag = false;
    private boolean dynasysinstidDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wfversionDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dsdynawfid")
    private String dsdynawfid;
    @Column(name="dsdynawfname")
    private String dsdynawfname;
    @Column(name="dsdynawfverid")
    private String dsdynawfverid;
    @Column(name="dsdynawfvername")
    private String dsdynawfvername;
    @Column(name="dynamodel")
    private String dynamodel;
    @Column(name="dynasysinstid")
    private String dynasysinstid;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wfversion")
    private Integer wfversion;
    private Integer objDSDynaWFLock = new Integer(1);
    private DSDynaWF dsdynawf = null;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DSDYNAWFID, 2);
        fieldIndexMap.put(FIELD_DSDYNAWFNAME, 3);
        fieldIndexMap.put(FIELD_DSDYNAWFVERID, 4);
        fieldIndexMap.put(FIELD_DSDYNAWFVERNAME, 5);
        fieldIndexMap.put(FIELD_DYNAMODEL, 6);
        fieldIndexMap.put(FIELD_DYNASYSINSTID, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
        fieldIndexMap.put(FIELD_WFVERSION, 10);
    }

    public void setCreateDate(Timestamp createdate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(createdate);
            return;
        }
        this.createdate = createdate;
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

    public void setCreateMan(String createman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(createman);
            return;
        }
        if (createman != null && (createman = StringHelper.trimRight(createman)).length() == 0) {
            createman = null;
        }
        this.createman = createman;
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

    public void setDSDynaWFId(String dsdynawfid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSDynaWFId(dsdynawfid);
            return;
        }
        if (dsdynawfid != null && (dsdynawfid = StringHelper.trimRight(dsdynawfid)).length() == 0) {
            dsdynawfid = null;
        }
        this.dsdynawfid = dsdynawfid;
        this.dsdynawfidDirtyFlag = true;
    }

    public String getDSDynaWFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSDynaWFId();
        }
        return this.dsdynawfid;
    }

    public boolean isDSDynaWFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSDynaWFIdDirty();
        }
        return this.dsdynawfidDirtyFlag;
    }

    public void resetDSDynaWFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSDynaWFId();
            return;
        }
        this.dsdynawfidDirtyFlag = false;
        this.dsdynawfid = null;
    }

    public void setDSDynaWFName(String dsdynawfname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSDynaWFName(dsdynawfname);
            return;
        }
        if (dsdynawfname != null && (dsdynawfname = StringHelper.trimRight(dsdynawfname)).length() == 0) {
            dsdynawfname = null;
        }
        this.dsdynawfname = dsdynawfname;
        this.dsdynawfnameDirtyFlag = true;
    }

    public String getDSDynaWFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSDynaWFName();
        }
        return this.dsdynawfname;
    }

    public boolean isDSDynaWFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSDynaWFNameDirty();
        }
        return this.dsdynawfnameDirtyFlag;
    }

    public void resetDSDynaWFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSDynaWFName();
            return;
        }
        this.dsdynawfnameDirtyFlag = false;
        this.dsdynawfname = null;
    }

    public void setDSDynaWFVerId(String dsdynawfverid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSDynaWFVerId(dsdynawfverid);
            return;
        }
        if (dsdynawfverid != null && (dsdynawfverid = StringHelper.trimRight(dsdynawfverid)).length() == 0) {
            dsdynawfverid = null;
        }
        this.dsdynawfverid = dsdynawfverid;
        this.dsdynawfveridDirtyFlag = true;
    }

    public String getDSDynaWFVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSDynaWFVerId();
        }
        return this.dsdynawfverid;
    }

    public boolean isDSDynaWFVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSDynaWFVerIdDirty();
        }
        return this.dsdynawfveridDirtyFlag;
    }

    public void resetDSDynaWFVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSDynaWFVerId();
            return;
        }
        this.dsdynawfveridDirtyFlag = false;
        this.dsdynawfverid = null;
    }

    public void setDSDynaWFVerName(String dsdynawfvername) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSDynaWFVerName(dsdynawfvername);
            return;
        }
        if (dsdynawfvername != null && (dsdynawfvername = StringHelper.trimRight(dsdynawfvername)).length() == 0) {
            dsdynawfvername = null;
        }
        this.dsdynawfvername = dsdynawfvername;
        this.dsdynawfvernameDirtyFlag = true;
    }

    public String getDSDynaWFVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSDynaWFVerName();
        }
        return this.dsdynawfvername;
    }

    public boolean isDSDynaWFVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSDynaWFVerNameDirty();
        }
        return this.dsdynawfvernameDirtyFlag;
    }

    public void resetDSDynaWFVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSDynaWFVerName();
            return;
        }
        this.dsdynawfvernameDirtyFlag = false;
        this.dsdynawfvername = null;
    }

    public void setDynaModel(String dynamodel) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModel(dynamodel);
            return;
        }
        if (dynamodel != null && (dynamodel = StringHelper.trimRight(dynamodel)).length() == 0) {
            dynamodel = null;
        }
        this.dynamodel = dynamodel;
        this.dynamodelDirtyFlag = true;
    }

    public String getDynaModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModel();
        }
        return this.dynamodel;
    }

    public boolean isDynaModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelDirty();
        }
        return this.dynamodelDirtyFlag;
    }

    public void resetDynaModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModel();
            return;
        }
        this.dynamodelDirtyFlag = false;
        this.dynamodel = null;
    }

    public void setDynaSysInstId(String dynasysinstid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaSysInstId(dynasysinstid);
            return;
        }
        if (dynasysinstid != null && (dynasysinstid = StringHelper.trimRight(dynasysinstid)).length() == 0) {
            dynasysinstid = null;
        }
        this.dynasysinstid = dynasysinstid;
        this.dynasysinstidDirtyFlag = true;
    }

    public String getDynaSysInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaSysInstId();
        }
        return this.dynasysinstid;
    }

    public boolean isDynaSysInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaSysInstIdDirty();
        }
        return this.dynasysinstidDirtyFlag;
    }

    public void resetDynaSysInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaSysInstId();
            return;
        }
        this.dynasysinstidDirtyFlag = false;
        this.dynasysinstid = null;
    }

    public void setUpdateDate(Timestamp updatedate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(updatedate);
            return;
        }
        this.updatedate = updatedate;
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

    public void setUpdateMan(String updateman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(updateman);
            return;
        }
        if (updateman != null && (updateman = StringHelper.trimRight(updateman)).length() == 0) {
            updateman = null;
        }
        this.updateman = updateman;
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

    public void setWFVersion(Integer wfversion) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFVersion(wfversion);
            return;
        }
        this.wfversion = wfversion;
        this.wfversionDirtyFlag = true;
    }

    public Integer getWFVersion() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFVersion();
        }
        return this.wfversion;
    }

    public boolean isWFVersionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFVersionDirty();
        }
        return this.wfversionDirtyFlag;
    }

    public void resetWFVersion() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFVersion();
            return;
        }
        this.wfversionDirtyFlag = false;
        this.wfversion = null;
    }

    @Override
    protected void onReset() {
        DSDynaWFVerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(DSDynaWFVerBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDSDynaWFId();
        et.resetDSDynaWFName();
        et.resetDSDynaWFVerId();
        et.resetDSDynaWFVerName();
        et.resetDynaModel();
        et.resetDynaSysInstId();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWFVersion();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isDSDynaWFIdDirty()) {
            params.put(FIELD_DSDYNAWFID, this.getDSDynaWFId());
        }
        if (!bDirtyOnly || this.isDSDynaWFNameDirty()) {
            params.put(FIELD_DSDYNAWFNAME, this.getDSDynaWFName());
        }
        if (!bDirtyOnly || this.isDSDynaWFVerIdDirty()) {
            params.put(FIELD_DSDYNAWFVERID, this.getDSDynaWFVerId());
        }
        if (!bDirtyOnly || this.isDSDynaWFVerNameDirty()) {
            params.put(FIELD_DSDYNAWFVERNAME, this.getDSDynaWFVerName());
        }
        if (!bDirtyOnly || this.isDynaModelDirty()) {
            params.put(FIELD_DYNAMODEL, this.getDynaModel());
        }
        if (!bDirtyOnly || this.isDynaSysInstIdDirty()) {
            params.put(FIELD_DYNASYSINSTID, this.getDynaSysInstId());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isWFVersionDirty()) {
            params.put(FIELD_WFVERSION, this.getWFVersion());
        }
        super.onFillMap(params, bDirtyOnly);
    }

    @Override
    public Object get(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.get(strParamName);
        }
        return DSDynaWFVerBase.get(this, index);
    }

    private static Object get(DSDynaWFVerBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getDSDynaWFId();
            }
            case 3: {
                return et.getDSDynaWFName();
            }
            case 4: {
                return et.getDSDynaWFVerId();
            }
            case 5: {
                return et.getDSDynaWFVerName();
            }
            case 6: {
                return et.getDynaModel();
            }
            case 7: {
                return et.getDynaSysInstId();
            }
            case 8: {
                return et.getUpdateDate();
            }
            case 9: {
                return et.getUpdateMan();
            }
            case 10: {
                return et.getWFVersion();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public void set(String strParamName, Object objValue) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(strParamName, objValue);
            return;
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            super.set(strParamName, objValue);
            return;
        }
        DSDynaWFVerBase.set(this, index, objValue);
    }

    private static void set(DSDynaWFVerBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 1: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 2: {
                et.setDSDynaWFId(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setDSDynaWFName(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setDSDynaWFVerId(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setDSDynaWFVerName(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setDynaModel(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setDynaSysInstId(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 9: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setWFVersion(DataObject.getIntegerValue(obj));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean isNull(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.isNull(strParamName);
        }
        return DSDynaWFVerBase.isNull(this, index);
    }

    private static boolean isNull(DSDynaWFVerBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getDSDynaWFId() == null;
            }
            case 3: {
                return et.getDSDynaWFName() == null;
            }
            case 4: {
                return et.getDSDynaWFVerId() == null;
            }
            case 5: {
                return et.getDSDynaWFVerName() == null;
            }
            case 6: {
                return et.getDynaModel() == null;
            }
            case 7: {
                return et.getDynaSysInstId() == null;
            }
            case 8: {
                return et.getUpdateDate() == null;
            }
            case 9: {
                return et.getUpdateMan() == null;
            }
            case 10: {
                return et.getWFVersion() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean contains(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.contains(strParamName);
        }
        return DSDynaWFVerBase.contains(this, index);
    }

    private static boolean contains(DSDynaWFVerBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isDSDynaWFIdDirty();
            }
            case 3: {
                return et.isDSDynaWFNameDirty();
            }
            case 4: {
                return et.isDSDynaWFVerIdDirty();
            }
            case 5: {
                return et.isDSDynaWFVerNameDirty();
            }
            case 6: {
                return et.isDynaModelDirty();
            }
            case 7: {
                return et.isDynaSysInstIdDirty();
            }
            case 8: {
                return et.isUpdateDateDirty();
            }
            case 9: {
                return et.isUpdateManDirty();
            }
            case 10: {
                return et.isWFVersionDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        DSDynaWFVerBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(DSDynaWFVerBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", DSDynaWFVerBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", DSDynaWFVerBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getDSDynaWFId() != null) {
            JSONObjectHelper.put(json, "dsdynawfid", DSDynaWFVerBase.getJSONValue(et.getDSDynaWFId()), false);
        }
        if (bIncEmpty || et.getDSDynaWFName() != null) {
            JSONObjectHelper.put(json, "dsdynawfname", DSDynaWFVerBase.getJSONValue(et.getDSDynaWFName()), false);
        }
        if (bIncEmpty || et.getDSDynaWFVerId() != null) {
            JSONObjectHelper.put(json, "dsdynawfverid", DSDynaWFVerBase.getJSONValue(et.getDSDynaWFVerId()), false);
        }
        if (bIncEmpty || et.getDSDynaWFVerName() != null) {
            JSONObjectHelper.put(json, "dsdynawfvername", DSDynaWFVerBase.getJSONValue(et.getDSDynaWFVerName()), false);
        }
        if (bIncEmpty || et.getDynaModel() != null) {
            JSONObjectHelper.put(json, "dynamodel", DSDynaWFVerBase.getJSONValue(et.getDynaModel()), false);
        }
        if (bIncEmpty || et.getDynaSysInstId() != null) {
            JSONObjectHelper.put(json, "dynasysinstid", DSDynaWFVerBase.getJSONValue(et.getDynaSysInstId()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", DSDynaWFVerBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", DSDynaWFVerBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getWFVersion() != null) {
            JSONObjectHelper.put(json, "wfversion", DSDynaWFVerBase.getJSONValue(et.getWFVersion()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        DSDynaWFVerBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(DSDynaWFVerBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDSDynaWFId() != null) {
            obj = et.getDSDynaWFId();
            node.setAttribute(FIELD_DSDYNAWFID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDSDynaWFName() != null) {
            obj = et.getDSDynaWFName();
            node.setAttribute(FIELD_DSDYNAWFNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDSDynaWFVerId() != null) {
            obj = et.getDSDynaWFVerId();
            node.setAttribute(FIELD_DSDYNAWFVERID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDSDynaWFVerName() != null) {
            obj = et.getDSDynaWFVerName();
            node.setAttribute(FIELD_DSDYNAWFVERNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDynaModel() != null) {
            obj = et.getDynaModel();
            node.setAttribute(FIELD_DYNAMODEL, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDynaSysInstId() != null) {
            obj = et.getDynaSysInstId();
            node.setAttribute(FIELD_DYNASYSINSTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFVersion() != null) {
            obj = et.getWFVersion();
            node.setAttribute(FIELD_WFVERSION, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        DSDynaWFVerBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(DSDynaWFVerBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isDSDynaWFIdDirty() && (bIncEmpty || et.getDSDynaWFId() != null)) {
            dst.set(FIELD_DSDYNAWFID, et.getDSDynaWFId());
        }
        if (et.isDSDynaWFNameDirty() && (bIncEmpty || et.getDSDynaWFName() != null)) {
            dst.set(FIELD_DSDYNAWFNAME, et.getDSDynaWFName());
        }
        if (et.isDSDynaWFVerIdDirty() && (bIncEmpty || et.getDSDynaWFVerId() != null)) {
            dst.set(FIELD_DSDYNAWFVERID, et.getDSDynaWFVerId());
        }
        if (et.isDSDynaWFVerNameDirty() && (bIncEmpty || et.getDSDynaWFVerName() != null)) {
            dst.set(FIELD_DSDYNAWFVERNAME, et.getDSDynaWFVerName());
        }
        if (et.isDynaModelDirty() && (bIncEmpty || et.getDynaModel() != null)) {
            dst.set(FIELD_DYNAMODEL, et.getDynaModel());
        }
        if (et.isDynaSysInstIdDirty() && (bIncEmpty || et.getDynaSysInstId() != null)) {
            dst.set(FIELD_DYNASYSINSTID, et.getDynaSysInstId());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isWFVersionDirty() && (bIncEmpty || et.getWFVersion() != null)) {
            dst.set(FIELD_WFVERSION, et.getWFVersion());
        }
    }

    @Override
    public boolean remove(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.remove(strParamName);
        }
        return DSDynaWFVerBase.remove(this, index);
    }

    private static boolean remove(DSDynaWFVerBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetCreateDate();
                return true;
            }
            case 1: {
                et.resetCreateMan();
                return true;
            }
            case 2: {
                et.resetDSDynaWFId();
                return true;
            }
            case 3: {
                et.resetDSDynaWFName();
                return true;
            }
            case 4: {
                et.resetDSDynaWFVerId();
                return true;
            }
            case 5: {
                et.resetDSDynaWFVerName();
                return true;
            }
            case 6: {
                et.resetDynaModel();
                return true;
            }
            case 7: {
                et.resetDynaSysInstId();
                return true;
            }
            case 8: {
                et.resetUpdateDate();
                return true;
            }
            case 9: {
                et.resetUpdateMan();
                return true;
            }
            case 10: {
                et.resetWFVersion();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public DSDynaWF getDSDynaWF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSDynaWF();
        }
        if (this.getDSDynaWFId() == null) {
            return null;
        }
        Integer n = this.objDSDynaWFLock;
        synchronized (n) {
            if (this.dsdynawf != null && DataTypeHelper.compare(25, (Object)this.getDSDynaWFId(), (Object)this.dsdynawf.getDSDynaWFId()) != 0L) {
                this.dsdynawf = null;
            }
            if (this.dsdynawf == null) {
                DSDynaWF dsdynawf = new DSDynaWF();
                dsdynawf.setDSDynaWFId(this.getDSDynaWFId());
                DSDynaWFService service = (DSDynaWFService)ServiceGlobal.getService(DSDynaWFService.class, this.getSessionFactory());
                service.autoGet(dsdynawf);
                this.dsdynawf = dsdynawf;
            }
            return this.dsdynawf;
        }
    }

    private DSDynaWFVerBase getProxyEntity() {
        return this.proxyDSDynaWFVerBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyDSDynaWFVerBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof DSDynaWFVerBase) {
            this.proxyDSDynaWFVerBase = (DSDynaWFVerBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.dynasys.service.DSDynaWFVerService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

