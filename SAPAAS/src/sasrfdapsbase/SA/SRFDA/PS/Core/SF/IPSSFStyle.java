/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFCodeFolder;
import SA.SRFDA.PS.Core.SF.IPSSFObject;
import SA.SRFDA.PS.Core.SF.IPSSFStylePkg;
import SA.SRFDA.PS.Core.SF.IPSSFStylePrj;
import SA.SRFDA.PS.Core.SF.IPSSFStyleVer;
import SA.SRFDA.PS.Data.PSSFStyle;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

public interface IPSSFStyle
extends IPSSFObject {
    public static final int ENABLEWSSERVER_NO = 0;
    public static final int ENABLEWSSERVER_YES = 1;
    public static final int ENABLEWSSERVER_ONLY = 3;
    public static final int ENABLEDEPLOYCENTER_NO = 0;
    public static final int ENABLEDEPLOYCENTER_YES = 1;
    public static final int ENABLEDEPLOYCENTER_ONLY = 3;

    public void init(ISRFDAGlobalHelper var1, IPSSF var2, PSSFStyle var3) throws Exception;

    public Iterator<IPSSFCodeFolder> getPSSFCodeFolders() throws Exception;

    public Iterator<IPSSFCodeFolder> getPSSFCodeFolders(boolean var1) throws Exception;

    public IPSSFCodeFolder getPSSFCodeFolder(String var1) throws Exception;

    public void resetPSSFCodeFolder(String var1) throws Exception;

    public String getClassOrPkgName(String var1) throws Exception;

    public IPSSFStyleVer getPSSFStyleVer(String var1) throws Exception;

    public void resetPSSFStyleVer(String var1) throws Exception;

    public Iterator<IPSSFStylePrj> getPSSFStylePrjs() throws Exception;

    public IPSSFStylePrj getPSSFStylePrj(String var1, boolean var2) throws Exception;

    public Iterator<IPSSFStylePkg> getPSSFStylePkgs() throws Exception;

    public String getStyleParam(String var1, String var2);

    public int getStyleParam(String var1, int var2);

    public String getWorkshopFolder();

    public String getVersionString();

    public String getTemplDocRootUrl();

    public int getEnableWorkshopServer();

    public int getEnableDeployCenter();

    public IPSSFStyle getTemplPSSFStyle() throws Exception;

    public String getResourceUrl();

    public String getResLocalPath();
}

