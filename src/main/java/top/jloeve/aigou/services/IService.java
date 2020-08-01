package top.jloeve.aigou.services;

public interface IService {
  default String getName() {
    return this.getClass().getName();
  }
}
