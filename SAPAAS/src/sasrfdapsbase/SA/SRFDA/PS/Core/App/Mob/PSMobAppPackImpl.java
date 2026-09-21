/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.Mob;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.Mob.IPSMobAppPack;
import SA.SRFDA.PS.Core.App.Mob.IPSMobAppPackCert;
import SA.SRFDA.PS.Core.Deploy.IPSMobAppPackServer;
import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Data.PSMobAppPack;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSMobAppPackImpl
extends PSDCResObjectImplBase
implements IPSMobAppPack {
    private static final Log log = LogFactory.getLog(PSMobAppPackImpl.class);
    protected PSMobAppPack psMobAppPack = null;
    private boolean bEnableIOS = false;
    private boolean bEnableAndroid = false;
    private ArrayList<String> iOSDeviceList = new ArrayList();
    private ArrayList<String> iOSPrivicyList = new ArrayList();
    private ArrayList<String> androidPermissionList = new ArrayList();
    private String strPKGName = null;
    private String strPackVersion = null;
    private IPSMobAppPackCert iPSMobAppPackCert = null;
    private IPSMobAppPackServer iPSMobAppPackServer = null;
    protected IPSApplication iPSApplication = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSMobAppPack psMobAppPack) throws Exception {
        try {
            String strItem;
            String[] items;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.psMobAppPack = psMobAppPack;
            this.setId(this.psMobAppPack.getPSMOBAPPPACKID());
            this.setName(this.psMobAppPack.getPSMOBAPPPACKNAME());
            this.setPSObjectData(psMobAppPack);
            String[] stringArray = items = this.psMobAppPack.getOSTYPES().split("[;]");
            int n = items.length;
            int n2 = 0;
            while (n2 < n) {
                String strOSType = stringArray[n2];
                if (StringHelper.compare((String)strOSType, (String)"IOS", (boolean)false) == 0) {
                    this.bEnableIOS = true;
                } else if (StringHelper.compare((String)strOSType, (String)"ANDROID", (boolean)false) == 0) {
                    this.bEnableAndroid = true;
                }
                ++n2;
            }
            if (!this.psMobAppPack.isENABLEANDROIDNull()) {
                this.bEnableAndroid = this.psMobAppPack.getENABLEANDROID();
            }
            if (!this.psMobAppPack.isENABLEIOSNull()) {
                this.bEnableIOS = this.psMobAppPack.getENABLEIOS();
            }
            stringArray = items = this.psMobAppPack.getIOSPRIVACIES().split("[;]");
            n = items.length;
            n2 = 0;
            while (n2 < n) {
                strItem = stringArray[n2];
                this.iOSPrivicyList.add(strItem);
                ++n2;
            }
            stringArray = items = this.psMobAppPack.getIOSDEVICES().split("[;]");
            n = items.length;
            n2 = 0;
            while (n2 < n) {
                strItem = stringArray[n2];
                this.iOSDeviceList.add(strItem);
                ++n2;
            }
            stringArray = items = this.psMobAppPack.getANDROIDPERMISSIONS().split("[;]");
            n = items.length;
            n2 = 0;
            while (n2 < n) {
                strItem = stringArray[n2];
                this.androidPermissionList.add(strItem);
                ++n2;
            }
            this.strPKGName = this.psMobAppPack.getPKGNAME();
            this.strPackVersion = this.psMobAppPack.getVERSION();
            if (!StringHelper.isNullOrEmpty((String)this.psMobAppPack.getPSDCMOBPACKCERTID())) {
                this.iPSMobAppPackCert = iPSApplication.getPSMobAppPackCert(this.psMobAppPack.getPSDCMOBPACKCERTID());
            }
            if (!StringHelper.isNullOrEmpty((String)PSTaskServerEnvImpl.getCurrent().getPSMobAppPackServerId())) {
                this.iPSMobAppPackServer = this.getPSModelStorage().getPSMobAppPackServer(PSTaskServerEnvImpl.getCurrent().getPSMobAppPackServerId());
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSMOBAPPPACK";
    }

    @Override
    public boolean isEnableIOS() {
        return this.bEnableIOS;
    }

    @Override
    public boolean isEnableAndroid() {
        return this.bEnableAndroid;
    }

    @Override
    public Iterator<String> getIOSDevices() {
        return this.iOSDeviceList.iterator();
    }

    @Override
    public boolean isSupportIOSDevice(String strDevice) {
        return this.iOSDeviceList.contains(strDevice);
    }

    @Override
    public Iterator<String> getIOSPrivicies() {
        return this.iOSPrivicyList.iterator();
    }

    @Override
    public Iterator<String> getAndroidPermissions() {
        return this.androidPermissionList.iterator();
    }

    @Override
    public String getPackType() {
        return this.iPSMobAppPackCert.getPackType();
    }

    @Override
    public String getPKGName() {
        return this.strPKGName;
    }

    @Override
    public String getPackVersion() {
        return this.strPackVersion;
    }

    @Override
    public IPSMobAppPackCert getPSMobAppPackCert() {
        return this.iPSMobAppPackCert;
    }

    @Override
    public IPSMobAppPackServer getPSMobAppPackServer() {
        return this.iPSMobAppPackServer;
    }

    @Override
    public IPSApplication getPSApplication() {
        return this.iPSApplication;
    }

    protected void setPSApplication(IPSApplication iPSApplication) {
        this.iPSApplication = iPSApplication;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSApplication().getPSSysModelInstId();
    }

    public IPSSystem getPSSystem() {
        return this.getPSApplication().getPSSystem();
    }

    @Override
    protected void onFillResCfgParams(Map<String, String> params) throws Exception {
        params.put("mobapp.id", this.getPSApplication().getId());
        params.put("mobapp.name", this.getPSApplication().getName());
        params.put("mobapp.pkgname", this.getPSApplication().getPKGCodeName());
        params.put("apppack.id", this.getId());
        params.put("apppack.name", this.getName());
        params.put("apppack.pkgname", this.getPKGName());
        params.put("apppack.type", this.getPackType());
        params.put("apppack.ver", this.getPackVersion());
        params.put("apppack.android.permissions", this.psMobAppPack.getANDROIDPERMISSIONS());
        params.put("apppack.ios.devices", this.psMobAppPack.getIOSDEVICES());
        params.put("apppack.ios.privacies", this.psMobAppPack.getIOSPRIVACIES());
        super.onFillResCfgParams(params);
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSApplication().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSystem());
    }

    @Override
    public boolean isEnableDynaModel() {
        return false;
    }

    @Override
    public int getDynaInstMode() {
        return 0;
    }

    @Override
    public String getDynaInstTag2() {
        return null;
    }

    @Override
    public String getDynaModelFolder() {
        return null;
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }
}

