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
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaAppViewInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEFormInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaSys;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaWFVerInst;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppViewInstService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormInstService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaSysService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaWFVerInstService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDynaInstBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_INSTMODE = "INSTMODE";
    public static final String FIELD_INSTVER = "INSTVER";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PPSDYNAINSTID = "PPSDYNAINSTID";
    public static final String FIELD_PPSDYNAINSTNAME = "PPSDYNAINSTNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSDYNAINSTNAME = "PSDYNAINSTNAME";
    public static final String FIELD_PSDYNASYSID = "PSDYNASYSID";
    public static final String FIELD_PSDYNASYSNAME = "PSDYNASYSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_INSTMODE = 2;
    private static final int INDEX_INSTVER = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PPSDYNAINSTID = 5;
    private static final int INDEX_PPSDYNAINSTNAME = 6;
    private static final int INDEX_PSDEVSLNSYSID = 7;
    private static final int INDEX_PSDYNAINSTID = 8;
    private static final int INDEX_PSDYNAINSTNAME = 9;
    private static final int INDEX_PSDYNASYSID = 10;
    private static final int INDEX_PSDYNASYSNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_USERTAG = 14;
    private static final int INDEX_USERTAG2 = 15;
    private static final int INDEX_VALIDFLAG = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDynaInstBase proxyPSDynaInstBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean instmodeDirtyFlag = false;
    private boolean instverDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ppsdynainstidDirtyFlag = false;
    private boolean ppsdynainstnameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psdynainstnameDirtyFlag = false;
    private boolean psdynasysidDirtyFlag = false;
    private boolean psdynasysnameDirtyFlag = false;
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
    @Column(name="instver")
    private Integer instver;
    @Column(name="memo")
    private String memo;
    @Column(name="ppsdynainstid")
    private String ppsdynainstid;
    @Column(name="ppsdynainstname")
    private String ppsdynainstname;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psdynainstname")
    private String psdynainstname;
    @Column(name="psdynasysid")
    private String psdynasysid;
    @Column(name="psdynasysname")
    private String psdynasysname;
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
    private Integer objPSDynaSysLock = new Integer(1);
    private PSDynaSys psdynasys = null;
    private Integer objPSCodeListsLock = new Integer(1);
    private ArrayList<PSCodeList> pscodelists = null;
    private Integer objPSDynaAppViewInstsLock = new Integer(1);
    private ArrayList<PSDynaAppViewInst> psdynaappviewinsts = null;
    private Integer objPSDynaDEFormInstsLock = new Integer(1);
    private ArrayList<PSDynaDEFormInst> psdynadeforminsts = null;
    private Integer objPSDynaWFVerInstsLock = new Integer(1);
    private ArrayList<PSDynaWFVerInst> psdynawfverinsts = null;

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

    public void setInstVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstVer(n);
            return;
        }
        this.instver = n;
        this.instverDirtyFlag = true;
    }

    public Integer getInstVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstVer();
        }
        return this.instver;
    }

    public boolean isInstVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstVerDirty();
        }
        return this.instverDirtyFlag;
    }

    public void resetInstVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstVer();
            return;
        }
        this.instverDirtyFlag = false;
        this.instver = null;
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

    public void setPPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdynainstid = string;
        this.ppsdynainstidDirtyFlag = true;
    }

    public String getPPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDynaInstId();
        }
        return this.ppsdynainstid;
    }

    public boolean isPPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDynaInstIdDirty();
        }
        return this.ppsdynainstidDirtyFlag;
    }

    public void resetPPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDynaInstId();
            return;
        }
        this.ppsdynainstidDirtyFlag = false;
        this.ppsdynainstid = null;
    }

    public void setPPSDynaInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDynaInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdynainstname = string;
        this.ppsdynainstnameDirtyFlag = true;
    }

    public String getPPSDynaInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDynaInstName();
        }
        return this.ppsdynainstname;
    }

    public boolean isPPSDynaInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDynaInstNameDirty();
        }
        return this.ppsdynainstnameDirtyFlag;
    }

    public void resetPPSDynaInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDynaInstName();
            return;
        }
        this.ppsdynainstnameDirtyFlag = false;
        this.ppsdynainstname = null;
    }

    public void setPSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysid = string;
        this.psdevslnsysidDirtyFlag = true;
    }

    public String getPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysId();
        }
        return this.psdevslnsysid;
    }

    public boolean isPSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysIdDirty();
        }
        return this.psdevslnsysidDirtyFlag;
    }

    public void resetPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysId();
            return;
        }
        this.psdevslnsysidDirtyFlag = false;
        this.psdevslnsysid = null;
    }

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
    }

    public void setPSDynaInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstname = string;
        this.psdynainstnameDirtyFlag = true;
    }

    public String getPSDynaInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstName();
        }
        return this.psdynainstname;
    }

    public boolean isPSDynaInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstNameDirty();
        }
        return this.psdynainstnameDirtyFlag;
    }

    public void resetPSDynaInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstName();
            return;
        }
        this.psdynainstnameDirtyFlag = false;
        this.psdynainstname = null;
    }

    public void setPSDynaSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynasysid = string;
        this.psdynasysidDirtyFlag = true;
    }

    public String getPSDynaSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaSysId();
        }
        return this.psdynasysid;
    }

    public boolean isPSDynaSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaSysIdDirty();
        }
        return this.psdynasysidDirtyFlag;
    }

    public void resetPSDynaSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaSysId();
            return;
        }
        this.psdynasysidDirtyFlag = false;
        this.psdynasysid = null;
    }

    public void setPSDynaSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynasysname = string;
        this.psdynasysnameDirtyFlag = true;
    }

    public String getPSDynaSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaSysName();
        }
        return this.psdynasysname;
    }

    public boolean isPSDynaSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaSysNameDirty();
        }
        return this.psdynasysnameDirtyFlag;
    }

    public void resetPSDynaSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaSysName();
            return;
        }
        this.psdynasysnameDirtyFlag = false;
        this.psdynasysname = null;
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
        PSDynaInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDynaInstBase pSDynaInstBase) {
        pSDynaInstBase.resetCreateDate();
        pSDynaInstBase.resetCreateMan();
        pSDynaInstBase.resetInstMode();
        pSDynaInstBase.resetInstVer();
        pSDynaInstBase.resetMemo();
        pSDynaInstBase.resetPPSDynaInstId();
        pSDynaInstBase.resetPPSDynaInstName();
        pSDynaInstBase.resetPSDevSlnSysId();
        pSDynaInstBase.resetPSDynaInstId();
        pSDynaInstBase.resetPSDynaInstName();
        pSDynaInstBase.resetPSDynaSysId();
        pSDynaInstBase.resetPSDynaSysName();
        pSDynaInstBase.resetUpdateDate();
        pSDynaInstBase.resetUpdateMan();
        pSDynaInstBase.resetUserTag();
        pSDynaInstBase.resetUserTag2();
        pSDynaInstBase.resetValidFlag();
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
        if (!bl || this.isInstVerDirty()) {
            hashMap.put(FIELD_INSTVER, this.getInstVer());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PPSDYNAINSTID, this.getPPSDynaInstId());
        }
        if (!bl || this.isPPSDynaInstNameDirty()) {
            hashMap.put(FIELD_PPSDYNAINSTNAME, this.getPPSDynaInstName());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSDynaInstNameDirty()) {
            hashMap.put(FIELD_PSDYNAINSTNAME, this.getPSDynaInstName());
        }
        if (!bl || this.isPSDynaSysIdDirty()) {
            hashMap.put(FIELD_PSDYNASYSID, this.getPSDynaSysId());
        }
        if (!bl || this.isPSDynaSysNameDirty()) {
            hashMap.put(FIELD_PSDYNASYSNAME, this.getPSDynaSysName());
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
        return PSDynaInstBase.get(this, n);
    }

    private static Object get(PSDynaInstBase pSDynaInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaInstBase.getCreateDate();
            }
            case 1: {
                return pSDynaInstBase.getCreateMan();
            }
            case 2: {
                return pSDynaInstBase.getInstMode();
            }
            case 3: {
                return pSDynaInstBase.getInstVer();
            }
            case 4: {
                return pSDynaInstBase.getMemo();
            }
            case 5: {
                return pSDynaInstBase.getPPSDynaInstId();
            }
            case 6: {
                return pSDynaInstBase.getPPSDynaInstName();
            }
            case 7: {
                return pSDynaInstBase.getPSDevSlnSysId();
            }
            case 8: {
                return pSDynaInstBase.getPSDynaInstId();
            }
            case 9: {
                return pSDynaInstBase.getPSDynaInstName();
            }
            case 10: {
                return pSDynaInstBase.getPSDynaSysId();
            }
            case 11: {
                return pSDynaInstBase.getPSDynaSysName();
            }
            case 12: {
                return pSDynaInstBase.getUpdateDate();
            }
            case 13: {
                return pSDynaInstBase.getUpdateMan();
            }
            case 14: {
                return pSDynaInstBase.getUserTag();
            }
            case 15: {
                return pSDynaInstBase.getUserTag2();
            }
            case 16: {
                return pSDynaInstBase.getValidFlag();
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
        PSDynaInstBase.set(this, n, object);
    }

    private static void set(PSDynaInstBase pSDynaInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDynaInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDynaInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDynaInstBase.setInstMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDynaInstBase.setInstVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDynaInstBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDynaInstBase.setPPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDynaInstBase.setPPSDynaInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDynaInstBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDynaInstBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDynaInstBase.setPSDynaInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDynaInstBase.setPSDynaSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDynaInstBase.setPSDynaSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDynaInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSDynaInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDynaInstBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDynaInstBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDynaInstBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDynaInstBase.isNull(this, n);
    }

    private static boolean isNull(PSDynaInstBase pSDynaInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaInstBase.getCreateDate() == null;
            }
            case 1: {
                return pSDynaInstBase.getCreateMan() == null;
            }
            case 2: {
                return pSDynaInstBase.getInstMode() == null;
            }
            case 3: {
                return pSDynaInstBase.getInstVer() == null;
            }
            case 4: {
                return pSDynaInstBase.getMemo() == null;
            }
            case 5: {
                return pSDynaInstBase.getPPSDynaInstId() == null;
            }
            case 6: {
                return pSDynaInstBase.getPPSDynaInstName() == null;
            }
            case 7: {
                return pSDynaInstBase.getPSDevSlnSysId() == null;
            }
            case 8: {
                return pSDynaInstBase.getPSDynaInstId() == null;
            }
            case 9: {
                return pSDynaInstBase.getPSDynaInstName() == null;
            }
            case 10: {
                return pSDynaInstBase.getPSDynaSysId() == null;
            }
            case 11: {
                return pSDynaInstBase.getPSDynaSysName() == null;
            }
            case 12: {
                return pSDynaInstBase.getUpdateDate() == null;
            }
            case 13: {
                return pSDynaInstBase.getUpdateMan() == null;
            }
            case 14: {
                return pSDynaInstBase.getUserTag() == null;
            }
            case 15: {
                return pSDynaInstBase.getUserTag2() == null;
            }
            case 16: {
                return pSDynaInstBase.getValidFlag() == null;
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
        return PSDynaInstBase.contains(this, n);
    }

    private static boolean contains(PSDynaInstBase pSDynaInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaInstBase.isCreateDateDirty();
            }
            case 1: {
                return pSDynaInstBase.isCreateManDirty();
            }
            case 2: {
                return pSDynaInstBase.isInstModeDirty();
            }
            case 3: {
                return pSDynaInstBase.isInstVerDirty();
            }
            case 4: {
                return pSDynaInstBase.isMemoDirty();
            }
            case 5: {
                return pSDynaInstBase.isPPSDynaInstIdDirty();
            }
            case 6: {
                return pSDynaInstBase.isPPSDynaInstNameDirty();
            }
            case 7: {
                return pSDynaInstBase.isPSDevSlnSysIdDirty();
            }
            case 8: {
                return pSDynaInstBase.isPSDynaInstIdDirty();
            }
            case 9: {
                return pSDynaInstBase.isPSDynaInstNameDirty();
            }
            case 10: {
                return pSDynaInstBase.isPSDynaSysIdDirty();
            }
            case 11: {
                return pSDynaInstBase.isPSDynaSysNameDirty();
            }
            case 12: {
                return pSDynaInstBase.isUpdateDateDirty();
            }
            case 13: {
                return pSDynaInstBase.isUpdateManDirty();
            }
            case 14: {
                return pSDynaInstBase.isUserTagDirty();
            }
            case 15: {
                return pSDynaInstBase.isUserTag2Dirty();
            }
            case 16: {
                return pSDynaInstBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDynaInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDynaInstBase pSDynaInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDynaInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDynaInstBase.getJSONValue((Object)pSDynaInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDynaInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDynaInstBase.getJSONValue((Object)pSDynaInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDynaInstBase.getInstMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"instmode", (Object)PSDynaInstBase.getJSONValue((Object)pSDynaInstBase.getInstMode()), (boolean)false);
        }
        if (bl || pSDynaInstBase.getInstVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"instver", (Object)PSDynaInstBase.getJSONValue((Object)pSDynaInstBase.getInstVer()), (boolean)false);
        }
        if (bl || pSDynaInstBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDynaInstBase.getJSONValue((Object)pSDynaInstBase.getMemo()), (boolean)false);
        }
        if (bl || pSDynaInstBase.getPPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdynainstid", (Object)PSDynaInstBase.getJSONValue((Object)pSDynaInstBase.getPPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDynaInstBase.getPPSDynaInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdynainstname", (Object)PSDynaInstBase.getJSONValue((Object)pSDynaInstBase.getPPSDynaInstName()), (boolean)false);
        }
        if (bl || pSDynaInstBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDynaInstBase.getJSONValue((Object)pSDynaInstBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDynaInstBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDynaInstBase.getJSONValue((Object)pSDynaInstBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDynaInstBase.getPSDynaInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstname", (Object)PSDynaInstBase.getJSONValue((Object)pSDynaInstBase.getPSDynaInstName()), (boolean)false);
        }
        if (bl || pSDynaInstBase.getPSDynaSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynasysid", (Object)PSDynaInstBase.getJSONValue((Object)pSDynaInstBase.getPSDynaSysId()), (boolean)false);
        }
        if (bl || pSDynaInstBase.getPSDynaSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynasysname", (Object)PSDynaInstBase.getJSONValue((Object)pSDynaInstBase.getPSDynaSysName()), (boolean)false);
        }
        if (bl || pSDynaInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDynaInstBase.getJSONValue((Object)pSDynaInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDynaInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDynaInstBase.getJSONValue((Object)pSDynaInstBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDynaInstBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDynaInstBase.getJSONValue((Object)pSDynaInstBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDynaInstBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDynaInstBase.getJSONValue((Object)pSDynaInstBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDynaInstBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDynaInstBase.getJSONValue((Object)pSDynaInstBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDynaInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDynaInstBase pSDynaInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDynaInstBase.getCreateDate() != null) {
            object = pSDynaInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaInstBase.getCreateMan() != null) {
            object = pSDynaInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDynaInstBase.getInstMode() != null) {
            object = pSDynaInstBase.getInstMode();
            xmlNode.setAttribute(FIELD_INSTMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDynaInstBase.getInstVer() != null) {
            object = pSDynaInstBase.getInstVer();
            xmlNode.setAttribute(FIELD_INSTVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDynaInstBase.getMemo() != null) {
            object = pSDynaInstBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDynaInstBase.getPPSDynaInstId() != null) {
            object = pSDynaInstBase.getPPSDynaInstId();
            xmlNode.setAttribute(FIELD_PPSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaInstBase.getPPSDynaInstName() != null) {
            object = pSDynaInstBase.getPPSDynaInstName();
            xmlNode.setAttribute(FIELD_PPSDYNAINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaInstBase.getPSDevSlnSysId() != null) {
            object = pSDynaInstBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaInstBase.getPSDynaInstId() != null) {
            object = pSDynaInstBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaInstBase.getPSDynaInstName() != null) {
            object = pSDynaInstBase.getPSDynaInstName();
            xmlNode.setAttribute(FIELD_PSDYNAINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaInstBase.getPSDynaSysId() != null) {
            object = pSDynaInstBase.getPSDynaSysId();
            xmlNode.setAttribute(FIELD_PSDYNASYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaInstBase.getPSDynaSysName() != null) {
            object = pSDynaInstBase.getPSDynaSysName();
            xmlNode.setAttribute(FIELD_PSDYNASYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaInstBase.getUpdateDate() != null) {
            object = pSDynaInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaInstBase.getUpdateMan() != null) {
            object = pSDynaInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDynaInstBase.getUserTag() != null) {
            object = pSDynaInstBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDynaInstBase.getUserTag2() != null) {
            object = pSDynaInstBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDynaInstBase.getValidFlag() != null) {
            object = pSDynaInstBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDynaInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDynaInstBase pSDynaInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDynaInstBase.isCreateDateDirty() && (bl || pSDynaInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDynaInstBase.getCreateDate());
        }
        if (pSDynaInstBase.isCreateManDirty() && (bl || pSDynaInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDynaInstBase.getCreateMan());
        }
        if (pSDynaInstBase.isInstModeDirty() && (bl || pSDynaInstBase.getInstMode() != null)) {
            iDataObject.set(FIELD_INSTMODE, (Object)pSDynaInstBase.getInstMode());
        }
        if (pSDynaInstBase.isInstVerDirty() && (bl || pSDynaInstBase.getInstVer() != null)) {
            iDataObject.set(FIELD_INSTVER, (Object)pSDynaInstBase.getInstVer());
        }
        if (pSDynaInstBase.isMemoDirty() && (bl || pSDynaInstBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDynaInstBase.getMemo());
        }
        if (pSDynaInstBase.isPPSDynaInstIdDirty() && (bl || pSDynaInstBase.getPPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PPSDYNAINSTID, (Object)pSDynaInstBase.getPPSDynaInstId());
        }
        if (pSDynaInstBase.isPPSDynaInstNameDirty() && (bl || pSDynaInstBase.getPPSDynaInstName() != null)) {
            iDataObject.set(FIELD_PPSDYNAINSTNAME, (Object)pSDynaInstBase.getPPSDynaInstName());
        }
        if (pSDynaInstBase.isPSDevSlnSysIdDirty() && (bl || pSDynaInstBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDynaInstBase.getPSDevSlnSysId());
        }
        if (pSDynaInstBase.isPSDynaInstIdDirty() && (bl || pSDynaInstBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDynaInstBase.getPSDynaInstId());
        }
        if (pSDynaInstBase.isPSDynaInstNameDirty() && (bl || pSDynaInstBase.getPSDynaInstName() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTNAME, (Object)pSDynaInstBase.getPSDynaInstName());
        }
        if (pSDynaInstBase.isPSDynaSysIdDirty() && (bl || pSDynaInstBase.getPSDynaSysId() != null)) {
            iDataObject.set(FIELD_PSDYNASYSID, (Object)pSDynaInstBase.getPSDynaSysId());
        }
        if (pSDynaInstBase.isPSDynaSysNameDirty() && (bl || pSDynaInstBase.getPSDynaSysName() != null)) {
            iDataObject.set(FIELD_PSDYNASYSNAME, (Object)pSDynaInstBase.getPSDynaSysName());
        }
        if (pSDynaInstBase.isUpdateDateDirty() && (bl || pSDynaInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDynaInstBase.getUpdateDate());
        }
        if (pSDynaInstBase.isUpdateManDirty() && (bl || pSDynaInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDynaInstBase.getUpdateMan());
        }
        if (pSDynaInstBase.isUserTagDirty() && (bl || pSDynaInstBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDynaInstBase.getUserTag());
        }
        if (pSDynaInstBase.isUserTag2Dirty() && (bl || pSDynaInstBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDynaInstBase.getUserTag2());
        }
        if (pSDynaInstBase.isValidFlagDirty() && (bl || pSDynaInstBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDynaInstBase.getValidFlag());
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
        return PSDynaInstBase.remove(this, n);
    }

    private static boolean remove(PSDynaInstBase pSDynaInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDynaInstBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDynaInstBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDynaInstBase.resetInstMode();
                return true;
            }
            case 3: {
                pSDynaInstBase.resetInstVer();
                return true;
            }
            case 4: {
                pSDynaInstBase.resetMemo();
                return true;
            }
            case 5: {
                pSDynaInstBase.resetPPSDynaInstId();
                return true;
            }
            case 6: {
                pSDynaInstBase.resetPPSDynaInstName();
                return true;
            }
            case 7: {
                pSDynaInstBase.resetPSDevSlnSysId();
                return true;
            }
            case 8: {
                pSDynaInstBase.resetPSDynaInstId();
                return true;
            }
            case 9: {
                pSDynaInstBase.resetPSDynaInstName();
                return true;
            }
            case 10: {
                pSDynaInstBase.resetPSDynaSysId();
                return true;
            }
            case 11: {
                pSDynaInstBase.resetPSDynaSysName();
                return true;
            }
            case 12: {
                pSDynaInstBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSDynaInstBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSDynaInstBase.resetUserTag();
                return true;
            }
            case 15: {
                pSDynaInstBase.resetUserTag2();
                return true;
            }
            case 16: {
                pSDynaInstBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaSys getPSDynaSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaSys();
        }
        if (this.getPSDynaSysId() == null) {
            return null;
        }
        Integer n = this.objPSDynaSysLock;
        synchronized (n) {
            if (this.psdynasys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaSysId(), (Object)this.psdynasys.getPSDynaSysId()) != 0L) {
                this.psdynasys = null;
            }
            if (this.psdynasys == null) {
                PSDynaSys pSDynaSys = new PSDynaSys();
                pSDynaSys.setPSDynaSysId(this.getPSDynaSysId());
                PSDynaSysService pSDynaSysService = (PSDynaSysService)ServiceGlobal.getService(PSDynaSysService.class, (SessionFactory)this.getSessionFactory());
                pSDynaSysService.autoGet(pSDynaSys);
                this.psdynasys = pSDynaSys;
            }
            return this.psdynasys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSCodeList> getPSCodeLists() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeLists();
        }
        if (this.getPSDynaInstId() == null) {
            return null;
        }
        PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSCodeListsLock;
        synchronized (n) {
            if (this.pscodelists == null) {
                this.pscodelists = pSCodeListService.selectByPSDynaInst(this);
            }
            return this.pscodelists;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDynaAppViewInst> getPSDynaAppViewInsts() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppViewInsts();
        }
        if (this.getPSDynaInstId() == null) {
            return null;
        }
        PSDynaAppViewInstService pSDynaAppViewInstService = (PSDynaAppViewInstService)ServiceGlobal.getService(PSDynaAppViewInstService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDynaAppViewInstsLock;
        synchronized (n) {
            if (this.psdynaappviewinsts == null) {
                this.psdynaappviewinsts = pSDynaAppViewInstService.selectByPSDynaInst(this);
            }
            return this.psdynaappviewinsts;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDynaDEFormInst> getPSDynaDEFormInsts() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEFormInsts();
        }
        if (this.getPSDynaInstId() == null) {
            return null;
        }
        PSDynaDEFormInstService pSDynaDEFormInstService = (PSDynaDEFormInstService)ServiceGlobal.getService(PSDynaDEFormInstService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDynaDEFormInstsLock;
        synchronized (n) {
            if (this.psdynadeforminsts == null) {
                this.psdynadeforminsts = pSDynaDEFormInstService.selectByPSDynaInst(this);
            }
            return this.psdynadeforminsts;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDynaWFVerInst> getPSDynaWFVerInsts() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaWFVerInsts();
        }
        if (this.getPSDynaInstId() == null) {
            return null;
        }
        PSDynaWFVerInstService pSDynaWFVerInstService = (PSDynaWFVerInstService)ServiceGlobal.getService(PSDynaWFVerInstService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDynaWFVerInstsLock;
        synchronized (n) {
            if (this.psdynawfverinsts == null) {
                this.psdynawfverinsts = pSDynaWFVerInstService.selectByPSDynaInst(this);
            }
            return this.psdynawfverinsts;
        }
    }

    private PSDynaInstBase getProxyEntity() {
        return this.proxyPSDynaInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDynaInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSDynaInstBase) {
            this.proxyPSDynaInstBase = (PSDynaInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_INSTMODE, 2);
        fieldIndexMap.put(FIELD_INSTVER, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PPSDYNAINSTID, 5);
        fieldIndexMap.put(FIELD_PPSDYNAINSTNAME, 6);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 7);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 8);
        fieldIndexMap.put(FIELD_PSDYNAINSTNAME, 9);
        fieldIndexMap.put(FIELD_PSDYNASYSID, 10);
        fieldIndexMap.put(FIELD_PSDYNASYSNAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_USERTAG, 14);
        fieldIndexMap.put(FIELD_USERTAG2, 15);
        fieldIndexMap.put(FIELD_VALIDFLAG, 16);
    }
}

