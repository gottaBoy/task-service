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
import net.ibizsys.modelapi.domain.PSDEDBCfg;
import net.ibizsys.modelapi.domain.PSDataEntity;
import net.ibizsys.modelapi.dto.PSDEDBCfgDTO;
import net.ibizsys.modelapi.dto.PSDataEntityDTO;
import net.ibizsys.modelapi.service.IPSDEDBCfgService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEDBCfgServiceImpl
extends PSModelServiceImplBase<PSDEDBCfg, PSDEDBCfgDTO>
implements IPSDEDBCfgService {
    private static final Log log = LogFactory.getLog(PSDEDBCfgServiceImpl.class);

    @Override
    public List<PSDEDBCfg> listByPSDataEntity(PSDataEntity parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEDBCfg get(PSDataEntity parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEDBCfg> list = this.listByPSDataEntity(parent);
        if (list != null) {
            for (PSDEDBCfg item : list) {
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
    public List<PSDEDBCfgDTO> listDTOByPSDataEntity(String strParentKey) throws Exception {
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey);
        List<PSDEDBCfg> list = this.listByPSDataEntity(psdataentity);
        if (list != null) {
            ArrayList<PSDEDBCfgDTO> dtoList = new ArrayList<PSDEDBCfgDTO>();
            for (PSDEDBCfg item : list) {
                PSDEDBCfgDTO dto = (PSDEDBCfgDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEDBCfg> onListAll() throws Exception {
        ArrayList<PSDEDBCfg> list = new ArrayList<PSDEDBCfg>();
        List<PSDataEntity> psdataentities = PSModelServiceUtil.getInstance().getPSDataEntityService().listAll();
        if (psdataentities != null) {
            for (PSDataEntity parent : psdataentities) {
                List<PSDEDBCfg> items = this.listByPSDataEntity(parent);
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
    protected PSDEDBCfg onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEDBCfg item;
        PSDataEntity psdataentity = (PSDataEntity)PSModelServiceUtil.getInstance().getPSDataEntityService().get(strParentKey, true);
        if (psdataentity != null && (item = this.get(psdataentity, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEDBCfg)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEDBCfgDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDataEntityService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEDBCfg et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSDEDBCfgName())) {
            return et.getPSDEDBCfgName();
        }
        if (StringUtils.hasLength((String)et.getPSDEDBCfgName())) {
            return et.getPSDEDBCfgName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEDBCfgDTO dto, PSDEDBCfg t, boolean bIgnoreNull) throws Exception {
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEDBCfgId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getExTableName() != null || !bIgnoreNull) {
            dto.setExTableName(t.getExTableName());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getObjNameCase() != null || !bIgnoreNull) {
            dto.setObjNameCase(t.getObjNameCase());
        }
        if (t.getPSDEDBCfgName() != null || !bIgnoreNull) {
            dto.setPSDEDBCfgName(t.getPSDEDBCfgName());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDEName() != null || !bIgnoreNull) {
            dto.setPSDEName(t.getPSDEName());
        }
        if (t.getPubModel() != null || !bIgnoreNull) {
            dto.setPubModel(t.getPubModel());
        }
        if (t.getTableName() != null || !bIgnoreNull) {
            dto.setTableName(t.getTableName());
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
        if (t.getUserParams() != null || !bIgnoreNull) {
            dto.setUserParams(t.getUserParams());
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
        if (t.getValidFlag() != null || !bIgnoreNull) {
            dto.setValidFlag(t.getValidFlag());
        }
        if (t.getViewName() != null || !bIgnoreNull) {
            dto.setViewName(t.getViewName());
        }
        if (t.getViewName2() != null || !bIgnoreNull) {
            dto.setViewName2(t.getViewName2());
        }
        if (t.getViewName3() != null || !bIgnoreNull) {
            dto.setViewName3(t.getViewName3());
        }
        if (t.getViewName4() != null || !bIgnoreNull) {
            dto.setViewName4(t.getViewName4());
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            dto.setPSDEId(this.getRealPSModelId(t, dto.getPSDEId()).replace("/", "."));
        }
        if ("PSDATAENTITY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEId())) {
            PSDataEntityDTO linkDTO = (PSDataEntityDTO)PSModelServiceUtil.getInstance().getPSDataEntityService().getDTO(dto.getPSDEId());
            dto.setPSDEName(linkDTO.getPSDataEntityName());
        } else {
            dto.setPSDEName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    public String getModelName() {
        return "PSDEDBCFG";
    }

    @Override
    public PSDEDBCfg createDomain() {
        return new PSDEDBCfg();
    }

    @Override
    public PSDEDBCfgDTO createDTO() {
        return new PSDEDBCfgDTO();
    }
}

