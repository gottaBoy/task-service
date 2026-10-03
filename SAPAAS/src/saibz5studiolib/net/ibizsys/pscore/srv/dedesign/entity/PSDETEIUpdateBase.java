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
import java.util.ArrayList;
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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETEIUDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeView;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETEIUDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETEIUpdateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDETEIUpdateBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDETEIUpdateBase.class);
    public static final String FIELD_BUSYINDICATOR = "BUSYINDICATOR";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEACTIONID = "PSDEACTIONID";
    public static final String FIELD_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDETEIUPDATEID = "PSDETEIUPDATEID";
    public static final String FIELD_PSDETEIUPDATENAME = "PSDETEIUPDATENAME";
    public static final String FIELD_PSDETREENODEID = "PSDETREENODEID";
    public static final String FIELD_PSDETREENODENAME = "PSDETREENODENAME";
    public static final String FIELD_PSDETREEVIEWID = "PSDETREEVIEWID";
    public static final String FIELD_PSDETREEVIEWNAME = "PSDETREEVIEWNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    private static final int INDEX_BUSYINDICATOR = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_CUSTOMCODE = 4;
    private static final int INDEX_CUSTOMMODE = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_PSDEACTIONID = 7;
    private static final int INDEX_PSDEACTIONNAME = 8;
    private static final int INDEX_PSDEID = 9;
    private static final int INDEX_PSDETEIUPDATEID = 10;
    private static final int INDEX_PSDETEIUPDATENAME = 11;
    private static final int INDEX_PSDETREENODEID = 12;
    private static final int INDEX_PSDETREENODENAME = 13;
    private static final int INDEX_PSDETREEVIEWID = 14;
    private static final int INDEX_PSDETREEVIEWNAME = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_USERTAG = 18;
    private static final int INDEX_USERTAG2 = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDETEIUpdateBase proxyPSDETEIUpdateBase = null;
    private boolean busyindicatorDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeactionidDirtyFlag = false;
    private boolean psdeactionnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdeteiupdateidDirtyFlag = false;
    private boolean psdeteiupdatenameDirtyFlag = false;
    private boolean psdetreenodeidDirtyFlag = false;
    private boolean psdetreenodenameDirtyFlag = false;
    private boolean psdetreeviewidDirtyFlag = false;
    private boolean psdetreeviewnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    @Column(name="busyindicator")
    private Integer busyindicator;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeactionid")
    private String psdeactionid;
    @Column(name="psdeactionname")
    private String psdeactionname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdeteiupdateid")
    private String psdeteiupdateid;
    @Column(name="psdeteiupdatename")
    private String psdeteiupdatename;
    @Column(name="psdetreenodeid")
    private String psdetreenodeid;
    @Column(name="psdetreenodename")
    private String psdetreenodename;
    @Column(name="psdetreeviewid")
    private String psdetreeviewid;
    @Column(name="psdetreeviewname")
    private String psdetreeviewname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    private Integer objPSDEActionLock = new Integer(1);
    private PSDEAction psdeaction = null;
    private Integer objPSDETreeNodeLock = new Integer(1);
    private PSDETreeNode psdetreenode = null;
    private Integer objPSDETreeViewLock = new Integer(1);
    private PSDETreeView psdetreeview = null;
    private Integer objPSDETEIUDetailsLock = new Integer(1);
    private ArrayList<PSDETEIUDetail> psdeteiudetails = null;

    public void setBusyIndicator(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBusyIndicator(n);
            return;
        }
        this.busyindicator = n;
        this.busyindicatorDirtyFlag = true;
    }

    public Integer getBusyIndicator() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBusyIndicator();
        }
        return this.busyindicator;
    }

    public boolean isBusyIndicatorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBusyIndicatorDirty();
        }
        return this.busyindicatorDirtyFlag;
    }

    public void resetBusyIndicator() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBusyIndicator();
            return;
        }
        this.busyindicatorDirtyFlag = false;
        this.busyindicator = null;
    }

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
    }

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

    public void setCustomCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcode = string;
        this.customcodeDirtyFlag = true;
    }

    public String getCustomCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCode();
        }
        return this.customcode;
    }

    public boolean isCustomCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCodeDirty();
        }
        return this.customcodeDirtyFlag;
    }

    public void resetCustomCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCode();
            return;
        }
        this.customcodeDirtyFlag = false;
        this.customcode = null;
    }

    public void setCustomMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomMode(n);
            return;
        }
        this.custommode = n;
        this.custommodeDirtyFlag = true;
    }

    public Integer getCustomMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomMode();
        }
        return this.custommode;
    }

    public boolean isCustomModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomModeDirty();
        }
        return this.custommodeDirtyFlag;
    }

    public void resetCustomMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomMode();
            return;
        }
        this.custommodeDirtyFlag = false;
        this.custommode = null;
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

    public void setPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionid = string;
        this.psdeactionidDirtyFlag = true;
    }

    public String getPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionId();
        }
        return this.psdeactionid;
    }

    public boolean isPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionIdDirty();
        }
        return this.psdeactionidDirtyFlag;
    }

    public void resetPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionId();
            return;
        }
        this.psdeactionidDirtyFlag = false;
        this.psdeactionid = null;
    }

    public void setPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionname = string;
        this.psdeactionnameDirtyFlag = true;
    }

    public String getPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionName();
        }
        return this.psdeactionname;
    }

    public boolean isPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionNameDirty();
        }
        return this.psdeactionnameDirtyFlag;
    }

    public void resetPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionName();
            return;
        }
        this.psdeactionnameDirtyFlag = false;
        this.psdeactionname = null;
    }

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
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

    protected void onReset() {
        PSDETEIUpdateBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDETEIUpdateBase pSDETEIUpdateBase) {
        pSDETEIUpdateBase.resetBusyIndicator();
        pSDETEIUpdateBase.resetCodeName();
        pSDETEIUpdateBase.resetCreateDate();
        pSDETEIUpdateBase.resetCreateMan();
        pSDETEIUpdateBase.resetCustomCode();
        pSDETEIUpdateBase.resetCustomMode();
        pSDETEIUpdateBase.resetMemo();
        pSDETEIUpdateBase.resetPSDEActionId();
        pSDETEIUpdateBase.resetPSDEActionName();
        pSDETEIUpdateBase.resetPSDEId();
        pSDETEIUpdateBase.resetPSDETEIUpdateId();
        pSDETEIUpdateBase.resetPSDETEIUpdateName();
        pSDETEIUpdateBase.resetPSDETreeNodeId();
        pSDETEIUpdateBase.resetPSDETreeNodeName();
        pSDETEIUpdateBase.resetPSDETreeViewId();
        pSDETEIUpdateBase.resetPSDETreeViewName();
        pSDETEIUpdateBase.resetUpdateDate();
        pSDETEIUpdateBase.resetUpdateMan();
        pSDETEIUpdateBase.resetUserTag();
        pSDETEIUpdateBase.resetUserTag2();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBusyIndicatorDirty()) {
            hashMap.put(FIELD_BUSYINDICATOR, this.getBusyIndicator());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isCustomModeDirty()) {
            hashMap.put(FIELD_CUSTOMMODE, this.getCustomMode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEActionIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONID, this.getPSDEActionId());
        }
        if (!bl || this.isPSDEActionNameDirty()) {
            hashMap.put(FIELD_PSDEACTIONNAME, this.getPSDEActionName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDETEIUpdateIdDirty()) {
            hashMap.put(FIELD_PSDETEIUPDATEID, this.getPSDETEIUpdateId());
        }
        if (!bl || this.isPSDETEIUpdateNameDirty()) {
            hashMap.put(FIELD_PSDETEIUPDATENAME, this.getPSDETEIUpdateName());
        }
        if (!bl || this.isPSDETreeNodeIdDirty()) {
            hashMap.put(FIELD_PSDETREENODEID, this.getPSDETreeNodeId());
        }
        if (!bl || this.isPSDETreeNodeNameDirty()) {
            hashMap.put(FIELD_PSDETREENODENAME, this.getPSDETreeNodeName());
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
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
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
        return PSDETEIUpdateBase.get(this, n);
    }

    private static Object get(PSDETEIUpdateBase pSDETEIUpdateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETEIUpdateBase.getBusyIndicator();
            }
            case 1: {
                return pSDETEIUpdateBase.getCodeName();
            }
            case 2: {
                return pSDETEIUpdateBase.getCreateDate();
            }
            case 3: {
                return pSDETEIUpdateBase.getCreateMan();
            }
            case 4: {
                return pSDETEIUpdateBase.getCustomCode();
            }
            case 5: {
                return pSDETEIUpdateBase.getCustomMode();
            }
            case 6: {
                return pSDETEIUpdateBase.getMemo();
            }
            case 7: {
                return pSDETEIUpdateBase.getPSDEActionId();
            }
            case 8: {
                return pSDETEIUpdateBase.getPSDEActionName();
            }
            case 9: {
                return pSDETEIUpdateBase.getPSDEId();
            }
            case 10: {
                return pSDETEIUpdateBase.getPSDETEIUpdateId();
            }
            case 11: {
                return pSDETEIUpdateBase.getPSDETEIUpdateName();
            }
            case 12: {
                return pSDETEIUpdateBase.getPSDETreeNodeId();
            }
            case 13: {
                return pSDETEIUpdateBase.getPSDETreeNodeName();
            }
            case 14: {
                return pSDETEIUpdateBase.getPSDETreeViewId();
            }
            case 15: {
                return pSDETEIUpdateBase.getPSDETreeViewName();
            }
            case 16: {
                return pSDETEIUpdateBase.getUpdateDate();
            }
            case 17: {
                return pSDETEIUpdateBase.getUpdateMan();
            }
            case 18: {
                return pSDETEIUpdateBase.getUserTag();
            }
            case 19: {
                return pSDETEIUpdateBase.getUserTag2();
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
        PSDETEIUpdateBase.set(this, n, object);
    }

    private static void set(PSDETEIUpdateBase pSDETEIUpdateBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDETEIUpdateBase.setBusyIndicator(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDETEIUpdateBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDETEIUpdateBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDETEIUpdateBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDETEIUpdateBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDETEIUpdateBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDETEIUpdateBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDETEIUpdateBase.setPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDETEIUpdateBase.setPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDETEIUpdateBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDETEIUpdateBase.setPSDETEIUpdateId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDETEIUpdateBase.setPSDETEIUpdateName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDETEIUpdateBase.setPSDETreeNodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDETEIUpdateBase.setPSDETreeNodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDETEIUpdateBase.setPSDETreeViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDETEIUpdateBase.setPSDETreeViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDETEIUpdateBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSDETEIUpdateBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDETEIUpdateBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDETEIUpdateBase.setUserTag2(DataObject.getStringValue((Object)object));
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
        return PSDETEIUpdateBase.isNull(this, n);
    }

    private static boolean isNull(PSDETEIUpdateBase pSDETEIUpdateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETEIUpdateBase.getBusyIndicator() == null;
            }
            case 1: {
                return pSDETEIUpdateBase.getCodeName() == null;
            }
            case 2: {
                return pSDETEIUpdateBase.getCreateDate() == null;
            }
            case 3: {
                return pSDETEIUpdateBase.getCreateMan() == null;
            }
            case 4: {
                return pSDETEIUpdateBase.getCustomCode() == null;
            }
            case 5: {
                return pSDETEIUpdateBase.getCustomMode() == null;
            }
            case 6: {
                return pSDETEIUpdateBase.getMemo() == null;
            }
            case 7: {
                return pSDETEIUpdateBase.getPSDEActionId() == null;
            }
            case 8: {
                return pSDETEIUpdateBase.getPSDEActionName() == null;
            }
            case 9: {
                return pSDETEIUpdateBase.getPSDEId() == null;
            }
            case 10: {
                return pSDETEIUpdateBase.getPSDETEIUpdateId() == null;
            }
            case 11: {
                return pSDETEIUpdateBase.getPSDETEIUpdateName() == null;
            }
            case 12: {
                return pSDETEIUpdateBase.getPSDETreeNodeId() == null;
            }
            case 13: {
                return pSDETEIUpdateBase.getPSDETreeNodeName() == null;
            }
            case 14: {
                return pSDETEIUpdateBase.getPSDETreeViewId() == null;
            }
            case 15: {
                return pSDETEIUpdateBase.getPSDETreeViewName() == null;
            }
            case 16: {
                return pSDETEIUpdateBase.getUpdateDate() == null;
            }
            case 17: {
                return pSDETEIUpdateBase.getUpdateMan() == null;
            }
            case 18: {
                return pSDETEIUpdateBase.getUserTag() == null;
            }
            case 19: {
                return pSDETEIUpdateBase.getUserTag2() == null;
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
        return PSDETEIUpdateBase.contains(this, n);
    }

    private static boolean contains(PSDETEIUpdateBase pSDETEIUpdateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETEIUpdateBase.isBusyIndicatorDirty();
            }
            case 1: {
                return pSDETEIUpdateBase.isCodeNameDirty();
            }
            case 2: {
                return pSDETEIUpdateBase.isCreateDateDirty();
            }
            case 3: {
                return pSDETEIUpdateBase.isCreateManDirty();
            }
            case 4: {
                return pSDETEIUpdateBase.isCustomCodeDirty();
            }
            case 5: {
                return pSDETEIUpdateBase.isCustomModeDirty();
            }
            case 6: {
                return pSDETEIUpdateBase.isMemoDirty();
            }
            case 7: {
                return pSDETEIUpdateBase.isPSDEActionIdDirty();
            }
            case 8: {
                return pSDETEIUpdateBase.isPSDEActionNameDirty();
            }
            case 9: {
                return pSDETEIUpdateBase.isPSDEIdDirty();
            }
            case 10: {
                return pSDETEIUpdateBase.isPSDETEIUpdateIdDirty();
            }
            case 11: {
                return pSDETEIUpdateBase.isPSDETEIUpdateNameDirty();
            }
            case 12: {
                return pSDETEIUpdateBase.isPSDETreeNodeIdDirty();
            }
            case 13: {
                return pSDETEIUpdateBase.isPSDETreeNodeNameDirty();
            }
            case 14: {
                return pSDETEIUpdateBase.isPSDETreeViewIdDirty();
            }
            case 15: {
                return pSDETEIUpdateBase.isPSDETreeViewNameDirty();
            }
            case 16: {
                return pSDETEIUpdateBase.isUpdateDateDirty();
            }
            case 17: {
                return pSDETEIUpdateBase.isUpdateManDirty();
            }
            case 18: {
                return pSDETEIUpdateBase.isUserTagDirty();
            }
            case 19: {
                return pSDETEIUpdateBase.isUserTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDETEIUpdateBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDETEIUpdateBase pSDETEIUpdateBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDETEIUpdateBase.getBusyIndicator() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"busyindicator", (Object)PSDETEIUpdateBase.getJSONValue((Object)pSDETEIUpdateBase.getBusyIndicator()), (boolean)false);
        }
        if (bl || pSDETEIUpdateBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDETEIUpdateBase.getJSONValue((Object)pSDETEIUpdateBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDETEIUpdateBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDETEIUpdateBase.getJSONValue((Object)pSDETEIUpdateBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDETEIUpdateBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDETEIUpdateBase.getJSONValue((Object)pSDETEIUpdateBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDETEIUpdateBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDETEIUpdateBase.getJSONValue((Object)pSDETEIUpdateBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDETEIUpdateBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSDETEIUpdateBase.getJSONValue((Object)pSDETEIUpdateBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSDETEIUpdateBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDETEIUpdateBase.getJSONValue((Object)pSDETEIUpdateBase.getMemo()), (boolean)false);
        }
        if (bl || pSDETEIUpdateBase.getPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionid", (Object)PSDETEIUpdateBase.getJSONValue((Object)pSDETEIUpdateBase.getPSDEActionId()), (boolean)false);
        }
        if (bl || pSDETEIUpdateBase.getPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionname", (Object)PSDETEIUpdateBase.getJSONValue((Object)pSDETEIUpdateBase.getPSDEActionName()), (boolean)false);
        }
        if (bl || pSDETEIUpdateBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDETEIUpdateBase.getJSONValue((Object)pSDETEIUpdateBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDETEIUpdateBase.getPSDETEIUpdateId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeteiupdateid", (Object)PSDETEIUpdateBase.getJSONValue((Object)pSDETEIUpdateBase.getPSDETEIUpdateId()), (boolean)false);
        }
        if (bl || pSDETEIUpdateBase.getPSDETEIUpdateName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeteiupdatename", (Object)PSDETEIUpdateBase.getJSONValue((Object)pSDETEIUpdateBase.getPSDETEIUpdateName()), (boolean)false);
        }
        if (bl || pSDETEIUpdateBase.getPSDETreeNodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreenodeid", (Object)PSDETEIUpdateBase.getJSONValue((Object)pSDETEIUpdateBase.getPSDETreeNodeId()), (boolean)false);
        }
        if (bl || pSDETEIUpdateBase.getPSDETreeNodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreenodename", (Object)PSDETEIUpdateBase.getJSONValue((Object)pSDETEIUpdateBase.getPSDETreeNodeName()), (boolean)false);
        }
        if (bl || pSDETEIUpdateBase.getPSDETreeViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreeviewid", (Object)PSDETEIUpdateBase.getJSONValue((Object)pSDETEIUpdateBase.getPSDETreeViewId()), (boolean)false);
        }
        if (bl || pSDETEIUpdateBase.getPSDETreeViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreeviewname", (Object)PSDETEIUpdateBase.getJSONValue((Object)pSDETEIUpdateBase.getPSDETreeViewName()), (boolean)false);
        }
        if (bl || pSDETEIUpdateBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDETEIUpdateBase.getJSONValue((Object)pSDETEIUpdateBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDETEIUpdateBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDETEIUpdateBase.getJSONValue((Object)pSDETEIUpdateBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDETEIUpdateBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDETEIUpdateBase.getJSONValue((Object)pSDETEIUpdateBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDETEIUpdateBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDETEIUpdateBase.getJSONValue((Object)pSDETEIUpdateBase.getUserTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDETEIUpdateBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDETEIUpdateBase pSDETEIUpdateBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDETEIUpdateBase.getBusyIndicator() != null) {
            object = pSDETEIUpdateBase.getBusyIndicator();
            xmlNode.setAttribute(FIELD_BUSYINDICATOR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETEIUpdateBase.getCodeName() != null) {
            object = pSDETEIUpdateBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETEIUpdateBase.getCreateDate() != null) {
            object = pSDETEIUpdateBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDETEIUpdateBase.getCreateMan() != null) {
            object = pSDETEIUpdateBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDETEIUpdateBase.getCustomCode() != null) {
            object = pSDETEIUpdateBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDETEIUpdateBase.getCustomMode() != null) {
            object = pSDETEIUpdateBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETEIUpdateBase.getMemo() != null) {
            object = pSDETEIUpdateBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDETEIUpdateBase.getPSDEActionId() != null) {
            object = pSDETEIUpdateBase.getPSDEActionId();
            xmlNode.setAttribute(FIELD_PSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDETEIUpdateBase.getPSDEActionName() != null) {
            object = pSDETEIUpdateBase.getPSDEActionName();
            xmlNode.setAttribute(FIELD_PSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETEIUpdateBase.getPSDEId() != null) {
            object = pSDETEIUpdateBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDETEIUpdateBase.getPSDETEIUpdateId() != null) {
            object = pSDETEIUpdateBase.getPSDETEIUpdateId();
            xmlNode.setAttribute(FIELD_PSDETEIUPDATEID, object == null ? "" : (String)object);
        }
        if (bl || pSDETEIUpdateBase.getPSDETEIUpdateName() != null) {
            object = pSDETEIUpdateBase.getPSDETEIUpdateName();
            xmlNode.setAttribute(FIELD_PSDETEIUPDATENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETEIUpdateBase.getPSDETreeNodeId() != null) {
            object = pSDETEIUpdateBase.getPSDETreeNodeId();
            xmlNode.setAttribute(FIELD_PSDETREENODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDETEIUpdateBase.getPSDETreeNodeName() != null) {
            object = pSDETEIUpdateBase.getPSDETreeNodeName();
            xmlNode.setAttribute(FIELD_PSDETREENODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETEIUpdateBase.getPSDETreeViewId() != null) {
            object = pSDETEIUpdateBase.getPSDETreeViewId();
            xmlNode.setAttribute(FIELD_PSDETREEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDETEIUpdateBase.getPSDETreeViewName() != null) {
            object = pSDETEIUpdateBase.getPSDETreeViewName();
            xmlNode.setAttribute(FIELD_PSDETREEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETEIUpdateBase.getUpdateDate() != null) {
            object = pSDETEIUpdateBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDETEIUpdateBase.getUpdateMan() != null) {
            object = pSDETEIUpdateBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDETEIUpdateBase.getUserTag() != null) {
            object = pSDETEIUpdateBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDETEIUpdateBase.getUserTag2() != null) {
            object = pSDETEIUpdateBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDETEIUpdateBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDETEIUpdateBase pSDETEIUpdateBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDETEIUpdateBase.isBusyIndicatorDirty() && (bl || pSDETEIUpdateBase.getBusyIndicator() != null)) {
            iDataObject.set(FIELD_BUSYINDICATOR, (Object)pSDETEIUpdateBase.getBusyIndicator());
        }
        if (pSDETEIUpdateBase.isCodeNameDirty() && (bl || pSDETEIUpdateBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDETEIUpdateBase.getCodeName());
        }
        if (pSDETEIUpdateBase.isCreateDateDirty() && (bl || pSDETEIUpdateBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDETEIUpdateBase.getCreateDate());
        }
        if (pSDETEIUpdateBase.isCreateManDirty() && (bl || pSDETEIUpdateBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDETEIUpdateBase.getCreateMan());
        }
        if (pSDETEIUpdateBase.isCustomCodeDirty() && (bl || pSDETEIUpdateBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDETEIUpdateBase.getCustomCode());
        }
        if (pSDETEIUpdateBase.isCustomModeDirty() && (bl || pSDETEIUpdateBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSDETEIUpdateBase.getCustomMode());
        }
        if (pSDETEIUpdateBase.isMemoDirty() && (bl || pSDETEIUpdateBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDETEIUpdateBase.getMemo());
        }
        if (pSDETEIUpdateBase.isPSDEActionIdDirty() && (bl || pSDETEIUpdateBase.getPSDEActionId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONID, (Object)pSDETEIUpdateBase.getPSDEActionId());
        }
        if (pSDETEIUpdateBase.isPSDEActionNameDirty() && (bl || pSDETEIUpdateBase.getPSDEActionName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONNAME, (Object)pSDETEIUpdateBase.getPSDEActionName());
        }
        if (pSDETEIUpdateBase.isPSDEIdDirty() && (bl || pSDETEIUpdateBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDETEIUpdateBase.getPSDEId());
        }
        if (pSDETEIUpdateBase.isPSDETEIUpdateIdDirty() && (bl || pSDETEIUpdateBase.getPSDETEIUpdateId() != null)) {
            iDataObject.set(FIELD_PSDETEIUPDATEID, (Object)pSDETEIUpdateBase.getPSDETEIUpdateId());
        }
        if (pSDETEIUpdateBase.isPSDETEIUpdateNameDirty() && (bl || pSDETEIUpdateBase.getPSDETEIUpdateName() != null)) {
            iDataObject.set(FIELD_PSDETEIUPDATENAME, (Object)pSDETEIUpdateBase.getPSDETEIUpdateName());
        }
        if (pSDETEIUpdateBase.isPSDETreeNodeIdDirty() && (bl || pSDETEIUpdateBase.getPSDETreeNodeId() != null)) {
            iDataObject.set(FIELD_PSDETREENODEID, (Object)pSDETEIUpdateBase.getPSDETreeNodeId());
        }
        if (pSDETEIUpdateBase.isPSDETreeNodeNameDirty() && (bl || pSDETEIUpdateBase.getPSDETreeNodeName() != null)) {
            iDataObject.set(FIELD_PSDETREENODENAME, (Object)pSDETEIUpdateBase.getPSDETreeNodeName());
        }
        if (pSDETEIUpdateBase.isPSDETreeViewIdDirty() && (bl || pSDETEIUpdateBase.getPSDETreeViewId() != null)) {
            iDataObject.set(FIELD_PSDETREEVIEWID, (Object)pSDETEIUpdateBase.getPSDETreeViewId());
        }
        if (pSDETEIUpdateBase.isPSDETreeViewNameDirty() && (bl || pSDETEIUpdateBase.getPSDETreeViewName() != null)) {
            iDataObject.set(FIELD_PSDETREEVIEWNAME, (Object)pSDETEIUpdateBase.getPSDETreeViewName());
        }
        if (pSDETEIUpdateBase.isUpdateDateDirty() && (bl || pSDETEIUpdateBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDETEIUpdateBase.getUpdateDate());
        }
        if (pSDETEIUpdateBase.isUpdateManDirty() && (bl || pSDETEIUpdateBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDETEIUpdateBase.getUpdateMan());
        }
        if (pSDETEIUpdateBase.isUserTagDirty() && (bl || pSDETEIUpdateBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDETEIUpdateBase.getUserTag());
        }
        if (pSDETEIUpdateBase.isUserTag2Dirty() && (bl || pSDETEIUpdateBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDETEIUpdateBase.getUserTag2());
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
        return PSDETEIUpdateBase.remove(this, n);
    }

    private static boolean remove(PSDETEIUpdateBase pSDETEIUpdateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDETEIUpdateBase.resetBusyIndicator();
                return true;
            }
            case 1: {
                pSDETEIUpdateBase.resetCodeName();
                return true;
            }
            case 2: {
                pSDETEIUpdateBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDETEIUpdateBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDETEIUpdateBase.resetCustomCode();
                return true;
            }
            case 5: {
                pSDETEIUpdateBase.resetCustomMode();
                return true;
            }
            case 6: {
                pSDETEIUpdateBase.resetMemo();
                return true;
            }
            case 7: {
                pSDETEIUpdateBase.resetPSDEActionId();
                return true;
            }
            case 8: {
                pSDETEIUpdateBase.resetPSDEActionName();
                return true;
            }
            case 9: {
                pSDETEIUpdateBase.resetPSDEId();
                return true;
            }
            case 10: {
                pSDETEIUpdateBase.resetPSDETEIUpdateId();
                return true;
            }
            case 11: {
                pSDETEIUpdateBase.resetPSDETEIUpdateName();
                return true;
            }
            case 12: {
                pSDETEIUpdateBase.resetPSDETreeNodeId();
                return true;
            }
            case 13: {
                pSDETEIUpdateBase.resetPSDETreeNodeName();
                return true;
            }
            case 14: {
                pSDETEIUpdateBase.resetPSDETreeViewId();
                return true;
            }
            case 15: {
                pSDETEIUpdateBase.resetPSDETreeViewName();
                return true;
            }
            case 16: {
                pSDETEIUpdateBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSDETEIUpdateBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSDETEIUpdateBase.resetUserTag();
                return true;
            }
            case 19: {
                pSDETEIUpdateBase.resetUserTag2();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAction();
        }
        if (this.getPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objPSDEActionLock;
        synchronized (n) {
            if (this.psdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEActionId(), (Object)this.psdeaction.getPSDEActionId()) != 0L) {
                this.psdeaction = null;
            }
            if (this.psdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet(pSDEAction);
                this.psdeaction = pSDEAction;
            }
            return this.psdeaction;
        }
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
                pSDETreeViewService.autoGet(pSDETreeView);
                this.psdetreeview = pSDETreeView;
            }
            return this.psdetreeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDETEIUDetail> getPSDETEIUDetails() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETEIUDetails();
        }
        if (this.getPSDETEIUpdateId() == null) {
            return null;
        }
        PSDETEIUpdateService pSDETEIUpdateService = (PSDETEIUpdateService)ServiceGlobal.getService(PSDETEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        PSDETEIUDetailService pSDETEIUDetailService = (PSDETEIUDetailService)ServiceGlobal.getService(PSDETEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDETEIUDetailsLock;
        synchronized (n) {
            if (this.psdeteiudetails == null) {
                this.psdeteiudetails = pSDETEIUpdateService.isTempData(this) ? pSDETEIUDetailService.selectTempByPSDETEIUpdate(this) : pSDETEIUDetailService.selectByPSDETEIUpdate(this);
            }
            return this.psdeteiudetails;
        }
    }

    private PSDETEIUpdateBase getProxyEntity() {
        return this.proxyPSDETEIUpdateBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDETEIUpdateBase = null;
        if (iDataObject != null && iDataObject instanceof PSDETEIUpdateBase) {
            this.proxyPSDETEIUpdateBase = (PSDETEIUpdateBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETEIUpdateService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BUSYINDICATOR, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 4);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_PSDEACTIONID, 7);
        fieldIndexMap.put(FIELD_PSDEACTIONNAME, 8);
        fieldIndexMap.put(FIELD_PSDEID, 9);
        fieldIndexMap.put(FIELD_PSDETEIUPDATEID, 10);
        fieldIndexMap.put(FIELD_PSDETEIUPDATENAME, 11);
        fieldIndexMap.put(FIELD_PSDETREENODEID, 12);
        fieldIndexMap.put(FIELD_PSDETREENODENAME, 13);
        fieldIndexMap.put(FIELD_PSDETREEVIEWID, 14);
        fieldIndexMap.put(FIELD_PSDETREEVIEWNAME, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_USERTAG, 18);
        fieldIndexMap.put(FIELD_USERTAG2, 19);
    }
}

