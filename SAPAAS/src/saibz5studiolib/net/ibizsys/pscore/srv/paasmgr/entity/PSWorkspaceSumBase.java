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

public abstract class PSWorkspaceSumBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWorkspaceSumBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDCWORKSPACEID = "PSDCWORKSPACEID";
    public static final String FIELD_PSWORKSPACEID = "PSWORKSPACEID";
    public static final String FIELD_PSWORKSPACENAME = "PSWORKSPACENAME";
    public static final String FIELD_PSWORKSPACESUMID = "PSWORKSPACESUMID";
    public static final String FIELD_PSWORKSPACESUMNAME = "PSWORKSPACESUMNAME";
    public static final String FIELD_SUMTAG = "SUMTAG";
    public static final String FIELD_SUMTAG2 = "SUMTAG2";
    public static final String FIELD_SUMTYPE = "SUMTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALUE = "VALUE";
    public static final String FIELD_VALUE2 = "VALUE2";
    public static final String FIELD_VALUE3 = "VALUE3";
    public static final String FIELD_VALUE4 = "VALUE4";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDCWORKSPACEID = 2;
    private static final int INDEX_PSWORKSPACEID = 3;
    private static final int INDEX_PSWORKSPACENAME = 4;
    private static final int INDEX_PSWORKSPACESUMID = 5;
    private static final int INDEX_PSWORKSPACESUMNAME = 6;
    private static final int INDEX_SUMTAG = 7;
    private static final int INDEX_SUMTAG2 = 8;
    private static final int INDEX_SUMTYPE = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_VALUE = 12;
    private static final int INDEX_VALUE2 = 13;
    private static final int INDEX_VALUE3 = 14;
    private static final int INDEX_VALUE4 = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWorkspaceSumBase proxyPSWorkspaceSumBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdcworkspaceidDirtyFlag = false;
    private boolean psworkspaceidDirtyFlag = false;
    private boolean psworkspacenameDirtyFlag = false;
    private boolean psworkspacesumidDirtyFlag = false;
    private boolean psworkspacesumnameDirtyFlag = false;
    private boolean sumtagDirtyFlag = false;
    private boolean sumtag2DirtyFlag = false;
    private boolean sumtypeDirtyFlag = false;
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
    @Column(name="psdcworkspaceid")
    private String psdcworkspaceid;
    @Column(name="psworkspaceid")
    private String psworkspaceid;
    @Column(name="psworkspacename")
    private String psworkspacename;
    @Column(name="psworkspacesumid")
    private String psworkspacesumid;
    @Column(name="psworkspacesumname")
    private String psworkspacesumname;
    @Column(name="sumtag")
    private String sumtag;
    @Column(name="sumtag2")
    private String sumtag2;
    @Column(name="sumtype")
    private String sumtype;
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

    public void setPSWorkspaceSumId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWorkspaceSumId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psworkspacesumid = string;
        this.psworkspacesumidDirtyFlag = true;
    }

    public String getPSWorkspaceSumId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkspaceSumId();
        }
        return this.psworkspacesumid;
    }

    public boolean isPSWorkspaceSumIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWorkspaceSumIdDirty();
        }
        return this.psworkspacesumidDirtyFlag;
    }

    public void resetPSWorkspaceSumId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWorkspaceSumId();
            return;
        }
        this.psworkspacesumidDirtyFlag = false;
        this.psworkspacesumid = null;
    }

    public void setPSWorkspaceSumName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWorkspaceSumName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psworkspacesumname = string;
        this.psworkspacesumnameDirtyFlag = true;
    }

    public String getPSWorkspaceSumName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkspaceSumName();
        }
        return this.psworkspacesumname;
    }

    public boolean isPSWorkspaceSumNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWorkspaceSumNameDirty();
        }
        return this.psworkspacesumnameDirtyFlag;
    }

    public void resetPSWorkspaceSumName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWorkspaceSumName();
            return;
        }
        this.psworkspacesumnameDirtyFlag = false;
        this.psworkspacesumname = null;
    }

    public void setSumTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSumTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sumtag = string;
        this.sumtagDirtyFlag = true;
    }

    public String getSumTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSumTag();
        }
        return this.sumtag;
    }

    public boolean isSumTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSumTagDirty();
        }
        return this.sumtagDirtyFlag;
    }

    public void resetSumTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSumTag();
            return;
        }
        this.sumtagDirtyFlag = false;
        this.sumtag = null;
    }

    public void setSumTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSumTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sumtag2 = string;
        this.sumtag2DirtyFlag = true;
    }

    public String getSumTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSumTag2();
        }
        return this.sumtag2;
    }

    public boolean isSumTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSumTag2Dirty();
        }
        return this.sumtag2DirtyFlag;
    }

    public void resetSumTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSumTag2();
            return;
        }
        this.sumtag2DirtyFlag = false;
        this.sumtag2 = null;
    }

    public void setSumType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSumType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sumtype = string;
        this.sumtypeDirtyFlag = true;
    }

    public String getSumType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSumType();
        }
        return this.sumtype;
    }

    public boolean isSumTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSumTypeDirty();
        }
        return this.sumtypeDirtyFlag;
    }

    public void resetSumType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSumType();
            return;
        }
        this.sumtypeDirtyFlag = false;
        this.sumtype = null;
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
        PSWorkspaceSumBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWorkspaceSumBase pSWorkspaceSumBase) {
        pSWorkspaceSumBase.resetCreateDate();
        pSWorkspaceSumBase.resetCreateMan();
        pSWorkspaceSumBase.resetPSDCWorkspaceId();
        pSWorkspaceSumBase.resetPSWorkspaceId();
        pSWorkspaceSumBase.resetPSWorkspaceName();
        pSWorkspaceSumBase.resetPSWorkspaceSumId();
        pSWorkspaceSumBase.resetPSWorkspaceSumName();
        pSWorkspaceSumBase.resetSumTag();
        pSWorkspaceSumBase.resetSumTag2();
        pSWorkspaceSumBase.resetSumType();
        pSWorkspaceSumBase.resetUpdateDate();
        pSWorkspaceSumBase.resetUpdateMan();
        pSWorkspaceSumBase.resetValue();
        pSWorkspaceSumBase.resetValue2();
        pSWorkspaceSumBase.resetValue3();
        pSWorkspaceSumBase.resetValue4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
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
        if (!bl || this.isPSWorkspaceSumIdDirty()) {
            hashMap.put(FIELD_PSWORKSPACESUMID, this.getPSWorkspaceSumId());
        }
        if (!bl || this.isPSWorkspaceSumNameDirty()) {
            hashMap.put(FIELD_PSWORKSPACESUMNAME, this.getPSWorkspaceSumName());
        }
        if (!bl || this.isSumTagDirty()) {
            hashMap.put(FIELD_SUMTAG, this.getSumTag());
        }
        if (!bl || this.isSumTag2Dirty()) {
            hashMap.put(FIELD_SUMTAG2, this.getSumTag2());
        }
        if (!bl || this.isSumTypeDirty()) {
            hashMap.put(FIELD_SUMTYPE, this.getSumType());
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
        return PSWorkspaceSumBase.get(this, n);
    }

    private static Object get(PSWorkspaceSumBase pSWorkspaceSumBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWorkspaceSumBase.getCreateDate();
            }
            case 1: {
                return pSWorkspaceSumBase.getCreateMan();
            }
            case 2: {
                return pSWorkspaceSumBase.getPSDCWorkspaceId();
            }
            case 3: {
                return pSWorkspaceSumBase.getPSWorkspaceId();
            }
            case 4: {
                return pSWorkspaceSumBase.getPSWorkspaceName();
            }
            case 5: {
                return pSWorkspaceSumBase.getPSWorkspaceSumId();
            }
            case 6: {
                return pSWorkspaceSumBase.getPSWorkspaceSumName();
            }
            case 7: {
                return pSWorkspaceSumBase.getSumTag();
            }
            case 8: {
                return pSWorkspaceSumBase.getSumTag2();
            }
            case 9: {
                return pSWorkspaceSumBase.getSumType();
            }
            case 10: {
                return pSWorkspaceSumBase.getUpdateDate();
            }
            case 11: {
                return pSWorkspaceSumBase.getUpdateMan();
            }
            case 12: {
                return pSWorkspaceSumBase.getValue();
            }
            case 13: {
                return pSWorkspaceSumBase.getValue2();
            }
            case 14: {
                return pSWorkspaceSumBase.getValue3();
            }
            case 15: {
                return pSWorkspaceSumBase.getValue4();
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
        PSWorkspaceSumBase.set(this, n, object);
    }

    private static void set(PSWorkspaceSumBase pSWorkspaceSumBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWorkspaceSumBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSWorkspaceSumBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSWorkspaceSumBase.setPSDCWorkspaceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWorkspaceSumBase.setPSWorkspaceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSWorkspaceSumBase.setPSWorkspaceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSWorkspaceSumBase.setPSWorkspaceSumId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWorkspaceSumBase.setPSWorkspaceSumName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSWorkspaceSumBase.setSumTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSWorkspaceSumBase.setSumTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSWorkspaceSumBase.setSumType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSWorkspaceSumBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSWorkspaceSumBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSWorkspaceSumBase.setValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSWorkspaceSumBase.setValue2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSWorkspaceSumBase.setValue3(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSWorkspaceSumBase.setValue4(DataObject.getIntegerValue((Object)object));
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
        return PSWorkspaceSumBase.isNull(this, n);
    }

    private static boolean isNull(PSWorkspaceSumBase pSWorkspaceSumBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWorkspaceSumBase.getCreateDate() == null;
            }
            case 1: {
                return pSWorkspaceSumBase.getCreateMan() == null;
            }
            case 2: {
                return pSWorkspaceSumBase.getPSDCWorkspaceId() == null;
            }
            case 3: {
                return pSWorkspaceSumBase.getPSWorkspaceId() == null;
            }
            case 4: {
                return pSWorkspaceSumBase.getPSWorkspaceName() == null;
            }
            case 5: {
                return pSWorkspaceSumBase.getPSWorkspaceSumId() == null;
            }
            case 6: {
                return pSWorkspaceSumBase.getPSWorkspaceSumName() == null;
            }
            case 7: {
                return pSWorkspaceSumBase.getSumTag() == null;
            }
            case 8: {
                return pSWorkspaceSumBase.getSumTag2() == null;
            }
            case 9: {
                return pSWorkspaceSumBase.getSumType() == null;
            }
            case 10: {
                return pSWorkspaceSumBase.getUpdateDate() == null;
            }
            case 11: {
                return pSWorkspaceSumBase.getUpdateMan() == null;
            }
            case 12: {
                return pSWorkspaceSumBase.getValue() == null;
            }
            case 13: {
                return pSWorkspaceSumBase.getValue2() == null;
            }
            case 14: {
                return pSWorkspaceSumBase.getValue3() == null;
            }
            case 15: {
                return pSWorkspaceSumBase.getValue4() == null;
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
        return PSWorkspaceSumBase.contains(this, n);
    }

    private static boolean contains(PSWorkspaceSumBase pSWorkspaceSumBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWorkspaceSumBase.isCreateDateDirty();
            }
            case 1: {
                return pSWorkspaceSumBase.isCreateManDirty();
            }
            case 2: {
                return pSWorkspaceSumBase.isPSDCWorkspaceIdDirty();
            }
            case 3: {
                return pSWorkspaceSumBase.isPSWorkspaceIdDirty();
            }
            case 4: {
                return pSWorkspaceSumBase.isPSWorkspaceNameDirty();
            }
            case 5: {
                return pSWorkspaceSumBase.isPSWorkspaceSumIdDirty();
            }
            case 6: {
                return pSWorkspaceSumBase.isPSWorkspaceSumNameDirty();
            }
            case 7: {
                return pSWorkspaceSumBase.isSumTagDirty();
            }
            case 8: {
                return pSWorkspaceSumBase.isSumTag2Dirty();
            }
            case 9: {
                return pSWorkspaceSumBase.isSumTypeDirty();
            }
            case 10: {
                return pSWorkspaceSumBase.isUpdateDateDirty();
            }
            case 11: {
                return pSWorkspaceSumBase.isUpdateManDirty();
            }
            case 12: {
                return pSWorkspaceSumBase.isValueDirty();
            }
            case 13: {
                return pSWorkspaceSumBase.isValue2Dirty();
            }
            case 14: {
                return pSWorkspaceSumBase.isValue3Dirty();
            }
            case 15: {
                return pSWorkspaceSumBase.isValue4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWorkspaceSumBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWorkspaceSumBase pSWorkspaceSumBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWorkspaceSumBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWorkspaceSumBase.getJSONValue((Object)pSWorkspaceSumBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWorkspaceSumBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWorkspaceSumBase.getJSONValue((Object)pSWorkspaceSumBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWorkspaceSumBase.getPSDCWorkspaceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcworkspaceid", (Object)PSWorkspaceSumBase.getJSONValue((Object)pSWorkspaceSumBase.getPSDCWorkspaceId()), (boolean)false);
        }
        if (bl || pSWorkspaceSumBase.getPSWorkspaceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkspaceid", (Object)PSWorkspaceSumBase.getJSONValue((Object)pSWorkspaceSumBase.getPSWorkspaceId()), (boolean)false);
        }
        if (bl || pSWorkspaceSumBase.getPSWorkspaceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkspacename", (Object)PSWorkspaceSumBase.getJSONValue((Object)pSWorkspaceSumBase.getPSWorkspaceName()), (boolean)false);
        }
        if (bl || pSWorkspaceSumBase.getPSWorkspaceSumId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkspacesumid", (Object)PSWorkspaceSumBase.getJSONValue((Object)pSWorkspaceSumBase.getPSWorkspaceSumId()), (boolean)false);
        }
        if (bl || pSWorkspaceSumBase.getPSWorkspaceSumName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkspacesumname", (Object)PSWorkspaceSumBase.getJSONValue((Object)pSWorkspaceSumBase.getPSWorkspaceSumName()), (boolean)false);
        }
        if (bl || pSWorkspaceSumBase.getSumTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sumtag", (Object)PSWorkspaceSumBase.getJSONValue((Object)pSWorkspaceSumBase.getSumTag()), (boolean)false);
        }
        if (bl || pSWorkspaceSumBase.getSumTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sumtag2", (Object)PSWorkspaceSumBase.getJSONValue((Object)pSWorkspaceSumBase.getSumTag2()), (boolean)false);
        }
        if (bl || pSWorkspaceSumBase.getSumType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sumtype", (Object)PSWorkspaceSumBase.getJSONValue((Object)pSWorkspaceSumBase.getSumType()), (boolean)false);
        }
        if (bl || pSWorkspaceSumBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWorkspaceSumBase.getJSONValue((Object)pSWorkspaceSumBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWorkspaceSumBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWorkspaceSumBase.getJSONValue((Object)pSWorkspaceSumBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSWorkspaceSumBase.getValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"value", (Object)PSWorkspaceSumBase.getJSONValue((Object)pSWorkspaceSumBase.getValue()), (boolean)false);
        }
        if (bl || pSWorkspaceSumBase.getValue2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"value2", (Object)PSWorkspaceSumBase.getJSONValue((Object)pSWorkspaceSumBase.getValue2()), (boolean)false);
        }
        if (bl || pSWorkspaceSumBase.getValue3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"value3", (Object)PSWorkspaceSumBase.getJSONValue((Object)pSWorkspaceSumBase.getValue3()), (boolean)false);
        }
        if (bl || pSWorkspaceSumBase.getValue4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"value4", (Object)PSWorkspaceSumBase.getJSONValue((Object)pSWorkspaceSumBase.getValue4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWorkspaceSumBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWorkspaceSumBase pSWorkspaceSumBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWorkspaceSumBase.getCreateDate() != null) {
            object = pSWorkspaceSumBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWorkspaceSumBase.getCreateMan() != null) {
            object = pSWorkspaceSumBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceSumBase.getPSDCWorkspaceId() != null) {
            object = pSWorkspaceSumBase.getPSDCWorkspaceId();
            xmlNode.setAttribute(FIELD_PSDCWORKSPACEID, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceSumBase.getPSWorkspaceId() != null) {
            object = pSWorkspaceSumBase.getPSWorkspaceId();
            xmlNode.setAttribute(FIELD_PSWORKSPACEID, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceSumBase.getPSWorkspaceName() != null) {
            object = pSWorkspaceSumBase.getPSWorkspaceName();
            xmlNode.setAttribute(FIELD_PSWORKSPACENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceSumBase.getPSWorkspaceSumId() != null) {
            object = pSWorkspaceSumBase.getPSWorkspaceSumId();
            xmlNode.setAttribute(FIELD_PSWORKSPACESUMID, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceSumBase.getPSWorkspaceSumName() != null) {
            object = pSWorkspaceSumBase.getPSWorkspaceSumName();
            xmlNode.setAttribute(FIELD_PSWORKSPACESUMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceSumBase.getSumTag() != null) {
            object = pSWorkspaceSumBase.getSumTag();
            xmlNode.setAttribute(FIELD_SUMTAG, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceSumBase.getSumTag2() != null) {
            object = pSWorkspaceSumBase.getSumTag2();
            xmlNode.setAttribute(FIELD_SUMTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceSumBase.getSumType() != null) {
            object = pSWorkspaceSumBase.getSumType();
            xmlNode.setAttribute(FIELD_SUMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceSumBase.getUpdateDate() != null) {
            object = pSWorkspaceSumBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWorkspaceSumBase.getUpdateMan() != null) {
            object = pSWorkspaceSumBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWorkspaceSumBase.getValue() != null) {
            object = pSWorkspaceSumBase.getValue();
            xmlNode.setAttribute(FIELD_VALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkspaceSumBase.getValue2() != null) {
            object = pSWorkspaceSumBase.getValue2();
            xmlNode.setAttribute(FIELD_VALUE2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkspaceSumBase.getValue3() != null) {
            object = pSWorkspaceSumBase.getValue3();
            xmlNode.setAttribute(FIELD_VALUE3, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWorkspaceSumBase.getValue4() != null) {
            object = pSWorkspaceSumBase.getValue4();
            xmlNode.setAttribute(FIELD_VALUE4, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWorkspaceSumBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWorkspaceSumBase pSWorkspaceSumBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWorkspaceSumBase.isCreateDateDirty() && (bl || pSWorkspaceSumBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWorkspaceSumBase.getCreateDate());
        }
        if (pSWorkspaceSumBase.isCreateManDirty() && (bl || pSWorkspaceSumBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWorkspaceSumBase.getCreateMan());
        }
        if (pSWorkspaceSumBase.isPSDCWorkspaceIdDirty() && (bl || pSWorkspaceSumBase.getPSDCWorkspaceId() != null)) {
            iDataObject.set(FIELD_PSDCWORKSPACEID, (Object)pSWorkspaceSumBase.getPSDCWorkspaceId());
        }
        if (pSWorkspaceSumBase.isPSWorkspaceIdDirty() && (bl || pSWorkspaceSumBase.getPSWorkspaceId() != null)) {
            iDataObject.set(FIELD_PSWORKSPACEID, (Object)pSWorkspaceSumBase.getPSWorkspaceId());
        }
        if (pSWorkspaceSumBase.isPSWorkspaceNameDirty() && (bl || pSWorkspaceSumBase.getPSWorkspaceName() != null)) {
            iDataObject.set(FIELD_PSWORKSPACENAME, (Object)pSWorkspaceSumBase.getPSWorkspaceName());
        }
        if (pSWorkspaceSumBase.isPSWorkspaceSumIdDirty() && (bl || pSWorkspaceSumBase.getPSWorkspaceSumId() != null)) {
            iDataObject.set(FIELD_PSWORKSPACESUMID, (Object)pSWorkspaceSumBase.getPSWorkspaceSumId());
        }
        if (pSWorkspaceSumBase.isPSWorkspaceSumNameDirty() && (bl || pSWorkspaceSumBase.getPSWorkspaceSumName() != null)) {
            iDataObject.set(FIELD_PSWORKSPACESUMNAME, (Object)pSWorkspaceSumBase.getPSWorkspaceSumName());
        }
        if (pSWorkspaceSumBase.isSumTagDirty() && (bl || pSWorkspaceSumBase.getSumTag() != null)) {
            iDataObject.set(FIELD_SUMTAG, (Object)pSWorkspaceSumBase.getSumTag());
        }
        if (pSWorkspaceSumBase.isSumTag2Dirty() && (bl || pSWorkspaceSumBase.getSumTag2() != null)) {
            iDataObject.set(FIELD_SUMTAG2, (Object)pSWorkspaceSumBase.getSumTag2());
        }
        if (pSWorkspaceSumBase.isSumTypeDirty() && (bl || pSWorkspaceSumBase.getSumType() != null)) {
            iDataObject.set(FIELD_SUMTYPE, (Object)pSWorkspaceSumBase.getSumType());
        }
        if (pSWorkspaceSumBase.isUpdateDateDirty() && (bl || pSWorkspaceSumBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWorkspaceSumBase.getUpdateDate());
        }
        if (pSWorkspaceSumBase.isUpdateManDirty() && (bl || pSWorkspaceSumBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWorkspaceSumBase.getUpdateMan());
        }
        if (pSWorkspaceSumBase.isValueDirty() && (bl || pSWorkspaceSumBase.getValue() != null)) {
            iDataObject.set(FIELD_VALUE, (Object)pSWorkspaceSumBase.getValue());
        }
        if (pSWorkspaceSumBase.isValue2Dirty() && (bl || pSWorkspaceSumBase.getValue2() != null)) {
            iDataObject.set(FIELD_VALUE2, (Object)pSWorkspaceSumBase.getValue2());
        }
        if (pSWorkspaceSumBase.isValue3Dirty() && (bl || pSWorkspaceSumBase.getValue3() != null)) {
            iDataObject.set(FIELD_VALUE3, (Object)pSWorkspaceSumBase.getValue3());
        }
        if (pSWorkspaceSumBase.isValue4Dirty() && (bl || pSWorkspaceSumBase.getValue4() != null)) {
            iDataObject.set(FIELD_VALUE4, (Object)pSWorkspaceSumBase.getValue4());
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
        return PSWorkspaceSumBase.remove(this, n);
    }

    private static boolean remove(PSWorkspaceSumBase pSWorkspaceSumBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWorkspaceSumBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSWorkspaceSumBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSWorkspaceSumBase.resetPSDCWorkspaceId();
                return true;
            }
            case 3: {
                pSWorkspaceSumBase.resetPSWorkspaceId();
                return true;
            }
            case 4: {
                pSWorkspaceSumBase.resetPSWorkspaceName();
                return true;
            }
            case 5: {
                pSWorkspaceSumBase.resetPSWorkspaceSumId();
                return true;
            }
            case 6: {
                pSWorkspaceSumBase.resetPSWorkspaceSumName();
                return true;
            }
            case 7: {
                pSWorkspaceSumBase.resetSumTag();
                return true;
            }
            case 8: {
                pSWorkspaceSumBase.resetSumTag2();
                return true;
            }
            case 9: {
                pSWorkspaceSumBase.resetSumType();
                return true;
            }
            case 10: {
                pSWorkspaceSumBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSWorkspaceSumBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSWorkspaceSumBase.resetValue();
                return true;
            }
            case 13: {
                pSWorkspaceSumBase.resetValue2();
                return true;
            }
            case 14: {
                pSWorkspaceSumBase.resetValue3();
                return true;
            }
            case 15: {
                pSWorkspaceSumBase.resetValue4();
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

    private PSWorkspaceSumBase getProxyEntity() {
        return this.proxyPSWorkspaceSumBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWorkspaceSumBase = null;
        if (iDataObject != null && iDataObject instanceof PSWorkspaceSumBase) {
            this.proxyPSWorkspaceSumBase = (PSWorkspaceSumBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceSumService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDCWORKSPACEID, 2);
        fieldIndexMap.put(FIELD_PSWORKSPACEID, 3);
        fieldIndexMap.put(FIELD_PSWORKSPACENAME, 4);
        fieldIndexMap.put(FIELD_PSWORKSPACESUMID, 5);
        fieldIndexMap.put(FIELD_PSWORKSPACESUMNAME, 6);
        fieldIndexMap.put(FIELD_SUMTAG, 7);
        fieldIndexMap.put(FIELD_SUMTAG2, 8);
        fieldIndexMap.put(FIELD_SUMTYPE, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_VALUE, 12);
        fieldIndexMap.put(FIELD_VALUE2, 13);
        fieldIndexMap.put(FIELD_VALUE3, 14);
        fieldIndexMap.put(FIELD_VALUE4, 15);
    }
}

