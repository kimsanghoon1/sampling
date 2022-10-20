package wallet.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import wallet.dto.entity.Dashboard;

@Mapper
public interface DashboardMapper{
    public List<Dashboard> findList();

    public Dashboard findOneById(Long id);

    public void save(Dashboard dashboard);
} 