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
package net.ibizsys.pscore.srv.devcenter.entity;

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
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCPFPlugin;
import net.ibizsys.pscore.srv.devcenter.service.PSDCPFPluginService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCPFPITemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCPFPITemplBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCPFPITEMPLID = "PSDCPFPITEMPLID";
    public static final String FIELD_PSDCPFPITEMPLNAME = "PSDCPFPITEMPLNAME";
    public static final String FIELD_PSDCPFPLUGINID = "PSDCPFPLUGINID";
    public static final String FIELD_PSDCPFPLUGINNAME = "PSDCPFPLUGINNAME";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
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
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDCPFPITEMPLID = 3;
    private static final int INDEX_PSDCPFPITEMPLNAME = 4;
    private static final int INDEX_PSDCPFPLUGINID = 5;
    private static final int INDEX_PSDCPFPLUGINNAME = 6;
    private static final int INDEX_PSPFID = 7;
    private static final int INDEX_PSPFNAME = 8;
    private static final int INDEX_TEMPLCODE = 9;
    private static final int INDEX_TEMPLCODE2 = 10;
    private static final int INDEX_TEMPLCODE2EX = 11;
    private static final int INDEX_TEMPLCODE2FLAG = 12;
    private static final int INDEX_TEMPLCODE2INFO = 13;
    private static final int INDEX_TEMPLCODE3 = 14;
    private static final int INDEX_TEMPLCODE3FLAG = 15;
    private static final int INDEX_TEMPLCODE3INFO = 16;
    private static final int INDEX_TEMPLCODE4 = 17;
    private static final int INDEX_TEMPLCODE4FLAG = 18;
    private static final int INDEX_TEMPLCODE4INFO = 19;
    private static final int INDEX_TEMPLCODE5 = 20;
    private static final int INDEX_TEMPLCODE6 = 21;
    private static final int INDEX_TEMPLCODEFLAG = 22;
    private static final int INDEX_TEMPLCODEINFO = 23;
    private static final int INDEX_UPDATEDATE = 24;
    private static final int INDEX_UPDATEMAN = 25;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCPFPITemplBase proxyPSDCPFPITemplBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcpfpitemplidDirtyFlag = false;
    private boolean psdcpfpitemplnameDirtyFlag = false;
    private boolean psdcpfpluginidDirtyFlag = false;
    private boolean psdcpfpluginnameDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
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
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcpfpitemplid")
    private String psdcpfpitemplid;
    @Column(name="psdcpfpitemplname")
    private String psdcpfpitemplname;
    @Column(name="psdcpfpluginid")
    private String psdcpfpluginid;
    @Column(name="psdcpfpluginname")
    private String psdcpfpluginname;
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfname")
    private String pspfname;
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
    private Integer objPSDCPFPluginLock = new Integer(1);
    private PSDCPFPlugin psdcpfplugin = null;
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

    public void setPSDCPFPITemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCPFPITemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcpfpitemplid = string;
        this.psdcpfpitemplidDirtyFlag = true;
    }

    public String getPSDCPFPITemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCPFPITemplId();
        }
        return this.psdcpfpitemplid;
    }

    public boolean isPSDCPFPITemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCPFPITemplIdDirty();
        }
        return this.psdcpfpitemplidDirtyFlag;
    }

    public void resetPSDCPFPITemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCPFPITemplId();
            return;
        }
        this.psdcpfpitemplidDirtyFlag = false;
        this.psdcpfpitemplid = null;
    }

    public void setPSDCPFPITemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCPFPITemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcpfpitemplname = string;
        this.psdcpfpitemplnameDirtyFlag = true;
    }

    public String getPSDCPFPITemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCPFPITemplName();
        }
        return this.psdcpfpitemplname;
    }

    public boolean isPSDCPFPITemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCPFPITemplNameDirty();
        }
        return this.psdcpfpitemplnameDirtyFlag;
    }

    public void resetPSDCPFPITemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCPFPITemplName();
            return;
        }
        this.psdcpfpitemplnameDirtyFlag = false;
        this.psdcpfpitemplname = null;
    }

    public void setPSDCPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcpfpluginid = string;
        this.psdcpfpluginidDirtyFlag = true;
    }

    public String getPSDCPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCPFPluginId();
        }
        return this.psdcpfpluginid;
    }

    public boolean isPSDCPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCPFPluginIdDirty();
        }
        return this.psdcpfpluginidDirtyFlag;
    }

    public void resetPSDCPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCPFPluginId();
            return;
        }
        this.psdcpfpluginidDirtyFlag = false;
        this.psdcpfpluginid = null;
    }

    public void setPSDCPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcpfpluginname = string;
        this.psdcpfpluginnameDirtyFlag = true;
    }

    public String getPSDCPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCPFPluginName();
        }
        return this.psdcpfpluginname;
    }

    public boolean isPSDCPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCPFPluginNameDirty();
        }
        return this.psdcpfpluginnameDirtyFlag;
    }

    public void resetPSDCPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCPFPluginName();
            return;
        }
        this.psdcpfpluginnameDirtyFlag = false;
        this.psdcpfpluginname = null;
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
        PSDCPFPITemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCPFPITemplBase pSDCPFPITemplBase) {
        pSDCPFPITemplBase.resetCreateDate();
        pSDCPFPITemplBase.resetCreateMan();
        pSDCPFPITemplBase.resetMemo();
        pSDCPFPITemplBase.resetPSDCPFPITemplId();
        pSDCPFPITemplBase.resetPSDCPFPITemplName();
        pSDCPFPITemplBase.resetPSDCPFPluginId();
        pSDCPFPITemplBase.resetPSDCPFPluginName();
        pSDCPFPITemplBase.resetPSPFId();
        pSDCPFPITemplBase.resetPSPFName();
        pSDCPFPITemplBase.resetTemplCode();
        pSDCPFPITemplBase.resetTemplCode2();
        pSDCPFPITemplBase.resetTemplCode2Ex();
        pSDCPFPITemplBase.resetTemplCode2Flag();
        pSDCPFPITemplBase.resetTemplCode2Info();
        pSDCPFPITemplBase.resetTemplCode3();
        pSDCPFPITemplBase.resetTemplCode3Flag();
        pSDCPFPITemplBase.resetTemplCode3Info();
        pSDCPFPITemplBase.resetTemplCode4();
        pSDCPFPITemplBase.resetTemplCode4Flag();
        pSDCPFPITemplBase.resetTemplCode4Info();
        pSDCPFPITemplBase.resetTemplCode5();
        pSDCPFPITemplBase.resetTemplCode6();
        pSDCPFPITemplBase.resetTemplCodeFlag();
        pSDCPFPITemplBase.resetTemplCodeInfo();
        pSDCPFPITemplBase.resetUpdateDate();
        pSDCPFPITemplBase.resetUpdateMan();
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
        if (!bl || this.isPSDCPFPITemplIdDirty()) {
            hashMap.put(FIELD_PSDCPFPITEMPLID, this.getPSDCPFPITemplId());
        }
        if (!bl || this.isPSDCPFPITemplNameDirty()) {
            hashMap.put(FIELD_PSDCPFPITEMPLNAME, this.getPSDCPFPITemplName());
        }
        if (!bl || this.isPSDCPFPluginIdDirty()) {
            hashMap.put(FIELD_PSDCPFPLUGINID, this.getPSDCPFPluginId());
        }
        if (!bl || this.isPSDCPFPluginNameDirty()) {
            hashMap.put(FIELD_PSDCPFPLUGINNAME, this.getPSDCPFPluginName());
        }
        if (!bl || this.isPSPFIdDirty()) {
            hashMap.put(FIELD_PSPFID, this.getPSPFId());
        }
        if (!bl || this.isPSPFNameDirty()) {
            hashMap.put(FIELD_PSPFNAME, this.getPSPFName());
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
        return PSDCPFPITemplBase.get(this, n);
    }

    private static Object get(PSDCPFPITemplBase pSDCPFPITemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCPFPITemplBase.getCreateDate();
            }
            case 1: {
                return pSDCPFPITemplBase.getCreateMan();
            }
            case 2: {
                return pSDCPFPITemplBase.getMemo();
            }
            case 3: {
                return pSDCPFPITemplBase.getPSDCPFPITemplId();
            }
            case 4: {
                return pSDCPFPITemplBase.getPSDCPFPITemplName();
            }
            case 5: {
                return pSDCPFPITemplBase.getPSDCPFPluginId();
            }
            case 6: {
                return pSDCPFPITemplBase.getPSDCPFPluginName();
            }
            case 7: {
                return pSDCPFPITemplBase.getPSPFId();
            }
            case 8: {
                return pSDCPFPITemplBase.getPSPFName();
            }
            case 9: {
                return pSDCPFPITemplBase.getTemplCode();
            }
            case 10: {
                return pSDCPFPITemplBase.getTemplCode2();
            }
            case 11: {
                return pSDCPFPITemplBase.getTemplCode2Ex();
            }
            case 12: {
                return pSDCPFPITemplBase.getTemplCode2Flag();
            }
            case 13: {
                return pSDCPFPITemplBase.getTemplCode2Info();
            }
            case 14: {
                return pSDCPFPITemplBase.getTemplCode3();
            }
            case 15: {
                return pSDCPFPITemplBase.getTemplCode3Flag();
            }
            case 16: {
                return pSDCPFPITemplBase.getTemplCode3Info();
            }
            case 17: {
                return pSDCPFPITemplBase.getTemplCode4();
            }
            case 18: {
                return pSDCPFPITemplBase.getTemplCode4Flag();
            }
            case 19: {
                return pSDCPFPITemplBase.getTemplCode4Info();
            }
            case 20: {
                return pSDCPFPITemplBase.getTemplCode5();
            }
            case 21: {
                return pSDCPFPITemplBase.getTemplCode6();
            }
            case 22: {
                return pSDCPFPITemplBase.getTemplCodeFlag();
            }
            case 23: {
                return pSDCPFPITemplBase.getTemplCodeInfo();
            }
            case 24: {
                return pSDCPFPITemplBase.getUpdateDate();
            }
            case 25: {
                return pSDCPFPITemplBase.getUpdateMan();
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
        PSDCPFPITemplBase.set(this, n, object);
    }

    private static void set(PSDCPFPITemplBase pSDCPFPITemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCPFPITemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCPFPITemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCPFPITemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCPFPITemplBase.setPSDCPFPITemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCPFPITemplBase.setPSDCPFPITemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCPFPITemplBase.setPSDCPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCPFPITemplBase.setPSDCPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCPFPITemplBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCPFPITemplBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCPFPITemplBase.setTemplCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCPFPITemplBase.setTemplCode2(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCPFPITemplBase.setTemplCode2Ex(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCPFPITemplBase.setTemplCode2Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDCPFPITemplBase.setTemplCode2Info(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCPFPITemplBase.setTemplCode3(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCPFPITemplBase.setTemplCode3Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDCPFPITemplBase.setTemplCode3Info(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDCPFPITemplBase.setTemplCode4(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDCPFPITemplBase.setTemplCode4Flag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSDCPFPITemplBase.setTemplCode4Info(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDCPFPITemplBase.setTemplCode5(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDCPFPITemplBase.setTemplCode6(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDCPFPITemplBase.setTemplCodeFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSDCPFPITemplBase.setTemplCodeInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDCPFPITemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 25: {
                pSDCPFPITemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCPFPITemplBase.isNull(this, n);
    }

    private static boolean isNull(PSDCPFPITemplBase pSDCPFPITemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCPFPITemplBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCPFPITemplBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCPFPITemplBase.getMemo() == null;
            }
            case 3: {
                return pSDCPFPITemplBase.getPSDCPFPITemplId() == null;
            }
            case 4: {
                return pSDCPFPITemplBase.getPSDCPFPITemplName() == null;
            }
            case 5: {
                return pSDCPFPITemplBase.getPSDCPFPluginId() == null;
            }
            case 6: {
                return pSDCPFPITemplBase.getPSDCPFPluginName() == null;
            }
            case 7: {
                return pSDCPFPITemplBase.getPSPFId() == null;
            }
            case 8: {
                return pSDCPFPITemplBase.getPSPFName() == null;
            }
            case 9: {
                return pSDCPFPITemplBase.getTemplCode() == null;
            }
            case 10: {
                return pSDCPFPITemplBase.getTemplCode2() == null;
            }
            case 11: {
                return pSDCPFPITemplBase.getTemplCode2Ex() == null;
            }
            case 12: {
                return pSDCPFPITemplBase.getTemplCode2Flag() == null;
            }
            case 13: {
                return pSDCPFPITemplBase.getTemplCode2Info() == null;
            }
            case 14: {
                return pSDCPFPITemplBase.getTemplCode3() == null;
            }
            case 15: {
                return pSDCPFPITemplBase.getTemplCode3Flag() == null;
            }
            case 16: {
                return pSDCPFPITemplBase.getTemplCode3Info() == null;
            }
            case 17: {
                return pSDCPFPITemplBase.getTemplCode4() == null;
            }
            case 18: {
                return pSDCPFPITemplBase.getTemplCode4Flag() == null;
            }
            case 19: {
                return pSDCPFPITemplBase.getTemplCode4Info() == null;
            }
            case 20: {
                return pSDCPFPITemplBase.getTemplCode5() == null;
            }
            case 21: {
                return pSDCPFPITemplBase.getTemplCode6() == null;
            }
            case 22: {
                return pSDCPFPITemplBase.getTemplCodeFlag() == null;
            }
            case 23: {
                return pSDCPFPITemplBase.getTemplCodeInfo() == null;
            }
            case 24: {
                return pSDCPFPITemplBase.getUpdateDate() == null;
            }
            case 25: {
                return pSDCPFPITemplBase.getUpdateMan() == null;
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
        return PSDCPFPITemplBase.contains(this, n);
    }

    private static boolean contains(PSDCPFPITemplBase pSDCPFPITemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCPFPITemplBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCPFPITemplBase.isCreateManDirty();
            }
            case 2: {
                return pSDCPFPITemplBase.isMemoDirty();
            }
            case 3: {
                return pSDCPFPITemplBase.isPSDCPFPITemplIdDirty();
            }
            case 4: {
                return pSDCPFPITemplBase.isPSDCPFPITemplNameDirty();
            }
            case 5: {
                return pSDCPFPITemplBase.isPSDCPFPluginIdDirty();
            }
            case 6: {
                return pSDCPFPITemplBase.isPSDCPFPluginNameDirty();
            }
            case 7: {
                return pSDCPFPITemplBase.isPSPFIdDirty();
            }
            case 8: {
                return pSDCPFPITemplBase.isPSPFNameDirty();
            }
            case 9: {
                return pSDCPFPITemplBase.isTemplCodeDirty();
            }
            case 10: {
                return pSDCPFPITemplBase.isTemplCode2Dirty();
            }
            case 11: {
                return pSDCPFPITemplBase.isTemplCode2ExDirty();
            }
            case 12: {
                return pSDCPFPITemplBase.isTemplCode2FlagDirty();
            }
            case 13: {
                return pSDCPFPITemplBase.isTemplCode2InfoDirty();
            }
            case 14: {
                return pSDCPFPITemplBase.isTemplCode3Dirty();
            }
            case 15: {
                return pSDCPFPITemplBase.isTemplCode3FlagDirty();
            }
            case 16: {
                return pSDCPFPITemplBase.isTemplCode3InfoDirty();
            }
            case 17: {
                return pSDCPFPITemplBase.isTemplCode4Dirty();
            }
            case 18: {
                return pSDCPFPITemplBase.isTemplCode4FlagDirty();
            }
            case 19: {
                return pSDCPFPITemplBase.isTemplCode4InfoDirty();
            }
            case 20: {
                return pSDCPFPITemplBase.isTemplCode5Dirty();
            }
            case 21: {
                return pSDCPFPITemplBase.isTemplCode6Dirty();
            }
            case 22: {
                return pSDCPFPITemplBase.isTemplCodeFlagDirty();
            }
            case 23: {
                return pSDCPFPITemplBase.isTemplCodeInfoDirty();
            }
            case 24: {
                return pSDCPFPITemplBase.isUpdateDateDirty();
            }
            case 25: {
                return pSDCPFPITemplBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCPFPITemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCPFPITemplBase pSDCPFPITemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCPFPITemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCPFPITemplBase.getJSONValue((Object)pSDCPFPITemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCPFPITemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCPFPITemplBase.getJSONValue((Object)pSDCPFPITemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCPFPITemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCPFPITemplBase.getJSONValue((Object)pSDCPFPITemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCPFPITemplBase.getPSDCPFPITemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcpfpitemplid", (Object)PSDCPFPITemplBase.getJSONValue((Object)pSDCPFPITemplBase.getPSDCPFPITemplId()), (boolean)false);
        }
        if (bl || pSDCPFPITemplBase.getPSDCPFPITemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcpfpitemplname", (Object)PSDCPFPITemplBase.getJSONValue((Object)pSDCPFPITemplBase.getPSDCPFPITemplName()), (boolean)false);
        }
        if (bl || pSDCPFPITemplBase.getPSDCPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcpfpluginid", (Object)PSDCPFPITemplBase.getJSONValue((Object)pSDCPFPITemplBase.getPSDCPFPluginId()), (boolean)false);
        }
        if (bl || pSDCPFPITemplBase.getPSDCPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcpfpluginname", (Object)PSDCPFPITemplBase.getJSONValue((Object)pSDCPFPITemplBase.getPSDCPFPluginName()), (boolean)false);
        }
        if (bl || pSDCPFPITemplBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSDCPFPITemplBase.getJSONValue((Object)pSDCPFPITemplBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSDCPFPITemplBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSDCPFPITemplBase.getJSONValue((Object)pSDCPFPITemplBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSDCPFPITemplBase.getTemplCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode", (Object)PSDCPFPITemplBase.getJSONValue((Object)pSDCPFPITemplBase.getTemplCode()), (boolean)false);
        }
        if (bl || pSDCPFPITemplBase.getTemplCode2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode2", (Object)PSDCPFPITemplBase.getJSONValue((Object)pSDCPFPITemplBase.getTemplCode2()), (boolean)false);
        }
        if (bl || pSDCPFPITemplBase.getTemplCode2Ex() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode2ex", (Object)PSDCPFPITemplBase.getJSONValue((Object)pSDCPFPITemplBase.getTemplCode2Ex()), (boolean)false);
        }
        if (bl || pSDCPFPITemplBase.getTemplCode2Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode2flag", (Object)PSDCPFPITemplBase.getJSONValue((Object)pSDCPFPITemplBase.getTemplCode2Flag()), (boolean)false);
        }
        if (bl || pSDCPFPITemplBase.getTemplCode2Info() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode2info", (Object)PSDCPFPITemplBase.getJSONValue((Object)pSDCPFPITemplBase.getTemplCode2Info()), (boolean)false);
        }
        if (bl || pSDCPFPITemplBase.getTemplCode3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode3", (Object)PSDCPFPITemplBase.getJSONValue((Object)pSDCPFPITemplBase.getTemplCode3()), (boolean)false);
        }
        if (bl || pSDCPFPITemplBase.getTemplCode3Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode3flag", (Object)PSDCPFPITemplBase.getJSONValue((Object)pSDCPFPITemplBase.getTemplCode3Flag()), (boolean)false);
        }
        if (bl || pSDCPFPITemplBase.getTemplCode3Info() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode3info", (Object)PSDCPFPITemplBase.getJSONValue((Object)pSDCPFPITemplBase.getTemplCode3Info()), (boolean)false);
        }
        if (bl || pSDCPFPITemplBase.getTemplCode4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode4", (Object)PSDCPFPITemplBase.getJSONValue((Object)pSDCPFPITemplBase.getTemplCode4()), (boolean)false);
        }
        if (bl || pSDCPFPITemplBase.getTemplCode4Flag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode4flag", (Object)PSDCPFPITemplBase.getJSONValue((Object)pSDCPFPITemplBase.getTemplCode4Flag()), (boolean)false);
        }
        if (bl || pSDCPFPITemplBase.getTemplCode4Info() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode4info", (Object)PSDCPFPITemplBase.getJSONValue((Object)pSDCPFPITemplBase.getTemplCode4Info()), (boolean)false);
        }
        if (bl || pSDCPFPITemplBase.getTemplCode5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode5", (Object)PSDCPFPITemplBase.getJSONValue((Object)pSDCPFPITemplBase.getTemplCode5()), (boolean)false);
        }
        if (bl || pSDCPFPITemplBase.getTemplCode6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode6", (Object)PSDCPFPITemplBase.getJSONValue((Object)pSDCPFPITemplBase.getTemplCode6()), (boolean)false);
        }
        if (bl || pSDCPFPITemplBase.getTemplCodeFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcodeflag", (Object)PSDCPFPITemplBase.getJSONValue((Object)pSDCPFPITemplBase.getTemplCodeFlag()), (boolean)false);
        }
        if (bl || pSDCPFPITemplBase.getTemplCodeInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcodeinfo", (Object)PSDCPFPITemplBase.getJSONValue((Object)pSDCPFPITemplBase.getTemplCodeInfo()), (boolean)false);
        }
        if (bl || pSDCPFPITemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCPFPITemplBase.getJSONValue((Object)pSDCPFPITemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCPFPITemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCPFPITemplBase.getJSONValue((Object)pSDCPFPITemplBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCPFPITemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCPFPITemplBase pSDCPFPITemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCPFPITemplBase.getCreateDate() != null) {
            object = pSDCPFPITemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCPFPITemplBase.getCreateMan() != null) {
            object = pSDCPFPITemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCPFPITemplBase.getMemo() != null) {
            object = pSDCPFPITemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCPFPITemplBase.getPSDCPFPITemplId() != null) {
            object = pSDCPFPITemplBase.getPSDCPFPITemplId();
            xmlNode.setAttribute(FIELD_PSDCPFPITEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDCPFPITemplBase.getPSDCPFPITemplName() != null) {
            object = pSDCPFPITemplBase.getPSDCPFPITemplName();
            xmlNode.setAttribute(FIELD_PSDCPFPITEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCPFPITemplBase.getPSDCPFPluginId() != null) {
            object = pSDCPFPITemplBase.getPSDCPFPluginId();
            xmlNode.setAttribute(FIELD_PSDCPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDCPFPITemplBase.getPSDCPFPluginName() != null) {
            object = pSDCPFPITemplBase.getPSDCPFPluginName();
            xmlNode.setAttribute(FIELD_PSDCPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCPFPITemplBase.getPSPFId() != null) {
            object = pSDCPFPITemplBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSDCPFPITemplBase.getPSPFName() != null) {
            object = pSDCPFPITemplBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCPFPITemplBase.getTemplCode() != null) {
            object = pSDCPFPITemplBase.getTemplCode();
            xmlNode.setAttribute(FIELD_TEMPLCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDCPFPITemplBase.getTemplCode2() != null) {
            object = pSDCPFPITemplBase.getTemplCode2();
            xmlNode.setAttribute(FIELD_TEMPLCODE2, object == null ? "" : (String)object);
        }
        if (bl || pSDCPFPITemplBase.getTemplCode2Ex() != null) {
            object = pSDCPFPITemplBase.getTemplCode2Ex();
            xmlNode.setAttribute(FIELD_TEMPLCODE2EX, object == null ? "" : (String)object);
        }
        if (bl || pSDCPFPITemplBase.getTemplCode2Flag() != null) {
            object = pSDCPFPITemplBase.getTemplCode2Flag();
            xmlNode.setAttribute(FIELD_TEMPLCODE2FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCPFPITemplBase.getTemplCode2Info() != null) {
            object = pSDCPFPITemplBase.getTemplCode2Info();
            xmlNode.setAttribute(FIELD_TEMPLCODE2INFO, object == null ? "" : (String)object);
        }
        if (bl || pSDCPFPITemplBase.getTemplCode3() != null) {
            object = pSDCPFPITemplBase.getTemplCode3();
            xmlNode.setAttribute(FIELD_TEMPLCODE3, object == null ? "" : (String)object);
        }
        if (bl || pSDCPFPITemplBase.getTemplCode3Flag() != null) {
            object = pSDCPFPITemplBase.getTemplCode3Flag();
            xmlNode.setAttribute(FIELD_TEMPLCODE3FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCPFPITemplBase.getTemplCode3Info() != null) {
            object = pSDCPFPITemplBase.getTemplCode3Info();
            xmlNode.setAttribute(FIELD_TEMPLCODE3INFO, object == null ? "" : (String)object);
        }
        if (bl || pSDCPFPITemplBase.getTemplCode4() != null) {
            object = pSDCPFPITemplBase.getTemplCode4();
            xmlNode.setAttribute(FIELD_TEMPLCODE4, object == null ? "" : (String)object);
        }
        if (bl || pSDCPFPITemplBase.getTemplCode4Flag() != null) {
            object = pSDCPFPITemplBase.getTemplCode4Flag();
            xmlNode.setAttribute(FIELD_TEMPLCODE4FLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCPFPITemplBase.getTemplCode4Info() != null) {
            object = pSDCPFPITemplBase.getTemplCode4Info();
            xmlNode.setAttribute(FIELD_TEMPLCODE4INFO, object == null ? "" : (String)object);
        }
        if (bl || pSDCPFPITemplBase.getTemplCode5() != null) {
            object = pSDCPFPITemplBase.getTemplCode5();
            xmlNode.setAttribute(FIELD_TEMPLCODE5, object == null ? "" : (String)object);
        }
        if (bl || pSDCPFPITemplBase.getTemplCode6() != null) {
            object = pSDCPFPITemplBase.getTemplCode6();
            xmlNode.setAttribute(FIELD_TEMPLCODE6, object == null ? "" : (String)object);
        }
        if (bl || pSDCPFPITemplBase.getTemplCodeFlag() != null) {
            object = pSDCPFPITemplBase.getTemplCodeFlag();
            xmlNode.setAttribute(FIELD_TEMPLCODEFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCPFPITemplBase.getTemplCodeInfo() != null) {
            object = pSDCPFPITemplBase.getTemplCodeInfo();
            xmlNode.setAttribute(FIELD_TEMPLCODEINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDCPFPITemplBase.getUpdateDate() != null) {
            object = pSDCPFPITemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCPFPITemplBase.getUpdateMan() != null) {
            object = pSDCPFPITemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCPFPITemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCPFPITemplBase pSDCPFPITemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCPFPITemplBase.isCreateDateDirty() && (bl || pSDCPFPITemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCPFPITemplBase.getCreateDate());
        }
        if (pSDCPFPITemplBase.isCreateManDirty() && (bl || pSDCPFPITemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCPFPITemplBase.getCreateMan());
        }
        if (pSDCPFPITemplBase.isMemoDirty() && (bl || pSDCPFPITemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCPFPITemplBase.getMemo());
        }
        if (pSDCPFPITemplBase.isPSDCPFPITemplIdDirty() && (bl || pSDCPFPITemplBase.getPSDCPFPITemplId() != null)) {
            iDataObject.set(FIELD_PSDCPFPITEMPLID, (Object)pSDCPFPITemplBase.getPSDCPFPITemplId());
        }
        if (pSDCPFPITemplBase.isPSDCPFPITemplNameDirty() && (bl || pSDCPFPITemplBase.getPSDCPFPITemplName() != null)) {
            iDataObject.set(FIELD_PSDCPFPITEMPLNAME, (Object)pSDCPFPITemplBase.getPSDCPFPITemplName());
        }
        if (pSDCPFPITemplBase.isPSDCPFPluginIdDirty() && (bl || pSDCPFPITemplBase.getPSDCPFPluginId() != null)) {
            iDataObject.set(FIELD_PSDCPFPLUGINID, (Object)pSDCPFPITemplBase.getPSDCPFPluginId());
        }
        if (pSDCPFPITemplBase.isPSDCPFPluginNameDirty() && (bl || pSDCPFPITemplBase.getPSDCPFPluginName() != null)) {
            iDataObject.set(FIELD_PSDCPFPLUGINNAME, (Object)pSDCPFPITemplBase.getPSDCPFPluginName());
        }
        if (pSDCPFPITemplBase.isPSPFIdDirty() && (bl || pSDCPFPITemplBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSDCPFPITemplBase.getPSPFId());
        }
        if (pSDCPFPITemplBase.isPSPFNameDirty() && (bl || pSDCPFPITemplBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSDCPFPITemplBase.getPSPFName());
        }
        if (pSDCPFPITemplBase.isTemplCodeDirty() && (bl || pSDCPFPITemplBase.getTemplCode() != null)) {
            iDataObject.set(FIELD_TEMPLCODE, (Object)pSDCPFPITemplBase.getTemplCode());
        }
        if (pSDCPFPITemplBase.isTemplCode2Dirty() && (bl || pSDCPFPITemplBase.getTemplCode2() != null)) {
            iDataObject.set(FIELD_TEMPLCODE2, (Object)pSDCPFPITemplBase.getTemplCode2());
        }
        if (pSDCPFPITemplBase.isTemplCode2ExDirty() && (bl || pSDCPFPITemplBase.getTemplCode2Ex() != null)) {
            iDataObject.set(FIELD_TEMPLCODE2EX, (Object)pSDCPFPITemplBase.getTemplCode2Ex());
        }
        if (pSDCPFPITemplBase.isTemplCode2FlagDirty() && (bl || pSDCPFPITemplBase.getTemplCode2Flag() != null)) {
            iDataObject.set(FIELD_TEMPLCODE2FLAG, (Object)pSDCPFPITemplBase.getTemplCode2Flag());
        }
        if (pSDCPFPITemplBase.isTemplCode2InfoDirty() && (bl || pSDCPFPITemplBase.getTemplCode2Info() != null)) {
            iDataObject.set(FIELD_TEMPLCODE2INFO, (Object)pSDCPFPITemplBase.getTemplCode2Info());
        }
        if (pSDCPFPITemplBase.isTemplCode3Dirty() && (bl || pSDCPFPITemplBase.getTemplCode3() != null)) {
            iDataObject.set(FIELD_TEMPLCODE3, (Object)pSDCPFPITemplBase.getTemplCode3());
        }
        if (pSDCPFPITemplBase.isTemplCode3FlagDirty() && (bl || pSDCPFPITemplBase.getTemplCode3Flag() != null)) {
            iDataObject.set(FIELD_TEMPLCODE3FLAG, (Object)pSDCPFPITemplBase.getTemplCode3Flag());
        }
        if (pSDCPFPITemplBase.isTemplCode3InfoDirty() && (bl || pSDCPFPITemplBase.getTemplCode3Info() != null)) {
            iDataObject.set(FIELD_TEMPLCODE3INFO, (Object)pSDCPFPITemplBase.getTemplCode3Info());
        }
        if (pSDCPFPITemplBase.isTemplCode4Dirty() && (bl || pSDCPFPITemplBase.getTemplCode4() != null)) {
            iDataObject.set(FIELD_TEMPLCODE4, (Object)pSDCPFPITemplBase.getTemplCode4());
        }
        if (pSDCPFPITemplBase.isTemplCode4FlagDirty() && (bl || pSDCPFPITemplBase.getTemplCode4Flag() != null)) {
            iDataObject.set(FIELD_TEMPLCODE4FLAG, (Object)pSDCPFPITemplBase.getTemplCode4Flag());
        }
        if (pSDCPFPITemplBase.isTemplCode4InfoDirty() && (bl || pSDCPFPITemplBase.getTemplCode4Info() != null)) {
            iDataObject.set(FIELD_TEMPLCODE4INFO, (Object)pSDCPFPITemplBase.getTemplCode4Info());
        }
        if (pSDCPFPITemplBase.isTemplCode5Dirty() && (bl || pSDCPFPITemplBase.getTemplCode5() != null)) {
            iDataObject.set(FIELD_TEMPLCODE5, (Object)pSDCPFPITemplBase.getTemplCode5());
        }
        if (pSDCPFPITemplBase.isTemplCode6Dirty() && (bl || pSDCPFPITemplBase.getTemplCode6() != null)) {
            iDataObject.set(FIELD_TEMPLCODE6, (Object)pSDCPFPITemplBase.getTemplCode6());
        }
        if (pSDCPFPITemplBase.isTemplCodeFlagDirty() && (bl || pSDCPFPITemplBase.getTemplCodeFlag() != null)) {
            iDataObject.set(FIELD_TEMPLCODEFLAG, (Object)pSDCPFPITemplBase.getTemplCodeFlag());
        }
        if (pSDCPFPITemplBase.isTemplCodeInfoDirty() && (bl || pSDCPFPITemplBase.getTemplCodeInfo() != null)) {
            iDataObject.set(FIELD_TEMPLCODEINFO, (Object)pSDCPFPITemplBase.getTemplCodeInfo());
        }
        if (pSDCPFPITemplBase.isUpdateDateDirty() && (bl || pSDCPFPITemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCPFPITemplBase.getUpdateDate());
        }
        if (pSDCPFPITemplBase.isUpdateManDirty() && (bl || pSDCPFPITemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCPFPITemplBase.getUpdateMan());
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
        return PSDCPFPITemplBase.remove(this, n);
    }

    private static boolean remove(PSDCPFPITemplBase pSDCPFPITemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCPFPITemplBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCPFPITemplBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCPFPITemplBase.resetMemo();
                return true;
            }
            case 3: {
                pSDCPFPITemplBase.resetPSDCPFPITemplId();
                return true;
            }
            case 4: {
                pSDCPFPITemplBase.resetPSDCPFPITemplName();
                return true;
            }
            case 5: {
                pSDCPFPITemplBase.resetPSDCPFPluginId();
                return true;
            }
            case 6: {
                pSDCPFPITemplBase.resetPSDCPFPluginName();
                return true;
            }
            case 7: {
                pSDCPFPITemplBase.resetPSPFId();
                return true;
            }
            case 8: {
                pSDCPFPITemplBase.resetPSPFName();
                return true;
            }
            case 9: {
                pSDCPFPITemplBase.resetTemplCode();
                return true;
            }
            case 10: {
                pSDCPFPITemplBase.resetTemplCode2();
                return true;
            }
            case 11: {
                pSDCPFPITemplBase.resetTemplCode2Ex();
                return true;
            }
            case 12: {
                pSDCPFPITemplBase.resetTemplCode2Flag();
                return true;
            }
            case 13: {
                pSDCPFPITemplBase.resetTemplCode2Info();
                return true;
            }
            case 14: {
                pSDCPFPITemplBase.resetTemplCode3();
                return true;
            }
            case 15: {
                pSDCPFPITemplBase.resetTemplCode3Flag();
                return true;
            }
            case 16: {
                pSDCPFPITemplBase.resetTemplCode3Info();
                return true;
            }
            case 17: {
                pSDCPFPITemplBase.resetTemplCode4();
                return true;
            }
            case 18: {
                pSDCPFPITemplBase.resetTemplCode4Flag();
                return true;
            }
            case 19: {
                pSDCPFPITemplBase.resetTemplCode4Info();
                return true;
            }
            case 20: {
                pSDCPFPITemplBase.resetTemplCode5();
                return true;
            }
            case 21: {
                pSDCPFPITemplBase.resetTemplCode6();
                return true;
            }
            case 22: {
                pSDCPFPITemplBase.resetTemplCodeFlag();
                return true;
            }
            case 23: {
                pSDCPFPITemplBase.resetTemplCodeInfo();
                return true;
            }
            case 24: {
                pSDCPFPITemplBase.resetUpdateDate();
                return true;
            }
            case 25: {
                pSDCPFPITemplBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCPFPlugin getPSDCPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCPFPlugin();
        }
        if (this.getPSDCPFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSDCPFPluginLock;
        synchronized (n) {
            if (this.psdcpfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCPFPluginId(), (Object)this.psdcpfplugin.getPSDCPFPluginId()) != 0L) {
                this.psdcpfplugin = null;
            }
            if (this.psdcpfplugin == null) {
                PSDCPFPlugin pSDCPFPlugin = new PSDCPFPlugin();
                pSDCPFPlugin.setPSDCPFPluginId(this.getPSDCPFPluginId());
                PSDCPFPluginService pSDCPFPluginService = (PSDCPFPluginService)ServiceGlobal.getService(PSDCPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSDCPFPluginService.autoGet((IEntity)pSDCPFPlugin);
                this.psdcpfplugin = pSDCPFPlugin;
            }
            return this.psdcpfplugin;
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

    private PSDCPFPITemplBase getProxyEntity() {
        return this.proxyPSDCPFPITemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCPFPITemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCPFPITemplBase) {
            this.proxyPSDCPFPITemplBase = (PSDCPFPITemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCPFPITemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDCPFPITEMPLID, 3);
        fieldIndexMap.put(FIELD_PSDCPFPITEMPLNAME, 4);
        fieldIndexMap.put(FIELD_PSDCPFPLUGINID, 5);
        fieldIndexMap.put(FIELD_PSDCPFPLUGINNAME, 6);
        fieldIndexMap.put(FIELD_PSPFID, 7);
        fieldIndexMap.put(FIELD_PSPFNAME, 8);
        fieldIndexMap.put(FIELD_TEMPLCODE, 9);
        fieldIndexMap.put(FIELD_TEMPLCODE2, 10);
        fieldIndexMap.put(FIELD_TEMPLCODE2EX, 11);
        fieldIndexMap.put(FIELD_TEMPLCODE2FLAG, 12);
        fieldIndexMap.put(FIELD_TEMPLCODE2INFO, 13);
        fieldIndexMap.put(FIELD_TEMPLCODE3, 14);
        fieldIndexMap.put(FIELD_TEMPLCODE3FLAG, 15);
        fieldIndexMap.put(FIELD_TEMPLCODE3INFO, 16);
        fieldIndexMap.put(FIELD_TEMPLCODE4, 17);
        fieldIndexMap.put(FIELD_TEMPLCODE4FLAG, 18);
        fieldIndexMap.put(FIELD_TEMPLCODE4INFO, 19);
        fieldIndexMap.put(FIELD_TEMPLCODE5, 20);
        fieldIndexMap.put(FIELD_TEMPLCODE6, 21);
        fieldIndexMap.put(FIELD_TEMPLCODEFLAG, 22);
        fieldIndexMap.put(FIELD_TEMPLCODEINFO, 23);
        fieldIndexMap.put(FIELD_UPDATEDATE, 24);
        fieldIndexMap.put(FIELD_UPDATEMAN, 25);
    }
}

