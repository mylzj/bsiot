package bsiotmobile.mobile.service.Impl;

import bsiotmobile.mobile.common.RespMsg;
import bsiotmobile.mobile.common.ResultUtils;
import bsiotmobile.mobile.eo.PcHumit;
import bsiotmobile.mobile.mapper.PcHumitMapper;
import bsiotmobile.mobile.service.PcHumitService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/3/11 16:50
 */
@Service
public class PcHumitServiceImpl implements PcHumitService {

    @Autowired
    private PcHumitMapper pcHumitMapper;

    @Override
    public RespMsg showHumitDataList(Integer page,Integer size) {
        //使用PageHelper进行分页
        PageHelper.startPage(page,size);
        //查询数据
        List<PcHumit> humitDataList = pcHumitMapper.findHumitDataList();
        return ResultUtils.success(new PageInfo<>(humitDataList));
    }

    @Override
    public RespMsg deletedHumitById(String id) {
        pcHumitMapper.deletedHumitById(id);
        return ResultUtils.success();
    }
}
