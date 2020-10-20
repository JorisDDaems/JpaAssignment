package be.intecbrussel.TestApps;

import be.intecbrussel.Daos.OfficeDao;
import be.intecbrussel.Daos.OfficeDaoImpl;
import be.intecbrussel.Entities.Office;

public class OfficeApp {
    public static void main(String[] args) {

        Office office = new Office();

        office.setOfficeCode("oktelang");
        office.setCity("Beeringen");
        office.setAddressLine1("straat");
        office.setCountry("guantanamo");
        office.setPhone("0328887878");
        office.setPostalCode("9999");
        office.setTerritory("sultan");

        OfficeDao officeDao = new OfficeDaoImpl();

        //officeDao.createOffice(office);
        System.out.println(officeDao.readOffice("1"));
        //officeDao.updateOffice(office);
        officeDao.deleteOffice(office);
    }
}
