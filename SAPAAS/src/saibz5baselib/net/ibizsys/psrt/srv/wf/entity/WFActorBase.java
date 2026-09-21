/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.wf.entity;

import java.io.Serializable;
import java.sql.Timestamp;
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
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WFActorBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFActorBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PARAMS = "PARAMS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WFACTORID = "WFACTORID";
    public static final String FIELD_WFACTORNAME = "WFACTORNAME";
    public static final String FIELD_WFACTORPARAM = "WFACTORPARAM";
    public static final String FIELD_WFACTORPARAM2 = "WFACTORPARAM2";
    public static final String FIELD_WFACTORTYPE = "WFACTORTYPE";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PARAMS = 2;
    private static final int INDEX_UPDATEDATE = 3;
    private static final int INDEX_UPDATEMAN = 4;
    private static final int INDEX_WFACTORID = 5;
    private static final int INDEX_WFACTORNAME = 6;
    private static final int INDEX_WFACTORPARAM = 7;
    private static final int INDEX_WFACTORPARAM2 = 8;
    private static final int INDEX_WFACTORTYPE = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private WFActorBase proxyWFActorBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean paramsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wfactoridDirtyFlag = false;
    private boolean wfactornameDirtyFlag = false;
    private boolean wfactorparamDirtyFlag = false;
    private boolean wfactorparam2DirtyFlag = false;
    private boolean wfactortypeDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="params")
    private String params;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wfactorid")
    private String wfactorid;
    @Column(name="wfactorname")
    private String wfactorname;
    @Column(name="wfactorparam")
    private String wfactorparam;
    @Column(name="wfactorparam2")
    private String wfactorparam2;
    @Column(name="wfactortype")
    private String wfactortype;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PARAMS, 2);
        fieldIndexMap.put(FIELD_UPDATEDATE, 3);
        fieldIndexMap.put(FIELD_UPDATEMAN, 4);
        fieldIndexMap.put(FIELD_WFACTORID, 5);
        fieldIndexMap.put(FIELD_WFACTORNAME, 6);
        fieldIndexMap.put(FIELD_WFACTORPARAM, 7);
        fieldIndexMap.put(FIELD_WFACTORPARAM2, 8);
        fieldIndexMap.put(FIELD_WFACTORTYPE, 9);
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

    public void setParams(String params) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParams(params);
            return;
        }
        if (params != null && (params = StringHelper.trimRight(params)).length() == 0) {
            params = null;
        }
        this.params = params;
        this.paramsDirtyFlag = true;
    }

    public String getParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParams();
        }
        return this.params;
    }

    public boolean isParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamsDirty();
        }
        return this.paramsDirtyFlag;
    }

    public void resetParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParams();
            return;
        }
        this.paramsDirtyFlag = false;
        this.params = null;
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

    public void setWFActorId(String wfactorid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFActorId(wfactorid);
            return;
        }
        if (wfactorid != null && (wfactorid = StringHelper.trimRight(wfactorid)).length() == 0) {
            wfactorid = null;
        }
        this.wfactorid = wfactorid;
        this.wfactoridDirtyFlag = true;
    }

    public String getWFActorId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFActorId();
        }
        return this.wfactorid;
    }

    public boolean isWFActorIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFActorIdDirty();
        }
        return this.wfactoridDirtyFlag;
    }

    public void resetWFActorId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFActorId();
            return;
        }
        this.wfactoridDirtyFlag = false;
        this.wfactorid = null;
    }

    public void setWFActorName(String wfactorname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFActorName(wfactorname);
            return;
        }
        if (wfactorname != null && (wfactorname = StringHelper.trimRight(wfactorname)).length() == 0) {
            wfactorname = null;
        }
        this.wfactorname = wfactorname;
        this.wfactornameDirtyFlag = true;
    }

    public String getWFActorName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFActorName();
        }
        return this.wfactorname;
    }

    public boolean isWFActorNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFActorNameDirty();
        }
        return this.wfactornameDirtyFlag;
    }

    public void resetWFActorName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFActorName();
            return;
        }
        this.wfactornameDirtyFlag = false;
        this.wfactorname = null;
    }

    public void setWFActorParam(String wfactorparam) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFActorParam(wfactorparam);
            return;
        }
        if (wfactorparam != null && (wfactorparam = StringHelper.trimRight(wfactorparam)).length() == 0) {
            wfactorparam = null;
        }
        this.wfactorparam = wfactorparam;
        this.wfactorparamDirtyFlag = true;
    }

    public String getWFActorParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFActorParam();
        }
        return this.wfactorparam;
    }

    public boolean isWFActorParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFActorParamDirty();
        }
        return this.wfactorparamDirtyFlag;
    }

    public void resetWFActorParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFActorParam();
            return;
        }
        this.wfactorparamDirtyFlag = false;
        this.wfactorparam = null;
    }

    public void setWFActorParam2(String wfactorparam2) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFActorParam2(wfactorparam2);
            return;
        }
        if (wfactorparam2 != null && (wfactorparam2 = StringHelper.trimRight(wfactorparam2)).length() == 0) {
            wfactorparam2 = null;
        }
        this.wfactorparam2 = wfactorparam2;
        this.wfactorparam2DirtyFlag = true;
    }

    public String getWFActorParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFActorParam2();
        }
        return this.wfactorparam2;
    }

    public boolean isWFActorParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFActorParam2Dirty();
        }
        return this.wfactorparam2DirtyFlag;
    }

    public void resetWFActorParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFActorParam2();
            return;
        }
        this.wfactorparam2DirtyFlag = false;
        this.wfactorparam2 = null;
    }

    public void setWFActorType(String wfactortype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFActorType(wfactortype);
            return;
        }
        if (wfactortype != null && (wfactortype = StringHelper.trimRight(wfactortype)).length() == 0) {
            wfactortype = null;
        }
        this.wfactortype = wfactortype;
        this.wfactortypeDirtyFlag = true;
    }

    public String getWFActorType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFActorType();
        }
        return this.wfactortype;
    }

    public boolean isWFActorTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFActorTypeDirty();
        }
        return this.wfactortypeDirtyFlag;
    }

    public void resetWFActorType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFActorType();
            return;
        }
        this.wfactortypeDirtyFlag = false;
        this.wfactortype = null;
    }

    @Override
    protected void onReset() {
        WFActorBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(WFActorBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetParams();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWFActorId();
        et.resetWFActorName();
        et.resetWFActorParam();
        et.resetWFActorParam2();
        et.resetWFActorType();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isParamsDirty()) {
            params.put(FIELD_PARAMS, this.getParams());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isWFActorIdDirty()) {
            params.put(FIELD_WFACTORID, this.getWFActorId());
        }
        if (!bDirtyOnly || this.isWFActorNameDirty()) {
            params.put(FIELD_WFACTORNAME, this.getWFActorName());
        }
        if (!bDirtyOnly || this.isWFActorParamDirty()) {
            params.put(FIELD_WFACTORPARAM, this.getWFActorParam());
        }
        if (!bDirtyOnly || this.isWFActorParam2Dirty()) {
            params.put(FIELD_WFACTORPARAM2, this.getWFActorParam2());
        }
        if (!bDirtyOnly || this.isWFActorTypeDirty()) {
            params.put(FIELD_WFACTORTYPE, this.getWFActorType());
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
        return WFActorBase.get(this, index);
    }

    private static Object get(WFActorBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getParams();
            }
            case 3: {
                return et.getUpdateDate();
            }
            case 4: {
                return et.getUpdateMan();
            }
            case 5: {
                return et.getWFActorId();
            }
            case 6: {
                return et.getWFActorName();
            }
            case 7: {
                return et.getWFActorParam();
            }
            case 8: {
                return et.getWFActorParam2();
            }
            case 9: {
                return et.getWFActorType();
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
        WFActorBase.set(this, index, objValue);
    }

    private static void set(WFActorBase et, int index, Object obj) throws Exception {
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
                et.setParams(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 4: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setWFActorId(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setWFActorName(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setWFActorParam(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setWFActorParam2(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setWFActorType(DataObject.getStringValue(obj));
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
        return WFActorBase.isNull(this, index);
    }

    private static boolean isNull(WFActorBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getParams() == null;
            }
            case 3: {
                return et.getUpdateDate() == null;
            }
            case 4: {
                return et.getUpdateMan() == null;
            }
            case 5: {
                return et.getWFActorId() == null;
            }
            case 6: {
                return et.getWFActorName() == null;
            }
            case 7: {
                return et.getWFActorParam() == null;
            }
            case 8: {
                return et.getWFActorParam2() == null;
            }
            case 9: {
                return et.getWFActorType() == null;
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
        return WFActorBase.contains(this, index);
    }

    private static boolean contains(WFActorBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isParamsDirty();
            }
            case 3: {
                return et.isUpdateDateDirty();
            }
            case 4: {
                return et.isUpdateManDirty();
            }
            case 5: {
                return et.isWFActorIdDirty();
            }
            case 6: {
                return et.isWFActorNameDirty();
            }
            case 7: {
                return et.isWFActorParamDirty();
            }
            case 8: {
                return et.isWFActorParam2Dirty();
            }
            case 9: {
                return et.isWFActorTypeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        WFActorBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(WFActorBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", WFActorBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", WFActorBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getParams() != null) {
            JSONObjectHelper.put(json, "params", WFActorBase.getJSONValue(et.getParams()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", WFActorBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", WFActorBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getWFActorId() != null) {
            JSONObjectHelper.put(json, "wfactorid", WFActorBase.getJSONValue(et.getWFActorId()), false);
        }
        if (bIncEmpty || et.getWFActorName() != null) {
            JSONObjectHelper.put(json, "wfactorname", WFActorBase.getJSONValue(et.getWFActorName()), false);
        }
        if (bIncEmpty || et.getWFActorParam() != null) {
            JSONObjectHelper.put(json, "wfactorparam", WFActorBase.getJSONValue(et.getWFActorParam()), false);
        }
        if (bIncEmpty || et.getWFActorParam2() != null) {
            JSONObjectHelper.put(json, "wfactorparam2", WFActorBase.getJSONValue(et.getWFActorParam2()), false);
        }
        if (bIncEmpty || et.getWFActorType() != null) {
            JSONObjectHelper.put(json, "wfactortype", WFActorBase.getJSONValue(et.getWFActorType()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        WFActorBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(WFActorBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getParams() != null) {
            obj = et.getParams();
            node.setAttribute(FIELD_PARAMS, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFActorId() != null) {
            obj = et.getWFActorId();
            node.setAttribute(FIELD_WFACTORID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFActorName() != null) {
            obj = et.getWFActorName();
            node.setAttribute(FIELD_WFACTORNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFActorParam() != null) {
            obj = et.getWFActorParam();
            node.setAttribute(FIELD_WFACTORPARAM, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFActorParam2() != null) {
            obj = et.getWFActorParam2();
            node.setAttribute(FIELD_WFACTORPARAM2, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFActorType() != null) {
            obj = et.getWFActorType();
            node.setAttribute(FIELD_WFACTORTYPE, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFActorBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(WFActorBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isParamsDirty() && (bIncEmpty || et.getParams() != null)) {
            dst.set(FIELD_PARAMS, et.getParams());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isWFActorIdDirty() && (bIncEmpty || et.getWFActorId() != null)) {
            dst.set(FIELD_WFACTORID, et.getWFActorId());
        }
        if (et.isWFActorNameDirty() && (bIncEmpty || et.getWFActorName() != null)) {
            dst.set(FIELD_WFACTORNAME, et.getWFActorName());
        }
        if (et.isWFActorParamDirty() && (bIncEmpty || et.getWFActorParam() != null)) {
            dst.set(FIELD_WFACTORPARAM, et.getWFActorParam());
        }
        if (et.isWFActorParam2Dirty() && (bIncEmpty || et.getWFActorParam2() != null)) {
            dst.set(FIELD_WFACTORPARAM2, et.getWFActorParam2());
        }
        if (et.isWFActorTypeDirty() && (bIncEmpty || et.getWFActorType() != null)) {
            dst.set(FIELD_WFACTORTYPE, et.getWFActorType());
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
        return WFActorBase.remove(this, index);
    }

    private static boolean remove(WFActorBase et, int index) throws Exception {
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
                et.resetParams();
                return true;
            }
            case 3: {
                et.resetUpdateDate();
                return true;
            }
            case 4: {
                et.resetUpdateMan();
                return true;
            }
            case 5: {
                et.resetWFActorId();
                return true;
            }
            case 6: {
                et.resetWFActorName();
                return true;
            }
            case 7: {
                et.resetWFActorParam();
                return true;
            }
            case 8: {
                et.resetWFActorParam2();
                return true;
            }
            case 9: {
                et.resetWFActorType();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private WFActorBase getProxyEntity() {
        return this.proxyWFActorBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFActorBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof WFActorBase) {
            this.proxyWFActorBase = (WFActorBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFActorService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

