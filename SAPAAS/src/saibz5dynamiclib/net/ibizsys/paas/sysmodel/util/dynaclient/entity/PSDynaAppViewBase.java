/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.sysmodel.util.dynaclient.entity;

import java.io.Serializable;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDynaAppViewBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDynaAppViewBase.class);
    public static final String FIELD_PSDYNAAPPVIEWID = "PSDYNAAPPVIEWID";
    public static final String FIELD_PSDYNAAPPVIEWNAME = "PSDYNAAPPVIEWNAME";
    public static final String FIELD_VIEWTYPE = "VIEWTYPE";
    public static final String FIELD_PDVTPARAM = "PDVTPARAM";
    public static final String FIELD_PREDEFINEDVIEWTYPE = "PREDEFINEDVIEWTYPE";
    public static final String FIELD_PSWFDEID = "PSWFDEID";
    public static final String FIELD_PSDYNADEID = "PSDYNADEID";
    private static final int INDEX_PSDYNAAPPVIEWID = 0;
    private static final int INDEX_PSDYNAAPPVIEWNAME = 1;
    private static final int INDEX_VIEWTYPE = 2;
    private static final int INDEX_PDVTPARAM = 3;
    private static final int INDEX_PREDEFINEDVIEWTYPE = 4;
    private static final int INDEX_PSWFDEID = 5;
    private static final int INDEX_PSDYNADEID = 6;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDynaAppViewBase proxyPSDynaAppViewBase = null;
    private boolean psdynaappviewidDirtyFlag = false;
    private boolean psdynaappviewnameDirtyFlag = false;
    private boolean viewtypeDirtyFlag = false;
    private boolean pdvtparamDirtyFlag = false;
    private boolean predefinedviewtypeDirtyFlag = false;
    private boolean pswfdeidDirtyFlag = false;
    private boolean psdynadeidDirtyFlag = false;
    @Column(name="psdynaappviewid")
    private String psdynaappviewid;
    @Column(name="psdynaappviewname")
    private String psdynaappviewname;
    @Column(name="viewtype")
    private String viewtype;
    @Column(name="pdvtparam")
    private String pdvtparam;
    @Column(name="predefinedviewtype")
    private String predefinedviewtype;
    @Column(name="pswfdeid")
    private String pswfdeid;
    @Column(name="psdynadeid")
    private String psdynadeid;

    static {
        fieldIndexMap.put(FIELD_PSDYNAAPPVIEWID, 0);
        fieldIndexMap.put(FIELD_PSDYNAAPPVIEWNAME, 1);
        fieldIndexMap.put(FIELD_VIEWTYPE, 2);
        fieldIndexMap.put(FIELD_PDVTPARAM, 3);
        fieldIndexMap.put(FIELD_PREDEFINEDVIEWTYPE, 4);
        fieldIndexMap.put(FIELD_PSWFDEID, 5);
        fieldIndexMap.put(FIELD_PSDYNADEID, 6);
    }

    public void setPSDynaAppViewId(String psdynaappviewid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaAppViewId(psdynaappviewid);
            return;
        }
        if (psdynaappviewid != null && (psdynaappviewid = StringHelper.trimRight((String)psdynaappviewid)).length() == 0) {
            psdynaappviewid = null;
        }
        this.psdynaappviewid = psdynaappviewid;
        this.psdynaappviewidDirtyFlag = true;
    }

    public String getPSDynaAppViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppViewId();
        }
        return this.psdynaappviewid;
    }

    public boolean isPSDynaAppViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaAppViewIdDirty();
        }
        return this.psdynaappviewidDirtyFlag;
    }

    public void resetPSDynaAppViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaAppViewId();
            return;
        }
        this.psdynaappviewidDirtyFlag = false;
        this.psdynaappviewid = null;
    }

    public void setPSDynaAppViewName(String psdynaappviewname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaAppViewName(psdynaappviewname);
            return;
        }
        if (psdynaappviewname != null && (psdynaappviewname = StringHelper.trimRight((String)psdynaappviewname)).length() == 0) {
            psdynaappviewname = null;
        }
        this.psdynaappviewname = psdynaappviewname;
        this.psdynaappviewnameDirtyFlag = true;
    }

    public String getPSDynaAppViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppViewName();
        }
        return this.psdynaappviewname;
    }

    public boolean isPSDynaAppViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaAppViewNameDirty();
        }
        return this.psdynaappviewnameDirtyFlag;
    }

    public void resetPSDynaAppViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaAppViewName();
            return;
        }
        this.psdynaappviewnameDirtyFlag = false;
        this.psdynaappviewname = null;
    }

    public void setViewType(String viewtype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewType(viewtype);
            return;
        }
        if (viewtype != null && (viewtype = StringHelper.trimRight((String)viewtype)).length() == 0) {
            viewtype = null;
        }
        this.viewtype = viewtype;
        this.viewtypeDirtyFlag = true;
    }

    public String getViewType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewType();
        }
        return this.viewtype;
    }

    public boolean isViewTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewTypeDirty();
        }
        return this.viewtypeDirtyFlag;
    }

    public void resetViewType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewType();
            return;
        }
        this.viewtypeDirtyFlag = false;
        this.viewtype = null;
    }

    public void setPDVTParam(String pdvtparam) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPDVTParam(pdvtparam);
            return;
        }
        if (pdvtparam != null && (pdvtparam = StringHelper.trimRight((String)pdvtparam)).length() == 0) {
            pdvtparam = null;
        }
        this.pdvtparam = pdvtparam;
        this.pdvtparamDirtyFlag = true;
    }

    public String getPDVTParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPDVTParam();
        }
        return this.pdvtparam;
    }

    public boolean isPDVTParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPDVTParamDirty();
        }
        return this.pdvtparamDirtyFlag;
    }

    public void resetPDVTParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPDVTParam();
            return;
        }
        this.pdvtparamDirtyFlag = false;
        this.pdvtparam = null;
    }

    public void setPredefinedViewType(String predefinedviewtype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPredefinedViewType(predefinedviewtype);
            return;
        }
        if (predefinedviewtype != null && (predefinedviewtype = StringHelper.trimRight((String)predefinedviewtype)).length() == 0) {
            predefinedviewtype = null;
        }
        this.predefinedviewtype = predefinedviewtype;
        this.predefinedviewtypeDirtyFlag = true;
    }

    public String getPredefinedViewType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPredefinedViewType();
        }
        return this.predefinedviewtype;
    }

    public boolean isPredefinedViewTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPredefinedViewTypeDirty();
        }
        return this.predefinedviewtypeDirtyFlag;
    }

    public void resetPredefinedViewType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPredefinedViewType();
            return;
        }
        this.predefinedviewtypeDirtyFlag = false;
        this.predefinedviewtype = null;
    }

    public void setPSWFDEId(String pswfdeid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFDEId(pswfdeid);
            return;
        }
        if (pswfdeid != null && (pswfdeid = StringHelper.trimRight((String)pswfdeid)).length() == 0) {
            pswfdeid = null;
        }
        this.pswfdeid = pswfdeid;
        this.pswfdeidDirtyFlag = true;
    }

    public String getPSWFDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFDEId();
        }
        return this.pswfdeid;
    }

    public boolean isPSWFDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFDEIdDirty();
        }
        return this.pswfdeidDirtyFlag;
    }

    public void resetPSWFDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFDEId();
            return;
        }
        this.pswfdeidDirtyFlag = false;
        this.pswfdeid = null;
    }

    public void setPSDynaDEId(String psdynadeid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaDEId(psdynadeid);
            return;
        }
        if (psdynadeid != null && (psdynadeid = StringHelper.trimRight((String)psdynadeid)).length() == 0) {
            psdynadeid = null;
        }
        this.psdynadeid = psdynadeid;
        this.psdynadeidDirtyFlag = true;
    }

    public String getPSDynaDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEId();
        }
        return this.psdynadeid;
    }

    public boolean isPSDynaDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaDEIdDirty();
        }
        return this.psdynadeidDirtyFlag;
    }

    public void resetPSDynaDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaDEId();
            return;
        }
        this.psdynadeidDirtyFlag = false;
        this.psdynadeid = null;
    }

    protected void onReset() {
        PSDynaAppViewBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDynaAppViewBase et) {
        et.resetPSDynaAppViewId();
        et.resetPSDynaAppViewName();
        et.resetViewType();
        et.resetPDVTParam();
        et.resetPredefinedViewType();
        et.resetPSWFDEId();
        et.resetPSDynaDEId();
    }

    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isPSDynaAppViewIdDirty()) {
            params.put(FIELD_PSDYNAAPPVIEWID, this.getPSDynaAppViewId());
        }
        if (!bDirtyOnly || this.isPSDynaAppViewNameDirty()) {
            params.put(FIELD_PSDYNAAPPVIEWNAME, this.getPSDynaAppViewName());
        }
        if (!bDirtyOnly || this.isViewTypeDirty()) {
            params.put(FIELD_VIEWTYPE, this.getViewType());
        }
        if (!bDirtyOnly || this.isPDVTParamDirty()) {
            params.put(FIELD_PDVTPARAM, this.getPDVTParam());
        }
        if (!bDirtyOnly || this.isPredefinedViewTypeDirty()) {
            params.put(FIELD_PREDEFINEDVIEWTYPE, this.getPredefinedViewType());
        }
        if (!bDirtyOnly || this.isPSWFDEIdDirty()) {
            params.put(FIELD_PSWFDEID, this.getPSWFDEId());
        }
        if (!bDirtyOnly || this.isPSDynaDEIdDirty()) {
            params.put(FIELD_PSDYNADEID, this.getPSDynaDEId());
        }
        super.onFillMap(params, bDirtyOnly);
    }

    public Object get(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(strParamName);
        }
        if (StringHelper.isNullOrEmpty((String)strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.get(strParamName);
        }
        return PSDynaAppViewBase.get(this, index);
    }

    private static Object get(PSDynaAppViewBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getPSDynaAppViewId();
            }
            case 1: {
                return et.getPSDynaAppViewName();
            }
            case 2: {
                return et.getViewType();
            }
            case 3: {
                return et.getPDVTParam();
            }
            case 4: {
                return et.getPredefinedViewType();
            }
            case 5: {
                return et.getPSWFDEId();
            }
            case 6: {
                return et.getPSDynaDEId();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public void set(String strParamName, Object objValue) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(strParamName, objValue);
            return;
        }
        if (StringHelper.isNullOrEmpty((String)strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            super.set(strParamName, objValue);
            return;
        }
        PSDynaAppViewBase.set(this, index, objValue);
    }

    private static void set(PSDynaAppViewBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setPSDynaAppViewId(DataObject.getStringValue((Object)obj));
                return;
            }
            case 1: {
                et.setPSDynaAppViewName(DataObject.getStringValue((Object)obj));
                return;
            }
            case 2: {
                et.setViewType(DataObject.getStringValue((Object)obj));
                return;
            }
            case 3: {
                et.setPDVTParam(DataObject.getStringValue((Object)obj));
                return;
            }
            case 4: {
                et.setPredefinedViewType(DataObject.getStringValue((Object)obj));
                return;
            }
            case 5: {
                et.setPSWFDEId(DataObject.getStringValue((Object)obj));
                return;
            }
            case 6: {
                et.setPSDynaDEId(DataObject.getStringValue((Object)obj));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public boolean isNull(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(strParamName);
        }
        if (StringHelper.isNullOrEmpty((String)strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.isNull(strParamName);
        }
        return PSDynaAppViewBase.isNull(this, index);
    }

    private static boolean isNull(PSDynaAppViewBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getPSDynaAppViewId() == null;
            }
            case 1: {
                return et.getPSDynaAppViewName() == null;
            }
            case 2: {
                return et.getViewType() == null;
            }
            case 3: {
                return et.getPDVTParam() == null;
            }
            case 4: {
                return et.getPredefinedViewType() == null;
            }
            case 5: {
                return et.getPSWFDEId() == null;
            }
            case 6: {
                return et.getPSDynaDEId() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public boolean contains(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(strParamName);
        }
        if (StringHelper.isNullOrEmpty((String)strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.contains(strParamName);
        }
        return PSDynaAppViewBase.contains(this, index);
    }

    private static boolean contains(PSDynaAppViewBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isPSDynaAppViewIdDirty();
            }
            case 1: {
                return et.isPSDynaAppViewNameDirty();
            }
            case 2: {
                return et.isViewTypeDirty();
            }
            case 3: {
                return et.isPDVTParamDirty();
            }
            case 4: {
                return et.isPredefinedViewTypeDirty();
            }
            case 5: {
                return et.isPSWFDEIdDirty();
            }
            case 6: {
                return et.isPSDynaDEIdDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        PSDynaAppViewBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(PSDynaAppViewBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getPSDynaAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)json, (String)"psdynaappviewid", (Object)PSDynaAppViewBase.getJSONValue((Object)et.getPSDynaAppViewId()), (boolean)false);
        }
        if (bIncEmpty || et.getPSDynaAppViewName() != null) {
            JSONObjectHelper.put((JSONObject)json, (String)"psdynaappviewname", (Object)PSDynaAppViewBase.getJSONValue((Object)et.getPSDynaAppViewName()), (boolean)false);
        }
        if (bIncEmpty || et.getViewType() != null) {
            JSONObjectHelper.put((JSONObject)json, (String)"viewtype", (Object)PSDynaAppViewBase.getJSONValue((Object)et.getViewType()), (boolean)false);
        }
        if (bIncEmpty || et.getPDVTParam() != null) {
            JSONObjectHelper.put((JSONObject)json, (String)"pdvtparam", (Object)PSDynaAppViewBase.getJSONValue((Object)et.getPDVTParam()), (boolean)false);
        }
        if (bIncEmpty || et.getPredefinedViewType() != null) {
            JSONObjectHelper.put((JSONObject)json, (String)"predefinedviewtype", (Object)PSDynaAppViewBase.getJSONValue((Object)et.getPredefinedViewType()), (boolean)false);
        }
        if (bIncEmpty || et.getPSWFDEId() != null) {
            JSONObjectHelper.put((JSONObject)json, (String)"pswfdeid", (Object)PSDynaAppViewBase.getJSONValue((Object)et.getPSWFDEId()), (boolean)false);
        }
        if (bIncEmpty || et.getPSDynaDEId() != null) {
            JSONObjectHelper.put((JSONObject)json, (String)"psdynadeid", (Object)PSDynaAppViewBase.getJSONValue((Object)et.getPSDynaDEId()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        PSDynaAppViewBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(PSDynaAppViewBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        String obj;
        if (bIncEmpty || et.getPSDynaAppViewId() != null) {
            obj = et.getPSDynaAppViewId();
            node.setAttribute(FIELD_PSDYNAAPPVIEWID, obj == null ? "" : obj);
        }
        if (bIncEmpty || et.getPSDynaAppViewName() != null) {
            obj = et.getPSDynaAppViewName();
            node.setAttribute(FIELD_PSDYNAAPPVIEWNAME, obj == null ? "" : obj);
        }
        if (bIncEmpty || et.getViewType() != null) {
            obj = et.getViewType();
            node.setAttribute(FIELD_VIEWTYPE, obj == null ? "" : obj);
        }
        if (bIncEmpty || et.getPDVTParam() != null) {
            obj = et.getPDVTParam();
            node.setAttribute(FIELD_PDVTPARAM, obj == null ? "" : obj);
        }
        if (bIncEmpty || et.getPredefinedViewType() != null) {
            obj = et.getPredefinedViewType();
            node.setAttribute(FIELD_PREDEFINEDVIEWTYPE, obj == null ? "" : obj);
        }
        if (bIncEmpty || et.getPSWFDEId() != null) {
            obj = et.getPSWFDEId();
            node.setAttribute(FIELD_PSWFDEID, obj == null ? "" : obj);
        }
        if (bIncEmpty || et.getPSDynaDEId() != null) {
            obj = et.getPSDynaDEId();
            node.setAttribute(FIELD_PSDYNADEID, obj == null ? "" : obj);
        }
    }

    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        PSDynaAppViewBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(PSDynaAppViewBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isPSDynaAppViewIdDirty() && (bIncEmpty || et.getPSDynaAppViewId() != null)) {
            dst.set(FIELD_PSDYNAAPPVIEWID, (Object)et.getPSDynaAppViewId());
        }
        if (et.isPSDynaAppViewNameDirty() && (bIncEmpty || et.getPSDynaAppViewName() != null)) {
            dst.set(FIELD_PSDYNAAPPVIEWNAME, (Object)et.getPSDynaAppViewName());
        }
        if (et.isViewTypeDirty() && (bIncEmpty || et.getViewType() != null)) {
            dst.set(FIELD_VIEWTYPE, (Object)et.getViewType());
        }
        if (et.isPDVTParamDirty() && (bIncEmpty || et.getPDVTParam() != null)) {
            dst.set(FIELD_PDVTPARAM, (Object)et.getPDVTParam());
        }
        if (et.isPredefinedViewTypeDirty() && (bIncEmpty || et.getPredefinedViewType() != null)) {
            dst.set(FIELD_PREDEFINEDVIEWTYPE, (Object)et.getPredefinedViewType());
        }
        if (et.isPSWFDEIdDirty() && (bIncEmpty || et.getPSWFDEId() != null)) {
            dst.set(FIELD_PSWFDEID, (Object)et.getPSWFDEId());
        }
        if (et.isPSDynaDEIdDirty() && (bIncEmpty || et.getPSDynaDEId() != null)) {
            dst.set(FIELD_PSDYNADEID, (Object)et.getPSDynaDEId());
        }
    }

    public boolean remove(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(strParamName);
        }
        if (StringHelper.isNullOrEmpty((String)strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.remove(strParamName);
        }
        return PSDynaAppViewBase.remove(this, index);
    }

    private static boolean remove(PSDynaAppViewBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetPSDynaAppViewId();
                return true;
            }
            case 1: {
                et.resetPSDynaAppViewName();
                return true;
            }
            case 2: {
                et.resetViewType();
                return true;
            }
            case 3: {
                et.resetPDVTParam();
                return true;
            }
            case 4: {
                et.resetPredefinedViewType();
                return true;
            }
            case 5: {
                et.resetPSWFDEId();
                return true;
            }
            case 6: {
                et.resetPSDynaDEId();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDynaAppViewBase getProxyEntity() {
        return this.proxyPSDynaAppViewBase;
    }

    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyPSDynaAppViewBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof PSDynaAppViewBase) {
            this.proxyPSDynaAppViewBase = (PSDynaAppViewBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }
}

