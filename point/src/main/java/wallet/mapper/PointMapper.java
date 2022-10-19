package wallet.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import wallet.dto.entity.Point;

@Mapper
public interface PointMapper{
    public List<Point> findList();

    public Point findOneById(Long id);

    public void save(Point point);

    public void update(Point point);

    public void deleteById(Long id);
} 