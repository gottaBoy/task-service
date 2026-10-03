/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.entity;


import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;

import java.sql.Timestamp;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.paas.service.ServiceGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 实体[CodeList] 数据对象基类
 */
public abstract class CodeListBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(CodeListBase.class);
    /**
     * 属性[代码表模型]
     */
    public final static String FIELD_CLMODEL = "CLMODEL";
    /**
     * 属性[代码表参数]
     */
    public final static String FIELD_CLPARAM = "CLPARAM";
    /**
     * 属性[配置路径]
     */
    public final static String FIELD_CLPATH = "CLPATH";
    /**
     * 属性[代码表版本]
     */
    public final static String FIELD_CLVERSION = "CLVERSION";
    /**
     * 属性[代码表标识]
     */
    public final static String FIELD_CODELISTID = "CODELISTID";
    /**
     * 属性[代码表名称]
     */
    public final static String FIELD_CODELISTNAME = "CODELISTNAME";
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[数据实体]
     */
    public final static String FIELD_DEID = "DEID";
    /**
     * 属性[数据实体]
     */
    public final static String FIELD_DENAME = "DENAME";
    /**
     * 属性[空白显示内容]
     */
    public final static String FIELD_EMPTYTEXT = "EMPTYTEXT";
    /**
     * 属性[数据库填充器]
     */
    public final static String FIELD_FILLER = "FILLER";
    /**
     * 属性[系统数据]
     */
    public final static String FIELD_ISSYSTEM = "ISSYSTEM";
    /**
     * 属性[用户范围]
     */
    public final static String FIELD_ISUSERSCOPE = "ISUSERSCOPE";
    /**
     * 属性[备注]
     */
    public final static String FIELD_MEMO = "MEMO";
    /**
     * 属性[无值显示空白]
     */
    public final static String FIELD_NOVALUEEMPTY = "NOVALUEEMPTY";
    /**
     * 属性[或模式]
     */
    public final static String FIELD_ORMODE = "ORMODE";
    /**
     * 属性[保留字段]
     */
    public final static String FIELD_RESERVER = "RESERVER";
    /**
     * 属性[保留字段2]
     */
    public final static String FIELD_RESERVER2 = "RESERVER2";
    /**
     * 属性[保留字段3]
     */
    public final static String FIELD_RESERVER3 = "RESERVER3";
    /**
     * 属性[保留字段4]
     */
    public final static String FIELD_RESERVER4 = "RESERVER4";
    /**
     * 属性[保留字段5]
     */
    public final static String FIELD_RESERVER5 = "RESERVER5";
    /**
     * 属性[显示分割符号]
     */
    public final static String FIELD_SEPERATOR = "SEPERATOR";
    /**
     * 属性[框架发布]
     */
    public final static String FIELD_SRFSYSPUB = "SRFSYSPUB";
    /**
     * 属性[应用发布]
     */
    public final static String FIELD_SRFUSERPUB = "SRFUSERPUB";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[值分割符号]
     */
    public final static String FIELD_VALUESEPERATOR = "VALUESEPERATOR";

    private final static int INDEX_CLMODEL = 0;
    private final static int INDEX_CLPARAM = 1;
    private final static int INDEX_CLPATH = 2;
    private final static int INDEX_CLVERSION = 3;
    private final static int INDEX_CODELISTID = 4;
    private final static int INDEX_CODELISTNAME = 5;
    private final static int INDEX_CREATEDATE = 6;
    private final static int INDEX_CREATEMAN = 7;
    private final static int INDEX_DEID = 8;
    private final static int INDEX_DENAME = 9;
    private final static int INDEX_EMPTYTEXT = 10;
    private final static int INDEX_FILLER = 11;
    private final static int INDEX_ISSYSTEM = 12;
    private final static int INDEX_ISUSERSCOPE = 13;
    private final static int INDEX_MEMO = 14;
    private final static int INDEX_NOVALUEEMPTY = 15;
    private final static int INDEX_ORMODE = 16;
    private final static int INDEX_RESERVER = 17;
    private final static int INDEX_RESERVER2 = 18;
    private final static int INDEX_RESERVER3 = 19;
    private final static int INDEX_RESERVER4 = 20;
    private final static int INDEX_RESERVER5 = 21;
    private final static int INDEX_SEPERATOR = 22;
    private final static int INDEX_SRFSYSPUB = 23;
    private final static int INDEX_SRFUSERPUB = 24;
    private final static int INDEX_UPDATEDATE = 25;
    private final static int INDEX_UPDATEMAN = 26;
    private final static int INDEX_VALUESEPERATOR = 27;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CLMODEL, INDEX_CLMODEL);
        fieldIndexMap.put( FIELD_CLPARAM, INDEX_CLPARAM);
        fieldIndexMap.put( FIELD_CLPATH, INDEX_CLPATH);
        fieldIndexMap.put( FIELD_CLVERSION, INDEX_CLVERSION);
        fieldIndexMap.put( FIELD_CODELISTID, INDEX_CODELISTID);
        fieldIndexMap.put( FIELD_CODELISTNAME, INDEX_CODELISTNAME);
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_DEID, INDEX_DEID);
        fieldIndexMap.put( FIELD_DENAME, INDEX_DENAME);
        fieldIndexMap.put( FIELD_EMPTYTEXT, INDEX_EMPTYTEXT);
        fieldIndexMap.put( FIELD_FILLER, INDEX_FILLER);
        fieldIndexMap.put( FIELD_ISSYSTEM, INDEX_ISSYSTEM);
        fieldIndexMap.put( FIELD_ISUSERSCOPE, INDEX_ISUSERSCOPE);
        fieldIndexMap.put( FIELD_MEMO, INDEX_MEMO);
        fieldIndexMap.put( FIELD_NOVALUEEMPTY, INDEX_NOVALUEEMPTY);
        fieldIndexMap.put( FIELD_ORMODE, INDEX_ORMODE);
        fieldIndexMap.put( FIELD_RESERVER, INDEX_RESERVER);
        fieldIndexMap.put( FIELD_RESERVER2, INDEX_RESERVER2);
        fieldIndexMap.put( FIELD_RESERVER3, INDEX_RESERVER3);
        fieldIndexMap.put( FIELD_RESERVER4, INDEX_RESERVER4);
        fieldIndexMap.put( FIELD_RESERVER5, INDEX_RESERVER5);
        fieldIndexMap.put( FIELD_SEPERATOR, INDEX_SEPERATOR);
        fieldIndexMap.put( FIELD_SRFSYSPUB, INDEX_SRFSYSPUB);
        fieldIndexMap.put( FIELD_SRFUSERPUB, INDEX_SRFUSERPUB);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_VALUESEPERATOR, INDEX_VALUESEPERATOR);
    }

    private CodeListBase proxyCodeListBase = null;
    public CodeListBase() {
        super();
    }
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


    /**
     *  设置属性值[代码表模型]
     *  @param clmodel
     */
    public void setCLModel(String clmodel) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCLModel(clmodel);
            return;
        }
        if(clmodel!=null) {
            clmodel = StringHelper.trimRight(clmodel);
            if(clmodel.length()==0) {
                clmodel = null;
            }
        }
        this.clmodel = clmodel;
        this.clmodelDirtyFlag  = true;
    }

    /**
     *  获取属性值[代码表模型]
     */
    public String getCLModel() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCLModel();
        }
        return this.clmodel;
    }

    /**
     *  获取属性值[代码表模型]是否修改
     */
    public boolean isCLModelDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCLModelDirty();
        }
        return this.clmodelDirtyFlag;
    }

    /**
     *  重置属性值[代码表模型]
     */
    public void resetCLModel() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCLModel();
            return;
        }

        this.clmodelDirtyFlag = false;
        this.clmodel = null;
    }
    /**
     *  设置属性值[代码表参数]
     *  @param clparam
     */
    public void setCLParam(String clparam) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCLParam(clparam);
            return;
        }
        if(clparam!=null) {
            clparam = StringHelper.trimRight(clparam);
            if(clparam.length()==0) {
                clparam = null;
            }
        }
        this.clparam = clparam;
        this.clparamDirtyFlag  = true;
    }

    /**
     *  获取属性值[代码表参数]
     */
    public String getCLParam() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCLParam();
        }
        return this.clparam;
    }

    /**
     *  获取属性值[代码表参数]是否修改
     */
    public boolean isCLParamDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCLParamDirty();
        }
        return this.clparamDirtyFlag;
    }

    /**
     *  重置属性值[代码表参数]
     */
    public void resetCLParam() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCLParam();
            return;
        }

        this.clparamDirtyFlag = false;
        this.clparam = null;
    }
    /**
     *  设置属性值[配置路径]
     *  @param clpath
     */
    public void setCLPath(String clpath) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCLPath(clpath);
            return;
        }
        if(clpath!=null) {
            clpath = StringHelper.trimRight(clpath);
            if(clpath.length()==0) {
                clpath = null;
            }
        }
        this.clpath = clpath;
        this.clpathDirtyFlag  = true;
    }

    /**
     *  获取属性值[配置路径]
     */
    public String getCLPath() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCLPath();
        }
        return this.clpath;
    }

    /**
     *  获取属性值[配置路径]是否修改
     */
    public boolean isCLPathDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCLPathDirty();
        }
        return this.clpathDirtyFlag;
    }

    /**
     *  重置属性值[配置路径]
     */
    public void resetCLPath() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCLPath();
            return;
        }

        this.clpathDirtyFlag = false;
        this.clpath = null;
    }
    /**
     *  设置属性值[代码表版本]
     *  @param clversion
     */
    public void setCLVersion(Integer clversion) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCLVersion(clversion);
            return;
        }
        this.clversion = clversion;
        this.clversionDirtyFlag  = true;
    }

    /**
     *  获取属性值[代码表版本]
     */
    public Integer getCLVersion() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCLVersion();
        }
        return this.clversion;
    }

    /**
     *  获取属性值[代码表版本]是否修改
     */
    public boolean isCLVersionDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCLVersionDirty();
        }
        return this.clversionDirtyFlag;
    }

    /**
     *  重置属性值[代码表版本]
     */
    public void resetCLVersion() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCLVersion();
            return;
        }

        this.clversionDirtyFlag = false;
        this.clversion = null;
    }
    /**
     *  设置属性值[代码表标识]
     *  @param codelistid
     */
    public void setCodeListId(String codelistid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCodeListId(codelistid);
            return;
        }
        if(codelistid!=null) {
            codelistid = StringHelper.trimRight(codelistid);
            if(codelistid.length()==0) {
                codelistid = null;
            }
        }
        this.codelistid = codelistid;
        this.codelistidDirtyFlag  = true;
    }

    /**
     *  获取属性值[代码表标识]
     */
    public String getCodeListId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCodeListId();
        }
        return this.codelistid;
    }

    /**
     *  获取属性值[代码表标识]是否修改
     */
    public boolean isCodeListIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCodeListIdDirty();
        }
        return this.codelistidDirtyFlag;
    }

    /**
     *  重置属性值[代码表标识]
     */
    public void resetCodeListId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCodeListId();
            return;
        }

        this.codelistidDirtyFlag = false;
        this.codelistid = null;
    }
    /**
     *  设置属性值[代码表名称]
     *  @param codelistname
     */
    public void setCodeListName(String codelistname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCodeListName(codelistname);
            return;
        }
        if(codelistname!=null) {
            codelistname = StringHelper.trimRight(codelistname);
            if(codelistname.length()==0) {
                codelistname = null;
            }
        }
        this.codelistname = codelistname;
        this.codelistnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[代码表名称]
     */
    public String getCodeListName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCodeListName();
        }
        return this.codelistname;
    }

    /**
     *  获取属性值[代码表名称]是否修改
     */
    public boolean isCodeListNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCodeListNameDirty();
        }
        return this.codelistnameDirtyFlag;
    }

    /**
     *  重置属性值[代码表名称]
     */
    public void resetCodeListName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCodeListName();
            return;
        }

        this.codelistnameDirtyFlag = false;
        this.codelistname = null;
    }
    /**
     *  设置属性值[建立时间]
     *  @param createdate
     */
    public void setCreateDate(Timestamp createdate) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCreateDate(createdate);
            return;
        }
        this.createdate = createdate;
        this.createdateDirtyFlag  = true;
    }

    /**
     *  获取属性值[建立时间]
     */
    public Timestamp getCreateDate() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCreateDate();
        }
        return this.createdate;
    }

    /**
     *  获取属性值[建立时间]是否修改
     */
    public boolean isCreateDateDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCreateDateDirty();
        }
        return this.createdateDirtyFlag;
    }

    /**
     *  重置属性值[建立时间]
     */
    public void resetCreateDate() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCreateDate();
            return;
        }

        this.createdateDirtyFlag = false;
        this.createdate = null;
    }
    /**
     *  设置属性值[建立人]代码表：net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel
     *  @param createman
     */
    public void setCreateMan(String createman) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCreateMan(createman);
            return;
        }
        if(createman!=null) {
            createman = StringHelper.trimRight(createman);
            if(createman.length()==0) {
                createman = null;
            }
        }
        this.createman = createman;
        this.createmanDirtyFlag  = true;
    }

    /**
     *  获取属性值[建立人]代码表：net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel
     */
    public String getCreateMan() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCreateMan();
        }
        return this.createman;
    }

    /**
     *  获取属性值[建立人]是否修改
     */
    public boolean isCreateManDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCreateManDirty();
        }
        return this.createmanDirtyFlag;
    }

    /**
     *  重置属性值[建立人]
     */
    public void resetCreateMan() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCreateMan();
            return;
        }

        this.createmanDirtyFlag = false;
        this.createman = null;
    }
    /**
     *  设置属性值[数据实体]
     *  @param deid
     */
    public void setDEId(String deid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDEId(deid);
            return;
        }
        if(deid!=null) {
            deid = StringHelper.trimRight(deid);
            if(deid.length()==0) {
                deid = null;
            }
        }
        this.deid = deid;
        this.deidDirtyFlag  = true;
    }

    /**
     *  获取属性值[数据实体]
     */
    public String getDEId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDEId();
        }
        return this.deid;
    }

    /**
     *  获取属性值[数据实体]是否修改
     */
    public boolean isDEIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDEIdDirty();
        }
        return this.deidDirtyFlag;
    }

    /**
     *  重置属性值[数据实体]
     */
    public void resetDEId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDEId();
            return;
        }

        this.deidDirtyFlag = false;
        this.deid = null;
    }
    /**
     *  设置属性值[数据实体]
     *  @param dename
     */
    public void setDEName(String dename) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDEName(dename);
            return;
        }
        if(dename!=null) {
            dename = StringHelper.trimRight(dename);
            if(dename.length()==0) {
                dename = null;
            }
        }
        this.dename = dename;
        this.denameDirtyFlag  = true;
    }

    /**
     *  获取属性值[数据实体]
     */
    public String getDEName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDEName();
        }
        return this.dename;
    }

    /**
     *  获取属性值[数据实体]是否修改
     */
    public boolean isDENameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDENameDirty();
        }
        return this.denameDirtyFlag;
    }

    /**
     *  重置属性值[数据实体]
     */
    public void resetDEName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDEName();
            return;
        }

        this.denameDirtyFlag = false;
        this.dename = null;
    }
    /**
     *  设置属性值[空白显示内容]
     *  @param emptytext
     */
    public void setEmptyText(String emptytext) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setEmptyText(emptytext);
            return;
        }
        if(emptytext!=null) {
            emptytext = StringHelper.trimRight(emptytext);
            if(emptytext.length()==0) {
                emptytext = null;
            }
        }
        this.emptytext = emptytext;
        this.emptytextDirtyFlag  = true;
    }

    /**
     *  获取属性值[空白显示内容]
     */
    public String getEmptyText() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getEmptyText();
        }
        return this.emptytext;
    }

    /**
     *  获取属性值[空白显示内容]是否修改
     */
    public boolean isEmptyTextDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isEmptyTextDirty();
        }
        return this.emptytextDirtyFlag;
    }

    /**
     *  重置属性值[空白显示内容]
     */
    public void resetEmptyText() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetEmptyText();
            return;
        }

        this.emptytextDirtyFlag = false;
        this.emptytext = null;
    }
    /**
     *  设置属性值[数据库填充器]
     *  @param filler
     */
    public void setFiller(String filler) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setFiller(filler);
            return;
        }
        if(filler!=null) {
            filler = StringHelper.trimRight(filler);
            if(filler.length()==0) {
                filler = null;
            }
        }
        this.filler = filler;
        this.fillerDirtyFlag  = true;
    }

    /**
     *  获取属性值[数据库填充器]
     */
    public String getFiller() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getFiller();
        }
        return this.filler;
    }

    /**
     *  获取属性值[数据库填充器]是否修改
     */
    public boolean isFillerDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isFillerDirty();
        }
        return this.fillerDirtyFlag;
    }

    /**
     *  重置属性值[数据库填充器]
     */
    public void resetFiller() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetFiller();
            return;
        }

        this.fillerDirtyFlag = false;
        this.filler = null;
    }
    /**
     *  设置属性值[系统数据]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param issystem
     */
    public void setIsSystem(Integer issystem) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setIsSystem(issystem);
            return;
        }
        this.issystem = issystem;
        this.issystemDirtyFlag  = true;
    }

    /**
     *  获取属性值[系统数据]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getIsSystem() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getIsSystem();
        }
        return this.issystem;
    }

    /**
     *  获取属性值[系统数据]是否修改
     */
    public boolean isIsSystemDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isIsSystemDirty();
        }
        return this.issystemDirtyFlag;
    }

    /**
     *  重置属性值[系统数据]
     */
    public void resetIsSystem() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetIsSystem();
            return;
        }

        this.issystemDirtyFlag = false;
        this.issystem = null;
    }
    /**
     *  设置属性值[用户范围]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param isuserscope
     */
    public void setIsUserScope(Integer isuserscope) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setIsUserScope(isuserscope);
            return;
        }
        this.isuserscope = isuserscope;
        this.isuserscopeDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户范围]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getIsUserScope() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getIsUserScope();
        }
        return this.isuserscope;
    }

    /**
     *  获取属性值[用户范围]是否修改
     */
    public boolean isIsUserScopeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isIsUserScopeDirty();
        }
        return this.isuserscopeDirtyFlag;
    }

    /**
     *  重置属性值[用户范围]
     */
    public void resetIsUserScope() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetIsUserScope();
            return;
        }

        this.isuserscopeDirtyFlag = false;
        this.isuserscope = null;
    }
    /**
     *  设置属性值[备注]
     *  @param memo
     */
    public void setMemo(String memo) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMemo(memo);
            return;
        }
        if(memo!=null) {
            memo = StringHelper.trimRight(memo);
            if(memo.length()==0) {
                memo = null;
            }
        }
        this.memo = memo;
        this.memoDirtyFlag  = true;
    }

    /**
     *  获取属性值[备注]
     */
    public String getMemo() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMemo();
        }
        return this.memo;
    }

    /**
     *  获取属性值[备注]是否修改
     */
    public boolean isMemoDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMemoDirty();
        }
        return this.memoDirtyFlag;
    }

    /**
     *  重置属性值[备注]
     */
    public void resetMemo() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMemo();
            return;
        }

        this.memoDirtyFlag = false;
        this.memo = null;
    }
    /**
     *  设置属性值[无值显示空白]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param novalueempty
     */
    public void setNoValueEmpty(Integer novalueempty) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setNoValueEmpty(novalueempty);
            return;
        }
        this.novalueempty = novalueempty;
        this.novalueemptyDirtyFlag  = true;
    }

    /**
     *  获取属性值[无值显示空白]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getNoValueEmpty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getNoValueEmpty();
        }
        return this.novalueempty;
    }

    /**
     *  获取属性值[无值显示空白]是否修改
     */
    public boolean isNoValueEmptyDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isNoValueEmptyDirty();
        }
        return this.novalueemptyDirtyFlag;
    }

    /**
     *  重置属性值[无值显示空白]
     */
    public void resetNoValueEmpty() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetNoValueEmpty();
            return;
        }

        this.novalueemptyDirtyFlag = false;
        this.novalueempty = null;
    }
    /**
     *  设置属性值[或模式]代码表：net.ibizsys.psrt.srv.codelist.CodeList20CodeListModel
     *  @param ormode
     */
    public void setORMode(String ormode) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setORMode(ormode);
            return;
        }
        if(ormode!=null) {
            ormode = StringHelper.trimRight(ormode);
            if(ormode.length()==0) {
                ormode = null;
            }
        }
        this.ormode = ormode;
        this.ormodeDirtyFlag  = true;
    }

    /**
     *  获取属性值[或模式]代码表：net.ibizsys.psrt.srv.codelist.CodeList20CodeListModel
     */
    public String getORMode() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getORMode();
        }
        return this.ormode;
    }

    /**
     *  获取属性值[或模式]是否修改
     */
    public boolean isORModeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isORModeDirty();
        }
        return this.ormodeDirtyFlag;
    }

    /**
     *  重置属性值[或模式]
     */
    public void resetORMode() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetORMode();
            return;
        }

        this.ormodeDirtyFlag = false;
        this.ormode = null;
    }
    /**
     *  设置属性值[保留字段]
     *  @param reserver
     */
    public void setReserver(String reserver) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReserver(reserver);
            return;
        }
        if(reserver!=null) {
            reserver = StringHelper.trimRight(reserver);
            if(reserver.length()==0) {
                reserver = null;
            }
        }
        this.reserver = reserver;
        this.reserverDirtyFlag  = true;
    }

    /**
     *  获取属性值[保留字段]
     */
    public String getReserver() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReserver();
        }
        return this.reserver;
    }

    /**
     *  获取属性值[保留字段]是否修改
     */
    public boolean isReserverDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReserverDirty();
        }
        return this.reserverDirtyFlag;
    }

    /**
     *  重置属性值[保留字段]
     */
    public void resetReserver() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetReserver();
            return;
        }

        this.reserverDirtyFlag = false;
        this.reserver = null;
    }
    /**
     *  设置属性值[保留字段2]
     *  @param reserver2
     */
    public void setReserver2(String reserver2) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReserver2(reserver2);
            return;
        }
        if(reserver2!=null) {
            reserver2 = StringHelper.trimRight(reserver2);
            if(reserver2.length()==0) {
                reserver2 = null;
            }
        }
        this.reserver2 = reserver2;
        this.reserver2DirtyFlag  = true;
    }

    /**
     *  获取属性值[保留字段2]
     */
    public String getReserver2() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReserver2();
        }
        return this.reserver2;
    }

    /**
     *  获取属性值[保留字段2]是否修改
     */
    public boolean isReserver2Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReserver2Dirty();
        }
        return this.reserver2DirtyFlag;
    }

    /**
     *  重置属性值[保留字段2]
     */
    public void resetReserver2() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetReserver2();
            return;
        }

        this.reserver2DirtyFlag = false;
        this.reserver2 = null;
    }
    /**
     *  设置属性值[保留字段3]
     *  @param reserver3
     */
    public void setReserver3(String reserver3) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReserver3(reserver3);
            return;
        }
        if(reserver3!=null) {
            reserver3 = StringHelper.trimRight(reserver3);
            if(reserver3.length()==0) {
                reserver3 = null;
            }
        }
        this.reserver3 = reserver3;
        this.reserver3DirtyFlag  = true;
    }

    /**
     *  获取属性值[保留字段3]
     */
    public String getReserver3() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReserver3();
        }
        return this.reserver3;
    }

    /**
     *  获取属性值[保留字段3]是否修改
     */
    public boolean isReserver3Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReserver3Dirty();
        }
        return this.reserver3DirtyFlag;
    }

    /**
     *  重置属性值[保留字段3]
     */
    public void resetReserver3() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetReserver3();
            return;
        }

        this.reserver3DirtyFlag = false;
        this.reserver3 = null;
    }
    /**
     *  设置属性值[保留字段4]
     *  @param reserver4
     */
    public void setReserver4(String reserver4) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReserver4(reserver4);
            return;
        }
        if(reserver4!=null) {
            reserver4 = StringHelper.trimRight(reserver4);
            if(reserver4.length()==0) {
                reserver4 = null;
            }
        }
        this.reserver4 = reserver4;
        this.reserver4DirtyFlag  = true;
    }

    /**
     *  获取属性值[保留字段4]
     */
    public String getReserver4() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReserver4();
        }
        return this.reserver4;
    }

    /**
     *  获取属性值[保留字段4]是否修改
     */
    public boolean isReserver4Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReserver4Dirty();
        }
        return this.reserver4DirtyFlag;
    }

    /**
     *  重置属性值[保留字段4]
     */
    public void resetReserver4() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetReserver4();
            return;
        }

        this.reserver4DirtyFlag = false;
        this.reserver4 = null;
    }
    /**
     *  设置属性值[保留字段5]
     *  @param reserver5
     */
    public void setReserver5(Timestamp reserver5) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReserver5(reserver5);
            return;
        }
        this.reserver5 = reserver5;
        this.reserver5DirtyFlag  = true;
    }

    /**
     *  获取属性值[保留字段5]
     */
    public Timestamp getReserver5() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReserver5();
        }
        return this.reserver5;
    }

    /**
     *  获取属性值[保留字段5]是否修改
     */
    public boolean isReserver5Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReserver5Dirty();
        }
        return this.reserver5DirtyFlag;
    }

    /**
     *  重置属性值[保留字段5]
     */
    public void resetReserver5() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetReserver5();
            return;
        }

        this.reserver5DirtyFlag = false;
        this.reserver5 = null;
    }
    /**
     *  设置属性值[显示分割符号]
     *  @param seperator
     */
    public void setSeperator(String seperator) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setSeperator(seperator);
            return;
        }
        if(seperator!=null) {
            seperator = StringHelper.trimRight(seperator);
            if(seperator.length()==0) {
                seperator = null;
            }
        }
        this.seperator = seperator;
        this.seperatorDirtyFlag  = true;
    }

    /**
     *  获取属性值[显示分割符号]
     */
    public String getSeperator() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getSeperator();
        }
        return this.seperator;
    }

    /**
     *  获取属性值[显示分割符号]是否修改
     */
    public boolean isSeperatorDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isSeperatorDirty();
        }
        return this.seperatorDirtyFlag;
    }

    /**
     *  重置属性值[显示分割符号]
     */
    public void resetSeperator() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetSeperator();
            return;
        }

        this.seperatorDirtyFlag = false;
        this.seperator = null;
    }
    /**
     *  设置属性值[框架发布]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param srfsyspub
     */
    public void setSRFSysPub(Integer srfsyspub) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setSRFSysPub(srfsyspub);
            return;
        }
        this.srfsyspub = srfsyspub;
        this.srfsyspubDirtyFlag  = true;
    }

    /**
     *  获取属性值[框架发布]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getSRFSysPub() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getSRFSysPub();
        }
        return this.srfsyspub;
    }

    /**
     *  获取属性值[框架发布]是否修改
     */
    public boolean isSRFSysPubDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isSRFSysPubDirty();
        }
        return this.srfsyspubDirtyFlag;
    }

    /**
     *  重置属性值[框架发布]
     */
    public void resetSRFSysPub() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetSRFSysPub();
            return;
        }

        this.srfsyspubDirtyFlag = false;
        this.srfsyspub = null;
    }
    /**
     *  设置属性值[应用发布]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param srfuserpub
     */
    public void setSRFUserPub(Integer srfuserpub) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setSRFUserPub(srfuserpub);
            return;
        }
        this.srfuserpub = srfuserpub;
        this.srfuserpubDirtyFlag  = true;
    }

    /**
     *  获取属性值[应用发布]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getSRFUserPub() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getSRFUserPub();
        }
        return this.srfuserpub;
    }

    /**
     *  获取属性值[应用发布]是否修改
     */
    public boolean isSRFUserPubDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isSRFUserPubDirty();
        }
        return this.srfuserpubDirtyFlag;
    }

    /**
     *  重置属性值[应用发布]
     */
    public void resetSRFUserPub() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetSRFUserPub();
            return;
        }

        this.srfuserpubDirtyFlag = false;
        this.srfuserpub = null;
    }
    /**
     *  设置属性值[更新时间]
     *  @param updatedate
     */
    public void setUpdateDate(Timestamp updatedate) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUpdateDate(updatedate);
            return;
        }
        this.updatedate = updatedate;
        this.updatedateDirtyFlag  = true;
    }

    /**
     *  获取属性值[更新时间]
     */
    public Timestamp getUpdateDate() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUpdateDate();
        }
        return this.updatedate;
    }

    /**
     *  获取属性值[更新时间]是否修改
     */
    public boolean isUpdateDateDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUpdateDateDirty();
        }
        return this.updatedateDirtyFlag;
    }

    /**
     *  重置属性值[更新时间]
     */
    public void resetUpdateDate() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUpdateDate();
            return;
        }

        this.updatedateDirtyFlag = false;
        this.updatedate = null;
    }
    /**
     *  设置属性值[更新人]代码表：net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel
     *  @param updateman
     */
    public void setUpdateMan(String updateman) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUpdateMan(updateman);
            return;
        }
        if(updateman!=null) {
            updateman = StringHelper.trimRight(updateman);
            if(updateman.length()==0) {
                updateman = null;
            }
        }
        this.updateman = updateman;
        this.updatemanDirtyFlag  = true;
    }

    /**
     *  获取属性值[更新人]代码表：net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel
     */
    public String getUpdateMan() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUpdateMan();
        }
        return this.updateman;
    }

    /**
     *  获取属性值[更新人]是否修改
     */
    public boolean isUpdateManDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUpdateManDirty();
        }
        return this.updatemanDirtyFlag;
    }

    /**
     *  重置属性值[更新人]
     */
    public void resetUpdateMan() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUpdateMan();
            return;
        }

        this.updatemanDirtyFlag = false;
        this.updateman = null;
    }
    /**
     *  设置属性值[值分割符号]
     *  @param valueseperator
     */
    public void setValueSeperator(String valueseperator) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setValueSeperator(valueseperator);
            return;
        }
        if(valueseperator!=null) {
            valueseperator = StringHelper.trimRight(valueseperator);
            if(valueseperator.length()==0) {
                valueseperator = null;
            }
        }
        this.valueseperator = valueseperator;
        this.valueseperatorDirtyFlag  = true;
    }

    /**
     *  获取属性值[值分割符号]
     */
    public String getValueSeperator() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getValueSeperator();
        }
        return this.valueseperator;
    }

    /**
     *  获取属性值[值分割符号]是否修改
     */
    public boolean isValueSeperatorDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isValueSeperatorDirty();
        }
        return this.valueseperatorDirtyFlag;
    }

    /**
     *  重置属性值[值分割符号]
     */
    public void resetValueSeperator() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetValueSeperator();
            return;
        }

        this.valueseperatorDirtyFlag = false;
        this.valueseperator = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        CodeListBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
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

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isCLModelDirty()) {
            params.put(FIELD_CLMODEL,getCLModel());
        }
        if(!bDirtyOnly || isCLParamDirty()) {
            params.put(FIELD_CLPARAM,getCLParam());
        }
        if(!bDirtyOnly || isCLPathDirty()) {
            params.put(FIELD_CLPATH,getCLPath());
        }
        if(!bDirtyOnly || isCLVersionDirty()) {
            params.put(FIELD_CLVERSION,getCLVersion());
        }
        if(!bDirtyOnly || isCodeListIdDirty()) {
            params.put(FIELD_CODELISTID,getCodeListId());
        }
        if(!bDirtyOnly || isCodeListNameDirty()) {
            params.put(FIELD_CODELISTNAME,getCodeListName());
        }
        if(!bDirtyOnly || isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE,getCreateDate());
        }
        if(!bDirtyOnly || isCreateManDirty()) {
            params.put(FIELD_CREATEMAN,getCreateMan());
        }
        if(!bDirtyOnly || isDEIdDirty()) {
            params.put(FIELD_DEID,getDEId());
        }
        if(!bDirtyOnly || isDENameDirty()) {
            params.put(FIELD_DENAME,getDEName());
        }
        if(!bDirtyOnly || isEmptyTextDirty()) {
            params.put(FIELD_EMPTYTEXT,getEmptyText());
        }
        if(!bDirtyOnly || isFillerDirty()) {
            params.put(FIELD_FILLER,getFiller());
        }
        if(!bDirtyOnly || isIsSystemDirty()) {
            params.put(FIELD_ISSYSTEM,getIsSystem());
        }
        if(!bDirtyOnly || isIsUserScopeDirty()) {
            params.put(FIELD_ISUSERSCOPE,getIsUserScope());
        }
        if(!bDirtyOnly || isMemoDirty()) {
            params.put(FIELD_MEMO,getMemo());
        }
        if(!bDirtyOnly || isNoValueEmptyDirty()) {
            params.put(FIELD_NOVALUEEMPTY,getNoValueEmpty());
        }
        if(!bDirtyOnly || isORModeDirty()) {
            params.put(FIELD_ORMODE,getORMode());
        }
        if(!bDirtyOnly || isReserverDirty()) {
            params.put(FIELD_RESERVER,getReserver());
        }
        if(!bDirtyOnly || isReserver2Dirty()) {
            params.put(FIELD_RESERVER2,getReserver2());
        }
        if(!bDirtyOnly || isReserver3Dirty()) {
            params.put(FIELD_RESERVER3,getReserver3());
        }
        if(!bDirtyOnly || isReserver4Dirty()) {
            params.put(FIELD_RESERVER4,getReserver4());
        }
        if(!bDirtyOnly || isReserver5Dirty()) {
            params.put(FIELD_RESERVER5,getReserver5());
        }
        if(!bDirtyOnly || isSeperatorDirty()) {
            params.put(FIELD_SEPERATOR,getSeperator());
        }
        if(!bDirtyOnly || isSRFSysPubDirty()) {
            params.put(FIELD_SRFSYSPUB,getSRFSysPub());
        }
        if(!bDirtyOnly || isSRFUserPubDirty()) {
            params.put(FIELD_SRFUSERPUB,getSRFUserPub());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
        }
        if(!bDirtyOnly || isValueSeperatorDirty()) {
            params.put(FIELD_VALUESEPERATOR,getValueSeperator());
        }
        super.onFillMap(params, bDirtyOnly);
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#get(java.lang.String)
     */
    @Override
    public Object get(String strParamName) throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().get(strParamName);
        }

        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");
        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null)
            return super.get(strParamName);

        return  CodeListBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(CodeListBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CLMODEL:
            return et.getCLModel();
        case INDEX_CLPARAM:
            return et.getCLParam();
        case INDEX_CLPATH:
            return et.getCLPath();
        case INDEX_CLVERSION:
            return et.getCLVersion();
        case INDEX_CODELISTID:
            return et.getCodeListId();
        case INDEX_CODELISTNAME:
            return et.getCodeListName();
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_DEID:
            return et.getDEId();
        case INDEX_DENAME:
            return et.getDEName();
        case INDEX_EMPTYTEXT:
            return et.getEmptyText();
        case INDEX_FILLER:
            return et.getFiller();
        case INDEX_ISSYSTEM:
            return et.getIsSystem();
        case INDEX_ISUSERSCOPE:
            return et.getIsUserScope();
        case INDEX_MEMO:
            return et.getMemo();
        case INDEX_NOVALUEEMPTY:
            return et.getNoValueEmpty();
        case INDEX_ORMODE:
            return et.getORMode();
        case INDEX_RESERVER:
            return et.getReserver();
        case INDEX_RESERVER2:
            return et.getReserver2();
        case INDEX_RESERVER3:
            return et.getReserver3();
        case INDEX_RESERVER4:
            return et.getReserver4();
        case INDEX_RESERVER5:
            return et.getReserver5();
        case INDEX_SEPERATOR:
            return et.getSeperator();
        case INDEX_SRFSYSPUB:
            return et.getSRFSysPub();
        case INDEX_SRFUSERPUB:
            return et.getSRFUserPub();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_VALUESEPERATOR:
            return et.getValueSeperator();
        default:
            throw new Exception("不明属性标识");
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#set(java.lang.String, java.lang.Object)
     */
    @Override
    public void set(String strParamName,Object objValue) throws Exception {
        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().set(strParamName,objValue);
            return;
        }
        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");

        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null) {
            super.set(strParamName,objValue);
            return;
        }

        CodeListBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(CodeListBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CLMODEL:
            et.setCLModel(DataObject.getStringValue(obj));
            return ;
        case INDEX_CLPARAM:
            et.setCLParam(DataObject.getStringValue(obj));
            return ;
        case INDEX_CLPATH:
            et.setCLPath(DataObject.getStringValue(obj));
            return ;
        case INDEX_CLVERSION:
            et.setCLVersion(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_CODELISTID:
            et.setCodeListId(DataObject.getStringValue(obj));
            return ;
        case INDEX_CODELISTNAME:
            et.setCodeListName(DataObject.getStringValue(obj));
            return ;
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_DEID:
            et.setDEId(DataObject.getStringValue(obj));
            return ;
        case INDEX_DENAME:
            et.setDEName(DataObject.getStringValue(obj));
            return ;
        case INDEX_EMPTYTEXT:
            et.setEmptyText(DataObject.getStringValue(obj));
            return ;
        case INDEX_FILLER:
            et.setFiller(DataObject.getStringValue(obj));
            return ;
        case INDEX_ISSYSTEM:
            et.setIsSystem(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_ISUSERSCOPE:
            et.setIsUserScope(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_MEMO:
            et.setMemo(DataObject.getStringValue(obj));
            return ;
        case INDEX_NOVALUEEMPTY:
            et.setNoValueEmpty(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_ORMODE:
            et.setORMode(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESERVER:
            et.setReserver(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESERVER2:
            et.setReserver2(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESERVER3:
            et.setReserver3(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESERVER4:
            et.setReserver4(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESERVER5:
            et.setReserver5(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_SEPERATOR:
            et.setSeperator(DataObject.getStringValue(obj));
            return ;
        case INDEX_SRFSYSPUB:
            et.setSRFSysPub(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_SRFUSERPUB:
            et.setSRFUserPub(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_VALUESEPERATOR:
            et.setValueSeperator(DataObject.getStringValue(obj));
            return ;
        default:
            throw new Exception("不明属性标识");
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#isNull(java.lang.String)
     */
    @Override
    public boolean isNull(String strParamName) throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isNull(strParamName);
        }
        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");

        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null)
            return super.isNull(strParamName);

        return  CodeListBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(CodeListBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CLMODEL:
            return et.getCLModel()==null;
        case INDEX_CLPARAM:
            return et.getCLParam()==null;
        case INDEX_CLPATH:
            return et.getCLPath()==null;
        case INDEX_CLVERSION:
            return et.getCLVersion()==null;
        case INDEX_CODELISTID:
            return et.getCodeListId()==null;
        case INDEX_CODELISTNAME:
            return et.getCodeListName()==null;
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_DEID:
            return et.getDEId()==null;
        case INDEX_DENAME:
            return et.getDEName()==null;
        case INDEX_EMPTYTEXT:
            return et.getEmptyText()==null;
        case INDEX_FILLER:
            return et.getFiller()==null;
        case INDEX_ISSYSTEM:
            return et.getIsSystem()==null;
        case INDEX_ISUSERSCOPE:
            return et.getIsUserScope()==null;
        case INDEX_MEMO:
            return et.getMemo()==null;
        case INDEX_NOVALUEEMPTY:
            return et.getNoValueEmpty()==null;
        case INDEX_ORMODE:
            return et.getORMode()==null;
        case INDEX_RESERVER:
            return et.getReserver()==null;
        case INDEX_RESERVER2:
            return et.getReserver2()==null;
        case INDEX_RESERVER3:
            return et.getReserver3()==null;
        case INDEX_RESERVER4:
            return et.getReserver4()==null;
        case INDEX_RESERVER5:
            return et.getReserver5()==null;
        case INDEX_SEPERATOR:
            return et.getSeperator()==null;
        case INDEX_SRFSYSPUB:
            return et.getSRFSysPub()==null;
        case INDEX_SRFUSERPUB:
            return et.getSRFUserPub()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_VALUESEPERATOR:
            return et.getValueSeperator()==null;
        default:
            throw new Exception("不明属性标识");
        }
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#contains(java.lang.String)
     */
    @Override
    public boolean contains(String strParamName) throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().contains(strParamName);
        }
        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");
        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null)
            return super.contains(strParamName);
        return  CodeListBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(CodeListBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CLMODEL:
            return et.isCLModelDirty();
        case INDEX_CLPARAM:
            return et.isCLParamDirty();
        case INDEX_CLPATH:
            return et.isCLPathDirty();
        case INDEX_CLVERSION:
            return et.isCLVersionDirty();
        case INDEX_CODELISTID:
            return et.isCodeListIdDirty();
        case INDEX_CODELISTNAME:
            return et.isCodeListNameDirty();
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_DEID:
            return et.isDEIdDirty();
        case INDEX_DENAME:
            return et.isDENameDirty();
        case INDEX_EMPTYTEXT:
            return et.isEmptyTextDirty();
        case INDEX_FILLER:
            return et.isFillerDirty();
        case INDEX_ISSYSTEM:
            return et.isIsSystemDirty();
        case INDEX_ISUSERSCOPE:
            return et.isIsUserScopeDirty();
        case INDEX_MEMO:
            return et.isMemoDirty();
        case INDEX_NOVALUEEMPTY:
            return et.isNoValueEmptyDirty();
        case INDEX_ORMODE:
            return et.isORModeDirty();
        case INDEX_RESERVER:
            return et.isReserverDirty();
        case INDEX_RESERVER2:
            return et.isReserver2Dirty();
        case INDEX_RESERVER3:
            return et.isReserver3Dirty();
        case INDEX_RESERVER4:
            return et.isReserver4Dirty();
        case INDEX_RESERVER5:
            return et.isReserver5Dirty();
        case INDEX_SEPERATOR:
            return et.isSeperatorDirty();
        case INDEX_SRFSYSPUB:
            return et.isSRFSysPubDirty();
        case INDEX_SRFUSERPUB:
            return et.isSRFUserPubDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_VALUESEPERATOR:
            return et.isValueSeperatorDirty();
        default:
            throw new Exception("不明属性标识");
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onFillJSONObject(net.sf.json.JSONObject, boolean)
     */
    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        fillJSONObject(this,objJSON,bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    /**
     * 填充当前对象到JSON
     * @param et 当前数据对象
     * @param json JSON对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static  void fillJSONObject(CodeListBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCLModel()!=null) {
            JSONObjectHelper.put(json,"clmodel",getJSONValue(et.getCLModel()),false);
        }
        if(bIncEmpty||et.getCLParam()!=null) {
            JSONObjectHelper.put(json,"clparam",getJSONValue(et.getCLParam()),false);
        }
        if(bIncEmpty||et.getCLPath()!=null) {
            JSONObjectHelper.put(json,"clpath",getJSONValue(et.getCLPath()),false);
        }
        if(bIncEmpty||et.getCLVersion()!=null) {
            JSONObjectHelper.put(json,"clversion",getJSONValue(et.getCLVersion()),false);
        }
        if(bIncEmpty||et.getCodeListId()!=null) {
            JSONObjectHelper.put(json,"codelistid",getJSONValue(et.getCodeListId()),false);
        }
        if(bIncEmpty||et.getCodeListName()!=null) {
            JSONObjectHelper.put(json,"codelistname",getJSONValue(et.getCodeListName()),false);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getDEId()!=null) {
            JSONObjectHelper.put(json,"deid",getJSONValue(et.getDEId()),false);
        }
        if(bIncEmpty||et.getDEName()!=null) {
            JSONObjectHelper.put(json,"dename",getJSONValue(et.getDEName()),false);
        }
        if(bIncEmpty||et.getEmptyText()!=null) {
            JSONObjectHelper.put(json,"emptytext",getJSONValue(et.getEmptyText()),false);
        }
        if(bIncEmpty||et.getFiller()!=null) {
            JSONObjectHelper.put(json,"filler",getJSONValue(et.getFiller()),false);
        }
        if(bIncEmpty||et.getIsSystem()!=null) {
            JSONObjectHelper.put(json,"issystem",getJSONValue(et.getIsSystem()),false);
        }
        if(bIncEmpty||et.getIsUserScope()!=null) {
            JSONObjectHelper.put(json,"isuserscope",getJSONValue(et.getIsUserScope()),false);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            JSONObjectHelper.put(json,"memo",getJSONValue(et.getMemo()),false);
        }
        if(bIncEmpty||et.getNoValueEmpty()!=null) {
            JSONObjectHelper.put(json,"novalueempty",getJSONValue(et.getNoValueEmpty()),false);
        }
        if(bIncEmpty||et.getORMode()!=null) {
            JSONObjectHelper.put(json,"ormode",getJSONValue(et.getORMode()),false);
        }
        if(bIncEmpty||et.getReserver()!=null) {
            JSONObjectHelper.put(json,"reserver",getJSONValue(et.getReserver()),false);
        }
        if(bIncEmpty||et.getReserver2()!=null) {
            JSONObjectHelper.put(json,"reserver2",getJSONValue(et.getReserver2()),false);
        }
        if(bIncEmpty||et.getReserver3()!=null) {
            JSONObjectHelper.put(json,"reserver3",getJSONValue(et.getReserver3()),false);
        }
        if(bIncEmpty||et.getReserver4()!=null) {
            JSONObjectHelper.put(json,"reserver4",getJSONValue(et.getReserver4()),false);
        }
        if(bIncEmpty||et.getReserver5()!=null) {
            JSONObjectHelper.put(json,"reserver5",getJSONValue(et.getReserver5()),false);
        }
        if(bIncEmpty||et.getSeperator()!=null) {
            JSONObjectHelper.put(json,"seperator",getJSONValue(et.getSeperator()),false);
        }
        if(bIncEmpty||et.getSRFSysPub()!=null) {
            JSONObjectHelper.put(json,"srfsyspub",getJSONValue(et.getSRFSysPub()),false);
        }
        if(bIncEmpty||et.getSRFUserPub()!=null) {
            JSONObjectHelper.put(json,"srfuserpub",getJSONValue(et.getSRFUserPub()),false);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
        }
        if(bIncEmpty||et.getValueSeperator()!=null) {
            JSONObjectHelper.put(json,"valueseperator",getJSONValue(et.getValueSeperator()),false);
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onFillXmlNode(net.ibizsys.paas.xml.XmlNode, boolean)
     */
    @Override
    protected void onFillXmlNode(XmlNode xmlNode,boolean bIncludeEmpty) throws Exception {
        fillXmlNode(this,xmlNode,bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    /**
     * 填充当前对象到Xml节点中
     * @param et 当前数据对象
     * @param node Xml节点
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void fillXmlNode(CodeListBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCLModel()!=null) {
            Object obj = et.getCLModel();
            node.setAttribute("CLMODEL",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getCLParam()!=null) {
            Object obj = et.getCLParam();
            node.setAttribute("CLPARAM",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getCLPath()!=null) {
            Object obj = et.getCLPath();
            node.setAttribute("CLPATH",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getCLVersion()!=null) {
            Object obj = et.getCLVersion();
            node.setAttribute("CLVERSION",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getCodeListId()!=null) {
            Object obj = et.getCodeListId();
            node.setAttribute("CODELISTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getCodeListName()!=null) {
            Object obj = et.getCodeListName();
            node.setAttribute("CODELISTNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDEId()!=null) {
            Object obj = et.getDEId();
            node.setAttribute("DEID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDEName()!=null) {
            Object obj = et.getDEName();
            node.setAttribute("DENAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getEmptyText()!=null) {
            Object obj = et.getEmptyText();
            node.setAttribute("EMPTYTEXT",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getFiller()!=null) {
            Object obj = et.getFiller();
            node.setAttribute("FILLER",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getIsSystem()!=null) {
            Object obj = et.getIsSystem();
            node.setAttribute("ISSYSTEM",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getIsUserScope()!=null) {
            Object obj = et.getIsUserScope();
            node.setAttribute("ISUSERSCOPE",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getMemo()!=null) {
            Object obj = et.getMemo();
            node.setAttribute("MEMO",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getNoValueEmpty()!=null) {
            Object obj = et.getNoValueEmpty();
            node.setAttribute("NOVALUEEMPTY",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getORMode()!=null) {
            Object obj = et.getORMode();
            node.setAttribute("ORMODE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getReserver()!=null) {
            Object obj = et.getReserver();
            node.setAttribute("RESERVER",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getReserver2()!=null) {
            Object obj = et.getReserver2();
            node.setAttribute("RESERVER2",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getReserver3()!=null) {
            Object obj = et.getReserver3();
            node.setAttribute("RESERVER3",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getReserver4()!=null) {
            Object obj = et.getReserver4();
            node.setAttribute("RESERVER4",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getReserver5()!=null) {
            Object obj = et.getReserver5();
            node.setAttribute("RESERVER5",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getSeperator()!=null) {
            Object obj = et.getSeperator();
            node.setAttribute("SEPERATOR",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getSRFSysPub()!=null) {
            Object obj = et.getSRFSysPub();
            node.setAttribute("SRFSYSPUB",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getSRFUserPub()!=null) {
            Object obj = et.getSRFUserPub();
            node.setAttribute("SRFUSERPUB",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getValueSeperator()!=null) {
            Object obj = et.getValueSeperator();
            node.setAttribute("VALUESEPERATOR",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        CodeListBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(CodeListBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCLModelDirty() && (bIncEmpty||et.getCLModel()!=null)) {
            dst.set(FIELD_CLMODEL,et.getCLModel());
        }
        if(et.isCLParamDirty() && (bIncEmpty||et.getCLParam()!=null)) {
            dst.set(FIELD_CLPARAM,et.getCLParam());
        }
        if(et.isCLPathDirty() && (bIncEmpty||et.getCLPath()!=null)) {
            dst.set(FIELD_CLPATH,et.getCLPath());
        }
        if(et.isCLVersionDirty() && (bIncEmpty||et.getCLVersion()!=null)) {
            dst.set(FIELD_CLVERSION,et.getCLVersion());
        }
        if(et.isCodeListIdDirty() && (bIncEmpty||et.getCodeListId()!=null)) {
            dst.set(FIELD_CODELISTID,et.getCodeListId());
        }
        if(et.isCodeListNameDirty() && (bIncEmpty||et.getCodeListName()!=null)) {
            dst.set(FIELD_CODELISTNAME,et.getCodeListName());
        }
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isDEIdDirty() && (bIncEmpty||et.getDEId()!=null)) {
            dst.set(FIELD_DEID,et.getDEId());
        }
        if(et.isDENameDirty() && (bIncEmpty||et.getDEName()!=null)) {
            dst.set(FIELD_DENAME,et.getDEName());
        }
        if(et.isEmptyTextDirty() && (bIncEmpty||et.getEmptyText()!=null)) {
            dst.set(FIELD_EMPTYTEXT,et.getEmptyText());
        }
        if(et.isFillerDirty() && (bIncEmpty||et.getFiller()!=null)) {
            dst.set(FIELD_FILLER,et.getFiller());
        }
        if(et.isIsSystemDirty() && (bIncEmpty||et.getIsSystem()!=null)) {
            dst.set(FIELD_ISSYSTEM,et.getIsSystem());
        }
        if(et.isIsUserScopeDirty() && (bIncEmpty||et.getIsUserScope()!=null)) {
            dst.set(FIELD_ISUSERSCOPE,et.getIsUserScope());
        }
        if(et.isMemoDirty() && (bIncEmpty||et.getMemo()!=null)) {
            dst.set(FIELD_MEMO,et.getMemo());
        }
        if(et.isNoValueEmptyDirty() && (bIncEmpty||et.getNoValueEmpty()!=null)) {
            dst.set(FIELD_NOVALUEEMPTY,et.getNoValueEmpty());
        }
        if(et.isORModeDirty() && (bIncEmpty||et.getORMode()!=null)) {
            dst.set(FIELD_ORMODE,et.getORMode());
        }
        if(et.isReserverDirty() && (bIncEmpty||et.getReserver()!=null)) {
            dst.set(FIELD_RESERVER,et.getReserver());
        }
        if(et.isReserver2Dirty() && (bIncEmpty||et.getReserver2()!=null)) {
            dst.set(FIELD_RESERVER2,et.getReserver2());
        }
        if(et.isReserver3Dirty() && (bIncEmpty||et.getReserver3()!=null)) {
            dst.set(FIELD_RESERVER3,et.getReserver3());
        }
        if(et.isReserver4Dirty() && (bIncEmpty||et.getReserver4()!=null)) {
            dst.set(FIELD_RESERVER4,et.getReserver4());
        }
        if(et.isReserver5Dirty() && (bIncEmpty||et.getReserver5()!=null)) {
            dst.set(FIELD_RESERVER5,et.getReserver5());
        }
        if(et.isSeperatorDirty() && (bIncEmpty||et.getSeperator()!=null)) {
            dst.set(FIELD_SEPERATOR,et.getSeperator());
        }
        if(et.isSRFSysPubDirty() && (bIncEmpty||et.getSRFSysPub()!=null)) {
            dst.set(FIELD_SRFSYSPUB,et.getSRFSysPub());
        }
        if(et.isSRFUserPubDirty() && (bIncEmpty||et.getSRFUserPub()!=null)) {
            dst.set(FIELD_SRFUSERPUB,et.getSRFUserPub());
        }
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
        }
        if(et.isValueSeperatorDirty() && (bIncEmpty||et.getValueSeperator()!=null)) {
            dst.set(FIELD_VALUESEPERATOR,et.getValueSeperator());
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#remove(java.lang.String)
     */
    @Override
    public boolean remove(String strParamName) throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().remove(strParamName);
        }
        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");
        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null)
            return super.remove(strParamName);
        return  CodeListBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(CodeListBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CLMODEL:
            et.resetCLModel();
            return true;
        case INDEX_CLPARAM:
            et.resetCLParam();
            return true;
        case INDEX_CLPATH:
            et.resetCLPath();
            return true;
        case INDEX_CLVERSION:
            et.resetCLVersion();
            return true;
        case INDEX_CODELISTID:
            et.resetCodeListId();
            return true;
        case INDEX_CODELISTNAME:
            et.resetCodeListName();
            return true;
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_DEID:
            et.resetDEId();
            return true;
        case INDEX_DENAME:
            et.resetDEName();
            return true;
        case INDEX_EMPTYTEXT:
            et.resetEmptyText();
            return true;
        case INDEX_FILLER:
            et.resetFiller();
            return true;
        case INDEX_ISSYSTEM:
            et.resetIsSystem();
            return true;
        case INDEX_ISUSERSCOPE:
            et.resetIsUserScope();
            return true;
        case INDEX_MEMO:
            et.resetMemo();
            return true;
        case INDEX_NOVALUEEMPTY:
            et.resetNoValueEmpty();
            return true;
        case INDEX_ORMODE:
            et.resetORMode();
            return true;
        case INDEX_RESERVER:
            et.resetReserver();
            return true;
        case INDEX_RESERVER2:
            et.resetReserver2();
            return true;
        case INDEX_RESERVER3:
            et.resetReserver3();
            return true;
        case INDEX_RESERVER4:
            et.resetReserver4();
            return true;
        case INDEX_RESERVER5:
            et.resetReserver5();
            return true;
        case INDEX_SEPERATOR:
            et.resetSeperator();
            return true;
        case INDEX_SRFSYSPUB:
            et.resetSRFSysPub();
            return true;
        case INDEX_SRFUSERPUB:
            et.resetSRFUserPub();
            return true;
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        case INDEX_VALUESEPERATOR:
            et.resetValueSeperator();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }


    private Integer objDELock = new Integer(1);
    private net.ibizsys.psrt.srv.demodel.entity.DataEntity de = null;
    /**
    * 获取父数据 实体
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.demodel.entity.DataEntity getDE() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDE();
        }

        if(this.getDEId()==null)
            return null;
        synchronized(this.objDELock) {
            if(this.de!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getDEId(),de.getDEId())!=0) {
                    this.de = null;
                }
            }


            if(this.de==null) {
                net.ibizsys.psrt.srv.demodel.entity.DataEntity de = new net.ibizsys.psrt.srv.demodel.entity.DataEntity();
                de.setDEId(this.getDEId());
                net.ibizsys.psrt.srv.demodel.service.DataEntityService service = (net.ibizsys.psrt.srv.demodel.service.DataEntityService)ServiceGlobal.getService(net.ibizsys.psrt.srv.demodel.service.DataEntityService.class,this.getSessionFactory());
                service.autoGet(de);
                this.de = de;
            }
            return this.de;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private CodeListBase getProxyEntity() {
        return this.proxyCodeListBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyCodeListBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof CodeListBase) {
            this.proxyCodeListBase = (CodeListBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }


    /**
    * 重写获取行为操作辅助对象
    */
    protected net.ibizsys.paas.entity.IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        net.ibizsys.paas.entity.IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if(!bMust || iEntityActionHelper!=null)
            return iEntityActionHelper;
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.CodeListService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}