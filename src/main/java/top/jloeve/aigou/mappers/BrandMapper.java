package top.jloeve.aigou.mappers;

import org.springframework.stereotype.Repository;
import top.jloeve.aigou.domains.impl.Brand;

import java.util.List;

@Repository
public interface BrandMapper extends ISearchMapper<List<Brand>> {}
