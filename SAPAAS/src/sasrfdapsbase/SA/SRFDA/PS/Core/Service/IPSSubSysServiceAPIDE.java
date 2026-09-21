/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEField;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEMethod;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDERS;
import SA.SRFDA.PS.Data.PSSubSysSADE;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5916\u90e8\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSubSysSADE")
public interface IPSSubSysServiceAPIDE
extends IPSModelObject {
    public void init(ISRFDAGlobalHelper var1, IPSSubSysServiceAPI var2, PSSubSysSADE var3) throws Exception;

    public IPSSubSysServiceAPI getPSSubSysServiceAPI();

    @Override
    public String getCodeName();

    public String getLogicName();

    public boolean isMajor();

    public Iterator<IPSSubSysServiceAPIDERS> getPSSubSysServiceAPIDERSs(boolean var1);

    public Iterator<IPSSubSysServiceAPIDERS> getPSSubSysServiceAPIDERSs();

    public Iterator<IPSSubSysServiceAPIDEField> getPSSubSysServiceAPIDEFields();

    public IPSSubSysServiceAPIDEField getPSSubSysServiceAPIDEField(String var1) throws Exception;

    public IPSSubSysServiceAPIDEField getPSSubSysServiceAPIDEField(String var1, boolean var2) throws Exception;

    public String getCodeName2();

    public int getPSSubSysSADERSPathCount() throws Exception;

    public Iterator<? extends IPSSubSysServiceAPIDERS> getPSSubSysSADERSPath(int var1) throws Exception;

    public IPSSubSysServiceAPIDERS getPSSubSysSADERSPathFirst(int var1) throws Exception;

    public IPSSubSysServiceAPIDERS getPSSubSysSADERSPathLast(int var1) throws Exception;

    public Iterator<? extends IPSSubSysServiceAPIDERS> getPSSubSysSADERSPath0() throws Exception;

    public Iterator<? extends IPSSubSysServiceAPIDERS> getPSSubSysSADERSPath1() throws Exception;

    public Iterator<? extends IPSSubSysServiceAPIDERS> getPSSubSysSADERSPath2() throws Exception;

    public Iterator<? extends IPSSubSysServiceAPIDERS> getPSSubSysSADERSPath3() throws Exception;

    public Iterator<? extends IPSSubSysServiceAPIDERS> getPSSubSysSADERSPath4() throws Exception;

    public Iterator<? extends IPSSubSysServiceAPIDEMethod> getPSSubSysServiceAPIDEMethods() throws Exception;

    public IPSSubSysServiceAPIDEMethod getPSSubSysServiceAPIDEMethod(String var1, boolean var2) throws Exception;

    public int getAPIMode();

    public boolean isNested();

    public String getDETag();

    public String getDETag2();

    public IPSSubSysServiceAPIDEField getKeyPSSubSysServiceAPIDEField();

    public IPSSubSysServiceAPIDEField getMajorPSSubSysServiceAPIDEField();

    public IPSSubSysServiceAPIDEField getKeyDEField();

    public IPSSubSysServiceAPIDEField getMajorDEField();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSFXCodeObject getRender();

    public String getMethodScriptCode();

    public String getServiceParam();

    public String getServiceParam2();
}

