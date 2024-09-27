package BO.Item;

import DAO.DAOFactory;
import DAO.Item.ItemDAO;
import Entity.ItemEntity;
import dto.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.Item);
    @Override
    public boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.save(new ItemEntity(dto.getId(),dto.getItemName(),dto.getItemQty(),dto.getItemPrice()));
    }

    @Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.update(new ItemEntity(dto.getId(),dto.getItemName(),dto.getItemQty(),dto.getItemPrice()));
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(id);
    }

    @Override
    public List<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
List<ItemEntity> list = itemDAO.getAll();
List<ItemDTO> dtos = new ArrayList<>();
for (ItemEntity item : list) {
    dtos.add(new ItemDTO(item.getId(),item.getItemName(),item.getItemQty(),item.getItemPrice()));
}
return dtos;
    }



    @Override
    public ItemDTO searchByItemCode(String code) throws SQLException, ClassNotFoundException {
        ItemEntity item = itemDAO.searchById(code);
        ItemDTO result = new ItemDTO();
        result.setId(item.getId());
        result.setItemName(item.getItemName());
        result.setItemQty(item.getItemQty());
        result.setItemPrice(item.getItemPrice());
        return  result;
    }
}
