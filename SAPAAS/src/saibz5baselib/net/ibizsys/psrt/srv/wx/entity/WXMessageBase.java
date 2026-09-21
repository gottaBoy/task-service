/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.wx.entity;

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
import net.ibizsys.psrt.srv.wx.entity.WXAccount;
import net.ibizsys.psrt.srv.wx.entity.WXEntApp;
import net.ibizsys.psrt.srv.wx.service.WXAccountService;
import net.ibizsys.psrt.srv.wx.service.WXEntAppService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WXMessageBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WXMessageBase.class);
    public static final String FIELD_CNT = "CNT";
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EVENT = "EVENT";
    public static final String FIELD_EVENTKEY = "EVENTKEY";
    public static final String FIELD_FORMAT = "FORMAT";
    public static final String FIELD_FROMUSERNAME = "FROMUSERNAME";
    public static final String FIELD_INCOMETIME = "INCOMETIME";
    public static final String FIELD_LOCATION_PREC = "LOCATION_PREC";
    public static final String FIELD_LOCATION_X = "LOCATION_X";
    public static final String FIELD_LOCATION_Y = "LOCATION_Y";
    public static final String FIELD_MEDIAID = "MEDIAID";
    public static final String FIELD_MSGTYPE = "MSGTYPE";
    public static final String FIELD_PICURL = "PICURL";
    public static final String FIELD_RESERVER = "RESERVER";
    public static final String FIELD_RESERVER2 = "RESERVER2";
    public static final String FIELD_RESERVER3 = "RESERVER3";
    public static final String FIELD_RESERVER4 = "RESERVER4";
    public static final String FIELD_RESPARTICLECOUNT = "RESPARTICLECOUNT";
    public static final String FIELD_RESPARTICLES = "RESPARTICLES";
    public static final String FIELD_RESPDESC = "RESPDESC";
    public static final String FIELD_RESPMEDIAID = "RESPMEDIAID";
    public static final String FIELD_RESPMSGTYPE = "RESPMSGTYPE";
    public static final String FIELD_RESPTIME = "RESPTIME";
    public static final String FIELD_RESPTITLE = "RESPTITLE";
    public static final String FIELD_RESULT = "RESULT";
    public static final String FIELD_SCALE = "SCALE";
    public static final String FIELD_SCANCODEINFO = "SCANCODEINFO";
    public static final String FIELD_SCANTYPE = "SCANTYPE";
    public static final String FIELD_THUMBMEDIAID = "THUMBMEDIAID";
    public static final String FIELD_TOUSERNAME = "TOUSERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WXACCOUNTID = "WXACCOUNTID";
    public static final String FIELD_WXACCOUNTNAME = "WXACCOUNTNAME";
    public static final String FIELD_WXENTAPPID = "WXENTAPPID";
    public static final String FIELD_WXENTAPPNAME = "WXENTAPPNAME";
    public static final String FIELD_WXMESSAGEID = "WXMESSAGEID";
    public static final String FIELD_WXMESSAGENAME = "WXMESSAGENAME";
    private static final int INDEX_CNT = 0;
    private static final int INDEX_CONTENT = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_EVENT = 4;
    private static final int INDEX_EVENTKEY = 5;
    private static final int INDEX_FORMAT = 6;
    private static final int INDEX_FROMUSERNAME = 7;
    private static final int INDEX_INCOMETIME = 8;
    private static final int INDEX_LOCATION_PREC = 9;
    private static final int INDEX_LOCATION_X = 10;
    private static final int INDEX_LOCATION_Y = 11;
    private static final int INDEX_MEDIAID = 12;
    private static final int INDEX_MSGTYPE = 13;
    private static final int INDEX_PICURL = 14;
    private static final int INDEX_RESERVER = 15;
    private static final int INDEX_RESERVER2 = 16;
    private static final int INDEX_RESERVER3 = 17;
    private static final int INDEX_RESERVER4 = 18;
    private static final int INDEX_RESPARTICLECOUNT = 19;
    private static final int INDEX_RESPARTICLES = 20;
    private static final int INDEX_RESPDESC = 21;
    private static final int INDEX_RESPMEDIAID = 22;
    private static final int INDEX_RESPMSGTYPE = 23;
    private static final int INDEX_RESPTIME = 24;
    private static final int INDEX_RESPTITLE = 25;
    private static final int INDEX_RESULT = 26;
    private static final int INDEX_SCALE = 27;
    private static final int INDEX_SCANCODEINFO = 28;
    private static final int INDEX_SCANTYPE = 29;
    private static final int INDEX_THUMBMEDIAID = 30;
    private static final int INDEX_TOUSERNAME = 31;
    private static final int INDEX_UPDATEDATE = 32;
    private static final int INDEX_UPDATEMAN = 33;
    private static final int INDEX_WXACCOUNTID = 34;
    private static final int INDEX_WXACCOUNTNAME = 35;
    private static final int INDEX_WXENTAPPID = 36;
    private static final int INDEX_WXENTAPPNAME = 37;
    private static final int INDEX_WXMESSAGEID = 38;
    private static final int INDEX_WXMESSAGENAME = 39;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private WXMessageBase proxyWXMessageBase = null;
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
    private Integer objWXAccountLock = new Integer(1);
    private WXAccount wxaccount = null;
    private Integer objWXEntAppLock = new Integer(1);
    private WXEntApp wxentapp = null;

    static {
        fieldIndexMap.put(FIELD_CNT, 0);
        fieldIndexMap.put(FIELD_CONTENT, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_EVENT, 4);
        fieldIndexMap.put(FIELD_EVENTKEY, 5);
        fieldIndexMap.put(FIELD_FORMAT, 6);
        fieldIndexMap.put(FIELD_FROMUSERNAME, 7);
        fieldIndexMap.put(FIELD_INCOMETIME, 8);
        fieldIndexMap.put(FIELD_LOCATION_PREC, 9);
        fieldIndexMap.put(FIELD_LOCATION_X, 10);
        fieldIndexMap.put(FIELD_LOCATION_Y, 11);
        fieldIndexMap.put(FIELD_MEDIAID, 12);
        fieldIndexMap.put(FIELD_MSGTYPE, 13);
        fieldIndexMap.put(FIELD_PICURL, 14);
        fieldIndexMap.put(FIELD_RESERVER, 15);
        fieldIndexMap.put(FIELD_RESERVER2, 16);
        fieldIndexMap.put(FIELD_RESERVER3, 17);
        fieldIndexMap.put(FIELD_RESERVER4, 18);
        fieldIndexMap.put(FIELD_RESPARTICLECOUNT, 19);
        fieldIndexMap.put(FIELD_RESPARTICLES, 20);
        fieldIndexMap.put(FIELD_RESPDESC, 21);
        fieldIndexMap.put(FIELD_RESPMEDIAID, 22);
        fieldIndexMap.put(FIELD_RESPMSGTYPE, 23);
        fieldIndexMap.put(FIELD_RESPTIME, 24);
        fieldIndexMap.put(FIELD_RESPTITLE, 25);
        fieldIndexMap.put(FIELD_RESULT, 26);
        fieldIndexMap.put(FIELD_SCALE, 27);
        fieldIndexMap.put(FIELD_SCANCODEINFO, 28);
        fieldIndexMap.put(FIELD_SCANTYPE, 29);
        fieldIndexMap.put(FIELD_THUMBMEDIAID, 30);
        fieldIndexMap.put(FIELD_TOUSERNAME, 31);
        fieldIndexMap.put(FIELD_UPDATEDATE, 32);
        fieldIndexMap.put(FIELD_UPDATEMAN, 33);
        fieldIndexMap.put(FIELD_WXACCOUNTID, 34);
        fieldIndexMap.put(FIELD_WXACCOUNTNAME, 35);
        fieldIndexMap.put(FIELD_WXENTAPPID, 36);
        fieldIndexMap.put(FIELD_WXENTAPPNAME, 37);
        fieldIndexMap.put(FIELD_WXMESSAGEID, 38);
        fieldIndexMap.put(FIELD_WXMESSAGENAME, 39);
    }

    public void setCnt(Integer cnt) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCnt(cnt);
            return;
        }
        this.cnt = cnt;
        this.cntDirtyFlag = true;
    }

    public Integer getCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCnt();
        }
        return this.cnt;
    }

    public boolean isCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCntDirty();
        }
        return this.cntDirtyFlag;
    }

    public void resetCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCnt();
            return;
        }
        this.cntDirtyFlag = false;
        this.cnt = null;
    }

    public void setContent(String content) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContent(content);
            return;
        }
        if (content != null && (content = StringHelper.trimRight(content)).length() == 0) {
            content = null;
        }
        this.content = content;
        this.contentDirtyFlag = true;
    }

    public String getContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContent();
        }
        return this.content;
    }

    public boolean isContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentDirty();
        }
        return this.contentDirtyFlag;
    }

    public void resetContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContent();
            return;
        }
        this.contentDirtyFlag = false;
        this.content = null;
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

    public void setEvent(String event) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEvent(event);
            return;
        }
        if (event != null && (event = StringHelper.trimRight(event)).length() == 0) {
            event = null;
        }
        this.event = event;
        this.eventDirtyFlag = true;
    }

    public String getEvent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEvent();
        }
        return this.event;
    }

    public boolean isEventDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEventDirty();
        }
        return this.eventDirtyFlag;
    }

    public void resetEvent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEvent();
            return;
        }
        this.eventDirtyFlag = false;
        this.event = null;
    }

    public void setEventKey(String eventkey) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEventKey(eventkey);
            return;
        }
        if (eventkey != null && (eventkey = StringHelper.trimRight(eventkey)).length() == 0) {
            eventkey = null;
        }
        this.eventkey = eventkey;
        this.eventkeyDirtyFlag = true;
    }

    public String getEventKey() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEventKey();
        }
        return this.eventkey;
    }

    public boolean isEventKeyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEventKeyDirty();
        }
        return this.eventkeyDirtyFlag;
    }

    public void resetEventKey() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEventKey();
            return;
        }
        this.eventkeyDirtyFlag = false;
        this.eventkey = null;
    }

    public void setFormat(String format) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFormat(format);
            return;
        }
        if (format != null && (format = StringHelper.trimRight(format)).length() == 0) {
            format = null;
        }
        this.format = format;
        this.formatDirtyFlag = true;
    }

    public String getFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormat();
        }
        return this.format;
    }

    public boolean isFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFormatDirty();
        }
        return this.formatDirtyFlag;
    }

    public void resetFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFormat();
            return;
        }
        this.formatDirtyFlag = false;
        this.format = null;
    }

    public void setFromUserName(String fromusername) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFromUserName(fromusername);
            return;
        }
        if (fromusername != null && (fromusername = StringHelper.trimRight(fromusername)).length() == 0) {
            fromusername = null;
        }
        this.fromusername = fromusername;
        this.fromusernameDirtyFlag = true;
    }

    public String getFromUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFromUserName();
        }
        return this.fromusername;
    }

    public boolean isFromUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFromUserNameDirty();
        }
        return this.fromusernameDirtyFlag;
    }

    public void resetFromUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFromUserName();
            return;
        }
        this.fromusernameDirtyFlag = false;
        this.fromusername = null;
    }

    public void setIncomeTime(Timestamp incometime) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIncomeTime(incometime);
            return;
        }
        this.incometime = incometime;
        this.incometimeDirtyFlag = true;
    }

    public Timestamp getIncomeTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIncomeTime();
        }
        return this.incometime;
    }

    public boolean isIncomeTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIncomeTimeDirty();
        }
        return this.incometimeDirtyFlag;
    }

    public void resetIncomeTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIncomeTime();
            return;
        }
        this.incometimeDirtyFlag = false;
        this.incometime = null;
    }

    public void setLocation_Prec(Double location_prec) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLocation_Prec(location_prec);
            return;
        }
        this.location_prec = location_prec;
        this.location_precDirtyFlag = true;
    }

    public Double getLocation_Prec() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLocation_Prec();
        }
        return this.location_prec;
    }

    public boolean isLocation_PrecDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLocation_PrecDirty();
        }
        return this.location_precDirtyFlag;
    }

    public void resetLocation_Prec() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLocation_Prec();
            return;
        }
        this.location_precDirtyFlag = false;
        this.location_prec = null;
    }

    public void setLocation_X(String location_x) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLocation_X(location_x);
            return;
        }
        if (location_x != null && (location_x = StringHelper.trimRight(location_x)).length() == 0) {
            location_x = null;
        }
        this.location_x = location_x;
        this.location_xDirtyFlag = true;
    }

    public String getLocation_X() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLocation_X();
        }
        return this.location_x;
    }

    public boolean isLocation_XDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLocation_XDirty();
        }
        return this.location_xDirtyFlag;
    }

    public void resetLocation_X() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLocation_X();
            return;
        }
        this.location_xDirtyFlag = false;
        this.location_x = null;
    }

    public void setLocation_Y(String location_y) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLocation_Y(location_y);
            return;
        }
        if (location_y != null && (location_y = StringHelper.trimRight(location_y)).length() == 0) {
            location_y = null;
        }
        this.location_y = location_y;
        this.location_yDirtyFlag = true;
    }

    public String getLocation_Y() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLocation_Y();
        }
        return this.location_y;
    }

    public boolean isLocation_YDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLocation_YDirty();
        }
        return this.location_yDirtyFlag;
    }

    public void resetLocation_Y() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLocation_Y();
            return;
        }
        this.location_yDirtyFlag = false;
        this.location_y = null;
    }

    public void setMediaId(String mediaid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMediaId(mediaid);
            return;
        }
        if (mediaid != null && (mediaid = StringHelper.trimRight(mediaid)).length() == 0) {
            mediaid = null;
        }
        this.mediaid = mediaid;
        this.mediaidDirtyFlag = true;
    }

    public String getMediaId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMediaId();
        }
        return this.mediaid;
    }

    public boolean isMediaIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMediaIdDirty();
        }
        return this.mediaidDirtyFlag;
    }

    public void resetMediaId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMediaId();
            return;
        }
        this.mediaidDirtyFlag = false;
        this.mediaid = null;
    }

    public void setMsgType(String msgtype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgType(msgtype);
            return;
        }
        if (msgtype != null && (msgtype = StringHelper.trimRight(msgtype)).length() == 0) {
            msgtype = null;
        }
        this.msgtype = msgtype;
        this.msgtypeDirtyFlag = true;
    }

    public String getMsgType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgType();
        }
        return this.msgtype;
    }

    public boolean isMsgTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgTypeDirty();
        }
        return this.msgtypeDirtyFlag;
    }

    public void resetMsgType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgType();
            return;
        }
        this.msgtypeDirtyFlag = false;
        this.msgtype = null;
    }

    public void setPicURL(String picurl) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPicURL(picurl);
            return;
        }
        if (picurl != null && (picurl = StringHelper.trimRight(picurl)).length() == 0) {
            picurl = null;
        }
        this.picurl = picurl;
        this.picurlDirtyFlag = true;
    }

    public String getPicURL() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPicURL();
        }
        return this.picurl;
    }

    public boolean isPicURLDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPicURLDirty();
        }
        return this.picurlDirtyFlag;
    }

    public void resetPicURL() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPicURL();
            return;
        }
        this.picurlDirtyFlag = false;
        this.picurl = null;
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

    public void setRespArticleCount(Integer resparticlecount) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRespArticleCount(resparticlecount);
            return;
        }
        this.resparticlecount = resparticlecount;
        this.resparticlecountDirtyFlag = true;
    }

    public Integer getRespArticleCount() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRespArticleCount();
        }
        return this.resparticlecount;
    }

    public boolean isRespArticleCountDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRespArticleCountDirty();
        }
        return this.resparticlecountDirtyFlag;
    }

    public void resetRespArticleCount() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRespArticleCount();
            return;
        }
        this.resparticlecountDirtyFlag = false;
        this.resparticlecount = null;
    }

    public void setRespArticles(String resparticles) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRespArticles(resparticles);
            return;
        }
        if (resparticles != null && (resparticles = StringHelper.trimRight(resparticles)).length() == 0) {
            resparticles = null;
        }
        this.resparticles = resparticles;
        this.resparticlesDirtyFlag = true;
    }

    public String getRespArticles() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRespArticles();
        }
        return this.resparticles;
    }

    public boolean isRespArticlesDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRespArticlesDirty();
        }
        return this.resparticlesDirtyFlag;
    }

    public void resetRespArticles() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRespArticles();
            return;
        }
        this.resparticlesDirtyFlag = false;
        this.resparticles = null;
    }

    public void setRespDesc(String respdesc) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRespDesc(respdesc);
            return;
        }
        if (respdesc != null && (respdesc = StringHelper.trimRight(respdesc)).length() == 0) {
            respdesc = null;
        }
        this.respdesc = respdesc;
        this.respdescDirtyFlag = true;
    }

    public String getRespDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRespDesc();
        }
        return this.respdesc;
    }

    public boolean isRespDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRespDescDirty();
        }
        return this.respdescDirtyFlag;
    }

    public void resetRespDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRespDesc();
            return;
        }
        this.respdescDirtyFlag = false;
        this.respdesc = null;
    }

    public void setRespMediaId(String respmediaid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRespMediaId(respmediaid);
            return;
        }
        if (respmediaid != null && (respmediaid = StringHelper.trimRight(respmediaid)).length() == 0) {
            respmediaid = null;
        }
        this.respmediaid = respmediaid;
        this.respmediaidDirtyFlag = true;
    }

    public String getRespMediaId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRespMediaId();
        }
        return this.respmediaid;
    }

    public boolean isRespMediaIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRespMediaIdDirty();
        }
        return this.respmediaidDirtyFlag;
    }

    public void resetRespMediaId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRespMediaId();
            return;
        }
        this.respmediaidDirtyFlag = false;
        this.respmediaid = null;
    }

    public void setRespMsgType(String respmsgtype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRespMsgType(respmsgtype);
            return;
        }
        if (respmsgtype != null && (respmsgtype = StringHelper.trimRight(respmsgtype)).length() == 0) {
            respmsgtype = null;
        }
        this.respmsgtype = respmsgtype;
        this.respmsgtypeDirtyFlag = true;
    }

    public String getRespMsgType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRespMsgType();
        }
        return this.respmsgtype;
    }

    public boolean isRespMsgTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRespMsgTypeDirty();
        }
        return this.respmsgtypeDirtyFlag;
    }

    public void resetRespMsgType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRespMsgType();
            return;
        }
        this.respmsgtypeDirtyFlag = false;
        this.respmsgtype = null;
    }

    public void setRespTime(Timestamp resptime) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRespTime(resptime);
            return;
        }
        this.resptime = resptime;
        this.resptimeDirtyFlag = true;
    }

    public Timestamp getRespTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRespTime();
        }
        return this.resptime;
    }

    public boolean isRespTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRespTimeDirty();
        }
        return this.resptimeDirtyFlag;
    }

    public void resetRespTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRespTime();
            return;
        }
        this.resptimeDirtyFlag = false;
        this.resptime = null;
    }

    public void setRespTitle(String resptitle) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRespTitle(resptitle);
            return;
        }
        if (resptitle != null && (resptitle = StringHelper.trimRight(resptitle)).length() == 0) {
            resptitle = null;
        }
        this.resptitle = resptitle;
        this.resptitleDirtyFlag = true;
    }

    public String getRespTitle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRespTitle();
        }
        return this.resptitle;
    }

    public boolean isRespTitleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRespTitleDirty();
        }
        return this.resptitleDirtyFlag;
    }

    public void resetRespTitle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRespTitle();
            return;
        }
        this.resptitleDirtyFlag = false;
        this.resptitle = null;
    }

    public void setResult(String result) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResult(result);
            return;
        }
        if (result != null && (result = StringHelper.trimRight(result)).length() == 0) {
            result = null;
        }
        this.result = result;
        this.resultDirtyFlag = true;
    }

    public String getResult() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResult();
        }
        return this.result;
    }

    public boolean isResultDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResultDirty();
        }
        return this.resultDirtyFlag;
    }

    public void resetResult() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResult();
            return;
        }
        this.resultDirtyFlag = false;
        this.result = null;
    }

    public void setScale(Integer scale) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setScale(scale);
            return;
        }
        this.scale = scale;
        this.scaleDirtyFlag = true;
    }

    public Integer getScale() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getScale();
        }
        return this.scale;
    }

    public boolean isScaleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isScaleDirty();
        }
        return this.scaleDirtyFlag;
    }

    public void resetScale() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetScale();
            return;
        }
        this.scaleDirtyFlag = false;
        this.scale = null;
    }

    public void setScanCodeInfo(String scancodeinfo) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setScanCodeInfo(scancodeinfo);
            return;
        }
        if (scancodeinfo != null && (scancodeinfo = StringHelper.trimRight(scancodeinfo)).length() == 0) {
            scancodeinfo = null;
        }
        this.scancodeinfo = scancodeinfo;
        this.scancodeinfoDirtyFlag = true;
    }

    public String getScanCodeInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getScanCodeInfo();
        }
        return this.scancodeinfo;
    }

    public boolean isScanCodeInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isScanCodeInfoDirty();
        }
        return this.scancodeinfoDirtyFlag;
    }

    public void resetScanCodeInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetScanCodeInfo();
            return;
        }
        this.scancodeinfoDirtyFlag = false;
        this.scancodeinfo = null;
    }

    public void setScanType(String scantype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setScanType(scantype);
            return;
        }
        if (scantype != null && (scantype = StringHelper.trimRight(scantype)).length() == 0) {
            scantype = null;
        }
        this.scantype = scantype;
        this.scantypeDirtyFlag = true;
    }

    public String getScanType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getScanType();
        }
        return this.scantype;
    }

    public boolean isScanTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isScanTypeDirty();
        }
        return this.scantypeDirtyFlag;
    }

    public void resetScanType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetScanType();
            return;
        }
        this.scantypeDirtyFlag = false;
        this.scantype = null;
    }

    public void setThumbMediaId(String thumbmediaid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setThumbMediaId(thumbmediaid);
            return;
        }
        if (thumbmediaid != null && (thumbmediaid = StringHelper.trimRight(thumbmediaid)).length() == 0) {
            thumbmediaid = null;
        }
        this.thumbmediaid = thumbmediaid;
        this.thumbmediaidDirtyFlag = true;
    }

    public String getThumbMediaId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getThumbMediaId();
        }
        return this.thumbmediaid;
    }

    public boolean isThumbMediaIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isThumbMediaIdDirty();
        }
        return this.thumbmediaidDirtyFlag;
    }

    public void resetThumbMediaId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetThumbMediaId();
            return;
        }
        this.thumbmediaidDirtyFlag = false;
        this.thumbmediaid = null;
    }

    public void setToUserName(String tousername) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setToUserName(tousername);
            return;
        }
        if (tousername != null && (tousername = StringHelper.trimRight(tousername)).length() == 0) {
            tousername = null;
        }
        this.tousername = tousername;
        this.tousernameDirtyFlag = true;
    }

    public String getToUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getToUserName();
        }
        return this.tousername;
    }

    public boolean isToUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isToUserNameDirty();
        }
        return this.tousernameDirtyFlag;
    }

    public void resetToUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetToUserName();
            return;
        }
        this.tousernameDirtyFlag = false;
        this.tousername = null;
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

    public void setWXAccountId(String wxaccountid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWXAccountId(wxaccountid);
            return;
        }
        if (wxaccountid != null && (wxaccountid = StringHelper.trimRight(wxaccountid)).length() == 0) {
            wxaccountid = null;
        }
        this.wxaccountid = wxaccountid;
        this.wxaccountidDirtyFlag = true;
    }

    public String getWXAccountId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXAccountId();
        }
        return this.wxaccountid;
    }

    public boolean isWXAccountIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWXAccountIdDirty();
        }
        return this.wxaccountidDirtyFlag;
    }

    public void resetWXAccountId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWXAccountId();
            return;
        }
        this.wxaccountidDirtyFlag = false;
        this.wxaccountid = null;
    }

    public void setWXAccountName(String wxaccountname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWXAccountName(wxaccountname);
            return;
        }
        if (wxaccountname != null && (wxaccountname = StringHelper.trimRight(wxaccountname)).length() == 0) {
            wxaccountname = null;
        }
        this.wxaccountname = wxaccountname;
        this.wxaccountnameDirtyFlag = true;
    }

    public String getWXAccountName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXAccountName();
        }
        return this.wxaccountname;
    }

    public boolean isWXAccountNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWXAccountNameDirty();
        }
        return this.wxaccountnameDirtyFlag;
    }

    public void resetWXAccountName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWXAccountName();
            return;
        }
        this.wxaccountnameDirtyFlag = false;
        this.wxaccountname = null;
    }

    public void setWXEntAppId(String wxentappid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWXEntAppId(wxentappid);
            return;
        }
        if (wxentappid != null && (wxentappid = StringHelper.trimRight(wxentappid)).length() == 0) {
            wxentappid = null;
        }
        this.wxentappid = wxentappid;
        this.wxentappidDirtyFlag = true;
    }

    public String getWXEntAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXEntAppId();
        }
        return this.wxentappid;
    }

    public boolean isWXEntAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWXEntAppIdDirty();
        }
        return this.wxentappidDirtyFlag;
    }

    public void resetWXEntAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWXEntAppId();
            return;
        }
        this.wxentappidDirtyFlag = false;
        this.wxentappid = null;
    }

    public void setWXEntAppName(String wxentappname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWXEntAppName(wxentappname);
            return;
        }
        if (wxentappname != null && (wxentappname = StringHelper.trimRight(wxentappname)).length() == 0) {
            wxentappname = null;
        }
        this.wxentappname = wxentappname;
        this.wxentappnameDirtyFlag = true;
    }

    public String getWXEntAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXEntAppName();
        }
        return this.wxentappname;
    }

    public boolean isWXEntAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWXEntAppNameDirty();
        }
        return this.wxentappnameDirtyFlag;
    }

    public void resetWXEntAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWXEntAppName();
            return;
        }
        this.wxentappnameDirtyFlag = false;
        this.wxentappname = null;
    }

    public void setWXMessageId(String wxmessageid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWXMessageId(wxmessageid);
            return;
        }
        if (wxmessageid != null && (wxmessageid = StringHelper.trimRight(wxmessageid)).length() == 0) {
            wxmessageid = null;
        }
        this.wxmessageid = wxmessageid;
        this.wxmessageidDirtyFlag = true;
    }

    public String getWXMessageId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXMessageId();
        }
        return this.wxmessageid;
    }

    public boolean isWXMessageIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWXMessageIdDirty();
        }
        return this.wxmessageidDirtyFlag;
    }

    public void resetWXMessageId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWXMessageId();
            return;
        }
        this.wxmessageidDirtyFlag = false;
        this.wxmessageid = null;
    }

    public void setWXMessageName(String wxmessagename) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWXMessageName(wxmessagename);
            return;
        }
        if (wxmessagename != null && (wxmessagename = StringHelper.trimRight(wxmessagename)).length() == 0) {
            wxmessagename = null;
        }
        this.wxmessagename = wxmessagename;
        this.wxmessagenameDirtyFlag = true;
    }

    public String getWXMessageName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXMessageName();
        }
        return this.wxmessagename;
    }

    public boolean isWXMessageNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWXMessageNameDirty();
        }
        return this.wxmessagenameDirtyFlag;
    }

    public void resetWXMessageName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWXMessageName();
            return;
        }
        this.wxmessagenameDirtyFlag = false;
        this.wxmessagename = null;
    }

    @Override
    protected void onReset() {
        WXMessageBase.resetAll(this);
        super.onReset();
    }

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

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCntDirty()) {
            params.put(FIELD_CNT, this.getCnt());
        }
        if (!bDirtyOnly || this.isContentDirty()) {
            params.put(FIELD_CONTENT, this.getContent());
        }
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isEventDirty()) {
            params.put(FIELD_EVENT, this.getEvent());
        }
        if (!bDirtyOnly || this.isEventKeyDirty()) {
            params.put(FIELD_EVENTKEY, this.getEventKey());
        }
        if (!bDirtyOnly || this.isFormatDirty()) {
            params.put(FIELD_FORMAT, this.getFormat());
        }
        if (!bDirtyOnly || this.isFromUserNameDirty()) {
            params.put(FIELD_FROMUSERNAME, this.getFromUserName());
        }
        if (!bDirtyOnly || this.isIncomeTimeDirty()) {
            params.put(FIELD_INCOMETIME, this.getIncomeTime());
        }
        if (!bDirtyOnly || this.isLocation_PrecDirty()) {
            params.put(FIELD_LOCATION_PREC, this.getLocation_Prec());
        }
        if (!bDirtyOnly || this.isLocation_XDirty()) {
            params.put(FIELD_LOCATION_X, this.getLocation_X());
        }
        if (!bDirtyOnly || this.isLocation_YDirty()) {
            params.put(FIELD_LOCATION_Y, this.getLocation_Y());
        }
        if (!bDirtyOnly || this.isMediaIdDirty()) {
            params.put(FIELD_MEDIAID, this.getMediaId());
        }
        if (!bDirtyOnly || this.isMsgTypeDirty()) {
            params.put(FIELD_MSGTYPE, this.getMsgType());
        }
        if (!bDirtyOnly || this.isPicURLDirty()) {
            params.put(FIELD_PICURL, this.getPicURL());
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
        if (!bDirtyOnly || this.isRespArticleCountDirty()) {
            params.put(FIELD_RESPARTICLECOUNT, this.getRespArticleCount());
        }
        if (!bDirtyOnly || this.isRespArticlesDirty()) {
            params.put(FIELD_RESPARTICLES, this.getRespArticles());
        }
        if (!bDirtyOnly || this.isRespDescDirty()) {
            params.put(FIELD_RESPDESC, this.getRespDesc());
        }
        if (!bDirtyOnly || this.isRespMediaIdDirty()) {
            params.put(FIELD_RESPMEDIAID, this.getRespMediaId());
        }
        if (!bDirtyOnly || this.isRespMsgTypeDirty()) {
            params.put(FIELD_RESPMSGTYPE, this.getRespMsgType());
        }
        if (!bDirtyOnly || this.isRespTimeDirty()) {
            params.put(FIELD_RESPTIME, this.getRespTime());
        }
        if (!bDirtyOnly || this.isRespTitleDirty()) {
            params.put(FIELD_RESPTITLE, this.getRespTitle());
        }
        if (!bDirtyOnly || this.isResultDirty()) {
            params.put(FIELD_RESULT, this.getResult());
        }
        if (!bDirtyOnly || this.isScaleDirty()) {
            params.put(FIELD_SCALE, this.getScale());
        }
        if (!bDirtyOnly || this.isScanCodeInfoDirty()) {
            params.put(FIELD_SCANCODEINFO, this.getScanCodeInfo());
        }
        if (!bDirtyOnly || this.isScanTypeDirty()) {
            params.put(FIELD_SCANTYPE, this.getScanType());
        }
        if (!bDirtyOnly || this.isThumbMediaIdDirty()) {
            params.put(FIELD_THUMBMEDIAID, this.getThumbMediaId());
        }
        if (!bDirtyOnly || this.isToUserNameDirty()) {
            params.put(FIELD_TOUSERNAME, this.getToUserName());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isWXAccountIdDirty()) {
            params.put(FIELD_WXACCOUNTID, this.getWXAccountId());
        }
        if (!bDirtyOnly || this.isWXAccountNameDirty()) {
            params.put(FIELD_WXACCOUNTNAME, this.getWXAccountName());
        }
        if (!bDirtyOnly || this.isWXEntAppIdDirty()) {
            params.put(FIELD_WXENTAPPID, this.getWXEntAppId());
        }
        if (!bDirtyOnly || this.isWXEntAppNameDirty()) {
            params.put(FIELD_WXENTAPPNAME, this.getWXEntAppName());
        }
        if (!bDirtyOnly || this.isWXMessageIdDirty()) {
            params.put(FIELD_WXMESSAGEID, this.getWXMessageId());
        }
        if (!bDirtyOnly || this.isWXMessageNameDirty()) {
            params.put(FIELD_WXMESSAGENAME, this.getWXMessageName());
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
        return WXMessageBase.get(this, index);
    }

    private static Object get(WXMessageBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCnt();
            }
            case 1: {
                return et.getContent();
            }
            case 2: {
                return et.getCreateDate();
            }
            case 3: {
                return et.getCreateMan();
            }
            case 4: {
                return et.getEvent();
            }
            case 5: {
                return et.getEventKey();
            }
            case 6: {
                return et.getFormat();
            }
            case 7: {
                return et.getFromUserName();
            }
            case 8: {
                return et.getIncomeTime();
            }
            case 9: {
                return et.getLocation_Prec();
            }
            case 10: {
                return et.getLocation_X();
            }
            case 11: {
                return et.getLocation_Y();
            }
            case 12: {
                return et.getMediaId();
            }
            case 13: {
                return et.getMsgType();
            }
            case 14: {
                return et.getPicURL();
            }
            case 15: {
                return et.getReserver();
            }
            case 16: {
                return et.getReserver2();
            }
            case 17: {
                return et.getReserver3();
            }
            case 18: {
                return et.getReserver4();
            }
            case 19: {
                return et.getRespArticleCount();
            }
            case 20: {
                return et.getRespArticles();
            }
            case 21: {
                return et.getRespDesc();
            }
            case 22: {
                return et.getRespMediaId();
            }
            case 23: {
                return et.getRespMsgType();
            }
            case 24: {
                return et.getRespTime();
            }
            case 25: {
                return et.getRespTitle();
            }
            case 26: {
                return et.getResult();
            }
            case 27: {
                return et.getScale();
            }
            case 28: {
                return et.getScanCodeInfo();
            }
            case 29: {
                return et.getScanType();
            }
            case 30: {
                return et.getThumbMediaId();
            }
            case 31: {
                return et.getToUserName();
            }
            case 32: {
                return et.getUpdateDate();
            }
            case 33: {
                return et.getUpdateMan();
            }
            case 34: {
                return et.getWXAccountId();
            }
            case 35: {
                return et.getWXAccountName();
            }
            case 36: {
                return et.getWXEntAppId();
            }
            case 37: {
                return et.getWXEntAppName();
            }
            case 38: {
                return et.getWXMessageId();
            }
            case 39: {
                return et.getWXMessageName();
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
        WXMessageBase.set(this, index, objValue);
    }

    private static void set(WXMessageBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setCnt(DataObject.getIntegerValue(obj));
                return;
            }
            case 1: {
                et.setContent(DataObject.getStringValue(obj));
                return;
            }
            case 2: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 3: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setEvent(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setEventKey(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setFormat(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setFromUserName(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setIncomeTime(DataObject.getTimestampValue(obj));
                return;
            }
            case 9: {
                et.setLocation_Prec(DataObject.getDoubleValue(obj));
                return;
            }
            case 10: {
                et.setLocation_X(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setLocation_Y(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setMediaId(DataObject.getStringValue(obj));
                return;
            }
            case 13: {
                et.setMsgType(DataObject.getStringValue(obj));
                return;
            }
            case 14: {
                et.setPicURL(DataObject.getStringValue(obj));
                return;
            }
            case 15: {
                et.setReserver(DataObject.getStringValue(obj));
                return;
            }
            case 16: {
                et.setReserver2(DataObject.getStringValue(obj));
                return;
            }
            case 17: {
                et.setReserver3(DataObject.getStringValue(obj));
                return;
            }
            case 18: {
                et.setReserver4(DataObject.getStringValue(obj));
                return;
            }
            case 19: {
                et.setRespArticleCount(DataObject.getIntegerValue(obj));
                return;
            }
            case 20: {
                et.setRespArticles(DataObject.getStringValue(obj));
                return;
            }
            case 21: {
                et.setRespDesc(DataObject.getStringValue(obj));
                return;
            }
            case 22: {
                et.setRespMediaId(DataObject.getStringValue(obj));
                return;
            }
            case 23: {
                et.setRespMsgType(DataObject.getStringValue(obj));
                return;
            }
            case 24: {
                et.setRespTime(DataObject.getTimestampValue(obj));
                return;
            }
            case 25: {
                et.setRespTitle(DataObject.getStringValue(obj));
                return;
            }
            case 26: {
                et.setResult(DataObject.getStringValue(obj));
                return;
            }
            case 27: {
                et.setScale(DataObject.getIntegerValue(obj));
                return;
            }
            case 28: {
                et.setScanCodeInfo(DataObject.getStringValue(obj));
                return;
            }
            case 29: {
                et.setScanType(DataObject.getStringValue(obj));
                return;
            }
            case 30: {
                et.setThumbMediaId(DataObject.getStringValue(obj));
                return;
            }
            case 31: {
                et.setToUserName(DataObject.getStringValue(obj));
                return;
            }
            case 32: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 33: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 34: {
                et.setWXAccountId(DataObject.getStringValue(obj));
                return;
            }
            case 35: {
                et.setWXAccountName(DataObject.getStringValue(obj));
                return;
            }
            case 36: {
                et.setWXEntAppId(DataObject.getStringValue(obj));
                return;
            }
            case 37: {
                et.setWXEntAppName(DataObject.getStringValue(obj));
                return;
            }
            case 38: {
                et.setWXMessageId(DataObject.getStringValue(obj));
                return;
            }
            case 39: {
                et.setWXMessageName(DataObject.getStringValue(obj));
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
        return WXMessageBase.isNull(this, index);
    }

    private static boolean isNull(WXMessageBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCnt() == null;
            }
            case 1: {
                return et.getContent() == null;
            }
            case 2: {
                return et.getCreateDate() == null;
            }
            case 3: {
                return et.getCreateMan() == null;
            }
            case 4: {
                return et.getEvent() == null;
            }
            case 5: {
                return et.getEventKey() == null;
            }
            case 6: {
                return et.getFormat() == null;
            }
            case 7: {
                return et.getFromUserName() == null;
            }
            case 8: {
                return et.getIncomeTime() == null;
            }
            case 9: {
                return et.getLocation_Prec() == null;
            }
            case 10: {
                return et.getLocation_X() == null;
            }
            case 11: {
                return et.getLocation_Y() == null;
            }
            case 12: {
                return et.getMediaId() == null;
            }
            case 13: {
                return et.getMsgType() == null;
            }
            case 14: {
                return et.getPicURL() == null;
            }
            case 15: {
                return et.getReserver() == null;
            }
            case 16: {
                return et.getReserver2() == null;
            }
            case 17: {
                return et.getReserver3() == null;
            }
            case 18: {
                return et.getReserver4() == null;
            }
            case 19: {
                return et.getRespArticleCount() == null;
            }
            case 20: {
                return et.getRespArticles() == null;
            }
            case 21: {
                return et.getRespDesc() == null;
            }
            case 22: {
                return et.getRespMediaId() == null;
            }
            case 23: {
                return et.getRespMsgType() == null;
            }
            case 24: {
                return et.getRespTime() == null;
            }
            case 25: {
                return et.getRespTitle() == null;
            }
            case 26: {
                return et.getResult() == null;
            }
            case 27: {
                return et.getScale() == null;
            }
            case 28: {
                return et.getScanCodeInfo() == null;
            }
            case 29: {
                return et.getScanType() == null;
            }
            case 30: {
                return et.getThumbMediaId() == null;
            }
            case 31: {
                return et.getToUserName() == null;
            }
            case 32: {
                return et.getUpdateDate() == null;
            }
            case 33: {
                return et.getUpdateMan() == null;
            }
            case 34: {
                return et.getWXAccountId() == null;
            }
            case 35: {
                return et.getWXAccountName() == null;
            }
            case 36: {
                return et.getWXEntAppId() == null;
            }
            case 37: {
                return et.getWXEntAppName() == null;
            }
            case 38: {
                return et.getWXMessageId() == null;
            }
            case 39: {
                return et.getWXMessageName() == null;
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
        return WXMessageBase.contains(this, index);
    }

    private static boolean contains(WXMessageBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCntDirty();
            }
            case 1: {
                return et.isContentDirty();
            }
            case 2: {
                return et.isCreateDateDirty();
            }
            case 3: {
                return et.isCreateManDirty();
            }
            case 4: {
                return et.isEventDirty();
            }
            case 5: {
                return et.isEventKeyDirty();
            }
            case 6: {
                return et.isFormatDirty();
            }
            case 7: {
                return et.isFromUserNameDirty();
            }
            case 8: {
                return et.isIncomeTimeDirty();
            }
            case 9: {
                return et.isLocation_PrecDirty();
            }
            case 10: {
                return et.isLocation_XDirty();
            }
            case 11: {
                return et.isLocation_YDirty();
            }
            case 12: {
                return et.isMediaIdDirty();
            }
            case 13: {
                return et.isMsgTypeDirty();
            }
            case 14: {
                return et.isPicURLDirty();
            }
            case 15: {
                return et.isReserverDirty();
            }
            case 16: {
                return et.isReserver2Dirty();
            }
            case 17: {
                return et.isReserver3Dirty();
            }
            case 18: {
                return et.isReserver4Dirty();
            }
            case 19: {
                return et.isRespArticleCountDirty();
            }
            case 20: {
                return et.isRespArticlesDirty();
            }
            case 21: {
                return et.isRespDescDirty();
            }
            case 22: {
                return et.isRespMediaIdDirty();
            }
            case 23: {
                return et.isRespMsgTypeDirty();
            }
            case 24: {
                return et.isRespTimeDirty();
            }
            case 25: {
                return et.isRespTitleDirty();
            }
            case 26: {
                return et.isResultDirty();
            }
            case 27: {
                return et.isScaleDirty();
            }
            case 28: {
                return et.isScanCodeInfoDirty();
            }
            case 29: {
                return et.isScanTypeDirty();
            }
            case 30: {
                return et.isThumbMediaIdDirty();
            }
            case 31: {
                return et.isToUserNameDirty();
            }
            case 32: {
                return et.isUpdateDateDirty();
            }
            case 33: {
                return et.isUpdateManDirty();
            }
            case 34: {
                return et.isWXAccountIdDirty();
            }
            case 35: {
                return et.isWXAccountNameDirty();
            }
            case 36: {
                return et.isWXEntAppIdDirty();
            }
            case 37: {
                return et.isWXEntAppNameDirty();
            }
            case 38: {
                return et.isWXMessageIdDirty();
            }
            case 39: {
                return et.isWXMessageNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        WXMessageBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(WXMessageBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCnt() != null) {
            JSONObjectHelper.put(json, "cnt", WXMessageBase.getJSONValue(et.getCnt()), false);
        }
        if (bIncEmpty || et.getContent() != null) {
            JSONObjectHelper.put(json, "content", WXMessageBase.getJSONValue(et.getContent()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", WXMessageBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", WXMessageBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getEvent() != null) {
            JSONObjectHelper.put(json, "event", WXMessageBase.getJSONValue(et.getEvent()), false);
        }
        if (bIncEmpty || et.getEventKey() != null) {
            JSONObjectHelper.put(json, "eventkey", WXMessageBase.getJSONValue(et.getEventKey()), false);
        }
        if (bIncEmpty || et.getFormat() != null) {
            JSONObjectHelper.put(json, "format", WXMessageBase.getJSONValue(et.getFormat()), false);
        }
        if (bIncEmpty || et.getFromUserName() != null) {
            JSONObjectHelper.put(json, "fromusername", WXMessageBase.getJSONValue(et.getFromUserName()), false);
        }
        if (bIncEmpty || et.getIncomeTime() != null) {
            JSONObjectHelper.put(json, "incometime", WXMessageBase.getJSONValue(et.getIncomeTime()), false);
        }
        if (bIncEmpty || et.getLocation_Prec() != null) {
            JSONObjectHelper.put(json, "location_prec", WXMessageBase.getJSONValue(et.getLocation_Prec()), false);
        }
        if (bIncEmpty || et.getLocation_X() != null) {
            JSONObjectHelper.put(json, "location_x", WXMessageBase.getJSONValue(et.getLocation_X()), false);
        }
        if (bIncEmpty || et.getLocation_Y() != null) {
            JSONObjectHelper.put(json, "location_y", WXMessageBase.getJSONValue(et.getLocation_Y()), false);
        }
        if (bIncEmpty || et.getMediaId() != null) {
            JSONObjectHelper.put(json, "mediaid", WXMessageBase.getJSONValue(et.getMediaId()), false);
        }
        if (bIncEmpty || et.getMsgType() != null) {
            JSONObjectHelper.put(json, "msgtype", WXMessageBase.getJSONValue(et.getMsgType()), false);
        }
        if (bIncEmpty || et.getPicURL() != null) {
            JSONObjectHelper.put(json, "picurl", WXMessageBase.getJSONValue(et.getPicURL()), false);
        }
        if (bIncEmpty || et.getReserver() != null) {
            JSONObjectHelper.put(json, "reserver", WXMessageBase.getJSONValue(et.getReserver()), false);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            JSONObjectHelper.put(json, "reserver2", WXMessageBase.getJSONValue(et.getReserver2()), false);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            JSONObjectHelper.put(json, "reserver3", WXMessageBase.getJSONValue(et.getReserver3()), false);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            JSONObjectHelper.put(json, "reserver4", WXMessageBase.getJSONValue(et.getReserver4()), false);
        }
        if (bIncEmpty || et.getRespArticleCount() != null) {
            JSONObjectHelper.put(json, "resparticlecount", WXMessageBase.getJSONValue(et.getRespArticleCount()), false);
        }
        if (bIncEmpty || et.getRespArticles() != null) {
            JSONObjectHelper.put(json, "resparticles", WXMessageBase.getJSONValue(et.getRespArticles()), false);
        }
        if (bIncEmpty || et.getRespDesc() != null) {
            JSONObjectHelper.put(json, "respdesc", WXMessageBase.getJSONValue(et.getRespDesc()), false);
        }
        if (bIncEmpty || et.getRespMediaId() != null) {
            JSONObjectHelper.put(json, "respmediaid", WXMessageBase.getJSONValue(et.getRespMediaId()), false);
        }
        if (bIncEmpty || et.getRespMsgType() != null) {
            JSONObjectHelper.put(json, "respmsgtype", WXMessageBase.getJSONValue(et.getRespMsgType()), false);
        }
        if (bIncEmpty || et.getRespTime() != null) {
            JSONObjectHelper.put(json, "resptime", WXMessageBase.getJSONValue(et.getRespTime()), false);
        }
        if (bIncEmpty || et.getRespTitle() != null) {
            JSONObjectHelper.put(json, "resptitle", WXMessageBase.getJSONValue(et.getRespTitle()), false);
        }
        if (bIncEmpty || et.getResult() != null) {
            JSONObjectHelper.put(json, "result", WXMessageBase.getJSONValue(et.getResult()), false);
        }
        if (bIncEmpty || et.getScale() != null) {
            JSONObjectHelper.put(json, "scale", WXMessageBase.getJSONValue(et.getScale()), false);
        }
        if (bIncEmpty || et.getScanCodeInfo() != null) {
            JSONObjectHelper.put(json, "scancodeinfo", WXMessageBase.getJSONValue(et.getScanCodeInfo()), false);
        }
        if (bIncEmpty || et.getScanType() != null) {
            JSONObjectHelper.put(json, "scantype", WXMessageBase.getJSONValue(et.getScanType()), false);
        }
        if (bIncEmpty || et.getThumbMediaId() != null) {
            JSONObjectHelper.put(json, "thumbmediaid", WXMessageBase.getJSONValue(et.getThumbMediaId()), false);
        }
        if (bIncEmpty || et.getToUserName() != null) {
            JSONObjectHelper.put(json, "tousername", WXMessageBase.getJSONValue(et.getToUserName()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", WXMessageBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", WXMessageBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getWXAccountId() != null) {
            JSONObjectHelper.put(json, "wxaccountid", WXMessageBase.getJSONValue(et.getWXAccountId()), false);
        }
        if (bIncEmpty || et.getWXAccountName() != null) {
            JSONObjectHelper.put(json, "wxaccountname", WXMessageBase.getJSONValue(et.getWXAccountName()), false);
        }
        if (bIncEmpty || et.getWXEntAppId() != null) {
            JSONObjectHelper.put(json, "wxentappid", WXMessageBase.getJSONValue(et.getWXEntAppId()), false);
        }
        if (bIncEmpty || et.getWXEntAppName() != null) {
            JSONObjectHelper.put(json, "wxentappname", WXMessageBase.getJSONValue(et.getWXEntAppName()), false);
        }
        if (bIncEmpty || et.getWXMessageId() != null) {
            JSONObjectHelper.put(json, "wxmessageid", WXMessageBase.getJSONValue(et.getWXMessageId()), false);
        }
        if (bIncEmpty || et.getWXMessageName() != null) {
            JSONObjectHelper.put(json, "wxmessagename", WXMessageBase.getJSONValue(et.getWXMessageName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        WXMessageBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(WXMessageBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCnt() != null) {
            obj = et.getCnt();
            node.setAttribute(FIELD_CNT, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getContent() != null) {
            obj = et.getContent();
            node.setAttribute(FIELD_CONTENT, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getEvent() != null) {
            obj = et.getEvent();
            node.setAttribute(FIELD_EVENT, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getEventKey() != null) {
            obj = et.getEventKey();
            node.setAttribute(FIELD_EVENTKEY, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getFormat() != null) {
            obj = et.getFormat();
            node.setAttribute(FIELD_FORMAT, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getFromUserName() != null) {
            obj = et.getFromUserName();
            node.setAttribute(FIELD_FROMUSERNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getIncomeTime() != null) {
            obj = et.getIncomeTime();
            node.setAttribute(FIELD_INCOMETIME, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getLocation_Prec() != null) {
            obj = et.getLocation_Prec();
            node.setAttribute(FIELD_LOCATION_PREC, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getLocation_X() != null) {
            obj = et.getLocation_X();
            node.setAttribute(FIELD_LOCATION_X, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getLocation_Y() != null) {
            obj = et.getLocation_Y();
            node.setAttribute(FIELD_LOCATION_Y, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMediaId() != null) {
            obj = et.getMediaId();
            node.setAttribute(FIELD_MEDIAID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMsgType() != null) {
            obj = et.getMsgType();
            node.setAttribute(FIELD_MSGTYPE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getPicURL() != null) {
            obj = et.getPicURL();
            node.setAttribute(FIELD_PICURL, obj == null ? "" : (String)obj);
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
        if (bIncEmpty || et.getRespArticleCount() != null) {
            obj = et.getRespArticleCount();
            node.setAttribute(FIELD_RESPARTICLECOUNT, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getRespArticles() != null) {
            obj = et.getRespArticles();
            node.setAttribute(FIELD_RESPARTICLES, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getRespDesc() != null) {
            obj = et.getRespDesc();
            node.setAttribute(FIELD_RESPDESC, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getRespMediaId() != null) {
            obj = et.getRespMediaId();
            node.setAttribute(FIELD_RESPMEDIAID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getRespMsgType() != null) {
            obj = et.getRespMsgType();
            node.setAttribute(FIELD_RESPMSGTYPE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getRespTime() != null) {
            obj = et.getRespTime();
            node.setAttribute(FIELD_RESPTIME, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getRespTitle() != null) {
            obj = et.getRespTitle();
            node.setAttribute(FIELD_RESPTITLE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getResult() != null) {
            obj = et.getResult();
            node.setAttribute(FIELD_RESULT, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getScale() != null) {
            obj = et.getScale();
            node.setAttribute(FIELD_SCALE, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getScanCodeInfo() != null) {
            obj = et.getScanCodeInfo();
            node.setAttribute(FIELD_SCANCODEINFO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getScanType() != null) {
            obj = et.getScanType();
            node.setAttribute(FIELD_SCANTYPE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getThumbMediaId() != null) {
            obj = et.getThumbMediaId();
            node.setAttribute(FIELD_THUMBMEDIAID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getToUserName() != null) {
            obj = et.getToUserName();
            node.setAttribute(FIELD_TOUSERNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWXAccountId() != null) {
            obj = et.getWXAccountId();
            node.setAttribute(FIELD_WXACCOUNTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWXAccountName() != null) {
            obj = et.getWXAccountName();
            node.setAttribute(FIELD_WXACCOUNTNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWXEntAppId() != null) {
            obj = et.getWXEntAppId();
            node.setAttribute(FIELD_WXENTAPPID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWXEntAppName() != null) {
            obj = et.getWXEntAppName();
            node.setAttribute(FIELD_WXENTAPPNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWXMessageId() != null) {
            obj = et.getWXMessageId();
            node.setAttribute(FIELD_WXMESSAGEID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWXMessageName() != null) {
            obj = et.getWXMessageName();
            node.setAttribute(FIELD_WXMESSAGENAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WXMessageBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(WXMessageBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCntDirty() && (bIncEmpty || et.getCnt() != null)) {
            dst.set(FIELD_CNT, et.getCnt());
        }
        if (et.isContentDirty() && (bIncEmpty || et.getContent() != null)) {
            dst.set(FIELD_CONTENT, et.getContent());
        }
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isEventDirty() && (bIncEmpty || et.getEvent() != null)) {
            dst.set(FIELD_EVENT, et.getEvent());
        }
        if (et.isEventKeyDirty() && (bIncEmpty || et.getEventKey() != null)) {
            dst.set(FIELD_EVENTKEY, et.getEventKey());
        }
        if (et.isFormatDirty() && (bIncEmpty || et.getFormat() != null)) {
            dst.set(FIELD_FORMAT, et.getFormat());
        }
        if (et.isFromUserNameDirty() && (bIncEmpty || et.getFromUserName() != null)) {
            dst.set(FIELD_FROMUSERNAME, et.getFromUserName());
        }
        if (et.isIncomeTimeDirty() && (bIncEmpty || et.getIncomeTime() != null)) {
            dst.set(FIELD_INCOMETIME, et.getIncomeTime());
        }
        if (et.isLocation_PrecDirty() && (bIncEmpty || et.getLocation_Prec() != null)) {
            dst.set(FIELD_LOCATION_PREC, et.getLocation_Prec());
        }
        if (et.isLocation_XDirty() && (bIncEmpty || et.getLocation_X() != null)) {
            dst.set(FIELD_LOCATION_X, et.getLocation_X());
        }
        if (et.isLocation_YDirty() && (bIncEmpty || et.getLocation_Y() != null)) {
            dst.set(FIELD_LOCATION_Y, et.getLocation_Y());
        }
        if (et.isMediaIdDirty() && (bIncEmpty || et.getMediaId() != null)) {
            dst.set(FIELD_MEDIAID, et.getMediaId());
        }
        if (et.isMsgTypeDirty() && (bIncEmpty || et.getMsgType() != null)) {
            dst.set(FIELD_MSGTYPE, et.getMsgType());
        }
        if (et.isPicURLDirty() && (bIncEmpty || et.getPicURL() != null)) {
            dst.set(FIELD_PICURL, et.getPicURL());
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
        if (et.isRespArticleCountDirty() && (bIncEmpty || et.getRespArticleCount() != null)) {
            dst.set(FIELD_RESPARTICLECOUNT, et.getRespArticleCount());
        }
        if (et.isRespArticlesDirty() && (bIncEmpty || et.getRespArticles() != null)) {
            dst.set(FIELD_RESPARTICLES, et.getRespArticles());
        }
        if (et.isRespDescDirty() && (bIncEmpty || et.getRespDesc() != null)) {
            dst.set(FIELD_RESPDESC, et.getRespDesc());
        }
        if (et.isRespMediaIdDirty() && (bIncEmpty || et.getRespMediaId() != null)) {
            dst.set(FIELD_RESPMEDIAID, et.getRespMediaId());
        }
        if (et.isRespMsgTypeDirty() && (bIncEmpty || et.getRespMsgType() != null)) {
            dst.set(FIELD_RESPMSGTYPE, et.getRespMsgType());
        }
        if (et.isRespTimeDirty() && (bIncEmpty || et.getRespTime() != null)) {
            dst.set(FIELD_RESPTIME, et.getRespTime());
        }
        if (et.isRespTitleDirty() && (bIncEmpty || et.getRespTitle() != null)) {
            dst.set(FIELD_RESPTITLE, et.getRespTitle());
        }
        if (et.isResultDirty() && (bIncEmpty || et.getResult() != null)) {
            dst.set(FIELD_RESULT, et.getResult());
        }
        if (et.isScaleDirty() && (bIncEmpty || et.getScale() != null)) {
            dst.set(FIELD_SCALE, et.getScale());
        }
        if (et.isScanCodeInfoDirty() && (bIncEmpty || et.getScanCodeInfo() != null)) {
            dst.set(FIELD_SCANCODEINFO, et.getScanCodeInfo());
        }
        if (et.isScanTypeDirty() && (bIncEmpty || et.getScanType() != null)) {
            dst.set(FIELD_SCANTYPE, et.getScanType());
        }
        if (et.isThumbMediaIdDirty() && (bIncEmpty || et.getThumbMediaId() != null)) {
            dst.set(FIELD_THUMBMEDIAID, et.getThumbMediaId());
        }
        if (et.isToUserNameDirty() && (bIncEmpty || et.getToUserName() != null)) {
            dst.set(FIELD_TOUSERNAME, et.getToUserName());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isWXAccountIdDirty() && (bIncEmpty || et.getWXAccountId() != null)) {
            dst.set(FIELD_WXACCOUNTID, et.getWXAccountId());
        }
        if (et.isWXAccountNameDirty() && (bIncEmpty || et.getWXAccountName() != null)) {
            dst.set(FIELD_WXACCOUNTNAME, et.getWXAccountName());
        }
        if (et.isWXEntAppIdDirty() && (bIncEmpty || et.getWXEntAppId() != null)) {
            dst.set(FIELD_WXENTAPPID, et.getWXEntAppId());
        }
        if (et.isWXEntAppNameDirty() && (bIncEmpty || et.getWXEntAppName() != null)) {
            dst.set(FIELD_WXENTAPPNAME, et.getWXEntAppName());
        }
        if (et.isWXMessageIdDirty() && (bIncEmpty || et.getWXMessageId() != null)) {
            dst.set(FIELD_WXMESSAGEID, et.getWXMessageId());
        }
        if (et.isWXMessageNameDirty() && (bIncEmpty || et.getWXMessageName() != null)) {
            dst.set(FIELD_WXMESSAGENAME, et.getWXMessageName());
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
        return WXMessageBase.remove(this, index);
    }

    private static boolean remove(WXMessageBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetCnt();
                return true;
            }
            case 1: {
                et.resetContent();
                return true;
            }
            case 2: {
                et.resetCreateDate();
                return true;
            }
            case 3: {
                et.resetCreateMan();
                return true;
            }
            case 4: {
                et.resetEvent();
                return true;
            }
            case 5: {
                et.resetEventKey();
                return true;
            }
            case 6: {
                et.resetFormat();
                return true;
            }
            case 7: {
                et.resetFromUserName();
                return true;
            }
            case 8: {
                et.resetIncomeTime();
                return true;
            }
            case 9: {
                et.resetLocation_Prec();
                return true;
            }
            case 10: {
                et.resetLocation_X();
                return true;
            }
            case 11: {
                et.resetLocation_Y();
                return true;
            }
            case 12: {
                et.resetMediaId();
                return true;
            }
            case 13: {
                et.resetMsgType();
                return true;
            }
            case 14: {
                et.resetPicURL();
                return true;
            }
            case 15: {
                et.resetReserver();
                return true;
            }
            case 16: {
                et.resetReserver2();
                return true;
            }
            case 17: {
                et.resetReserver3();
                return true;
            }
            case 18: {
                et.resetReserver4();
                return true;
            }
            case 19: {
                et.resetRespArticleCount();
                return true;
            }
            case 20: {
                et.resetRespArticles();
                return true;
            }
            case 21: {
                et.resetRespDesc();
                return true;
            }
            case 22: {
                et.resetRespMediaId();
                return true;
            }
            case 23: {
                et.resetRespMsgType();
                return true;
            }
            case 24: {
                et.resetRespTime();
                return true;
            }
            case 25: {
                et.resetRespTitle();
                return true;
            }
            case 26: {
                et.resetResult();
                return true;
            }
            case 27: {
                et.resetScale();
                return true;
            }
            case 28: {
                et.resetScanCodeInfo();
                return true;
            }
            case 29: {
                et.resetScanType();
                return true;
            }
            case 30: {
                et.resetThumbMediaId();
                return true;
            }
            case 31: {
                et.resetToUserName();
                return true;
            }
            case 32: {
                et.resetUpdateDate();
                return true;
            }
            case 33: {
                et.resetUpdateMan();
                return true;
            }
            case 34: {
                et.resetWXAccountId();
                return true;
            }
            case 35: {
                et.resetWXAccountName();
                return true;
            }
            case 36: {
                et.resetWXEntAppId();
                return true;
            }
            case 37: {
                et.resetWXEntAppName();
                return true;
            }
            case 38: {
                et.resetWXMessageId();
                return true;
            }
            case 39: {
                et.resetWXMessageName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WXAccount getWXAccount() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXAccount();
        }
        if (this.getWXAccountId() == null) {
            return null;
        }
        Integer n = this.objWXAccountLock;
        synchronized (n) {
            if (this.wxaccount != null && DataTypeHelper.compare(25, (Object)this.getWXAccountId(), (Object)this.wxaccount.getWXAccountId()) != 0L) {
                this.wxaccount = null;
            }
            if (this.wxaccount == null) {
                WXAccount wxaccount = new WXAccount();
                wxaccount.setWXAccountId(this.getWXAccountId());
                WXAccountService service = (WXAccountService)ServiceGlobal.getService(WXAccountService.class, this.getSessionFactory());
                service.autoGet(wxaccount);
                this.wxaccount = wxaccount;
            }
            return this.wxaccount;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WXEntApp getWXEntApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWXEntApp();
        }
        if (this.getWXEntAppId() == null) {
            return null;
        }
        Integer n = this.objWXEntAppLock;
        synchronized (n) {
            if (this.wxentapp != null && DataTypeHelper.compare(25, (Object)this.getWXEntAppId(), (Object)this.wxentapp.getWXEntAppId()) != 0L) {
                this.wxentapp = null;
            }
            if (this.wxentapp == null) {
                WXEntApp wxentapp = new WXEntApp();
                wxentapp.setWXEntAppId(this.getWXEntAppId());
                WXEntAppService service = (WXEntAppService)ServiceGlobal.getService(WXEntAppService.class, this.getSessionFactory());
                service.autoGet(wxentapp);
                this.wxentapp = wxentapp;
            }
            return this.wxentapp;
        }
    }

    private WXMessageBase getProxyEntity() {
        return this.proxyWXMessageBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWXMessageBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof WXMessageBase) {
            this.proxyWXMessageBase = (WXMessageBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.wx.service.WXMessageService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

