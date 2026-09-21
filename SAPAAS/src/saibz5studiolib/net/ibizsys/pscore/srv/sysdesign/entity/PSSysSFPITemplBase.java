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
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.service.PSSFService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysSFPITemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysSFPITemplBase.class);
    public static final String FIELD_CODEMAP = "CODEMAP";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSFID = "PSSFID";
    public static final String FIELD_PSSFNAME = "PSSFNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSSFPITEMPLID = "PSSYSSFPITEMPLID";
    public static final String FIELD_PSSYSSFPITEMPLNAME = "PSSYSSFPITEMPLNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_TEMPLCODE = "TEMPLCODE";
    public static final String FIELD_TEMPLCODE2 = "TEMPLCODE2";
    public static final String FIELD_TEMPLCODE2EX = "TEMPLCODE2EX";
    public static final String FIELD_TEMPLCODE3 = "TEMPLCODE3";
    public static final String FIELD_TEMPLCODE4 = "TEMPLCODE4";
    public static final String FIELD_TEMPLCODE5 = "TEMPLCODE5";
    public static final String FIELD_TEMPLCODE6 = "TEMPLCODE6";
    public static final String FIELD_TEMPLCODEEX = "TEMPLCODEEX";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CODEMAP = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSSFID = 4;
    private static final int INDEX_PSSFNAME = 5;
    private static final int INDEX_PSSYSDYNAMODELID = 6;
    private static final int INDEX_PSSYSDYNAMODELNAME = 7;
    private static final int INDEX_PSSYSSFPITEMPLID = 8;
    private static final int INDEX_PSSYSSFPITEMPLNAME = 9;
    private static final int INDEX_PSSYSSFPLUGINID = 10;
    private static final int INDEX_PSSYSSFPLUGINNAME = 11;
    private static final int INDEX_TEMPLCODE = 12;
    private static final int INDEX_TEMPLCODE2 = 13;
    private static final int INDEX_TEMPLCODE2EX = 14;
    private static final int INDEX_TEMPLCODE3 = 15;
    private static final int INDEX_TEMPLCODE4 = 16;
    private static final int INDEX_TEMPLCODE5 = 17;
    private static final int INDEX_TEMPLCODE6 = 18;
    private static final int INDEX_TEMPLCODEEX = 19;
    private static final int INDEX_UPDATEDATE = 20;
    private static final int INDEX_UPDATEMAN = 21;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysSFPITemplBase proxyPSSysSFPITemplBase = null;
    private boolean codemapDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssfidDirtyFlag = false;
    private boolean pssfnameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyssfpitemplidDirtyFlag = false;
    private boolean pssyssfpitemplnameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean templcodeDirtyFlag = false;
    private boolean templcode2DirtyFlag = false;
    private boolean templcode2exDirtyFlag = false;
    private boolean templcode3DirtyFlag = false;
    private boolean templcode4DirtyFlag = false;
    private boolean templcode5DirtyFlag = false;
    private boolean templcode6DirtyFlag = false;
    private boolean templcodeexDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="codemap")
    private String codemap;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pssfid")
    private String pssfid;
    @Column(name="pssfname")
    private String pssfname;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssyssfpitemplid")
    private String pssyssfpitemplid;
    @Column(name="pssyssfpitemplname")
    private String pssyssfpitemplname;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="templcode")
    private String templcode;
    @Column(name="templcode2")
    private String templcode2;
    @Column(name="templcode2ex")
    private String templcode2ex;
    @Column(name="templcode3")
    private String templcode3;
    @Column(name="templcode4")
    private String templcode4;
    @Column(name="templcode5")
    private String templcode5;
    @Column(name="templcode6")
    private String templcode6;
    @Column(name="templcodeex")
    private String templcodeex;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSFLock = new Integer(1);
    private PSSF pssf = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;

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

    public void setPSSFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfid = string;
        this.pssfidDirtyFlag = true;
    }

    public String getPSSFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFId();
        }
        return this.pssfid;
    }

    public boolean isPSSFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFIdDirty();
        }
        return this.pssfidDirtyFlag;
    }

    public void resetPSSFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFId();
            return;
        }
        this.pssfidDirtyFlag = false;
        this.pssfid = null;
    }

    public void setPSSFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfname = string;
        this.pssfnameDirtyFlag = true;
    }

    public String getPSSFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFName();
        }
        return this.pssfname;
    }

    public boolean isPSSFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFNameDirty();
        }
        return this.pssfnameDirtyFlag;
    }

    public void resetPSSFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFName();
            return;
        }
        this.pssfnameDirtyFlag = false;
        this.pssfname = null;
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

    public void setPSSysSFPITemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPITemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpitemplid = string;
        this.pssyssfpitemplidDirtyFlag = true;
    }

    public String getPSSysSFPITemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPITemplId();
        }
        return this.pssyssfpitemplid;
    }

    public boolean isPSSysSFPITemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPITemplIdDirty();
        }
        return this.pssyssfpitemplidDirtyFlag;
    }

    public void resetPSSysSFPITemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPITemplId();
            return;
        }
        this.pssyssfpitemplidDirtyFlag = false;
        this.pssyssfpitemplid = null;
    }

    public void setPSSysSFPITemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPITemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpitemplname = string;
        this.pssyssfpitemplnameDirtyFlag = true;
    }

    public String getPSSysSFPITemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPITemplName();
        }
        return this.pssyssfpitemplname;
    }

    public boolean isPSSysSFPITemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPITemplNameDirty();
        }
        return this.pssyssfpitemplnameDirtyFlag;
    }

    public void resetPSSysSFPITemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPITemplName();
            return;
        }
        this.pssyssfpitemplnameDirtyFlag = false;
        this.pssyssfpitemplname = null;
    }

    public void setPSSysSFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginid = string;
        this.pssyssfpluginidDirtyFlag = true;
    }

    public String getPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginId();
        }
        return this.pssyssfpluginid;
    }

    public boolean isPSSysSFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginIdDirty();
        }
        return this.pssyssfpluginidDirtyFlag;
    }

    public void resetPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginId();
            return;
        }
        this.pssyssfpluginidDirtyFlag = false;
        this.pssyssfpluginid = null;
    }

    public void setPSSysSFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginname = string;
        this.pssyssfpluginnameDirtyFlag = true;
    }

    public String getPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginName();
        }
        return this.pssyssfpluginname;
    }

    public boolean isPSSysSFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginNameDirty();
        }
        return this.pssyssfpluginnameDirtyFlag;
    }

    public void resetPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginName();
            return;
        }
        this.pssyssfpluginnameDirtyFlag = false;
        this.pssyssfpluginname = null;
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

    public void setTemplCodeEx(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCodeEx(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcodeex = string;
        this.templcodeexDirtyFlag = true;
    }

    public String getTemplCodeEx() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCodeEx();
        }
        return this.templcodeex;
    }

    public boolean isTemplCodeExDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCodeExDirty();
        }
        return this.templcodeexDirtyFlag;
    }

    public void resetTemplCodeEx() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCodeEx();
            return;
        }
        this.templcodeexDirtyFlag = false;
        this.templcodeex = null;
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
        PSSysSFPITemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysSFPITemplBase pSSysSFPITemplBase) {
        pSSysSFPITemplBase.resetCodeMap();
        pSSysSFPITemplBase.resetCreateDate();
        pSSysSFPITemplBase.resetCreateMan();
        pSSysSFPITemplBase.resetMemo();
        pSSysSFPITemplBase.resetPSSFId();
        pSSysSFPITemplBase.resetPSSFName();
        pSSysSFPITemplBase.resetPSSysDynaModelId();
        pSSysSFPITemplBase.resetPSSysDynaModelName();
        pSSysSFPITemplBase.resetPSSysSFPITemplId();
        pSSysSFPITemplBase.resetPSSysSFPITemplName();
        pSSysSFPITemplBase.resetPSSysSFPluginId();
        pSSysSFPITemplBase.resetPSSysSFPluginName();
        pSSysSFPITemplBase.resetTemplCode();
        pSSysSFPITemplBase.resetTemplCode2();
        pSSysSFPITemplBase.resetTemplCode2Ex();
        pSSysSFPITemplBase.resetTemplCode3();
        pSSysSFPITemplBase.resetTemplCode4();
        pSSysSFPITemplBase.resetTemplCode5();
        pSSysSFPITemplBase.resetTemplCode6();
        pSSysSFPITemplBase.resetTemplCodeEx();
        pSSysSFPITemplBase.resetUpdateDate();
        pSSysSFPITemplBase.resetUpdateMan();
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSSFIdDirty()) {
            hashMap.put(FIELD_PSSFID, this.getPSSFId());
        }
        if (!bl || this.isPSSFNameDirty()) {
            hashMap.put(FIELD_PSSFNAME, this.getPSSFName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysSFPITemplIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPITEMPLID, this.getPSSysSFPITemplId());
        }
        if (!bl || this.isPSSysSFPITemplNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPITEMPLNAME, this.getPSSysSFPITemplName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
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
        if (!bl || this.isTemplCode3Dirty()) {
            hashMap.put(FIELD_TEMPLCODE3, this.getTemplCode3());
        }
        if (!bl || this.isTemplCode4Dirty()) {
            hashMap.put(FIELD_TEMPLCODE4, this.getTemplCode4());
        }
        if (!bl || this.isTemplCode5Dirty()) {
            hashMap.put(FIELD_TEMPLCODE5, this.getTemplCode5());
        }
        if (!bl || this.isTemplCode6Dirty()) {
            hashMap.put(FIELD_TEMPLCODE6, this.getTemplCode6());
        }
        if (!bl || this.isTemplCodeExDirty()) {
            hashMap.put(FIELD_TEMPLCODEEX, this.getTemplCodeEx());
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
        return PSSysSFPITemplBase.get(this, n);
    }

    private static Object get(PSSysSFPITemplBase pSSysSFPITemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSFPITemplBase.getCodeMap();
            }
            case 1: {
                return pSSysSFPITemplBase.getCreateDate();
            }
            case 2: {
                return pSSysSFPITemplBase.getCreateMan();
            }
            case 3: {
                return pSSysSFPITemplBase.getMemo();
            }
            case 4: {
                return pSSysSFPITemplBase.getPSSFId();
            }
            case 5: {
                return pSSysSFPITemplBase.getPSSFName();
            }
            case 6: {
                return pSSysSFPITemplBase.getPSSysDynaModelId();
            }
            case 7: {
                return pSSysSFPITemplBase.getPSSysDynaModelName();
            }
            case 8: {
                return pSSysSFPITemplBase.getPSSysSFPITemplId();
            }
            case 9: {
                return pSSysSFPITemplBase.getPSSysSFPITemplName();
            }
            case 10: {
                return pSSysSFPITemplBase.getPSSysSFPluginId();
            }
            case 11: {
                return pSSysSFPITemplBase.getPSSysSFPluginName();
            }
            case 12: {
                return pSSysSFPITemplBase.getTemplCode();
            }
            case 13: {
                return pSSysSFPITemplBase.getTemplCode2();
            }
            case 14: {
                return pSSysSFPITemplBase.getTemplCode2Ex();
            }
            case 15: {
                return pSSysSFPITemplBase.getTemplCode3();
            }
            case 16: {
                return pSSysSFPITemplBase.getTemplCode4();
            }
            case 17: {
                return pSSysSFPITemplBase.getTemplCode5();
            }
            case 18: {
                return pSSysSFPITemplBase.getTemplCode6();
            }
            case 19: {
                return pSSysSFPITemplBase.getTemplCodeEx();
            }
            case 20: {
                return pSSysSFPITemplBase.getUpdateDate();
            }
            case 21: {
                return pSSysSFPITemplBase.getUpdateMan();
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
        PSSysSFPITemplBase.set(this, n, object);
    }

    private static void set(PSSysSFPITemplBase pSSysSFPITemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysSFPITemplBase.setCodeMap(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysSFPITemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysSFPITemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysSFPITemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysSFPITemplBase.setPSSFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysSFPITemplBase.setPSSFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysSFPITemplBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysSFPITemplBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysSFPITemplBase.setPSSysSFPITemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysSFPITemplBase.setPSSysSFPITemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysSFPITemplBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysSFPITemplBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysSFPITemplBase.setTemplCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysSFPITemplBase.setTemplCode2(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysSFPITemplBase.setTemplCode2Ex(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysSFPITemplBase.setTemplCode3(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysSFPITemplBase.setTemplCode4(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysSFPITemplBase.setTemplCode5(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysSFPITemplBase.setTemplCode6(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysSFPITemplBase.setTemplCodeEx(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysSFPITemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 21: {
                pSSysSFPITemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysSFPITemplBase.isNull(this, n);
    }

    private static boolean isNull(PSSysSFPITemplBase pSSysSFPITemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSFPITemplBase.getCodeMap() == null;
            }
            case 1: {
                return pSSysSFPITemplBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysSFPITemplBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysSFPITemplBase.getMemo() == null;
            }
            case 4: {
                return pSSysSFPITemplBase.getPSSFId() == null;
            }
            case 5: {
                return pSSysSFPITemplBase.getPSSFName() == null;
            }
            case 6: {
                return pSSysSFPITemplBase.getPSSysDynaModelId() == null;
            }
            case 7: {
                return pSSysSFPITemplBase.getPSSysDynaModelName() == null;
            }
            case 8: {
                return pSSysSFPITemplBase.getPSSysSFPITemplId() == null;
            }
            case 9: {
                return pSSysSFPITemplBase.getPSSysSFPITemplName() == null;
            }
            case 10: {
                return pSSysSFPITemplBase.getPSSysSFPluginId() == null;
            }
            case 11: {
                return pSSysSFPITemplBase.getPSSysSFPluginName() == null;
            }
            case 12: {
                return pSSysSFPITemplBase.getTemplCode() == null;
            }
            case 13: {
                return pSSysSFPITemplBase.getTemplCode2() == null;
            }
            case 14: {
                return pSSysSFPITemplBase.getTemplCode2Ex() == null;
            }
            case 15: {
                return pSSysSFPITemplBase.getTemplCode3() == null;
            }
            case 16: {
                return pSSysSFPITemplBase.getTemplCode4() == null;
            }
            case 17: {
                return pSSysSFPITemplBase.getTemplCode5() == null;
            }
            case 18: {
                return pSSysSFPITemplBase.getTemplCode6() == null;
            }
            case 19: {
                return pSSysSFPITemplBase.getTemplCodeEx() == null;
            }
            case 20: {
                return pSSysSFPITemplBase.getUpdateDate() == null;
            }
            case 21: {
                return pSSysSFPITemplBase.getUpdateMan() == null;
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
        return PSSysSFPITemplBase.contains(this, n);
    }

    private static boolean contains(PSSysSFPITemplBase pSSysSFPITemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysSFPITemplBase.isCodeMapDirty();
            }
            case 1: {
                return pSSysSFPITemplBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysSFPITemplBase.isCreateManDirty();
            }
            case 3: {
                return pSSysSFPITemplBase.isMemoDirty();
            }
            case 4: {
                return pSSysSFPITemplBase.isPSSFIdDirty();
            }
            case 5: {
                return pSSysSFPITemplBase.isPSSFNameDirty();
            }
            case 6: {
                return pSSysSFPITemplBase.isPSSysDynaModelIdDirty();
            }
            case 7: {
                return pSSysSFPITemplBase.isPSSysDynaModelNameDirty();
            }
            case 8: {
                return pSSysSFPITemplBase.isPSSysSFPITemplIdDirty();
            }
            case 9: {
                return pSSysSFPITemplBase.isPSSysSFPITemplNameDirty();
            }
            case 10: {
                return pSSysSFPITemplBase.isPSSysSFPluginIdDirty();
            }
            case 11: {
                return pSSysSFPITemplBase.isPSSysSFPluginNameDirty();
            }
            case 12: {
                return pSSysSFPITemplBase.isTemplCodeDirty();
            }
            case 13: {
                return pSSysSFPITemplBase.isTemplCode2Dirty();
            }
            case 14: {
                return pSSysSFPITemplBase.isTemplCode2ExDirty();
            }
            case 15: {
                return pSSysSFPITemplBase.isTemplCode3Dirty();
            }
            case 16: {
                return pSSysSFPITemplBase.isTemplCode4Dirty();
            }
            case 17: {
                return pSSysSFPITemplBase.isTemplCode5Dirty();
            }
            case 18: {
                return pSSysSFPITemplBase.isTemplCode6Dirty();
            }
            case 19: {
                return pSSysSFPITemplBase.isTemplCodeExDirty();
            }
            case 20: {
                return pSSysSFPITemplBase.isUpdateDateDirty();
            }
            case 21: {
                return pSSysSFPITemplBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysSFPITemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysSFPITemplBase pSSysSFPITemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysSFPITemplBase.getCodeMap() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codemap", (Object)PSSysSFPITemplBase.getJSONValue((Object)pSSysSFPITemplBase.getCodeMap()), (boolean)false);
        }
        if (bl || pSSysSFPITemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysSFPITemplBase.getJSONValue((Object)pSSysSFPITemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysSFPITemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysSFPITemplBase.getJSONValue((Object)pSSysSFPITemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysSFPITemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysSFPITemplBase.getJSONValue((Object)pSSysSFPITemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysSFPITemplBase.getPSSFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfid", (Object)PSSysSFPITemplBase.getJSONValue((Object)pSSysSFPITemplBase.getPSSFId()), (boolean)false);
        }
        if (bl || pSSysSFPITemplBase.getPSSFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfname", (Object)PSSysSFPITemplBase.getJSONValue((Object)pSSysSFPITemplBase.getPSSFName()), (boolean)false);
        }
        if (bl || pSSysSFPITemplBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysSFPITemplBase.getJSONValue((Object)pSSysSFPITemplBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysSFPITemplBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysSFPITemplBase.getJSONValue((Object)pSSysSFPITemplBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysSFPITemplBase.getPSSysSFPITemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpitemplid", (Object)PSSysSFPITemplBase.getJSONValue((Object)pSSysSFPITemplBase.getPSSysSFPITemplId()), (boolean)false);
        }
        if (bl || pSSysSFPITemplBase.getPSSysSFPITemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpitemplname", (Object)PSSysSFPITemplBase.getJSONValue((Object)pSSysSFPITemplBase.getPSSysSFPITemplName()), (boolean)false);
        }
        if (bl || pSSysSFPITemplBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysSFPITemplBase.getJSONValue((Object)pSSysSFPITemplBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysSFPITemplBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysSFPITemplBase.getJSONValue((Object)pSSysSFPITemplBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysSFPITemplBase.getTemplCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode", (Object)PSSysSFPITemplBase.getJSONValue((Object)pSSysSFPITemplBase.getTemplCode()), (boolean)false);
        }
        if (bl || pSSysSFPITemplBase.getTemplCode2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode2", (Object)PSSysSFPITemplBase.getJSONValue((Object)pSSysSFPITemplBase.getTemplCode2()), (boolean)false);
        }
        if (bl || pSSysSFPITemplBase.getTemplCode2Ex() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode2ex", (Object)PSSysSFPITemplBase.getJSONValue((Object)pSSysSFPITemplBase.getTemplCode2Ex()), (boolean)false);
        }
        if (bl || pSSysSFPITemplBase.getTemplCode3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode3", (Object)PSSysSFPITemplBase.getJSONValue((Object)pSSysSFPITemplBase.getTemplCode3()), (boolean)false);
        }
        if (bl || pSSysSFPITemplBase.getTemplCode4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode4", (Object)PSSysSFPITemplBase.getJSONValue((Object)pSSysSFPITemplBase.getTemplCode4()), (boolean)false);
        }
        if (bl || pSSysSFPITemplBase.getTemplCode5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode5", (Object)PSSysSFPITemplBase.getJSONValue((Object)pSSysSFPITemplBase.getTemplCode5()), (boolean)false);
        }
        if (bl || pSSysSFPITemplBase.getTemplCode6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode6", (Object)PSSysSFPITemplBase.getJSONValue((Object)pSSysSFPITemplBase.getTemplCode6()), (boolean)false);
        }
        if (bl || pSSysSFPITemplBase.getTemplCodeEx() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcodeex", (Object)PSSysSFPITemplBase.getJSONValue((Object)pSSysSFPITemplBase.getTemplCodeEx()), (boolean)false);
        }
        if (bl || pSSysSFPITemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysSFPITemplBase.getJSONValue((Object)pSSysSFPITemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysSFPITemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysSFPITemplBase.getJSONValue((Object)pSSysSFPITemplBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysSFPITemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysSFPITemplBase pSSysSFPITemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysSFPITemplBase.getCodeMap() != null) {
            object = pSSysSFPITemplBase.getCodeMap();
            xmlNode.setAttribute(FIELD_CODEMAP, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPITemplBase.getCreateDate() != null) {
            object = pSSysSFPITemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSFPITemplBase.getCreateMan() != null) {
            object = pSSysSFPITemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPITemplBase.getMemo() != null) {
            object = pSSysSFPITemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPITemplBase.getPSSFId() != null) {
            object = pSSysSFPITemplBase.getPSSFId();
            xmlNode.setAttribute(FIELD_PSSFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPITemplBase.getPSSFName() != null) {
            object = pSSysSFPITemplBase.getPSSFName();
            xmlNode.setAttribute(FIELD_PSSFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPITemplBase.getPSSysDynaModelId() != null) {
            object = pSSysSFPITemplBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPITemplBase.getPSSysDynaModelName() != null) {
            object = pSSysSFPITemplBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPITemplBase.getPSSysSFPITemplId() != null) {
            object = pSSysSFPITemplBase.getPSSysSFPITemplId();
            xmlNode.setAttribute(FIELD_PSSYSSFPITEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPITemplBase.getPSSysSFPITemplName() != null) {
            object = pSSysSFPITemplBase.getPSSysSFPITemplName();
            xmlNode.setAttribute(FIELD_PSSYSSFPITEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPITemplBase.getPSSysSFPluginId() != null) {
            object = pSSysSFPITemplBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPITemplBase.getPSSysSFPluginName() != null) {
            object = pSSysSFPITemplBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPITemplBase.getTemplCode() != null) {
            object = pSSysSFPITemplBase.getTemplCode();
            xmlNode.setAttribute(FIELD_TEMPLCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPITemplBase.getTemplCode2() != null) {
            object = pSSysSFPITemplBase.getTemplCode2();
            xmlNode.setAttribute(FIELD_TEMPLCODE2, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPITemplBase.getTemplCode2Ex() != null) {
            object = pSSysSFPITemplBase.getTemplCode2Ex();
            xmlNode.setAttribute(FIELD_TEMPLCODE2EX, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPITemplBase.getTemplCode3() != null) {
            object = pSSysSFPITemplBase.getTemplCode3();
            xmlNode.setAttribute(FIELD_TEMPLCODE3, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPITemplBase.getTemplCode4() != null) {
            object = pSSysSFPITemplBase.getTemplCode4();
            xmlNode.setAttribute(FIELD_TEMPLCODE4, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPITemplBase.getTemplCode5() != null) {
            object = pSSysSFPITemplBase.getTemplCode5();
            xmlNode.setAttribute(FIELD_TEMPLCODE5, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPITemplBase.getTemplCode6() != null) {
            object = pSSysSFPITemplBase.getTemplCode6();
            xmlNode.setAttribute(FIELD_TEMPLCODE6, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPITemplBase.getTemplCodeEx() != null) {
            object = pSSysSFPITemplBase.getTemplCodeEx();
            xmlNode.setAttribute(FIELD_TEMPLCODEEX, object == null ? "" : (String)object);
        }
        if (bl || pSSysSFPITemplBase.getUpdateDate() != null) {
            object = pSSysSFPITemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysSFPITemplBase.getUpdateMan() != null) {
            object = pSSysSFPITemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysSFPITemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysSFPITemplBase pSSysSFPITemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysSFPITemplBase.isCodeMapDirty() && (bl || pSSysSFPITemplBase.getCodeMap() != null)) {
            iDataObject.set(FIELD_CODEMAP, (Object)pSSysSFPITemplBase.getCodeMap());
        }
        if (pSSysSFPITemplBase.isCreateDateDirty() && (bl || pSSysSFPITemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysSFPITemplBase.getCreateDate());
        }
        if (pSSysSFPITemplBase.isCreateManDirty() && (bl || pSSysSFPITemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysSFPITemplBase.getCreateMan());
        }
        if (pSSysSFPITemplBase.isMemoDirty() && (bl || pSSysSFPITemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysSFPITemplBase.getMemo());
        }
        if (pSSysSFPITemplBase.isPSSFIdDirty() && (bl || pSSysSFPITemplBase.getPSSFId() != null)) {
            iDataObject.set(FIELD_PSSFID, (Object)pSSysSFPITemplBase.getPSSFId());
        }
        if (pSSysSFPITemplBase.isPSSFNameDirty() && (bl || pSSysSFPITemplBase.getPSSFName() != null)) {
            iDataObject.set(FIELD_PSSFNAME, (Object)pSSysSFPITemplBase.getPSSFName());
        }
        if (pSSysSFPITemplBase.isPSSysDynaModelIdDirty() && (bl || pSSysSFPITemplBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysSFPITemplBase.getPSSysDynaModelId());
        }
        if (pSSysSFPITemplBase.isPSSysDynaModelNameDirty() && (bl || pSSysSFPITemplBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysSFPITemplBase.getPSSysDynaModelName());
        }
        if (pSSysSFPITemplBase.isPSSysSFPITemplIdDirty() && (bl || pSSysSFPITemplBase.getPSSysSFPITemplId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPITEMPLID, (Object)pSSysSFPITemplBase.getPSSysSFPITemplId());
        }
        if (pSSysSFPITemplBase.isPSSysSFPITemplNameDirty() && (bl || pSSysSFPITemplBase.getPSSysSFPITemplName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPITEMPLNAME, (Object)pSSysSFPITemplBase.getPSSysSFPITemplName());
        }
        if (pSSysSFPITemplBase.isPSSysSFPluginIdDirty() && (bl || pSSysSFPITemplBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysSFPITemplBase.getPSSysSFPluginId());
        }
        if (pSSysSFPITemplBase.isPSSysSFPluginNameDirty() && (bl || pSSysSFPITemplBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysSFPITemplBase.getPSSysSFPluginName());
        }
        if (pSSysSFPITemplBase.isTemplCodeDirty() && (bl || pSSysSFPITemplBase.getTemplCode() != null)) {
            iDataObject.set(FIELD_TEMPLCODE, (Object)pSSysSFPITemplBase.getTemplCode());
        }
        if (pSSysSFPITemplBase.isTemplCode2Dirty() && (bl || pSSysSFPITemplBase.getTemplCode2() != null)) {
            iDataObject.set(FIELD_TEMPLCODE2, (Object)pSSysSFPITemplBase.getTemplCode2());
        }
        if (pSSysSFPITemplBase.isTemplCode2ExDirty() && (bl || pSSysSFPITemplBase.getTemplCode2Ex() != null)) {
            iDataObject.set(FIELD_TEMPLCODE2EX, (Object)pSSysSFPITemplBase.getTemplCode2Ex());
        }
        if (pSSysSFPITemplBase.isTemplCode3Dirty() && (bl || pSSysSFPITemplBase.getTemplCode3() != null)) {
            iDataObject.set(FIELD_TEMPLCODE3, (Object)pSSysSFPITemplBase.getTemplCode3());
        }
        if (pSSysSFPITemplBase.isTemplCode4Dirty() && (bl || pSSysSFPITemplBase.getTemplCode4() != null)) {
            iDataObject.set(FIELD_TEMPLCODE4, (Object)pSSysSFPITemplBase.getTemplCode4());
        }
        if (pSSysSFPITemplBase.isTemplCode5Dirty() && (bl || pSSysSFPITemplBase.getTemplCode5() != null)) {
            iDataObject.set(FIELD_TEMPLCODE5, (Object)pSSysSFPITemplBase.getTemplCode5());
        }
        if (pSSysSFPITemplBase.isTemplCode6Dirty() && (bl || pSSysSFPITemplBase.getTemplCode6() != null)) {
            iDataObject.set(FIELD_TEMPLCODE6, (Object)pSSysSFPITemplBase.getTemplCode6());
        }
        if (pSSysSFPITemplBase.isTemplCodeExDirty() && (bl || pSSysSFPITemplBase.getTemplCodeEx() != null)) {
            iDataObject.set(FIELD_TEMPLCODEEX, (Object)pSSysSFPITemplBase.getTemplCodeEx());
        }
        if (pSSysSFPITemplBase.isUpdateDateDirty() && (bl || pSSysSFPITemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysSFPITemplBase.getUpdateDate());
        }
        if (pSSysSFPITemplBase.isUpdateManDirty() && (bl || pSSysSFPITemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysSFPITemplBase.getUpdateMan());
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
        return PSSysSFPITemplBase.remove(this, n);
    }

    private static boolean remove(PSSysSFPITemplBase pSSysSFPITemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysSFPITemplBase.resetCodeMap();
                return true;
            }
            case 1: {
                pSSysSFPITemplBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysSFPITemplBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysSFPITemplBase.resetMemo();
                return true;
            }
            case 4: {
                pSSysSFPITemplBase.resetPSSFId();
                return true;
            }
            case 5: {
                pSSysSFPITemplBase.resetPSSFName();
                return true;
            }
            case 6: {
                pSSysSFPITemplBase.resetPSSysDynaModelId();
                return true;
            }
            case 7: {
                pSSysSFPITemplBase.resetPSSysDynaModelName();
                return true;
            }
            case 8: {
                pSSysSFPITemplBase.resetPSSysSFPITemplId();
                return true;
            }
            case 9: {
                pSSysSFPITemplBase.resetPSSysSFPITemplName();
                return true;
            }
            case 10: {
                pSSysSFPITemplBase.resetPSSysSFPluginId();
                return true;
            }
            case 11: {
                pSSysSFPITemplBase.resetPSSysSFPluginName();
                return true;
            }
            case 12: {
                pSSysSFPITemplBase.resetTemplCode();
                return true;
            }
            case 13: {
                pSSysSFPITemplBase.resetTemplCode2();
                return true;
            }
            case 14: {
                pSSysSFPITemplBase.resetTemplCode2Ex();
                return true;
            }
            case 15: {
                pSSysSFPITemplBase.resetTemplCode3();
                return true;
            }
            case 16: {
                pSSysSFPITemplBase.resetTemplCode4();
                return true;
            }
            case 17: {
                pSSysSFPITemplBase.resetTemplCode5();
                return true;
            }
            case 18: {
                pSSysSFPITemplBase.resetTemplCode6();
                return true;
            }
            case 19: {
                pSSysSFPITemplBase.resetTemplCodeEx();
                return true;
            }
            case 20: {
                pSSysSFPITemplBase.resetUpdateDate();
                return true;
            }
            case 21: {
                pSSysSFPITemplBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSF getPSSF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSF();
        }
        if (this.getPSSFId() == null) {
            return null;
        }
        Integer n = this.objPSSFLock;
        synchronized (n) {
            if (this.pssf != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFId(), (Object)this.pssf.getPSSFId()) != 0L) {
                this.pssf = null;
            }
            if (this.pssf == null) {
                PSSF pSSF = new PSSF();
                pSSF.setPSSFId(this.getPSSFId());
                PSSFService pSSFService = (PSSFService)ServiceGlobal.getService(PSSFService.class, (SessionFactory)this.getSessionFactory());
                pSSFService.autoGet((IEntity)pSSF);
                this.pssf = pSSF;
            }
            return this.pssf;
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
    public PSSysSFPlugin getPSSysSFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPlugin();
        }
        if (this.getPSSysSFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysSFPluginLock;
        synchronized (n) {
            if (this.pssyssfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSFPluginId(), (Object)this.pssyssfplugin.getPSSysSFPluginId()) != 0L) {
                this.pssyssfplugin = null;
            }
            if (this.pssyssfplugin == null) {
                PSSysSFPlugin pSSysSFPlugin = new PSSysSFPlugin();
                pSSysSFPlugin.setPSSysSFPluginId(this.getPSSysSFPluginId());
                PSSysSFPluginService pSSysSFPluginService = (PSSysSFPluginService)ServiceGlobal.getService(PSSysSFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysSFPluginService.autoGet((IEntity)pSSysSFPlugin);
                this.pssyssfplugin = pSSysSFPlugin;
            }
            return this.pssyssfplugin;
        }
    }

    private PSSysSFPITemplBase getProxyEntity() {
        return this.proxyPSSysSFPITemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysSFPITemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysSFPITemplBase) {
            this.proxyPSSysSFPITemplBase = (PSSysSFPITemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPITemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODEMAP, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSSFID, 4);
        fieldIndexMap.put(FIELD_PSSFNAME, 5);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 6);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 7);
        fieldIndexMap.put(FIELD_PSSYSSFPITEMPLID, 8);
        fieldIndexMap.put(FIELD_PSSYSSFPITEMPLNAME, 9);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 10);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 11);
        fieldIndexMap.put(FIELD_TEMPLCODE, 12);
        fieldIndexMap.put(FIELD_TEMPLCODE2, 13);
        fieldIndexMap.put(FIELD_TEMPLCODE2EX, 14);
        fieldIndexMap.put(FIELD_TEMPLCODE3, 15);
        fieldIndexMap.put(FIELD_TEMPLCODE4, 16);
        fieldIndexMap.put(FIELD_TEMPLCODE5, 17);
        fieldIndexMap.put(FIELD_TEMPLCODE6, 18);
        fieldIndexMap.put(FIELD_TEMPLCODEEX, 19);
        fieldIndexMap.put(FIELD_UPDATEDATE, 20);
        fieldIndexMap.put(FIELD_UPDATEMAN, 21);
    }
}

