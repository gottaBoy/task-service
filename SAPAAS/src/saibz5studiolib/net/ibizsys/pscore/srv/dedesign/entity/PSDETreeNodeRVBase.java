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
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDETreeNodeRVBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDETreeNodeRVBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDETREENODEID = "PSDETREENODEID";
    public static final String FIELD_PSDETREENODENAME = "PSDETREENODENAME";
    public static final String FIELD_PSDETREENODERVID = "PSDETREENODERVID";
    public static final String FIELD_PSDETREENODERVNAME = "PSDETREENODERVNAME";
    public static final String FIELD_PSDETREEVIEWID = "PSDETREEVIEWID";
    public static final String FIELD_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String FIELD_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String FIELD_REFMODE = "REFMODE";
    public static final String FIELD_REFMODETEXT = "REFMODETEXT";
    public static final String FIELD_REFPARAM = "REFPARAM";
    public static final String FIELD_REFPARAMDESC = "REFPARAMDESC";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VIEWPARAMS = "VIEWPARAMS";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDETREENODEID = 3;
    private static final int INDEX_PSDETREENODENAME = 4;
    private static final int INDEX_PSDETREENODERVID = 5;
    private static final int INDEX_PSDETREENODERVNAME = 6;
    private static final int INDEX_PSDETREEVIEWID = 7;
    private static final int INDEX_PSDEVIEWBASEID = 8;
    private static final int INDEX_PSDEVIEWBASENAME = 9;
    private static final int INDEX_REFMODE = 10;
    private static final int INDEX_REFMODETEXT = 11;
    private static final int INDEX_REFPARAM = 12;
    private static final int INDEX_REFPARAMDESC = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final int INDEX_USERCAT = 16;
    private static final int INDEX_USERTAG = 17;
    private static final int INDEX_USERTAG2 = 18;
    private static final int INDEX_USERTAG3 = 19;
    private static final int INDEX_USERTAG4 = 20;
    private static final int INDEX_VIEWPARAMS = 21;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDETreeNodeRVBase proxyPSDETreeNodeRVBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdetreenodeidDirtyFlag = false;
    private boolean psdetreenodenameDirtyFlag = false;
    private boolean psdetreenodervidDirtyFlag = false;
    private boolean psdetreenodervnameDirtyFlag = false;
    private boolean psdetreeviewidDirtyFlag = false;
    private boolean psdeviewbaseidDirtyFlag = false;
    private boolean psdeviewbasenameDirtyFlag = false;
    private boolean refmodeDirtyFlag = false;
    private boolean refmodetextDirtyFlag = false;
    private boolean refparamDirtyFlag = false;
    private boolean refparamdescDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean viewparamsDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdetreenodeid")
    private String psdetreenodeid;
    @Column(name="psdetreenodename")
    private String psdetreenodename;
    @Column(name="psdetreenodervid")
    private String psdetreenodervid;
    @Column(name="psdetreenodervname")
    private String psdetreenodervname;
    @Column(name="psdetreeviewid")
    private String psdetreeviewid;
    @Column(name="psdeviewbaseid")
    private String psdeviewbaseid;
    @Column(name="psdeviewbasename")
    private String psdeviewbasename;
    @Column(name="refmode")
    private String refmode;
    @Column(name="refmodetext")
    private String refmodetext;
    @Column(name="refparam")
    private String refparam;
    @Column(name="refparamdesc")
    private String refparamdesc;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="viewparams")
    private String viewparams;
    private Integer objPSDETreeNodeLock = new Integer(1);
    private PSDETreeNode psdetreenode = null;
    private Integer objPSDEViewBaseLock = new Integer(1);
    private PSDEViewBase psdeviewbase = null;

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

    public void setPSDETreeNodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeNodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreenodename = string;
        this.psdetreenodenameDirtyFlag = true;
    }

    public String getPSDETreeNodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeNodeName();
        }
        return this.psdetreenodename;
    }

    public boolean isPSDETreeNodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeNodeNameDirty();
        }
        return this.psdetreenodenameDirtyFlag;
    }

    public void resetPSDETreeNodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeNodeName();
            return;
        }
        this.psdetreenodenameDirtyFlag = false;
        this.psdetreenodename = null;
    }

    public void setPSDETreeNodeRVId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeNodeRVId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreenodervid = string;
        this.psdetreenodervidDirtyFlag = true;
    }

    public String getPSDETreeNodeRVId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeNodeRVId();
        }
        return this.psdetreenodervid;
    }

    public boolean isPSDETreeNodeRVIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeNodeRVIdDirty();
        }
        return this.psdetreenodervidDirtyFlag;
    }

    public void resetPSDETreeNodeRVId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeNodeRVId();
            return;
        }
        this.psdetreenodervidDirtyFlag = false;
        this.psdetreenodervid = null;
    }

    public void setPSDETreeNodeRVName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeNodeRVName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreenodervname = string;
        this.psdetreenodervnameDirtyFlag = true;
    }

    public String getPSDETreeNodeRVName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeNodeRVName();
        }
        return this.psdetreenodervname;
    }

    public boolean isPSDETreeNodeRVNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeNodeRVNameDirty();
        }
        return this.psdetreenodervnameDirtyFlag;
    }

    public void resetPSDETreeNodeRVName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeNodeRVName();
            return;
        }
        this.psdetreenodervnameDirtyFlag = false;
        this.psdetreenodervname = null;
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

    public void setPSDEViewBaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbaseid = string;
        this.psdeviewbaseidDirtyFlag = true;
    }

    public String getPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseId();
        }
        return this.psdeviewbaseid;
    }

    public boolean isPSDEViewBaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseIdDirty();
        }
        return this.psdeviewbaseidDirtyFlag;
    }

    public void resetPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseId();
            return;
        }
        this.psdeviewbaseidDirtyFlag = false;
        this.psdeviewbaseid = null;
    }

    public void setPSDEViewBaseName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbasename = string;
        this.psdeviewbasenameDirtyFlag = true;
    }

    public String getPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseName();
        }
        return this.psdeviewbasename;
    }

    public boolean isPSDEViewBaseNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseNameDirty();
        }
        return this.psdeviewbasenameDirtyFlag;
    }

    public void resetPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseName();
            return;
        }
        this.psdeviewbasenameDirtyFlag = false;
        this.psdeviewbasename = null;
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

    public void setRefModeText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefModeText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refmodetext = string;
        this.refmodetextDirtyFlag = true;
    }

    public String getRefModeText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefModeText();
        }
        return this.refmodetext;
    }

    public boolean isRefModeTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefModeTextDirty();
        }
        return this.refmodetextDirtyFlag;
    }

    public void resetRefModeText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefModeText();
            return;
        }
        this.refmodetextDirtyFlag = false;
        this.refmodetext = null;
    }

    public void setRefParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refparam = string;
        this.refparamDirtyFlag = true;
    }

    public String getRefParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefParam();
        }
        return this.refparam;
    }

    public boolean isRefParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefParamDirty();
        }
        return this.refparamDirtyFlag;
    }

    public void resetRefParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefParam();
            return;
        }
        this.refparamDirtyFlag = false;
        this.refparam = null;
    }

    public void setRefParamDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefParamDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refparamdesc = string;
        this.refparamdescDirtyFlag = true;
    }

    public String getRefParamDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefParamDesc();
        }
        return this.refparamdesc;
    }

    public boolean isRefParamDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefParamDescDirty();
        }
        return this.refparamdescDirtyFlag;
    }

    public void resetRefParamDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefParamDesc();
            return;
        }
        this.refparamdescDirtyFlag = false;
        this.refparamdesc = null;
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

    public void setUserCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usercat = string;
        this.usercatDirtyFlag = true;
    }

    public String getUserCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCat();
        }
        return this.usercat;
    }

    public boolean isUserCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCatDirty();
        }
        return this.usercatDirtyFlag;
    }

    public void resetUserCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCat();
            return;
        }
        this.usercatDirtyFlag = false;
        this.usercat = null;
    }

    public void setUserTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag = string;
        this.usertagDirtyFlag = true;
    }

    public String getUserTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag();
        }
        return this.usertag;
    }

    public boolean isUserTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTagDirty();
        }
        return this.usertagDirtyFlag;
    }

    public void resetUserTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag();
            return;
        }
        this.usertagDirtyFlag = false;
        this.usertag = null;
    }

    public void setUserTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag2 = string;
        this.usertag2DirtyFlag = true;
    }

    public String getUserTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag2();
        }
        return this.usertag2;
    }

    public boolean isUserTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag2Dirty();
        }
        return this.usertag2DirtyFlag;
    }

    public void resetUserTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag2();
            return;
        }
        this.usertag2DirtyFlag = false;
        this.usertag2 = null;
    }

    public void setUserTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag3 = string;
        this.usertag3DirtyFlag = true;
    }

    public String getUserTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag3();
        }
        return this.usertag3;
    }

    public boolean isUserTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag3Dirty();
        }
        return this.usertag3DirtyFlag;
    }

    public void resetUserTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag3();
            return;
        }
        this.usertag3DirtyFlag = false;
        this.usertag3 = null;
    }

    public void setUserTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag4 = string;
        this.usertag4DirtyFlag = true;
    }

    public String getUserTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag4();
        }
        return this.usertag4;
    }

    public boolean isUserTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag4Dirty();
        }
        return this.usertag4DirtyFlag;
    }

    public void resetUserTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag4();
            return;
        }
        this.usertag4DirtyFlag = false;
        this.usertag4 = null;
    }

    public void setViewParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewparams = string;
        this.viewparamsDirtyFlag = true;
    }

    public String getViewParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewParams();
        }
        return this.viewparams;
    }

    public boolean isViewParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewParamsDirty();
        }
        return this.viewparamsDirtyFlag;
    }

    public void resetViewParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewParams();
            return;
        }
        this.viewparamsDirtyFlag = false;
        this.viewparams = null;
    }

    protected void onReset() {
        PSDETreeNodeRVBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDETreeNodeRVBase pSDETreeNodeRVBase) {
        pSDETreeNodeRVBase.resetCreateDate();
        pSDETreeNodeRVBase.resetCreateMan();
        pSDETreeNodeRVBase.resetMemo();
        pSDETreeNodeRVBase.resetPSDETreeNodeId();
        pSDETreeNodeRVBase.resetPSDETreeNodeName();
        pSDETreeNodeRVBase.resetPSDETreeNodeRVId();
        pSDETreeNodeRVBase.resetPSDETreeNodeRVName();
        pSDETreeNodeRVBase.resetPSDETreeViewId();
        pSDETreeNodeRVBase.resetPSDEViewBaseId();
        pSDETreeNodeRVBase.resetPSDEViewBaseName();
        pSDETreeNodeRVBase.resetRefMode();
        pSDETreeNodeRVBase.resetRefModeText();
        pSDETreeNodeRVBase.resetRefParam();
        pSDETreeNodeRVBase.resetRefParamDesc();
        pSDETreeNodeRVBase.resetUpdateDate();
        pSDETreeNodeRVBase.resetUpdateMan();
        pSDETreeNodeRVBase.resetUserCat();
        pSDETreeNodeRVBase.resetUserTag();
        pSDETreeNodeRVBase.resetUserTag2();
        pSDETreeNodeRVBase.resetUserTag3();
        pSDETreeNodeRVBase.resetUserTag4();
        pSDETreeNodeRVBase.resetViewParams();
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
        if (!bl || this.isPSDETreeNodeIdDirty()) {
            hashMap.put(FIELD_PSDETREENODEID, this.getPSDETreeNodeId());
        }
        if (!bl || this.isPSDETreeNodeNameDirty()) {
            hashMap.put(FIELD_PSDETREENODENAME, this.getPSDETreeNodeName());
        }
        if (!bl || this.isPSDETreeNodeRVIdDirty()) {
            hashMap.put(FIELD_PSDETREENODERVID, this.getPSDETreeNodeRVId());
        }
        if (!bl || this.isPSDETreeNodeRVNameDirty()) {
            hashMap.put(FIELD_PSDETREENODERVNAME, this.getPSDETreeNodeRVName());
        }
        if (!bl || this.isPSDETreeViewIdDirty()) {
            hashMap.put(FIELD_PSDETREEVIEWID, this.getPSDETreeViewId());
        }
        if (!bl || this.isPSDEViewBaseIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASEID, this.getPSDEViewBaseId());
        }
        if (!bl || this.isPSDEViewBaseNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASENAME, this.getPSDEViewBaseName());
        }
        if (!bl || this.isRefModeDirty()) {
            hashMap.put(FIELD_REFMODE, this.getRefMode());
        }
        if (!bl || this.isRefModeTextDirty()) {
            hashMap.put(FIELD_REFMODETEXT, this.getRefModeText());
        }
        if (!bl || this.isRefParamDirty()) {
            hashMap.put(FIELD_REFPARAM, this.getRefParam());
        }
        if (!bl || this.isRefParamDescDirty()) {
            hashMap.put(FIELD_REFPARAMDESC, this.getRefParamDesc());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isUserTag3Dirty()) {
            hashMap.put(FIELD_USERTAG3, this.getUserTag3());
        }
        if (!bl || this.isUserTag4Dirty()) {
            hashMap.put(FIELD_USERTAG4, this.getUserTag4());
        }
        if (!bl || this.isViewParamsDirty()) {
            hashMap.put(FIELD_VIEWPARAMS, this.getViewParams());
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
        return PSDETreeNodeRVBase.get(this, n);
    }

    private static Object get(PSDETreeNodeRVBase pSDETreeNodeRVBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETreeNodeRVBase.getCreateDate();
            }
            case 1: {
                return pSDETreeNodeRVBase.getCreateMan();
            }
            case 2: {
                return pSDETreeNodeRVBase.getMemo();
            }
            case 3: {
                return pSDETreeNodeRVBase.getPSDETreeNodeId();
            }
            case 4: {
                return pSDETreeNodeRVBase.getPSDETreeNodeName();
            }
            case 5: {
                return pSDETreeNodeRVBase.getPSDETreeNodeRVId();
            }
            case 6: {
                return pSDETreeNodeRVBase.getPSDETreeNodeRVName();
            }
            case 7: {
                return pSDETreeNodeRVBase.getPSDETreeViewId();
            }
            case 8: {
                return pSDETreeNodeRVBase.getPSDEViewBaseId();
            }
            case 9: {
                return pSDETreeNodeRVBase.getPSDEViewBaseName();
            }
            case 10: {
                return pSDETreeNodeRVBase.getRefMode();
            }
            case 11: {
                return pSDETreeNodeRVBase.getRefModeText();
            }
            case 12: {
                return pSDETreeNodeRVBase.getRefParam();
            }
            case 13: {
                return pSDETreeNodeRVBase.getRefParamDesc();
            }
            case 14: {
                return pSDETreeNodeRVBase.getUpdateDate();
            }
            case 15: {
                return pSDETreeNodeRVBase.getUpdateMan();
            }
            case 16: {
                return pSDETreeNodeRVBase.getUserCat();
            }
            case 17: {
                return pSDETreeNodeRVBase.getUserTag();
            }
            case 18: {
                return pSDETreeNodeRVBase.getUserTag2();
            }
            case 19: {
                return pSDETreeNodeRVBase.getUserTag3();
            }
            case 20: {
                return pSDETreeNodeRVBase.getUserTag4();
            }
            case 21: {
                return pSDETreeNodeRVBase.getViewParams();
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
        PSDETreeNodeRVBase.set(this, n, object);
    }

    private static void set(PSDETreeNodeRVBase pSDETreeNodeRVBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDETreeNodeRVBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDETreeNodeRVBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDETreeNodeRVBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDETreeNodeRVBase.setPSDETreeNodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDETreeNodeRVBase.setPSDETreeNodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDETreeNodeRVBase.setPSDETreeNodeRVId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDETreeNodeRVBase.setPSDETreeNodeRVName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDETreeNodeRVBase.setPSDETreeViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDETreeNodeRVBase.setPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDETreeNodeRVBase.setPSDEViewBaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDETreeNodeRVBase.setRefMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDETreeNodeRVBase.setRefModeText(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDETreeNodeRVBase.setRefParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDETreeNodeRVBase.setRefParamDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDETreeNodeRVBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSDETreeNodeRVBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDETreeNodeRVBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDETreeNodeRVBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDETreeNodeRVBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDETreeNodeRVBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDETreeNodeRVBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDETreeNodeRVBase.setViewParams(DataObject.getStringValue((Object)object));
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
        return PSDETreeNodeRVBase.isNull(this, n);
    }

    private static boolean isNull(PSDETreeNodeRVBase pSDETreeNodeRVBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETreeNodeRVBase.getCreateDate() == null;
            }
            case 1: {
                return pSDETreeNodeRVBase.getCreateMan() == null;
            }
            case 2: {
                return pSDETreeNodeRVBase.getMemo() == null;
            }
            case 3: {
                return pSDETreeNodeRVBase.getPSDETreeNodeId() == null;
            }
            case 4: {
                return pSDETreeNodeRVBase.getPSDETreeNodeName() == null;
            }
            case 5: {
                return pSDETreeNodeRVBase.getPSDETreeNodeRVId() == null;
            }
            case 6: {
                return pSDETreeNodeRVBase.getPSDETreeNodeRVName() == null;
            }
            case 7: {
                return pSDETreeNodeRVBase.getPSDETreeViewId() == null;
            }
            case 8: {
                return pSDETreeNodeRVBase.getPSDEViewBaseId() == null;
            }
            case 9: {
                return pSDETreeNodeRVBase.getPSDEViewBaseName() == null;
            }
            case 10: {
                return pSDETreeNodeRVBase.getRefMode() == null;
            }
            case 11: {
                return pSDETreeNodeRVBase.getRefModeText() == null;
            }
            case 12: {
                return pSDETreeNodeRVBase.getRefParam() == null;
            }
            case 13: {
                return pSDETreeNodeRVBase.getRefParamDesc() == null;
            }
            case 14: {
                return pSDETreeNodeRVBase.getUpdateDate() == null;
            }
            case 15: {
                return pSDETreeNodeRVBase.getUpdateMan() == null;
            }
            case 16: {
                return pSDETreeNodeRVBase.getUserCat() == null;
            }
            case 17: {
                return pSDETreeNodeRVBase.getUserTag() == null;
            }
            case 18: {
                return pSDETreeNodeRVBase.getUserTag2() == null;
            }
            case 19: {
                return pSDETreeNodeRVBase.getUserTag3() == null;
            }
            case 20: {
                return pSDETreeNodeRVBase.getUserTag4() == null;
            }
            case 21: {
                return pSDETreeNodeRVBase.getViewParams() == null;
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
        return PSDETreeNodeRVBase.contains(this, n);
    }

    private static boolean contains(PSDETreeNodeRVBase pSDETreeNodeRVBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETreeNodeRVBase.isCreateDateDirty();
            }
            case 1: {
                return pSDETreeNodeRVBase.isCreateManDirty();
            }
            case 2: {
                return pSDETreeNodeRVBase.isMemoDirty();
            }
            case 3: {
                return pSDETreeNodeRVBase.isPSDETreeNodeIdDirty();
            }
            case 4: {
                return pSDETreeNodeRVBase.isPSDETreeNodeNameDirty();
            }
            case 5: {
                return pSDETreeNodeRVBase.isPSDETreeNodeRVIdDirty();
            }
            case 6: {
                return pSDETreeNodeRVBase.isPSDETreeNodeRVNameDirty();
            }
            case 7: {
                return pSDETreeNodeRVBase.isPSDETreeViewIdDirty();
            }
            case 8: {
                return pSDETreeNodeRVBase.isPSDEViewBaseIdDirty();
            }
            case 9: {
                return pSDETreeNodeRVBase.isPSDEViewBaseNameDirty();
            }
            case 10: {
                return pSDETreeNodeRVBase.isRefModeDirty();
            }
            case 11: {
                return pSDETreeNodeRVBase.isRefModeTextDirty();
            }
            case 12: {
                return pSDETreeNodeRVBase.isRefParamDirty();
            }
            case 13: {
                return pSDETreeNodeRVBase.isRefParamDescDirty();
            }
            case 14: {
                return pSDETreeNodeRVBase.isUpdateDateDirty();
            }
            case 15: {
                return pSDETreeNodeRVBase.isUpdateManDirty();
            }
            case 16: {
                return pSDETreeNodeRVBase.isUserCatDirty();
            }
            case 17: {
                return pSDETreeNodeRVBase.isUserTagDirty();
            }
            case 18: {
                return pSDETreeNodeRVBase.isUserTag2Dirty();
            }
            case 19: {
                return pSDETreeNodeRVBase.isUserTag3Dirty();
            }
            case 20: {
                return pSDETreeNodeRVBase.isUserTag4Dirty();
            }
            case 21: {
                return pSDETreeNodeRVBase.isViewParamsDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDETreeNodeRVBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDETreeNodeRVBase pSDETreeNodeRVBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDETreeNodeRVBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDETreeNodeRVBase.getJSONValue((Object)pSDETreeNodeRVBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDETreeNodeRVBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDETreeNodeRVBase.getJSONValue((Object)pSDETreeNodeRVBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDETreeNodeRVBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDETreeNodeRVBase.getJSONValue((Object)pSDETreeNodeRVBase.getMemo()), (boolean)false);
        }
        if (bl || pSDETreeNodeRVBase.getPSDETreeNodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreenodeid", (Object)PSDETreeNodeRVBase.getJSONValue((Object)pSDETreeNodeRVBase.getPSDETreeNodeId()), (boolean)false);
        }
        if (bl || pSDETreeNodeRVBase.getPSDETreeNodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreenodename", (Object)PSDETreeNodeRVBase.getJSONValue((Object)pSDETreeNodeRVBase.getPSDETreeNodeName()), (boolean)false);
        }
        if (bl || pSDETreeNodeRVBase.getPSDETreeNodeRVId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreenodervid", (Object)PSDETreeNodeRVBase.getJSONValue((Object)pSDETreeNodeRVBase.getPSDETreeNodeRVId()), (boolean)false);
        }
        if (bl || pSDETreeNodeRVBase.getPSDETreeNodeRVName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreenodervname", (Object)PSDETreeNodeRVBase.getJSONValue((Object)pSDETreeNodeRVBase.getPSDETreeNodeRVName()), (boolean)false);
        }
        if (bl || pSDETreeNodeRVBase.getPSDETreeViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreeviewid", (Object)PSDETreeNodeRVBase.getJSONValue((Object)pSDETreeNodeRVBase.getPSDETreeViewId()), (boolean)false);
        }
        if (bl || pSDETreeNodeRVBase.getPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbaseid", (Object)PSDETreeNodeRVBase.getJSONValue((Object)pSDETreeNodeRVBase.getPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSDETreeNodeRVBase.getPSDEViewBaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasename", (Object)PSDETreeNodeRVBase.getJSONValue((Object)pSDETreeNodeRVBase.getPSDEViewBaseName()), (boolean)false);
        }
        if (bl || pSDETreeNodeRVBase.getRefMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refmode", (Object)PSDETreeNodeRVBase.getJSONValue((Object)pSDETreeNodeRVBase.getRefMode()), (boolean)false);
        }
        if (bl || pSDETreeNodeRVBase.getRefModeText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refmodetext", (Object)PSDETreeNodeRVBase.getJSONValue((Object)pSDETreeNodeRVBase.getRefModeText()), (boolean)false);
        }
        if (bl || pSDETreeNodeRVBase.getRefParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refparam", (Object)PSDETreeNodeRVBase.getJSONValue((Object)pSDETreeNodeRVBase.getRefParam()), (boolean)false);
        }
        if (bl || pSDETreeNodeRVBase.getRefParamDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refparamdesc", (Object)PSDETreeNodeRVBase.getJSONValue((Object)pSDETreeNodeRVBase.getRefParamDesc()), (boolean)false);
        }
        if (bl || pSDETreeNodeRVBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDETreeNodeRVBase.getJSONValue((Object)pSDETreeNodeRVBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDETreeNodeRVBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDETreeNodeRVBase.getJSONValue((Object)pSDETreeNodeRVBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDETreeNodeRVBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDETreeNodeRVBase.getJSONValue((Object)pSDETreeNodeRVBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDETreeNodeRVBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDETreeNodeRVBase.getJSONValue((Object)pSDETreeNodeRVBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDETreeNodeRVBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDETreeNodeRVBase.getJSONValue((Object)pSDETreeNodeRVBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDETreeNodeRVBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDETreeNodeRVBase.getJSONValue((Object)pSDETreeNodeRVBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDETreeNodeRVBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDETreeNodeRVBase.getJSONValue((Object)pSDETreeNodeRVBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDETreeNodeRVBase.getViewParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewparams", (Object)PSDETreeNodeRVBase.getJSONValue((Object)pSDETreeNodeRVBase.getViewParams()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDETreeNodeRVBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDETreeNodeRVBase pSDETreeNodeRVBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDETreeNodeRVBase.getCreateDate() != null) {
            object = pSDETreeNodeRVBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDETreeNodeRVBase.getCreateMan() != null) {
            object = pSDETreeNodeRVBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRVBase.getMemo() != null) {
            object = pSDETreeNodeRVBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRVBase.getPSDETreeNodeId() != null) {
            object = pSDETreeNodeRVBase.getPSDETreeNodeId();
            xmlNode.setAttribute(FIELD_PSDETREENODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRVBase.getPSDETreeNodeName() != null) {
            object = pSDETreeNodeRVBase.getPSDETreeNodeName();
            xmlNode.setAttribute(FIELD_PSDETREENODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRVBase.getPSDETreeNodeRVId() != null) {
            object = pSDETreeNodeRVBase.getPSDETreeNodeRVId();
            xmlNode.setAttribute(FIELD_PSDETREENODERVID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRVBase.getPSDETreeNodeRVName() != null) {
            object = pSDETreeNodeRVBase.getPSDETreeNodeRVName();
            xmlNode.setAttribute(FIELD_PSDETREENODERVNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRVBase.getPSDETreeViewId() != null) {
            object = pSDETreeNodeRVBase.getPSDETreeViewId();
            xmlNode.setAttribute(FIELD_PSDETREEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRVBase.getPSDEViewBaseId() != null) {
            object = pSDETreeNodeRVBase.getPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRVBase.getPSDEViewBaseName() != null) {
            object = pSDETreeNodeRVBase.getPSDEViewBaseName();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRVBase.getRefMode() != null) {
            object = pSDETreeNodeRVBase.getRefMode();
            xmlNode.setAttribute(FIELD_REFMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRVBase.getRefModeText() != null) {
            object = pSDETreeNodeRVBase.getRefModeText();
            xmlNode.setAttribute(FIELD_REFMODETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRVBase.getRefParam() != null) {
            object = pSDETreeNodeRVBase.getRefParam();
            xmlNode.setAttribute(FIELD_REFPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRVBase.getRefParamDesc() != null) {
            object = pSDETreeNodeRVBase.getRefParamDesc();
            xmlNode.setAttribute(FIELD_REFPARAMDESC, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRVBase.getUpdateDate() != null) {
            object = pSDETreeNodeRVBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDETreeNodeRVBase.getUpdateMan() != null) {
            object = pSDETreeNodeRVBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRVBase.getUserCat() != null) {
            object = pSDETreeNodeRVBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRVBase.getUserTag() != null) {
            object = pSDETreeNodeRVBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRVBase.getUserTag2() != null) {
            object = pSDETreeNodeRVBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRVBase.getUserTag3() != null) {
            object = pSDETreeNodeRVBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRVBase.getUserTag4() != null) {
            object = pSDETreeNodeRVBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRVBase.getViewParams() != null) {
            object = pSDETreeNodeRVBase.getViewParams();
            xmlNode.setAttribute(FIELD_VIEWPARAMS, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDETreeNodeRVBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDETreeNodeRVBase pSDETreeNodeRVBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDETreeNodeRVBase.isCreateDateDirty() && (bl || pSDETreeNodeRVBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDETreeNodeRVBase.getCreateDate());
        }
        if (pSDETreeNodeRVBase.isCreateManDirty() && (bl || pSDETreeNodeRVBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDETreeNodeRVBase.getCreateMan());
        }
        if (pSDETreeNodeRVBase.isMemoDirty() && (bl || pSDETreeNodeRVBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDETreeNodeRVBase.getMemo());
        }
        if (pSDETreeNodeRVBase.isPSDETreeNodeIdDirty() && (bl || pSDETreeNodeRVBase.getPSDETreeNodeId() != null)) {
            iDataObject.set(FIELD_PSDETREENODEID, (Object)pSDETreeNodeRVBase.getPSDETreeNodeId());
        }
        if (pSDETreeNodeRVBase.isPSDETreeNodeNameDirty() && (bl || pSDETreeNodeRVBase.getPSDETreeNodeName() != null)) {
            iDataObject.set(FIELD_PSDETREENODENAME, (Object)pSDETreeNodeRVBase.getPSDETreeNodeName());
        }
        if (pSDETreeNodeRVBase.isPSDETreeNodeRVIdDirty() && (bl || pSDETreeNodeRVBase.getPSDETreeNodeRVId() != null)) {
            iDataObject.set(FIELD_PSDETREENODERVID, (Object)pSDETreeNodeRVBase.getPSDETreeNodeRVId());
        }
        if (pSDETreeNodeRVBase.isPSDETreeNodeRVNameDirty() && (bl || pSDETreeNodeRVBase.getPSDETreeNodeRVName() != null)) {
            iDataObject.set(FIELD_PSDETREENODERVNAME, (Object)pSDETreeNodeRVBase.getPSDETreeNodeRVName());
        }
        if (pSDETreeNodeRVBase.isPSDETreeViewIdDirty() && (bl || pSDETreeNodeRVBase.getPSDETreeViewId() != null)) {
            iDataObject.set(FIELD_PSDETREEVIEWID, (Object)pSDETreeNodeRVBase.getPSDETreeViewId());
        }
        if (pSDETreeNodeRVBase.isPSDEViewBaseIdDirty() && (bl || pSDETreeNodeRVBase.getPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASEID, (Object)pSDETreeNodeRVBase.getPSDEViewBaseId());
        }
        if (pSDETreeNodeRVBase.isPSDEViewBaseNameDirty() && (bl || pSDETreeNodeRVBase.getPSDEViewBaseName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASENAME, (Object)pSDETreeNodeRVBase.getPSDEViewBaseName());
        }
        if (pSDETreeNodeRVBase.isRefModeDirty() && (bl || pSDETreeNodeRVBase.getRefMode() != null)) {
            iDataObject.set(FIELD_REFMODE, (Object)pSDETreeNodeRVBase.getRefMode());
        }
        if (pSDETreeNodeRVBase.isRefModeTextDirty() && (bl || pSDETreeNodeRVBase.getRefModeText() != null)) {
            iDataObject.set(FIELD_REFMODETEXT, (Object)pSDETreeNodeRVBase.getRefModeText());
        }
        if (pSDETreeNodeRVBase.isRefParamDirty() && (bl || pSDETreeNodeRVBase.getRefParam() != null)) {
            iDataObject.set(FIELD_REFPARAM, (Object)pSDETreeNodeRVBase.getRefParam());
        }
        if (pSDETreeNodeRVBase.isRefParamDescDirty() && (bl || pSDETreeNodeRVBase.getRefParamDesc() != null)) {
            iDataObject.set(FIELD_REFPARAMDESC, (Object)pSDETreeNodeRVBase.getRefParamDesc());
        }
        if (pSDETreeNodeRVBase.isUpdateDateDirty() && (bl || pSDETreeNodeRVBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDETreeNodeRVBase.getUpdateDate());
        }
        if (pSDETreeNodeRVBase.isUpdateManDirty() && (bl || pSDETreeNodeRVBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDETreeNodeRVBase.getUpdateMan());
        }
        if (pSDETreeNodeRVBase.isUserCatDirty() && (bl || pSDETreeNodeRVBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDETreeNodeRVBase.getUserCat());
        }
        if (pSDETreeNodeRVBase.isUserTagDirty() && (bl || pSDETreeNodeRVBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDETreeNodeRVBase.getUserTag());
        }
        if (pSDETreeNodeRVBase.isUserTag2Dirty() && (bl || pSDETreeNodeRVBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDETreeNodeRVBase.getUserTag2());
        }
        if (pSDETreeNodeRVBase.isUserTag3Dirty() && (bl || pSDETreeNodeRVBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDETreeNodeRVBase.getUserTag3());
        }
        if (pSDETreeNodeRVBase.isUserTag4Dirty() && (bl || pSDETreeNodeRVBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDETreeNodeRVBase.getUserTag4());
        }
        if (pSDETreeNodeRVBase.isViewParamsDirty() && (bl || pSDETreeNodeRVBase.getViewParams() != null)) {
            iDataObject.set(FIELD_VIEWPARAMS, (Object)pSDETreeNodeRVBase.getViewParams());
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
        return PSDETreeNodeRVBase.remove(this, n);
    }

    private static boolean remove(PSDETreeNodeRVBase pSDETreeNodeRVBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDETreeNodeRVBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDETreeNodeRVBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDETreeNodeRVBase.resetMemo();
                return true;
            }
            case 3: {
                pSDETreeNodeRVBase.resetPSDETreeNodeId();
                return true;
            }
            case 4: {
                pSDETreeNodeRVBase.resetPSDETreeNodeName();
                return true;
            }
            case 5: {
                pSDETreeNodeRVBase.resetPSDETreeNodeRVId();
                return true;
            }
            case 6: {
                pSDETreeNodeRVBase.resetPSDETreeNodeRVName();
                return true;
            }
            case 7: {
                pSDETreeNodeRVBase.resetPSDETreeViewId();
                return true;
            }
            case 8: {
                pSDETreeNodeRVBase.resetPSDEViewBaseId();
                return true;
            }
            case 9: {
                pSDETreeNodeRVBase.resetPSDEViewBaseName();
                return true;
            }
            case 10: {
                pSDETreeNodeRVBase.resetRefMode();
                return true;
            }
            case 11: {
                pSDETreeNodeRVBase.resetRefModeText();
                return true;
            }
            case 12: {
                pSDETreeNodeRVBase.resetRefParam();
                return true;
            }
            case 13: {
                pSDETreeNodeRVBase.resetRefParamDesc();
                return true;
            }
            case 14: {
                pSDETreeNodeRVBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSDETreeNodeRVBase.resetUpdateMan();
                return true;
            }
            case 16: {
                pSDETreeNodeRVBase.resetUserCat();
                return true;
            }
            case 17: {
                pSDETreeNodeRVBase.resetUserTag();
                return true;
            }
            case 18: {
                pSDETreeNodeRVBase.resetUserTag2();
                return true;
            }
            case 19: {
                pSDETreeNodeRVBase.resetUserTag3();
                return true;
            }
            case 20: {
                pSDETreeNodeRVBase.resetUserTag4();
                return true;
            }
            case 21: {
                pSDETreeNodeRVBase.resetViewParams();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDETreeNode getPSDETreeNode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeNode();
        }
        if (this.getPSDETreeNodeId() == null) {
            return null;
        }
        Integer n = this.objPSDETreeNodeLock;
        synchronized (n) {
            if (this.psdetreenode != null && DataTypeHelper.compare((int)25, (Object)this.getPSDETreeNodeId(), (Object)this.psdetreenode.getPSDETreeNodeId()) != 0L) {
                this.psdetreenode = null;
            }
            if (this.psdetreenode == null) {
                PSDETreeNode pSDETreeNode = new PSDETreeNode();
                pSDETreeNode.setPSDETreeNodeId(this.getPSDETreeNodeId());
                PSDETreeNodeService pSDETreeNodeService = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
                pSDETreeNodeService.autoGet(pSDETreeNode);
                this.psdetreenode = pSDETreeNode;
            }
            return this.psdetreenode;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getPSDEViewBase() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBase();
        }
        if (this.getPSDEViewBaseId() == null) {
            return null;
        }
        Integer n = this.objPSDEViewBaseLock;
        synchronized (n) {
            if (this.psdeviewbase != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEViewBaseId(), (Object)this.psdeviewbase.getPSDEViewBaseId()) != 0L) {
                this.psdeviewbase = null;
            }
            if (this.psdeviewbase == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getPSDEViewBaseId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet(pSDEViewBase);
                this.psdeviewbase = pSDEViewBase;
            }
            return this.psdeviewbase;
        }
    }

    private PSDETreeNodeRVBase getProxyEntity() {
        return this.proxyPSDETreeNodeRVBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDETreeNodeRVBase = null;
        if (iDataObject != null && iDataObject instanceof PSDETreeNodeRVBase) {
            this.proxyPSDETreeNodeRVBase = (PSDETreeNodeRVBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeRVService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDETREENODEID, 3);
        fieldIndexMap.put(FIELD_PSDETREENODENAME, 4);
        fieldIndexMap.put(FIELD_PSDETREENODERVID, 5);
        fieldIndexMap.put(FIELD_PSDETREENODERVNAME, 6);
        fieldIndexMap.put(FIELD_PSDETREEVIEWID, 7);
        fieldIndexMap.put(FIELD_PSDEVIEWBASEID, 8);
        fieldIndexMap.put(FIELD_PSDEVIEWBASENAME, 9);
        fieldIndexMap.put(FIELD_REFMODE, 10);
        fieldIndexMap.put(FIELD_REFMODETEXT, 11);
        fieldIndexMap.put(FIELD_REFPARAM, 12);
        fieldIndexMap.put(FIELD_REFPARAMDESC, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
        fieldIndexMap.put(FIELD_USERCAT, 16);
        fieldIndexMap.put(FIELD_USERTAG, 17);
        fieldIndexMap.put(FIELD_USERTAG2, 18);
        fieldIndexMap.put(FIELD_USERTAG3, 19);
        fieldIndexMap.put(FIELD_USERTAG4, 20);
        fieldIndexMap.put(FIELD_VIEWPARAMS, 21);
    }
}

