package top.jloeve.aigou.domains.impl;

import java.util.Date;
import lombok.Data;
import top.jloeve.aigou.domains.IDomain;

@Data
public class SearchHistory implements IDomain {
  private String id;
  private String searchWords;
  private Integer num;
  private Date searchTime;
}
