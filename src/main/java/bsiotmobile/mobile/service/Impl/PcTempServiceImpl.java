package bsiotmobile.mobile.service.Impl;

import bsiotmobile.mobile.common.RespMsg;
import bsiotmobile.mobile.common.ResultUtils;
import bsiotmobile.mobile.eo.PcTemp;
import bsiotmobile.mobile.mapper.PcTempMapper;
import bsiotmobile.mobile.service.PcTempService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/3/11 16:48
 */
@Service
public class PcTempServiceImpl implements PcTempService {
    @Autowired
    private PcTempMapper pcTempMapper;

    @Override
    public RespMsg showTempDataList(Integer page,Integer size) {
        PageHelper.startPage(page,size);
        List<PcTemp> tempDataList = pcTempMapper.findTempDataList();
        return ResultUtils.success(new PageInfo<>(tempDataList));
    }

    @Override
    public RespMsg deletedTempById(String id) {
        pcTempMapper.deletedTempById(id);
        return ResultUtils.success();
    }
}
