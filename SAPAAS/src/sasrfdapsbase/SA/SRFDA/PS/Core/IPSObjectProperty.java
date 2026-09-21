/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSObjectProperty {
    public static final Integer PROPERTYSTATE_OK = 0;
    public static final Integer PROPERTYSTATE_WARN = 1;
    public static final Integer PROPERTYSTATE_ERROR = 2;
    public static final String GROUP_STD = "STD";
    public static final String GROUP_ADV = "ADV";
    public static final String GROUP_USER01 = "USER01";
    public static final String GROUP_USER02 = "USER02";
    public static final String GROUP_USER03 = "USER03";

    public IPSObject getPSObject();

    public String getName();

    public String getLogicName();

    public Object getValue();

    public String getValueText();

    public String getMemo();

    public IPSCodeList getRefPSCodeList();

    public IPSDataEntity getRefPSDataEntity();

    public int getState();

    public String getStateInfo();

    public String getGroupTag();

    public String getGroupName();
}

