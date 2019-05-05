package bsiotmobile.mobile.mapper;

import bsiotmobile.mobile.eo.NbCard;
import bsiotmobile.mobile.eo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/2/17 21:27
 */
@Mapper
@Component
public interface NbCardMapper {

    //滴卡校验卡号
    NbCard checkCard(@Param("cardId") String cardId);
}
