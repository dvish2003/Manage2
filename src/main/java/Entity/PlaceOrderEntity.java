package Entity;

import dto.OrderDTO;
import dto.OrderDetailDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlaceOrderEntity {
        private OrderDTO order;
        private List<OrderDetailDTO> odList;
    }

