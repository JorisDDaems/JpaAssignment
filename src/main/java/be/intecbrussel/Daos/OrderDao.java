package be.intecbrussel.Daos;

import be.intecbrussel.Entities.Order;

public interface OrderDao {

        void createOrder(Order order);
        Order readOrder(int orderNumber);
        void updateOrder(Order order);
        void deleteOrder(Order order);

}
