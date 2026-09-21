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
package net.ibizsys.pscore.srv.paasmgr.entity;

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
import net.ibizsys.pscore.srv.paasmgr.entity.PSNDFile;
import net.ibizsys.pscore.srv.paasmgr.service.PSNDFileService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSNDFileLinkBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSNDFileLinkBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSNDFILEID = "PSNDFILEID";
    public static final String FIELD_PSNDFILELINKID = "PSNDFILELINKID";
    public static final String FIELD_PSNDFILELINKNAME = "PSNDFILELINKNAME";
    public static final String FIELD_PSNDFILENAME = "PSNDFILENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSNDFILEID = 3;
    private static final int INDEX_PSNDFILELINKID = 4;
    private static final int INDEX_PSNDFILELINKNAME = 5;
    private static final int INDEX_PSNDFILENAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSNDFileLinkBase proxyPSNDFileLinkBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psndfileidDirtyFlag = false;
    private boolean psndfilelinkidDirtyFlag = false;
    private boolean psndfilelinknameDirtyFlag = false;
    private boolean psndfilenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psndfileid")
    private String psndfileid;
    @Column(name="psndfilelinkid")
    private String psndfilelinkid;
    @Column(name="psndfilelinkname")
    private String psndfilelinkname;
    @Column(name="psndfilename")
    private String psndfilename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSNDFileLock = new Integer(1);
    private PSNDFile psndfile = null;

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

    public void setPSNDFileId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSNDFileId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psndfileid = string;
        this.psndfileidDirtyFlag = true;
    }

    public String getPSNDFileId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSNDFileId();
        }
        return this.psndfileid;
    }

    public boolean isPSNDFileIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSNDFileIdDirty();
        }
        return this.psndfileidDirtyFlag;
    }

    public void resetPSNDFileId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSNDFileId();
            return;
        }
        this.psndfileidDirtyFlag = false;
        this.psndfileid = null;
    }

    public void setPSNDFileLinkId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSNDFileLinkId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psndfilelinkid = string;
        this.psndfilelinkidDirtyFlag = true;
    }

    public String getPSNDFileLinkId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSNDFileLinkId();
        }
        return this.psndfilelinkid;
    }

    public boolean isPSNDFileLinkIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSNDFileLinkIdDirty();
        }
        return this.psndfilelinkidDirtyFlag;
    }

    public void resetPSNDFileLinkId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSNDFileLinkId();
            return;
        }
        this.psndfilelinkidDirtyFlag = false;
        this.psndfilelinkid = null;
    }

    public void setPSNDFileLinkName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSNDFileLinkName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psndfilelinkname = string;
        this.psndfilelinknameDirtyFlag = true;
    }

    public String getPSNDFileLinkName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSNDFileLinkName();
        }
        return this.psndfilelinkname;
    }

    public boolean isPSNDFileLinkNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSNDFileLinkNameDirty();
        }
        return this.psndfilelinknameDirtyFlag;
    }

    public void resetPSNDFileLinkName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSNDFileLinkName();
            return;
        }
        this.psndfilelinknameDirtyFlag = false;
        this.psndfilelinkname = null;
    }

    public void setPSNDFileName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSNDFileName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psndfilename = string;
        this.psndfilenameDirtyFlag = true;
    }

    public String getPSNDFileName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSNDFileName();
        }
        return this.psndfilename;
    }

    public boolean isPSNDFileNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSNDFileNameDirty();
        }
        return this.psndfilenameDirtyFlag;
    }

    public void resetPSNDFileName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSNDFileName();
            return;
        }
        this.psndfilenameDirtyFlag = false;
        this.psndfilename = null;
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
        PSNDFileLinkBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSNDFileLinkBase pSNDFileLinkBase) {
        pSNDFileLinkBase.resetCreateDate();
        pSNDFileLinkBase.resetCreateMan();
        pSNDFileLinkBase.resetMemo();
        pSNDFileLinkBase.resetPSNDFileId();
        pSNDFileLinkBase.resetPSNDFileLinkId();
        pSNDFileLinkBase.resetPSNDFileLinkName();
        pSNDFileLinkBase.resetPSNDFileName();
        pSNDFileLinkBase.resetUpdateDate();
        pSNDFileLinkBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSNDFileIdDirty()) {
            hashMap.put(FIELD_PSNDFILEID, this.getPSNDFileId());
        }
        if (!bl || this.isPSNDFileLinkIdDirty()) {
            hashMap.put(FIELD_PSNDFILELINKID, this.getPSNDFileLinkId());
        }
        if (!bl || this.isPSNDFileLinkNameDirty()) {
            hashMap.put(FIELD_PSNDFILELINKNAME, this.getPSNDFileLinkName());
        }
        if (!bl || this.isPSNDFileNameDirty()) {
            hashMap.put(FIELD_PSNDFILENAME, this.getPSNDFileName());
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
        return PSNDFileLinkBase.get(this, n);
    }

    private static Object get(PSNDFileLinkBase pSNDFileLinkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSNDFileLinkBase.getCreateDate();
            }
            case 1: {
                return pSNDFileLinkBase.getCreateMan();
            }
            case 2: {
                return pSNDFileLinkBase.getMemo();
            }
            case 3: {
                return pSNDFileLinkBase.getPSNDFileId();
            }
            case 4: {
                return pSNDFileLinkBase.getPSNDFileLinkId();
            }
            case 5: {
                return pSNDFileLinkBase.getPSNDFileLinkName();
            }
            case 6: {
                return pSNDFileLinkBase.getPSNDFileName();
            }
            case 7: {
                return pSNDFileLinkBase.getUpdateDate();
            }
            case 8: {
                return pSNDFileLinkBase.getUpdateMan();
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
        PSNDFileLinkBase.set(this, n, object);
    }

    private static void set(PSNDFileLinkBase pSNDFileLinkBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSNDFileLinkBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSNDFileLinkBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSNDFileLinkBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSNDFileLinkBase.setPSNDFileId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSNDFileLinkBase.setPSNDFileLinkId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSNDFileLinkBase.setPSNDFileLinkName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSNDFileLinkBase.setPSNDFileName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSNDFileLinkBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSNDFileLinkBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSNDFileLinkBase.isNull(this, n);
    }

    private static boolean isNull(PSNDFileLinkBase pSNDFileLinkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSNDFileLinkBase.getCreateDate() == null;
            }
            case 1: {
                return pSNDFileLinkBase.getCreateMan() == null;
            }
            case 2: {
                return pSNDFileLinkBase.getMemo() == null;
            }
            case 3: {
                return pSNDFileLinkBase.getPSNDFileId() == null;
            }
            case 4: {
                return pSNDFileLinkBase.getPSNDFileLinkId() == null;
            }
            case 5: {
                return pSNDFileLinkBase.getPSNDFileLinkName() == null;
            }
            case 6: {
                return pSNDFileLinkBase.getPSNDFileName() == null;
            }
            case 7: {
                return pSNDFileLinkBase.getUpdateDate() == null;
            }
            case 8: {
                return pSNDFileLinkBase.getUpdateMan() == null;
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
        return PSNDFileLinkBase.contains(this, n);
    }

    private static boolean contains(PSNDFileLinkBase pSNDFileLinkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSNDFileLinkBase.isCreateDateDirty();
            }
            case 1: {
                return pSNDFileLinkBase.isCreateManDirty();
            }
            case 2: {
                return pSNDFileLinkBase.isMemoDirty();
            }
            case 3: {
                return pSNDFileLinkBase.isPSNDFileIdDirty();
            }
            case 4: {
                return pSNDFileLinkBase.isPSNDFileLinkIdDirty();
            }
            case 5: {
                return pSNDFileLinkBase.isPSNDFileLinkNameDirty();
            }
            case 6: {
                return pSNDFileLinkBase.isPSNDFileNameDirty();
            }
            case 7: {
                return pSNDFileLinkBase.isUpdateDateDirty();
            }
            case 8: {
                return pSNDFileLinkBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSNDFileLinkBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSNDFileLinkBase pSNDFileLinkBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSNDFileLinkBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSNDFileLinkBase.getJSONValue((Object)pSNDFileLinkBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSNDFileLinkBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSNDFileLinkBase.getJSONValue((Object)pSNDFileLinkBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSNDFileLinkBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSNDFileLinkBase.getJSONValue((Object)pSNDFileLinkBase.getMemo()), (boolean)false);
        }
        if (bl || pSNDFileLinkBase.getPSNDFileId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psndfileid", (Object)PSNDFileLinkBase.getJSONValue((Object)pSNDFileLinkBase.getPSNDFileId()), (boolean)false);
        }
        if (bl || pSNDFileLinkBase.getPSNDFileLinkId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psndfilelinkid", (Object)PSNDFileLinkBase.getJSONValue((Object)pSNDFileLinkBase.getPSNDFileLinkId()), (boolean)false);
        }
        if (bl || pSNDFileLinkBase.getPSNDFileLinkName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psndfilelinkname", (Object)PSNDFileLinkBase.getJSONValue((Object)pSNDFileLinkBase.getPSNDFileLinkName()), (boolean)false);
        }
        if (bl || pSNDFileLinkBase.getPSNDFileName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psndfilename", (Object)PSNDFileLinkBase.getJSONValue((Object)pSNDFileLinkBase.getPSNDFileName()), (boolean)false);
        }
        if (bl || pSNDFileLinkBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSNDFileLinkBase.getJSONValue((Object)pSNDFileLinkBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSNDFileLinkBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSNDFileLinkBase.getJSONValue((Object)pSNDFileLinkBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSNDFileLinkBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSNDFileLinkBase pSNDFileLinkBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSNDFileLinkBase.getCreateDate() != null) {
            object = pSNDFileLinkBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSNDFileLinkBase.getCreateMan() != null) {
            object = pSNDFileLinkBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSNDFileLinkBase.getMemo() != null) {
            object = pSNDFileLinkBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSNDFileLinkBase.getPSNDFileId() != null) {
            object = pSNDFileLinkBase.getPSNDFileId();
            xmlNode.setAttribute(FIELD_PSNDFILEID, object == null ? "" : (String)object);
        }
        if (bl || pSNDFileLinkBase.getPSNDFileLinkId() != null) {
            object = pSNDFileLinkBase.getPSNDFileLinkId();
            xmlNode.setAttribute(FIELD_PSNDFILELINKID, object == null ? "" : (String)object);
        }
        if (bl || pSNDFileLinkBase.getPSNDFileLinkName() != null) {
            object = pSNDFileLinkBase.getPSNDFileLinkName();
            xmlNode.setAttribute(FIELD_PSNDFILELINKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSNDFileLinkBase.getPSNDFileName() != null) {
            object = pSNDFileLinkBase.getPSNDFileName();
            xmlNode.setAttribute(FIELD_PSNDFILENAME, object == null ? "" : (String)object);
        }
        if (bl || pSNDFileLinkBase.getUpdateDate() != null) {
            object = pSNDFileLinkBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSNDFileLinkBase.getUpdateMan() != null) {
            object = pSNDFileLinkBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSNDFileLinkBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSNDFileLinkBase pSNDFileLinkBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSNDFileLinkBase.isCreateDateDirty() && (bl || pSNDFileLinkBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSNDFileLinkBase.getCreateDate());
        }
        if (pSNDFileLinkBase.isCreateManDirty() && (bl || pSNDFileLinkBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSNDFileLinkBase.getCreateMan());
        }
        if (pSNDFileLinkBase.isMemoDirty() && (bl || pSNDFileLinkBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSNDFileLinkBase.getMemo());
        }
        if (pSNDFileLinkBase.isPSNDFileIdDirty() && (bl || pSNDFileLinkBase.getPSNDFileId() != null)) {
            iDataObject.set(FIELD_PSNDFILEID, (Object)pSNDFileLinkBase.getPSNDFileId());
        }
        if (pSNDFileLinkBase.isPSNDFileLinkIdDirty() && (bl || pSNDFileLinkBase.getPSNDFileLinkId() != null)) {
            iDataObject.set(FIELD_PSNDFILELINKID, (Object)pSNDFileLinkBase.getPSNDFileLinkId());
        }
        if (pSNDFileLinkBase.isPSNDFileLinkNameDirty() && (bl || pSNDFileLinkBase.getPSNDFileLinkName() != null)) {
            iDataObject.set(FIELD_PSNDFILELINKNAME, (Object)pSNDFileLinkBase.getPSNDFileLinkName());
        }
        if (pSNDFileLinkBase.isPSNDFileNameDirty() && (bl || pSNDFileLinkBase.getPSNDFileName() != null)) {
            iDataObject.set(FIELD_PSNDFILENAME, (Object)pSNDFileLinkBase.getPSNDFileName());
        }
        if (pSNDFileLinkBase.isUpdateDateDirty() && (bl || pSNDFileLinkBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSNDFileLinkBase.getUpdateDate());
        }
        if (pSNDFileLinkBase.isUpdateManDirty() && (bl || pSNDFileLinkBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSNDFileLinkBase.getUpdateMan());
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
        return PSNDFileLinkBase.remove(this, n);
    }

    private static boolean remove(PSNDFileLinkBase pSNDFileLinkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSNDFileLinkBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSNDFileLinkBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSNDFileLinkBase.resetMemo();
                return true;
            }
            case 3: {
                pSNDFileLinkBase.resetPSNDFileId();
                return true;
            }
            case 4: {
                pSNDFileLinkBase.resetPSNDFileLinkId();
                return true;
            }
            case 5: {
                pSNDFileLinkBase.resetPSNDFileLinkName();
                return true;
            }
            case 6: {
                pSNDFileLinkBase.resetPSNDFileName();
                return true;
            }
            case 7: {
                pSNDFileLinkBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSNDFileLinkBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSNDFile getPSNDFile() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSNDFile();
        }
        if (this.getPSNDFileId() == null) {
            return null;
        }
        Integer n = this.objPSNDFileLock;
        synchronized (n) {
            if (this.psndfile != null && DataTypeHelper.compare((int)25, (Object)this.getPSNDFileId(), (Object)this.psndfile.getPSNDFileId()) != 0L) {
                this.psndfile = null;
            }
            if (this.psndfile == null) {
                PSNDFile pSNDFile = new PSNDFile();
                pSNDFile.setPSNDFileId(this.getPSNDFileId());
                PSNDFileService pSNDFileService = (PSNDFileService)ServiceGlobal.getService(PSNDFileService.class, (SessionFactory)this.getSessionFactory());
                pSNDFileService.autoGet((IEntity)pSNDFile);
                this.psndfile = pSNDFile;
            }
            return this.psndfile;
        }
    }

    private PSNDFileLinkBase getProxyEntity() {
        return this.proxyPSNDFileLinkBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSNDFileLinkBase = null;
        if (iDataObject != null && iDataObject instanceof PSNDFileLinkBase) {
            this.proxyPSNDFileLinkBase = (PSNDFileLinkBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSNDFileLinkService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSNDFILEID, 3);
        fieldIndexMap.put(FIELD_PSNDFILELINKID, 4);
        fieldIndexMap.put(FIELD_PSNDFILELINKNAME, 5);
        fieldIndexMap.put(FIELD_PSNDFILENAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
    }
}

