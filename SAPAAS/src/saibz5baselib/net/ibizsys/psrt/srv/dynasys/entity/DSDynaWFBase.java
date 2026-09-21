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
import java.util.ArrayList;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.psrt.srv.dynasys.entity.DSDynaWFVer;
import net.ibizsys.psrt.srv.dynasys.service.DSDynaWFVerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class DSDynaWFBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(DSDynaWFBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DSDYNAWFID = "DSDYNAWFID";
    public static final String FIELD_DSDYNAWFNAME = "DSDYNAWFNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WFWORKFLOWID = "WFWORKFLOWID";
    public static final String FIELD_WFWORKFLOWNAME = "WFWORKFLOWNAME";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DSDYNAWFID = 2;
    private static final int INDEX_DSDYNAWFNAME = 3;
    private static final int INDEX_UPDATEDATE = 4;
    private static final int INDEX_UPDATEMAN = 5;
    private static final int INDEX_WFWORKFLOWID = 6;
    private static final int INDEX_WFWORKFLOWNAME = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private DSDynaWFBase proxyDSDynaWFBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dsdynawfidDirtyFlag = false;
    private boolean dsdynawfnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wfworkflowidDirtyFlag = false;
    private boolean wfworkflownameDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dsdynawfid")
    private String dsdynawfid;
    @Column(name="dsdynawfname")
    private String dsdynawfname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wfworkflowid")
    private String wfworkflowid;
    @Column(name="wfworkflowname")
    private String wfworkflowname;
    private Integer objDSDynaWFVersLock = new Integer(1);
    private ArrayList<DSDynaWFVer> dsdynawfvers = null;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DSDYNAWFID, 2);
        fieldIndexMap.put(FIELD_DSDYNAWFNAME, 3);
        fieldIndexMap.put(FIELD_UPDATEDATE, 4);
        fieldIndexMap.put(FIELD_UPDATEMAN, 5);
        fieldIndexMap.put(FIELD_WFWORKFLOWID, 6);
        fieldIndexMap.put(FIELD_WFWORKFLOWNAME, 7);
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

    public void setWFWorkflowId(String wfworkflowid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFWorkflowId(wfworkflowid);
            return;
        }
        if (wfworkflowid != null && (wfworkflowid = StringHelper.trimRight(wfworkflowid)).length() == 0) {
            wfworkflowid = null;
        }
        this.wfworkflowid = wfworkflowid;
        this.wfworkflowidDirtyFlag = true;
    }

    public String getWFWorkflowId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFWorkflowId();
        }
        return this.wfworkflowid;
    }

    public boolean isWFWorkflowIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFWorkflowIdDirty();
        }
        return this.wfworkflowidDirtyFlag;
    }

    public void resetWFWorkflowId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFWorkflowId();
            return;
        }
        this.wfworkflowidDirtyFlag = false;
        this.wfworkflowid = null;
    }

    public void setWFWorkflowName(String wfworkflowname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFWorkflowName(wfworkflowname);
            return;
        }
        if (wfworkflowname != null && (wfworkflowname = StringHelper.trimRight(wfworkflowname)).length() == 0) {
            wfworkflowname = null;
        }
        this.wfworkflowname = wfworkflowname;
        this.wfworkflownameDirtyFlag = true;
    }

    public String getWFWorkflowName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFWorkflowName();
        }
        return this.wfworkflowname;
    }

    public boolean isWFWorkflowNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFWorkflowNameDirty();
        }
        return this.wfworkflownameDirtyFlag;
    }

    public void resetWFWorkflowName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFWorkflowName();
            return;
        }
        this.wfworkflownameDirtyFlag = false;
        this.wfworkflowname = null;
    }

    @Override
    protected void onReset() {
        DSDynaWFBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(DSDynaWFBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDSDynaWFId();
        et.resetDSDynaWFName();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWFWorkflowId();
        et.resetWFWorkflowName();
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
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isWFWorkflowIdDirty()) {
            params.put(FIELD_WFWORKFLOWID, this.getWFWorkflowId());
        }
        if (!bDirtyOnly || this.isWFWorkflowNameDirty()) {
            params.put(FIELD_WFWORKFLOWNAME, this.getWFWorkflowName());
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
        return DSDynaWFBase.get(this, index);
    }

    private static Object get(DSDynaWFBase et, int index) throws Exception {
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
                return et.getUpdateDate();
            }
            case 5: {
                return et.getUpdateMan();
            }
            case 6: {
                return et.getWFWorkflowId();
            }
            case 7: {
                return et.getWFWorkflowName();
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
        DSDynaWFBase.set(this, index, objValue);
    }

    private static void set(DSDynaWFBase et, int index, Object obj) throws Exception {
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
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 5: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setWFWorkflowId(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setWFWorkflowName(DataObject.getStringValue(obj));
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
        return DSDynaWFBase.isNull(this, index);
    }

    private static boolean isNull(DSDynaWFBase et, int index) throws Exception {
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
                return et.getUpdateDate() == null;
            }
            case 5: {
                return et.getUpdateMan() == null;
            }
            case 6: {
                return et.getWFWorkflowId() == null;
            }
            case 7: {
                return et.getWFWorkflowName() == null;
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
        return DSDynaWFBase.contains(this, index);
    }

    private static boolean contains(DSDynaWFBase et, int index) throws Exception {
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
                return et.isUpdateDateDirty();
            }
            case 5: {
                return et.isUpdateManDirty();
            }
            case 6: {
                return et.isWFWorkflowIdDirty();
            }
            case 7: {
                return et.isWFWorkflowNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        DSDynaWFBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(DSDynaWFBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", DSDynaWFBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", DSDynaWFBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getDSDynaWFId() != null) {
            JSONObjectHelper.put(json, "dsdynawfid", DSDynaWFBase.getJSONValue(et.getDSDynaWFId()), false);
        }
        if (bIncEmpty || et.getDSDynaWFName() != null) {
            JSONObjectHelper.put(json, "dsdynawfname", DSDynaWFBase.getJSONValue(et.getDSDynaWFName()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", DSDynaWFBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", DSDynaWFBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getWFWorkflowId() != null) {
            JSONObjectHelper.put(json, "wfworkflowid", DSDynaWFBase.getJSONValue(et.getWFWorkflowId()), false);
        }
        if (bIncEmpty || et.getWFWorkflowName() != null) {
            JSONObjectHelper.put(json, "wfworkflowname", DSDynaWFBase.getJSONValue(et.getWFWorkflowName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        DSDynaWFBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(DSDynaWFBase et, XmlNode node, boolean bIncEmpty) throws Exception {
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
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFWorkflowId() != null) {
            obj = et.getWFWorkflowId();
            node.setAttribute(FIELD_WFWORKFLOWID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFWorkflowName() != null) {
            obj = et.getWFWorkflowName();
            node.setAttribute(FIELD_WFWORKFLOWNAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        DSDynaWFBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(DSDynaWFBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
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
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isWFWorkflowIdDirty() && (bIncEmpty || et.getWFWorkflowId() != null)) {
            dst.set(FIELD_WFWORKFLOWID, et.getWFWorkflowId());
        }
        if (et.isWFWorkflowNameDirty() && (bIncEmpty || et.getWFWorkflowName() != null)) {
            dst.set(FIELD_WFWORKFLOWNAME, et.getWFWorkflowName());
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
        return DSDynaWFBase.remove(this, index);
    }

    private static boolean remove(DSDynaWFBase et, int index) throws Exception {
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
                et.resetUpdateDate();
                return true;
            }
            case 5: {
                et.resetUpdateMan();
                return true;
            }
            case 6: {
                et.resetWFWorkflowId();
                return true;
            }
            case 7: {
                et.resetWFWorkflowName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<DSDynaWFVer> getDSDynaWFVers() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSDynaWFVers();
        }
        if (this.getDSDynaWFId() == null) {
            return null;
        }
        DSDynaWFVerService service = (DSDynaWFVerService)ServiceGlobal.getService(DSDynaWFVerService.class, this.getSessionFactory());
        Integer n = this.objDSDynaWFVersLock;
        synchronized (n) {
            if (this.dsdynawfvers == null) {
                this.dsdynawfvers = service.selectByDSDynaWF(this);
            }
            return this.dsdynawfvers;
        }
    }

    private DSDynaWFBase getProxyEntity() {
        return this.proxyDSDynaWFBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyDSDynaWFBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof DSDynaWFBase) {
            this.proxyDSDynaWFBase = (DSDynaWFBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.dynasys.service.DSDynaWFService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

