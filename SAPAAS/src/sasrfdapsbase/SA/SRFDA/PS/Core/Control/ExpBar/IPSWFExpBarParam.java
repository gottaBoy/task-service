/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.Control.ExpBar.IPSExpBarParam;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;

@PSModelInterfaceMeta(title="\u5de5\u4f5c\u6d41\u5bfc\u822a\u680f\u53c2\u6570\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
@PSModelRTIgnoreMeta
public interface IPSWFExpBarParam
extends IPSExpBarParam {
    public static final String SECTION_MYDATA = "MY";
    public static final String SECTION_ALLDATA = "ALL";
    public static final String SECTION_MYWFWORK = "MYWFWORK";
    public static final String SECTION_PROCESSING = "PROCESSING";

    public boolean isOutputMyWorkFirst();

    public boolean hasOutputMyWorkFirstParam();

    public boolean isExpandMyWork();

    public boolean isOutputMyHistoryWork();

    public String getWFDataSector();

    public String getMyHistoryWorkName();

    public String getMyWorkName();

    public boolean isOutputWFParallelFolder();

    public boolean isOutputMyDataWFSteps();

    public boolean hasOutputMyDataWFStepsParam();
}

