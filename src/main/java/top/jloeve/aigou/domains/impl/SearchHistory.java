package top.jloeve.aigou.domains.impl;

import java.util.Date;
import lombok.Data;
import top.jloeve.aigou.domains.IDomain;

@Data
public class SearchHistory implements IDomain {
  private String uuid;
  private String keyword;
  private Integer count;
  private Date latestSearchTime;
}
