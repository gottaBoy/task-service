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
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class DSDynaCodeListBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(DSDynaCodeListBase.class);
    public static final String FIELD_CODELISTID = "CODELISTID";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DSDYNACODELISTID = "DSDYNACODELISTID";
    public static final String FIELD_DSDYNACODELISTNAME = "DSDYNACODELISTNAME";
    public static final String FIELD_DYNAMODEL = "DYNAMODEL";
    public static final String FIELD_DYNASYSINSTID = "DYNASYSINSTID";
    public static final String FIELD_INSTVER = "INSTVER";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CODELISTID = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DSDYNACODELISTID = 3;
    private static final int INDEX_DSDYNACODELISTNAME = 4;
    private static final int INDEX_DYNAMODEL = 5;
    private static final int INDEX_DYNASYSINSTID = 6;
    private static final int INDEX_INSTVER = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private DSDynaCodeListBase proxyDSDynaCodeListBase = null;
    private boolean codelistidDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dsdynacodelistidDirtyFlag = false;
    private boolean dsdynacodelistnameDirtyFlag = false;
    private boolean dynamodelDirtyFlag = false;
    private boolean dynasysinstidDirtyFlag = false;
    private boolean instverDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="codelistid")
    private String codelistid;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dsdynacodelistid")
    private String dsdynacodelistid;
    @Column(name="dsdynacodelistname")
    private String dsdynacodelistname;
    @Column(name="dynamodel")
    private String dynamodel;
    @Column(name="dynasysinstid")
    private String dynasysinstid;
    @Column(name="instver")
    private Integer instver;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

    static {
        fieldIndexMap.put(FIELD_CODELISTID, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DSDYNACODELISTID, 3);
        fieldIndexMap.put(FIELD_DSDYNACODELISTNAME, 4);
        fieldIndexMap.put(FIELD_DYNAMODEL, 5);
        fieldIndexMap.put(FIELD_DYNASYSINSTID, 6);
        fieldIndexMap.put(FIELD_INSTVER, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
    }

    public void setCodeListId(String codelistid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeListId(codelistid);
            return;
        }
        if (codelistid != null && (codelistid = StringHelper.trimRight(codelistid)).length() == 0) {
            codelistid = null;
        }
        this.codelistid = codelistid;
        this.codelistidDirtyFlag = true;
    }

    public String getCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeListId();
        }
        return this.codelistid;
    }

    public boolean isCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeListIdDirty();
        }
        return this.codelistidDirtyFlag;
    }

    public void resetCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeListId();
            return;
        }
        this.codelistidDirtyFlag = false;
        this.codelistid = null;
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

    public void setDSDynaCodeListId(String dsdynacodelistid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSDynaCodeListId(dsdynacodelistid);
            return;
        }
        if (dsdynacodelistid != null && (dsdynacodelistid = StringHelper.trimRight(dsdynacodelistid)).length() == 0) {
            dsdynacodelistid = null;
        }
        this.dsdynacodelistid = dsdynacodelistid;
        this.dsdynacodelistidDirtyFlag = true;
    }

    public String getDSDynaCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSDynaCodeListId();
        }
        return this.dsdynacodelistid;
    }

    public boolean isDSDynaCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSDynaCodeListIdDirty();
        }
        return this.dsdynacodelistidDirtyFlag;
    }

    public void resetDSDynaCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSDynaCodeListId();
            return;
        }
        this.dsdynacodelistidDirtyFlag = false;
        this.dsdynacodelistid = null;
    }

    public void setDSDynaCodeListName(String dsdynacodelistname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSDynaCodeListName(dsdynacodelistname);
            return;
        }
        if (dsdynacodelistname != null && (dsdynacodelistname = StringHelper.trimRight(dsdynacodelistname)).length() == 0) {
            dsdynacodelistname = null;
        }
        this.dsdynacodelistname = dsdynacodelistname;
        this.dsdynacodelistnameDirtyFlag = true;
    }

    public String getDSDynaCodeListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSDynaCodeListName();
        }
        return this.dsdynacodelistname;
    }

    public boolean isDSDynaCodeListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSDynaCodeListNameDirty();
        }
        return this.dsdynacodelistnameDirtyFlag;
    }

    public void resetDSDynaCodeListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSDynaCodeListName();
            return;
        }
        this.dsdynacodelistnameDirtyFlag = false;
        this.dsdynacodelistname = null;
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

    public void setInstVer(Integer instver) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstVer(instver);
            return;
        }
        this.instver = instver;
        this.instverDirtyFlag = true;
    }

    public Integer getInstVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstVer();
        }
        return this.instver;
    }

    public boolean isInstVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstVerDirty();
        }
        return this.instverDirtyFlag;
    }

    public void resetInstVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstVer();
            return;
        }
        this.instverDirtyFlag = false;
        this.instver = null;
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

    @Override
    protected void onReset() {
        DSDynaCodeListBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(DSDynaCodeListBase et) {
        et.resetCodeListId();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDSDynaCodeListId();
        et.resetDSDynaCodeListName();
        et.resetDynaModel();
        et.resetDynaSysInstId();
        et.resetInstVer();
        et.resetUpdateDate();
        et.resetUpdateMan();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCodeListIdDirty()) {
            params.put(FIELD_CODELISTID, this.getCodeListId());
        }
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isDSDynaCodeListIdDirty()) {
            params.put(FIELD_DSDYNACODELISTID, this.getDSDynaCodeListId());
        }
        if (!bDirtyOnly || this.isDSDynaCodeListNameDirty()) {
            params.put(FIELD_DSDYNACODELISTNAME, this.getDSDynaCodeListName());
        }
        if (!bDirtyOnly || this.isDynaModelDirty()) {
            params.put(FIELD_DYNAMODEL, this.getDynaModel());
        }
        if (!bDirtyOnly || this.isDynaSysInstIdDirty()) {
            params.put(FIELD_DYNASYSINSTID, this.getDynaSysInstId());
        }
        if (!bDirtyOnly || this.isInstVerDirty()) {
            params.put(FIELD_INSTVER, this.getInstVer());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return DSDynaCodeListBase.get(this, index);
    }

    private static Object get(DSDynaCodeListBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCodeListId();
            }
            case 1: {
                return et.getCreateDate();
            }
            case 2: {
                return et.getCreateMan();
            }
            case 3: {
                return et.getDSDynaCodeListId();
            }
            case 4: {
                return et.getDSDynaCodeListName();
            }
            case 5: {
                return et.getDynaModel();
            }
            case 6: {
                return et.getDynaSysInstId();
            }
            case 7: {
                return et.getInstVer();
            }
            case 8: {
                return et.getUpdateDate();
            }
            case 9: {
                return et.getUpdateMan();
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
        DSDynaCodeListBase.set(this, index, objValue);
    }

    private static void set(DSDynaCodeListBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setCodeListId(DataObject.getStringValue(obj));
                return;
            }
            case 1: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 2: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setDSDynaCodeListId(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setDSDynaCodeListName(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setDynaModel(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setDynaSysInstId(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setInstVer(DataObject.getIntegerValue(obj));
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
        return DSDynaCodeListBase.isNull(this, index);
    }

    private static boolean isNull(DSDynaCodeListBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCodeListId() == null;
            }
            case 1: {
                return et.getCreateDate() == null;
            }
            case 2: {
                return et.getCreateMan() == null;
            }
            case 3: {
                return et.getDSDynaCodeListId() == null;
            }
            case 4: {
                return et.getDSDynaCodeListName() == null;
            }
            case 5: {
                return et.getDynaModel() == null;
            }
            case 6: {
                return et.getDynaSysInstId() == null;
            }
            case 7: {
                return et.getInstVer() == null;
            }
            case 8: {
                return et.getUpdateDate() == null;
            }
            case 9: {
                return et.getUpdateMan() == null;
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
        return DSDynaCodeListBase.contains(this, index);
    }

    private static boolean contains(DSDynaCodeListBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCodeListIdDirty();
            }
            case 1: {
                return et.isCreateDateDirty();
            }
            case 2: {
                return et.isCreateManDirty();
            }
            case 3: {
                return et.isDSDynaCodeListIdDirty();
            }
            case 4: {
                return et.isDSDynaCodeListNameDirty();
            }
            case 5: {
                return et.isDynaModelDirty();
            }
            case 6: {
                return et.isDynaSysInstIdDirty();
            }
            case 7: {
                return et.isInstVerDirty();
            }
            case 8: {
                return et.isUpdateDateDirty();
            }
            case 9: {
                return et.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        DSDynaCodeListBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(DSDynaCodeListBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCodeListId() != null) {
            JSONObjectHelper.put(json, "codelistid", DSDynaCodeListBase.getJSONValue(et.getCodeListId()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", DSDynaCodeListBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", DSDynaCodeListBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getDSDynaCodeListId() != null) {
            JSONObjectHelper.put(json, "dsdynacodelistid", DSDynaCodeListBase.getJSONValue(et.getDSDynaCodeListId()), false);
        }
        if (bIncEmpty || et.getDSDynaCodeListName() != null) {
            JSONObjectHelper.put(json, "dsdynacodelistname", DSDynaCodeListBase.getJSONValue(et.getDSDynaCodeListName()), false);
        }
        if (bIncEmpty || et.getDynaModel() != null) {
            JSONObjectHelper.put(json, "dynamodel", DSDynaCodeListBase.getJSONValue(et.getDynaModel()), false);
        }
        if (bIncEmpty || et.getDynaSysInstId() != null) {
            JSONObjectHelper.put(json, "dynasysinstid", DSDynaCodeListBase.getJSONValue(et.getDynaSysInstId()), false);
        }
        if (bIncEmpty || et.getInstVer() != null) {
            JSONObjectHelper.put(json, "instver", DSDynaCodeListBase.getJSONValue(et.getInstVer()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", DSDynaCodeListBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", DSDynaCodeListBase.getJSONValue(et.getUpdateMan()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        DSDynaCodeListBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(DSDynaCodeListBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCodeListId() != null) {
            obj = et.getCodeListId();
            node.setAttribute(FIELD_CODELISTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDSDynaCodeListId() != null) {
            obj = et.getDSDynaCodeListId();
            node.setAttribute(FIELD_DSDYNACODELISTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDSDynaCodeListName() != null) {
            obj = et.getDSDynaCodeListName();
            node.setAttribute(FIELD_DSDYNACODELISTNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDynaModel() != null) {
            obj = et.getDynaModel();
            node.setAttribute(FIELD_DYNAMODEL, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDynaSysInstId() != null) {
            obj = et.getDynaSysInstId();
            node.setAttribute(FIELD_DYNASYSINSTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getInstVer() != null) {
            obj = et.getInstVer();
            node.setAttribute(FIELD_INSTVER, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        DSDynaCodeListBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(DSDynaCodeListBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCodeListIdDirty() && (bIncEmpty || et.getCodeListId() != null)) {
            dst.set(FIELD_CODELISTID, et.getCodeListId());
        }
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isDSDynaCodeListIdDirty() && (bIncEmpty || et.getDSDynaCodeListId() != null)) {
            dst.set(FIELD_DSDYNACODELISTID, et.getDSDynaCodeListId());
        }
        if (et.isDSDynaCodeListNameDirty() && (bIncEmpty || et.getDSDynaCodeListName() != null)) {
            dst.set(FIELD_DSDYNACODELISTNAME, et.getDSDynaCodeListName());
        }
        if (et.isDynaModelDirty() && (bIncEmpty || et.getDynaModel() != null)) {
            dst.set(FIELD_DYNAMODEL, et.getDynaModel());
        }
        if (et.isDynaSysInstIdDirty() && (bIncEmpty || et.getDynaSysInstId() != null)) {
            dst.set(FIELD_DYNASYSINSTID, et.getDynaSysInstId());
        }
        if (et.isInstVerDirty() && (bIncEmpty || et.getInstVer() != null)) {
            dst.set(FIELD_INSTVER, et.getInstVer());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
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
        return DSDynaCodeListBase.remove(this, index);
    }

    private static boolean remove(DSDynaCodeListBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetCodeListId();
                return true;
            }
            case 1: {
                et.resetCreateDate();
                return true;
            }
            case 2: {
                et.resetCreateMan();
                return true;
            }
            case 3: {
                et.resetDSDynaCodeListId();
                return true;
            }
            case 4: {
                et.resetDSDynaCodeListName();
                return true;
            }
            case 5: {
                et.resetDynaModel();
                return true;
            }
            case 6: {
                et.resetDynaSysInstId();
                return true;
            }
            case 7: {
                et.resetInstVer();
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
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private DSDynaCodeListBase getProxyEntity() {
        return this.proxyDSDynaCodeListBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyDSDynaCodeListBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof DSDynaCodeListBase) {
            this.proxyDSDynaCodeListBase = (DSDynaCodeListBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.dynasys.service.DSDynaCodeListService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

