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
import net.ibizsys.modelapi.domain.PSDEDSDQ;
import net.ibizsys.modelapi.domain.PSDEDataSet;
import net.ibizsys.modelapi.dto.PSDEDSDQDTO;
import net.ibizsys.modelapi.dto.PSDEDataQueryDTO;
import net.ibizsys.modelapi.dto.PSDEDataSetDTO;
import net.ibizsys.modelapi.service.IPSDEDSDQService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDEDSDQServiceImpl
extends PSModelServiceImplBase<PSDEDSDQ, PSDEDSDQDTO>
implements IPSDEDSDQService {
    private static final Log log = LogFactory.getLog(PSDEDSDQServiceImpl.class);

    @Override
    public List<PSDEDSDQ> listByPSDEDataSet(PSDEDataSet parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDEDSDQ get(PSDEDataSet parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDEDSDQ> list = this.listByPSDEDataSet(parent);
        if (list != null) {
            for (PSDEDSDQ item : list) {
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
    public List<PSDEDSDQDTO> listDTOByPSDEDataSet(String strParentKey) throws Exception {
        PSDEDataSet psdedataset = (PSDEDataSet)PSModelServiceUtil.getInstance().getPSDEDataSetService().get(strParentKey);
        List<PSDEDSDQ> list = this.listByPSDEDataSet(psdedataset);
        if (list != null) {
            ArrayList<PSDEDSDQDTO> dtoList = new ArrayList<PSDEDSDQDTO>();
            for (PSDEDSDQ item : list) {
                PSDEDSDQDTO dto = (PSDEDSDQDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDEDSDQ> onListAll() throws Exception {
        ArrayList<PSDEDSDQ> list = new ArrayList<PSDEDSDQ>();
        List<PSDEDataSet> psdedatasets = PSModelServiceUtil.getInstance().getPSDEDataSetService().listAll();
        if (psdedatasets != null) {
            for (PSDEDataSet parent : psdedatasets) {
                List<PSDEDSDQ> items = this.listByPSDEDataSet(parent);
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
    protected PSDEDSDQ onGet(String strParentKey, String strCurKey) throws Exception {
        PSDEDSDQ item;
        PSDEDataSet psdedataset = (PSDEDataSet)PSModelServiceUtil.getInstance().getPSDEDataSetService().get(strParentKey, true);
        if (psdedataset != null && (item = this.get(psdedataset, strCurKey, true)) != null) {
            return item;
        }
        return (PSDEDSDQ)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDEDSDQDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDEDataSetId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDEDataSetService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDEDSDQ et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDEDSDQDTO dto, PSDEDSDQ t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDEDSDQId(t.getId().replace("/", "."));
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
        if (t.getOrderValue() != null || !bIgnoreNull) {
            dto.setOrderValue(t.getOrderValue());
        }
        if (t.getPSDEDataSetId() != null || !bIgnoreNull) {
            dto.setPSDEDataSetId(t.getPSDEDataSetId());
        }
        if (t.getPSDEDataSetName() != null || !bIgnoreNull) {
            dto.setPSDEDataSetName(t.getPSDEDataSetName());
        }
        if (t.getPSDEDQId() != null || !bIgnoreNull) {
            dto.setPSDEDQId(t.getPSDEDQId());
        }
        if (t.getPSDEDQName() != null || !bIgnoreNull) {
            dto.setPSDEDQName(t.getPSDEDQName());
        }
        if (t.getPSDEDSDQName() != null || !bIgnoreNull) {
            dto.setPSDEDSDQName(t.getPSDEDSDQName());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (t.getViewColLevel() != null || !bIgnoreNull) {
            dto.setViewColLevel(t.getViewColLevel());
        }
        if (StringUtils.hasLength((String)dto.getPSDEDataSetId())) {
            dto.setPSDEDataSetId(this.getRealPSModelId(t, dto.getPSDEDataSetId()).replace("/", "."));
        }
        if ("PSDEDATASET".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDEDataSetId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDQId())) {
            dto.setPSDEDQId(this.getRealPSModelId(t, dto.getPSDEDQId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDEDataSetId())) {
            linkDTO = (PSDEDataSetDTO)PSModelServiceUtil.getInstance().getPSDEDataSetService().getDTO(dto.getPSDEDataSetId());
            dto.setPSDEDataSetName(((PSDEDataSetDTO)linkDTO).getPSDEDataSetName());
        } else {
            dto.setPSDEDataSetName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSDEDQId())) {
            linkDTO = (PSDEDataQueryDTO)PSModelServiceUtil.getInstance().getPSDEDataQueryService().getDTO(dto.getPSDEDQId());
            dto.setPSDEDQName(((PSDEDataQueryDTO)linkDTO).getPSDEDataQueryName());
            dto.setViewColLevel(((PSDEDataQueryDTO)linkDTO).getViewColLevel());
        } else {
            dto.setPSDEDQName(null);
            dto.setViewColLevel(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDEDSDQ";
    }

    @Override
    public PSDEDSDQ createDomain() {
        return new PSDEDSDQ();
    }

    @Override
    public PSDEDSDQDTO createDTO() {
        return new PSDEDSDQDTO();
    }
}

