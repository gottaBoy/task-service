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
import net.ibizsys.pscore.srv.dedesign.entity.PSDETEIUpdate;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNodeCol;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeView;
import net.ibizsys.pscore.srv.dedesign.service.PSDETEIUpdateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDETEIUDetailBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDETEIUDetailBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDETEIUDETAILID = "PSDETEIUDETAILID";
    public static final String FIELD_PSDETEIUDETAILNAME = "PSDETEIUDETAILNAME";
    public static final String FIELD_PSDETEIUPDATEID = "PSDETEIUPDATEID";
    public static final String FIELD_PSDETEIUPDATENAME = "PSDETEIUPDATENAME";
    public static final String FIELD_PSDETREENODECOLID = "PSDETREENODECOLID";
    public static final String FIELD_PSDETREENODECOLNAME = "PSDETREENODECOLNAME";
    public static final String FIELD_PSDETREENODEID = "PSDETREENODEID";
    public static final String FIELD_PSDETREEVIEWID = "PSDETREEVIEWID";
    public static final String FIELD_PSDETREEVIEWNAME = "PSDETREEVIEWNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDETEIUDETAILID = 2;
    private static final int INDEX_PSDETEIUDETAILNAME = 3;
    private static final int INDEX_PSDETEIUPDATEID = 4;
    private static final int INDEX_PSDETEIUPDATENAME = 5;
    private static final int INDEX_PSDETREENODECOLID = 6;
    private static final int INDEX_PSDETREENODECOLNAME = 7;
    private static final int INDEX_PSDETREENODEID = 8;
    private static final int INDEX_PSDETREEVIEWID = 9;
    private static final int INDEX_PSDETREEVIEWNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDETEIUDetailBase proxyPSDETEIUDetailBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdeteiudetailidDirtyFlag = false;
    private boolean psdeteiudetailnameDirtyFlag = false;
    private boolean psdeteiupdateidDirtyFlag = false;
    private boolean psdeteiupdatenameDirtyFlag = false;
    private boolean psdetreenodecolidDirtyFlag = false;
    private boolean psdetreenodecolnameDirtyFlag = false;
    private boolean psdetreenodeidDirtyFlag = false;
    private boolean psdetreeviewidDirtyFlag = false;
    private boolean psdetreeviewnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psdeteiudetailid")
    private String psdeteiudetailid;
    @Column(name="psdeteiudetailname")
    private String psdeteiudetailname;
    @Column(name="psdeteiupdateid")
    private String psdeteiupdateid;
    @Column(name="psdeteiupdatename")
    private String psdeteiupdatename;
    @Column(name="psdetreenodecolid")
    private String psdetreenodecolid;
    @Column(name="psdetreenodecolname")
    private String psdetreenodecolname;
    @Column(name="psdetreenodeid")
    private String psdetreenodeid;
    @Column(name="psdetreeviewid")
    private String psdetreeviewid;
    @Column(name="psdetreeviewname")
    private String psdetreeviewname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDETEIUpdateLock = new Integer(1);
    private PSDETEIUpdate psdeteiupdate = null;
    private Integer objPSDETreeNodeColLock = new Integer(1);
    private PSDETreeNodeCol psdetreenodecol = null;
    private Integer objPSDETreeViewLock = new Integer(1);
    private PSDETreeView psdetreeview = null;

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

    public void setPSDETEIUDetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETEIUDetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeteiudetailid = string;
        this.psdeteiudetailidDirtyFlag = true;
    }

    public String getPSDETEIUDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETEIUDetailId();
        }
        return this.psdeteiudetailid;
    }

    public boolean isPSDETEIUDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETEIUDetailIdDirty();
        }
        return this.psdeteiudetailidDirtyFlag;
    }

    public void resetPSDETEIUDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETEIUDetailId();
            return;
        }
        this.psdeteiudetailidDirtyFlag = false;
        this.psdeteiudetailid = null;
    }

    public void setPSDETEIUDetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETEIUDetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeteiudetailname = string;
        this.psdeteiudetailnameDirtyFlag = true;
    }

    public String getPSDETEIUDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETEIUDetailName();
        }
        return this.psdeteiudetailname;
    }

    public boolean isPSDETEIUDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETEIUDetailNameDirty();
        }
        return this.psdeteiudetailnameDirtyFlag;
    }

    public void resetPSDETEIUDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETEIUDetailName();
            return;
        }
        this.psdeteiudetailnameDirtyFlag = false;
        this.psdeteiudetailname = null;
    }

    public void setPSDETEIUpdateId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETEIUpdateId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeteiupdateid = string;
        this.psdeteiupdateidDirtyFlag = true;
    }

    public String getPSDETEIUpdateId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETEIUpdateId();
        }
        return this.psdeteiupdateid;
    }

    public boolean isPSDETEIUpdateIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETEIUpdateIdDirty();
        }
        return this.psdeteiupdateidDirtyFlag;
    }

    public void resetPSDETEIUpdateId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETEIUpdateId();
            return;
        }
        this.psdeteiupdateidDirtyFlag = false;
        this.psdeteiupdateid = null;
    }

    public void setPSDETEIUpdateName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETEIUpdateName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeteiupdatename = string;
        this.psdeteiupdatenameDirtyFlag = true;
    }

    public String getPSDETEIUpdateName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETEIUpdateName();
        }
        return this.psdeteiupdatename;
    }

    public boolean isPSDETEIUpdateNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETEIUpdateNameDirty();
        }
        return this.psdeteiupdatenameDirtyFlag;
    }

    public void resetPSDETEIUpdateName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETEIUpdateName();
            return;
        }
        this.psdeteiupdatenameDirtyFlag = false;
        this.psdeteiupdatename = null;
    }

    public void setPSDETreeNodeColId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeNodeColId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreenodecolid = string;
        this.psdetreenodecolidDirtyFlag = true;
    }

    public String getPSDETreeNodeColId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeNodeColId();
        }
        return this.psdetreenodecolid;
    }

    public boolean isPSDETreeNodeColIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeNodeColIdDirty();
        }
        return this.psdetreenodecolidDirtyFlag;
    }

    public void resetPSDETreeNodeColId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeNodeColId();
            return;
        }
        this.psdetreenodecolidDirtyFlag = false;
        this.psdetreenodecolid = null;
    }

    public void setPSDETreeNodeColName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeNodeColName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreenodecolname = string;
        this.psdetreenodecolnameDirtyFlag = true;
    }

    public String getPSDETreeNodeColName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeNodeColName();
        }
        return this.psdetreenodecolname;
    }

    public boolean isPSDETreeNodeColNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeNodeColNameDirty();
        }
        return this.psdetreenodecolnameDirtyFlag;
    }

    public void resetPSDETreeNodeColName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeNodeColName();
            return;
        }
        this.psdetreenodecolnameDirtyFlag = false;
        this.psdetreenodecolname = null;
    }

    public void setPSDETreeNodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeNodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreenodeid = string;
        this.psdetreenodeidDirtyFlag = true;
    }

    public String getPSDETreeNodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeNodeId();
        }
        return this.psdetreenodeid;
    }

    public boolean isPSDETreeNodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeNodeIdDirty();
        }
        return this.psdetreenodeidDirtyFlag;
    }

    public void resetPSDETreeNodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeNodeId();
            return;
        }
        this.psdetreenodeidDirtyFlag = false;
        this.psdetreenodeid = null;
    }

    public void setPSDETreeViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreeviewid = string;
        this.psdetreeviewidDirtyFlag = true;
    }

    public String getPSDETreeViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeViewId();
        }
        return this.psdetreeviewid;
    }

    public boolean isPSDETreeViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeViewIdDirty();
        }
        return this.psdetreeviewidDirtyFlag;
    }

    public void resetPSDETreeViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeViewId();
            return;
        }
        this.psdetreeviewidDirtyFlag = false;
        this.psdetreeviewid = null;
    }

    public void setPSDETreeViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreeviewname = string;
        this.psdetreeviewnameDirtyFlag = true;
    }

    public String getPSDETreeViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeViewName();
        }
        return this.psdetreeviewname;
    }

    public boolean isPSDETreeViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeViewNameDirty();
        }
        return this.psdetreeviewnameDirtyFlag;
    }

    public void resetPSDETreeViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeViewName();
            return;
        }
        this.psdetreeviewnameDirtyFlag = false;
        this.psdetreeviewname = null;
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
        PSDETEIUDetailBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDETEIUDetailBase pSDETEIUDetailBase) {
        pSDETEIUDetailBase.resetCreateDate();
        pSDETEIUDetailBase.resetCreateMan();
        pSDETEIUDetailBase.resetPSDETEIUDetailId();
        pSDETEIUDetailBase.resetPSDETEIUDetailName();
        pSDETEIUDetailBase.resetPSDETEIUpdateId();
        pSDETEIUDetailBase.resetPSDETEIUpdateName();
        pSDETEIUDetailBase.resetPSDETreeNodeColId();
        pSDETEIUDetailBase.resetPSDETreeNodeColName();
        pSDETEIUDetailBase.resetPSDETreeNodeId();
        pSDETEIUDetailBase.resetPSDETreeViewId();
        pSDETEIUDetailBase.resetPSDETreeViewName();
        pSDETEIUDetailBase.resetUpdateDate();
        pSDETEIUDetailBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSDETEIUDetailIdDirty()) {
            hashMap.put(FIELD_PSDETEIUDETAILID, this.getPSDETEIUDetailId());
        }
        if (!bl || this.isPSDETEIUDetailNameDirty()) {
            hashMap.put(FIELD_PSDETEIUDETAILNAME, this.getPSDETEIUDetailName());
        }
        if (!bl || this.isPSDETEIUpdateIdDirty()) {
            hashMap.put(FIELD_PSDETEIUPDATEID, this.getPSDETEIUpdateId());
        }
        if (!bl || this.isPSDETEIUpdateNameDirty()) {
            hashMap.put(FIELD_PSDETEIUPDATENAME, this.getPSDETEIUpdateName());
        }
        if (!bl || this.isPSDETreeNodeColIdDirty()) {
            hashMap.put(FIELD_PSDETREENODECOLID, this.getPSDETreeNodeColId());
        }
        if (!bl || this.isPSDETreeNodeColNameDirty()) {
            hashMap.put(FIELD_PSDETREENODECOLNAME, this.getPSDETreeNodeColName());
        }
        if (!bl || this.isPSDETreeNodeIdDirty()) {
            hashMap.put(FIELD_PSDETREENODEID, this.getPSDETreeNodeId());
        }
        if (!bl || this.isPSDETreeViewIdDirty()) {
            hashMap.put(FIELD_PSDETREEVIEWID, this.getPSDETreeViewId());
        }
        if (!bl || this.isPSDETreeViewNameDirty()) {
            hashMap.put(FIELD_PSDETREEVIEWNAME, this.getPSDETreeViewName());
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
        return PSDETEIUDetailBase.get(this, n);
    }

    private static Object get(PSDETEIUDetailBase pSDETEIUDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETEIUDetailBase.getCreateDate();
            }
            case 1: {
                return pSDETEIUDetailBase.getCreateMan();
            }
            case 2: {
                return pSDETEIUDetailBase.getPSDETEIUDetailId();
            }
            case 3: {
                return pSDETEIUDetailBase.getPSDETEIUDetailName();
            }
            case 4: {
                return pSDETEIUDetailBase.getPSDETEIUpdateId();
            }
            case 5: {
                return pSDETEIUDetailBase.getPSDETEIUpdateName();
            }
            case 6: {
                return pSDETEIUDetailBase.getPSDETreeNodeColId();
            }
            case 7: {
                return pSDETEIUDetailBase.getPSDETreeNodeColName();
            }
            case 8: {
                return pSDETEIUDetailBase.getPSDETreeNodeId();
            }
            case 9: {
                return pSDETEIUDetailBase.getPSDETreeViewId();
            }
            case 10: {
                return pSDETEIUDetailBase.getPSDETreeViewName();
            }
            case 11: {
                return pSDETEIUDetailBase.getUpdateDate();
            }
            case 12: {
                return pSDETEIUDetailBase.getUpdateMan();
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
        PSDETEIUDetailBase.set(this, n, object);
    }

    private static void set(PSDETEIUDetailBase pSDETEIUDetailBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDETEIUDetailBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDETEIUDetailBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDETEIUDetailBase.setPSDETEIUDetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDETEIUDetailBase.setPSDETEIUDetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDETEIUDetailBase.setPSDETEIUpdateId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDETEIUDetailBase.setPSDETEIUpdateName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDETEIUDetailBase.setPSDETreeNodeColId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDETEIUDetailBase.setPSDETreeNodeColName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDETEIUDetailBase.setPSDETreeNodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDETEIUDetailBase.setPSDETreeViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDETEIUDetailBase.setPSDETreeViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDETEIUDetailBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDETEIUDetailBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDETEIUDetailBase.isNull(this, n);
    }

    private static boolean isNull(PSDETEIUDetailBase pSDETEIUDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETEIUDetailBase.getCreateDate() == null;
            }
            case 1: {
                return pSDETEIUDetailBase.getCreateMan() == null;
            }
            case 2: {
                return pSDETEIUDetailBase.getPSDETEIUDetailId() == null;
            }
            case 3: {
                return pSDETEIUDetailBase.getPSDETEIUDetailName() == null;
            }
            case 4: {
                return pSDETEIUDetailBase.getPSDETEIUpdateId() == null;
            }
            case 5: {
                return pSDETEIUDetailBase.getPSDETEIUpdateName() == null;
            }
            case 6: {
                return pSDETEIUDetailBase.getPSDETreeNodeColId() == null;
            }
            case 7: {
                return pSDETEIUDetailBase.getPSDETreeNodeColName() == null;
            }
            case 8: {
                return pSDETEIUDetailBase.getPSDETreeNodeId() == null;
            }
            case 9: {
                return pSDETEIUDetailBase.getPSDETreeViewId() == null;
            }
            case 10: {
                return pSDETEIUDetailBase.getPSDETreeViewName() == null;
            }
            case 11: {
                return pSDETEIUDetailBase.getUpdateDate() == null;
            }
            case 12: {
                return pSDETEIUDetailBase.getUpdateMan() == null;
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
        return PSDETEIUDetailBase.contains(this, n);
    }

    private static boolean contains(PSDETEIUDetailBase pSDETEIUDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETEIUDetailBase.isCreateDateDirty();
            }
            case 1: {
                return pSDETEIUDetailBase.isCreateManDirty();
            }
            case 2: {
                return pSDETEIUDetailBase.isPSDETEIUDetailIdDirty();
            }
            case 3: {
                return pSDETEIUDetailBase.isPSDETEIUDetailNameDirty();
            }
            case 4: {
                return pSDETEIUDetailBase.isPSDETEIUpdateIdDirty();
            }
            case 5: {
                return pSDETEIUDetailBase.isPSDETEIUpdateNameDirty();
            }
            case 6: {
                return pSDETEIUDetailBase.isPSDETreeNodeColIdDirty();
            }
            case 7: {
                return pSDETEIUDetailBase.isPSDETreeNodeColNameDirty();
            }
            case 8: {
                return pSDETEIUDetailBase.isPSDETreeNodeIdDirty();
            }
            case 9: {
                return pSDETEIUDetailBase.isPSDETreeViewIdDirty();
            }
            case 10: {
                return pSDETEIUDetailBase.isPSDETreeViewNameDirty();
            }
            case 11: {
                return pSDETEIUDetailBase.isUpdateDateDirty();
            }
            case 12: {
                return pSDETEIUDetailBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDETEIUDetailBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDETEIUDetailBase pSDETEIUDetailBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDETEIUDetailBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDETEIUDetailBase.getJSONValue((Object)pSDETEIUDetailBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDETEIUDetailBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDETEIUDetailBase.getJSONValue((Object)pSDETEIUDetailBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDETEIUDetailBase.getPSDETEIUDetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeteiudetailid", (Object)PSDETEIUDetailBase.getJSONValue((Object)pSDETEIUDetailBase.getPSDETEIUDetailId()), (boolean)false);
        }
        if (bl || pSDETEIUDetailBase.getPSDETEIUDetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeteiudetailname", (Object)PSDETEIUDetailBase.getJSONValue((Object)pSDETEIUDetailBase.getPSDETEIUDetailName()), (boolean)false);
        }
        if (bl || pSDETEIUDetailBase.getPSDETEIUpdateId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeteiupdateid", (Object)PSDETEIUDetailBase.getJSONValue((Object)pSDETEIUDetailBase.getPSDETEIUpdateId()), (boolean)false);
        }
        if (bl || pSDETEIUDetailBase.getPSDETEIUpdateName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeteiupdatename", (Object)PSDETEIUDetailBase.getJSONValue((Object)pSDETEIUDetailBase.getPSDETEIUpdateName()), (boolean)false);
        }
        if (bl || pSDETEIUDetailBase.getPSDETreeNodeColId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreenodecolid", (Object)PSDETEIUDetailBase.getJSONValue((Object)pSDETEIUDetailBase.getPSDETreeNodeColId()), (boolean)false);
        }
        if (bl || pSDETEIUDetailBase.getPSDETreeNodeColName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreenodecolname", (Object)PSDETEIUDetailBase.getJSONValue((Object)pSDETEIUDetailBase.getPSDETreeNodeColName()), (boolean)false);
        }
        if (bl || pSDETEIUDetailBase.getPSDETreeNodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreenodeid", (Object)PSDETEIUDetailBase.getJSONValue((Object)pSDETEIUDetailBase.getPSDETreeNodeId()), (boolean)false);
        }
        if (bl || pSDETEIUDetailBase.getPSDETreeViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreeviewid", (Object)PSDETEIUDetailBase.getJSONValue((Object)pSDETEIUDetailBase.getPSDETreeViewId()), (boolean)false);
        }
        if (bl || pSDETEIUDetailBase.getPSDETreeViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreeviewname", (Object)PSDETEIUDetailBase.getJSONValue((Object)pSDETEIUDetailBase.getPSDETreeViewName()), (boolean)false);
        }
        if (bl || pSDETEIUDetailBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDETEIUDetailBase.getJSONValue((Object)pSDETEIUDetailBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDETEIUDetailBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDETEIUDetailBase.getJSONValue((Object)pSDETEIUDetailBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDETEIUDetailBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDETEIUDetailBase pSDETEIUDetailBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDETEIUDetailBase.getCreateDate() != null) {
            object = pSDETEIUDetailBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDETEIUDetailBase.getCreateMan() != null) {
            object = pSDETEIUDetailBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDETEIUDetailBase.getPSDETEIUDetailId() != null) {
            object = pSDETEIUDetailBase.getPSDETEIUDetailId();
            xmlNode.setAttribute(FIELD_PSDETEIUDETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSDETEIUDetailBase.getPSDETEIUDetailName() != null) {
            object = pSDETEIUDetailBase.getPSDETEIUDetailName();
            xmlNode.setAttribute(FIELD_PSDETEIUDETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETEIUDetailBase.getPSDETEIUpdateId() != null) {
            object = pSDETEIUDetailBase.getPSDETEIUpdateId();
            xmlNode.setAttribute(FIELD_PSDETEIUPDATEID, object == null ? "" : (String)object);
        }
        if (bl || pSDETEIUDetailBase.getPSDETEIUpdateName() != null) {
            object = pSDETEIUDetailBase.getPSDETEIUpdateName();
            xmlNode.setAttribute(FIELD_PSDETEIUPDATENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETEIUDetailBase.getPSDETreeNodeColId() != null) {
            object = pSDETEIUDetailBase.getPSDETreeNodeColId();
            xmlNode.setAttribute(FIELD_PSDETREENODECOLID, object == null ? "" : (String)object);
        }
        if (bl || pSDETEIUDetailBase.getPSDETreeNodeColName() != null) {
            object = pSDETEIUDetailBase.getPSDETreeNodeColName();
            xmlNode.setAttribute(FIELD_PSDETREENODECOLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETEIUDetailBase.getPSDETreeNodeId() != null) {
            object = pSDETEIUDetailBase.getPSDETreeNodeId();
            xmlNode.setAttribute(FIELD_PSDETREENODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDETEIUDetailBase.getPSDETreeViewId() != null) {
            object = pSDETEIUDetailBase.getPSDETreeViewId();
            xmlNode.setAttribute(FIELD_PSDETREEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDETEIUDetailBase.getPSDETreeViewName() != null) {
            object = pSDETEIUDetailBase.getPSDETreeViewName();
            xmlNode.setAttribute(FIELD_PSDETREEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETEIUDetailBase.getUpdateDate() != null) {
            object = pSDETEIUDetailBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDETEIUDetailBase.getUpdateMan() != null) {
            object = pSDETEIUDetailBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDETEIUDetailBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDETEIUDetailBase pSDETEIUDetailBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDETEIUDetailBase.isCreateDateDirty() && (bl || pSDETEIUDetailBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDETEIUDetailBase.getCreateDate());
        }
        if (pSDETEIUDetailBase.isCreateManDirty() && (bl || pSDETEIUDetailBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDETEIUDetailBase.getCreateMan());
        }
        if (pSDETEIUDetailBase.isPSDETEIUDetailIdDirty() && (bl || pSDETEIUDetailBase.getPSDETEIUDetailId() != null)) {
            iDataObject.set(FIELD_PSDETEIUDETAILID, (Object)pSDETEIUDetailBase.getPSDETEIUDetailId());
        }
        if (pSDETEIUDetailBase.isPSDETEIUDetailNameDirty() && (bl || pSDETEIUDetailBase.getPSDETEIUDetailName() != null)) {
            iDataObject.set(FIELD_PSDETEIUDETAILNAME, (Object)pSDETEIUDetailBase.getPSDETEIUDetailName());
        }
        if (pSDETEIUDetailBase.isPSDETEIUpdateIdDirty() && (bl || pSDETEIUDetailBase.getPSDETEIUpdateId() != null)) {
            iDataObject.set(FIELD_PSDETEIUPDATEID, (Object)pSDETEIUDetailBase.getPSDETEIUpdateId());
        }
        if (pSDETEIUDetailBase.isPSDETEIUpdateNameDirty() && (bl || pSDETEIUDetailBase.getPSDETEIUpdateName() != null)) {
            iDataObject.set(FIELD_PSDETEIUPDATENAME, (Object)pSDETEIUDetailBase.getPSDETEIUpdateName());
        }
        if (pSDETEIUDetailBase.isPSDETreeNodeColIdDirty() && (bl || pSDETEIUDetailBase.getPSDETreeNodeColId() != null)) {
            iDataObject.set(FIELD_PSDETREENODECOLID, (Object)pSDETEIUDetailBase.getPSDETreeNodeColId());
        }
        if (pSDETEIUDetailBase.isPSDETreeNodeColNameDirty() && (bl || pSDETEIUDetailBase.getPSDETreeNodeColName() != null)) {
            iDataObject.set(FIELD_PSDETREENODECOLNAME, (Object)pSDETEIUDetailBase.getPSDETreeNodeColName());
        }
        if (pSDETEIUDetailBase.isPSDETreeNodeIdDirty() && (bl || pSDETEIUDetailBase.getPSDETreeNodeId() != null)) {
            iDataObject.set(FIELD_PSDETREENODEID, (Object)pSDETEIUDetailBase.getPSDETreeNodeId());
        }
        if (pSDETEIUDetailBase.isPSDETreeViewIdDirty() && (bl || pSDETEIUDetailBase.getPSDETreeViewId() != null)) {
            iDataObject.set(FIELD_PSDETREEVIEWID, (Object)pSDETEIUDetailBase.getPSDETreeViewId());
        }
        if (pSDETEIUDetailBase.isPSDETreeViewNameDirty() && (bl || pSDETEIUDetailBase.getPSDETreeViewName() != null)) {
            iDataObject.set(FIELD_PSDETREEVIEWNAME, (Object)pSDETEIUDetailBase.getPSDETreeViewName());
        }
        if (pSDETEIUDetailBase.isUpdateDateDirty() && (bl || pSDETEIUDetailBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDETEIUDetailBase.getUpdateDate());
        }
        if (pSDETEIUDetailBase.isUpdateManDirty() && (bl || pSDETEIUDetailBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDETEIUDetailBase.getUpdateMan());
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
        return PSDETEIUDetailBase.remove(this, n);
    }

    private static boolean remove(PSDETEIUDetailBase pSDETEIUDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDETEIUDetailBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDETEIUDetailBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDETEIUDetailBase.resetPSDETEIUDetailId();
                return true;
            }
            case 3: {
                pSDETEIUDetailBase.resetPSDETEIUDetailName();
                return true;
            }
            case 4: {
                pSDETEIUDetailBase.resetPSDETEIUpdateId();
                return true;
            }
            case 5: {
                pSDETEIUDetailBase.resetPSDETEIUpdateName();
                return true;
            }
            case 6: {
                pSDETEIUDetailBase.resetPSDETreeNodeColId();
                return true;
            }
            case 7: {
                pSDETEIUDetailBase.resetPSDETreeNodeColName();
                return true;
            }
            case 8: {
                pSDETEIUDetailBase.resetPSDETreeNodeId();
                return true;
            }
            case 9: {
                pSDETEIUDetailBase.resetPSDETreeViewId();
                return true;
            }
            case 10: {
                pSDETEIUDetailBase.resetPSDETreeViewName();
                return true;
            }
            case 11: {
                pSDETEIUDetailBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSDETEIUDetailBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDETEIUpdate getPSDETEIUpdate() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETEIUpdate();
        }
        if (this.getPSDETEIUpdateId() == null) {
            return null;
        }
        Integer n = this.objPSDETEIUpdateLock;
        synchronized (n) {
            if (this.psdeteiupdate != null && DataTypeHelper.compare((int)25, (Object)this.getPSDETEIUpdateId(), (Object)this.psdeteiupdate.getPSDETEIUpdateId()) != 0L) {
                this.psdeteiupdate = null;
            }
            if (this.psdeteiupdate == null) {
                PSDETEIUpdate pSDETEIUpdate = new PSDETEIUpdate();
                pSDETEIUpdate.setPSDETEIUpdateId(this.getPSDETEIUpdateId());
                PSDETEIUpdateService pSDETEIUpdateService = (PSDETEIUpdateService)ServiceGlobal.getService(PSDETEIUpdateService.class, (SessionFactory)this.getSessionFactory());
                pSDETEIUpdateService.autoGet((IEntity)pSDETEIUpdate);
                this.psdeteiupdate = pSDETEIUpdate;
            }
            return this.psdeteiupdate;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDETreeNodeCol getPSDETreeNodeCol() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeNodeCol();
        }
        if (this.getPSDETreeNodeColId() == null) {
            return null;
        }
        Integer n = this.objPSDETreeNodeColLock;
        synchronized (n) {
            if (this.psdetreenodecol != null && DataTypeHelper.compare((int)25, (Object)this.getPSDETreeNodeColId(), (Object)this.psdetreenodecol.getPSDETreeNodeColId()) != 0L) {
                this.psdetreenodecol = null;
            }
            if (this.psdetreenodecol == null) {
                PSDETreeNodeCol pSDETreeNodeCol = new PSDETreeNodeCol();
                pSDETreeNodeCol.setPSDETreeNodeColId(this.getPSDETreeNodeColId());
                PSDETreeNodeColService pSDETreeNodeColService = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
                pSDETreeNodeColService.autoGet((IEntity)pSDETreeNodeCol);
                this.psdetreenodecol = pSDETreeNodeCol;
            }
            return this.psdetreenodecol;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDETreeView getPSDETreeView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeView();
        }
        if (this.getPSDETreeViewId() == null) {
            return null;
        }
        Integer n = this.objPSDETreeViewLock;
        synchronized (n) {
            if (this.psdetreeview != null && DataTypeHelper.compare((int)25, (Object)this.getPSDETreeViewId(), (Object)this.psdetreeview.getPSDETreeViewId()) != 0L) {
                this.psdetreeview = null;
            }
            if (this.psdetreeview == null) {
                PSDETreeView pSDETreeView = new PSDETreeView();
                pSDETreeView.setPSDETreeViewId(this.getPSDETreeViewId());
                PSDETreeViewService pSDETreeViewService = (PSDETreeViewService)ServiceGlobal.getService(PSDETreeViewService.class, (SessionFactory)this.getSessionFactory());
                pSDETreeViewService.autoGet((IEntity)pSDETreeView);
                this.psdetreeview = pSDETreeView;
            }
            return this.psdetreeview;
        }
    }

    private PSDETEIUDetailBase getProxyEntity() {
        return this.proxyPSDETEIUDetailBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDETEIUDetailBase = null;
        if (iDataObject != null && iDataObject instanceof PSDETEIUDetailBase) {
            this.proxyPSDETEIUDetailBase = (PSDETEIUDetailBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETEIUDetailService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDETEIUDETAILID, 2);
        fieldIndexMap.put(FIELD_PSDETEIUDETAILNAME, 3);
        fieldIndexMap.put(FIELD_PSDETEIUPDATEID, 4);
        fieldIndexMap.put(FIELD_PSDETEIUPDATENAME, 5);
        fieldIndexMap.put(FIELD_PSDETREENODECOLID, 6);
        fieldIndexMap.put(FIELD_PSDETREENODECOLNAME, 7);
        fieldIndexMap.put(FIELD_PSDETREENODEID, 8);
        fieldIndexMap.put(FIELD_PSDETREEVIEWID, 9);
        fieldIndexMap.put(FIELD_PSDETREEVIEWNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
    }
}

