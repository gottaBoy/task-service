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
package net.ibizsys.pscore.srv.dynasys.entity;

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
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysDynaInstTagBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnSysDynaInstTagBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVSLNSYSDYNAINSTID = "PSDEVSLNSYSDYNAINSTID";
    public static final String FIELD_PSDEVSLNSYSDYNAINSTNAME = "PSDEVSLNSYSDYNAINSTNAME";
    public static final String FIELD_PSDEVSLNSYSDYNAINSTTAGID = "PSDEVSLNSYSDYNAINSTTAGID";
    public static final String FIELD_PSDEVSLNSYSDYNAINSTTAGNAME = "PSDEVSLNSYSDYNAINSTTAGNAME";
    public static final String FIELD_TAGTAG = "TAGTAG";
    public static final String FIELD_TAGTAG2 = "TAGTAG2";
    public static final String FIELD_TAGTAG3 = "TAGTAG3";
    public static final String FIELD_TAGTAG4 = "TAGTAG4";
    public static final String FIELD_TAGTAG5 = "TAGTAG5";
    public static final String FIELD_TAGTAG6 = "TAGTAG6";
    public static final String FIELD_TAGTAG7 = "TAGTAG7";
    public static final String FIELD_TAGTAG8 = "TAGTAG8";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDEVSLNSYSDYNAINSTID = 3;
    private static final int INDEX_PSDEVSLNSYSDYNAINSTNAME = 4;
    private static final int INDEX_PSDEVSLNSYSDYNAINSTTAGID = 5;
    private static final int INDEX_PSDEVSLNSYSDYNAINSTTAGNAME = 6;
    private static final int INDEX_TAGTAG = 7;
    private static final int INDEX_TAGTAG2 = 8;
    private static final int INDEX_TAGTAG3 = 9;
    private static final int INDEX_TAGTAG4 = 10;
    private static final int INDEX_TAGTAG5 = 11;
    private static final int INDEX_TAGTAG6 = 12;
    private static final int INDEX_TAGTAG7 = 13;
    private static final int INDEX_TAGTAG8 = 14;
    private static final int INDEX_UPDATEDATE = 15;
    private static final int INDEX_UPDATEMAN = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnSysDynaInstTagBase proxyPSDevSlnSysDynaInstTagBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevslnsysdynainstidDirtyFlag = false;
    private boolean psdevslnsysdynainstnameDirtyFlag = false;
    private boolean psdevslnsysdynainsttagidDirtyFlag = false;
    private boolean psdevslnsysdynainsttagnameDirtyFlag = false;
    private boolean tagtagDirtyFlag = false;
    private boolean tagtag2DirtyFlag = false;
    private boolean tagtag3DirtyFlag = false;
    private boolean tagtag4DirtyFlag = false;
    private boolean tagtag5DirtyFlag = false;
    private boolean tagtag6DirtyFlag = false;
    private boolean tagtag7DirtyFlag = false;
    private boolean tagtag8DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevslnsysdynainstid")
    private String psdevslnsysdynainstid;
    @Column(name="psdevslnsysdynainstname")
    private String psdevslnsysdynainstname;
    @Column(name="psdevslnsysdynainsttagid")
    private String psdevslnsysdynainsttagid;
    @Column(name="psdevslnsysdynainsttagname")
    private String psdevslnsysdynainsttagname;
    @Column(name="tagtag")
    private String tagtag;
    @Column(name="tagtag2")
    private String tagtag2;
    @Column(name="tagtag3")
    private String tagtag3;
    @Column(name="tagtag4")
    private String tagtag4;
    @Column(name="tagtag5")
    private String tagtag5;
    @Column(name="tagtag6")
    private String tagtag6;
    @Column(name="tagtag7")
    private String tagtag7;
    @Column(name="tagtag8")
    private String tagtag8;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevSlnSysDynaInstLock = new Integer(1);
    private PSDevSlnSysDynaInst psdevslnsysdynainst = null;

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

    public void setMemo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.memo = string;
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

    public void setPSDevSlnSysDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysdynainstid = string;
        this.psdevslnsysdynainstidDirtyFlag = true;
    }

    public String getPSDevSlnSysDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysDynaInstId();
        }
        return this.psdevslnsysdynainstid;
    }

    public boolean isPSDevSlnSysDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysDynaInstIdDirty();
        }
        return this.psdevslnsysdynainstidDirtyFlag;
    }

    public void resetPSDevSlnSysDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysDynaInstId();
            return;
        }
        this.psdevslnsysdynainstidDirtyFlag = false;
        this.psdevslnsysdynainstid = null;
    }

    public void setPSDevSlnSysDynaInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysDynaInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysdynainstname = string;
        this.psdevslnsysdynainstnameDirtyFlag = true;
    }

    public String getPSDevSlnSysDynaInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysDynaInstName();
        }
        return this.psdevslnsysdynainstname;
    }

    public boolean isPSDevSlnSysDynaInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysDynaInstNameDirty();
        }
        return this.psdevslnsysdynainstnameDirtyFlag;
    }

    public void resetPSDevSlnSysDynaInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysDynaInstName();
            return;
        }
        this.psdevslnsysdynainstnameDirtyFlag = false;
        this.psdevslnsysdynainstname = null;
    }

    public void setPSDevSlnSysDynaInstTagId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysDynaInstTagId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysdynainsttagid = string;
        this.psdevslnsysdynainsttagidDirtyFlag = true;
    }

    public String getPSDevSlnSysDynaInstTagId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysDynaInstTagId();
        }
        return this.psdevslnsysdynainsttagid;
    }

    public boolean isPSDevSlnSysDynaInstTagIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysDynaInstTagIdDirty();
        }
        return this.psdevslnsysdynainsttagidDirtyFlag;
    }

    public void resetPSDevSlnSysDynaInstTagId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysDynaInstTagId();
            return;
        }
        this.psdevslnsysdynainsttagidDirtyFlag = false;
        this.psdevslnsysdynainsttagid = null;
    }

    public void setPSDevSlnSysDynaInstTagName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysDynaInstTagName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysdynainsttagname = string;
        this.psdevslnsysdynainsttagnameDirtyFlag = true;
    }

    public String getPSDevSlnSysDynaInstTagName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysDynaInstTagName();
        }
        return this.psdevslnsysdynainsttagname;
    }

    public boolean isPSDevSlnSysDynaInstTagNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysDynaInstTagNameDirty();
        }
        return this.psdevslnsysdynainsttagnameDirtyFlag;
    }

    public void resetPSDevSlnSysDynaInstTagName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysDynaInstTagName();
            return;
        }
        this.psdevslnsysdynainsttagnameDirtyFlag = false;
        this.psdevslnsysdynainsttagname = null;
    }

    public void setTagTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTagTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tagtag = string;
        this.tagtagDirtyFlag = true;
    }

    public String getTagTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTagTag();
        }
        return this.tagtag;
    }

    public boolean isTagTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTagTagDirty();
        }
        return this.tagtagDirtyFlag;
    }

    public void resetTagTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTagTag();
            return;
        }
        this.tagtagDirtyFlag = false;
        this.tagtag = null;
    }

    public void setTagTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTagTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tagtag2 = string;
        this.tagtag2DirtyFlag = true;
    }

    public String getTagTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTagTag2();
        }
        return this.tagtag2;
    }

    public boolean isTagTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTagTag2Dirty();
        }
        return this.tagtag2DirtyFlag;
    }

    public void resetTagTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTagTag2();
            return;
        }
        this.tagtag2DirtyFlag = false;
        this.tagtag2 = null;
    }

    public void setTagTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTagTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tagtag3 = string;
        this.tagtag3DirtyFlag = true;
    }

    public String getTagTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTagTag3();
        }
        return this.tagtag3;
    }

    public boolean isTagTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTagTag3Dirty();
        }
        return this.tagtag3DirtyFlag;
    }

    public void resetTagTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTagTag3();
            return;
        }
        this.tagtag3DirtyFlag = false;
        this.tagtag3 = null;
    }

    public void setTagTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTagTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tagtag4 = string;
        this.tagtag4DirtyFlag = true;
    }

    public String getTagTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTagTag4();
        }
        return this.tagtag4;
    }

    public boolean isTagTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTagTag4Dirty();
        }
        return this.tagtag4DirtyFlag;
    }

    public void resetTagTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTagTag4();
            return;
        }
        this.tagtag4DirtyFlag = false;
        this.tagtag4 = null;
    }

    public void setTagTag5(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTagTag5(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tagtag5 = string;
        this.tagtag5DirtyFlag = true;
    }

    public String getTagTag5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTagTag5();
        }
        return this.tagtag5;
    }

    public boolean isTagTag5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTagTag5Dirty();
        }
        return this.tagtag5DirtyFlag;
    }

    public void resetTagTag5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTagTag5();
            return;
        }
        this.tagtag5DirtyFlag = false;
        this.tagtag5 = null;
    }

    public void setTagTag6(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTagTag6(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tagtag6 = string;
        this.tagtag6DirtyFlag = true;
    }

    public String getTagTag6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTagTag6();
        }
        return this.tagtag6;
    }

    public boolean isTagTag6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTagTag6Dirty();
        }
        return this.tagtag6DirtyFlag;
    }

    public void resetTagTag6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTagTag6();
            return;
        }
        this.tagtag6DirtyFlag = false;
        this.tagtag6 = null;
    }

    public void setTagTag7(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTagTag7(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tagtag7 = string;
        this.tagtag7DirtyFlag = true;
    }

    public String getTagTag7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTagTag7();
        }
        return this.tagtag7;
    }

    public boolean isTagTag7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTagTag7Dirty();
        }
        return this.tagtag7DirtyFlag;
    }

    public void resetTagTag7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTagTag7();
            return;
        }
        this.tagtag7DirtyFlag = false;
        this.tagtag7 = null;
    }

    public void setTagTag8(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTagTag8(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tagtag8 = string;
        this.tagtag8DirtyFlag = true;
    }

    public String getTagTag8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTagTag8();
        }
        return this.tagtag8;
    }

    public boolean isTagTag8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTagTag8Dirty();
        }
        return this.tagtag8DirtyFlag;
    }

    public void resetTagTag8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTagTag8();
            return;
        }
        this.tagtag8DirtyFlag = false;
        this.tagtag8 = null;
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
        PSDevSlnSysDynaInstTagBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnSysDynaInstTagBase pSDevSlnSysDynaInstTagBase) {
        pSDevSlnSysDynaInstTagBase.resetCreateDate();
        pSDevSlnSysDynaInstTagBase.resetCreateMan();
        pSDevSlnSysDynaInstTagBase.resetMemo();
        pSDevSlnSysDynaInstTagBase.resetPSDevSlnSysDynaInstId();
        pSDevSlnSysDynaInstTagBase.resetPSDevSlnSysDynaInstName();
        pSDevSlnSysDynaInstTagBase.resetPSDevSlnSysDynaInstTagId();
        pSDevSlnSysDynaInstTagBase.resetPSDevSlnSysDynaInstTagName();
        pSDevSlnSysDynaInstTagBase.resetTagTag();
        pSDevSlnSysDynaInstTagBase.resetTagTag2();
        pSDevSlnSysDynaInstTagBase.resetTagTag3();
        pSDevSlnSysDynaInstTagBase.resetTagTag4();
        pSDevSlnSysDynaInstTagBase.resetTagTag5();
        pSDevSlnSysDynaInstTagBase.resetTagTag6();
        pSDevSlnSysDynaInstTagBase.resetTagTag7();
        pSDevSlnSysDynaInstTagBase.resetTagTag8();
        pSDevSlnSysDynaInstTagBase.resetUpdateDate();
        pSDevSlnSysDynaInstTagBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevSlnSysDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSDYNAINSTID, this.getPSDevSlnSysDynaInstId());
        }
        if (!bl || this.isPSDevSlnSysDynaInstNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSDYNAINSTNAME, this.getPSDevSlnSysDynaInstName());
        }
        if (!bl || this.isPSDevSlnSysDynaInstTagIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSDYNAINSTTAGID, this.getPSDevSlnSysDynaInstTagId());
        }
        if (!bl || this.isPSDevSlnSysDynaInstTagNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSDYNAINSTTAGNAME, this.getPSDevSlnSysDynaInstTagName());
        }
        if (!bl || this.isTagTagDirty()) {
            hashMap.put(FIELD_TAGTAG, this.getTagTag());
        }
        if (!bl || this.isTagTag2Dirty()) {
            hashMap.put(FIELD_TAGTAG2, this.getTagTag2());
        }
        if (!bl || this.isTagTag3Dirty()) {
            hashMap.put(FIELD_TAGTAG3, this.getTagTag3());
        }
        if (!bl || this.isTagTag4Dirty()) {
            hashMap.put(FIELD_TAGTAG4, this.getTagTag4());
        }
        if (!bl || this.isTagTag5Dirty()) {
            hashMap.put(FIELD_TAGTAG5, this.getTagTag5());
        }
        if (!bl || this.isTagTag6Dirty()) {
            hashMap.put(FIELD_TAGTAG6, this.getTagTag6());
        }
        if (!bl || this.isTagTag7Dirty()) {
            hashMap.put(FIELD_TAGTAG7, this.getTagTag7());
        }
        if (!bl || this.isTagTag8Dirty()) {
            hashMap.put(FIELD_TAGTAG8, this.getTagTag8());
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
        return PSDevSlnSysDynaInstTagBase.get(this, n);
    }

    private static Object get(PSDevSlnSysDynaInstTagBase pSDevSlnSysDynaInstTagBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysDynaInstTagBase.getCreateDate();
            }
            case 1: {
                return pSDevSlnSysDynaInstTagBase.getCreateMan();
            }
            case 2: {
                return pSDevSlnSysDynaInstTagBase.getMemo();
            }
            case 3: {
                return pSDevSlnSysDynaInstTagBase.getPSDevSlnSysDynaInstId();
            }
            case 4: {
                return pSDevSlnSysDynaInstTagBase.getPSDevSlnSysDynaInstName();
            }
            case 5: {
                return pSDevSlnSysDynaInstTagBase.getPSDevSlnSysDynaInstTagId();
            }
            case 6: {
                return pSDevSlnSysDynaInstTagBase.getPSDevSlnSysDynaInstTagName();
            }
            case 7: {
                return pSDevSlnSysDynaInstTagBase.getTagTag();
            }
            case 8: {
                return pSDevSlnSysDynaInstTagBase.getTagTag2();
            }
            case 9: {
                return pSDevSlnSysDynaInstTagBase.getTagTag3();
            }
            case 10: {
                return pSDevSlnSysDynaInstTagBase.getTagTag4();
            }
            case 11: {
                return pSDevSlnSysDynaInstTagBase.getTagTag5();
            }
            case 12: {
                return pSDevSlnSysDynaInstTagBase.getTagTag6();
            }
            case 13: {
                return pSDevSlnSysDynaInstTagBase.getTagTag7();
            }
            case 14: {
                return pSDevSlnSysDynaInstTagBase.getTagTag8();
            }
            case 15: {
                return pSDevSlnSysDynaInstTagBase.getUpdateDate();
            }
            case 16: {
                return pSDevSlnSysDynaInstTagBase.getUpdateMan();
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
        PSDevSlnSysDynaInstTagBase.set(this, n, object);
    }

    private static void set(PSDevSlnSysDynaInstTagBase pSDevSlnSysDynaInstTagBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysDynaInstTagBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnSysDynaInstTagBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnSysDynaInstTagBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnSysDynaInstTagBase.setPSDevSlnSysDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnSysDynaInstTagBase.setPSDevSlnSysDynaInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnSysDynaInstTagBase.setPSDevSlnSysDynaInstTagId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnSysDynaInstTagBase.setPSDevSlnSysDynaInstTagName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnSysDynaInstTagBase.setTagTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnSysDynaInstTagBase.setTagTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnSysDynaInstTagBase.setTagTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnSysDynaInstTagBase.setTagTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnSysDynaInstTagBase.setTagTag5(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnSysDynaInstTagBase.setTagTag6(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnSysDynaInstTagBase.setTagTag7(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnSysDynaInstTagBase.setTagTag8(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnSysDynaInstTagBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnSysDynaInstTagBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevSlnSysDynaInstTagBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnSysDynaInstTagBase pSDevSlnSysDynaInstTagBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysDynaInstTagBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevSlnSysDynaInstTagBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevSlnSysDynaInstTagBase.getMemo() == null;
            }
            case 3: {
                return pSDevSlnSysDynaInstTagBase.getPSDevSlnSysDynaInstId() == null;
            }
            case 4: {
                return pSDevSlnSysDynaInstTagBase.getPSDevSlnSysDynaInstName() == null;
            }
            case 5: {
                return pSDevSlnSysDynaInstTagBase.getPSDevSlnSysDynaInstTagId() == null;
            }
            case 6: {
                return pSDevSlnSysDynaInstTagBase.getPSDevSlnSysDynaInstTagName() == null;
            }
            case 7: {
                return pSDevSlnSysDynaInstTagBase.getTagTag() == null;
            }
            case 8: {
                return pSDevSlnSysDynaInstTagBase.getTagTag2() == null;
            }
            case 9: {
                return pSDevSlnSysDynaInstTagBase.getTagTag3() == null;
            }
            case 10: {
                return pSDevSlnSysDynaInstTagBase.getTagTag4() == null;
            }
            case 11: {
                return pSDevSlnSysDynaInstTagBase.getTagTag5() == null;
            }
            case 12: {
                return pSDevSlnSysDynaInstTagBase.getTagTag6() == null;
            }
            case 13: {
                return pSDevSlnSysDynaInstTagBase.getTagTag7() == null;
            }
            case 14: {
                return pSDevSlnSysDynaInstTagBase.getTagTag8() == null;
            }
            case 15: {
                return pSDevSlnSysDynaInstTagBase.getUpdateDate() == null;
            }
            case 16: {
                return pSDevSlnSysDynaInstTagBase.getUpdateMan() == null;
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
        return PSDevSlnSysDynaInstTagBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnSysDynaInstTagBase pSDevSlnSysDynaInstTagBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysDynaInstTagBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevSlnSysDynaInstTagBase.isCreateManDirty();
            }
            case 2: {
                return pSDevSlnSysDynaInstTagBase.isMemoDirty();
            }
            case 3: {
                return pSDevSlnSysDynaInstTagBase.isPSDevSlnSysDynaInstIdDirty();
            }
            case 4: {
                return pSDevSlnSysDynaInstTagBase.isPSDevSlnSysDynaInstNameDirty();
            }
            case 5: {
                return pSDevSlnSysDynaInstTagBase.isPSDevSlnSysDynaInstTagIdDirty();
            }
            case 6: {
                return pSDevSlnSysDynaInstTagBase.isPSDevSlnSysDynaInstTagNameDirty();
            }
            case 7: {
                return pSDevSlnSysDynaInstTagBase.isTagTagDirty();
            }
            case 8: {
                return pSDevSlnSysDynaInstTagBase.isTagTag2Dirty();
            }
            case 9: {
                return pSDevSlnSysDynaInstTagBase.isTagTag3Dirty();
            }
            case 10: {
                return pSDevSlnSysDynaInstTagBase.isTagTag4Dirty();
            }
            case 11: {
                return pSDevSlnSysDynaInstTagBase.isTagTag5Dirty();
            }
            case 12: {
                return pSDevSlnSysDynaInstTagBase.isTagTag6Dirty();
            }
            case 13: {
                return pSDevSlnSysDynaInstTagBase.isTagTag7Dirty();
            }
            case 14: {
                return pSDevSlnSysDynaInstTagBase.isTagTag8Dirty();
            }
            case 15: {
                return pSDevSlnSysDynaInstTagBase.isUpdateDateDirty();
            }
            case 16: {
                return pSDevSlnSysDynaInstTagBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnSysDynaInstTagBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnSysDynaInstTagBase pSDevSlnSysDynaInstTagBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnSysDynaInstTagBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnSysDynaInstTagBase.getJSONValue((Object)pSDevSlnSysDynaInstTagBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstTagBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnSysDynaInstTagBase.getJSONValue((Object)pSDevSlnSysDynaInstTagBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstTagBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnSysDynaInstTagBase.getJSONValue((Object)pSDevSlnSysDynaInstTagBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstTagBase.getPSDevSlnSysDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysdynainstid", (Object)PSDevSlnSysDynaInstTagBase.getJSONValue((Object)pSDevSlnSysDynaInstTagBase.getPSDevSlnSysDynaInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstTagBase.getPSDevSlnSysDynaInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysdynainstname", (Object)PSDevSlnSysDynaInstTagBase.getJSONValue((Object)pSDevSlnSysDynaInstTagBase.getPSDevSlnSysDynaInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstTagBase.getPSDevSlnSysDynaInstTagId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysdynainsttagid", (Object)PSDevSlnSysDynaInstTagBase.getJSONValue((Object)pSDevSlnSysDynaInstTagBase.getPSDevSlnSysDynaInstTagId()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstTagBase.getPSDevSlnSysDynaInstTagName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysdynainsttagname", (Object)PSDevSlnSysDynaInstTagBase.getJSONValue((Object)pSDevSlnSysDynaInstTagBase.getPSDevSlnSysDynaInstTagName()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstTagBase.getTagTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tagtag", (Object)PSDevSlnSysDynaInstTagBase.getJSONValue((Object)pSDevSlnSysDynaInstTagBase.getTagTag()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstTagBase.getTagTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tagtag2", (Object)PSDevSlnSysDynaInstTagBase.getJSONValue((Object)pSDevSlnSysDynaInstTagBase.getTagTag2()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstTagBase.getTagTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tagtag3", (Object)PSDevSlnSysDynaInstTagBase.getJSONValue((Object)pSDevSlnSysDynaInstTagBase.getTagTag3()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstTagBase.getTagTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tagtag4", (Object)PSDevSlnSysDynaInstTagBase.getJSONValue((Object)pSDevSlnSysDynaInstTagBase.getTagTag4()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstTagBase.getTagTag5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tagtag5", (Object)PSDevSlnSysDynaInstTagBase.getJSONValue((Object)pSDevSlnSysDynaInstTagBase.getTagTag5()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstTagBase.getTagTag6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tagtag6", (Object)PSDevSlnSysDynaInstTagBase.getJSONValue((Object)pSDevSlnSysDynaInstTagBase.getTagTag6()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstTagBase.getTagTag7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tagtag7", (Object)PSDevSlnSysDynaInstTagBase.getJSONValue((Object)pSDevSlnSysDynaInstTagBase.getTagTag7()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstTagBase.getTagTag8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tagtag8", (Object)PSDevSlnSysDynaInstTagBase.getJSONValue((Object)pSDevSlnSysDynaInstTagBase.getTagTag8()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstTagBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnSysDynaInstTagBase.getJSONValue((Object)pSDevSlnSysDynaInstTagBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstTagBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnSysDynaInstTagBase.getJSONValue((Object)pSDevSlnSysDynaInstTagBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnSysDynaInstTagBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnSysDynaInstTagBase pSDevSlnSysDynaInstTagBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnSysDynaInstTagBase.getCreateDate() != null) {
            object = pSDevSlnSysDynaInstTagBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysDynaInstTagBase.getCreateMan() != null) {
            object = pSDevSlnSysDynaInstTagBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstTagBase.getMemo() != null) {
            object = pSDevSlnSysDynaInstTagBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstTagBase.getPSDevSlnSysDynaInstId() != null) {
            object = pSDevSlnSysDynaInstTagBase.getPSDevSlnSysDynaInstId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstTagBase.getPSDevSlnSysDynaInstName() != null) {
            object = pSDevSlnSysDynaInstTagBase.getPSDevSlnSysDynaInstName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSDYNAINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstTagBase.getPSDevSlnSysDynaInstTagId() != null) {
            object = pSDevSlnSysDynaInstTagBase.getPSDevSlnSysDynaInstTagId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSDYNAINSTTAGID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstTagBase.getPSDevSlnSysDynaInstTagName() != null) {
            object = pSDevSlnSysDynaInstTagBase.getPSDevSlnSysDynaInstTagName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSDYNAINSTTAGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstTagBase.getTagTag() != null) {
            object = pSDevSlnSysDynaInstTagBase.getTagTag();
            xmlNode.setAttribute(FIELD_TAGTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstTagBase.getTagTag2() != null) {
            object = pSDevSlnSysDynaInstTagBase.getTagTag2();
            xmlNode.setAttribute(FIELD_TAGTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstTagBase.getTagTag3() != null) {
            object = pSDevSlnSysDynaInstTagBase.getTagTag3();
            xmlNode.setAttribute(FIELD_TAGTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstTagBase.getTagTag4() != null) {
            object = pSDevSlnSysDynaInstTagBase.getTagTag4();
            xmlNode.setAttribute(FIELD_TAGTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstTagBase.getTagTag5() != null) {
            object = pSDevSlnSysDynaInstTagBase.getTagTag5();
            xmlNode.setAttribute(FIELD_TAGTAG5, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstTagBase.getTagTag6() != null) {
            object = pSDevSlnSysDynaInstTagBase.getTagTag6();
            xmlNode.setAttribute(FIELD_TAGTAG6, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstTagBase.getTagTag7() != null) {
            object = pSDevSlnSysDynaInstTagBase.getTagTag7();
            xmlNode.setAttribute(FIELD_TAGTAG7, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstTagBase.getTagTag8() != null) {
            object = pSDevSlnSysDynaInstTagBase.getTagTag8();
            xmlNode.setAttribute(FIELD_TAGTAG8, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstTagBase.getUpdateDate() != null) {
            object = pSDevSlnSysDynaInstTagBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysDynaInstTagBase.getUpdateMan() != null) {
            object = pSDevSlnSysDynaInstTagBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnSysDynaInstTagBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnSysDynaInstTagBase pSDevSlnSysDynaInstTagBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnSysDynaInstTagBase.isCreateDateDirty() && (bl || pSDevSlnSysDynaInstTagBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnSysDynaInstTagBase.getCreateDate());
        }
        if (pSDevSlnSysDynaInstTagBase.isCreateManDirty() && (bl || pSDevSlnSysDynaInstTagBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnSysDynaInstTagBase.getCreateMan());
        }
        if (pSDevSlnSysDynaInstTagBase.isMemoDirty() && (bl || pSDevSlnSysDynaInstTagBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnSysDynaInstTagBase.getMemo());
        }
        if (pSDevSlnSysDynaInstTagBase.isPSDevSlnSysDynaInstIdDirty() && (bl || pSDevSlnSysDynaInstTagBase.getPSDevSlnSysDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSDYNAINSTID, (Object)pSDevSlnSysDynaInstTagBase.getPSDevSlnSysDynaInstId());
        }
        if (pSDevSlnSysDynaInstTagBase.isPSDevSlnSysDynaInstNameDirty() && (bl || pSDevSlnSysDynaInstTagBase.getPSDevSlnSysDynaInstName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSDYNAINSTNAME, (Object)pSDevSlnSysDynaInstTagBase.getPSDevSlnSysDynaInstName());
        }
        if (pSDevSlnSysDynaInstTagBase.isPSDevSlnSysDynaInstTagIdDirty() && (bl || pSDevSlnSysDynaInstTagBase.getPSDevSlnSysDynaInstTagId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSDYNAINSTTAGID, (Object)pSDevSlnSysDynaInstTagBase.getPSDevSlnSysDynaInstTagId());
        }
        if (pSDevSlnSysDynaInstTagBase.isPSDevSlnSysDynaInstTagNameDirty() && (bl || pSDevSlnSysDynaInstTagBase.getPSDevSlnSysDynaInstTagName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSDYNAINSTTAGNAME, (Object)pSDevSlnSysDynaInstTagBase.getPSDevSlnSysDynaInstTagName());
        }
        if (pSDevSlnSysDynaInstTagBase.isTagTagDirty() && (bl || pSDevSlnSysDynaInstTagBase.getTagTag() != null)) {
            iDataObject.set(FIELD_TAGTAG, (Object)pSDevSlnSysDynaInstTagBase.getTagTag());
        }
        if (pSDevSlnSysDynaInstTagBase.isTagTag2Dirty() && (bl || pSDevSlnSysDynaInstTagBase.getTagTag2() != null)) {
            iDataObject.set(FIELD_TAGTAG2, (Object)pSDevSlnSysDynaInstTagBase.getTagTag2());
        }
        if (pSDevSlnSysDynaInstTagBase.isTagTag3Dirty() && (bl || pSDevSlnSysDynaInstTagBase.getTagTag3() != null)) {
            iDataObject.set(FIELD_TAGTAG3, (Object)pSDevSlnSysDynaInstTagBase.getTagTag3());
        }
        if (pSDevSlnSysDynaInstTagBase.isTagTag4Dirty() && (bl || pSDevSlnSysDynaInstTagBase.getTagTag4() != null)) {
            iDataObject.set(FIELD_TAGTAG4, (Object)pSDevSlnSysDynaInstTagBase.getTagTag4());
        }
        if (pSDevSlnSysDynaInstTagBase.isTagTag5Dirty() && (bl || pSDevSlnSysDynaInstTagBase.getTagTag5() != null)) {
            iDataObject.set(FIELD_TAGTAG5, (Object)pSDevSlnSysDynaInstTagBase.getTagTag5());
        }
        if (pSDevSlnSysDynaInstTagBase.isTagTag6Dirty() && (bl || pSDevSlnSysDynaInstTagBase.getTagTag6() != null)) {
            iDataObject.set(FIELD_TAGTAG6, (Object)pSDevSlnSysDynaInstTagBase.getTagTag6());
        }
        if (pSDevSlnSysDynaInstTagBase.isTagTag7Dirty() && (bl || pSDevSlnSysDynaInstTagBase.getTagTag7() != null)) {
            iDataObject.set(FIELD_TAGTAG7, (Object)pSDevSlnSysDynaInstTagBase.getTagTag7());
        }
        if (pSDevSlnSysDynaInstTagBase.isTagTag8Dirty() && (bl || pSDevSlnSysDynaInstTagBase.getTagTag8() != null)) {
            iDataObject.set(FIELD_TAGTAG8, (Object)pSDevSlnSysDynaInstTagBase.getTagTag8());
        }
        if (pSDevSlnSysDynaInstTagBase.isUpdateDateDirty() && (bl || pSDevSlnSysDynaInstTagBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnSysDynaInstTagBase.getUpdateDate());
        }
        if (pSDevSlnSysDynaInstTagBase.isUpdateManDirty() && (bl || pSDevSlnSysDynaInstTagBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnSysDynaInstTagBase.getUpdateMan());
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
        return PSDevSlnSysDynaInstTagBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnSysDynaInstTagBase pSDevSlnSysDynaInstTagBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysDynaInstTagBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevSlnSysDynaInstTagBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevSlnSysDynaInstTagBase.resetMemo();
                return true;
            }
            case 3: {
                pSDevSlnSysDynaInstTagBase.resetPSDevSlnSysDynaInstId();
                return true;
            }
            case 4: {
                pSDevSlnSysDynaInstTagBase.resetPSDevSlnSysDynaInstName();
                return true;
            }
            case 5: {
                pSDevSlnSysDynaInstTagBase.resetPSDevSlnSysDynaInstTagId();
                return true;
            }
            case 6: {
                pSDevSlnSysDynaInstTagBase.resetPSDevSlnSysDynaInstTagName();
                return true;
            }
            case 7: {
                pSDevSlnSysDynaInstTagBase.resetTagTag();
                return true;
            }
            case 8: {
                pSDevSlnSysDynaInstTagBase.resetTagTag2();
                return true;
            }
            case 9: {
                pSDevSlnSysDynaInstTagBase.resetTagTag3();
                return true;
            }
            case 10: {
                pSDevSlnSysDynaInstTagBase.resetTagTag4();
                return true;
            }
            case 11: {
                pSDevSlnSysDynaInstTagBase.resetTagTag5();
                return true;
            }
            case 12: {
                pSDevSlnSysDynaInstTagBase.resetTagTag6();
                return true;
            }
            case 13: {
                pSDevSlnSysDynaInstTagBase.resetTagTag7();
                return true;
            }
            case 14: {
                pSDevSlnSysDynaInstTagBase.resetTagTag8();
                return true;
            }
            case 15: {
                pSDevSlnSysDynaInstTagBase.resetUpdateDate();
                return true;
            }
            case 16: {
                pSDevSlnSysDynaInstTagBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSysDynaInst getPSDevSlnSysDynaInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysDynaInst();
        }
        if (this.getPSDevSlnSysDynaInstId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysDynaInstLock;
        synchronized (n) {
            if (this.psdevslnsysdynainst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysDynaInstId(), (Object)this.psdevslnsysdynainst.getPSDevSlnSysDynaInstId()) != 0L) {
                this.psdevslnsysdynainst = null;
            }
            if (this.psdevslnsysdynainst == null) {
                PSDevSlnSysDynaInst pSDevSlnSysDynaInst = new PSDevSlnSysDynaInst();
                pSDevSlnSysDynaInst.setPSDevSlnSysDynaInstId(this.getPSDevSlnSysDynaInstId());
                PSDevSlnSysDynaInstService pSDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysDynaInstService.autoGet((IEntity)pSDevSlnSysDynaInst);
                this.psdevslnsysdynainst = pSDevSlnSysDynaInst;
            }
            return this.psdevslnsysdynainst;
        }
    }

    private PSDevSlnSysDynaInstTagBase getProxyEntity() {
        return this.proxyPSDevSlnSysDynaInstTagBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnSysDynaInstTagBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnSysDynaInstTagBase) {
            this.proxyPSDevSlnSysDynaInstTagBase = (PSDevSlnSysDynaInstTagBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstTagService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSDYNAINSTID, 3);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSDYNAINSTNAME, 4);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSDYNAINSTTAGID, 5);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSDYNAINSTTAGNAME, 6);
        fieldIndexMap.put(FIELD_TAGTAG, 7);
        fieldIndexMap.put(FIELD_TAGTAG2, 8);
        fieldIndexMap.put(FIELD_TAGTAG3, 9);
        fieldIndexMap.put(FIELD_TAGTAG4, 10);
        fieldIndexMap.put(FIELD_TAGTAG5, 11);
        fieldIndexMap.put(FIELD_TAGTAG6, 12);
        fieldIndexMap.put(FIELD_TAGTAG7, 13);
        fieldIndexMap.put(FIELD_TAGTAG8, 14);
        fieldIndexMap.put(FIELD_UPDATEDATE, 15);
        fieldIndexMap.put(FIELD_UPDATEMAN, 16);
    }
}

