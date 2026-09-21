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
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Res.IPSSysContent;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysContentCat;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u9884\u7f6e\u5185\u5bb9\u5206\u7c7b\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysContentCat")
public interface IPSSysContentCat
extends IPSSystemObject,
IPSSysSFPubObject {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, IPSSysContentCat var3, PSSysContentCat var4) throws Exception;

    @Override
    public String getCodeName();

    public IPSSystemModule getPSSystemModule();

    public String getCatTag();

    public String getCatTag2();

    public IPSSysContentCat getParentPSSysContentCat();

    public Iterator<IPSSysContent> getPSSysContents() throws Exception;

    public IPSSysContent getPSSysContent(String var1) throws Exception;

    public IPSSysContent getPSSysContent(String var1, boolean var2) throws Exception;

    public void resetPSSysContent(String var1) throws Exception;

    public void resetPSSysContents();

    public Iterator<IPSSysContentCat> getPSSysContentCats() throws Exception;

    public IPSSysContentCat getPSSysContentCat(String var1) throws Exception;

    public IPSSysContentCat getPSSysContentCat(String var1, boolean var2) throws Exception;

    public void resetPSSysContentCat(String var1) throws Exception;

    public void resetPSSysContentCats();
}

