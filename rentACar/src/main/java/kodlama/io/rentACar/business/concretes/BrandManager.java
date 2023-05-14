package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.request.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service//bu sınıf bussines nesenesi
public class BrandManager implements BrandService {
private BrandRepository brandRepository;
@Autowired
    public BrandManager(BrandRepository brandRepository) {

        this.brandRepository = brandRepository;
    }


    public List<GetAllBrandsResponse> getAll() {
        //iş kuralları
        //ilkel mapping
        List <Brand> brands=brandRepository.findAll();
        List<GetAllBrandsResponse> brandsResponses=new ArrayList<>();
        for (Brand brand:brands)
        {
            GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
            responseItem.setId(brand.getId());
            responseItem.setName(brand.getName());
            brandsResponses.add(responseItem);



        }

        return brandsResponses;
        //modern mapping

    }


    public void add(CreateBrandRequest createBrandRequest) {
    Brand brand = new Brand();
    brand.setName(createBrandRequest.getName());
    this.brandRepository.save(brand);

    }
}
