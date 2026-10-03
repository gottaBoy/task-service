/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.config.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Enumeration;
import java.util.Properties;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSFCodeTempl;
import net.ibizsys.pscore.srv.config.entity.PSSFCodeType;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.ibizsys.pscore.srv.config.service.PSSFCodeTypeService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSFStyleService
extends PSSFStyleServiceBase {
    public static final String PARAM_PRJFOLDER = "SRFPRJFOLDER";
    private static final Log log = LogFactory.getLog(PSSFStyleService.class);

    @Override
    protected void onExpStyle(PSSFStyle pSSFStyle) throws Exception {
        boolean bl;
        String string = DataObject.getStringValue((Object)pSSFStyle.get(PARAM_PRJFOLDER));
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u5f53\u524d\u6ca1\u6709\u6307\u5b9a\u9879\u76ee\u76ee\u5f55");
        }
        this.get(pSSFStyle);
        File file = new File(string);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (bl = true) {
            Properties properties;
            HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("${pub.getPKGCodeName()?replace('.','/')}", "%PUBPKG%");
            hashMap.put("${item.getPSSystemModule().codeName?lower_case}", "%MOD%");
            hashMap.put("${de.getPSSystemModule().codeName?lower_case}", "%DEMOD%");
            hashMap.put("${de.codeName?lower_case}", "%DE%");
            hashMap.put("${de.name?lower_case}", "%DENAME%");
            hashMap.put("${item.getPKGCodeName()?lower_case}", "%PKG%");
            hashMap.put("${app.getPKGCodeName()?lower_case}", "%APPPKG%");
            hashMap.put("${item.getPSApplication().getPKGCodeName()?lower_case}", "%ITEMAPPPKG%");
            hashMap.put("${item.getPSAppModule().codeName?lower_case}", "%APPMOD%");
            hashMap.put("${api.codeName?lower_case}", "%API%");
            hashMap.put("${item.getControlType()?lower_case}", "%CTRLTYPE%");
            hashMap.put("${appview.codeName?lower_case}", "%APPVIEW%");
            hashMap.put("${appview.getPSAppModule().codeName?lower_case}", "%VIEWMOD%");
            hashMap.put("${item.getPSWorkflow().codeName?lower_case}", "%WF%");
            hashMap.put("${item.getPSSysBDScheme().getShortCodeName()?lower_case}", "%BDSCHEME%");
            hashMap.put("${item.codeName?lower_case}", "%ITEM%");
            hashMap.put("${app.getAppFolder()?lower_case}", "%APPFOLDER%");
            hashMap.put("${item.getAppFolder()?lower_case}", "%APPFOLDER%");
            String string2 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string, (Object)File.separator, (Object)"macros.properties");
            File file2 = new File(string2);
            if (file2.exists() && (properties = PropertiesHelper.loadFromFile((String)string2)) != null) {
                Enumeration<?> keys = properties.keys();
                while (keys.hasMoreElements()) {
                    String key = (String)keys.nextElement();
                    String value = PropertiesHelper.getProperty(properties, key);
                    if (StringHelper.isNullOrEmpty(value)) continue;
                    hashMap.put(key, value);
                }
            }
            SelectCond selectCond = new SelectCond();
            selectCond.set("PSSFSTYLEID", pSSFStyle.getPSSFStyleId());
            PSSFCodeTypeService codeTypeService = (PSSFCodeTypeService)ServiceGlobal.getService(PSSFCodeTypeService.class, (SessionFactory)this.getSessionFactory());
            for (PSSFCodeType pSSFCodeType : codeTypeService.select(selectCond)) {
                String string3;
                if (!DataObject.getBoolValue((Integer)pSSFCodeType.getValidFlag(), (boolean)true)) continue;
                StringBuilderEx stringBuilderEx = new StringBuilderEx();
                stringBuilderEx.append("<#ibiztemplate>\r\n");
                stringBuilderEx.append("FILENAME=%1$s\r\n", (Object)pSSFCodeType.getFileName());
                stringBuilderEx.append("PUBOBJ=%1$s\r\n", (Object)pSSFCodeType.getPubObj().replace("SA.SRFDA.PS.Core.Pub.PSIBiz5", "").replace("PublisherImpl", ""));
                if (!StringHelper.isNullOrEmpty((String)pSSFCodeType.getPSModelId())) {
                    stringBuilderEx.append("MODELS=%1$s\r\n", (Object)pSSFCodeType.getPSModelId());
                }
                if (!StringHelper.isNullOrEmpty((String)(string3 = pSSFCodeType.getCodePath()))) {
                    for (Map.Entry<String, String> entry2 : hashMap.entrySet()) {
                        if (!string3.contains(entry2.getKey())) continue;
                        string3 = string3.replace(entry2.getKey(), entry2.getValue());
                        stringBuilderEx.append("%1$s=%2$s\r\n", entry2.getValue(), entry2.getKey());
                    }
                } else {
                    string3 = "";
                }
                Object object4 = null;
                object4 = StringHelper.isNullOrEmpty((String)string3) ? StringHelper.format((String)"%1$s%2$s%3$s", (Object)string, (Object)File.separator, (Object)pSSFCodeType.getPSSFCodeFolder().getFolderName()) : StringHelper.format((String)"%1$s%2$s%3$s%2$s%4$s", (Object)string, (Object)File.separator, (Object)pSSFCodeType.getPSSFCodeFolder().getFolderName(), (Object)string3);
                file = new File((String)object4);
                if (!file.exists()) {
                    file.mkdirs();
                }
                String filename = StringHelper.isNullOrEmpty((String)pSSFCodeType.getFileExt()) ? StringHelper.format((String)"%1$s.ftl", (Object)pSSFCodeType.getTypeCode()) : StringHelper.format((String)"%1$s.%2$s.ftl", (Object)pSSFCodeType.getTypeCode(), (Object)pSSFCodeType.getFileExt());
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)object4, (Object)File.separator, (Object)filename);
                stringBuilderEx.append("</#ibiztemplate>\r\n");
                stringBuilderEx.append(pSSFCodeType.getCodeTempl());
                PSPFStyleService.writeFile(string4, stringBuilderEx.toString());
                ArrayList<PSSFCodeTempl> arrayList = pSSFCodeType.getPSSFCodeTempls();
                for (PSSFCodeTempl pSSFCodeTempl : arrayList) {
                    if (!DataObject.getBoolValue((Integer)pSSFCodeTempl.getValidFlag(), (boolean)true)) continue;
                    filename = StringHelper.isNullOrEmpty((String)pSSFCodeType.getFileExt()) ? StringHelper.format((String)"%1$s#%2$s.ftl", (Object)pSSFCodeType.getTypeCode(), (Object)pSSFCodeTempl.getPSSFCodeTemplName()) : StringHelper.format((String)"%1$s.%2$s#%3$s.ftl", (Object)pSSFCodeType.getTypeCode(), (Object)pSSFCodeType.getFileExt(), (Object)pSSFCodeTempl.getPSSFCodeTemplName());
                    string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)object4, (Object)File.separator, (Object)filename);
                    PSPFStyleService.writeFile(string4, pSSFCodeTempl.getTemplCode());
                }
            }
        } else {
            SelectCond selectCond = new SelectCond();
            selectCond.set("PSSFSTYLEID", (Object)pSSFStyle.getPSSFStyleId());
            PSSFCodeTypeService pSSFCodeTypeService = (PSSFCodeTypeService)ServiceGlobal.getService(PSSFCodeTypeService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSSFCodeType> arrayList = pSSFCodeTypeService.select((ISelectCond)selectCond);
            for (PSSFCodeType pSSFCodeType : arrayList) {
                if (!DataObject.getBoolValue((Integer)pSSFCodeType.getValidFlag(), (boolean)true)) continue;
                String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string, (Object)File.separator, (Object)pSSFCodeType.getTypeCode());
                file = new File(string5);
                if (!file.exists()) {
                    file.mkdirs();
                }
                String string6 = null;
                string6 = StringHelper.isNullOrEmpty((String)pSSFCodeType.getFileExt()) ? StringHelper.format((String)"%1$s", (Object)"MAIN") : StringHelper.format((String)"%1$s.%2$s", (Object)"MAIN", (Object)pSSFCodeType.getFileExt());
                String string7 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string5, (Object)File.separator, (Object)string6);
                PSPFStyleService.writeFile(string7, pSSFCodeType.getTemplCode2());
                ArrayList<PSSFCodeTempl> arrayList2 = pSSFCodeType.getPSSFCodeTempls();
                for (PSSFCodeTempl pSSFCodeTempl : arrayList2) {
                    if (!DataObject.getBoolValue((Integer)pSSFCodeTempl.getValidFlag(), (boolean)true)) continue;
                    string6 = null;
                    string6 = StringHelper.isNullOrEmpty((String)pSSFCodeType.getFileExt()) ? StringHelper.format((String)"%1$s", (Object)pSSFCodeTempl.getPSSFCodeTemplName()) : StringHelper.format((String)"%1$s.%2$s", (Object)pSSFCodeTempl.getPSSFCodeTemplName(), (Object)pSSFCodeType.getFileExt());
                    string7 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string5, (Object)File.separator, (Object)string6);
                    PSPFStyleService.writeFile(string7, pSSFCodeTempl.getTemplCode2());
                }
            }
        }
    }

    @Override
    public DBFetchResult fetchCurDCSFAll2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            return pSSFStyleService.fetchCurDCSFAll2(iDEDataSetFetchContext);
        }
        return super.fetchCurDCSFAll2(iDEDataSetFetchContext);
    }

    @Override
    public DBFetchResult fetchCurDCSF2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            return pSSFStyleService.fetchCurDCSF2(iDEDataSetFetchContext);
        }
        return super.fetchCurDCSF2(iDEDataSetFetchContext);
    }

    @Override
    public DBFetchResult fetchCurDCSF(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            return pSSFStyleService.fetchCurDCSF(iDEDataSetFetchContext);
        }
        return super.fetchCurDCSF(iDEDataSetFetchContext);
    }

    @Override
    public DBFetchResult fetchCurDCDocAll(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            return pSSFStyleService.fetchCurDCDocAll(iDEDataSetFetchContext);
        }
        return super.fetchCurDCDocAll(iDEDataSetFetchContext);
    }

    @Override
    public DBFetchResult fetchCurDCDoc2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            return pSSFStyleService.fetchCurDCDoc2(iDEDataSetFetchContext);
        }
        return super.fetchCurDCDoc2(iDEDataSetFetchContext);
    }

    @Override
    public DBFetchResult fetchCurDCDoc(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            return pSSFStyleService.fetchCurDCDoc(iDEDataSetFetchContext);
        }
        return super.fetchCurDCDoc(iDEDataSetFetchContext);
    }

    @Override
    public DBFetchResult fetchCurDCDocAll2(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            return pSSFStyleService.fetchCurDCDocAll2(iDEDataSetFetchContext);
        }
        return super.fetchCurDCDocAll2(iDEDataSetFetchContext);
    }

    @Override
    public DBFetchResult fetchCurDCSF3(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            return pSSFStyleService.fetchCurDCSF3(iDEDataSetFetchContext);
        }
        return super.fetchCurDCSF3(iDEDataSetFetchContext);
    }

    @Override
    public DBFetchResult fetchCurDCDoc3(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            return pSSFStyleService.fetchCurDCDoc3(iDEDataSetFetchContext);
        }
        return super.fetchCurDCDoc3(iDEDataSetFetchContext);
    }

    @Override
    public DBFetchResult fetchCurDCSFAll(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            return pSSFStyleService.fetchCurDCSFAll(iDEDataSetFetchContext);
        }
        return super.fetchCurDCSFAll(iDEDataSetFetchContext);
    }

    @Override
    public DBFetchResult fetchCurSF(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            PSSFStyleService pSSFStyleService = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            return pSSFStyleService.fetchCurDCSFAll(iDEDataSetFetchContext);
        }
        return super.fetchCurSF(iDEDataSetFetchContext);
    }
}
