/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.db.ISelectContext
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.config.entity.PSModel
 *  net.ibizsys.pscore.srv.config.service.PSModelService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMItem
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfgBase
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysDMItemService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Core.Util.FileWriterHelper;
import SA.SRFDA.PS.Core.Util.FileWriterHelper2;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSSysModelVer;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.config.entity.PSModel;
import net.ibizsys.pscore.srv.config.service.PSModelService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfgBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDMItemService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSSysModelVerDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSSysModelVerDataCtrl.class);
    public static final String CUSTOMCALL_INIT = "INIT";

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.compare((String)strCallName, (String)CUSTOMCALL_INIT, (boolean)true) == 0) {
            return this.initSysVer(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult initSysVer(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSSysModelVer psSysModelVer = new PSSysModelVer();
            psSysModelVer.proxy(dataEntity);
            if (!psSysModelVer.getACTIVEFLAG()) {
                throw new Exception(StringHelper.format((String)"[%1$s]\u4e0d\u662f\u5f53\u524d\u7248\u672c", (Object)psSysModelVer.getPSSYSMODELVERNAME()));
            }
            this.onInitSysVer(psSysModelVer);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u521d\u59cb\u5316\u7cfb\u7edf\u6a21\u578b\u7248\u672c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onInitSysVer(PSSysModelVer psSysModelVer) throws Exception {
        String strSysModelFolder = this.getGlobalHelper().getWebExConfig().GetValue("SRFPS", "SYSMODELFOLDER", null);
        if (StringHelper.isNullOrEmpty((String)strSysModelFolder)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7cfb\u7edf\u6a21\u578b\u76ee\u5f55");
        }
        if (StringHelper.compare((String)psSysModelVer.getSYSTYPE(), (String)"DEPSYS", (boolean)true) == 0) {
            strSysModelFolder = String.valueOf(strSysModelFolder) + "_DEP";
        }
        String strSysModelVerFolder = String.valueOf(strSysModelFolder) + StringHelper.format((String)"%1$s%2$s%1$s", (Object)File.separator, (Object)psSysModelVer.getMODELVER());
        File folder = new File(strSysModelFolder);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        if (!(folder = new File(strSysModelVerFolder)).exists()) {
            folder.mkdirs();
        }
        PSModelService psModelService = (PSModelService)ServiceGlobal.getService(PSModelService.class);
        SelectContext selectContext = new SelectContext();
        ArrayList<PSModel> psModelList = psModelService.selectEx((ISelectContext)selectContext);
        HashMap<String, PSModel> psModelMap = new HashMap<String, PSModel>();
        for (PSModel psModel : psModelList) {
            psModelMap.put(psModel.getPSModelId(), psModel);
        }
        String strPSSystemDBCfgId = "2ae7565e4906ca5fb225ecf4d5472b63";
        SessionFactory sessionFactory = null;
        PSSysDMItemService psSysDMItemService = null;
        if (StringHelper.compare((String)psSysModelVer.getSYSTYPE(), (String)"DEPSYS", (boolean)true) == 0) {
            String strPSSysModelInstId = "00E09EF1-8B4A-4D0E-8567-75E0605EAC82";
            strPSSystemDBCfgId = "2ae7565e4906ca5fb225ecf4d5472b63";
            sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)strPSSysModelInstId);
        }
        psSysDMItemService = (PSSysDMItemService)ServiceGlobal.getService(PSSysDMItemService.class, sessionFactory);
        PSSystemDBCfg psSystemDBCfg = new PSSystemDBCfg();
        psSystemDBCfg.setPSSystemDBCfgId(strPSSystemDBCfgId);
        ArrayList<PSSysDMItem> psSysDMItemList2 = psSysDMItemService.selectByPSSystemDBCfg((PSSystemDBCfgBase)psSystemDBCfg);
        ArrayList<PSSysDMItem> psSysDMItemList = new ArrayList<PSSysDMItem>();
        for (PSSysDMItem psSysDMItem : psSysDMItemList2) {
            if (!psModelMap.containsKey(psSysDMItem.getPSDEName())) continue;
            psSysDMItemList.add(psSysDMItem);
        }
        Collections.sort(psSysDMItemList, new Comparator<PSSysDMItem>(){

            @Override
            public int compare(PSSysDMItem arg0, PSSysDMItem arg1) {
                int nRet = StringHelper.compare((String)arg0.getPSDEName(), (String)arg1.getPSDEName(), (boolean)false);
                if (nRet != 0) {
                    return nRet;
                }
                return StringHelper.compare((String)arg0.getPSSysDMItemName(), (String)arg1.getPSSysDMItemName(), (boolean)false);
            }
        });
        StringBuilderEx sb = new StringBuilderEx();
        String strSrcSql = StringHelper.format((String)"%1$s%2$s1.sql", (Object)strSysModelFolder, (Object)File.separator);
        String strDstSql = StringHelper.format((String)"%1$s%2$s1.sql", (Object)strSysModelVerFolder, (Object)File.separator);
        String strContent = FileWriterHelper2.readFile(strSrcSql);
        sb.append(strContent);
        this.appendDMCode(sb, psSysDMItemList, "TABLE");
        FileWriterHelper.write(strDstSql, sb.toString());
        sb.reset();
        strSrcSql = StringHelper.format((String)"%1$s%2$s2.sql", (Object)strSysModelFolder, (Object)File.separator);
        strDstSql = StringHelper.format((String)"%1$s%2$s2.sql", (Object)strSysModelVerFolder, (Object)File.separator);
        strContent = FileWriterHelper2.readFile(strSrcSql);
        sb.append(strContent);
        this.appendDMCode(sb, psSysDMItemList, "COLUMN");
        FileWriterHelper.write(strDstSql, sb.toString());
        sb.reset();
        strSrcSql = StringHelper.format((String)"%1$s%2$s3.sql", (Object)strSysModelFolder, (Object)File.separator);
        strDstSql = StringHelper.format((String)"%1$s%2$s3.sql", (Object)strSysModelVerFolder, (Object)File.separator);
        strContent = FileWriterHelper2.readFile(strSrcSql);
        sb.append(strContent);
        this.appendDMCode(sb, psSysDMItemList, "FKEY");
        this.appendDMCode(sb, psSysDMItemList, "INDEX");
        FileWriterHelper.write(strDstSql, sb.toString());
        sb.reset();
        strSrcSql = StringHelper.format((String)"%1$s%2$s4.sql", (Object)strSysModelFolder, (Object)File.separator);
        strDstSql = StringHelper.format((String)"%1$s%2$s4.sql", (Object)strSysModelVerFolder, (Object)File.separator);
        strContent = FileWriterHelper2.readFile(strSrcSql);
        sb.append(strContent);
        this.appendDMCode(sb, psSysDMItemList, "VIEW");
        FileWriterHelper.write(strDstSql, sb.toString());
    }

    protected void appendDMCode(StringBuilderEx sb, ArrayList<PSSysDMItem> psSysDMItemList, String strDBObjType) {
        for (PSSysDMItem psSysDMItem : psSysDMItemList) {
            if (StringHelper.compare((String)psSysDMItem.getDBObjType(), (String)strDBObjType, (boolean)true) != 0) continue;
            if (!StringHelper.isNullOrEmpty((String)psSysDMItem.getDropSql())) {
                sb.append(psSysDMItem.getDropSql());
                sb.append("\r\n/**\u5206\u5272\u7ebf**/\r\n");
            }
            if (!StringHelper.isNullOrEmpty((String)psSysDMItem.getCreateSql3())) {
                sb.append(psSysDMItem.getCreateSql3());
                sb.append("\r\n/**\u5206\u5272\u7ebf**/\r\n");
            }
            if (!StringHelper.isNullOrEmpty((String)psSysDMItem.getCreateSql())) {
                sb.append(psSysDMItem.getCreateSql());
                sb.append("\r\n/**\u5206\u5272\u7ebf**/\r\n");
            } else if (!StringHelper.isNullOrEmpty((String)psSysDMItem.getCreateSql4())) {
                sb.append(psSysDMItem.getCreateSql4());
                sb.append("\r\n/**\u5206\u5272\u7ebf**/\r\n");
            }
            if (!StringHelper.isNullOrEmpty((String)psSysDMItem.getCreateSql2())) {
                sb.append(psSysDMItem.getCreateSql2());
                sb.append("\r\n/**\u5206\u5272\u7ebf**/\r\n");
            }
            if (!StringHelper.isNullOrEmpty((String)psSysDMItem.getCreateSql5())) {
                sb.append(psSysDMItem.getCreateSql5());
                sb.append("\r\n/**\u5206\u5272\u7ebf**/\r\n");
            }
            if (!StringHelper.isNullOrEmpty((String)psSysDMItem.getCreateSql6())) {
                sb.append(psSysDMItem.getCreateSql6());
                sb.append("\r\n/**\u5206\u5272\u7ebf**/\r\n");
            }
            if (StringHelper.isNullOrEmpty((String)psSysDMItem.getCreateSql7())) continue;
            sb.append(psSysDMItem.getCreateSql7());
            sb.append("\r\n/**\u5206\u5272\u7ebf**/\r\n");
        }
    }
}
