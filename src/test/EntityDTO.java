package test;

import java.util.List;

/**
 * @author xmy
 * @date 2023/5/19 6:28 下午
 */
public class EntityDTO {
    /**
     * 主键
     */
    Long id;

    /**
     * 姓名
     */
    String name;

    /**
     * 根节点
     */
    List<EntityDTO> subList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EntityDTO> getSubList() {
        return subList;
    }

    public void setSubList(List<EntityDTO> subList) {
        this.subList = subList;
    }
}
