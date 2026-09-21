/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.XMLNode
 */
package SA.WT.Data;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;
import java.sql.Timestamp;
import java.util.Date;

public class WTIncomeMessage
extends BaseDataEntity {
    public static final String MSGTYPE_text = "text";
    public static final String MSGTYPE_image = "image";
    public static final String MSGTYPE_voice = "voice";
    public static final String MSGTYPE_video = "video";
    public static final String MSGTYPE_location = "location";
    public static final String MSGTYPE_link = "link";
    public static final String MSGTYPE_event = "event";
    public static final String TAG_WTINCOMEMESSAGEID = "WTINCOMEMESSAGEID";
    public static final String TAG_WTINCOMEMESSAGENAME = "WTINCOMEMESSAGENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MSGTYPE = "MSGTYPE";
    public static final String TAG_TOUSERNAME = "TOUSERNAME";
    public static final String TAG_FROMUSERNAME = "FROMUSERNAME";
    public static final String TAG_INCOMETIME = "INCOMETIME";
    public static final String TAG_CONTENT = "CONTENT";
    public static final String TAG_PICURL = "PICURL";
    public static final String TAG_MEDIAID = "MEDIAID";
    public static final String TAG_FORMAT = "FORMAT";
    public static final String TAG_THUMBMEDIAID = "THUMBMEDIAID";
    public static final String TAG_LOCATION_X = "LOCATION_X";
    public static final String TAG_LOCATION_Y = "LOCATION_Y";
    public static final String TAG_SCALE = "SCALE";
    public static final String TAG_EVENT = "EVENT";
    public static final String TAG_TICKET = "TICKET";

    public final boolean isWTINCOMEMESSAGEIDNull() {
        return this.IsParamNull(TAG_WTINCOMEMESSAGEID);
    }

    public final String getWTINCOMEMESSAGEID() {
        return this.GetParamStringValue(TAG_WTINCOMEMESSAGEID, "");
    }

    public final void setWTINCOMEMESSAGEID(String strValue) {
        this.SetParamValue(TAG_WTINCOMEMESSAGEID, strValue);
    }

    public final boolean isWTINCOMEMESSAGENAMENull() {
        return this.IsParamNull(TAG_WTINCOMEMESSAGENAME);
    }

    public final String getWTINCOMEMESSAGENAME() {
        return this.GetParamStringValue(TAG_WTINCOMEMESSAGENAME, "");
    }

    public final void setWTINCOMEMESSAGENAME(String strValue) {
        this.SetParamValue(TAG_WTINCOMEMESSAGENAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isMSGTYPENull() {
        return this.IsParamNull(TAG_MSGTYPE);
    }

    public final String getMSGTYPE() {
        return this.GetParamStringValue(TAG_MSGTYPE, "");
    }

    public final void setMSGTYPE(String strValue) {
        this.SetParamValue(TAG_MSGTYPE, strValue);
    }

    public final boolean isTOUSERNAMENull() {
        return this.IsParamNull(TAG_TOUSERNAME);
    }

    public final String getTOUSERNAME() {
        return this.GetParamStringValue(TAG_TOUSERNAME, "");
    }

    public final void setTOUSERNAME(String strValue) {
        this.SetParamValue(TAG_TOUSERNAME, strValue);
    }

    public final boolean isFROMUSERNAMENull() {
        return this.IsParamNull(TAG_FROMUSERNAME);
    }

    public final String getFROMUSERNAME() {
        return this.GetParamStringValue(TAG_FROMUSERNAME, "");
    }

    public final void setFROMUSERNAME(String strValue) {
        this.SetParamValue(TAG_FROMUSERNAME, strValue);
    }

    public final boolean isINCOMETIMENull() {
        return this.IsParamNull(TAG_INCOMETIME);
    }

    public final Date getINCOMETIME() {
        return this.GetParamDateValue(TAG_INCOMETIME, null);
    }

    public final void setINCOMETIME(Date dtValue) {
        this.SetParamValue(TAG_INCOMETIME, dtValue);
    }

    public final boolean isCONTENTNull() {
        return this.IsParamNull(TAG_CONTENT);
    }

    public final String getCONTENT() {
        return this.GetParamStringValue(TAG_CONTENT, "");
    }

    public final void setCONTENT(String strValue) {
        this.SetParamValue(TAG_CONTENT, strValue);
    }

    public final boolean isPICURLNull() {
        return this.IsParamNull(TAG_PICURL);
    }

    public final String getPICURL() {
        return this.GetParamStringValue(TAG_PICURL, "");
    }

    public final void setPICURL(String strValue) {
        this.SetParamValue(TAG_PICURL, strValue);
    }

    public final boolean isMEDIAIDNull() {
        return this.IsParamNull(TAG_MEDIAID);
    }

    public final String getMEDIAID() {
        return this.GetParamStringValue(TAG_MEDIAID, "");
    }

    public final void setMEDIAID(String strValue) {
        this.SetParamValue(TAG_MEDIAID, strValue);
    }

    public final boolean isFORMATNull() {
        return this.IsParamNull(TAG_FORMAT);
    }

    public final String getFORMAT() {
        return this.GetParamStringValue(TAG_FORMAT, "");
    }

    public final void setFORMAT(String strValue) {
        this.SetParamValue(TAG_FORMAT, strValue);
    }

    public final boolean isTHUMBMEDIAIDNull() {
        return this.IsParamNull(TAG_THUMBMEDIAID);
    }

    public final String getTHUMBMEDIAID() {
        return this.GetParamStringValue(TAG_THUMBMEDIAID, "");
    }

    public final void setTHUMBMEDIAID(String strValue) {
        this.SetParamValue(TAG_THUMBMEDIAID, strValue);
    }

    public final boolean isLOCATION_XNull() {
        return this.IsParamNull(TAG_LOCATION_X);
    }

    public final String getLOCATION_X() {
        return this.GetParamStringValue(TAG_LOCATION_X, "");
    }

    public final void setLOCATION_X(String strValue) {
        this.SetParamValue(TAG_LOCATION_X, strValue);
    }

    public final boolean isLOCATION_YNull() {
        return this.IsParamNull(TAG_LOCATION_Y);
    }

    public final String getLOCATION_Y() {
        return this.GetParamStringValue(TAG_LOCATION_Y, "");
    }

    public final void setLOCATION_Y(String strValue) {
        this.SetParamValue(TAG_LOCATION_Y, strValue);
    }

    public final boolean isSCALENull() {
        return this.IsParamNull(TAG_SCALE);
    }

    public final int getSCALE() {
        return this.GetParamIntValue(TAG_SCALE, 0);
    }

    public final void setSCALE(int nValue) {
        this.SetParamValue(TAG_SCALE, nValue);
    }

    public final boolean isEVENTNull() {
        return this.IsParamNull(TAG_EVENT);
    }

    public final String getEVENT() {
        return this.GetParamStringValue(TAG_EVENT, "");
    }

    public final void setEVENT(String strValue) {
        this.SetParamValue(TAG_EVENT, strValue);
    }

    public final boolean isTICKETNull() {
        return this.IsParamNull(TAG_TICKET);
    }

    public final String getTICKET() {
        return this.GetParamStringValue(TAG_TICKET, "");
    }

    public final void setTICKET(String strValue) {
        this.SetParamValue(TAG_TICKET, strValue);
    }

    public static WTIncomeMessage FromRawContent(String strContent) throws Exception {
        XMLNode msgTypeNode;
        XMLNode createTimeNode;
        XMLNode fromUserNameNode;
        XMLNode toUserNameNode;
        WTIncomeMessage wtIncomeMessage = new WTIncomeMessage();
        XMLNode xmlNode = new XMLNode();
        XMLNode.LoadFromXML((String)strContent, (XMLConfig)xmlNode);
        XMLNode msgIdNode = xmlNode.GetChildNodeByNodeName("MsgId");
        if (msgIdNode != null) {
            wtIncomeMessage.setWTINCOMEMESSAGENAME(msgIdNode.getNodeValue());
        }
        if ((toUserNameNode = xmlNode.GetChildNodeByNodeName("ToUserName")) != null) {
            wtIncomeMessage.setTOUSERNAME(toUserNameNode.getNodeValue());
        }
        if ((fromUserNameNode = xmlNode.GetChildNodeByNodeName("FromUserName")) != null) {
            wtIncomeMessage.setFROMUSERNAME(fromUserNameNode.getNodeValue());
        }
        if ((createTimeNode = xmlNode.GetChildNodeByNodeName("CreateTime")) != null) {
            long nTime = Integer.parseInt(createTimeNode.getNodeValue());
            wtIncomeMessage.setINCOMETIME(new Timestamp(nTime * 1000L));
        }
        if ((msgTypeNode = xmlNode.GetChildNodeByNodeName("MsgType")) != null) {
            wtIncomeMessage.setMSGTYPE(msgTypeNode.getNodeValue());
        }
        if (StringHelper.Compare((String)wtIncomeMessage.getMSGTYPE(), (String)MSGTYPE_text, (boolean)true) == 0) {
            XMLNode contentNode = xmlNode.GetChildNodeByNodeName("Content");
            if (contentNode != null) {
                wtIncomeMessage.setCONTENT(contentNode.getNodeValue());
            }
            return wtIncomeMessage;
        }
        if (StringHelper.Compare((String)wtIncomeMessage.getMSGTYPE(), (String)MSGTYPE_voice, (boolean)true) == 0) {
            XMLNode contentNode;
            XMLNode mediaIdNode;
            XMLNode formatNode = xmlNode.GetChildNodeByNodeName("Format");
            if (formatNode != null) {
                wtIncomeMessage.setFORMAT(formatNode.getNodeValue());
            }
            if ((mediaIdNode = xmlNode.GetChildNodeByNodeName("MediaId")) != null) {
                wtIncomeMessage.setMEDIAID(mediaIdNode.getNodeValue());
            }
            if ((contentNode = xmlNode.GetChildNodeByNodeName("Recognition")) != null) {
                wtIncomeMessage.setCONTENT(contentNode.getNodeValue());
            }
            return wtIncomeMessage;
        }
        if (StringHelper.Compare((String)wtIncomeMessage.getMSGTYPE(), (String)MSGTYPE_event, (boolean)true) == 0) {
            XMLNode ticketNode;
            XMLNode eventKeyNode;
            XMLNode eventNode = xmlNode.GetChildNodeByNodeName("Event");
            if (eventNode != null) {
                wtIncomeMessage.setEVENT(eventNode.getNodeValue());
            }
            if ((eventKeyNode = xmlNode.GetChildNodeByNodeName("EventKey")) != null) {
                wtIncomeMessage.setCONTENT(eventKeyNode.getNodeValue());
            }
            if ((ticketNode = xmlNode.GetChildNodeByNodeName("Ticket")) != null) {
                wtIncomeMessage.setTICKET(ticketNode.getNodeValue());
            }
            return wtIncomeMessage;
        }
        return wtIncomeMessage;
    }
}

