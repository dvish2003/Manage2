package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlaceOrder {
        private OrderDTO order;
        private List<OrderDetailDTO> odList;
    }

