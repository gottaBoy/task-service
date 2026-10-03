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
import net.ibizsys.modelapi.domain.PSDEUtilDE;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEUtilDEDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.dto.PSSubSysServiceAPIDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysSFPluginDTO;
import net.ibizsys.modelapi.service.IPSDEUtilDEService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEUtilDEServiceImpl
extends PSModelServiceImplBase<PSDEUtilDE, PSDEUtilDEDTO>
implements IPSDEUtilDEService {
    private static final Log log = LogFactory.getLog(PSDEUtilDEServiceImpl.class);

    @Override
    public List<PSDEUtilDE> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEUtilDE get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEUtilDE> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDEUtilDE item : list) {
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
    public List<PSDEUtilDEDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDEUtilDE> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDEUtilDEDTO> dtoList = new ArrayList<PSDEUtilDEDTO>();
            for (PSDEUtilDE item : list) {
                PSDEUtilDEDTO dto = (PSDEUtilDEDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEUtilDE> onListAll() throws Exception {
        ArrayList<PSDEUtilDE> list = new ArrayList<PSDEUtilDE>();
        List<PSDataEntity> psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSDEUtilDE> items = this.listByPSDataEntity(parent);
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
    protected PSDEUtilDE onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEUtilDE item;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item = this.get(psdataentity, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEUtilDE)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEUtilDEDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEUtilDE et) throws Exception {
        if (StringUtils.hasLength((String)et.getCodeName())) {
            return et.getCodeName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEUtilDEDTO dto, PSDEUtilDE t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEUtilDEId(t.getId().replace("/", "."));
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
        if (t.getExtendMode() != null || !bIgnoreNull) {
            dto.setExtendMode(t.getExtendMode());
        }
        if (t.getLockFlag() != null || !bIgnoreNull) {
            dto.setLockFlag(t.getLockFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPSDEUtilDEName() != null || !bIgnoreNull) {
            dto.setPSDEUtilDEName(t.getPSDEUtilDEName());
        }
        if (t.getPSSubSysServiceAPIId() != null || !bIgnoreNull) {
            dto.setPSSubSysServiceAPIId(t.getPSSubSysServiceAPIId());
        }
        if (t.getPSSubSysServiceAPIName() != null || !bIgnoreNull) {
            dto.setPSSubSysServiceAPIName(t.getPSSubSysServiceAPIName());
        }
        if (t.getPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelId(t.getPSSysDynaModelId());
        }
        if (t.getPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelName(t.getPSSysDynaModelName());
        }
        if (t.getPSSysSFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginId(t.getPSSysSFPluginId());
        }
        if (t.getPSSysSFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginName(t.getPSSysSFPluginName());
        }
        if (t.getUniqueTag() != null || !bIgnoreNull) {
            dto.setUniqueTag(t.getUniqueTag());
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
        if (t.getUtilPSDE10Id() != null || !bIgnoreNull) {
            dto.setUtilPSDE10Id(t.getUtilPSDE10Id());
        }
        if (t.getUtilPSDE10Name() != null || !bIgnoreNull) {
            dto.setUtilPSDE10Name(t.getUtilPSDE10Name());
        }
        if (t.getUtilPSDE11Id() != null || !bIgnoreNull) {
            dto.setUtilPSDE11Id(t.getUtilPSDE11Id());
        }
        if (t.getUtilPSDE11Name() != null || !bIgnoreNull) {
            dto.setUtilPSDE11Name(t.getUtilPSDE11Name());
        }
        if (t.getUtilPSDE12Id() != null || !bIgnoreNull) {
            dto.setUtilPSDE12Id(t.getUtilPSDE12Id());
        }
        if (t.getUtilPSDE12Name() != null || !bIgnoreNull) {
            dto.setUtilPSDE12Name(t.getUtilPSDE12Name());
        }
        if (t.getUtilPSDE13Id() != null || !bIgnoreNull) {
            dto.setUtilPSDE13Id(t.getUtilPSDE13Id());
        }
        if (t.getUtilPSDE13Name() != null || !bIgnoreNull) {
            dto.setUtilPSDE13Name(t.getUtilPSDE13Name());
        }
        if (t.getUtilPSDE14Id() != null || !bIgnoreNull) {
            dto.setUtilPSDE14Id(t.getUtilPSDE14Id());
        }
        if (t.getUtilPSDE14Name() != null || !bIgnoreNull) {
            dto.setUtilPSDE14Name(t.getUtilPSDE14Name());
        }
        if (t.getUtilPSDE15Id() != null || !bIgnoreNull) {
            dto.setUtilPSDE15Id(t.getUtilPSDE15Id());
        }
        if (t.getUtilPSDE15Name() != null || !bIgnoreNull) {
            dto.setUtilPSDE15Name(t.getUtilPSDE15Name());
        }
        if (t.getUtilPSDE16Id() != null || !bIgnoreNull) {
            dto.setUtilPSDE16Id(t.getUtilPSDE16Id());
        }
        if (t.getUtilPSDE16Name() != null || !bIgnoreNull) {
            dto.setUtilPSDE16Name(t.getUtilPSDE16Name());
        }
        if (t.getUtilPSDE17Id() != null || !bIgnoreNull) {
            dto.setUtilPSDE17Id(t.getUtilPSDE17Id());
        }
        if (t.getUtilPSDE17Name() != null || !bIgnoreNull) {
            dto.setUtilPSDE17Name(t.getUtilPSDE17Name());
        }
        if (t.getUtilPSDE18Id() != null || !bIgnoreNull) {
            dto.setUtilPSDE18Id(t.getUtilPSDE18Id());
        }
        if (t.getUtilPSDE18Name() != null || !bIgnoreNull) {
            dto.setUtilPSDE18Name(t.getUtilPSDE18Name());
        }
        if (t.getUtilPSDE19Id() != null || !bIgnoreNull) {
            dto.setUtilPSDE19Id(t.getUtilPSDE19Id());
        }
        if (t.getUtilPSDE19Name() != null || !bIgnoreNull) {
            dto.setUtilPSDE19Name(t.getUtilPSDE19Name());
        }
        if (t.getUtilPSDE20Id() != null || !bIgnoreNull) {
            dto.setUtilPSDE20Id(t.getUtilPSDE20Id());
        }
        if (t.getUtilPSDE20Name() != null || !bIgnoreNull) {
            dto.setUtilPSDE20Name(t.getUtilPSDE20Name());
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
        if (t.getUtilTag2() != null || !bIgnoreNull) {
            dto.setUtilTag2(t.getUtilTag2());
        }
        if (t.getUtilType() != null || !bIgnoreNull) {
            dto.setUtilType(t.getUtilType());
        }
        if (t.getValidFlag() != null || !bIgnoreNull) {
            dto.setValidFlag(t.getValidFlag());
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if ("PSDATAENTITY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSubSysServiceAPIId())) {
            dto.setPSSubSysServiceAPIId(this.getRealPSModelId(t, dto.getPSSubSysServiceAPIId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            dto.setPSSysDynaModelId(this.getRealPSModelId(t, dto.getPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            dto.setPSSysSFPluginId(this.getRealPSModelId(t, dto.getPSSysSFPluginId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE10Id())) {
            dto.setUtilPSDE10Id(this.getRealPSModelId(t, dto.getUtilPSDE10Id()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE11Id())) {
            dto.setUtilPSDE11Id(this.getRealPSModelId(t, dto.getUtilPSDE11Id()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE12Id())) {
            dto.setUtilPSDE12Id(this.getRealPSModelId(t, dto.getUtilPSDE12Id()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE13Id())) {
            dto.setUtilPSDE13Id(this.getRealPSModelId(t, dto.getUtilPSDE13Id()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE14Id())) {
            dto.setUtilPSDE14Id(this.getRealPSModelId(t, dto.getUtilPSDE14Id()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE15Id())) {
            dto.setUtilPSDE15Id(this.getRealPSModelId(t, dto.getUtilPSDE15Id()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE16Id())) {
            dto.setUtilPSDE16Id(this.getRealPSModelId(t, dto.getUtilPSDE16Id()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE17Id())) {
            dto.setUtilPSDE17Id(this.getRealPSModelId(t, dto.getUtilPSDE17Id()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE18Id())) {
            dto.setUtilPSDE18Id(this.getRealPSModelId(t, dto.getUtilPSDE18Id()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE19Id())) {
            dto.setUtilPSDE19Id(this.getRealPSModelId(t, dto.getUtilPSDE19Id()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE20Id())) {
            dto.setUtilPSDE20Id(this.getRealPSModelId(t, dto.getUtilPSDE20Id()).replace("/", "."));
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
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSubSysServiceAPIId())) {
            linkDTO = (PSSubSysServiceAPIDTO)PSModelServiceUtil.getInstance().getPSSubSysServiceAPIService().getDTO(dto.getPSSubSysServiceAPIId());
            dto.setPSSubSysServiceAPIName(((PSSubSysServiceAPIDTO)linkDTO).getPSSubSysServiceAPIName());
        } else {
            dto.setPSSubSysServiceAPIName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            linkDTO = (PSSysDynaModelDTO)PSModelServiceUtil.getInstance().getPSSysDynaModelService().getDTO(dto.getPSSysDynaModelId());
            dto.setPSSysDynaModelName(((PSSysDynaModelDTO)linkDTO).getPSSysDynaModelName());
        } else {
            dto.setPSSysDynaModelName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            linkDTO = (PSSysSFPluginDTO)PSModelServiceUtil.getInstance().getPSSysSFPluginService().getDTO(dto.getPSSysSFPluginId());
            dto.setPSSysSFPluginName(((PSSysSFPluginDTO)linkDTO).getPSSysSFPluginName());
        } else {
            dto.setPSSysSFPluginName(null);
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE10Id())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getUtilPSDE10Id());
            dto.setUtilPSDE10Name(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setUtilPSDE10Name(null);
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE11Id())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getUtilPSDE11Id());
            dto.setUtilPSDE11Name(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setUtilPSDE11Name(null);
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE12Id())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getUtilPSDE12Id());
            dto.setUtilPSDE12Name(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setUtilPSDE12Name(null);
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE13Id())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getUtilPSDE13Id());
            dto.setUtilPSDE13Name(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setUtilPSDE13Name(null);
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE14Id())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getUtilPSDE14Id());
            dto.setUtilPSDE14Name(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setUtilPSDE14Name(null);
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE15Id())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getUtilPSDE15Id());
            dto.setUtilPSDE15Name(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setUtilPSDE15Name(null);
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE16Id())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getUtilPSDE16Id());
            dto.setUtilPSDE16Name(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setUtilPSDE16Name(null);
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE17Id())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getUtilPSDE17Id());
            dto.setUtilPSDE17Name(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setUtilPSDE17Name(null);
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE18Id())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getUtilPSDE18Id());
            dto.setUtilPSDE18Name(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setUtilPSDE18Name(null);
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE19Id())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getUtilPSDE19Id());
            dto.setUtilPSDE19Name(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setUtilPSDE19Name(null);
        }
        if (StringUtils.hasLength((String)dto.getUtilPSDE20Id())) {
            linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getUtilPSDE20Id());
            dto.setUtilPSDE20Name(((PSDataEntityDTO)linkDTO).getPSDataEntityName());
        } else {
            dto.setUtilPSDE20Name(null);
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
        return "PSDEUTILDE";
    }

    @Override
    public PSDEUtilDE createDomain() {
        return new PSDEUtilDE();
    }

    @Override
    public PSDEUtilDEDTO createDTO() {
        return new PSDEUtilDEDTO();
    }
}

