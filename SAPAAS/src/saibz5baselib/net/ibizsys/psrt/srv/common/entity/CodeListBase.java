/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.common.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.psrt.srv.demodel.entity.DataEntity;
import net.ibizsys.psrt.srv.demodel.service.DataEntityService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class CodeListBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(CodeListBase.class);
    public static final String FIELD_CLMODEL = "CLMODEL";
    public static final String FIELD_CLPARAM = "CLPARAM";
    public static final String FIELD_CLPATH = "CLPATH";
    public static final String FIELD_CLVERSION = "CLVERSION";
    public static final String FIELD_CODELISTID = "CODELISTID";
    public static final String FIELD_CODELISTNAME = "CODELISTNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEID = "DEID";
    public static final String FIELD_DENAME = "DENAME";
    public static final String FIELD_EMPTYTEXT = "EMPTYTEXT";
    public static final String FIELD_FILLER = "FILLER";
    public static final String FIELD_ISSYSTEM = "ISSYSTEM";
    public static final String FIELD_ISUSERSCOPE = "ISUSERSCOPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NOVALUEEMPTY = "NOVALUEEMPTY";
    public static final String FIELD_ORMODE = "ORMODE";
    public static final String FIELD_RESERVER = "RESERVER";
    public static final String FIELD_RESERVER2 = "RESERVER2";
    public static final String FIELD_RESERVER3 = "RESERVER3";
    public static final String FIELD_RESERVER4 = "RESERVER4";
    public static final String FIELD_RESERVER5 = "RESERVER5";
    public static final String FIELD_SEPERATOR = "SEPERATOR";
    public static final String FIELD_SRFSYSPUB = "SRFSYSPUB";
    public static final String FIELD_SRFUSERPUB = "SRFUSERPUB";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALUESEPERATOR = "VALUESEPERATOR";
    private static final int INDEX_CLMODEL = 0;
    private static final int INDEX_CLPARAM = 1;
    private static final int INDEX_CLPATH = 2;
    private static final int INDEX_CLVERSION = 3;
    private static final int INDEX_CODELISTID = 4;
    private static final int INDEX_CODELISTNAME = 5;
    private static final int INDEX_CREATEDATE = 6;
    private static final int INDEX_CREATEMAN = 7;
    private static final int INDEX_DEID = 8;
    private static final int INDEX_DENAME = 9;
    private static final int INDEX_EMPTYTEXT = 10;
    private static final int INDEX_FILLER = 11;
    private static final int INDEX_ISSYSTEM = 12;
    private static final int INDEX_ISUSERSCOPE = 13;
    private static final int INDEX_MEMO = 14;
    private static final int INDEX_NOVALUEEMPTY = 15;
    private static final int INDEX_ORMODE = 16;
    private static final int INDEX_RESERVER = 17;
    private static final int INDEX_RESERVER2 = 18;
    private static final int INDEX_RESERVER3 = 19;
    private static final int INDEX_RESERVER4 = 20;
    private static final int INDEX_RESERVER5 = 21;
    private static final int INDEX_SEPERATOR = 22;
    private static final int INDEX_SRFSYSPUB = 23;
    private static final int INDEX_SRFUSERPUB = 24;
    private static final int INDEX_UPDATEDATE = 25;
    private static final int INDEX_UPDATEMAN = 26;
    private static final int INDEX_VALUESEPERATOR = 27;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private CodeListBase proxyCodeListBase = null;
    private boolean clmodelDirtyFlag = false;
    private boolean clparamDirtyFlag = false;
    private boolean clpathDirtyFlag = false;
    private boolean clversionDirtyFlag = false;
    private boolean codelistidDirtyFlag = false;
    private boolean codelistnameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean deidDirtyFlag = false;
    private boolean denameDirtyFlag = false;
    private boolean emptytextDirtyFlag = false;
    private boolean fillerDirtyFlag = false;
    private boolean issystemDirtyFlag = false;
    private boolean isuserscopeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean novalueemptyDirtyFlag = false;
    private boolean ormodeDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean reserver5DirtyFlag = false;
    private boolean seperatorDirtyFlag = false;
    private boolean srfsyspubDirtyFlag = false;
    private boolean srfuserpubDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean valueseperatorDirtyFlag = false;
    @Column(name="clmodel")
    private String clmodel;
    @Column(name="clparam")
    private String clparam;
    @Column(name="clpath")
    private String clpath;
    @Column(name="clversion")
    private Integer clversion;
    @Column(name="codelistid")
    private String codelistid;
    @Column(name="codelistname")
    private String codelistname;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="deid")
    private String deid;
    @Column(name="dename")
    private String dename;
    @Column(name="emptytext")
    private String emptytext;
    @Column(name="filler")
    private String filler;
    @Column(name="issystem")
    private Integer issystem;
    @Column(name="isuserscope")
    private Integer isuserscope;
    @Column(name="memo")
    private String memo;
    @Column(name="novalueempty")
    private Integer novalueempty;
    @Column(name="ormode")
    private String ormode;
    @Column(name="reserver")
    private String reserver;
    @Column(name="reserver2")
    private String reserver2;
    @Column(name="reserver3")
    private String reserver3;
    @Column(name="reserver4")
    private String reserver4;
    @Column(name="reserver5")
    private Timestamp reserver5;
    @Column(name="seperator")
    private String seperator;
    @Column(name="srfsyspub")
    private Integer srfsyspub;
    @Column(name="srfuserpub")
    private Integer srfuserpub;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="valueseperator")
    private String valueseperator;
    private Integer objDELock = new Integer(1);
    private DataEntity de = null;

    static {
        fieldIndexMap.put(FIELD_CLMODEL, 0);
        fieldIndexMap.put(FIELD_CLPARAM, 1);
        fieldIndexMap.put(FIELD_CLPATH, 2);
        fieldIndexMap.put(FIELD_CLVERSION, 3);
        fieldIndexMap.put(FIELD_CODELISTID, 4);
        fieldIndexMap.put(FIELD_CODELISTNAME, 5);
        fieldIndexMap.put(FIELD_CREATEDATE, 6);
        fieldIndexMap.put(FIELD_CREATEMAN, 7);
        fieldIndexMap.put(FIELD_DEID, 8);
        fieldIndexMap.put(FIELD_DENAME, 9);
        fieldIndexMap.put(FIELD_EMPTYTEXT, 10);
        fieldIndexMap.put(FIELD_FILLER, 11);
        fieldIndexMap.put(FIELD_ISSYSTEM, 12);
        fieldIndexMap.put(FIELD_ISUSERSCOPE, 13);
        fieldIndexMap.put(FIELD_MEMO, 14);
        fieldIndexMap.put(FIELD_NOVALUEEMPTY, 15);
        fieldIndexMap.put(FIELD_ORMODE, 16);
        fieldIndexMap.put(FIELD_RESERVER, 17);
        fieldIndexMap.put(FIELD_RESERVER2, 18);
        fieldIndexMap.put(FIELD_RESERVER3, 19);
        fieldIndexMap.put(FIELD_RESERVER4, 20);
        fieldIndexMap.put(FIELD_RESERVER5, 21);
        fieldIndexMap.put(FIELD_SEPERATOR, 22);
        fieldIndexMap.put(FIELD_SRFSYSPUB, 23);
        fieldIndexMap.put(FIELD_SRFUSERPUB, 24);
        fieldIndexMap.put(FIELD_UPDATEDATE, 25);
        fieldIndexMap.put(FIELD_UPDATEMAN, 26);
        fieldIndexMap.put(FIELD_VALUESEPERATOR, 27);
    }

    public void setCLModel(String clmodel) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCLModel(clmodel);
            return;
        }
        if (clmodel != null && (clmodel = StringHelper.trimRight(clmodel)).length() == 0) {
            clmodel = null;
        }
        this.clmodel = clmodel;
        this.clmodelDirtyFlag = true;
    }

    public String getCLModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCLModel();
        }
        return this.clmodel;
    }

    public boolean isCLModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCLModelDirty();
        }
        return this.clmodelDirtyFlag;
    }

    public void resetCLModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCLModel();
            return;
        }
        this.clmodelDirtyFlag = false;
        this.clmodel = null;
    }

    public void setCLParam(String clparam) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCLParam(clparam);
            return;
        }
        if (clparam != null && (clparam = StringHelper.trimRight(clparam)).length() == 0) {
            clparam = null;
        }
        this.clparam = clparam;
        this.clparamDirtyFlag = true;
    }

    public String getCLParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCLParam();
        }
        return this.clparam;
    }

    public boolean isCLParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCLParamDirty();
        }
        return this.clparamDirtyFlag;
    }

    public void resetCLParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCLParam();
            return;
        }
        this.clparamDirtyFlag = false;
        this.clparam = null;
    }

    public void setCLPath(String clpath) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCLPath(clpath);
            return;
        }
        if (clpath != null && (clpath = StringHelper.trimRight(clpath)).length() == 0) {
            clpath = null;
        }
        this.clpath = clpath;
        this.clpathDirtyFlag = true;
    }

    public String getCLPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCLPath();
        }
        return this.clpath;
    }

    public boolean isCLPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCLPathDirty();
        }
        return this.clpathDirtyFlag;
    }

    public void resetCLPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCLPath();
            return;
        }
        this.clpathDirtyFlag = false;
        this.clpath = null;
    }

    public void setCLVersion(Integer clversion) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCLVersion(clversion);
            return;
        }
        this.clversion = clversion;
        this.clversionDirtyFlag = true;
    }

    public Integer getCLVersion() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCLVersion();
        }
        return this.clversion;
    }

    public boolean isCLVersionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCLVersionDirty();
        }
        return this.clversionDirtyFlag;
    }

    public void resetCLVersion() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCLVersion();
            return;
        }
        this.clversionDirtyFlag = false;
        this.clversion = null;
    }

    public void setCodeListId(String codelistid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeListId(codelistid);
            return;
        }
        if (codelistid != null && (codelistid = StringHelper.trimRight(codelistid)).length() == 0) {
            codelistid = null;
        }
        this.codelistid = codelistid;
        this.codelistidDirtyFlag = true;
    }

    public String getCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeListId();
        }
        return this.codelistid;
    }

    public boolean isCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeListIdDirty();
        }
        return this.codelistidDirtyFlag;
    }

    public void resetCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeListId();
            return;
        }
        this.codelistidDirtyFlag = false;
        this.codelistid = null;
    }

    public void setCodeListName(String codelistname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeListName(codelistname);
            return;
        }
        if (codelistname != null && (codelistname = StringHelper.trimRight(codelistname)).length() == 0) {
            codelistname = null;
        }
        this.codelistname = codelistname;
        this.codelistnameDirtyFlag = true;
    }

    public String getCodeListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeListName();
        }
        return this.codelistname;
    }

    public boolean isCodeListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeListNameDirty();
        }
        return this.codelistnameDirtyFlag;
    }

    public void resetCodeListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeListName();
            return;
        }
        this.codelistnameDirtyFlag = false;
        this.codelistname = null;
    }

    public void setCreateDate(Timestamp createdate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(createdate);
            return;
        }
        this.createdate = createdate;
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

    public void setCreateMan(String createman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(createman);
            return;
        }
        if (createman != null && (createman = StringHelper.trimRight(createman)).length() == 0) {
            createman = null;
        }
        this.createman = createman;
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

    public void setDEId(String deid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEId(deid);
            return;
        }
        if (deid != null && (deid = StringHelper.trimRight(deid)).length() == 0) {
            deid = null;
        }
        this.deid = deid;
        this.deidDirtyFlag = true;
    }

    public String getDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEId();
        }
        return this.deid;
    }

    public boolean isDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEIdDirty();
        }
        return this.deidDirtyFlag;
    }

    public void resetDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEId();
            return;
        }
        this.deidDirtyFlag = false;
        this.deid = null;
    }

    public void setDEName(String dename) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEName(dename);
            return;
        }
        if (dename != null && (dename = StringHelper.trimRight(dename)).length() == 0) {
            dename = null;
        }
        this.dename = dename;
        this.denameDirtyFlag = true;
    }

    public String getDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEName();
        }
        return this.dename;
    }

    public boolean isDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDENameDirty();
        }
        return this.denameDirtyFlag;
    }

    public void resetDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEName();
            return;
        }
        this.denameDirtyFlag = false;
        this.dename = null;
    }

    public void setEmptyText(String emptytext) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmptyText(emptytext);
            return;
        }
        if (emptytext != null && (emptytext = StringHelper.trimRight(emptytext)).length() == 0) {
            emptytext = null;
        }
        this.emptytext = emptytext;
        this.emptytextDirtyFlag = true;
    }

    public String getEmptyText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmptyText();
        }
        return this.emptytext;
    }

    public boolean isEmptyTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmptyTextDirty();
        }
        return this.emptytextDirtyFlag;
    }

    public void resetEmptyText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmptyText();
            return;
        }
        this.emptytextDirtyFlag = false;
        this.emptytext = null;
    }

    public void setFiller(String filler) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFiller(filler);
            return;
        }
        if (filler != null && (filler = StringHelper.trimRight(filler)).length() == 0) {
            filler = null;
        }
        this.filler = filler;
        this.fillerDirtyFlag = true;
    }

    public String getFiller() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFiller();
        }
        return this.filler;
    }

    public boolean isFillerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFillerDirty();
        }
        return this.fillerDirtyFlag;
    }

    public void resetFiller() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFiller();
            return;
        }
        this.fillerDirtyFlag = false;
        this.filler = null;
    }

    public void setIsSystem(Integer issystem) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIsSystem(issystem);
            return;
        }
        this.issystem = issystem;
        this.issystemDirtyFlag = true;
    }

    public Integer getIsSystem() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIsSystem();
        }
        return this.issystem;
    }

    public boolean isIsSystemDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIsSystemDirty();
        }
        return this.issystemDirtyFlag;
    }

    public void resetIsSystem() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIsSystem();
            return;
        }
        this.issystemDirtyFlag = false;
        this.issystem = null;
    }

    public void setIsUserScope(Integer isuserscope) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIsUserScope(isuserscope);
            return;
        }
        this.isuserscope = isuserscope;
        this.isuserscopeDirtyFlag = true;
    }

    public Integer getIsUserScope() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIsUserScope();
        }
        return this.isuserscope;
    }

    public boolean isIsUserScopeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIsUserScopeDirty();
        }
        return this.isuserscopeDirtyFlag;
    }

    public void resetIsUserScope() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIsUserScope();
            return;
        }
        this.isuserscopeDirtyFlag = false;
        this.isuserscope = null;
    }

    public void setMemo(String memo) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(memo);
            return;
        }
        if (memo != null && (memo = StringHelper.trimRight(memo)).length() == 0) {
            memo = null;
        }
        this.memo = memo;
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

    public void setNoValueEmpty(Integer novalueempty) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNoValueEmpty(novalueempty);
            return;
        }
        this.novalueempty = novalueempty;
        this.novalueemptyDirtyFlag = true;
    }

    public Integer getNoValueEmpty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNoValueEmpty();
        }
        return this.novalueempty;
    }

    public boolean isNoValueEmptyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNoValueEmptyDirty();
        }
        return this.novalueemptyDirtyFlag;
    }

    public void resetNoValueEmpty() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNoValueEmpty();
            return;
        }
        this.novalueemptyDirtyFlag = false;
        this.novalueempty = null;
    }

    public void setORMode(String ormode) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setORMode(ormode);
            return;
        }
        if (ormode != null && (ormode = StringHelper.trimRight(ormode)).length() == 0) {
            ormode = null;
        }
        this.ormode = ormode;
        this.ormodeDirtyFlag = true;
    }

    public String getORMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getORMode();
        }
        return this.ormode;
    }

    public boolean isORModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isORModeDirty();
        }
        return this.ormodeDirtyFlag;
    }

    public void resetORMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetORMode();
            return;
        }
        this.ormodeDirtyFlag = false;
        this.ormode = null;
    }

    public void setReserver(String reserver) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver(reserver);
            return;
        }
        if (reserver != null && (reserver = StringHelper.trimRight(reserver)).length() == 0) {
            reserver = null;
        }
        this.reserver = reserver;
        this.reserverDirtyFlag = true;
    }

    public String getReserver() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver();
        }
        return this.reserver;
    }

    public boolean isReserverDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserverDirty();
        }
        return this.reserverDirtyFlag;
    }

    public void resetReserver() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver();
            return;
        }
        this.reserverDirtyFlag = false;
        this.reserver = null;
    }

    public void setReserver2(String reserver2) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver2(reserver2);
            return;
        }
        if (reserver2 != null && (reserver2 = StringHelper.trimRight(reserver2)).length() == 0) {
            reserver2 = null;
        }
        this.reserver2 = reserver2;
        this.reserver2DirtyFlag = true;
    }

    public String getReserver2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver2();
        }
        return this.reserver2;
    }

    public boolean isReserver2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver2Dirty();
        }
        return this.reserver2DirtyFlag;
    }

    public void resetReserver2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver2();
            return;
        }
        this.reserver2DirtyFlag = false;
        this.reserver2 = null;
    }

    public void setReserver3(String reserver3) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver3(reserver3);
            return;
        }
        if (reserver3 != null && (reserver3 = StringHelper.trimRight(reserver3)).length() == 0) {
            reserver3 = null;
        }
        this.reserver3 = reserver3;
        this.reserver3DirtyFlag = true;
    }

    public String getReserver3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver3();
        }
        return this.reserver3;
    }

    public boolean isReserver3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver3Dirty();
        }
        return this.reserver3DirtyFlag;
    }

    public void resetReserver3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver3();
            return;
        }
        this.reserver3DirtyFlag = false;
        this.reserver3 = null;
    }

    public void setReserver4(String reserver4) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver4(reserver4);
            return;
        }
        if (reserver4 != null && (reserver4 = StringHelper.trimRight(reserver4)).length() == 0) {
            reserver4 = null;
        }
        this.reserver4 = reserver4;
        this.reserver4DirtyFlag = true;
    }

    public String getReserver4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver4();
        }
        return this.reserver4;
    }

    public boolean isReserver4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver4Dirty();
        }
        return this.reserver4DirtyFlag;
    }

    public void resetReserver4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver4();
            return;
        }
        this.reserver4DirtyFlag = false;
        this.reserver4 = null;
    }

    public void setReserver5(Timestamp reserver5) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver5(reserver5);
            return;
        }
        this.reserver5 = reserver5;
        this.reserver5DirtyFlag = true;
    }

    public Timestamp getReserver5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver5();
        }
        return this.reserver5;
    }

    public boolean isReserver5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver5Dirty();
        }
        return this.reserver5DirtyFlag;
    }

    public void resetReserver5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver5();
            return;
        }
        this.reserver5DirtyFlag = false;
        this.reserver5 = null;
    }

    public void setSeperator(String seperator) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSeperator(seperator);
            return;
        }
        if (seperator != null && (seperator = StringHelper.trimRight(seperator)).length() == 0) {
            seperator = null;
        }
        this.seperator = seperator;
        this.seperatorDirtyFlag = true;
    }

    public String getSeperator() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSeperator();
        }
        return this.seperator;
    }

    public boolean isSeperatorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSeperatorDirty();
        }
        return this.seperatorDirtyFlag;
    }

    public void resetSeperator() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSeperator();
            return;
        }
        this.seperatorDirtyFlag = false;
        this.seperator = null;
    }

    public void setSRFSysPub(Integer srfsyspub) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSRFSysPub(srfsyspub);
            return;
        }
        this.srfsyspub = srfsyspub;
        this.srfsyspubDirtyFlag = true;
    }

    public Integer getSRFSysPub() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSRFSysPub();
        }
        return this.srfsyspub;
    }

    public boolean isSRFSysPubDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSRFSysPubDirty();
        }
        return this.srfsyspubDirtyFlag;
    }

    public void resetSRFSysPub() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSRFSysPub();
            return;
        }
        this.srfsyspubDirtyFlag = false;
        this.srfsyspub = null;
    }

    public void setSRFUserPub(Integer srfuserpub) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSRFUserPub(srfuserpub);
            return;
        }
        this.srfuserpub = srfuserpub;
        this.srfuserpubDirtyFlag = true;
    }

    public Integer getSRFUserPub() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSRFUserPub();
        }
        return this.srfuserpub;
    }

    public boolean isSRFUserPubDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSRFUserPubDirty();
        }
        return this.srfuserpubDirtyFlag;
    }

    public void resetSRFUserPub() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSRFUserPub();
            return;
        }
        this.srfuserpubDirtyFlag = false;
        this.srfuserpub = null;
    }

    public void setUpdateDate(Timestamp updatedate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(updatedate);
            return;
        }
        this.updatedate = updatedate;
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

    public void setUpdateMan(String updateman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(updateman);
            return;
        }
        if (updateman != null && (updateman = StringHelper.trimRight(updateman)).length() == 0) {
            updateman = null;
        }
        this.updateman = updateman;
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

    public void setValueSeperator(String valueseperator) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValueSeperator(valueseperator);
            return;
        }
        if (valueseperator != null && (valueseperator = StringHelper.trimRight(valueseperator)).length() == 0) {
            valueseperator = null;
        }
        this.valueseperator = valueseperator;
        this.valueseperatorDirtyFlag = true;
    }

    public String getValueSeperator() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValueSeperator();
        }
        return this.valueseperator;
    }

    public boolean isValueSeperatorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueSeperatorDirty();
        }
        return this.valueseperatorDirtyFlag;
    }

    public void resetValueSeperator() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValueSeperator();
            return;
        }
        this.valueseperatorDirtyFlag = false;
        this.valueseperator = null;
    }

    @Override
    protected void onReset() {
        CodeListBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(CodeListBase et) {
        et.resetCLModel();
        et.resetCLParam();
        et.resetCLPath();
        et.resetCLVersion();
        et.resetCodeListId();
        et.resetCodeListName();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDEId();
        et.resetDEName();
        et.resetEmptyText();
        et.resetFiller();
        et.resetIsSystem();
        et.resetIsUserScope();
        et.resetMemo();
        et.resetNoValueEmpty();
        et.resetORMode();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetReserver5();
        et.resetSeperator();
        et.resetSRFSysPub();
        et.resetSRFUserPub();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetValueSeperator();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCLModelDirty()) {
            params.put(FIELD_CLMODEL, this.getCLModel());
        }
        if (!bDirtyOnly || this.isCLParamDirty()) {
            params.put(FIELD_CLPARAM, this.getCLParam());
        }
        if (!bDirtyOnly || this.isCLPathDirty()) {
            params.put(FIELD_CLPATH, this.getCLPath());
        }
        if (!bDirtyOnly || this.isCLVersionDirty()) {
            params.put(FIELD_CLVERSION, this.getCLVersion());
        }
        if (!bDirtyOnly || this.isCodeListIdDirty()) {
            params.put(FIELD_CODELISTID, this.getCodeListId());
        }
        if (!bDirtyOnly || this.isCodeListNameDirty()) {
            params.put(FIELD_CODELISTNAME, this.getCodeListName());
        }
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isDEIdDirty()) {
            params.put(FIELD_DEID, this.getDEId());
        }
        if (!bDirtyOnly || this.isDENameDirty()) {
            params.put(FIELD_DENAME, this.getDEName());
        }
        if (!bDirtyOnly || this.isEmptyTextDirty()) {
            params.put(FIELD_EMPTYTEXT, this.getEmptyText());
        }
        if (!bDirtyOnly || this.isFillerDirty()) {
            params.put(FIELD_FILLER, this.getFiller());
        }
        if (!bDirtyOnly || this.isIsSystemDirty()) {
            params.put(FIELD_ISSYSTEM, this.getIsSystem());
        }
        if (!bDirtyOnly || this.isIsUserScopeDirty()) {
            params.put(FIELD_ISUSERSCOPE, this.getIsUserScope());
        }
        if (!bDirtyOnly || this.isMemoDirty()) {
            params.put(FIELD_MEMO, this.getMemo());
        }
        if (!bDirtyOnly || this.isNoValueEmptyDirty()) {
            params.put(FIELD_NOVALUEEMPTY, this.getNoValueEmpty());
        }
        if (!bDirtyOnly || this.isORModeDirty()) {
            params.put(FIELD_ORMODE, this.getORMode());
        }
        if (!bDirtyOnly || this.isReserverDirty()) {
            params.put(FIELD_RESERVER, this.getReserver());
        }
        if (!bDirtyOnly || this.isReserver2Dirty()) {
            params.put(FIELD_RESERVER2, this.getReserver2());
        }
        if (!bDirtyOnly || this.isReserver3Dirty()) {
            params.put(FIELD_RESERVER3, this.getReserver3());
        }
        if (!bDirtyOnly || this.isReserver4Dirty()) {
            params.put(FIELD_RESERVER4, this.getReserver4());
        }
        if (!bDirtyOnly || this.isReserver5Dirty()) {
            params.put(FIELD_RESERVER5, this.getReserver5());
        }
        if (!bDirtyOnly || this.isSeperatorDirty()) {
            params.put(FIELD_SEPERATOR, this.getSeperator());
        }
        if (!bDirtyOnly || this.isSRFSysPubDirty()) {
            params.put(FIELD_SRFSYSPUB, this.getSRFSysPub());
        }
        if (!bDirtyOnly || this.isSRFUserPubDirty()) {
            params.put(FIELD_SRFUSERPUB, this.getSRFUserPub());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isValueSeperatorDirty()) {
            params.put(FIELD_VALUESEPERATOR, this.getValueSeperator());
        }
        super.onFillMap(params, bDirtyOnly);
    }

    @Override
    public Object get(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.get(strParamName);
        }
        return CodeListBase.get(this, index);
    }

    private static Object get(CodeListBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCLModel();
            }
            case 1: {
                return et.getCLParam();
            }
            case 2: {
                return et.getCLPath();
            }
            case 3: {
                return et.getCLVersion();
            }
            case 4: {
                return et.getCodeListId();
            }
            case 5: {
                return et.getCodeListName();
            }
            case 6: {
                return et.getCreateDate();
            }
            case 7: {
                return et.getCreateMan();
            }
            case 8: {
                return et.getDEId();
            }
            case 9: {
                return et.getDEName();
            }
            case 10: {
                return et.getEmptyText();
            }
            case 11: {
                return et.getFiller();
            }
            case 12: {
                return et.getIsSystem();
            }
            case 13: {
                return et.getIsUserScope();
            }
            case 14: {
                return et.getMemo();
            }
            case 15: {
                return et.getNoValueEmpty();
            }
            case 16: {
                return et.getORMode();
            }
            case 17: {
                return et.getReserver();
            }
            case 18: {
                return et.getReserver2();
            }
            case 19: {
                return et.getReserver3();
            }
            case 20: {
                return et.getReserver4();
            }
            case 21: {
                return et.getReserver5();
            }
            case 22: {
                return et.getSeperator();
            }
            case 23: {
                return et.getSRFSysPub();
            }
            case 24: {
                return et.getSRFUserPub();
            }
            case 25: {
                return et.getUpdateDate();
            }
            case 26: {
                return et.getUpdateMan();
            }
            case 27: {
                return et.getValueSeperator();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public void set(String strParamName, Object objValue) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(strParamName, objValue);
            return;
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            super.set(strParamName, objValue);
            return;
        }
        CodeListBase.set(this, index, objValue);
    }

    private static void set(CodeListBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setCLModel(DataObject.getStringValue(obj));
                return;
            }
            case 1: {
                et.setCLParam(DataObject.getStringValue(obj));
                return;
            }
            case 2: {
                et.setCLPath(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setCLVersion(DataObject.getIntegerValue(obj));
                return;
            }
            case 4: {
                et.setCodeListId(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setCodeListName(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 7: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setDEId(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setDEName(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setEmptyText(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setFiller(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setIsSystem(DataObject.getIntegerValue(obj));
                return;
            }
            case 13: {
                et.setIsUserScope(DataObject.getIntegerValue(obj));
                return;
            }
            case 14: {
                et.setMemo(DataObject.getStringValue(obj));
                return;
            }
            case 15: {
                et.setNoValueEmpty(DataObject.getIntegerValue(obj));
                return;
            }
            case 16: {
                et.setORMode(DataObject.getStringValue(obj));
                return;
            }
            case 17: {
                et.setReserver(DataObject.getStringValue(obj));
                return;
            }
            case 18: {
                et.setReserver2(DataObject.getStringValue(obj));
                return;
            }
            case 19: {
                et.setReserver3(DataObject.getStringValue(obj));
                return;
            }
            case 20: {
                et.setReserver4(DataObject.getStringValue(obj));
                return;
            }
            case 21: {
                et.setReserver5(DataObject.getTimestampValue(obj));
                return;
            }
            case 22: {
                et.setSeperator(DataObject.getStringValue(obj));
                return;
            }
            case 23: {
                et.setSRFSysPub(DataObject.getIntegerValue(obj));
                return;
            }
            case 24: {
                et.setSRFUserPub(DataObject.getIntegerValue(obj));
                return;
            }
            case 25: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 26: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 27: {
                et.setValueSeperator(DataObject.getStringValue(obj));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean isNull(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.isNull(strParamName);
        }
        return CodeListBase.isNull(this, index);
    }

    private static boolean isNull(CodeListBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCLModel() == null;
            }
            case 1: {
                return et.getCLParam() == null;
            }
            case 2: {
                return et.getCLPath() == null;
            }
            case 3: {
                return et.getCLVersion() == null;
            }
            case 4: {
                return et.getCodeListId() == null;
            }
            case 5: {
                return et.getCodeListName() == null;
            }
            case 6: {
                return et.getCreateDate() == null;
            }
            case 7: {
                return et.getCreateMan() == null;
            }
            case 8: {
                return et.getDEId() == null;
            }
            case 9: {
                return et.getDEName() == null;
            }
            case 10: {
                return et.getEmptyText() == null;
            }
            case 11: {
                return et.getFiller() == null;
            }
            case 12: {
                return et.getIsSystem() == null;
            }
            case 13: {
                return et.getIsUserScope() == null;
            }
            case 14: {
                return et.getMemo() == null;
            }
            case 15: {
                return et.getNoValueEmpty() == null;
            }
            case 16: {
                return et.getORMode() == null;
            }
            case 17: {
                return et.getReserver() == null;
            }
            case 18: {
                return et.getReserver2() == null;
            }
            case 19: {
                return et.getReserver3() == null;
            }
            case 20: {
                return et.getReserver4() == null;
            }
            case 21: {
                return et.getReserver5() == null;
            }
            case 22: {
                return et.getSeperator() == null;
            }
            case 23: {
                return et.getSRFSysPub() == null;
            }
            case 24: {
                return et.getSRFUserPub() == null;
            }
            case 25: {
                return et.getUpdateDate() == null;
            }
            case 26: {
                return et.getUpdateMan() == null;
            }
            case 27: {
                return et.getValueSeperator() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean contains(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.contains(strParamName);
        }
        return CodeListBase.contains(this, index);
    }

    private static boolean contains(CodeListBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCLModelDirty();
            }
            case 1: {
                return et.isCLParamDirty();
            }
            case 2: {
                return et.isCLPathDirty();
            }
            case 3: {
                return et.isCLVersionDirty();
            }
            case 4: {
                return et.isCodeListIdDirty();
            }
            case 5: {
                return et.isCodeListNameDirty();
            }
            case 6: {
                return et.isCreateDateDirty();
            }
            case 7: {
                return et.isCreateManDirty();
            }
            case 8: {
                return et.isDEIdDirty();
            }
            case 9: {
                return et.isDENameDirty();
            }
            case 10: {
                return et.isEmptyTextDirty();
            }
            case 11: {
                return et.isFillerDirty();
            }
            case 12: {
                return et.isIsSystemDirty();
            }
            case 13: {
                return et.isIsUserScopeDirty();
            }
            case 14: {
                return et.isMemoDirty();
            }
            case 15: {
                return et.isNoValueEmptyDirty();
            }
            case 16: {
                return et.isORModeDirty();
            }
            case 17: {
                return et.isReserverDirty();
            }
            case 18: {
                return et.isReserver2Dirty();
            }
            case 19: {
                return et.isReserver3Dirty();
            }
            case 20: {
                return et.isReserver4Dirty();
            }
            case 21: {
                return et.isReserver5Dirty();
            }
            case 22: {
                return et.isSeperatorDirty();
            }
            case 23: {
                return et.isSRFSysPubDirty();
            }
            case 24: {
                return et.isSRFUserPubDirty();
            }
            case 25: {
                return et.isUpdateDateDirty();
            }
            case 26: {
                return et.isUpdateManDirty();
            }
            case 27: {
                return et.isValueSeperatorDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        CodeListBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(CodeListBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCLModel() != null) {
            JSONObjectHelper.put(json, "clmodel", CodeListBase.getJSONValue(et.getCLModel()), false);
        }
        if (bIncEmpty || et.getCLParam() != null) {
            JSONObjectHelper.put(json, "clparam", CodeListBase.getJSONValue(et.getCLParam()), false);
        }
        if (bIncEmpty || et.getCLPath() != null) {
            JSONObjectHelper.put(json, "clpath", CodeListBase.getJSONValue(et.getCLPath()), false);
        }
        if (bIncEmpty || et.getCLVersion() != null) {
            JSONObjectHelper.put(json, "clversion", CodeListBase.getJSONValue(et.getCLVersion()), false);
        }
        if (bIncEmpty || et.getCodeListId() != null) {
            JSONObjectHelper.put(json, "codelistid", CodeListBase.getJSONValue(et.getCodeListId()), false);
        }
        if (bIncEmpty || et.getCodeListName() != null) {
            JSONObjectHelper.put(json, "codelistname", CodeListBase.getJSONValue(et.getCodeListName()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", CodeListBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", CodeListBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getDEId() != null) {
            JSONObjectHelper.put(json, "deid", CodeListBase.getJSONValue(et.getDEId()), false);
        }
        if (bIncEmpty || et.getDEName() != null) {
            JSONObjectHelper.put(json, "dename", CodeListBase.getJSONValue(et.getDEName()), false);
        }
        if (bIncEmpty || et.getEmptyText() != null) {
            JSONObjectHelper.put(json, "emptytext", CodeListBase.getJSONValue(et.getEmptyText()), false);
        }
        if (bIncEmpty || et.getFiller() != null) {
            JSONObjectHelper.put(json, "filler", CodeListBase.getJSONValue(et.getFiller()), false);
        }
        if (bIncEmpty || et.getIsSystem() != null) {
            JSONObjectHelper.put(json, "issystem", CodeListBase.getJSONValue(et.getIsSystem()), false);
        }
        if (bIncEmpty || et.getIsUserScope() != null) {
            JSONObjectHelper.put(json, "isuserscope", CodeListBase.getJSONValue(et.getIsUserScope()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", CodeListBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getNoValueEmpty() != null) {
            JSONObjectHelper.put(json, "novalueempty", CodeListBase.getJSONValue(et.getNoValueEmpty()), false);
        }
        if (bIncEmpty || et.getORMode() != null) {
            JSONObjectHelper.put(json, "ormode", CodeListBase.getJSONValue(et.getORMode()), false);
        }
        if (bIncEmpty || et.getReserver() != null) {
            JSONObjectHelper.put(json, "reserver", CodeListBase.getJSONValue(et.getReserver()), false);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            JSONObjectHelper.put(json, "reserver2", CodeListBase.getJSONValue(et.getReserver2()), false);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            JSONObjectHelper.put(json, "reserver3", CodeListBase.getJSONValue(et.getReserver3()), false);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            JSONObjectHelper.put(json, "reserver4", CodeListBase.getJSONValue(et.getReserver4()), false);
        }
        if (bIncEmpty || et.getReserver5() != null) {
            JSONObjectHelper.put(json, "reserver5", CodeListBase.getJSONValue(et.getReserver5()), false);
        }
        if (bIncEmpty || et.getSeperator() != null) {
            JSONObjectHelper.put(json, "seperator", CodeListBase.getJSONValue(et.getSeperator()), false);
        }
        if (bIncEmpty || et.getSRFSysPub() != null) {
            JSONObjectHelper.put(json, "srfsyspub", CodeListBase.getJSONValue(et.getSRFSysPub()), false);
        }
        if (bIncEmpty || et.getSRFUserPub() != null) {
            JSONObjectHelper.put(json, "srfuserpub", CodeListBase.getJSONValue(et.getSRFUserPub()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", CodeListBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", CodeListBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getValueSeperator() != null) {
            JSONObjectHelper.put(json, "valueseperator", CodeListBase.getJSONValue(et.getValueSeperator()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        CodeListBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(CodeListBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCLModel() != null) {
            obj = et.getCLModel();
            node.setAttribute(FIELD_CLMODEL, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getCLParam() != null) {
            obj = et.getCLParam();
            node.setAttribute(FIELD_CLPARAM, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getCLPath() != null) {
            obj = et.getCLPath();
            node.setAttribute(FIELD_CLPATH, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getCLVersion() != null) {
            obj = et.getCLVersion();
            node.setAttribute(FIELD_CLVERSION, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getCodeListId() != null) {
            obj = et.getCodeListId();
            node.setAttribute(FIELD_CODELISTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getCodeListName() != null) {
            obj = et.getCodeListName();
            node.setAttribute(FIELD_CODELISTNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDEId() != null) {
            obj = et.getDEId();
            node.setAttribute(FIELD_DEID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDEName() != null) {
            obj = et.getDEName();
            node.setAttribute(FIELD_DENAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getEmptyText() != null) {
            obj = et.getEmptyText();
            node.setAttribute(FIELD_EMPTYTEXT, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getFiller() != null) {
            obj = et.getFiller();
            node.setAttribute(FIELD_FILLER, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getIsSystem() != null) {
            obj = et.getIsSystem();
            node.setAttribute(FIELD_ISSYSTEM, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getIsUserScope() != null) {
            obj = et.getIsUserScope();
            node.setAttribute(FIELD_ISUSERSCOPE, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getMemo() != null) {
            obj = et.getMemo();
            node.setAttribute(FIELD_MEMO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getNoValueEmpty() != null) {
            obj = et.getNoValueEmpty();
            node.setAttribute(FIELD_NOVALUEEMPTY, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getORMode() != null) {
            obj = et.getORMode();
            node.setAttribute(FIELD_ORMODE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver() != null) {
            obj = et.getReserver();
            node.setAttribute(FIELD_RESERVER, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            obj = et.getReserver2();
            node.setAttribute(FIELD_RESERVER2, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            obj = et.getReserver3();
            node.setAttribute(FIELD_RESERVER3, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            obj = et.getReserver4();
            node.setAttribute(FIELD_RESERVER4, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver5() != null) {
            obj = et.getReserver5();
            node.setAttribute(FIELD_RESERVER5, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getSeperator() != null) {
            obj = et.getSeperator();
            node.setAttribute(FIELD_SEPERATOR, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getSRFSysPub() != null) {
            obj = et.getSRFSysPub();
            node.setAttribute(FIELD_SRFSYSPUB, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getSRFUserPub() != null) {
            obj = et.getSRFUserPub();
            node.setAttribute(FIELD_SRFUSERPUB, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getValueSeperator() != null) {
            obj = et.getValueSeperator();
            node.setAttribute(FIELD_VALUESEPERATOR, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        CodeListBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(CodeListBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCLModelDirty() && (bIncEmpty || et.getCLModel() != null)) {
            dst.set(FIELD_CLMODEL, et.getCLModel());
        }
        if (et.isCLParamDirty() && (bIncEmpty || et.getCLParam() != null)) {
            dst.set(FIELD_CLPARAM, et.getCLParam());
        }
        if (et.isCLPathDirty() && (bIncEmpty || et.getCLPath() != null)) {
            dst.set(FIELD_CLPATH, et.getCLPath());
        }
        if (et.isCLVersionDirty() && (bIncEmpty || et.getCLVersion() != null)) {
            dst.set(FIELD_CLVERSION, et.getCLVersion());
        }
        if (et.isCodeListIdDirty() && (bIncEmpty || et.getCodeListId() != null)) {
            dst.set(FIELD_CODELISTID, et.getCodeListId());
        }
        if (et.isCodeListNameDirty() && (bIncEmpty || et.getCodeListName() != null)) {
            dst.set(FIELD_CODELISTNAME, et.getCodeListName());
        }
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isDEIdDirty() && (bIncEmpty || et.getDEId() != null)) {
            dst.set(FIELD_DEID, et.getDEId());
        }
        if (et.isDENameDirty() && (bIncEmpty || et.getDEName() != null)) {
            dst.set(FIELD_DENAME, et.getDEName());
        }
        if (et.isEmptyTextDirty() && (bIncEmpty || et.getEmptyText() != null)) {
            dst.set(FIELD_EMPTYTEXT, et.getEmptyText());
        }
        if (et.isFillerDirty() && (bIncEmpty || et.getFiller() != null)) {
            dst.set(FIELD_FILLER, et.getFiller());
        }
        if (et.isIsSystemDirty() && (bIncEmpty || et.getIsSystem() != null)) {
            dst.set(FIELD_ISSYSTEM, et.getIsSystem());
        }
        if (et.isIsUserScopeDirty() && (bIncEmpty || et.getIsUserScope() != null)) {
            dst.set(FIELD_ISUSERSCOPE, et.getIsUserScope());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
        }
        if (et.isNoValueEmptyDirty() && (bIncEmpty || et.getNoValueEmpty() != null)) {
            dst.set(FIELD_NOVALUEEMPTY, et.getNoValueEmpty());
        }
        if (et.isORModeDirty() && (bIncEmpty || et.getORMode() != null)) {
            dst.set(FIELD_ORMODE, et.getORMode());
        }
        if (et.isReserverDirty() && (bIncEmpty || et.getReserver() != null)) {
            dst.set(FIELD_RESERVER, et.getReserver());
        }
        if (et.isReserver2Dirty() && (bIncEmpty || et.getReserver2() != null)) {
            dst.set(FIELD_RESERVER2, et.getReserver2());
        }
        if (et.isReserver3Dirty() && (bIncEmpty || et.getReserver3() != null)) {
            dst.set(FIELD_RESERVER3, et.getReserver3());
        }
        if (et.isReserver4Dirty() && (bIncEmpty || et.getReserver4() != null)) {
            dst.set(FIELD_RESERVER4, et.getReserver4());
        }
        if (et.isReserver5Dirty() && (bIncEmpty || et.getReserver5() != null)) {
            dst.set(FIELD_RESERVER5, et.getReserver5());
        }
        if (et.isSeperatorDirty() && (bIncEmpty || et.getSeperator() != null)) {
            dst.set(FIELD_SEPERATOR, et.getSeperator());
        }
        if (et.isSRFSysPubDirty() && (bIncEmpty || et.getSRFSysPub() != null)) {
            dst.set(FIELD_SRFSYSPUB, et.getSRFSysPub());
        }
        if (et.isSRFUserPubDirty() && (bIncEmpty || et.getSRFUserPub() != null)) {
            dst.set(FIELD_SRFUSERPUB, et.getSRFUserPub());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isValueSeperatorDirty() && (bIncEmpty || et.getValueSeperator() != null)) {
            dst.set(FIELD_VALUESEPERATOR, et.getValueSeperator());
        }
    }

    @Override
    public boolean remove(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.remove(strParamName);
        }
        return CodeListBase.remove(this, index);
    }

    private static boolean remove(CodeListBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetCLModel();
                return true;
            }
            case 1: {
                et.resetCLParam();
                return true;
            }
            case 2: {
                et.resetCLPath();
                return true;
            }
            case 3: {
                et.resetCLVersion();
                return true;
            }
            case 4: {
                et.resetCodeListId();
                return true;
            }
            case 5: {
                et.resetCodeListName();
                return true;
            }
            case 6: {
                et.resetCreateDate();
                return true;
            }
            case 7: {
                et.resetCreateMan();
                return true;
            }
            case 8: {
                et.resetDEId();
                return true;
            }
            case 9: {
                et.resetDEName();
                return true;
            }
            case 10: {
                et.resetEmptyText();
                return true;
            }
            case 11: {
                et.resetFiller();
                return true;
            }
            case 12: {
                et.resetIsSystem();
                return true;
            }
            case 13: {
                et.resetIsUserScope();
                return true;
            }
            case 14: {
                et.resetMemo();
                return true;
            }
            case 15: {
                et.resetNoValueEmpty();
                return true;
            }
            case 16: {
                et.resetORMode();
                return true;
            }
            case 17: {
                et.resetReserver();
                return true;
            }
            case 18: {
                et.resetReserver2();
                return true;
            }
            case 19: {
                et.resetReserver3();
                return true;
            }
            case 20: {
                et.resetReserver4();
                return true;
            }
            case 21: {
                et.resetReserver5();
                return true;
            }
            case 22: {
                et.resetSeperator();
                return true;
            }
            case 23: {
                et.resetSRFSysPub();
                return true;
            }
            case 24: {
                et.resetSRFUserPub();
                return true;
            }
            case 25: {
                et.resetUpdateDate();
                return true;
            }
            case 26: {
                et.resetUpdateMan();
                return true;
            }
            case 27: {
                et.resetValueSeperator();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public DataEntity getDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDE();
        }
        if (this.getDEId() == null) {
            return null;
        }
        Integer n = this.objDELock;
        synchronized (n) {
            if (this.de != null && DataTypeHelper.compare(25, (Object)this.getDEId(), (Object)this.de.getDEId()) != 0L) {
                this.de = null;
            }
            if (this.de == null) {
                DataEntity de = new DataEntity();
                de.setDEId(this.getDEId());
                DataEntityService service = (DataEntityService)ServiceGlobal.getService(DataEntityService.class, this.getSessionFactory());
                service.autoGet(de);
                this.de = de;
            }
            return this.de;
        }
    }

    private CodeListBase getProxyEntity() {
        return this.proxyCodeListBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyCodeListBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof CodeListBase) {
            this.proxyCodeListBase = (CodeListBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.CodeListService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

