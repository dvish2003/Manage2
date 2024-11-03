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
/*package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.ItemBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.ItemDAO;
import lk.ijse.dto.ItemDto;
import lk.ijse.entity.Customer;
import lk.ijse.entity.Item;

import java.util.ArrayList;
import java.util.List;



public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAOFactory(DAOFactory.DAOType.ITEM);

    @Override
    public ItemDto searchByItemCode(String itemCode) {
        Item item = itemDAO.get(itemCode);
        ItemDto result = new ItemDto();
        result.setCode(item.getCode());
        result.setName(item.getName());
        result.setQty(item.getQty());
        result.setPrice(item.getPrice());
        return  result;
    }

    @Override
    public boolean save(ItemDto item) {
        return itemDAO.save(new Item(item.getCode(),item.getName(),item.getPrice(),item.getQty()));
    }

    @Override
    public boolean deleteItem(ItemDto item) {
        return itemDAO.delete(new Item(item.getCode(),item.getName(),item.getPrice(),item.getQty()));
    }

    @Override
    public boolean updateItem(ItemDto itemDto) {
        return itemDAO.update(new Item(itemDto.getCode(), itemDto.getName(), itemDto.getPrice(), itemDto.getQty()));
    }

    @Override
    public ItemDto getItem(int id) {
        return null;
    }

    @Override
    public List<ItemDto> getItems() {
      List<ItemDto> itemDtos = new ArrayList<>();
      List<Item> items = itemDAO.getAll();
      for (Item item : items) {
          itemDtos.add(new ItemDto(item.getCode(),item.getName(),item.getPrice(),item.getQty()));
      }
      return itemDtos;
    }

    @Override
    public String generateNewItemId() {
        return itemDAO.generateId();
    }
}*/