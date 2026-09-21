/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.common.entity;

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

public abstract class PortalPageBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PortalPageBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLECTX = "ENABLECTX";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PORTALPAGEID = "PORTALPAGEID";
    public static final String FIELD_PORTALPAGEMEMO = "PORTALPAGEMEMO";
    public static final String FIELD_PORTALPAGENAME = "PORTALPAGENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ENABLECTX = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PORTALPAGEID = 4;
    private static final int INDEX_PORTALPAGEMEMO = 5;
    private static final int INDEX_PORTALPAGENAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PortalPageBase proxyPortalPageBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enablectxDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean portalpageidDirtyFlag = false;
    private boolean portalpagememoDirtyFlag = false;
    private boolean portalpagenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enablectx")
    private Integer enablectx;
    @Column(name="memo")
    private String memo;
    @Column(name="portalpageid")
    private String portalpageid;
    @Column(name="portalpagememo")
    private String portalpagememo;
    @Column(name="portalpagename")
    private String portalpagename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ENABLECTX, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PORTALPAGEID, 4);
        fieldIndexMap.put(FIELD_PORTALPAGEMEMO, 5);
        fieldIndexMap.put(FIELD_PORTALPAGENAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
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

    public void setEnableCTX(Integer enablectx) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableCTX(enablectx);
            return;
        }
        this.enablectx = enablectx;
        this.enablectxDirtyFlag = true;
    }

    public Integer getEnableCTX() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableCTX();
        }
        return this.enablectx;
    }

    public boolean isEnableCTXDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableCTXDirty();
        }
        return this.enablectxDirtyFlag;
    }

    public void resetEnableCTX() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableCTX();
            return;
        }
        this.enablectxDirtyFlag = false;
        this.enablectx = null;
    }

    public void setMemo(String memo) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(memo);
            return;
        }
        if (memo != null && (memo = StringHelper.trimRight(memo)).length() == 0) {
            memo = null;
        }
        this.memo = memo;
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

    public void setPortalPageId(String portalpageid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPortalPageId(portalpageid);
            return;
        }
        if (portalpageid != null && (portalpageid = StringHelper.trimRight(portalpageid)).length() == 0) {
            portalpageid = null;
        }
        this.portalpageid = portalpageid;
        this.portalpageidDirtyFlag = true;
    }

    public String getPortalPageId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPortalPageId();
        }
        return this.portalpageid;
    }

    public boolean isPortalPageIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPortalPageIdDirty();
        }
        return this.portalpageidDirtyFlag;
    }

    public void resetPortalPageId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPortalPageId();
            return;
        }
        this.portalpageidDirtyFlag = false;
        this.portalpageid = null;
    }

    public void setPortalPageMemo(String portalpagememo) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPortalPageMemo(portalpagememo);
            return;
        }
        if (portalpagememo != null && (portalpagememo = StringHelper.trimRight(portalpagememo)).length() == 0) {
            portalpagememo = null;
        }
        this.portalpagememo = portalpagememo;
        this.portalpagememoDirtyFlag = true;
    }

    public String getPortalPageMemo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPortalPageMemo();
        }
        return this.portalpagememo;
    }

    public boolean isPortalPageMemoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPortalPageMemoDirty();
        }
        return this.portalpagememoDirtyFlag;
    }

    public void resetPortalPageMemo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPortalPageMemo();
            return;
        }
        this.portalpagememoDirtyFlag = false;
        this.portalpagememo = null;
    }

    public void setPortalPageName(String portalpagename) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPortalPageName(portalpagename);
            return;
        }
        if (portalpagename != null && (portalpagename = StringHelper.trimRight(portalpagename)).length() == 0) {
            portalpagename = null;
        }
        this.portalpagename = portalpagename;
        this.portalpagenameDirtyFlag = true;
    }

    public String getPortalPageName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPortalPageName();
        }
        return this.portalpagename;
    }

    public boolean isPortalPageNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPortalPageNameDirty();
        }
        return this.portalpagenameDirtyFlag;
    }

    public void resetPortalPageName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPortalPageName();
            return;
        }
        this.portalpagenameDirtyFlag = false;
        this.portalpagename = null;
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
        PortalPageBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PortalPageBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetEnableCTX();
        et.resetMemo();
        et.resetPortalPageId();
        et.resetPortalPageMemo();
        et.resetPortalPageName();
        et.resetUpdateDate();
        et.resetUpdateMan();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isEnableCTXDirty()) {
            params.put(FIELD_ENABLECTX, this.getEnableCTX());
        }
        if (!bDirtyOnly || this.isMemoDirty()) {
            params.put(FIELD_MEMO, this.getMemo());
        }
        if (!bDirtyOnly || this.isPortalPageIdDirty()) {
            params.put(FIELD_PORTALPAGEID, this.getPortalPageId());
        }
        if (!bDirtyOnly || this.isPortalPageMemoDirty()) {
            params.put(FIELD_PORTALPAGEMEMO, this.getPortalPageMemo());
        }
        if (!bDirtyOnly || this.isPortalPageNameDirty()) {
            params.put(FIELD_PORTALPAGENAME, this.getPortalPageName());
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
        return PortalPageBase.get(this, index);
    }

    private static Object get(PortalPageBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getEnableCTX();
            }
            case 3: {
                return et.getMemo();
            }
            case 4: {
                return et.getPortalPageId();
            }
            case 5: {
                return et.getPortalPageMemo();
            }
            case 6: {
                return et.getPortalPageName();
            }
            case 7: {
                return et.getUpdateDate();
            }
            case 8: {
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
        PortalPageBase.set(this, index, objValue);
    }

    private static void set(PortalPageBase et, int index, Object obj) throws Exception {
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
                et.setEnableCTX(DataObject.getIntegerValue(obj));
                return;
            }
            case 3: {
                et.setMemo(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setPortalPageId(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setPortalPageMemo(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setPortalPageName(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 8: {
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
        return PortalPageBase.isNull(this, index);
    }

    private static boolean isNull(PortalPageBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getEnableCTX() == null;
            }
            case 3: {
                return et.getMemo() == null;
            }
            case 4: {
                return et.getPortalPageId() == null;
            }
            case 5: {
                return et.getPortalPageMemo() == null;
            }
            case 6: {
                return et.getPortalPageName() == null;
            }
            case 7: {
                return et.getUpdateDate() == null;
            }
            case 8: {
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
        return PortalPageBase.contains(this, index);
    }

    private static boolean contains(PortalPageBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isEnableCTXDirty();
            }
            case 3: {
                return et.isMemoDirty();
            }
            case 4: {
                return et.isPortalPageIdDirty();
            }
            case 5: {
                return et.isPortalPageMemoDirty();
            }
            case 6: {
                return et.isPortalPageNameDirty();
            }
            case 7: {
                return et.isUpdateDateDirty();
            }
            case 8: {
                return et.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        PortalPageBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(PortalPageBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", PortalPageBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", PortalPageBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getEnableCTX() != null) {
            JSONObjectHelper.put(json, "enablectx", PortalPageBase.getJSONValue(et.getEnableCTX()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", PortalPageBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getPortalPageId() != null) {
            JSONObjectHelper.put(json, "portalpageid", PortalPageBase.getJSONValue(et.getPortalPageId()), false);
        }
        if (bIncEmpty || et.getPortalPageMemo() != null) {
            JSONObjectHelper.put(json, "portalpagememo", PortalPageBase.getJSONValue(et.getPortalPageMemo()), false);
        }
        if (bIncEmpty || et.getPortalPageName() != null) {
            JSONObjectHelper.put(json, "portalpagename", PortalPageBase.getJSONValue(et.getPortalPageName()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", PortalPageBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", PortalPageBase.getJSONValue(et.getUpdateMan()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        PortalPageBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(PortalPageBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getEnableCTX() != null) {
            obj = et.getEnableCTX();
            node.setAttribute(FIELD_ENABLECTX, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getMemo() != null) {
            obj = et.getMemo();
            node.setAttribute(FIELD_MEMO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getPortalPageId() != null) {
            obj = et.getPortalPageId();
            node.setAttribute(FIELD_PORTALPAGEID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getPortalPageMemo() != null) {
            obj = et.getPortalPageMemo();
            node.setAttribute(FIELD_PORTALPAGEMEMO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getPortalPageName() != null) {
            obj = et.getPortalPageName();
            node.setAttribute(FIELD_PORTALPAGENAME, obj == null ? "" : (String)obj);
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
        PortalPageBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(PortalPageBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isEnableCTXDirty() && (bIncEmpty || et.getEnableCTX() != null)) {
            dst.set(FIELD_ENABLECTX, et.getEnableCTX());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
        }
        if (et.isPortalPageIdDirty() && (bIncEmpty || et.getPortalPageId() != null)) {
            dst.set(FIELD_PORTALPAGEID, et.getPortalPageId());
        }
        if (et.isPortalPageMemoDirty() && (bIncEmpty || et.getPortalPageMemo() != null)) {
            dst.set(FIELD_PORTALPAGEMEMO, et.getPortalPageMemo());
        }
        if (et.isPortalPageNameDirty() && (bIncEmpty || et.getPortalPageName() != null)) {
            dst.set(FIELD_PORTALPAGENAME, et.getPortalPageName());
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
        return PortalPageBase.remove(this, index);
    }

    private static boolean remove(PortalPageBase et, int index) throws Exception {
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
                et.resetEnableCTX();
                return true;
            }
            case 3: {
                et.resetMemo();
                return true;
            }
            case 4: {
                et.resetPortalPageId();
                return true;
            }
            case 5: {
                et.resetPortalPageMemo();
                return true;
            }
            case 6: {
                et.resetPortalPageName();
                return true;
            }
            case 7: {
                et.resetUpdateDate();
                return true;
            }
            case 8: {
                et.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PortalPageBase getProxyEntity() {
        return this.proxyPortalPageBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyPortalPageBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof PortalPageBase) {
            this.proxyPortalPageBase = (PortalPageBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.PortalPageService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

