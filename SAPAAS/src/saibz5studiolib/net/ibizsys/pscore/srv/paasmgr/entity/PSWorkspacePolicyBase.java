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
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspace;
import net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWorkspacePolicyBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWorkspacePolicyBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_POLICYTAG = "POLICYTAG";
    public static final String FIELD_POLICYTAG2 = "POLICYTAG2";
    public static final String FIELD_POLICYTAG3 = "POLICYTAG3";
    public static final String FIELD_POLICYTAG4 = "POLICYTAG4";
    public static final String FIELD_POLICYTYPE = "POLICYTYPE";
    public static final String FIELD_PSDCWORKSPACEID = "PSDCWORKSPACEID";
    public static final String FIELD_PSWORKSPACEID = "PSWORKSPACEID";
    public static final String FIELD_PSWORKSPACENAME = "PSWORKSPACENAME";
    public static final String FIELD_PSWORKSPACEPOLICYID = "PSWORKSPACEPOLICYID";
    public static final String FIELD_PSWORKSPACEPOLICYNAME = "PSWORKSPACEPOLICYNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALUE = "VALUE";
    public static final String FIELD_VALUE2 = "VALUE2";
    public static final String FIELD_VALUE3 = "VALUE3";
    public static final String FIELD_VALUE4 = "VALUE4";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_POLICYTAG = 2;
    private static final int INDEX_POLICYTAG2 = 3;
    private static final int INDEX_POLICYTAG3 = 4;
    private static final int INDEX_POLICYTAG4 = 5;
    private static final int INDEX_POLICYTYPE = 6;
    private static final int INDEX_PSDCWORKSPACEID = 7;
    private static final int INDEX_PSWORKSPACEID = 8;
    private static final int INDEX_PSWORKSPACENAME = 9;
    private static final int INDEX_PSWORKSPACEPOLICYID = 10;
    private static final int INDEX_PSWORKSPACEPOLICYNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_VALUE = 14;
    private static final int INDEX_VALUE2 = 15;
    private static final int INDEX_VALUE3 = 16;
    private static final int INDEX_VALUE4 = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWorkspacePolicyBase proxyPSWorkspacePolicyBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean policytagDirtyFlag = false;
    private boolean policytag2DirtyFlag = false;
    private boolean policytag3DirtyFlag = false;
    private boolean policytag4DirtyFlag = false;
    private boolean policytypeDirtyFlag = false;
    private boolean psdcworkspaceidDirtyFlag = false;
    private boolean psworkspaceidDirtyFlag = false;
    private boolean psworkspacenameDirtyFlag = false;
    private boolean psworkspacepolicyidDirtyFlag = false;
    private boolean psworkspacepolicynameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean valueDirtyFlag = false;
    private boolean value2DirtyFlag = false;
    private boolean value3DirtyFlag = false;
    private boolean value4DirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="policytag")
    private String policytag;
    @Column(name="policytag2")
    private String policytag2;
    @Column(name="policytag3")
    private String policytag3;
    @Column(name="policytag4")
    private String policytag4;
    @Column(name="policytype")
    private String policytype;
    @Column(name="psdcworkspaceid")
    private String psdcworkspaceid;
    @Column(name="psworkspaceid")
    private String psworkspaceid;
    @Column(name="psworkspacename")
    private String psworkspacename;
    @Column(name="psworkspacepolicyid")
    private String psworkspacepolicyid;
    @Column(name="psworkspacepolicyname")
    private String psworkspacepolicyname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="value")
    private Integer value;
    @Column(name="value2")
    private Integer value2;
    @Column(name="value3")
    private Integer value3;
    @Column(name="value4")
    private Integer value4;
    private Integer objPSWorkspaceLock = new Integer(1);
    private PSWorkspace psworkspace = null;

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

    public void setPolicyTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPolicyTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.policytag = string;
        this.policytagDirtyFlag = true;
    }

    public String getPolicyTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPolicyTag();
        }
        return this.policytag;
    }

    public boolean isPolicyTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPolicyTagDirty();
        }
        return this.policytagDirtyFlag;
    }

    public void resetPolicyTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPolicyTag();
            return;
        }
        this.policytagDirtyFlag = false;
        this.policytag = null;
    }

    public void setPolicyTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPolicyTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.policytag2 = string;
        this.policytag2DirtyFlag = true;
    }

    public String getPolicyTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPolicyTag2();
        }
        return this.policytag2;
    }

    public boolean isPolicyTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPolicyTag2Dirty();
        }
        return this.policytag2DirtyFlag;
    }

    public void resetPolicyTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPolicyTag2();
            return;
        }
        this.policytag2DirtyFlag = false;
        this.policytag2 = null;
    }

    public void setPolicyTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPolicyTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.policytag3 = string;
        this.policytag3DirtyFlag = true;
    }

    public String getPolicyTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPolicyTag3();
        }
        return this.policytag3;
    }

    public boolean isPolicyTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPolicyTag3Dirty();
        }
        return this.policytag3DirtyFlag;
    }

    public void resetPolicyTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPolicyTag3();
            return;
        }
        this.policytag3DirtyFlag = false;
        this.policytag3 = null;
    }

    public void setPolicyTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPolicyTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.policytag4 = string;
        this.policytag4DirtyFlag = true;
    }

    public String getPolicyTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPolicyTag4();
        }
        return this.policytag4;
    }

    public boolean isPolicyTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPolicyTag4Dirty();
        }
        return this.policytag4DirtyFlag;
    }

    public void resetPolicyTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPolicyTag4();
            return;
        }
        this.policytag4DirtyFlag = false;
        this.policytag4 = null;
    }

    public void setPolicyType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPolicyType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.policytype = string;
        this.policytypeDirtyFlag = true;
    }

    public String getPolicyType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPolicyType();
        }
        return this.policytype;
    }

    public boolean isPolicyTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPolicyTypeDirty();
        }
        return this.policytypeDirtyFlag;
    }

    public void resetPolicyType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPolicyType();
            return;
        }
        this.policytypeDirtyFlag = false;
        this.policytype = null;
    }

    public void setPSDCWorkspaceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCWorkspaceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcworkspaceid = string;
        this.psdcworkspaceidDirtyFlag = true;
    }

    public String getPSDCWorkspaceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWorkspaceId();
        }
        return this.psdcworkspaceid;
    }

    public boolean isPSDCWorkspaceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCWorkspaceIdDirty();
        }
        return this.psdcworkspaceidDirtyFlag;
    }

    public void resetPSDCWorkspaceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCWorkspaceId();
            return;
        }
        this.psdcworkspaceidDirtyFlag = false;
        this.psdcworkspaceid = null;
    }

    public void setPSWorkspaceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWorkspaceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psworkspaceid = string;
        this.psworkspaceidDirtyFlag = true;
    }

    public String getPSWorkspaceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkspaceId();
        }
        return this.psworkspaceid;
    }

    public boolean isPSWorkspaceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWorkspaceIdDirty();
        }
        return this.psworkspaceidDirtyFlag;
    }

    public void resetPSWorkspaceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWorkspaceId();
            return;
        }
        this.psworkspaceidDirtyFlag = false;
        this.psworkspaceid = null;
    }

    public void setPSWorkspaceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWorkspaceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psworkspacename = string;
        this.psworkspacenameDirtyFlag = true;
    }

    public String getPSWorkspaceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkspaceName();
        }
        return this.psworkspacename;
    }

    public boolean isPSWorkspaceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWorkspaceNameDirty();
        }
        return this.psworkspacenameDirtyFlag;
    }

    public void resetPSWorkspaceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWorkspaceName();
            return;
        }
        this.psworkspacenameDirtyFlag = false;
        this.psworkspacename = null;
    }

    public void setPSWorkspacePolicyId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWorkspacePolicyId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psworkspacepolicyid = string;
        this.psworkspacepolicyidDirtyFlag = true;
    }

    public String getPSWorkspacePolicyId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkspacePolicyId();
        }
        return this.psworkspacepolicyid;
    }

    public boolean isPSWorkspacePolicyIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWorkspacePolicyIdDirty();
        }
        return this.psworkspacepolicyidDirtyFlag;
    }

    public void resetPSWorkspacePolicyId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWorkspacePolicyId();
            return;
        }
        this.psworkspacepolicyidDirtyFlag = false;
        this.psworkspacepolicyid = null;
    }

    public void setPSWorkspacePolicyName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWorkspacePolicyName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psworkspacepolicyname = string;
        this.psworkspacepolicynameDirtyFlag = true;
    }

    public String getPSWorkspacePolicyName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkspacePolicyName();
        }
        return this.psworkspacepolicyname;
    }

    public boolean isPSWorkspacePolicyNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWorkspacePolicyNameDirty();
        }
        return this.psworkspacepolicynameDirtyFlag;
    }

    public void resetPSWorkspacePolicyName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWorkspacePolicyName();
            return;
        }
        this.psworkspacepolicynameDirtyFlag = false;
        this.psworkspacepolicyname = null;
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

    public void setValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValue(n);
            return;
        }
        this.value = n;
        this.valueDirtyFlag = true;
    }

    public Integer getValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValue();
        }
        return this.value;
    }

    public boolean isValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueDirty();
        }
        return this.valueDirtyFlag;
    }

    public void resetValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValue();
            return;
        }
        this.valueDirtyFlag = false;
        this.value = null;
    }

    public void setValue2(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValue2(n);
            return;
        }
        this.value2 = n;
        this.value2DirtyFlag = true;
    }

    public Integer getValue2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValue2();
        }
        return this.value2;
    }

    public boolean isValue2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValue2Dirty();
        }
        return this.value2DirtyFlag;
    }

    public void resetValue2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValue2();
            return;
        }
        this.value2DirtyFlag = false;
        this.value2 = null;
    }

    public void setValue3(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValue3(n);
            return;
        }
        this.value3 = n;
        this.value3DirtyFlag = true;
    }

    public Integer getValue3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValue3();
        }
        return this.value3;
    }

    public boolean isValue3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValue3Dirty();
        }
        return this.value3DirtyFlag;
    }

    public void resetValue3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValue3();
            return;
        }
        this.value3DirtyFlag = false;
        this.value3 = null;
    }

    public void setValue4(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValue4(n);
            return;
        }
        this.value4 = n;
        this.value4DirtyFlag = true;
    }

    public Integer getValue4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValue4();
        }
        return this.value4;
    }

    public boolean isValue4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValue4Dirty();
        }
        return this.value4DirtyFlag;
    }

    public void resetValue4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValue4();
            return;
        }
        this.value4DirtyFlag = false;
        this.value4 = null;
    }

    protected void onReset() {
        PSWorkspacePolicyBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWorkspacePolicyBase pSWorkspacePolicyBase) {
        pSWorkspacePolicyBase.resetCreateDate();
        pSWorkspacePolicyBase.resetCreateMan();
        pSWorkspacePolicyBase.resetPolicyTag();
        pSWorkspacePolicyBase.resetPolicyTag2();
        pSWorkspacePolicyBase.resetPolicyTag3();
        pSWorkspacePolicyBase.resetPolicyTag4();
        pSWorkspacePolicyBase.resetPolicyType();
        pSWorkspacePolicyBase.resetPSDCWorkspaceId();
        pSWorkspacePolicyBase.resetPSWorkspaceId();
        pSWorkspacePolicyBase.resetPSWorkspaceName();
        pSWorkspacePolicyBase.resetPSWorkspacePolicyId();
        pSWorkspacePolicyBase.resetPSWorkspacePolicyName();
        pSWorkspacePolicyBase.resetUpdateDate();
        pSWorkspacePolicyBase.resetUpdateMan();
        pSWorkspacePolicyBase.resetValue();
        pSWorkspacePolicyBase.resetValue2();
        pSWorkspacePolicyBase.resetValue3();
        pSWorkspacePolicyBase.resetValue4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPolicyTagDirty()) {
            hashMap.put(FIELD_POLICYTAG, this.getPolicyTag());
        }
        if (!bl || this.isPolicyTag2Dirty()) {
            hashMap.put(FIELD_POLICYTAG2, this.getPolicyTag2());
        }
        if (!bl || this.isPolicyTag3Dirty()) {
            hashMap.put(FIELD_POLICYTAG3, this.getPolicyTag3());
        }
        if (!bl || this.isPolicyTag4Dirty()) {
            hashMap.put(FIELD_POLICYTAG4, this.getPolicyTag4());
        }
        if (!bl || this.isPolicyTypeDirty()) {
            hashMap.put(FIELD_POLICYTYPE, this.getPolicyType());
        }
        if (!bl || this.isPSDCWorkspaceIdDirty()) {
            hashMap.put(FIELD_PSDCWORKSPACEID, this.getPSDCWorkspaceId());
        }
        if (!bl || this.isPSWorkspaceIdDirty()) {
            hashMap.put(FIELD_PSWORKSPACEID, this.getPSWorkspaceId());
        }
        if (!bl || this.isPSWorkspaceNameDirty()) {
            hashMap.put(FIELD_PSWORKSPACENAME, this.getPSWorkspaceName());
        }
        if (!bl || this.isPSWorkspacePolicyIdDirty()) {
            hashMap.put(FIELD_PSWORKSPACEPOLICYID, this.getPSWorkspacePolicyId());
        }
        if (!bl || this.isPSWorkspacePolicyNameDirty()) {
            hashMap.put(FIELD_PSWORKSPACEPOLICYNAME, this.getPSWorkspacePolicyName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isValueDirty()) {
            hashMap.put(FIELD_VALUE, this.getValue());
        }
        if (!bl || this.isValue2Dirty()) {
            hashMap.put(FIELD_VALUE2, this.getValue2());
        }
        if (!bl || this.isValue3Dirty()) {
            hashMap.put(FIELD_VALUE3, this.getValue3());
        }
        if (!bl || this.isValue4Dirty()) {
            hashMap.put(FIELD_VALUE4, this.getValue4());
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
        return PSWorkspacePolicyBase.get(this, n);
    }

    private static Object get(PSWorkspacePolicyBase pSWorkspacePolicyBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWorkspacePolicyBase.getCreateDate();
            }
            case 1: {
                return pSWorkspacePolicyBase.getCreateMan();
            }
            case 2: {
                return pSWorkspacePolicyBase.getPolicyTag();
            }
            case 3: {
                return pSWorkspacePolicyBase.getPolicyTag2();
            }
            case 4: {
                return pSWorkspacePolicyBase.getPolicyTag3();
            }
            case 5: {
                return pSWorkspacePolicyBase.getPolicyTag4();
            }
            case 6: {
                return pSWorkspacePolicyBase.getPolicyType();
            }
            case 7: {
                return pSWorkspacePolicyBase.getPSDCWorkspaceId();
            }
            case 8: {
                return pSWorkspacePolicyBase.getPSWorkspaceId();
            }
            case 9: {
                return pSWorkspacePolicyBase.getPSWorkspaceName();
            }
            case 10: {
                return pSWorkspacePolicyBase.getPSWorkspacePolicyId();
            }
            case 11: {
                return pSWorkspacePolicyBase.getPSWorkspacePolicyName();
            }
            case 12: {
                return pSWorkspacePolicyBase.getUpdateDate();
            }
            case 13: {
                return pSWorkspacePolicyBase.getUpdateMan();
            }
            case 14: {
                return pSWorkspacePolicyBase.getValue();
            }
            case 15: {
                return pSWorkspacePolicyBase.getValue2();
            }
            case 16: {
                return pSWorkspacePolicyBase.getValue3();
            }
            case 17: {
                return pSWorkspacePolicyBase.getValue4();
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
        PSWorkspacePolicyBase.set(this, n, object);
    }

    private static void set(PSWorkspacePolicyBase pSWorkspacePolicyBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWorkspacePolicyBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSWorkspacePolicyBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSWorkspacePolicyBase.setPolicyTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWorkspacePolicyBase.setPolicyTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSWorkspacePolicyBase.setPolicyTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSWorkspacePolicyBase.setPolicyTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWorkspacePolicyBase.setPolicyType(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSWorkspacePolicyBase.setPSDCWorkspaceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSWorkspacePolicyBase.setPSWorkspaceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSWorkspacePolicyBase.setPSWorkspaceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSWorkspacePolicyBase.setPSWorkspacePolicyId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSWorkspacePolicyBase.setPSWorkspacePolicyName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSWorkspacePolicyBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSWorkspacePolicyBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSWorkspacePolicyBase.setValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSWorkspacePolicyBase.setValue2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSWorkspacePolicyBase.setValue3(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSWorkspacePolicyBase.setValue4(DataObject.getIntegerValue((Object)object));
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
        return PSWorkspacePolicyBase.isNull(this, n);
    }

    private static boolean isNull(PSWorkspacePolicyBase pSWorkspacePolicyBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWorkspacePolicyBase.getCreateDate() == null;
            }
            case 1: {
                return pSWorkspacePolicyBase.getCreateMan() == null;
            }
            case 2: {
                return pSWorkspacePolicyBase.getPolicyTag() == null;
            }
            case 3: {
                return pSWorkspacePolicyBase.getPolicyTag2() == null;
            }
            case 4: {
                return pSWorkspacePolicyBase.getPolicyTag3() == null;
            }
            case 5: {
                return pSWorkspacePolicyBase.getPolicyTag4() == null;
            }
            case 6: {
                return pSWorkspacePolicyBase.getPolicyType() == null;
            }
            case 7: {
                return pSWorkspacePolicyBase.getPSDCWorkspaceId() == null;
            }
            case 8: {
                return pSWorkspacePolicyBase.getPSWorkspaceId() == null;
            }
            case 9: {
                return pSWorkspacePolicyBase.getPSWorkspaceName() == null;
            }
            case 10: {
                return pSWorkspacePolicyBase.getPSWorkspacePolicyId() == null;
            }
            case 11: {
                return pSWorkspacePolicyBase.getPSWorkspacePolicyName() == null;
            }
            case 12: {
                return pSWorkspacePolicyBase.getUpdateDate() == null;
            }
            case 13: {
                return pSWorkspacePolicyBase.getUpdateMan() == null;
            }
            case 14: {
                return pSWorkspacePolicyBase.getValue() == null;
            }
            case 15: {
                return pSWorkspacePolicyBase.getValue2() == null;
            }
            case 16: {
                return pSWorkspacePolicyBase.getValue3() == null;
            }
            case 17: {
                return pSWorkspacePolicyBase.getValue4() == null;
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
        return PSWorkspacePolicyBase.contains(this, n);
    }

    private static boolean contains(PSWorkspacePolicyBase pSWorkspacePolicyBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWorkspacePolicyBase.isCreateDateDirty();
            }
            case 1: {
                return pSWorkspacePolicyBase.isCreateManDirty();
            }
            case 2: {
                return pSWorkspacePolicyBase.isPolicyTagDirty();
            }
            case 3: {
                return pSWorkspacePolicyBase.isPolicyTag2Dirty();
            }
            case 4: {
                return pSWorkspacePolicyBase.isPolicyTag3Dirty();
            }
            case 5: {
                return pSWorkspacePolicyBase.isPolicyTag4Dirty();
            }
            case 6: {
                return pSWorkspacePolicyBase.isPolicyTypeDirty();
            }
            case 7: {
                return pSWorkspacePolicyBase.isPSDCWorkspaceIdDirty();
            }
            case 8: {
                return pSWorkspacePolicyBase.isPSWorkspaceIdDirty();
            }
            case 9: {
                return pSWorkspacePolicyBase.isPSWorkspaceNameDirty();
            }
            case 10: {
                return pSWorkspacePolicyBase.isPSWorkspacePolicyIdDirty();
            }
            case 11: {
                return pSWorkspacePolicyBase.isPSWorkspacePolicyNameDirty();
            }
            case 12: {
                return pSWorkspacePolicyBase.isUpdateDateDirty();
            }
            case 13: {
                return pSWorkspacePolicyBase.isUpdateManDirty();
            }
            case 14: {
                return pSWorkspacePolicyBase.isValueDirty();
            }
            case 15: {
                return pSWorkspacePolicyBase.isValue2Dirty();
            }
            case 16: {
                return pSWorkspacePolicyBase.isValue3Dirty();
            }
            case 17: {
                return pSWorkspacePolicyBase.isValue4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWorkspacePolicyBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWorkspacePolicyBase pSWorkspacePolicyBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWorkspacePolicyBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWorkspacePolicyBase.getJSONValue((Object)pSWorkspacePolicyBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWorkspacePolicyBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWorkspacePolicyBase.getJSONValue((Object)pSWorkspacePolicyBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWorkspacePolicyBase.getPolicyTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"policytag", (Object)PSWorkspacePolicyBase.getJSONValue((Object)pSWorkspacePolicyBase.getPolicyTag()), (boolean)false);
        }
        if (bl || pSWorkspacePolicyBase.getPolicyTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"policytag2", (Object)PSWorkspacePolicyBase.getJSONValue((Object)pSWorkspacePolicyBase.getPolicyTag2()), (boolean)false);
        }
        if (bl || pSWorkspacePolicyBase.getPolicyTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"policytag3", (Object)PSWorkspacePolicyBase.getJSONValue((Object)pSWorkspacePolicyBase.getPolicyTag3()), (boolean)false);
        }
        if (bl || pSWorkspacePolicyBase.getPolicyTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"policytag4", (Object)PSWorkspacePolicyBase.getJSONValue((Object)pSWorkspacePolicyBase.getPolicyTag4()), (boolean)false);
        }
        if (bl || pSWorkspacePolicyBase.getPolicyType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"policytype", (Object)PSWorkspacePolicyBase.getJSONValue((Object)pSWorkspacePolicyBase.getPolicyType()), (boolean)false);
        }
        if (bl || pSWorkspacePolicyBase.getPSDCWorkspaceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcworkspaceid", (Object)PSWorkspacePolicyBase.getJSONValue((Object)pSWorkspacePolicyBase.getPSDCWorkspaceId()), (boolean)false);
        }
        if (bl || pSWorkspacePolicyBase.getPSWorkspaceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkspaceid", (Object)PSWorkspacePolicyBase.getJSONValue((Object)pSWorkspacePolicyBase.getPSWorkspaceId()), (boolean)false);
        }
        if (bl || pSWorkspacePolicyBase.getPSWorkspaceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkspacename", (Object)PSWorkspacePolicyBase.getJSONValue((Object)pSWorkspacePolicyBase.getPSWorkspaceName()), (boolean)false);
        }
        if (bl || pSWorkspacePolicyBase.getPSWorkspacePolicyId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkspacepolicyid", (Object)PSWorkspacePolicyBase.getJSONValue((Object)pSWorkspacePolicyBase.getPSWorkspacePolicyId()), (boolean)false);
        }
        if (bl || pSWorkspacePolicyBase.getPSWorkspacePolicyName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkspacepolicyname", (Object)PSWorkspacePolicyBase.getJSONValue((Object)pSWorkspacePolicyBase.getPSWorkspacePolicyName()), (boolean)false);
        }
        if (bl || pSWorkspacePolicyBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWorkspacePolicyBase.getJSONValue((Object)pSWorkspacePolicyBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWorkspacePolicyBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWorkspacePolicyBase.getJSONValue((Object)pSWorkspacePolicyBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSWorkspacePolicyBase.getValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"value", (Object)PSWorkspacePolicyBase.getJSONValue((Object)pSWorkspacePolicyBase.getValue()), (boolean)false);
        }
        if (bl || pSWorkspacePolicyBase.getValue2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"value2", (Object)PSWorkspacePolicyBase.getJSONValue((Object)pSWorkspacePolicyBase.getValue2()), (boolean)false);
        }
        if (bl || pSWorkspacePolicyBase.getValue3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"value3", (Object)PSWorkspacePolicyBase.getJSONValue((Object)pSWorkspacePolicyBase.getValue3()), (boolean)false);
        }
        if (bl || pSWorkspacePolicyBase.getValue4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"value4", (Object)PSWorkspacePolicyBase.getJSONValue((Object)pSWorkspacePolicyBase.getValue4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWorkspacePolicyBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWorkspacePolicyBase pSWorkspacePolicyBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWorkspacePolicyBase.getCreateDate() != null) {
            object = pSWorkspacePolicyBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWorkspacePolicyBase.getCreateMan() != null) {
            object = pSWorkspacePolicyBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspacePolicyBase.getPolicyTag() != null) {
            object = pSWorkspacePolicyBase.getPolicyTag();
            xmlNode.setAttribute(FIELD_POLICYTAG, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspacePolicyBase.getPolicyTag2() != null) {
            object = pSWorkspacePolicyBase.getPolicyTag2();
            xmlNode.setAttribute(FIELD_POLICYTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspacePolicyBase.getPolicyTag3() != null) {
            object = pSWorkspacePolicyBase.getPolicyTag3();
            xmlNode.setAttribute(FIELD_POLICYTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspacePolicyBase.getPolicyTag4() != null) {
            object = pSWorkspacePolicyBase.getPolicyTag4();
            xmlNode.setAttribute(FIELD_POLICYTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspacePolicyBase.getPolicyType() != null) {
            object = pSWorkspacePolicyBase.getPolicyType();
            xmlNode.setAttribute(FIELD_POLICYTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspacePolicyBase.getPSDCWorkspaceId() != null) {
            object = pSWorkspacePolicyBase.getPSDCWorkspaceId();
            xmlNode.setAttribute(FIELD_PSDCWORKSPACEID, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspacePolicyBase.getPSWorkspaceId() != null) {
            object = pSWorkspacePolicyBase.getPSWorkspaceId();
            xmlNode.setAttribute(FIELD_PSWORKSPACEID, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspacePolicyBase.getPSWorkspaceName() != null) {
            object = pSWorkspacePolicyBase.getPSWorkspaceName();
            xmlNode.setAttribute(FIELD_PSWORKSPACENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspacePolicyBase.getPSWorkspacePolicyId() != null) {
            object = pSWorkspacePolicyBase.getPSWorkspacePolicyId();
            xmlNode.setAttribute(FIELD_PSWORKSPACEPOLICYID, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspacePolicyBase.getPSWorkspacePolicyName() != null) {
            object = pSWorkspacePolicyBase.getPSWorkspacePolicyName();
            xmlNode.setAttribute(FIELD_PSWORKSPACEPOLICYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspacePolicyBase.getUpdateDate() != null) {
            object = pSWorkspacePolicyBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWorkspacePolicyBase.getUpdateMan() != null) {
            object = pSWorkspacePolicyBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspacePolicyBase.getValue() != null) {
            object = pSWorkspacePolicyBase.getValue();
            xmlNode.setAttribute(FIELD_VALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkspacePolicyBase.getValue2() != null) {
            object = pSWorkspacePolicyBase.getValue2();
            xmlNode.setAttribute(FIELD_VALUE2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkspacePolicyBase.getValue3() != null) {
            object = pSWorkspacePolicyBase.getValue3();
            xmlNode.setAttribute(FIELD_VALUE3, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkspacePolicyBase.getValue4() != null) {
            object = pSWorkspacePolicyBase.getValue4();
            xmlNode.setAttribute(FIELD_VALUE4, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWorkspacePolicyBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWorkspacePolicyBase pSWorkspacePolicyBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWorkspacePolicyBase.isCreateDateDirty() && (bl || pSWorkspacePolicyBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWorkspacePolicyBase.getCreateDate());
        }
        if (pSWorkspacePolicyBase.isCreateManDirty() && (bl || pSWorkspacePolicyBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWorkspacePolicyBase.getCreateMan());
        }
        if (pSWorkspacePolicyBase.isPolicyTagDirty() && (bl || pSWorkspacePolicyBase.getPolicyTag() != null)) {
            iDataObject.set(FIELD_POLICYTAG, (Object)pSWorkspacePolicyBase.getPolicyTag());
        }
        if (pSWorkspacePolicyBase.isPolicyTag2Dirty() && (bl || pSWorkspacePolicyBase.getPolicyTag2() != null)) {
            iDataObject.set(FIELD_POLICYTAG2, (Object)pSWorkspacePolicyBase.getPolicyTag2());
        }
        if (pSWorkspacePolicyBase.isPolicyTag3Dirty() && (bl || pSWorkspacePolicyBase.getPolicyTag3() != null)) {
            iDataObject.set(FIELD_POLICYTAG3, (Object)pSWorkspacePolicyBase.getPolicyTag3());
        }
        if (pSWorkspacePolicyBase.isPolicyTag4Dirty() && (bl || pSWorkspacePolicyBase.getPolicyTag4() != null)) {
            iDataObject.set(FIELD_POLICYTAG4, (Object)pSWorkspacePolicyBase.getPolicyTag4());
        }
        if (pSWorkspacePolicyBase.isPolicyTypeDirty() && (bl || pSWorkspacePolicyBase.getPolicyType() != null)) {
            iDataObject.set(FIELD_POLICYTYPE, (Object)pSWorkspacePolicyBase.getPolicyType());
        }
        if (pSWorkspacePolicyBase.isPSDCWorkspaceIdDirty() && (bl || pSWorkspacePolicyBase.getPSDCWorkspaceId() != null)) {
            iDataObject.set(FIELD_PSDCWORKSPACEID, (Object)pSWorkspacePolicyBase.getPSDCWorkspaceId());
        }
        if (pSWorkspacePolicyBase.isPSWorkspaceIdDirty() && (bl || pSWorkspacePolicyBase.getPSWorkspaceId() != null)) {
            iDataObject.set(FIELD_PSWORKSPACEID, (Object)pSWorkspacePolicyBase.getPSWorkspaceId());
        }
        if (pSWorkspacePolicyBase.isPSWorkspaceNameDirty() && (bl || pSWorkspacePolicyBase.getPSWorkspaceName() != null)) {
            iDataObject.set(FIELD_PSWORKSPACENAME, (Object)pSWorkspacePolicyBase.getPSWorkspaceName());
        }
        if (pSWorkspacePolicyBase.isPSWorkspacePolicyIdDirty() && (bl || pSWorkspacePolicyBase.getPSWorkspacePolicyId() != null)) {
            iDataObject.set(FIELD_PSWORKSPACEPOLICYID, (Object)pSWorkspacePolicyBase.getPSWorkspacePolicyId());
        }
        if (pSWorkspacePolicyBase.isPSWorkspacePolicyNameDirty() && (bl || pSWorkspacePolicyBase.getPSWorkspacePolicyName() != null)) {
            iDataObject.set(FIELD_PSWORKSPACEPOLICYNAME, (Object)pSWorkspacePolicyBase.getPSWorkspacePolicyName());
        }
        if (pSWorkspacePolicyBase.isUpdateDateDirty() && (bl || pSWorkspacePolicyBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWorkspacePolicyBase.getUpdateDate());
        }
        if (pSWorkspacePolicyBase.isUpdateManDirty() && (bl || pSWorkspacePolicyBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWorkspacePolicyBase.getUpdateMan());
        }
        if (pSWorkspacePolicyBase.isValueDirty() && (bl || pSWorkspacePolicyBase.getValue() != null)) {
            iDataObject.set(FIELD_VALUE, (Object)pSWorkspacePolicyBase.getValue());
        }
        if (pSWorkspacePolicyBase.isValue2Dirty() && (bl || pSWorkspacePolicyBase.getValue2() != null)) {
            iDataObject.set(FIELD_VALUE2, (Object)pSWorkspacePolicyBase.getValue2());
        }
        if (pSWorkspacePolicyBase.isValue3Dirty() && (bl || pSWorkspacePolicyBase.getValue3() != null)) {
            iDataObject.set(FIELD_VALUE3, (Object)pSWorkspacePolicyBase.getValue3());
        }
        if (pSWorkspacePolicyBase.isValue4Dirty() && (bl || pSWorkspacePolicyBase.getValue4() != null)) {
            iDataObject.set(FIELD_VALUE4, (Object)pSWorkspacePolicyBase.getValue4());
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
        return PSWorkspacePolicyBase.remove(this, n);
    }

    private static boolean remove(PSWorkspacePolicyBase pSWorkspacePolicyBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWorkspacePolicyBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSWorkspacePolicyBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSWorkspacePolicyBase.resetPolicyTag();
                return true;
            }
            case 3: {
                pSWorkspacePolicyBase.resetPolicyTag2();
                return true;
            }
            case 4: {
                pSWorkspacePolicyBase.resetPolicyTag3();
                return true;
            }
            case 5: {
                pSWorkspacePolicyBase.resetPolicyTag4();
                return true;
            }
            case 6: {
                pSWorkspacePolicyBase.resetPolicyType();
                return true;
            }
            case 7: {
                pSWorkspacePolicyBase.resetPSDCWorkspaceId();
                return true;
            }
            case 8: {
                pSWorkspacePolicyBase.resetPSWorkspaceId();
                return true;
            }
            case 9: {
                pSWorkspacePolicyBase.resetPSWorkspaceName();
                return true;
            }
            case 10: {
                pSWorkspacePolicyBase.resetPSWorkspacePolicyId();
                return true;
            }
            case 11: {
                pSWorkspacePolicyBase.resetPSWorkspacePolicyName();
                return true;
            }
            case 12: {
                pSWorkspacePolicyBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSWorkspacePolicyBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSWorkspacePolicyBase.resetValue();
                return true;
            }
            case 15: {
                pSWorkspacePolicyBase.resetValue2();
                return true;
            }
            case 16: {
                pSWorkspacePolicyBase.resetValue3();
                return true;
            }
            case 17: {
                pSWorkspacePolicyBase.resetValue4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWorkspace getPSWorkspace() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkspace();
        }
        if (this.getPSWorkspaceId() == null) {
            return null;
        }
        Integer n = this.objPSWorkspaceLock;
        synchronized (n) {
            if (this.psworkspace != null && DataTypeHelper.compare((int)25, (Object)this.getPSWorkspaceId(), (Object)this.psworkspace.getPSWorkspaceId()) != 0L) {
                this.psworkspace = null;
            }
            if (this.psworkspace == null) {
                PSWorkspace pSWorkspace = new PSWorkspace();
                pSWorkspace.setPSWorkspaceId(this.getPSWorkspaceId());
                PSWorkspaceService pSWorkspaceService = (PSWorkspaceService)ServiceGlobal.getService(PSWorkspaceService.class, (SessionFactory)this.getSessionFactory());
                pSWorkspaceService.autoGet(pSWorkspace);
                this.psworkspace = pSWorkspace;
            }
            return this.psworkspace;
        }
    }

    private PSWorkspacePolicyBase getProxyEntity() {
        return this.proxyPSWorkspacePolicyBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWorkspacePolicyBase = null;
        if (iDataObject != null && iDataObject instanceof PSWorkspacePolicyBase) {
            this.proxyPSWorkspacePolicyBase = (PSWorkspacePolicyBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSWorkspacePolicyService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_POLICYTAG, 2);
        fieldIndexMap.put(FIELD_POLICYTAG2, 3);
        fieldIndexMap.put(FIELD_POLICYTAG3, 4);
        fieldIndexMap.put(FIELD_POLICYTAG4, 5);
        fieldIndexMap.put(FIELD_POLICYTYPE, 6);
        fieldIndexMap.put(FIELD_PSDCWORKSPACEID, 7);
        fieldIndexMap.put(FIELD_PSWORKSPACEID, 8);
        fieldIndexMap.put(FIELD_PSWORKSPACENAME, 9);
        fieldIndexMap.put(FIELD_PSWORKSPACEPOLICYID, 10);
        fieldIndexMap.put(FIELD_PSWORKSPACEPOLICYNAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_VALUE, 14);
        fieldIndexMap.put(FIELD_VALUE2, 15);
        fieldIndexMap.put(FIELD_VALUE3, 16);
        fieldIndexMap.put(FIELD_VALUE4, 17);
    }
}

