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
package net.ibizsys.pscore.srv.sysdeploy.entity;

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
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSys;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSysDynaInst;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysDynaInstService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnSysDynaInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSlnSysDynaInstBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_INSTMODE = "INSTMODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PPSDEPSLNSYSDYNAINSTID = "PPSDEPSLNSYSDYNAINSTID";
    public static final String FIELD_PPSDEPSLNSYSDYNAINSTNAME = "PPSDEPSLNSYSDYNAINSTNAME";
    public static final String FIELD_PROXYPSDEPSLNSYSDYNAINSTID = "PROXYPSDEPSLNSYSDYNAINSTID";
    public static final String FIELD_PROXYPSDEPSLNSYSDYNAINSTNAME = "PROXYPSDEPSLNSYSDYNAINSTNAME";
    public static final String FIELD_PSDEPSLNID = "PSDEPSLNID";
    public static final String FIELD_PSDEPSLNSYSDYNAINSTID = "PSDEPSLNSYSDYNAINSTID";
    public static final String FIELD_PSDEPSLNSYSDYNAINSTNAME = "PSDEPSLNSYSDYNAINSTNAME";
    public static final String FIELD_PSDEPSLNSYSID = "PSDEPSLNSYSID";
    public static final String FIELD_PSDEPSLNSYSNAME = "PSDEPSLNSYSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_INSTMODE = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PPSDEPSLNSYSDYNAINSTID = 4;
    private static final int INDEX_PPSDEPSLNSYSDYNAINSTNAME = 5;
    private static final int INDEX_PROXYPSDEPSLNSYSDYNAINSTID = 6;
    private static final int INDEX_PROXYPSDEPSLNSYSDYNAINSTNAME = 7;
    private static final int INDEX_PSDEPSLNID = 8;
    private static final int INDEX_PSDEPSLNSYSDYNAINSTID = 9;
    private static final int INDEX_PSDEPSLNSYSDYNAINSTNAME = 10;
    private static final int INDEX_PSDEPSLNSYSID = 11;
    private static final int INDEX_PSDEPSLNSYSNAME = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final int INDEX_USERTAG = 15;
    private static final int INDEX_USERTAG2 = 16;
    private static final int INDEX_VALIDFLAG = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSlnSysDynaInstBase proxyPSDepSlnSysDynaInstBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean instmodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ppsdepslnsysdynainstidDirtyFlag = false;
    private boolean ppsdepslnsysdynainstnameDirtyFlag = false;
    private boolean proxypsdepslnsysdynainstidDirtyFlag = false;
    private boolean proxypsdepslnsysdynainstnameDirtyFlag = false;
    private boolean psdepslnidDirtyFlag = false;
    private boolean psdepslnsysdynainstidDirtyFlag = false;
    private boolean psdepslnsysdynainstnameDirtyFlag = false;
    private boolean psdepslnsysidDirtyFlag = false;
    private boolean psdepslnsysnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="instmode")
    private String instmode;
    @Column(name="memo")
    private String memo;
    @Column(name="ppsdepslnsysdynainstid")
    private String ppsdepslnsysdynainstid;
    @Column(name="ppsdepslnsysdynainstname")
    private String ppsdepslnsysdynainstname;
    @Column(name="proxypsdepslnsysdynainstid")
    private String proxypsdepslnsysdynainstid;
    @Column(name="proxypsdepslnsysdynainstname")
    private String proxypsdepslnsysdynainstname;
    @Column(name="psdepslnid")
    private String psdepslnid;
    @Column(name="psdepslnsysdynainstid")
    private String psdepslnsysdynainstid;
    @Column(name="psdepslnsysdynainstname")
    private String psdepslnsysdynainstname;
    @Column(name="psdepslnsysid")
    private String psdepslnsysid;
    @Column(name="psdepslnsysname")
    private String psdepslnsysname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPPSDepSlnSysDynaInstLock = new Integer(1);
    private PSDepSlnSysDynaInst ppsdepslnsysdynainst = null;
    private Integer objProxyPSDepSlnSysDynaInstLock = new Integer(1);
    private PSDepSlnSysDynaInst proxypsdepslnsysdynainst = null;
    private Integer objPSDepSlnSysLock = new Integer(1);
    private PSDepSlnSys psdepslnsys = null;

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

    public void setInstMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.instmode = string;
        this.instmodeDirtyFlag = true;
    }

    public String getInstMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstMode();
        }
        return this.instmode;
    }

    public boolean isInstModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstModeDirty();
        }
        return this.instmodeDirtyFlag;
    }

    public void resetInstMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstMode();
            return;
        }
        this.instmodeDirtyFlag = false;
        this.instmode = null;
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

    public void setPPSDepSlnSysDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDepSlnSysDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdepslnsysdynainstid = string;
        this.ppsdepslnsysdynainstidDirtyFlag = true;
    }

    public String getPPSDepSlnSysDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDepSlnSysDynaInstId();
        }
        return this.ppsdepslnsysdynainstid;
    }

    public boolean isPPSDepSlnSysDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDepSlnSysDynaInstIdDirty();
        }
        return this.ppsdepslnsysdynainstidDirtyFlag;
    }

    public void resetPPSDepSlnSysDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDepSlnSysDynaInstId();
            return;
        }
        this.ppsdepslnsysdynainstidDirtyFlag = false;
        this.ppsdepslnsysdynainstid = null;
    }

    public void setPPSDepSlnSysDynaInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDepSlnSysDynaInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdepslnsysdynainstname = string;
        this.ppsdepslnsysdynainstnameDirtyFlag = true;
    }

    public String getPPSDepSlnSysDynaInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDepSlnSysDynaInstName();
        }
        return this.ppsdepslnsysdynainstname;
    }

    public boolean isPPSDepSlnSysDynaInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDepSlnSysDynaInstNameDirty();
        }
        return this.ppsdepslnsysdynainstnameDirtyFlag;
    }

    public void resetPPSDepSlnSysDynaInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDepSlnSysDynaInstName();
            return;
        }
        this.ppsdepslnsysdynainstnameDirtyFlag = false;
        this.ppsdepslnsysdynainstname = null;
    }

    public void setProxyPSDepSlnSysDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setProxyPSDepSlnSysDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.proxypsdepslnsysdynainstid = string;
        this.proxypsdepslnsysdynainstidDirtyFlag = true;
    }

    public String getProxyPSDepSlnSysDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getProxyPSDepSlnSysDynaInstId();
        }
        return this.proxypsdepslnsysdynainstid;
    }

    public boolean isProxyPSDepSlnSysDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isProxyPSDepSlnSysDynaInstIdDirty();
        }
        return this.proxypsdepslnsysdynainstidDirtyFlag;
    }

    public void resetProxyPSDepSlnSysDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetProxyPSDepSlnSysDynaInstId();
            return;
        }
        this.proxypsdepslnsysdynainstidDirtyFlag = false;
        this.proxypsdepslnsysdynainstid = null;
    }

    public void setProxyPSDepSlnSysDynaInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setProxyPSDepSlnSysDynaInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.proxypsdepslnsysdynainstname = string;
        this.proxypsdepslnsysdynainstnameDirtyFlag = true;
    }

    public String getProxyPSDepSlnSysDynaInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getProxyPSDepSlnSysDynaInstName();
        }
        return this.proxypsdepslnsysdynainstname;
    }

    public boolean isProxyPSDepSlnSysDynaInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isProxyPSDepSlnSysDynaInstNameDirty();
        }
        return this.proxypsdepslnsysdynainstnameDirtyFlag;
    }

    public void resetProxyPSDepSlnSysDynaInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetProxyPSDepSlnSysDynaInstName();
            return;
        }
        this.proxypsdepslnsysdynainstnameDirtyFlag = false;
        this.proxypsdepslnsysdynainstname = null;
    }

    public void setPSDepSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnid = string;
        this.psdepslnidDirtyFlag = true;
    }

    public String getPSDepSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnId();
        }
        return this.psdepslnid;
    }

    public boolean isPSDepSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnIdDirty();
        }
        return this.psdepslnidDirtyFlag;
    }

    public void resetPSDepSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnId();
            return;
        }
        this.psdepslnidDirtyFlag = false;
        this.psdepslnid = null;
    }

    public void setPSDepSlnSysDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysdynainstid = string;
        this.psdepslnsysdynainstidDirtyFlag = true;
    }

    public String getPSDepSlnSysDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysDynaInstId();
        }
        return this.psdepslnsysdynainstid;
    }

    public boolean isPSDepSlnSysDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysDynaInstIdDirty();
        }
        return this.psdepslnsysdynainstidDirtyFlag;
    }

    public void resetPSDepSlnSysDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysDynaInstId();
            return;
        }
        this.psdepslnsysdynainstidDirtyFlag = false;
        this.psdepslnsysdynainstid = null;
    }

    public void setPSDepSlnSysDynaInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysDynaInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysdynainstname = string;
        this.psdepslnsysdynainstnameDirtyFlag = true;
    }

    public String getPSDepSlnSysDynaInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysDynaInstName();
        }
        return this.psdepslnsysdynainstname;
    }

    public boolean isPSDepSlnSysDynaInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysDynaInstNameDirty();
        }
        return this.psdepslnsysdynainstnameDirtyFlag;
    }

    public void resetPSDepSlnSysDynaInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysDynaInstName();
            return;
        }
        this.psdepslnsysdynainstnameDirtyFlag = false;
        this.psdepslnsysdynainstname = null;
    }

    public void setPSDepSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysid = string;
        this.psdepslnsysidDirtyFlag = true;
    }

    public String getPSDepSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysId();
        }
        return this.psdepslnsysid;
    }

    public boolean isPSDepSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysIdDirty();
        }
        return this.psdepslnsysidDirtyFlag;
    }

    public void resetPSDepSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysId();
            return;
        }
        this.psdepslnsysidDirtyFlag = false;
        this.psdepslnsysid = null;
    }

    public void setPSDepSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysname = string;
        this.psdepslnsysnameDirtyFlag = true;
    }

    public String getPSDepSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysName();
        }
        return this.psdepslnsysname;
    }

    public boolean isPSDepSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysNameDirty();
        }
        return this.psdepslnsysnameDirtyFlag;
    }

    public void resetPSDepSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysName();
            return;
        }
        this.psdepslnsysnameDirtyFlag = false;
        this.psdepslnsysname = null;
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

    public void setValidFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(n);
            return;
        }
        this.validflag = n;
        this.validflagDirtyFlag = true;
    }

    public Integer getValidFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    public boolean isValidFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    public void resetValidFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }
        this.validflagDirtyFlag = false;
        this.validflag = null;
    }

    protected void onReset() {
        PSDepSlnSysDynaInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSlnSysDynaInstBase pSDepSlnSysDynaInstBase) {
        pSDepSlnSysDynaInstBase.resetCreateDate();
        pSDepSlnSysDynaInstBase.resetCreateMan();
        pSDepSlnSysDynaInstBase.resetInstMode();
        pSDepSlnSysDynaInstBase.resetMemo();
        pSDepSlnSysDynaInstBase.resetPPSDepSlnSysDynaInstId();
        pSDepSlnSysDynaInstBase.resetPPSDepSlnSysDynaInstName();
        pSDepSlnSysDynaInstBase.resetProxyPSDepSlnSysDynaInstId();
        pSDepSlnSysDynaInstBase.resetProxyPSDepSlnSysDynaInstName();
        pSDepSlnSysDynaInstBase.resetPSDepSlnId();
        pSDepSlnSysDynaInstBase.resetPSDepSlnSysDynaInstId();
        pSDepSlnSysDynaInstBase.resetPSDepSlnSysDynaInstName();
        pSDepSlnSysDynaInstBase.resetPSDepSlnSysId();
        pSDepSlnSysDynaInstBase.resetPSDepSlnSysName();
        pSDepSlnSysDynaInstBase.resetUpdateDate();
        pSDepSlnSysDynaInstBase.resetUpdateMan();
        pSDepSlnSysDynaInstBase.resetUserTag();
        pSDepSlnSysDynaInstBase.resetUserTag2();
        pSDepSlnSysDynaInstBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isInstModeDirty()) {
            hashMap.put(FIELD_INSTMODE, this.getInstMode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPPSDepSlnSysDynaInstIdDirty()) {
            hashMap.put(FIELD_PPSDEPSLNSYSDYNAINSTID, this.getPPSDepSlnSysDynaInstId());
        }
        if (!bl || this.isPPSDepSlnSysDynaInstNameDirty()) {
            hashMap.put(FIELD_PPSDEPSLNSYSDYNAINSTNAME, this.getPPSDepSlnSysDynaInstName());
        }
        if (!bl || this.isProxyPSDepSlnSysDynaInstIdDirty()) {
            hashMap.put(FIELD_PROXYPSDEPSLNSYSDYNAINSTID, this.getProxyPSDepSlnSysDynaInstId());
        }
        if (!bl || this.isProxyPSDepSlnSysDynaInstNameDirty()) {
            hashMap.put(FIELD_PROXYPSDEPSLNSYSDYNAINSTNAME, this.getProxyPSDepSlnSysDynaInstName());
        }
        if (!bl || this.isPSDepSlnIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNID, this.getPSDepSlnId());
        }
        if (!bl || this.isPSDepSlnSysDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSDYNAINSTID, this.getPSDepSlnSysDynaInstId());
        }
        if (!bl || this.isPSDepSlnSysDynaInstNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSDYNAINSTNAME, this.getPSDepSlnSysDynaInstName());
        }
        if (!bl || this.isPSDepSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSID, this.getPSDepSlnSysId());
        }
        if (!bl || this.isPSDepSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSNAME, this.getPSDepSlnSysName());
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
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
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
        return PSDepSlnSysDynaInstBase.get(this, n);
    }

    private static Object get(PSDepSlnSysDynaInstBase pSDepSlnSysDynaInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysDynaInstBase.getCreateDate();
            }
            case 1: {
                return pSDepSlnSysDynaInstBase.getCreateMan();
            }
            case 2: {
                return pSDepSlnSysDynaInstBase.getInstMode();
            }
            case 3: {
                return pSDepSlnSysDynaInstBase.getMemo();
            }
            case 4: {
                return pSDepSlnSysDynaInstBase.getPPSDepSlnSysDynaInstId();
            }
            case 5: {
                return pSDepSlnSysDynaInstBase.getPPSDepSlnSysDynaInstName();
            }
            case 6: {
                return pSDepSlnSysDynaInstBase.getProxyPSDepSlnSysDynaInstId();
            }
            case 7: {
                return pSDepSlnSysDynaInstBase.getProxyPSDepSlnSysDynaInstName();
            }
            case 8: {
                return pSDepSlnSysDynaInstBase.getPSDepSlnId();
            }
            case 9: {
                return pSDepSlnSysDynaInstBase.getPSDepSlnSysDynaInstId();
            }
            case 10: {
                return pSDepSlnSysDynaInstBase.getPSDepSlnSysDynaInstName();
            }
            case 11: {
                return pSDepSlnSysDynaInstBase.getPSDepSlnSysId();
            }
            case 12: {
                return pSDepSlnSysDynaInstBase.getPSDepSlnSysName();
            }
            case 13: {
                return pSDepSlnSysDynaInstBase.getUpdateDate();
            }
            case 14: {
                return pSDepSlnSysDynaInstBase.getUpdateMan();
            }
            case 15: {
                return pSDepSlnSysDynaInstBase.getUserTag();
            }
            case 16: {
                return pSDepSlnSysDynaInstBase.getUserTag2();
            }
            case 17: {
                return pSDepSlnSysDynaInstBase.getValidFlag();
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
        PSDepSlnSysDynaInstBase.set(this, n, object);
    }

    private static void set(PSDepSlnSysDynaInstBase pSDepSlnSysDynaInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnSysDynaInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDepSlnSysDynaInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDepSlnSysDynaInstBase.setInstMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSlnSysDynaInstBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepSlnSysDynaInstBase.setPPSDepSlnSysDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDepSlnSysDynaInstBase.setPPSDepSlnSysDynaInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDepSlnSysDynaInstBase.setProxyPSDepSlnSysDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDepSlnSysDynaInstBase.setProxyPSDepSlnSysDynaInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDepSlnSysDynaInstBase.setPSDepSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDepSlnSysDynaInstBase.setPSDepSlnSysDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDepSlnSysDynaInstBase.setPSDepSlnSysDynaInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDepSlnSysDynaInstBase.setPSDepSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDepSlnSysDynaInstBase.setPSDepSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDepSlnSysDynaInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSDepSlnSysDynaInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDepSlnSysDynaInstBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDepSlnSysDynaInstBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDepSlnSysDynaInstBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDepSlnSysDynaInstBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSlnSysDynaInstBase pSDepSlnSysDynaInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysDynaInstBase.getCreateDate() == null;
            }
            case 1: {
                return pSDepSlnSysDynaInstBase.getCreateMan() == null;
            }
            case 2: {
                return pSDepSlnSysDynaInstBase.getInstMode() == null;
            }
            case 3: {
                return pSDepSlnSysDynaInstBase.getMemo() == null;
            }
            case 4: {
                return pSDepSlnSysDynaInstBase.getPPSDepSlnSysDynaInstId() == null;
            }
            case 5: {
                return pSDepSlnSysDynaInstBase.getPPSDepSlnSysDynaInstName() == null;
            }
            case 6: {
                return pSDepSlnSysDynaInstBase.getProxyPSDepSlnSysDynaInstId() == null;
            }
            case 7: {
                return pSDepSlnSysDynaInstBase.getProxyPSDepSlnSysDynaInstName() == null;
            }
            case 8: {
                return pSDepSlnSysDynaInstBase.getPSDepSlnId() == null;
            }
            case 9: {
                return pSDepSlnSysDynaInstBase.getPSDepSlnSysDynaInstId() == null;
            }
            case 10: {
                return pSDepSlnSysDynaInstBase.getPSDepSlnSysDynaInstName() == null;
            }
            case 11: {
                return pSDepSlnSysDynaInstBase.getPSDepSlnSysId() == null;
            }
            case 12: {
                return pSDepSlnSysDynaInstBase.getPSDepSlnSysName() == null;
            }
            case 13: {
                return pSDepSlnSysDynaInstBase.getUpdateDate() == null;
            }
            case 14: {
                return pSDepSlnSysDynaInstBase.getUpdateMan() == null;
            }
            case 15: {
                return pSDepSlnSysDynaInstBase.getUserTag() == null;
            }
            case 16: {
                return pSDepSlnSysDynaInstBase.getUserTag2() == null;
            }
            case 17: {
                return pSDepSlnSysDynaInstBase.getValidFlag() == null;
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
        return PSDepSlnSysDynaInstBase.contains(this, n);
    }

    private static boolean contains(PSDepSlnSysDynaInstBase pSDepSlnSysDynaInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysDynaInstBase.isCreateDateDirty();
            }
            case 1: {
                return pSDepSlnSysDynaInstBase.isCreateManDirty();
            }
            case 2: {
                return pSDepSlnSysDynaInstBase.isInstModeDirty();
            }
            case 3: {
                return pSDepSlnSysDynaInstBase.isMemoDirty();
            }
            case 4: {
                return pSDepSlnSysDynaInstBase.isPPSDepSlnSysDynaInstIdDirty();
            }
            case 5: {
                return pSDepSlnSysDynaInstBase.isPPSDepSlnSysDynaInstNameDirty();
            }
            case 6: {
                return pSDepSlnSysDynaInstBase.isProxyPSDepSlnSysDynaInstIdDirty();
            }
            case 7: {
                return pSDepSlnSysDynaInstBase.isProxyPSDepSlnSysDynaInstNameDirty();
            }
            case 8: {
                return pSDepSlnSysDynaInstBase.isPSDepSlnIdDirty();
            }
            case 9: {
                return pSDepSlnSysDynaInstBase.isPSDepSlnSysDynaInstIdDirty();
            }
            case 10: {
                return pSDepSlnSysDynaInstBase.isPSDepSlnSysDynaInstNameDirty();
            }
            case 11: {
                return pSDepSlnSysDynaInstBase.isPSDepSlnSysIdDirty();
            }
            case 12: {
                return pSDepSlnSysDynaInstBase.isPSDepSlnSysNameDirty();
            }
            case 13: {
                return pSDepSlnSysDynaInstBase.isUpdateDateDirty();
            }
            case 14: {
                return pSDepSlnSysDynaInstBase.isUpdateManDirty();
            }
            case 15: {
                return pSDepSlnSysDynaInstBase.isUserTagDirty();
            }
            case 16: {
                return pSDepSlnSysDynaInstBase.isUserTag2Dirty();
            }
            case 17: {
                return pSDepSlnSysDynaInstBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSlnSysDynaInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSlnSysDynaInstBase pSDepSlnSysDynaInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSlnSysDynaInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSlnSysDynaInstBase.getJSONValue((Object)pSDepSlnSysDynaInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSlnSysDynaInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSlnSysDynaInstBase.getJSONValue((Object)pSDepSlnSysDynaInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSlnSysDynaInstBase.getInstMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"instmode", (Object)PSDepSlnSysDynaInstBase.getJSONValue((Object)pSDepSlnSysDynaInstBase.getInstMode()), (boolean)false);
        }
        if (bl || pSDepSlnSysDynaInstBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDepSlnSysDynaInstBase.getJSONValue((Object)pSDepSlnSysDynaInstBase.getMemo()), (boolean)false);
        }
        if (bl || pSDepSlnSysDynaInstBase.getPPSDepSlnSysDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdepslnsysdynainstid", (Object)PSDepSlnSysDynaInstBase.getJSONValue((Object)pSDepSlnSysDynaInstBase.getPPSDepSlnSysDynaInstId()), (boolean)false);
        }
        if (bl || pSDepSlnSysDynaInstBase.getPPSDepSlnSysDynaInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdepslnsysdynainstname", (Object)PSDepSlnSysDynaInstBase.getJSONValue((Object)pSDepSlnSysDynaInstBase.getPPSDepSlnSysDynaInstName()), (boolean)false);
        }
        if (bl || pSDepSlnSysDynaInstBase.getProxyPSDepSlnSysDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"proxypsdepslnsysdynainstid", (Object)PSDepSlnSysDynaInstBase.getJSONValue((Object)pSDepSlnSysDynaInstBase.getProxyPSDepSlnSysDynaInstId()), (boolean)false);
        }
        if (bl || pSDepSlnSysDynaInstBase.getProxyPSDepSlnSysDynaInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"proxypsdepslnsysdynainstname", (Object)PSDepSlnSysDynaInstBase.getJSONValue((Object)pSDepSlnSysDynaInstBase.getProxyPSDepSlnSysDynaInstName()), (boolean)false);
        }
        if (bl || pSDepSlnSysDynaInstBase.getPSDepSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnid", (Object)PSDepSlnSysDynaInstBase.getJSONValue((Object)pSDepSlnSysDynaInstBase.getPSDepSlnId()), (boolean)false);
        }
        if (bl || pSDepSlnSysDynaInstBase.getPSDepSlnSysDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysdynainstid", (Object)PSDepSlnSysDynaInstBase.getJSONValue((Object)pSDepSlnSysDynaInstBase.getPSDepSlnSysDynaInstId()), (boolean)false);
        }
        if (bl || pSDepSlnSysDynaInstBase.getPSDepSlnSysDynaInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysdynainstname", (Object)PSDepSlnSysDynaInstBase.getJSONValue((Object)pSDepSlnSysDynaInstBase.getPSDepSlnSysDynaInstName()), (boolean)false);
        }
        if (bl || pSDepSlnSysDynaInstBase.getPSDepSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysid", (Object)PSDepSlnSysDynaInstBase.getJSONValue((Object)pSDepSlnSysDynaInstBase.getPSDepSlnSysId()), (boolean)false);
        }
        if (bl || pSDepSlnSysDynaInstBase.getPSDepSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysname", (Object)PSDepSlnSysDynaInstBase.getJSONValue((Object)pSDepSlnSysDynaInstBase.getPSDepSlnSysName()), (boolean)false);
        }
        if (bl || pSDepSlnSysDynaInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSlnSysDynaInstBase.getJSONValue((Object)pSDepSlnSysDynaInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSlnSysDynaInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSlnSysDynaInstBase.getJSONValue((Object)pSDepSlnSysDynaInstBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDepSlnSysDynaInstBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDepSlnSysDynaInstBase.getJSONValue((Object)pSDepSlnSysDynaInstBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDepSlnSysDynaInstBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDepSlnSysDynaInstBase.getJSONValue((Object)pSDepSlnSysDynaInstBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDepSlnSysDynaInstBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDepSlnSysDynaInstBase.getJSONValue((Object)pSDepSlnSysDynaInstBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSlnSysDynaInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSlnSysDynaInstBase pSDepSlnSysDynaInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSlnSysDynaInstBase.getCreateDate() != null) {
            object = pSDepSlnSysDynaInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnSysDynaInstBase.getCreateMan() != null) {
            object = pSDepSlnSysDynaInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysDynaInstBase.getInstMode() != null) {
            object = pSDepSlnSysDynaInstBase.getInstMode();
            xmlNode.setAttribute(FIELD_INSTMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysDynaInstBase.getMemo() != null) {
            object = pSDepSlnSysDynaInstBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysDynaInstBase.getPPSDepSlnSysDynaInstId() != null) {
            object = pSDepSlnSysDynaInstBase.getPPSDepSlnSysDynaInstId();
            xmlNode.setAttribute(FIELD_PPSDEPSLNSYSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysDynaInstBase.getPPSDepSlnSysDynaInstName() != null) {
            object = pSDepSlnSysDynaInstBase.getPPSDepSlnSysDynaInstName();
            xmlNode.setAttribute(FIELD_PPSDEPSLNSYSDYNAINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysDynaInstBase.getProxyPSDepSlnSysDynaInstId() != null) {
            object = pSDepSlnSysDynaInstBase.getProxyPSDepSlnSysDynaInstId();
            xmlNode.setAttribute(FIELD_PROXYPSDEPSLNSYSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysDynaInstBase.getProxyPSDepSlnSysDynaInstName() != null) {
            object = pSDepSlnSysDynaInstBase.getProxyPSDepSlnSysDynaInstName();
            xmlNode.setAttribute(FIELD_PROXYPSDEPSLNSYSDYNAINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysDynaInstBase.getPSDepSlnId() != null) {
            object = pSDepSlnSysDynaInstBase.getPSDepSlnId();
            xmlNode.setAttribute(FIELD_PSDEPSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysDynaInstBase.getPSDepSlnSysDynaInstId() != null) {
            object = pSDepSlnSysDynaInstBase.getPSDepSlnSysDynaInstId();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysDynaInstBase.getPSDepSlnSysDynaInstName() != null) {
            object = pSDepSlnSysDynaInstBase.getPSDepSlnSysDynaInstName();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSDYNAINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysDynaInstBase.getPSDepSlnSysId() != null) {
            object = pSDepSlnSysDynaInstBase.getPSDepSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysDynaInstBase.getPSDepSlnSysName() != null) {
            object = pSDepSlnSysDynaInstBase.getPSDepSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysDynaInstBase.getUpdateDate() != null) {
            object = pSDepSlnSysDynaInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnSysDynaInstBase.getUpdateMan() != null) {
            object = pSDepSlnSysDynaInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysDynaInstBase.getUserTag() != null) {
            object = pSDepSlnSysDynaInstBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysDynaInstBase.getUserTag2() != null) {
            object = pSDepSlnSysDynaInstBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysDynaInstBase.getValidFlag() != null) {
            object = pSDepSlnSysDynaInstBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSlnSysDynaInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSlnSysDynaInstBase pSDepSlnSysDynaInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSlnSysDynaInstBase.isCreateDateDirty() && (bl || pSDepSlnSysDynaInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSlnSysDynaInstBase.getCreateDate());
        }
        if (pSDepSlnSysDynaInstBase.isCreateManDirty() && (bl || pSDepSlnSysDynaInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSlnSysDynaInstBase.getCreateMan());
        }
        if (pSDepSlnSysDynaInstBase.isInstModeDirty() && (bl || pSDepSlnSysDynaInstBase.getInstMode() != null)) {
            iDataObject.set(FIELD_INSTMODE, (Object)pSDepSlnSysDynaInstBase.getInstMode());
        }
        if (pSDepSlnSysDynaInstBase.isMemoDirty() && (bl || pSDepSlnSysDynaInstBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDepSlnSysDynaInstBase.getMemo());
        }
        if (pSDepSlnSysDynaInstBase.isPPSDepSlnSysDynaInstIdDirty() && (bl || pSDepSlnSysDynaInstBase.getPPSDepSlnSysDynaInstId() != null)) {
            iDataObject.set(FIELD_PPSDEPSLNSYSDYNAINSTID, (Object)pSDepSlnSysDynaInstBase.getPPSDepSlnSysDynaInstId());
        }
        if (pSDepSlnSysDynaInstBase.isPPSDepSlnSysDynaInstNameDirty() && (bl || pSDepSlnSysDynaInstBase.getPPSDepSlnSysDynaInstName() != null)) {
            iDataObject.set(FIELD_PPSDEPSLNSYSDYNAINSTNAME, (Object)pSDepSlnSysDynaInstBase.getPPSDepSlnSysDynaInstName());
        }
        if (pSDepSlnSysDynaInstBase.isProxyPSDepSlnSysDynaInstIdDirty() && (bl || pSDepSlnSysDynaInstBase.getProxyPSDepSlnSysDynaInstId() != null)) {
            iDataObject.set(FIELD_PROXYPSDEPSLNSYSDYNAINSTID, (Object)pSDepSlnSysDynaInstBase.getProxyPSDepSlnSysDynaInstId());
        }
        if (pSDepSlnSysDynaInstBase.isProxyPSDepSlnSysDynaInstNameDirty() && (bl || pSDepSlnSysDynaInstBase.getProxyPSDepSlnSysDynaInstName() != null)) {
            iDataObject.set(FIELD_PROXYPSDEPSLNSYSDYNAINSTNAME, (Object)pSDepSlnSysDynaInstBase.getProxyPSDepSlnSysDynaInstName());
        }
        if (pSDepSlnSysDynaInstBase.isPSDepSlnIdDirty() && (bl || pSDepSlnSysDynaInstBase.getPSDepSlnId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNID, (Object)pSDepSlnSysDynaInstBase.getPSDepSlnId());
        }
        if (pSDepSlnSysDynaInstBase.isPSDepSlnSysDynaInstIdDirty() && (bl || pSDepSlnSysDynaInstBase.getPSDepSlnSysDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSDYNAINSTID, (Object)pSDepSlnSysDynaInstBase.getPSDepSlnSysDynaInstId());
        }
        if (pSDepSlnSysDynaInstBase.isPSDepSlnSysDynaInstNameDirty() && (bl || pSDepSlnSysDynaInstBase.getPSDepSlnSysDynaInstName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSDYNAINSTNAME, (Object)pSDepSlnSysDynaInstBase.getPSDepSlnSysDynaInstName());
        }
        if (pSDepSlnSysDynaInstBase.isPSDepSlnSysIdDirty() && (bl || pSDepSlnSysDynaInstBase.getPSDepSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSID, (Object)pSDepSlnSysDynaInstBase.getPSDepSlnSysId());
        }
        if (pSDepSlnSysDynaInstBase.isPSDepSlnSysNameDirty() && (bl || pSDepSlnSysDynaInstBase.getPSDepSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSNAME, (Object)pSDepSlnSysDynaInstBase.getPSDepSlnSysName());
        }
        if (pSDepSlnSysDynaInstBase.isUpdateDateDirty() && (bl || pSDepSlnSysDynaInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSlnSysDynaInstBase.getUpdateDate());
        }
        if (pSDepSlnSysDynaInstBase.isUpdateManDirty() && (bl || pSDepSlnSysDynaInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSlnSysDynaInstBase.getUpdateMan());
        }
        if (pSDepSlnSysDynaInstBase.isUserTagDirty() && (bl || pSDepSlnSysDynaInstBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDepSlnSysDynaInstBase.getUserTag());
        }
        if (pSDepSlnSysDynaInstBase.isUserTag2Dirty() && (bl || pSDepSlnSysDynaInstBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDepSlnSysDynaInstBase.getUserTag2());
        }
        if (pSDepSlnSysDynaInstBase.isValidFlagDirty() && (bl || pSDepSlnSysDynaInstBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDepSlnSysDynaInstBase.getValidFlag());
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
        return PSDepSlnSysDynaInstBase.remove(this, n);
    }

    private static boolean remove(PSDepSlnSysDynaInstBase pSDepSlnSysDynaInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnSysDynaInstBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDepSlnSysDynaInstBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDepSlnSysDynaInstBase.resetInstMode();
                return true;
            }
            case 3: {
                pSDepSlnSysDynaInstBase.resetMemo();
                return true;
            }
            case 4: {
                pSDepSlnSysDynaInstBase.resetPPSDepSlnSysDynaInstId();
                return true;
            }
            case 5: {
                pSDepSlnSysDynaInstBase.resetPPSDepSlnSysDynaInstName();
                return true;
            }
            case 6: {
                pSDepSlnSysDynaInstBase.resetProxyPSDepSlnSysDynaInstId();
                return true;
            }
            case 7: {
                pSDepSlnSysDynaInstBase.resetProxyPSDepSlnSysDynaInstName();
                return true;
            }
            case 8: {
                pSDepSlnSysDynaInstBase.resetPSDepSlnId();
                return true;
            }
            case 9: {
                pSDepSlnSysDynaInstBase.resetPSDepSlnSysDynaInstId();
                return true;
            }
            case 10: {
                pSDepSlnSysDynaInstBase.resetPSDepSlnSysDynaInstName();
                return true;
            }
            case 11: {
                pSDepSlnSysDynaInstBase.resetPSDepSlnSysId();
                return true;
            }
            case 12: {
                pSDepSlnSysDynaInstBase.resetPSDepSlnSysName();
                return true;
            }
            case 13: {
                pSDepSlnSysDynaInstBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSDepSlnSysDynaInstBase.resetUpdateMan();
                return true;
            }
            case 15: {
                pSDepSlnSysDynaInstBase.resetUserTag();
                return true;
            }
            case 16: {
                pSDepSlnSysDynaInstBase.resetUserTag2();
                return true;
            }
            case 17: {
                pSDepSlnSysDynaInstBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSlnSysDynaInst getPPSDepSlnSysDynaInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDepSlnSysDynaInst();
        }
        if (this.getPPSDepSlnSysDynaInstId() == null) {
            return null;
        }
        Integer n = this.objPPSDepSlnSysDynaInstLock;
        synchronized (n) {
            if (this.ppsdepslnsysdynainst != null && DataTypeHelper.compare((int)25, (Object)this.getPPSDepSlnSysDynaInstId(), (Object)this.ppsdepslnsysdynainst.getPSDepSlnSysDynaInstId()) != 0L) {
                this.ppsdepslnsysdynainst = null;
            }
            if (this.ppsdepslnsysdynainst == null) {
                PSDepSlnSysDynaInst pSDepSlnSysDynaInst = new PSDepSlnSysDynaInst();
                pSDepSlnSysDynaInst.setPSDepSlnSysDynaInstId(this.getPPSDepSlnSysDynaInstId());
                PSDepSlnSysDynaInstService pSDepSlnSysDynaInstService = (PSDepSlnSysDynaInstService)ServiceGlobal.getService(PSDepSlnSysDynaInstService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnSysDynaInstService.autoGet(pSDepSlnSysDynaInst);
                this.ppsdepslnsysdynainst = pSDepSlnSysDynaInst;
            }
            return this.ppsdepslnsysdynainst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSlnSysDynaInst getProxyPSDepSlnSysDynaInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getProxyPSDepSlnSysDynaInst();
        }
        if (this.getProxyPSDepSlnSysDynaInstId() == null) {
            return null;
        }
        Integer n = this.objProxyPSDepSlnSysDynaInstLock;
        synchronized (n) {
            if (this.proxypsdepslnsysdynainst != null && DataTypeHelper.compare((int)25, (Object)this.getProxyPSDepSlnSysDynaInstId(), (Object)this.proxypsdepslnsysdynainst.getPSDepSlnSysDynaInstId()) != 0L) {
                this.proxypsdepslnsysdynainst = null;
            }
            if (this.proxypsdepslnsysdynainst == null) {
                PSDepSlnSysDynaInst pSDepSlnSysDynaInst = new PSDepSlnSysDynaInst();
                pSDepSlnSysDynaInst.setPSDepSlnSysDynaInstId(this.getProxyPSDepSlnSysDynaInstId());
                PSDepSlnSysDynaInstService pSDepSlnSysDynaInstService = (PSDepSlnSysDynaInstService)ServiceGlobal.getService(PSDepSlnSysDynaInstService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnSysDynaInstService.autoGet(pSDepSlnSysDynaInst);
                this.proxypsdepslnsysdynainst = pSDepSlnSysDynaInst;
            }
            return this.proxypsdepslnsysdynainst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSlnSys getPSDepSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSys();
        }
        if (this.getPSDepSlnSysId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnSysLock;
        synchronized (n) {
            if (this.psdepslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnSysId(), (Object)this.psdepslnsys.getPSDepSlnSysId()) != 0L) {
                this.psdepslnsys = null;
            }
            if (this.psdepslnsys == null) {
                PSDepSlnSys pSDepSlnSys = new PSDepSlnSys();
                pSDepSlnSys.setPSDepSlnSysId(this.getPSDepSlnSysId());
                PSDepSlnSysService pSDepSlnSysService = (PSDepSlnSysService)ServiceGlobal.getService(PSDepSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnSysService.autoGet(pSDepSlnSys);
                this.psdepslnsys = pSDepSlnSys;
            }
            return this.psdepslnsys;
        }
    }

    private PSDepSlnSysDynaInstBase getProxyEntity() {
        return this.proxyPSDepSlnSysDynaInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSlnSysDynaInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSlnSysDynaInstBase) {
            this.proxyPSDepSlnSysDynaInstBase = (PSDepSlnSysDynaInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysDynaInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_INSTMODE, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PPSDEPSLNSYSDYNAINSTID, 4);
        fieldIndexMap.put(FIELD_PPSDEPSLNSYSDYNAINSTNAME, 5);
        fieldIndexMap.put(FIELD_PROXYPSDEPSLNSYSDYNAINSTID, 6);
        fieldIndexMap.put(FIELD_PROXYPSDEPSLNSYSDYNAINSTNAME, 7);
        fieldIndexMap.put(FIELD_PSDEPSLNID, 8);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSDYNAINSTID, 9);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSDYNAINSTNAME, 10);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSID, 11);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSNAME, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
        fieldIndexMap.put(FIELD_USERTAG, 15);
        fieldIndexMap.put(FIELD_USERTAG2, 16);
        fieldIndexMap.put(FIELD_VALIDFLAG, 17);
    }
}

