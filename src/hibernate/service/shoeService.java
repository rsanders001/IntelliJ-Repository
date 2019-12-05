package hibernate.service;

import hibernate.entity.shoes;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface shoeService {
    List<shoes> getShoes();

    void saveShoes(shoes aShoe, MultipartFile file, String applicationPath);

    shoes getShoe(int ID);

    void deleteShoe(int ID);

    List<shoes> getShoeByName(String searchTerm);

}
