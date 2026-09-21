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
package net.ibizsys.pscore.srv.sysdesign.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFPubCode;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSPFPubCodeService;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysPFPITemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysPFPITemplBase.class);
    public static final String FIELD_CODEMAP = "CODEMAP";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSPFPUBCODEID = "PSPFPUBCODEID";
    public static final String FIELD_PSPFPUBCODENAME = "PSPFPUBCODENAME";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSPFPITEMPLID = "PSSYSPFPITEMPLID";
    public static final String FIELD_PSSYSPFPITEMPLNAME = "PSSYSPFPITEMPLNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_TEMPLCODE = "TEMPLCODE";
    public static final String FIELD_TEMPLCODE2 = "TEMPLCODE2";
    public static final String FIELD_TEMPLCODE2EX = "TEMPLCODE2EX";
    public static final String FIELD_TEMPLCODE2FLAG = "TEMPLCODE2FLAG";
    public static final String FIELD_TEMPLCODE2INFO = "TEMPLCODE2INFO";
    public static final String FIELD_TEMPLCODE3 = "TEMPLCODE3";
    public static final String FIELD_TEMPLCODE3FLAG = "TEMPLCODE3FLAG";
    public static final String FIELD_TEMPLCODE3INFO = "TEMPLCODE3INFO";
    public static final String FIELD_TEMPLCODE4 = "TEMPLCODE4";
    public static final String FIELD_TEMPLCODE4FLAG = "TEMPLCODE4FLAG";
    public static final String FIELD_TEMPLCODE4INFO = "TEMPLCODE4INFO";
    public static final String FIELD_TEMPLCODE5 = "TEMPLCODE5";
    public static final String FIELD_TEMPLCODE6 = "TEMPLCODE6";
    public static final String FIELD_TEMPLCODEFLAG = "TEMPLCODEFLAG";
    public static final String FIELD_TEMPLCODEINFO = "TEMPLCODEINFO";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CODEMAP = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DYNAMODELFLAG = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSDYNAINSTID = 5;
    private static final int INDEX_PSPFID = 6;
    private static final int INDEX_PSPFNAME = 7;
    private static final int INDEX_PSPFPUBCODEID = 8;
    private static final int INDEX_PSPFPUBCODENAME = 9;
    private static final int INDEX_PSSYSCSSID = 10;
    private static final int INDEX_PSSYSCSSNAME = 11;
    private static final int INDEX_PSSYSDYNAMODELID = 12;
    private static final int INDEX_PSSYSDYNAMODELNAME = 13;
    private static final int INDEX_PSSYSPFPITEMPLID = 14;
    private static final int INDEX_PSSYSPFPITEMPLNAME = 15;
    private static final int INDEX_PSSYSPFPLUGINID = 16;
    private static final int INDEX_PSSYSPFPLUGINNAME = 17;
    private static final int INDEX_TEMPLCODE = 18;
    private static final int INDEX_TEMPLCODE2 = 19;
    private static final int INDEX_TEMPLCODE2EX = 20;
    private static final int INDEX_TEMPLCODE2FLAG = 21;
    private static final int INDEX_TEMPLCODE2INFO = 22;
    private static final int INDEX_TEMPLCODE3 = 23;
    private static final int INDEX_TEMPLCODE3FLAG = 24;
    private static final int INDEX_TEMPLCODE3INFO = 25;
    private static final int INDEX_TEMPLCODE4 = 26;
    private static final int INDEX_TEMPLCODE4FLAG = 27;
    private static final int INDEX_TEMPLCODE4INFO = 28;
    private static final int INDEX_TEMPLCODE5 = 29;
    private static final int INDEX_TEMPLCODE6 = 30;
    private static final int INDEX_TEMPLCODEFLAG = 31;
    private static final int INDEX_TEMPLCODEINFO = 32;
    private static final int INDEX_UPDATEDATE = 33;
    private static final int INDEX_UPDATEMAN = 34;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysPFPITemplBase proxyPSSysPFPITemplBase = null;
    private boolean codemapDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pspfpubcodeidDirtyFlag = false;
    private boolean pspfpubcodenameDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyspfpitemplidDirtyFlag = false;
    private boolean pssyspfpitemplnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean templcodeDirtyFlag = false;
    private boolean templcode2DirtyFlag = false;
    private boolean templcode2exDirtyFlag = false;
    private boolean templcode2flagDirtyFlag = false;
    private boolean templcode2infoDirtyFlag = false;
    private boolean templcode3DirtyFlag = false;
    private boolean templcode3flagDirtyFlag = false;
    private boolean templcode3infoDirtyFlag = false;
    private boolean templcode4DirtyFlag = false;
    private boolean templcode4flagDirtyFlag = false;
    private boolean templcode4infoDirtyFlag = false;
    private boolean templcode5DirtyFlag = false;
    private boolean templcode6DirtyFlag = false;
    private boolean templcodeflagDirtyFlag = false;
    private boolean templcodeinfoDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="codemap")
    private String codemap;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfname")
    private String pspfname;
    @Column(name="pspfpubcodeid")
    private String pspfpubcodeid;
    @Column(name="pspfpubcodename")
    private String pspfpubcodename;
    @Column(name="pssyscssid")
    private String pssyscssid;
    @Column(name="pssyscssname")
    private String pssyscssname;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssyspfpitemplid")
    private String pssyspfpitemplid;
    @Column(name="pssyspfpitemplname")
    private String pssyspfpitemplname;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="templcode")
    private String templcode;
    @Column(name="templcode2")
    private String templcode2;
    @Column(name="templcode2ex")
    private String templcode2ex;
    @Column(name="templcode2flag")
    private Integer templcode2flag;
    @Column(name="templcode2info")
    private String templcode2info;
    @Column(name="templcode3")
    private String templcode3;
    @Column(name="templcode3flag")
    private Integer templcode3flag;
    @Column(name="templcode3info")
    private String templcode3info;
    @Column(name="templcode4")
    private String templcode4;
    @Column(name="templcode4flag")
    private Integer templcode4flag;
    @Column(name="templcode4info")
    private String templcode4info;
    @Column(name="templcode5")
    private String templcode5;
    @Column(name="templcode6")
    private String templcode6;
    @Column(name="templcodeflag")
    private Integer templcodeflag;
    @Column(name="templcodeinfo")
    private String templcodeinfo;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSPFPubCodeLock = new Integer(1);
    private PSPFPubCode pspfpubcode = null;
    private Integer objPSPFLock = new Integer(1);
    private PSPF pspf = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;

    public void setCodeMap(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeMap(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codemap = string;
        this.codemapDirtyFlag = true;
    }

    public String getCodeMap() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeMap();
        }
        return this.codemap;
    }

    public boolean isCodeMapDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeMapDirty();
        }
        return this.codemapDirtyFlag;
    }

    public void resetCodeMap() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeMap();
            return;
        }
        this.codemapDirtyFlag = false;
        this.codemap = null;
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

    public void setDynaModelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModelFlag(n);
            return;
        }
        this.dynamodelflag = n;
        this.dynamodelflagDirtyFlag = true;
    }

    public Integer getDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModelFlag();
        }
        return this.dynamodelflag;
    }

    public boolean isDynaModelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelFlagDirty();
        }
        return this.dynamodelflagDirtyFlag;
    }

    public void resetDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModelFlag();
            return;
        }
        this.dynamodelflagDirtyFlag = false;
        this.dynamodelflag = null;
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

    public void setPSPFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfid = string;
        this.pspfidDirtyFlag = true;
    }

    public String getPSPFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFId();
        }
        return this.pspfid;
    }

    public boolean isPSPFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFIdDirty();
        }
        return this.pspfidDirtyFlag;
    }

    public void resetPSPFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFId();
            return;
        }
        this.pspfidDirtyFlag = false;
        this.pspfid = null;
    }

    public void setPSPFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfname = string;
        this.pspfnameDirtyFlag = true;
    }

    public String getPSPFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFName();
        }
        return this.pspfname;
    }

    public boolean isPSPFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFNameDirty();
        }
        return this.pspfnameDirtyFlag;
    }

    public void resetPSPFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFName();
            return;
        }
        this.pspfnameDirtyFlag = false;
        this.pspfname = null;
    }

    public void setPSPFPubCodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPubCodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpubcodeid = string;
        this.pspfpubcodeidDirtyFlag = true;
    }

    public String getPSPFPubCodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPubCodeId();
        }
        return this.pspfpubcodeid;
    }

    public boolean isPSPFPubCodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPubCodeIdDirty();
        }
        return this.pspfpubcodeidDirtyFlag;
    }

    public void resetPSPFPubCodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPubCodeId();
            return;
        }
        this.pspfpubcodeidDirtyFlag = false;
        this.pspfpubcodeid = null;
    }

    public void setPSPFPubCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPubCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpubcodename = string;
        this.pspfpubcodenameDirtyFlag = true;
    }

    public String getPSPFPubCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPubCodeName();
        }
        return this.pspfpubcodename;
    }

    public boolean isPSPFPubCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPubCodeNameDirty();
        }
        return this.pspfpubcodenameDirtyFlag;
    }

    public void resetPSPFPubCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPubCodeName();
            return;
        }
        this.pspfpubcodenameDirtyFlag = false;
        this.pspfpubcodename = null;
    }

    public void setPSSysCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscssid = string;
        this.pssyscssidDirtyFlag = true;
    }

    public String getPSSysCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCssId();
        }
        return this.pssyscssid;
    }

    public boolean isPSSysCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCssIdDirty();
        }
        return this.pssyscssidDirtyFlag;
    }

    public void resetPSSysCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCssId();
            return;
        }
        this.pssyscssidDirtyFlag = false;
        this.pssyscssid = null;
    }

    public void setPSSysCssName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCssName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscssname = string;
        this.pssyscssnameDirtyFlag = true;
    }

    public String getPSSysCssName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCssName();
        }
        return this.pssyscssname;
    }

    public boolean isPSSysCssNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCssNameDirty();
        }
        return this.pssyscssnameDirtyFlag;
    }

    public void resetPSSysCssName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCssName();
            return;
        }
        this.pssyscssnameDirtyFlag = false;
        this.pssyscssname = null;
    }

    public void setPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelid = string;
        this.pssysdynamodelidDirtyFlag = true;
    }

    public String getPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelId();
        }
        return this.pssysdynamodelid;
    }

    public boolean isPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelIdDirty();
        }
        return this.pssysdynamodelidDirtyFlag;
    }

    public void resetPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelId();
            return;
        }
        this.pssysdynamodelidDirtyFlag = false;
        this.pssysdynamodelid = null;
    }

    public void setPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelname = string;
        this.pssysdynamodelnameDirtyFlag = true;
    }

    public String getPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelName();
        }
        return this.pssysdynamodelname;
    }

    public boolean isPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelNameDirty();
        }
        return this.pssysdynamodelnameDirtyFlag;
    }

    public void resetPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelName();
            return;
        }
        this.pssysdynamodelnameDirtyFlag = false;
        this.pssysdynamodelname = null;
    }

    public void setPSSysPFPITemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPITemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpitemplid = string;
        this.pssyspfpitemplidDirtyFlag = true;
    }

    public String getPSSysPFPITemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPITemplId();
        }
        return this.pssyspfpitemplid;
    }

    public boolean isPSSysPFPITemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPITemplIdDirty();
        }
        return this.pssyspfpitemplidDirtyFlag;
    }

    public void resetPSSysPFPITemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPITemplId();
            return;
        }
        this.pssyspfpitemplidDirtyFlag = false;
        this.pssyspfpitemplid = null;
    }

    public void setPSSysPFPITemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPITemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpitemplname = string;
        this.pssyspfpitemplnameDirtyFlag = true;
    }

    public String getPSSysPFPITemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPITemplName();
        }
        return this.pssyspfpitemplname;
    }

    public boolean isPSSysPFPITemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPITemplNameDirty();
        }
        return this.pssyspfpitemplnameDirtyFlag;
    }

    public void resetPSSysPFPITemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPITemplName();
            return;
        }
        this.pssyspfpitemplnameDirtyFlag = false;
        this.pssyspfpitemplname = null;
    }

    public void setPSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginid = string;
        this.pssyspfpluginidDirtyFlag = true;
    }

    public String getPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginId();
        }
        return this.pssyspfpluginid;
    }

    public boolean isPSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginIdDirty();
        }
        return this.pssyspfpluginidDirtyFlag;
    }

    public void resetPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginId();
            return;
        }
        this.pssyspfpluginidDirtyFlag = false;
        this.pssyspfpluginid = null;
    }

    public void setPSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginname = string;
        this.pssyspfpluginnameDirtyFlag = true;
    }

    public String getPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginName();
        }
        return this.pssyspfpluginname;
    }

    public boolean isPSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginNameDirty();
        }
        return this.pssyspfpluginnameDirtyFlag;
    }

    public void resetPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginName();
            return;
        }
        this.pssyspfpluginnameDirtyFlag = false;
        this.pssyspfpluginname = null;
    }

    public void setTemplCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode = string;
        this.templcodeDirtyFlag = true;
    }

    public String getTemplCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode();
        }
        return this.templcode;
    }

    public boolean isTemplCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCodeDirty();
        }
        return this.templcodeDirtyFlag;
    }

    public void resetTemplCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode();
            return;
        }
        this.templcodeDirtyFlag = false;
        this.templcode = null;
    }

    public void setTemplCode2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode2 = string;
        this.templcode2DirtyFlag = true;
    }

    public String getTemplCode2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode2();
        }
        return this.templcode2;
    }

    public boolean isTemplCode2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCode2Dirty();
        }
        return this.templcode2DirtyFlag;
    }

    public void resetTemplCode2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode2();
            return;
        }
        this.templcode2DirtyFlag = false;
        this.templcode2 = null;
    }

    public void setTemplCode2Ex(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode2Ex(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode2ex = string;
        this.templcode2exDirtyFlag = true;
    }

    public String getTemplCode2Ex() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode2Ex();
        }
        return this.templcode2ex;
    }

    public boolean isTemplCode2ExDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCode2ExDirty();
        }
        return this.templcode2exDirtyFlag;
    }

    public void resetTemplCode2Ex() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode2Ex();
            return;
        }
        this.templcode2exDirtyFlag = false;
        this.templcode2ex = null;
    }

    public void setTemplCode2Flag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode2Flag(n);
            return;
        }
        this.templcode2flag = n;
        this.templcode2flagDirtyFlag = true;
    }

    public Integer getTemplCode2Flag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode2Flag();
        }
        return this.templcode2flag;
    }

    public boolean isTemplCode2FlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCode2FlagDirty();
        }
        return this.templcode2flagDirtyFlag;
    }

    public void resetTemplCode2Flag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode2Flag();
            return;
        }
        this.templcode2flagDirtyFlag = false;
        this.templcode2flag = null;
    }

    public void setTemplCode2Info(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode2Info(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode2info = string;
        this.templcode2infoDirtyFlag = true;
    }

    public String getTemplCode2Info() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode2Info();
        }
        return this.templcode2info;
    }

    public boolean isTemplCode2InfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCode2InfoDirty();
        }
        return this.templcode2infoDirtyFlag;
    }

    public void resetTemplCode2Info() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode2Info();
            return;
        }
        this.templcode2infoDirtyFlag = false;
        this.templcode2info = null;
    }

    public void setTemplCode3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode3 = string;
        this.templcode3DirtyFlag = true;
    }

    public String getTemplCode3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode3();
        }
        return this.templcode3;
    }

    public boolean isTemplCode3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCode3Dirty();
        }
        return this.templcode3DirtyFlag;
    }

    public void resetTemplCode3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode3();
            return;
        }
        this.templcode3DirtyFlag = false;
        this.templcode3 = null;
    }

    public void setTemplCode3Flag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode3Flag(n);
            return;
        }
        this.templcode3flag = n;
        this.templcode3flagDirtyFlag = true;
    }

    public Integer getTemplCode3Flag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode3Flag();
        }
        return this.templcode3flag;
    }

    public boolean isTemplCode3FlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCode3FlagDirty();
        }
        return this.templcode3flagDirtyFlag;
    }

    public void resetTemplCode3Flag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode3Flag();
            return;
        }
        this.templcode3flagDirtyFlag = false;
        this.templcode3flag = null;
    }

    public void setTemplCode3Info(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode3Info(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode3info = string;
        this.templcode3infoDirtyFlag = true;
    }

    public String getTemplCode3Info() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode3Info();
        }
        return this.templcode3info;
    }

    public boolean isTemplCode3InfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCode3InfoDirty();
        }
        return this.templcode3infoDirtyFlag;
    }

    public void resetTemplCode3Info() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode3Info();
            return;
        }
        this.templcode3infoDirtyFlag = false;
        this.templcode3info = null;
    }

    public void setTemplCode4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode4 = string;
        this.templcode4DirtyFlag = true;
    }

    public String getTemplCode4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode4();
        }
        return this.templcode4;
    }

    public boolean isTemplCode4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCode4Dirty();
        }
        return this.templcode4DirtyFlag;
    }

    public void resetTemplCode4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode4();
            return;
        }
        this.templcode4DirtyFlag = false;
        this.templcode4 = null;
    }

    public void setTemplCode4Flag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode4Flag(n);
            return;
        }
        this.templcode4flag = n;
        this.templcode4flagDirtyFlag = true;
    }

    public Integer getTemplCode4Flag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode4Flag();
        }
        return this.templcode4flag;
    }

    public boolean isTemplCode4FlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCode4FlagDirty();
        }
        return this.templcode4flagDirtyFlag;
    }

    public void resetTemplCode4Flag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode4Flag();
            return;
        }
        this.templcode4flagDirtyFlag = false;
        this.templcode4flag = null;
    }

    public void setTemplCode4Info(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode4Info(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode4info = string;
        this.templcode4infoDirtyFlag = true;
    }

    public String getTemplCode4Info() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode4Info();
        }
        return this.templcode4info;
    }

    public boolean isTemplCode4InfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCode4InfoDirty();
        }
        return this.templcode4infoDirtyFlag;
    }

    public void resetTemplCode4Info() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode4Info();
            return;
        }
        this.templcode4infoDirtyFlag = false;
        this.templcode4info = null;
    }

    public void setTemplCode5(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode5(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode5 = string;
        this.templcode5DirtyFlag = true;
    }

    public String getTemplCode5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode5();
        }
        return this.templcode5;
    }

    public boolean isTemplCode5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCode5Dirty();
        }
        return this.templcode5DirtyFlag;
    }

    public void resetTemplCode5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode5();
            return;
        }
        this.templcode5DirtyFlag = false;
        this.templcode5 = null;
    }

    public void setTemplCode6(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode6(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode6 = string;
        this.templcode6DirtyFlag = true;
    }

    public String getTemplCode6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode6();
        }
        return this.templcode6;
    }

    public boolean isTemplCode6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCode6Dirty();
        }
        return this.templcode6DirtyFlag;
    }

    public void resetTemplCode6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode6();
            return;
        }
        this.templcode6DirtyFlag = false;
        this.templcode6 = null;
    }

    public void setTemplCodeFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCodeFlag(n);
            return;
        }
        this.templcodeflag = n;
        this.templcodeflagDirtyFlag = true;
    }

    public Integer getTemplCodeFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCodeFlag();
        }
        return this.templcodeflag;
    }

    public boolean isTemplCodeFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCodeFlagDirty();
        }
        return this.templcodeflagDirtyFlag;
    }

    public void resetTemplCodeFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCodeFlag();
            return;
        }
        this.templcodeflagDirtyFlag = false;
        this.templcodeflag = null;
    }

    public void setTemplCodeInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCodeInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcodeinfo = string;
        this.templcodeinfoDirtyFlag = true;
    }

    public String getTemplCodeInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCodeInfo();
        }
        return this.templcodeinfo;
    }

    public boolean isTemplCodeInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCodeInfoDirty();
        }
        return this.templcodeinfoDirtyFlag;
    }

    public void resetTemplCodeInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCodeInfo();
            return;
        }
        this.templcodeinfoDirtyFlag = false;
        this.templcodeinfo = null;
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
        PSSysPFPITemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysPFPITemplBase pSSysPFPITemplBase) {
        pSSysPFPITemplBase.resetCodeMap();
        pSSysPFPITemplBase.resetCreateDate();
        pSSysPFPITemplBase.resetCreateMan();
        pSSysPFPITemplBase.resetDynaModelFlag();
        pSSysPFPITemplBase.resetMemo();
        pSSysPFPITemplBase.resetPSDynaInstId();
        pSSysPFPITemplBase.resetPSPFId();
        pSSysPFPITemplBase.resetPSPFName();
        pSSysPFPITemplBase.resetPSPFPubCodeId();
        pSSysPFPITemplBase.resetPSPFPubCodeName();
        pSSysPFPITemplBase.resetPSSysCssId();
        pSSysPFPITemplBase.resetPSSysCssName();
        pSSysPFPITemplBase.resetPSSysDynaModelId();
        pSSysPFPITemplBase.resetPSSysDynaModelName();
        pSSysPFPITemplBase.resetPSSysPFPITemplId();
        pSSysPFPITemplBase.resetPSSysPFPITemplName();
        pSSysPFPITemplBase.resetPSSysPFPluginId();
        pSSysPFPITemplBase.resetPSSysPFPluginName();
        pSSysPFPITemplBase.resetTemplCode();
        pSSysPFPITemplBase.resetTemplCode2();
        pSSysPFPITemplBase.resetTemplCode2Ex();
        pSSysPFPITemplBase.resetTemplCode2Flag();
        pSSysPFPITemplBase.resetTemplCode2Info();
        pSSysPFPITemplBase.resetTemplCode3();
        pSSysPFPITemplBase.resetTemplCode3Flag();
        pSSysPFPITemplBase.resetTemplCode3Info();
        pSSysPFPITemplBase.resetTemplCode4();
        pSSysPFPITemplBase.resetTemplCode4Flag();
        pSSysPFPITemplBase.resetTemplCode4Info();
        pSSysPFPITemplBase.resetTemplCode5();
        pSSysPFPITemplBase.resetTemplCode6();
        pSSysPFPITemplBase.resetTemplCodeFlag();
        pSSysPFPITemplBase.resetTemplCodeInfo();
        pSSysPFPITemplBase.resetUpdateDate();
        pSSysPFPITemplBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeMapDirty()) {
            hashMap.put(FIELD_CODEMAP, this.getCodeMap());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSPFIdDirty()) {
            hashMap.put(FIELD_PSPFID, this.getPSPFId());
        }
        if (!bl || this.isPSPFNameDirty()) {
            hashMap.put(FIELD_PSPFNAME, this.getPSPFName());
        }
        if (!bl || this.isPSPFPubCodeIdDirty()) {
            hashMap.put(FIELD_PSPFPUBCODEID, this.getPSPFPubCodeId());
        }
        if (!bl || this.isPSPFPubCodeNameDirty()) {
            hashMap.put(FIELD_PSPFPUBCODENAME, this.getPSPFPubCodeName());
        }
        if (!bl || this.isPSSysCssIdDirty()) {
            hashMap.put(FIELD_PSSYSCSSID, this.getPSSysCssId());
        }
        if (!bl || this.isPSSysCssNameDirty()) {
            hashMap.put(FIELD_PSSYSCSSNAME, this.getPSSysCssName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysPFPITemplIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPITEMPLID, this.getPSSysPFPITemplId());
        }
        if (!bl || this.isPSSysPFPITemplNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPITEMPLNAME, this.getPSSysPFPITemplName());
        }
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
        }
        if (!bl || this.isTemplCodeDirty()) {
            hashMap.put(FIELD_TEMPLCODE, this.getTemplCode());
        }
        if (!bl || this.isTemplCode2Dirty()) {
            hashMap.put(FIELD_TEMPLCODE2, this.getTemplCode2());
        }
        if (!bl || this.isTemplCode2ExDirty()) {
            hashMap.put(FIELD_TEMPLCODE2EX, this.getTemplCode2Ex());
        }
        if (!bl || this.isTemplCode2FlagDirty()) {
            hashMap.put(FIELD_TEMPLCODE2FLAG, this.getTemplCode2Flag());
        }
        if (!bl || this.isTemplCode2InfoDirty()) {
            hashMap.put(FIELD_TEMPLCODE2INFO, this.getTemplCode2Info());
        }
        if (!bl || this.isTemplCode3Dirty()) {
            hashMap.put(FIELD_TEMPLCODE3, this.getTemplCode3());
        }
        if (!bl || this.isTemplCode3FlagDirty()) {
            hashMap.put(FIELD_TEMPLCODE3FLAG, this.getTemplCode3Flag());
        }
        if (!bl || this.isTemplCode3InfoDirty()) {
            hashMap.put(FIELD_TEMPLCODE3INFO, this.getTemplCode3Info());
        }
        if (!bl || this.isTemplCode4Dirty()) {
            hashMap.put(FIELD_TEMPLCODE4, this.getTemplCode4());
        }
        if (!bl || this.isTemplCode4FlagDirty()) {
            hashMap.put(FIELD_TEMPLCODE4FLAG, this.getTemplCode4Flag());
        }
        if (!bl || this.isTemplCode4InfoDirty()) {
            hashMap.put(FIELD_TEMPLCODE4INFO, this.getTemplCode4Info());
        }
        if (!bl || this.isTemplCode5Dirty()) {
            hashMap.put(FIELD_TEMPLCODE5, this.getTemplCode5());
        }
        if (!bl || this.isTemplCode6Dirty()) {
            hashMap.put(FIELD_TEMPLCODE6, this.getTemplCode6());
        }
        if (!bl || this.isTemplCodeFlagDirty()) {
            hashMap.put(FIELD_TEMPLCODEFLAG, this.getTemplCodeFlag());
        }
        if (!bl || this.isTemplCodeInfoDirty()) {
            hashMap.put(FIELD_TEMPLCODEINFO, this.getTemplCodeInfo());
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
        return PSSysPFPITemplBase.get(this, n);
    }

    private static Object get(PSSysPFPITemplBase pSSysPFPITemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysPFPITemplBase.getCodeMap();
            }
            case 1: {
                return pSSysPFPITemplBase.getCreateDate();
            }
            case 2: {
                return pSSysPFPITemplBase.getCreateMan();
            }
            case 3: {
                return pSSysPFPITemplBase.getDynaModelFlag();
            }
            case 4: {
                return pSSysPFPITemplBase.getMemo();
            }
            case 5: {
                return pSSysPFPITemplBase.getPSDynaInstId();
            }
            case 6: {
                return pSSysPFPITemplBase.getPSPFId();
            }
            case 7: {
                return pSSysPFPITemplBase.getPSPFName();
            }
            case 8: {
                return pSSysPFPITemplBase.getPSPFPubCodeId();
            }
            case 9: {
                return pSSysPFPITemplBase.getPSPFPubCodeName();
            }
            case 10: {
                return pSSysPFPITemplBase.getPSSysCssId();
            }
            case 11: {
                return pSSysPFPITemplBase.getPSSysCssName();
            }
            case 12: {
                return pSSysPFPITemplBase.getPSSysDynaModelId();
            }
            case 13: {
                return pSSysPFPITemplBase.getPSSysDynaModelName();
            }
            case 14: {
                return pSSysPFPITemplBase.getPSSysPFPITemplId();
            }
            case 15: {
                return pSSysPFPITemplBase.getPSSysPFPITemplName();
            }
            case 16: {
                return pSSysPFPITemplBase.getPSSysPFPluginId();
            }
            case 17: {
                return pSSysPFPITemplBase.getPSSysPFPluginName();
            }
            case 18: {
                return pSSysPFPITemplBase.getTemplCode();
            }
            case 19: {
                return pSSysPFPITemplBase.getTemplCode2();
            }
            case 20: {
                return pSSysPFPITemplBase.getTemplCode2Ex();
            }
            case 21: {
                return pSSysPFPITemplBase.getTemplCode2Flag();
            }
            case 22: {
                return pSSysPFPITemplBase.getTemplCode2Info();
            }
            case 23: {
                return pSSysPFPITemplBase.getTemplCode3();
            }
            case 24: {
                return pSSysPFPITemplBase.getTemplCode3Flag();
            }
            case 25: {
                return pSSysPFPITemplBase.getTemplCode3Info();
            }
            case 26: {
                return pSSysPFPITemplBase.getTemplCode4();
            }
            case 27: {
                return pSSysPFPITemplBase.getTemplCode4Flag();
            }
            case 28: {
                return pSSysPFPITemplBase.getTemplCode4Info();
            }
            case 29: {
                return pSSysPFPITemplBase.getTemplCode5();
            }
            case 30: {
                return pSSysPFPITemplBase.getTemplCode6();
            }
            case 31: {
                return pSSysPFPITemplBase.getTemplCodeFlag();
            }
            case 32: {
                return pSSysPFPITemplBase.getTemplCodeInfo();
            }
            case 33: {
                return pSSysPFPITemplBase.getUpdateDate();
            }
            case 34: {
                return pSSysPFPITemplBase.getUpdateMan();
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
        PSSysPFPITemplBase.set(this, n, object);
    }

    private static void set(PSSysPFPITemplBase pSSysPFPITemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysPFPITemplBase.setCodeMap(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysPFPITemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysPFPITemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysPFPITemplBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSysPFPITemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysPFPITemplBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysPFPITemplBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysPFPITemplBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysPFPITemplBase.setPSPFPubCodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysPFPITemplBase.setPSPFPubCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysPFPITemplBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysPFPITemplBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysPFPITemplBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysPFPITemplBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysPFPITemplBase.setPSSysPFPITemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysPFPITemplBase.setPSSysPFPITemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysPFPITemplBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysPFPITemplBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysPFPITemplBase.setTemplCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysPFPITemplBase.setTemplCode2(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysPFPITemplBase.setTemplCode2Ex(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysPFPITemplBase.setTemplCode2Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSSysPFPITemplBase.setTemplCode2Info(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysPFPITemplBase.setTemplCode3(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysPFPITemplBase.setTemplCode3Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSSysPFPITemplBase.setTemplCode3Info(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysPFPITemplBase.setTemplCode4(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysPFPITemplBase.setTemplCode4Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 28: {
                pSSysPFPITemplBase.setTemplCode4Info(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysPFPITemplBase.setTemplCode5(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysPFPITemplBase.setTemplCode6(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysPFPITemplBase.setTemplCodeFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 32: {
                pSSysPFPITemplBase.setTemplCodeInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysPFPITemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 34: {
                pSSysPFPITemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysPFPITemplBase.isNull(this, n);
    }

    private static boolean isNull(PSSysPFPITemplBase pSSysPFPITemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysPFPITemplBase.getCodeMap() == null;
            }
            case 1: {
                return pSSysPFPITemplBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysPFPITemplBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysPFPITemplBase.getDynaModelFlag() == null;
            }
            case 4: {
                return pSSysPFPITemplBase.getMemo() == null;
            }
            case 5: {
                return pSSysPFPITemplBase.getPSDynaInstId() == null;
            }
            case 6: {
                return pSSysPFPITemplBase.getPSPFId() == null;
            }
            case 7: {
                return pSSysPFPITemplBase.getPSPFName() == null;
            }
            case 8: {
                return pSSysPFPITemplBase.getPSPFPubCodeId() == null;
            }
            case 9: {
                return pSSysPFPITemplBase.getPSPFPubCodeName() == null;
            }
            case 10: {
                return pSSysPFPITemplBase.getPSSysCssId() == null;
            }
            case 11: {
                return pSSysPFPITemplBase.getPSSysCssName() == null;
            }
            case 12: {
                return pSSysPFPITemplBase.getPSSysDynaModelId() == null;
            }
            case 13: {
                return pSSysPFPITemplBase.getPSSysDynaModelName() == null;
            }
            case 14: {
                return pSSysPFPITemplBase.getPSSysPFPITemplId() == null;
            }
            case 15: {
                return pSSysPFPITemplBase.getPSSysPFPITemplName() == null;
            }
            case 16: {
                return pSSysPFPITemplBase.getPSSysPFPluginId() == null;
            }
            case 17: {
                return pSSysPFPITemplBase.getPSSysPFPluginName() == null;
            }
            case 18: {
                return pSSysPFPITemplBase.getTemplCode() == null;
            }
            case 19: {
                return pSSysPFPITemplBase.getTemplCode2() == null;
            }
            case 20: {
                return pSSysPFPITemplBase.getTemplCode2Ex() == null;
            }
            case 21: {
                return pSSysPFPITemplBase.getTemplCode2Flag() == null;
            }
            case 22: {
                return pSSysPFPITemplBase.getTemplCode2Info() == null;
            }
            case 23: {
                return pSSysPFPITemplBase.getTemplCode3() == null;
            }
            case 24: {
                return pSSysPFPITemplBase.getTemplCode3Flag() == null;
            }
            case 25: {
                return pSSysPFPITemplBase.getTemplCode3Info() == null;
            }
            case 26: {
                return pSSysPFPITemplBase.getTemplCode4() == null;
            }
            case 27: {
                return pSSysPFPITemplBase.getTemplCode4Flag() == null;
            }
            case 28: {
                return pSSysPFPITemplBase.getTemplCode4Info() == null;
            }
            case 29: {
                return pSSysPFPITemplBase.getTemplCode5() == null;
            }
            case 30: {
                return pSSysPFPITemplBase.getTemplCode6() == null;
            }
            case 31: {
                return pSSysPFPITemplBase.getTemplCodeFlag() == null;
            }
            case 32: {
                return pSSysPFPITemplBase.getTemplCodeInfo() == null;
            }
            case 33: {
                return pSSysPFPITemplBase.getUpdateDate() == null;
            }
            case 34: {
                return pSSysPFPITemplBase.getUpdateMan() == null;
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
        return PSSysPFPITemplBase.contains(this, n);
    }

    private static boolean contains(PSSysPFPITemplBase pSSysPFPITemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysPFPITemplBase.isCodeMapDirty();
            }
            case 1: {
                return pSSysPFPITemplBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysPFPITemplBase.isCreateManDirty();
            }
            case 3: {
                return pSSysPFPITemplBase.isDynaModelFlagDirty();
            }
            case 4: {
                return pSSysPFPITemplBase.isMemoDirty();
            }
            case 5: {
                return pSSysPFPITemplBase.isPSDynaInstIdDirty();
            }
            case 6: {
                return pSSysPFPITemplBase.isPSPFIdDirty();
            }
            case 7: {
                return pSSysPFPITemplBase.isPSPFNameDirty();
            }
            case 8: {
                return pSSysPFPITemplBase.isPSPFPubCodeIdDirty();
            }
            case 9: {
                return pSSysPFPITemplBase.isPSPFPubCodeNameDirty();
            }
            case 10: {
                return pSSysPFPITemplBase.isPSSysCssIdDirty();
            }
            case 11: {
                return pSSysPFPITemplBase.isPSSysCssNameDirty();
            }
            case 12: {
                return pSSysPFPITemplBase.isPSSysDynaModelIdDirty();
            }
            case 13: {
                return pSSysPFPITemplBase.isPSSysDynaModelNameDirty();
            }
            case 14: {
                return pSSysPFPITemplBase.isPSSysPFPITemplIdDirty();
            }
            case 15: {
                return pSSysPFPITemplBase.isPSSysPFPITemplNameDirty();
            }
            case 16: {
                return pSSysPFPITemplBase.isPSSysPFPluginIdDirty();
            }
            case 17: {
                return pSSysPFPITemplBase.isPSSysPFPluginNameDirty();
            }
            case 18: {
                return pSSysPFPITemplBase.isTemplCodeDirty();
            }
            case 19: {
                return pSSysPFPITemplBase.isTemplCode2Dirty();
            }
            case 20: {
                return pSSysPFPITemplBase.isTemplCode2ExDirty();
            }
            case 21: {
                return pSSysPFPITemplBase.isTemplCode2FlagDirty();
            }
            case 22: {
                return pSSysPFPITemplBase.isTemplCode2InfoDirty();
            }
            case 23: {
                return pSSysPFPITemplBase.isTemplCode3Dirty();
            }
            case 24: {
                return pSSysPFPITemplBase.isTemplCode3FlagDirty();
            }
            case 25: {
                return pSSysPFPITemplBase.isTemplCode3InfoDirty();
            }
            case 26: {
                return pSSysPFPITemplBase.isTemplCode4Dirty();
            }
            case 27: {
                return pSSysPFPITemplBase.isTemplCode4FlagDirty();
            }
            case 28: {
                return pSSysPFPITemplBase.isTemplCode4InfoDirty();
            }
            case 29: {
                return pSSysPFPITemplBase.isTemplCode5Dirty();
            }
            case 30: {
                return pSSysPFPITemplBase.isTemplCode6Dirty();
            }
            case 31: {
                return pSSysPFPITemplBase.isTemplCodeFlagDirty();
            }
            case 32: {
                return pSSysPFPITemplBase.isTemplCodeInfoDirty();
            }
            case 33: {
                return pSSysPFPITemplBase.isUpdateDateDirty();
            }
            case 34: {
                return pSSysPFPITemplBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysPFPITemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysPFPITemplBase pSSysPFPITemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysPFPITemplBase.getCodeMap() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codemap", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getCodeMap()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getPSPFPubCodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpubcodeid", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getPSPFPubCodeId()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getPSPFPubCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpubcodename", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getPSPFPubCodeName()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getPSSysPFPITemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpitemplid", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getPSSysPFPITemplId()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getPSSysPFPITemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpitemplname", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getPSSysPFPITemplName()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getTemplCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getTemplCode()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getTemplCode2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode2", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getTemplCode2()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getTemplCode2Ex() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode2ex", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getTemplCode2Ex()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getTemplCode2Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode2flag", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getTemplCode2Flag()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getTemplCode2Info() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode2info", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getTemplCode2Info()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getTemplCode3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode3", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getTemplCode3()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getTemplCode3Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode3flag", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getTemplCode3Flag()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getTemplCode3Info() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode3info", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getTemplCode3Info()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getTemplCode4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode4", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getTemplCode4()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getTemplCode4Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode4flag", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getTemplCode4Flag()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getTemplCode4Info() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode4info", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getTemplCode4Info()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getTemplCode5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode5", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getTemplCode5()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getTemplCode6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode6", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getTemplCode6()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getTemplCodeFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcodeflag", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getTemplCodeFlag()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getTemplCodeInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcodeinfo", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getTemplCodeInfo()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysPFPITemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysPFPITemplBase.getJSONValue((Object)pSSysPFPITemplBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysPFPITemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysPFPITemplBase pSSysPFPITemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysPFPITemplBase.getCodeMap() != null) {
            object = pSSysPFPITemplBase.getCodeMap();
            xmlNode.setAttribute(FIELD_CODEMAP, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPITemplBase.getCreateDate() != null) {
            object = pSSysPFPITemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysPFPITemplBase.getCreateMan() != null) {
            object = pSSysPFPITemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPITemplBase.getDynaModelFlag() != null) {
            object = pSSysPFPITemplBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysPFPITemplBase.getMemo() != null) {
            object = pSSysPFPITemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPITemplBase.getPSDynaInstId() != null) {
            object = pSSysPFPITemplBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPITemplBase.getPSPFId() != null) {
            object = pSSysPFPITemplBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPITemplBase.getPSPFName() != null) {
            object = pSSysPFPITemplBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPITemplBase.getPSPFPubCodeId() != null) {
            object = pSSysPFPITemplBase.getPSPFPubCodeId();
            xmlNode.setAttribute(FIELD_PSPFPUBCODEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPITemplBase.getPSPFPubCodeName() != null) {
            object = pSSysPFPITemplBase.getPSPFPubCodeName();
            xmlNode.setAttribute(FIELD_PSPFPUBCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPITemplBase.getPSSysCssId() != null) {
            object = pSSysPFPITemplBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPITemplBase.getPSSysCssName() != null) {
            object = pSSysPFPITemplBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPITemplBase.getPSSysDynaModelId() != null) {
            object = pSSysPFPITemplBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPITemplBase.getPSSysDynaModelName() != null) {
            object = pSSysPFPITemplBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPITemplBase.getPSSysPFPITemplId() != null) {
            object = pSSysPFPITemplBase.getPSSysPFPITemplId();
            xmlNode.setAttribute(FIELD_PSSYSPFPITEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPITemplBase.getPSSysPFPITemplName() != null) {
            object = pSSysPFPITemplBase.getPSSysPFPITemplName();
            xmlNode.setAttribute(FIELD_PSSYSPFPITEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPITemplBase.getPSSysPFPluginId() != null) {
            object = pSSysPFPITemplBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPITemplBase.getPSSysPFPluginName() != null) {
            object = pSSysPFPITemplBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPITemplBase.getTemplCode() != null) {
            object = pSSysPFPITemplBase.getTemplCode();
            xmlNode.setAttribute(FIELD_TEMPLCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPITemplBase.getTemplCode2() != null) {
            object = pSSysPFPITemplBase.getTemplCode2();
            xmlNode.setAttribute(FIELD_TEMPLCODE2, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPITemplBase.getTemplCode2Ex() != null) {
            object = pSSysPFPITemplBase.getTemplCode2Ex();
            xmlNode.setAttribute(FIELD_TEMPLCODE2EX, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPITemplBase.getTemplCode2Flag() != null) {
            object = pSSysPFPITemplBase.getTemplCode2Flag();
            xmlNode.setAttribute(FIELD_TEMPLCODE2FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysPFPITemplBase.getTemplCode2Info() != null) {
            object = pSSysPFPITemplBase.getTemplCode2Info();
            xmlNode.setAttribute(FIELD_TEMPLCODE2INFO, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPITemplBase.getTemplCode3() != null) {
            object = pSSysPFPITemplBase.getTemplCode3();
            xmlNode.setAttribute(FIELD_TEMPLCODE3, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPITemplBase.getTemplCode3Flag() != null) {
            object = pSSysPFPITemplBase.getTemplCode3Flag();
            xmlNode.setAttribute(FIELD_TEMPLCODE3FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysPFPITemplBase.getTemplCode3Info() != null) {
            object = pSSysPFPITemplBase.getTemplCode3Info();
            xmlNode.setAttribute(FIELD_TEMPLCODE3INFO, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPITemplBase.getTemplCode4() != null) {
            object = pSSysPFPITemplBase.getTemplCode4();
            xmlNode.setAttribute(FIELD_TEMPLCODE4, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPITemplBase.getTemplCode4Flag() != null) {
            object = pSSysPFPITemplBase.getTemplCode4Flag();
            xmlNode.setAttribute(FIELD_TEMPLCODE4FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysPFPITemplBase.getTemplCode4Info() != null) {
            object = pSSysPFPITemplBase.getTemplCode4Info();
            xmlNode.setAttribute(FIELD_TEMPLCODE4INFO, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPITemplBase.getTemplCode5() != null) {
            object = pSSysPFPITemplBase.getTemplCode5();
            xmlNode.setAttribute(FIELD_TEMPLCODE5, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPITemplBase.getTemplCode6() != null) {
            object = pSSysPFPITemplBase.getTemplCode6();
            xmlNode.setAttribute(FIELD_TEMPLCODE6, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPITemplBase.getTemplCodeFlag() != null) {
            object = pSSysPFPITemplBase.getTemplCodeFlag();
            xmlNode.setAttribute(FIELD_TEMPLCODEFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysPFPITemplBase.getTemplCodeInfo() != null) {
            object = pSSysPFPITemplBase.getTemplCodeInfo();
            xmlNode.setAttribute(FIELD_TEMPLCODEINFO, object == null ? "" : (String)object);
        }
        if (bl || pSSysPFPITemplBase.getUpdateDate() != null) {
            object = pSSysPFPITemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysPFPITemplBase.getUpdateMan() != null) {
            object = pSSysPFPITemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysPFPITemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysPFPITemplBase pSSysPFPITemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysPFPITemplBase.isCodeMapDirty() && (bl || pSSysPFPITemplBase.getCodeMap() != null)) {
            iDataObject.set(FIELD_CODEMAP, (Object)pSSysPFPITemplBase.getCodeMap());
        }
        if (pSSysPFPITemplBase.isCreateDateDirty() && (bl || pSSysPFPITemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysPFPITemplBase.getCreateDate());
        }
        if (pSSysPFPITemplBase.isCreateManDirty() && (bl || pSSysPFPITemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysPFPITemplBase.getCreateMan());
        }
        if (pSSysPFPITemplBase.isDynaModelFlagDirty() && (bl || pSSysPFPITemplBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSSysPFPITemplBase.getDynaModelFlag());
        }
        if (pSSysPFPITemplBase.isMemoDirty() && (bl || pSSysPFPITemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysPFPITemplBase.getMemo());
        }
        if (pSSysPFPITemplBase.isPSDynaInstIdDirty() && (bl || pSSysPFPITemplBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSSysPFPITemplBase.getPSDynaInstId());
        }
        if (pSSysPFPITemplBase.isPSPFIdDirty() && (bl || pSSysPFPITemplBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSSysPFPITemplBase.getPSPFId());
        }
        if (pSSysPFPITemplBase.isPSPFNameDirty() && (bl || pSSysPFPITemplBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSSysPFPITemplBase.getPSPFName());
        }
        if (pSSysPFPITemplBase.isPSPFPubCodeIdDirty() && (bl || pSSysPFPITemplBase.getPSPFPubCodeId() != null)) {
            iDataObject.set(FIELD_PSPFPUBCODEID, (Object)pSSysPFPITemplBase.getPSPFPubCodeId());
        }
        if (pSSysPFPITemplBase.isPSPFPubCodeNameDirty() && (bl || pSSysPFPITemplBase.getPSPFPubCodeName() != null)) {
            iDataObject.set(FIELD_PSPFPUBCODENAME, (Object)pSSysPFPITemplBase.getPSPFPubCodeName());
        }
        if (pSSysPFPITemplBase.isPSSysCssIdDirty() && (bl || pSSysPFPITemplBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSSysPFPITemplBase.getPSSysCssId());
        }
        if (pSSysPFPITemplBase.isPSSysCssNameDirty() && (bl || pSSysPFPITemplBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSSysPFPITemplBase.getPSSysCssName());
        }
        if (pSSysPFPITemplBase.isPSSysDynaModelIdDirty() && (bl || pSSysPFPITemplBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysPFPITemplBase.getPSSysDynaModelId());
        }
        if (pSSysPFPITemplBase.isPSSysDynaModelNameDirty() && (bl || pSSysPFPITemplBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysPFPITemplBase.getPSSysDynaModelName());
        }
        if (pSSysPFPITemplBase.isPSSysPFPITemplIdDirty() && (bl || pSSysPFPITemplBase.getPSSysPFPITemplId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPITEMPLID, (Object)pSSysPFPITemplBase.getPSSysPFPITemplId());
        }
        if (pSSysPFPITemplBase.isPSSysPFPITemplNameDirty() && (bl || pSSysPFPITemplBase.getPSSysPFPITemplName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPITEMPLNAME, (Object)pSSysPFPITemplBase.getPSSysPFPITemplName());
        }
        if (pSSysPFPITemplBase.isPSSysPFPluginIdDirty() && (bl || pSSysPFPITemplBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSSysPFPITemplBase.getPSSysPFPluginId());
        }
        if (pSSysPFPITemplBase.isPSSysPFPluginNameDirty() && (bl || pSSysPFPITemplBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSSysPFPITemplBase.getPSSysPFPluginName());
        }
        if (pSSysPFPITemplBase.isTemplCodeDirty() && (bl || pSSysPFPITemplBase.getTemplCode() != null)) {
            iDataObject.set(FIELD_TEMPLCODE, (Object)pSSysPFPITemplBase.getTemplCode());
        }
        if (pSSysPFPITemplBase.isTemplCode2Dirty() && (bl || pSSysPFPITemplBase.getTemplCode2() != null)) {
            iDataObject.set(FIELD_TEMPLCODE2, (Object)pSSysPFPITemplBase.getTemplCode2());
        }
        if (pSSysPFPITemplBase.isTemplCode2ExDirty() && (bl || pSSysPFPITemplBase.getTemplCode2Ex() != null)) {
            iDataObject.set(FIELD_TEMPLCODE2EX, (Object)pSSysPFPITemplBase.getTemplCode2Ex());
        }
        if (pSSysPFPITemplBase.isTemplCode2FlagDirty() && (bl || pSSysPFPITemplBase.getTemplCode2Flag() != null)) {
            iDataObject.set(FIELD_TEMPLCODE2FLAG, (Object)pSSysPFPITemplBase.getTemplCode2Flag());
        }
        if (pSSysPFPITemplBase.isTemplCode2InfoDirty() && (bl || pSSysPFPITemplBase.getTemplCode2Info() != null)) {
            iDataObject.set(FIELD_TEMPLCODE2INFO, (Object)pSSysPFPITemplBase.getTemplCode2Info());
        }
        if (pSSysPFPITemplBase.isTemplCode3Dirty() && (bl || pSSysPFPITemplBase.getTemplCode3() != null)) {
            iDataObject.set(FIELD_TEMPLCODE3, (Object)pSSysPFPITemplBase.getTemplCode3());
        }
        if (pSSysPFPITemplBase.isTemplCode3FlagDirty() && (bl || pSSysPFPITemplBase.getTemplCode3Flag() != null)) {
            iDataObject.set(FIELD_TEMPLCODE3FLAG, (Object)pSSysPFPITemplBase.getTemplCode3Flag());
        }
        if (pSSysPFPITemplBase.isTemplCode3InfoDirty() && (bl || pSSysPFPITemplBase.getTemplCode3Info() != null)) {
            iDataObject.set(FIELD_TEMPLCODE3INFO, (Object)pSSysPFPITemplBase.getTemplCode3Info());
        }
        if (pSSysPFPITemplBase.isTemplCode4Dirty() && (bl || pSSysPFPITemplBase.getTemplCode4() != null)) {
            iDataObject.set(FIELD_TEMPLCODE4, (Object)pSSysPFPITemplBase.getTemplCode4());
        }
        if (pSSysPFPITemplBase.isTemplCode4FlagDirty() && (bl || pSSysPFPITemplBase.getTemplCode4Flag() != null)) {
            iDataObject.set(FIELD_TEMPLCODE4FLAG, (Object)pSSysPFPITemplBase.getTemplCode4Flag());
        }
        if (pSSysPFPITemplBase.isTemplCode4InfoDirty() && (bl || pSSysPFPITemplBase.getTemplCode4Info() != null)) {
            iDataObject.set(FIELD_TEMPLCODE4INFO, (Object)pSSysPFPITemplBase.getTemplCode4Info());
        }
        if (pSSysPFPITemplBase.isTemplCode5Dirty() && (bl || pSSysPFPITemplBase.getTemplCode5() != null)) {
            iDataObject.set(FIELD_TEMPLCODE5, (Object)pSSysPFPITemplBase.getTemplCode5());
        }
        if (pSSysPFPITemplBase.isTemplCode6Dirty() && (bl || pSSysPFPITemplBase.getTemplCode6() != null)) {
            iDataObject.set(FIELD_TEMPLCODE6, (Object)pSSysPFPITemplBase.getTemplCode6());
        }
        if (pSSysPFPITemplBase.isTemplCodeFlagDirty() && (bl || pSSysPFPITemplBase.getTemplCodeFlag() != null)) {
            iDataObject.set(FIELD_TEMPLCODEFLAG, (Object)pSSysPFPITemplBase.getTemplCodeFlag());
        }
        if (pSSysPFPITemplBase.isTemplCodeInfoDirty() && (bl || pSSysPFPITemplBase.getTemplCodeInfo() != null)) {
            iDataObject.set(FIELD_TEMPLCODEINFO, (Object)pSSysPFPITemplBase.getTemplCodeInfo());
        }
        if (pSSysPFPITemplBase.isUpdateDateDirty() && (bl || pSSysPFPITemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysPFPITemplBase.getUpdateDate());
        }
        if (pSSysPFPITemplBase.isUpdateManDirty() && (bl || pSSysPFPITemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysPFPITemplBase.getUpdateMan());
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
        return PSSysPFPITemplBase.remove(this, n);
    }

    private static boolean remove(PSSysPFPITemplBase pSSysPFPITemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysPFPITemplBase.resetCodeMap();
                return true;
            }
            case 1: {
                pSSysPFPITemplBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysPFPITemplBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysPFPITemplBase.resetDynaModelFlag();
                return true;
            }
            case 4: {
                pSSysPFPITemplBase.resetMemo();
                return true;
            }
            case 5: {
                pSSysPFPITemplBase.resetPSDynaInstId();
                return true;
            }
            case 6: {
                pSSysPFPITemplBase.resetPSPFId();
                return true;
            }
            case 7: {
                pSSysPFPITemplBase.resetPSPFName();
                return true;
            }
            case 8: {
                pSSysPFPITemplBase.resetPSPFPubCodeId();
                return true;
            }
            case 9: {
                pSSysPFPITemplBase.resetPSPFPubCodeName();
                return true;
            }
            case 10: {
                pSSysPFPITemplBase.resetPSSysCssId();
                return true;
            }
            case 11: {
                pSSysPFPITemplBase.resetPSSysCssName();
                return true;
            }
            case 12: {
                pSSysPFPITemplBase.resetPSSysDynaModelId();
                return true;
            }
            case 13: {
                pSSysPFPITemplBase.resetPSSysDynaModelName();
                return true;
            }
            case 14: {
                pSSysPFPITemplBase.resetPSSysPFPITemplId();
                return true;
            }
            case 15: {
                pSSysPFPITemplBase.resetPSSysPFPITemplName();
                return true;
            }
            case 16: {
                pSSysPFPITemplBase.resetPSSysPFPluginId();
                return true;
            }
            case 17: {
                pSSysPFPITemplBase.resetPSSysPFPluginName();
                return true;
            }
            case 18: {
                pSSysPFPITemplBase.resetTemplCode();
                return true;
            }
            case 19: {
                pSSysPFPITemplBase.resetTemplCode2();
                return true;
            }
            case 20: {
                pSSysPFPITemplBase.resetTemplCode2Ex();
                return true;
            }
            case 21: {
                pSSysPFPITemplBase.resetTemplCode2Flag();
                return true;
            }
            case 22: {
                pSSysPFPITemplBase.resetTemplCode2Info();
                return true;
            }
            case 23: {
                pSSysPFPITemplBase.resetTemplCode3();
                return true;
            }
            case 24: {
                pSSysPFPITemplBase.resetTemplCode3Flag();
                return true;
            }
            case 25: {
                pSSysPFPITemplBase.resetTemplCode3Info();
                return true;
            }
            case 26: {
                pSSysPFPITemplBase.resetTemplCode4();
                return true;
            }
            case 27: {
                pSSysPFPITemplBase.resetTemplCode4Flag();
                return true;
            }
            case 28: {
                pSSysPFPITemplBase.resetTemplCode4Info();
                return true;
            }
            case 29: {
                pSSysPFPITemplBase.resetTemplCode5();
                return true;
            }
            case 30: {
                pSSysPFPITemplBase.resetTemplCode6();
                return true;
            }
            case 31: {
                pSSysPFPITemplBase.resetTemplCodeFlag();
                return true;
            }
            case 32: {
                pSSysPFPITemplBase.resetTemplCodeInfo();
                return true;
            }
            case 33: {
                pSSysPFPITemplBase.resetUpdateDate();
                return true;
            }
            case 34: {
                pSSysPFPITemplBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFPubCode getPSPFPubCode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPubCode();
        }
        if (this.getPSPFPubCodeId() == null) {
            return null;
        }
        Integer n = this.objPSPFPubCodeLock;
        synchronized (n) {
            if (this.pspfpubcode != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFPubCodeId(), (Object)this.pspfpubcode.getPSPFPubCodeId()) != 0L) {
                this.pspfpubcode = null;
            }
            if (this.pspfpubcode == null) {
                PSPFPubCode pSPFPubCode = new PSPFPubCode();
                pSPFPubCode.setPSPFPubCodeId(this.getPSPFPubCodeId());
                PSPFPubCodeService pSPFPubCodeService = (PSPFPubCodeService)ServiceGlobal.getService(PSPFPubCodeService.class, (SessionFactory)this.getSessionFactory());
                pSPFPubCodeService.autoGet((IEntity)pSPFPubCode);
                this.pspfpubcode = pSPFPubCode;
            }
            return this.pspfpubcode;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPF getPSPF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPF();
        }
        if (this.getPSPFId() == null) {
            return null;
        }
        Integer n = this.objPSPFLock;
        synchronized (n) {
            if (this.pspf != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFId(), (Object)this.pspf.getPSPFId()) != 0L) {
                this.pspf = null;
            }
            if (this.pspf == null) {
                PSPF pSPF = new PSPF();
                pSPF.setPSPFId(this.getPSPFId());
                PSPFService pSPFService = (PSPFService)ServiceGlobal.getService(PSPFService.class, (SessionFactory)this.getSessionFactory());
                pSPFService.autoGet((IEntity)pSPF);
                this.pspf = pSPF;
            }
            return this.pspf;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCss getPSSysCss() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCss();
        }
        if (this.getPSSysCssId() == null) {
            return null;
        }
        Integer n = this.objPSSysCssLock;
        synchronized (n) {
            if (this.pssyscss != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysCssId(), (Object)this.pssyscss.getPSSysCssId()) != 0L) {
                this.pssyscss = null;
            }
            if (this.pssyscss == null) {
                PSSysCss pSSysCss = new PSSysCss();
                pSSysCss.setPSSysCssId(this.getPSSysCssId());
                PSSysCssService pSSysCssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
                pSSysCssService.autoGet((IEntity)pSSysCss);
                this.pssyscss = pSSysCss;
            }
            return this.pssyscss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDynaModel getPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModel();
        }
        if (this.getPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objPSSysDynaModelLock;
        synchronized (n) {
            if (this.pssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDynaModelId(), (Object)this.pssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.pssysdynamodel = null;
            }
            if (this.pssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet((IEntity)pSSysDynaModel);
                this.pssysdynamodel = pSSysDynaModel;
            }
            return this.pssysdynamodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysPFPlugin getPSSysPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPlugin();
        }
        if (this.getPSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysPFPluginLock;
        synchronized (n) {
            if (this.pssyspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysPFPluginId(), (Object)this.pssyspfplugin.getPSSysPFPluginId()) != 0L) {
                this.pssyspfplugin = null;
            }
            if (this.pssyspfplugin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getPSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet((IEntity)pSSysPFPlugin);
                this.pssyspfplugin = pSSysPFPlugin;
            }
            return this.pssyspfplugin;
        }
    }

    private PSSysPFPITemplBase getProxyEntity() {
        return this.proxyPSSysPFPITemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysPFPITemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysPFPITemplBase) {
            this.proxyPSSysPFPITemplBase = (PSSysPFPITemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysPFPITemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODEMAP, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 5);
        fieldIndexMap.put(FIELD_PSPFID, 6);
        fieldIndexMap.put(FIELD_PSPFNAME, 7);
        fieldIndexMap.put(FIELD_PSPFPUBCODEID, 8);
        fieldIndexMap.put(FIELD_PSPFPUBCODENAME, 9);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 10);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 11);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 12);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 13);
        fieldIndexMap.put(FIELD_PSSYSPFPITEMPLID, 14);
        fieldIndexMap.put(FIELD_PSSYSPFPITEMPLNAME, 15);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 16);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 17);
        fieldIndexMap.put(FIELD_TEMPLCODE, 18);
        fieldIndexMap.put(FIELD_TEMPLCODE2, 19);
        fieldIndexMap.put(FIELD_TEMPLCODE2EX, 20);
        fieldIndexMap.put(FIELD_TEMPLCODE2FLAG, 21);
        fieldIndexMap.put(FIELD_TEMPLCODE2INFO, 22);
        fieldIndexMap.put(FIELD_TEMPLCODE3, 23);
        fieldIndexMap.put(FIELD_TEMPLCODE3FLAG, 24);
        fieldIndexMap.put(FIELD_TEMPLCODE3INFO, 25);
        fieldIndexMap.put(FIELD_TEMPLCODE4, 26);
        fieldIndexMap.put(FIELD_TEMPLCODE4FLAG, 27);
        fieldIndexMap.put(FIELD_TEMPLCODE4INFO, 28);
        fieldIndexMap.put(FIELD_TEMPLCODE5, 29);
        fieldIndexMap.put(FIELD_TEMPLCODE6, 30);
        fieldIndexMap.put(FIELD_TEMPLCODEFLAG, 31);
        fieldIndexMap.put(FIELD_TEMPLCODEINFO, 32);
        fieldIndexMap.put(FIELD_UPDATEDATE, 33);
        fieldIndexMap.put(FIELD_UPDATEMAN, 34);
    }
}

