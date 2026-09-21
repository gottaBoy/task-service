/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.IM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.sql.Timestamp;
import java.util.Date;

public class IMUser
extends BaseDataEntity {
    public static final String ONLINESTATE_ONLINE = "ONLINE";
    public static final String ONLINESTATE_BUSY = "BUSY";
    public static final String ONLINESTATE_AWAY = "AWAY";
    public static final String ONLINESTATE_INVISIBLE = "INVISIBLE";
    public static final String USERTYPE_IMROBOT1 = "IMROBOT1";
    public static final String IMDOMAIN_IMDOMAIN001 = "IMDOMAIN001";
    public static final String IMDOMAIN_IMDOMAIN002 = "IMDOMAIN002";
    public static final String IMDOMAIN_IMDOMAIN004 = "IMDOMAIN004";
    public static final String IMDOMAIN_IMDOMAIN005 = "IMDOMAIN005";
    public static final String IMDOMAIN_IMDOMAIN006 = "IMDOMAIN006";
    public static final String IMDOMAIN_IMDOMAIN007 = "IMDOMAIN007";
    public static final String IMDOMAIN_IMDOMAIN008 = "IMDOMAIN008";
    public static final String IMDOMAIN_IMDOMAIN009 = "IMDOMAIN009";
    public static final String IMDOMAIN_IMDOMAIN010 = "IMDOMAIN010";
    public static final String IMDOMAIN_IMDOMAIN003 = "IMDOMAIN003";
    public static final String SEX_1 = "1";
    public static final String SEX_2 = "2";
    public static final String TAG_IMUSERID = "IMUSERID";
    public static final String TAG_IMUSERNAME = "IMUSERNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ONLINEFLAG = "ONLINEFLAG";
    public static final String TAG_ONLINESTATE = "ONLINESTATE";
    public static final String TAG_ONLINESTATEINFO = "ONLINESTATEINFO";
    public static final String TAG_IMUSERSESSIONID = "IMUSERSESSIONID";
    public static final String TAG_USERINFO = "USERINFO";
    public static final String TAG_NICKNAME = "NICKNAME";
    public static final String TAG_ICONPATH = "ICONPATH";
    public static final String TAG_USERTYPE = "USERTYPE";
    public static final String TAG_USERLEVEL = "USERLEVEL";
    public static final String TAG_TALKLEVEL = "TALKLEVEL";
    public static final String TAG_ALWAYSONLINE = "ALWAYSONLINE";
    public static final String TAG_LASTINFORMTIME = "LASTINFORMTIME";
    public static final String TAG_IMDOMAIN = "IMDOMAIN";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PASSWD = "PASSWD";
    public static final String TAG_IMORGID = "IMORGID";
    public static final String TAG_IMORGNAME = "IMORGNAME";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_PHONE = "PHONE";
    public static final String TAG_OFFICEPHONE = "OFFICEPHONE";
    public static final String TAG_SEX = "SEX";
    public static final String TAG_SHORTPHONE = "SHORTPHONE";
    public static final String TAG_SHORTPHONE2 = "SHORTPHONE2";
    public static final String TAG_EMAIL = "EMAIL";
    public static final String TAG_DUTY = "DUTY";
    public static final String TAG_DUTYLEVEL = "DUTYLEVEL";
    public static final String TAG_WORKPLACE = "WORKPLACE";
    public static final String TAG_HOLIDAYSTATE = "HOLIDAYSTATE";
    public static final String TAG_BIRTHDAY = "BIRTHDAY";
    public static final String TAG_USERDATA = "USERDATA";
    public static final String TAG_USERDATA2 = "USERDATA2";
    public static final String TAG_USERDATA3 = "USERDATA3";
    public static final String TAG_USERDATA4 = "USERDATA4";
    public static final String TAG_USERDATA5 = "USERDATA5";
    public static final String TAG_USERDATA6 = "USERDATA6";
    public static final String TAG_USERDATA7 = "USERDATA7";
    public static final String TAG_USERDATA8 = "USERDATA8";
    public static final String TAG_USERDATA9 = "USERDATA9";
    public static final String TAG_USERDATA10 = "USERDATA10";
    public static final String TAG_RECENTFROMTIME = "RECENTFROMTIME";
    public static final String USERFULLINFOFIELDS = "NICKNAME|IMUSERID|PHONE|OFFICEPHONE|SEX|SHORTPHONE|SHORTPHONE2|EMAIL|DUTY|DUTYLEVEL|WORKPLACE|HOLIDAYSTATE|BIRTHDAY|USERDATA|USERDATA2|USERDATA3|USERDATA4|USERDATA5|USERDATA6|USERDATA7|USERDATA8|USERDATA9|USERDATA10";
    public static final String TAG_USERFULLINFO = "USERFULLINFO";

    public final boolean isIMUSERIDNull() {
        return this.IsParamNull(TAG_IMUSERID);
    }

    public final String getIMUSERID() {
        return this.GetParamStringValue(TAG_IMUSERID, "");
    }

    public final void setIMUSERID(String strValue) {
        this.SetParamValue(TAG_IMUSERID, strValue);
    }

    public final boolean isIMUSERNAMENull() {
        return this.IsParamNull(TAG_IMUSERNAME);
    }

    public final String getIMUSERNAME() {
        return this.GetParamStringValue(TAG_IMUSERNAME, "");
    }

    public final void setIMUSERNAME(String strValue) {
        this.SetParamValue(TAG_IMUSERNAME, strValue);
    }

    public final boolean isENABLENull() {
        return this.IsParamNull(TAG_ENABLE);
    }

    public final boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public final void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public final boolean isONLINEFLAGNull() {
        return this.IsParamNull(TAG_ONLINEFLAG);
    }

    public final boolean getONLINEFLAG() {
        return this.GetParamIntValue(TAG_ONLINEFLAG, 0) == 1;
    }

    public final void setONLINEFLAG(boolean bValue) {
        this.SetParamValue(TAG_ONLINEFLAG, bValue ? 1 : 0);
    }

    public final boolean isONLINESTATENull() {
        return this.IsParamNull(TAG_ONLINESTATE);
    }

    public final String getONLINESTATE() {
        return this.GetParamStringValue(TAG_ONLINESTATE, "");
    }

    public final void setONLINESTATE(String strValue) {
        this.SetParamValue(TAG_ONLINESTATE, strValue);
    }

    public final boolean isONLINESTATEINFONull() {
        return this.IsParamNull(TAG_ONLINESTATEINFO);
    }

    public final String getONLINESTATEINFO() {
        return this.GetParamStringValue(TAG_ONLINESTATEINFO, "");
    }

    public final void setONLINESTATEINFO(String strValue) {
        this.SetParamValue(TAG_ONLINESTATEINFO, strValue);
    }

    public final boolean isIMUSERSESSIONIDNull() {
        return this.IsParamNull(TAG_IMUSERSESSIONID);
    }

    public final String getIMUSERSESSIONID() {
        return this.GetParamStringValue(TAG_IMUSERSESSIONID, "");
    }

    public final void setIMUSERSESSIONID(String strValue) {
        this.SetParamValue(TAG_IMUSERSESSIONID, strValue);
    }

    public final boolean isUSERINFONull() {
        return this.IsParamNull(TAG_USERINFO);
    }

    public final String getUSERINFO() {
        return this.GetParamStringValue(TAG_USERINFO, "");
    }

    public final void setUSERINFO(String strValue) {
        this.SetParamValue(TAG_USERINFO, strValue);
    }

    public final boolean isNICKNAMENull() {
        return this.IsParamNull(TAG_NICKNAME);
    }

    public final String getNICKNAME() {
        return this.GetParamStringValue(TAG_NICKNAME, "");
    }

    public final void setNICKNAME(String strValue) {
        this.SetParamValue(TAG_NICKNAME, strValue);
    }

    public final boolean isICONPATHNull() {
        return this.IsParamNull(TAG_ICONPATH);
    }

    public final String getICONPATH() {
        return this.GetParamStringValue(TAG_ICONPATH, "");
    }

    public final void setICONPATH(String strValue) {
        this.SetParamValue(TAG_ICONPATH, strValue);
    }

    public final boolean isUSERTYPENull() {
        return this.IsParamNull(TAG_USERTYPE);
    }

    public final String getUSERTYPE() {
        return this.GetParamStringValue(TAG_USERTYPE, "");
    }

    public final void setUSERTYPE(String strValue) {
        this.SetParamValue(TAG_USERTYPE, strValue);
    }

    public final boolean isUSERLEVELNull() {
        return this.IsParamNull(TAG_USERLEVEL);
    }

    public final int getUSERLEVEL() {
        return this.GetParamIntValue(TAG_USERLEVEL, 0);
    }

    public final void setUSERLEVEL(int nValue) {
        this.SetParamValue(TAG_USERLEVEL, nValue);
    }

    public final boolean isTALKLEVELNull() {
        return this.IsParamNull(TAG_TALKLEVEL);
    }

    public final int getTALKLEVEL() {
        return this.GetParamIntValue(TAG_TALKLEVEL, 0);
    }

    public final void setTALKLEVEL(int nValue) {
        this.SetParamValue(TAG_TALKLEVEL, nValue);
    }

    public final boolean isALWAYSONLINENull() {
        return this.IsParamNull(TAG_ALWAYSONLINE);
    }

    public final boolean getALWAYSONLINE() {
        return this.GetParamIntValue(TAG_ALWAYSONLINE, 0) == 1;
    }

    public final void setALWAYSONLINE(boolean bValue) {
        this.SetParamValue(TAG_ALWAYSONLINE, bValue ? 1 : 0);
    }

    public final boolean isLASTINFORMTIMENull() {
        return this.IsParamNull(TAG_LASTINFORMTIME);
    }

    public final Timestamp getLASTINFORMTIME() {
        return this.GetParamTimestampValue(TAG_LASTINFORMTIME, null);
    }

    public final void setLASTINFORMTIME(Timestamp dtValue) {
        this.SetParamValue(TAG_LASTINFORMTIME, dtValue);
    }

    public final boolean isIMDOMAINNull() {
        return this.IsParamNull(TAG_IMDOMAIN);
    }

    public final String getIMDOMAIN() {
        return this.GetParamStringValue(TAG_IMDOMAIN, "");
    }

    public final void setIMDOMAIN(String strValue) {
        this.SetParamValue(TAG_IMDOMAIN, strValue);
    }

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isPASSWDNull() {
        return this.IsParamNull(TAG_PASSWD);
    }

    public final String getPASSWD() {
        return this.GetParamStringValue(TAG_PASSWD, "");
    }

    public final void setPASSWD(String strValue) {
        this.SetParamValue(TAG_PASSWD, strValue);
    }

    public final boolean isIMORGIDNull() {
        return this.IsParamNull(TAG_IMORGID);
    }

    public final String getIMORGID() {
        return this.GetParamStringValue(TAG_IMORGID, "");
    }

    public final void setIMORGID(String strValue) {
        this.SetParamValue(TAG_IMORGID, strValue);
    }

    public final boolean isIMORGNAMENull() {
        return this.IsParamNull(TAG_IMORGNAME);
    }

    public final String getIMORGNAME() {
        return this.GetParamStringValue(TAG_IMORGNAME, "");
    }

    public final void setIMORGNAME(String strValue) {
        this.SetParamValue(TAG_IMORGNAME, strValue);
    }

    public final boolean isORDERFLAGNull() {
        return this.IsParamNull(TAG_ORDERFLAG);
    }

    public final int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public final void setORDERFLAG(int nValue) {
        this.SetParamValue(TAG_ORDERFLAG, nValue);
    }

    public final boolean isPHONENull() {
        return this.IsParamNull(TAG_PHONE);
    }

    public final String getPHONE() {
        return this.GetParamStringValue(TAG_PHONE, "");
    }

    public final void setPHONE(String strValue) {
        this.SetParamValue(TAG_PHONE, strValue);
    }

    public final boolean isOFFICEPHONENull() {
        return this.IsParamNull(TAG_OFFICEPHONE);
    }

    public final String getOFFICEPHONE() {
        return this.GetParamStringValue(TAG_OFFICEPHONE, "");
    }

    public final void setOFFICEPHONE(String strValue) {
        this.SetParamValue(TAG_OFFICEPHONE, strValue);
    }

    public final boolean isSEXNull() {
        return this.IsParamNull(TAG_SEX);
    }

    public final String getSEX() {
        return this.GetParamStringValue(TAG_SEX, "");
    }

    public final void setSEX(String strValue) {
        this.SetParamValue(TAG_SEX, strValue);
    }

    public final boolean isSHORTPHONENull() {
        return this.IsParamNull(TAG_SHORTPHONE);
    }

    public final String getSHORTPHONE() {
        return this.GetParamStringValue(TAG_SHORTPHONE, "");
    }

    public final void setSHORTPHONE(String strValue) {
        this.SetParamValue(TAG_SHORTPHONE, strValue);
    }

    public final boolean isSHORTPHONE2Null() {
        return this.IsParamNull(TAG_SHORTPHONE2);
    }

    public final String getSHORTPHONE2() {
        return this.GetParamStringValue(TAG_SHORTPHONE2, "");
    }

    public final void setSHORTPHONE2(String strValue) {
        this.SetParamValue(TAG_SHORTPHONE2, strValue);
    }

    public final boolean isEMAILNull() {
        return this.IsParamNull(TAG_EMAIL);
    }

    public final String getEMAIL() {
        return this.GetParamStringValue(TAG_EMAIL, "");
    }

    public final void setEMAIL(String strValue) {
        this.SetParamValue(TAG_EMAIL, strValue);
    }

    public final boolean isDUTYNull() {
        return this.IsParamNull(TAG_DUTY);
    }

    public final String getDUTY() {
        return this.GetParamStringValue(TAG_DUTY, "");
    }

    public final void setDUTY(String strValue) {
        this.SetParamValue(TAG_DUTY, strValue);
    }

    public final boolean isDUTYLEVELNull() {
        return this.IsParamNull(TAG_DUTYLEVEL);
    }

    public final String getDUTYLEVEL() {
        return this.GetParamStringValue(TAG_DUTYLEVEL, "");
    }

    public final void setDUTYLEVEL(String strValue) {
        this.SetParamValue(TAG_DUTYLEVEL, strValue);
    }

    public final boolean isWORKPLACENull() {
        return this.IsParamNull(TAG_WORKPLACE);
    }

    public final String getWORKPLACE() {
        return this.GetParamStringValue(TAG_WORKPLACE, "");
    }

    public final void setWORKPLACE(String strValue) {
        this.SetParamValue(TAG_WORKPLACE, strValue);
    }

    public final boolean isHOLIDAYSTATENull() {
        return this.IsParamNull(TAG_HOLIDAYSTATE);
    }

    public final String getHOLIDAYSTATE() {
        return this.GetParamStringValue(TAG_HOLIDAYSTATE, "");
    }

    public final void setHOLIDAYSTATE(String strValue) {
        this.SetParamValue(TAG_HOLIDAYSTATE, strValue);
    }

    public final boolean isBIRTHDAYNull() {
        return this.IsParamNull(TAG_BIRTHDAY);
    }

    public final Date getBIRTHDAY() {
        return this.GetParamDateValue(TAG_BIRTHDAY, null);
    }

    public final void setBIRTHDAY(Date dtValue) {
        this.SetParamValue(TAG_BIRTHDAY, dtValue);
    }

    public final boolean isUSERDATANull() {
        return this.IsParamNull(TAG_USERDATA);
    }

    public final String getUSERDATA() {
        return this.GetParamStringValue(TAG_USERDATA, "");
    }

    public final void setUSERDATA(String strValue) {
        this.SetParamValue(TAG_USERDATA, strValue);
    }

    public final boolean isUSERDATA2Null() {
        return this.IsParamNull(TAG_USERDATA2);
    }

    public final String getUSERDATA2() {
        return this.GetParamStringValue(TAG_USERDATA2, "");
    }

    public final void setUSERDATA2(String strValue) {
        this.SetParamValue(TAG_USERDATA2, strValue);
    }

    public final boolean isUSERDATA3Null() {
        return this.IsParamNull(TAG_USERDATA3);
    }

    public final String getUSERDATA3() {
        return this.GetParamStringValue(TAG_USERDATA3, "");
    }

    public final void setUSERDATA3(String strValue) {
        this.SetParamValue(TAG_USERDATA3, strValue);
    }

    public final boolean isUSERDATA4Null() {
        return this.IsParamNull(TAG_USERDATA4);
    }

    public final String getUSERDATA4() {
        return this.GetParamStringValue(TAG_USERDATA4, "");
    }

    public final void setUSERDATA4(String strValue) {
        this.SetParamValue(TAG_USERDATA4, strValue);
    }

    public final boolean isUSERDATA5Null() {
        return this.IsParamNull(TAG_USERDATA5);
    }

    public final String getUSERDATA5() {
        return this.GetParamStringValue(TAG_USERDATA5, "");
    }

    public final void setUSERDATA5(String strValue) {
        this.SetParamValue(TAG_USERDATA5, strValue);
    }

    public final boolean isUSERDATA6Null() {
        return this.IsParamNull(TAG_USERDATA6);
    }

    public final String getUSERDATA6() {
        return this.GetParamStringValue(TAG_USERDATA6, "");
    }

    public final void setUSERDATA6(String strValue) {
        this.SetParamValue(TAG_USERDATA6, strValue);
    }

    public final boolean isUSERDATA7Null() {
        return this.IsParamNull(TAG_USERDATA7);
    }

    public final String getUSERDATA7() {
        return this.GetParamStringValue(TAG_USERDATA7, "");
    }

    public final void setUSERDATA7(String strValue) {
        this.SetParamValue(TAG_USERDATA7, strValue);
    }

    public final boolean isUSERDATA8Null() {
        return this.IsParamNull(TAG_USERDATA8);
    }

    public final String getUSERDATA8() {
        return this.GetParamStringValue(TAG_USERDATA8, "");
    }

    public final void setUSERDATA8(String strValue) {
        this.SetParamValue(TAG_USERDATA8, strValue);
    }

    public final boolean isUSERDATA9Null() {
        return this.IsParamNull(TAG_USERDATA9);
    }

    public final String getUSERDATA9() {
        return this.GetParamStringValue(TAG_USERDATA9, "");
    }

    public final void setUSERDATA9(String strValue) {
        this.SetParamValue(TAG_USERDATA9, strValue);
    }

    public final boolean isUSERDATA10Null() {
        return this.IsParamNull(TAG_USERDATA10);
    }

    public final String getUSERDATA10() {
        return this.GetParamStringValue(TAG_USERDATA10, "");
    }

    public final void setUSERDATA10(String strValue) {
        this.SetParamValue(TAG_USERDATA10, strValue);
    }

    public final boolean isRECENTFROMTIMENull() {
        return this.IsParamNull(TAG_RECENTFROMTIME);
    }

    public final Timestamp getRECENTFROMTIME() {
        return this.GetParamTimestampValue(TAG_RECENTFROMTIME, null);
    }

    public final void setRECENTFROMTIME(Timestamp dtValue) {
        this.SetParamValue(TAG_RECENTFROMTIME, dtValue);
    }
}

