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
package net.ibizsys.pscore.srv.sysdevstudio.entity;

import java.io.Serializable;
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
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUWDELogicNodeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSUWDELogicNodeBase.class);
    public static final String FIELD_LOGICNODETYPE = "LOGICNODETYPE";
    public static final String FIELD_PSDELOGICID = "PSDELOGICID";
    public static final String FIELD_PSDELOGICNODEID = "PSDELOGICNODEID";
    public static final String FIELD_PSDELOGICNODENAME = "PSDELOGICNODENAME";
    public static final String FIELD_DRAFTFLAG = "SRFDRAFTFLAG";
    private static final int INDEX_LOGICNODETYPE = 0;
    private static final int INDEX_PSDELOGICID = 1;
    private static final int INDEX_PSDELOGICNODEID = 2;
    private static final int INDEX_PSDELOGICNODENAME = 3;
    private static final int INDEX_DRAFTFLAG = 4;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSUWDELogicNodeBase proxyPSUWDELogicNodeBase = null;
    private boolean logicnodetypeDirtyFlag = false;
    private boolean psdelogicidDirtyFlag = false;
    private boolean psdelogicnodeidDirtyFlag = false;
    private boolean psdelogicnodenameDirtyFlag = false;
    private boolean draftflagDirtyFlag = false;
    @Column(name="logicnodetype")
    private String logicnodetype;
    @Column(name="psdelogicid")
    private String psdelogicid;
    @Column(name="psdelogicnodeid")
    private String psdelogicnodeid;
    @Column(name="psdelogicnodename")
    private String psdelogicnodename;
    @Column(name="draftflag")
    private Integer draftflag;
    private Integer objPSDELogicLock = new Integer(1);
    private PSDELogic psdelogic = null;

    public void setLogicNodeType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicNodeType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicnodetype = string;
        this.logicnodetypeDirtyFlag = true;
    }

    public String getLogicNodeType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicNodeType();
        }
        return this.logicnodetype;
    }

    public boolean isLogicNodeTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNodeTypeDirty();
        }
        return this.logicnodetypeDirtyFlag;
    }

    public void resetLogicNodeType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicNodeType();
            return;
        }
        this.logicnodetypeDirtyFlag = false;
        this.logicnodetype = null;
    }

    public void setPSDELogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogicid = string;
        this.psdelogicidDirtyFlag = true;
    }

    public String getPSDELogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicId();
        }
        return this.psdelogicid;
    }

    public boolean isPSDELogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicIdDirty();
        }
        return this.psdelogicidDirtyFlag;
    }

    public void resetPSDELogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicId();
            return;
        }
        this.psdelogicidDirtyFlag = false;
        this.psdelogicid = null;
    }

    public void setPSDELogicNodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicNodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogicnodeid = string;
        this.psdelogicnodeidDirtyFlag = true;
    }

    public String getPSDELogicNodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicNodeId();
        }
        return this.psdelogicnodeid;
    }

    public boolean isPSDELogicNodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicNodeIdDirty();
        }
        return this.psdelogicnodeidDirtyFlag;
    }

    public void resetPSDELogicNodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicNodeId();
            return;
        }
        this.psdelogicnodeidDirtyFlag = false;
        this.psdelogicnodeid = null;
    }

    public void setPSDELogicNodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicNodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogicnodename = string;
        this.psdelogicnodenameDirtyFlag = true;
    }

    public String getPSDELogicNodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicNodeName();
        }
        return this.psdelogicnodename;
    }

    public boolean isPSDELogicNodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicNodeNameDirty();
        }
        return this.psdelogicnodenameDirtyFlag;
    }

    public void resetPSDELogicNodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicNodeName();
            return;
        }
        this.psdelogicnodenameDirtyFlag = false;
        this.psdelogicnodename = null;
    }

    public void setDraftFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDraftFlag(n);
            return;
        }
        this.draftflag = n;
        this.draftflagDirtyFlag = true;
    }

    public Integer getDraftFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDraftFlag();
        }
        return this.draftflag;
    }

    public boolean isDraftFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDraftFlagDirty();
        }
        return this.draftflagDirtyFlag;
    }

    public void resetDraftFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDraftFlag();
            return;
        }
        this.draftflagDirtyFlag = false;
        this.draftflag = null;
    }

    protected void onReset() {
        PSUWDELogicNodeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSUWDELogicNodeBase pSUWDELogicNodeBase) {
        pSUWDELogicNodeBase.resetLogicNodeType();
        pSUWDELogicNodeBase.resetPSDELogicId();
        pSUWDELogicNodeBase.resetPSDELogicNodeId();
        pSUWDELogicNodeBase.resetPSDELogicNodeName();
        pSUWDELogicNodeBase.resetDraftFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isLogicNodeTypeDirty()) {
            hashMap.put(FIELD_LOGICNODETYPE, this.getLogicNodeType());
        }
        if (!bl || this.isPSDELogicIdDirty()) {
            hashMap.put(FIELD_PSDELOGICID, this.getPSDELogicId());
        }
        if (!bl || this.isPSDELogicNodeIdDirty()) {
            hashMap.put(FIELD_PSDELOGICNODEID, this.getPSDELogicNodeId());
        }
        if (!bl || this.isPSDELogicNodeNameDirty()) {
            hashMap.put(FIELD_PSDELOGICNODENAME, this.getPSDELogicNodeName());
        }
        if (!bl || this.isDraftFlagDirty()) {
            hashMap.put(FIELD_DRAFTFLAG, this.getDraftFlag());
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
        return PSUWDELogicNodeBase.get(this, n);
    }

    private static Object get(PSUWDELogicNodeBase pSUWDELogicNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWDELogicNodeBase.getLogicNodeType();
            }
            case 1: {
                return pSUWDELogicNodeBase.getPSDELogicId();
            }
            case 2: {
                return pSUWDELogicNodeBase.getPSDELogicNodeId();
            }
            case 3: {
                return pSUWDELogicNodeBase.getPSDELogicNodeName();
            }
            case 4: {
                return pSUWDELogicNodeBase.getDraftFlag();
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
        PSUWDELogicNodeBase.set(this, n, object);
    }

    private static void set(PSUWDELogicNodeBase pSUWDELogicNodeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSUWDELogicNodeBase.setLogicNodeType(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSUWDELogicNodeBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSUWDELogicNodeBase.setPSDELogicNodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSUWDELogicNodeBase.setPSDELogicNodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSUWDELogicNodeBase.setDraftFlag(DataObject.getIntegerValue((Object)object));
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
        return PSUWDELogicNodeBase.isNull(this, n);
    }

    private static boolean isNull(PSUWDELogicNodeBase pSUWDELogicNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWDELogicNodeBase.getLogicNodeType() == null;
            }
            case 1: {
                return pSUWDELogicNodeBase.getPSDELogicId() == null;
            }
            case 2: {
                return pSUWDELogicNodeBase.getPSDELogicNodeId() == null;
            }
            case 3: {
                return pSUWDELogicNodeBase.getPSDELogicNodeName() == null;
            }
            case 4: {
                return pSUWDELogicNodeBase.getDraftFlag() == null;
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
        return PSUWDELogicNodeBase.contains(this, n);
    }

    private static boolean contains(PSUWDELogicNodeBase pSUWDELogicNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWDELogicNodeBase.isLogicNodeTypeDirty();
            }
            case 1: {
                return pSUWDELogicNodeBase.isPSDELogicIdDirty();
            }
            case 2: {
                return pSUWDELogicNodeBase.isPSDELogicNodeIdDirty();
            }
            case 3: {
                return pSUWDELogicNodeBase.isPSDELogicNodeNameDirty();
            }
            case 4: {
                return pSUWDELogicNodeBase.isDraftFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSUWDELogicNodeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSUWDELogicNodeBase pSUWDELogicNodeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSUWDELogicNodeBase.getLogicNodeType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicnodetype", (Object)PSUWDELogicNodeBase.getJSONValue((Object)pSUWDELogicNodeBase.getLogicNodeType()), (boolean)false);
        }
        if (bl || pSUWDELogicNodeBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSUWDELogicNodeBase.getJSONValue((Object)pSUWDELogicNodeBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSUWDELogicNodeBase.getPSDELogicNodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicnodeid", (Object)PSUWDELogicNodeBase.getJSONValue((Object)pSUWDELogicNodeBase.getPSDELogicNodeId()), (boolean)false);
        }
        if (bl || pSUWDELogicNodeBase.getPSDELogicNodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicnodename", (Object)PSUWDELogicNodeBase.getJSONValue((Object)pSUWDELogicNodeBase.getPSDELogicNodeName()), (boolean)false);
        }
        if (bl || pSUWDELogicNodeBase.getDraftFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srfdraftflag", (Object)PSUWDELogicNodeBase.getJSONValue((Object)pSUWDELogicNodeBase.getDraftFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSUWDELogicNodeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSUWDELogicNodeBase pSUWDELogicNodeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSUWDELogicNodeBase.getLogicNodeType() != null) {
            object = pSUWDELogicNodeBase.getLogicNodeType();
            xmlNode.setAttribute(FIELD_LOGICNODETYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSUWDELogicNodeBase.getPSDELogicId() != null) {
            object = pSUWDELogicNodeBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, (String)(object == null ? "" : object));
        }
        if (bl || pSUWDELogicNodeBase.getPSDELogicNodeId() != null) {
            object = pSUWDELogicNodeBase.getPSDELogicNodeId();
            xmlNode.setAttribute(FIELD_PSDELOGICNODEID, (String)(object == null ? "" : object));
        }
        if (bl || pSUWDELogicNodeBase.getPSDELogicNodeName() != null) {
            object = pSUWDELogicNodeBase.getPSDELogicNodeName();
            xmlNode.setAttribute(FIELD_PSDELOGICNODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWDELogicNodeBase.getDraftFlag() != null) {
            object = pSUWDELogicNodeBase.getDraftFlag();
            xmlNode.setAttribute("DRAFTFLAG", object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSUWDELogicNodeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSUWDELogicNodeBase pSUWDELogicNodeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSUWDELogicNodeBase.isLogicNodeTypeDirty() && (bl || pSUWDELogicNodeBase.getLogicNodeType() != null)) {
            iDataObject.set(FIELD_LOGICNODETYPE, (Object)pSUWDELogicNodeBase.getLogicNodeType());
        }
        if (pSUWDELogicNodeBase.isPSDELogicIdDirty() && (bl || pSUWDELogicNodeBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSUWDELogicNodeBase.getPSDELogicId());
        }
        if (pSUWDELogicNodeBase.isPSDELogicNodeIdDirty() && (bl || pSUWDELogicNodeBase.getPSDELogicNodeId() != null)) {
            iDataObject.set(FIELD_PSDELOGICNODEID, (Object)pSUWDELogicNodeBase.getPSDELogicNodeId());
        }
        if (pSUWDELogicNodeBase.isPSDELogicNodeNameDirty() && (bl || pSUWDELogicNodeBase.getPSDELogicNodeName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNODENAME, (Object)pSUWDELogicNodeBase.getPSDELogicNodeName());
        }
        if (pSUWDELogicNodeBase.isDraftFlagDirty() && (bl || pSUWDELogicNodeBase.getDraftFlag() != null)) {
            iDataObject.set(FIELD_DRAFTFLAG, (Object)pSUWDELogicNodeBase.getDraftFlag());
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
        return PSUWDELogicNodeBase.remove(this, n);
    }

    private static boolean remove(PSUWDELogicNodeBase pSUWDELogicNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSUWDELogicNodeBase.resetLogicNodeType();
                return true;
            }
            case 1: {
                pSUWDELogicNodeBase.resetPSDELogicId();
                return true;
            }
            case 2: {
                pSUWDELogicNodeBase.resetPSDELogicNodeId();
                return true;
            }
            case 3: {
                pSUWDELogicNodeBase.resetPSDELogicNodeName();
                return true;
            }
            case 4: {
                pSUWDELogicNodeBase.resetDraftFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogic getPSDELogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogic();
        }
        if (this.getPSDELogicId() == null) {
            return null;
        }
        Integer n = this.objPSDELogicLock;
        synchronized (n) {
            if (this.psdelogic != null && DataTypeHelper.compare((int)25, (Object)this.getPSDELogicId(), (Object)this.psdelogic.getPSDELogicId()) != 0L) {
                this.psdelogic = null;
            }
            if (this.psdelogic == null) {
                PSDELogic pSDELogic = new PSDELogic();
                pSDELogic.setPSDELogicId(this.getPSDELogicId());
                PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicService.autoGet(pSDELogic);
                this.psdelogic = pSDELogic;
            }
            return this.psdelogic;
        }
    }

    private PSUWDELogicNodeBase getProxyEntity() {
        return this.proxyPSUWDELogicNodeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSUWDELogicNodeBase = null;
        if (iDataObject != null && iDataObject instanceof PSUWDELogicNodeBase) {
            this.proxyPSUWDELogicNodeBase = (PSUWDELogicNodeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSUWDELogicNodeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_LOGICNODETYPE, 0);
        fieldIndexMap.put(FIELD_PSDELOGICID, 1);
        fieldIndexMap.put(FIELD_PSDELOGICNODEID, 2);
        fieldIndexMap.put(FIELD_PSDELOGICNODENAME, 3);
        fieldIndexMap.put(FIELD_DRAFTFLAG, 4);
    }
}

