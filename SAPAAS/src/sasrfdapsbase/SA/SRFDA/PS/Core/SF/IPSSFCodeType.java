/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Pub.IPSSFSysCodePublisher;
import SA.SRFDA.PS.Core.SF.IPSSFCodeFolder;
import SA.SRFDA.PS.Core.SF.IPSSFCodeTempl;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Data.PSSFCodeType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

public interface IPSSFCodeType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, IPSSFCodeFolder var2, PSSFCodeType var3) throws Exception;

    public IPSSFStyle getPSSFStyle();

    public IPSSFCodeFolder getPSSFCodeFolder();

    public IPSSFCodeTempl getPSSFCodeTemplByTag(String var1) throws Exception;

    public IPSSFCodeTempl getPSSFCodeTemplByTag(String var1, boolean var2) throws Exception;

    public IPSSFCodeTempl getPSSFCodeTempl(String var1) throws Exception;

    public IPSSFCodeTempl getPSSFCodeTempl(String var1, boolean var2) throws Exception;

    public void resetPSSFCodeTempl(String var1) throws Exception;

    public Iterator<IPSSFCodeTempl> getPSSFCodeTempls() throws Exception;

    public String getTypeCode();

    public IPSSFSysCodePublisher getPSSFSysCodePublisher() throws Exception;

    public void releasePSSFSysCodePublisher(IPSSFSysCodePublisher var1);

    public void resetPSSFSysCodePublishers();

    public PSSFCodeType getPSSFCodeTypeData();

    public boolean isGlobalCodeType();

    public String getFileName();

    public String getFileExt();

    public boolean testPubPSModelCode(String var1);

    public String getTemplDocUrl();

    public boolean isRemoveMode();

    public boolean isDebugModeOnly();

    public boolean isDefaultPub();
}

