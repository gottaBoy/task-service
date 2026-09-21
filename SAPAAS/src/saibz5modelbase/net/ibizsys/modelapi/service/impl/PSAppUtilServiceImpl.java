/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.util.StringUtils
 */
package net.ibizsys.modelapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import net.ibizsys.modelapi.domain.PSAppUtil;
import net.ibizsys.modelapi.domain.PSSysApp;
import net.ibizsys.modelapi.dto.PSAppUtilDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSysAppDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.service.IPSAppUtilService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSAppUtilServiceImpl
extends PSModelServiceImplBase<PSAppUtil, PSAppUtilDTO>
implements IPSAppUtilService {
    private static final Log log = LogFactory.getLog(PSAppUtilServiceImpl.class);

    @Override
    public List<PSAppUtil> listByPSSysApp(PSSysApp parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSAppUtil get(PSSysApp parent, String strKey, boolean bTryMode) throws Exception {
        List<PSAppUtil> list = this.listByPSSysApp(parent);
        if (list != null) {
            for (PSAppUtil item : list) {
                String strTag = item.getSrfTag();
                if (!StringUtils.hasLength((String)strTag)) {
                    item.init();
                    strTag = this.getModelTag(item);
                }
                if (strKey.compareTo(strTag) != 0) continue;
                return item;
            }
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b\uff0c\u6807\u8bb0\u4e3a[%1$s]", strKey));
    }

    @Override
    public List<PSAppUtilDTO> listDTOByPSSysApp(String strParentKey) throws Exception {
        PSSysApp pssysapp = (PSSysApp)PSModelServiceUtil.getInstance().getPSSysAppService().get(strParentKey);
        List<PSAppUtil> list = this.listByPSSysApp(pssysapp);
        if (list != null) {
            ArrayList<PSAppUtilDTO> dtoList = new ArrayList<PSAppUtilDTO>();
            for (PSAppUtil item : list) {
                PSAppUtilDTO dto = (PSAppUtilDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSAppUtil> onListAll() throws Exception {
        ArrayList<PSAppUtil> list = new ArrayList<PSAppUtil>();
        List pssysapps = PSModelServiceUtil.getInstance().getPSSysAppService().listAll();
        if (pssysapps != null) {
            for (PSSysApp parent : pssysapps) {
                List<PSAppUtil> items = this.listByPSSysApp(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if (list.size() == 0) {
            return null;
        }
        return list;
    }

    @Override
    protected PSAppUtil onGet(String strParentKey, String strCurKey) throws Exception {
        PSAppUtil item;
        PSSysApp pssysapp = (PSSysApp)PSModelServiceUtil.getInstance().getPSSysAppService().get(strParentKey, true);
        if (pssysapp != null && (item = this.get(pssysapp, strCurKey, true)) != null) {
            return item;
        }
        return (PSAppUtil)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSAppUtilDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysAppId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysAppService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSAppUtil et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSAppUtilDTO dto, PSAppUtil t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSAppUtilId(t.getId().replace("/", "."));
        }
        if (t.getCodeName() != null || !bIgnoreNull) {
            dto.setCodeName(t.getCodeName());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSAppUtilName() != null || !bIgnoreNull) {
            dto.setPSAppUtilName(t.getPSAppUtilName());
        }
        if (t.getPSSysAppId() != null || !bIgnoreNull) {
            dto.setPSSysAppId(t.getPSSysAppId());
        }
        if (t.getPSSysAppName() != null || !bIgnoreNull) {
            dto.setPSSysAppName(t.getPSSysAppName());
        }
        if (t.getPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelId(t.getPSSysDynaModelId());
        }
        if (t.getPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelName(t.getPSSysDynaModelName());
        }
        if (t.getPSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginId(t.getPSSysPFPluginId());
        }
        if (t.getPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginName(t.getPSSysPFPluginName());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (t.getUserCat() != null || !bIgnoreNull) {
            dto.setUserCat(t.getUserCat());
        }
        if (t.getUserTag() != null || !bIgnoreNull) {
            dto.setUserTag(t.getUserTag());
        }
        if (t.getUserTag2() != null || !bIgnoreNull) {
            dto.setUserTag2(t.getUserTag2());
        }
        if (t.getUserTag3() != null || !bIgnoreNull) {
            dto.setUserTag3(t.getUserTag3());
        }
        if (t.getUserTag4() != null || !bIgnoreNull) {
            dto.setUserTag4(t.getUserTag4());
        }
        if (t.getUtilObj() != null || !bIgnoreNull) {
            dto.setUtilObj(t.getUtilObj());
        }
        if (t.getUtilParam() != null || !bIgnoreNull) {
            dto.setUtilParam(t.getUtilParam());
        }
        if (t.getUtilParam10() != null || !bIgnoreNull) {
            dto.setUtilParam10(t.getUtilParam10());
        }
        if (t.getUtilParam11() != null || !bIgnoreNull) {
            dto.setUtilParam11(t.getUtilParam11());
        }
        if (t.getUtilParam12() != null || !bIgnoreNull) {
            dto.setUtilParam12(t.getUtilParam12());
        }
        if (t.getUtilParam2() != null || !bIgnoreNull) {
            dto.setUtilParam2(t.getUtilParam2());
        }
        if (t.getUtilParam3() != null || !bIgnoreNull) {
            dto.setUtilParam3(t.getUtilParam3());
        }
        if (t.getUtilParam4() != null || !bIgnoreNull) {
            dto.setUtilParam4(t.getUtilParam4());
        }
        if (t.getUtilParam5() != null || !bIgnoreNull) {
            dto.setUtilParam5(t.getUtilParam5());
        }
        if (t.getUtilParam6() != null || !bIgnoreNull) {
            dto.setUtilParam6(t.getUtilParam6());
        }
        if (t.getUtilParam7() != null || !bIgnoreNull) {
            dto.setUtilParam7(t.getUtilParam7());
        }
        if (t.getUtilParam8() != null || !bIgnoreNull) {
            dto.setUtilParam8(t.getUtilParam8());
        }
        if (t.getUtilParam9() != null || !bIgnoreNull) {
            dto.setUtilParam9(t.getUtilParam9());
        }
        if (t.getUtilParams() != null || !bIgnoreNull) {
            dto.setUtilParams(t.getUtilParams());
        }
        if (t.getUtilPSDE2Id() != null || !bIgnoreNull) {
            dto.setUtilPSDE2Id(t.getUtilPSDE2Id());
        }
        if (t.getUtilPSDE2Name() != null || !bIgnoreNull) {
            dto.setUtilPSDE2Name(t.getUtilPSDE2Name());
        }
        if (t.getUtilPSDE3Id() != null || !bIgnoreNull) {
            dto.setUtilPSDE3Id(t.getUtilPSDE3Id());
        }
        if (t.getUtilPSDE3Name() != null || !bIgnoreNull) {
            dto.setUtilPSDE3Name(t.getUtilPSDE3Name());
        }
        if (t.getUtilPSDE4Id() != null || !bIgnoreNull) {
            dto.setUtilPSDE4Id(t.getUtilPSDE4Id());
        }
        if (t.getUtilPSDE4Name() != null || !bIgnoreNull) {
            dto.setUtilPSDE4Name(t.getUtilPSDE4Name());
        }
        if (t.getUtilPSDE5Id() != null || !bIgnoreNull) {
            dto.setUtilPSDE5Id(t.getUtilPSDE5Id());
        }
        if (t.getUtilPSDE5Name() != null || !bIgnoreNull) {
            dto.setUtilPSDE5Name(t.getUtilPSDE5Name());
        }
        if (t.getUtilPSDE6Id() != null || !bIgnoreNull) {
            dto.setUtilPSDE6Id(t.getUtilPSDE6Id());
        }
        if (t.getUtilPSDE6Name() != null || !bIgnoreNull) {
            dto.setUtilPSDE6Name(t.getUtilPSDE6Name());
        }
        if (t.getUtilPSDE7Id() != null || !bIgnoreNull) {
            dto.setUtilPSDE7Id(t.getUtilPSDE7Id());
        }
        if (t.getUtilPSDE7Name() != null || !bIgnoreNull) {
            dto.setUtilPSDE7Name(t.getUtilPSDE7Name());
        }
        if (t.getUtilPSDE8Id() != null || !bIgnoreNull) {
            dto.setUtilPSDE8Id(t.getUtilPSDE8Id());
        }
        if (t.getUtilPSDE8Name() != null || !bIgnoreNull) {
            dto.setUtilPSDE8Name(t.getUtilPSDE8Name());
        }
        if (t.getUtilPSDE9Id() != null || !bIgnoreNull) {
            dto.setUtilPSDE9Id(t.getUtilPSDE9Id());
        }
        if (t.getUtilPSDE9Name() != null || !bIgnoreNull) {
            dto.setUtilPSDE9Name(t.getUtilPSDE9Name());
        }
        if (t.getUtilPSDEId() != null || !bIgnoreNull) {
            dto.setUtilPSDEId(t.getUtilPSDEId());
        }
        if (t.getUtilPSDEName() != null || !bIgnoreNull) {
            dto.setUtilPSDEName(t.getUtilPSDEName());
        }
        if (t.getUtilTag() != null || !bIgnoreNull) {
            dto.setUtilTag(t.getUtilTag());
        }
        if (t.getUtilType() != null || !bIgnoreNull) {
            dto.setUtilType(t.getUtilType());
        }
        if (t.getValidFlag() != null || !bIgnoreNull) {
            dto.setValidFlag(t.getValidFlag());
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            dto.setPSSysAppId(this.getRealPSModelId(t, dto.getPSSysAppId()).replace("/", "."));
        }
        if ("PSSYSAPP".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysAppId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            dto.setPSSysDynaModelId(this.getRealPSModelId(t, dto.getPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            dto.setPSSysPFPluginId(this.getRealPSModelId(t, dto.getPSSysPFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE2Id())) {
            dto.setUtilPSDE2Id(this.getRealPSModelId(t, dto.getUtilPSDE2Id()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE3Id())) {
            dto.setUtilPSDE3Id(this.getRealPSModelId(t, dto.getUtilPSDE3Id()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE4Id())) {
            dto.setUtilPSDE4Id(this.getRealPSModelId(t, dto.getUtilPSDE4Id()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE5Id())) {
            dto.setUtilPSDE5Id(this.getRealPSModelId(t, dto.getUtilPSDE5Id()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE6Id())) {
            dto.setUtilPSDE6Id(this.getRealPSModelId(t, dto.getUtilPSDE6Id()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE7Id())) {
            dto.setUtilPSDE7Id(this.getRealPSModelId(t, dto.getUtilPSDE7Id()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE8Id())) {
            dto.setUtilPSDE8Id(this.getRealPSModelId(t, dto.getUtilPSDE8Id()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE9Id())) {
            dto.setUtilPSDE9Id(this.getRealPSModelId(t, dto.getUtilPSDE9Id()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDEId())) {
            dto.setUtilPSDEId(this.getRealPSModelId(t, dto.getUtilPSDEId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysAppId())) {
            linkDTO = (PSSysAppDTO)PSModelServiceUtil.getInstance().getPSSysAppService().getDTO(dto.getPSSysAppId());
            dto.setPSSysAppName(((PSSysAppDTO)linkDTO).getPSSysAppName());
        } else {
            dto.setPSSysAppName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getPSSysDynaModelId());
            dto.setPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setPSSysDynaModelName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            linkDTO = (PSSysPFPluginDTO)PSModelServiceUtil.getInstance().getPSSysPFPluginService().getDTO(dto.getPSSysPFPluginId());
            dto.setPSSysPFPluginName(((PSSysPFPluginDTO)linkDTO).getPSSysPFPluginName());
        } else {
            dto.setPSSysPFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE2Id())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getUtilPSDE2Id());
            dto.setUtilPSDE2Name(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setUtilPSDE2Name(null);
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE3Id())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getUtilPSDE3Id());
            dto.setUtilPSDE3Name(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setUtilPSDE3Name(null);
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE4Id())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getUtilPSDE4Id());
            dto.setUtilPSDE4Name(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setUtilPSDE4Name(null);
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE5Id())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getUtilPSDE5Id());
            dto.setUtilPSDE5Name(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setUtilPSDE5Name(null);
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE6Id())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getUtilPSDE6Id());
            dto.setUtilPSDE6Name(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setUtilPSDE6Name(null);
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE7Id())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getUtilPSDE7Id());
            dto.setUtilPSDE7Name(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setUtilPSDE7Name(null);
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE8Id())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getUtilPSDE8Id());
            dto.setUtilPSDE8Name(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setUtilPSDE8Name(null);
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE9Id())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getUtilPSDE9Id());
            dto.setUtilPSDE9Name(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setUtilPSDE9Name(null);
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getUtilPSDEId());
            dto.setUtilPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setUtilPSDEName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSAPPUTIL";
    }

    @Override
    public PSAppUtil createDomain() {
        return new PSAppUtil();
    }

    @Override
    public PSAppUtilDTO createDTO() {
        return new PSAppUtilDTO();
    }
}

