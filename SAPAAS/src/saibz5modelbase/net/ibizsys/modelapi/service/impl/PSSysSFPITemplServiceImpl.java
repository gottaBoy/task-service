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
import net.ibizsys.modelapi.domain.PSSysSFPITempl;
import net.ibizsys.modelapi.domain.PSSysSFPlugin;
import net.ibizsys.modelapi.dto.PSSysDynaModelDTO;
import net.ibizsys.modelapi.dto.PSSysSFPITemplDTO;
import net.ibizsys.modelapi.dto.PSSysSFPluginDTO;
import net.ibizsys.modelapi.service.IPSSysSFPITemplService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysSFPITemplServiceImpl
extends PSModelServiceImplBase<PSSysSFPITempl, PSSysSFPITemplDTO>
implements IPSSysSFPITemplService {
    private static final Log log = LogFactory.getLog(PSSysSFPITemplServiceImpl.class);

    @Override
    public List<PSSysSFPITempl> listByPSSysSFPlugin(PSSysSFPlugin parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSSysSFPITempl get(PSSysSFPlugin parent, String strKey, boolean bTryMode) throws Exception {
        List<PSSysSFPITempl> list = this.listByPSSysSFPlugin(parent);
        if (list != null) {
            for (PSSysSFPITempl item : list) {
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
    public List<PSSysSFPITemplDTO> listDTOByPSSysSFPlugin(String strParentKey) throws Exception {
        PSSysSFPlugin pssyssfplugin = (PSSysSFPlugin)PSModelServiceUtil.getInstance().getPSSysSFPluginService().get(strParentKey);
        List<PSSysSFPITempl> list = this.listByPSSysSFPlugin(pssyssfplugin);
        if (list != null) {
            ArrayList<PSSysSFPITemplDTO> dtoList = new ArrayList<PSSysSFPITemplDTO>();
            for (PSSysSFPITempl item : list) {
                PSSysSFPITemplDTO dto = (PSSysSFPITemplDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSSysSFPITempl> onListAll() throws Exception {
        ArrayList<PSSysSFPITempl> list = new ArrayList<PSSysSFPITempl>();
        List pssyssfplugins = PSModelServiceUtil.getInstance().getPSSysSFPluginService().listAll();
        if (pssyssfplugins != null) {
            for (PSSysSFPlugin parent : pssyssfplugins) {
                List<PSSysSFPITempl> items = this.listByPSSysSFPlugin(parent);
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
    protected PSSysSFPITempl onGet(String strParentKey, String strCurKey) throws Exception {
        PSSysSFPITempl item;
        PSSysSFPlugin pssyssfplugin = (PSSysSFPlugin)PSModelServiceUtil.getInstance().getPSSysSFPluginService().get(strParentKey, true);
        if (pssyssfplugin != null && (item = this.get(pssyssfplugin, strCurKey, true)) != null) {
            return item;
        }
        return (PSSysSFPITempl)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSSysSFPITemplDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSSysSFPluginId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSSysSFPluginService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSSysSFPITempl et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSSysSFPITemplDTO dto, PSSysSFPITempl t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSSysSFPITemplId(t.getId().replace("/", "."));
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
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSSFId() != null || !bIgnoreNull) {
            dto.setPSSFId(t.getPSSFId());
        }
        if (t.getPSSFName() != null || !bIgnoreNull) {
            dto.setPSSFName(t.getPSSFName());
        }
        if (t.getPSSysDynaModelId() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelId(t.getPSSysDynaModelId());
        }
        if (t.getPSSysDynaModelName() != null || !bIgnoreNull) {
            dto.setPSSysDynaModelName(t.getPSSysDynaModelName());
        }
        if (t.getPSSysSFPITemplName() != null || !bIgnoreNull) {
            dto.setPSSysSFPITemplName(t.getPSSysSFPITemplName());
        }
        if (t.getPSSysSFPluginId() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginId(t.getPSSysSFPluginId());
        }
        if (t.getPSSysSFPluginName() != null || !bIgnoreNull) {
            dto.setPSSysSFPluginName(t.getPSSysSFPluginName());
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
        if (t.getTemplCode3() != null || !bIgnoreNull) {
            dto.setTemplCode3(t.getTemplCode3());
        }
        if (t.getTemplCode4() != null || !bIgnoreNull) {
            dto.setTemplCode4(t.getTemplCode4());
        }
        if (t.getTemplCode5() != null || !bIgnoreNull) {
            dto.setTemplCode5(t.getTemplCode5());
        }
        if (t.getTemplCode6() != null || !bIgnoreNull) {
            dto.setTemplCode6(t.getTemplCode6());
        }
        if (t.getTemplCodeEx() != null || !bIgnoreNull) {
            dto.setTemplCodeEx(t.getTemplCodeEx());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (StringUtils.hasLength((String)dto.getPSSysDynaModelId())) {
            dto.setPSSysDynaModelId(this.getRealPSModelId(t, dto.getPSSysDynaModelId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysSFPluginId())) {
            dto.setPSSysSFPluginId(this.getRealPSModelId(t, dto.getPSSysSFPluginId()).replace("/", "."));
        }
        if ("PSSYSSFPLUGIN".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSSysSFPluginId(t.getSrfParent().getId().replace("/", "."));
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
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSSYSSFPITEMPL";
    }

    @Override
    public PSSysSFPITempl createDomain() {
        return new PSSysSFPITempl();
    }

    @Override
    public PSSysSFPITemplDTO createDTO() {
        return new PSSysSFPITemplDTO();
    }
}

