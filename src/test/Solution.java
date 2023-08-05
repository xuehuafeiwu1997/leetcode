package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xmy
 * @date 2023/5/19 6:24 下午
 */
public class Solution {
    public static void main(String[] args) {
        Entity entity = new Entity(-1L, "test1", 1L);
    }

    public List<EntityDTO> buildTree(List<Entity> dataList) {
        if (dataList == null || dataList.isEmpty()) {
            return null;
        }
        List<EntityDTO> entityDTOS = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i).parentId == -1) {
                EntityDTO entityDTO = new EntityDTO();
                entityDTO.setId(dataList.get(i).getId());
                entityDTO.setName(dataList.get(i).getName());
                List<EntityDTO> subList = new ArrayList<>();
                recrusive(dataList.get(i).getId(), dataList, subList);
                entityDTO.setSubList(subList);
                entityDTOS.add(entityDTO);
            }

        }
        return entityDTOS;
    }

    public void recrusive(Long targetParentId, List<Entity> dataList, List<EntityDTO> subList) {
        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i).getParentId() == targetParentId) {
                EntityDTO entityDTO = new EntityDTO();
                entityDTO.setId(dataList.get(i).getId());
                entityDTO.setName(dataList.get(i).getName());
                List<EntityDTO> subList1 = new ArrayList<>();
                subList.add(entityDTO);
                recrusive(dataList.get(i).getId(), dataList, subList1);
                entityDTO.setSubList(subList1);
                subList.add(entityDTO);
            }
            return;
        }
    }


}
