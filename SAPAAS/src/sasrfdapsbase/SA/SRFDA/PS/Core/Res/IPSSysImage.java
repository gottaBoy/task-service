/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysImage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u7cfb\u7edf\u56fe\u7247\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysImage")
public interface IPSSysImage
extends IPSSystemObject {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysImage var3) throws Exception;

    public String getPSImageTemplId();

    public String getImagePath();

    public String getCssClass();

    public String getImagePathX();

    public String getCssClassX();

    public String getGlyph();

    public String getImagePath(int var1);

    public String getCssClass(int var1);

    public int getWidth();

    public int getHeight();

    @Override
    public String getCodeName();

    public IPSSystemModule getPSSystemModule();

    public String getRawContent();
}

