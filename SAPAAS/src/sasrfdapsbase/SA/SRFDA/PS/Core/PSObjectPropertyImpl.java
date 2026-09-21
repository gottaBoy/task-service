/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.IPSObjectProperty;

public class PSObjectPropertyImpl
implements IPSObjectProperty {
    private IPSObject iPSObject = null;
    private String strName = null;
    private String strLogicName = null;
    private Object objValue = null;
    private String strValueText = null;
    private String strMemo = null;
    private String strGroupTag = "STD";
    private String strGroupName = "\u6807\u51c6";
    private int nState = PROPERTYSTATE_OK;
    private String strStateInfo = null;
    private IPSCodeList refPSCodeList = null;
    private IPSDataEntity refPSDataEntity = null;

    public PSObjectPropertyImpl(IPSObject iPSObject) {
        this.iPSObject = iPSObject;
    }

    @Override
    public IPSObject getPSObject() {
        return this.iPSObject;
    }

    @Override
    public String getName() {
        return this.strName;
    }

    @Override
    public String getLogicName() {
        return this.strLogicName;
    }

    @Override
    public Object getValue() {
        return this.objValue;
    }

    @Override
    public String getValueText() {
        return this.strValueText;
    }

    @Override
    public String getMemo() {
        return this.strMemo;
    }

    @Override
    public IPSCodeList getRefPSCodeList() {
        return this.refPSCodeList;
    }

    @Override
    public IPSDataEntity getRefPSDataEntity() {
        return this.refPSDataEntity;
    }

    @Override
    public int getState() {
        return this.nState;
    }

    @Override
    public String getStateInfo() {
        return this.strStateInfo;
    }

    @Override
    public String getGroupTag() {
        return this.strGroupTag;
    }

    @Override
    public String getGroupName() {
        return this.strGroupName;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public void setLogicName(String strLogicName) {
        this.strLogicName = strLogicName;
    }

    public void setValue(Object objValue) {
        this.objValue = objValue;
    }

    public void setValueText(String strValueText) {
        this.strValueText = strValueText;
    }

    public void setMemo(String strMemo) {
        this.strMemo = strMemo;
    }

    public void setGroupTag(String strGroupTag) {
        this.strGroupTag = strGroupTag;
    }

    public void setGroupName(String strGroupName) {
        this.strGroupName = strGroupName;
    }

    public void setState(int nState) {
        this.nState = nState;
    }

    public void setStateInfo(String strStateInfo) {
        this.strStateInfo = strStateInfo;
    }

    public void setRefPSCodeList(IPSCodeList refPSCodeList) {
        this.refPSCodeList = refPSCodeList;
    }

    public void setRefPSDataEntity(IPSDataEntity refPSDataEntity) {
        this.refPSDataEntity = refPSDataEntity;
    }
}

