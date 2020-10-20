package be.intecbrussel.Daos;

import be.intecbrussel.Entities.Orderdetail;

public interface OrderDetailDao {

        void createOrderDetail(Orderdetail orderdetail);
        Orderdetail readOrderDetail(int orderNumber);
        void updateOrderDetail(Orderdetail orderdetail);
        void deleteOrderDetail(Orderdetail orderdetail);

}
