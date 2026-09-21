/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonFormat
 *  com.fasterxml.jackson.annotation.JsonIgnore
 *  com.fasterxml.jackson.annotation.JsonProperty
 */
package net.ibizsys.modelapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;
import java.util.List;
import net.ibizsys.modelapi.dto.PSDELLCondDTO;
import net.ibizsys.modelapi.util.PSModelDTOBase;

public class PSDELogicLinkDTO
extends PSModelDTOBase {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_CREATEDATE = "createdate";
    public static final String FIELD_CREATEMAN = "createman";
    public static final String FIELD_DEBUGMODE = "debugmode";
    public static final String FIELD_DEFAULTLINK = "defaultlink";
    public static final String FIELD_DSTENDPOINT = "dstendpoint";
    public static final String FIELD_DSTPSDELOGICNODEID = "dstpsdelogicnodeid";
    public static final String FIELD_DSTPSDELOGICNODENAME = "dstpsdelogicnodename";
    public static final String FIELD_DSTPSDLPARAMID = "dstpsdlparamid";
    public static final String FIELD_DSTPSDLPARAMNAME = "dstpsdlparamname";
    public static final String FIELD_DYNAMODELFLAG = "dynamodelflag";
    public static final String FIELD_LINKCOND = "linkcond";
    public static final String FIELD_LINKCOND2 = "linkcond2";
    public static final String FIELD_LINKINFO = "linkinfo";
    public static final String FIELD_MEMO = "memo";
    public static final String FIELD_ORDERVALUE = "ordervalue";
    public static final String FIELD_PSDELOGICID = "psdelogicid";
    public static final String FIELD_PSDELOGICLINKID = "psdelogiclinkid";
    public static final String FIELD_PSDELOGICLINKNAME = "psdelogiclinkname";
    public static final String FIELD_PSDELOGICNAME = "psdelogicname";
    public static final String FIELD_SHAPEPARAMS = "shapeparams";
    public static final String FIELD_SRCENDPOINT = "srcendpoint";
    public static final String FIELD_SRCPSDELOGICNODEID = "srcpsdelogicnodeid";
    public static final String FIELD_SRCPSDELOGICNODENAME = "srcpsdelogicnodename";
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale="zh", timezone="GMT+8")
    public static final String FIELD_UPDATEDATE = "updatedate";
    public static final String FIELD_UPDATEMAN = "updateman";
    public static final String FIELD_USERCAT = "usercat";
    public static final String FIELD_USERTAG = "usertag";
    public static final String FIELD_USERTAG2 = "usertag2";
    public static final String FIELD_USERTAG3 = "usertag3";
    public static final String FIELD_USERTAG4 = "usertag4";
    private List<PSDELLCondDTO> psdellconds;

    @JsonIgnore
    public Timestamp getCreateDate() {
        Object objValue = this.get(FIELD_CREATEDATE);
        if (objValue == null) {
            return null;
        }
        return (Timestamp)objValue;
    }

    @JsonProperty(value="createdate")
    public void setCreateDate(Timestamp createDate) {
        this.set(FIELD_CREATEDATE, createDate);
    }

    @JsonIgnore
    public boolean isCreateDateDirty() {
        return this.contains(FIELD_CREATEDATE);
    }

    @JsonIgnore
    public String getCreateMan() {
        Object objValue = this.get(FIELD_CREATEMAN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="createman")
    public void setCreateMan(String createMan) {
        this.set(FIELD_CREATEMAN, createMan);
    }

    @JsonIgnore
    public boolean isCreateManDirty() {
        return this.contains(FIELD_CREATEMAN);
    }

    @JsonIgnore
    public Integer getDebugMode() {
        Object objValue = this.get(FIELD_DEBUGMODE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="debugmode")
    public void setDebugMode(Integer debugMode) {
        this.set(FIELD_DEBUGMODE, debugMode);
    }

    @JsonIgnore
    public boolean isDebugModeDirty() {
        return this.contains(FIELD_DEBUGMODE);
    }

    @JsonIgnore
    public Integer getDefaultLink() {
        Object objValue = this.get(FIELD_DEFAULTLINK);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="defaultlink")
    public void setDefaultLink(Integer defaultLink) {
        this.set(FIELD_DEFAULTLINK, defaultLink);
    }

    @JsonIgnore
    public boolean isDefaultLinkDirty() {
        return this.contains(FIELD_DEFAULTLINK);
    }

    @JsonIgnore
    public String getDstEndPoint() {
        Object objValue = this.get(FIELD_DSTENDPOINT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstendpoint")
    public void setDstEndPoint(String dstEndPoint) {
        this.set(FIELD_DSTENDPOINT, dstEndPoint);
    }

    @JsonIgnore
    public boolean isDstEndPointDirty() {
        return this.contains(FIELD_DSTENDPOINT);
    }

    @JsonIgnore
    public String getDstPSDELogicNodeId() {
        Object objValue = this.get(FIELD_DSTPSDELOGICNODEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdelogicnodeid")
    public void setDstPSDELogicNodeId(String dstPSDELogicNodeId) {
        this.set(FIELD_DSTPSDELOGICNODEID, dstPSDELogicNodeId);
    }

    @JsonIgnore
    public boolean isDstPSDELogicNodeIdDirty() {
        return this.contains(FIELD_DSTPSDELOGICNODEID);
    }

    @JsonIgnore
    public String getDstPSDELogicNodeName() {
        Object objValue = this.get(FIELD_DSTPSDELOGICNODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdelogicnodename")
    public void setDstPSDELogicNodeName(String dstPSDELogicNodeName) {
        this.set(FIELD_DSTPSDELOGICNODENAME, dstPSDELogicNodeName);
    }

    @JsonIgnore
    public boolean isDstPSDELogicNodeNameDirty() {
        return this.contains(FIELD_DSTPSDELOGICNODENAME);
    }

    @JsonIgnore
    public String getDstPSDLParamId() {
        Object objValue = this.get(FIELD_DSTPSDLPARAMID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdlparamid")
    public void setDstPSDLParamId(String dstPSDLParamId) {
        this.set(FIELD_DSTPSDLPARAMID, dstPSDLParamId);
    }

    @JsonIgnore
    public boolean isDstPSDLParamIdDirty() {
        return this.contains(FIELD_DSTPSDLPARAMID);
    }

    @JsonIgnore
    public String getDstPSDLParamName() {
        Object objValue = this.get(FIELD_DSTPSDLPARAMNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="dstpsdlparamname")
    public void setDstPSDLParamName(String dstPSDLParamName) {
        this.set(FIELD_DSTPSDLPARAMNAME, dstPSDLParamName);
    }

    @JsonIgnore
    public boolean isDstPSDLParamNameDirty() {
        return this.contains(FIELD_DSTPSDLPARAMNAME);
    }

    @JsonIgnore
    public Integer getDynaModelFlag() {
        Object objValue = this.get(FIELD_DYNAMODELFLAG);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="dynamodelflag")
    public void setDynaModelFlag(Integer dynaModelFlag) {
        this.set(FIELD_DYNAMODELFLAG, dynaModelFlag);
    }

    @JsonIgnore
    public boolean isDynaModelFlagDirty() {
        return this.contains(FIELD_DYNAMODELFLAG);
    }

    @JsonIgnore
    public String getLinkCond() {
        Object objValue = this.get(FIELD_LINKCOND);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="linkcond")
    public void setLinkCond(String linkCond) {
        this.set(FIELD_LINKCOND, linkCond);
    }

    @JsonIgnore
    public boolean isLinkCondDirty() {
        return this.contains(FIELD_LINKCOND);
    }

    @JsonIgnore
    public String getLinkCond2() {
        Object objValue = this.get(FIELD_LINKCOND2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="linkcond2")
    public void setLinkCond2(String linkCond2) {
        this.set(FIELD_LINKCOND2, linkCond2);
    }

    @JsonIgnore
    public boolean isLinkCond2Dirty() {
        return this.contains(FIELD_LINKCOND2);
    }

    @JsonIgnore
    public String getLinkInfo() {
        Object objValue = this.get(FIELD_LINKINFO);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="linkinfo")
    public void setLinkInfo(String linkInfo) {
        this.set(FIELD_LINKINFO, linkInfo);
    }

    @JsonIgnore
    public boolean isLinkInfoDirty() {
        return this.contains(FIELD_LINKINFO);
    }

    @JsonIgnore
    public String getMemo() {
        Object objValue = this.get(FIELD_MEMO);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="memo")
    public void setMemo(String memo) {
        this.set(FIELD_MEMO, memo);
    }

    @JsonIgnore
    public boolean isMemoDirty() {
        return this.contains(FIELD_MEMO);
    }

    @JsonIgnore
    public Integer getOrderValue() {
        Object objValue = this.get(FIELD_ORDERVALUE);
        if (objValue == null) {
            return null;
        }
        return (Integer)objValue;
    }

    @JsonProperty(value="ordervalue")
    public void setOrderValue(Integer orderValue) {
        this.set(FIELD_ORDERVALUE, orderValue);
    }

    @JsonIgnore
    public boolean isOrderValueDirty() {
        return this.contains(FIELD_ORDERVALUE);
    }

    @JsonIgnore
    public String getPSDELogicId() {
        Object objValue = this.get(FIELD_PSDELOGICID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelogicid")
    public void setPSDELogicId(String pSDELogicId) {
        this.set(FIELD_PSDELOGICID, pSDELogicId);
    }

    @JsonIgnore
    public boolean isPSDELogicIdDirty() {
        return this.contains(FIELD_PSDELOGICID);
    }

    @JsonIgnore
    public String getPSDELogicLinkId() {
        Object objValue = this.get(FIELD_PSDELOGICLINKID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelogiclinkid")
    public void setPSDELogicLinkId(String pSDELogicLinkId) {
        this.set(FIELD_PSDELOGICLINKID, pSDELogicLinkId);
    }

    @JsonIgnore
    public boolean isPSDELogicLinkIdDirty() {
        return this.contains(FIELD_PSDELOGICLINKID);
    }

    @JsonIgnore
    public String getPSDELogicLinkName() {
        Object objValue = this.get(FIELD_PSDELOGICLINKNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelogiclinkname")
    public void setPSDELogicLinkName(String pSDELogicLinkName) {
        this.set(FIELD_PSDELOGICLINKNAME, pSDELogicLinkName);
    }

    @JsonIgnore
    public boolean isPSDELogicLinkNameDirty() {
        return this.contains(FIELD_PSDELOGICLINKNAME);
    }

    @JsonIgnore
    public String getPSDELogicName() {
        Object objValue = this.get(FIELD_PSDELOGICNAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="psdelogicname")
    public void setPSDELogicName(String pSDELogicName) {
        this.set(FIELD_PSDELOGICNAME, pSDELogicName);
    }

    @JsonIgnore
    public boolean isPSDELogicNameDirty() {
        return this.contains(FIELD_PSDELOGICNAME);
    }

    @JsonIgnore
    public String getShapeParams() {
        Object objValue = this.get(FIELD_SHAPEPARAMS);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="shapeparams")
    public void setShapeParams(String shapeParams) {
        this.set(FIELD_SHAPEPARAMS, shapeParams);
    }

    @JsonIgnore
    public boolean isShapeParamsDirty() {
        return this.contains(FIELD_SHAPEPARAMS);
    }

    @JsonIgnore
    public String getSrcEndPoint() {
        Object objValue = this.get(FIELD_SRCENDPOINT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="srcendpoint")
    public void setSrcEndPoint(String srcEndPoint) {
        this.set(FIELD_SRCENDPOINT, srcEndPoint);
    }

    @JsonIgnore
    public boolean isSrcEndPointDirty() {
        return this.contains(FIELD_SRCENDPOINT);
    }

    @JsonIgnore
    public String getSrcPSDELogicNodeId() {
        Object objValue = this.get(FIELD_SRCPSDELOGICNODEID);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="srcpsdelogicnodeid")
    public void setSrcPSDELogicNodeId(String srcPSDELogicNodeId) {
        this.set(FIELD_SRCPSDELOGICNODEID, srcPSDELogicNodeId);
    }

    @JsonIgnore
    public boolean isSrcPSDELogicNodeIdDirty() {
        return this.contains(FIELD_SRCPSDELOGICNODEID);
    }

    @JsonIgnore
    public String getSrcPSDELogicNodeName() {
        Object objValue = this.get(FIELD_SRCPSDELOGICNODENAME);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="srcpsdelogicnodename")
    public void setSrcPSDELogicNodeName(String srcPSDELogicNodeName) {
        this.set(FIELD_SRCPSDELOGICNODENAME, srcPSDELogicNodeName);
    }

    @JsonIgnore
    public boolean isSrcPSDELogicNodeNameDirty() {
        return this.contains(FIELD_SRCPSDELOGICNODENAME);
    }

    @JsonIgnore
    public Timestamp getUpdateDate() {
        Object objValue = this.get(FIELD_UPDATEDATE);
        if (objValue == null) {
            return null;
        }
        return (Timestamp)objValue;
    }

    @JsonProperty(value="updatedate")
    public void setUpdateDate(Timestamp updateDate) {
        this.set(FIELD_UPDATEDATE, updateDate);
    }

    @JsonIgnore
    public boolean isUpdateDateDirty() {
        return this.contains(FIELD_UPDATEDATE);
    }

    @JsonIgnore
    public String getUpdateMan() {
        Object objValue = this.get(FIELD_UPDATEMAN);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="updateman")
    public void setUpdateMan(String updateMan) {
        this.set(FIELD_UPDATEMAN, updateMan);
    }

    @JsonIgnore
    public boolean isUpdateManDirty() {
        return this.contains(FIELD_UPDATEMAN);
    }

    @JsonIgnore
    public String getUserCat() {
        Object objValue = this.get(FIELD_USERCAT);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usercat")
    public void setUserCat(String userCat) {
        this.set(FIELD_USERCAT, userCat);
    }

    @JsonIgnore
    public boolean isUserCatDirty() {
        return this.contains(FIELD_USERCAT);
    }

    @JsonIgnore
    public String getUserTag() {
        Object objValue = this.get(FIELD_USERTAG);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usertag")
    public void setUserTag(String userTag) {
        this.set(FIELD_USERTAG, userTag);
    }

    @JsonIgnore
    public boolean isUserTagDirty() {
        return this.contains(FIELD_USERTAG);
    }

    @JsonIgnore
    public String getUserTag2() {
        Object objValue = this.get(FIELD_USERTAG2);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usertag2")
    public void setUserTag2(String userTag2) {
        this.set(FIELD_USERTAG2, userTag2);
    }

    @JsonIgnore
    public boolean isUserTag2Dirty() {
        return this.contains(FIELD_USERTAG2);
    }

    @JsonIgnore
    public String getUserTag3() {
        Object objValue = this.get(FIELD_USERTAG3);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usertag3")
    public void setUserTag3(String userTag3) {
        this.set(FIELD_USERTAG3, userTag3);
    }

    @JsonIgnore
    public boolean isUserTag3Dirty() {
        return this.contains(FIELD_USERTAG3);
    }

    @JsonIgnore
    public String getUserTag4() {
        Object objValue = this.get(FIELD_USERTAG4);
        if (objValue == null) {
            return null;
        }
        return (String)objValue;
    }

    @JsonProperty(value="usertag4")
    public void setUserTag4(String userTag4) {
        this.set(FIELD_USERTAG4, userTag4);
    }

    @JsonIgnore
    public boolean isUserTag4Dirty() {
        return this.contains(FIELD_USERTAG4);
    }

    @Override
    @JsonIgnore
    public String getSrfkey() {
        return this.getPSDELogicLinkId();
    }

    @Override
    public void setSrfkey(String strValue) {
        this.setPSDELogicLinkId(strValue);
    }

    @JsonProperty(value="psdellconds")
    public List<PSDELLCondDTO> getPsdellconds() {
        return this.psdellconds;
    }

    @JsonProperty(value="psdellconds")
    public void setPsdellconds(List<PSDELLCondDTO> psdellconds) {
        this.psdellconds = psdellconds;
    }
}

