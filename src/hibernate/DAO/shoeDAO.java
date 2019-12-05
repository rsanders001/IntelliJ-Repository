package hibernate.DAO;

import hibernate.entity.shoes;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface shoeDAO {
    List<shoes> getShoes();
    void createShoe();
    void saveShoe(shoes aShoe);
    void readShoe(int id);
    void deleteShoe(int id);
    void updateShoe(int id);
    List<shoes> getShoesByName(String searchTerm);
}
