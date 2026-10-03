/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wx.entity;


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
 * 实体[WXMessage] 数据对象基类
 */
public abstract class WXMessageBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WXMessageBase.class);
    /**
     * 属性[输入内容数量]
     */
    public final static String FIELD_CNT = "CNT";
    /**
     * 属性[文本消息内容]
     */
    public final static String FIELD_CONTENT = "CONTENT";
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[事件]
     */
    public final static String FIELD_EVENT = "EVENT";
    /**
     * 属性[EventKey]
     */
    public final static String FIELD_EVENTKEY = "EVENTKEY";
    /**
     * 属性[语音格式]
     */
    public final static String FIELD_FORMAT = "FORMAT";
    /**
     * 属性[发送方帐号]
     */
    public final static String FIELD_FROMUSERNAME = "FROMUSERNAME";
    /**
     * 属性[进入时间]
     */
    public final static String FIELD_INCOMETIME = "INCOMETIME";
    /**
     * 属性[位置精度]
     */
    public final static String FIELD_LOCATION_PREC = "LOCATION_PREC";
    /**
     * 属性[地理位置维度]
     */
    public final static String FIELD_LOCATION_X = "LOCATION_X";
    /**
     * 属性[地理位置经度]
     */
    public final static String FIELD_LOCATION_Y = "LOCATION_Y";
    /**
     * 属性[图片消息媒体编号]
     */
    public final static String FIELD_MEDIAID = "MEDIAID";
    /**
     * 属性[消息类型]
     */
    public final static String FIELD_MSGTYPE = "MSGTYPE";
    /**
     * 属性[图片路径]
     */
    public final static String FIELD_PICURL = "PICURL";
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
     * 属性[反馈图文消息的数量]
     */
    public final static String FIELD_RESPARTICLECOUNT = "RESPARTICLECOUNT";
    /**
     * 属性[反馈的文章内容]
     */
    public final static String FIELD_RESPARTICLES = "RESPARTICLES";
    /**
     * 属性[返回描述]
     */
    public final static String FIELD_RESPDESC = "RESPDESC";
    /**
     * 属性[返回图片消息媒体编号]
     */
    public final static String FIELD_RESPMEDIAID = "RESPMEDIAID";
    /**
     * 属性[反馈消息类型]
     */
    public final static String FIELD_RESPMSGTYPE = "RESPMSGTYPE";
    /**
     * 属性[反馈时间]
     */
    public final static String FIELD_RESPTIME = "RESPTIME";
    /**
     * 属性[返回标题]
     */
    public final static String FIELD_RESPTITLE = "RESPTITLE";
    /**
     * 属性[结果内容]
     */
    public final static String FIELD_RESULT = "RESULT";
    /**
     * 属性[地图缩放大小]
     */
    public final static String FIELD_SCALE = "SCALE";
    /**
     * 属性[ScanCodeInfo]
     */
    public final static String FIELD_SCANCODEINFO = "SCANCODEINFO";
    /**
     * 属性[ScanType]
     */
    public final static String FIELD_SCANTYPE = "SCANTYPE";
    /**
     * 属性[视频消息缩略图的媒体编号]
     */
    public final static String FIELD_THUMBMEDIAID = "THUMBMEDIAID";
    /**
     * 属性[开发者微信号]
     */
    public final static String FIELD_TOUSERNAME = "TOUSERNAME";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[微信公众号]
     */
    public final static String FIELD_WXACCOUNTID = "WXACCOUNTID";
    /**
     * 属性[微信公众号]
     */
    public final static String FIELD_WXACCOUNTNAME = "WXACCOUNTNAME";
    /**
     * 属性[微信企业应用]
     */
    public final static String FIELD_WXENTAPPID = "WXENTAPPID";
    /**
     * 属性[微信企业应用]
     */
    public final static String FIELD_WXENTAPPNAME = "WXENTAPPNAME";
    /**
     * 属性[微信消息标识]
     */
    public final static String FIELD_WXMESSAGEID = "WXMESSAGEID";
    /**
     * 属性[微信消息名称]
     */
    public final static String FIELD_WXMESSAGENAME = "WXMESSAGENAME";

    private final static int INDEX_CNT = 0;
    private final static int INDEX_CONTENT = 1;
    private final static int INDEX_CREATEDATE = 2;
    private final static int INDEX_CREATEMAN = 3;
    private final static int INDEX_EVENT = 4;
    private final static int INDEX_EVENTKEY = 5;
    private final static int INDEX_FORMAT = 6;
    private final static int INDEX_FROMUSERNAME = 7;
    private final static int INDEX_INCOMETIME = 8;
    private final static int INDEX_LOCATION_PREC = 9;
    private final static int INDEX_LOCATION_X = 10;
    private final static int INDEX_LOCATION_Y = 11;
    private final static int INDEX_MEDIAID = 12;
    private final static int INDEX_MSGTYPE = 13;
    private final static int INDEX_PICURL = 14;
    private final static int INDEX_RESERVER = 15;
    private final static int INDEX_RESERVER2 = 16;
    private final static int INDEX_RESERVER3 = 17;
    private final static int INDEX_RESERVER4 = 18;
    private final static int INDEX_RESPARTICLECOUNT = 19;
    private final static int INDEX_RESPARTICLES = 20;
    private final static int INDEX_RESPDESC = 21;
    private final static int INDEX_RESPMEDIAID = 22;
    private final static int INDEX_RESPMSGTYPE = 23;
    private final static int INDEX_RESPTIME = 24;
    private final static int INDEX_RESPTITLE = 25;
    private final static int INDEX_RESULT = 26;
    private final static int INDEX_SCALE = 27;
    private final static int INDEX_SCANCODEINFO = 28;
    private final static int INDEX_SCANTYPE = 29;
    private final static int INDEX_THUMBMEDIAID = 30;
    private final static int INDEX_TOUSERNAME = 31;
    private final static int INDEX_UPDATEDATE = 32;
    private final static int INDEX_UPDATEMAN = 33;
    private final static int INDEX_WXACCOUNTID = 34;
    private final static int INDEX_WXACCOUNTNAME = 35;
    private final static int INDEX_WXENTAPPID = 36;
    private final static int INDEX_WXENTAPPNAME = 37;
    private final static int INDEX_WXMESSAGEID = 38;
    private final static int INDEX_WXMESSAGENAME = 39;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CNT, INDEX_CNT);
        fieldIndexMap.put( FIELD_CONTENT, INDEX_CONTENT);
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_EVENT, INDEX_EVENT);
        fieldIndexMap.put( FIELD_EVENTKEY, INDEX_EVENTKEY);
        fieldIndexMap.put( FIELD_FORMAT, INDEX_FORMAT);
        fieldIndexMap.put( FIELD_FROMUSERNAME, INDEX_FROMUSERNAME);
        fieldIndexMap.put( FIELD_INCOMETIME, INDEX_INCOMETIME);
        fieldIndexMap.put( FIELD_LOCATION_PREC, INDEX_LOCATION_PREC);
        fieldIndexMap.put( FIELD_LOCATION_X, INDEX_LOCATION_X);
        fieldIndexMap.put( FIELD_LOCATION_Y, INDEX_LOCATION_Y);
        fieldIndexMap.put( FIELD_MEDIAID, INDEX_MEDIAID);
        fieldIndexMap.put( FIELD_MSGTYPE, INDEX_MSGTYPE);
        fieldIndexMap.put( FIELD_PICURL, INDEX_PICURL);
        fieldIndexMap.put( FIELD_RESERVER, INDEX_RESERVER);
        fieldIndexMap.put( FIELD_RESERVER2, INDEX_RESERVER2);
        fieldIndexMap.put( FIELD_RESERVER3, INDEX_RESERVER3);
        fieldIndexMap.put( FIELD_RESERVER4, INDEX_RESERVER4);
        fieldIndexMap.put( FIELD_RESPARTICLECOUNT, INDEX_RESPARTICLECOUNT);
        fieldIndexMap.put( FIELD_RESPARTICLES, INDEX_RESPARTICLES);
        fieldIndexMap.put( FIELD_RESPDESC, INDEX_RESPDESC);
        fieldIndexMap.put( FIELD_RESPMEDIAID, INDEX_RESPMEDIAID);
        fieldIndexMap.put( FIELD_RESPMSGTYPE, INDEX_RESPMSGTYPE);
        fieldIndexMap.put( FIELD_RESPTIME, INDEX_RESPTIME);
        fieldIndexMap.put( FIELD_RESPTITLE, INDEX_RESPTITLE);
        fieldIndexMap.put( FIELD_RESULT, INDEX_RESULT);
        fieldIndexMap.put( FIELD_SCALE, INDEX_SCALE);
        fieldIndexMap.put( FIELD_SCANCODEINFO, INDEX_SCANCODEINFO);
        fieldIndexMap.put( FIELD_SCANTYPE, INDEX_SCANTYPE);
        fieldIndexMap.put( FIELD_THUMBMEDIAID, INDEX_THUMBMEDIAID);
        fieldIndexMap.put( FIELD_TOUSERNAME, INDEX_TOUSERNAME);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_WXACCOUNTID, INDEX_WXACCOUNTID);
        fieldIndexMap.put( FIELD_WXACCOUNTNAME, INDEX_WXACCOUNTNAME);
        fieldIndexMap.put( FIELD_WXENTAPPID, INDEX_WXENTAPPID);
        fieldIndexMap.put( FIELD_WXENTAPPNAME, INDEX_WXENTAPPNAME);
        fieldIndexMap.put( FIELD_WXMESSAGEID, INDEX_WXMESSAGEID);
        fieldIndexMap.put( FIELD_WXMESSAGENAME, INDEX_WXMESSAGENAME);
    }

    private WXMessageBase proxyWXMessageBase = null;
    public WXMessageBase() {
        super();
    }
    private boolean cntDirtyFlag = false;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean eventDirtyFlag = false;
    private boolean eventkeyDirtyFlag = false;
    private boolean formatDirtyFlag = false;
    private boolean fromusernameDirtyFlag = false;
    private boolean incometimeDirtyFlag = false;
    private boolean location_precDirtyFlag = false;
    private boolean location_xDirtyFlag = false;
    private boolean location_yDirtyFlag = false;
    private boolean mediaidDirtyFlag = false;
    private boolean msgtypeDirtyFlag = false;
    private boolean picurlDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean resparticlecountDirtyFlag = false;
    private boolean resparticlesDirtyFlag = false;
    private boolean respdescDirtyFlag = false;
    private boolean respmediaidDirtyFlag = false;
    private boolean respmsgtypeDirtyFlag = false;
    private boolean resptimeDirtyFlag = false;
    private boolean resptitleDirtyFlag = false;
    private boolean resultDirtyFlag = false;
    private boolean scaleDirtyFlag = false;
    private boolean scancodeinfoDirtyFlag = false;
    private boolean scantypeDirtyFlag = false;
    private boolean thumbmediaidDirtyFlag = false;
    private boolean tousernameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wxaccountidDirtyFlag = false;
    private boolean wxaccountnameDirtyFlag = false;
    private boolean wxentappidDirtyFlag = false;
    private boolean wxentappnameDirtyFlag = false;
    private boolean wxmessageidDirtyFlag = false;
    private boolean wxmessagenameDirtyFlag = false;

    @Column(name="cnt")
    private Integer cnt;
    @Column(name="content")
    private String content;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="event")
    private String event;
    @Column(name="eventkey")
    private String eventkey;
    @Column(name="format")
    private String format;
    @Column(name="fromusername")
    private String fromusername;
    @Column(name="incometime")
    private Timestamp incometime;
    @Column(name="location_prec")
    private Double location_prec;
    @Column(name="location_x")
    private String location_x;
    @Column(name="location_y")
    private String location_y;
    @Column(name="mediaid")
    private String mediaid;
    @Column(name="msgtype")
    private String msgtype;
    @Column(name="picurl")
    private String picurl;
    @Column(name="reserver")
    private String reserver;
    @Column(name="reserver2")
    private String reserver2;
    @Column(name="reserver3")
    private String reserver3;
    @Column(name="reserver4")
    private String reserver4;
    @Column(name="resparticlecount")
    private Integer resparticlecount;
    @Column(name="resparticles")
    private String resparticles;
    @Column(name="respdesc")
    private String respdesc;
    @Column(name="respmediaid")
    private String respmediaid;
    @Column(name="respmsgtype")
    private String respmsgtype;
    @Column(name="resptime")
    private Timestamp resptime;
    @Column(name="resptitle")
    private String resptitle;
    @Column(name="result")
    private String result;
    @Column(name="scale")
    private Integer scale;
    @Column(name="scancodeinfo")
    private String scancodeinfo;
    @Column(name="scantype")
    private String scantype;
    @Column(name="thumbmediaid")
    private String thumbmediaid;
    @Column(name="tousername")
    private String tousername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wxaccountid")
    private String wxaccountid;
    @Column(name="wxaccountname")
    private String wxaccountname;
    @Column(name="wxentappid")
    private String wxentappid;
    @Column(name="wxentappname")
    private String wxentappname;
    @Column(name="wxmessageid")
    private String wxmessageid;
    @Column(name="wxmessagename")
    private String wxmessagename;


    /**
     *  设置属性值[输入内容数量]
     *  @param cnt
     */
    public void setCnt(Integer cnt) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCnt(cnt);
            return;
        }
        this.cnt = cnt;
        this.cntDirtyFlag  = true;
    }

    /**
     *  获取属性值[输入内容数量]
     */
    public Integer getCnt() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCnt();
        }
        return this.cnt;
    }

    /**
     *  获取属性值[输入内容数量]是否修改
     */
    public boolean isCntDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCntDirty();
        }
        return this.cntDirtyFlag;
    }

    /**
     *  重置属性值[输入内容数量]
     */
    public void resetCnt() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCnt();
            return;
        }

        this.cntDirtyFlag = false;
        this.cnt = null;
    }
    /**
     *  设置属性值[文本消息内容]
     *  @param content
     */
    public void setContent(String content) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setContent(content);
            return;
        }
        if(content!=null) {
            content = StringHelper.trimRight(content);
            if(content.length()==0) {
                content = null;
            }
        }
        this.content = content;
        this.contentDirtyFlag  = true;
    }

    /**
     *  获取属性值[文本消息内容]
     */
    public String getContent() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getContent();
        }
        return this.content;
    }

    /**
     *  获取属性值[文本消息内容]是否修改
     */
    public boolean isContentDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isContentDirty();
        }
        return this.contentDirtyFlag;
    }

    /**
     *  重置属性值[文本消息内容]
     */
    public void resetContent() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetContent();
            return;
        }

        this.contentDirtyFlag = false;
        this.content = null;
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
     *  设置属性值[事件]
     *  @param event
     */
    public void setEvent(String event) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setEvent(event);
            return;
        }
        if(event!=null) {
            event = StringHelper.trimRight(event);
            if(event.length()==0) {
                event = null;
            }
        }
        this.event = event;
        this.eventDirtyFlag  = true;
    }

    /**
     *  获取属性值[事件]
     */
    public String getEvent() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getEvent();
        }
        return this.event;
    }

    /**
     *  获取属性值[事件]是否修改
     */
    public boolean isEventDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isEventDirty();
        }
        return this.eventDirtyFlag;
    }

    /**
     *  重置属性值[事件]
     */
    public void resetEvent() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetEvent();
            return;
        }

        this.eventDirtyFlag = false;
        this.event = null;
    }
    /**
     *  设置属性值[EventKey]
     *  @param eventkey
     */
    public void setEventKey(String eventkey) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setEventKey(eventkey);
            return;
        }
        if(eventkey!=null) {
            eventkey = StringHelper.trimRight(eventkey);
            if(eventkey.length()==0) {
                eventkey = null;
            }
        }
        this.eventkey = eventkey;
        this.eventkeyDirtyFlag  = true;
    }

    /**
     *  获取属性值[EventKey]
     */
    public String getEventKey() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getEventKey();
        }
        return this.eventkey;
    }

    /**
     *  获取属性值[EventKey]是否修改
     */
    public boolean isEventKeyDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isEventKeyDirty();
        }
        return this.eventkeyDirtyFlag;
    }

    /**
     *  重置属性值[EventKey]
     */
    public void resetEventKey() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetEventKey();
            return;
        }

        this.eventkeyDirtyFlag = false;
        this.eventkey = null;
    }
    /**
     *  设置属性值[语音格式]
     *  @param format
     */
    public void setFormat(String format) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setFormat(format);
            return;
        }
        if(format!=null) {
            format = StringHelper.trimRight(format);
            if(format.length()==0) {
                format = null;
            }
        }
        this.format = format;
        this.formatDirtyFlag  = true;
    }

    /**
     *  获取属性值[语音格式]
     */
    public String getFormat() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getFormat();
        }
        return this.format;
    }

    /**
     *  获取属性值[语音格式]是否修改
     */
    public boolean isFormatDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isFormatDirty();
        }
        return this.formatDirtyFlag;
    }

    /**
     *  重置属性值[语音格式]
     */
    public void resetFormat() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetFormat();
            return;
        }

        this.formatDirtyFlag = false;
        this.format = null;
    }
    /**
     *  设置属性值[发送方帐号]
     *  @param fromusername
     */
    public void setFromUserName(String fromusername) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setFromUserName(fromusername);
            return;
        }
        if(fromusername!=null) {
            fromusername = StringHelper.trimRight(fromusername);
            if(fromusername.length()==0) {
                fromusername = null;
            }
        }
        this.fromusername = fromusername;
        this.fromusernameDirtyFlag  = true;
    }

    /**
     *  获取属性值[发送方帐号]
     */
    public String getFromUserName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getFromUserName();
        }
        return this.fromusername;
    }

    /**
     *  获取属性值[发送方帐号]是否修改
     */
    public boolean isFromUserNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isFromUserNameDirty();
        }
        return this.fromusernameDirtyFlag;
    }

    /**
     *  重置属性值[发送方帐号]
     */
    public void resetFromUserName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetFromUserName();
            return;
        }

        this.fromusernameDirtyFlag = false;
        this.fromusername = null;
    }
    /**
     *  设置属性值[进入时间]
     *  @param incometime
     */
    public void setIncomeTime(Timestamp incometime) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setIncomeTime(incometime);
            return;
        }
        this.incometime = incometime;
        this.incometimeDirtyFlag  = true;
    }

    /**
     *  获取属性值[进入时间]
     */
    public Timestamp getIncomeTime() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getIncomeTime();
        }
        return this.incometime;
    }

    /**
     *  获取属性值[进入时间]是否修改
     */
    public boolean isIncomeTimeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isIncomeTimeDirty();
        }
        return this.incometimeDirtyFlag;
    }

    /**
     *  重置属性值[进入时间]
     */
    public void resetIncomeTime() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetIncomeTime();
            return;
        }

        this.incometimeDirtyFlag = false;
        this.incometime = null;
    }
    /**
     *  设置属性值[位置精度]
     *  @param location_prec
     */
    public void setLocation_Prec(Double location_prec) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setLocation_Prec(location_prec);
            return;
        }
        this.location_prec = location_prec;
        this.location_precDirtyFlag  = true;
    }

    /**
     *  获取属性值[位置精度]
     */
    public Double getLocation_Prec() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getLocation_Prec();
        }
        return this.location_prec;
    }

    /**
     *  获取属性值[位置精度]是否修改
     */
    public boolean isLocation_PrecDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isLocation_PrecDirty();
        }
        return this.location_precDirtyFlag;
    }

    /**
     *  重置属性值[位置精度]
     */
    public void resetLocation_Prec() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetLocation_Prec();
            return;
        }

        this.location_precDirtyFlag = false;
        this.location_prec = null;
    }
    /**
     *  设置属性值[地理位置维度]
     *  @param location_x
     */
    public void setLocation_X(String location_x) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setLocation_X(location_x);
            return;
        }
        if(location_x!=null) {
            location_x = StringHelper.trimRight(location_x);
            if(location_x.length()==0) {
                location_x = null;
            }
        }
        this.location_x = location_x;
        this.location_xDirtyFlag  = true;
    }

    /**
     *  获取属性值[地理位置维度]
     */
    public String getLocation_X() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getLocation_X();
        }
        return this.location_x;
    }

    /**
     *  获取属性值[地理位置维度]是否修改
     */
    public boolean isLocation_XDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isLocation_XDirty();
        }
        return this.location_xDirtyFlag;
    }

    /**
     *  重置属性值[地理位置维度]
     */
    public void resetLocation_X() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetLocation_X();
            return;
        }

        this.location_xDirtyFlag = false;
        this.location_x = null;
    }
    /**
     *  设置属性值[地理位置经度]
     *  @param location_y
     */
    public void setLocation_Y(String location_y) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setLocation_Y(location_y);
            return;
        }
        if(location_y!=null) {
            location_y = StringHelper.trimRight(location_y);
            if(location_y.length()==0) {
                location_y = null;
            }
        }
        this.location_y = location_y;
        this.location_yDirtyFlag  = true;
    }

    /**
     *  获取属性值[地理位置经度]
     */
    public String getLocation_Y() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getLocation_Y();
        }
        return this.location_y;
    }

    /**
     *  获取属性值[地理位置经度]是否修改
     */
    public boolean isLocation_YDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isLocation_YDirty();
        }
        return this.location_yDirtyFlag;
    }

    /**
     *  重置属性值[地理位置经度]
     */
    public void resetLocation_Y() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetLocation_Y();
            return;
        }

        this.location_yDirtyFlag = false;
        this.location_y = null;
    }
    /**
     *  设置属性值[图片消息媒体编号]
     *  @param mediaid
     */
    public void setMediaId(String mediaid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMediaId(mediaid);
            return;
        }
        if(mediaid!=null) {
            mediaid = StringHelper.trimRight(mediaid);
            if(mediaid.length()==0) {
                mediaid = null;
            }
        }
        this.mediaid = mediaid;
        this.mediaidDirtyFlag  = true;
    }

    /**
     *  获取属性值[图片消息媒体编号]
     */
    public String getMediaId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMediaId();
        }
        return this.mediaid;
    }

    /**
     *  获取属性值[图片消息媒体编号]是否修改
     */
    public boolean isMediaIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMediaIdDirty();
        }
        return this.mediaidDirtyFlag;
    }

    /**
     *  重置属性值[图片消息媒体编号]
     */
    public void resetMediaId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMediaId();
            return;
        }

        this.mediaidDirtyFlag = false;
        this.mediaid = null;
    }
    /**
     *  设置属性值[消息类型]代码表：net.ibizsys.psrt.srv.codelist.WXMsgTypeCodeListModel
     *  @param msgtype
     */
    public void setMsgType(String msgtype) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMsgType(msgtype);
            return;
        }
        if(msgtype!=null) {
            msgtype = StringHelper.trimRight(msgtype);
            if(msgtype.length()==0) {
                msgtype = null;
            }
        }
        this.msgtype = msgtype;
        this.msgtypeDirtyFlag  = true;
    }

    /**
     *  获取属性值[消息类型]代码表：net.ibizsys.psrt.srv.codelist.WXMsgTypeCodeListModel
     */
    public String getMsgType() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMsgType();
        }
        return this.msgtype;
    }

    /**
     *  获取属性值[消息类型]是否修改
     */
    public boolean isMsgTypeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMsgTypeDirty();
        }
        return this.msgtypeDirtyFlag;
    }

    /**
     *  重置属性值[消息类型]
     */
    public void resetMsgType() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMsgType();
            return;
        }

        this.msgtypeDirtyFlag = false;
        this.msgtype = null;
    }
    /**
     *  设置属性值[图片路径]
     *  @param picurl
     */
    public void setPicURL(String picurl) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPicURL(picurl);
            return;
        }
        if(picurl!=null) {
            picurl = StringHelper.trimRight(picurl);
            if(picurl.length()==0) {
                picurl = null;
            }
        }
        this.picurl = picurl;
        this.picurlDirtyFlag  = true;
    }

    /**
     *  获取属性值[图片路径]
     */
    public String getPicURL() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPicURL();
        }
        return this.picurl;
    }

    /**
     *  获取属性值[图片路径]是否修改
     */
    public boolean isPicURLDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPicURLDirty();
        }
        return this.picurlDirtyFlag;
    }

    /**
     *  重置属性值[图片路径]
     */
    public void resetPicURL() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPicURL();
            return;
        }

        this.picurlDirtyFlag = false;
        this.picurl = null;
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
     *  设置属性值[反馈图文消息的数量]
     *  @param resparticlecount
     */
    public void setRespArticleCount(Integer resparticlecount) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setRespArticleCount(resparticlecount);
            return;
        }
        this.resparticlecount = resparticlecount;
        this.resparticlecountDirtyFlag  = true;
    }

    /**
     *  获取属性值[反馈图文消息的数量]
     */
    public Integer getRespArticleCount() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getRespArticleCount();
        }
        return this.resparticlecount;
    }

    /**
     *  获取属性值[反馈图文消息的数量]是否修改
     */
    public boolean isRespArticleCountDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isRespArticleCountDirty();
        }
        return this.resparticlecountDirtyFlag;
    }

    /**
     *  重置属性值[反馈图文消息的数量]
     */
    public void resetRespArticleCount() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetRespArticleCount();
            return;
        }

        this.resparticlecountDirtyFlag = false;
        this.resparticlecount = null;
    }
    /**
     *  设置属性值[反馈的文章内容]
     *  @param resparticles
     */
    public void setRespArticles(String resparticles) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setRespArticles(resparticles);
            return;
        }
        if(resparticles!=null) {
            resparticles = StringHelper.trimRight(resparticles);
            if(resparticles.length()==0) {
                resparticles = null;
            }
        }
        this.resparticles = resparticles;
        this.resparticlesDirtyFlag  = true;
    }

    /**
     *  获取属性值[反馈的文章内容]
     */
    public String getRespArticles() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getRespArticles();
        }
        return this.resparticles;
    }

    /**
     *  获取属性值[反馈的文章内容]是否修改
     */
    public boolean isRespArticlesDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isRespArticlesDirty();
        }
        return this.resparticlesDirtyFlag;
    }

    /**
     *  重置属性值[反馈的文章内容]
     */
    public void resetRespArticles() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetRespArticles();
            return;
        }

        this.resparticlesDirtyFlag = false;
        this.resparticles = null;
    }
    /**
     *  设置属性值[返回描述]
     *  @param respdesc
     */
    public void setRespDesc(String respdesc) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setRespDesc(respdesc);
            return;
        }
        if(respdesc!=null) {
            respdesc = StringHelper.trimRight(respdesc);
            if(respdesc.length()==0) {
                respdesc = null;
            }
        }
        this.respdesc = respdesc;
        this.respdescDirtyFlag  = true;
    }

    /**
     *  获取属性值[返回描述]
     */
    public String getRespDesc() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getRespDesc();
        }
        return this.respdesc;
    }

    /**
     *  获取属性值[返回描述]是否修改
     */
    public boolean isRespDescDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isRespDescDirty();
        }
        return this.respdescDirtyFlag;
    }

    /**
     *  重置属性值[返回描述]
     */
    public void resetRespDesc() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetRespDesc();
            return;
        }

        this.respdescDirtyFlag = false;
        this.respdesc = null;
    }
    /**
     *  设置属性值[返回图片消息媒体编号]
     *  @param respmediaid
     */
    public void setRespMediaId(String respmediaid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setRespMediaId(respmediaid);
            return;
        }
        if(respmediaid!=null) {
            respmediaid = StringHelper.trimRight(respmediaid);
            if(respmediaid.length()==0) {
                respmediaid = null;
            }
        }
        this.respmediaid = respmediaid;
        this.respmediaidDirtyFlag  = true;
    }

    /**
     *  获取属性值[返回图片消息媒体编号]
     */
    public String getRespMediaId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getRespMediaId();
        }
        return this.respmediaid;
    }

    /**
     *  获取属性值[返回图片消息媒体编号]是否修改
     */
    public boolean isRespMediaIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isRespMediaIdDirty();
        }
        return this.respmediaidDirtyFlag;
    }

    /**
     *  重置属性值[返回图片消息媒体编号]
     */
    public void resetRespMediaId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetRespMediaId();
            return;
        }

        this.respmediaidDirtyFlag = false;
        this.respmediaid = null;
    }
    /**
     *  设置属性值[反馈消息类型]代码表：net.ibizsys.psrt.srv.codelist.WXMsgTypeCodeListModel
     *  @param respmsgtype
     */
    public void setRespMsgType(String respmsgtype) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setRespMsgType(respmsgtype);
            return;
        }
        if(respmsgtype!=null) {
            respmsgtype = StringHelper.trimRight(respmsgtype);
            if(respmsgtype.length()==0) {
                respmsgtype = null;
            }
        }
        this.respmsgtype = respmsgtype;
        this.respmsgtypeDirtyFlag  = true;
    }

    /**
     *  获取属性值[反馈消息类型]代码表：net.ibizsys.psrt.srv.codelist.WXMsgTypeCodeListModel
     */
    public String getRespMsgType() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getRespMsgType();
        }
        return this.respmsgtype;
    }

    /**
     *  获取属性值[反馈消息类型]是否修改
     */
    public boolean isRespMsgTypeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isRespMsgTypeDirty();
        }
        return this.respmsgtypeDirtyFlag;
    }

    /**
     *  重置属性值[反馈消息类型]
     */
    public void resetRespMsgType() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetRespMsgType();
            return;
        }

        this.respmsgtypeDirtyFlag = false;
        this.respmsgtype = null;
    }
    /**
     *  设置属性值[反馈时间]
     *  @param resptime
     */
    public void setRespTime(Timestamp resptime) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setRespTime(resptime);
            return;
        }
        this.resptime = resptime;
        this.resptimeDirtyFlag  = true;
    }

    /**
     *  获取属性值[反馈时间]
     */
    public Timestamp getRespTime() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getRespTime();
        }
        return this.resptime;
    }

    /**
     *  获取属性值[反馈时间]是否修改
     */
    public boolean isRespTimeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isRespTimeDirty();
        }
        return this.resptimeDirtyFlag;
    }

    /**
     *  重置属性值[反馈时间]
     */
    public void resetRespTime() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetRespTime();
            return;
        }

        this.resptimeDirtyFlag = false;
        this.resptime = null;
    }
    /**
     *  设置属性值[返回标题]
     *  @param resptitle
     */
    public void setRespTitle(String resptitle) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setRespTitle(resptitle);
            return;
        }
        if(resptitle!=null) {
            resptitle = StringHelper.trimRight(resptitle);
            if(resptitle.length()==0) {
                resptitle = null;
            }
        }
        this.resptitle = resptitle;
        this.resptitleDirtyFlag  = true;
    }

    /**
     *  获取属性值[返回标题]
     */
    public String getRespTitle() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getRespTitle();
        }
        return this.resptitle;
    }

    /**
     *  获取属性值[返回标题]是否修改
     */
    public boolean isRespTitleDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isRespTitleDirty();
        }
        return this.resptitleDirtyFlag;
    }

    /**
     *  重置属性值[返回标题]
     */
    public void resetRespTitle() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetRespTitle();
            return;
        }

        this.resptitleDirtyFlag = false;
        this.resptitle = null;
    }
    /**
     *  设置属性值[结果内容]
     *  @param result
     */
    public void setResult(String result) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setResult(result);
            return;
        }
        if(result!=null) {
            result = StringHelper.trimRight(result);
            if(result.length()==0) {
                result = null;
            }
        }
        this.result = result;
        this.resultDirtyFlag  = true;
    }

    /**
     *  获取属性值[结果内容]
     */
    public String getResult() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getResult();
        }
        return this.result;
    }

    /**
     *  获取属性值[结果内容]是否修改
     */
    public boolean isResultDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isResultDirty();
        }
        return this.resultDirtyFlag;
    }

    /**
     *  重置属性值[结果内容]
     */
    public void resetResult() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetResult();
            return;
        }

        this.resultDirtyFlag = false;
        this.result = null;
    }
    /**
     *  设置属性值[地图缩放大小]
     *  @param scale
     */
    public void setScale(Integer scale) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setScale(scale);
            return;
        }
        this.scale = scale;
        this.scaleDirtyFlag  = true;
    }

    /**
     *  获取属性值[地图缩放大小]
     */
    public Integer getScale() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getScale();
        }
        return this.scale;
    }

    /**
     *  获取属性值[地图缩放大小]是否修改
     */
    public boolean isScaleDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isScaleDirty();
        }
        return this.scaleDirtyFlag;
    }

    /**
     *  重置属性值[地图缩放大小]
     */
    public void resetScale() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetScale();
            return;
        }

        this.scaleDirtyFlag = false;
        this.scale = null;
    }
    /**
     *  设置属性值[ScanCodeInfo]
     *  @param scancodeinfo
     */
    public void setScanCodeInfo(String scancodeinfo) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setScanCodeInfo(scancodeinfo);
            return;
        }
        if(scancodeinfo!=null) {
            scancodeinfo = StringHelper.trimRight(scancodeinfo);
            if(scancodeinfo.length()==0) {
                scancodeinfo = null;
            }
        }
        this.scancodeinfo = scancodeinfo;
        this.scancodeinfoDirtyFlag  = true;
    }

    /**
     *  获取属性值[ScanCodeInfo]
     */
    public String getScanCodeInfo() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getScanCodeInfo();
        }
        return this.scancodeinfo;
    }

    /**
     *  获取属性值[ScanCodeInfo]是否修改
     */
    public boolean isScanCodeInfoDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isScanCodeInfoDirty();
        }
        return this.scancodeinfoDirtyFlag;
    }

    /**
     *  重置属性值[ScanCodeInfo]
     */
    public void resetScanCodeInfo() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetScanCodeInfo();
            return;
        }

        this.scancodeinfoDirtyFlag = false;
        this.scancodeinfo = null;
    }
    /**
     *  设置属性值[ScanType]
     *  @param scantype
     */
    public void setScanType(String scantype) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setScanType(scantype);
            return;
        }
        if(scantype!=null) {
            scantype = StringHelper.trimRight(scantype);
            if(scantype.length()==0) {
                scantype = null;
            }
        }
        this.scantype = scantype;
        this.scantypeDirtyFlag  = true;
    }

    /**
     *  获取属性值[ScanType]
     */
    public String getScanType() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getScanType();
        }
        return this.scantype;
    }

    /**
     *  获取属性值[ScanType]是否修改
     */
    public boolean isScanTypeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isScanTypeDirty();
        }
        return this.scantypeDirtyFlag;
    }

    /**
     *  重置属性值[ScanType]
     */
    public void resetScanType() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetScanType();
            return;
        }

        this.scantypeDirtyFlag = false;
        this.scantype = null;
    }
    /**
     *  设置属性值[视频消息缩略图的媒体编号]
     *  @param thumbmediaid
     */
    public void setThumbMediaId(String thumbmediaid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setThumbMediaId(thumbmediaid);
            return;
        }
        if(thumbmediaid!=null) {
            thumbmediaid = StringHelper.trimRight(thumbmediaid);
            if(thumbmediaid.length()==0) {
                thumbmediaid = null;
            }
        }
        this.thumbmediaid = thumbmediaid;
        this.thumbmediaidDirtyFlag  = true;
    }

    /**
     *  获取属性值[视频消息缩略图的媒体编号]
     */
    public String getThumbMediaId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getThumbMediaId();
        }
        return this.thumbmediaid;
    }

    /**
     *  获取属性值[视频消息缩略图的媒体编号]是否修改
     */
    public boolean isThumbMediaIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isThumbMediaIdDirty();
        }
        return this.thumbmediaidDirtyFlag;
    }

    /**
     *  重置属性值[视频消息缩略图的媒体编号]
     */
    public void resetThumbMediaId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetThumbMediaId();
            return;
        }

        this.thumbmediaidDirtyFlag = false;
        this.thumbmediaid = null;
    }
    /**
     *  设置属性值[开发者微信号]
     *  @param tousername
     */
    public void setToUserName(String tousername) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setToUserName(tousername);
            return;
        }
        if(tousername!=null) {
            tousername = StringHelper.trimRight(tousername);
            if(tousername.length()==0) {
                tousername = null;
            }
        }
        this.tousername = tousername;
        this.tousernameDirtyFlag  = true;
    }

    /**
     *  获取属性值[开发者微信号]
     */
    public String getToUserName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getToUserName();
        }
        return this.tousername;
    }

    /**
     *  获取属性值[开发者微信号]是否修改
     */
    public boolean isToUserNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isToUserNameDirty();
        }
        return this.tousernameDirtyFlag;
    }

    /**
     *  重置属性值[开发者微信号]
     */
    public void resetToUserName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetToUserName();
            return;
        }

        this.tousernameDirtyFlag = false;
        this.tousername = null;
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
     *  设置属性值[微信公众号]
     *  @param wxaccountid
     */
    public void setWXAccountId(String wxaccountid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWXAccountId(wxaccountid);
            return;
        }
        if(wxaccountid!=null) {
            wxaccountid = StringHelper.trimRight(wxaccountid);
            if(wxaccountid.length()==0) {
                wxaccountid = null;
            }
        }
        this.wxaccountid = wxaccountid;
        this.wxaccountidDirtyFlag  = true;
    }

    /**
     *  获取属性值[微信公众号]
     */
    public String getWXAccountId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWXAccountId();
        }
        return this.wxaccountid;
    }

    /**
     *  获取属性值[微信公众号]是否修改
     */
    public boolean isWXAccountIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWXAccountIdDirty();
        }
        return this.wxaccountidDirtyFlag;
    }

    /**
     *  重置属性值[微信公众号]
     */
    public void resetWXAccountId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWXAccountId();
            return;
        }

        this.wxaccountidDirtyFlag = false;
        this.wxaccountid = null;
    }
    /**
     *  设置属性值[微信公众号]
     *  @param wxaccountname
     */
    public void setWXAccountName(String wxaccountname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWXAccountName(wxaccountname);
            return;
        }
        if(wxaccountname!=null) {
            wxaccountname = StringHelper.trimRight(wxaccountname);
            if(wxaccountname.length()==0) {
                wxaccountname = null;
            }
        }
        this.wxaccountname = wxaccountname;
        this.wxaccountnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[微信公众号]
     */
    public String getWXAccountName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWXAccountName();
        }
        return this.wxaccountname;
    }

    /**
     *  获取属性值[微信公众号]是否修改
     */
    public boolean isWXAccountNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWXAccountNameDirty();
        }
        return this.wxaccountnameDirtyFlag;
    }

    /**
     *  重置属性值[微信公众号]
     */
    public void resetWXAccountName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWXAccountName();
            return;
        }

        this.wxaccountnameDirtyFlag = false;
        this.wxaccountname = null;
    }
    /**
     *  设置属性值[微信企业应用]
     *  @param wxentappid
     */
    public void setWXEntAppId(String wxentappid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWXEntAppId(wxentappid);
            return;
        }
        if(wxentappid!=null) {
            wxentappid = StringHelper.trimRight(wxentappid);
            if(wxentappid.length()==0) {
                wxentappid = null;
            }
        }
        this.wxentappid = wxentappid;
        this.wxentappidDirtyFlag  = true;
    }

    /**
     *  获取属性值[微信企业应用]
     */
    public String getWXEntAppId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWXEntAppId();
        }
        return this.wxentappid;
    }

    /**
     *  获取属性值[微信企业应用]是否修改
     */
    public boolean isWXEntAppIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWXEntAppIdDirty();
        }
        return this.wxentappidDirtyFlag;
    }

    /**
     *  重置属性值[微信企业应用]
     */
    public void resetWXEntAppId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWXEntAppId();
            return;
        }

        this.wxentappidDirtyFlag = false;
        this.wxentappid = null;
    }
    /**
     *  设置属性值[微信企业应用]
     *  @param wxentappname
     */
    public void setWXEntAppName(String wxentappname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWXEntAppName(wxentappname);
            return;
        }
        if(wxentappname!=null) {
            wxentappname = StringHelper.trimRight(wxentappname);
            if(wxentappname.length()==0) {
                wxentappname = null;
            }
        }
        this.wxentappname = wxentappname;
        this.wxentappnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[微信企业应用]
     */
    public String getWXEntAppName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWXEntAppName();
        }
        return this.wxentappname;
    }

    /**
     *  获取属性值[微信企业应用]是否修改
     */
    public boolean isWXEntAppNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWXEntAppNameDirty();
        }
        return this.wxentappnameDirtyFlag;
    }

    /**
     *  重置属性值[微信企业应用]
     */
    public void resetWXEntAppName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWXEntAppName();
            return;
        }

        this.wxentappnameDirtyFlag = false;
        this.wxentappname = null;
    }
    /**
     *  设置属性值[微信消息标识]
     *  @param wxmessageid
     */
    public void setWXMessageId(String wxmessageid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWXMessageId(wxmessageid);
            return;
        }
        if(wxmessageid!=null) {
            wxmessageid = StringHelper.trimRight(wxmessageid);
            if(wxmessageid.length()==0) {
                wxmessageid = null;
            }
        }
        this.wxmessageid = wxmessageid;
        this.wxmessageidDirtyFlag  = true;
    }

    /**
     *  获取属性值[微信消息标识]
     */
    public String getWXMessageId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWXMessageId();
        }
        return this.wxmessageid;
    }

    /**
     *  获取属性值[微信消息标识]是否修改
     */
    public boolean isWXMessageIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWXMessageIdDirty();
        }
        return this.wxmessageidDirtyFlag;
    }

    /**
     *  重置属性值[微信消息标识]
     */
    public void resetWXMessageId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWXMessageId();
            return;
        }

        this.wxmessageidDirtyFlag = false;
        this.wxmessageid = null;
    }
    /**
     *  设置属性值[微信消息名称]
     *  @param wxmessagename
     */
    public void setWXMessageName(String wxmessagename) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWXMessageName(wxmessagename);
            return;
        }
        if(wxmessagename!=null) {
            wxmessagename = StringHelper.trimRight(wxmessagename);
            if(wxmessagename.length()==0) {
                wxmessagename = null;
            }
        }
        this.wxmessagename = wxmessagename;
        this.wxmessagenameDirtyFlag  = true;
    }

    /**
     *  获取属性值[微信消息名称]
     */
    public String getWXMessageName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWXMessageName();
        }
        return this.wxmessagename;
    }

    /**
     *  获取属性值[微信消息名称]是否修改
     */
    public boolean isWXMessageNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWXMessageNameDirty();
        }
        return this.wxmessagenameDirtyFlag;
    }

    /**
     *  重置属性值[微信消息名称]
     */
    public void resetWXMessageName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWXMessageName();
            return;
        }

        this.wxmessagenameDirtyFlag = false;
        this.wxmessagename = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        WXMessageBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(WXMessageBase et) {
        et.resetCnt();
        et.resetContent();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetEvent();
        et.resetEventKey();
        et.resetFormat();
        et.resetFromUserName();
        et.resetIncomeTime();
        et.resetLocation_Prec();
        et.resetLocation_X();
        et.resetLocation_Y();
        et.resetMediaId();
        et.resetMsgType();
        et.resetPicURL();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetRespArticleCount();
        et.resetRespArticles();
        et.resetRespDesc();
        et.resetRespMediaId();
        et.resetRespMsgType();
        et.resetRespTime();
        et.resetRespTitle();
        et.resetResult();
        et.resetScale();
        et.resetScanCodeInfo();
        et.resetScanType();
        et.resetThumbMediaId();
        et.resetToUserName();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWXAccountId();
        et.resetWXAccountName();
        et.resetWXEntAppId();
        et.resetWXEntAppName();
        et.resetWXMessageId();
        et.resetWXMessageName();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isCntDirty()) {
            params.put(FIELD_CNT,getCnt());
        }
        if(!bDirtyOnly || isContentDirty()) {
            params.put(FIELD_CONTENT,getContent());
        }
        if(!bDirtyOnly || isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE,getCreateDate());
        }
        if(!bDirtyOnly || isCreateManDirty()) {
            params.put(FIELD_CREATEMAN,getCreateMan());
        }
        if(!bDirtyOnly || isEventDirty()) {
            params.put(FIELD_EVENT,getEvent());
        }
        if(!bDirtyOnly || isEventKeyDirty()) {
            params.put(FIELD_EVENTKEY,getEventKey());
        }
        if(!bDirtyOnly || isFormatDirty()) {
            params.put(FIELD_FORMAT,getFormat());
        }
        if(!bDirtyOnly || isFromUserNameDirty()) {
            params.put(FIELD_FROMUSERNAME,getFromUserName());
        }
        if(!bDirtyOnly || isIncomeTimeDirty()) {
            params.put(FIELD_INCOMETIME,getIncomeTime());
        }
        if(!bDirtyOnly || isLocation_PrecDirty()) {
            params.put(FIELD_LOCATION_PREC,getLocation_Prec());
        }
        if(!bDirtyOnly || isLocation_XDirty()) {
            params.put(FIELD_LOCATION_X,getLocation_X());
        }
        if(!bDirtyOnly || isLocation_YDirty()) {
            params.put(FIELD_LOCATION_Y,getLocation_Y());
        }
        if(!bDirtyOnly || isMediaIdDirty()) {
            params.put(FIELD_MEDIAID,getMediaId());
        }
        if(!bDirtyOnly || isMsgTypeDirty()) {
            params.put(FIELD_MSGTYPE,getMsgType());
        }
        if(!bDirtyOnly || isPicURLDirty()) {
            params.put(FIELD_PICURL,getPicURL());
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
        if(!bDirtyOnly || isRespArticleCountDirty()) {
            params.put(FIELD_RESPARTICLECOUNT,getRespArticleCount());
        }
        if(!bDirtyOnly || isRespArticlesDirty()) {
            params.put(FIELD_RESPARTICLES,getRespArticles());
        }
        if(!bDirtyOnly || isRespDescDirty()) {
            params.put(FIELD_RESPDESC,getRespDesc());
        }
        if(!bDirtyOnly || isRespMediaIdDirty()) {
            params.put(FIELD_RESPMEDIAID,getRespMediaId());
        }
        if(!bDirtyOnly || isRespMsgTypeDirty()) {
            params.put(FIELD_RESPMSGTYPE,getRespMsgType());
        }
        if(!bDirtyOnly || isRespTimeDirty()) {
            params.put(FIELD_RESPTIME,getRespTime());
        }
        if(!bDirtyOnly || isRespTitleDirty()) {
            params.put(FIELD_RESPTITLE,getRespTitle());
        }
        if(!bDirtyOnly || isResultDirty()) {
            params.put(FIELD_RESULT,getResult());
        }
        if(!bDirtyOnly || isScaleDirty()) {
            params.put(FIELD_SCALE,getScale());
        }
        if(!bDirtyOnly || isScanCodeInfoDirty()) {
            params.put(FIELD_SCANCODEINFO,getScanCodeInfo());
        }
        if(!bDirtyOnly || isScanTypeDirty()) {
            params.put(FIELD_SCANTYPE,getScanType());
        }
        if(!bDirtyOnly || isThumbMediaIdDirty()) {
            params.put(FIELD_THUMBMEDIAID,getThumbMediaId());
        }
        if(!bDirtyOnly || isToUserNameDirty()) {
            params.put(FIELD_TOUSERNAME,getToUserName());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
        }
        if(!bDirtyOnly || isWXAccountIdDirty()) {
            params.put(FIELD_WXACCOUNTID,getWXAccountId());
        }
        if(!bDirtyOnly || isWXAccountNameDirty()) {
            params.put(FIELD_WXACCOUNTNAME,getWXAccountName());
        }
        if(!bDirtyOnly || isWXEntAppIdDirty()) {
            params.put(FIELD_WXENTAPPID,getWXEntAppId());
        }
        if(!bDirtyOnly || isWXEntAppNameDirty()) {
            params.put(FIELD_WXENTAPPNAME,getWXEntAppName());
        }
        if(!bDirtyOnly || isWXMessageIdDirty()) {
            params.put(FIELD_WXMESSAGEID,getWXMessageId());
        }
        if(!bDirtyOnly || isWXMessageNameDirty()) {
            params.put(FIELD_WXMESSAGENAME,getWXMessageName());
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

        return  WXMessageBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(WXMessageBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CNT:
            return et.getCnt();
        case INDEX_CONTENT:
            return et.getContent();
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_EVENT:
            return et.getEvent();
        case INDEX_EVENTKEY:
            return et.getEventKey();
        case INDEX_FORMAT:
            return et.getFormat();
        case INDEX_FROMUSERNAME:
            return et.getFromUserName();
        case INDEX_INCOMETIME:
            return et.getIncomeTime();
        case INDEX_LOCATION_PREC:
            return et.getLocation_Prec();
        case INDEX_LOCATION_X:
            return et.getLocation_X();
        case INDEX_LOCATION_Y:
            return et.getLocation_Y();
        case INDEX_MEDIAID:
            return et.getMediaId();
        case INDEX_MSGTYPE:
            return et.getMsgType();
        case INDEX_PICURL:
            return et.getPicURL();
        case INDEX_RESERVER:
            return et.getReserver();
        case INDEX_RESERVER2:
            return et.getReserver2();
        case INDEX_RESERVER3:
            return et.getReserver3();
        case INDEX_RESERVER4:
            return et.getReserver4();
        case INDEX_RESPARTICLECOUNT:
            return et.getRespArticleCount();
        case INDEX_RESPARTICLES:
            return et.getRespArticles();
        case INDEX_RESPDESC:
            return et.getRespDesc();
        case INDEX_RESPMEDIAID:
            return et.getRespMediaId();
        case INDEX_RESPMSGTYPE:
            return et.getRespMsgType();
        case INDEX_RESPTIME:
            return et.getRespTime();
        case INDEX_RESPTITLE:
            return et.getRespTitle();
        case INDEX_RESULT:
            return et.getResult();
        case INDEX_SCALE:
            return et.getScale();
        case INDEX_SCANCODEINFO:
            return et.getScanCodeInfo();
        case INDEX_SCANTYPE:
            return et.getScanType();
        case INDEX_THUMBMEDIAID:
            return et.getThumbMediaId();
        case INDEX_TOUSERNAME:
            return et.getToUserName();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_WXACCOUNTID:
            return et.getWXAccountId();
        case INDEX_WXACCOUNTNAME:
            return et.getWXAccountName();
        case INDEX_WXENTAPPID:
            return et.getWXEntAppId();
        case INDEX_WXENTAPPNAME:
            return et.getWXEntAppName();
        case INDEX_WXMESSAGEID:
            return et.getWXMessageId();
        case INDEX_WXMESSAGENAME:
            return et.getWXMessageName();
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

        WXMessageBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(WXMessageBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CNT:
            et.setCnt(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_CONTENT:
            et.setContent(DataObject.getStringValue(obj));
            return ;
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_EVENT:
            et.setEvent(DataObject.getStringValue(obj));
            return ;
        case INDEX_EVENTKEY:
            et.setEventKey(DataObject.getStringValue(obj));
            return ;
        case INDEX_FORMAT:
            et.setFormat(DataObject.getStringValue(obj));
            return ;
        case INDEX_FROMUSERNAME:
            et.setFromUserName(DataObject.getStringValue(obj));
            return ;
        case INDEX_INCOMETIME:
            et.setIncomeTime(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_LOCATION_PREC:
            et.setLocation_Prec(DataObject.getDoubleValue(obj));
            return ;
        case INDEX_LOCATION_X:
            et.setLocation_X(DataObject.getStringValue(obj));
            return ;
        case INDEX_LOCATION_Y:
            et.setLocation_Y(DataObject.getStringValue(obj));
            return ;
        case INDEX_MEDIAID:
            et.setMediaId(DataObject.getStringValue(obj));
            return ;
        case INDEX_MSGTYPE:
            et.setMsgType(DataObject.getStringValue(obj));
            return ;
        case INDEX_PICURL:
            et.setPicURL(DataObject.getStringValue(obj));
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
        case INDEX_RESPARTICLECOUNT:
            et.setRespArticleCount(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_RESPARTICLES:
            et.setRespArticles(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESPDESC:
            et.setRespDesc(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESPMEDIAID:
            et.setRespMediaId(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESPMSGTYPE:
            et.setRespMsgType(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESPTIME:
            et.setRespTime(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_RESPTITLE:
            et.setRespTitle(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESULT:
            et.setResult(DataObject.getStringValue(obj));
            return ;
        case INDEX_SCALE:
            et.setScale(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_SCANCODEINFO:
            et.setScanCodeInfo(DataObject.getStringValue(obj));
            return ;
        case INDEX_SCANTYPE:
            et.setScanType(DataObject.getStringValue(obj));
            return ;
        case INDEX_THUMBMEDIAID:
            et.setThumbMediaId(DataObject.getStringValue(obj));
            return ;
        case INDEX_TOUSERNAME:
            et.setToUserName(DataObject.getStringValue(obj));
            return ;
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_WXACCOUNTID:
            et.setWXAccountId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WXACCOUNTNAME:
            et.setWXAccountName(DataObject.getStringValue(obj));
            return ;
        case INDEX_WXENTAPPID:
            et.setWXEntAppId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WXENTAPPNAME:
            et.setWXEntAppName(DataObject.getStringValue(obj));
            return ;
        case INDEX_WXMESSAGEID:
            et.setWXMessageId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WXMESSAGENAME:
            et.setWXMessageName(DataObject.getStringValue(obj));
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

        return  WXMessageBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(WXMessageBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CNT:
            return et.getCnt()==null;
        case INDEX_CONTENT:
            return et.getContent()==null;
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_EVENT:
            return et.getEvent()==null;
        case INDEX_EVENTKEY:
            return et.getEventKey()==null;
        case INDEX_FORMAT:
            return et.getFormat()==null;
        case INDEX_FROMUSERNAME:
            return et.getFromUserName()==null;
        case INDEX_INCOMETIME:
            return et.getIncomeTime()==null;
        case INDEX_LOCATION_PREC:
            return et.getLocation_Prec()==null;
        case INDEX_LOCATION_X:
            return et.getLocation_X()==null;
        case INDEX_LOCATION_Y:
            return et.getLocation_Y()==null;
        case INDEX_MEDIAID:
            return et.getMediaId()==null;
        case INDEX_MSGTYPE:
            return et.getMsgType()==null;
        case INDEX_PICURL:
            return et.getPicURL()==null;
        case INDEX_RESERVER:
            return et.getReserver()==null;
        case INDEX_RESERVER2:
            return et.getReserver2()==null;
        case INDEX_RESERVER3:
            return et.getReserver3()==null;
        case INDEX_RESERVER4:
            return et.getReserver4()==null;
        case INDEX_RESPARTICLECOUNT:
            return et.getRespArticleCount()==null;
        case INDEX_RESPARTICLES:
            return et.getRespArticles()==null;
        case INDEX_RESPDESC:
            return et.getRespDesc()==null;
        case INDEX_RESPMEDIAID:
            return et.getRespMediaId()==null;
        case INDEX_RESPMSGTYPE:
            return et.getRespMsgType()==null;
        case INDEX_RESPTIME:
            return et.getRespTime()==null;
        case INDEX_RESPTITLE:
            return et.getRespTitle()==null;
        case INDEX_RESULT:
            return et.getResult()==null;
        case INDEX_SCALE:
            return et.getScale()==null;
        case INDEX_SCANCODEINFO:
            return et.getScanCodeInfo()==null;
        case INDEX_SCANTYPE:
            return et.getScanType()==null;
        case INDEX_THUMBMEDIAID:
            return et.getThumbMediaId()==null;
        case INDEX_TOUSERNAME:
            return et.getToUserName()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_WXACCOUNTID:
            return et.getWXAccountId()==null;
        case INDEX_WXACCOUNTNAME:
            return et.getWXAccountName()==null;
        case INDEX_WXENTAPPID:
            return et.getWXEntAppId()==null;
        case INDEX_WXENTAPPNAME:
            return et.getWXEntAppName()==null;
        case INDEX_WXMESSAGEID:
            return et.getWXMessageId()==null;
        case INDEX_WXMESSAGENAME:
            return et.getWXMessageName()==null;
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
        return  WXMessageBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(WXMessageBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CNT:
            return et.isCntDirty();
        case INDEX_CONTENT:
            return et.isContentDirty();
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_EVENT:
            return et.isEventDirty();
        case INDEX_EVENTKEY:
            return et.isEventKeyDirty();
        case INDEX_FORMAT:
            return et.isFormatDirty();
        case INDEX_FROMUSERNAME:
            return et.isFromUserNameDirty();
        case INDEX_INCOMETIME:
            return et.isIncomeTimeDirty();
        case INDEX_LOCATION_PREC:
            return et.isLocation_PrecDirty();
        case INDEX_LOCATION_X:
            return et.isLocation_XDirty();
        case INDEX_LOCATION_Y:
            return et.isLocation_YDirty();
        case INDEX_MEDIAID:
            return et.isMediaIdDirty();
        case INDEX_MSGTYPE:
            return et.isMsgTypeDirty();
        case INDEX_PICURL:
            return et.isPicURLDirty();
        case INDEX_RESERVER:
            return et.isReserverDirty();
        case INDEX_RESERVER2:
            return et.isReserver2Dirty();
        case INDEX_RESERVER3:
            return et.isReserver3Dirty();
        case INDEX_RESERVER4:
            return et.isReserver4Dirty();
        case INDEX_RESPARTICLECOUNT:
            return et.isRespArticleCountDirty();
        case INDEX_RESPARTICLES:
            return et.isRespArticlesDirty();
        case INDEX_RESPDESC:
            return et.isRespDescDirty();
        case INDEX_RESPMEDIAID:
            return et.isRespMediaIdDirty();
        case INDEX_RESPMSGTYPE:
            return et.isRespMsgTypeDirty();
        case INDEX_RESPTIME:
            return et.isRespTimeDirty();
        case INDEX_RESPTITLE:
            return et.isRespTitleDirty();
        case INDEX_RESULT:
            return et.isResultDirty();
        case INDEX_SCALE:
            return et.isScaleDirty();
        case INDEX_SCANCODEINFO:
            return et.isScanCodeInfoDirty();
        case INDEX_SCANTYPE:
            return et.isScanTypeDirty();
        case INDEX_THUMBMEDIAID:
            return et.isThumbMediaIdDirty();
        case INDEX_TOUSERNAME:
            return et.isToUserNameDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_WXACCOUNTID:
            return et.isWXAccountIdDirty();
        case INDEX_WXACCOUNTNAME:
            return et.isWXAccountNameDirty();
        case INDEX_WXENTAPPID:
            return et.isWXEntAppIdDirty();
        case INDEX_WXENTAPPNAME:
            return et.isWXEntAppNameDirty();
        case INDEX_WXMESSAGEID:
            return et.isWXMessageIdDirty();
        case INDEX_WXMESSAGENAME:
            return et.isWXMessageNameDirty();
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
    private static  void fillJSONObject(WXMessageBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCnt()!=null) {
            JSONObjectHelper.put(json,"cnt",getJSONValue(et.getCnt()),false);
        }
        if(bIncEmpty||et.getContent()!=null) {
            JSONObjectHelper.put(json,"content",getJSONValue(et.getContent()),false);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getEvent()!=null) {
            JSONObjectHelper.put(json,"event",getJSONValue(et.getEvent()),false);
        }
        if(bIncEmpty||et.getEventKey()!=null) {
            JSONObjectHelper.put(json,"eventkey",getJSONValue(et.getEventKey()),false);
        }
        if(bIncEmpty||et.getFormat()!=null) {
            JSONObjectHelper.put(json,"format",getJSONValue(et.getFormat()),false);
        }
        if(bIncEmpty||et.getFromUserName()!=null) {
            JSONObjectHelper.put(json,"fromusername",getJSONValue(et.getFromUserName()),false);
        }
        if(bIncEmpty||et.getIncomeTime()!=null) {
            JSONObjectHelper.put(json,"incometime",getJSONValue(et.getIncomeTime()),false);
        }
        if(bIncEmpty||et.getLocation_Prec()!=null) {
            JSONObjectHelper.put(json,"location_prec",getJSONValue(et.getLocation_Prec()),false);
        }
        if(bIncEmpty||et.getLocation_X()!=null) {
            JSONObjectHelper.put(json,"location_x",getJSONValue(et.getLocation_X()),false);
        }
        if(bIncEmpty||et.getLocation_Y()!=null) {
            JSONObjectHelper.put(json,"location_y",getJSONValue(et.getLocation_Y()),false);
        }
        if(bIncEmpty||et.getMediaId()!=null) {
            JSONObjectHelper.put(json,"mediaid",getJSONValue(et.getMediaId()),false);
        }
        if(bIncEmpty||et.getMsgType()!=null) {
            JSONObjectHelper.put(json,"msgtype",getJSONValue(et.getMsgType()),false);
        }
        if(bIncEmpty||et.getPicURL()!=null) {
            JSONObjectHelper.put(json,"picurl",getJSONValue(et.getPicURL()),false);
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
        if(bIncEmpty||et.getRespArticleCount()!=null) {
            JSONObjectHelper.put(json,"resparticlecount",getJSONValue(et.getRespArticleCount()),false);
        }
        if(bIncEmpty||et.getRespArticles()!=null) {
            JSONObjectHelper.put(json,"resparticles",getJSONValue(et.getRespArticles()),false);
        }
        if(bIncEmpty||et.getRespDesc()!=null) {
            JSONObjectHelper.put(json,"respdesc",getJSONValue(et.getRespDesc()),false);
        }
        if(bIncEmpty||et.getRespMediaId()!=null) {
            JSONObjectHelper.put(json,"respmediaid",getJSONValue(et.getRespMediaId()),false);
        }
        if(bIncEmpty||et.getRespMsgType()!=null) {
            JSONObjectHelper.put(json,"respmsgtype",getJSONValue(et.getRespMsgType()),false);
        }
        if(bIncEmpty||et.getRespTime()!=null) {
            JSONObjectHelper.put(json,"resptime",getJSONValue(et.getRespTime()),false);
        }
        if(bIncEmpty||et.getRespTitle()!=null) {
            JSONObjectHelper.put(json,"resptitle",getJSONValue(et.getRespTitle()),false);
        }
        if(bIncEmpty||et.getResult()!=null) {
            JSONObjectHelper.put(json,"result",getJSONValue(et.getResult()),false);
        }
        if(bIncEmpty||et.getScale()!=null) {
            JSONObjectHelper.put(json,"scale",getJSONValue(et.getScale()),false);
        }
        if(bIncEmpty||et.getScanCodeInfo()!=null) {
            JSONObjectHelper.put(json,"scancodeinfo",getJSONValue(et.getScanCodeInfo()),false);
        }
        if(bIncEmpty||et.getScanType()!=null) {
            JSONObjectHelper.put(json,"scantype",getJSONValue(et.getScanType()),false);
        }
        if(bIncEmpty||et.getThumbMediaId()!=null) {
            JSONObjectHelper.put(json,"thumbmediaid",getJSONValue(et.getThumbMediaId()),false);
        }
        if(bIncEmpty||et.getToUserName()!=null) {
            JSONObjectHelper.put(json,"tousername",getJSONValue(et.getToUserName()),false);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
        }
        if(bIncEmpty||et.getWXAccountId()!=null) {
            JSONObjectHelper.put(json,"wxaccountid",getJSONValue(et.getWXAccountId()),false);
        }
        if(bIncEmpty||et.getWXAccountName()!=null) {
            JSONObjectHelper.put(json,"wxaccountname",getJSONValue(et.getWXAccountName()),false);
        }
        if(bIncEmpty||et.getWXEntAppId()!=null) {
            JSONObjectHelper.put(json,"wxentappid",getJSONValue(et.getWXEntAppId()),false);
        }
        if(bIncEmpty||et.getWXEntAppName()!=null) {
            JSONObjectHelper.put(json,"wxentappname",getJSONValue(et.getWXEntAppName()),false);
        }
        if(bIncEmpty||et.getWXMessageId()!=null) {
            JSONObjectHelper.put(json,"wxmessageid",getJSONValue(et.getWXMessageId()),false);
        }
        if(bIncEmpty||et.getWXMessageName()!=null) {
            JSONObjectHelper.put(json,"wxmessagename",getJSONValue(et.getWXMessageName()),false);
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
    private static void fillXmlNode(WXMessageBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCnt()!=null) {
            Object obj = et.getCnt();
            node.setAttribute("CNT",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getContent()!=null) {
            Object obj = et.getContent();
            node.setAttribute("CONTENT",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getEvent()!=null) {
            Object obj = et.getEvent();
            node.setAttribute("EVENT",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getEventKey()!=null) {
            Object obj = et.getEventKey();
            node.setAttribute("EVENTKEY",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getFormat()!=null) {
            Object obj = et.getFormat();
            node.setAttribute("FORMAT",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getFromUserName()!=null) {
            Object obj = et.getFromUserName();
            node.setAttribute("FROMUSERNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getIncomeTime()!=null) {
            Object obj = et.getIncomeTime();
            node.setAttribute("INCOMETIME",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getLocation_Prec()!=null) {
            Object obj = et.getLocation_Prec();
            node.setAttribute("LOCATION_PREC",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getLocation_X()!=null) {
            Object obj = et.getLocation_X();
            node.setAttribute("LOCATION_X",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getLocation_Y()!=null) {
            Object obj = et.getLocation_Y();
            node.setAttribute("LOCATION_Y",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMediaId()!=null) {
            Object obj = et.getMediaId();
            node.setAttribute("MEDIAID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMsgType()!=null) {
            Object obj = et.getMsgType();
            node.setAttribute("MSGTYPE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getPicURL()!=null) {
            Object obj = et.getPicURL();
            node.setAttribute("PICURL",(obj==null)?"":(String)obj);
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
        if(bIncEmpty||et.getRespArticleCount()!=null) {
            Object obj = et.getRespArticleCount();
            node.setAttribute("RESPARTICLECOUNT",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getRespArticles()!=null) {
            Object obj = et.getRespArticles();
            node.setAttribute("RESPARTICLES",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getRespDesc()!=null) {
            Object obj = et.getRespDesc();
            node.setAttribute("RESPDESC",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getRespMediaId()!=null) {
            Object obj = et.getRespMediaId();
            node.setAttribute("RESPMEDIAID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getRespMsgType()!=null) {
            Object obj = et.getRespMsgType();
            node.setAttribute("RESPMSGTYPE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getRespTime()!=null) {
            Object obj = et.getRespTime();
            node.setAttribute("RESPTIME",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getRespTitle()!=null) {
            Object obj = et.getRespTitle();
            node.setAttribute("RESPTITLE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getResult()!=null) {
            Object obj = et.getResult();
            node.setAttribute("RESULT",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getScale()!=null) {
            Object obj = et.getScale();
            node.setAttribute("SCALE",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getScanCodeInfo()!=null) {
            Object obj = et.getScanCodeInfo();
            node.setAttribute("SCANCODEINFO",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getScanType()!=null) {
            Object obj = et.getScanType();
            node.setAttribute("SCANTYPE",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getThumbMediaId()!=null) {
            Object obj = et.getThumbMediaId();
            node.setAttribute("THUMBMEDIAID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getToUserName()!=null) {
            Object obj = et.getToUserName();
            node.setAttribute("TOUSERNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWXAccountId()!=null) {
            Object obj = et.getWXAccountId();
            node.setAttribute("WXACCOUNTID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWXAccountName()!=null) {
            Object obj = et.getWXAccountName();
            node.setAttribute("WXACCOUNTNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWXEntAppId()!=null) {
            Object obj = et.getWXEntAppId();
            node.setAttribute("WXENTAPPID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWXEntAppName()!=null) {
            Object obj = et.getWXEntAppName();
            node.setAttribute("WXENTAPPNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWXMessageId()!=null) {
            Object obj = et.getWXMessageId();
            node.setAttribute("WXMESSAGEID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWXMessageName()!=null) {
            Object obj = et.getWXMessageName();
            node.setAttribute("WXMESSAGENAME",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WXMessageBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(WXMessageBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCntDirty() && (bIncEmpty||et.getCnt()!=null)) {
            dst.set(FIELD_CNT,et.getCnt());
        }
        if(et.isContentDirty() && (bIncEmpty||et.getContent()!=null)) {
            dst.set(FIELD_CONTENT,et.getContent());
        }
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isEventDirty() && (bIncEmpty||et.getEvent()!=null)) {
            dst.set(FIELD_EVENT,et.getEvent());
        }
        if(et.isEventKeyDirty() && (bIncEmpty||et.getEventKey()!=null)) {
            dst.set(FIELD_EVENTKEY,et.getEventKey());
        }
        if(et.isFormatDirty() && (bIncEmpty||et.getFormat()!=null)) {
            dst.set(FIELD_FORMAT,et.getFormat());
        }
        if(et.isFromUserNameDirty() && (bIncEmpty||et.getFromUserName()!=null)) {
            dst.set(FIELD_FROMUSERNAME,et.getFromUserName());
        }
        if(et.isIncomeTimeDirty() && (bIncEmpty||et.getIncomeTime()!=null)) {
            dst.set(FIELD_INCOMETIME,et.getIncomeTime());
        }
        if(et.isLocation_PrecDirty() && (bIncEmpty||et.getLocation_Prec()!=null)) {
            dst.set(FIELD_LOCATION_PREC,et.getLocation_Prec());
        }
        if(et.isLocation_XDirty() && (bIncEmpty||et.getLocation_X()!=null)) {
            dst.set(FIELD_LOCATION_X,et.getLocation_X());
        }
        if(et.isLocation_YDirty() && (bIncEmpty||et.getLocation_Y()!=null)) {
            dst.set(FIELD_LOCATION_Y,et.getLocation_Y());
        }
        if(et.isMediaIdDirty() && (bIncEmpty||et.getMediaId()!=null)) {
            dst.set(FIELD_MEDIAID,et.getMediaId());
        }
        if(et.isMsgTypeDirty() && (bIncEmpty||et.getMsgType()!=null)) {
            dst.set(FIELD_MSGTYPE,et.getMsgType());
        }
        if(et.isPicURLDirty() && (bIncEmpty||et.getPicURL()!=null)) {
            dst.set(FIELD_PICURL,et.getPicURL());
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
        if(et.isRespArticleCountDirty() && (bIncEmpty||et.getRespArticleCount()!=null)) {
            dst.set(FIELD_RESPARTICLECOUNT,et.getRespArticleCount());
        }
        if(et.isRespArticlesDirty() && (bIncEmpty||et.getRespArticles()!=null)) {
            dst.set(FIELD_RESPARTICLES,et.getRespArticles());
        }
        if(et.isRespDescDirty() && (bIncEmpty||et.getRespDesc()!=null)) {
            dst.set(FIELD_RESPDESC,et.getRespDesc());
        }
        if(et.isRespMediaIdDirty() && (bIncEmpty||et.getRespMediaId()!=null)) {
            dst.set(FIELD_RESPMEDIAID,et.getRespMediaId());
        }
        if(et.isRespMsgTypeDirty() && (bIncEmpty||et.getRespMsgType()!=null)) {
            dst.set(FIELD_RESPMSGTYPE,et.getRespMsgType());
        }
        if(et.isRespTimeDirty() && (bIncEmpty||et.getRespTime()!=null)) {
            dst.set(FIELD_RESPTIME,et.getRespTime());
        }
        if(et.isRespTitleDirty() && (bIncEmpty||et.getRespTitle()!=null)) {
            dst.set(FIELD_RESPTITLE,et.getRespTitle());
        }
        if(et.isResultDirty() && (bIncEmpty||et.getResult()!=null)) {
            dst.set(FIELD_RESULT,et.getResult());
        }
        if(et.isScaleDirty() && (bIncEmpty||et.getScale()!=null)) {
            dst.set(FIELD_SCALE,et.getScale());
        }
        if(et.isScanCodeInfoDirty() && (bIncEmpty||et.getScanCodeInfo()!=null)) {
            dst.set(FIELD_SCANCODEINFO,et.getScanCodeInfo());
        }
        if(et.isScanTypeDirty() && (bIncEmpty||et.getScanType()!=null)) {
            dst.set(FIELD_SCANTYPE,et.getScanType());
        }
        if(et.isThumbMediaIdDirty() && (bIncEmpty||et.getThumbMediaId()!=null)) {
            dst.set(FIELD_THUMBMEDIAID,et.getThumbMediaId());
        }
        if(et.isToUserNameDirty() && (bIncEmpty||et.getToUserName()!=null)) {
            dst.set(FIELD_TOUSERNAME,et.getToUserName());
        }
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
        }
        if(et.isWXAccountIdDirty() && (bIncEmpty||et.getWXAccountId()!=null)) {
            dst.set(FIELD_WXACCOUNTID,et.getWXAccountId());
        }
        if(et.isWXAccountNameDirty() && (bIncEmpty||et.getWXAccountName()!=null)) {
            dst.set(FIELD_WXACCOUNTNAME,et.getWXAccountName());
        }
        if(et.isWXEntAppIdDirty() && (bIncEmpty||et.getWXEntAppId()!=null)) {
            dst.set(FIELD_WXENTAPPID,et.getWXEntAppId());
        }
        if(et.isWXEntAppNameDirty() && (bIncEmpty||et.getWXEntAppName()!=null)) {
            dst.set(FIELD_WXENTAPPNAME,et.getWXEntAppName());
        }
        if(et.isWXMessageIdDirty() && (bIncEmpty||et.getWXMessageId()!=null)) {
            dst.set(FIELD_WXMESSAGEID,et.getWXMessageId());
        }
        if(et.isWXMessageNameDirty() && (bIncEmpty||et.getWXMessageName()!=null)) {
            dst.set(FIELD_WXMESSAGENAME,et.getWXMessageName());
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
        return  WXMessageBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(WXMessageBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CNT:
            et.resetCnt();
            return true;
        case INDEX_CONTENT:
            et.resetContent();
            return true;
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_EVENT:
            et.resetEvent();
            return true;
        case INDEX_EVENTKEY:
            et.resetEventKey();
            return true;
        case INDEX_FORMAT:
            et.resetFormat();
            return true;
        case INDEX_FROMUSERNAME:
            et.resetFromUserName();
            return true;
        case INDEX_INCOMETIME:
            et.resetIncomeTime();
            return true;
        case INDEX_LOCATION_PREC:
            et.resetLocation_Prec();
            return true;
        case INDEX_LOCATION_X:
            et.resetLocation_X();
            return true;
        case INDEX_LOCATION_Y:
            et.resetLocation_Y();
            return true;
        case INDEX_MEDIAID:
            et.resetMediaId();
            return true;
        case INDEX_MSGTYPE:
            et.resetMsgType();
            return true;
        case INDEX_PICURL:
            et.resetPicURL();
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
        case INDEX_RESPARTICLECOUNT:
            et.resetRespArticleCount();
            return true;
        case INDEX_RESPARTICLES:
            et.resetRespArticles();
            return true;
        case INDEX_RESPDESC:
            et.resetRespDesc();
            return true;
        case INDEX_RESPMEDIAID:
            et.resetRespMediaId();
            return true;
        case INDEX_RESPMSGTYPE:
            et.resetRespMsgType();
            return true;
        case INDEX_RESPTIME:
            et.resetRespTime();
            return true;
        case INDEX_RESPTITLE:
            et.resetRespTitle();
            return true;
        case INDEX_RESULT:
            et.resetResult();
            return true;
        case INDEX_SCALE:
            et.resetScale();
            return true;
        case INDEX_SCANCODEINFO:
            et.resetScanCodeInfo();
            return true;
        case INDEX_SCANTYPE:
            et.resetScanType();
            return true;
        case INDEX_THUMBMEDIAID:
            et.resetThumbMediaId();
            return true;
        case INDEX_TOUSERNAME:
            et.resetToUserName();
            return true;
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        case INDEX_WXACCOUNTID:
            et.resetWXAccountId();
            return true;
        case INDEX_WXACCOUNTNAME:
            et.resetWXAccountName();
            return true;
        case INDEX_WXENTAPPID:
            et.resetWXEntAppId();
            return true;
        case INDEX_WXENTAPPNAME:
            et.resetWXEntAppName();
            return true;
        case INDEX_WXMESSAGEID:
            et.resetWXMessageId();
            return true;
        case INDEX_WXMESSAGENAME:
            et.resetWXMessageName();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }


    private Integer objWXAccountLock = new Integer(1);
    private net.ibizsys.psrt.srv.wx.entity.WXAccount wxaccount = null;
    /**
    * 获取父数据 微信公众号
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.wx.entity.WXAccount getWXAccount() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWXAccount();
        }

        if(this.getWXAccountId()==null)
            return null;
        synchronized(this.objWXAccountLock) {
            if(this.wxaccount!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getWXAccountId(),wxaccount.getWXAccountId())!=0) {
                    this.wxaccount = null;
                }
            }


            if(this.wxaccount==null) {
                net.ibizsys.psrt.srv.wx.entity.WXAccount wxaccount = new net.ibizsys.psrt.srv.wx.entity.WXAccount();
                wxaccount.setWXAccountId(this.getWXAccountId());
                net.ibizsys.psrt.srv.wx.service.WXAccountService service = (net.ibizsys.psrt.srv.wx.service.WXAccountService)ServiceGlobal.getService(net.ibizsys.psrt.srv.wx.service.WXAccountService.class,this.getSessionFactory());
                service.autoGet(wxaccount);
                this.wxaccount = wxaccount;
            }
            return this.wxaccount;
        }
    }

    private Integer objWXEntAppLock = new Integer(1);
    private net.ibizsys.psrt.srv.wx.entity.WXEntApp wxentapp = null;
    /**
    * 获取父数据 微信企业应用
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.wx.entity.WXEntApp getWXEntApp() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWXEntApp();
        }

        if(this.getWXEntAppId()==null)
            return null;
        synchronized(this.objWXEntAppLock) {
            if(this.wxentapp!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getWXEntAppId(),wxentapp.getWXEntAppId())!=0) {
                    this.wxentapp = null;
                }
            }


            if(this.wxentapp==null) {
                net.ibizsys.psrt.srv.wx.entity.WXEntApp wxentapp = new net.ibizsys.psrt.srv.wx.entity.WXEntApp();
                wxentapp.setWXEntAppId(this.getWXEntAppId());
                net.ibizsys.psrt.srv.wx.service.WXEntAppService service = (net.ibizsys.psrt.srv.wx.service.WXEntAppService)ServiceGlobal.getService(net.ibizsys.psrt.srv.wx.service.WXEntAppService.class,this.getSessionFactory());
                service.autoGet(wxentapp);
                this.wxentapp = wxentapp;
            }
            return this.wxentapp;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private WXMessageBase getProxyEntity() {
        return this.proxyWXMessageBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWXMessageBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof WXMessageBase) {
            this.proxyWXMessageBase = (WXMessageBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.wx.service.WXMessageService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}