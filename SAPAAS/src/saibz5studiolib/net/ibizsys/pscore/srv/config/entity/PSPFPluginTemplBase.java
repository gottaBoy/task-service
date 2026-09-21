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
package net.ibizsys.pscore.srv.config.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSPFPubCode;
import net.ibizsys.pscore.srv.config.service.PSPFPluginService;
import net.ibizsys.pscore.srv.config.service.PSPFPubCodeService;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFPluginTemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFPluginTemplBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSPFPLUGINID = "PSPFPLUGINID";
    public static final String FIELD_PSPFPLUGINNAME = "PSPFPLUGINNAME";
    public static final String FIELD_PSPFPLUGINTEMPLID = "PSPFPLUGINTEMPLID";
    public static final String FIELD_PSPFPLUGINTEMPLNAME = "PSPFPLUGINTEMPLNAME";
    public static final String FIELD_PSPFPUBCODEID = "PSPFPUBCODEID";
    public static final String FIELD_PSPFPUBCODENAME = "PSPFPUBCODENAME";
    public static final String FIELD_TEMPLCODE = "TEMPLCODE";
    public static final String FIELD_TEMPLCODE2 = "TEMPLCODE2";
    public static final String FIELD_TEMPLCODE3 = "TEMPLCODE3";
    public static final String FIELD_TEMPLCODE4 = "TEMPLCODE4";
    public static final String FIELD_TEMPLDESC = "TEMPLDESC";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSPFID = 3;
    private static final int INDEX_PSPFNAME = 4;
    private static final int INDEX_PSPFPLUGINID = 5;
    private static final int INDEX_PSPFPLUGINNAME = 6;
    private static final int INDEX_PSPFPLUGINTEMPLID = 7;
    private static final int INDEX_PSPFPLUGINTEMPLNAME = 8;
    private static final int INDEX_PSPFPUBCODEID = 9;
    private static final int INDEX_PSPFPUBCODENAME = 10;
    private static final int INDEX_TEMPLCODE = 11;
    private static final int INDEX_TEMPLCODE2 = 12;
    private static final int INDEX_TEMPLCODE3 = 13;
    private static final int INDEX_TEMPLCODE4 = 14;
    private static final int INDEX_TEMPLDESC = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFPluginTemplBase proxyPSPFPluginTemplBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pspfpluginidDirtyFlag = false;
    private boolean pspfpluginnameDirtyFlag = false;
    private boolean pspfplugintemplidDirtyFlag = false;
    private boolean pspfplugintemplnameDirtyFlag = false;
    private boolean pspfpubcodeidDirtyFlag = false;
    private boolean pspfpubcodenameDirtyFlag = false;
    private boolean templcodeDirtyFlag = false;
    private boolean templcode2DirtyFlag = false;
    private boolean templcode3DirtyFlag = false;
    private boolean templcode4DirtyFlag = false;
    private boolean templdescDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfname")
    private String pspfname;
    @Column(name="pspfpluginid")
    private String pspfpluginid;
    @Column(name="pspfpluginname")
    private String pspfpluginname;
    @Column(name="pspfplugintemplid")
    private String pspfplugintemplid;
    @Column(name="pspfplugintemplname")
    private String pspfplugintemplname;
    @Column(name="pspfpubcodeid")
    private String pspfpubcodeid;
    @Column(name="pspfpubcodename")
    private String pspfpubcodename;
    @Column(name="templcode")
    private String templcode;
    @Column(name="templcode2")
    private String templcode2;
    @Column(name="templcode3")
    private String templcode3;
    @Column(name="templcode4")
    private String templcode4;
    @Column(name="templdesc")
    private String templdesc;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSPFPluginLock = new Integer(1);
    private PSPFPlugin pspfplugin = null;
    private Integer objPSPFPubCodeLock = new Integer(1);
    private PSPFPubCode pspfpubcode = null;
    private Integer objPSPFLock = new Integer(1);
    private PSPF pspf = null;

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

    public void setPSPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpluginid = string;
        this.pspfpluginidDirtyFlag = true;
    }

    public String getPSPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPluginId();
        }
        return this.pspfpluginid;
    }

    public boolean isPSPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPluginIdDirty();
        }
        return this.pspfpluginidDirtyFlag;
    }

    public void resetPSPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPluginId();
            return;
        }
        this.pspfpluginidDirtyFlag = false;
        this.pspfpluginid = null;
    }

    public void setPSPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpluginname = string;
        this.pspfpluginnameDirtyFlag = true;
    }

    public String getPSPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPluginName();
        }
        return this.pspfpluginname;
    }

    public boolean isPSPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPluginNameDirty();
        }
        return this.pspfpluginnameDirtyFlag;
    }

    public void resetPSPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPluginName();
            return;
        }
        this.pspfpluginnameDirtyFlag = false;
        this.pspfpluginname = null;
    }

    public void setPSPFPluginTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPluginTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfplugintemplid = string;
        this.pspfplugintemplidDirtyFlag = true;
    }

    public String getPSPFPluginTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPluginTemplId();
        }
        return this.pspfplugintemplid;
    }

    public boolean isPSPFPluginTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPluginTemplIdDirty();
        }
        return this.pspfplugintemplidDirtyFlag;
    }

    public void resetPSPFPluginTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPluginTemplId();
            return;
        }
        this.pspfplugintemplidDirtyFlag = false;
        this.pspfplugintemplid = null;
    }

    public void setPSPFPluginTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPluginTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfplugintemplname = string;
        this.pspfplugintemplnameDirtyFlag = true;
    }

    public String getPSPFPluginTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPluginTemplName();
        }
        return this.pspfplugintemplname;
    }

    public boolean isPSPFPluginTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPluginTemplNameDirty();
        }
        return this.pspfplugintemplnameDirtyFlag;
    }

    public void resetPSPFPluginTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPluginTemplName();
            return;
        }
        this.pspfplugintemplnameDirtyFlag = false;
        this.pspfplugintemplname = null;
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

    public void setTemplDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templdesc = string;
        this.templdescDirtyFlag = true;
    }

    public String getTemplDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplDesc();
        }
        return this.templdesc;
    }

    public boolean isTemplDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplDescDirty();
        }
        return this.templdescDirtyFlag;
    }

    public void resetTemplDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplDesc();
            return;
        }
        this.templdescDirtyFlag = false;
        this.templdesc = null;
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
        PSPFPluginTemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFPluginTemplBase pSPFPluginTemplBase) {
        pSPFPluginTemplBase.resetCreateDate();
        pSPFPluginTemplBase.resetCreateMan();
        pSPFPluginTemplBase.resetMemo();
        pSPFPluginTemplBase.resetPSPFId();
        pSPFPluginTemplBase.resetPSPFName();
        pSPFPluginTemplBase.resetPSPFPluginId();
        pSPFPluginTemplBase.resetPSPFPluginName();
        pSPFPluginTemplBase.resetPSPFPluginTemplId();
        pSPFPluginTemplBase.resetPSPFPluginTemplName();
        pSPFPluginTemplBase.resetPSPFPubCodeId();
        pSPFPluginTemplBase.resetPSPFPubCodeName();
        pSPFPluginTemplBase.resetTemplCode();
        pSPFPluginTemplBase.resetTemplCode2();
        pSPFPluginTemplBase.resetTemplCode3();
        pSPFPluginTemplBase.resetTemplCode4();
        pSPFPluginTemplBase.resetTemplDesc();
        pSPFPluginTemplBase.resetUpdateDate();
        pSPFPluginTemplBase.resetUpdateMan();
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
        if (!bl || this.isPSPFIdDirty()) {
            hashMap.put(FIELD_PSPFID, this.getPSPFId());
        }
        if (!bl || this.isPSPFNameDirty()) {
            hashMap.put(FIELD_PSPFNAME, this.getPSPFName());
        }
        if (!bl || this.isPSPFPluginIdDirty()) {
            hashMap.put(FIELD_PSPFPLUGINID, this.getPSPFPluginId());
        }
        if (!bl || this.isPSPFPluginNameDirty()) {
            hashMap.put(FIELD_PSPFPLUGINNAME, this.getPSPFPluginName());
        }
        if (!bl || this.isPSPFPluginTemplIdDirty()) {
            hashMap.put(FIELD_PSPFPLUGINTEMPLID, this.getPSPFPluginTemplId());
        }
        if (!bl || this.isPSPFPluginTemplNameDirty()) {
            hashMap.put(FIELD_PSPFPLUGINTEMPLNAME, this.getPSPFPluginTemplName());
        }
        if (!bl || this.isPSPFPubCodeIdDirty()) {
            hashMap.put(FIELD_PSPFPUBCODEID, this.getPSPFPubCodeId());
        }
        if (!bl || this.isPSPFPubCodeNameDirty()) {
            hashMap.put(FIELD_PSPFPUBCODENAME, this.getPSPFPubCodeName());
        }
        if (!bl || this.isTemplCodeDirty()) {
            hashMap.put(FIELD_TEMPLCODE, this.getTemplCode());
        }
        if (!bl || this.isTemplCode2Dirty()) {
            hashMap.put(FIELD_TEMPLCODE2, this.getTemplCode2());
        }
        if (!bl || this.isTemplCode3Dirty()) {
            hashMap.put(FIELD_TEMPLCODE3, this.getTemplCode3());
        }
        if (!bl || this.isTemplCode4Dirty()) {
            hashMap.put(FIELD_TEMPLCODE4, this.getTemplCode4());
        }
        if (!bl || this.isTemplDescDirty()) {
            hashMap.put(FIELD_TEMPLDESC, this.getTemplDesc());
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
        return PSPFPluginTemplBase.get(this, n);
    }

    private static Object get(PSPFPluginTemplBase pSPFPluginTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPluginTemplBase.getCreateDate();
            }
            case 1: {
                return pSPFPluginTemplBase.getCreateMan();
            }
            case 2: {
                return pSPFPluginTemplBase.getMemo();
            }
            case 3: {
                return pSPFPluginTemplBase.getPSPFId();
            }
            case 4: {
                return pSPFPluginTemplBase.getPSPFName();
            }
            case 5: {
                return pSPFPluginTemplBase.getPSPFPluginId();
            }
            case 6: {
                return pSPFPluginTemplBase.getPSPFPluginName();
            }
            case 7: {
                return pSPFPluginTemplBase.getPSPFPluginTemplId();
            }
            case 8: {
                return pSPFPluginTemplBase.getPSPFPluginTemplName();
            }
            case 9: {
                return pSPFPluginTemplBase.getPSPFPubCodeId();
            }
            case 10: {
                return pSPFPluginTemplBase.getPSPFPubCodeName();
            }
            case 11: {
                return pSPFPluginTemplBase.getTemplCode();
            }
            case 12: {
                return pSPFPluginTemplBase.getTemplCode2();
            }
            case 13: {
                return pSPFPluginTemplBase.getTemplCode3();
            }
            case 14: {
                return pSPFPluginTemplBase.getTemplCode4();
            }
            case 15: {
                return pSPFPluginTemplBase.getTemplDesc();
            }
            case 16: {
                return pSPFPluginTemplBase.getUpdateDate();
            }
            case 17: {
                return pSPFPluginTemplBase.getUpdateMan();
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
        PSPFPluginTemplBase.set(this, n, object);
    }

    private static void set(PSPFPluginTemplBase pSPFPluginTemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFPluginTemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSPFPluginTemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPFPluginTemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPFPluginTemplBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPFPluginTemplBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPFPluginTemplBase.setPSPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPFPluginTemplBase.setPSPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPFPluginTemplBase.setPSPFPluginTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPFPluginTemplBase.setPSPFPluginTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPFPluginTemplBase.setPSPFPubCodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPFPluginTemplBase.setPSPFPubCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPFPluginTemplBase.setTemplCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSPFPluginTemplBase.setTemplCode2(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSPFPluginTemplBase.setTemplCode3(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSPFPluginTemplBase.setTemplCode4(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSPFPluginTemplBase.setTemplDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSPFPluginTemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSPFPluginTemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSPFPluginTemplBase.isNull(this, n);
    }

    private static boolean isNull(PSPFPluginTemplBase pSPFPluginTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPluginTemplBase.getCreateDate() == null;
            }
            case 1: {
                return pSPFPluginTemplBase.getCreateMan() == null;
            }
            case 2: {
                return pSPFPluginTemplBase.getMemo() == null;
            }
            case 3: {
                return pSPFPluginTemplBase.getPSPFId() == null;
            }
            case 4: {
                return pSPFPluginTemplBase.getPSPFName() == null;
            }
            case 5: {
                return pSPFPluginTemplBase.getPSPFPluginId() == null;
            }
            case 6: {
                return pSPFPluginTemplBase.getPSPFPluginName() == null;
            }
            case 7: {
                return pSPFPluginTemplBase.getPSPFPluginTemplId() == null;
            }
            case 8: {
                return pSPFPluginTemplBase.getPSPFPluginTemplName() == null;
            }
            case 9: {
                return pSPFPluginTemplBase.getPSPFPubCodeId() == null;
            }
            case 10: {
                return pSPFPluginTemplBase.getPSPFPubCodeName() == null;
            }
            case 11: {
                return pSPFPluginTemplBase.getTemplCode() == null;
            }
            case 12: {
                return pSPFPluginTemplBase.getTemplCode2() == null;
            }
            case 13: {
                return pSPFPluginTemplBase.getTemplCode3() == null;
            }
            case 14: {
                return pSPFPluginTemplBase.getTemplCode4() == null;
            }
            case 15: {
                return pSPFPluginTemplBase.getTemplDesc() == null;
            }
            case 16: {
                return pSPFPluginTemplBase.getUpdateDate() == null;
            }
            case 17: {
                return pSPFPluginTemplBase.getUpdateMan() == null;
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
        return PSPFPluginTemplBase.contains(this, n);
    }

    private static boolean contains(PSPFPluginTemplBase pSPFPluginTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPluginTemplBase.isCreateDateDirty();
            }
            case 1: {
                return pSPFPluginTemplBase.isCreateManDirty();
            }
            case 2: {
                return pSPFPluginTemplBase.isMemoDirty();
            }
            case 3: {
                return pSPFPluginTemplBase.isPSPFIdDirty();
            }
            case 4: {
                return pSPFPluginTemplBase.isPSPFNameDirty();
            }
            case 5: {
                return pSPFPluginTemplBase.isPSPFPluginIdDirty();
            }
            case 6: {
                return pSPFPluginTemplBase.isPSPFPluginNameDirty();
            }
            case 7: {
                return pSPFPluginTemplBase.isPSPFPluginTemplIdDirty();
            }
            case 8: {
                return pSPFPluginTemplBase.isPSPFPluginTemplNameDirty();
            }
            case 9: {
                return pSPFPluginTemplBase.isPSPFPubCodeIdDirty();
            }
            case 10: {
                return pSPFPluginTemplBase.isPSPFPubCodeNameDirty();
            }
            case 11: {
                return pSPFPluginTemplBase.isTemplCodeDirty();
            }
            case 12: {
                return pSPFPluginTemplBase.isTemplCode2Dirty();
            }
            case 13: {
                return pSPFPluginTemplBase.isTemplCode3Dirty();
            }
            case 14: {
                return pSPFPluginTemplBase.isTemplCode4Dirty();
            }
            case 15: {
                return pSPFPluginTemplBase.isTemplDescDirty();
            }
            case 16: {
                return pSPFPluginTemplBase.isUpdateDateDirty();
            }
            case 17: {
                return pSPFPluginTemplBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFPluginTemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFPluginTemplBase pSPFPluginTemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFPluginTemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFPluginTemplBase.getJSONValue((Object)pSPFPluginTemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFPluginTemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFPluginTemplBase.getJSONValue((Object)pSPFPluginTemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFPluginTemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPFPluginTemplBase.getJSONValue((Object)pSPFPluginTemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSPFPluginTemplBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSPFPluginTemplBase.getJSONValue((Object)pSPFPluginTemplBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSPFPluginTemplBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSPFPluginTemplBase.getJSONValue((Object)pSPFPluginTemplBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSPFPluginTemplBase.getPSPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpluginid", (Object)PSPFPluginTemplBase.getJSONValue((Object)pSPFPluginTemplBase.getPSPFPluginId()), (boolean)false);
        }
        if (bl || pSPFPluginTemplBase.getPSPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpluginname", (Object)PSPFPluginTemplBase.getJSONValue((Object)pSPFPluginTemplBase.getPSPFPluginName()), (boolean)false);
        }
        if (bl || pSPFPluginTemplBase.getPSPFPluginTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfplugintemplid", (Object)PSPFPluginTemplBase.getJSONValue((Object)pSPFPluginTemplBase.getPSPFPluginTemplId()), (boolean)false);
        }
        if (bl || pSPFPluginTemplBase.getPSPFPluginTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfplugintemplname", (Object)PSPFPluginTemplBase.getJSONValue((Object)pSPFPluginTemplBase.getPSPFPluginTemplName()), (boolean)false);
        }
        if (bl || pSPFPluginTemplBase.getPSPFPubCodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpubcodeid", (Object)PSPFPluginTemplBase.getJSONValue((Object)pSPFPluginTemplBase.getPSPFPubCodeId()), (boolean)false);
        }
        if (bl || pSPFPluginTemplBase.getPSPFPubCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpubcodename", (Object)PSPFPluginTemplBase.getJSONValue((Object)pSPFPluginTemplBase.getPSPFPubCodeName()), (boolean)false);
        }
        if (bl || pSPFPluginTemplBase.getTemplCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode", (Object)PSPFPluginTemplBase.getJSONValue((Object)pSPFPluginTemplBase.getTemplCode()), (boolean)false);
        }
        if (bl || pSPFPluginTemplBase.getTemplCode2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode2", (Object)PSPFPluginTemplBase.getJSONValue((Object)pSPFPluginTemplBase.getTemplCode2()), (boolean)false);
        }
        if (bl || pSPFPluginTemplBase.getTemplCode3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode3", (Object)PSPFPluginTemplBase.getJSONValue((Object)pSPFPluginTemplBase.getTemplCode3()), (boolean)false);
        }
        if (bl || pSPFPluginTemplBase.getTemplCode4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode4", (Object)PSPFPluginTemplBase.getJSONValue((Object)pSPFPluginTemplBase.getTemplCode4()), (boolean)false);
        }
        if (bl || pSPFPluginTemplBase.getTemplDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templdesc", (Object)PSPFPluginTemplBase.getJSONValue((Object)pSPFPluginTemplBase.getTemplDesc()), (boolean)false);
        }
        if (bl || pSPFPluginTemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFPluginTemplBase.getJSONValue((Object)pSPFPluginTemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFPluginTemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFPluginTemplBase.getJSONValue((Object)pSPFPluginTemplBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFPluginTemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFPluginTemplBase pSPFPluginTemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFPluginTemplBase.getCreateDate() != null) {
            object = pSPFPluginTemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFPluginTemplBase.getCreateMan() != null) {
            object = pSPFPluginTemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginTemplBase.getMemo() != null) {
            object = pSPFPluginTemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginTemplBase.getPSPFId() != null) {
            object = pSPFPluginTemplBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginTemplBase.getPSPFName() != null) {
            object = pSPFPluginTemplBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginTemplBase.getPSPFPluginId() != null) {
            object = pSPFPluginTemplBase.getPSPFPluginId();
            xmlNode.setAttribute(FIELD_PSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginTemplBase.getPSPFPluginName() != null) {
            object = pSPFPluginTemplBase.getPSPFPluginName();
            xmlNode.setAttribute(FIELD_PSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginTemplBase.getPSPFPluginTemplId() != null) {
            object = pSPFPluginTemplBase.getPSPFPluginTemplId();
            xmlNode.setAttribute(FIELD_PSPFPLUGINTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginTemplBase.getPSPFPluginTemplName() != null) {
            object = pSPFPluginTemplBase.getPSPFPluginTemplName();
            xmlNode.setAttribute(FIELD_PSPFPLUGINTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginTemplBase.getPSPFPubCodeId() != null) {
            object = pSPFPluginTemplBase.getPSPFPubCodeId();
            xmlNode.setAttribute(FIELD_PSPFPUBCODEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginTemplBase.getPSPFPubCodeName() != null) {
            object = pSPFPluginTemplBase.getPSPFPubCodeName();
            xmlNode.setAttribute(FIELD_PSPFPUBCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginTemplBase.getTemplCode() != null) {
            object = pSPFPluginTemplBase.getTemplCode();
            xmlNode.setAttribute(FIELD_TEMPLCODE, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginTemplBase.getTemplCode2() != null) {
            object = pSPFPluginTemplBase.getTemplCode2();
            xmlNode.setAttribute(FIELD_TEMPLCODE2, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginTemplBase.getTemplCode3() != null) {
            object = pSPFPluginTemplBase.getTemplCode3();
            xmlNode.setAttribute(FIELD_TEMPLCODE3, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginTemplBase.getTemplCode4() != null) {
            object = pSPFPluginTemplBase.getTemplCode4();
            xmlNode.setAttribute(FIELD_TEMPLCODE4, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginTemplBase.getTemplDesc() != null) {
            object = pSPFPluginTemplBase.getTemplDesc();
            xmlNode.setAttribute(FIELD_TEMPLDESC, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginTemplBase.getUpdateDate() != null) {
            object = pSPFPluginTemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFPluginTemplBase.getUpdateMan() != null) {
            object = pSPFPluginTemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFPluginTemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFPluginTemplBase pSPFPluginTemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFPluginTemplBase.isCreateDateDirty() && (bl || pSPFPluginTemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFPluginTemplBase.getCreateDate());
        }
        if (pSPFPluginTemplBase.isCreateManDirty() && (bl || pSPFPluginTemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFPluginTemplBase.getCreateMan());
        }
        if (pSPFPluginTemplBase.isMemoDirty() && (bl || pSPFPluginTemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPFPluginTemplBase.getMemo());
        }
        if (pSPFPluginTemplBase.isPSPFIdDirty() && (bl || pSPFPluginTemplBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSPFPluginTemplBase.getPSPFId());
        }
        if (pSPFPluginTemplBase.isPSPFNameDirty() && (bl || pSPFPluginTemplBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSPFPluginTemplBase.getPSPFName());
        }
        if (pSPFPluginTemplBase.isPSPFPluginIdDirty() && (bl || pSPFPluginTemplBase.getPSPFPluginId() != null)) {
            iDataObject.set(FIELD_PSPFPLUGINID, (Object)pSPFPluginTemplBase.getPSPFPluginId());
        }
        if (pSPFPluginTemplBase.isPSPFPluginNameDirty() && (bl || pSPFPluginTemplBase.getPSPFPluginName() != null)) {
            iDataObject.set(FIELD_PSPFPLUGINNAME, (Object)pSPFPluginTemplBase.getPSPFPluginName());
        }
        if (pSPFPluginTemplBase.isPSPFPluginTemplIdDirty() && (bl || pSPFPluginTemplBase.getPSPFPluginTemplId() != null)) {
            iDataObject.set(FIELD_PSPFPLUGINTEMPLID, (Object)pSPFPluginTemplBase.getPSPFPluginTemplId());
        }
        if (pSPFPluginTemplBase.isPSPFPluginTemplNameDirty() && (bl || pSPFPluginTemplBase.getPSPFPluginTemplName() != null)) {
            iDataObject.set(FIELD_PSPFPLUGINTEMPLNAME, (Object)pSPFPluginTemplBase.getPSPFPluginTemplName());
        }
        if (pSPFPluginTemplBase.isPSPFPubCodeIdDirty() && (bl || pSPFPluginTemplBase.getPSPFPubCodeId() != null)) {
            iDataObject.set(FIELD_PSPFPUBCODEID, (Object)pSPFPluginTemplBase.getPSPFPubCodeId());
        }
        if (pSPFPluginTemplBase.isPSPFPubCodeNameDirty() && (bl || pSPFPluginTemplBase.getPSPFPubCodeName() != null)) {
            iDataObject.set(FIELD_PSPFPUBCODENAME, (Object)pSPFPluginTemplBase.getPSPFPubCodeName());
        }
        if (pSPFPluginTemplBase.isTemplCodeDirty() && (bl || pSPFPluginTemplBase.getTemplCode() != null)) {
            iDataObject.set(FIELD_TEMPLCODE, (Object)pSPFPluginTemplBase.getTemplCode());
        }
        if (pSPFPluginTemplBase.isTemplCode2Dirty() && (bl || pSPFPluginTemplBase.getTemplCode2() != null)) {
            iDataObject.set(FIELD_TEMPLCODE2, (Object)pSPFPluginTemplBase.getTemplCode2());
        }
        if (pSPFPluginTemplBase.isTemplCode3Dirty() && (bl || pSPFPluginTemplBase.getTemplCode3() != null)) {
            iDataObject.set(FIELD_TEMPLCODE3, (Object)pSPFPluginTemplBase.getTemplCode3());
        }
        if (pSPFPluginTemplBase.isTemplCode4Dirty() && (bl || pSPFPluginTemplBase.getTemplCode4() != null)) {
            iDataObject.set(FIELD_TEMPLCODE4, (Object)pSPFPluginTemplBase.getTemplCode4());
        }
        if (pSPFPluginTemplBase.isTemplDescDirty() && (bl || pSPFPluginTemplBase.getTemplDesc() != null)) {
            iDataObject.set(FIELD_TEMPLDESC, (Object)pSPFPluginTemplBase.getTemplDesc());
        }
        if (pSPFPluginTemplBase.isUpdateDateDirty() && (bl || pSPFPluginTemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFPluginTemplBase.getUpdateDate());
        }
        if (pSPFPluginTemplBase.isUpdateManDirty() && (bl || pSPFPluginTemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFPluginTemplBase.getUpdateMan());
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
        return PSPFPluginTemplBase.remove(this, n);
    }

    private static boolean remove(PSPFPluginTemplBase pSPFPluginTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFPluginTemplBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSPFPluginTemplBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSPFPluginTemplBase.resetMemo();
                return true;
            }
            case 3: {
                pSPFPluginTemplBase.resetPSPFId();
                return true;
            }
            case 4: {
                pSPFPluginTemplBase.resetPSPFName();
                return true;
            }
            case 5: {
                pSPFPluginTemplBase.resetPSPFPluginId();
                return true;
            }
            case 6: {
                pSPFPluginTemplBase.resetPSPFPluginName();
                return true;
            }
            case 7: {
                pSPFPluginTemplBase.resetPSPFPluginTemplId();
                return true;
            }
            case 8: {
                pSPFPluginTemplBase.resetPSPFPluginTemplName();
                return true;
            }
            case 9: {
                pSPFPluginTemplBase.resetPSPFPubCodeId();
                return true;
            }
            case 10: {
                pSPFPluginTemplBase.resetPSPFPubCodeName();
                return true;
            }
            case 11: {
                pSPFPluginTemplBase.resetTemplCode();
                return true;
            }
            case 12: {
                pSPFPluginTemplBase.resetTemplCode2();
                return true;
            }
            case 13: {
                pSPFPluginTemplBase.resetTemplCode3();
                return true;
            }
            case 14: {
                pSPFPluginTemplBase.resetTemplCode4();
                return true;
            }
            case 15: {
                pSPFPluginTemplBase.resetTemplDesc();
                return true;
            }
            case 16: {
                pSPFPluginTemplBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSPFPluginTemplBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFPlugin getPSPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPlugin();
        }
        if (this.getPSPFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSPFPluginLock;
        synchronized (n) {
            if (this.pspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFPluginId(), (Object)this.pspfplugin.getPSPFPluginId()) != 0L) {
                this.pspfplugin = null;
            }
            if (this.pspfplugin == null) {
                PSPFPlugin pSPFPlugin = new PSPFPlugin();
                pSPFPlugin.setPSPFPluginId(this.getPSPFPluginId());
                PSPFPluginService pSPFPluginService = (PSPFPluginService)ServiceGlobal.getService(PSPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSPFPluginService.autoGet((IEntity)pSPFPlugin);
                this.pspfplugin = pSPFPlugin;
            }
            return this.pspfplugin;
        }
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

    private PSPFPluginTemplBase getProxyEntity() {
        return this.proxyPSPFPluginTemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFPluginTemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFPluginTemplBase) {
            this.proxyPSPFPluginTemplBase = (PSPFPluginTemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPluginTemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSPFID, 3);
        fieldIndexMap.put(FIELD_PSPFNAME, 4);
        fieldIndexMap.put(FIELD_PSPFPLUGINID, 5);
        fieldIndexMap.put(FIELD_PSPFPLUGINNAME, 6);
        fieldIndexMap.put(FIELD_PSPFPLUGINTEMPLID, 7);
        fieldIndexMap.put(FIELD_PSPFPLUGINTEMPLNAME, 8);
        fieldIndexMap.put(FIELD_PSPFPUBCODEID, 9);
        fieldIndexMap.put(FIELD_PSPFPUBCODENAME, 10);
        fieldIndexMap.put(FIELD_TEMPLCODE, 11);
        fieldIndexMap.put(FIELD_TEMPLCODE2, 12);
        fieldIndexMap.put(FIELD_TEMPLCODE3, 13);
        fieldIndexMap.put(FIELD_TEMPLCODE4, 14);
        fieldIndexMap.put(FIELD_TEMPLDESC, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
    }
}

