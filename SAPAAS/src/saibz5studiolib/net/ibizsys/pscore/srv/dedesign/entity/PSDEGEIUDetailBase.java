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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGEIUpdate;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridCol;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGEIUpdateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEGEIUDetailBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEGEIUDetailBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDEGEIUDETAILID = "PSDEGEIUDETAILID";
    public static final String FIELD_PSDEGEIUDETAILNAME = "PSDEGEIUDETAILNAME";
    public static final String FIELD_PSDEGEIUPDATEID = "PSDEGEIUPDATEID";
    public static final String FIELD_PSDEGEIUPDATENAME = "PSDEGEIUPDATENAME";
    public static final String FIELD_PSDEGRIDCOLID = "PSDEGRIDCOLID";
    public static final String FIELD_PSDEGRIDCOLNAME = "PSDEGRIDCOLNAME";
    public static final String FIELD_PSDEGRIDID = "PSDEGRIDID";
    public static final String FIELD_PSDEGRIDNAME = "PSDEGRIDNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDEGEIUDETAILID = 2;
    private static final int INDEX_PSDEGEIUDETAILNAME = 3;
    private static final int INDEX_PSDEGEIUPDATEID = 4;
    private static final int INDEX_PSDEGEIUPDATENAME = 5;
    private static final int INDEX_PSDEGRIDCOLID = 6;
    private static final int INDEX_PSDEGRIDCOLNAME = 7;
    private static final int INDEX_PSDEGRIDID = 8;
    private static final int INDEX_PSDEGRIDNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEGEIUDetailBase proxyPSDEGEIUDetailBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdegeiudetailidDirtyFlag = false;
    private boolean psdegeiudetailnameDirtyFlag = false;
    private boolean psdegeiupdateidDirtyFlag = false;
    private boolean psdegeiupdatenameDirtyFlag = false;
    private boolean psdegridcolidDirtyFlag = false;
    private boolean psdegridcolnameDirtyFlag = false;
    private boolean psdegrididDirtyFlag = false;
    private boolean psdegridnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psdegeiudetailid")
    private String psdegeiudetailid;
    @Column(name="psdegeiudetailname")
    private String psdegeiudetailname;
    @Column(name="psdegeiupdateid")
    private String psdegeiupdateid;
    @Column(name="psdegeiupdatename")
    private String psdegeiupdatename;
    @Column(name="psdegridcolid")
    private String psdegridcolid;
    @Column(name="psdegridcolname")
    private String psdegridcolname;
    @Column(name="psdegridid")
    private String psdegridid;
    @Column(name="psdegridname")
    private String psdegridname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDEGEIUpdateLock = new Integer(1);
    private PSDEGEIUpdate psdegeiupdate = null;
    private Integer objPSDEGridColLock = new Integer(1);
    private PSDEGridCol psdegridcol = null;
    private Integer objPSDEGridLock = new Integer(1);
    private PSDEGrid psdegrid = null;

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

    public void setPSDEGEIUDetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGEIUDetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegeiudetailid = string;
        this.psdegeiudetailidDirtyFlag = true;
    }

    public String getPSDEGEIUDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGEIUDetailId();
        }
        return this.psdegeiudetailid;
    }

    public boolean isPSDEGEIUDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGEIUDetailIdDirty();
        }
        return this.psdegeiudetailidDirtyFlag;
    }

    public void resetPSDEGEIUDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGEIUDetailId();
            return;
        }
        this.psdegeiudetailidDirtyFlag = false;
        this.psdegeiudetailid = null;
    }

    public void setPSDEGEIUDetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGEIUDetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegeiudetailname = string;
        this.psdegeiudetailnameDirtyFlag = true;
    }

    public String getPSDEGEIUDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGEIUDetailName();
        }
        return this.psdegeiudetailname;
    }

    public boolean isPSDEGEIUDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGEIUDetailNameDirty();
        }
        return this.psdegeiudetailnameDirtyFlag;
    }

    public void resetPSDEGEIUDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGEIUDetailName();
            return;
        }
        this.psdegeiudetailnameDirtyFlag = false;
        this.psdegeiudetailname = null;
    }

    public void setPSDEGEIUpdateId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGEIUpdateId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegeiupdateid = string;
        this.psdegeiupdateidDirtyFlag = true;
    }

    public String getPSDEGEIUpdateId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGEIUpdateId();
        }
        return this.psdegeiupdateid;
    }

    public boolean isPSDEGEIUpdateIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGEIUpdateIdDirty();
        }
        return this.psdegeiupdateidDirtyFlag;
    }

    public void resetPSDEGEIUpdateId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGEIUpdateId();
            return;
        }
        this.psdegeiupdateidDirtyFlag = false;
        this.psdegeiupdateid = null;
    }

    public void setPSDEGEIUpdateName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGEIUpdateName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegeiupdatename = string;
        this.psdegeiupdatenameDirtyFlag = true;
    }

    public String getPSDEGEIUpdateName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGEIUpdateName();
        }
        return this.psdegeiupdatename;
    }

    public boolean isPSDEGEIUpdateNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGEIUpdateNameDirty();
        }
        return this.psdegeiupdatenameDirtyFlag;
    }

    public void resetPSDEGEIUpdateName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGEIUpdateName();
            return;
        }
        this.psdegeiupdatenameDirtyFlag = false;
        this.psdegeiupdatename = null;
    }

    public void setPSDEGridColId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridColId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegridcolid = string;
        this.psdegridcolidDirtyFlag = true;
    }

    public String getPSDEGridColId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridColId();
        }
        return this.psdegridcolid;
    }

    public boolean isPSDEGridColIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridColIdDirty();
        }
        return this.psdegridcolidDirtyFlag;
    }

    public void resetPSDEGridColId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridColId();
            return;
        }
        this.psdegridcolidDirtyFlag = false;
        this.psdegridcolid = null;
    }

    public void setPSDEGridColName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridColName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegridcolname = string;
        this.psdegridcolnameDirtyFlag = true;
    }

    public String getPSDEGridColName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridColName();
        }
        return this.psdegridcolname;
    }

    public boolean isPSDEGridColNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridColNameDirty();
        }
        return this.psdegridcolnameDirtyFlag;
    }

    public void resetPSDEGridColName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridColName();
            return;
        }
        this.psdegridcolnameDirtyFlag = false;
        this.psdegridcolname = null;
    }

    public void setPSDEGridId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegridid = string;
        this.psdegrididDirtyFlag = true;
    }

    public String getPSDEGridId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridId();
        }
        return this.psdegridid;
    }

    public boolean isPSDEGridIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridIdDirty();
        }
        return this.psdegrididDirtyFlag;
    }

    public void resetPSDEGridId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridId();
            return;
        }
        this.psdegrididDirtyFlag = false;
        this.psdegridid = null;
    }

    public void setPSDEGridName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEGridName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdegridname = string;
        this.psdegridnameDirtyFlag = true;
    }

    public String getPSDEGridName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridName();
        }
        return this.psdegridname;
    }

    public boolean isPSDEGridNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEGridNameDirty();
        }
        return this.psdegridnameDirtyFlag;
    }

    public void resetPSDEGridName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEGridName();
            return;
        }
        this.psdegridnameDirtyFlag = false;
        this.psdegridname = null;
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
        PSDEGEIUDetailBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEGEIUDetailBase pSDEGEIUDetailBase) {
        pSDEGEIUDetailBase.resetCreateDate();
        pSDEGEIUDetailBase.resetCreateMan();
        pSDEGEIUDetailBase.resetPSDEGEIUDetailId();
        pSDEGEIUDetailBase.resetPSDEGEIUDetailName();
        pSDEGEIUDetailBase.resetPSDEGEIUpdateId();
        pSDEGEIUDetailBase.resetPSDEGEIUpdateName();
        pSDEGEIUDetailBase.resetPSDEGridColId();
        pSDEGEIUDetailBase.resetPSDEGridColName();
        pSDEGEIUDetailBase.resetPSDEGridId();
        pSDEGEIUDetailBase.resetPSDEGridName();
        pSDEGEIUDetailBase.resetUpdateDate();
        pSDEGEIUDetailBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSDEGEIUDetailIdDirty()) {
            hashMap.put(FIELD_PSDEGEIUDETAILID, this.getPSDEGEIUDetailId());
        }
        if (!bl || this.isPSDEGEIUDetailNameDirty()) {
            hashMap.put(FIELD_PSDEGEIUDETAILNAME, this.getPSDEGEIUDetailName());
        }
        if (!bl || this.isPSDEGEIUpdateIdDirty()) {
            hashMap.put(FIELD_PSDEGEIUPDATEID, this.getPSDEGEIUpdateId());
        }
        if (!bl || this.isPSDEGEIUpdateNameDirty()) {
            hashMap.put(FIELD_PSDEGEIUPDATENAME, this.getPSDEGEIUpdateName());
        }
        if (!bl || this.isPSDEGridColIdDirty()) {
            hashMap.put(FIELD_PSDEGRIDCOLID, this.getPSDEGridColId());
        }
        if (!bl || this.isPSDEGridColNameDirty()) {
            hashMap.put(FIELD_PSDEGRIDCOLNAME, this.getPSDEGridColName());
        }
        if (!bl || this.isPSDEGridIdDirty()) {
            hashMap.put(FIELD_PSDEGRIDID, this.getPSDEGridId());
        }
        if (!bl || this.isPSDEGridNameDirty()) {
            hashMap.put(FIELD_PSDEGRIDNAME, this.getPSDEGridName());
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
        return PSDEGEIUDetailBase.get(this, n);
    }

    private static Object get(PSDEGEIUDetailBase pSDEGEIUDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEGEIUDetailBase.getCreateDate();
            }
            case 1: {
                return pSDEGEIUDetailBase.getCreateMan();
            }
            case 2: {
                return pSDEGEIUDetailBase.getPSDEGEIUDetailId();
            }
            case 3: {
                return pSDEGEIUDetailBase.getPSDEGEIUDetailName();
            }
            case 4: {
                return pSDEGEIUDetailBase.getPSDEGEIUpdateId();
            }
            case 5: {
                return pSDEGEIUDetailBase.getPSDEGEIUpdateName();
            }
            case 6: {
                return pSDEGEIUDetailBase.getPSDEGridColId();
            }
            case 7: {
                return pSDEGEIUDetailBase.getPSDEGridColName();
            }
            case 8: {
                return pSDEGEIUDetailBase.getPSDEGridId();
            }
            case 9: {
                return pSDEGEIUDetailBase.getPSDEGridName();
            }
            case 10: {
                return pSDEGEIUDetailBase.getUpdateDate();
            }
            case 11: {
                return pSDEGEIUDetailBase.getUpdateMan();
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
        PSDEGEIUDetailBase.set(this, n, object);
    }

    private static void set(PSDEGEIUDetailBase pSDEGEIUDetailBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEGEIUDetailBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEGEIUDetailBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEGEIUDetailBase.setPSDEGEIUDetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEGEIUDetailBase.setPSDEGEIUDetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEGEIUDetailBase.setPSDEGEIUpdateId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEGEIUDetailBase.setPSDEGEIUpdateName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEGEIUDetailBase.setPSDEGridColId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEGEIUDetailBase.setPSDEGridColName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEGEIUDetailBase.setPSDEGridId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEGEIUDetailBase.setPSDEGridName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEGEIUDetailBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSDEGEIUDetailBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDEGEIUDetailBase.isNull(this, n);
    }

    private static boolean isNull(PSDEGEIUDetailBase pSDEGEIUDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEGEIUDetailBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEGEIUDetailBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEGEIUDetailBase.getPSDEGEIUDetailId() == null;
            }
            case 3: {
                return pSDEGEIUDetailBase.getPSDEGEIUDetailName() == null;
            }
            case 4: {
                return pSDEGEIUDetailBase.getPSDEGEIUpdateId() == null;
            }
            case 5: {
                return pSDEGEIUDetailBase.getPSDEGEIUpdateName() == null;
            }
            case 6: {
                return pSDEGEIUDetailBase.getPSDEGridColId() == null;
            }
            case 7: {
                return pSDEGEIUDetailBase.getPSDEGridColName() == null;
            }
            case 8: {
                return pSDEGEIUDetailBase.getPSDEGridId() == null;
            }
            case 9: {
                return pSDEGEIUDetailBase.getPSDEGridName() == null;
            }
            case 10: {
                return pSDEGEIUDetailBase.getUpdateDate() == null;
            }
            case 11: {
                return pSDEGEIUDetailBase.getUpdateMan() == null;
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
        return PSDEGEIUDetailBase.contains(this, n);
    }

    private static boolean contains(PSDEGEIUDetailBase pSDEGEIUDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEGEIUDetailBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEGEIUDetailBase.isCreateManDirty();
            }
            case 2: {
                return pSDEGEIUDetailBase.isPSDEGEIUDetailIdDirty();
            }
            case 3: {
                return pSDEGEIUDetailBase.isPSDEGEIUDetailNameDirty();
            }
            case 4: {
                return pSDEGEIUDetailBase.isPSDEGEIUpdateIdDirty();
            }
            case 5: {
                return pSDEGEIUDetailBase.isPSDEGEIUpdateNameDirty();
            }
            case 6: {
                return pSDEGEIUDetailBase.isPSDEGridColIdDirty();
            }
            case 7: {
                return pSDEGEIUDetailBase.isPSDEGridColNameDirty();
            }
            case 8: {
                return pSDEGEIUDetailBase.isPSDEGridIdDirty();
            }
            case 9: {
                return pSDEGEIUDetailBase.isPSDEGridNameDirty();
            }
            case 10: {
                return pSDEGEIUDetailBase.isUpdateDateDirty();
            }
            case 11: {
                return pSDEGEIUDetailBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEGEIUDetailBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEGEIUDetailBase pSDEGEIUDetailBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEGEIUDetailBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEGEIUDetailBase.getJSONValue((Object)pSDEGEIUDetailBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEGEIUDetailBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEGEIUDetailBase.getJSONValue((Object)pSDEGEIUDetailBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEGEIUDetailBase.getPSDEGEIUDetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegeiudetailid", (Object)PSDEGEIUDetailBase.getJSONValue((Object)pSDEGEIUDetailBase.getPSDEGEIUDetailId()), (boolean)false);
        }
        if (bl || pSDEGEIUDetailBase.getPSDEGEIUDetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegeiudetailname", (Object)PSDEGEIUDetailBase.getJSONValue((Object)pSDEGEIUDetailBase.getPSDEGEIUDetailName()), (boolean)false);
        }
        if (bl || pSDEGEIUDetailBase.getPSDEGEIUpdateId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegeiupdateid", (Object)PSDEGEIUDetailBase.getJSONValue((Object)pSDEGEIUDetailBase.getPSDEGEIUpdateId()), (boolean)false);
        }
        if (bl || pSDEGEIUDetailBase.getPSDEGEIUpdateName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegeiupdatename", (Object)PSDEGEIUDetailBase.getJSONValue((Object)pSDEGEIUDetailBase.getPSDEGEIUpdateName()), (boolean)false);
        }
        if (bl || pSDEGEIUDetailBase.getPSDEGridColId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridcolid", (Object)PSDEGEIUDetailBase.getJSONValue((Object)pSDEGEIUDetailBase.getPSDEGridColId()), (boolean)false);
        }
        if (bl || pSDEGEIUDetailBase.getPSDEGridColName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridcolname", (Object)PSDEGEIUDetailBase.getJSONValue((Object)pSDEGEIUDetailBase.getPSDEGridColName()), (boolean)false);
        }
        if (bl || pSDEGEIUDetailBase.getPSDEGridId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridid", (Object)PSDEGEIUDetailBase.getJSONValue((Object)pSDEGEIUDetailBase.getPSDEGridId()), (boolean)false);
        }
        if (bl || pSDEGEIUDetailBase.getPSDEGridName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdegridname", (Object)PSDEGEIUDetailBase.getJSONValue((Object)pSDEGEIUDetailBase.getPSDEGridName()), (boolean)false);
        }
        if (bl || pSDEGEIUDetailBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEGEIUDetailBase.getJSONValue((Object)pSDEGEIUDetailBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEGEIUDetailBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEGEIUDetailBase.getJSONValue((Object)pSDEGEIUDetailBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEGEIUDetailBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEGEIUDetailBase pSDEGEIUDetailBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEGEIUDetailBase.getCreateDate() != null) {
            object = pSDEGEIUDetailBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEGEIUDetailBase.getCreateMan() != null) {
            object = pSDEGEIUDetailBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIUDetailBase.getPSDEGEIUDetailId() != null) {
            object = pSDEGEIUDetailBase.getPSDEGEIUDetailId();
            xmlNode.setAttribute(FIELD_PSDEGEIUDETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIUDetailBase.getPSDEGEIUDetailName() != null) {
            object = pSDEGEIUDetailBase.getPSDEGEIUDetailName();
            xmlNode.setAttribute(FIELD_PSDEGEIUDETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIUDetailBase.getPSDEGEIUpdateId() != null) {
            object = pSDEGEIUDetailBase.getPSDEGEIUpdateId();
            xmlNode.setAttribute(FIELD_PSDEGEIUPDATEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIUDetailBase.getPSDEGEIUpdateName() != null) {
            object = pSDEGEIUDetailBase.getPSDEGEIUpdateName();
            xmlNode.setAttribute(FIELD_PSDEGEIUPDATENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIUDetailBase.getPSDEGridColId() != null) {
            object = pSDEGEIUDetailBase.getPSDEGridColId();
            xmlNode.setAttribute(FIELD_PSDEGRIDCOLID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIUDetailBase.getPSDEGridColName() != null) {
            object = pSDEGEIUDetailBase.getPSDEGridColName();
            xmlNode.setAttribute(FIELD_PSDEGRIDCOLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIUDetailBase.getPSDEGridId() != null) {
            object = pSDEGEIUDetailBase.getPSDEGridId();
            xmlNode.setAttribute(FIELD_PSDEGRIDID, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIUDetailBase.getPSDEGridName() != null) {
            object = pSDEGEIUDetailBase.getPSDEGridName();
            xmlNode.setAttribute(FIELD_PSDEGRIDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEGEIUDetailBase.getUpdateDate() != null) {
            object = pSDEGEIUDetailBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEGEIUDetailBase.getUpdateMan() != null) {
            object = pSDEGEIUDetailBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEGEIUDetailBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEGEIUDetailBase pSDEGEIUDetailBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEGEIUDetailBase.isCreateDateDirty() && (bl || pSDEGEIUDetailBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEGEIUDetailBase.getCreateDate());
        }
        if (pSDEGEIUDetailBase.isCreateManDirty() && (bl || pSDEGEIUDetailBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEGEIUDetailBase.getCreateMan());
        }
        if (pSDEGEIUDetailBase.isPSDEGEIUDetailIdDirty() && (bl || pSDEGEIUDetailBase.getPSDEGEIUDetailId() != null)) {
            iDataObject.set(FIELD_PSDEGEIUDETAILID, (Object)pSDEGEIUDetailBase.getPSDEGEIUDetailId());
        }
        if (pSDEGEIUDetailBase.isPSDEGEIUDetailNameDirty() && (bl || pSDEGEIUDetailBase.getPSDEGEIUDetailName() != null)) {
            iDataObject.set(FIELD_PSDEGEIUDETAILNAME, (Object)pSDEGEIUDetailBase.getPSDEGEIUDetailName());
        }
        if (pSDEGEIUDetailBase.isPSDEGEIUpdateIdDirty() && (bl || pSDEGEIUDetailBase.getPSDEGEIUpdateId() != null)) {
            iDataObject.set(FIELD_PSDEGEIUPDATEID, (Object)pSDEGEIUDetailBase.getPSDEGEIUpdateId());
        }
        if (pSDEGEIUDetailBase.isPSDEGEIUpdateNameDirty() && (bl || pSDEGEIUDetailBase.getPSDEGEIUpdateName() != null)) {
            iDataObject.set(FIELD_PSDEGEIUPDATENAME, (Object)pSDEGEIUDetailBase.getPSDEGEIUpdateName());
        }
        if (pSDEGEIUDetailBase.isPSDEGridColIdDirty() && (bl || pSDEGEIUDetailBase.getPSDEGridColId() != null)) {
            iDataObject.set(FIELD_PSDEGRIDCOLID, (Object)pSDEGEIUDetailBase.getPSDEGridColId());
        }
        if (pSDEGEIUDetailBase.isPSDEGridColNameDirty() && (bl || pSDEGEIUDetailBase.getPSDEGridColName() != null)) {
            iDataObject.set(FIELD_PSDEGRIDCOLNAME, (Object)pSDEGEIUDetailBase.getPSDEGridColName());
        }
        if (pSDEGEIUDetailBase.isPSDEGridIdDirty() && (bl || pSDEGEIUDetailBase.getPSDEGridId() != null)) {
            iDataObject.set(FIELD_PSDEGRIDID, (Object)pSDEGEIUDetailBase.getPSDEGridId());
        }
        if (pSDEGEIUDetailBase.isPSDEGridNameDirty() && (bl || pSDEGEIUDetailBase.getPSDEGridName() != null)) {
            iDataObject.set(FIELD_PSDEGRIDNAME, (Object)pSDEGEIUDetailBase.getPSDEGridName());
        }
        if (pSDEGEIUDetailBase.isUpdateDateDirty() && (bl || pSDEGEIUDetailBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEGEIUDetailBase.getUpdateDate());
        }
        if (pSDEGEIUDetailBase.isUpdateManDirty() && (bl || pSDEGEIUDetailBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEGEIUDetailBase.getUpdateMan());
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
        return PSDEGEIUDetailBase.remove(this, n);
    }

    private static boolean remove(PSDEGEIUDetailBase pSDEGEIUDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEGEIUDetailBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEGEIUDetailBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEGEIUDetailBase.resetPSDEGEIUDetailId();
                return true;
            }
            case 3: {
                pSDEGEIUDetailBase.resetPSDEGEIUDetailName();
                return true;
            }
            case 4: {
                pSDEGEIUDetailBase.resetPSDEGEIUpdateId();
                return true;
            }
            case 5: {
                pSDEGEIUDetailBase.resetPSDEGEIUpdateName();
                return true;
            }
            case 6: {
                pSDEGEIUDetailBase.resetPSDEGridColId();
                return true;
            }
            case 7: {
                pSDEGEIUDetailBase.resetPSDEGridColName();
                return true;
            }
            case 8: {
                pSDEGEIUDetailBase.resetPSDEGridId();
                return true;
            }
            case 9: {
                pSDEGEIUDetailBase.resetPSDEGridName();
                return true;
            }
            case 10: {
                pSDEGEIUDetailBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSDEGEIUDetailBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEGEIUpdate getPSDEGEIUpdate() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGEIUpdate();
        }
        if (this.getPSDEGEIUpdateId() == null) {
            return null;
        }
        Integer n = this.objPSDEGEIUpdateLock;
        synchronized (n) {
            if (this.psdegeiupdate != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEGEIUpdateId(), (Object)this.psdegeiupdate.getPSDEGEIUpdateId()) != 0L) {
                this.psdegeiupdate = null;
            }
            if (this.psdegeiupdate == null) {
                PSDEGEIUpdate pSDEGEIUpdate = new PSDEGEIUpdate();
                pSDEGEIUpdate.setPSDEGEIUpdateId(this.getPSDEGEIUpdateId());
                PSDEGEIUpdateService pSDEGEIUpdateService = (PSDEGEIUpdateService)ServiceGlobal.getService(PSDEGEIUpdateService.class, (SessionFactory)this.getSessionFactory());
                pSDEGEIUpdateService.autoGet(pSDEGEIUpdate);
                this.psdegeiupdate = pSDEGEIUpdate;
            }
            return this.psdegeiupdate;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEGridCol getPSDEGridCol() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGridCol();
        }
        if (this.getPSDEGridColId() == null) {
            return null;
        }
        Integer n = this.objPSDEGridColLock;
        synchronized (n) {
            if (this.psdegridcol != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEGridColId(), (Object)this.psdegridcol.getPSDEGridColId()) != 0L) {
                this.psdegridcol = null;
            }
            if (this.psdegridcol == null) {
                PSDEGridCol pSDEGridCol = new PSDEGridCol();
                pSDEGridCol.setPSDEGridColId(this.getPSDEGridColId());
                PSDEGridColService pSDEGridColService = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
                pSDEGridColService.autoGet(pSDEGridCol);
                this.psdegridcol = pSDEGridCol;
            }
            return this.psdegridcol;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEGrid getPSDEGrid() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEGrid();
        }
        if (this.getPSDEGridId() == null) {
            return null;
        }
        Integer n = this.objPSDEGridLock;
        synchronized (n) {
            if (this.psdegrid != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEGridId(), (Object)this.psdegrid.getPSDEGridId()) != 0L) {
                this.psdegrid = null;
            }
            if (this.psdegrid == null) {
                PSDEGrid pSDEGrid = new PSDEGrid();
                pSDEGrid.setPSDEGridId(this.getPSDEGridId());
                PSDEGridService pSDEGridService = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
                pSDEGridService.autoGet(pSDEGrid);
                this.psdegrid = pSDEGrid;
            }
            return this.psdegrid;
        }
    }

    private PSDEGEIUDetailBase getProxyEntity() {
        return this.proxyPSDEGEIUDetailBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEGEIUDetailBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEGEIUDetailBase) {
            this.proxyPSDEGEIUDetailBase = (PSDEGEIUDetailBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEGEIUDetailService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDEGEIUDETAILID, 2);
        fieldIndexMap.put(FIELD_PSDEGEIUDETAILNAME, 3);
        fieldIndexMap.put(FIELD_PSDEGEIUPDATEID, 4);
        fieldIndexMap.put(FIELD_PSDEGEIUPDATENAME, 5);
        fieldIndexMap.put(FIELD_PSDEGRIDCOLID, 6);
        fieldIndexMap.put(FIELD_PSDEGRIDCOLNAME, 7);
        fieldIndexMap.put(FIELD_PSDEGRIDID, 8);
        fieldIndexMap.put(FIELD_PSDEGRIDNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
    }
}

