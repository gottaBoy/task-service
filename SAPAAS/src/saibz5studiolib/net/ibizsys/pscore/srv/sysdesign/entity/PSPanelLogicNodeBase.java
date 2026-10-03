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
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLNParam;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicParam;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelLogic;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLNParamService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicNodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicParamService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPanelLogicNodeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPanelLogicNodeBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LEFTPOS = "LEFTPOS";
    public static final String FIELD_LOGICNODETYPE = "LOGICNODETYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PARALLELOUTPUT = "PARALLELOUTPUT";
    public static final String FIELD_PARAM1 = "PARAM1";
    public static final String FIELD_PARAM10 = "PARAM10";
    public static final String FIELD_PARAM11 = "PARAM11";
    public static final String FIELD_PARAM12 = "PARAM12";
    public static final String FIELD_PARAM13 = "PARAM13";
    public static final String FIELD_PARAM14 = "PARAM14";
    public static final String FIELD_PARAM2 = "PARAM2";
    public static final String FIELD_PARAM3 = "PARAM3";
    public static final String FIELD_PARAM4 = "PARAM4";
    public static final String FIELD_PARAM5 = "PARAM5";
    public static final String FIELD_PARAM6 = "PARAM6";
    public static final String FIELD_PARAM7 = "PARAM7";
    public static final String FIELD_PARAM8 = "PARAM8";
    public static final String FIELD_PARAM9 = "PARAM9";
    public static final String FIELD_PSPANELLOGICNODEID = "PSPANELLOGICNODEID";
    public static final String FIELD_PSPANELLOGICNODENAME = "PSPANELLOGICNODENAME";
    public static final String FIELD_PSPANELLOGICPARAMID = "PSPANELLOGICPARAMID";
    public static final String FIELD_PSPANELLOGICPARAMNAME = "PSPANELLOGICPARAMNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String FIELD_PSSYSVIEWPANELITEMID = "PSSYSVIEWPANELITEMID";
    public static final String FIELD_PSSYSVIEWPANELITEMNAME = "PSSYSVIEWPANELITEMNAME";
    public static final String FIELD_PSSYSVIEWPANELLOGICID = "PSSYSVIEWPANELLOGICID";
    public static final String FIELD_PSSYSVIEWPANELLOGICNAME = "PSSYSVIEWPANELLOGICNAME";
    public static final String FIELD_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String FIELD_TOPPOS = "TOPPOS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_LEFTPOS = 3;
    private static final int INDEX_LOGICNODETYPE = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PARALLELOUTPUT = 6;
    private static final int INDEX_PARAM1 = 7;
    private static final int INDEX_PARAM10 = 8;
    private static final int INDEX_PARAM11 = 9;
    private static final int INDEX_PARAM12 = 10;
    private static final int INDEX_PARAM13 = 11;
    private static final int INDEX_PARAM14 = 12;
    private static final int INDEX_PARAM2 = 13;
    private static final int INDEX_PARAM3 = 14;
    private static final int INDEX_PARAM4 = 15;
    private static final int INDEX_PARAM5 = 16;
    private static final int INDEX_PARAM6 = 17;
    private static final int INDEX_PARAM7 = 18;
    private static final int INDEX_PARAM8 = 19;
    private static final int INDEX_PARAM9 = 20;
    private static final int INDEX_PSPANELLOGICNODEID = 21;
    private static final int INDEX_PSPANELLOGICNODENAME = 22;
    private static final int INDEX_PSPANELLOGICPARAMID = 23;
    private static final int INDEX_PSPANELLOGICPARAMNAME = 24;
    private static final int INDEX_PSSYSTEMID = 25;
    private static final int INDEX_PSSYSVIEWPANELID = 26;
    private static final int INDEX_PSSYSVIEWPANELITEMID = 27;
    private static final int INDEX_PSSYSVIEWPANELITEMNAME = 28;
    private static final int INDEX_PSSYSVIEWPANELLOGICID = 29;
    private static final int INDEX_PSSYSVIEWPANELLOGICNAME = 30;
    private static final int INDEX_PSSYSVIEWPANELNAME = 31;
    private static final int INDEX_TOPPOS = 32;
    private static final int INDEX_UPDATEDATE = 33;
    private static final int INDEX_UPDATEMAN = 34;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPanelLogicNodeBase proxyPSPanelLogicNodeBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean leftposDirtyFlag = false;
    private boolean logicnodetypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean paralleloutputDirtyFlag = false;
    private boolean param1DirtyFlag = false;
    private boolean param10DirtyFlag = false;
    private boolean param11DirtyFlag = false;
    private boolean param12DirtyFlag = false;
    private boolean param13DirtyFlag = false;
    private boolean param14DirtyFlag = false;
    private boolean param2DirtyFlag = false;
    private boolean param3DirtyFlag = false;
    private boolean param4DirtyFlag = false;
    private boolean param5DirtyFlag = false;
    private boolean param6DirtyFlag = false;
    private boolean param7DirtyFlag = false;
    private boolean param8DirtyFlag = false;
    private boolean param9DirtyFlag = false;
    private boolean pspanellogicnodeidDirtyFlag = false;
    private boolean pspanellogicnodenameDirtyFlag = false;
    private boolean pspanellogicparamidDirtyFlag = false;
    private boolean pspanellogicparamnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssysviewpanelidDirtyFlag = false;
    private boolean pssysviewpanelitemidDirtyFlag = false;
    private boolean pssysviewpanelitemnameDirtyFlag = false;
    private boolean pssysviewpanellogicidDirtyFlag = false;
    private boolean pssysviewpanellogicnameDirtyFlag = false;
    private boolean pssysviewpanelnameDirtyFlag = false;
    private boolean topposDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="leftpos")
    private Integer leftpos;
    @Column(name="logicnodetype")
    private String logicnodetype;
    @Column(name="memo")
    private String memo;
    @Column(name="paralleloutput")
    private Integer paralleloutput;
    @Column(name="param1")
    private String param1;
    @Column(name="param10")
    private Integer param10;
    @Column(name="param11")
    private String param11;
    @Column(name="param12")
    private String param12;
    @Column(name="param13")
    private String param13;
    @Column(name="param14")
    private String param14;
    @Column(name="param2")
    private String param2;
    @Column(name="param3")
    private String param3;
    @Column(name="param4")
    private String param4;
    @Column(name="param5")
    private String param5;
    @Column(name="param6")
    private String param6;
    @Column(name="param7")
    private Integer param7;
    @Column(name="param8")
    private Integer param8;
    @Column(name="param9")
    private Integer param9;
    @Column(name="pspanellogicnodeid")
    private String pspanellogicnodeid;
    @Column(name="pspanellogicnodename")
    private String pspanellogicnodename;
    @Column(name="pspanellogicparamid")
    private String pspanellogicparamid;
    @Column(name="pspanellogicparamname")
    private String pspanellogicparamname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssysviewpanelid")
    private String pssysviewpanelid;
    @Column(name="pssysviewpanelitemid")
    private String pssysviewpanelitemid;
    @Column(name="pssysviewpanelitemname")
    private String pssysviewpanelitemname;
    @Column(name="pssysviewpanellogicid")
    private String pssysviewpanellogicid;
    @Column(name="pssysviewpanellogicname")
    private String pssysviewpanellogicname;
    @Column(name="pssysviewpanelname")
    private String pssysviewpanelname;
    @Column(name="toppos")
    private Integer toppos;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSPanelLogicParamLock = new Integer(1);
    private PSPanelLogicParam pspanellogicparam = null;
    private Integer objPSSysViewPanelItemLock = new Integer(1);
    private PSSysViewPanelItem pssysviewpanelitem = null;
    private Integer objPSSysViewPanelLogicLock = new Integer(1);
    private PSSysViewPanelLogic pssysviewpanellogic = null;
    private Integer objPSSysViewPanelLock = new Integer(1);
    private PSSysViewPanel pssysviewpanel = null;
    private Integer objPSPanelLNParamsLock = new Integer(1);
    private ArrayList<PSPanelLNParam> pspanellnparams = null;

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

    public void setLeftPos(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLeftPos(n);
            return;
        }
        this.leftpos = n;
        this.leftposDirtyFlag = true;
    }

    public Integer getLeftPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLeftPos();
        }
        return this.leftpos;
    }

    public boolean isLeftPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLeftPosDirty();
        }
        return this.leftposDirtyFlag;
    }

    public void resetLeftPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLeftPos();
            return;
        }
        this.leftposDirtyFlag = false;
        this.leftpos = null;
    }

    public void setLogicNodeType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicNodeType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicnodetype = string;
        this.logicnodetypeDirtyFlag = true;
    }

    public String getLogicNodeType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicNodeType();
        }
        return this.logicnodetype;
    }

    public boolean isLogicNodeTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNodeTypeDirty();
        }
        return this.logicnodetypeDirtyFlag;
    }

    public void resetLogicNodeType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicNodeType();
            return;
        }
        this.logicnodetypeDirtyFlag = false;
        this.logicnodetype = null;
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

    public void setParallelOutput(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParallelOutput(n);
            return;
        }
        this.paralleloutput = n;
        this.paralleloutputDirtyFlag = true;
    }

    public Integer getParallelOutput() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParallelOutput();
        }
        return this.paralleloutput;
    }

    public boolean isParallelOutputDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParallelOutputDirty();
        }
        return this.paralleloutputDirtyFlag;
    }

    public void resetParallelOutput() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParallelOutput();
            return;
        }
        this.paralleloutputDirtyFlag = false;
        this.paralleloutput = null;
    }

    public void setParam1(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam1(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param1 = string;
        this.param1DirtyFlag = true;
    }

    public String getParam1() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam1();
        }
        return this.param1;
    }

    public boolean isParam1Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam1Dirty();
        }
        return this.param1DirtyFlag;
    }

    public void resetParam1() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam1();
            return;
        }
        this.param1DirtyFlag = false;
        this.param1 = null;
    }

    public void setParam10(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam10(n);
            return;
        }
        this.param10 = n;
        this.param10DirtyFlag = true;
    }

    public Integer getParam10() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam10();
        }
        return this.param10;
    }

    public boolean isParam10Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam10Dirty();
        }
        return this.param10DirtyFlag;
    }

    public void resetParam10() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam10();
            return;
        }
        this.param10DirtyFlag = false;
        this.param10 = null;
    }

    public void setParam11(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam11(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param11 = string;
        this.param11DirtyFlag = true;
    }

    public String getParam11() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam11();
        }
        return this.param11;
    }

    public boolean isParam11Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam11Dirty();
        }
        return this.param11DirtyFlag;
    }

    public void resetParam11() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam11();
            return;
        }
        this.param11DirtyFlag = false;
        this.param11 = null;
    }

    public void setParam12(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam12(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param12 = string;
        this.param12DirtyFlag = true;
    }

    public String getParam12() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam12();
        }
        return this.param12;
    }

    public boolean isParam12Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam12Dirty();
        }
        return this.param12DirtyFlag;
    }

    public void resetParam12() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam12();
            return;
        }
        this.param12DirtyFlag = false;
        this.param12 = null;
    }

    public void setParam13(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam13(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param13 = string;
        this.param13DirtyFlag = true;
    }

    public String getParam13() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam13();
        }
        return this.param13;
    }

    public boolean isParam13Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam13Dirty();
        }
        return this.param13DirtyFlag;
    }

    public void resetParam13() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam13();
            return;
        }
        this.param13DirtyFlag = false;
        this.param13 = null;
    }

    public void setParam14(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam14(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param14 = string;
        this.param14DirtyFlag = true;
    }

    public String getParam14() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam14();
        }
        return this.param14;
    }

    public boolean isParam14Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam14Dirty();
        }
        return this.param14DirtyFlag;
    }

    public void resetParam14() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam14();
            return;
        }
        this.param14DirtyFlag = false;
        this.param14 = null;
    }

    public void setParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param2 = string;
        this.param2DirtyFlag = true;
    }

    public String getParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam2();
        }
        return this.param2;
    }

    public boolean isParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam2Dirty();
        }
        return this.param2DirtyFlag;
    }

    public void resetParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam2();
            return;
        }
        this.param2DirtyFlag = false;
        this.param2 = null;
    }

    public void setParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param3 = string;
        this.param3DirtyFlag = true;
    }

    public String getParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam3();
        }
        return this.param3;
    }

    public boolean isParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam3Dirty();
        }
        return this.param3DirtyFlag;
    }

    public void resetParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam3();
            return;
        }
        this.param3DirtyFlag = false;
        this.param3 = null;
    }

    public void setParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param4 = string;
        this.param4DirtyFlag = true;
    }

    public String getParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam4();
        }
        return this.param4;
    }

    public boolean isParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam4Dirty();
        }
        return this.param4DirtyFlag;
    }

    public void resetParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam4();
            return;
        }
        this.param4DirtyFlag = false;
        this.param4 = null;
    }

    public void setParam5(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam5(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param5 = string;
        this.param5DirtyFlag = true;
    }

    public String getParam5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam5();
        }
        return this.param5;
    }

    public boolean isParam5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam5Dirty();
        }
        return this.param5DirtyFlag;
    }

    public void resetParam5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam5();
            return;
        }
        this.param5DirtyFlag = false;
        this.param5 = null;
    }

    public void setParam6(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam6(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.param6 = string;
        this.param6DirtyFlag = true;
    }

    public String getParam6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam6();
        }
        return this.param6;
    }

    public boolean isParam6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam6Dirty();
        }
        return this.param6DirtyFlag;
    }

    public void resetParam6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam6();
            return;
        }
        this.param6DirtyFlag = false;
        this.param6 = null;
    }

    public void setParam7(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam7(n);
            return;
        }
        this.param7 = n;
        this.param7DirtyFlag = true;
    }

    public Integer getParam7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam7();
        }
        return this.param7;
    }

    public boolean isParam7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam7Dirty();
        }
        return this.param7DirtyFlag;
    }

    public void resetParam7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam7();
            return;
        }
        this.param7DirtyFlag = false;
        this.param7 = null;
    }

    public void setParam8(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam8(n);
            return;
        }
        this.param8 = n;
        this.param8DirtyFlag = true;
    }

    public Integer getParam8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam8();
        }
        return this.param8;
    }

    public boolean isParam8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam8Dirty();
        }
        return this.param8DirtyFlag;
    }

    public void resetParam8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam8();
            return;
        }
        this.param8DirtyFlag = false;
        this.param8 = null;
    }

    public void setParam9(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParam9(n);
            return;
        }
        this.param9 = n;
        this.param9DirtyFlag = true;
    }

    public Integer getParam9() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParam9();
        }
        return this.param9;
    }

    public boolean isParam9Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParam9Dirty();
        }
        return this.param9DirtyFlag;
    }

    public void resetParam9() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParam9();
            return;
        }
        this.param9DirtyFlag = false;
        this.param9 = null;
    }

    public void setPSPanelLogicNodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPanelLogicNodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspanellogicnodeid = string;
        this.pspanellogicnodeidDirtyFlag = true;
    }

    public String getPSPanelLogicNodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLogicNodeId();
        }
        return this.pspanellogicnodeid;
    }

    public boolean isPSPanelLogicNodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPanelLogicNodeIdDirty();
        }
        return this.pspanellogicnodeidDirtyFlag;
    }

    public void resetPSPanelLogicNodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPanelLogicNodeId();
            return;
        }
        this.pspanellogicnodeidDirtyFlag = false;
        this.pspanellogicnodeid = null;
    }

    public void setPSPanelLogicNodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPanelLogicNodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspanellogicnodename = string;
        this.pspanellogicnodenameDirtyFlag = true;
    }

    public String getPSPanelLogicNodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLogicNodeName();
        }
        return this.pspanellogicnodename;
    }

    public boolean isPSPanelLogicNodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPanelLogicNodeNameDirty();
        }
        return this.pspanellogicnodenameDirtyFlag;
    }

    public void resetPSPanelLogicNodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPanelLogicNodeName();
            return;
        }
        this.pspanellogicnodenameDirtyFlag = false;
        this.pspanellogicnodename = null;
    }

    public void setPSPanelLogicParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPanelLogicParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspanellogicparamid = string;
        this.pspanellogicparamidDirtyFlag = true;
    }

    public String getPSPanelLogicParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLogicParamId();
        }
        return this.pspanellogicparamid;
    }

    public boolean isPSPanelLogicParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPanelLogicParamIdDirty();
        }
        return this.pspanellogicparamidDirtyFlag;
    }

    public void resetPSPanelLogicParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPanelLogicParamId();
            return;
        }
        this.pspanellogicparamidDirtyFlag = false;
        this.pspanellogicparamid = null;
    }

    public void setPSPanelLogicParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPanelLogicParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspanellogicparamname = string;
        this.pspanellogicparamnameDirtyFlag = true;
    }

    public String getPSPanelLogicParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLogicParamName();
        }
        return this.pspanellogicparamname;
    }

    public boolean isPSPanelLogicParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPanelLogicParamNameDirty();
        }
        return this.pspanellogicparamnameDirtyFlag;
    }

    public void resetPSPanelLogicParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPanelLogicParamName();
            return;
        }
        this.pspanellogicparamnameDirtyFlag = false;
        this.pspanellogicparamname = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setPSSysViewPanelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelid = string;
        this.pssysviewpanelidDirtyFlag = true;
    }

    public String getPSSysViewPanelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelId();
        }
        return this.pssysviewpanelid;
    }

    public boolean isPSSysViewPanelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelIdDirty();
        }
        return this.pssysviewpanelidDirtyFlag;
    }

    public void resetPSSysViewPanelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelId();
            return;
        }
        this.pssysviewpanelidDirtyFlag = false;
        this.pssysviewpanelid = null;
    }

    public void setPSSysViewPanelItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelitemid = string;
        this.pssysviewpanelitemidDirtyFlag = true;
    }

    public String getPSSysViewPanelItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelItemId();
        }
        return this.pssysviewpanelitemid;
    }

    public boolean isPSSysViewPanelItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelItemIdDirty();
        }
        return this.pssysviewpanelitemidDirtyFlag;
    }

    public void resetPSSysViewPanelItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelItemId();
            return;
        }
        this.pssysviewpanelitemidDirtyFlag = false;
        this.pssysviewpanelitemid = null;
    }

    public void setPSSysViewPanelItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelitemname = string;
        this.pssysviewpanelitemnameDirtyFlag = true;
    }

    public String getPSSysViewPanelItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelItemName();
        }
        return this.pssysviewpanelitemname;
    }

    public boolean isPSSysViewPanelItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelItemNameDirty();
        }
        return this.pssysviewpanelitemnameDirtyFlag;
    }

    public void resetPSSysViewPanelItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelItemName();
            return;
        }
        this.pssysviewpanelitemnameDirtyFlag = false;
        this.pssysviewpanelitemname = null;
    }

    public void setPSSysViewPanelLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanellogicid = string;
        this.pssysviewpanellogicidDirtyFlag = true;
    }

    public String getPSSysViewPanelLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelLogicId();
        }
        return this.pssysviewpanellogicid;
    }

    public boolean isPSSysViewPanelLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelLogicIdDirty();
        }
        return this.pssysviewpanellogicidDirtyFlag;
    }

    public void resetPSSysViewPanelLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelLogicId();
            return;
        }
        this.pssysviewpanellogicidDirtyFlag = false;
        this.pssysviewpanellogicid = null;
    }

    public void setPSSysViewPanelLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanellogicname = string;
        this.pssysviewpanellogicnameDirtyFlag = true;
    }

    public String getPSSysViewPanelLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelLogicName();
        }
        return this.pssysviewpanellogicname;
    }

    public boolean isPSSysViewPanelLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelLogicNameDirty();
        }
        return this.pssysviewpanellogicnameDirtyFlag;
    }

    public void resetPSSysViewPanelLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelLogicName();
            return;
        }
        this.pssysviewpanellogicnameDirtyFlag = false;
        this.pssysviewpanellogicname = null;
    }

    public void setPSSysViewPanelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelname = string;
        this.pssysviewpanelnameDirtyFlag = true;
    }

    public String getPSSysViewPanelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelName();
        }
        return this.pssysviewpanelname;
    }

    public boolean isPSSysViewPanelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelNameDirty();
        }
        return this.pssysviewpanelnameDirtyFlag;
    }

    public void resetPSSysViewPanelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelName();
            return;
        }
        this.pssysviewpanelnameDirtyFlag = false;
        this.pssysviewpanelname = null;
    }

    public void setTopPos(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTopPos(n);
            return;
        }
        this.toppos = n;
        this.topposDirtyFlag = true;
    }

    public Integer getTopPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTopPos();
        }
        return this.toppos;
    }

    public boolean isTopPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTopPosDirty();
        }
        return this.topposDirtyFlag;
    }

    public void resetTopPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTopPos();
            return;
        }
        this.topposDirtyFlag = false;
        this.toppos = null;
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
        PSPanelLogicNodeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPanelLogicNodeBase pSPanelLogicNodeBase) {
        pSPanelLogicNodeBase.resetCodeName();
        pSPanelLogicNodeBase.resetCreateDate();
        pSPanelLogicNodeBase.resetCreateMan();
        pSPanelLogicNodeBase.resetLeftPos();
        pSPanelLogicNodeBase.resetLogicNodeType();
        pSPanelLogicNodeBase.resetMemo();
        pSPanelLogicNodeBase.resetParallelOutput();
        pSPanelLogicNodeBase.resetParam1();
        pSPanelLogicNodeBase.resetParam10();
        pSPanelLogicNodeBase.resetParam11();
        pSPanelLogicNodeBase.resetParam12();
        pSPanelLogicNodeBase.resetParam13();
        pSPanelLogicNodeBase.resetParam14();
        pSPanelLogicNodeBase.resetParam2();
        pSPanelLogicNodeBase.resetParam3();
        pSPanelLogicNodeBase.resetParam4();
        pSPanelLogicNodeBase.resetParam5();
        pSPanelLogicNodeBase.resetParam6();
        pSPanelLogicNodeBase.resetParam7();
        pSPanelLogicNodeBase.resetParam8();
        pSPanelLogicNodeBase.resetParam9();
        pSPanelLogicNodeBase.resetPSPanelLogicNodeId();
        pSPanelLogicNodeBase.resetPSPanelLogicNodeName();
        pSPanelLogicNodeBase.resetPSPanelLogicParamId();
        pSPanelLogicNodeBase.resetPSPanelLogicParamName();
        pSPanelLogicNodeBase.resetPSSystemId();
        pSPanelLogicNodeBase.resetPSSysViewPanelId();
        pSPanelLogicNodeBase.resetPSSysViewPanelItemId();
        pSPanelLogicNodeBase.resetPSSysViewPanelItemName();
        pSPanelLogicNodeBase.resetPSSysViewPanelLogicId();
        pSPanelLogicNodeBase.resetPSSysViewPanelLogicName();
        pSPanelLogicNodeBase.resetPSSysViewPanelName();
        pSPanelLogicNodeBase.resetTopPos();
        pSPanelLogicNodeBase.resetUpdateDate();
        pSPanelLogicNodeBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isLeftPosDirty()) {
            hashMap.put(FIELD_LEFTPOS, this.getLeftPos());
        }
        if (!bl || this.isLogicNodeTypeDirty()) {
            hashMap.put(FIELD_LOGICNODETYPE, this.getLogicNodeType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isParallelOutputDirty()) {
            hashMap.put(FIELD_PARALLELOUTPUT, this.getParallelOutput());
        }
        if (!bl || this.isParam1Dirty()) {
            hashMap.put(FIELD_PARAM1, this.getParam1());
        }
        if (!bl || this.isParam10Dirty()) {
            hashMap.put(FIELD_PARAM10, this.getParam10());
        }
        if (!bl || this.isParam11Dirty()) {
            hashMap.put(FIELD_PARAM11, this.getParam11());
        }
        if (!bl || this.isParam12Dirty()) {
            hashMap.put(FIELD_PARAM12, this.getParam12());
        }
        if (!bl || this.isParam13Dirty()) {
            hashMap.put(FIELD_PARAM13, this.getParam13());
        }
        if (!bl || this.isParam14Dirty()) {
            hashMap.put(FIELD_PARAM14, this.getParam14());
        }
        if (!bl || this.isParam2Dirty()) {
            hashMap.put(FIELD_PARAM2, this.getParam2());
        }
        if (!bl || this.isParam3Dirty()) {
            hashMap.put(FIELD_PARAM3, this.getParam3());
        }
        if (!bl || this.isParam4Dirty()) {
            hashMap.put(FIELD_PARAM4, this.getParam4());
        }
        if (!bl || this.isParam5Dirty()) {
            hashMap.put(FIELD_PARAM5, this.getParam5());
        }
        if (!bl || this.isParam6Dirty()) {
            hashMap.put(FIELD_PARAM6, this.getParam6());
        }
        if (!bl || this.isParam7Dirty()) {
            hashMap.put(FIELD_PARAM7, this.getParam7());
        }
        if (!bl || this.isParam8Dirty()) {
            hashMap.put(FIELD_PARAM8, this.getParam8());
        }
        if (!bl || this.isParam9Dirty()) {
            hashMap.put(FIELD_PARAM9, this.getParam9());
        }
        if (!bl || this.isPSPanelLogicNodeIdDirty()) {
            hashMap.put(FIELD_PSPANELLOGICNODEID, this.getPSPanelLogicNodeId());
        }
        if (!bl || this.isPSPanelLogicNodeNameDirty()) {
            hashMap.put(FIELD_PSPANELLOGICNODENAME, this.getPSPanelLogicNodeName());
        }
        if (!bl || this.isPSPanelLogicParamIdDirty()) {
            hashMap.put(FIELD_PSPANELLOGICPARAMID, this.getPSPanelLogicParamId());
        }
        if (!bl || this.isPSPanelLogicParamNameDirty()) {
            hashMap.put(FIELD_PSPANELLOGICPARAMNAME, this.getPSPanelLogicParamName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSysViewPanelIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELID, this.getPSSysViewPanelId());
        }
        if (!bl || this.isPSSysViewPanelItemIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELITEMID, this.getPSSysViewPanelItemId());
        }
        if (!bl || this.isPSSysViewPanelItemNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELITEMNAME, this.getPSSysViewPanelItemName());
        }
        if (!bl || this.isPSSysViewPanelLogicIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELLOGICID, this.getPSSysViewPanelLogicId());
        }
        if (!bl || this.isPSSysViewPanelLogicNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELLOGICNAME, this.getPSSysViewPanelLogicName());
        }
        if (!bl || this.isPSSysViewPanelNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELNAME, this.getPSSysViewPanelName());
        }
        if (!bl || this.isTopPosDirty()) {
            hashMap.put(FIELD_TOPPOS, this.getTopPos());
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
        return PSPanelLogicNodeBase.get(this, n);
    }

    private static Object get(PSPanelLogicNodeBase pSPanelLogicNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelLogicNodeBase.getCodeName();
            }
            case 1: {
                return pSPanelLogicNodeBase.getCreateDate();
            }
            case 2: {
                return pSPanelLogicNodeBase.getCreateMan();
            }
            case 3: {
                return pSPanelLogicNodeBase.getLeftPos();
            }
            case 4: {
                return pSPanelLogicNodeBase.getLogicNodeType();
            }
            case 5: {
                return pSPanelLogicNodeBase.getMemo();
            }
            case 6: {
                return pSPanelLogicNodeBase.getParallelOutput();
            }
            case 7: {
                return pSPanelLogicNodeBase.getParam1();
            }
            case 8: {
                return pSPanelLogicNodeBase.getParam10();
            }
            case 9: {
                return pSPanelLogicNodeBase.getParam11();
            }
            case 10: {
                return pSPanelLogicNodeBase.getParam12();
            }
            case 11: {
                return pSPanelLogicNodeBase.getParam13();
            }
            case 12: {
                return pSPanelLogicNodeBase.getParam14();
            }
            case 13: {
                return pSPanelLogicNodeBase.getParam2();
            }
            case 14: {
                return pSPanelLogicNodeBase.getParam3();
            }
            case 15: {
                return pSPanelLogicNodeBase.getParam4();
            }
            case 16: {
                return pSPanelLogicNodeBase.getParam5();
            }
            case 17: {
                return pSPanelLogicNodeBase.getParam6();
            }
            case 18: {
                return pSPanelLogicNodeBase.getParam7();
            }
            case 19: {
                return pSPanelLogicNodeBase.getParam8();
            }
            case 20: {
                return pSPanelLogicNodeBase.getParam9();
            }
            case 21: {
                return pSPanelLogicNodeBase.getPSPanelLogicNodeId();
            }
            case 22: {
                return pSPanelLogicNodeBase.getPSPanelLogicNodeName();
            }
            case 23: {
                return pSPanelLogicNodeBase.getPSPanelLogicParamId();
            }
            case 24: {
                return pSPanelLogicNodeBase.getPSPanelLogicParamName();
            }
            case 25: {
                return pSPanelLogicNodeBase.getPSSystemId();
            }
            case 26: {
                return pSPanelLogicNodeBase.getPSSysViewPanelId();
            }
            case 27: {
                return pSPanelLogicNodeBase.getPSSysViewPanelItemId();
            }
            case 28: {
                return pSPanelLogicNodeBase.getPSSysViewPanelItemName();
            }
            case 29: {
                return pSPanelLogicNodeBase.getPSSysViewPanelLogicId();
            }
            case 30: {
                return pSPanelLogicNodeBase.getPSSysViewPanelLogicName();
            }
            case 31: {
                return pSPanelLogicNodeBase.getPSSysViewPanelName();
            }
            case 32: {
                return pSPanelLogicNodeBase.getTopPos();
            }
            case 33: {
                return pSPanelLogicNodeBase.getUpdateDate();
            }
            case 34: {
                return pSPanelLogicNodeBase.getUpdateMan();
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
        PSPanelLogicNodeBase.set(this, n, object);
    }

    private static void set(PSPanelLogicNodeBase pSPanelLogicNodeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPanelLogicNodeBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSPanelLogicNodeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSPanelLogicNodeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPanelLogicNodeBase.setLeftPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSPanelLogicNodeBase.setLogicNodeType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPanelLogicNodeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPanelLogicNodeBase.setParallelOutput(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSPanelLogicNodeBase.setParam1(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPanelLogicNodeBase.setParam10(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSPanelLogicNodeBase.setParam11(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPanelLogicNodeBase.setParam12(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPanelLogicNodeBase.setParam13(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSPanelLogicNodeBase.setParam14(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSPanelLogicNodeBase.setParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSPanelLogicNodeBase.setParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSPanelLogicNodeBase.setParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSPanelLogicNodeBase.setParam5(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSPanelLogicNodeBase.setParam6(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSPanelLogicNodeBase.setParam7(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSPanelLogicNodeBase.setParam8(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSPanelLogicNodeBase.setParam9(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSPanelLogicNodeBase.setPSPanelLogicNodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSPanelLogicNodeBase.setPSPanelLogicNodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSPanelLogicNodeBase.setPSPanelLogicParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSPanelLogicNodeBase.setPSPanelLogicParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSPanelLogicNodeBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSPanelLogicNodeBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSPanelLogicNodeBase.setPSSysViewPanelItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSPanelLogicNodeBase.setPSSysViewPanelItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSPanelLogicNodeBase.setPSSysViewPanelLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSPanelLogicNodeBase.setPSSysViewPanelLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSPanelLogicNodeBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSPanelLogicNodeBase.setTopPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSPanelLogicNodeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 34: {
                pSPanelLogicNodeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSPanelLogicNodeBase.isNull(this, n);
    }

    private static boolean isNull(PSPanelLogicNodeBase pSPanelLogicNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelLogicNodeBase.getCodeName() == null;
            }
            case 1: {
                return pSPanelLogicNodeBase.getCreateDate() == null;
            }
            case 2: {
                return pSPanelLogicNodeBase.getCreateMan() == null;
            }
            case 3: {
                return pSPanelLogicNodeBase.getLeftPos() == null;
            }
            case 4: {
                return pSPanelLogicNodeBase.getLogicNodeType() == null;
            }
            case 5: {
                return pSPanelLogicNodeBase.getMemo() == null;
            }
            case 6: {
                return pSPanelLogicNodeBase.getParallelOutput() == null;
            }
            case 7: {
                return pSPanelLogicNodeBase.getParam1() == null;
            }
            case 8: {
                return pSPanelLogicNodeBase.getParam10() == null;
            }
            case 9: {
                return pSPanelLogicNodeBase.getParam11() == null;
            }
            case 10: {
                return pSPanelLogicNodeBase.getParam12() == null;
            }
            case 11: {
                return pSPanelLogicNodeBase.getParam13() == null;
            }
            case 12: {
                return pSPanelLogicNodeBase.getParam14() == null;
            }
            case 13: {
                return pSPanelLogicNodeBase.getParam2() == null;
            }
            case 14: {
                return pSPanelLogicNodeBase.getParam3() == null;
            }
            case 15: {
                return pSPanelLogicNodeBase.getParam4() == null;
            }
            case 16: {
                return pSPanelLogicNodeBase.getParam5() == null;
            }
            case 17: {
                return pSPanelLogicNodeBase.getParam6() == null;
            }
            case 18: {
                return pSPanelLogicNodeBase.getParam7() == null;
            }
            case 19: {
                return pSPanelLogicNodeBase.getParam8() == null;
            }
            case 20: {
                return pSPanelLogicNodeBase.getParam9() == null;
            }
            case 21: {
                return pSPanelLogicNodeBase.getPSPanelLogicNodeId() == null;
            }
            case 22: {
                return pSPanelLogicNodeBase.getPSPanelLogicNodeName() == null;
            }
            case 23: {
                return pSPanelLogicNodeBase.getPSPanelLogicParamId() == null;
            }
            case 24: {
                return pSPanelLogicNodeBase.getPSPanelLogicParamName() == null;
            }
            case 25: {
                return pSPanelLogicNodeBase.getPSSystemId() == null;
            }
            case 26: {
                return pSPanelLogicNodeBase.getPSSysViewPanelId() == null;
            }
            case 27: {
                return pSPanelLogicNodeBase.getPSSysViewPanelItemId() == null;
            }
            case 28: {
                return pSPanelLogicNodeBase.getPSSysViewPanelItemName() == null;
            }
            case 29: {
                return pSPanelLogicNodeBase.getPSSysViewPanelLogicId() == null;
            }
            case 30: {
                return pSPanelLogicNodeBase.getPSSysViewPanelLogicName() == null;
            }
            case 31: {
                return pSPanelLogicNodeBase.getPSSysViewPanelName() == null;
            }
            case 32: {
                return pSPanelLogicNodeBase.getTopPos() == null;
            }
            case 33: {
                return pSPanelLogicNodeBase.getUpdateDate() == null;
            }
            case 34: {
                return pSPanelLogicNodeBase.getUpdateMan() == null;
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
        return PSPanelLogicNodeBase.contains(this, n);
    }

    private static boolean contains(PSPanelLogicNodeBase pSPanelLogicNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelLogicNodeBase.isCodeNameDirty();
            }
            case 1: {
                return pSPanelLogicNodeBase.isCreateDateDirty();
            }
            case 2: {
                return pSPanelLogicNodeBase.isCreateManDirty();
            }
            case 3: {
                return pSPanelLogicNodeBase.isLeftPosDirty();
            }
            case 4: {
                return pSPanelLogicNodeBase.isLogicNodeTypeDirty();
            }
            case 5: {
                return pSPanelLogicNodeBase.isMemoDirty();
            }
            case 6: {
                return pSPanelLogicNodeBase.isParallelOutputDirty();
            }
            case 7: {
                return pSPanelLogicNodeBase.isParam1Dirty();
            }
            case 8: {
                return pSPanelLogicNodeBase.isParam10Dirty();
            }
            case 9: {
                return pSPanelLogicNodeBase.isParam11Dirty();
            }
            case 10: {
                return pSPanelLogicNodeBase.isParam12Dirty();
            }
            case 11: {
                return pSPanelLogicNodeBase.isParam13Dirty();
            }
            case 12: {
                return pSPanelLogicNodeBase.isParam14Dirty();
            }
            case 13: {
                return pSPanelLogicNodeBase.isParam2Dirty();
            }
            case 14: {
                return pSPanelLogicNodeBase.isParam3Dirty();
            }
            case 15: {
                return pSPanelLogicNodeBase.isParam4Dirty();
            }
            case 16: {
                return pSPanelLogicNodeBase.isParam5Dirty();
            }
            case 17: {
                return pSPanelLogicNodeBase.isParam6Dirty();
            }
            case 18: {
                return pSPanelLogicNodeBase.isParam7Dirty();
            }
            case 19: {
                return pSPanelLogicNodeBase.isParam8Dirty();
            }
            case 20: {
                return pSPanelLogicNodeBase.isParam9Dirty();
            }
            case 21: {
                return pSPanelLogicNodeBase.isPSPanelLogicNodeIdDirty();
            }
            case 22: {
                return pSPanelLogicNodeBase.isPSPanelLogicNodeNameDirty();
            }
            case 23: {
                return pSPanelLogicNodeBase.isPSPanelLogicParamIdDirty();
            }
            case 24: {
                return pSPanelLogicNodeBase.isPSPanelLogicParamNameDirty();
            }
            case 25: {
                return pSPanelLogicNodeBase.isPSSystemIdDirty();
            }
            case 26: {
                return pSPanelLogicNodeBase.isPSSysViewPanelIdDirty();
            }
            case 27: {
                return pSPanelLogicNodeBase.isPSSysViewPanelItemIdDirty();
            }
            case 28: {
                return pSPanelLogicNodeBase.isPSSysViewPanelItemNameDirty();
            }
            case 29: {
                return pSPanelLogicNodeBase.isPSSysViewPanelLogicIdDirty();
            }
            case 30: {
                return pSPanelLogicNodeBase.isPSSysViewPanelLogicNameDirty();
            }
            case 31: {
                return pSPanelLogicNodeBase.isPSSysViewPanelNameDirty();
            }
            case 32: {
                return pSPanelLogicNodeBase.isTopPosDirty();
            }
            case 33: {
                return pSPanelLogicNodeBase.isUpdateDateDirty();
            }
            case 34: {
                return pSPanelLogicNodeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPanelLogicNodeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPanelLogicNodeBase pSPanelLogicNodeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPanelLogicNodeBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getCodeName()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getLeftPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"leftpos", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getLeftPos()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getLogicNodeType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicnodetype", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getLogicNodeType()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getMemo()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getParallelOutput() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paralleloutput", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getParallelOutput()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getParam1() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param1", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getParam1()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getParam10() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param10", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getParam10()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getParam11() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param11", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getParam11()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getParam12() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param12", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getParam12()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getParam13() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param13", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getParam13()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getParam14() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param14", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getParam14()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param2", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getParam2()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param3", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getParam3()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param4", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getParam4()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getParam5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param5", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getParam5()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getParam6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param6", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getParam6()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getParam7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param7", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getParam7()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getParam8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param8", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getParam8()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getParam9() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"param9", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getParam9()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getPSPanelLogicNodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspanellogicnodeid", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getPSPanelLogicNodeId()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getPSPanelLogicNodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspanellogicnodename", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getPSPanelLogicNodeName()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getPSPanelLogicParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspanellogicparamid", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getPSPanelLogicParamId()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getPSPanelLogicParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspanellogicparamname", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getPSPanelLogicParamName()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getPSSysViewPanelItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelitemid", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getPSSysViewPanelItemId()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getPSSysViewPanelItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelitemname", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getPSSysViewPanelItemName()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getPSSysViewPanelLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanellogicid", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getPSSysViewPanelLogicId()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getPSSysViewPanelLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanellogicname", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getPSSysViewPanelLogicName()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getTopPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"toppos", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getTopPos()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPanelLogicNodeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPanelLogicNodeBase.getJSONValue((Object)pSPanelLogicNodeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPanelLogicNodeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPanelLogicNodeBase pSPanelLogicNodeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPanelLogicNodeBase.getCodeName() != null) {
            object = pSPanelLogicNodeBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicNodeBase.getCreateDate() != null) {
            object = pSPanelLogicNodeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPanelLogicNodeBase.getCreateMan() != null) {
            object = pSPanelLogicNodeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicNodeBase.getLeftPos() != null) {
            object = pSPanelLogicNodeBase.getLeftPos();
            xmlNode.setAttribute(FIELD_LEFTPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelLogicNodeBase.getLogicNodeType() != null) {
            object = pSPanelLogicNodeBase.getLogicNodeType();
            xmlNode.setAttribute(FIELD_LOGICNODETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicNodeBase.getMemo() != null) {
            object = pSPanelLogicNodeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicNodeBase.getParallelOutput() != null) {
            object = pSPanelLogicNodeBase.getParallelOutput();
            xmlNode.setAttribute(FIELD_PARALLELOUTPUT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelLogicNodeBase.getParam1() != null) {
            object = pSPanelLogicNodeBase.getParam1();
            xmlNode.setAttribute(FIELD_PARAM1, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicNodeBase.getParam10() != null) {
            object = pSPanelLogicNodeBase.getParam10();
            xmlNode.setAttribute(FIELD_PARAM10, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelLogicNodeBase.getParam11() != null) {
            object = pSPanelLogicNodeBase.getParam11();
            xmlNode.setAttribute(FIELD_PARAM11, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicNodeBase.getParam12() != null) {
            object = pSPanelLogicNodeBase.getParam12();
            xmlNode.setAttribute(FIELD_PARAM12, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicNodeBase.getParam13() != null) {
            object = pSPanelLogicNodeBase.getParam13();
            xmlNode.setAttribute(FIELD_PARAM13, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicNodeBase.getParam14() != null) {
            object = pSPanelLogicNodeBase.getParam14();
            xmlNode.setAttribute(FIELD_PARAM14, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicNodeBase.getParam2() != null) {
            object = pSPanelLogicNodeBase.getParam2();
            xmlNode.setAttribute(FIELD_PARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicNodeBase.getParam3() != null) {
            object = pSPanelLogicNodeBase.getParam3();
            xmlNode.setAttribute(FIELD_PARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicNodeBase.getParam4() != null) {
            object = pSPanelLogicNodeBase.getParam4();
            xmlNode.setAttribute(FIELD_PARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicNodeBase.getParam5() != null) {
            object = pSPanelLogicNodeBase.getParam5();
            xmlNode.setAttribute(FIELD_PARAM5, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicNodeBase.getParam6() != null) {
            object = pSPanelLogicNodeBase.getParam6();
            xmlNode.setAttribute(FIELD_PARAM6, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicNodeBase.getParam7() != null) {
            object = pSPanelLogicNodeBase.getParam7();
            xmlNode.setAttribute(FIELD_PARAM7, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelLogicNodeBase.getParam8() != null) {
            object = pSPanelLogicNodeBase.getParam8();
            xmlNode.setAttribute(FIELD_PARAM8, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelLogicNodeBase.getParam9() != null) {
            object = pSPanelLogicNodeBase.getParam9();
            xmlNode.setAttribute(FIELD_PARAM9, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelLogicNodeBase.getPSPanelLogicNodeId() != null) {
            object = pSPanelLogicNodeBase.getPSPanelLogicNodeId();
            xmlNode.setAttribute(FIELD_PSPANELLOGICNODEID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicNodeBase.getPSPanelLogicNodeName() != null) {
            object = pSPanelLogicNodeBase.getPSPanelLogicNodeName();
            xmlNode.setAttribute(FIELD_PSPANELLOGICNODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicNodeBase.getPSPanelLogicParamId() != null) {
            object = pSPanelLogicNodeBase.getPSPanelLogicParamId();
            xmlNode.setAttribute(FIELD_PSPANELLOGICPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicNodeBase.getPSPanelLogicParamName() != null) {
            object = pSPanelLogicNodeBase.getPSPanelLogicParamName();
            xmlNode.setAttribute(FIELD_PSPANELLOGICPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicNodeBase.getPSSystemId() != null) {
            object = pSPanelLogicNodeBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicNodeBase.getPSSysViewPanelId() != null) {
            object = pSPanelLogicNodeBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicNodeBase.getPSSysViewPanelItemId() != null) {
            object = pSPanelLogicNodeBase.getPSSysViewPanelItemId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicNodeBase.getPSSysViewPanelItemName() != null) {
            object = pSPanelLogicNodeBase.getPSSysViewPanelItemName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicNodeBase.getPSSysViewPanelLogicId() != null) {
            object = pSPanelLogicNodeBase.getPSSysViewPanelLogicId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicNodeBase.getPSSysViewPanelLogicName() != null) {
            object = pSPanelLogicNodeBase.getPSSysViewPanelLogicName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicNodeBase.getPSSysViewPanelName() != null) {
            object = pSPanelLogicNodeBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicNodeBase.getTopPos() != null) {
            object = pSPanelLogicNodeBase.getTopPos();
            xmlNode.setAttribute(FIELD_TOPPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelLogicNodeBase.getUpdateDate() != null) {
            object = pSPanelLogicNodeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPanelLogicNodeBase.getUpdateMan() != null) {
            object = pSPanelLogicNodeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPanelLogicNodeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPanelLogicNodeBase pSPanelLogicNodeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPanelLogicNodeBase.isCodeNameDirty() && (bl || pSPanelLogicNodeBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSPanelLogicNodeBase.getCodeName());
        }
        if (pSPanelLogicNodeBase.isCreateDateDirty() && (bl || pSPanelLogicNodeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPanelLogicNodeBase.getCreateDate());
        }
        if (pSPanelLogicNodeBase.isCreateManDirty() && (bl || pSPanelLogicNodeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPanelLogicNodeBase.getCreateMan());
        }
        if (pSPanelLogicNodeBase.isLeftPosDirty() && (bl || pSPanelLogicNodeBase.getLeftPos() != null)) {
            iDataObject.set(FIELD_LEFTPOS, (Object)pSPanelLogicNodeBase.getLeftPos());
        }
        if (pSPanelLogicNodeBase.isLogicNodeTypeDirty() && (bl || pSPanelLogicNodeBase.getLogicNodeType() != null)) {
            iDataObject.set(FIELD_LOGICNODETYPE, (Object)pSPanelLogicNodeBase.getLogicNodeType());
        }
        if (pSPanelLogicNodeBase.isMemoDirty() && (bl || pSPanelLogicNodeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPanelLogicNodeBase.getMemo());
        }
        if (pSPanelLogicNodeBase.isParallelOutputDirty() && (bl || pSPanelLogicNodeBase.getParallelOutput() != null)) {
            iDataObject.set(FIELD_PARALLELOUTPUT, (Object)pSPanelLogicNodeBase.getParallelOutput());
        }
        if (pSPanelLogicNodeBase.isParam1Dirty() && (bl || pSPanelLogicNodeBase.getParam1() != null)) {
            iDataObject.set(FIELD_PARAM1, (Object)pSPanelLogicNodeBase.getParam1());
        }
        if (pSPanelLogicNodeBase.isParam10Dirty() && (bl || pSPanelLogicNodeBase.getParam10() != null)) {
            iDataObject.set(FIELD_PARAM10, (Object)pSPanelLogicNodeBase.getParam10());
        }
        if (pSPanelLogicNodeBase.isParam11Dirty() && (bl || pSPanelLogicNodeBase.getParam11() != null)) {
            iDataObject.set(FIELD_PARAM11, (Object)pSPanelLogicNodeBase.getParam11());
        }
        if (pSPanelLogicNodeBase.isParam12Dirty() && (bl || pSPanelLogicNodeBase.getParam12() != null)) {
            iDataObject.set(FIELD_PARAM12, (Object)pSPanelLogicNodeBase.getParam12());
        }
        if (pSPanelLogicNodeBase.isParam13Dirty() && (bl || pSPanelLogicNodeBase.getParam13() != null)) {
            iDataObject.set(FIELD_PARAM13, (Object)pSPanelLogicNodeBase.getParam13());
        }
        if (pSPanelLogicNodeBase.isParam14Dirty() && (bl || pSPanelLogicNodeBase.getParam14() != null)) {
            iDataObject.set(FIELD_PARAM14, (Object)pSPanelLogicNodeBase.getParam14());
        }
        if (pSPanelLogicNodeBase.isParam2Dirty() && (bl || pSPanelLogicNodeBase.getParam2() != null)) {
            iDataObject.set(FIELD_PARAM2, (Object)pSPanelLogicNodeBase.getParam2());
        }
        if (pSPanelLogicNodeBase.isParam3Dirty() && (bl || pSPanelLogicNodeBase.getParam3() != null)) {
            iDataObject.set(FIELD_PARAM3, (Object)pSPanelLogicNodeBase.getParam3());
        }
        if (pSPanelLogicNodeBase.isParam4Dirty() && (bl || pSPanelLogicNodeBase.getParam4() != null)) {
            iDataObject.set(FIELD_PARAM4, (Object)pSPanelLogicNodeBase.getParam4());
        }
        if (pSPanelLogicNodeBase.isParam5Dirty() && (bl || pSPanelLogicNodeBase.getParam5() != null)) {
            iDataObject.set(FIELD_PARAM5, (Object)pSPanelLogicNodeBase.getParam5());
        }
        if (pSPanelLogicNodeBase.isParam6Dirty() && (bl || pSPanelLogicNodeBase.getParam6() != null)) {
            iDataObject.set(FIELD_PARAM6, (Object)pSPanelLogicNodeBase.getParam6());
        }
        if (pSPanelLogicNodeBase.isParam7Dirty() && (bl || pSPanelLogicNodeBase.getParam7() != null)) {
            iDataObject.set(FIELD_PARAM7, (Object)pSPanelLogicNodeBase.getParam7());
        }
        if (pSPanelLogicNodeBase.isParam8Dirty() && (bl || pSPanelLogicNodeBase.getParam8() != null)) {
            iDataObject.set(FIELD_PARAM8, (Object)pSPanelLogicNodeBase.getParam8());
        }
        if (pSPanelLogicNodeBase.isParam9Dirty() && (bl || pSPanelLogicNodeBase.getParam9() != null)) {
            iDataObject.set(FIELD_PARAM9, (Object)pSPanelLogicNodeBase.getParam9());
        }
        if (pSPanelLogicNodeBase.isPSPanelLogicNodeIdDirty() && (bl || pSPanelLogicNodeBase.getPSPanelLogicNodeId() != null)) {
            iDataObject.set(FIELD_PSPANELLOGICNODEID, (Object)pSPanelLogicNodeBase.getPSPanelLogicNodeId());
        }
        if (pSPanelLogicNodeBase.isPSPanelLogicNodeNameDirty() && (bl || pSPanelLogicNodeBase.getPSPanelLogicNodeName() != null)) {
            iDataObject.set(FIELD_PSPANELLOGICNODENAME, (Object)pSPanelLogicNodeBase.getPSPanelLogicNodeName());
        }
        if (pSPanelLogicNodeBase.isPSPanelLogicParamIdDirty() && (bl || pSPanelLogicNodeBase.getPSPanelLogicParamId() != null)) {
            iDataObject.set(FIELD_PSPANELLOGICPARAMID, (Object)pSPanelLogicNodeBase.getPSPanelLogicParamId());
        }
        if (pSPanelLogicNodeBase.isPSPanelLogicParamNameDirty() && (bl || pSPanelLogicNodeBase.getPSPanelLogicParamName() != null)) {
            iDataObject.set(FIELD_PSPANELLOGICPARAMNAME, (Object)pSPanelLogicNodeBase.getPSPanelLogicParamName());
        }
        if (pSPanelLogicNodeBase.isPSSystemIdDirty() && (bl || pSPanelLogicNodeBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSPanelLogicNodeBase.getPSSystemId());
        }
        if (pSPanelLogicNodeBase.isPSSysViewPanelIdDirty() && (bl || pSPanelLogicNodeBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSPanelLogicNodeBase.getPSSysViewPanelId());
        }
        if (pSPanelLogicNodeBase.isPSSysViewPanelItemIdDirty() && (bl || pSPanelLogicNodeBase.getPSSysViewPanelItemId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELITEMID, (Object)pSPanelLogicNodeBase.getPSSysViewPanelItemId());
        }
        if (pSPanelLogicNodeBase.isPSSysViewPanelItemNameDirty() && (bl || pSPanelLogicNodeBase.getPSSysViewPanelItemName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELITEMNAME, (Object)pSPanelLogicNodeBase.getPSSysViewPanelItemName());
        }
        if (pSPanelLogicNodeBase.isPSSysViewPanelLogicIdDirty() && (bl || pSPanelLogicNodeBase.getPSSysViewPanelLogicId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELLOGICID, (Object)pSPanelLogicNodeBase.getPSSysViewPanelLogicId());
        }
        if (pSPanelLogicNodeBase.isPSSysViewPanelLogicNameDirty() && (bl || pSPanelLogicNodeBase.getPSSysViewPanelLogicName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELLOGICNAME, (Object)pSPanelLogicNodeBase.getPSSysViewPanelLogicName());
        }
        if (pSPanelLogicNodeBase.isPSSysViewPanelNameDirty() && (bl || pSPanelLogicNodeBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSPanelLogicNodeBase.getPSSysViewPanelName());
        }
        if (pSPanelLogicNodeBase.isTopPosDirty() && (bl || pSPanelLogicNodeBase.getTopPos() != null)) {
            iDataObject.set(FIELD_TOPPOS, (Object)pSPanelLogicNodeBase.getTopPos());
        }
        if (pSPanelLogicNodeBase.isUpdateDateDirty() && (bl || pSPanelLogicNodeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPanelLogicNodeBase.getUpdateDate());
        }
        if (pSPanelLogicNodeBase.isUpdateManDirty() && (bl || pSPanelLogicNodeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPanelLogicNodeBase.getUpdateMan());
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
        return PSPanelLogicNodeBase.remove(this, n);
    }

    private static boolean remove(PSPanelLogicNodeBase pSPanelLogicNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPanelLogicNodeBase.resetCodeName();
                return true;
            }
            case 1: {
                pSPanelLogicNodeBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSPanelLogicNodeBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSPanelLogicNodeBase.resetLeftPos();
                return true;
            }
            case 4: {
                pSPanelLogicNodeBase.resetLogicNodeType();
                return true;
            }
            case 5: {
                pSPanelLogicNodeBase.resetMemo();
                return true;
            }
            case 6: {
                pSPanelLogicNodeBase.resetParallelOutput();
                return true;
            }
            case 7: {
                pSPanelLogicNodeBase.resetParam1();
                return true;
            }
            case 8: {
                pSPanelLogicNodeBase.resetParam10();
                return true;
            }
            case 9: {
                pSPanelLogicNodeBase.resetParam11();
                return true;
            }
            case 10: {
                pSPanelLogicNodeBase.resetParam12();
                return true;
            }
            case 11: {
                pSPanelLogicNodeBase.resetParam13();
                return true;
            }
            case 12: {
                pSPanelLogicNodeBase.resetParam14();
                return true;
            }
            case 13: {
                pSPanelLogicNodeBase.resetParam2();
                return true;
            }
            case 14: {
                pSPanelLogicNodeBase.resetParam3();
                return true;
            }
            case 15: {
                pSPanelLogicNodeBase.resetParam4();
                return true;
            }
            case 16: {
                pSPanelLogicNodeBase.resetParam5();
                return true;
            }
            case 17: {
                pSPanelLogicNodeBase.resetParam6();
                return true;
            }
            case 18: {
                pSPanelLogicNodeBase.resetParam7();
                return true;
            }
            case 19: {
                pSPanelLogicNodeBase.resetParam8();
                return true;
            }
            case 20: {
                pSPanelLogicNodeBase.resetParam9();
                return true;
            }
            case 21: {
                pSPanelLogicNodeBase.resetPSPanelLogicNodeId();
                return true;
            }
            case 22: {
                pSPanelLogicNodeBase.resetPSPanelLogicNodeName();
                return true;
            }
            case 23: {
                pSPanelLogicNodeBase.resetPSPanelLogicParamId();
                return true;
            }
            case 24: {
                pSPanelLogicNodeBase.resetPSPanelLogicParamName();
                return true;
            }
            case 25: {
                pSPanelLogicNodeBase.resetPSSystemId();
                return true;
            }
            case 26: {
                pSPanelLogicNodeBase.resetPSSysViewPanelId();
                return true;
            }
            case 27: {
                pSPanelLogicNodeBase.resetPSSysViewPanelItemId();
                return true;
            }
            case 28: {
                pSPanelLogicNodeBase.resetPSSysViewPanelItemName();
                return true;
            }
            case 29: {
                pSPanelLogicNodeBase.resetPSSysViewPanelLogicId();
                return true;
            }
            case 30: {
                pSPanelLogicNodeBase.resetPSSysViewPanelLogicName();
                return true;
            }
            case 31: {
                pSPanelLogicNodeBase.resetPSSysViewPanelName();
                return true;
            }
            case 32: {
                pSPanelLogicNodeBase.resetTopPos();
                return true;
            }
            case 33: {
                pSPanelLogicNodeBase.resetUpdateDate();
                return true;
            }
            case 34: {
                pSPanelLogicNodeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPanelLogicParam getPSPanelLogicParam() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLogicParam();
        }
        if (this.getPSPanelLogicParamId() == null) {
            return null;
        }
        Integer n = this.objPSPanelLogicParamLock;
        synchronized (n) {
            if (this.pspanellogicparam != null && DataTypeHelper.compare((int)25, (Object)this.getPSPanelLogicParamId(), (Object)this.pspanellogicparam.getPSPanelLogicParamId()) != 0L) {
                this.pspanellogicparam = null;
            }
            if (this.pspanellogicparam == null) {
                PSPanelLogicParam pSPanelLogicParam = new PSPanelLogicParam();
                pSPanelLogicParam.setPSPanelLogicParamId(this.getPSPanelLogicParamId());
                PSPanelLogicParamService pSPanelLogicParamService = (PSPanelLogicParamService)ServiceGlobal.getService(PSPanelLogicParamService.class, (SessionFactory)this.getSessionFactory());
                pSPanelLogicParamService.autoGet(pSPanelLogicParam);
                this.pspanellogicparam = pSPanelLogicParam;
            }
            return this.pspanellogicparam;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysViewPanelItem getPSSysViewPanelItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelItem();
        }
        if (this.getPSSysViewPanelItemId() == null) {
            return null;
        }
        Integer n = this.objPSSysViewPanelItemLock;
        synchronized (n) {
            if (this.pssysviewpanelitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysViewPanelItemId(), (Object)this.pssysviewpanelitem.getPSSysViewPanelItemId()) != 0L) {
                this.pssysviewpanelitem = null;
            }
            if (this.pssysviewpanelitem == null) {
                PSSysViewPanelItem pSSysViewPanelItem = new PSSysViewPanelItem();
                pSSysViewPanelItem.setPSSysViewPanelItemId(this.getPSSysViewPanelItemId());
                PSSysViewPanelItemService pSSysViewPanelItemService = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelItemService.autoGet(pSSysViewPanelItem);
                this.pssysviewpanelitem = pSSysViewPanelItem;
            }
            return this.pssysviewpanelitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysViewPanelLogic getPSSysViewPanelLogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelLogic();
        }
        if (this.getPSSysViewPanelLogicId() == null) {
            return null;
        }
        Integer n = this.objPSSysViewPanelLogicLock;
        synchronized (n) {
            if (this.pssysviewpanellogic != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysViewPanelLogicId(), (Object)this.pssysviewpanellogic.getPSSysViewPanelLogicId()) != 0L) {
                this.pssysviewpanellogic = null;
            }
            if (this.pssysviewpanellogic == null) {
                PSSysViewPanelLogic pSSysViewPanelLogic = new PSSysViewPanelLogic();
                pSSysViewPanelLogic.setPSSysViewPanelLogicId(this.getPSSysViewPanelLogicId());
                PSSysViewPanelLogicService pSSysViewPanelLogicService = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelLogicService.autoGet(pSSysViewPanelLogic);
                this.pssysviewpanellogic = pSSysViewPanelLogic;
            }
            return this.pssysviewpanellogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysViewPanel getPSSysViewPanel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanel();
        }
        if (this.getPSSysViewPanelId() == null) {
            return null;
        }
        Integer n = this.objPSSysViewPanelLock;
        synchronized (n) {
            if (this.pssysviewpanel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysViewPanelId(), (Object)this.pssysviewpanel.getPSSysViewPanelId()) != 0L) {
                this.pssysviewpanel = null;
            }
            if (this.pssysviewpanel == null) {
                PSSysViewPanel pSSysViewPanel = new PSSysViewPanel();
                pSSysViewPanel.setPSSysViewPanelId(this.getPSSysViewPanelId());
                PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelService.autoGet(pSSysViewPanel);
                this.pssysviewpanel = pSSysViewPanel;
            }
            return this.pssysviewpanel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSPanelLNParam> getPSPanelLNParams() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLNParams();
        }
        if (this.getPSPanelLogicNodeId() == null) {
            return null;
        }
        PSPanelLogicNodeService pSPanelLogicNodeService = (PSPanelLogicNodeService)ServiceGlobal.getService(PSPanelLogicNodeService.class, (SessionFactory)this.getSessionFactory());
        PSPanelLNParamService pSPanelLNParamService = (PSPanelLNParamService)ServiceGlobal.getService(PSPanelLNParamService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSPanelLNParamsLock;
        synchronized (n) {
            if (this.pspanellnparams == null) {
                this.pspanellnparams = pSPanelLogicNodeService.isTempData(this) ? pSPanelLNParamService.selectTempByPSPanelLogicNode(this) : pSPanelLNParamService.selectByPSPanelLogicNode(this);
            }
            return this.pspanellnparams;
        }
    }

    private PSPanelLogicNodeBase getProxyEntity() {
        return this.proxyPSPanelLogicNodeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPanelLogicNodeBase = null;
        if (iDataObject != null && iDataObject instanceof PSPanelLogicNodeBase) {
            this.proxyPSPanelLogicNodeBase = (PSPanelLogicNodeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicNodeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_LEFTPOS, 3);
        fieldIndexMap.put(FIELD_LOGICNODETYPE, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PARALLELOUTPUT, 6);
        fieldIndexMap.put(FIELD_PARAM1, 7);
        fieldIndexMap.put(FIELD_PARAM10, 8);
        fieldIndexMap.put(FIELD_PARAM11, 9);
        fieldIndexMap.put(FIELD_PARAM12, 10);
        fieldIndexMap.put(FIELD_PARAM13, 11);
        fieldIndexMap.put(FIELD_PARAM14, 12);
        fieldIndexMap.put(FIELD_PARAM2, 13);
        fieldIndexMap.put(FIELD_PARAM3, 14);
        fieldIndexMap.put(FIELD_PARAM4, 15);
        fieldIndexMap.put(FIELD_PARAM5, 16);
        fieldIndexMap.put(FIELD_PARAM6, 17);
        fieldIndexMap.put(FIELD_PARAM7, 18);
        fieldIndexMap.put(FIELD_PARAM8, 19);
        fieldIndexMap.put(FIELD_PARAM9, 20);
        fieldIndexMap.put(FIELD_PSPANELLOGICNODEID, 21);
        fieldIndexMap.put(FIELD_PSPANELLOGICNODENAME, 22);
        fieldIndexMap.put(FIELD_PSPANELLOGICPARAMID, 23);
        fieldIndexMap.put(FIELD_PSPANELLOGICPARAMNAME, 24);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 25);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELID, 26);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELITEMID, 27);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELITEMNAME, 28);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELLOGICID, 29);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELLOGICNAME, 30);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELNAME, 31);
        fieldIndexMap.put(FIELD_TOPPOS, 32);
        fieldIndexMap.put(FIELD_UPDATEDATE, 33);
        fieldIndexMap.put(FIELD_UPDATEMAN, 34);
    }
}

