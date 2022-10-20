
package wallet.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wallet.dto.entity.Point;
import wallet.dto.event.PointsDeducted;
import wallet.mapper.PointMapper;
import wallet.service.PointService;

@Transactional
@Service
public class PointServiceImpl implements PointService{
    @Autowired
    PointMapper pointMapper;
    
    @Override
    public List<Point> getList(){
        List<Point> pointList = pointMapper.findList();

        return pointList;
    }

    @Override
    public void save(Point point){
        
        pointMapper.save(point); 

        
        // PUB/SUB
        // if trigger is set as Post~, this line should go below save method
        PointsDeducted pointsDeducted = new PointsDeducted();
        BeanUtils.copyProperties(point, pointsDeducted);
        pointsDeducted.publish(pointsDeducted.getId());

        // PUB/SUB
        // if trigger is set as Post~, this line should go below save method
        // InsufficientPointsOccurred insufficientPointsOccurred = new InsufficientPointsOccurred();
        // BeanUtils.copyProperties(point, insufficientPointsOccurred);
        // insufficientPointsOccurred.publish(insufficientPointsOccurred.getId());

        
        
        
    }

    @Override
    public Point getById(Long id){
        Point point = pointMapper.findOneById(id);

        return point;
    }

    @Override
    public void delete(Long id){
        
        pointMapper.deleteById(id); 


    }

    @Override
    public void update(Point point){

        pointMapper.update(point); 



    }
}
