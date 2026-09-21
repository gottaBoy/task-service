/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdesign.entity;

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
import org.hibernate.SessionFactory;

public abstract class PSModelRefBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelRefBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MODELID = "MODELID";
    public static final String FIELD_MODELNAME = "MODELNAME";
    public static final String FIELD_MODELTYPE = "MODELTYPE";
    public static final String FIELD_MODELTYPENAME = "MODELTYPENAME";
    public static final String FIELD_PSMODELREFID = "PSMODELREFID";
    public static final String FIELD_PSMODELREFNAME = "PSMODELREFNAME";
    public static final String FIELD_REFMODE = "REFMODE";
    public static final String FIELD_REFMODEL2ID = "REFMODEL2ID";
    public static final String FIELD_REFMODEL2NAME = "REFMODEL2NAME";
    public static final String FIELD_REFMODEL2TYPE = "REFMODEL2TYPE";
    public static final String FIELD_REFMODEL2TYPENAME = "REFMODEL2TYPENAME";
    public static final String FIELD_REFMODELID = "REFMODELID";
    public static final String FIELD_REFMODELNAME = "REFMODELNAME";
    public static final String FIELD_REFMODELTYPE = "REFMODELTYPE";
    public static final String FIELD_REFMODELTYPENAME = "REFMODELTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MODELID = 2;
    private static final int INDEX_MODELNAME = 3;
    private static final int INDEX_MODELTYPE = 4;
    private static final int INDEX_MODELTYPENAME = 5;
    private static final int INDEX_PSMODELREFID = 6;
    private static final int INDEX_PSMODELREFNAME = 7;
    private static final int INDEX_REFMODE = 8;
    private static final int INDEX_REFMODEL2ID = 9;
    private static final int INDEX_REFMODEL2NAME = 10;
    private static final int INDEX_REFMODEL2TYPE = 11;
    private static final int INDEX_REFMODEL2TYPENAME = 12;
    private static final int INDEX_REFMODELID = 13;
    private static final int INDEX_REFMODELNAME = 14;
    private static final int INDEX_REFMODELTYPE = 15;
    private static final int INDEX_REFMODELTYPENAME = 16;
    private static final int INDEX_UPDATEDATE = 17;
    private static final int INDEX_UPDATEMAN = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelRefBase proxyPSModelRefBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean modelidDirtyFlag = false;
    private boolean modelnameDirtyFlag = false;
    private boolean modeltypeDirtyFlag = false;
    private boolean modeltypenameDirtyFlag = false;
    private boolean psmodelrefidDirtyFlag = false;
    private boolean psmodelrefnameDirtyFlag = false;
    private boolean refmodeDirtyFlag = false;
    private boolean refmodel2idDirtyFlag = false;
    private boolean refmodel2nameDirtyFlag = false;
    private boolean refmodel2typeDirtyFlag = false;
    private boolean refmodel2typenameDirtyFlag = false;
    private boolean refmodelidDirtyFlag = false;
    private boolean refmodelnameDirtyFlag = false;
    private boolean refmodeltypeDirtyFlag = false;
    private boolean refmodeltypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="modelid")
    private String modelid;
    @Column(name="modelname")
    private String modelname;
    @Column(name="modeltype")
    private String modeltype;
    @Column(name="modeltypename")
    private String modeltypename;
    @Column(name="psmodelrefid")
    private String psmodelrefid;
    @Column(name="psmodelrefname")
    private String psmodelrefname;
    @Column(name="refmode")
    private String refmode;
    @Column(name="refmodel2id")
    private String refmodel2id;
    @Column(name="refmodel2name")
    private String refmodel2name;
    @Column(name="refmodel2type")
    private String refmodel2type;
    @Column(name="refmodel2typename")
    private String refmodel2typename;
    @Column(name="refmodelid")
    private String refmodelid;
    @Column(name="refmodelname")
    private String refmodelname;
    @Column(name="refmodeltype")
    private String refmodeltype;
    @Column(name="refmodeltypename")
    private String refmodeltypename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

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

    public void setModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modelid = string;
        this.modelidDirtyFlag = true;
    }

    public String getModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelId();
        }
        return this.modelid;
    }

    public boolean isModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelIdDirty();
        }
        return this.modelidDirtyFlag;
    }

    public void resetModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelId();
            return;
        }
        this.modelidDirtyFlag = false;
        this.modelid = null;
    }

    public void setModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modelname = string;
        this.modelnameDirtyFlag = true;
    }

    public String getModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelName();
        }
        return this.modelname;
    }

    public boolean isModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelNameDirty();
        }
        return this.modelnameDirtyFlag;
    }

    public void resetModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelName();
            return;
        }
        this.modelnameDirtyFlag = false;
        this.modelname = null;
    }

    public void setModelType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modeltype = string;
        this.modeltypeDirtyFlag = true;
    }

    public String getModelType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelType();
        }
        return this.modeltype;
    }

    public boolean isModelTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelTypeDirty();
        }
        return this.modeltypeDirtyFlag;
    }

    public void resetModelType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelType();
            return;
        }
        this.modeltypeDirtyFlag = false;
        this.modeltype = null;
    }

    public void setModelTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modeltypename = string;
        this.modeltypenameDirtyFlag = true;
    }

    public String getModelTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelTypeName();
        }
        return this.modeltypename;
    }

    public boolean isModelTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelTypeNameDirty();
        }
        return this.modeltypenameDirtyFlag;
    }

    public void resetModelTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelTypeName();
            return;
        }
        this.modeltypenameDirtyFlag = false;
        this.modeltypename = null;
    }

    public void setPSModelRefId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelRefId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelrefid = string;
        this.psmodelrefidDirtyFlag = true;
    }

    public String getPSModelRefId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelRefId();
        }
        return this.psmodelrefid;
    }

    public boolean isPSModelRefIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelRefIdDirty();
        }
        return this.psmodelrefidDirtyFlag;
    }

    public void resetPSModelRefId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelRefId();
            return;
        }
        this.psmodelrefidDirtyFlag = false;
        this.psmodelrefid = null;
    }

    public void setPSModelRefName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelRefName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelrefname = string;
        this.psmodelrefnameDirtyFlag = true;
    }

    public String getPSModelRefName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelRefName();
        }
        return this.psmodelrefname;
    }

    public boolean isPSModelRefNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelRefNameDirty();
        }
        return this.psmodelrefnameDirtyFlag;
    }

    public void resetPSModelRefName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelRefName();
            return;
        }
        this.psmodelrefnameDirtyFlag = false;
        this.psmodelrefname = null;
    }

    public void setRefMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refmode = string;
        this.refmodeDirtyFlag = true;
    }

    public String getRefMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefMode();
        }
        return this.refmode;
    }

    public boolean isRefModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefModeDirty();
        }
        return this.refmodeDirtyFlag;
    }

    public void resetRefMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefMode();
            return;
        }
        this.refmodeDirtyFlag = false;
        this.refmode = null;
    }

    public void setRefModel2Id(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefModel2Id(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refmodel2id = string;
        this.refmodel2idDirtyFlag = true;
    }

    public String getRefModel2Id() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefModel2Id();
        }
        return this.refmodel2id;
    }

    public boolean isRefModel2IdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefModel2IdDirty();
        }
        return this.refmodel2idDirtyFlag;
    }

    public void resetRefModel2Id() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefModel2Id();
            return;
        }
        this.refmodel2idDirtyFlag = false;
        this.refmodel2id = null;
    }

    public void setRefModel2Name(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefModel2Name(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refmodel2name = string;
        this.refmodel2nameDirtyFlag = true;
    }

    public String getRefModel2Name() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefModel2Name();
        }
        return this.refmodel2name;
    }

    public boolean isRefModel2NameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefModel2NameDirty();
        }
        return this.refmodel2nameDirtyFlag;
    }

    public void resetRefModel2Name() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefModel2Name();
            return;
        }
        this.refmodel2nameDirtyFlag = false;
        this.refmodel2name = null;
    }

    public void setRefModel2Type(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefModel2Type(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refmodel2type = string;
        this.refmodel2typeDirtyFlag = true;
    }

    public String getRefModel2Type() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefModel2Type();
        }
        return this.refmodel2type;
    }

    public boolean isRefModel2TypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefModel2TypeDirty();
        }
        return this.refmodel2typeDirtyFlag;
    }

    public void resetRefModel2Type() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefModel2Type();
            return;
        }
        this.refmodel2typeDirtyFlag = false;
        this.refmodel2type = null;
    }

    public void setRefModel2TypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefModel2TypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refmodel2typename = string;
        this.refmodel2typenameDirtyFlag = true;
    }

    public String getRefModel2TypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefModel2TypeName();
        }
        return this.refmodel2typename;
    }

    public boolean isRefModel2TypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefModel2TypeNameDirty();
        }
        return this.refmodel2typenameDirtyFlag;
    }

    public void resetRefModel2TypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefModel2TypeName();
            return;
        }
        this.refmodel2typenameDirtyFlag = false;
        this.refmodel2typename = null;
    }

    public void setRefModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refmodelid = string;
        this.refmodelidDirtyFlag = true;
    }

    public String getRefModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefModelId();
        }
        return this.refmodelid;
    }

    public boolean isRefModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefModelIdDirty();
        }
        return this.refmodelidDirtyFlag;
    }

    public void resetRefModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefModelId();
            return;
        }
        this.refmodelidDirtyFlag = false;
        this.refmodelid = null;
    }

    public void setRefModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refmodelname = string;
        this.refmodelnameDirtyFlag = true;
    }

    public String getRefModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefModelName();
        }
        return this.refmodelname;
    }

    public boolean isRefModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefModelNameDirty();
        }
        return this.refmodelnameDirtyFlag;
    }

    public void resetRefModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefModelName();
            return;
        }
        this.refmodelnameDirtyFlag = false;
        this.refmodelname = null;
    }

    public void setRefModelType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefModelType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refmodeltype = string;
        this.refmodeltypeDirtyFlag = true;
    }

    public String getRefModelType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefModelType();
        }
        return this.refmodeltype;
    }

    public boolean isRefModelTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefModelTypeDirty();
        }
        return this.refmodeltypeDirtyFlag;
    }

    public void resetRefModelType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefModelType();
            return;
        }
        this.refmodeltypeDirtyFlag = false;
        this.refmodeltype = null;
    }

    public void setRefModelTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefModelTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refmodeltypename = string;
        this.refmodeltypenameDirtyFlag = true;
    }

    public String getRefModelTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefModelTypeName();
        }
        return this.refmodeltypename;
    }

    public boolean isRefModelTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefModelTypeNameDirty();
        }
        return this.refmodeltypenameDirtyFlag;
    }

    public void resetRefModelTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefModelTypeName();
            return;
        }
        this.refmodeltypenameDirtyFlag = false;
        this.refmodeltypename = null;
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
        PSModelRefBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelRefBase pSModelRefBase) {
        pSModelRefBase.resetCreateDate();
        pSModelRefBase.resetCreateMan();
        pSModelRefBase.resetModelId();
        pSModelRefBase.resetModelName();
        pSModelRefBase.resetModelType();
        pSModelRefBase.resetModelTypeName();
        pSModelRefBase.resetPSModelRefId();
        pSModelRefBase.resetPSModelRefName();
        pSModelRefBase.resetRefMode();
        pSModelRefBase.resetRefModel2Id();
        pSModelRefBase.resetRefModel2Name();
        pSModelRefBase.resetRefModel2Type();
        pSModelRefBase.resetRefModel2TypeName();
        pSModelRefBase.resetRefModelId();
        pSModelRefBase.resetRefModelName();
        pSModelRefBase.resetRefModelType();
        pSModelRefBase.resetRefModelTypeName();
        pSModelRefBase.resetUpdateDate();
        pSModelRefBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isModelIdDirty()) {
            hashMap.put(FIELD_MODELID, this.getModelId());
        }
        if (!bl || this.isModelNameDirty()) {
            hashMap.put(FIELD_MODELNAME, this.getModelName());
        }
        if (!bl || this.isModelTypeDirty()) {
            hashMap.put(FIELD_MODELTYPE, this.getModelType());
        }
        if (!bl || this.isModelTypeNameDirty()) {
            hashMap.put(FIELD_MODELTYPENAME, this.getModelTypeName());
        }
        if (!bl || this.isPSModelRefIdDirty()) {
            hashMap.put(FIELD_PSMODELREFID, this.getPSModelRefId());
        }
        if (!bl || this.isPSModelRefNameDirty()) {
            hashMap.put(FIELD_PSMODELREFNAME, this.getPSModelRefName());
        }
        if (!bl || this.isRefModeDirty()) {
            hashMap.put(FIELD_REFMODE, this.getRefMode());
        }
        if (!bl || this.isRefModel2IdDirty()) {
            hashMap.put(FIELD_REFMODEL2ID, this.getRefModel2Id());
        }
        if (!bl || this.isRefModel2NameDirty()) {
            hashMap.put(FIELD_REFMODEL2NAME, this.getRefModel2Name());
        }
        if (!bl || this.isRefModel2TypeDirty()) {
            hashMap.put(FIELD_REFMODEL2TYPE, this.getRefModel2Type());
        }
        if (!bl || this.isRefModel2TypeNameDirty()) {
            hashMap.put(FIELD_REFMODEL2TYPENAME, this.getRefModel2TypeName());
        }
        if (!bl || this.isRefModelIdDirty()) {
            hashMap.put(FIELD_REFMODELID, this.getRefModelId());
        }
        if (!bl || this.isRefModelNameDirty()) {
            hashMap.put(FIELD_REFMODELNAME, this.getRefModelName());
        }
        if (!bl || this.isRefModelTypeDirty()) {
            hashMap.put(FIELD_REFMODELTYPE, this.getRefModelType());
        }
        if (!bl || this.isRefModelTypeNameDirty()) {
            hashMap.put(FIELD_REFMODELTYPENAME, this.getRefModelTypeName());
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
        return PSModelRefBase.get(this, n);
    }

    private static Object get(PSModelRefBase pSModelRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelRefBase.getCreateDate();
            }
            case 1: {
                return pSModelRefBase.getCreateMan();
            }
            case 2: {
                return pSModelRefBase.getModelId();
            }
            case 3: {
                return pSModelRefBase.getModelName();
            }
            case 4: {
                return pSModelRefBase.getModelType();
            }
            case 5: {
                return pSModelRefBase.getModelTypeName();
            }
            case 6: {
                return pSModelRefBase.getPSModelRefId();
            }
            case 7: {
                return pSModelRefBase.getPSModelRefName();
            }
            case 8: {
                return pSModelRefBase.getRefMode();
            }
            case 9: {
                return pSModelRefBase.getRefModel2Id();
            }
            case 10: {
                return pSModelRefBase.getRefModel2Name();
            }
            case 11: {
                return pSModelRefBase.getRefModel2Type();
            }
            case 12: {
                return pSModelRefBase.getRefModel2TypeName();
            }
            case 13: {
                return pSModelRefBase.getRefModelId();
            }
            case 14: {
                return pSModelRefBase.getRefModelName();
            }
            case 15: {
                return pSModelRefBase.getRefModelType();
            }
            case 16: {
                return pSModelRefBase.getRefModelTypeName();
            }
            case 17: {
                return pSModelRefBase.getUpdateDate();
            }
            case 18: {
                return pSModelRefBase.getUpdateMan();
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
        PSModelRefBase.set(this, n, object);
    }

    private static void set(PSModelRefBase pSModelRefBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelRefBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSModelRefBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSModelRefBase.setModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSModelRefBase.setModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSModelRefBase.setModelType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSModelRefBase.setModelTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSModelRefBase.setPSModelRefId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSModelRefBase.setPSModelRefName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSModelRefBase.setRefMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModelRefBase.setRefModel2Id(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSModelRefBase.setRefModel2Name(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSModelRefBase.setRefModel2Type(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSModelRefBase.setRefModel2TypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSModelRefBase.setRefModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSModelRefBase.setRefModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSModelRefBase.setRefModelType(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSModelRefBase.setRefModelTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSModelRefBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSModelRefBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSModelRefBase.isNull(this, n);
    }

    private static boolean isNull(PSModelRefBase pSModelRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelRefBase.getCreateDate() == null;
            }
            case 1: {
                return pSModelRefBase.getCreateMan() == null;
            }
            case 2: {
                return pSModelRefBase.getModelId() == null;
            }
            case 3: {
                return pSModelRefBase.getModelName() == null;
            }
            case 4: {
                return pSModelRefBase.getModelType() == null;
            }
            case 5: {
                return pSModelRefBase.getModelTypeName() == null;
            }
            case 6: {
                return pSModelRefBase.getPSModelRefId() == null;
            }
            case 7: {
                return pSModelRefBase.getPSModelRefName() == null;
            }
            case 8: {
                return pSModelRefBase.getRefMode() == null;
            }
            case 9: {
                return pSModelRefBase.getRefModel2Id() == null;
            }
            case 10: {
                return pSModelRefBase.getRefModel2Name() == null;
            }
            case 11: {
                return pSModelRefBase.getRefModel2Type() == null;
            }
            case 12: {
                return pSModelRefBase.getRefModel2TypeName() == null;
            }
            case 13: {
                return pSModelRefBase.getRefModelId() == null;
            }
            case 14: {
                return pSModelRefBase.getRefModelName() == null;
            }
            case 15: {
                return pSModelRefBase.getRefModelType() == null;
            }
            case 16: {
                return pSModelRefBase.getRefModelTypeName() == null;
            }
            case 17: {
                return pSModelRefBase.getUpdateDate() == null;
            }
            case 18: {
                return pSModelRefBase.getUpdateMan() == null;
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
        return PSModelRefBase.contains(this, n);
    }

    private static boolean contains(PSModelRefBase pSModelRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelRefBase.isCreateDateDirty();
            }
            case 1: {
                return pSModelRefBase.isCreateManDirty();
            }
            case 2: {
                return pSModelRefBase.isModelIdDirty();
            }
            case 3: {
                return pSModelRefBase.isModelNameDirty();
            }
            case 4: {
                return pSModelRefBase.isModelTypeDirty();
            }
            case 5: {
                return pSModelRefBase.isModelTypeNameDirty();
            }
            case 6: {
                return pSModelRefBase.isPSModelRefIdDirty();
            }
            case 7: {
                return pSModelRefBase.isPSModelRefNameDirty();
            }
            case 8: {
                return pSModelRefBase.isRefModeDirty();
            }
            case 9: {
                return pSModelRefBase.isRefModel2IdDirty();
            }
            case 10: {
                return pSModelRefBase.isRefModel2NameDirty();
            }
            case 11: {
                return pSModelRefBase.isRefModel2TypeDirty();
            }
            case 12: {
                return pSModelRefBase.isRefModel2TypeNameDirty();
            }
            case 13: {
                return pSModelRefBase.isRefModelIdDirty();
            }
            case 14: {
                return pSModelRefBase.isRefModelNameDirty();
            }
            case 15: {
                return pSModelRefBase.isRefModelTypeDirty();
            }
            case 16: {
                return pSModelRefBase.isRefModelTypeNameDirty();
            }
            case 17: {
                return pSModelRefBase.isUpdateDateDirty();
            }
            case 18: {
                return pSModelRefBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelRefBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelRefBase pSModelRefBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelRefBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelRefBase.getJSONValue((Object)pSModelRefBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelRefBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelRefBase.getJSONValue((Object)pSModelRefBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelRefBase.getModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelid", (Object)PSModelRefBase.getJSONValue((Object)pSModelRefBase.getModelId()), (boolean)false);
        }
        if (bl || pSModelRefBase.getModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelname", (Object)PSModelRefBase.getJSONValue((Object)pSModelRefBase.getModelName()), (boolean)false);
        }
        if (bl || pSModelRefBase.getModelType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modeltype", (Object)PSModelRefBase.getJSONValue((Object)pSModelRefBase.getModelType()), (boolean)false);
        }
        if (bl || pSModelRefBase.getModelTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modeltypename", (Object)PSModelRefBase.getJSONValue((Object)pSModelRefBase.getModelTypeName()), (boolean)false);
        }
        if (bl || pSModelRefBase.getPSModelRefId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelrefid", (Object)PSModelRefBase.getJSONValue((Object)pSModelRefBase.getPSModelRefId()), (boolean)false);
        }
        if (bl || pSModelRefBase.getPSModelRefName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelrefname", (Object)PSModelRefBase.getJSONValue((Object)pSModelRefBase.getPSModelRefName()), (boolean)false);
        }
        if (bl || pSModelRefBase.getRefMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refmode", (Object)PSModelRefBase.getJSONValue((Object)pSModelRefBase.getRefMode()), (boolean)false);
        }
        if (bl || pSModelRefBase.getRefModel2Id() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refmodel2id", (Object)PSModelRefBase.getJSONValue((Object)pSModelRefBase.getRefModel2Id()), (boolean)false);
        }
        if (bl || pSModelRefBase.getRefModel2Name() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refmodel2name", (Object)PSModelRefBase.getJSONValue((Object)pSModelRefBase.getRefModel2Name()), (boolean)false);
        }
        if (bl || pSModelRefBase.getRefModel2Type() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refmodel2type", (Object)PSModelRefBase.getJSONValue((Object)pSModelRefBase.getRefModel2Type()), (boolean)false);
        }
        if (bl || pSModelRefBase.getRefModel2TypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refmodel2typename", (Object)PSModelRefBase.getJSONValue((Object)pSModelRefBase.getRefModel2TypeName()), (boolean)false);
        }
        if (bl || pSModelRefBase.getRefModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refmodelid", (Object)PSModelRefBase.getJSONValue((Object)pSModelRefBase.getRefModelId()), (boolean)false);
        }
        if (bl || pSModelRefBase.getRefModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refmodelname", (Object)PSModelRefBase.getJSONValue((Object)pSModelRefBase.getRefModelName()), (boolean)false);
        }
        if (bl || pSModelRefBase.getRefModelType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refmodeltype", (Object)PSModelRefBase.getJSONValue((Object)pSModelRefBase.getRefModelType()), (boolean)false);
        }
        if (bl || pSModelRefBase.getRefModelTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refmodeltypename", (Object)PSModelRefBase.getJSONValue((Object)pSModelRefBase.getRefModelTypeName()), (boolean)false);
        }
        if (bl || pSModelRefBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelRefBase.getJSONValue((Object)pSModelRefBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelRefBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelRefBase.getJSONValue((Object)pSModelRefBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelRefBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelRefBase pSModelRefBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelRefBase.getCreateDate() != null) {
            object = pSModelRefBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelRefBase.getCreateMan() != null) {
            object = pSModelRefBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelRefBase.getModelId() != null) {
            object = pSModelRefBase.getModelId();
            xmlNode.setAttribute(FIELD_MODELID, object == null ? "" : (String)object);
        }
        if (bl || pSModelRefBase.getModelName() != null) {
            object = pSModelRefBase.getModelName();
            xmlNode.setAttribute(FIELD_MODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelRefBase.getModelType() != null) {
            object = pSModelRefBase.getModelType();
            xmlNode.setAttribute(FIELD_MODELTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSModelRefBase.getModelTypeName() != null) {
            object = pSModelRefBase.getModelTypeName();
            xmlNode.setAttribute(FIELD_MODELTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelRefBase.getPSModelRefId() != null) {
            object = pSModelRefBase.getPSModelRefId();
            xmlNode.setAttribute(FIELD_PSMODELREFID, object == null ? "" : (String)object);
        }
        if (bl || pSModelRefBase.getPSModelRefName() != null) {
            object = pSModelRefBase.getPSModelRefName();
            xmlNode.setAttribute(FIELD_PSMODELREFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelRefBase.getRefMode() != null) {
            object = pSModelRefBase.getRefMode();
            xmlNode.setAttribute(FIELD_REFMODE, object == null ? "" : (String)object);
        }
        if (bl || pSModelRefBase.getRefModel2Id() != null) {
            object = pSModelRefBase.getRefModel2Id();
            xmlNode.setAttribute(FIELD_REFMODEL2ID, object == null ? "" : (String)object);
        }
        if (bl || pSModelRefBase.getRefModel2Name() != null) {
            object = pSModelRefBase.getRefModel2Name();
            xmlNode.setAttribute(FIELD_REFMODEL2NAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelRefBase.getRefModel2Type() != null) {
            object = pSModelRefBase.getRefModel2Type();
            xmlNode.setAttribute(FIELD_REFMODEL2TYPE, object == null ? "" : (String)object);
        }
        if (bl || pSModelRefBase.getRefModel2TypeName() != null) {
            object = pSModelRefBase.getRefModel2TypeName();
            xmlNode.setAttribute(FIELD_REFMODEL2TYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelRefBase.getRefModelId() != null) {
            object = pSModelRefBase.getRefModelId();
            xmlNode.setAttribute(FIELD_REFMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSModelRefBase.getRefModelName() != null) {
            object = pSModelRefBase.getRefModelName();
            xmlNode.setAttribute(FIELD_REFMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelRefBase.getRefModelType() != null) {
            object = pSModelRefBase.getRefModelType();
            xmlNode.setAttribute(FIELD_REFMODELTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSModelRefBase.getRefModelTypeName() != null) {
            object = pSModelRefBase.getRefModelTypeName();
            xmlNode.setAttribute(FIELD_REFMODELTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelRefBase.getUpdateDate() != null) {
            object = pSModelRefBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelRefBase.getUpdateMan() != null) {
            object = pSModelRefBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelRefBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelRefBase pSModelRefBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelRefBase.isCreateDateDirty() && (bl || pSModelRefBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelRefBase.getCreateDate());
        }
        if (pSModelRefBase.isCreateManDirty() && (bl || pSModelRefBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelRefBase.getCreateMan());
        }
        if (pSModelRefBase.isModelIdDirty() && (bl || pSModelRefBase.getModelId() != null)) {
            iDataObject.set(FIELD_MODELID, (Object)pSModelRefBase.getModelId());
        }
        if (pSModelRefBase.isModelNameDirty() && (bl || pSModelRefBase.getModelName() != null)) {
            iDataObject.set(FIELD_MODELNAME, (Object)pSModelRefBase.getModelName());
        }
        if (pSModelRefBase.isModelTypeDirty() && (bl || pSModelRefBase.getModelType() != null)) {
            iDataObject.set(FIELD_MODELTYPE, (Object)pSModelRefBase.getModelType());
        }
        if (pSModelRefBase.isModelTypeNameDirty() && (bl || pSModelRefBase.getModelTypeName() != null)) {
            iDataObject.set(FIELD_MODELTYPENAME, (Object)pSModelRefBase.getModelTypeName());
        }
        if (pSModelRefBase.isPSModelRefIdDirty() && (bl || pSModelRefBase.getPSModelRefId() != null)) {
            iDataObject.set(FIELD_PSMODELREFID, (Object)pSModelRefBase.getPSModelRefId());
        }
        if (pSModelRefBase.isPSModelRefNameDirty() && (bl || pSModelRefBase.getPSModelRefName() != null)) {
            iDataObject.set(FIELD_PSMODELREFNAME, (Object)pSModelRefBase.getPSModelRefName());
        }
        if (pSModelRefBase.isRefModeDirty() && (bl || pSModelRefBase.getRefMode() != null)) {
            iDataObject.set(FIELD_REFMODE, (Object)pSModelRefBase.getRefMode());
        }
        if (pSModelRefBase.isRefModel2IdDirty() && (bl || pSModelRefBase.getRefModel2Id() != null)) {
            iDataObject.set(FIELD_REFMODEL2ID, (Object)pSModelRefBase.getRefModel2Id());
        }
        if (pSModelRefBase.isRefModel2NameDirty() && (bl || pSModelRefBase.getRefModel2Name() != null)) {
            iDataObject.set(FIELD_REFMODEL2NAME, (Object)pSModelRefBase.getRefModel2Name());
        }
        if (pSModelRefBase.isRefModel2TypeDirty() && (bl || pSModelRefBase.getRefModel2Type() != null)) {
            iDataObject.set(FIELD_REFMODEL2TYPE, (Object)pSModelRefBase.getRefModel2Type());
        }
        if (pSModelRefBase.isRefModel2TypeNameDirty() && (bl || pSModelRefBase.getRefModel2TypeName() != null)) {
            iDataObject.set(FIELD_REFMODEL2TYPENAME, (Object)pSModelRefBase.getRefModel2TypeName());
        }
        if (pSModelRefBase.isRefModelIdDirty() && (bl || pSModelRefBase.getRefModelId() != null)) {
            iDataObject.set(FIELD_REFMODELID, (Object)pSModelRefBase.getRefModelId());
        }
        if (pSModelRefBase.isRefModelNameDirty() && (bl || pSModelRefBase.getRefModelName() != null)) {
            iDataObject.set(FIELD_REFMODELNAME, (Object)pSModelRefBase.getRefModelName());
        }
        if (pSModelRefBase.isRefModelTypeDirty() && (bl || pSModelRefBase.getRefModelType() != null)) {
            iDataObject.set(FIELD_REFMODELTYPE, (Object)pSModelRefBase.getRefModelType());
        }
        if (pSModelRefBase.isRefModelTypeNameDirty() && (bl || pSModelRefBase.getRefModelTypeName() != null)) {
            iDataObject.set(FIELD_REFMODELTYPENAME, (Object)pSModelRefBase.getRefModelTypeName());
        }
        if (pSModelRefBase.isUpdateDateDirty() && (bl || pSModelRefBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelRefBase.getUpdateDate());
        }
        if (pSModelRefBase.isUpdateManDirty() && (bl || pSModelRefBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelRefBase.getUpdateMan());
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
        return PSModelRefBase.remove(this, n);
    }

    private static boolean remove(PSModelRefBase pSModelRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelRefBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSModelRefBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSModelRefBase.resetModelId();
                return true;
            }
            case 3: {
                pSModelRefBase.resetModelName();
                return true;
            }
            case 4: {
                pSModelRefBase.resetModelType();
                return true;
            }
            case 5: {
                pSModelRefBase.resetModelTypeName();
                return true;
            }
            case 6: {
                pSModelRefBase.resetPSModelRefId();
                return true;
            }
            case 7: {
                pSModelRefBase.resetPSModelRefName();
                return true;
            }
            case 8: {
                pSModelRefBase.resetRefMode();
                return true;
            }
            case 9: {
                pSModelRefBase.resetRefModel2Id();
                return true;
            }
            case 10: {
                pSModelRefBase.resetRefModel2Name();
                return true;
            }
            case 11: {
                pSModelRefBase.resetRefModel2Type();
                return true;
            }
            case 12: {
                pSModelRefBase.resetRefModel2TypeName();
                return true;
            }
            case 13: {
                pSModelRefBase.resetRefModelId();
                return true;
            }
            case 14: {
                pSModelRefBase.resetRefModelName();
                return true;
            }
            case 15: {
                pSModelRefBase.resetRefModelType();
                return true;
            }
            case 16: {
                pSModelRefBase.resetRefModelTypeName();
                return true;
            }
            case 17: {
                pSModelRefBase.resetUpdateDate();
                return true;
            }
            case 18: {
                pSModelRefBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSModelRefBase getProxyEntity() {
        return this.proxyPSModelRefBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelRefBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelRefBase) {
            this.proxyPSModelRefBase = (PSModelRefBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModelRefService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MODELID, 2);
        fieldIndexMap.put(FIELD_MODELNAME, 3);
        fieldIndexMap.put(FIELD_MODELTYPE, 4);
        fieldIndexMap.put(FIELD_MODELTYPENAME, 5);
        fieldIndexMap.put(FIELD_PSMODELREFID, 6);
        fieldIndexMap.put(FIELD_PSMODELREFNAME, 7);
        fieldIndexMap.put(FIELD_REFMODE, 8);
        fieldIndexMap.put(FIELD_REFMODEL2ID, 9);
        fieldIndexMap.put(FIELD_REFMODEL2NAME, 10);
        fieldIndexMap.put(FIELD_REFMODEL2TYPE, 11);
        fieldIndexMap.put(FIELD_REFMODEL2TYPENAME, 12);
        fieldIndexMap.put(FIELD_REFMODELID, 13);
        fieldIndexMap.put(FIELD_REFMODELNAME, 14);
        fieldIndexMap.put(FIELD_REFMODELTYPE, 15);
        fieldIndexMap.put(FIELD_REFMODELTYPENAME, 16);
        fieldIndexMap.put(FIELD_UPDATEDATE, 17);
        fieldIndexMap.put(FIELD_UPDATEMAN, 18);
    }
}

