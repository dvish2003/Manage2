package BO.Item;

import BO.SuperBO;
import Entity.ItemEntity;
import dto.ItemDTO;

import java.sql.SQLException;
import java.util.List;

public interface ItemBO extends SuperBO {
    public boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException;

    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException;


    public boolean delete(String id) throws SQLException, ClassNotFoundException;


    public List<ItemDTO> getAll() throws SQLException, ClassNotFoundException;

    ItemDTO searchByItemCode(String code) throws SQLException, ClassNotFoundException;
}
