/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.CodeList;

import SA.SRFDA.PS.Core.CodeList.IPSThresholdGroup;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Data.PSThreshold;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
public interface IPSThreshold
extends IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSThresholdGroup var2, PSThreshold var3) throws Exception;

    @Override
    public String getCodeName();

    public IPSSysCss getPSSysCss();

    public IPSSysImage getPSSysImage();

    public IPSLanguageRes getTextPSLanguageRes();

    public String getData();

    public IPSLanguageRes getTooltipPSLanguageRes();

    public String getTooltip();

    public String getText();

    public String getColor();

    public String getBKColor();

    public String getThresholdTag();

    public String getThresholdTag2();

    public String getTextLanResTag();

    public Double getBeginValue();

    public Double getEndValue();

    public boolean isIncludeBeginValue();

    public boolean isIncludeEndValue();
}

