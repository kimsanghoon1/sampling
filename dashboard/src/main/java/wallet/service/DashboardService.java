
package wallet.service;

import java.util.List;
import wallet.dto.entity.Dashboard;

public interface DashboardService{
    public List<Dashboard> getList();

    public Dashboard getById(Long id);

}