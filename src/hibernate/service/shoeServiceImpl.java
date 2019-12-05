package hibernate.service;

import hibernate.DAO.shoeDAO;
import hibernate.entity.shoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class shoeServiceImpl implements shoeService {

    @Autowired
    private shoeDAO shoeDAO;

    @Override
    @Transactional
    public shoes getShoe(int id){
        shoes shoe = new shoes();
        return shoe;
    }

    @Override
    @Transactional
    public void saveShoes(shoes aShoe, MultipartFile file, String applicationPath) {
        if (aShoe.getDateAdded() == null) {
            aShoe.setDateAdded(new Date());
        }

        shoeDAO.saveShoe(aShoe);
    }





    @Override
    @Transactional
    public List<shoes> getShoes() {
            return shoeDAO.getShoes();
    }


    @Override
    @Transactional
    public void deleteShoe(int id) {
        shoeDAO.deleteShoe(id);
    }

    @Override
    @Transactional
    public List<shoes> getShoeByName(String searchTerm) {
        return shoeDAO.getShoesByName(searchTerm);
    }
}
