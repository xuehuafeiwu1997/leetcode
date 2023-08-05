package test;

/**
 * @author xmy
 * @date 2023/5/19 6:27 下午
 */
public class Entity {

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
    Long parentId;


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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Entity(Long id, String name, Long parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }
}
