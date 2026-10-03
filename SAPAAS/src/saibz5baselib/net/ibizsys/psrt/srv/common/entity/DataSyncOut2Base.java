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
 * 实体[DataSyncOut2] 数据对象基类
 */
public abstract class DataSyncOut2Base extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(DataSyncOut2Base.class);
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[数据]
     */
    public final static String FIELD_DATA = "DATA";
    /**
     * 属性[数据主键]
     */
    public final static String FIELD_DATAKEY = "DATAKEY";
    /**
     * 属性[数据同步发送队列2标识]
     */
    public final static String FIELD_DATASYNCOUT2ID = "DATASYNCOUT2ID";
    /**
     * 属性[发送队列2名称]
     */
    public final static String FIELD_DATASYNCOUT2NAME = "DATASYNCOUT2NAME";
    /**
     * 属性[数据实体]
     */
    public final static String FIELD_DEID = "DEID";
    /**
     * 属性[数据实体]
     */
    public final static String FIELD_DENAME = "DENAME";
    /**
     * 属性[同步错误信息]
     */
    public final static String FIELD_ERROR = "ERROR";
    /**
     * 属性[事件类型]
     */
    public final static String FIELD_EVENTTYPE = "EVENTTYPE";
    /**
     * 属性[同步文件清单]
     */
    public final static String FIELD_FILELIST = "FILELIST";
    /**
     * 属性[逻辑数据]
     */
    public final static String FIELD_LOGICDATA = "LOGICDATA";
    /**
     * 属性[数据输出代理]
     */
    public final static String FIELD_SYNCAGENT = "SYNCAGENT";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";

    private final static int INDEX_CREATEDATE = 0;
    private final static int INDEX_CREATEMAN = 1;
    private final static int INDEX_DATA = 2;
    private final static int INDEX_DATAKEY = 3;
    private final static int INDEX_DATASYNCOUT2ID = 4;
    private final static int INDEX_DATASYNCOUT2NAME = 5;
    private final static int INDEX_DEID = 6;
    private final static int INDEX_DENAME = 7;
    private final static int INDEX_ERROR = 8;
    private final static int INDEX_EVENTTYPE = 9;
    private final static int INDEX_FILELIST = 10;
    private final static int INDEX_LOGICDATA = 11;
    private final static int INDEX_SYNCAGENT = 12;
    private final static int INDEX_UPDATEDATE = 13;
    private final static int INDEX_UPDATEMAN = 14;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_DATA, INDEX_DATA);
        fieldIndexMap.put( FIELD_DATAKEY, INDEX_DATAKEY);
        fieldIndexMap.put( FIELD_DATASYNCOUT2ID, INDEX_DATASYNCOUT2ID);
        fieldIndexMap.put( FIELD_DATASYNCOUT2NAME, INDEX_DATASYNCOUT2NAME);
        fieldIndexMap.put( FIELD_DEID, INDEX_DEID);
        fieldIndexMap.put( FIELD_DENAME, INDEX_DENAME);
        fieldIndexMap.put( FIELD_ERROR, INDEX_ERROR);
        fieldIndexMap.put( FIELD_EVENTTYPE, INDEX_EVENTTYPE);
        fieldIndexMap.put( FIELD_FILELIST, INDEX_FILELIST);
        fieldIndexMap.put( FIELD_LOGICDATA, INDEX_LOGICDATA);
        fieldIndexMap.put( FIELD_SYNCAGENT, INDEX_SYNCAGENT);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
    }

    private DataSyncOut2Base proxyDataSyncOut2Base = null;
    public DataSyncOut2Base() {
        super();
    }
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dataDirtyFlag = false;
    private boolean datakeyDirtyFlag = false;
    private boolean datasyncout2idDirtyFlag = false;
    private boolean datasyncout2nameDirtyFlag = false;
    private boolean deidDirtyFlag = false;
    private boolean denameDirtyFlag = false;
    private boolean errorDirtyFlag = false;
    private boolean eventtypeDirtyFlag = false;
    private boolean filelistDirtyFlag = false;
    private boolean logicdataDirtyFlag = false;
    private boolean syncagentDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;

    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="data")
    private String data;
    @Column(name="datakey")
    private String datakey;
    @Column(name="datasyncout2id")
    private String datasyncout2id;
    @Column(name="datasyncout2name")
    private String datasyncout2name;
    @Column(name="deid")
    private String deid;
    @Column(name="dename")
    private String dename;
    @Column(name="error")
    private String error;
    @Column(name="eventtype")
    private Integer eventtype;
    @Column(name="filelist")
    private String filelist;
    @Column(name="logicdata")
    private String logicdata;
    @Column(name="syncagent")
    private String syncagent;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;


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
     *  设置属性值[数据]
     *  @param data
     */
    public void setData(String data) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setData(data);
            return;
        }
        if(data!=null) {
            data = StringHelper.trimRight(data);
            if(data.length()==0) {
                data = null;
            }
        }
        this.data = data;
        this.dataDirtyFlag  = true;
    }

    /**
     *  获取属性值[数据]
     */
    public String getData() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getData();
        }
        return this.data;
    }

    /**
     *  获取属性值[数据]是否修改
     */
    public boolean isDataDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDataDirty();
        }
        return this.dataDirtyFlag;
    }

    /**
     *  重置属性值[数据]
     */
    public void resetData() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetData();
            return;
        }

        this.dataDirtyFlag = false;
        this.data = null;
    }
    /**
     *  设置属性值[数据主键]
     *  @param datakey
     */
    public void setDataKey(String datakey) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDataKey(datakey);
            return;
        }
        if(datakey!=null) {
            datakey = StringHelper.trimRight(datakey);
            if(datakey.length()==0) {
                datakey = null;
            }
        }
        this.datakey = datakey;
        this.datakeyDirtyFlag  = true;
    }

    /**
     *  获取属性值[数据主键]
     */
    public String getDataKey() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDataKey();
        }
        return this.datakey;
    }

    /**
     *  获取属性值[数据主键]是否修改
     */
    public boolean isDataKeyDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDataKeyDirty();
        }
        return this.datakeyDirtyFlag;
    }

    /**
     *  重置属性值[数据主键]
     */
    public void resetDataKey() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDataKey();
            return;
        }

        this.datakeyDirtyFlag = false;
        this.datakey = null;
    }
    /**
     *  设置属性值[数据同步发送队列2标识]
     *  @param datasyncout2id
     */
    public void setDataSyncOut2Id(String datasyncout2id) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDataSyncOut2Id(datasyncout2id);
            return;
        }
        if(datasyncout2id!=null) {
            datasyncout2id = StringHelper.trimRight(datasyncout2id);
            if(datasyncout2id.length()==0) {
                datasyncout2id = null;
            }
        }
        this.datasyncout2id = datasyncout2id;
        this.datasyncout2idDirtyFlag  = true;
    }

    /**
     *  获取属性值[数据同步发送队列2标识]
     */
    public String getDataSyncOut2Id() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDataSyncOut2Id();
        }
        return this.datasyncout2id;
    }

    /**
     *  获取属性值[数据同步发送队列2标识]是否修改
     */
    public boolean isDataSyncOut2IdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDataSyncOut2IdDirty();
        }
        return this.datasyncout2idDirtyFlag;
    }

    /**
     *  重置属性值[数据同步发送队列2标识]
     */
    public void resetDataSyncOut2Id() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDataSyncOut2Id();
            return;
        }

        this.datasyncout2idDirtyFlag = false;
        this.datasyncout2id = null;
    }
    /**
     *  设置属性值[发送队列2名称]
     *  @param datasyncout2name
     */
    public void setDataSyncOut2Name(String datasyncout2name) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDataSyncOut2Name(datasyncout2name);
            return;
        }
        if(datasyncout2name!=null) {
            datasyncout2name = StringHelper.trimRight(datasyncout2name);
            if(datasyncout2name.length()==0) {
                datasyncout2name = null;
            }
        }
        this.datasyncout2name = datasyncout2name;
        this.datasyncout2nameDirtyFlag  = true;
    }

    /**
     *  获取属性值[发送队列2名称]
     */
    public String getDataSyncOut2Name() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDataSyncOut2Name();
        }
        return this.datasyncout2name;
    }

    /**
     *  获取属性值[发送队列2名称]是否修改
     */
    public boolean isDataSyncOut2NameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDataSyncOut2NameDirty();
        }
        return this.datasyncout2nameDirtyFlag;
    }

    /**
     *  重置属性值[发送队列2名称]
     */
    public void resetDataSyncOut2Name() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDataSyncOut2Name();
            return;
        }

        this.datasyncout2nameDirtyFlag = false;
        this.datasyncout2name = null;
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
     *  设置属性值[同步错误信息]
     *  @param error
     */
    public void setError(String error) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setError(error);
            return;
        }
        if(error!=null) {
            error = StringHelper.trimRight(error);
            if(error.length()==0) {
                error = null;
            }
        }
        this.error = error;
        this.errorDirtyFlag  = true;
    }

    /**
     *  获取属性值[同步错误信息]
     */
    public String getError() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getError();
        }
        return this.error;
    }

    /**
     *  获取属性值[同步错误信息]是否修改
     */
    public boolean isErrorDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isErrorDirty();
        }
        return this.errorDirtyFlag;
    }

    /**
     *  重置属性值[同步错误信息]
     */
    public void resetError() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetError();
            return;
        }

        this.errorDirtyFlag = false;
        this.error = null;
    }
    /**
     *  设置属性值[事件类型]代码表：net.ibizsys.psrt.srv.codelist.DataChangeEventCodeListModel
     *  @param eventtype
     */
    public void setEventType(Integer eventtype) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setEventType(eventtype);
            return;
        }
        this.eventtype = eventtype;
        this.eventtypeDirtyFlag  = true;
    }

    /**
     *  获取属性值[事件类型]代码表：net.ibizsys.psrt.srv.codelist.DataChangeEventCodeListModel
     */
    public Integer getEventType() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getEventType();
        }
        return this.eventtype;
    }

    /**
     *  获取属性值[事件类型]是否修改
     */
    public boolean isEventTypeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isEventTypeDirty();
        }
        return this.eventtypeDirtyFlag;
    }

    /**
     *  重置属性值[事件类型]
     */
    public void resetEventType() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetEventType();
            return;
        }

        this.eventtypeDirtyFlag = false;
        this.eventtype = null;
    }
    /**
     *  设置属性值[同步文件清单]
     *  @param filelist
     */
    public void setFileList(String filelist) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setFileList(filelist);
            return;
        }
        if(filelist!=null) {
            filelist = StringHelper.trimRight(filelist);
            if(filelist.length()==0) {
                filelist = null;
            }
        }
        this.filelist = filelist;
        this.filelistDirtyFlag  = true;
    }

    /**
     *  获取属性值[同步文件清单]
     */
    public String getFileList() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getFileList();
        }
        return this.filelist;
    }

    /**
     *  获取属性值[同步文件清单]是否修改
     */
    public boolean isFileListDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isFileListDirty();
        }
        return this.filelistDirtyFlag;
    }

    /**
     *  重置属性值[同步文件清单]
     */
    public void resetFileList() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetFileList();
            return;
        }

        this.filelistDirtyFlag = false;
        this.filelist = null;
    }
    /**
     *  设置属性值[逻辑数据]
     *  @param logicdata
     */
    public void setLogicData(String logicdata) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setLogicData(logicdata);
            return;
        }
        if(logicdata!=null) {
            logicdata = StringHelper.trimRight(logicdata);
            if(logicdata.length()==0) {
                logicdata = null;
            }
        }
        this.logicdata = logicdata;
        this.logicdataDirtyFlag  = true;
    }

    /**
     *  获取属性值[逻辑数据]
     */
    public String getLogicData() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getLogicData();
        }
        return this.logicdata;
    }

    /**
     *  获取属性值[逻辑数据]是否修改
     */
    public boolean isLogicDataDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isLogicDataDirty();
        }
        return this.logicdataDirtyFlag;
    }

    /**
     *  重置属性值[逻辑数据]
     */
    public void resetLogicData() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetLogicData();
            return;
        }

        this.logicdataDirtyFlag = false;
        this.logicdata = null;
    }
    /**
     *  设置属性值[数据输出代理]代码表：net.ibizsys.psrt.srv.codelist.DataSyncInAgentCodeListModel
     *  @param syncagent
     */
    public void setSyncAgent(String syncagent) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setSyncAgent(syncagent);
            return;
        }
        if(syncagent!=null) {
            syncagent = StringHelper.trimRight(syncagent);
            if(syncagent.length()==0) {
                syncagent = null;
            }
        }
        this.syncagent = syncagent;
        this.syncagentDirtyFlag  = true;
    }

    /**
     *  获取属性值[数据输出代理]代码表：net.ibizsys.psrt.srv.codelist.DataSyncInAgentCodeListModel
     */
    public String getSyncAgent() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getSyncAgent();
        }
        return this.syncagent;
    }

    /**
     *  获取属性值[数据输出代理]是否修改
     */
    public boolean isSyncAgentDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isSyncAgentDirty();
        }
        return this.syncagentDirtyFlag;
    }

    /**
     *  重置属性值[数据输出代理]
     */
    public void resetSyncAgent() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetSyncAgent();
            return;
        }

        this.syncagentDirtyFlag = false;
        this.syncagent = null;
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

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        DataSyncOut2Base.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(DataSyncOut2Base et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetData();
        et.resetDataKey();
        et.resetDataSyncOut2Id();
        et.resetDataSyncOut2Name();
        et.resetDEId();
        et.resetDEName();
        et.resetError();
        et.resetEventType();
        et.resetFileList();
        et.resetLogicData();
        et.resetSyncAgent();
        et.resetUpdateDate();
        et.resetUpdateMan();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE,getCreateDate());
        }
        if(!bDirtyOnly || isCreateManDirty()) {
            params.put(FIELD_CREATEMAN,getCreateMan());
        }
        if(!bDirtyOnly || isDataDirty()) {
            params.put(FIELD_DATA,getData());
        }
        if(!bDirtyOnly || isDataKeyDirty()) {
            params.put(FIELD_DATAKEY,getDataKey());
        }
        if(!bDirtyOnly || isDataSyncOut2IdDirty()) {
            params.put(FIELD_DATASYNCOUT2ID,getDataSyncOut2Id());
        }
        if(!bDirtyOnly || isDataSyncOut2NameDirty()) {
            params.put(FIELD_DATASYNCOUT2NAME,getDataSyncOut2Name());
        }
        if(!bDirtyOnly || isDEIdDirty()) {
            params.put(FIELD_DEID,getDEId());
        }
        if(!bDirtyOnly || isDENameDirty()) {
            params.put(FIELD_DENAME,getDEName());
        }
        if(!bDirtyOnly || isErrorDirty()) {
            params.put(FIELD_ERROR,getError());
        }
        if(!bDirtyOnly || isEventTypeDirty()) {
            params.put(FIELD_EVENTTYPE,getEventType());
        }
        if(!bDirtyOnly || isFileListDirty()) {
            params.put(FIELD_FILELIST,getFileList());
        }
        if(!bDirtyOnly || isLogicDataDirty()) {
            params.put(FIELD_LOGICDATA,getLogicData());
        }
        if(!bDirtyOnly || isSyncAgentDirty()) {
            params.put(FIELD_SYNCAGENT,getSyncAgent());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
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

        return  DataSyncOut2Base.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(DataSyncOut2Base et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_DATA:
            return et.getData();
        case INDEX_DATAKEY:
            return et.getDataKey();
        case INDEX_DATASYNCOUT2ID:
            return et.getDataSyncOut2Id();
        case INDEX_DATASYNCOUT2NAME:
            return et.getDataSyncOut2Name();
        case INDEX_DEID:
            return et.getDEId();
        case INDEX_DENAME:
            return et.getDEName();
        case INDEX_ERROR:
            return et.getError();
        case INDEX_EVENTTYPE:
            return et.getEventType();
        case INDEX_FILELIST:
            return et.getFileList();
        case INDEX_LOGICDATA:
            return et.getLogicData();
        case INDEX_SYNCAGENT:
            return et.getSyncAgent();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
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

        DataSyncOut2Base.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(DataSyncOut2Base et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_DATA:
            et.setData(DataObject.getStringValue(obj));
            return ;
        case INDEX_DATAKEY:
            et.setDataKey(DataObject.getStringValue(obj));
            return ;
        case INDEX_DATASYNCOUT2ID:
            et.setDataSyncOut2Id(DataObject.getStringValue(obj));
            return ;
        case INDEX_DATASYNCOUT2NAME:
            et.setDataSyncOut2Name(DataObject.getStringValue(obj));
            return ;
        case INDEX_DEID:
            et.setDEId(DataObject.getStringValue(obj));
            return ;
        case INDEX_DENAME:
            et.setDEName(DataObject.getStringValue(obj));
            return ;
        case INDEX_ERROR:
            et.setError(DataObject.getStringValue(obj));
            return ;
        case INDEX_EVENTTYPE:
            et.setEventType(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_FILELIST:
            et.setFileList(DataObject.getStringValue(obj));
            return ;
        case INDEX_LOGICDATA:
            et.setLogicData(DataObject.getStringValue(obj));
            return ;
        case INDEX_SYNCAGENT:
            et.setSyncAgent(DataObject.getStringValue(obj));
            return ;
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
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

        return  DataSyncOut2Base.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(DataSyncOut2Base et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_DATA:
            return et.getData()==null;
        case INDEX_DATAKEY:
            return et.getDataKey()==null;
        case INDEX_DATASYNCOUT2ID:
            return et.getDataSyncOut2Id()==null;
        case INDEX_DATASYNCOUT2NAME:
            return et.getDataSyncOut2Name()==null;
        case INDEX_DEID:
            return et.getDEId()==null;
        case INDEX_DENAME:
            return et.getDEName()==null;
        case INDEX_ERROR:
            return et.getError()==null;
        case INDEX_EVENTTYPE:
            return et.getEventType()==null;
        case INDEX_FILELIST:
            return et.getFileList()==null;
        case INDEX_LOGICDATA:
            return et.getLogicData()==null;
        case INDEX_SYNCAGENT:
            return et.getSyncAgent()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
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
        return  DataSyncOut2Base.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(DataSyncOut2Base et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_DATA:
            return et.isDataDirty();
        case INDEX_DATAKEY:
            return et.isDataKeyDirty();
        case INDEX_DATASYNCOUT2ID:
            return et.isDataSyncOut2IdDirty();
        case INDEX_DATASYNCOUT2NAME:
            return et.isDataSyncOut2NameDirty();
        case INDEX_DEID:
            return et.isDEIdDirty();
        case INDEX_DENAME:
            return et.isDENameDirty();
        case INDEX_ERROR:
            return et.isErrorDirty();
        case INDEX_EVENTTYPE:
            return et.isEventTypeDirty();
        case INDEX_FILELIST:
            return et.isFileListDirty();
        case INDEX_LOGICDATA:
            return et.isLogicDataDirty();
        case INDEX_SYNCAGENT:
            return et.isSyncAgentDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
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
    private static  void fillJSONObject(DataSyncOut2Base et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getData()!=null) {
            JSONObjectHelper.put(json,"data",getJSONValue(et.getData()),false);
        }
        if(bIncEmpty||et.getDataKey()!=null) {
            JSONObjectHelper.put(json,"datakey",getJSONValue(et.getDataKey()),false);
        }
        if(bIncEmpty||et.getDataSyncOut2Id()!=null) {
            JSONObjectHelper.put(json,"datasyncout2id",getJSONValue(et.getDataSyncOut2Id()),false);
        }
        if(bIncEmpty||et.getDataSyncOut2Name()!=null) {
            JSONObjectHelper.put(json,"datasyncout2name",getJSONValue(et.getDataSyncOut2Name()),false);
        }
        if(bIncEmpty||et.getDEId()!=null) {
            JSONObjectHelper.put(json,"deid",getJSONValue(et.getDEId()),false);
        }
        if(bIncEmpty||et.getDEName()!=null) {
            JSONObjectHelper.put(json,"dename",getJSONValue(et.getDEName()),false);
        }
        if(bIncEmpty||et.getError()!=null) {
            JSONObjectHelper.put(json,"error",getJSONValue(et.getError()),false);
        }
        if(bIncEmpty||et.getEventType()!=null) {
            JSONObjectHelper.put(json,"eventtype",getJSONValue(et.getEventType()),false);
        }
        if(bIncEmpty||et.getFileList()!=null) {
            JSONObjectHelper.put(json,"filelist",getJSONValue(et.getFileList()),false);
        }
        if(bIncEmpty||et.getLogicData()!=null) {
            JSONObjectHelper.put(json,"logicdata",getJSONValue(et.getLogicData()),false);
        }
        if(bIncEmpty||et.getSyncAgent()!=null) {
            JSONObjectHelper.put(json,"syncagent",getJSONValue(et.getSyncAgent()),false);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
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
    private static void fillXmlNode(DataSyncOut2Base et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getData()!=null) {
            Object obj = et.getData();
            node.setAttribute("DATA",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDataKey()!=null) {
            Object obj = et.getDataKey();
            node.setAttribute("DATAKEY",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDataSyncOut2Id()!=null) {
            Object obj = et.getDataSyncOut2Id();
            node.setAttribute("DATASYNCOUT2ID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDataSyncOut2Name()!=null) {
            Object obj = et.getDataSyncOut2Name();
            node.setAttribute("DATASYNCOUT2NAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDEId()!=null) {
            Object obj = et.getDEId();
            node.setAttribute("DEID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDEName()!=null) {
            Object obj = et.getDEName();
            node.setAttribute("DENAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getError()!=null) {
            Object obj = et.getError();
            node.setAttribute("ERROR",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getEventType()!=null) {
            Object obj = et.getEventType();
            node.setAttribute("EVENTTYPE",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getFileList()!=null) {
            Object obj = et.getFileList();
            node.setAttribute("FILELIST",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getLogicData()!=null) {
            Object obj = et.getLogicData();
            node.setAttribute("LOGICDATA",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getSyncAgent()!=null) {
            Object obj = et.getSyncAgent();
            node.setAttribute("SYNCAGENT",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        DataSyncOut2Base.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(DataSyncOut2Base et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isDataDirty() && (bIncEmpty||et.getData()!=null)) {
            dst.set(FIELD_DATA,et.getData());
        }
        if(et.isDataKeyDirty() && (bIncEmpty||et.getDataKey()!=null)) {
            dst.set(FIELD_DATAKEY,et.getDataKey());
        }
        if(et.isDataSyncOut2IdDirty() && (bIncEmpty||et.getDataSyncOut2Id()!=null)) {
            dst.set(FIELD_DATASYNCOUT2ID,et.getDataSyncOut2Id());
        }
        if(et.isDataSyncOut2NameDirty() && (bIncEmpty||et.getDataSyncOut2Name()!=null)) {
            dst.set(FIELD_DATASYNCOUT2NAME,et.getDataSyncOut2Name());
        }
        if(et.isDEIdDirty() && (bIncEmpty||et.getDEId()!=null)) {
            dst.set(FIELD_DEID,et.getDEId());
        }
        if(et.isDENameDirty() && (bIncEmpty||et.getDEName()!=null)) {
            dst.set(FIELD_DENAME,et.getDEName());
        }
        if(et.isErrorDirty() && (bIncEmpty||et.getError()!=null)) {
            dst.set(FIELD_ERROR,et.getError());
        }
        if(et.isEventTypeDirty() && (bIncEmpty||et.getEventType()!=null)) {
            dst.set(FIELD_EVENTTYPE,et.getEventType());
        }
        if(et.isFileListDirty() && (bIncEmpty||et.getFileList()!=null)) {
            dst.set(FIELD_FILELIST,et.getFileList());
        }
        if(et.isLogicDataDirty() && (bIncEmpty||et.getLogicData()!=null)) {
            dst.set(FIELD_LOGICDATA,et.getLogicData());
        }
        if(et.isSyncAgentDirty() && (bIncEmpty||et.getSyncAgent()!=null)) {
            dst.set(FIELD_SYNCAGENT,et.getSyncAgent());
        }
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
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
        return  DataSyncOut2Base.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(DataSyncOut2Base et,int index) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_DATA:
            et.resetData();
            return true;
        case INDEX_DATAKEY:
            et.resetDataKey();
            return true;
        case INDEX_DATASYNCOUT2ID:
            et.resetDataSyncOut2Id();
            return true;
        case INDEX_DATASYNCOUT2NAME:
            et.resetDataSyncOut2Name();
            return true;
        case INDEX_DEID:
            et.resetDEId();
            return true;
        case INDEX_DENAME:
            et.resetDEName();
            return true;
        case INDEX_ERROR:
            et.resetError();
            return true;
        case INDEX_EVENTTYPE:
            et.resetEventType();
            return true;
        case INDEX_FILELIST:
            et.resetFileList();
            return true;
        case INDEX_LOGICDATA:
            et.resetLogicData();
            return true;
        case INDEX_SYNCAGENT:
            et.resetSyncAgent();
            return true;
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
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
    private DataSyncOut2Base getProxyEntity() {
        return this.proxyDataSyncOut2Base;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyDataSyncOut2Base = null;
        if(proxyDataObject!=null && proxyDataObject instanceof DataSyncOut2Base) {
            this.proxyDataSyncOut2Base = (DataSyncOut2Base)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.DataSyncOut2Service", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}