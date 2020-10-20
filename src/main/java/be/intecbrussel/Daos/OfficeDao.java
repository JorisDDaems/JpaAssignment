package be.intecbrussel.Daos;

import be.intecbrussel.Entities.Office;

public interface OfficeDao {

        void createOffice(Office office);
        Office readOffice(String officeCode);
        void updateOffice(Office office);
        void deleteOffice(Office office);

}
