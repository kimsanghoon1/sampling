
package wallet.service;

import java.util.List;
import wallet.dto.entity.Point;

public interface PointService{
    public List<Point> getList();

    public void save(Point point);

    public Point getById(Long id);

    public void delete(Long id);

    public void update(Point point);
}