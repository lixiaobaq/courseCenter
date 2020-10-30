package com.iothings.VO;

import com.iothings.entity.GraphicEntity;
import lombok.Data;

import java.util.List;

/**
 * @author: Huanglei
 * @time:2020/10/28 10:41 AM
 * @Description：
 */
@Data
public class HeadVO {
    private GraphicEntity logo;
    private List<GraphicEntity> navis;
}
