
package wallet.controller;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import wallet.service.PointService;
import wallet.dto.entity.Point;

@RestController
@RequestMapping(value="/points")
public class PointController{

    @Autowired
    PointService pointService;


@RequestMapping(value = "/use",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")

public void use(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        System.out.println("##### /point/use  called #####");
        }

    @RequestMapping(value="", method=RequestMethod.GET)
    public ResponseEntity<?> getList() {
        HashMap<String, Object> result = new HashMap<>();

        result.put("data", pointService.getList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Point getById(@PathVariable(value="id") Long id){
        Point point = pointService.getById(id);

        return point;
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public Point post(@RequestBody Point point){
        pointService.save(point);
        
        return point;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public void put(@PathVariable(value="id") Long id, @RequestBody Point point){
        point.setId(id);
        pointService.update(point);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deletebyId(@PathVariable(value="id") Long id){
        pointService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}