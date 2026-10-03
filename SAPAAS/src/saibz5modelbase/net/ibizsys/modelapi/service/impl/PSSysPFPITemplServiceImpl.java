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
import net.ibizsys.modelapi.domain.PSSysPFPITempl;
import net.ibizsys.modelapi.domain.PSSysPFPlugin;
import net.ibizsys.modelapi.dto.PSSysCssDTO;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysPFPITemplDTO;
import net.ibizsys.modelapi.dto.PSSysPFPluginDTO;
import net.ibizsys.modelapi.service.IPSSysPFPITemplService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysPFPITemplServiceImpl
extends PSModelServiceImplBase<PSSysPFPITempl, PSSysPFPITemplDTO>
implements IPSSysPFPITemplService {
    private static final Log log = LogFactory.getLog(PSSysPFPITemplServiceImpl.class);

    @Override
    public List<PSSysPFPITempl> listByPSSysPFPlugin(PSSysPFPlugin parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysPFPITempl get(PSSysPFPlugin parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysPFPITempl> list = this.listByPSSysPFPlugin(parent);
        if (list != null) {
            for (PSSysPFPITempl item : list) {
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
    public List<PSSysPFPITemplDTO> listDTOByPSSysPFPlugin(String strParentKey) throws Exception {
        PSSysPFPlugin pssyspfplugin = (PSSysPFPlugin)PSModelServiceUtil.getInstance().getPSSysPFPluginService().get(strParentKey);
        List<PSSysPFPITempl> list = this.listByPSSysPFPlugin(pssyspfplugin);
        if (list != null) {
            ArrayList<PSSysPFPITemplDTO> dtoList = new ArrayList<PSSysPFPITemplDTO>();
            for (PSSysPFPITempl item : list) {
                PSSysPFPITemplDTO dto = (PSSysPFPITemplDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysPFPITempl> onListAll() throws Exception {
        ArrayList<PSSysPFPITempl> list = new ArrayList<PSSysPFPITempl>();
        List<PSSysPFPlugin> pssyspfplugins = PSModelServiceUtil.getInstance().getPSSysPFPluginService().listAll();
        if (pssyspfplugins != null) {
            for (PSSysPFPlugin parent : pssyspfplugins) {
                List<PSSysPFPITempl> items = this.listByPSSysPFPlugin(parent);
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
    protected PSSysPFPITempl onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysPFPITempl item;
        PSSysPFPlugin pssyspfplugin = (PSSysPFPlugin)PSModelServiceUtil.getInstance().getPSSysPFPluginService().get(strParentKey, true);
        if (pssyspfplugin != null && (item = this.get(pssyspfplugin, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysPFPITempl)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysPFPITemplDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysPFPluginId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysPFPluginService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysPFPITempl et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysPFPITemplDTO dto, PSSysPFPITempl t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysPFPITemplId(t.getId().replace("/", "."));
        }
        if (t.getCodeMap() != null || !bIgnoreNull) {
            dto.setCodeMap(t.getCodeMap());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getDynaModelFlag() != null || !bIgnoreNull) {
            dto.setDynaModelFlag(t.getDynaModelFlag());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSPFId() != null || !bIgnoreNull) {
            dto.setPSPFId(t.getPSPFId());
        }
        if (t.getPSPFName() != null || !bIgnoreNull) {
            dto.setPSPFName(t.getPSPFName());
        }
        if (t.getPSPFPubCodeId() != null || !bIgnoreNull) {
            dto.setPSPFPubCodeId(t.getPSPFPubCodeId());
        }
        if (t.getPSPFPubCodeName() != null || !bIgnoreNull) {
            dto.setPSPFPubCodeName(t.getPSPFPubCodeName());
        }
        if (t.getPSSysCssId() != null || !bIgnoreNull) {
            dto.setPSSysCssId(t.getPSSysCssId());
        }
        if (t.getPSSysCssName() != null || !bIgnoreNull) {
            dto.setPSSysCssName(t.getPSSysCssName());
        }
        if (t.getPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelId(t.getPSSysDynaModelId());
        }
        if (t.getPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelName(t.getPSSysDynaModelName());
        }
        if (t.getPSSysPFPITemplName() != null || !bIgnoreNull) {
            dto.setPSSysPFPITemplName(t.getPSSysPFPITemplName());
        }
        if (t.getPSSysPFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginId(t.getPSSysPFPluginId());
        }
        if (t.getPSSysPFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysPFPluginName(t.getPSSysPFPluginName());
        }
        if (t.getTemplCode() != null || !bIgnoreNull) {
            dto.setTemplCode(t.getTemplCode());
        }
        if (t.getTemplCode2() != null || !bIgnoreNull) {
            dto.setTemplCode2(t.getTemplCode2());
        }
        if (t.getTemplCode2Ex() != null || !bIgnoreNull) {
            dto.setTemplCode2Ex(t.getTemplCode2Ex());
        }
        if (t.getTemplCode2Flag() != null || !bIgnoreNull) {
            dto.setTemplCode2Flag(t.getTemplCode2Flag());
        }
        if (t.getTemplCode2Info() != null || !bIgnoreNull) {
            dto.setTemplCode2Info(t.getTemplCode2Info());
        }
        if (t.getTemplCode3() != null || !bIgnoreNull) {
            dto.setTemplCode3(t.getTemplCode3());
        }
        if (t.getTemplCode3Flag() != null || !bIgnoreNull) {
            dto.setTemplCode3Flag(t.getTemplCode3Flag());
        }
        if (t.getTemplCode3Info() != null || !bIgnoreNull) {
            dto.setTemplCode3Info(t.getTemplCode3Info());
        }
        if (t.getTemplCode4() != null || !bIgnoreNull) {
            dto.setTemplCode4(t.getTemplCode4());
        }
        if (t.getTemplCode4Flag() != null || !bIgnoreNull) {
            dto.setTemplCode4Flag(t.getTemplCode4Flag());
        }
        if (t.getTemplCode4Info() != null || !bIgnoreNull) {
            dto.setTemplCode4Info(t.getTemplCode4Info());
        }
        if (t.getTemplCode5() != null || !bIgnoreNull) {
            dto.setTemplCode5(t.getTemplCode5());
        }
        if (t.getTemplCode6() != null || !bIgnoreNull) {
            dto.setTemplCode6(t.getTemplCode6());
        }
        if (t.getTemplCodeFlag() != null || !bIgnoreNull) {
            dto.setTemplCodeFlag(t.getTemplCodeFlag());
        }
        if (t.getTemplCodeInfo() != null || !bIgnoreNull) {
            dto.setTemplCodeInfo(t.getTemplCodeInfo());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (StringUtils.hasLength((String)dto.getPSSysCssId())) {
            dto.setPSSysCssId(this.getRealPSModelId(t, dto.getPSSysCssId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            dto.setPSSysDynaModelId(this.getRealPSModelId(t, dto.getPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysPFPluginId())) {
            dto.setPSSysPFPluginId(this.getRealPSModelId(t, dto.getPSSysPFPluginId()).replace("/", "."));
        }
        if ("PSSYSPFPLUGIN".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysPFPluginId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysCssId())) {
            linkDTO = (PSSysCssDTO)PSModelServiceUtil.getInstance().getPSSysCssService().getDTO(dto.getPSSysCssId());
            dto.setPSSysCssName(((PSSysCssDTO)linkDTO).getPSSysCssName());
        } else {
            dto.setPSSysCssName(null);
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
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSPFPITEMPL";
    }

    @Override
    public PSSysPFPITempl createDomain() {
        return new PSSysPFPITempl();
    }

    @Override
    public PSSysPFPITemplDTO createDTO() {
        return new PSSysPFPITemplDTO();
    }
}

