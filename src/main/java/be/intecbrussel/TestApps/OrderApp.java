package be.intecbrussel.TestApps;

import be.intecbrussel.Daos.OrderDao;
import be.intecbrussel.Daos.OrderDaoImpl;
import be.intecbrussel.Entities.Order;

public class OrderApp {
    public static void main(String[] args) {

        Order order = new Order();

        OrderDao orderDao = new OrderDaoImpl();

        orderDao.createOrder(order);
        System.out.println(orderDao.readOrder(10101));
        //orderDao.updateOrder();
        //orderDao.deleteOrder();

    }
}
